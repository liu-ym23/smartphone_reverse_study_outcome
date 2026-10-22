package lda;

import com.larus.common.apphost.AppHost;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.s3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, c0> f508847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet<String> f508848b = null;

    static {
        f508847a = new LinkedHashMap();
        f508848b = new LinkedHashSet();
    }

    public static void a(w r110) {
        Intrinsics.checkNotNullParameter(r110, "step");
        int r100 = s3.f387719a;
        s3.b("omni.runtime", "receive step recordId=" + r110.f508837a + ", stepIndex=" + r110.f508840d + ", createdAt=" + r110.f508838b + ", finishAt=" + r110.f508845i + ", last=" + r110.f508843g + ", success=" + r110.f508844h + ", taskTriggerType=" + r110.f508846j.getRaw() + ", query=" + j.c(r110.f508839c) + ", desc=" + j.c(r110.f508841e) + ", reply=" + j.c(r110.f508842f));
        LinkedHashMap<String, c0> r101 = f508847a;
        monitor-enter(r101);
    L49:
        th = move-exception;
        throw th;
    L5:
        if (f508848b.contains(r110.f508837a) == false) goto L9;
        s3.b("omni.runtime", "skip step for user stopped recordId=" + r110.f508837a + ", stepIndex=" + r110.f508840d + ", last=" + r110.f508843g);     // Catch: Throwable -> L49
        monitor-exit(r101);
        return;
    L9:
        String r102 = r110.f508837a;     // Catch: Throwable -> L49
        c0 r103 = r101.get(r102);     // Catch: Throwable -> L49
        if (r103 != null) goto L12;
        s3.b("omni.runtime", "create pending recordId=" + r110.f508837a + ", createdAt=" + r110.f508838b + ", taskTriggerType=" + r110.f508846j.getRaw() + ", query=" + j.c(r110.f508839c));     // Catch: Throwable -> L49
        r103 = new c0(r110.f508838b, r110.f508839c, r110.f508846j);     // Catch: Throwable -> L49
        r101.put(r102, r103);     // Catch: Throwable -> L49
    L12:
        c0 r104 = r103;     // Catch: Throwable -> L49
        r104.a(r110);     // Catch: Throwable -> L49
        monitor-exit(r101);
        if (r110.f508843g == true) goto L18;
        s3.a("omni.runtime", "append step recordId=" + r110.f508837a + ", stepIndex=" + r110.f508840d + ", steps=" + r104.f508805e.size() + ", latestReply=" + j.c(r104.f508804d));
        return;
    L18:
        Intrinsics.checkNotNullParameter(r110, "finalStep");
        List r105 = CollectionsKt.toList(r104.f508805e.values());
        if (r105.isEmpty() == false) goto L30;
        String r106 = r110.f508842f;
        if (StringsKt.isBlank(r106) == false) goto L23;
        r106 = r110.f508841e;
    L23:
        List r107 = CollectionsKt.listOf(new c(v.a(r106)));
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L25:
        if (r109.hasNext() == false) goto L29;
        Object r111 = r109.next();
        if ((!StringsKt.isBlank(((c) r111).f508800a)) == false) goto L25;
        r108.add(r111);
        goto L25
    L29:
        r105 = r108;
    L30:
        List r112 = r105;
        String r113 = v.b(r110.f508837a);
        ModuleKey r114 = e.f508808a.f387358a;
        String r115 = r110.f508837a;
        long r116 = r104.f508801a;
        String r117 = r104.f508802b;
        String r118 = r110.f508842f;
        if (StringsKt.isBlank(r118) == false) goto L34;
        r118 = r104.f508804d;
    L34:
        if (StringsKt.isBlank(r118) == false) goto L36;
        r118 = r110.f508841e;
    L36:
        String r119 = r118;
        if (r110.f508844h == false) goto L39;
        OmniTaskStatus r120 = OmniTaskStatus.SUCCESS;
    L40:
        b0 r121 = new b0(r113, r114, r115, r116, r117, r119, r120, r104.f508803c, r112, j.a(r104.f508801a, r110.f508845i));
        String r122 = CollectionsKt.joinToString$default(r121.f508796i, null, "[", "]", 0, null, new y(), 25, null);
        int r123 = s3.f387719a;
        s3.b("omni.runtime", "transform to usage recordId=" + r121.f508788a + ", taskId=" + r121.f508790c + ", createdAt=" + r121.f508791d + ", status=" + r121.f508794g.getRaw() + ", taskTriggerType=" + r121.f508795h.getRaw() + ", stepCount=" + r121.f508796i.size() + ", time=" + r121.f508797j + ", title=" + j.c(r121.f508792e) + ", answer=" + j.c(r121.f508793f) + ", steps=" + r122);
        new i(AppHost.f326268a.getApplication().getApplicationContext()).a(CollectionsKt.listOf(r121));
        LinkedHashMap<String, c0> r124 = f508847a;
        monitor-enter(r124);
        c0 r125 = r124.remove(r110.f508837a);     // Catch: Throwable -> L46
        monitor-exit(r124);
        s3.b("omni.runtime", "saved runtime recordId=" + r121.f508788a + ", taskId=" + r121.f508790c + ", steps=" + r121.f508796i.size() + ", status=" + r121.f508794g.getRaw() + ", taskTriggerType=" + r121.f508795h.getRaw() + ", time=" + r121.f508797j);
        return;
    L46:
        th = move-exception;
        throw th;
    L39:
        r120 = OmniTaskStatus.FAILED;
        goto L40
    }

    public static void b(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "stop");
        int r100 = s3.f387719a;
        s3.b("omni.runtime", "receive user stop recordId=" + r110.f508781a + ", createdAt=" + r110.f508782b + ", finishAt=" + r110.f508784d + ", reason=" + r110.f508785e + ", taskTriggerType=" + r110.f508786f.getRaw() + ", query=" + j.c(r110.f508783c));
        LinkedHashMap<String, c0> r101 = f508847a;
        monitor-enter(r101);
        f508848b.add(r110.f508781a);     // Catch: Throwable -> L18
    L5:
        LinkedHashSet<String> r102 = f508848b;     // Catch: Throwable -> L18
        if (r102.size() <= 64) goto L11;
        String r103 = (String) CollectionsKt.firstOrNull(r102);     // Catch: Throwable -> L18
        if (r103 == null) goto L11;
        r102.remove(r103);     // Catch: Throwable -> L18
    L11:
        c0 r104 = f508847a.remove(r110.f508781a);     // Catch: Throwable -> L18
        if (r104 != null) goto L14;
        r104 = new c0(r110.f508782b, r110.f508783c, r110.f508786f);     // Catch: Throwable -> L18
    L14:
        b0 r111 = r104.b(r110);     // Catch: Throwable -> L18
        monitor-exit(r101);
        String r105 = CollectionsKt.joinToString$default(r111.f508796i, null, "[", "]", 0, null, new x(), 25, null);
        int r106 = s3.f387719a;
        s3.b("omni.runtime", "transform user stop to usage recordId=" + r111.f508788a + ", taskId=" + r111.f508790c + ", createdAt=" + r111.f508791d + ", status=" + r111.f508794g.getRaw() + ", taskTriggerType=" + r111.f508795h.getRaw() + ", stepCount=" + r111.f508796i.size() + ", time=" + r111.f508797j + ", title=" + j.c(r111.f508792e) + ", answer=" + j.c(r111.f508793f) + ", steps=" + r105);
        new i(AppHost.f326268a.getApplication().getApplicationContext()).a(CollectionsKt.listOf(r111));
        StringBuilder r107 = new StringBuilder("saved user stopped recordId=");
        r107.append(r111.f508788a);
        r107.append(", taskId=");
        r107.append(r111.f508790c);
        r107.append(", steps=");
        r107.append(r111.f508796i.size());
        r107.append(", status=");
        r107.append(r111.f508794g.getRaw());
        r107.append(", taskTriggerType=");
        r107.append(r111.f508795h.getRaw());
        r107.append(", time=");
        r107.append(r111.f508797j);
        s3.b("omni.runtime", r107.toString());
        return;
    L18:
        th = move-exception;
        throw th;
    }
}

package lda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f508824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.assistant.cocreationreview.j f508825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<Function1<u, Unit>> f508826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function0<Unit>> f508827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f508828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g5 f508829f;

    public final synchronized void d() {
        monitor-enter(this);
        Iterator r100 = ((ArrayList) this.f508827d).iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L7;
        ((Function0) r100.next()).invoke();     // Catch: Throwable -> L10
        goto L5
    L7:
        ((ArrayList) this.f508827d).clear();     // Catch: Throwable -> L10
        this.f508828e = false;     // Catch: Throwable -> L10
        s3.b("omni.repository.observe", "stopStoreObservers");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f508828e == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.f508824a == null) goto L12;
        Function1 r100 = new o(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.f508827d).add(i.f508809b.b(r100));     // Catch: Throwable -> L17
    L12:
        if (this.f508825b == null) goto L14;
        Function1 r101 = new p(this);     // Catch: Throwable -> L17
        com.obric.assistant.cocreationreview.g r102 = com.obric.assistant.cocreationreview.j.f387323b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.f508827d).add(com.obric.assistant.cocreationreview.j.f387323b.b(r101));     // Catch: Throwable -> L17
    L14:
        this.f508828e = true;     // Catch: Throwable -> L17
        int r103 = s3.f387719a;     // Catch: Throwable -> L17
        s3.b("omni.repository.observe", "startStoreObservers subscriptions=" + ((ArrayList) this.f508827d).size());     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public q(Context r100) {
        com.obric.assistant.cocreationreview.j r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.getApplicationContext();
        if (r102 == null) goto L7;
        i r103 = new i(r102);
    L8:
        this.f508824a = r103;
        if (r100 == null) goto L13;
        Context r104 = r100.getApplicationContext();
        if (r104 == null) goto L13;
        r101 = new com.obric.assistant.cocreationreview.j(r104);
    L13:
        this.f508825b = r101;
        this.f508826c = new LinkedHashSet();
        this.f508827d = new ArrayList();
        int r105 = g5.f387291c;
        this.f508829f = g5.a.a("repository_init");
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void b(String r100) {
        LinkedHashSet<Function1<u, Unit>> r101 = this.f508826c;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(this.f508826c);     // Catch: Throwable -> L26
        monitor-exit(r101);
        List<b0> r103 = c(this.f508829f);
        u r104 = new u(r100, r103);
        int r105 = s3.f387719a;
        StringBuilder r106 = new StringBuilder("changed reason=");
        r106.append(r100);
        r106.append(", listeners=");
        r106.append(r102.size());
        r106.append(", records=");
        ArrayList r107 = (ArrayList) r103;
        r106.append(r107.size());
        r106.append(", feedback=");
        int r108 = 0;
        if (r107.isEmpty() == true) goto L21;
        Iterator r109 = r107.iterator();
        int r110 = 0;
    L11:
        if (r109.hasNext() == false) goto L20;
        if (((b0) r109.next()).f508799l == null) goto L15;
        boolean r111 = true;
    L16:
        if (r111 == false) goto L11;
        r110 = r110 + 1;
        if (r110 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L15:
        r111 = false;
        goto L16
    L20:
        r108 = r110;
    L21:
        r106.append(r108);
        s3.b("omni.repository.observe", r106.toString());
        Iterator r112 = r102.iterator();
    L23:
        if (r112.hasNext() == false) goto L25;
        ((Function1) r112.next()).invoke(r104);
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final List<b0> c(g5 r310) {
        Intrinsics.checkNotNullParameter(r310, "request");
        i r100 = this.f508824a;
        Map<String, a5> r101 = null;
        String r102 = ", reason=";
        String r103 = ", latest=";
        String r104 = ", earliest=";
        if (r100 == null) goto L24;
        Intrinsics.checkNotNullParameter(r310, "request");
        SQLiteDatabase r110 = r100.f508810a.getWritableDatabase();
        Intrinsics.checkNotNull(r110);
        ArrayList r105 = new ArrayList();
        h5 r111 = g5.a(r310);
        Cursor r112 = r110.query("omni_data", null, "created_at >= ? AND created_at <= ?", new String[]{String.valueOf(r111.f387303a), String.valueOf(r111.f387304b)}, null, null, "created_at DESC, record_id ASC");
        Cursor r113 = r112;     // Catch: Throwable -> L18
    L8:
        if (r113.moveToNext() == false) goto L16;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L11
        r105.add(com.obric.assistant.cocreationreview.modules.omni.a.b(r113));     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L18
        if (r108 == null) goto L8;
        int r114 = s3.f387719a;     // Catch: Throwable -> L18
        s3.c("omni.database", "skip invalid row error=" + r108.getMessage());     // Catch: Throwable -> L18
        goto L8
    L11:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L18
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L13
    L16:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r112, null);
        String r116 = CollectionsKt.joinToString$default(r105, null, "[", "]", 0, null, new h(), 25, null);
        int r117 = s3.f387719a;
        s3.b("omni.database", "query count=" + r105.size() + ", earliest=" + r111.f387303a + ", latest=" + r111.f387304b + ", reason=" + r310.f387293b + ", records=" + r116);
        ?? r118 = r105;
    L25:
        if (r118 != 0) goto L27;
        r118 = CollectionsKt.emptyList();
    L27:
        String r119 = "omni.repository";
        if (r118.isEmpty() == false) goto L30;
    L29:
        String r120 = r119;
        String r311 = r102;
        String r312 = r103;
        String r313 = r104;
        ArrayList r121 = new ArrayList();
        Iterator r122 = ((Iterable) r118).iterator();
    L46:
        if (r122.hasNext() == false) goto L55;
        Object r123 = r122.next();
        long r124 = ((b0) r123).f508791d;
        int r125 = g5.f387291c;
        long r126 = System.currentTimeMillis();
        r310.getClass();
        long r127 = r310.f387292a;
        if (r124 <= RangesKt.coerceAtLeast(r126, r127)) goto L50;
    L52:
        boolean r128 = false;
    L53:
        if (r128 == false) goto L46;
        r121.add(r123);
        goto L46
    L50:
        if (r127 > r124) goto L52;
        r128 = true;
        goto L53
    L55:
        String r129 = CollectionsKt.joinToString$default(r121, null, "[", "]", 0, null, new m(), 25, null);
        if (this.f508824a == null) goto L74;
        h5 r130 = g5.a(r310);
        int r131 = s3.f387719a;
        StringBuilder r132 = new StringBuilder("loadRecords source=runtime_database, count=");
        r132.append(r121.size());
        r132.append(", feedback=");
        if (r121.isEmpty() == false) goto L60;
        int r133 = 0;
    L72:
        r132.append(r133);
        r132.append(r313);
        r132.append(r130.f387303a);
        r132.append(r312);
        r132.append(r130.f387304b);
        r132.append(r311);
        r132.append(r310.f387293b);
        r132.append(", items=");
        r132.append(r129);
        s3.b(r120, r132.toString());
        return r121;
    L60:
        Iterator r134 = r121.iterator();
        int r135 = 0;
    L62:
        if (r134.hasNext() == false) goto L71;
        if (((b0) r134.next()).f508799l == null) goto L66;
        boolean r136 = true;
    L67:
        if (r136 == false) goto L62;
        r135 = r135 + 1;
        if (r135 >= 0) goto L62;
        CollectionsKt.throwCountOverflow();
        goto L62
    L66:
        r136 = false;
        goto L67
    L71:
        r133 = r135;
        goto L72
    L74:
        int r137 = s3.f387719a;
        StringBuilder r138 = new StringBuilder("loadRecords source=empty, reason=context_unavailable, count=");
        r138.append(r121.size());
        r138.append(", feedback=");
        if (r121.isEmpty() == false) goto L77;
        int r139 = 0;
    L89:
        r138.append(r139);
        r138.append(", observeReason=");
        r138.append(r310.f387293b);
        r138.append(", items=");
        r138.append(r129);
        s3.c(r120, r138.toString());
        return r121;
    L77:
        Iterator r140 = r121.iterator();
        int r141 = 0;
    L79:
        if (r140.hasNext() == false) goto L88;
        if (((b0) r140.next()).f508799l == null) goto L83;
        boolean r142 = true;
    L84:
        if (r142 == false) goto L79;
        r141 = r141 + 1;
        if (r141 >= 0) goto L79;
        CollectionsKt.throwCountOverflow();
        goto L79
    L83:
        r142 = false;
        goto L84
    L88:
        r139 = r141;
        goto L89
    L30:
        Iterable r143 = (Iterable) r118;
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator r145 = r143.iterator();
    L32:
        if (r145.hasNext() == false) goto L34;
        r144.add(((b0) r145.next()).f508788a);
        goto L32
    L34:
        Set<String> r146 = CollectionsKt.toSet(r144);
        com.obric.assistant.cocreationreview.j r147 = this.f508825b;
        if (r147 == null) goto L37;
        r101 = r147.a(r146, CollectionsKt.emptyList());
    L37:
        if (r101 == null) goto L39;
        int r148 = s3.f387719a;
        s3.b("omni.repository", "loadFeedback source=database, requested=" + r146.size() + ", count=" + r101.size());
    L40:
        s3.b("omni.repository", "attachFeedback records=" + r118.size() + ", feedbackIds=" + CollectionsKt.joinToString$default(r101.keySet(), null, "[", "]", 0, null, null, 57, null));
        r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator r149 = r143.iterator();
    L42:
        if (r149.hasNext() == false) goto L29;
        b0 r150 = (b0) r149.next();
        a5 r314 = r101.get(r150.f508788a);
        String r151 = r150.f508788a;
        ModuleKey r152 = r150.f508789b;
        String r153 = r150.f508790c;
        long r154 = r150.f508791d;
        String r155 = r150.f508792e;
        Iterator r156 = r149;
        String r157 = r150.f508793f;
        Map<String, a5> r158 = r101;
        OmniTaskStatus r159 = r150.f508794g;
        String r160 = r119;
        OmniTaskTriggerType r161 = r150.f508795h;
        String r315 = r102;
        List<c> r162 = r150.f508796i;
        String r316 = r103;
        String r163 = r150.f508797j;
        String r164 = r150.f508798k;
        Intrinsics.checkNotNullParameter(r151, "id");
        Intrinsics.checkNotNullParameter(r152, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r153, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r155, "userQuery");
        Intrinsics.checkNotNullParameter(r157, "doubaoAnswer");
        Intrinsics.checkNotNullParameter(r159, "status");
        Intrinsics.checkNotNullParameter(r161, "taskTriggerType");
        Intrinsics.checkNotNullParameter(r162, "steps");
        Intrinsics.checkNotNullParameter(r163, "timeCost");
        Intrinsics.checkNotNullParameter(r164, WsConstants.KEY_PAYLOAD);
        r118.add(new b0(r151, r152, r153, r154, r155, r157, r159, r161, r162, r163, r164, r314));
        r149 = r156;
        r101 = r158;
        r119 = r160;
        r102 = r315;
        r103 = r316;
        r104 = r104;
        goto L42
    L39:
        int r165 = s3.f387719a;
        s3.c("omni.repository", "loadFeedback source=empty, reason=context_unavailable, requested=" + r146.size() + ", count=0");
        r101 = MapsKt.emptyMap();
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r112, th);
        throw th;
    L24:
        r118 = 0;
        goto L25
    }
}

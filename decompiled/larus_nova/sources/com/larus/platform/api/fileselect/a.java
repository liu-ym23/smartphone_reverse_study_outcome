package com.larus.platform.api.fileselect;

import aq9.e;
import aq9.f;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.u;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.chat.r0;
import com.larus.platform.service.z2;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import yc9.l1;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements IChatFileSelectionStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f365122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f365123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, u> f365124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, IChatFileSelectionStore.Source> f365125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f365126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlowImpl f365127f;

    /* JADX INFO: renamed from: com.larus.platform.api.fileselect.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4469a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f365128a = null;

        static {
            int[] r100 = new int[FlowDriveFileType.values().length];
            r100[FlowDriveFileType.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FlowDriveFileType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f365128a = r100;
        }
    }

    public a() {
        f r100 = new f(0);
        Intrinsics.checkNotNullParameter(r100, "initialPolicy");
        this.f365122a = new Object();
        this.f365123b = r100;
        this.f365124c = new LinkedHashMap();
        this.f365125d = new LinkedHashMap();
        this.f365126e = j1.a(new LinkedHashMap());
        this.f365127f = j1.a(new e(0));
    }

    public final void f() {
        StateFlowImpl r100 = this.f365126e;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.f365124c);
        r100.setValue(r101);
        FlowDriveFileType r102 = (FlowDriveFileType) CollectionsKt.singleOrNull(SequencesKt.toList(SequencesKt.distinct(SequencesKt.map(CollectionsKt.asSequence(this.f365124c.values()), new aq9.a()))));
        Set<Map.Entry<String, u>> r103 = this.f365124c.entrySet();
        boolean r104 = false;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L18;
        Map.Entry r106 = (Map.Entry) r105.next();
        Intrinsics.checkNotNull(r106);
        String r107 = (String) r106.getKey();
        if (((u) r106.getValue()).f365285f.isMediaType() == true) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == false) goto L9;
        r104 = true;
        goto L18
    L13:
        if (this.f365125d.get(r107) != IChatFileSelectionStore.Source.DRIVE) goto L15;
        r108 = true;
    L18:
        this.f365127f.setValue(new e(r102, r104));
        return;
    L5:
        if (r103.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final List<u> snapshot() {
        Object r100 = this.f365122a;
        monitor-enter(r100);
        List<u> r101 = CollectionsKt.toList(this.f365124c.values());     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final StateFlowImpl getState() {
        return this.f365126e;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final void d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        Object r101 = this.f365122a;
        monitor-enter(r101);
        this.f365123b = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.Source e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileUri");
        Object r101 = this.f365122a;
        monitor-enter(r101);
        IChatFileSelectionStore.Source r102 = this.f365125d.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = IChatFileSelectionStore.Source.UNKNOWN;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b.a a(String r100, IChatFileSelectionStore.Source r101) {
        Intrinsics.checkNotNullParameter(r100, "fileUri");
        Intrinsics.checkNotNullParameter(r101, "source");
        Object r102 = this.f365122a;
        monitor-enter(r102);
        this.f365124c.remove(r100);     // Catch: Throwable -> L7
        this.f365125d.remove(r100);     // Catch: Throwable -> L7
        f();     // Catch: Throwable -> L7
        IChatFileSelectionStore.b.a r103 = IChatFileSelectionStore.b.a.f365120a;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b b(u r100, IChatFileSelectionStore.Source r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "source");
        Object r102 = this.f365122a;
        monitor-enter(r102);
        IChatFileSelectionStore.b r103 = g(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b c(u r100, IChatFileSelectionStore.Source r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "source");
        Object r102 = this.f365122a;
        monitor-enter(r102);
        IChatFileSelectionStore.b r103 = g(r100, r101);     // Catch: Throwable -> L23
        if ((r103 instanceof IChatFileSelectionStore.b.C4468b) == false) goto L8;
        monitor-exit(r102);
        return r103;
    L8:
        LinkedHashMap<String, u> r104 = this.f365124c;     // Catch: Throwable -> L23
        String r105 = r100.f365280a;     // Catch: Throwable -> L23
        u r106 = r104.get(r105);     // Catch: Throwable -> L23
        if (r106 == null) goto L19;
        Map<String, String> r107 = r106.f365292m;     // Catch: Throwable -> L23
        if (r107 == null) goto L19;
        String r108 = r107.get("upload_way");     // Catch: Throwable -> L23
        if (r108 == null) goto L19;
        Map<String, String> r109 = r100.f365292m;     // Catch: Throwable -> L23
        if (r109 != null) goto L18;
        r109 = MapsKt.emptyMap();     // Catch: Throwable -> L23
    L18:
        u r110 = u.a(r100, 0, MapsKt.plus(r109, MapsKt.mapOf(TuplesKt.to("upload_way", r108))), UnixStat.PERM_MASK);     // Catch: Throwable -> L23
    L20:
        r104.put(r105, r110);     // Catch: Throwable -> L23
        this.f365125d.put(r100.f365280a, r101);     // Catch: Throwable -> L23
        f();     // Catch: Throwable -> L23
        IChatFileSelectionStore.b.a r111 = IChatFileSelectionStore.b.a.f365120a;     // Catch: Throwable -> L23
        monitor-exit(r102);
        return r111;
    L19:
        r110 = r100;
    L23:
        th = move-exception;
        throw th;
    }

    public final IChatFileSelectionStore.b g(u r110, IChatFileSelectionStore.Source r111) {
        if (this.f365124c.containsKey(r110.f365280a) == true) goto L5;
        LinkedHashMap<String, u> r100 = this.f365124c;
        f r101 = this.f365123b;
        boolean r102 = UploadFilePolicy.f365565a;
        boolean r103 = false;
        if (UploadFilePolicy.f365566b == true) goto L37;
        Collection<u> r104 = r100.values();
        if (r104.isEmpty() == true) goto L17;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        if (((u) r105.next()).f365285f.isMediaType() == false) goto L13;
        boolean r106 = true;
    L18:
        Collection<u> r107 = r100.values();
        if (r107.isEmpty() == true) goto L27;
        Iterator<T> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L27;
        if ((!((u) r108.next()).f365285f.isMediaType()) == false) goto L23;
        boolean r109 = true;
    L28:
        boolean r112 = r110.f365285f.isMediaType();
        if (r112 == false) goto L31;
        if (r109 == false) goto L31;
    L33:
        if (r106 == false) goto L35;
        FlowDriveFileType r113 = FlowDriveFileType.IMAGE;
    L104:
        return new IChatFileSelectionStore.b.C4468b(new IChatFileSelectionStore.a.d(r113, r110.f365285f.toMixCategory()));
    L35:
        r113 = FlowDriveFileType.FILE;
    L31:
        if (r112 == true) goto L37;
        if (r106 == false) goto L37;
    L27:
        r109 = false;
    L17:
        r106 = false;
    L37:
        Set<FlowDriveFileType> r114 = r101.f15974a;
        if (r114 != null) goto L40;
    L42:
        int r115 = bq9.a.f20090a;
        Map<String, String> r116 = r110.f365292m;
        Long r117 = null;
        if (r116 == null) goto L45;
        String r118 = r116.get("originFileTypeString");
    L47:
        if (l1.k(r118) == true) goto L86;
        String r119 = StringsKt.substringAfterLast(r110.f365281b, '.', "").toLowerCase(Locale.ROOT);
        IChatFileSelectionStore.Source r120 = IChatFileSelectionStore.Source.DRIVE;
        if (r111 != r120) goto L51;
    L54:
        boolean r121 = UploadFilePolicy.e(r119);
    L55:
        if (r121 == true) goto L58;
        return new IChatFileSelectionStore.b.C4468b(new IChatFileSelectionStore.a.e(r110.f365285f));
    L58:
        if (r111 == r120) goto L60;
    L62:
        boolean r122 = false;
    L64:
        if (r111 == IChatFileSelectionStore.Source.LOCAL) goto L66;
    L79:
        long r123 = UploadFilePolicy.d();
    L80:
        if (r122 == true) goto L86;
        long r124 = r110.f365282c;
        if (r124 <= 0) goto L107;
        if (r124 <= r123) goto L86;
    L107:
        return new IChatFileSelectionStore.b.C4468b(new IChatFileSelectionStore.a.C4467a(r123));
    L66:
        if (r110.f365285f != FlowDriveFileType.AUDIO) goto L79;
        r0 r125 = z2.f365865a.getFlowMultiUploadConfig().j();
        if (r125 == null) goto L78;
        Long r126 = r125.e();
        if (r126 == null) goto L78;
        if (r126.longValue() <= 0) goto L74;
        r103 = true;
    L74:
        if (r103 == false) goto L76;
        r117 = r126;
    L76:
        if (r117 == null) goto L78;
        r123 = r117.longValue();
    L78:
        r123 = 314572800;
        goto L80
    L60:
        if (r110.f365282c > 0) goto L62;
        r122 = true;
        goto L64
    L51:
        if (r111 == IChatFileSelectionStore.Source.RECENT) goto L54;
        r121 = UploadFilePolicy.g(r119);
    L86:
        int r127 = C4469a.f365128a[r110.f365285f.ordinal()];
        if (r127 != 1) goto L89;
        int r128 = r101.f15976c;
    L94:
        if (((r100.size() + r101.f15975b) + 1) <= r128) goto L97;
        return new IChatFileSelectionStore.b.C4468b(new IChatFileSelectionStore.a.c(r128));
    L97:
        return IChatFileSelectionStore.b.a.f365120a;
    L89:
        if (r127 == 2) goto L91;
        r128 = r101.f15978e;
        goto L94
    L91:
        r128 = r101.f15977d;
        goto L94
    L45:
        r118 = null;
        goto L47
    L40:
        if (r114.contains(r110.f365285f) == true) goto L42;
        return new IChatFileSelectionStore.b.C4468b(new IChatFileSelectionStore.a.e(r110.f365285f));
    L5:
        return IChatFileSelectionStore.b.a.f365120a;
    }
}

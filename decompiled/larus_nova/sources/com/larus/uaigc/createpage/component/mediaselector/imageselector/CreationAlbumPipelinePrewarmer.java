package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationAlbumPipelinePrewarmer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f371902g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<kq9.d, String, Continuation<? super com.larus.bmhome.resource.access.b0>, Object> f371903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f371904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f371905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f371906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, b> f371907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, b> f371908f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer$TaskOwner;", "", "<init>", "(Ljava/lang/String;I)V", "ALBUM_SELECTION", "ATTACHMENT", "SEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TaskOwner extends Enum<TaskOwner> {
        public static final TaskOwner ALBUM_SELECTION = null;
        public static final TaskOwner ATTACHMENT = null;
        public static final TaskOwner SEND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TaskOwner[] f371909a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f371910b = null;

        public static EnumEntries<TaskOwner> getEntries() {
            return f371910b;
        }

        static {
            TaskOwner r100 = new TaskOwner("ALBUM_SELECTION", 0);
            ALBUM_SELECTION = r100;
            TaskOwner r101 = new TaskOwner("ATTACHMENT", 1);
            ATTACHMENT = r101;
            TaskOwner r102 = new TaskOwner("SEND", 2);
            SEND = r102;
            TaskOwner[] r103 = {r100, r101, r102};
            f371909a = r103;
            f371910b = EnumEntriesKt.enumEntries(r103);
        }

        public static TaskOwner[] values() {
            return (TaskOwner[]) f371909a.clone();
        }

        public static TaskOwner valueOf(String r100) {
            return (TaskOwner) r27.a.a(TaskOwner.class, r100);
        }

        public TaskOwner(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f371911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AlbumSelectionMediaType f371912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Deferred<com.larus.bmhome.resource.access.b0> f371913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f371914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TaskOwner f371915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Job f371916f;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f371911a, r101.f371911a) == true) goto L12;
            return false;
        L12:
            if (this.f371912b == r101.f371912b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f371913c, r101.f371913c) == true) goto L18;
            return false;
        L18:
            if (this.f371914d == r101.f371914d) goto L21;
            return false;
        L21:
            if (this.f371915e == r101.f371915e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f371916f, r101.f371916f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f371911a.hashCode() * 31) + this.f371912b.hashCode()) * 31) + this.f371913c.hashCode()) * 31;
            if (this.f371914d == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f371915e.hashCode()) * 31;
            Job r103 = this.f371916f;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Entry(identifier=" + this.f371911a + ", mediaType=" + this.f371912b + ", task=" + this.f371913c + ", selected=" + this.f371914d + ", owner=" + this.f371915e + ", cancelJob=" + this.f371916f + ')';
        }

        public final String getIdentifier() {
            return this.f371911a;
        }

        public b(String r100, AlbumSelectionMediaType r101, Deferred r102) {
            TaskOwner r103 = TaskOwner.ALBUM_SELECTION;
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            Intrinsics.checkNotNullParameter(r101, "mediaType");
            Intrinsics.checkNotNullParameter(r102, "task");
            Intrinsics.checkNotNullParameter(r103, "owner");
            this.f371911a = r100;
            this.f371912b = r101;
            this.f371913c = r102;
            this.f371914d = true;
            this.f371915e = r103;
            this.f371916f = null;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371917a = null;

        static {
            int[] r100 = new int[AlbumSelectionMediaType.values().length];
            r100[AlbumSelectionMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AlbumSelectionMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f371917a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationAlbumPipelinePrewarmer(Function3<? super kq9.d, ? super String, ? super Continuation<? super com.larus.bmhome.resource.access.b0>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "submitTask");
        this.f371903a = r100;
        this.f371904b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f371905c = new Object();
        this.f371907e = new LinkedHashMap();
        this.f371908f = new LinkedHashMap();
    }

    public final void a(ResourceCancelReason r100) {
        Object r101 = this.f371905c;
        monitor-enter(r101);
        String r102 = this.f371906d;     // Catch: Throwable -> L12
        this.f371906d = null;     // Catch: Throwable -> L12
        List<b> r103 = CollectionsKt.toList(((LinkedHashMap) this.f371907e).values());     // Catch: Throwable -> L12
        ((LinkedHashMap) this.f371907e).clear();     // Catch: Throwable -> L12
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        if (r102 == null) goto L10;
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r105 = kq9.c.f505615a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        if ((!StringsKt.isBlank(r102)) == false) goto L10;
        kq9.c.f505615a.remove(r102);
    L10:
        b(r103, r100);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void b(List<b> r110, ResourceCancelReason r111) {
        Iterator<T> r100 = r110.iterator();
    L4:
        if (r100.hasNext() == false) goto L39;
        b r101 = (b) r100.next();
        Job r102 = r101.f371916f;
        boolean r103 = true;
        if (r102 == null) goto L8;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L8:
        Job.DefaultImpls.cancel$default(r101.f371913c, null, 1, null);
        ICreationResourceAccessService.Companion r104 = ICreationResourceAccessService.f373925a;
        com.larus.bmhome.resource.access.z r105 = ICreationResourceAccessService.a.c(r104, r101.getIdentifier(), null, null, 14);
        if (r105 == null) goto L15;
        com.larus.bmhome.resource.access.a0 r106 = r105.f313784c;
        if (r106 == null) goto L15;
        if (com.larus.bmhome.resource.access.s.b(r106) == true) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        boolean r108 = r104.a(r101.getIdentifier(), r111);
    L19:
        com.larus.bmhome.resource.access.z r109 = ICreationResourceAccessService.a.c(r104, r101.getIdentifier(), null, null, 14);
        if (r109 != null) goto L22;
        com.larus.bmhome.resource.access.z r112 = r105;
    L23:
        if (r108 == false) goto L26;
        String r113 = "cancelled";
    L25:
        String r114 = r113;
        d(r101.getIdentifier(), r101.f371912b, r112, "cancel", r114, null);
        ResourceCenter r115 = ResourceCenter.f313541a;
        String r116 = r101.getIdentifier();
        r115.getClass();
        ResourceCenter.a(r116);
        goto L4
    L26:
        if (r112 == null) goto L32;
        com.larus.bmhome.resource.access.a0 r117 = r112.f313784c;
        if (r117 == null) goto L32;
        if (com.larus.bmhome.resource.access.s.b(r117) != true) goto L32;
    L33:
        if (r103 == false) goto L35;
        r113 = "terminal_kept";
        goto L25
    L35:
        if (r112 != null) goto L37;
        r113 = "no_task";
        goto L25
    L37:
        r113 = "cancel_skipped";
    L32:
        r103 = false;
        goto L33
    L22:
        r112 = r109;
        goto L23
    L18:
        r108 = false;
    L15:
        r107 = false;
        goto L16
    }

    public final String c(Uri r100, AlbumSelectionMediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "fallbackMediaType");
        String r102 = r100.toString();
        Object r103 = this.f371905c;
        monitor-enter(r103);
        String r104 = null;
        if (this.f371906d == null) goto L17;
        b r105 = this.f371907e.remove(r102);     // Catch: Throwable -> L19
        if (r105 != null) goto L11;
        r105 = new b(UUID.randomUUID().toString(), r101, CompletableDeferredKt.CompletableDeferred(null));     // Catch: Throwable -> L19
    L11:
        if (r105.f371914d == true) goto L13;
        this.f371907e.put(r102, r105);     // Catch: Throwable -> L19
        goto L17
    L13:
        TaskOwner r106 = TaskOwner.ATTACHMENT;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r106, "<set-?>");     // Catch: Throwable -> L19
        r105.f371915e = r106;     // Catch: Throwable -> L19
        Job r107 = r105.f371916f;     // Catch: Throwable -> L19
        if (r107 == null) goto L16;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);     // Catch: Throwable -> L19
    L16:
        r105.f371916f = null;     // Catch: Throwable -> L19
        this.f371908f.put(r105.getIdentifier(), r105);     // Catch: Throwable -> L19
        r104 = r105.getIdentifier();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r103);
        return r104;
    L19:
        th = move-exception;
        throw th;
    }

    public final Object e(String r110, Continuation<? super com.larus.bmhome.resource.access.b0> r111) {
        if ((r111 instanceof CreationAlbumPipelinePrewarmer$takeClaimedTask$1) == false) goto L7;
        CreationAlbumPipelinePrewarmer$takeClaimedTask$1 r100 = (CreationAlbumPipelinePrewarmer$takeClaimedTask$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        b r113 = (b) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: CancellationException -> L14 Throwable -> L119
    L28:
        com.larus.bmhome.resource.access.b0 r114 = (com.larus.bmhome.resource.access.b0) r112;     // Catch: CancellationException -> L14 Throwable -> L119
    L32:
        Object r106 = this.f371905c;
        monitor-enter(r106);
    L112:
        th = move-exception;
        throw th;
    L35:
        if (((LinkedHashMap) this.f371908f).get(r105) != r113) goto L37;
        this.f371908f.remove(r105);     // Catch: Throwable -> L112
    L37:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L112
        monitor-exit(r106);
        if (r114 != null) goto L42;
        r114 = ICreationResourceAccessService.a.b(ICreationResourceAccessService.f373925a, r105, null, null, 14);
    L42:
        if (r114 == null) goto L47;
        com.larus.bmhome.resource.access.z r108 = r114.snapshot();
        if (r108 == null) goto L47;
        com.larus.bmhome.resource.access.z r109 = r108;
    L48:
        if (r109 == null) goto L50;
        com.larus.bmhome.resource.access.a0 r115 = r109.f313784c;
    L52:
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.d) == true) goto L54;
    L58:
        r104 = false;
    L59:
        if (r104 == false) goto L61;
        d(r105, r113.f371912b, r109, "expire", AiBotPollingAuthResult.STATUS_EXPIRED, null);
    L61:
        if (r104 == false) goto L63;
        String r116 = "miss";
    L99:
        AlbumSelectionMediaType r117 = r113.f371912b;
        if (Intrinsics.areEqual(r116, "ready") == false) goto L102;
    L105:
        String r118 = "reuse";
    L106:
        d(r105, r117, r109, "claim", r118, r116);
        if (Intrinsics.areEqual(r116, "ready") == true) goto L111;
        if (Intrinsics.areEqual(r116, "running") == true) goto L111;
        return null;
    L111:
        return r114;
    L102:
        if (Intrinsics.areEqual(r116, "running") == true) goto L105;
        r118 = "fallback";
        goto L106
    L63:
        if (r109 == null) goto L65;
        com.larus.bmhome.resource.access.a0 r119 = r109.f313784c;
    L67:
        if ((r119 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L69;
        r116 = "ready";
        goto L99
    L69:
        if (r109 == null) goto L71;
        com.larus.bmhome.resource.access.a0 r120 = r109.f313784c;
    L73:
        if ((r120 instanceof com.larus.bmhome.resource.access.a0.b) == true) goto L98;
        if (r109 == null) goto L76;
        com.larus.bmhome.resource.access.a0 r121 = r109.f313784c;
    L78:
        if ((r121 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L98;
        if (r109 == null) goto L81;
        com.larus.bmhome.resource.access.a0 r122 = r109.f313784c;
    L83:
        if ((r122 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L98;
        if (r109 == null) goto L87;
        com.larus.bmhome.resource.access.a0 r123 = r109.f313784c;
    L89:
        if ((r123 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L97;
        if (r109 == null) goto L92;
        com.larus.bmhome.resource.access.a0 r124 = r109.f313784c;
    L94:
        if ((r124 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L97;
        r116 = "miss";
        goto L99
    L92:
        r124 = null;
    L97:
        r116 = "failed";
        goto L99
    L87:
        r123 = null;
        goto L89
    L81:
        r122 = null;
        goto L83
    L76:
        r121 = null;
    L98:
        r116 = "running";
        goto L99
    L71:
        r120 = null;
        goto L73
    L65:
        r119 = null;
        goto L67
    L54:
        if (r109.f313787f <= 0) goto L58;
        if ((System.currentTimeMillis() - r109.f313787f) <= 600000) goto L58;
    L50:
        r115 = null;
    L47:
        r109 = ICreationResourceAccessService.a.c(ICreationResourceAccessService.f373925a, r105, null, null, 14);
        goto L48
    L31:
        r114 = null;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        Object r125 = this.f371905c;
        monitor-enter(r125);
        b r126 = (b) ((LinkedHashMap) this.f371908f).get(r110);     // Catch: Throwable -> L116
        monitor-exit(r125);
        if (r126 != null) goto L122;
        return null;
    L122:
        Deferred<com.larus.bmhome.resource.access.b0> r127 = r126.f371913c;     // Catch: CancellationException -> L14 Throwable -> L30
        r100.L$0 = r110;     // Catch: CancellationException -> L14 Throwable -> L30
        r100.L$1 = r126;     // Catch: CancellationException -> L14 Throwable -> L30
        r100.label = 1;     // Catch: CancellationException -> L14 Throwable -> L30
        r112 = r127.await(r100);     // Catch: CancellationException -> L14 Throwable -> L30
        if (r112 != r102) goto L27;
        return r102;
    L27:
        r105 = r110;
        r113 = r126;
    L30:
        r105 = r110;
        r113 = r126;
    L116:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        throw e;
    L7:
        r100 = new CreationAlbumPipelinePrewarmer$takeClaimedTask$1(this, r111);
        goto L8
    }

    public static void d(String r310, AlbumSelectionMediaType r311, com.larus.bmhome.resource.access.z r312, String r313, String r314, String r315) {
        CreationResourceAccessUploader r100 = CreationResourceAccessUploader.f372969a;
        int r101 = c.f371917a[r311.ordinal()];
        boolean r102 = true;
        if (r101 == 1) goto L8;
        if (r101 != 2) goto L7;
        ResourceMediaType r103 = ResourceMediaType.VIDEO;
    L9:
        Intrinsics.checkNotNullParameter(r310, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r103, "mediaType");
        Intrinsics.checkNotNullParameter(r313, "action");
        Intrinsics.checkNotNullParameter(r314, "result");
        if (r312 == null) goto L12;
        com.larus.bmhome.resource.access.w r104 = r312.f313785d;
    L13:
        Map r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trigger", "album_select_prewarm"), TuplesKt.to("prewarm_action", r313)});
        if (r315 == null) goto L16;
        r105.put("state_at_confirm", r315);
    L16:
        int[] r106 = CreationResourceAccessUploader.b.f372985a;
        int r107 = r106[r103.ordinal()];
        if (r107 == 1) goto L24;
        if (r107 == 2) goto L23;
        if (r107 != 3) goto L22;
        com.larus.bmhome.resource.access.x r108 = com.larus.bmhome.resource.access.x.f313766b;
    L25:
        int r109 = r106[r103.ordinal()];
        if (r109 == 1) goto L33;
        if (r109 == 2) goto L32;
        if (r109 == 3) goto L32;
        throw new NoWhenBranchMatchedException();
    L32:
        ResourceInputType r110 = ResourceInputType.LOCAL_PATH;
    L34:
        com.larus.bmhome.resource.access.y r111 = com.larus.bmhome.resource.access.y.f313777a;
        if (r312 == null) goto L37;
        String r112 = r312.f313782a;
    L38:
        if (r112 != null) goto L40;
        r112 = "";
    L40:
        String r113 = r112;
        if (r104 == null) goto L46;
        com.larus.bmhome.resource.access.x r114 = r104.f313762a;
        if (r114 == null) goto L46;
        r108 = r114;
    L46:
        if (r104 == null) goto L51;
        com.larus.bmhome.resource.access.j0 r115 = r104.f313763b;
        if (r115 == null) goto L51;
        ResourceInputType r116 = r115.getType();
        if (r116 == null) goto L51;
    L52:
        if (r104 == null) goto L57;
        ResourceMediaType r117 = r104.f313764c;
        if (r117 == null) goto L57;
        ResourceMediaType r118 = r117;
    L59:
        if (r315 != null) goto L61;
        Boolean r210 = null;
    L68:
        com.larus.bmhome.resource.access.t r119 = new com.larus.bmhome.resource.access.t(r113, r108, r116, r118, r310, "album_prewarm", "selection_lifecycle", 0, r314, null, null, null, null, null, null, null, r210, null, null, r105, 458240);
        Intrinsics.checkNotNullParameter(r119, "event");
        com.larus.bmhome.resource.access.u.f313753a.getClass();
        com.larus.bmhome.resource.access.u.b(r119);
        return;
    L61:
        if (Intrinsics.areEqual(r315, "ready") == false) goto L63;
    L66:
        r210 = Boolean.valueOf(r102);
        goto L68
    L63:
        if (Intrinsics.areEqual(r315, "running") == true) goto L66;
        r102 = false;
    L57:
        r118 = r103;
    L51:
        r116 = r110;
        goto L52
    L37:
        r112 = null;
        goto L38
    L33:
        r110 = ResourceInputType.CONTENT_URI;
        goto L34
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        r108 = com.larus.uaigc.service.f.f373957a;
        goto L25
    L24:
        r108 = com.larus.uaigc.service.f.f373959c;
        goto L25
    L12:
        r104 = null;
        goto L13
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r103 = ResourceMediaType.IMAGE;
        goto L9
    }
}

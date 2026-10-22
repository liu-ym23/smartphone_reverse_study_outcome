package com.larus.bmhome.resource.access;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class SdkUploadNode implements l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f313599d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourcePhase f313600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f313601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f313602c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/resource/access/SdkUploadNode$ResourceAccessErrorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/larus/bmhome/resource/access/ResourceAccessError;", "<init>", "(Lcom/larus/bmhome/resource/access/ResourceAccessError;)V", "getError", "()Lcom/larus/bmhome/resource/access/ResourceAccessError;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceAccessErrorException extends RuntimeException {
        private final r error;

        public final r getError() {
            return this.error;
        }

        public ResourceAccessErrorException(r r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            super(r100.f313724c);
            this.error = r100;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f313603a = null;

        static {
            int[] r100 = new int[ResourceMediaType.values().length];
            r100[ResourceMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceMediaType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f313603a = r100;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f313604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f313605b;

        public c(AtomicBoolean r100, String r101) {
            this.f313604a = r100;
            this.f313605b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f313604a.compareAndSet(false, true);
            FLogger.f375446a.i("SdkUploadNode", "[awaitUpload] cancelled, fileIdentifier=" + this.f313605b);
            ResourceUploader r101 = ResourceUploader.f314736a;
            ResourceUploader.c(this.f313605b);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<mr9.l, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<f0> f313606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f313607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w f313608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j0 f313609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SdkUploadNode f313610e;

        public d(kotlinx.coroutines.j r100, AtomicBoolean r101, w r102, j0 r103, SdkUploadNode r104) {
            this.f313606a = r100;
            this.f313607b = r101;
            this.f313608c = r102;
            this.f313609d = r103;
            this.f313610e = r104;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(mr9.l r110) {
            mr9.l r100 = r110;
            Intrinsics.checkNotNullParameter(r100, "result");
            kotlinx.coroutines.i<f0> r111 = this.f313606a;
            AtomicBoolean r101 = this.f313607b;
            w r102 = this.f313608c;
            j0 r103 = this.f313609d;
            SdkUploadNode r104 = this.f313610e;
            if (r111.isActive() == false) goto L18;
            boolean r105 = false;
            if (r101.compareAndSet(false, true) == false) goto L18;
            Result.Companion r106 = Result.Companion;
            ResourceMediaType r107 = r102.f313764c;
            String r108 = r100.f515022a;
            String r109 = r100.f515024c;
            r104.getClass();
            if (r100.f515027f == true) goto L15;
            ResourceUploadInstantInfo r112 = r100.f515028g;
            if (r112 == null) goto L12;
            r105 = Intrinsics.areEqual(r112.getPreQueryHit(), Boolean.TRUE);
        L12:
            if (r105 == true) goto L15;
            String r113 = "sdk_upload";
        L16:
            r111.resumeWith(Result.m9449constructorimpl(new f0(r107, r103, r108, r109, r100, MapsKt.mapOf(TuplesKt.to("sdk_route", r113)))));
        L15:
            r113 = "instant_upload";
        L18:
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Function1<mr9.k, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0 f313611a;

        public e(h0 r100) {
            this.f313611a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(mr9.k r100) {
            mr9.k r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "progress");
            c0 r102 = this.f313611a.f313672b;
            Long r103 = r101.f515020a;
            if (r103 == null) goto L5;
            long r104 = r103.longValue();
        L6:
            r102.update(new a0.f(r104));
            return Unit.INSTANCE;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static final class f implements Function1<ResourceUploadError, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<f0> f313612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f313613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SdkUploadNode f313614c;

        public f(kotlinx.coroutines.j r100, AtomicBoolean r101, SdkUploadNode r102) {
            this.f313612a = r100;
            this.f313613b = r101;
            this.f313614c = r102;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ResourceUploadError r100) {
            ResourceUploadError r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "error");
            kotlinx.coroutines.i<f0> r102 = this.f313612a;
            AtomicBoolean r103 = this.f313613b;
            SdkUploadNode r104 = this.f313614c;
            if (r102.isActive() == false) goto L9;
            if (r103.compareAndSet(false, true) == false) goto L9;
            Result.Companion r105 = Result.Companion;
            r104.getClass();
            StateFlowImpl r106 = s.f313730a;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            Intrinsics.checkNotNullParameter("sdk_upload", "stage");
            r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new ResourceAccessErrorException(new r("sdk_upload", r101.getCode(), r101.getMsg(), r101)))));
        L9:
            return Unit.INSTANCE;
        }
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "sdk_upload";
    }

    static {
        f313599d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public SdkUploadNode() {
        this.f313600a = ResourcePhase.UPLOAD;
        this.f313601b = CollectionsKt.listOf("preprocess");
        this.f313602c = true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.f313600a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.f313601b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.f313602c;
    }

    public static String b(j0 r100) {
        if ((r100 instanceof j0.b) == false) goto L6;
        return ((j0.b) r100).f313690b;
    L6:
        if ((r100 instanceof j0.a) == false) goto L9;
        return ((j0.a) r100).f313689b;
    L9:
        if ((r100 instanceof j0.c) == false) goto L11;
    L15:
        return null;
    L11:
        if ((r100 instanceof j0.d) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (SetsKt.setOf(new ResourceMediaType[]{ResourceMediaType.IMAGE, ResourceMediaType.VIDEO, ResourceMediaType.FILE}).contains(r100.f313671a.f313764c) == false) goto L14;
        String r101 = b(r100.f313673c);
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L14:
        return false;
    }

    public final Object a(h0 r310, Continuation<? super f0> r311) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r311), 1);
        r100.C();
        w r101 = r310.f313671a;
        j0 r110 = r310.f313673c;
        String r111 = r101.f313765d.f313654a;
        String r112 = b(r110);
        if (r112 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L110;
        Result.Companion r103 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new ResourceAccessErrorException(new r("sdk_upload", "unsupported_source", "resourceInput " + r110.getType() + " cannot upload by local sdk", null)))));
        kotlinx.coroutines.j r104 = r100;
    L106:
        Object r105 = r104.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        DebugProbesKt.probeCoroutineSuspended(r311);
    L109:
        return r105;
    L110:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
        Set r107 = ServiceManager.get().getServices(ResourceUploadSceneResolver.class, true);     // Catch: Throwable -> L27
        if (r107 != null) goto L15;
        r107 = SetsKt.emptySet();     // Catch: Throwable -> L27
    L15:
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L27
        Iterator r109 = r107.iterator();     // Catch: Throwable -> L27
    L17:
        if (r109.hasNext() == false) goto L21;
        Object r113 = r109.next();     // Catch: Throwable -> L27
        if (((ResourceUploadSceneResolver) r113).b(r310) == false) goto L17;
        r108.add(r113);     // Catch: Throwable -> L27
        goto L17
    L21:
        ResourceUploadSceneResolver r114 = (ResourceUploadSceneResolver) CollectionsKt.maxWithOrNull(r108, new b1(new a1()));     // Catch: Throwable -> L27
        if (r114 == null) goto L24;
        FlowResourceScene r115 = r114.a(r310);     // Catch: Throwable -> L27
    L25:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L27
    L29:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L33;
        FLogger.f375446a.e("SdkUploadNode", "[resolveFlowResourceScene] failed, scene=" + r310.f313671a.f313762a, r117);
    L33:
        if (Result.m9455isFailureimpl(r116) == false) goto L35;
        r116 = null;
    L35:
        FlowResourceScene r118 = (FlowResourceScene) r116;
        if (r118 == null) goto L38;
        ResourceCenter.f313541a.getClass();
        ResourceCenter.k(r111, r118);
    L38:
        AtomicBoolean r119 = new AtomicBoolean(false);
        String r120 = r101.f313765d.f313655b;
        int r121 = b.f313603a[r101.f313764c.ordinal()];
        if (r121 != 1) goto L41;
        UploadDataType r122 = UploadDataType.IMAGE;
    L49:
        UploadDataType r123 = r122;
        d r124 = new d(r100, r119, r101, r110, this);
        e r125 = new e(r310);
        f r126 = new f(r100, r119, this);
        boolean r127 = r110 instanceof j0.a;
        String r128 = r310.f313677g;
        g0 r129 = r101.f313765d;
        boolean r130 = r129.f313659f;
        CountDownLatch r131 = r129.f313660g;
        mr9.h r132 = r310.f313676f;
        boolean r133 = r110 instanceof j0.b;
        if (r133 == false) goto L52;
        String r134 = r111;
        String r135 = ((j0.b) r110).f313691c;
    L55:
        String r210 = r135;
    L64:
        if (r133 == false) goto L66;
        Boolean r136 = ((j0.b) r110).f313692d;
    L68:
        Boolean r211 = r136;
    L77:
        if (r133 == false) goto L79;
        mr9.c r137 = ((j0.b) r110).f313694f;
    L88:
        if (r137 != null) goto L90;
        r137 = r310.f313674d;
    L90:
        mr9.c r212 = r137;
        String r138 = r101.f313765d.f313657d;
        if (r133 == false) goto L93;
        Long r139 = ((j0.b) r110).f313693e;
    L102:
        if (r139 != null) goto L104;
        Long r312 = r310.f313675e;
    L105:
        String r140 = r134;
        mr9.j r313 = new mr9.j(r112, r120, r123, r124, r125, r126, r127, null, null, r128, r140, r130, r131, r132, r210, r211, r212, r138, r312, null, 1049472);
        r104 = r100;
        r104.i(new c(r119, r140));
        BuildersKt.launch$default(f313599d, null, null, new SdkUploadNode$awaitUpload$2$3(r104, r119, r313, this, null), 3, null);
        goto L106
    L104:
        r312 = r139;
        goto L105
    L93:
        if (r127 == false) goto L95;
    L101:
        r139 = null;
        goto L102
    L95:
        if ((r110 instanceof j0.c) == true) goto L101;
        if ((r110 instanceof j0.d) == true) goto L101;
        throw new NoWhenBranchMatchedException();
    L79:
        if (r127 == false) goto L81;
    L87:
        r137 = null;
        goto L88
    L81:
        if ((r110 instanceof j0.c) == true) goto L87;
        if ((r110 instanceof j0.d) == true) goto L87;
        throw new NoWhenBranchMatchedException();
    L66:
        if (r127 == false) goto L70;
        r136 = Boolean.TRUE;
        goto L68
    L70:
        if ((r110 instanceof j0.c) == false) goto L72;
    L76:
        r211 = null;
        goto L77
    L72:
        if ((r110 instanceof j0.d) == true) goto L76;
        throw new NoWhenBranchMatchedException();
    L52:
        r134 = r111;
        if (r127 == false) goto L57;
        r135 = ((j0.a) r110).f313689b;
        goto L55
    L57:
        if ((r110 instanceof j0.c) == false) goto L59;
    L63:
        r210 = null;
        goto L64
    L59:
        if ((r110 instanceof j0.d) == true) goto L63;
        throw new NoWhenBranchMatchedException();
    L41:
        if (r121 != 2) goto L43;
        r122 = UploadDataType.VIDEO;
        goto L49
    L43:
        if (r121 != 3) goto L46;
        r122 = UploadDataType.FILE;
        goto L49
    L46:
        throw new NoWhenBranchMatchedException();
    L24:
        r115 = null;
    L27:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L5:
        if (r112.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r100, Continuation<? super g> r101) {
        if ((r101 instanceof SdkUploadNode$execute$1) == false) goto L7;
        SdkUploadNode$execute$1 r102 = (SdkUploadNode$execute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L19;
        if (r106 != 1) goto L18;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
    L23:
    L34:
        return new g.d((f0) r104);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
        r104 = a(r100, r102);     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
        if (r104 != r105) goto L23;
        return r105;
    L15:
        e = move-exception;
        g.b r107 = new g.b(e.getError());
    L31:
        return r107;
    L13:
        th = move-exception;
        String r108 = th.getMessage();
        if (r108 != null) goto L28;
        r108 = "";
    L28:
        r107 = new g.b(new r("sdk_upload", "upload_exception", r108, th));
    L7:
        r102 = new SdkUploadNode$execute$1(this, r101);
        goto L8
    }
}

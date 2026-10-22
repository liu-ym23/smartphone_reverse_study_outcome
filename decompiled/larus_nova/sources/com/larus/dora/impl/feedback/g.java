package com.larus.dora.impl.feedback;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import com.larus.platform.model.upload.UploadDataType;
import com.obric.aivoice.core.data.IdlKeys;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f335619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f335620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f335621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateFlowImpl f335622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f335623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f335624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f335625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f335626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f335627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f335628j;

    private final Context getContext() {
        return this.f335621c.f335631a.getContext();
    }

    public static final /* synthetic */ Context a(g r100) {
        return r100.getContext();
    }

    public static final Object b(g r210, Continuation r211) {
        r210.getClass();
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r211), 1);
        r100.C();
        r0 r101 = r210.f335621c.f335631a.getImageXUploadCredentials();
        String r102 = r210.f335627i;
        Intrinsics.checkNotNull(r102);
        Context r110 = r210.getContext();
        boolean r103 = r210.f335624f;
        if (r103 == false) goto L5;
        UploadDataType r104 = UploadDataType.VIDEO;
    L6:
        UploadDataType r105 = r104;
        if (r103 == true) goto L9;
    L11:
        boolean r111 = false;
    L12:
        Intrinsics.checkNotNull(r101);
        mr9.m r106 = new mr9.m(r101.e(), "imagex.bytedanceapi.com", new mr9.b(r101.a(), r101.d(), r101.f(), r101.c(), r101.b()), 2);
        p0 r107 = new p0(new mr9.j(r102, "DoraG Feedback", r105, d.f335611a, e.f335613a, f.f335615a, r111, r106, r110, null, null, false, null, null, null, null, null, null, null, null, 2096384));
        b r108 = new b(r210, r100);
        Intrinsics.checkNotNullParameter(r108, "listener");
        r107.f335661c = r108;
        r100.i(new c(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFeedbackImage$uploadImage$2$uploadJob$1(r107, r100, null), 3, null), r107));
        Object r109 = r100.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r211);
    L16:
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r109;
    L19:
        return Unit.INSTANCE;
    L9:
        if (r210.f335628j == false) goto L11;
        r111 = true;
        goto L12
    L5:
        r104 = UploadDataType.IMAGE;
        goto L6
    }

    public static Object c(g r100, Continuation r101) {
        r100.getClass();
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        r102.i(new a(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFeedbackImage$compressImage$2$compressionJob$1(r100, r102, null), 3, null)));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r103;
    }

    public g(Uri r100, int r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, IdlKeys.Args_GrantUri);
        Intrinsics.checkNotNullParameter(r102, "imageGroup");
        this.f335619a = r100;
        this.f335620b = r101;
        this.f335621c = r102;
        StateFlowImpl r103 = j1.a(ImageState.IDLE);
        this.f335622d = r103;
        this.f335623e = kotlinx.coroutines.flow.e.b(r103);
        this.f335625g = "";
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r103, new DoraFeedbackImage$setupStateLogging$1(this, null)), ViewModelKt.getViewModelScope(r102.f335631a));
        String r104 = getContext().getContentResolver().getType(r100);
        boolean r105 = false;
        if (r104 != null) goto L5;
    L7:
        if (r105 == false) goto L10;
        this.f335624f = true;
        return;
    L10:
        return;
    L5:
        if (StringsKt.startsWith$default(r104, "video/", false, 2, null) != true) goto L7;
        r105 = true;
        goto L7
    }
}

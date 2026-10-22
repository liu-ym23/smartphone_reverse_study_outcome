package com.larus.bmhome.bigimg.download;

import com.larus.bmhome.bigimg.ImageSave;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes25.dex */
public final class ImageDownloadLoadingMgr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageDownloadLoadingMgr f295963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f295964b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f295965c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Job> f295966d = null;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f295967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f295968b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r100, String r101) {
            this.f295967a = r100;
            this.f295968b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            List r102 = (List) r100;
            this.f295967a.invoke(Boxing.boxBoolean(((List) ImageDownloadLoadingMgr.f295964b.getValue()).contains(this.f295968b)));
            return Unit.INSTANCE;
        }
    }

    public ImageDownloadLoadingMgr() {
    }

    static {
        f295963a = new ImageDownloadLoadingMgr();
        f295964b = j1.a(CollectionsKt.emptyList());
        f295965c = new e();
        f295966d = new HashMap();
    }

    public final Object a(String r100, Function1<? super Boolean, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ImageDownloadLoadingMgr$collectLoadingStatus$1) == false) goto L7;
        ImageDownloadLoadingMgr$collectLoadingStatus$1 r103 = (ImageDownloadLoadingMgr$collectLoadingStatus$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        ResultKt.throwOnFailure(r105);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        StateFlowImpl r108 = f295964b;
        a r109 = new a(r101, r100);
        r103.label = 1;
        if (r108.collect(r109, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new ImageDownloadLoadingMgr$collectLoadingStatus$1(this, r102);
        goto L8
    }

    public static void b(final String r100, Map r101, Function1 r102, final Function2 r110, boolean r111, Function1 r112) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Job r103 = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ImageDownloadLoadingMgr$saveImage$updateLoadingJob$1(r100, null), 3, null);
        r103.invokeOnCompletion(new f(r100));
        f295966d.put(r100, r103);
        ImageSave r104 = ImageSave.f295932a;
        Function3 r105 = new g(r100, r110);
        r104.getClass();
        ImageSave.w(r100, r101, r105, r102, r112, r111);
    }

    public static /* synthetic */ void c(String r100, Map r101, Function2 r102, boolean r103, Function1 r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        Function2 r106 = null;
    L10:
        if ((r105 & 16) == 0) goto L12;
        boolean r107 = false;
    L14:
        if ((r105 & 32) == 0) goto L16;
        Function1 r108 = null;
    L17:
        b(r100, r101, null, r106, r107, r108);
        return;
    L16:
        r108 = r104;
        goto L17
    L12:
        r107 = r103;
        goto L14
    L8:
        r106 = r102;
        goto L10
    }
}

package com.larus.dora.obric.device_management.explore;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource$RemoteUrl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreResourceProvider$getImage$2", f = "DoraObricGlassesExploreResourceProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGlassesExploreResourceProvider$getImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraObricGlassesImageResource.RemoteUrl>, Object> {
    final /* synthetic */ x0 $spec;
    int label;

    public DoraObricGlassesExploreResourceProvider$getImage$2(x0 r100, Continuation<? super DoraObricGlassesExploreResourceProvider$getImage$2> r101) {
        this.$spec = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraObricGlassesExploreResourceProvider$getImage$2(this.$spec, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super DoraObricGlassesImageResource.RemoteUrl> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super DoraObricGlassesImageResource.RemoteUrl> r101) {
        return ((DoraObricGlassesExploreResourceProvider$getImage$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$spec.f339607a;
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L17;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "image resourceName is empty");
        return new DoraObricGlassesImageResource.RemoteUrl("");
    L17:
        t0 r103 = t0.f339590a;
        x0 r104 = this.$spec;
        r103.getClass();
        int r105 = t0.a.f339591a[r104.f339608b.ordinal()];
        if (r105 != 1) goto L20;
        String r106 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/v1";
    L29:
        return new DoraObricGlassesImageResource.RemoteUrl(r106 + '/' + r104.f339607a + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
    L20:
        if (r105 != 2) goto L22;
        r106 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/detail/v1";
        goto L29
    L22:
        if (r105 != 3) goto L25;
        r106 = "https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/dora/obric/glasses/explore/basic/detail/v2";
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L10:
        if (StringsKt.isBlank(r101) == true) goto L13;
        r102 = false;
        goto L14
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

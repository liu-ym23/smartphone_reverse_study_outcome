package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFromType;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/l;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.MoreVideoComponent$openGallery$2", f = "MoreVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MoreVideoComponent$openGallery$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.l, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $itemNodeList;
    final /* synthetic */ List $tabNodeList;
    final /* synthetic */ Ref.IntRef $targetIndex;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public MoreVideoComponent$openGallery$2(List r1, List r2, View r3, Ref.IntRef r4, Continuation r5) {
        this.$itemNodeList = r1;
        this.$tabNodeList = r2;
        this.$view = r3;
        this.$targetIndex = r4;
        super(3, r5);
    }

    public final Continuation<Unit> create(CoroutineScope r7, vg3.l r8, Continuation<? super Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$create");
        Intrinsics.checkNotNullParameter(r8, "it");
        Intrinsics.checkNotNullParameter(r9, "continuation");
        MoreVideoComponent$openGallery$2 r10 = new MoreVideoComponent$openGallery$2(this.$itemNodeList, this.$tabNodeList, this.$view, this.$targetIndex, r9);
        r10.L$0 = r8;
        return r10;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.l) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        HeaderComponent.HeaderDependencyV2.a r7 = ((vg3.l) this.L$0).P();
        Fragment r0 = com.bytedance.android.shopping.anchorv4.containers.a.a;
        GalleryFragment r1 = new GalleryFragment(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a(r7, GalleryFromType.MoreVideo), null);
        r1.ma0(this.$itemNodeList, this.$tabNodeList);
        int r8 = FullScreenGalleryDialogActivity.l;
        Context r9 = this.$view.getContext();
        GalleryViewerParams r2 = new GalleryViewerParams(this.$targetIndex.element);
        BtmSDK r3 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.d r4 = new com.bytedance.android.btm.api.model.d();
        r4.a = "a1.b8094.c05258.d150175";
        r4.b = PageFinder.via(this.$view);
        Unit r5 = Unit.INSTANCE;
        FullScreenGalleryDialogActivity.a.a(r9, r2, r3.createJumpSourceBtmToken(r4));
        com.bytedance.android.shopping.anchorv4.containers.a.a = r1;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

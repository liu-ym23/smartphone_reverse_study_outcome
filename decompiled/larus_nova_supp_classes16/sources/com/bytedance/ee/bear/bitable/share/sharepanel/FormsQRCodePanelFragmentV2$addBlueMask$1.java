package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.larksuite.component.ignition.widget.blur.BlurProcessor;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.share.sharepanel.FormsQRCodePanelFragmentV2$addBlueMask$1", f = "FormsQRCodePanelFragmentV2.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
final class FormsQRCodePanelFragmentV2$addBlueMask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $dstBmp;
    int label;
    final /* synthetic */ FormsQRCodePanelFragmentV2 this$0;

    public FormsQRCodePanelFragmentV2$addBlueMask$1(FormsQRCodePanelFragmentV2 r1, Bitmap r2, Continuation<? super FormsQRCodePanelFragmentV2$addBlueMask$1> r3) {
        this.this$0 = r1;
        this.$dstBmp = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FormsQRCodePanelFragmentV2$addBlueMask$1(this.this$0, this.$dstBmp, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L24
    L13:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");     // Catch: Exception -> L24
        BitmapDrawable r8 = (BitmapDrawable) r7;     // Catch: Exception -> L24
        Context r2 = this.this$0.getContext();     // Catch: Exception -> L24
        if (r2 == null) goto L27;
        FormsQRCodePanelFragmentV2 r3 = this.this$0;     // Catch: Exception -> L24
        float r4 = UIUtils.dp2px(r3.requireContext(), 16.0f);     // Catch: Exception -> L24
        RequestBuilder r9 = Glide.with(r2).asBitmap().load(r8.getBitmap()).transform(new Transformation[]{new CenterCrop(), new FourRoundedCorners(r4, r4, 0.0f, 0.0f)});     // Catch: Exception -> L24
        View r5 = r3.p;     // Catch: Exception -> L24
        if (r5 != null) goto L22;
        View r6 = r3.getView();     // Catch: Exception -> L24
        if (r6 == null) goto L20;
        r5 = r6.findViewById(2131379659);     // Catch: Exception -> L24
    L21:
        r3.p = (AppCompatImageView) r5;     // Catch: Exception -> L24
        goto L22
    L20:
        r5 = null;
    L22:
        r9.into((AppCompatImageView) r5);     // Catch: Exception -> L24
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        Context r10 = this.this$0.requireContext();     // Catch: Exception -> L24
        Bitmap r11 = this.$dstBmp;     // Catch: Exception -> L24
        int r12 = UDColorUtils.getAlphaColor(this.this$0.requireContext(), 2131106521, 0.4f);     // Catch: Exception -> L24
        this.label = 1;     // Catch: Exception -> L24
        r7 = BlurProcessor.a.b(r10, r11, r12, this);     // Catch: Exception -> L24
        if (r7 != r0) goto L13;
        return r0;
    L24:
        e = move-exception;
        tt5.a.d("FormsQRCodePanelFragment", "add blur exception:" + e.getMessage());
        goto L27
    }
}

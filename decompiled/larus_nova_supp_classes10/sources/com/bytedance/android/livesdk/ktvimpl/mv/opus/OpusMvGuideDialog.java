package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.n;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvGuideDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusMvGuideDialog extends BaseKtvDialogFragment {
    public static final /* synthetic */ int j = 0;
    public final String g;
    public KtvContext h;
    public k i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OpusMvGuideDialog a;

        public b(OpusMvGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OpusMvGuideDialog a;

        public c(OpusMvGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            OpusMvGuideDialog r10 = this.a;
            k r0 = r10.i;
            if (r0 == null) goto L17;
            KtvContext r11 = r10.h;
            if (r11 == null) goto L17;
            com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a> r12 = r11.getOpenOpusPreViewDialog();
            if (r12 == null) goto L17;
            r12.post(new com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a(r0.e, r0.f, true, ""));
        L17:
            this.a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r13 = DialogFragmentLancet.sLastShowStack;
            if (r13 == null) goto L19;
            com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d extends BaseControllerListener<ImageInfo> {
        public d() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            boolean r5 = r3 instanceof AnimatedDrawable2;
        }
    }

    static {
    }

    public final String S90() {
        return "KtvOrderSongDialog";
    }

    public final int getLayoutId() {
        return 2131566517;
    }

    public OpusMvGuideDialog() {
        this.g = n.a((String) h.m4.getValue(null, h.a[271(0x10f, float:3.8E-43)]));
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L18;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        int r1 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L17:
        r6.setLayout(r1, -1);
        goto L18
    L16:
        r1 = -1;
        goto L17
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r0 = false;
    L18:
        Dialog r7 = getDialog();
        if (r7 == null) goto L24;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L25;
        r8.setGravity(85);
        return;
    L25:
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r3, r4);
        HSImageView r5 = r3.findViewById(2131374114);
        if (r5 == null) goto L5;
        r5.setController(Fresco.newDraweeControllerBuilder().setUri(this.g).setAutoPlayAnimations(true).setControllerListener(new d()).build());
    L5:
        CommomKtvButton r6 = r3.findViewById(2131365114);
        if (r6 == null) goto L8;
        r6.setTextColor(-16777216);
        r6.setBackgroundResource(2131249193);
        r6.setOnClickListener(new b(this));
    L8:
        View r7 = r3.findViewById(2131391650);
        if (r7 == null) goto L12;
        r7.setOnClickListener(new c(this));
        return;
    }
}

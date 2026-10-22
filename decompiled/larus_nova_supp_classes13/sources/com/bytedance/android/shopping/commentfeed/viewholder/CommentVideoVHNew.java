package com.bytedance.android.shopping.commentfeed.viewholder;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import bc3.e;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.h;
import com.bytedance.android.shopping.commentfeed.widget.VideoPlaySeekBar;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentVideoVHNew;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoVHNew extends CommentBaseViewHolder implements SeekBar.OnSeekBarChangeListener {
    public static final int o = 0;
    public final String b;
    public final View c;
    public final ECVideoPlayerView d;
    public final SimpleDraweeView e;
    public final ImageView f;
    public final VideoPlaySeekBar g;
    public final TextView h;
    public final ECStatusView i;
    public PromotionVideoInfo j;
    public boolean k;
    public int l;
    public boolean m;
    public final e n;

    public static final class a implements h {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c extends d {
        public final /* synthetic */ CommentVideoVHNew g;

        public c(CommentVideoVHNew r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            if (this.g.d.h() == false) goto L5;
            CommentVideoVHNew r3 = this.g;
            r3.d.m();
            r3.f.setVisibility(0);
            return;
        L5:
            this.g.play();
        }
    }

    static {
        o = com.bytedance.android.shopping.extensions.b.b(78);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void T3() {
        com.bytedance.android.ec.sdk.helper.c.a.b(this.b, "attachToWindow");
        if (this.d.h() == true) goto L6;
        W3();
        return;
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void U3() {
        com.bytedance.android.ec.sdk.helper.c.a.b(this.b, "detachFromWindow");
        this.d.x();
        this.f.setVisibility(0);
    }

    @Override // com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder
    public final void V3() {
        this.d.x();
        this.f.setVisibility(0);
        this.d.s();
    }

    public final void W3() {
        if (NetworkUtils.isWifi(this.a.getContext()) == false) goto L6;
        play();
        return;
    }

    public final void play() {
        if (this.d.h() == true) goto L6;
        this.d.n();
        this.f.setVisibility(8);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r4) {
        e r5 = this.n;
        if (r5 == null) goto L6;
        r5.b();
    L6:
        if (this.k == false) goto L16;
        this.h.setVisibility(8);
        Drawable r6 = this.g.getProgressDrawable();
        if (r6 == null) goto L15;
        LayerDrawable r7 = (LayerDrawable) r6;
        Drawable r0 = r7.findDrawableByLayerId(R.id.progress);
        Drawable r8 = r7.findDrawableByLayerId(R.id.background);
        this.g.setThumbOffset(2);
        if (r0 == null) goto L12;
        r0.setColorFilter(th.a.f(this.a.getContext()).getColor(2131101227), PorterDuff.Mode.SRC);
    L12:
        if (r8 == null) goto L17;
        r8.setColorFilter(th.a.f(this.a.getContext()).getColor(2131105930), PorterDuff.Mode.SRC);
        return;
    L17:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r5) {
        e r0 = this.n;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        ECVideoPlayerView r1 = this.d;
        if (r1 == null) goto L11;
        if (r1.g() != true) goto L11;
        play();
    L11:
        if (this.k == false) goto L21;
        this.h.setVisibility(8);
        Drawable r2 = this.g.getProgressDrawable();
        if (r2 == null) goto L20;
        LayerDrawable r3 = (LayerDrawable) r2;
        Drawable r4 = r3.findDrawableByLayerId(R.id.progress);
        Drawable r6 = r3.findDrawableByLayerId(R.id.background);
        this.g.setThumbOffset(0);
        if (r4 == null) goto L17;
        r4.setColorFilter(th.a.f(this.a.getContext()).getColor(2131101174), PorterDuff.Mode.SRC);
    L17:
        if (r6 == null) goto L21;
        r6.setColorFilter(th.a.f(this.a.getContext()).getColor(2131105906), PorterDuff.Mode.SRC);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L21:
        if (r5 != null) goto L32;
        return;
    L32:
        float r7 = (r5.getProgress() * 100) / r5.getMax();     // Catch: Exception -> L29
        if (this.j == null) goto L34;
        ECVideoPlayerView r8 = this.d;     // Catch: Exception -> L29
        if (r8 == null) goto L35;
        r8.v(r7);     // Catch: Exception -> L29
        return;
    L35:
        return;
    L34:
        return;
    L29:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.SeekBar, com.bytedance.android.shopping.commentfeed.widget.VideoPlaySeekBar] */
    public CommentVideoVHNew(View r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        super(r5);
        this.n = r6;
        this.b = "CommentVideoVHNew[" + hashCode() + ']';
        View r7 = r5.findViewById(2131370554);
        this.c = r7;
        ECVideoPlayerView r0 = (ECVideoPlayerView) r5.findViewById(2131370553);
        this.d = r0;
        this.e = r5.findViewById(2131370541);
        ImageView r1 = (ImageView) r5.findViewById(2131370552);
        this.f = r1;
        ?? r2 = (VideoPlaySeekBar) r5.findViewById(2131370555);
        this.g = r2;
        this.h = (TextView) r5.findViewById(2131370546);
        this.i = r5.findViewById(2131370549);
        this.l = -1;
        this.m = true;
        d r8 = new c(this);
        r2.setOnSeekBarChangeListener(this);
        r0.r(new a());
        r7.setOnClickListener(r8);
        r1.setOnClickListener(r8);
    }

    public final void X3(String r19, ECUrlModel r20) {
        this.i.b(this.a.getContext(), null, null);
        if (r20 == null) goto L5;
        h0.d(this.e, r20, null, null, null, null, null, 120);
        return;
    L5:
        if (r19 == null) goto L9;
        h0.e(this.e, r19, null, null, null, 120);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r7, int r8, boolean r9) {
        PromotionVideoInfo r10 = this.j;
        if (r10 == null) goto L21;
        long r11 = (long) (((r8 * 1.0f) / 100) * r10.getDuration());
        if (r9 == true) goto L7;
        return;
    L7:
        if (this.k == true) goto L9;
        this.h.setVisibility(8);
        return;
    L9:
        this.h.setVisibility(0);
        PromotionVideoInfo r12 = this.j;
        if (r12 == null) goto L24;
        Long r13 = Long.valueOf(r12.getDuration());
        if (r13.longValue() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        r13 = null;
    L18:
        if (r13 == null) goto L25;
        long r2 = r13.longValue();
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        int r4 = com.bytedance.android.shopping.anchorv3.utils.h.a;
        SpannableString r3 = new SpannableString(Intrinsics.stringPlus(com.bytedance.android.shopping.anchorv3.utils.h.a(this.a.getContext(), r11), " / "));
        r3.setSpan(new ForegroundColorSpan(th.a.f(this.a.getContext()).getColor(2131106028)), 0, r3.length(), 17);
        r14.append(r3);
        SpannableString r15 = new SpannableString(com.bytedance.android.shopping.anchorv3.utils.h.a(this.a.getContext(), r2));
        r15.setSpan(new ForegroundColorSpan(th.a.f(this.a.getContext()).getColor(2131105971)), 0, r15.length(), 17);
        r14.append(r15);
        this.h.setText(r14);
        return;
    L25:
        return;
    L14:
        r1 = false;
        goto L15
    L24:
        return;
    }
}

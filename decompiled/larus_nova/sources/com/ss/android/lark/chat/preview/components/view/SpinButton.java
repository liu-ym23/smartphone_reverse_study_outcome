package com.ss.android.lark.chat.preview.components.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se6.u;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJO\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n¢\u0006\u0002\u0010#J\u0006\u0010+\u001a\u00020\u0018J\u0010\u0010,\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/SpinButton;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "Lkotlin/Lazy;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "setSpinButtonData", "", "text", "", "textColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "iconKey", "iconResource", "iconWidth", "iconHeight", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/FontLevel;Ljava/lang/String;Ljava/lang/Integer;II)V", "animator", "Landroid/animation/ObjectAnimator;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator$delegate", "isOriginDegree", "", "startAnim", "setTextContent", "getTextWidthAndHeight", "Lcom/ss/android/lark/tangram/base/node/IVirtualNode$RectSize;", "size", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpinButton extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f416145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f416146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f416147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f416148d;

    public static final class a extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThemeColor f416149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpinButton f416150b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            if (r101 == null) goto L10;
            ThemeColor r102 = this.f416149a;
            SpinButton r103 = this.f416150b;
            r101.mutate();
            if (r102 == null) goto L7;
            r101.setTint(com.ss.android.lark.export.entity.preview.a.a(r102, r103.getContext(), null));
        L8:
            SpinButton.a(r103).setImageDrawable(r101);
            return;
        L7:
            r101.setTint(r103.getContext().getResources().getColor(R.color.ud_B600));
            goto L8
        }

        public a(ThemeColor r100, SpinButton r101) {
            this.f416149a = r100;
            this.f416150b = r101;
        }
    }

    private final ObjectAnimator getAnimator() {
        return (ObjectAnimator) this.f416147c.getValue();
    }

    private final ImageView getImageView() {
        return (ImageView) this.f416146b.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.f416145a.getValue();
    }

    public final void d() {
        boolean r100 = this.f416148d;
        float r101 = 0.0f;
        if (r100 == false) goto L5;
        float r102 = 0.0f;
    L6:
        if (r100 == false) goto L8;
        r101 = 180.0f;
    L8:
        getAnimator().setFloatValues(new float[]{r102, r101});
        getAnimator().start();
        this.f416148d = !this.f416148d;
        return;
    L5:
        r102 = 180.0f;
        goto L6
    }

    public SpinButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f416145a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.f416146b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.f416147c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.f416148d = true;
    }

    public static final /* synthetic */ ImageView a(SpinButton r100) {
        return r100.getImageView();
    }

    public final s6c.b.a b(s6c.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        getTextView().measure(View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(r100.f540895a), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new s6c.b.a(UIHelper.px2dp(getTextView().getMeasuredWidth()), UIHelper.px2dp(getTextView().getMeasuredHeight()));
    }

    public final void setTextContent(String r100) {
        if (r100 == null) goto L5;
        getTextView().setText(r100);
        return;
    }

    public SpinButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f416145a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.f416146b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.f416147c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.f416148d = true;
    }

    public SpinButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f416145a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.f416146b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.f416147c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.f416148d = true;
    }

    public final void c(String r100, ThemeColor r101, FontLevel r102, String r103, Integer r104, int r105, int r110) {
        getTextView().setText(r100);
        if (r101 == null) goto L5;
        getTextView().setTextColor(com.ss.android.lark.export.entity.preview.a.a(r101, getContext(), null));
    L6:
        int r106 = h6b.a.f483930a;
        float r107 = h6b.a.c(getContext(), r102);
        getTextView().setTextSize(0, r107);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r105, r110);
        r108.leftMargin = UIHelper.dp2px(4.0f);
        getImageView().setLayoutParams(r108);
        if (u.a() == false) goto L24;
        if (r103 != null) goto L10;
    L13:
        boolean r109 = true;
    L15:
        if (r109 == true) goto L20;
        IRequestCreator r111 = ImageLoader.with(getContext()).load(new EncryptImage(r103));
        g6b.a.InterfaceC5990a r112 = g6b.a.f480178a;
        if (r112 == null) goto L19;
        r112.c();
    L19:
        r111.isAsync(false).asDrawable().centerCrop().override(r105, r110).error(R.drawable.ic_chat_preview_icon_fold).into(new a(r101, this));
        return;
    L20:
        if (r104 == null) goto L22;
        getImageView().setImageResource(r104.intValue());
        getImageView().setColorFilter(getContext().getResources().getColor(R.color.ud_B600));
        return;
    L22:
        getImageView().setImageResource(R.drawable.ic_chat_preview_icon_fold);
        return;
    L10:
        if (r103.length() == 0) goto L13;
        r109 = false;
        goto L15
    L24:
        return;
    L5:
        getTextView().setTextColor(getContext().getResources().getColor(R.color.ud_B600));
        goto L6
    }
}

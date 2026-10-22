package com.larus.common_ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusChatContinuousTalkInputBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.obric.assistant.common.spi.IObricUIService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import v19.l5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\rJ4\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u001c\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\f\u0010\"\u001a\u00020\u0013*\u00020#H\u0002J\n\u0010)\u001a\u00020\u0013*\u00020#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u00020\r*\u00020#2\u0006\u0010$\u001a\u00020\r8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/larus/common_ui/view/ChatInputInnerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusChatContinuousTalkInputBinding;", "forceEnableDark", "", "defaultSpeakNormalText", "", "kotlin.jvm.PlatformType", "defaultSpeakHintStyle0Text", "setNormalTextColor", "", "color", "normalTextView", "Landroid/widget/TextView;", "updateImmerseModeStatus", "adaptSpeakArea", "showOnSpeakText", "instructionClosed", "enableRealtimeCall", "needAnim", "customSpeakHint", "", "configStyle1", "configStyle0", "configNoStyle", "fadeIn", "Landroid/view/View;", "value", "isAnimating", "(Landroid/view/View;)Z", "setAnimating", "(Landroid/view/View;Z)V", "fadeOut", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputInnerView extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f328173e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusChatContinuousTalkInputBinding f328174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f328175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f328176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f328177d;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInputInnerView f328178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f328179b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ChatInputInnerView r101 = this.f328178a;
            View r102 = this.f328179b;
            int r103 = ChatInputInnerView.f328173e;
            r101.getClass();
            r102.setTag(R.id.animating_tag, Boolean.FALSE);
            e1.o(this.f328179b);
        }

        public b(ChatInputInnerView r100, View r101) {
            this.f328178a = r100;
            this.f328179b = r101;
        }
    }

    static {
    }

    public ChatInputInnerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatInputInnerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static void S5(View r100) {
        if (r100.getVisibility() != 0) goto L5;
        return;
    L5:
        r100.setAlpha(0.0f);
        e1.x(r100);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r101.setInterpolator(new l5());
        r101.setDuration(300);
        r101.start();
    }

    public final void T5(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        return;
    L5:
        r100.setTag(R.id.animating_tag, Boolean.TRUE);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setInterpolator(new l5());
        r101.setDuration(300);
        r101.addListener(new b(this, r100));
        r101.start();
    }

    public final void U5(boolean r100) {
        this.f328175b = r100;
        this.f328174a.f326618e.setTextColor(ve8.d.a(R.color.larus_static_white, getContext()));
        this.f328174a.f326619f.setTextColor(ve8.d.a(R.color.larus_static_white, getContext()));
        this.f328174a.f326617d.setTextColor(ve8.d.a(R.color.larus_static_white, getContext()));
    }

    public final void setNormalTextColor(int r100) {
        this.f328174a.f326617d.setTextColor(r100);
    }

    public ChatInputInnerView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_chat_continuous_talk_input, this);
        int r102 = R.id.speak_hint_style_0;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.speak_hint_style_0);
        if (r103 == null) goto L17;
        r102 = R.id.speak_hint_style_1;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.speak_hint_style_1);
        if (r104 == null) goto L17;
        r102 = R.id.speak_normal;
        TextView r111 = (TextView) ViewBindings.findChildViewById(this, R.id.speak_normal);
        if (r111 == null) goto L17;
        r102 = R.id.speak_style_0;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.speak_style_0);
        if (r105 == null) goto L17;
        r102 = R.id.speak_style_1;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.speak_style_1);
        if (r106 == null) goto L17;
        this.f328174a = new LarusChatContinuousTalkInputBinding(this, r103, r104, r111, r105, r106);
        this.f328176c = r111.getText();
        this.f328177d = r103.getText();
        IObricUIService r107 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r107 == null) goto L18;
        r107.na(new TextView[]{r111});
        return;
    L18:
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ ChatInputInnerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void R5(boolean r100, boolean r101, boolean r102, boolean r103, String r110) {
        final LarusChatContinuousTalkInputBinding r104 = this.f328174a;
        if (r100 == false) goto L31;
        if (r102 == false) goto L31;
        if (r101 == false) goto L31;
        if (z2.f365865a.continuousTalkClickAlignment() == 1) goto L9;
    L15:
        final LarusChatContinuousTalkInputBinding r105 = this.f328174a;
        if (r103 == false) goto L18;
        T5(r105.f326617d);
        S5(r105.f326618e);
        S5(r105.f326615b);
    L19:
        e1.o(r105.f326619f);
        e1.o(r105.f326616c);
        TextView r106 = r105.f326615b;
        Resources r107 = getResources();
        boolean r108 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L22;
    L25:
        int r109 = R.color.static_white_transparent_3;
    L26:
        r106.setTextColor(ResourcesCompat.getColor(r107, r109, null));
        r105.f326618e.setTextSize(0, i5.o());
        r105.f326618e.post(new l(r105, this));
        r105.f326615b.setTextSize(0, i5.k());
        r105.f326615b.post(new m(r105));
        TextView r111 = r105.f326615b;
        CharSequence r112 = r110;
        if (r110 != null) goto L30;
        r112 = this.f328177d;
    L30:
        r111.setText(r112);
        nda.d.a().na(new TextView[]{r105.f326618e, r105.f326615b});
        return;
    L22:
        if (this.f328175b == true) goto L25;
        r109 = v19.c.b(R.attr.larus_neutral_50, null, R.color.larus_neutral_50);
        goto L26
    L18:
        e1.o(r105.f326617d);
        e1.x(r105.f326618e);
        e1.x(r105.f326615b);
        goto L19
    L9:
        if (AppHost.f326268a.isOversea() == true) goto L15;
        final LarusChatContinuousTalkInputBinding r113 = this.f328174a;
        if (r103 == false) goto L13;
        T5(r113.f326617d);
        S5(r113.f326619f);
        S5(r113.f326616c);
    L14:
        e1.o(r113.f326618e);
        e1.o(r113.f326615b);
        r113.f326619f.setTextSize(0, i5.q());
        r113.f326619f.post(new i(r113, this));
        r113.f326616c.setTextSize(0, i5.q());
        r113.f326616c.post(new j(r113, this));
        nda.d.a().na(new TextView[]{r113.f326619f, r113.f326616c});
        return;
    L13:
        e1.o(r113.f326617d);
        e1.x(r113.f326619f);
        e1.x(r113.f326616c);
    L31:
        if (r103 == false) goto L33;
        S5(r104.f326617d);
        T5(r104.f326618e);
        T5(r104.f326615b);
        T5(r104.f326619f);
        T5(r104.f326616c);
    L34:
        TextView r114 = r104.f326617d;
        CharSequence r115 = r110;
        if (r110 != null) goto L38;
        r115 = this.f328176c;
    L38:
        r114.setText(r115);
        r104.f326617d.post(new k(r104, this));
        return;
    L33:
        e1.x(r104.f326617d);
        e1.o(r104.f326618e);
        e1.o(r104.f326615b);
        e1.o(r104.f326619f);
        e1.o(r104.f326616c);
        goto L34
    }
}

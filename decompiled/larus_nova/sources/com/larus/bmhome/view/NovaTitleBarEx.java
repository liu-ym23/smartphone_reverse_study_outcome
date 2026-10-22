package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.common.CastMonitor;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common_res.common_ui.databinding.LarusLayoutLeftAvatarBinding;
import com.larus.common_res.common_ui.databinding.LarusWidgetTitlebarExBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J0\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0014JA\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\nJD\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010;\u001a\u00020\u001cJ:\u0010<\u001a\u00020=2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010>\u001a\u00020\u001cJ)\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010BJD\u0010C\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J:\u0010D\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020=J\"\u0010G\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020%J$\u0010J\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010K\u001a\u0004\u0018\u00010\r2\b\u0010L\u001a\u0004\u0018\u00010\rJ#\u0010M\u001a\u00020\u001c2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020UH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006V"}, d2 = {"Lcom/larus/bmhome/view/NovaTitleBarEx;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/larus/common_res/common_ui/databinding/LarusWidgetTitlebarExBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusWidgetTitlebarExBinding;", "avatarAreaViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutLeftAvatarBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getAvatarAreaViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "avatarAreaViewStub$delegate", "Lkotlin/Lazy;", "init", "", com.alipay.sdk.m.x.d.f25925o, "title", "color", "listener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "setTitleWithDesc", SocialConstants.PARAM_APP_DESC, "titleColor", "descColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)Lkotlin/Unit;", "updateTitleVisibility", RemoteMessageConst.Notification.VISIBILITY, "setTitleMaxWidth", "maxWidth", "showLeftImgSec", "resId", "alpha", "", "staticColor", "scaleType", "Landroid/widget/ImageView$ScaleType;", "accessibilityContent", "hideLeftImgSec", "showLeftImg", "Landroid/view/View;", "hideLeftImg", "showLeftText", "text", "", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "showRightImgSec", "showRightImg", "hideRightImg", "getRightImg", "showRightText", "setRightTextEnable", "enable", "setAvatarInfo", "subtitle", "avatarUrl", "setAvatarAreaStyle", "startMargin", "avatarSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setAvatarClickListener", "loadImg", "imgUrl", "builder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NovaTitleBarEx extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f315582d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusWidgetTitlebarExBinding f315584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f315585c;

    private final com.larus.common_ui.view.b0<LarusLayoutLeftAvatarBinding> getAvatarAreaViewStub() {
        return (com.larus.common_ui.view.b0) this.f315585c.getValue();
    }

    public final LarusWidgetTitlebarExBinding getBinding() {
        LarusWidgetTitlebarExBinding r100 = this.f315584b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void R5() {
        getBinding().f326840f.setVisibility(8);
    }

    public final View getRightImg() {
        return getBinding().f326840f;
    }

    public NovaTitleBarEx(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f315583a = "NovaTitleBarEx";
        this.f315585c = LazyKt.lazy(new w3(this));
        S5(r100, null);
    }

    public final void setAvatarClickListener(View.OnClickListener r100) {
        getAvatarAreaViewStub().b();
        LarusLayoutLeftAvatarBinding r101 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r101 == null) goto L10;
        ConstraintLayout r102 = r101.f326761a;
        if (r102 == null) goto L11;
        if (r100 != null) goto L8;
        r102.setOnClickListener(null);
        r102.setClickable(false);
        return;
    L8:
        com.larus.utils.e1.c(r102, r100);
        return;
    L11:
        return;
    }

    public final void setRightTextEnable(boolean r100) {
        LarusWidgetTitlebarExBinding r101 = getBinding();
        r101.f326842h.setEnabled(r100);
        TextView r102 = r101.f326842h;
        if (r100 == false) goto L5;
        float r103 = 1.0f;
    L6:
        r102.setAlpha(r103);
        return;
    L5:
        r103 = 0.3f;
        goto L6
    }

    public final void setTitleMaxWidth(int r100) {
        getBinding().f326844j.setMaxWidth(r100);
    }

    public NovaTitleBarEx(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f315583a = "NovaTitleBarEx";
        this.f315585c = LazyKt.lazy(new w3(this));
        S5(r100, r101);
    }

    public final void S5(Context r110, AttributeSet r111) {
        LayoutInflater.from(r110).inflate(R.layout.larus_widget_titlebar_ex, this);
        int r112 = R.id.complex_title_desc;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.complex_title_desc)) == null) goto L27;
        r112 = R.id.complex_title_layout;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.complex_title_layout);
        if (r100 == null) goto L27;
        r112 = R.id.complex_title_text;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.complex_title_text)) == null) goto L27;
        r112 = R.id.left_img;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(this, R.id.left_img);
        if (r101 == null) goto L27;
        r112 = R.id.left_img_sec;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.left_img_sec);
        if (r102 == null) goto L27;
        r112 = R.id.left_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.left_text);
        if (r103 == null) goto L27;
        r112 = R.id.right_img;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.right_img);
        if (r104 == null) goto L27;
        r112 = R.id.right_img_sec;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(this, R.id.right_img_sec);
        if (r105 == null) goto L27;
        r112 = R.id.right_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.right_text);
        if (r106 == null) goto L27;
        r112 = R.id.setting_left_avatar_container;
        ViewStub r107 = (ViewStub) ViewBindings.findChildViewById(this, R.id.setting_left_avatar_container);
        if (r107 == null) goto L27;
        r112 = R.id.title_text;
        TextView r113 = (TextView) ViewBindings.findChildViewById(this, R.id.title_text);
        if (r113 == null) goto L27;
        this.f315584b = new LarusWidgetTitlebarExBinding(this, r100, r101, r102, r103, r104, r105, r106, r107, r113);
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    public final void T5(Integer r100, Integer r101) {
        getAvatarAreaViewStub().b();
        if (r100 == null) goto L13;
        int r102 = r100.intValue();
        LarusLayoutLeftAvatarBinding r103 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r103 == null) goto L13;
        ConstraintLayout r104 = r103.f326761a;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L12;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r106.setMarginStart(r102);
        r104.setLayoutParams(r106);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        if (r101 == null) goto L23;
        int r107 = r101.intValue();
        LarusLayoutLeftAvatarBinding r108 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r108 == null) goto L24;
        TitleAvatarImageView r109 = r108.f326762b;
        if (r109 == null) goto L25;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L22;
        r110.width = r107;
        r110.height = r107;
        r109.setLayoutParams(r110);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L25:
        return;
    L24:
        return;
    }

    public NovaTitleBarEx(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315583a = "NovaTitleBarEx";
        this.f315585c = LazyKt.lazy(new w3(this));
        S5(r100, r101);
    }

    public static /* synthetic */ void o6(NovaTitleBarEx r100, CharSequence r101, View.OnClickListener r102) {
        r100.n6(r101, v19.c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50), r102);
    }

    public final void U5(String r100, String r101, String r102) {
        getAvatarAreaViewStub().b();
        LarusLayoutLeftAvatarBinding r103 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r103 == null) goto L7;
        TextView r104 = r103.f326764d;
        if (r104 == null) goto L7;
        r104.setText(r100);
    L7:
        LarusLayoutLeftAvatarBinding r105 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r105 == null) goto L12;
        TextView r106 = r105.f326763c;
        if (r106 == null) goto L12;
        r106.setText(r101);
    L12:
        LarusLayoutLeftAvatarBinding r107 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r107 == null) goto L31;
        TitleAvatarImageView r108 = r107.f326762b;
        if (r108 == null) goto L32;
        if (r102 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == false) goto L25;
        r108.setActualImageResource(R.drawable.larus_common_ui_avatar_placeholder);
        return;
    L25:
        r108.getHierarchy().setFadeDuration(200);
        final PipelineDraweeControllerBuilder r110 = Fresco.newDraweeControllerBuilder();
        LarusLayoutLeftAvatarBinding r111 = (LarusLayoutLeftAvatarBinding) getAvatarAreaViewStub().f328321c;
        if (r111 == null) goto L33;
        TitleAvatarImageView r112 = r111.f326762b;
        if (r112 == null) goto L34;
        ImageLoaderKt.w(r112, r102, "chat.setting.bot_avatar", new x3(r110), null);
        return;
    L34:
        return;
    L33:
        return;
    L18:
        if (r102.length() == 0) goto L21;
        r109 = false;
        goto L22
    L32:
        return;
    }

    public final void V5(String r100, Integer r101, View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        LarusWidgetTitlebarExBinding r103 = getBinding();
        com.larus.utils.e1.o(r103.f326836b);
        r103.f326844j.setVisibility(0);
        r103.f326844j.setText(r100);
        if (r101 == null) goto L5;
        r103.f326844j.setTextColor(ContextCompat.getColor(getContext(), r101.intValue()));
    L5:
        if (r102 == null) goto L8;
        com.larus.utils.e1.c(r103.f326844j, r102);
        return;
    }

    public final void c6(CharSequence r100, Integer r101, View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusWidgetTitlebarExBinding r103 = getBinding();
        r103.f326837c.setVisibility(8);
        r103.f326839e.setVisibility(0);
        r103.f326839e.setText(r100);
        if (r101 == null) goto L5;
        r103.f326839e.setTextColor(ContextCompat.getColor(getContext(), r101.intValue()));
    L5:
        com.larus.utils.e1.c(r103.f326839e, r102);
    }

    public final void n6(CharSequence r100, int r101, View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusWidgetTitlebarExBinding r103 = getBinding();
        r103.f326840f.setVisibility(8);
        r103.f326841g.setVisibility(8);
        r103.f326842h.setVisibility(0);
        if (r101 != v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)) goto L5;
    L7:
        r103.f326842h.setText(r100);
        com.larus.utils.e1.c(r103.f326842h, r102);
        return;
    L5:
        if (getContext() == null) goto L7;
        r103.f326842h.setTextColor(ContextCompat.getColor(getContext(), r101));
        goto L7
    }

    public static /* synthetic */ void Y5(NovaTitleBarEx r100, String r101, Integer r102, View.OnClickListener r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.V5(r101, r102, r103);
    }

    public final View Z5(int r100, boolean r101, ImageView.ScaleType r102, String r103, View.OnClickListener r110) {
        LarusWidgetTitlebarExBinding r104 = getBinding();
        r104.f326837c.setVisibility(0);
        if (r101 == true) goto L5;
        r104.f326837c.setColorFilter(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
    L5:
        r104.f326839e.setVisibility(8);
        r104.f326837c.setImageResource(r100);
        if (r102 == null) goto L8;
        r104.f326837c.setScaleType(r102);
    L8:
        if (r103 == null) goto L10;
        r104.f326837c.setContentDescription(r103);
    L10:
        com.larus.utils.e1.c(r104.f326837c, r110);
        return getBinding().f326837c;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (getBinding().f326839e.getRight() <= getBinding().f326844j.getLeft()) goto L12;
        FLogger r105 = FLogger.f375446a;
        r105.d(this.f315583a, "title bar overlap");
        int r106 = (getBinding().f326839e.getWidth() - (getBinding().f326839e.getRight() - getBinding().f326844j.getLeft())) - i5.z();
        int r107 = i5.T();
        if (r106 < r107) goto L9;
        r105.d(this.f315583a, "title bar overlap, candidate " + r106 + " >= minWidth " + r107);
        getBinding().f326839e.setMaxWidth(r106);
        return;
    L9:
        getBinding().f326839e.setMaxWidth(r107);
        getBinding().f326844j.setMaxWidth(getBinding().f326844j.getWidth() - ((r107 - r106) * 2));
        r105.d(this.f315583a, "title bar overlap, candidate " + r106 + " < minWidth " + r107 + ", resize title maxWidth " + getBinding().f326844j.getMaxWidth());
        return;
    }

    public static void i6(NovaTitleBarEx r100, int r101, ImageView.ScaleType r102, String r103, View.OnClickListener r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r103 = null;
    L8:
        LarusWidgetTitlebarExBinding r106 = r100.getBinding();
        r106.f326840f.setVisibility(0);
        r106.f326842h.setVisibility(8);
        r106.f326840f.setImageResource(r101);
        r106.f326840f.setColorFilter(ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_neutral_100, r100.getContext(), R.color.larus_neutral_100)));
        if (r102 == null) goto L11;
        r106.f326840f.setScaleType(r102);
    L11:
        if (r103 == null) goto L13;
        r106.f326840f.setContentDescription(r103);
    L13:
        com.larus.utils.e1.c(r106.f326840f, r104);
    }

    public static /* synthetic */ View b6(NovaTitleBarEx r100, int r101, boolean r102, ImageView.ScaleType r103, String r110, View.OnClickListener r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        boolean r104 = false;
    L7:
        if ((r112 & 4) == 0) goto L9;
        ImageView.ScaleType r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        String r106 = null;
    L15:
        return r100.Z5(r101, r104, r105, r106, r111);
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }

    public static void k6(NovaTitleBarEx r100, int r101, float r102, ImageView.ScaleType r103, String r104, View.OnClickListener r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = 1.0f;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 16) == 0) goto L11;
        r104 = null;
    L11:
        LarusWidgetTitlebarExBinding r107 = r100.getBinding();
        r107.f326841g.setVisibility(0);
        r107.f326841g.setAlpha(r102);
        r107.f326842h.setVisibility(8);
        r107.f326841g.setImageResource(r101);
        r107.f326841g.setColorFilter(ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_neutral_100, r100.getContext(), R.color.larus_neutral_100)));
        if (r103 == null) goto L14;
        r107.f326841g.setScaleType(r103);
    L14:
        if (r104 == null) goto L16;
        r107.f326841g.setContentDescription(r104);
    L16:
        com.larus.utils.e1.c(r107.f326841g, r105);
    }
}

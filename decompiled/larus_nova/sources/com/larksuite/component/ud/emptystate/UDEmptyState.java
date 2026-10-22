package com.larksuite.component.ud.emptystate;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.component.ud.button.UDButton;
import com.larksuite.component.ud.color.UDColorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 W2\u00020\u0001:\u0003XYZB\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bR\u0010TB#\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bR\u0010UB+\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\bR\u0010VJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0017\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00072\b\b\u0001\u0010\u001a\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010,\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010,\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u00100\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u00104\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\u000e\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u000209J\u0010\u0010<\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010<\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u0010=\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u0010>\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010@\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010B\u001a\u00020\u00072\u0006\u0010:\u001a\u000209J\u0010\u0010C\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010C\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u0010G\u001a\u00020\u000fJ\u0010\u0010J\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010HJ\u0006\u0010K\u001a\u00020\u0007J\b\u0010L\u001a\u0004\u0018\u00010\rJ\u000e\u0010M\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006["}, d2 = {"Lcom/larksuite/component/ud/emptystate/UDEmptyState;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "init", "Landroid/content/res/TypedArray;", "ta", "initProperty", "initStyle", "Landroid/view/View;", "view", "", "isVisible", "setViewVisibility", GXTemplateKey.GAIAX_PX, "setImageSizeInternal", "Lcom/larksuite/component/ud/button/UDButton;", "button", "setButtonPrimaryTextLinkStyle", "setButtonSecondaryTextLinkStyle", "setButtonPrimaryButtonStyle", "setButtonSecondaryButtonStyle", "resId", "setImageRes", "(Ljava/lang/Integer;)V", "", "dp", "setImageSize", "(Ljava/lang/Float;)V", "setImageSizeResource", "", "text", d.f25925o, "", "textAppearanceRes", "setTitleTextAppearance", GXTemplateKey.FLEXBOX_MARGIN, "setImageBottomMargin", "isShow", "showTitle", "setDesc", "setDescTextAppearance", "setTitleBottomMargin", "showDescription", "setPrimaryText", "Landroid/view/View$OnClickListener;", "listener", "setPrimaryClickListener", "setPrimaryActionTopMargin", "showPrimaryAction", "enabled", "setPrimaryActionEnabled", "isPrimaryActionEnabled", "Lcom/larksuite/component/ud/emptystate/UDEmptyState$ButtonStyle;", "style", "setPrimaryActionStyle", "setSecondaryText", "setSecondaryClickListener", "setSecondaryActionTopMargin", "showSecondaryAction", "setSecondaryActionEnabled", "isSecondaryActionEnabled", "setSecondaryActionStyle", "setLinkAction", "setOnLinkActionClickListener", "showLinkAction", "setLinkActionEnabled", "isLinkActionEnabled", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "setContainer", BasicTestActionHandler.TEST_ACTION_RESET, "getImageView", "setImageView", "rootView", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "ButtonStyle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
public class UDEmptyState extends LinearLayout {
    public static final a Companion = null;
    private static final float IMAGE_LARGE = 0.0f;
    private static final float IMAGE_SMALL = 0.0f;
    private View rootView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/ud/emptystate/UDEmptyState$ButtonStyle;", "", "BUTTON", "TEXT_LINK", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        public static final ButtonStyle BUTTON = null;
        public static final ButtonStyle TEXT_LINK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ButtonStyle[] f284036a = null;

        public static ButtonStyle valueOf(String r100) {
            return (ButtonStyle) r27.a.a(ButtonStyle.class, r100);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) f284036a.clone();
        }

        static {
            ButtonStyle r100 = new ButtonStyle("BUTTON", 0);
            BUTTON = r100;
            ButtonStyle r101 = new ButtonStyle("TEXT_LINK", 1);
            TEXT_LINK = r101;
            f284036a = new ButtonStyle[]{r100, r101};
        }

        public ButtonStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f284037a = 0;

        public static final class a {
        }

        static {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284038a = null;

        static {
            int[] r100 = new int[ButtonStyle.values().length];
            r100[ButtonStyle.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ButtonStyle.TEXT_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f284038a = r100;
        }
    }

    public static /* synthetic */ void a(UDEmptyState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        init$lambda$1(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* synthetic */ void b(UDEmptyState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        init$lambda$3(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public final void reset() {
        setImageRes(0);
        setTitle(null);
        setDesc(null);
        setPrimaryText(null);
        setPrimaryClickListener(null);
        setSecondaryText(null);
        setSecondaryClickListener(null);
        setLinkAction(null);
        setOnLinkActionClickListener(null);
    }

    static {
        Companion = new a();
        IMAGE_LARGE = 245.0f;
        IMAGE_SMALL = 100.0f;
    }

    public final View getImageView() {
        View r100 = this.rootView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (ImageView) r100.findViewById(R.id.image);
    }

    public final boolean isLinkActionEnabled() {
        View r100 = this.rootView;
        if (r100 == null) goto L7;
        UDButton r101 = (UDButton) r100.findViewById(R.id.btnLink);
        if (r101 == null) goto L7;
        return r101.isEnabled();
    L7:
        return false;
    }

    public final boolean isPrimaryActionEnabled() {
        View r100 = this.rootView;
        if (r100 == null) goto L7;
        UDButton r101 = (UDButton) r100.findViewById(R.id.btnPrimary);
        if (r101 == null) goto L7;
        return r101.isEnabled();
    L7:
        return false;
    }

    public final boolean isSecondaryActionEnabled() {
        View r100 = this.rootView;
        if (r100 == null) goto L7;
        UDButton r101 = (UDButton) r100.findViewById(R.id.btnSecondary);
        if (r101 == null) goto L7;
        return r101.isEnabled();
    L7:
        return false;
    }

    public static final /* synthetic */ float access$getIMAGE_LARGE$cp() {
        return IMAGE_LARGE;
    }

    public static final /* synthetic */ float access$getIMAGE_SMALL$cp() {
        return IMAGE_SMALL;
    }

    public UDEmptyState(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void initProperty(TypedArray r100) {
        setImageRes(Integer.valueOf(r100.getResourceId(2, 0)));
        CharSequence r101 = r100.getText(10);
        if (r101 == null) goto L6;
        String r102 = r101.toString();
        if (r102 == null) goto L6;
    L7:
        setTitle(r102);
        CharSequence r103 = r100.getText(0);
        if (r103 == null) goto L11;
        String r104 = r103.toString();
        if (r104 == null) goto L11;
    L12:
        setDesc(r104);
        CharSequence r105 = r100.getText(6);
        if (r105 == null) goto L16;
        String r106 = r105.toString();
        if (r106 == null) goto L16;
    L17:
        setPrimaryText(r106);
        CharSequence r107 = r100.getText(8);
        if (r107 == null) goto L21;
        String r108 = r107.toString();
        if (r108 == null) goto L21;
    L22:
        setSecondaryText(r108);
        CharSequence r109 = r100.getText(4);
        if (r109 == null) goto L26;
        String r110 = r109.toString();
        if (r110 == null) goto L26;
    L27:
        setLinkAction(r110);
        return;
    L26:
        r110 = r100.getString(4);
    L21:
        r108 = r100.getString(8);
    L16:
        r106 = r100.getString(6);
    L11:
        r104 = r100.getString(0);
    L6:
        r102 = r100.getString(10);
        goto L7
    }

    private final void initStyle(TypedArray r100) {
        Context r101 = getContext();
        float r102 = IMAGE_SMALL;
        int r103 = qz7.a.f535381a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r104 = r101.getResources();
        int r105 = r100.getDimensionPixelSize(3, (int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        View r106 = this.rootView;
        ViewGroup.LayoutParams r107 = null;
        if (r106 == null) goto L7;
        ImageView r108 = (ImageView) r106.findViewById(R.id.image);
        if (r108 == null) goto L7;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L8:
        if (r109 == null) goto L11;
        r109.width = r105;
    L11:
        View r110 = this.rootView;
        if (r110 == null) goto L16;
        ImageView r111 = (ImageView) r110.findViewById(R.id.image);
        if (r111 == null) goto L16;
        r107 = r111.getLayoutParams();
    L16:
        if (r107 == null) goto L19;
        r107.height = r105;
    L19:
        int r112 = r100.getDimensionPixelSize(7, 14);
        View r113 = this.rootView;
        if (r113 == null) goto L24;
        UDButton r114 = (UDButton) r113.findViewById(R.id.btnPrimary);
        if (r114 == null) goto L24;
        r114.setTextSize(0, r112);
    L24:
        int r115 = r100.getDimensionPixelSize(9, 14);
        View r116 = this.rootView;
        if (r116 == null) goto L29;
        UDButton r117 = (UDButton) r116.findViewById(R.id.btnSecondary);
        if (r117 == null) goto L29;
        r117.setTextSize(0, r115);
    L29:
        Context r118 = getContext();
        Lazy r119 = UDColorUtils.f284034a;
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r120 = r100.getColor(11, r118.getResources().getColor(R.color.text_title));
        View r121 = this.rootView;
        if (r121 == null) goto L34;
        TextView r122 = (TextView) r121.findViewById(R.id.title);
        if (r122 == null) goto L34;
        r122.setTextColor(r120);
    L34:
        Context r123 = getContext();
        Intrinsics.checkNotNullParameter(r123, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r124 = r100.getColor(1, r123.getResources().getColor(R.color.text_caption));
        View r125 = this.rootView;
        if (r125 == null) goto L39;
        TextView r126 = (TextView) r125.findViewById(R.id.desc);
        if (r126 == null) goto L39;
        r126.setTextColor(r124);
    L39:
        int r127 = b.f284037a;
        Context r128 = getContext();
        Intrinsics.checkNotNullParameter(r128, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.getInt(5, r128.getResources().getColor(R.color.primary_fill_default));
        return;
    L7:
        r109 = null;
        goto L8
    }

    private final void setButtonPrimaryButtonStyle(UDButton r100) {
        if (r100 == null) goto L4;
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_blue_bg));
    L4:
        if (r100 == null) goto L6;
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.static_white));
    L6:
        if (r100 == null) goto L9;
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
        return;
    }

    private final void setButtonPrimaryTextLinkStyle(UDButton r100) {
        if (r100 == null) goto L4;
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_text_primary_bg));
    L4:
        if (r100 == null) goto L6;
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_blue_text));
    L6:
        if (r100 == null) goto L9;
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
        return;
    }

    private final void setButtonSecondaryButtonStyle(UDButton r100) {
        if (r100 == null) goto L4;
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_text_secondary_bg));
    L4:
        if (r100 == null) goto L6;
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_grey_text));
    L6:
        if (r100 == null) goto L9;
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.line_border_component));
        return;
    }

    private final void setButtonSecondaryTextLinkStyle(UDButton r100) {
        if (r100 == null) goto L4;
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_text_secondary_bg));
    L4:
        if (r100 == null) goto L6;
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.chameleonv1_ud_button_grey_text));
    L6:
        if (r100 == null) goto L9;
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
        return;
    }

    private final void setImageSizeInternal(int r100) {
        View r101 = this.rootView;
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L7;
        ImageView r103 = (ImageView) r101.findViewById(R.id.image);
        if (r103 == null) goto L7;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L8:
        if (r104 == null) goto L11;
        r104.width = r100;
    L11:
        View r105 = this.rootView;
        if (r105 == null) goto L16;
        ImageView r106 = (ImageView) r105.findViewById(R.id.image);
        if (r106 == null) goto L16;
        r102 = r106.getLayoutParams();
    L16:
        if (r102 == null) goto L20;
        r102.height = r100;
        return;
    L20:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void setContainer(ViewGroup r100) {
        if (getParent() == null) goto L5;
        ViewParent r101 = getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r101).removeView(this);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if ((r100 instanceof LinearLayout) == false) goto L9;
        int r102 = 0;
    L10:
        r100.addView(this, r102, new LinearLayout.LayoutParams(-1, -1));
        return;
    L9:
        r102 = r100.getChildCount() - 1;
        goto L10
    }

    public final void setDesc(CharSequence r100) {
        View r101 = this.rootView;
        TextView r102 = null;
        if (r101 == null) goto L5;
        TextView r103 = (TextView) r101.findViewById(R.id.desc);
    L6:
        if (r103 == null) goto L9;
        r103.setText(r100);
    L9:
        View r104 = this.rootView;
        if (r104 == null) goto L12;
        TextView r105 = (TextView) r104.findViewById(R.id.desc);
    L13:
        if (r105 == null) goto L25;
        int r106 = 0;
        if (r100 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        r106 = 8;
    L24:
        r105.setVisibility(r106);
        goto L25
    L18:
        if (r100.length() == 0) goto L21;
        r107 = false;
    L25:
        View r108 = this.rootView;
        if (r108 == null) goto L28;
        r102 = (TextView) r108.findViewById(R.id.desc);
    L28:
        if (r102 == null) goto L32;
        r102.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L32:
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void setDescTextAppearance(int r100) {
        if (Build.VERSION.SDK_INT < 23) goto L9;
        View r101 = this.rootView;
        if (r101 == null) goto L15;
        TextView r102 = (TextView) r101.findViewById(R.id.desc);
        if (r102 == null) goto L16;
        r102.setTextAppearance(r100);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r103 = this.rootView;
        if (r103 == null) goto L18;
        TextView r104 = (TextView) r103.findViewById(R.id.desc);
        if (r104 == null) goto L19;
        r104.setTextAppearance(getContext(), r100);
        return;
    L19:
        return;
    }

    public final void setImageBottomMargin(int r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L7;
        ImageView r102 = (ImageView) r101.findViewById(R.id.image);
        if (r102 == null) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = r100;
        View r104 = this.rootView;
        if (r104 == null) goto L14;
        ImageView r105 = (ImageView) r104.findViewById(R.id.image);
        if (r105 == null) goto L15;
        r105.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void setImageRes(Integer r100) {
        View r101 = getImageView();
        if (r100 == null) goto L11;
        if (r100.intValue() != 0) goto L11;
        if (r101 == null) goto L20;
        r101.setVisibility(8);
        return;
    L20:
        return;
    L11:
        if ((r101 instanceof ImageView) == false) goto L19;
        ImageView r102 = (ImageView) r101;
        if (r100 == null) goto L15;
        int r103 = r100.intValue();
    L16:
        r102.setImageResource(r103);
        r102.setVisibility(0);
        return;
    L15:
        r103 = 0;
        goto L16
    }

    public final void setImageSize(Float r100) {
        if (r100 == null) goto L5;
        r100.floatValue();
        Context r101 = getContext();
        float r102 = r100.floatValue();
        int r103 = qz7.a.f535381a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r104 = r101.getResources();
        setImageSizeInternal((int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        return;
    }

    public final void setImageSizeResource(int r100) {
        setImageSizeInternal((int) getContext().getResources().getDimension(r100));
    }

    public final void setImageView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r101 = getImageView();
        if (r101 == null) goto L6;
        removeView(r101);
        addView(r100, 0, r101.getLayoutParams());
        return;
    }

    public final void setLinkAction(CharSequence r100) {
        View r101 = this.rootView;
        UDButton r102 = null;
        if (r101 == null) goto L5;
        UDButton r103 = (UDButton) r101.findViewById(R.id.btnLink);
    L6:
        if (r103 == null) goto L9;
        r103.setText(r100);
    L9:
        View r104 = this.rootView;
        if (r104 == null) goto L12;
        r102 = (UDButton) r104.findViewById(R.id.btnLink);
    L12:
        if (r102 == null) goto L25;
        int r105 = 0;
        if (r100 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        r105 = 8;
    L23:
        r102.setVisibility(r105);
        return;
    L17:
        if (r100.length() == 0) goto L20;
        r106 = false;
        goto L21
    L25:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setLinkActionEnabled(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L5;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnLink);
    L6:
        if (r102 == null) goto L10;
        r102.setEnabled(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setOnLinkActionClickListener(View.OnClickListener r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnLink);
        if (r102 == null) goto L9;
        r102.setOnClickListener(r100);
        return;
    L9:
        return;
    }

    public final void setPrimaryActionEnabled(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L5;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnPrimary);
    L6:
        if (r102 == null) goto L10;
        r102.setEnabled(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setPrimaryActionStyle(ButtonStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = c.f284038a[r100.ordinal()];
        UDButton r102 = null;
        if (r101 != 1) goto L5;
        View r103 = this.rootView;
        if (r103 == null) goto L14;
        r102 = (UDButton) r103.findViewById(R.id.btnPrimary);
    L14:
        setButtonPrimaryButtonStyle(r102);
        return;
    L5:
        if (r101 != 2) goto L17;
        View r104 = this.rootView;
        if (r104 == null) goto L10;
        r102 = (UDButton) r104.findViewById(R.id.btnPrimary);
    L10:
        setButtonPrimaryTextLinkStyle(r102);
        return;
    }

    public final void setPrimaryActionTopMargin(int r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L7;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnPrimary);
        if (r102 == null) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r103).topMargin = r100;
        View r104 = this.rootView;
        if (r104 == null) goto L14;
        UDButton r105 = (UDButton) r104.findViewById(R.id.btnPrimary);
        if (r105 == null) goto L15;
        r105.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void setPrimaryClickListener(View.OnClickListener r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnPrimary);
        if (r102 == null) goto L9;
        r102.setOnClickListener(r100);
        return;
    L9:
        return;
    }

    public final void setPrimaryText(CharSequence r100) {
        View r101 = this.rootView;
        CharSequence r102 = null;
        if (r101 == null) goto L5;
        UDButton r103 = (UDButton) r101.findViewById(R.id.btnPrimary);
    L6:
        if (r103 == null) goto L9;
        r103.setText(r100);
    L9:
        View r104 = this.rootView;
        if (r104 == null) goto L12;
        UDButton r105 = (UDButton) r104.findViewById(R.id.btnPrimary);
    L13:
        if (r105 == null) goto L31;
        View r106 = this.rootView;
        if (r106 == null) goto L20;
        UDButton r107 = (UDButton) r106.findViewById(R.id.btnPrimary);
        if (r107 == null) goto L20;
        r102 = r107.getText();
    L20:
        int r108 = 0;
        if (r102 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L29;
        r108 = 8;
    L29:
        r105.setVisibility(r108);
        return;
    L23:
        if (r102.length() == 0) goto L26;
        r109 = false;
        goto L27
    L31:
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void setSecondaryActionEnabled(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L5;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnSecondary);
    L6:
        if (r102 == null) goto L10;
        r102.setEnabled(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setSecondaryActionStyle(ButtonStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = c.f284038a[r100.ordinal()];
        UDButton r102 = null;
        if (r101 != 1) goto L5;
        View r103 = this.rootView;
        if (r103 == null) goto L14;
        r102 = (UDButton) r103.findViewById(R.id.btnSecondary);
    L14:
        setButtonSecondaryButtonStyle(r102);
        return;
    L5:
        if (r101 != 2) goto L17;
        View r104 = this.rootView;
        if (r104 == null) goto L10;
        r102 = (UDButton) r104.findViewById(R.id.btnSecondary);
    L10:
        setButtonSecondaryTextLinkStyle(r102);
        return;
    }

    public final void setSecondaryActionTopMargin(int r100) {
        View r101 = this.rootView;
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 == null) goto L7;
        UDButton r103 = (UDButton) r101.findViewById(R.id.btnSecondary);
        if (r103 == null) goto L7;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L9:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r102 = (ViewGroup.MarginLayoutParams) r104;
    L11:
        if (r102 == null) goto L18;
        r102.topMargin = r100;
        View r105 = this.rootView;
        if (r105 == null) goto L19;
        UDButton r106 = (UDButton) r105.findViewById(R.id.btnSecondary);
        if (r106 == null) goto L20;
        r106.requestLayout();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r104 = null;
        goto L9
    }

    public final void setSecondaryClickListener(View.OnClickListener r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnSecondary);
        if (r102 == null) goto L9;
        r102.setOnClickListener(r100);
        return;
    L9:
        return;
    }

    public final void setSecondaryText(CharSequence r100) {
        View r101 = this.rootView;
        CharSequence r102 = null;
        if (r101 == null) goto L5;
        UDButton r103 = (UDButton) r101.findViewById(R.id.btnSecondary);
    L6:
        if (r103 == null) goto L9;
        r103.setText(r100);
    L9:
        View r104 = this.rootView;
        if (r104 == null) goto L12;
        UDButton r105 = (UDButton) r104.findViewById(R.id.btnSecondary);
    L13:
        if (r105 == null) goto L31;
        View r106 = this.rootView;
        if (r106 == null) goto L20;
        UDButton r107 = (UDButton) r106.findViewById(R.id.btnSecondary);
        if (r107 == null) goto L20;
        r102 = r107.getText();
    L20:
        int r108 = 0;
        if (r102 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L29;
        r108 = 8;
    L29:
        r105.setVisibility(r108);
        return;
    L23:
        if (r102.length() == 0) goto L26;
        r109 = false;
        goto L27
    L31:
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void setTitle(CharSequence r100) {
        View r101 = this.rootView;
        TextView r102 = null;
        if (r101 == null) goto L5;
        TextView r103 = (TextView) r101.findViewById(R.id.title);
    L6:
        if (r103 == null) goto L9;
        r103.setText(r100);
    L9:
        View r104 = this.rootView;
        if (r104 == null) goto L12;
        r102 = (TextView) r104.findViewById(R.id.title);
    L12:
        if (r102 == null) goto L25;
        int r105 = 0;
        if (r100 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        r105 = 8;
    L23:
        r102.setVisibility(r105);
        return;
    L17:
        if (r100.length() == 0) goto L20;
        r106 = false;
        goto L21
    L25:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setTitleBottomMargin(int r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L7;
        TextView r102 = (TextView) r101.findViewById(R.id.title);
        if (r102 == null) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = r100;
        View r104 = this.rootView;
        if (r104 == null) goto L14;
        TextView r105 = (TextView) r104.findViewById(R.id.title);
        if (r105 == null) goto L15;
        r105.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void setTitleTextAppearance(int r100) {
        if (Build.VERSION.SDK_INT < 23) goto L9;
        View r101 = this.rootView;
        if (r101 == null) goto L15;
        TextView r102 = (TextView) r101.findViewById(R.id.title);
        if (r102 == null) goto L16;
        r102.setTextAppearance(r100);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r103 = this.rootView;
        if (r103 == null) goto L18;
        TextView r104 = (TextView) r103.findViewById(R.id.title);
        if (r104 == null) goto L19;
        r104.setTextAppearance(getContext(), r100);
        return;
    L19:
        return;
    }

    public final void showDescription(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        TextView r102 = (TextView) r101.findViewById(R.id.desc);
        if (r102 == null) goto L9;
        setViewVisibility(r102, r100);
        return;
    L9:
        return;
    }

    public final void showLinkAction(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnLink);
        if (r102 == null) goto L9;
        setViewVisibility(r102, r100);
        return;
    L9:
        return;
    }

    public final void showPrimaryAction(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnPrimary);
        if (r102 == null) goto L9;
        setViewVisibility(r102, r100);
        return;
    L9:
        return;
    }

    public final void showSecondaryAction(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        UDButton r102 = (UDButton) r101.findViewById(R.id.btnSecondary);
        if (r102 == null) goto L9;
        setViewVisibility(r102, r100);
        return;
    L9:
        return;
    }

    public final void showTitle(boolean r100) {
        View r101 = this.rootView;
        if (r101 == null) goto L8;
        TextView r102 = (TextView) r101.findViewById(R.id.title);
        if (r102 == null) goto L9;
        setViewVisibility(r102, r100);
        return;
    L9:
        return;
    }

    public final void setDesc(String r100) {
        setDesc(r100);
    }

    public final void setLinkAction(String r100) {
        setLinkAction(r100);
    }

    public final void setPrimaryText(String r100) {
        setPrimaryText(r100);
    }

    public final void setSecondaryText(String r100) {
        setSecondaryText(r100);
    }

    public final void setTitle(String r100) {
        setTitle(r100);
    }

    public UDEmptyState(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    private final void setViewVisibility(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 0;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 8;
        goto L5
    }

    public UDEmptyState(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, R.style.chameleonv1_UDEmptyState);
    }

    private final void init(AttributeSet r100, int r101, int r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.chameleonv1_ud_layout_emptystate, this, true);
        this.rootView = r103;
        if (r103 == null) goto L5;
        TextView r104 = (TextView) r103.findViewById(R.id.desc);
    L6:
        if (r104 == null) goto L9;
        r104.setHighlightColor(0);
    L9:
        View r105 = this.rootView;
        if (r105 == null) goto L14;
        UDButton r106 = (UDButton) r105.findViewById(R.id.btnPrimary);
        if (r106 == null) goto L14;
        r106.addOnLayoutChangeListener(new oz7.a(this));
    L14:
        View r107 = this.rootView;
        if (r107 == null) goto L19;
        UDButton r108 = (UDButton) r107.findViewById(R.id.btnSecondary);
        if (r108 == null) goto L19;
        r108.addOnLayoutChangeListener(new oz7.b(this));
    L19:
        TypedArray r109 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_empty_desc, R.attr.ud_empty_descTextColor, R.attr.ud_empty_imageRes, R.attr.ud_empty_imageSize, R.attr.ud_empty_linkText, R.attr.ud_empty_operableTextColor, R.attr.ud_empty_primaryText, R.attr.ud_empty_primaryTextSize, R.attr.ud_empty_secondaryText, R.attr.ud_empty_secondaryTextSize, R.attr.ud_empty_title, R.attr.ud_empty_titleTextColor}, r101, r102);
        initProperty(r109);
        initStyle(r109);
        r109.recycle();
        return;
    L5:
        r104 = null;
        goto L6
    }

    public UDEmptyState(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        init(r101, r102, r103);
    }

    private static final void init$lambda$1(UDEmptyState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        View r110 = r100.rootView;
        if (r110 == null) goto L12;
        UDButton r111 = (UDButton) r110.findViewById(R.id.btnPrimary);
        if (r111 == null) goto L13;
        View r112 = r100.rootView;
        if (r112 == null) goto L14;
        UDButton r113 = (UDButton) r112.findViewById(R.id.btnSecondary);
        if (r113 == null) goto L15;
        oz7.c.a(r113, r111);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private static final void init$lambda$3(UDEmptyState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        View r110 = r100.rootView;
        if (r110 == null) goto L12;
        UDButton r111 = (UDButton) r110.findViewById(R.id.btnSecondary);
        if (r111 == null) goto L13;
        View r112 = r100.rootView;
        if (r112 == null) goto L14;
        UDButton r113 = (UDButton) r112.findViewById(R.id.btnPrimary);
        if (r113 == null) goto L15;
        oz7.c.a(r113, r111);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}

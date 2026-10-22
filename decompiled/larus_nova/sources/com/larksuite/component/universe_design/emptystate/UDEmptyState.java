package com.larksuite.component.universe_design.emptystate;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.emptystate.databinding.UdLayoutEmptystateBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 X2\u00020\u0001:\u0003WXYB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0015\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010)\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u0010\u0010-\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010-\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020(J\u000e\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u00109\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010:\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010;\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010<\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u0010=\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u0010>\u001a\u00020(J\u000e\u0010?\u001a\u00020\u00112\u0006\u00107\u001a\u000208J\u0010\u0010@\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010@\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010A\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010B\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u0010C\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u0010D\u001a\u00020(J\u0010\u0010E\u001a\u00020\u00112\b\u0010F\u001a\u0004\u0018\u00010GJ\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020JJ\u0018\u0010M\u001a\u00020\u00112\u0006\u0010L\u001a\u00020J2\u0006\u0010N\u001a\u00020(H\u0002J\u0010\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\nH\u0002J\u0010\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010U\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010V\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "viewBinding", "Lcom/larksuite/component/universe_design/emptystate/databinding/UdLayoutEmptystateBinding;", "init", "", "initProperty", "ta", "Landroid/content/res/TypedArray;", "initStyle", "setImageRes", "resId", "(Ljava/lang/Integer;)V", "setImageSize", "dp", "", "(Ljava/lang/Float;)V", "setImageSizeResource", com.alipay.sdk.m.x.d.f25925o, "text", "", "", "setTitleTextAppearance", "textAppearanceRes", "setImageBottomMargin", GXTemplateKey.FLEXBOX_MARGIN, "showTitle", "isShow", "", "setDesc", "setDescTextAppearance", "setTitleBottomMargin", "showDescription", "setPrimaryText", "setPrimaryClickListener", "listener", "Landroid/view/View$OnClickListener;", "setPrimaryActionTopMargin", "showPrimaryAction", "setPrimaryActionEnabled", "enabled", "isPrimaryActionEnabled", "setPrimaryActionStyle", "style", "Lcom/larksuite/component/universe_design/emptystate/UDEmptyState$ButtonStyle;", "setSecondaryText", "setSecondaryClickListener", "setSecondaryActionTopMargin", "showSecondaryAction", "setSecondaryActionEnabled", "isSecondaryActionEnabled", "setSecondaryActionStyle", "setLinkAction", "setOnLinkActionClickListener", "showLinkAction", "setLinkActionEnabled", "isLinkActionEnabled", "setContainer", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", BasicTestActionHandler.TEST_ACTION_RESET, "getImageView", "Landroid/view/View;", "setImageView", "view", "setViewVisibility", "isVisible", "setImageSizeInternal", GXTemplateKey.GAIAX_PX, "setButtonPrimaryTextLinkStyle", "button", "Lcom/larksuite/component/universe_design/button/UDButton;", "setButtonSecondaryTextLinkStyle", "setButtonPrimaryButtonStyle", "setButtonSecondaryButtonStyle", "OperableTextSpan", "Companion", "ButtonStyle", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDEmptyState extends LinearLayout {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final float IMAGE_LARGE = 0.0f;
    private static final float IMAGE_SMALL = 0.0f;
    private final UdLayoutEmptystateBinding viewBinding;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/UDEmptyState$ButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "TEXT_LINK", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        public static final ButtonStyle BUTTON = null;
        public static final ButtonStyle TEXT_LINK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ButtonStyle[] f284997a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284998b = null;

        public static EnumEntries<ButtonStyle> getEntries() {
            return f284998b;
        }

        static {
            ButtonStyle r100 = new ButtonStyle("BUTTON", 0);
            BUTTON = r100;
            ButtonStyle r101 = new ButtonStyle("TEXT_LINK", 1);
            TEXT_LINK = r101;
            ButtonStyle[] r102 = {r100, r101};
            f284997a = r102;
            f284998b = EnumEntriesKt.enumEntries(r102);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) f284997a.clone();
        }

        public static ButtonStyle valueOf(String r100) {
            return (ButtonStyle) r27.a.a(ButtonStyle.class, r100);
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

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f284999b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f285000a;

        public static final class a {
        }

        static {
        }

        public b(View.OnClickListener r100) {
            this.f285000a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            View.OnClickListener r101 = this.f285000a;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "drawState");
            super.updateDrawState(r100);
            r100.setColor(f284999b);
            r100.setUnderlineText(false);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285001a = null;

        static {
            int[] r100 = new int[ButtonStyle.values().length];
            r100[ButtonStyle.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ButtonStyle.TEXT_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f285001a = r100;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDEmptyState f285002a;

        public d(UDEmptyState r100) {
            this.f285002a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            v08.a.a(UDEmptyState.access$getViewBinding$p(this.f285002a).f285020d, UDEmptyState.access$getViewBinding$p(this.f285002a).f285019c);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDEmptyState f285003a;

        public e(UDEmptyState r100) {
            this.f285003a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            v08.a.a(UDEmptyState.access$getViewBinding$p(this.f285003a).f285019c, UDEmptyState.access$getViewBinding$p(this.f285003a).f285020d);
        }
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
        $stable = 8;
        IMAGE_LARGE = 245.0f;
        IMAGE_SMALL = 100.0f;
    }

    public final View getImageView() {
        return this.viewBinding.f285022f;
    }

    public final boolean isLinkActionEnabled() {
        return this.viewBinding.f285018b.isEnabled();
    }

    public final boolean isPrimaryActionEnabled() {
        return this.viewBinding.f285019c.isEnabled();
    }

    public final boolean isSecondaryActionEnabled() {
        return this.viewBinding.f285020d.isEnabled();
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

    public static final /* synthetic */ UdLayoutEmptystateBinding access$getViewBinding$p(UDEmptyState r100) {
        return r100.viewBinding;
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
        int r101 = r100.getDimensionPixelSize(3, (int) h18.d.a(getContext(), IMAGE_SMALL));
        this.viewBinding.f285022f.getLayoutParams().width = r101;
        this.viewBinding.f285022f.getLayoutParams().height = r101;
        this.viewBinding.f285019c.setTextSize(0, r100.getDimensionPixelSize(7, 14));
        this.viewBinding.f285020d.setTextSize(0, r100.getDimensionPixelSize(9, 14));
        this.viewBinding.f285023g.setTextColor(r100.getColor(11, UDColorUtils.getColor(getContext(), R.color.text_title)));
        this.viewBinding.f285021e.setTextColor(r100.getColor(1, UDColorUtils.getColor(getContext(), R.color.text_caption)));
        int r102 = b.f284999b;
        b.f284999b = r100.getInt(5, UDColorUtils.getColor(getContext(), R.color.primary_fill_default));
    }

    private final void setButtonPrimaryButtonStyle(UDButton r100) {
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_blue_bg));
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.static_white));
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
    }

    private final void setButtonPrimaryTextLinkStyle(UDButton r100) {
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_text_primary_bg));
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_blue_text));
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
    }

    private final void setButtonSecondaryButtonStyle(UDButton r100) {
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_text_secondary_bg));
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_grey_text));
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.line_border_component));
    }

    private final void setButtonSecondaryTextLinkStyle(UDButton r100) {
        r100.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_text_secondary_bg));
        r100.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.ud_button_grey_text));
        r100.setStrokeColor(AppCompatResources.getColorStateList(getContext(), android.R.color.transparent));
    }

    private final void setImageSizeInternal(int r100) {
        this.viewBinding.f285022f.getLayoutParams().width = r100;
        this.viewBinding.f285022f.getLayoutParams().height = r100;
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
        this.viewBinding.f285021e.setText(r100);
        TextView r101 = this.viewBinding.f285021e;
        int r102 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = 8;
    L11:
        r101.setVisibility(r102);
        this.viewBinding.f285021e.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void setDescTextAppearance(int r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.viewBinding.f285021e.setTextAppearance(r100);
        return;
    L5:
        this.viewBinding.f285021e.setTextAppearance(getContext(), r100);
    }

    public final void setImageBottomMargin(int r100) {
        ViewGroup.LayoutParams r101 = this.viewBinding.f285022f.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = r100;
        this.viewBinding.f285022f.requestLayout();
    }

    public final void setImageRes(Integer r100) {
        View r101 = getImageView();
        if (r100 == null) goto L9;
        if (r100.intValue() != 0) goto L9;
        r101.setVisibility(8);
        return;
    L9:
        if ((r101 instanceof ImageView) == false) goto L17;
        ImageView r102 = (ImageView) r101;
        if (r100 == null) goto L13;
        int r103 = r100.intValue();
    L14:
        r102.setImageResource(r103);
        r102.setVisibility(0);
        return;
    L13:
        r103 = 0;
        goto L14
    }

    public final void setImageSize(Float r100) {
        if (r100 == null) goto L5;
        r100.floatValue();
        setImageSizeInternal((int) h18.d.a(getContext(), r100.floatValue()));
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
        this.viewBinding.f285018b.setText(r100);
        UDButton r101 = this.viewBinding.f285018b;
        int r102 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = 8;
    L11:
        r101.setVisibility(r102);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void setLinkActionEnabled(boolean r100) {
        this.viewBinding.f285018b.setEnabled(r100);
    }

    public final void setOnLinkActionClickListener(View.OnClickListener r100) {
        this.viewBinding.f285018b.setOnClickListener(r100);
    }

    public final void setPrimaryActionEnabled(boolean r100) {
        this.viewBinding.f285019c.setEnabled(r100);
    }

    public final void setPrimaryActionStyle(ButtonStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = c.f285001a[r100.ordinal()];
        if (r101 != 1) goto L5;
        setButtonPrimaryButtonStyle(this.viewBinding.f285019c);
        return;
    L5:
        if (r101 != 2) goto L8;
        setButtonPrimaryTextLinkStyle(this.viewBinding.f285019c);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setPrimaryActionTopMargin(int r100) {
        ViewGroup.LayoutParams r101 = this.viewBinding.f285019c.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r101).topMargin = r100;
        this.viewBinding.f285019c.requestLayout();
    }

    public final void setPrimaryClickListener(View.OnClickListener r100) {
        this.viewBinding.f285019c.setOnClickListener(r100);
    }

    public final void setPrimaryText(CharSequence r100) {
        this.viewBinding.f285019c.setText(r100);
        UDButton r101 = this.viewBinding.f285019c;
        CharSequence r102 = r101.getText();
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r103 = 8;
    L11:
        r101.setVisibility(r103);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final void setSecondaryActionEnabled(boolean r100) {
        this.viewBinding.f285020d.setEnabled(r100);
    }

    public final void setSecondaryActionStyle(ButtonStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = c.f285001a[r100.ordinal()];
        if (r101 != 1) goto L5;
        setButtonSecondaryButtonStyle(this.viewBinding.f285020d);
        return;
    L5:
        if (r101 != 2) goto L8;
        setButtonSecondaryTextLinkStyle(this.viewBinding.f285020d);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setSecondaryActionTopMargin(int r100) {
        ViewGroup.LayoutParams r101 = this.viewBinding.f285020d.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 == null) goto L9;
        r102.topMargin = r100;
        this.viewBinding.f285020d.requestLayout();
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setSecondaryClickListener(View.OnClickListener r100) {
        this.viewBinding.f285020d.setOnClickListener(r100);
    }

    public final void setSecondaryText(CharSequence r100) {
        this.viewBinding.f285020d.setText(r100);
        UDButton r101 = this.viewBinding.f285020d;
        CharSequence r102 = r101.getText();
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r103 = 8;
    L11:
        r101.setVisibility(r103);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final void setTitle(CharSequence r100) {
        this.viewBinding.f285023g.setText(r100);
        TextView r101 = this.viewBinding.f285023g;
        int r102 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = 8;
    L11:
        r101.setVisibility(r102);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void setTitleBottomMargin(int r100) {
        ViewGroup.LayoutParams r101 = this.viewBinding.f285023g.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = r100;
        this.viewBinding.f285023g.requestLayout();
    }

    public final void setTitleTextAppearance(int r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.viewBinding.f285023g.setTextAppearance(r100);
        return;
    L5:
        this.viewBinding.f285023g.setTextAppearance(getContext(), r100);
    }

    public final void showDescription(boolean r100) {
        setViewVisibility(this.viewBinding.f285021e, r100);
    }

    public final void showLinkAction(boolean r100) {
        setViewVisibility(this.viewBinding.f285018b, r100);
    }

    public final void showPrimaryAction(boolean r100) {
        setViewVisibility(this.viewBinding.f285019c, r100);
    }

    public final void showSecondaryAction(boolean r100) {
        setViewVisibility(this.viewBinding.f285020d, r100);
    }

    public final void showTitle(boolean r100) {
        setViewVisibility(this.viewBinding.f285023g, r100);
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
        this(r100, r101, r102, R.style.UDEmptyState);
    }

    private final void init(AttributeSet r100, int r101, int r102) {
        this.viewBinding.f285021e.setHighlightColor(0);
        this.viewBinding.f285019c.addOnLayoutChangeListener(new d(this));
        this.viewBinding.f285020d.addOnLayoutChangeListener(new e(this));
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_empty_desc, R.attr.ud_empty_descTextColor, R.attr.ud_empty_imageRes, R.attr.ud_empty_imageSize, R.attr.ud_empty_linkText, R.attr.ud_empty_operableTextColor, R.attr.ud_empty_primaryText, R.attr.ud_empty_primaryTextSize, R.attr.ud_empty_secondaryText, R.attr.ud_empty_secondaryTextSize, R.attr.ud_empty_title, R.attr.ud_empty_titleTextColor}, r101, r102);
        initProperty(r103);
        initStyle(r103);
        r103.recycle();
    }

    public UDEmptyState(Context r110, AttributeSet r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112, r113);
        View r114 = LayoutInflater.from(getContext()).inflate(R.layout.ud_layout_emptystate, this, false);
        addView(r114);
        int r100 = R.id.btnLink;
        UDButton r101 = (UDButton) ViewBindings.findChildViewById(r114, R.id.btnLink);
        if (r101 == null) goto L17;
        r100 = R.id.btnPrimary;
        UDButton r102 = (UDButton) ViewBindings.findChildViewById(r114, R.id.btnPrimary);
        if (r102 == null) goto L17;
        r100 = R.id.btnSecondary;
        UDButton r103 = (UDButton) ViewBindings.findChildViewById(r114, R.id.btnSecondary);
        if (r103 == null) goto L17;
        r100 = R.id.desc;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r114, R.id.desc);
        if (r104 == null) goto L17;
        r100 = R.id.image;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r114, R.id.image);
        if (r105 == null) goto L17;
        r100 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r114, R.id.title);
        if (r106 == null) goto L17;
        this.viewBinding = new UdLayoutEmptystateBinding((LinearLayout) r114, r101, r102, r103, r104, r105, r106);
        init(r111, r112, r113);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r114.getResources().getResourceName(r100)));
    }
}

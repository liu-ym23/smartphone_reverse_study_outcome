package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001[B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\n¢\u0006\u0004\bY\u0010ZJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R.\u0010>\u001a\u0004\u0018\u00010\u00022\b\u00107\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010B\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00101\u001a\u0004\b@\u00103\"\u0004\bA\u00105R.\u0010F\u001a\u0004\u0018\u00010\u00022\b\u00107\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00109\u001a\u0004\bD\u0010;\"\u0004\bE\u0010=R\u0014\u0010H\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u00103R\u0014\u0010J\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u00103R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u001fR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001fR\u0011\u0010Q\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bR\u0010P¨\u0006\\"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "", "title", "", "setCenterText", "setCenterSubText", "Landroid/view/View;", "view", "setCenterView", "", "resId", "b", "Landroid/view/View;", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "(Landroid/view/View;)V", "mCenterView", "c", "getMLeftLastView", "setMLeftLastView", "mLeftLastView", "d", "getMRightLastView", "setMRightLastView", "mRightLastView", "", "e", "Ljava/util/List;", "getMLeftViewList", "()Ljava/util/List;", "setMLeftViewList", "(Ljava/util/List;)V", "mLeftViewList", "f", "getMRightViewList", "setMRightViewList", "mRightViewList", "Lcom/obric/oui/button/OButton;", ce.f26391f, "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "value", RXScreenCaptureService.KEY_INDEX, "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", ce.f26395j, "getMSubTitleView", "setMSubTitleView", "mSubTitleView", ce.f26396k, "getSubTitleText", "setSubTitleText", "subTitleText", "getSubtitleViewOrCreate", "subtitleViewOrCreate", "getTitleViewOrCreate", "titleViewOrCreate", "getRightViewListOrCreate", "rightViewListOrCreate", "getLeftViewListOrCreate", "leftViewListOrCreate", "getLeftViewCount", "()I", "leftViewCount", "getRightViewCount", "rightViewCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCTitleBar extends RelativeLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f403671m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f403672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f403673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f403674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f403675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f403676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<View> f403677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OButton f403678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f403679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f403680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f403681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f403682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final uma.a f403683l;

    public static final class a {
    }

    static {
    }

    public OCTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OCTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.f403676e != null) goto L5;
        this.f403676e = new ArrayList();
    L5:
        List<View> r100 = this.f403676e;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.f403677f != null) goto L5;
        this.f403677f = new ArrayList();
    L5:
        List<View> r100 = this.f403677f;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r100 = this.f403681j;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        OBaseTextView r101 = new OBaseTextView(getContext(), null, 6, 0);
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setTextAppearance(R.style.Label_M);
        r101.setTextColor(r101.getContext().getResources().getColor(R.color.oui_text_3b));
        this.f403681j = r101;
        ViewGroup.LayoutParams r102 = generateDefaultLayoutParams();
        if (r102 == null) goto L11;
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
        r103.addRule(14);
        r103.topMargin = d.n(this, 30);
        addView(this.f403681j, r103);
        TextView r104 = this.f403681j;
        Intrinsics.checkNotNull(r104);
        return r104;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final TextView getTitleViewOrCreate() {
        View r100 = this.f403673b;
        if (r100 == null) goto L8;
        TextView r101 = this.f403679h;
        if (r100 != r101) goto L8;
        Intrinsics.checkNotNull(r101);
        return r101;
    L8:
        if (this.f403679h != null) goto L10;
        OBaseTextView r102 = new OBaseTextView(getContext(), null, 6, 0);
        r102.setMaxLines(1);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        r102.setTextAppearance(R.style.Title_Title_M_Thick);
        r102.setTextColor(r102.getContext().getResources().getColor(R.color.oui_text_1));
        this.f403679h = r102;
    L10:
        View r103 = this.f403673b;
        if (r103 == null) goto L14;
        if (r103 == null) goto L14;
        removeView(r103);
        this.f403673b = null;
    L14:
        View r104 = this.f403679h;
        ViewGroup.LayoutParams r105 = generateDefaultLayoutParams();
        if (r105 == null) goto L19;
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r105;
        r106.addRule(13);
        addView(r104, r106);
        TextView r107 = this.f403679h;
        this.f403673b = r107;
        Intrinsics.checkNotNull(r107);
        return r107;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final int getLeftViewCount() {
        return b(this.f403676e);
    }

    public final int getRightViewCount() {
        return b(this.f403677f);
    }

    public final View getMCenterView() {
        return this.f403673b;
    }

    public final OButton getMLeftActionBack() {
        return this.f403678g;
    }

    public final View getMLeftLastView() {
        return this.f403674c;
    }

    public final List<View> getMLeftViewList() {
        return this.f403676e;
    }

    public final View getMRightLastView() {
        return this.f403675d;
    }

    public final List<View> getMRightViewList() {
        return this.f403677f;
    }

    public final TextView getMSubTitleView() {
        return this.f403681j;
    }

    public final TextView getMTitleView() {
        return this.f403679h;
    }

    public final String getSubTitleText() {
        return this.f403682k;
    }

    public final String getTitleText() {
        return this.f403680i;
    }

    public static int b(List r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.size() <= 0) goto L18;
        int r102 = r100.size();
        int r103 = 0;
    L7:
        if (r101 >= r102) goto L13;
        int r104 = r101 + 1;
        if (((View) ListProtector.get(r100, r101)).getVisibility() == 8) goto L11;
        r103 = r103 + 1;
    L11:
        r101 = r104;
        goto L7
    L13:
        return r103;
    L18:
        return 0;
    }

    private final void setCenterSubText(String r100) {
        getSubtitleViewOrCreate().setText(r100);
        TextView r101 = this.f403679h;
        if (r101 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L21;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L20;
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
        r103.removeRule(13);
        r103.addRule(14);
        r103.topMargin = d.n(this, 9);
        if (getContext().getResources().getConfiguration().fontScale <= 1.0f) goto L22;
        r103.topMargin = d.n(this, 6);
        TextView r104 = getMSubTitleView();
        if (r104 == null) goto L25;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L18;
        int r106 = d.n(this, 31);
        ((RelativeLayout.LayoutParams) r105).topMargin = r106;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        return;
    L22:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void setCenterText(int r100) {
        setCenterText(getContext().getString(r100));
    }

    public final void setCenterView(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        RelativeLayout.LayoutParams r101 = a(r100, true);
        if (Intrinsics.areEqual(this.f403673b, r100) == true) goto L12;
        View r102 = this.f403673b;
        if (r102 == null) goto L10;
        removeView(r102);
        this.f403673b = null;
    L10:
        this.f403673b = r100;
        addView(r100, r101);
        return;
    }

    public final void setMCenterView(View r100) {
        this.f403673b = r100;
    }

    public final void setMLeftActionBack(OButton r100) {
        this.f403678g = r100;
    }

    public final void setMLeftLastView(View r100) {
        this.f403674c = r100;
    }

    public final void setMLeftViewList(List<View> r100) {
        this.f403676e = r100;
    }

    public final void setMRightLastView(View r100) {
        this.f403675d = r100;
    }

    public final void setMRightViewList(List<View> r100) {
        this.f403677f = r100;
    }

    public final void setMSubTitleView(TextView r100) {
        this.f403681j = r100;
    }

    public final void setMTitleView(TextView r100) {
        this.f403679h = r100;
    }

    public final void setSubTitleText(String r100) {
        this.f403682k = r100;
        setCenterSubText(r100);
    }

    public final void setTitleText(String r100) {
        this.f403680i = r100;
        setCenterText(r100);
    }

    private final void setCenterText(String r100) {
        getTitleViewOrCreate().setText(r100);
    }

    public final RelativeLayout.LayoutParams a(View r100, boolean r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L6;
        return (RelativeLayout.LayoutParams) r102;
    L6:
        if (r101 == false) goto L12;
        ViewGroup.LayoutParams r103 = generateDefaultLayoutParams();
        if (r103 == null) goto L11;
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r103;
        r104.addRule(13);
        Object r105 = r104;
    L13:
        if (r105 == null) goto L17;
        return (RelativeLayout.LayoutParams) r105;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L12:
        r105 = generateDefaultLayoutParams();
        goto L13
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) getContext().getResources().getDimension(R.dimen.oui_h_title_bar_window), 1073741824));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, uma.a] */
    public OCTitleBar(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        ?? r102 = new uma.a(this);
        this.f403683l = r102;
        if (r101 == null) goto L44;
        TypedArray r103 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_autoAdjustTitleSpace, R.attr.oui_sub_title_text, R.attr.oui_title_des_text, R.attr.oui_title_pos, R.attr.oui_title_text, R.attr.oui_useBackIcon}, 0, 0);
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r111 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r103.getInt(3, com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue())];
        String r112 = r103.getString(4);
        if (r112 == null) goto L8;
        setCenterText(r112);
    L8:
        if (r103.getBoolean(5, true) == false) goto L39;
        Context r113 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r114 = LayoutInflater.from(r113).inflate(R.layout.o_widget_titlebar_trans_icon_button, this, false);
        if (r114 == null) goto L38;
        OButton r115 = (OButton) r114;
        r115.setButtonSourceBitmap(R.drawable.o_ic_titlebar_back);
        setMLeftActionBack(r115);
        Intrinsics.checkNotNullParameter(r115, "view");
        RelativeLayout.LayoutParams r104 = a(r115, false);
        int r105 = getLeftViewCount();
        Intrinsics.checkNotNullParameter(r115, "view");
        Intrinsics.checkNotNullParameter(r104, "layoutParams");
        r104.alignWithParent = true;
        r104.leftMargin = 0;
        r115.setId(View.generateViewId());
        if (this.f403674c != null) goto L14;
        r104.addRule(9);
        r105 = 0;
    L31:
        r104.addRule(15);
        List<View> r106 = this.f403676e;
        if (r106 == null) goto L35;
        Intrinsics.checkNotNull(r106);
        if (r105 == r106.size()) goto L35;
    L36:
        ListProtector.add(getLeftViewListOrCreate(), r105, r115);
        addView(r115, r104);
    L35:
        this.f403674c = r115;
        goto L36
    L14:
        if (r105 < 0) goto L30;
        List<View> r107 = this.f403676e;
        Intrinsics.checkNotNull(r107);
        if (r105 >= r107.size()) goto L30;
        if (r105 != 0) goto L25;
        r104.addRule(9);
        List<View> r108 = this.f403676e;
        Intrinsics.checkNotNull(r108);
        ViewGroup.LayoutParams r109 = ((View) ListProtector.get(r108, r105)).getLayoutParams();
        if (r109 == null) goto L24;
        RelativeLayout.LayoutParams r116 = (RelativeLayout.LayoutParams) r109;
        r116.removeRule(9);
        r116.addRule(1, r115.getId());
        goto L31
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L25:
        List<View> r117 = this.f403676e;
        Intrinsics.checkNotNull(r117);
        View r118 = (View) ListProtector.get(r117, r105 - 1);
        List<View> r119 = this.f403676e;
        Intrinsics.checkNotNull(r119);
        View r120 = (View) ListProtector.get(r119, r105);
        r104.addRule(1, r118.getId());
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L29;
        ((RelativeLayout.LayoutParams) r121).addRule(1, r115.getId());
        goto L31
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L30:
        List<View> r122 = this.f403676e;
        Intrinsics.checkNotNull(r122);
        r105 = r122.size();
        View r123 = this.f403674c;
        Intrinsics.checkNotNull(r123);
        r104.addRule(1, r123.getId());
        goto L31
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L39:
        String r124 = r103.getString(1);
        if (r124 == null) goto L42;
        setCenterSubText(r124);
    L42:
        this.f403672a = r103.getBoolean(0, true);
        int r125 = (int) getContext().getResources().getDimension(R.dimen.oui_p_title_bar_default);
        setPadding(r125, 0, r125, 0);
    L44:
        if (this.f403672a == false) goto L52;
        getViewTreeObserver().addOnGlobalLayoutListener(r102);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        b.c("OCTitleBar", "addGlobalLayoutListener: ", e);
        return;
    }

    public /* synthetic */ OCTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

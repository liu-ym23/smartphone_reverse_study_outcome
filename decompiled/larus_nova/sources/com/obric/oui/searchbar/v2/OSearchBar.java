package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.obric.oui.color.h0;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.p;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;
import vma.i;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B\u001d\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006R\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00104\u001a\u00020)8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/g;", "", "", "updateStateInternal", "", "enabled", "setEnabled", "Landroid/view/View;", "view", "setBackdropTarget", "", "text", "setText", "", "getText", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "getEllipsize", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "getPrefixView", "getPostfixView", "setPrefixView", "setPostfixView", "show", "setCanShowClear", "Lcom/obric/oui/forms/OEditText;", RXScreenCaptureService.KEY_INDEX, "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "inputView", "", "Lcom/obric/oui/common/style/q;", "shadowsNormal", "Ljava/util/List;", "shadowsResting", "", "bgColor", "I", "bgColorResting", "enabledMaterial", "Z", "s", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "currentTheme", "isBackdropView", "()Z", "setBackdropView", "(Z)V", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSearchBar extends OUIFrameLayout implements g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f402614t = 0;
    private int bgColor;
    private int bgColorResting;
    private boolean enabledMaterial;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OUILinearLayout f402615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OEditText f402616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f402617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f402618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f402619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f402620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f402621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f402622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c[] f402623p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c[] f402624q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f402625r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f402626s;
    private List<q> shadowsNormal;
    private List<q> shadowsResting;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "", "RESTING", "ACTIVE", "VALUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
        public static final enum SearchBarState extends Enum<SearchBarState> {
            public static final SearchBarState ACTIVE = null;
            public static final SearchBarState RESTING = null;
            public static final SearchBarState VALUE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ SearchBarState[] f402627a = null;

            public static SearchBarState valueOf(String r100) {
                return (SearchBarState) r27.a.a(SearchBarState.class, r100);
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) f402627a.clone();
            }

            static {
                SearchBarState r100 = new SearchBarState("RESTING", 0);
                RESTING = r100;
                SearchBarState r101 = new SearchBarState("ACTIVE", 1);
                ACTIVE = r101;
                SearchBarState r102 = new SearchBarState("VALUE", 2);
                VALUE = r102;
                f402627a = new SearchBarState[]{r100, r101, r102};
            }

            public SearchBarState(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402628a = null;

        static {
            int[] r100 = new int[Companion.SearchBarState.values().length];
            r100[Companion.SearchBarState.RESTING.ordinal()] = 1;
            r100[Companion.SearchBarState.ACTIVE.ordinal()] = 2;
            r100[Companion.SearchBarState.VALUE.ordinal()] = 3;
            f402628a = r100;
        }
    }

    static {
    }

    public final void setBackdropView(boolean r100) {
    }

    private final void updateStateInternal() {
        if (this.f402616i.hasFocus() == false) goto L5;
        Companion.SearchBarState r100 = Companion.SearchBarState.ACTIVE;
    L15:
        int r101 = a.f402628a[r100.ordinal()];
        int r102 = 2;
        OUILinearLayout r103 = null;
        if (r101 == 1) goto L36;
        if (r101 == 2) goto L29;
        if (r101 != 3) goto L43;
        if (this.enabledMaterial == true) goto L27;
        OUILinearLayout r104 = this.f402615h;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r104 = null;
    L26:
        r104.setBackgroundColor(this.bgColor);
    L27:
        this.f402617j.setSelected(true);
        g(this, r100);
    L43:
        if (this.enabledMaterial == true) goto L46;
        return;
    L46:
        if (r100 != Companion.SearchBarState.RESTING) goto L50;
        c[] r105 = this.f402624q;
        if (r105 != null) goto L51;
        r105 = this.f402623p;
    L51:
        if (r105 == null) goto L63;
        int r106 = this.f402625r;
        if (r106 == (-1)) goto L56;
        r102 = r106;
    L56:
        OUILinearLayout r107 = this.f402615h;
        if (r107 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L60:
        p.d(r103, r105, false, r102, 10);
        return;
    L59:
        r103 = r107;
        goto L60
    L63:
        return;
    L50:
        r105 = this.f402623p;
        goto L51
    L29:
        if (this.enabledMaterial == true) goto L34;
        OUILinearLayout r108 = this.f402615h;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r108 = null;
    L33:
        r108.setBackgroundColor(this.bgColor);
    L34:
        this.f402617j.setSelected(true);
        g(this, r100);
        goto L43
    L36:
        if (this.enabledMaterial == true) goto L41;
        OUILinearLayout r109 = this.f402615h;
        if (r109 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r109 = null;
    L40:
        r109.setBackgroundColor(this.bgColorResting);
    L41:
        this.f402617j.setSelected(false);
        g(this, r100);
        goto L43
    L5:
        Editable r110 = this.f402616i.getText();
        if (r110 != null) goto L8;
    L11:
        boolean r111 = true;
    L12:
        if (r111 == false) goto L14;
        r100 = Companion.SearchBarState.RESTING;
        goto L15
    L14:
        r100 = Companion.SearchBarState.VALUE;
        goto L15
    L8:
        if (r110.length() == 0) goto L11;
        r111 = false;
        goto L12
    }

    public final void e() {
        int r100 = 8;
        boolean r101 = true;
        if (this.f402620m == true) goto L5;
        this.f402619l.setVisibility(8);
    L16:
        if (this.f402619l.getVisibility() != 0) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == false) goto L22;
        j.e(this.f402618k);
    L27:
        f();
        return;
    L22:
        if (this.f402618k.getChildCount() != 0) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        j.f(this.f402618k);
        goto L27
    L18:
        r102 = false;
        goto L19
    L5:
        ViewGroup r103 = this.f402619l;
        Editable r104 = this.f402616i.getText();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        r100 = 0;
    L14:
        r103.setVisibility(r100);
        goto L16
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    public final void f() {
        if (this.f402617j.getVisibility() != 0) goto L5;
        int r100 = 0;
    L6:
        boolean r101 = true;
        if (this.f402619l.getVisibility() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L18:
        int r103 = d.n(this, 0);
    L19:
        this.f402616i.setPaddingRelative(r100, 0, r103, 0);
        return;
    L12:
        if (this.f402618k.getVisibility() == 0) goto L15;
        r101 = false;
    L15:
        if (r101 == true) goto L18;
        r103 = d.n(this, 8);
        goto L19
    L9:
        r102 = false;
        goto L10
    L5:
        r100 = d.n(this, 12);
        goto L6
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f402616i.getEllipsize();
    }

    public final View getPostfixView() {
        if (this.f402618k.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        return null;
    L10:
        return this.f402618k.getChildAt(0);
    L5:
        r100 = false;
        goto L6
    }

    public final View getPrefixView() {
        if (this.f402617j.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        return null;
    L10:
        return this.f402617j.getChildAt(0);
    L5:
        r100 = false;
        goto L6
    }

    public final CharSequence getText() {
        Editable r100 = this.f402616i.getText();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getCurrentTheme() {
        return this.f402626s;
    }

    public final OEditText getInputView() {
        return this.f402616i;
    }

    public OSearchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "originContext");
        this(r100, null);
    }

    public static final /* synthetic */ void d(OSearchBar r100) {
        r100.updateStateInternal();
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        this.f402625r = r100;
        OUILinearLayout r101 = this.f402615h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r101 = null;
    L5:
        p.g(r101, r100);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f402623p = MaterialToken.parseSet(this.f402622o, !i.a(this));
        String r101 = this.f402621n;
        if (r101 == null) goto L5;
        c[] r102 = MaterialToken.parseSet(r101, !i.a(this));
    L6:
        this.f402624q = r102;
        updateStateInternal();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r100);
    }

    public final void setCanShowClear(boolean r100) {
        this.f402620m = r100;
        e();
    }

    public final void setCurrentTheme(int r100) {
        this.f402626s = r100;
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        this.f402616i.setEllipsize(r100);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        this.f402616i.setEnabled(r100);
        super.setEnabled(r100);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onFocusChangeListener");
        this.f402616i.setOnFocusChangeListener(r100);
    }

    public final void setPostfixView(View r100) {
        this.f402618k.removeAllViews();
        if (r100 != null) goto L5;
        j.e(this.f402618k);
    L6:
        f();
        return;
    L5:
        this.f402618k.addView(r100);
        j.f(this.f402618k);
        goto L6
    }

    public final void setPrefixView(View r100) {
        this.f402617j.removeAllViews();
        if (r100 != null) goto L5;
        j.e(this.f402617j);
    L6:
        f();
        return;
    L5:
        r100.setDuplicateParentStateEnabled(true);
        this.f402617j.addView(r100);
        j.f(this.f402617j);
        goto L6
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f402616i.setText(r100);
    }

    public OSearchBar(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, "originContext");
        boolean r100 = false;
        super(r110, r111, 0, 12);
        this.f402620m = true;
        this.f402625r = -1;
        FrameLayout.inflate(getContext(), R.layout.o_widget_search_bar_v2, this);
        setChangeAlphaWhenPress(false);
        if (p.b(this) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.enabledMaterial = r101;
        OUILinearLayout r102 = (OUILinearLayout) findViewById(R.id.searchbar_container);
        this.f402615h = r102;
        OEditText r103 = (OEditText) findViewById(R.id.input_view);
        this.f402616i = r103;
        Function1<MotionEvent, Unit> r104 = new AnonymousClass1(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "action");
        r103.f400881b.f400889a = r104;
        FrameLayout r105 = (FrameLayout) findViewById(R.id.left_container);
        this.f402617j = r105;
        FrameLayout r112 = (FrameLayout) findViewById(R.id.right_container);
        this.f402618k = r112;
        ViewGroup r113 = (ViewGroup) findViewById(R.id.clear_action_container);
        this.f402619l = r113;
        ImageView r114 = (ImageView) findViewById(R.id.clear_action);
        TypedArray r106 = getContext().obtainStyledAttributes(r111, new int[]{android.R.attr.ellipsize, android.R.attr.layout_height, android.R.attr.text, android.R.attr.hint, R.attr.oui_search_actionText, R.attr.oui_search_postfixView, R.attr.oui_search_prefixView, R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorResting, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialDisabled, R.attr.oui_widgetMaterialResting, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowResting, R.attr.oui_widgetTextColor, R.attr.oui_widgetTextColorHint}, 0, 0);
        this.bgColor = r106.getColor(7, getContext().getResources().getColor(R.color.oui_searchbar_bg, null));
        this.bgColorResting = r106.getColor(8, getContext().getResources().getColor(R.color.oui_searchbar_bg_resting, null));
        getInputView().setTextColor(r106.getColorStateList(16));
        ColorStateList r115 = r106.getColorStateList(17);
        getInputView().setHintTextColor(r115);
        r114.setImageTintList(r115);
        getInputView().setHint(r106.getString(3));
        getInputView().setText(r106.getString(2));
        if (r106.hasValue(0) == false) goto L22;
        int r116 = r106.getInt(0, 0);
        if (r116 == 1) goto L20;
        if (r116 == 2) goto L19;
        if (r116 != 3) goto L15;
        TextUtils.TruncateAt r117 = TextUtils.TruncateAt.END;
    L21:
        setEllipsize(r117);
        goto L22
    L15:
        if (r116 == 4) goto L17;
        r117 = null;
        goto L21
    L17:
        r117 = TextUtils.TruncateAt.MARQUEE;
        goto L21
    L19:
        r117 = TextUtils.TruncateAt.MIDDLE;
        goto L21
    L20:
        r117 = TextUtils.TruncateAt.START;
    L22:
        int r118 = r106.getLayoutDimension(1, 0);
        if (r118 > 0) goto L25;
        b.b("OSearchBar", Intrinsics.stringPlus("searchBarHeight must be greater than 0, ", Integer.valueOf(r118)));
    L25:
        int r107 = r106.getResourceId(5, 0);
        if (r107 == 0) goto L28;
        FrameLayout.inflate(getContext(), r107, r112);
        j.f(r112);
    L28:
        int r108 = r106.getResourceId(6, R.layout.o_widget_search_bar_prefix_v2);
        if (r108 == 0) goto L34;
        FrameLayout.inflate(getContext(), r108, r105);
        j.f(r105);
        if (r118 > 0) goto L33;
        b.b("OSearchBar", Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r118)));
        goto L34
    L33:
        ViewGroup.LayoutParams r109 = r105.getLayoutParams();
        r109.width = r118;
        r105.setLayoutParams(r109);
    L34:
        if (r118 > 0) goto L36;
        b.b("OSearchBar", Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r118)));
    L37:
        r113.setOnClickListener(new com.obric.oui.searchbar.v2.a(this));
        Context r119 = getContext();
        List<q> r120 = l.b(r119, r106, 14);
        if (r120 == null) goto L40;
        this.shadowsNormal = r120;
    L40:
        List<q> r121 = l.b(r119, r106, 15);
        if (r121 == null) goto L44;
        this.shadowsResting = r121;
    L44:
        if (this.enabledMaterial == false) goto L46;
        this.f402625r = r106.getInt(13, -1);
        this.enabledMaterial = r106.getBoolean(9, false);
    L46:
        int r122 = this.bgColor;
        if (r122 != 0) goto L50;
        boolean r123 = i.a(this);
    L57:
        if (this.enabledMaterial == false) goto L84;
        String r124 = r106.getString(10);
        this.f402622o = r124;
        if (r124 != null) goto L61;
        this.f402622o = r106.getResources().getString(R.string.oui_material_bg_floating);
    L61:
        String r125 = r106.getString(12);
        this.f402621n = r125;
        boolean r126 = !r123;
        this.f402623p = MaterialToken.parseSet(this.f402622o, r126);
        if (r125 == null) goto L64;
        c[] r127 = MaterialToken.parseSet(r125, r126);
    L65:
        this.f402624q = r127;
        if (r127 != null) goto L68;
        r127 = this.f402623p;
    L68:
        if (r127 != null) goto L70;
        Unit r128 = null;
        OUILinearLayout r129 = null;
    L82:
        if (r128 != null) goto L85;
        this.enabledMaterial = false;
    L85:
        r106.recycle();
        int r130 = this.bgColor;
        if (r130 != 0) goto L89;
        boolean r131 = i.a(this);
    L95:
        if ((!r131) == false) goto L100;
        if (r102 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r132 = r129;
    L99:
        r132.setOverridePressColor(getResources().getColor(R.color.oui_basic_fill_element_2_light));
    L104:
        if (r102 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r102 = r129;
    L106:
        r102.m1("OSearchBar");
        Function4<CharSequence, Integer, Integer, Integer, Unit> r133 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r133, "action");
        r103.f400882c.f400891a = r133;
        Function1<Boolean, Unit> r134 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r134, "action");
        r103.f400880a.f400887a = r134;
        updateStateInternal();
        f();
        return;
    L98:
        r132 = r102;
        goto L99
    L100:
        if (r102 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r135 = r129;
    L103:
        r135.setOverridePressColor(getResources().getColor(R.color.oui_basic_fill_element_2_dark));
        goto L104
    L102:
        r135 = r102;
        goto L103
    L89:
        if (this.f402626s != 2) goto L91;
    L92:
        r100 = true;
    L93:
        r131 = r100;
        goto L95
    L91:
        if (h0.b(r130) == false) goto L93;
    L70:
        r129 = null;
        setBackground(null);
        int r136 = this.f402625r;
        if (r136 != (-1)) goto L74;
        r136 = 2;
    L74:
        if (r102 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        LinearLayout r137 = null;
    L77:
        GradientDrawable r138 = new GradientDrawable();
        r138.setShape(0);
        r138.setCornerRadius(d.q(this, 99));
        r138.setColor(0);
        r137.setBackground(r138);
        if (r102 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r139 = null;
    L81:
        p.d(r139, r127, false, r136, 10);
        r128 = Unit.INSTANCE;
        goto L82
    L80:
        r139 = r102;
        goto L81
    L76:
        r137 = r102;
        goto L77
    L64:
        r127 = null;
        goto L65
    L84:
        r129 = null;
        goto L85
    L50:
        if (this.f402626s != 2) goto L52;
    L55:
        r123 = true;
        goto L57
    L52:
        if (h0.b(r122) == true) goto L55;
        r123 = false;
        goto L57
    L36:
        ViewGroup.LayoutParams r140 = r113.getLayoutParams();
        r140.width = r118;
        r113.setLayoutParams(r140);
        goto L37
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        r101 = true;
        goto L8
    }

    public static void g(OSearchBar r100, Companion.SearchBarState r101) {
        if (r100.shadowsNormal != null) goto L5;
        q r102 = q.f399591h;
        r100.c(r102, r102, false);
        return;
    L5:
        int r103 = d.n(r100, 99);
        r100.setShadowCornerRadius(r103);
        OUILinearLayout r104 = r100.f402615h;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r104 = null;
    L8:
        r104.setRadius(r103);
        if (a.f402628a[r101.ordinal()] != 1) goto L14;
        List<q> r105 = r100.shadowsResting;
        if (r105 == null) goto L13;
        Intrinsics.checkNotNull(r105);
        q r106 = (q) CollectionsKt.getOrNull(r105, 0);
        List<q> r107 = r100.shadowsResting;
        Intrinsics.checkNotNull(r107);
        r100.c(r106, (q) CollectionsKt.getOrNull(r107, 1), true);
        return;
    L13:
        q r108 = q.f399591h;
        r100.c(r108, r108, true);
        return;
    L14:
        List<q> r109 = r100.shadowsNormal;
        Intrinsics.checkNotNull(r109);
        q r110 = (q) CollectionsKt.getOrNull(r109, 0);
        List<q> r111 = r100.shadowsNormal;
        Intrinsics.checkNotNull(r111);
        r100.c(r110, (q) CollectionsKt.getOrNull(r111, 1), true);
    }
}

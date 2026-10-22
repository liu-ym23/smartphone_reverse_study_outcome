package com.ss.android.ugc.aweme.search.common.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.dmt.ui.widget.DmtEditText;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.ISearchEditFactory;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.config.ActionStyle;
import com.ss.android.ugc.aweme.search.common.config.ArrowIconStyle;
import com.ss.android.ugc.aweme.search.common.config.FrameStyle;
import com.ss.android.ugc.aweme.search.common.config.HintTextStyle;
import com.ss.android.ugc.aweme.search.common.config.ScanStyle;
import com.ss.android.ugc.aweme.search.common.config.SearchStyleConfig;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchEditHelper;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002:;B\u001d\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b8\u00109J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u001a\u0010(\u001a\u00020\u00048\u0014X\u0094\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00102\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/ECSearchEditView;", "Landroid/widget/FrameLayout;", "", "keywordText", "", "triggerType", "", "query", RemoteMessageConst.Notification.VISIBILITY, "setMaskVisibility", "Lcom/ss/android/ugc/aweme/search/common/view/ECSearchEditView$OnSearchEditViewListener;", "listener", "setOnSearchEditViewListener", "getText", "text", "setText", "len", "setSelection", "Lcom/bytedance/ies/dmt/ui/widget/DmtEditText;", "getEditView", "Landroid/view/View;", "getEditBgView", "Landroid/widget/TextView;", "getSearchTextView", "Landroid/widget/ImageView;", "getSearchIconView", "getBackIconView", "getScanIconView", "getBackIconViewV2", "getEditBgViewV2", "getScanIconViewV2", "", "getExtraLocation", "Lcom/ss/android/ugc/aweme/search/common/ISearchEditFactory;", "searchEditFactory", "setSearchEditFactory", "C", "I", "getLayoutId", "()I", "layoutId", "", "D", "Z", "getFlagText", "()Z", "setFlagText", "(Z)V", "flagText", ExifInterface.LONGITUDE_EAST, "isFirstOvalDim", "setFirstOvalDim", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OnSearchEditViewListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchEditView extends FrameLayout {
    public static final /* synthetic */ int G = 0;
    public ISearchEditFactory A;
    public String B;
    public final int C;
    public boolean D;
    public boolean E;
    public JSONObject F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnSearchEditViewListener f452341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f452342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f452343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f452344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f452345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DmtEditText f452346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintLayout f452347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f452348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f452349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f452350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f452351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f452352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RelativeLayout f452353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f452354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f452355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f452356p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f452357q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f452358r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f452359s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f452360t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImageView f452361u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SearchStyleConfig f452362v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SearchStyleConfig f452363w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SearchStyleConfig f452364x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SearchStyleConfig f452365y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ECSearchEditHelper f452366z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/ECSearchEditView$Companion;", "", "()V", "TRIGGER_TYPE_BTN", "", "TRIGGER_TYPE_IME", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/view/ECSearchEditView$OnSearchEditViewListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnSearchEditViewListener {
        boolean onBackClick();

        void onClear();

        void onQueryWordChanged(String r100);

        void onScan();

        void onScanShow(String r100);

        void onSearchBtnPredictSearch(String r100, String r101);

        void onSearchBtnSearch(String r100, String r101, int r102);
    }

    static {
        new Companion(0);
    }

    public ImageView getBackIconViewV2() {
        return null;
    }

    public View getEditBgViewV2() {
        return null;
    }

    public int[] getExtraLocation() {
        int[] r100 = new int[2];
        FrameLayout r101 = this.f452352l;
        if (r101 != null) goto L5;
    L7:
        return r100;
    L5:
        if (r101.getVisibility() != 0) goto L7;
        r101.getLocationInWindow(r100);
        r100[0] = r100[0] + (r101.getMeasuredWidth() / 2);
        r100[1] = r100[1] + (r101.getMeasuredHeight() / 2);
        goto L7
    }

    public ImageView getScanIconViewV2() {
        return null;
    }

    public final void d() {
        DmtEditText r100 = this.f452346f;
        if (r100 == null) goto L5;
        Editable r101 = r100.getText();
    L6:
        query(b(String.valueOf(r101)), 2);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public String getText() {
        DmtEditText r100 = this.f452346f;
        if (r100 == null) goto L5;
        Editable r101 = r100.getText();
    L7:
        return String.valueOf(r101);
    L5:
        r101 = null;
        goto L7
    }

    public ImageView getBackIconView() {
        return this.f452342b;
    }

    public View getEditBgView() {
        return this.f452350j;
    }

    public DmtEditText getEditView() {
        return this.f452346f;
    }

    public final boolean getFlagText() {
        return this.D;
    }

    public int getLayoutId() {
        return this.C;
    }

    public ImageView getScanIconView() {
        return this.f452349i;
    }

    public ImageView getSearchIconView() {
        return this.f452344d;
    }

    public TextView getSearchTextView() {
        return this.f452343c;
    }

    public ECSearchEditView(Context r100) {
        this(r100, null);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originText");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (StringsKt.contains$default(r100, "\u200b", false, 2, null) == false) goto L12;
        String r101 = StringsKt.replace$default(r100, "\u200b", "", false, 4, null);
        if (r101 == null) goto L10;
        return StringsKt.trim(r101).toString();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L12:
        return r100;
    }

    private final void setMaskVisibility(int r100) {
        ConstraintLayout r101 = this.f452347g;
        if (r101 != null) goto L5;
        return;
    L5:
        View r102 = r101.findViewById(R.id.ec_search_edit_mask);
        if (r102 != null) goto L8;
        return;
    L8:
        Logger.a("ECSearchEdit", "setMaskVisibility visibility = " + r100);
        r102.setVisibility(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        return super.dispatchKeyEvent(r100);
    L8:
        e = move-exception;
        Logger.b("ECSearchEditView", "Catch dispatchKeyEvent IndexOutOfBoundsException: " + e.getMessage());
        return true;
    L5:
        th = move-exception;
        Logger.b("ECSearchEditView", "Catch dispatchKeyEvent Throwable: " + th.getMessage());
        return true;
    }

    public final void e(boolean r100) {
        ViewGroup.LayoutParams r101 = null;
        if (r100 == false) goto L50;
        View r102 = this.f452351k;
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        ITradeSearchHostService r103 = TradeSearch.c(TradeSearch.f453393a);
        if (r103 == null) goto L10;
        ITradeSearchAwemeHostService r104 = r103.getITradeSearchAwemeHostService();
    L12:
        if (r104 == null) goto L14;
        boolean r105 = r104.banOvalBlur();
    L15:
        if (r105 == false) goto L19;
        View r106 = this.f452354n;
        if (r106 == null) goto L28;
        r106.setVisibility(8);
    L28:
        View r107 = this.f452350j;
        if (r107 == null) goto L31;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L33:
        if ((r108 instanceof ConstraintLayout.LayoutParams) == false) goto L36;
        r101 = r108;
    L36:
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r101;
        if (r109 == null) goto L39;
        ((ViewGroup.MarginLayoutParams) r109).height = DimenExtensionsKt.b(34);
    L39:
        if (r109 == null) goto L41;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = DimenExtensionsKt.b(1);
    L41:
        if (r109 == null) goto L43;
        ((ViewGroup.MarginLayoutParams) r109).bottomMargin = DimenExtensionsKt.b(1);
    L43:
        if (r109 == null) goto L45;
        ((ViewGroup.MarginLayoutParams) r109).leftMargin = DimenExtensionsKt.b(9) + 1;
    L45:
        if (r109 == null) goto L47;
        ((ViewGroup.MarginLayoutParams) r109).rightMargin = DimenExtensionsKt.b(1) + 1;
    L47:
        View r110 = this.f452350j;
        if (r110 == null) goto L79;
        r110.setLayoutParams(r109);
        return;
    L79:
        return;
    L31:
        r108 = null;
        goto L33
    L19:
        View r111 = this.f452354n;
        if (r111 == null) goto L23;
        r111.setVisibility(0);
    L23:
        if (this.E == false) goto L28;
        this.E = false;
        View r112 = this.f452354n;
        if (r112 == null) goto L28;
        r112.post(new ECSearchEditView$allOvalDim$1(this));
        goto L28
    L14:
        r105 = true;
        goto L15
    L10:
        r104 = null;
        goto L12
    L50:
        View r113 = this.f452351k;
        if (r113 == null) goto L53;
        r113.setVisibility(8);
    L53:
        View r114 = this.f452354n;
        if (r114 == null) goto L56;
        r114.setVisibility(8);
    L56:
        View r115 = this.f452350j;
        if (r115 == null) goto L59;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
    L61:
        if ((r116 instanceof ConstraintLayout.LayoutParams) == false) goto L64;
        r101 = r116;
    L64:
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r101;
        if (r117 == null) goto L67;
        ((ViewGroup.MarginLayoutParams) r117).height = DimenExtensionsKt.b(36);
    L67:
        if (r117 == null) goto L69;
        ((ViewGroup.MarginLayoutParams) r117).topMargin = 0;
    L69:
        if (r117 == null) goto L71;
        ((ViewGroup.MarginLayoutParams) r117).bottomMargin = 0;
    L71:
        if (r117 == null) goto L73;
        ((ViewGroup.MarginLayoutParams) r117).leftMargin = DimenExtensionsKt.b(8);
    L73:
        if (r117 == null) goto L75;
        ((ViewGroup.MarginLayoutParams) r117).rightMargin = 0;
    L75:
        View r118 = this.f452350j;
        if (r118 == null) goto L81;
        r118.setLayoutParams(r117);
        return;
    L81:
        return;
    L59:
        r116 = null;
        goto L61
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L22;
        DmtEditText r101 = this.f452346f;
        if (r101 == null) goto L6;
        ViewExtKt.m(r101, 0);
    L6:
        ImageView r102 = this.f452344d;
        if (r102 == null) goto L9;
        r102.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ec_search_saas_new_design_search));
    L9:
        ImageView r103 = this.f452344d;
        if (r103 == null) goto L12;
        ViewExtKt.m(r103, DimenExtensionsKt.b(6));
    L12:
        ImageView r104 = this.f452349i;
        if (r104 == null) goto L15;
        r104.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ec_search_saas_new_design_scan));
    L15:
        ImageView r105 = this.f452345e;
        if (r105 == null) goto L18;
        r105.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ec_search_saas_new_design_close_circle));
    L18:
        TextView r106 = this.f452343c;
        if (r106 == null) goto L23;
        r106.post(new ECSearchEditView$updateSearchStyle$1(this));
        return;
    L23:
        return;
    }

    public final void setFirstOvalDim(boolean r100) {
        this.E = r100;
    }

    public final void setFlagText(boolean r100) {
        this.D = r100;
    }

    public void setOnSearchEditViewListener(OnSearchEditViewListener r100) {
        this.f452341a = r100;
    }

    public void setSearchEditFactory(ISearchEditFactory r100) {
        this.A = r100;
    }

    public void setSelection(int r100) {
        DmtEditText r101 = this.f452346f;
        if (r101 == null) goto L6;
        r101.setSelection(r100);
        return;
    }

    public void setText(String r100) {
        Logger.a("ECSearchStyle", "setText current Text = " + r100);
        if (r100 == null) goto L8;
        this.D = true;
        DmtEditText r101 = this.f452346f;
        if (r101 == null) goto L9;
        r101.setText(r100);
        return;
    L9:
        return;
    }

    public ECSearchEditView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.C = R.layout.search_ec_common_layout_view_titlebar;
        FrameLayout.inflate(r100, getLayoutId(), this);
        this.f452366z = new ECSearchEditHelper();
        setClipChildren(false);
        setClipToPadding(false);
        this.f452342b = (ImageView) findViewById(R.id.search_ec_common_title_back);
        this.f452343c = (TextView) findViewById(R.id.search_ec_common_title_search);
        this.f452347g = (ConstraintLayout) findViewById(R.id.edit_view_root);
        ImageView r102 = (ImageView) findViewById(R.id.search_ec_common_icon);
        this.f452344d = r102;
        ViewExtKt.m(r102, DimenExtensionsKt.b(10));
        this.f452345e = (ImageView) findViewById(R.id.search_ec_common_close);
        ImageView r103 = (ImageView) findViewById(R.id.search_ec_common_half_screen_close);
        this.f452346f = (DmtEditText) findViewById(R.id.search_ec_common_input);
        this.f452348h = findViewById(R.id.focusView);
        this.f452350j = findViewById(R.id.search_ec_common_title_edit_bg);
        this.f452351k = findViewById(R.id.search_ec_common_title_edit_bg_border);
        this.f452349i = (ImageView) findViewById(R.id.search_ec_common_scan);
        this.f452352l = (FrameLayout) findViewById(R.id.search_ec_common_title_extra);
        this.f452353m = (RelativeLayout) findViewById(R.id.search_ec_common_title_right);
        this.f452354n = findViewById(R.id.search_ec_common_title_edit_bg_range_dim);
        this.f452355o = findViewById(R.id.oval_dim_1);
        this.f452356p = findViewById(R.id.oval_dim_2);
        this.f452357q = findViewById(R.id.oval_dim_3);
        this.f452358r = findViewById(R.id.oval_dim_4);
        this.f452359s = findViewById(R.id.oval_dim_5);
        this.f452360t = findViewById(R.id.oval_dim_6);
        ImageView r104 = (ImageView) findViewById(R.id.saas_ec_search_top_bar_order);
        this.f452361u = r104;
        if (r104 == null) goto L5;
        r104.setOnClickListener(new ECSearchEditView$initView$1(this));
    L5:
        ImageView r105 = this.f452342b;
        if (r105 == null) goto L8;
        r105.setOnClickListener(new ECSearchEditView$initView$2(this));
    L8:
        ImageView r106 = this.f452345e;
        if (r106 == null) goto L11;
        r106.setOnClickListener(new ECSearchEditView$initView$3(this));
    L11:
        DmtEditText r107 = this.f452346f;
        if (r107 == null) goto L14;
        r107.addTextChangedListener(new ECSearchEditView$initView$4(this));
    L14:
        DmtEditText r108 = this.f452346f;
        if (r108 == null) goto L17;
        r108.setOnEditorActionListener(new ECSearchEditView$initView$5(this));
    L17:
        TextView r109 = this.f452343c;
        if (r109 == null) goto L20;
        r109.setOnTouchListener(new ECSearchEditView$initView$6(this));
    L20:
        ImageView r110 = this.f452349i;
        if (r110 == null) goto L23;
        r110.setOnClickListener(new ECSearchEditView$initView$7(this));
    L23:
        this.E = true;
        this.F = new JSONObject();
    }

    public static void c(View r100, float r101) {
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        if (r102 == null) goto L5;
        ITradeSearchAwemeHostService r103 = r102.getITradeSearchAwemeHostService();
    L6:
        if (r103 == null) goto L9;
        r103.ovalDimBlur(r100, r101);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    private final void query(String r100, int r101) {
        OnSearchEditViewListener r102 = this.f452341a;
        if (r102 == null) goto L10;
        DmtEditText r103 = this.f452346f;
        if (r103 == null) goto L7;
        CharSequence r104 = r103.getHint();
    L8:
        r102.onSearchBtnSearch(String.valueOf(r104), r100, r101);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void g(SearchStyleConfig r100, String r110) {
        FrameStyle r101 = r100.d();
        if (r101 == null) goto L11;
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(r101.b());
        int r103 = Color.parseColor(r101.a());     // Catch: IllegalArgumentException -> L7
    L8:
        r102.setColor(r103);
        View r104 = this.f452350j;
        if (r104 == null) goto L11;
        r104.setBackground(r102);
    L7:
        r103 = 0;
    L11:
        ScanStyle r105 = r100.f();
        if (r105 == null) goto L67;
        ImageView r106 = this.f452349i;
        if (r106 == null) goto L21;
        if (r105.a() == false) goto L18;
        int r107 = 0;
    L19:
        r106.setVisibility(r107);
        goto L21
    L18:
        r107 = 8;
    L21:
        if (r105.a() == false) goto L39;
        ImageView r108 = this.f452345e;
        if (r108 == null) goto L25;
        r108.setVisibility(8);
    L25:
        int r109 = r110.hashCode();
        if (r109 == 173545095) goto L35;
        if (r109 != 529792783) goto L67;
        if (r110.equals("result_style") == false) goto L67;
        OnSearchEditViewListener r111 = this.f452341a;
        if (r111 == null) goto L67;
        r111.onScanShow("search_result_page");
        goto L67
    L35:
        if (r110.equals("middle_style") == false) goto L67;
        OnSearchEditViewListener r112 = this.f452341a;
        if (r112 == null) goto L67;
        r112.onScanShow("search_middle_page");
        goto L67
    L39:
        int r113 = r110.hashCode();
        if (r113 == 99661623) goto L53;
        if (r113 == 173545095) goto L50;
        if (r113 != 529792783) goto L67;
        if (r110.equals("result_style") == false) goto L67;
        ImageView r114 = this.f452345e;
        if (r114 == null) goto L67;
        r114.setVisibility(0);
        goto L67
    L50:
        if (r110.equals("middle_style") == false) goto L67;
    L54:
        Logger.a("ECSearchStyle", "updateStyle, current Text = " + getText());
        ImageView r115 = this.f452345e;
        if (r115 == null) goto L67;
        String r116 = getText();
        if (r116 != null) goto L59;
    L62:
        boolean r117 = true;
    L63:
        if (r117 == true) goto L65;
        int r118 = 0;
    L66:
        r115.setVisibility(r118);
        goto L67
    L65:
        r118 = 8;
        goto L66
    L59:
        if (r116.length() == 0) goto L62;
        r117 = false;
        goto L63
    L53:
        if (r110.equals("sug_style") == true) goto L54;
    L67:
        ActionStyle r119 = r100.b();
        if (r119 == null) goto L98;
        if (r119.b() == false) goto L91;
        TextView r120 = this.f452343c;
        if (r120 == null) goto L74;
        r120.setVisibility(0);
    L74:
        FrameLayout r121 = this.f452352l;
        if (r121 == null) goto L77;
        r121.setVisibility(8);
    L77:
        TextView r122 = this.f452343c;
        if (r122 != null) goto L180;
    L84:
        TextView r123 = this.f452343c;
        if (r123 == null) goto L98;
        String r124 = r119.c();
        if (r124 != null) goto L90;
        r124 = "";
    L90:
        r123.setText(r124);
        goto L98
    L180:
        int r125 = Color.parseColor(r119.a());     // Catch: IllegalArgumentException -> L82
    L83:
        r122.setTextColor(r125);
    L82:
        r125 = 0;
        goto L83
    L91:
        TextView r126 = this.f452343c;
        if (r126 == null) goto L94;
        r126.setVisibility(8);
    L94:
        FrameLayout r127 = this.f452352l;
        if (r127 == null) goto L98;
        r127.setVisibility(8);
    L98:
        if (r100.a() == null) goto L117;
        TextView r128 = this.f452343c;
        if (r128 == null) goto L102;
        r128.setVisibility(8);
    L102:
        FrameLayout r129 = this.f452352l;
        if (r129 == null) goto L105;
        r129.setVisibility(0);
    L105:
        FrameLayout r130 = this.f452352l;
        if (r130 == null) goto L108;
        int r131 = r130.getChildCount();
    L109:
        if (r131 > 0) goto L117;
        ECSearchEditHelper r132 = this.f452366z;
        if (r132 == null) goto L113;
        r132.f451704b = this.A;
    L113:
        ECSearchEditHelper r133 = this.f452366z;
        if (r133 == null) goto L117;
        r133.b(this.f452352l, r100);
        goto L117
    L108:
        r131 = 0;
    L117:
        if (r100.g() == false) goto L127;
        ImageView r134 = this.f452361u;
        if (r134 == null) goto L121;
        r134.setVisibility(0);
    L121:
        TextView r135 = this.f452343c;
        if (r135 == null) goto L124;
        r135.setVisibility(8);
    L124:
        FrameLayout r136 = this.f452352l;
        if (r136 == null) goto L130;
        r136.setVisibility(8);
    L130:
        HintTextStyle r137 = r100.e();
        if (r137 == null) goto L139;
        DmtEditText r138 = this.f452346f;
        if (r138 == null) goto L139;
        int r139 = Color.parseColor(r137.a());     // Catch: IllegalArgumentException -> L137
    L138:
        r138.setHintTextColor(r139);
    L137:
        r139 = 0;
    L139:
        ArrowIconStyle r140 = r100.c();
        if (r140 == null) goto L144;
        Integer r141 = r140.a();
        if (r141 == null) goto L144;
        int r142 = r141.intValue();
    L145:
        ImageView r143 = this.f452342b;
        ViewGroup.LayoutParams r144 = null;
        if (r143 == null) goto L148;
        ViewGroup.LayoutParams r145 = r143.getLayoutParams();
    L150:
        if ((r145 instanceof ConstraintLayout.LayoutParams) == false) goto L153;
        r144 = r145;
    L153:
        ConstraintLayout.LayoutParams r146 = (ConstraintLayout.LayoutParams) r144;
        if (r146 == null) goto L158;
        r146.setMarginStart(r142);
        ImageView r147 = this.f452342b;
        if (r147 == null) goto L158;
        r147.setLayoutParams(r146);
    L158:
        TextView r148 = this.f452343c;
        if (r148 != null) goto L161;
    L162:
        FrameLayout r149 = this.f452352l;
        if (r149 != null) goto L165;
    L166:
        ImageView r150 = this.f452361u;
        if (r150 != null) goto L169;
    L174:
        RelativeLayout r151 = this.f452353m;
        if (r151 == null) goto L186;
        r151.setVisibility(8);
        return;
    L186:
        return;
    L169:
        if (r150.getVisibility() != 0) goto L174;
    L171:
        RelativeLayout r152 = this.f452353m;
        if (r152 == null) goto L184;
        r152.setVisibility(0);
        return;
    L184:
        return;
    L165:
        if (r149.getVisibility() == 0) goto L171;
    L161:
        if (r148.getVisibility() == 0) goto L171;
    L148:
        r145 = null;
    L144:
        r142 = DimenExtensionsKt.b(16);
        goto L145
    L127:
        ImageView r153 = this.f452361u;
        if (r153 == null) goto L130;
        r153.setVisibility(8);
        goto L130
    }

    public static final /* synthetic */ void a(ECSearchEditView r100, String r101, int r102) {
        r100.query(r101, r102);
    }
}

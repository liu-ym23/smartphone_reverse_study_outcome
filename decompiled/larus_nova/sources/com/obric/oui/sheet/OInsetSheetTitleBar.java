package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u000bSB'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010RJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020)8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00108\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u0010<\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R.\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00103\u001a\u0004\b>\u00105\"\u0004\b?\u00107R*\u0010H\u001a\u00020A2\u0006\u0010*\u001a\u00020A8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010K\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006T"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", "Landroid/widget/LinearLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Lcom/obric/oui/button/OButton;", ce.f26396k, "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "", "value", "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", OfficeSDKRequestTag.KEY_NEW_USER, "getTitleText", "setTitleText", "titleText", "o", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "p", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OInsetSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f402841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f402842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f402844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f402845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f402846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f402847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f402848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f402849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTextView f402850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OButton f402851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f402852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f402853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f402854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f402855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TitlePosition f402856p;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f402857a = null;
        private final int value;

        public static TitlePosition valueOf(String r100) {
            return (TitlePosition) r27.a.a(TitlePosition.class, r100);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f402857a.clone();
        }

        static {
            TitlePosition r100 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r100;
            TitlePosition r101 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r101;
            TitlePosition r102 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r102;
            f402857a = new TitlePosition[]{r100, r101, r102};
        }

        public final int getValue() {
            return this.value;
        }

        public TitlePosition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402858a = null;

        static {
            int[] r100 = new int[TitlePosition.values().length];
            r100[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r100[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r100[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f402858a = r100;
        }
    }

    static {
    }

    public OInsetSheetTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OInsetSheetTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r100 = this.f402843c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r100 = this.f402844d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OButton getMLeftActionBack() {
        OButton r100 = this.f402851k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r100 = this.f402841a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r100 = this.f402842b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TextView getMTitleView() {
        TitlePosition r100 = this.f402856p;
        int r101 = b.f402858a[r100.ordinal()];
        if (r101 != 1) goto L5;
        TextView r102 = this.f402847g;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        r102 = this.f402845e;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r101 != 3) goto L12;
        r102 = this.f402846f;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final String getDesText() {
        return this.f402855o;
    }

    public final TitlePosition getMTitlePosition() {
        return this.f402856p;
    }

    public final boolean getShowLeftBack() {
        return this.f402852l;
    }

    public final String getSubTitleText() {
        return this.f402853m;
    }

    public final String getTitleText() {
        return this.f402854n;
    }

    public final void setCenterText(int r100) {
        setTitleText(getResources().getString(r100));
    }

    public final void setDesText(String r100) {
        this.f402855o = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        OTextView r102 = null;
        FrameLayout r103 = null;
        if (r101 == false) goto L16;
        FrameLayout r104 = this.f402849i;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r103.setVisibility(8);
        return;
    L14:
        r103 = r104;
        goto L15
    L16:
        FrameLayout r105 = this.f402849i;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r105 = null;
    L19:
        r105.setVisibility(0);
        OTextView r106 = this.f402850j;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L23:
        r102.setText(r100);
        return;
    L22:
        r102 = r106;
        goto L23
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setMCenterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402843c = r100;
    }

    public final void setMFixedCenterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402844d = r100;
    }

    public final void setMLeftActionBack(OButton r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402851k = r100;
    }

    public final void setMLeftContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402841a = r100;
    }

    public final void setMRightContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402842b = r100;
    }

    public final void setMTitlePosition(TitlePosition r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f402856p = r100;
        int r101 = b.f402858a[r100.ordinal()];
        TextView r102 = null;
        if (r101 != 1) goto L5;
        TextView r103 = this.f402847g;
        if (r103 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r103 = null;
    L34:
        r103.setVisibility(0);
        TextView r104 = this.f402845e;
        if (r104 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r104 = null;
    L37:
        r104.setVisibility(8);
        TextView r105 = this.f402846f;
        if (r105 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r102.setVisibility(8);
    L42:
        getMTitleView().setText(this.f402854n);
        return;
    L40:
        r102 = r105;
        goto L41
    L5:
        if (r101 != 2) goto L7;
        TextView r106 = this.f402847g;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r106 = null;
    L23:
        r106.setVisibility(8);
        TextView r107 = this.f402845e;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r107 = null;
    L26:
        r107.setVisibility(0);
        TextView r108 = this.f402846f;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r102.setVisibility(8);
        goto L42
    L29:
        r102 = r108;
        goto L30
    L7:
        if (r101 != 3) goto L42;
        TextView r109 = this.f402847g;
        if (r109 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r109 = null;
    L12:
        r109.setVisibility(8);
        TextView r110 = this.f402845e;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r110 = null;
    L15:
        r110.setVisibility(8);
        TextView r111 = this.f402846f;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r102.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r102 = r111;
        goto L19
    }

    public final void setShowLeftBack(boolean r100) {
        this.f402852l = r100;
        OButton r101 = getMLeftActionBack();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (this.f402856p != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setSubTitleText(String r100) {
        this.f402853m = r100;
        TextView r101 = null;
        if (r100 != null) goto L9;
        TextView r102 = this.f402848h;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r101.setVisibility(8);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        TextView r103 = this.f402848h;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r103 = null;
    L12:
        r103.setVisibility(0);
        TextView r104 = this.f402848h;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r101.setText(r100);
        return;
    L15:
        r101 = r104;
        goto L16
    }

    public final void setTitleText(String r100) {
        this.f402854n = r100;
        if (r100 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r100);
    }

    public final void setCenterText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        setTitleText(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OInsetSheetTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402852l = true;
        TitlePosition r103 = TitlePosition.FIXED_CENTER;
        this.f402856p = r103;
        FrameLayout.inflate(r100, R.layout.o_sheet_title_bar_container, this);
        this.f402845e = (TextView) findViewById(R.id.center_title);
        this.f402846f = (TextView) findViewById(R.id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R.id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R.id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R.id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R.id.fl_fixed_center_action_container));
        this.f402847g = (TextView) findViewById(R.id.fixed_center_title);
        setMLeftActionBack((OButton) findViewById(R.id.left_action_back));
        this.f402848h = (TextView) findViewById(R.id.fixed_center_sub_title);
        this.f402849i = (FrameLayout) findViewById(R.id.sheet_title_bar_des);
        OTextView r104 = (OTextView) findViewById(R.id.sheet_title_bar_des_text);
        this.f402850j = r104;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r104 = null;
    L5:
        r104.setEnableAutoAlignLeft(true);
        if (r101 == null) goto L13;
        TypedArray r105 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_autoAdjustTitleSpace, R.attr.oui_sub_title_text, R.attr.oui_title_des_text, R.attr.oui_title_pos, R.attr.oui_title_text, R.attr.oui_useBackIcon}, 0, 0);
        int r106 = r105.getInt(3, r103.getValue());     // Catch: Throwable -> L10
        setMTitlePosition(TitlePosition.values()[r106]);     // Catch: Throwable -> L10
        setTitleText(r105.getString(4));     // Catch: Throwable -> L10
        setDesText(r105.getString(2));     // Catch: Throwable -> L10
        setShowLeftBack(r105.getBoolean(5, true));     // Catch: Throwable -> L10
        setSubTitleText(r105.getString(1));     // Catch: Throwable -> L10
        r105.recycle();
        return;
    L10:
        th = move-exception;
        r105.recycle();
        throw th;
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}

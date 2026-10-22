package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\rYB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\u0002¢\u0006\u0004\bW\u0010XJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u0010;\u001a\u0002032\u0006\u00104\u001a\u0002038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010B\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR.\u0010F\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR*\u0010N\u001a\u00020G2\u0006\u00104\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010Q\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006Z"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", "minWidth", "setMinCenterTitleWidth", "Landroid/widget/LinearLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "fixedCenterTitleContainer", "Lcom/obric/oui/button/OButton;", ce.f26395j, "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "", "value", "l", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "m", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", OfficeSDKRequestTag.KEY_NEW_USER, "getTitleText", "setTitleText", "titleText", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "o", "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitlePosition", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f403361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f403362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f403363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f403364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f403365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f403366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f403367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f403368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f403369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OButton f403370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f403371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f403372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f403373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f403374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TitlePosition f403375o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f403376a = null;
        private final int value;

        public static TitlePosition valueOf(String r100) {
            return (TitlePosition) r27.a.a(TitlePosition.class, r100);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f403376a.clone();
        }

        static {
            TitlePosition r100 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r100;
            TitlePosition r101 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r101;
            TitlePosition r102 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r102;
            f403376a = new TitlePosition[]{r100, r101, r102};
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
        public static final /* synthetic */ int[] f403377a = null;

        static {
            int[] r100 = new int[TitlePosition.values().length];
            r100[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r100[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r100[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f403377a = r100;
        }
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

    public static /* synthetic */ void a(OCTitleBar r100) {
        m8592setMinCenterTitleWidth$lambda1(r100);
    }

    public final void b() {
        TitlePosition r100 = this.f403375o;
        TextView r101 = null;
        if (r100 != TitlePosition.LEFT_IN_ACTION) goto L10;
        TextView r102 = this.f403367g;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L8:
        r101.requestLayout();
        return;
    L7:
        r101 = r102;
        goto L8
    L10:
        if (r100 != TitlePosition.FIXED_CENTER) goto L21;
        TextView r103 = this.f403368h;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r103 = null;
    L14:
        r103.requestLayout();
        TextView r104 = this.f403369i;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L18:
        r101.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r101 = r104;
        goto L18
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r100 = this.f403365e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
        return null;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r100 = this.f403363c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r100 = this.f403364d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OButton getMLeftActionBack() {
        OButton r100 = this.f403370j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r100 = this.f403361a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r100 = this.f403362b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TextView getMTitleView() {
        TitlePosition r100 = this.f403375o;
        int r101 = b.f403377a[r100.ordinal()];
        if (r101 != 1) goto L5;
        TextView r102 = this.f403368h;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        r102 = this.f403366f;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r101 != 3) goto L12;
        r102 = this.f403367g;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final TitlePosition getMTitlePosition() {
        return this.f403375o;
    }

    public final boolean getShowLeftBack() {
        return this.f403372l;
    }

    public final String getSubTitleText() {
        return this.f403373m;
    }

    public final String getTitleText() {
        return this.f403374n;
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m8592setMinCenterTitleWidth$lambda1(OCTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.b();
    }

    public final void setCenterText(int r100) {
        setTitleText(getResources().getString(r100));
    }

    public final void setFixedCenterTitleContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403365e = r100;
    }

    public final void setMCenterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403363c = r100;
    }

    public final void setMFixedCenterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403364d = r100;
    }

    public final void setMLeftActionBack(OButton r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403370j = r100;
    }

    public final void setMLeftContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403361a = r100;
    }

    public final void setMRightContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f403362b = r100;
    }

    public final void setMTitlePosition(TitlePosition r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f403375o = r100;
        int r101 = b.f403377a[r100.ordinal()];
        TextView r102 = null;
        if (r101 != 1) goto L5;
        TextView r103 = this.f403368h;
        if (r103 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r103 = null;
    L34:
        r103.setVisibility(0);
        TextView r104 = this.f403366f;
        if (r104 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r104 = null;
    L37:
        r104.setVisibility(8);
        TextView r105 = this.f403367g;
        if (r105 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r102.setVisibility(8);
    L42:
        getMTitleView().setText(this.f403374n);
        return;
    L40:
        r102 = r105;
        goto L41
    L5:
        if (r101 != 2) goto L7;
        TextView r106 = this.f403368h;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r106 = null;
    L23:
        r106.setVisibility(8);
        TextView r107 = this.f403366f;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r107 = null;
    L26:
        r107.setVisibility(0);
        TextView r108 = this.f403367g;
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
        TextView r109 = this.f403368h;
        if (r109 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r109 = null;
    L12:
        r109.setVisibility(8);
        TextView r110 = this.f403366f;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r110 = null;
    L15:
        r110.setVisibility(8);
        TextView r111 = this.f403367g;
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

    public final void setMinCenterTitleWidth(int r100) {
        this.f403371k = pla.d.n(this, r100);
        post(new com.obric.oui.titlebar.a(this));
    }

    public final void setShowLeftBack(boolean r100) {
        this.f403372l = r100;
        OButton r101 = getMLeftActionBack();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (this.f403375o != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setSubTitleText(String r100) {
        this.f403373m = r100;
        TextView r101 = null;
        if (r100 != null) goto L9;
        TextView r102 = this.f403369i;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r101.setVisibility(8);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        TextView r103 = this.f403369i;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r103 = null;
    L12:
        r103.setVisibility(0);
        TextView r104 = this.f403369i;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r104 = null;
    L15:
        r104.setText(r100);
        if (getResources().getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r105 = this.f403368h;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r105 = null;
    L20:
        r105.setTextSize(1, 16.0f);
        TextView r106 = this.f403369i;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L24:
        r101.setTextSize(1, 12.0f);
        goto L25
    L23:
        r101 = r106;
    L25:
        b();
    }

    public final void setTitleText(String r100) {
        this.f403374n = r100;
        if (r100 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r100);
        b();
    }

    public final void setCenterText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        setTitleText(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        TitlePosition r102 = this.f403375o;
        int r103 = 0;
        TextView r104 = null;
        if (r102 != TitlePosition.LEFT_IN_ACTION) goto L35;
        TextView r105 = this.f403367g;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r105 = null;
    L7:
        int r106 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r107 = this.f403367g;
        if (r107 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r107 = null;
    L10:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r108 = null;
    L13:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 == null) goto L16;
        int r110 = r109.rightMargin;
    L17:
        int r111 = r106 - r110;
        TextView r112 = this.f403367g;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r112 = null;
    L20:
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r113 = null;
    L23:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L26;
        r103 = r114.rightMargin;
    L26:
        int r115 = r111 - r103;
        TextView r116 = this.f403367g;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r116 = null;
    L29:
        int r117 = r115 - r116.getPaddingLeft();
        TextView r118 = this.f403367g;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L33:
        r105.setMaxWidth(r117 - r104.getPaddingRight());
        return;
    L32:
        r104 = r118;
        goto L33
    L16:
        r110 = 0;
        goto L17
    L35:
        if (r102 == TitlePosition.FIXED_CENTER) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r119 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r120 = getMLeftContainer().getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r120 = null;
    L41:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        if (r121 == null) goto L44;
        int r122 = r121.leftMargin;
    L45:
        int r123 = r119 + r122;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r124 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r125 = getMRightContainer().getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r125 = null;
    L52:
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
        if (r126 == null) goto L55;
        int r127 = r126.rightMargin;
    L56:
        int r128 = r124 + r127;
    L58:
        int r129 = Math.max(r123, r128);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r130 = getMFixedCenterContainer().getLayoutParams();
        if ((r130 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r130 = null;
    L63:
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        if (r131 == null) goto L66;
        int r132 = r131.leftMargin;
    L67:
        ViewGroup.LayoutParams r133 = getMFixedCenterContainer().getLayoutParams();
        if ((r133 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r133 = null;
    L70:
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        if (r134 == null) goto L73;
        r103 = r134.rightMargin;
    L73:
        int r135 = Math.max((getMeasuredWidth() - (r129 * 2)) - (r132 + r103), this.f403371k);
        TextView r136 = this.f403368h;
        if (r136 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r136 = null;
    L76:
        TextView r137 = this.f403368h;
        if (r137 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r137 = null;
    L79:
        int r138 = r137.getPaddingLeft() + r135;
        TextView r139 = this.f403368h;
        if (r139 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r139 = null;
    L82:
        r136.setMaxWidth(r138 + r139.getPaddingRight());
        TextView r140 = this.f403369i;
        if (r140 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r140 = null;
    L85:
        TextView r141 = this.f403369i;
        if (r141 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r141 = null;
    L88:
        int r142 = r135 + r141.getPaddingLeft();
        TextView r143 = this.f403369i;
        if (r143 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L92:
        r140.setMaxWidth(r142 + r104.getPaddingRight());
        return;
    L91:
        r104 = r143;
        goto L92
    L66:
        r132 = 0;
        goto L67
    L96:
        return;
    L55:
        r127 = 0;
        goto L56
    L57:
        r128 = 0;
        goto L58
    L44:
        r122 = 0;
        goto L45
    L46:
        r123 = 0;
        goto L48
    }

    public OCTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403371k = pla.d.n(this, 70);
        this.f403372l = true;
        TitlePosition r103 = TitlePosition.FIXED_CENTER;
        this.f403375o = r103;
        FrameLayout.inflate(r100, R.layout.o_title_bar_container, this);
        this.f403366f = (TextView) findViewById(R.id.center_title);
        this.f403367g = (TextView) findViewById(R.id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R.id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R.id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R.id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R.id.fl_fixed_center_action_container));
        this.f403368h = (TextView) findViewById(R.id.fixed_center_title);
        setMLeftActionBack((OButton) findViewById(R.id.left_action_back));
        this.f403369i = (TextView) findViewById(R.id.fixed_center_sub_title);
        setFixedCenterTitleContainer((ViewGroup) findViewById(R.id.fixed_center_title_container));
        if (r101 == null) goto L10;
        TypedArray r104 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_autoAdjustTitleSpace, R.attr.oui_sub_title_text, R.attr.oui_title_des_text, R.attr.oui_title_pos, R.attr.oui_title_text, R.attr.oui_useBackIcon}, 0, 0);
        int r105 = r104.getInt(3, r103.getValue());     // Catch: Throwable -> L7
        setMTitlePosition(TitlePosition.values()[r105]);     // Catch: Throwable -> L7
        setTitleText(r104.getString(4));     // Catch: Throwable -> L7
        setShowLeftBack(r104.getBoolean(5, true));     // Catch: Throwable -> L7
        setSubTitleText(r104.getString(1));     // Catch: Throwable -> L7
        r104.recycle();
        return;
    L7:
        th = move-exception;
        r104.recycle();
        throw th;
    }

    public /* synthetic */ OCTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
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

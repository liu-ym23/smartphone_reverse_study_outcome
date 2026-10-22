package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.color.h0;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0014vB'\b\u0007\u0012\u0006\u0010p\u001a\u00020o\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q\u0012\b\b\u0002\u0010s\u001a\u00020\u0007¢\u0006\u0004\bt\u0010uJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010%\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u00100\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u0010A\u001a\u0002092\u0006\u0010:\u001a\u0002098\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010H\u001a\u0004\u0018\u00010\r2\b\u0010:\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR.\u0010L\u001a\u0004\u0018\u00010\r2\b\u0010:\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010C\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR.\u0010P\u001a\u0004\u0018\u00010\r2\b\u0010:\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010E\"\u0004\bO\u0010GR*\u0010X\u001a\u00020Q2\u0006\u0010:\u001a\u00020Q8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010`\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010c\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010[\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0011\u0010n\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006w"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/b;", "Lcom/obric/oui/material/g;", "", "Landroid/view/View;", "getDefaultTargetView", "", "getCenterTitleGap", "getTitleBarContentWidth", "resId", "", "setCenterText", "", "title", "Landroid/widget/TextView;", "getTitleView", "view", "setBackdropTarget", "Landroid/widget/LinearLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "t", "I", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "currentTheme", "Lcom/obric/oui/button/OIconButtonFloating;", "y", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftActionBack", "", "value", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subTitleText", "B", "getTitleText", "setTitleText", "titleText", "C", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "D", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitlePosition", "", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartX", "getTouchStartY", "setTouchStartY", "touchStartY", "Landroid/view/VelocityTracker;", "G", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "velocityTracker", "getMTitleView", "()Landroid/widget/TextView;", "mTitleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OSheetTitleBar extends FrameLayout implements com.obric.oui.material.b, com.obric.oui.material.g {
    public static final /* synthetic */ int H = 0;
    public String A;
    public String B;
    public String C;
    public TitlePosition D;
    public float E;
    public float F;
    public VelocityTracker G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f402932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f402933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f402935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f402936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f402937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f402938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f402939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f402940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f402941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f402942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OTextView f402943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f402944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f402945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f402946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f402947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f402948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f402949r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f402950s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f402951t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f402952u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f402953v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402954w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Function1<? super Boolean, com.obric.oui.material.c> f402955x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OIconButtonFloating f402956y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f402957z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f402958a = null;
        private final int value;

        public static TitlePosition valueOf(String r100) {
            return (TitlePosition) r27.a.a(TitlePosition.class, r100);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f402958a.clone();
        }

        static {
            TitlePosition r100 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r100;
            TitlePosition r101 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r101;
            TitlePosition r102 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r102;
            f402958a = new TitlePosition[]{r100, r101, r102};
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
        public static final /* synthetic */ int[] f402959a = null;

        static {
            int[] r100 = new int[TitlePosition.values().length];
            r100[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r100[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r100[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f402959a = r100;
        }
    }

    static {
    }

    public OSheetTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSheetTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getCenterTitleGap() {
        if (this.f402947p == false) goto L6;
        return this.f402949r;
    L6:
        return this.f402948q;
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r100 = this.f402937f;
        ViewGroup r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r100 = null;
    L6:
        if (r100.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r102 = this.f402937f;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L14:
        return r101.getMeasuredWidth();
    L10:
        r101 = r102;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r100 = this.f402934c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r100 = this.f402935d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r100 = this.f402956y;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r100 = this.f402932a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r100 = this.f402933b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TextView getMTitleView() {
        TitlePosition r100 = this.D;
        int r101 = b.f402959a[r100.ordinal()];
        if (r101 != 1) goto L5;
        TextView r102 = this.f402940i;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r102;
    L5:
        if (r101 != 2) goto L7;
        r102 = this.f402938g;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r101 != 3) goto L12;
        r102 = this.f402939h;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean h() {
        if (this.D == TitlePosition.FIXED_CENTER) goto L5;
        return false;
    L5:
        if (getMFixedCenterContainer().getVisibility() != 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L29;
        TextView r101 = this.f402940i;
        TextView r102 = null;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r101 = null;
    L13:
        if (r101.getVisibility() != 0) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L26;
        TextView r104 = this.f402941j;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L22:
        if (r102.getVisibility() != 0) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L26;
        return false;
    L24:
        r105 = false;
        goto L25
    L20:
        r102 = r104;
    L26:
        return true;
    L15:
        r103 = false;
        goto L16
    L29:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final void i() {
        Function1<? super Boolean, com.obric.oui.material.c> r100 = this.f402955x;
        int r101 = this.f402951t;
        com.obric.oui.material.c r102 = null;
        boolean r103 = false;
        if (r101 != 0) goto L5;
        TextView r104 = this.f402939h;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r104 = null;
    L11:
        if (r104.getVisibility() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L19;
        TextView r106 = this.f402939h;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r106 = null;
    L18:
        int r107 = r106.getTextColors().getDefaultColor();
    L31:
        r103 = !h0.b(r107);
    L32:
        com.obric.oui.material.c r108 = r100.invoke(Boolean.valueOf(!r103));
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L36:
        OMaterialHelper.p(this, r102, this.f402954w);
        View r109 = this.f402952u;
        if (r109 != null) goto L40;
        r109 = this;
    L40:
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r109);
        return;
    L35:
        r102 = r108;
        goto L36
    L19:
        TextView r110 = this.f402940i;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r110 = null;
    L23:
        if (r110.getVisibility() != 0) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L30;
        TextView r111 = this.f402940i;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r111 = null;
    L29:
        r107 = r111.getTextColors().getDefaultColor();
        goto L31
    L30:
        r107 = -16777216;
        goto L31
    L13:
        r105 = false;
        goto L14
    L5:
        if (r101 != 2) goto L32;
        r103 = true;
        goto L32
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    private final View getDefaultTargetView() {
        Integer r100 = OMaterialHelper.f401446a;
        return this;
    }

    public final int getCurrentTheme() {
        return this.f402951t;
    }

    public final String getDesText() {
        return this.C;
    }

    public final TitlePosition getMTitlePosition() {
        return this.D;
    }

    public final boolean getShowLeftBack() {
        return this.f402957z;
    }

    public final String getSubTitleText() {
        return this.A;
    }

    public final String getTitleText() {
        return this.B;
    }

    public final float getTouchStartX() {
        return this.E;
    }

    public final float getTouchStartY() {
        return this.F;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.G;
    }

    public static int g(View r100) {
        int r101 = 0;
        if (r100.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L15:
        return 0;
    L8:
        if (r100.getMeasuredWidth() <= 0) goto L15;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r101 = r104.getMarginStart() + r104.getMarginEnd();
    L14:
        return r100.getMeasuredWidth() + r101;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        this.f402954w = r100;
        com.obric.oui.material.h.c(CollectionsKt.listOf(getMLeftActionBack()), r100);
        p.g(this, r100);
    }

    @Override // com.obric.oui.material.b
    public final void b(boolean r100) {
        int r101 = this.f402954w;
        if (r101 == (-1)) goto L6;
        com.obric.oui.material.h.a(this, r100, r101);
        return;
    L6:
        com.obric.oui.material.h.b(this, r100, this.f402953v);
    }

    public final Pair<Integer, Integer> f(int r100) {
        ViewGroup r101 = this.f402937f;
        ViewGroup r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r101 = null;
    L5:
        int r103 = r101.getPaddingLeft();
        ViewGroup r104 = this.f402937f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L9:
        int r105 = r102.getPaddingRight();
        int r106 = getCenterTitleGap();
        int r107 = g(getMLeftContainer());
        int r108 = g(getMRightContainer());
        if (r107 <= 0) goto L12;
        int r109 = (r103 + r107) + r106;
    L13:
        int r110 = r100 - r105;
        if (r108 <= 0) goto L16;
        int r111 = (r110 - r108) - r106;
    L18:
        return TuplesKt.to(Integer.valueOf(r109), Integer.valueOf(r111));
    L16:
        r111 = r110 - this.f402950s;
        goto L18
    L12:
        r109 = r103 + this.f402950s;
        goto L13
    L8:
        r102 = r104;
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 == null) goto L6;
        this.f402947p = vma.h.b(r100.fontScale);
    L6:
        this.f402948q = pla.d.n(this, 12);
        this.f402949r = pla.d.n(this, 4);
        this.f402950s = pla.d.n(this, 8);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        this.f402952u = r100;
        if (r100 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, this);
        View r101 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r101);
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r100);
        List r102 = CollectionsKt.listOf(getMLeftActionBack());
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((com.obric.oui.material.g) r103.next()).setBackdropTarget(r100);
        goto L8
    }

    public final void setCenterText(int r100) {
        setTitleText(getResources().getString(r100));
    }

    public final void setCurrentTheme(int r100) {
        this.f402951t = r100;
    }

    public final void setDesText(String r100) {
        this.C = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        OTextView r102 = null;
        FrameLayout r103 = null;
        if (r101 == false) goto L16;
        FrameLayout r104 = this.f402942k;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r103.setVisibility(8);
        return;
    L14:
        r103 = r104;
        goto L15
    L16:
        FrameLayout r105 = this.f402942k;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r105 = null;
    L19:
        r105.setVisibility(0);
        OTextView r106 = this.f402943l;
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
        this.f402934c = r100;
    }

    public final void setMFixedCenterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402935d = r100;
    }

    public final void setMLeftActionBack(OIconButtonFloating r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402956y = r100;
    }

    public final void setMLeftContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402932a = r100;
    }

    public final void setMRightContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402933b = r100;
    }

    public final void setMTitlePosition(TitlePosition r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.D = r100;
        int r101 = b.f402959a[r100.ordinal()];
        TextView r102 = null;
        if (r101 != 1) goto L5;
        TextView r103 = this.f402940i;
        if (r103 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r103 = null;
    L34:
        r103.setVisibility(0);
        TextView r104 = this.f402938g;
        if (r104 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r104 = null;
    L37:
        r104.setVisibility(8);
        TextView r105 = this.f402939h;
        if (r105 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r102.setVisibility(8);
    L42:
        getMTitleView().setText(this.B);
        return;
    L40:
        r102 = r105;
        goto L41
    L5:
        if (r101 != 2) goto L7;
        TextView r106 = this.f402940i;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r106 = null;
    L23:
        r106.setVisibility(8);
        TextView r107 = this.f402938g;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r107 = null;
    L26:
        r107.setVisibility(0);
        TextView r108 = this.f402939h;
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
        TextView r109 = this.f402940i;
        if (r109 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r109 = null;
    L12:
        r109.setVisibility(8);
        TextView r110 = this.f402938g;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r110 = null;
    L15:
        r110.setVisibility(8);
        TextView r111 = this.f402939h;
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
        this.f402957z = r100;
        OIconButtonFloating r101 = getMLeftActionBack();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (this.D != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setSubTitleText(String r100) {
        this.A = r100;
        TextView r101 = null;
        if (r100 != null) goto L9;
        TextView r102 = this.f402941j;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r101.setVisibility(8);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        TextView r103 = this.f402941j;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r103 = null;
    L12:
        r103.setVisibility(0);
        TextView r104 = this.f402941j;
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
        this.B = r100;
        if (r100 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r100);
    }

    public final void setTouchStartX(float r100) {
        this.E = r100;
    }

    public final void setTouchStartY(float r100) {
        this.F = r100;
    }

    public final void setVelocityTracker(VelocityTracker r100) {
        this.G = r100;
    }

    public final void setCenterText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        setTitleText(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        boolean r101 = false;
        this.f402944m = false;
        TextView r102 = this.f402940i;
        TextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r102 = null;
    L5:
        r102.setMaxWidth(this.f402945n);
        TextView r104 = this.f402941j;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r104 = null;
    L8:
        r104.setMaxWidth(this.f402946o);
        super.onMeasure(r100, r110);
        if (h() == true) goto L11;
        return;
    L11:
        int r105 = getTitleBarContentWidth();
        if (r105 > 0) goto L14;
        return;
    L14:
        Pair<Integer, Integer> r106 = f(r105);
        int r107 = r106.component1().intValue();
        int r108 = r106.component2().intValue();
        int r109 = r105 / 2;
        int r111 = Math.max(0, Math.min((r109 - r107) * 2, (r108 - r109) * 2));
        int r112 = Math.max(0, r108 - r107);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r111) goto L39;
        boolean r113 = true;
        this.f402944m = true;
        int r114 = Math.min(this.f402945n, r112);
        int r115 = Math.min(this.f402946o, r112);
        TextView r116 = this.f402940i;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r116 = null;
    L20:
        if (r116.getMaxWidth() == r114) goto L25;
        TextView r117 = this.f402940i;
        if (r117 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r117 = null;
    L24:
        r117.setMaxWidth(r114);
        r101 = true;
    L25:
        TextView r118 = this.f402941j;
        if (r118 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r118 = null;
    L29:
        if (r118.getMaxWidth() == r115) goto L35;
        TextView r119 = this.f402941j;
        if (r119 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L34:
        r103.setMaxWidth(r115);
    L36:
        if (r113 == false) goto L40;
        super.onMeasure(r100, r110);
        return;
    L40:
        return;
    L33:
        r103 = r119;
        goto L34
    L35:
        r113 = r101;
        goto L36
    }

    public OSheetTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402945n = Integer.MAX_VALUE;
        this.f402946o = Integer.MAX_VALUE;
        this.f402947p = vma.h.b(r100.getResources().getConfiguration().fontScale);
        this.f402953v = true;
        this.f402954w = 2;
        this.f402955x = new OSheetTitleBar$maskMaterial$1(this);
        this.f402957z = true;
        TitlePosition r103 = TitlePosition.FIXED_CENTER;
        this.D = r103;
        this.f402948q = pla.d.n(this, 12);
        this.f402949r = pla.d.n(this, 4);
        this.f402950s = pla.d.n(this, 8);
        FrameLayout.inflate(r100, R.layout.o_sheet_title_bar_container_v2, this);
        this.f402937f = (ViewGroup) findViewById(R.id.sheet_title_bar_main);
        this.f402938g = (TextView) findViewById(R.id.center_title);
        this.f402939h = (TextView) findViewById(R.id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R.id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R.id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R.id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R.id.fl_fixed_center_action_container));
        this.f402940i = (TextView) findViewById(R.id.fixed_center_title);
        setMLeftActionBack((OIconButtonFloating) findViewById(R.id.left_action_back));
        this.f402941j = (TextView) findViewById(R.id.fixed_center_sub_title);
        this.f402942k = (FrameLayout) findViewById(R.id.sheet_title_bar_des);
        OTextView r104 = (OTextView) findViewById(R.id.sheet_title_bar_des_text);
        this.f402943l = r104;
        TextView r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r104 = null;
    L5:
        r104.setEnableAutoAlignLeft(true);
        TextView r106 = this.f402940i;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r106 = null;
    L8:
        this.f402945n = r106.getMaxWidth();
        TextView r107 = this.f402941j;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L12:
        this.f402946o = r105.getMaxWidth();
        if (r101 == null) goto L20;
        TypedArray r108 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_autoAdjustTitleSpace, R.attr.oui_sub_title_text, R.attr.oui_title_des_text, R.attr.oui_title_pos, R.attr.oui_title_text, R.attr.oui_useBackIcon}, 0, 0);
        setMTitlePosition(TitlePosition.values()[r108.getInt(3, r103.getValue())]);     // Catch: Throwable -> L17
        setTitleText(r108.getString(4));     // Catch: Throwable -> L17
        setDesText(r108.getString(2));     // Catch: Throwable -> L17
        setShowLeftBack(r108.getBoolean(5, true));     // Catch: Throwable -> L17
        setSubTitleText(r108.getString(1));     // Catch: Throwable -> L17
        r108.recycle();
    L17:
        th = move-exception;
        r108.recycle();
        throw th;
    L20:
        i();
        return;
    L11:
        r105 = r107;
        goto L12
    }

    public static OIconButtonFloating c(Context r100, ViewGroup r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        View r103 = FrameLayout.inflate(r100, r102, r101);
        if (r103 == null) goto L11;
        View r104 = ((ViewGroup) r103).getChildAt(r101.getChildCount() - 1);
        if (r104 == null) goto L9;
        return (OIconButtonFloating) r104;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public /* synthetic */ OSheetTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final OIconButtonFloating d(Context r100, ViewGroup r101, int r102, ColorStateList r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        OIconButtonFloating r105 = c(r100, r101, R.layout.o_widget_titlebar_neutral_icon_button);
        View r106 = getDefaultTargetView();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        OMaterialHelper.t(r105, r106);
        r105.setIcon(r102);
        if (r103 == null) goto L6;
        r105.setIconTintColor(r103);
    L6:
        if (r104 == null) goto L9;
        r104.intValue();
        r105.setContentDescription(r105.getContext().getString(r104.intValue()));
    L9:
        return r105;
    }

    public final OIconButtonFloating e(Context r100, ViewGroup r101, int r102, ColorStateList r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        OIconButtonFloating r105 = c(r100, r101, R.layout.o_widget_titlebar_primary_icon_button);
        View r106 = getDefaultTargetView();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        OMaterialHelper.t(r105, r106);
        r105.setIcon(r102);
        if (r103 == null) goto L6;
        r105.setIconTintColor(r103);
    L6:
        if (r104 == null) goto L9;
        r104.intValue();
        r105.setContentDescription(r105.getContext().getString(r104.intValue()));
    L9:
        return r105;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (h() == true) goto L5;
        return;
    L5:
        int r105 = getTitleBarContentWidth();
        if (r105 > 0) goto L8;
        return;
    L8:
        Pair<Integer, Integer> r106 = f(r105);
        int r107 = r106.component1().intValue();
        int r108 = r106.component2().intValue();
        int r109 = Math.max(0, r108 - r107);
        int r110 = getMFixedCenterContainer().getMeasuredWidth();
        int r111 = (r105 - r110) / 2;
        int r112 = r111 + r110;
        if (r110 <= r109) goto L11;
    L10:
        r111 = r107;
    L17:
        if (this.f402944m == false) goto L20;
        if (r110 > r109) goto L20;
        r111 = r107 + ((r109 - r110) / 2);
        r108 = r111 + r110;
    L20:
        getMFixedCenterContainer().layout(r111, getMFixedCenterContainer().getTop(), r108, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r111 >= r107) goto L13;
        r108 = r107 + r110;
        goto L10
    L13:
        if (r112 <= r108) goto L15;
        r111 = r108 - r110;
        goto L17
    L15:
        r108 = r112;
        goto L17
    }
}

package com.bytedance.ee.bear.widgets.panel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001:\n¤\u0001¥\u0001¦\u0001§\u0001¨\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010;\u001a\u00020<2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u000e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u0015J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J$\u0010F\u001a\u00020<2\b\u0010G\u001a\u0004\u0018\u00010\r2\u0006\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020<H\u0002J\u0010\u0010L\u001a\u00020<2\b\b\u0001\u0010M\u001a\u00020\nJ\u000e\u0010N\u001a\u00020<2\u0006\u0010M\u001a\u00020\nJ\b\u0010O\u001a\u0004\u0018\u00010\rJ\u0006\u0010P\u001a\u00020\u0015J\u0006\u0010Q\u001a\u00020\u000fJ\u0006\u0010R\u001a\u000202J\u0006\u0010S\u001a\u00020\rJ\u000e\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010V\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ!\u0010W\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J!\u0010\\\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J\u000e\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020CJ\u000e\u0010_\u001a\u00020<2\u0006\u0010^\u001a\u00020CJ\u000e\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020\u0015J\u000e\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u0015J\u0010\u0010d\u001a\u00020<2\b\u0010e\u001a\u0004\u0018\u00010YJ!\u0010f\u001a\u00020<2\b\u0010g\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J\u001a\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u00020\"2\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J\u0018\u0010j\u001a\u00020<2\u0006\u0010i\u001a\u00020\r2\u0006\u0010U\u001a\u00020CH\u0002J\u000e\u0010k\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020\nJ&\u0010n\u001a\u00020<2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020\nJ\u000e\u0010s\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010t\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ!\u0010u\u001a\u00020<2\b\b\u0001\u0010v\u001a\u00020\n2\n\b\u0003\u0010w\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010xJ!\u0010y\u001a\u00020<2\b\b\u0001\u0010v\u001a\u00020\n2\n\b\u0003\u0010w\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010xJ\u000e\u0010z\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u0006\u0010{\u001a\u00020<J\u001a\u0010|\u001a\u00020<2\u0006\u0010}\u001a\u00020\n2\b\b\u0001\u0010~\u001a\u00020\nH\u0002J\u0012\u0010\u007f\u001a\u00020<2\b\b\u0001\u0010~\u001a\u00020\nH\u0002J\t\u0010\u0080\u0001\u001a\u00020<H\u0002J\u0012\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010M\u001a\u00020\nH\u0002J\u001b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010M\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u0015H\u0002J\u001c\u0010\u0085\u0001\u001a\u00020\n2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0002J\u0014\u0010\u0089\u0001\u001a\u00020<2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CH\u0016J\u0010\u0010\u008c\u0001\u001a\u00020<2\u0007\u0010\u008d\u0001\u001a\u00020CJ!\u0010\u008e\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u00020\u00152\u0007\u0010\u0090\u0001\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015J\u0010\u0010\u008e\u0001\u001a\u00020<2\u0007\u0010\u0091\u0001\u001a\u00020\u0015J\u0011\u0010\u0092\u0001\u001a\u00020<2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u000b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020<2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0013J\u0011\u0010\u0097\u0001\u001a\u00020<2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001J#\u0010\u0097\u0001\u001a\u00020<2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020C2\u0007\u0010\u009b\u0001\u001a\u00020CJ\t\u0010\u009c\u0001\u001a\u00020<H\u0002J\u000f\u0010\u009d\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u0011\u0010\u009e\u0001\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010YJ\u0007\u0010\u009f\u0001\u001a\u00020:J\"\u0010 \u0001\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\t\u0010¡\u0001\u001a\u0004\u0018\u00010C¢\u0006\u0003\u0010¢\u0001J\u000f\u0010£\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001bR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b'\u0010$R\u001b\u0010)\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b*\u0010$R\u001b\u0010,\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b-\u0010$R\u000e\u0010/\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000¨\u0006©\u0001"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "topBarContainer", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "mDragUtil", "Lcom/bytedance/ee/bear/facade/common/widget/DragView;", "mOnActionListener", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$OnActionListener;", "mMaxHeightPercent", "", "titleBar", "Lcom/bytedance/ee/bear/widgets/panel/PanelTitleBarContainer;", "leftIconIV", "Landroid/widget/ImageView;", "getLeftIconIV", "()Landroid/widget/ImageView;", "leftIconIV$delegate", "Lkotlin/Lazy;", "rightIconIV", "getRightIconIV", "rightIconIV$delegate", "leftTV", "Landroid/widget/TextView;", "getLeftTV", "()Landroid/widget/TextView;", "leftTV$delegate", "rightTV", "getRightTV", "rightTV$delegate", "titleTV", "getTitleTV", "titleTV$delegate", "subTitleTV", "getSubTitleTV", "subTitleTV$delegate", "topBar", ItemStyle.ITEM_STYLE_DIVIDER, "shadowLayout", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "titleBarV2", "dragHandlerContainer", "Landroid/widget/FrameLayout;", "lineDragHandler", "downArrowDragHandler", "titleTvV2", "rightButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxHeightPercent", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "initDragView", "setPanelBackgroundColor", "color", "setPanelBackgroundColorByColorInt", "getConentContainer", "getLimitHeight", "getTopBar", "getShadowLayout", "getDragHandler", "setLeftTextVisible", "visible", "setRightTextVisible", "setLeftText", "text", "", "textColor", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "setRightText", "setLeftTextEnabled", "enabled", "setRightTextEnabled", "setRightTextAlpha", "alpha", "setRightTextSize", "textSize", com.alipay.sdk.m.x.d.f25925o, "title", "setSubTitle", "subTitle", "setText", "view", "setVisible", "setTitleBarVisible", "setTitleBarHeight", "dpHeight", "setTitleBarPadding", "dpLeft", "dpTop", "dpRight", "dpBottom", "setLeftIconVisible", "setRightIconVisible", "setLeftIcon", "resId", "iconColor", "(ILjava/lang/Integer;)V", "setRightIcon", "setDividerVisible", "setShadowSizeNone", "applyHeaderStyle", "style", "panelBackgroundColor", "applyRoundedRightCloseStyle", "styleRightCloseButton", "createCircleBackground", "Landroid/graphics/drawable/GradientDrawable;", "createTopRoundBackground", "cornerRadius", "getNamedColor", "colorName", "", "fallbackColor", "setSlideView", "slideView", "setDragHandlerVisible", "enableDragUp", "enable", "updateDragViewHeight", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "mid", "targetHeight", "setOnDragViewHeightChangeListener", "listener", "Lcom/bytedance/ee/bear/facade/common/widget/DragView$OnHeightChangeListener;", "getDragUtil", "setOnActionListener", "supportInnerRVNestScroll", "recyclerView", "Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView;", "supportNestScrollUp", "supportNestScrollDown", "decorateTitle", "setTitleBarV2Visible", "setTitleV2", "getRightButton", "setRightButton", "isLoading", "(Ljava/lang/CharSequence;Ljava/lang/Boolean;)V", "setRightButtonVisible", "MenuType", "DragHandlerType", "HeaderStyle", "OnActionListener", "SimpleActionListener", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonActionPanelLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f240265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f240266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.widget.d f240267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f240268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f240269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PanelTitleBarContainer f240270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f240271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f240272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f240273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f240274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f240275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f240276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f240277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f240278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public UDShadowLayout f240279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f240280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f240281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f240282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f240283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f240284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public UDButton f240285u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$DragHandlerType;", "", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DragHandlerType {
        public static final a Companion = null;
        public static final int DOWN_ARROW = 1;
        public static final int LINE = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f240286a = null;

            static {
                f240286a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f240286a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$HeaderStyle;", "", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface HeaderStyle {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int ROUNDED_RIGHT_CLOSE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f240287a = null;

            static {
                f240287a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f240287a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$MenuType;", "", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MenuType {
        public static final a Companion = null;
        public static final int ICON = 0;
        public static final int TEXT = 1;
        public static final int UNKNOWN = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f240288a = null;

            static {
                f240288a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f240288a;
        }
    }

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public void a() {
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public void b() {
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public void c() {
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public void d() {
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public void e() {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonActionPanelLayout f240289a;

        public c(CommonActionPanelLayout r100) {
            this.f240289a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f240289a.f240268d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonActionPanelLayout f240290a;

        public d(CommonActionPanelLayout r100) {
            this.f240290a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f240290a.f240268d;
            if (r101 == null) goto L6;
            r101.e();
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonActionPanelLayout f240291a;

        public e(CommonActionPanelLayout r100) {
            this.f240291a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f240291a.f240268d;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonActionPanelLayout f240292a;

        public f(CommonActionPanelLayout r100) {
            this.f240292a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f240292a.f240268d;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }
    }

    private final ImageView getLeftIconIV() {
        return (ImageView) this.f240271g.getValue();
    }

    private final TextView getLeftTV() {
        return (TextView) this.f240273i.getValue();
    }

    private final ImageView getRightIconIV() {
        return (ImageView) this.f240272h.getValue();
    }

    private final TextView getRightTV() {
        return (TextView) this.f240274j.getValue();
    }

    private final TextView getSubTitleTV() {
        return (TextView) this.f240276l.getValue();
    }

    private final TextView getTitleTV() {
        return (TextView) this.f240275k.getValue();
    }

    public final View getDragHandler() {
        FrameLayout r100 = this.f240281q;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dragHandlerContainer");
        return null;
    L6:
        return r100;
    }

    public final UDButton getRightButton() {
        UDButton r100 = this.f240285u;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        return null;
    L6:
        return r100;
    }

    public final UDShadowLayout getShadowLayout() {
        UDShadowLayout r100 = this.f240279o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
        return null;
    L6:
        return r100;
    }

    public final ViewGroup getTopBar() {
        LinearLayout r100 = this.f240277m;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        return null;
    L6:
        return r100;
    }

    public final float getLimitHeight() {
        return n.t() * this.f240269e;
    }

    public final View getConentContainer() {
        return this.f240266b;
    }

    public com.bytedance.ee.bear.facade.common.widget.d getDragUtil() {
        return this.f240267c;
    }

    public CommonActionPanelLayout(Context r100) {
        super(r100);
        this.f240269e = 1.0f;
        this.f240271g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.f240272h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.f240273i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.f240274j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.f240275k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.f240276l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(null);
    }

    public final void b(boolean r100) {
        com.bytedance.ee.bear.facade.common.widget.d r101 = this.f240267c;
        if (r101 == null) goto L6;
        r101.f226595j = r100;
        return;
    }

    public final void d(AttributeSet r110) {
        setOrientation(1);
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.common_panel_topbar_container_layout, this, false);
        this.f240265a = r100;
        addView(r100);
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setOrientation(1);
        this.f240266b = r101;
        addView(r101, new LinearLayout.LayoutParams(-1, -1));
        this.f240277m = (LinearLayout) findViewById(R.id.topBar);
        this.f240281q = (FrameLayout) findViewById(R.id.dragHandlerContainer);
        this.f240282r = findViewById(R.id.lineDragHandler);
        this.f240283s = (ImageView) findViewById(R.id.downArrowDragHandler);
        this.f240278n = findViewById(R.id.divider);
        this.f240270f = (PanelTitleBarContainer) findViewById(R.id.titleBar);
        this.f240280p = (LinearLayout) findViewById(R.id.titleBarV2);
        this.f240284t = (TextView) findViewById(R.id.titleTvV2);
        this.f240285u = (UDButton) findViewById(R.id.rightButton);
        this.f240279o = (UDShadowLayout) findViewById(R.id.shadowLayout);
        if (r110 == null) goto L66;
        TypedArray r102 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.panel_background_color, R.attr.panel_custom_left_icon, R.attr.panel_custom_right_icon, R.attr.panel_drag_handler_type, R.attr.panel_enable_drag, R.attr.panel_header_style, R.attr.panel_left_menu_type, R.attr.panel_left_text, R.attr.panel_left_text_color, R.attr.panel_max_height_percent, R.attr.panel_menu_type, R.attr.panel_right_menu_type, R.attr.panel_right_text, R.attr.panel_right_text_color, R.attr.panel_show_divider, R.attr.panel_show_drag_handler, R.attr.panel_show_left_icon, R.attr.panel_show_shadow, R.attr.panel_show_titlebar, R.attr.panel_title});
        int r103 = r102.getInteger(10, 0);
        int r111 = r102.getInteger(6, 2);
        int r112 = r102.getInteger(11, 2);
        if (r111 != 2) goto L7;
        r111 = r103;
    L7:
        if (r112 == 2) goto L10;
        r103 = r112;
    L10:
        if (r111 == 0) goto L12;
    L14:
        boolean r113 = false;
    L15:
        setLeftIconVisible(r113);
        if (r111 != 0) goto L20;
        Drawable r114 = r102.getDrawable(1);
        if (r114 == null) goto L20;
        getLeftIconIV().setImageDrawable(r114);
    L20:
        if (r103 != 0) goto L25;
        Drawable r115 = r102.getDrawable(2);
        if (r115 == null) goto L25;
        setRightIconVisible(true);
        getRightIconIV().setImageDrawable(r115);
    L25:
        if (r111 != 1) goto L27;
        f(r102.getString(7), Integer.valueOf(r102.getResourceId(8, R.color.text_title)));
    L27:
        if (r103 != 1) goto L29;
        h(r102.getString(12), Integer.valueOf(r102.getResourceId(13, R.color.text_title)));
    L29:
        setTitleBarVisible(r102.getBoolean(18, true));
        setTitle(r102.getString(19));
        setDividerVisible(r102.getBoolean(14, true));
        if (r102.getBoolean(17, true) == true) goto L35;
        UDShadowLayout r104 = this.f240279o;
        if (r104 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
        r104 = null;
    L34:
        r104.setShadowSize(UDShadowLayout.Size.NONE);
    L35:
        setDragHandlerVisible(r102.getBoolean(15, false));
        int r116 = r102.getInt(3, 0);
        View r117 = this.f240282r;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("lineDragHandler");
        r117 = null;
    L38:
        if (r116 != 0) goto L40;
        boolean r118 = true;
    L41:
        j(r117, r118);
        ImageView r119 = this.f240283s;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("downArrowDragHandler");
        r119 = null;
    L44:
        if (r116 != 1) goto L46;
        boolean r120 = true;
    L47:
        j(r119, r120);
        if (r102.getBoolean(4, false) == false) goto L53;
        com.bytedance.ee.bear.facade.common.widget.d r121 = new com.bytedance.ee.bear.facade.common.widget.d(getContext(), getRootView());
        this.f240267c = r121;
        LinearLayout r105 = this.f240277m;
        if (r105 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r105 = null;
    L52:
        r121.i(r105);
        r121.f226595j = false;
        r121.f226593h = new com.bytedance.ee.bear.widgets.panel.a(this);
    L53:
        this.f240269e = r102.getFloat(9, 1.0f);
        int r106 = r102.getResourceId(0, R.color.ccm_widget_common_action_panel_bg_default);
        setPanelBackgroundColor(r106);
        if (r102.getInt(5, 0) != 1) goto L65;
        LinearLayout r122 = this.f240277m;
        if (r122 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r122 = null;
    L58:
        int r107 = getResources().getColor(r106);
        float r123 = getResources().getDimension(R.dimen.space_kit_len_16);
        GradientDrawable r108 = new GradientDrawable();
        r108.setColor(r107);
        r108.setCornerRadii(new float[]{r123, r123, r123, r123, 0.0f, 0.0f, 0.0f, 0.0f});
        r122.setBackground(r108);
        int r109 = getResources().getDimensionPixelSize(R.dimen.space_kit_len_30);
        int r124 = getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        int r125 = getResources().getDimensionPixelSize(R.dimen.space_kit_len_12);
        int r126 = RangesKt.coerceAtLeast((r109 - r124) / 2, 0);
        ViewGroup.LayoutParams r127 = getRightIconIV().getLayoutParams();
        if ((r127 instanceof RelativeLayout.LayoutParams) == false) goto L61;
        RelativeLayout.LayoutParams r128 = (RelativeLayout.LayoutParams) r127;
    L62:
        if (r128 == null) goto L65;
        r128.width = r109;
        r128.height = r109;
        r128.addRule(15, -1);
        r128.setMarginEnd(r125);
        getRightIconIV().setLayoutParams(r128);
        getRightIconIV().setPadding(r126, r126, r126, r126);
        getRightIconIV().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        getRightIconIV().setImageTintList(ColorStateList.valueOf(c("neutral_transparent_50", ColorProtector.parseColor("#80000000"))));
        ImageView r129 = getRightIconIV();
        int r130 = c("picker_base_larus_neutral_transparent_1", ColorProtector.parseColor("#0F000000"));
        GradientDrawable r131 = new GradientDrawable();
        r131.setShape(1);
        r131.setColor(r130);
        r129.setBackground(r131);
        goto L65
    L61:
        r128 = null;
    L65:
        r102.recycle();
        goto L66
    L46:
        r120 = false;
        goto L47
    L40:
        r118 = false;
        goto L41
    L12:
        if (r102.getBoolean(16, true) == false) goto L14;
        r113 = true;
    L66:
        getTitleTV().getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getTitleTV().getPaint().setStrokeWidth(1.0f);
        getTitleTV().setGravity(17);
        getLeftIconIV().setOnClickListener(new c(this));
        getRightIconIV().setOnClickListener(new d(this));
        getLeftTV().setOnClickListener(new e(this));
        getRightTV().setOnClickListener(new f(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        this.f240269e = 1.0f;
        return super.dispatchTouchEvent(r100);
    }

    public final void k(InterceptTouchRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f240267c == null) goto L7;
        r100.setTouchInterceptor(new com.bytedance.ee.bear.widgets.panel.b(this, r100));
        return;
    }

    public final void setDividerVisible(boolean r100) {
        View r101 = this.f240278n;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
        r101 = null;
    L5:
        j(r101, r100);
    }

    public void setDragHandlerVisible(boolean r100) {
        FrameLayout r101 = this.f240281q;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragHandlerContainer");
        r101 = null;
    L5:
        j(r101, r100);
    }

    public final void setLeftIconVisible(boolean r100) {
        j(getLeftIconIV(), r100);
    }

    public final void setLeftTextEnabled(boolean r100) {
        getLeftTV().setEnabled(r100);
    }

    public final void setLeftTextVisible(boolean r100) {
        j(getLeftTV(), r100);
    }

    public final void setMaxHeightPercent(float r100) {
        this.f240269e = r100;
    }

    public final void setOnActionListener(a r100) {
        this.f240268d = r100;
    }

    public final void setOnDragViewHeightChangeListener(com.bytedance.ee.bear.facade.common.widget.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.ee.bear.facade.common.widget.d r101 = this.f240267c;
        if (r101 == null) goto L6;
        r101.f226593h = r100;
        return;
    }

    public final void setPanelBackgroundColor(int r100) {
        LinearLayout r101 = this.f240277m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r101 = null;
    L5:
        r101.setBackgroundTintList(getResources().getColorStateList(r100));
        ViewGroup r102 = this.f240266b;
        if (r102 == null) goto L9;
        r102.setBackgroundColor(getResources().getColor(r100));
        return;
    }

    public final void setPanelBackgroundColorByColorInt(int r100) {
        LinearLayout r101 = this.f240277m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r101 = null;
    L5:
        r101.setBackgroundTintList(ColorStateList.valueOf(r100));
        ViewGroup r102 = this.f240266b;
        if (r102 == null) goto L9;
        r102.setBackgroundColor(r100);
        return;
    }

    public final void setRightButtonVisible(boolean r100) {
        UDButton r101 = this.f240285u;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r101 = null;
    L5:
        j(r101, r100);
    }

    public final void setRightIconVisible(boolean r100) {
        j(getRightIconIV(), r100);
    }

    public final void setRightTextAlpha(float r100) {
        TextView r101 = getRightTV();
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    public final void setRightTextEnabled(boolean r100) {
        getRightTV().setEnabled(r100);
    }

    public final void setRightTextSize(float r100) {
        TextView r101 = getRightTV();
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        return;
    }

    public final void setRightTextVisible(boolean r100) {
        j(getRightTV(), r100);
    }

    public void setSlideView(View r100) {
        if (r100 == null) goto L7;
        com.bytedance.ee.bear.facade.common.widget.d r101 = this.f240267c;
        if (r101 == null) goto L8;
        r101.i(r100);
        return;
    L8:
        return;
    }

    public final void setTitle(CharSequence r100) {
        TextView r101 = getTitleTV();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setText(r100);
        getTitleTV().requestLayout();
    }

    public final void setTitleBarHeight(int r100) {
        PanelTitleBarContainer r101 = this.f240270f;
        PanelTitleBarContainer r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r101 = null;
    L5:
        r101.getLayoutParams().height = n.d(r100);
        PanelTitleBarContainer r103 = this.f240270f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L9:
        r102.requestLayout();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setTitleBarV2Visible(boolean r100) {
        LinearLayout r101 = this.f240280p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarV2");
        r101 = null;
    L5:
        j(r101, r100);
    }

    public final void setTitleBarVisible(boolean r100) {
        PanelTitleBarContainer r101 = this.f240270f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r101 = null;
    L5:
        j(r101, r100);
    }

    public final void setTitleV2(CharSequence r100) {
        TextView r101 = this.f240284t;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTvV2");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public CommonActionPanelLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240269e = 1.0f;
        this.f240271g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.f240272h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.f240273i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.f240274j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.f240275k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.f240276l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(r101);
    }

    public static void j(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 0;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 8;
        goto L5
    }

    public final int c(String r100, int r101) {
        int r102 = getResources().getIdentifier(r100, "color", getContext().getPackageName());
        if (r102 != 0) goto L5;
        return r101;
    L5:
        return getResources().getColor(r102);
    }

    public final void e(int r100, Integer r101) {
        setLeftIconVisible(true);
        getLeftIconIV().setImageResource(kac.a.b(r100));
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        getLeftIconIV().setImageTintList(getResources().getColorStateList(r102));
        return;
    }

    public final void f(CharSequence r100, Integer r101) {
        setLeftTextVisible(true);
        TextView r102 = getLeftTV();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setText(r100);
        if (r101 == null) goto L9;
        int r103 = r101.intValue();
        getLeftTV().setTextColor(getResources().getColorStateList(r103));
        return;
    }

    public final void g(CharSequence r100, Boolean r101) {
        UDButton r102 = this.f240285u;
        String r103 = null;
        String r104 = null;
        UDButton r105 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r102 = null;
    L5:
        r102.setText(r100);
        if (r101 != null) goto L20;
        UDButton r106 = this.f240285u;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r106 = null;
    L10:
        if (r100 == null) goto L12;
        String r107 = r100.toString();
    L13:
        com.larksuite.component.universe_design.button.e.a r108 = com.larksuite.component.universe_design.button.e.f284623a;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        com.larksuite.component.universe_design.button.e.b(r106, r107);
        UDButton r109 = this.f240285u;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r109 = null;
    L16:
        if (r100 == null) goto L18;
        r104 = r100.toString();
    L18:
        com.larksuite.component.universe_design.button.e.b(r109, r104);
        return;
    L12:
        r107 = null;
        goto L13
    L20:
        if (r101.booleanValue() == false) goto L26;
        UDButton r110 = this.f240285u;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
    L25:
        com.larksuite.component.universe_design.button.e.i(r105);
        return;
    L24:
        r105 = r110;
        goto L25
    L26:
        UDButton r111 = this.f240285u;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r111 = null;
    L29:
        Drawable r112 = n.m(getContext(), R.drawable.ud_icon_done_outlined);
        r112.setTint(n.h(getContext(), R.color.function_success_content_default));
        com.larksuite.component.universe_design.button.e.f(r111, r112);
        UDButton r113 = this.f240285u;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r113 = null;
    L32:
        if (r100 == null) goto L34;
        r103 = r100.toString();
    L34:
        Intrinsics.checkNotNullParameter(r113, "<this>");
        com.larksuite.component.universe_design.button.e.b(r113, r103);
    }

    public final void h(CharSequence r100, Integer r101) {
        setRightTextVisible(true);
        TextView r102 = getRightTV();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setText(r100);
        if (r101 == null) goto L9;
        int r103 = r101.intValue();
        getRightTV().setTextColor(getResources().getColorStateList(r103));
        return;
    }

    public final void i(CharSequence r100, Integer r101) {
        j(getSubTitleTV(), true);
        TextView r102 = getSubTitleTV();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setText(r100);
        if (r101 == null) goto L8;
        int r103 = r101.intValue();
        getSubTitleTV().setTextColor(AppCompatResources.getColorStateList(getContext(), r103));
    L8:
        getSubTitleTV().requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (((int) getLimitHeight()) >= getMeasuredHeight()) goto L6;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) getLimitHeight(), Integer.MIN_VALUE));
        return;
    }

    public CommonActionPanelLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240269e = 1.0f;
        this.f240271g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.f240272h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.f240273i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.f240274j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.f240275k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.f240276l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(r101);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (Intrinsics.areEqual(r100, this.f240265a) == false) goto L5;
    L10:
        super.addView(r100, r101, r102);
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.f240266b) == true) goto L10;
        ViewGroup r103 = this.f240266b;
        if (r103 == null) goto L12;
        r103.addView(r100, r101, r102);
        return;
    }

    public final void l(float r100, float r101, float r102) {
        com.bytedance.ee.bear.facade.common.widget.d r103 = this.f240267c;
        if (r103 == null) goto L6;
        r103.m(r100, r101, r102);
        return;
    }
}

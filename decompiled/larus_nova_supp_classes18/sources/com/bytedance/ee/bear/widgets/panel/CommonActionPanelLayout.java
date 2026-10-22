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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001:\n¤\u0001¥\u0001¦\u0001§\u0001¨\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010;\u001a\u00020<2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u000e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u0015J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J$\u0010F\u001a\u00020<2\b\u0010G\u001a\u0004\u0018\u00010\r2\u0006\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020<H\u0002J\u0010\u0010L\u001a\u00020<2\b\b\u0001\u0010M\u001a\u00020\nJ\u000e\u0010N\u001a\u00020<2\u0006\u0010M\u001a\u00020\nJ\b\u0010O\u001a\u0004\u0018\u00010\rJ\u0006\u0010P\u001a\u00020\u0015J\u0006\u0010Q\u001a\u00020\u000fJ\u0006\u0010R\u001a\u000202J\u0006\u0010S\u001a\u00020\rJ\u000e\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010V\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ!\u0010W\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J!\u0010\\\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J\u000e\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020CJ\u000e\u0010_\u001a\u00020<2\u0006\u0010^\u001a\u00020CJ\u000e\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020\u0015J\u000e\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u0015J\u0010\u0010d\u001a\u00020<2\b\u0010e\u001a\u0004\u0018\u00010YJ!\u0010f\u001a\u00020<2\b\u0010g\u001a\u0004\u0018\u00010Y2\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010[J\u001a\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u00020\"2\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J\u0018\u0010j\u001a\u00020<2\u0006\u0010i\u001a\u00020\r2\u0006\u0010U\u001a\u00020CH\u0002J\u000e\u0010k\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020\nJ&\u0010n\u001a\u00020<2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020\nJ\u000e\u0010s\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u000e\u0010t\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ!\u0010u\u001a\u00020<2\b\b\u0001\u0010v\u001a\u00020\n2\n\b\u0003\u0010w\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010xJ!\u0010y\u001a\u00020<2\b\b\u0001\u0010v\u001a\u00020\n2\n\b\u0003\u0010w\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010xJ\u000e\u0010z\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u0006\u0010{\u001a\u00020<J\u001a\u0010|\u001a\u00020<2\u0006\u0010}\u001a\u00020\n2\b\b\u0001\u0010~\u001a\u00020\nH\u0002J\u0012\u0010\u007f\u001a\u00020<2\b\b\u0001\u0010~\u001a\u00020\nH\u0002J\t\u0010\u0080\u0001\u001a\u00020<H\u0002J\u0012\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010M\u001a\u00020\nH\u0002J\u001b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010M\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u0015H\u0002J\u001c\u0010\u0085\u0001\u001a\u00020\n2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0002J\u0014\u0010\u0089\u0001\u001a\u00020<2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u0011\u0010\u008b\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CH\u0016J\u0010\u0010\u008c\u0001\u001a\u00020<2\u0007\u0010\u008d\u0001\u001a\u00020CJ!\u0010\u008e\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u00020\u00152\u0007\u0010\u0090\u0001\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015J\u0010\u0010\u008e\u0001\u001a\u00020<2\u0007\u0010\u0091\u0001\u001a\u00020\u0015J\u0011\u0010\u0092\u0001\u001a\u00020<2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u000b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020<2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0013J\u0011\u0010\u0097\u0001\u001a\u00020<2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001J#\u0010\u0097\u0001\u001a\u00020<2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020C2\u0007\u0010\u009b\u0001\u001a\u00020CJ\t\u0010\u009c\u0001\u001a\u00020<H\u0002J\u000f\u0010\u009d\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CJ\u0011\u0010\u009e\u0001\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010YJ\u0007\u0010\u009f\u0001\u001a\u00020:J\"\u0010 \u0001\u001a\u00020<2\b\u0010X\u001a\u0004\u0018\u00010Y2\t\u0010¡\u0001\u001a\u0004\u0018\u00010C¢\u0006\u0003\u0010¢\u0001J\u000f\u0010£\u0001\u001a\u00020<2\u0006\u0010U\u001a\u00020CR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001bR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b'\u0010$R\u001b\u0010)\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b*\u0010$R\u001b\u0010,\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b-\u0010$R\u000e\u0010/\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000¨\u0006©\u0001"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "topBarContainer", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "mDragUtil", "Lcom/bytedance/ee/bear/facade/common/widget/DragView;", "mOnActionListener", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$OnActionListener;", "mMaxHeightPercent", "", "titleBar", "Lcom/bytedance/ee/bear/widgets/panel/PanelTitleBarContainer;", "leftIconIV", "Landroid/widget/ImageView;", "getLeftIconIV", "()Landroid/widget/ImageView;", "leftIconIV$delegate", "Lkotlin/Lazy;", "rightIconIV", "getRightIconIV", "rightIconIV$delegate", "leftTV", "Landroid/widget/TextView;", "getLeftTV", "()Landroid/widget/TextView;", "leftTV$delegate", "rightTV", "getRightTV", "rightTV$delegate", "titleTV", "getTitleTV", "titleTV$delegate", "subTitleTV", "getSubTitleTV", "subTitleTV$delegate", "topBar", "divider", "shadowLayout", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "titleBarV2", "dragHandlerContainer", "Landroid/widget/FrameLayout;", "lineDragHandler", "downArrowDragHandler", "titleTvV2", "rightButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxHeightPercent", "max", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "addView", "child", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "initDragView", "setPanelBackgroundColor", "color", "setPanelBackgroundColorByColorInt", "getConentContainer", "getLimitHeight", "getTopBar", "getShadowLayout", "getDragHandler", "setLeftTextVisible", "visible", "setRightTextVisible", "setLeftText", "text", "", "textColor", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "setRightText", "setLeftTextEnabled", "enabled", "setRightTextEnabled", "setRightTextAlpha", "alpha", "setRightTextSize", "textSize", "setTitle", "title", "setSubTitle", "subTitle", "setText", "view", "setVisible", "setTitleBarVisible", "setTitleBarHeight", "dpHeight", "setTitleBarPadding", "dpLeft", "dpTop", "dpRight", "dpBottom", "setLeftIconVisible", "setRightIconVisible", "setLeftIcon", "resId", "iconColor", "(ILjava/lang/Integer;)V", "setRightIcon", "setDividerVisible", "setShadowSizeNone", "applyHeaderStyle", "style", "panelBackgroundColor", "applyRoundedRightCloseStyle", "styleRightCloseButton", "createCircleBackground", "Landroid/graphics/drawable/GradientDrawable;", "createTopRoundBackground", "cornerRadius", "getNamedColor", "colorName", "", "fallbackColor", "setSlideView", "slideView", "setDragHandlerVisible", "enableDragUp", "enable", "updateDragViewHeight", "min", "mid", "targetHeight", "setOnDragViewHeightChangeListener", "listener", "Lcom/bytedance/ee/bear/facade/common/widget/DragView$OnHeightChangeListener;", "getDragUtil", "setOnActionListener", "supportInnerRVNestScroll", "recyclerView", "Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView;", "supportNestScrollUp", "supportNestScrollDown", "decorateTitle", "setTitleBarV2Visible", "setTitleV2", "getRightButton", "setRightButton", "isLoading", "(Ljava/lang/CharSequence;Ljava/lang/Boolean;)V", "setRightButtonVisible", "MenuType", "DragHandlerType", "HeaderStyle", "OnActionListener", "SimpleActionListener", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonActionPanelLayout extends LinearLayout {
    public View a;
    public ViewGroup b;
    public com.bytedance.ee.bear.facade.common.widget.d c;
    public a d;
    public float e;
    public PanelTitleBarContainer f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public LinearLayout m;
    public View n;
    public UDShadowLayout o;
    public LinearLayout p;
    public FrameLayout q;
    public View r;
    public ImageView s;
    public TextView t;
    public UDButton u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout$DragHandlerType;", "", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DragHandlerType {
        public static final a Companion = null;
        public static final int DOWN_ARROW = 1;
        public static final int LINE = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
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
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
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
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
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
        public final /* synthetic */ CommonActionPanelLayout a;

        public c(CommonActionPanelLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CommonActionPanelLayout a;

        public d(CommonActionPanelLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.e();
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ CommonActionPanelLayout a;

        public e(CommonActionPanelLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ CommonActionPanelLayout a;

        public f(CommonActionPanelLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.c();
            return;
        }
    }

    private final ImageView getLeftIconIV() {
        return (ImageView) this.g.getValue();
    }

    private final TextView getLeftTV() {
        return (TextView) this.i.getValue();
    }

    private final ImageView getRightIconIV() {
        return (ImageView) this.h.getValue();
    }

    private final TextView getRightTV() {
        return (TextView) this.j.getValue();
    }

    private final TextView getSubTitleTV() {
        return (TextView) this.l.getValue();
    }

    private final TextView getTitleTV() {
        return (TextView) this.k.getValue();
    }

    public final View getDragHandler() {
        FrameLayout r0 = this.q;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dragHandlerContainer");
        return null;
    L6:
        return r0;
    }

    public final UDButton getRightButton() {
        UDButton r0 = this.u;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        return null;
    L6:
        return r0;
    }

    public final UDShadowLayout getShadowLayout() {
        UDShadowLayout r0 = this.o;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
        return null;
    L6:
        return r0;
    }

    public final ViewGroup getTopBar() {
        LinearLayout r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        return null;
    L6:
        return r0;
    }

    public final float getLimitHeight() {
        return n.t() * this.e;
    }

    public final View getConentContainer() {
        return this.b;
    }

    public com.bytedance.ee.bear.facade.common.widget.d getDragUtil() {
        return this.c;
    }

    public CommonActionPanelLayout(Context r1) {
        super(r1);
        this.e = 1.0f;
        this.g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(null);
    }

    public final void b(boolean r2) {
        com.bytedance.ee.bear.facade.common.widget.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.j = r2;
        return;
    }

    public final void d(AttributeSet r17) {
        setOrientation(1);
        View r3 = LayoutInflater.from(getContext()).inflate(2131559894, this, false);
        this.a = r3;
        addView(r3);
        LinearLayout r4 = new LinearLayout(getContext());
        r4.setOrientation(1);
        this.b = r4;
        addView(r4, new LinearLayout.LayoutParams(-1, -1));
        this.m = (LinearLayout) findViewById(2131389094);
        this.q = (FrameLayout) findViewById(2131370196);
        this.r = findViewById(2131377905);
        this.s = (ImageView) findViewById(2131370139);
        this.n = findViewById(2131369197);
        this.f = (PanelTitleBarContainer) findViewById(2131388775);
        this.p = (LinearLayout) findViewById(2131388776);
        this.t = (TextView) findViewById(2131388794);
        this.u = (UDButton) findViewById(2131384503);
        this.o = (UDShadowLayout) findViewById(2131386033);
        if (r17 == null) goto L66;
        TypedArray r1 = getContext().obtainStyledAttributes(r17, new int[]{2130973437, 2130973438, 2130973439, 2130973440, 2130973441, 2130973442, 2130973443, 2130973444, 2130973445, 2130973446, 2130973447, 2130973448, 2130973449, 2130973450, 2130973451, 2130973452, 2130973453, 2130973454, 2130973455, 2130973456});
        int r7 = r1.getInteger(10, 0);
        int r10 = r1.getInteger(6, 2);
        int r11 = r1.getInteger(11, 2);
        if (r10 != 2) goto L7;
        r10 = r7;
    L7:
        if (r11 == 2) goto L10;
        r7 = r11;
    L10:
        if (r10 == 0) goto L12;
    L14:
        boolean r12 = false;
    L15:
        setLeftIconVisible(r12);
        if (r10 != 0) goto L20;
        Drawable r13 = r1.getDrawable(1);
        if (r13 == null) goto L20;
        getLeftIconIV().setImageDrawable(r13);
    L20:
        if (r7 != 0) goto L25;
        Drawable r14 = r1.getDrawable(2);
        if (r14 == null) goto L25;
        setRightIconVisible(true);
        getRightIconIV().setImageDrawable(r14);
    L25:
        if (r10 != 1) goto L27;
        f(r1.getString(7), Integer.valueOf(r1.getResourceId(8, 2131106622)));
    L27:
        if (r7 != 1) goto L29;
        h(r1.getString(12), Integer.valueOf(r1.getResourceId(13, 2131106622)));
    L29:
        setTitleBarVisible(r1.getBoolean(18, true));
        setTitle(r1.getString(19));
        setDividerVisible(r1.getBoolean(14, true));
        if (r1.getBoolean(17, true) == true) goto L35;
        UDShadowLayout r8 = this.o;
        if (r8 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
        r8 = null;
    L34:
        r8.setShadowSize(UDShadowLayout.Size.NONE);
    L35:
        setDragHandlerVisible(r1.getBoolean(15, false));
        int r15 = r1.getInt(3, 0);
        View r16 = this.r;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("lineDragHandler");
        r16 = null;
    L38:
        if (r15 != 0) goto L40;
        boolean r18 = true;
    L41:
        j(r16, r18);
        ImageView r19 = this.s;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("downArrowDragHandler");
        r19 = null;
    L44:
        if (r15 != 1) goto L46;
        boolean r110 = true;
    L47:
        j(r19, r110);
        if (r1.getBoolean(4, false) == false) goto L53;
        com.bytedance.ee.bear.facade.common.widget.d r111 = new com.bytedance.ee.bear.facade.common.widget.d(getContext(), getRootView());
        this.c = r111;
        LinearLayout r5 = this.m;
        if (r5 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r5 = null;
    L52:
        r111.i(r5);
        r111.j = false;
        r111.h = new com.bytedance.ee.bear.widgets.panel.a(this);
    L53:
        this.e = r1.getFloat(9, 1.0f);
        int r6 = r1.getResourceId(0, 2131100778);
        setPanelBackgroundColor(r6);
        if (r1.getInt(5, 0) != 1) goto L65;
        LinearLayout r112 = this.m;
        if (r112 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r112 = null;
    L58:
        int r9 = getResources().getColor(r6);
        float r113 = getResources().getDimension(2131168315);
        GradientDrawable r20 = new GradientDrawable();
        r20.setColor(r9);
        r20.setCornerRadii(new float[]{r113, r113, r113, r113, 0.0f, 0.0f, 0.0f, 0.0f});
        r112.setBackground(r20);
        int r21 = getResources().getDimensionPixelSize(2131168334);
        int r22 = getResources().getDimensionPixelSize(2131168315);
        int r23 = getResources().getDimensionPixelSize(2131168304);
        int r24 = RangesKt.coerceAtLeast((r21 - r22) / 2, 0);
        ViewGroup.LayoutParams r25 = getRightIconIV().getLayoutParams();
        if ((r25 instanceof RelativeLayout.LayoutParams) == false) goto L61;
        RelativeLayout.LayoutParams r114 = (RelativeLayout.LayoutParams) r25;
    L62:
        if (r114 == null) goto L65;
        r114.width = r21;
        r114.height = r21;
        r114.addRule(15, -1);
        r114.setMarginEnd(r23);
        getRightIconIV().setLayoutParams(r114);
        getRightIconIV().setPadding(r24, r24, r24, r24);
        getRightIconIV().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        getRightIconIV().setImageTintList(ColorStateList.valueOf(c("neutral_transparent_50", ColorProtector.parseColor("#80000000"))));
        ImageView r26 = getRightIconIV();
        int r27 = c("picker_base_larus_neutral_transparent_1", ColorProtector.parseColor("#0F000000"));
        GradientDrawable r28 = new GradientDrawable();
        r28.setShape(1);
        r28.setColor(r27);
        r26.setBackground(r28);
        goto L65
    L61:
        r114 = null;
    L65:
        r1.recycle();
        goto L66
    L46:
        r110 = false;
        goto L47
    L40:
        r18 = false;
        goto L41
    L12:
        if (r1.getBoolean(16, true) == false) goto L14;
        r12 = true;
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
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        this.e = 1.0f;
        return super.dispatchTouchEvent(r2);
    }

    public final void k(InterceptTouchRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (this.c == null) goto L7;
        r2.setTouchInterceptor(new com.bytedance.ee.bear.widgets.panel.b(this, r2));
        return;
    }

    public final void setDividerVisible(boolean r2) {
        View r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("divider");
        r0 = null;
    L5:
        j(r0, r2);
    }

    public void setDragHandlerVisible(boolean r2) {
        FrameLayout r0 = this.q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragHandlerContainer");
        r0 = null;
    L5:
        j(r0, r2);
    }

    public final void setLeftIconVisible(boolean r2) {
        j(getLeftIconIV(), r2);
    }

    public final void setLeftTextEnabled(boolean r2) {
        getLeftTV().setEnabled(r2);
    }

    public final void setLeftTextVisible(boolean r2) {
        j(getLeftTV(), r2);
    }

    public final void setMaxHeightPercent(float r1) {
        this.e = r1;
    }

    public final void setOnActionListener(a r1) {
        this.d = r1;
    }

    public final void setOnDragViewHeightChangeListener(com.bytedance.ee.bear.facade.common.widget.d.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.ee.bear.facade.common.widget.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.h = r2;
        return;
    }

    public final void setPanelBackgroundColor(int r3) {
        LinearLayout r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r0 = null;
    L5:
        r0.setBackgroundTintList(getResources().getColorStateList(r3));
        ViewGroup r1 = this.b;
        if (r1 == null) goto L9;
        r1.setBackgroundColor(getResources().getColor(r3));
        return;
    }

    public final void setPanelBackgroundColorByColorInt(int r3) {
        LinearLayout r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBar");
        r0 = null;
    L5:
        r0.setBackgroundTintList(ColorStateList.valueOf(r3));
        ViewGroup r1 = this.b;
        if (r1 == null) goto L9;
        r1.setBackgroundColor(r3);
        return;
    }

    public final void setRightButtonVisible(boolean r2) {
        View r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r0 = null;
    L5:
        j(r0, r2);
    }

    public final void setRightIconVisible(boolean r2) {
        j(getRightIconIV(), r2);
    }

    public final void setRightTextAlpha(float r2) {
        TextView r0 = getRightTV();
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public final void setRightTextEnabled(boolean r2) {
        getRightTV().setEnabled(r2);
    }

    public final void setRightTextSize(float r2) {
        TextView r0 = getRightTV();
        if (r0 == null) goto L6;
        r0.setTextSize(r2);
        return;
    }

    public final void setRightTextVisible(boolean r2) {
        j(getRightTV(), r2);
    }

    public void setSlideView(View r2) {
        if (r2 == null) goto L7;
        com.bytedance.ee.bear.facade.common.widget.d r0 = this.c;
        if (r0 == null) goto L8;
        r0.i(r2);
        return;
    L8:
        return;
    }

    public final void setTitle(CharSequence r2) {
        TextView r0 = getTitleTV();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setText(r2);
        getTitleTV().requestLayout();
    }

    public final void setTitleBarHeight(int r4) {
        PanelTitleBarContainer r0 = this.f;
        PanelTitleBarContainer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r0 = null;
    L5:
        r0.getLayoutParams().height = n.d(r4);
        PanelTitleBarContainer r5 = this.f;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L9:
        r1.requestLayout();
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setTitleBarV2Visible(boolean r2) {
        LinearLayout r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarV2");
        r0 = null;
    L5:
        j(r0, r2);
    }

    public final void setTitleBarVisible(boolean r2) {
        PanelTitleBarContainer r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r0 = null;
    L5:
        j(r0, r2);
    }

    public final void setTitleV2(CharSequence r2) {
        TextView r0 = this.t;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTvV2");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public CommonActionPanelLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = 1.0f;
        this.g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(r2);
    }

    public static void j(View r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        r0.setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public final int c(String r4, int r5) {
        int r6 = getResources().getIdentifier(r4, "color", getContext().getPackageName());
        if (r6 != 0) goto L5;
        return r5;
    L5:
        return getResources().getColor(r6);
    }

    public final void e(int r2, Integer r3) {
        setLeftIconVisible(true);
        getLeftIconIV().setImageResource(kac.a.b(r2));
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
        getLeftIconIV().setImageTintList(getResources().getColorStateList(r4));
        return;
    }

    public final void f(CharSequence r2, Integer r3) {
        setLeftTextVisible(true);
        TextView r0 = getLeftTV();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setText(r2);
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
        getLeftTV().setTextColor(getResources().getColorStateList(r4));
        return;
    }

    public final void g(CharSequence r7, Boolean r8) {
        Button r0 = this.u;
        String r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r0 = null;
    L5:
        r0.setText(r7);
        if (r8 != null) goto L20;
        UDButton r9 = this.u;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r9 = null;
    L10:
        if (r7 == null) goto L12;
        String r3 = r7.toString();
    L13:
        com.larksuite.component.universe_design.button.e.a r4 = com.larksuite.component.universe_design.button.e.a;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        com.larksuite.component.universe_design.button.e.b(r9, r3);
        UDButton r10 = this.u;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r10 = null;
    L16:
        if (r7 == null) goto L18;
        r2 = r7.toString();
    L18:
        com.larksuite.component.universe_design.button.e.b(r10, r2);
        return;
    L12:
        r3 = null;
        goto L13
    L20:
        if (r8.booleanValue() == false) goto L26;
        String r11 = this.u;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
    L25:
        com.larksuite.component.universe_design.button.e.i(r2);
        return;
    L24:
        r2 = r11;
        goto L25
    L26:
        UDButton r12 = this.u;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r12 = null;
    L29:
        Drawable r5 = n.m(getContext(), 2131254251);
        r5.setTint(n.h(getContext(), 2131102153));
        com.larksuite.component.universe_design.button.e.f(r12, r5);
        UDButton r13 = this.u;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("rightButton");
        r13 = null;
    L32:
        if (r7 == null) goto L34;
        r2 = r7.toString();
    L34:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        com.larksuite.component.universe_design.button.e.b(r13, r2);
    }

    public final void h(CharSequence r2, Integer r3) {
        setRightTextVisible(true);
        TextView r0 = getRightTV();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setText(r2);
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
        getRightTV().setTextColor(getResources().getColorStateList(r4));
        return;
    }

    public final void i(CharSequence r3, Integer r4) {
        j(getSubTitleTV(), true);
        TextView r0 = getSubTitleTV();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.setText(r3);
        if (r4 == null) goto L8;
        int r5 = r4.intValue();
        getSubTitleTV().setTextColor(AppCompatResources.getColorStateList(getContext(), r5));
    L8:
        getSubTitleTV().requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (((int) getLimitHeight()) >= getMeasuredHeight()) goto L6;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec((int) getLimitHeight(), Integer.MIN_VALUE));
        return;
    }

    public CommonActionPanelLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = 1.0f;
        this.g = LazyKt.lazy(new CommonActionPanelLayout$leftIconIV$2(this));
        this.h = LazyKt.lazy(new CommonActionPanelLayout$rightIconIV$2(this));
        this.i = LazyKt.lazy(new CommonActionPanelLayout$leftTV$2(this));
        this.j = LazyKt.lazy(new CommonActionPanelLayout$rightTV$2(this));
        this.k = LazyKt.lazy(new CommonActionPanelLayout$titleTV$2(this));
        this.l = LazyKt.lazy(new CommonActionPanelLayout$subTitleTV$2(this));
        d(r2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (Intrinsics.areEqual(r2, this.a) == false) goto L5;
    L10:
        super.addView(r2, r3, r4);
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.b) == true) goto L10;
        ViewGroup r0 = this.b;
        if (r0 == null) goto L12;
        r0.addView(r2, r3, r4);
        return;
    }

    public final void l(float r2, float r3, float r4) {
        com.bytedance.ee.bear.facade.common.widget.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.m(r2, r3, r4);
        return;
    }
}

package com.larksuite.component.universe_design.timepicker.impl.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import e18.e;
import e18.f;
import h18.d;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u0000 ²\u00012\u00020\u0001:\u0006°\u0001±\u0001²\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010a\u001a\u00020b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010c\u001a\u00020bH\u0002J0\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020!2\u0006\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020!H\u0014J\b\u0010j\u001a\u00020bH\u0002J\b\u0010k\u001a\u00020\u001eH\u0014J\b\u0010l\u001a\u00020\u001eH\u0014J\b\u0010m\u001a\u00020bH\u0002J\b\u0010n\u001a\u00020bH\u0002J\u000e\u0010o\u001a\u00020b2\u0006\u0010p\u001a\u00020qJ\u000e\u0010r\u001a\u00020b2\u0006\u0010s\u001a\u00020\u001eJ\u0006\u0010t\u001a\u00020bJ\u0006\u0010u\u001a\u00020bJ\u0006\u0010y\u001a\u00020bJ\u0010\u0010z\u001a\u00020b2\u0006\u0010{\u001a\u00020|H\u0014J.\u0010}\u001a\u00020b2\u0006\u0010{\u001a\u00020|2\u0006\u0010~\u001a\u00020\u001e2\u000e\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RH\u0002¢\u0006\u0003\u0010\u0080\u0001J+\u0010\u0081\u0001\u001a\u00020\u001e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00162\u000e\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RH\u0002¢\u0006\u0003\u0010\u0082\u0001J\u001d\u0010\u0083\u0001\u001a\u00020b2\u0007\u0010\u0084\u0001\u001a\u00020\u001e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020b2\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u001e2\u0007\u0010\u008a\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020!H\u0002J\u0014\u0010\u008d\u0001\u001a\u00020J2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u008f\u0001\u001a\u00020b2\u0006\u0010@\u001a\u00020!2\u0007\u0010\u0090\u0001\u001a\u00020!H\u0014J\u0013\u0010\u0091\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0010\u0010\u0094\u0001\u001a\u00020b2\u0007\u0010\u0095\u0001\u001a\u00020\u001eJ\"\u0010\u0096\u0001\u001a\u00020!2\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00162\u0007\u0010\u0097\u0001\u001a\u00020!H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020,2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020bH\u0014J\u0010\u0010\u009c\u0001\u001a\u00020b2\u0007\u0010\u009d\u0001\u001a\u00020!J\u0010\u0010\u009e\u0001\u001a\u00020b2\u0007\u0010\u009f\u0001\u001a\u00020,J\u0010\u0010 \u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020,J\u0010\u0010¢\u0001\u001a\u00020b2\u0007\u0010£\u0001\u001a\u00020(J\u0010\u0010¤\u0001\u001a\u00020b2\u0007\u0010¥\u0001\u001a\u00020\u001eJ\u0010\u0010¦\u0001\u001a\u00020b2\u0007\u0010¥\u0001\u001a\u00020\u001eJ\u0012\u0010§\u0001\u001a\u00020b2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\\J\u0011\u0010©\u0001\u001a\u00020b2\b\u0010I\u001a\u0004\u0018\u00010JJ\u000f\u0010ª\u0001\u001a\u00020b2\u0006\u0010)\u001a\u00020!J\u000f\u0010«\u0001\u001a\u00020b2\u0006\u0010*\u001a\u00020!J\u0011\u0010¬\u0001\u001a\u00020b2\b\u0010C\u001a\u0004\u0018\u00010DJ\u0012\u0010\u00ad\u0001\u001a\u00020b2\t\u0010®\u0001\u001a\u0004\u0018\u00010YJ\u000f\u0010¯\u0001\u001a\u00020b2\u0006\u0010P\u001a\u00020!R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00162\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001a\u00105\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u000e\u0010=\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170RX\u0084\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010v\u001a\u00020!2\u0006\u0010v\u001a\u00020!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u00107\"\u0004\bx\u00109R\u0016\u0010\u0087\u0001\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010$R\u0013\u0010\u009a\u0001\u001a\u00020!8F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u00107¨\u0006³\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wheelHandler", "Landroid/os/Handler;", "getWheelHandler", "()Landroid/os/Handler;", "setWheelHandler", "(Landroid/os/Handler;)V", "mExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "paintCenterText", "Landroid/text/TextPaint;", "paintIndicator", "Landroid/graphics/Paint;", "value", "Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "", "adapter", "getAdapter", "()Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;", "setAdapter", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;)V", "textSize", "", "outTextSize", "maxTextHeight", "", "itemHeight", "getItemHeight", "()F", "setItemHeight", "(F)V", "typeface", "Landroid/graphics/Typeface;", "textColorCenter", "dividerColor", "isLoop", "", "()Z", "setLoop", "(Z)V", "firstLineY", "secondLineY", "totalScrollY", "getTotalScrollY", "setTotalScrollY", "initPosition", "getInitPosition", "()I", "setInitPosition", "(I)V", "preCurrentIndex", "getPreCurrentIndex", "setPreCurrentIndex", "itemsVisible", "wheelMeasuredHeight", "wheelMeasuredWidth", "widthMeasureSpec", "mLastDownTime", "", "dividerType", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$DividerType;", "gestureDetector", "Landroid/view/GestureDetector;", "mFuture", "Ljava/util/concurrent/ScheduledFuture;", "label", "", "selectedItemIndex", "mOffset", "mLastDownEventY", "mShowTwoFigure", "mScaledVerticalScrollFactor", "dividerExtraStart", "mVisibleItems", "", "getMVisibleItems", "()[Ljava/lang/Object;", "setMVisibleItems", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "mLoopChangeListener", "Lcom/larksuite/component/universe_design/timepicker/impl/base/ILoopChangeListener;", "isScrollChangeDrawn", "itemSelectedListener", "Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;", "getItemSelectedListener", "()Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;", "setItemSelectedListener", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/OnItemSelectedListener;)V", "initView", "", "initPaints", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "initializeFadingEdges", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "remeasure", "measureTextWidthHeight", "smoothScroll", "action", "Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$ACTION;", "scrollBy", "velocityY", "cancelFuture", "selectCurrentItem", "currentItem", "getCurrentItem", "setCurrentItem", "onItemSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawWheelContent", "itemHeightOffset", "visibleItems", "(Landroid/graphics/Canvas;F[Ljava/lang/Object;)V", "updateVisibleItems", "(Lcom/larksuite/component/universe_design/timepicker/impl/base/BaseWheelAdapter;[Ljava/lang/Object;)F", "updateSelectedItem", "itemCenterY", "visibleItem", "drawDivider", "centerTextBaseLine", "getCenterTextBaseLine", "getScaleTextSize", "translateY", "getLoopMappingIndex", "index", "getContentText", MapController.ITEM_LAYER_TAG, "onMeasure", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "checkLoopChange", "scrollDy", "calculateLoopNextIndex", "nextCurrentIndex", "onGenericMotionEvent", "onDetachedFromWindow", "itemsCount", "getItemsCount", "setItemVisible", "itemVisible", "setShowTwoFigure", "showTwoFigure", "setCyclic", "cyclic", "setTypeface", LynxResourceModule.FONT_TYPE, "setTextSize", "dpSize", "setTextSizeOuter", "setOnItemSelectedListener", "onItemSelectedListener", "setLabel", "setTextColorCenter", "setDividerColor", "setDividerType", "setLoopChangeListener", "listener", "setDividerExtraStart", "ACTION", "DividerType", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WheelView extends View {
    public static final a Companion = null;
    public static final float DEFAULT_WHEEL_CENTER_TEXT_SIZE_DP = 17.0f;
    public static final float DEFAULT_WHEEL_OUTER_TEXT_SIZE_DP = 14.0f;
    private static final int IGNORE_SCROLL_OFFSET_THRESHOLD = 10;
    private static final String TAG = "WheelView";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 1.0f;
    private static final int VELOCITY_FLING = 5;
    public static final int WHEEL_ITEM_HEIGHT = 48;
    private e18.a<? extends Object> adapter;
    private int dividerColor;
    private int dividerExtraStart;
    private DividerType dividerType;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private int initPosition;
    private boolean isLoop;
    private boolean isScrollChangeDrawn;
    private float itemHeight;
    private OnItemSelectedListener itemSelectedListener;
    private int itemsVisible;
    private String label;
    private final ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private float mLastDownEventY;
    private long mLastDownTime;
    private e18.b mLoopChangeListener;
    private float mOffset;
    private final float mScaledVerticalScrollFactor;
    private boolean mShowTwoFigure;
    private Object[] mVisibleItems;
    private int maxTextHeight;
    private float outTextSize;
    private TextPaint paintCenterText;
    private Paint paintIndicator;
    private int preCurrentIndex;
    private float secondLineY;
    private int selectedItemIndex;
    private int textColorCenter;
    private float textSize;
    private float totalScrollY;
    private Typeface typeface;
    public Handler wheelHandler;
    private int wheelMeasuredHeight;
    private int wheelMeasuredWidth;
    private int widthMeasureSpec;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$ACTION;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK", "FLING", "DAGGLE", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ACTION extends Enum<ACTION> {
        public static final ACTION CLICK = null;
        public static final ACTION DAGGLE = null;
        public static final ACTION FLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ACTION[] f285388a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285389b = null;

        public static EnumEntries<ACTION> getEntries() {
            return f285389b;
        }

        static {
            ACTION r100 = new ACTION("CLICK", 0);
            CLICK = r100;
            ACTION r101 = new ACTION("FLING", 1);
            FLING = r101;
            ACTION r102 = new ACTION("DAGGLE", 2);
            DAGGLE = r102;
            ACTION[] r103 = {r100, r101, r102};
            f285388a = r103;
            f285389b = EnumEntriesKt.enumEntries(r103);
        }

        public static ACTION[] values() {
            return (ACTION[]) f285388a.clone();
        }

        public static ACTION valueOf(String r100) {
            return (ACTION) r27.a.a(ACTION.class, r100);
        }

        public ACTION(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/base/WheelView$DividerType;", "", "<init>", "(Ljava/lang/String;I)V", "FILL", "EXTRA", UserProfileEvent.POSITION_NONE, "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DividerType extends Enum<DividerType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DividerType[] $VALUES = null;
        public static final DividerType EXTRA = null;
        public static final DividerType FILL = null;
        public static final DividerType NONE = null;

        private static final /* synthetic */ DividerType[] $values() {
            return new DividerType[]{FILL, EXTRA, NONE};
        }

        public static EnumEntries<DividerType> getEntries() {
            return $ENTRIES;
        }

        static {
            FILL = new DividerType("FILL", 0);
            EXTRA = new DividerType("EXTRA", 1);
            NONE = new DividerType(UserProfileEvent.POSITION_NONE, 2);
            DividerType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static DividerType[] values() {
            return (DividerType[]) $VALUES.clone();
        }

        public static DividerType valueOf(String r100) {
            return (DividerType) r27.a.a(DividerType.class, r100);
        }

        private DividerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f285390a;

        public b(WheelView r100) {
            this.f285390a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e18.b r100 = WheelView.access$getMLoopChangeListener$p(this.f285390a);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnItemSelectedListener f285391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WheelView f285392b;

        public c(OnItemSelectedListener r100, WheelView r101) {
            this.f285391a = r100;
            this.f285392b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f285391a.onItemSelected(this.f285392b.getCurrentItem());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WheelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    private final void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((int) this.firstLineY);
    }

    public final synchronized void cancelFuture() {
        monitor-enter(this);
        ScheduledFuture<?> r100 = this.mFuture;     // Catch: Throwable -> L17
        if (r100 == null) goto L15;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        if (r101 == true) goto L15;
        ScheduledFuture<?> r102 = this.mFuture;     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        r102.cancel(true);     // Catch: Throwable -> L17
    L14:
        this.mFuture = null;     // Catch: Throwable -> L17
        goto L15
    L8:
        if (r100.isCancelled() != true) goto L10;
        r101 = true;
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 1.0f;
    }

    private final float getCenterTextBaseLine() {
        TextPaint r100 = this.paintCenterText;
        if (r100 == null) goto L9;
        Paint.FontMetrics r101 = r100.getFontMetrics();
        if (r101 == null) goto L11;
        float r102 = r101.bottom;
        return ((r102 - r101.top) / 2) - r102;
    L11:
        return 0.0f;
    L9:
        return 0.0f;
    }

    private final void initPaints() {
        TextPaint r100 = new TextPaint();
        r100.setColor(this.textColorCenter);
        r100.setAntiAlias(true);
        r100.setTypeface(this.typeface);
        r100.setTextSize(r100.getTextSize());
        r100.setTextAlign(Paint.Align.CENTER);
        this.paintCenterText = r100;
        Paint r101 = new Paint();
        r101.setColor(this.dividerColor);
        r101.setAntiAlias(true);
        this.paintIndicator = r101;
    }

    private final void measureTextWidthHeight() {
        TextPaint r100 = this.paintCenterText;
        if (r100 == null) goto L5;
        r100.setTextSize(this.textSize);
    L5:
        Rect r101 = new Rect();
        TextPaint r102 = this.paintCenterText;
        if (r102 == null) goto L8;
        r102.getTextBounds("星期", 0, 2, r101);
    L8:
        this.maxTextHeight = r101.height() + 2;
    }

    private final void remeasure() {
        if (this.adapter != null) goto L5;
        return;
    L5:
        measureTextWidthHeight();
        float r100 = d.b(getContext(), 48);
        this.itemHeight = r100;
        this.wheelMeasuredHeight = (int) (r100 * (this.itemsVisible - 2));
        this.wheelMeasuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int r101 = this.wheelMeasuredHeight;
        float r102 = this.itemHeight;
        this.firstLineY = (r101 - r102) / 2.0f;
        this.secondLineY = (r101 + r102) / 2.0f;
        if (this.initPosition != (-1)) goto L14;
        e18.a<? extends Object> r103 = this.adapter;
        if (this.isLoop == false) goto L11;
        if (r103 == null) goto L11;
        int r104 = (r103.getItemsCount() + 1) / 2;
    L12:
        this.initPosition = r104;
        this.preCurrentIndex = r104;
        return;
    L11:
        r104 = 0;
        goto L12
    }

    public final int getItemsCount() {
        e18.a<? extends Object> r100 = this.adapter;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getItemsCount();
    }

    public final Handler getWheelHandler() {
        Handler r100 = this.wheelHandler;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("wheelHandler");
        return null;
    }

    public final void onItemSelected() {
        OnItemSelectedListener r100 = this.itemSelectedListener;
        if (r100 == null) goto L6;
        post(new c(r100, this));
        return;
    }

    public final void selectCurrentItem() {
        OnItemSelectedListener r100 = this.itemSelectedListener;
        if (r100 == null) goto L6;
        r100.onItemSelected(getCurrentItem());
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelFuture();
    }

    public final e18.a<? extends Object> getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        return this.selectedItemIndex;
    }

    public final int getInitPosition() {
        return this.initPosition;
    }

    public final float getItemHeight() {
        return this.itemHeight;
    }

    public final OnItemSelectedListener getItemSelectedListener() {
        return this.itemSelectedListener;
    }

    public final Object[] getMVisibleItems() {
        return this.mVisibleItems;
    }

    public final int getPreCurrentIndex() {
        return this.preCurrentIndex;
    }

    public final float getTotalScrollY() {
        return this.totalScrollY;
    }

    public final boolean isLoop() {
        return this.isLoop;
    }

    public static final /* synthetic */ e18.b access$getMLoopChangeListener$p(WheelView r100) {
        return r100.mLoopChangeListener;
    }

    private final void drawDivider(Canvas r110) {
        Paint r100 = this.paintIndicator;
        if (r100 != null) goto L5;
        return;
    L5:
        DividerType r101 = this.dividerType;
        if (r101 != DividerType.EXTRA) goto L16;
        float r102 = this.dividerExtraStart;
        int r103 = this.wheelMeasuredWidth;
        if (r102 <= r103) goto L10;
    L13:
        float r104 = 0.0f;
    L14:
        float r105 = r103 - r104;
        float r106 = this.firstLineY;
        float r107 = r104;
        r110.drawLine(r107, r106, r105, r106, r100);
        float r108 = this.secondLineY;
        r110.drawLine(r107, r108, r105, r108, r100);
        return;
    L10:
        if (r102 < 0.0f) goto L13;
        r104 = r102;
        goto L14
    L16:
        if (r101 != DividerType.FILL) goto L20;
        float r109 = this.firstLineY;
        r110.drawLine(0.0f, r109, this.wheelMeasuredWidth, r109, r100);
        float r111 = this.secondLineY;
        r110.drawLine(0.0f, r111, this.wheelMeasuredWidth, r111, r100);
        return;
    }

    private final String getContentText(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof e18.c) == false) goto L10;
        return ((e18.c) r100).a();
    L10:
        if ((r100 instanceof Integer) == false) goto L16;
        if (this.mShowTwoFigure == false) goto L16;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{r100}, 1));
    L16:
        return r100.toString();
    }

    private final int getLoopMappingIndex(int r100) {
        e18.a<? extends Object> r101 = this.adapter;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.getItemsCount() > 0) goto L8;
        return 0;
    L8:
        if (r100 >= 0) goto L11;
        return getLoopMappingIndex(r100 + r101.getItemsCount());
    L11:
        if (r100 > (r101.getItemsCount() - 1)) goto L13;
        return r100;
    L13:
        return getLoopMappingIndex(r100 - r101.getItemsCount());
    }

    private final float getScaleTextSize(float r100) {
        float r101 = this.textSize;
        return Math.min(Math.max(r101 - (Math.abs(r100 - (this.wheelMeasuredHeight / 2.0f)) * ((r101 - this.outTextSize) / this.itemHeight)), this.outTextSize), this.textSize);
    }

    private final void initView(Context r100) {
        setWheelHandler(new com.larksuite.component.universe_design.timepicker.impl.base.a(this));
        GestureDetector r101 = new GestureDetector(r100, new e(this));
        this.gestureDetector = r101;
        r101.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    public final void checkLoopChange(float r100) {
        e18.a<? extends Object> r101 = this.adapter;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.isLoop == true) goto L8;
        return;
    L8:
        if (this.mLoopChangeListener == null) goto L36;
        int r102 = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % r101.getItemsCount());
        float r103 = this.totalScrollY % this.itemHeight;
        if (Math.abs(r103) > (this.itemHeight - 10)) goto L13;
    L16:
        int r104 = calculateLoopNextIndex(r101, r102);
        boolean r105 = true;
        if (r100 <= 0.0f) goto L22;
        if (r104 < this.preCurrentIndex) goto L25;
    L24:
        r105 = false;
    L25:
        if (r105 == true) goto L27;
        return;
    L27:
        if (this.mLoopChangeListener != null) goto L29;
        return;
    L29:
        if (this.isScrollChangeDrawn == true) goto L31;
        return;
    L31:
        this.isScrollChangeDrawn = false;
        post(new b(this));
        return;
    L22:
        if (r104 <= this.preCurrentIndex) goto L24;
    L13:
        if (r103 <= 0.0f) goto L15;
        r102 = r102 + 1;
        goto L16
    L15:
        r102 = r102 - 1;
        goto L16
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        e18.a<? extends Object> r101 = this.adapter;
        if (r101 != null) goto L5;
        return;
    L5:
        Object[] r102 = this.mVisibleItems;
        float r103 = updateVisibleItems(r101, r102);
        drawDivider(r100);
        drawWheelContent(r100, r103, r102);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        GestureDetector r100 = this.gestureDetector;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r100 = null;
    L5:
        boolean r101 = r100.onTouchEvent(r110);
        if (r110.isFromSource(2) == true) goto L8;
    L28:
        invalidate();
        return super.onGenericMotionEvent(r110);
    L8:
        if (r110.getAction() != 8) goto L28;
        float r102 = (-r110.getAxisValue(9)) * this.mScaledVerticalScrollFactor;
        this.totalScrollY += r102;
        e18.a<? extends Object> r103 = this.adapter;
        if (this.isLoop == true) goto L24;
        if (r103 == null) goto L24;
        float r104 = (-this.initPosition) * this.itemHeight;
        float r105 = (r103.getItemsCount() - 1) - this.initPosition;
        float r106 = this.itemHeight;
        float r107 = r105 * r106;
        float r108 = this.totalScrollY;
        if ((((double) r108) - (((double) r106) * 0.25d)) >= r104) goto L16;
        r104 = r108 - r102;
    L19:
        if (r108 >= r104) goto L22;
        this.totalScrollY = r104;
        goto L24
    L22:
        if (r108 <= r107) goto L24;
        this.totalScrollY = r107;
        goto L24
    L16:
        if ((((double) r108) + (((double) r106) * 0.25d)) <= r107) goto L19;
        r107 = r108 - r102;
    L24:
        checkLoopChange(r102);
        if (r101 == true) goto L28;
        smoothScroll(ACTION.DAGGLE);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        GestureDetector r100 = this.gestureDetector;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r100 = null;
    L5:
        boolean r101 = r100.onTouchEvent(r110);
        int r102 = r110.getAction();
        if (r102 != 0) goto L8;
        this.mLastDownTime = System.currentTimeMillis();
        cancelFuture();
        this.mLastDownEventY = r110.getRawY();
    L38:
        invalidate();
        return true;
    L8:
        if (r102 == 2) goto L21;
        if (r101 == true) goto L38;
        float r111 = r110.getY();
        float r103 = this.itemHeight;
        int r112 = (int) (r111 / r103);
        if (Math.abs(this.totalScrollY % r103) >= 10.0f) goto L13;
        float r104 = 0.0f;
    L17:
        this.mOffset = ((r112 - ((this.itemsVisible - 2) / 2)) * this.itemHeight) + r104;
        if ((System.currentTimeMillis() - this.mLastDownTime) <= 120) goto L20;
        smoothScroll(ACTION.DAGGLE);
        goto L38
    L20:
        smoothScroll(ACTION.CLICK);
        goto L38
    L13:
        float r105 = this.totalScrollY;
        float r106 = this.itemHeight;
        float r107 = ((r105 % r106) + r106) % r106;
        if (r107 <= (r106 / 2.0f)) goto L16;
        r104 = r106 - r107;
        goto L17
    L16:
        r104 = -r107;
        goto L17
    L21:
        float r108 = this.mLastDownEventY - r110.getRawY();
        this.mLastDownEventY = r110.getRawY();
        this.totalScrollY += r108;
        e18.a<? extends Object> r113 = this.adapter;
        if (this.isLoop == true) goto L36;
        if (r113 == null) goto L36;
        float r109 = (-this.initPosition) * this.itemHeight;
        float r114 = (r113.getItemsCount() - 1) - this.initPosition;
        float r115 = this.itemHeight;
        float r116 = r114 * r115;
        float r117 = this.totalScrollY;
        if ((((double) r117) - (((double) r115) * 0.25d)) >= r109) goto L28;
        r109 = r117 - r108;
    L31:
        if (r117 >= r109) goto L34;
        this.totalScrollY = r109;
        goto L36
    L34:
        if (r117 <= r116) goto L36;
        this.totalScrollY = r116;
        goto L36
    L28:
        if ((((double) r117) + (((double) r115) * 0.25d)) <= r116) goto L31;
        r116 = r117 - r108;
    L36:
        checkLoopChange(r108);
        goto L38
    }

    public final void scrollBy(float r100) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new e18.d(this, r100), 0, 5, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(e18.a<? extends Object> r100) {
        this.adapter = r100;
        invalidate();
    }

    public final void setCurrentItem(int r100) {
        this.selectedItemIndex = r100;
        this.initPosition = r100;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean r100) {
        this.isLoop = r100;
    }

    public final void setDividerColor(int r100) {
        if (r100 == 0) goto L7;
        this.dividerColor = r100;
        Paint r101 = this.paintIndicator;
        if (r101 == null) goto L8;
        r101.setColor(r100);
        return;
    L8:
        return;
    }

    public final void setDividerExtraStart(int r100) {
        this.dividerExtraStart = r100;
    }

    public final void setDividerType(DividerType r100) {
        this.dividerType = r100;
    }

    public final void setInitPosition(int r100) {
        this.initPosition = r100;
    }

    public final void setItemHeight(float r100) {
        this.itemHeight = r100;
    }

    public final void setItemSelectedListener(OnItemSelectedListener r100) {
        this.itemSelectedListener = r100;
    }

    public final void setItemVisible(int r100) {
        if (r100 == this.itemsVisible) goto L5;
        this.mVisibleItems = new Object[r100];
    L5:
        this.itemsVisible = r100;
        requestLayout();
    }

    public final void setLabel(String r100) {
        this.label = r100;
    }

    public final void setLoop(boolean r100) {
        this.isLoop = r100;
    }

    public final void setLoopChangeListener(e18.b r100) {
        this.mLoopChangeListener = r100;
    }

    public final void setMVisibleItems(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mVisibleItems = r100;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener r100) {
        this.itemSelectedListener = r100;
    }

    public final void setPreCurrentIndex(int r100) {
        this.preCurrentIndex = r100;
    }

    public final void setShowTwoFigure(boolean r100) {
        this.mShowTwoFigure = r100;
    }

    public final void setTextColorCenter(int r100) {
        if (r100 == 0) goto L7;
        this.textColorCenter = r100;
        TextPaint r101 = this.paintCenterText;
        if (r101 == null) goto L8;
        r101.setColor(r100);
        return;
    L8:
        return;
    }

    public final void setTextSize(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        float r101 = d.a(getContext(), r100);
        this.textSize = r101;
        TextPaint r102 = this.paintCenterText;
        if (r102 == null) goto L9;
        r102.setTextSize(r101);
        return;
    }

    public final void setTextSizeOuter(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        this.outTextSize = d.a(getContext(), r100);
    }

    public final void setTotalScrollY(float r100) {
        this.totalScrollY = r100;
    }

    public final void setTypeface(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, LynxResourceModule.FONT_TYPE);
        this.typeface = r100;
        TextPaint r101 = this.paintCenterText;
        if (r101 == null) goto L6;
        r101.setTypeface(r100);
        return;
    }

    public final void setWheelHandler(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.wheelHandler = r100;
    }

    public final void smoothScroll(ACTION r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        cancelFuture();
        if (r100 != ACTION.FLING) goto L5;
    L6:
        float r101 = this.totalScrollY;
        float r102 = this.itemHeight;
        float r103 = ((r101 % r102) + r102) % r102;
        this.mOffset = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        float r104 = r102 - r103;
    L10:
        this.mOffset = r104;
    L11:
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new f(this, this.mOffset), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        r104 = -r103;
        goto L10
    L5:
        if (r100 != ACTION.DAGGLE) goto L11;
        goto L6
    }

    public WheelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.mExecutor = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("ase/WheelView"));
        this.typeface = h18.e.a(r100);
        this.itemsVisible = 5;
        this.mVisibleItems = new Object[5];
        this.isScrollChangeDrawn = true;
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(ViewConfiguration.get(r100), r100);
        this.textSize = d.a(r100, 17.0f);
        this.outTextSize = d.a(r100, 14.0f);
        this.dividerColor = r100.getResources().getColor(R.color.line_border_card);
        this.textColorCenter = r100.getResources().getColor(R.color.text_title);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.fontFamily, R.attr.ud_wheelView_dividerColor, R.attr.ud_wheelView_textColorCenter, R.attr.ud_wheelView_textSize}, 0, 0);
        this.textColorCenter = r102.getColor(2, this.textColorCenter);
        this.dividerColor = r102.getColor(1, this.dividerColor);
        this.textSize = r102.getDimensionPixelOffset(3, (int) this.textSize);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "typedArray");
        int r103 = r102.getResourceId(0, 0);
        if (r103 > 0) goto L12;
        Typeface r104 = Typeface.DEFAULT;
    L8:
        if (r104 != null) goto L10;
        r104 = Typeface.DEFAULT;
    L10:
        this.typeface = r104;
        r102.recycle();
        initView(r100);
        return;
    L12:
        r104 = ResourcesCompat.getFont(r100, r103);     // Catch: Resources.NotFoundException -> L6
    L6:
        r104 = Typeface.DEFAULT;
        goto L8
    }

    private final int calculateLoopNextIndex(e18.a<? extends Object> r100, int r101) {
        if (r101 >= 0) goto L5;
        r101 = r101 + r100.getItemsCount();
    L5:
        if (r101 > (r100.getItemsCount() - 1)) goto L7;
        return r101;
    L7:
        return r101 - r100.getItemsCount();
    }

    private final void updateSelectedItem(float r100, Object r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        e18.a<? extends Object> r102 = this.adapter;
        if (r102 != null) goto L7;
        return;
    L7:
        float r103 = this.firstLineY;
        if (r100 > r103) goto L14;
        int r104 = this.maxTextHeight;
        if (((r104 / 2.0f) + r100) < r103) goto L14;
        if ((r103 - r100) >= ((r100 + r104) - r103)) goto L27;
        this.selectedItemIndex = r102.a(r101);
        return;
    L27:
        return;
    L14:
        float r105 = this.secondLineY;
        if (r100 > r105) goto L21;
        int r106 = this.maxTextHeight;
        if (((r106 / 2.0f) + r100) < r105) goto L21;
        if ((r105 - r100) <= ((r100 + r106) - r105)) goto L29;
        this.selectedItemIndex = r102.a(r101);
        return;
    L29:
        return;
    L21:
        int r107 = this.maxTextHeight;
        if (r100 >= (r103 + (r107 / 2.0f))) goto L24;
        return;
    L24:
        if (((r107 / 2.0f) + r100) > r105) goto L32;
        this.selectedItemIndex = r102.a(r101);
        return;
    }

    private final float updateVisibleItems(e18.a<?> r100, Object[] r101) {
        int r102 = 0;
        if (this.initPosition >= 0) goto L6;
        this.initPosition = 0;
    L6:
        if (this.initPosition < r100.getItemsCount()) goto L47;
        this.initPosition = r100.getItemsCount() - 1;
    L47:
        this.preCurrentIndex = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % r100.getItemsCount());     // Catch: ArithmeticException -> L11
    L12:
        float r103 = this.totalScrollY % this.itemHeight;
        float r104 = Math.abs(r103);
        float r105 = this.itemHeight;
        if (r104 <= (r105 - 10)) goto L19;
        if (r103 <= 0.0f) goto L17;
        this.preCurrentIndex++;
        r103 = -(r105 - Math.abs(r103));
        goto L19
    L17:
        this.preCurrentIndex--;
        r103 = r105 - Math.abs(r103);
    L19:
        if (this.isLoop == false) goto L21;
        int r106 = this.preCurrentIndex;
        if (r106 >= 0) goto L30;
        this.preCurrentIndex = r106 + r100.getItemsCount();
    L30:
        if (this.preCurrentIndex <= (r100.getItemsCount() - 1)) goto L32;
        this.preCurrentIndex -= r100.getItemsCount();
    L32:
        this.isScrollChangeDrawn = true;
    L33:
        int r107 = this.itemsVisible;
        if (r102 >= r107) goto L46;
        int r108 = this.preCurrentIndex - ((r107 / 2) - r102);
        if (this.isLoop == false) goto L39;
        r101[r102] = r100.getItem(getLoopMappingIndex(r108));
    L45:
        r102 = r102 + 1;
        goto L33
    L39:
        if (r108 >= 0) goto L42;
        r101[r102] = "";
        goto L45
    L42:
        if (r108 <= (r100.getItemsCount() - 1)) goto L44;
        r101[r102] = "";
        goto L45
    L44:
        r101[r102] = r100.getItem(r108);
        goto L45
    L46:
        return r103;
    L21:
        if (this.preCurrentIndex >= 0) goto L24;
        this.preCurrentIndex = 0;
    L24:
        if (this.preCurrentIndex <= (r100.getItemsCount() - 1)) goto L32;
        this.preCurrentIndex = r100.getItemsCount() - 1;
        goto L32
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        this.widthMeasureSpec = r100;
        remeasure();
        setMeasuredDimension(this.wheelMeasuredWidth, this.wheelMeasuredHeight);
    }

    private final void drawWheelContent(Canvas r110, float r111, Object[] r112) {
        TextPaint r100 = this.paintCenterText;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.itemsVisible;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L18;
        if (Math.abs(r111) >= 5.0f) goto L13;
        if (r102 == 0) goto L17;
        if (r102 != (this.itemsVisible - 1)) goto L13;
    L17:
        r102 = r102 + 1;
    L13:
        float r103 = this.itemHeight;
        float r104 = (((r102 - 1) * r103) - r111) + (r103 / 2.0f);
        Object r105 = r112[r102];
        String r106 = getContentText(r105);
        if (TextUtils.isEmpty(this.label) == true) goto L16;
        r106 = r106 + this.label;
    L16:
        r100.setTextSize(getScaleTextSize(r104));
        r110.drawText(TextUtils.ellipsize(r106, r100, this.wheelMeasuredWidth, TextUtils.TruncateAt.END).toString(), this.wheelMeasuredWidth / 2.0f, getCenterTextBaseLine() + r104, r100);
        updateSelectedItem(r104, r105);
        r100.setTextSize(this.textSize);
        goto L17
    }

    public /* synthetic */ WheelView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (r100 == false) goto L5;
        initializeFadingEdges();
        return;
    }
}

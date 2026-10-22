package com.ss.android.lark.feed.app.tablayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.math.MathUtils;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 Ú\u00012\u00020\u0001:\u0004Ú\u0001Û\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000b2\b\b\u0002\u0010Q\u001a\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u0011J\u000e\u0010S\u001a\u00020O2\u0006\u0010T\u001a\u00020UJ+\u0010*\u001a\u00020O2\b\b\u0002\u0010V\u001a\u00020&2\u0019\b\u0002\u0010W\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020O0X¢\u0006\u0002\bYJ!\u0010Z\u001a\u00020O2\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020O0X¢\u0006\u0002\bYJ\b\u0010[\u001a\u00020OH\u0014J\b\u0010\\\u001a\u00020OH\u0014J\b\u0010]\u001a\u00020OH\u0014J\u0010\u0010^\u001a\u00020O2\u0006\u0010_\u001a\u00020KH\u0016J\u0010\u0010`\u001a\u00020O2\u0006\u0010_\u001a\u00020KH\u0016J\b\u0010a\u001a\u00020OH\u0016J\u0010\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020O2\u0006\u0010c\u001a\u00020dH\u0014J \u0010f\u001a\u00020\u00112\u0006\u0010c\u001a\u00020d2\u0006\u0010_\u001a\u00020K2\u0006\u0010g\u001a\u00020\u001eH\u0014J\u0010\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020jH\u0014J\u0018\u0010q\u001a\u00020O2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000bH\u0014J\u0018\u0010t\u001a\u00020O2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000bH\u0007J0\u0010u\u001a\u00020O2\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000bH\u0014J(\u0010{\u001a\u00020O2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0084\u0001\u001a\u00020O2\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0016J/\u0010\u0086\u0001\u001a\u00020O2\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000bJ\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0014J\u0015\u0010\u0089\u0001\u001a\u00030\u0088\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0089\u0001\u001a\u00030\u0088\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0014J\u0013\u0010\u0097\u0001\u001a\u00020\u00112\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010\u009a\u0001\u001a\u00020\u00112\b\u0010\u009b\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010ª\u0001\u001a\u00020O2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\"\u0010\u00ad\u0001\u001a\u00020O2\u0007\u0010«\u0001\u001a\u00020\u000b2\u0007\u0010®\u0001\u001a\u00020\u000b2\u0007\u0010¯\u0001\u001a\u00020\u000bJ\u0010\u0010°\u0001\u001a\u00020O2\u0007\u0010±\u0001\u001a\u00020\u000bJ\u0007\u0010²\u0001\u001a\u00020OJ\u0013\u0010³\u0001\u001a\u00020\u00112\b\u0010´\u0001\u001a\u00030¬\u0001H\u0016J\u001b\u0010µ\u0001\u001a\u00020O2\u0007\u0010¶\u0001\u001a\u00020\u000b2\u0007\u0010·\u0001\u001a\u00020\u000bH\u0016J\t\u0010¸\u0001\u001a\u00020OH\u0016J\u0007\u0010¹\u0001\u001a\u00020\u000bJ\u0007\u0010º\u0001\u001a\u00020\u000bJ\u0018\u0010»\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000b2\u0007\u0010¼\u0001\u001a\u00020\u0011J\u0019\u0010Ã\u0001\u001a\u00020O2\u0007\u0010Ä\u0001\u001a\u00020\u000b2\u0007\u0010Å\u0001\u001a\u00020\u000bJ\u0010\u0010Æ\u0001\u001a\u00020O2\u0007\u0010\u0016\u001a\u00030¬\u0001J\u0007\u0010Ç\u0001\u001a\u00020OJ\u0010\u0010Ð\u0001\u001a\u00020O2\u0007\u0010Ñ\u0001\u001a\u00020\u000bJ#\u0010Ò\u0001\u001a\u00020O2\u0007\u0010Ó\u0001\u001a\u00020\u000b2\b\u0010Ô\u0001\u001a\u00030¬\u00012\u0007\u0010Õ\u0001\u001a\u00020\u000bJ\u0010\u0010Ö\u0001\u001a\u00020O2\u0007\u0010Ó\u0001\u001a\u00020\u000bJ\u0015\u0010×\u0001\u001a\u00020O2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0014J\f\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0016\u001a\u0004\u0018\u00010&@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR\u001a\u00105\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001a\u00108\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001a\u0010;\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bI\u0010\rR\u0013\u0010J\u001a\u0004\u0018\u00010K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010k\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000fR\u001a\u0010n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\r\"\u0004\bp\u0010\u000fR\u0013\u0010\u0080\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0013R\u001d\u0010\u0081\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\r\"\u0005\b\u0083\u0001\u0010\u000fR \u0010\u008d\u0001\u001a\u00030\u008e\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010G\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0092\u0001\u001a\u00030\u0093\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010G\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0013\u0010\u009c\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010\u0013R\u0013\u0010\u009e\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010\rR\u0013\u0010 \u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\rR\u0013\u0010¢\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\rR\u0013\u0010¤\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010\rR\u0013\u0010¦\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b§\u0001\u0010\rR\u0013\u0010¨\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b©\u0001\u0010\rR \u0010½\u0001\u001a\u00030¾\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bÁ\u0001\u0010G\u001a\u0006\b¿\u0001\u0010À\u0001R\u0013\u0010Â\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010\u0013R!\u0010È\u0001\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001d\u0010Í\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\r\"\u0005\bÏ\u0001\u0010\u000f¨\u0006Ü\u0001"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttributeSet", "()Landroid/util/AttributeSet;", "itemDefaultHeight", "", "getItemDefaultHeight", "()I", "setItemDefaultHeight", "(I)V", "drawIndicator", "", "getDrawIndicator", "()Z", "setDrawIndicator", "(Z)V", "value", "Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;", "tabIndicator", "getTabIndicator", "()Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;", "setTabIndicator", "(Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;)V", "tabIndicatorAnimationDuration", "", "getTabIndicatorAnimationDuration", "()J", "setTabIndicatorAnimationDuration", "(J)V", "tabDefaultIndex", "getTabDefaultIndex", "setTabDefaultIndex", "Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", "tabLayoutConfig", "getTabLayoutConfig", "()Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", "setTabLayoutConfig", "(Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;)V", "tabEnableSelectorMode", "getTabEnableSelectorMode", "setTabEnableSelectorMode", "layoutScrollAnim", "getLayoutScrollAnim", "setLayoutScrollAnim", "scrollAnimDuration", "getScrollAnimDuration", "setScrollAnimDuration", "_minFlingVelocity", "get_minFlingVelocity", "set_minFlingVelocity", "_maxFlingVelocity", "get_maxFlingVelocity", "set_maxFlingVelocity", "_touchSlop", "get_touchSlop", "set_touchSlop", "_tempRect", "Landroid/graphics/Rect;", "get_tempRect", "()Landroid/graphics/Rect;", "feedSelector", "Lcom/ss/android/lark/feed/app/tablayout/FeedSelector;", "getFeedSelector", "()Lcom/ss/android/lark/feed/app/tablayout/FeedSelector;", "feedSelector$delegate", "Lkotlin/Lazy;", "currentItemIndex", "getCurrentItemIndex", "currentItemView", "Landroid/view/View;", "getCurrentItemView", "()Landroid/view/View;", "setCurrentItem", "", "index", "notify", "fromUser", "setupViewPager", "viewPagerDelegate", "Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;", "config", "doIt", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "configTabLayoutConfig", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onViewAdded", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "onViewRemoved", "updateTabLayout", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawChild", "drawingTime", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "_childAllWidthSum", "get_childAllWidthSum", "set_childAllWidthSum", "_maxConvexHeight", "get_maxConvexHeight", "set_maxConvexHeight", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHorizontal", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onSizeChanged", "w", "h", "oldw", "oldh", "isLayoutRtl", "_layoutDirection", "get_layoutDirection", "set_layoutDirection", "onRtlPropertiesChanged", "layoutDirection", "layoutHorizontal", "generateDefaultLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "attrs", "p", "Landroid/view/ViewGroup$LayoutParams;", "_overScroller", "Landroid/widget/OverScroller;", "get_overScroller", "()Landroid/widget/OverScroller;", "_overScroller$delegate", "_gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "get_gestureDetector", "()Landroidx/core/view/GestureDetectorCompat;", "_gestureDetector$delegate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "needScroll", "getNeedScroll", "maxScrollX", "getMaxScrollX", "maxScrollY", "getMaxScrollY", "minScrollX", "getMinScrollX", "minScrollY", "getMinScrollY", "maxWidth", "getMaxWidth", "maxHeight", "getMaxHeight", "onFlingChange", "velocity", "", "startFling", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "startScroll", "dv", "restoreScroll", "onScrollChange", "distance", "scrollTo", "x", "y", "computeScroll", "getViewTargetX", "getViewTargetY", "scrollToTarget", "scrollAnim", "_scrollAnimator", "Landroid/animation/ValueAnimator;", "get_scrollAnimator", "()Landroid/animation/ValueAnimator;", "_scrollAnimator$delegate", "isAnimatorStart", "animateToItem", "fromIndex", "toIndex", "onAnimateValue", "onAnimateEnd", "_viewPagerDelegate", "get_viewPagerDelegate", "()Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;", "set_viewPagerDelegate", "(Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;)V", "_viewPagerScrollState", "get_viewPagerScrollState", "set_viewPagerScrollState", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "positionOffsetPixels", "onPageSelected", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onSaveInstanceState", "Companion", "LayoutParams", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RefactoredFeedTabLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeSet f420794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f420795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f420796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedTabIndicator f420797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f420798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f420799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeedTabLayoutConfig f420800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f420801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f420802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f420803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f420805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f420806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f420807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f420808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f420809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f420810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f420811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f420812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f420813t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f420814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f420815v;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000eB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0006\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "width", "", "height", "(II)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "(IIF)V", "layoutWidth", "", "getLayoutWidth", "()Ljava/lang/String;", "setLayoutWidth", "(Ljava/lang/String;)V", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "layoutConvexHeight", "getLayoutConvexHeight", "()I", "setLayoutConvexHeight", "(I)V", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "weight", "getWeight", "()F", "setWeight", "(F)V", "highlightDrawable", "Landroid/graphics/drawable/Drawable;", "getHighlightDrawable", "()Landroid/graphics/drawable/Drawable;", "setHighlightDrawable", "(Landroid/graphics/drawable/Drawable;)V", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f420816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f420817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f420818c;

        public LayoutParams(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f420817b = -1;
            this.f420818c = -1;
            if ((r100 instanceof LayoutParams) == false) goto L6;
            LayoutParams r101 = (LayoutParams) r100;
            r101.getClass();
            this.f420816a = r101.f420816a;
            return;
        }

        public LayoutParams(int r100) {
            super(-2, r100);
            this.f420817b = -1;
            this.f420818c = -1;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            super(r100, r101);
            this.f420817b = -1;
            this.f420818c = -1;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_tab_height, R.attr.layout_tab_indicator_content_id, R.attr.layout_tab_indicator_content_index, R.attr.layout_tab_weight, R.attr.layout_tab_width});
            r102.getString(4);
            r102.getString(0);
            this.f420817b = r102.getInt(2, -1);
            this.f420818c = r102.getResourceId(1, -1);
            r102.getFloat(3, -1.0f);
            r102.recycle();
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout$setTabLayoutConfig$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<FeedTabLayoutConfig, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedTabLayoutConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedTabLayoutConfig r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final i get_viewPagerDelegate() {
        return null;
    }

    public final void set_viewPagerDelegate(i r100) {
    }

    public final void setupViewPager(i r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPagerDelegate");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2);
    }

    public final e getFeedSelector() {
        return (e) this.f420808o.getValue();
    }

    public final int getMaxHeight() {
        return (this.f420809p + getPaddingTop()) + getPaddingBottom();
    }

    public final int getMaxWidth() {
        return (this.f420809p + getPaddingStart()) + getPaddingEnd();
    }

    public final int getMinScrollY() {
        if (this.f420801h == true) goto L7;
        return 0;
    L7:
        return (-c.a(this)) / 2;
    }

    public final boolean getNeedScroll() {
        if (this.f420801h == false) goto L6;
        return true;
    L6:
        if (a() == false) goto L11;
        if (getMinScrollX() < 0) goto L16;
    L13:
        return false;
    L16:
        return true;
    L11:
        if (getMaxScrollX() <= 0) goto L13;
        return true;
    }

    public final int getViewTargetX() {
        int r100 = this.f420797d.f420768p;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return getPaddingStart() + (c.b(this) / 2);
    L11:
        return getMeasuredWidth() - getPaddingEnd();
    L9:
        return getPaddingStart();
    }

    public final int getViewTargetY() {
        int r100 = this.f420797d.f420768p;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return getPaddingTop() + (c.a(this) / 2);
    L11:
        return getMeasuredHeight() - getPaddingBottom();
    L9:
        return getPaddingTop();
    }

    public final GestureDetectorCompat get_gestureDetector() {
        return (GestureDetectorCompat) this.f420813t.getValue();
    }

    public final OverScroller get_overScroller() {
        return (OverScroller) this.f420812s.getValue();
    }

    public final ValueAnimator get_scrollAnimator() {
        return (ValueAnimator) this.f420814u.getValue();
    }

    public final boolean a() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (get_overScroller().computeScrollOffset() == false) goto L10;
        scrollTo(get_overScroller().getCurrX(), get_overScroller().getCurrY());
        invalidate();
        if (get_overScroller().getCurrX() >= getMinScrollX()) goto L7;
    L8:
        get_overScroller().abortAnimation();
        return;
    L7:
        if (get_overScroller().getCurrX() > getMaxScrollX()) goto L8;
        return;
    }

    public final int getCurrentItemIndex() {
        return getFeedSelector().f420842h;
    }

    public final View getCurrentItemView() {
        return (View) CollectionsKt.getOrNull(getFeedSelector().f420837c, getCurrentItemIndex());
    }

    public final int getMaxScrollX() {
        if (a() == true) goto L5;
        int r100 = getMaxWidth() - getMeasuredWidth();
        if (this.f420801h == false) goto L10;
        int r101 = c.b(this) / 2;
    L12:
        return Math.max(r100 + r101, 0);
    L10:
        r101 = 0;
        goto L12
    L5:
        if (this.f420801h == true) goto L14;
        return 0;
    L14:
        return c.b(this) / 2;
    }

    public final int getMaxScrollY() {
        int r100 = getMaxHeight() - getMeasuredHeight();
        if (this.f420801h == false) goto L5;
        int r101 = c.a(this) / 2;
    L7:
        return Math.max(r100 + r101, 0);
    L5:
        r101 = 0;
        goto L7
    }

    public final int getMinScrollX() {
        if (a() == false) goto L10;
        int r100 = getMaxWidth() - getMeasuredWidth();
        if (this.f420801h == false) goto L7;
        int r101 = c.b(this) / 2;
    L13:
        return Math.min(-(r100 + r101), 0);
    L7:
        r101 = 0;
        goto L13
    L10:
        if (this.f420801h == true) goto L12;
        return 0;
    L12:
        return (-c.b(this)) / 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getFeedSelector().f420842h >= 0) goto L6;
        e(this, this.f420799f, false, 6);
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r100 = super.onSaveInstanceState();
        Bundle r101 = new Bundle();
        r101.putParcelable("old", r100);
        r101.putInt("defaultIndex", this.f420799f);
        r101.putInt("currentIndex", getCurrentItemIndex());
        return r101;
    }

    public final AttributeSet getAttributeSet() {
        return this.f420794a;
    }

    public final boolean getDrawIndicator() {
        return this.f420796c;
    }

    public final int getItemDefaultHeight() {
        return this.f420795b;
    }

    public final boolean getLayoutScrollAnim() {
        return this.f420802i;
    }

    public final int getScrollAnimDuration() {
        return this.f420803j;
    }

    public final int getTabDefaultIndex() {
        return this.f420799f;
    }

    public final boolean getTabEnableSelectorMode() {
        return this.f420801h;
    }

    public final FeedTabIndicator getTabIndicator() {
        return this.f420797d;
    }

    public final long getTabIndicatorAnimationDuration() {
        return this.f420798e;
    }

    public final FeedTabLayoutConfig getTabLayoutConfig() {
        return this.f420800g;
    }

    public final int get_childAllWidthSum() {
        return this.f420809p;
    }

    public final int get_layoutDirection() {
        return this.f420811r;
    }

    public final int get_maxConvexHeight() {
        return this.f420810q;
    }

    public final int get_maxFlingVelocity() {
        return this.f420805l;
    }

    public final int get_minFlingVelocity() {
        return this.f420804k;
    }

    public final Rect get_tempRect() {
        return this.f420807n;
    }

    public final int get_touchSlop() {
        return this.f420806m;
    }

    public final int get_viewPagerScrollState() {
        return this.f420815v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public final void b(float r110) {
        FeedTabIndicator r100 = this.f420797d;
        r100.F = r110;
        r100.invalidateSelf();
        FeedTabLayoutConfig r101 = this.f420800g;
        if (r101 == null) goto L5;
        int r102 = this.f420797d.G;
    L5:
        if (r101 == null) goto L27;
        List<View> r103 = getFeedSelector().f420837c;
        View r104 = (View) CollectionsKt.getOrNull(r103, this.f420797d.H);
        if (r104 == null) goto L28;
        View r105 = (View) CollectionsKt.getOrNull(r103, this.f420797d.G);
        Intrinsics.checkNotNullParameter(r104, "toView");
        if (Intrinsics.areEqual(r105, r104) == true) goto L29;
        int r106 = r101.f420779h.getTabIndicator().G;
        int r107 = r101.f420779h.getTabIndicator().H;
        if (r101.f420781j == true) goto L13;
        return;
    L13:
        if (r105 == null) goto L20;
        TextView r108 = r101.f420787p.invoke(r105, Integer.valueOf(r106));
        int r109 = r101.f420782k;
        int r111 = r101.f420783l;
        r101.f420785n.getClass();
        if ((r108 instanceof TextView) == false) goto L17;
        TextView r112 = r108;
    L18:
        if (r112 == null) goto L20;
        float r113 = MathUtils.clamp(r110, 0.0f, 1.0f);
        int r114 = (r109 >> 24) & 255;
        int r115 = (r109 >> 16) & 255;
        int r116 = (r109 >> 8) & 255;
        int r117 = r109 & 255;
        int r118 = (r115 + ((int) ((((r111 >> 16) & 255) - r115) * r113))) << 16;
        int r119 = (r116 + ((int) ((((r111 >> 8) & 255) - r116) * r113))) << 8;
        r112.setTextColor((r117 + ((int) (r113 * ((r111 & 255) - r117)))) | (r119 | (r118 | ((r114 + ((int) ((((r111 >> 24) & 255) - r114) * r113))) << 24))));
        goto L20
    L17:
        r112 = null;
    L20:
        TextView r120 = r101.f420787p.invoke(r104, Integer.valueOf(r107));
        int r121 = r101.f420783l;
        int r122 = r101.f420782k;
        r101.f420785n.getClass();
        if ((r120 instanceof TextView) == false) goto L23;
        TextView r123 = r120;
    L24:
        if (r123 == null) goto L31;
        float r124 = MathUtils.clamp(r110, 0.0f, 1.0f);
        int r125 = (r121 >> 24) & 255;
        int r126 = (r121 >> 16) & 255;
        int r127 = (r121 >> 8) & 255;
        int r128 = r121 & 255;
        r123.setTextColor((r128 + ((int) (r124 * ((r122 & 255) - r128)))) | ((((r125 + ((int) ((((r122 >> 24) & 255) - r125) * r124))) << 24) | ((r126 + ((int) ((((r122 >> 16) & 255) - r126) * r124))) << 16)) | ((r127 + ((int) ((((r122 >> 8) & 255) - r127) * r124))) << 8)));
        return;
    L31:
        return;
    L23:
        r123 = null;
        goto L24
    L29:
        return;
    L28:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f420796c == false) goto L5;
        this.f420797d.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L5:
        super.draw(r100);
        ((ArrayList) getFeedSelector().f420837c).size();
        if (this.f420796c == false) goto L11;
        FeedTabIndicator r101 = this.f420797d;
        if (r101.f420767o <= 4096) goto L12;
        r101.draw(r100);
        return;
    L12:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L5;
        return new LayoutParams(r100);
    L5:
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f420796c == false) goto L8;
        FeedTabIndicator r101 = this.f420797d;
        if (r101.f420767o >= 4096) goto L9;
        r101.draw(r100);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (getNeedScroll() == false) goto L16;
        if (r100.getActionMasked() != 0) goto L8;
        get_overScroller().abortAnimation();
        get_scrollAnimator().cancel();
    L8:
        if (super.onInterceptTouchEvent(r100) == false) goto L10;
    L13:
        return true;
    L10:
        if (get_gestureDetector().onTouchEvent(r100) == true) goto L13;
        return false;
    L16:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L7;
        Bundle r101 = (Bundle) r100;
        super.onRestoreInstanceState(r101.getParcelable("old"));
        this.f420799f = r101.getInt("defaultIndex", this.f420799f);
        int r102 = r101.getInt("currentIndex", -1);
        getFeedSelector().f420842h = -1;
        if (r102 <= 0) goto L9;
        d(r102, true, false);
        return;
    L9:
        return;
    L7:
        super.onRestoreInstanceState(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        if (r100 == this.f420811r) goto L8;
        this.f420811r = r100;
        if (getOrientation() != 0) goto L9;
        requestLayout();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (getNeedScroll() == false) goto L15;
        get_gestureDetector().onTouchEvent(r100);
        if (r100.getActionMasked() != 3) goto L7;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
    L13:
        return true;
    L7:
        if (r100.getActionMasked() == 1) goto L12;
        if (r100.getActionMasked() != 0) goto L13;
        get_overScroller().abortAnimation();
        goto L13
    L15:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.onViewAdded(r100);
        getFeedSelector().i();
        getFeedSelector().h();
        getFeedSelector().g();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.onViewRemoved(r100);
        getFeedSelector().i();
        getFeedSelector().h();
        getFeedSelector().g();
    }

    public final void setDrawIndicator(boolean r100) {
        this.f420796c = r100;
    }

    public final void setItemDefaultHeight(int r100) {
        this.f420795b = r100;
    }

    public final void setLayoutScrollAnim(boolean r100) {
        this.f420802i = r100;
    }

    public final void setScrollAnimDuration(int r100) {
        this.f420803j = r100;
    }

    public final void setTabDefaultIndex(int r100) {
        this.f420799f = r100;
    }

    public final void setTabEnableSelectorMode(boolean r100) {
        this.f420801h = r100;
    }

    public final void setTabIndicator(FeedTabIndicator r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f420797d = r100;
        r100.g(getContext(), this.f420794a);
    }

    public final void setTabIndicatorAnimationDuration(long r100) {
        this.f420798e = r100;
    }

    public final void setTabLayoutConfig(FeedTabLayoutConfig r100) {
        this.f420800g = r100;
        if (r100 == null) goto L6;
        Context r101 = getContext();
        AttributeSet r102 = this.f420794a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r103 = r101.obtainStyledAttributes(r102, new int[]{R.attr.lark_tab_indicator_height, R.attr.lark_tab_indicator_width, R.attr.tab_deselect_color, R.attr.tab_draw_indicator, R.attr.tab_enable_gradient_color, R.attr.tab_enable_selector_mode, R.attr.tab_enable_text_bold, R.attr.tab_enable_text_color, R.attr.tab_indicator_anim, R.attr.tab_indicator_color, R.attr.tab_indicator_content_id, R.attr.tab_indicator_content_index, R.attr.tab_indicator_dash_gap, R.attr.tab_indicator_dash_width, R.attr.tab_indicator_drawable, R.attr.tab_indicator_enable_flash, R.attr.tab_indicator_enable_flash_clip, R.attr.tab_indicator_enable_flow, R.attr.tab_indicator_flow_step, R.attr.tab_indicator_gradient_colors, R.attr.tab_indicator_gradient_end_color, R.attr.tab_indicator_gradient_start_color, R.attr.tab_indicator_height_offset, R.attr.tab_indicator_radii, R.attr.tab_indicator_radius, R.attr.tab_indicator_shape, R.attr.tab_indicator_solid_color, R.attr.tab_indicator_stroke_color, R.attr.tab_indicator_stroke_width, R.attr.tab_indicator_style, R.attr.tab_indicator_width_offset, R.attr.tab_indicator_x_offset, R.attr.tab_indicator_y_offset, R.attr.tab_item_default_height, R.attr.tab_layout_scroll_anim, R.attr.tab_scroll_anim_duration, R.attr.tab_select_color, R.attr.tab_text_view_id});
        r100.f420782k = r103.getColor(36, r100.f420782k);
        r100.f420783l = r103.getColor(2, r100.f420783l);
        r100.f420780i = r103.getBoolean(7, r100.f420780i);
        r100.f420781j = r103.getBoolean(4, r100.f420781j);
        r100.f420784m = r103.getBoolean(6, r100.f420784m);
        r100.f420786o = r103.getResourceId(37, r100.f420786o);
        r103.recycle();
        return;
    }

    public final void set_childAllWidthSum(int r100) {
        this.f420809p = r100;
    }

    public final void set_layoutDirection(int r100) {
        this.f420811r = r100;
    }

    public final void set_maxConvexHeight(int r100) {
        this.f420810q = r100;
    }

    public final void set_maxFlingVelocity(int r100) {
        this.f420805l = r100;
    }

    public final void set_minFlingVelocity(int r100) {
        this.f420804k = r100;
    }

    public final void set_touchSlop(int r100) {
        this.f420806m = r100;
    }

    public final void set_viewPagerScrollState(int r100) {
        this.f420815v = r100;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, this.f420797d) == true) goto L8;
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public RefactoredFeedTabLayout(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f420794a = r101;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Resources r102 = getContext().getResources();
        this.f420795b = ((int) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) * 40;
        this.f420796c = true;
        this.f420797d = new FeedTabIndicator(this);
        this.f420798e = 300;
        this.f420803j = 250;
        this.f420807n = new Rect();
        this.f420808o = LazyKt.lazy(new RefactoredFeedTabLayout$feedSelector$2(this));
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.lark_tab_indicator_height, R.attr.lark_tab_indicator_width, R.attr.tab_deselect_color, R.attr.tab_draw_indicator, R.attr.tab_enable_gradient_color, R.attr.tab_enable_selector_mode, R.attr.tab_enable_text_bold, R.attr.tab_enable_text_color, R.attr.tab_indicator_anim, R.attr.tab_indicator_color, R.attr.tab_indicator_content_id, R.attr.tab_indicator_content_index, R.attr.tab_indicator_dash_gap, R.attr.tab_indicator_dash_width, R.attr.tab_indicator_drawable, R.attr.tab_indicator_enable_flash, R.attr.tab_indicator_enable_flash_clip, R.attr.tab_indicator_enable_flow, R.attr.tab_indicator_flow_step, R.attr.tab_indicator_gradient_colors, R.attr.tab_indicator_gradient_end_color, R.attr.tab_indicator_gradient_start_color, R.attr.tab_indicator_height_offset, R.attr.tab_indicator_radii, R.attr.tab_indicator_radius, R.attr.tab_indicator_shape, R.attr.tab_indicator_solid_color, R.attr.tab_indicator_stroke_color, R.attr.tab_indicator_stroke_width, R.attr.tab_indicator_style, R.attr.tab_indicator_width_offset, R.attr.tab_indicator_x_offset, R.attr.tab_indicator_y_offset, R.attr.tab_item_default_height, R.attr.tab_layout_scroll_anim, R.attr.tab_scroll_anim_duration, R.attr.tab_select_color, R.attr.tab_text_view_id});
        this.f420795b = r103.getDimensionPixelOffset(33, this.f420795b);
        this.f420799f = 0;
        this.f420796c = r103.getBoolean(3, this.f420796c);
        this.f420801h = r103.getBoolean(5, this.f420801h);
        this.f420802i = r103.getBoolean(34, this.f420802i);
        this.f420803j = r103.getInt(35, this.f420803j);
        r103.recycle();
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        this.f420804k = r104.getScaledMinimumFlingVelocity();
        this.f420805l = r104.getScaledMaximumFlingVelocity();
        if (this.f420796c == false) goto L5;
        this.f420797d.g(r100, r101);
    L5:
        setTabLayoutConfig(new FeedTabLayoutConfig(this));
        setWillNotDraw(false);
        setOrientation(0);
        this.f420811r = -1;
        this.f420812s = LazyKt.lazy(new RefactoredFeedTabLayout$_overScroller$2(r100));
        this.f420813t = LazyKt.lazy(new RefactoredFeedTabLayout$_gestureDetector$2(r100, this));
        this.f420814u = LazyKt.lazy(new RefactoredFeedTabLayout$_scrollAnimator$2(this));
    }

    public final void c(int r100, boolean r101) {
        if (getNeedScroll() == true) goto L5;
        return;
    L5:
        View r102 = (View) CollectionsKt.getOrNull(getFeedSelector().f420837c, r100);
        if (r102 != null) goto L8;
    L10:
        FeedTabIndicator r103 = this.f420797d;
        int r104 = FeedTabIndicator.I;
        int r105 = r103.c(r100, r103.f420768p);
        int r106 = getViewTargetX();
        if (this.f420801h == false) goto L16;
        int r107 = r105 - (getMeasuredWidth() / 2);
        int r108 = getScrollX();
    L13:
        int r109 = r107 - r108;
    L14:
        int r110 = r109;
        if (isInEditMode() == true) goto L29;
        if (r101 == false) goto L29;
        get_overScroller().abortAnimation();
        get_overScroller().startScroll(getScrollX(), getScrollY(), r110, 0, this.f420803j);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L29:
        get_overScroller().abortAnimation();
        scrollBy(r110, 0);
        return;
    L16:
        if (a() == false) goto L20;
        if (r105 >= r106) goto L19;
        r107 = r105 - r106;
        r108 = getScrollX();
        goto L13
    L19:
        int r111 = getScrollX();
    L23:
        r109 = -r111;
        goto L14
    L20:
        if (r105 <= r106) goto L22;
        r107 = r105 - r106;
        r108 = getScrollX();
        goto L13
    L22:
        r111 = getScrollX();
        goto L23
    L8:
        if (ViewCompat.isLaidOut(r102) == true) goto L10;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getFeedSelector().f420842h >= 0) goto L5;
        e(this, this.f420799f, false, 6);
    L5:
        getFeedSelector().i();
        if (((ArrayList) getFeedSelector().f420837c).size() != 0) goto L8;
        setMeasuredDimension(LinearLayout.getDefaultSize(getSuggestedMinimumWidth(), r100), LinearLayout.getDefaultSize(getSuggestedMinimumHeight(), r101));
        return;
    L8:
        super.onMeasure(r100, r101);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (r100 <= getMaxScrollX()) goto L6;
        super.scrollTo(getMaxScrollX(), 0);
        return;
    L6:
        if (r100 >= getMinScrollX()) goto L8;
        super.scrollTo(getMinScrollX(), 0);
        return;
    L8:
        super.scrollTo(r100, 0);
    }

    public final void d(int r100, boolean r101, boolean r102) {
        if (getCurrentItemIndex() != r100) goto L6;
        c(r100, this.f420797d.E);
        return;
    L6:
        e.e(getFeedSelector(), r100, true, r101, r102, 16);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return super.drawChild(r100, r101, r102);
    }

    public final void f(int r110, int r111, int r112) {
        if (r110 <= 0) goto L8;
        int r100 = this.f420804k;
        int r101 = this.f420805l;
        if (r110 < r100) goto L10;
        if (r110 > r101) goto L12;
    L13:
        int r102 = r110;
        get_overScroller().abortAnimation();
        get_overScroller().fling(getScrollX(), getScrollY(), r102, 0, r111, r112, 0, 0, getMeasuredWidth(), 0);
        postInvalidate();
        return;
    L12:
        r110 = r101;
    L10:
        r110 = r100;
        goto L13
    L8:
        r100 = -this.f420805l;
        r101 = -this.f420804k;
        if (r110 < r100) goto L10;
        if (r110 <= r101) goto L13;
        goto L12
    }

    public static /* synthetic */ void e(RefactoredFeedTabLayout r100, int r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.d(r101, r102, false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (getNeedScroll() == true) goto L10;
        if (getScrollX() == 0) goto L7;
    L8:
        scrollTo(0, 0);
        goto L10
    L7:
        if (getScrollY() != 0) goto L8;
    L10:
        if (getFeedSelector().f420842h >= 0) goto L13;
        e(this, this.f420799f, false, 6);
        return;
    L13:
        if (get_overScroller().isFinished() == false) goto L17;
        c(getFeedSelector().f420842h, this.f420802i);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        boolean r103 = a();
        int r104 = getPaddingStart();
        int r105 = getMeasuredWidth() - getPaddingEnd();
        getMeasuredHeight();
        getPaddingBottom();
        ArrayList r112 = (ArrayList) getFeedSelector().f420837c;
        Iterator r113 = r112.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        ((View) r113.next()).getMeasuredWidth();
        goto L4
    L6:
        getMeasuredWidth();
        Iterator r114 = r112.iterator();
        int r106 = 0;
    L8:
        if (r114.hasNext() == false) goto L32;
        Object r107 = r114.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r109 = (View) r107;
        ViewGroup.LayoutParams r115 = r109.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout.LayoutParams");
        LayoutParams r116 = (LayoutParams) r115;
        if (r103 == false) goto L15;
        r105 = r105 - r116.getMarginEnd();
    L16:
        int r117 = ((LinearLayout.LayoutParams) r116).gravity;
        if (r117 == 0) goto L22;
        if (r117 <= 0) goto L22;
        if ((r117 & 16) != 16) goto L22;
        boolean r118 = true;
    L23:
        if (r118 == false) goto L25;
        int r119 = getMeasuredHeight() - getPaddingBottom();
        int r120 = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.f420810q) / 2) - (r109.getMeasuredHeight() / 2);
    L26:
        int r121 = r119 - r120;
        if (r103 == false) goto L29;
        r109.layout(r105 - r109.getMeasuredWidth(), r121 - r109.getMeasuredHeight(), r105, r121);
        r105 = r105 - (r109.getMeasuredWidth() + r116.getMarginStart());
    L30:
        r106 = r108;
        goto L8
    L29:
        r109.layout(r104, r121 - r109.getMeasuredHeight(), r109.getMeasuredWidth() + r104, r121);
        r104 = r104 + (r109.getMeasuredWidth() + r116.getMarginEnd());
        goto L30
    L25:
        r119 = getMeasuredHeight();
        r120 = getPaddingBottom();
    L22:
        r118 = false;
        goto L23
    L15:
        r104 = r104 + r116.getMarginStart();
        goto L16
    L32:
        if (getNeedScroll() == true) goto L39;
        if (getScrollX() == 0) goto L36;
    L37:
        scrollTo(0, 0);
        goto L39
    L36:
        if (getScrollY() != 0) goto L37;
    L39:
        if (getFeedSelector().f420842h >= 0) goto L42;
        e(this, this.f420799f, false, 6);
        return;
    L42:
        if (get_overScroller().isFinished() == false) goto L50;
        c(getFeedSelector().f420842h, this.f420802i);
        return;
    }
}

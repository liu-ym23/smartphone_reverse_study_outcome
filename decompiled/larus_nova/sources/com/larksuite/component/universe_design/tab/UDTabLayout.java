package com.larksuite.component.universe_design.tab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.animation.UDAnimation$Interpolator;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 Ä\u00012\u00020\u0001:\nÀ\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u0014\u0010;\u001a\u00020<2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120>J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nJ\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010@\u001a\u00020!J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020!J\u000e\u0010A\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nJ\u000e\u0010B\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u000e\u0010C\u001a\u00020<2\u0006\u0010?\u001a\u00020\nJ\u0006\u0010D\u001a\u00020<J\u0006\u0010E\u001a\u00020\nJ\u0010\u0010F\u001a\u00020<2\b\b\u0001\u0010\u0015\u001a\u00020\nJ\b\u0010G\u001a\u00020\nH\u0007J\u0010\u0010H\u001a\u00020<2\b\b\u0001\u0010\u0018\u001a\u00020\nJ\b\u0010I\u001a\u00020\nH\u0007J\u0010\u0010J\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0010\u0010J\u001a\u00020<2\b\b\u0001\u0010M\u001a\u00020\nJ\b\u0010N\u001a\u0004\u0018\u00010LJ\u0010\u0010O\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\nJ\u000e\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020+J\u001a\u0010V\u001a\u00020<2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nJ\u0010\u0010Z\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u0010\u0010[\u001a\u00020<2\b\b\u0001\u0010\\\u001a\u00020\nJ\u0006\u0010]\u001a\u00020+J\u0010\u0010^\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u000e\u0010_\u001a\u00020<2\u0006\u0010W\u001a\u00020+J\u0010\u0010`\u001a\u00020<2\b\b\u0001\u0010\\\u001a\u00020\nJ\u0006\u0010a\u001a\u00020+J\u000e\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020+J\u0010\u0010d\u001a\u00020<2\b\b\u0001\u0010e\u001a\u00020\nJ\u0010\u0010f\u001a\u00020<2\b\b\u0001\u0010g\u001a\u00020\nJ\u001a\u0010b\u001a\u00020<2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nJ\u0006\u0010h\u001a\u00020+J\u000e\u0010i\u001a\u00020<2\u0006\u0010j\u001a\u00020!J\u0006\u0010k\u001a\u00020!J\u000e\u0010l\u001a\u00020<2\u0006\u0010j\u001a\u00020!J\u0006\u0010m\u001a\u00020!J\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010o\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u001d\u0010o\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0002\bqJ\u000e\u0010r\u001a\u00020<2\u0006\u0010?\u001a\u00020\nJ\u001d\u0010r\u001a\u00020<2\u0006\u0010?\u001a\u00020\n2\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0002\bsJ\u0006\u0010t\u001a\u00020\nJ\u000e\u0010u\u001a\u00020<2\u0006\u0010v\u001a\u00020!J\u0006\u0010w\u001a\u00020!J\u0010\u0010x\u001a\u00020<2\b\b\u0001\u0010y\u001a\u00020\nJ\u0006\u0010z\u001a\u00020\nJ\u000e\u0010{\u001a\u00020<2\u0006\u0010|\u001a\u00020\u0014J\u000e\u0010}\u001a\u00020<2\u0006\u0010|\u001a\u00020\u0014J1\u0010~\u001a\u00020<2\b\b\u0001\u0010\u007f\u001a\u00020\n2\t\b\u0001\u0010\u0080\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0082\u0001\u001a\u00020\nJ\u0013\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\u001c\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0016J$\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0016J\u001f\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J(\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u001b\u0010\u008a\u0001\u001a\u00020<2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0014J6\u0010\u008d\u0001\u001a\u00020<2\u0007\u0010\u008e\u0001\u001a\u00020!2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\nH\u0014J\u0013\u0010\u0093\u0001\u001a\u00020<2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J-\u0010\u0096\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0097\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0014J2\u0010\u0099\u0001\u001a\u00020<2\u0006\u0010?\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020!2\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0003\b\u009d\u0001J\u000f\u0010\u009e\u0001\u001a\u00020<H\u0000¢\u0006\u0003\b\u009f\u0001J#\u0010 \u0001\u001a\u00020<2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0013\u0010¡\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J!\u0010¢\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020!H\u0002J\u0011\u0010£\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0013\u0010¤\u0001\u001a\u00020<2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\u0019\u0010§\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010@\u001a\u00020!H\u0002J\u0019\u0010¨\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nH\u0002J\u0012\u0010©\u0001\u001a\u00020<2\u0007\u0010ª\u0001\u001a\u00020\nH\u0002J\u0011\u0010«\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\t\u0010¬\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020<2\u0007\u0010®\u0001\u001a\u00020\nH\u0002J\u001b\u0010¯\u0001\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0006\u0010p\u001a\u00020!H\u0002J\u0011\u0010°\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u001b\u0010±\u0001\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\t\u0010²\u0001\u001a\u00020<H\u0002J\u0012\u0010³\u0001\u001a\u00020<2\u0007\u0010´\u0001\u001a\u00020\nH\u0002J\u0011\u0010µ\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0011\u0010¶\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0011\u0010·\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J&\u0010¸\u0001\u001a\u00020<2\u001a\u0010¹\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020<0º\u0001¢\u0006\u0003\b»\u0001H\u0082\bJ\t\u0010¼\u0001\u001a\u00020<H\u0002J\t\u0010½\u0001\u001a\u00020<H\u0002J\u001d\u0010¾\u0001\u001a\u00020+2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nH\u0002J\t\u0010¿\u0001\u001a\u000204H\u0002R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u000e\u0010:\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "indicator", "Lcom/larksuite/component/universe_design/tab/UDTabLayout$UDTabIndicator;", "tabs", "", "Lcom/larksuite/component/universe_design/tab/UDTab;", "selectedListeners", "Lcom/larksuite/component/universe_design/tab/UDTabLayout$OnTabSelectedListener;", "tabMode", "getTabMode$annotations", "()V", "tabGravity", "getTabGravity$annotations", "tabMaxWidth", "tabMinWidth", "scrollAnimator", "Landroid/animation/ValueAnimator;", "indicatorAnimatorDuration", "", "edgeShadowShow", "", "edgeShadowEnable", "indicatorFullWidth", "tabPaddingStart", "tabPaddingTop", "tabPaddingEnd", "tabPaddingBottom", "tabMargin", "tabLayoutPaddingStart", "tabBackgroundColors", "Landroid/content/res/ColorStateList;", "tabTitleColors", "tabIconTintColors", "tabTitleTextAppearance", "tabTitleTextSize", "tabMultiLineTitleTextSize", "scrollBounds", "Landroid/graphics/Rect;", "edgeShadowDrawable", "Landroid/graphics/drawable/GradientDrawable;", "bottomDividerDrawable", "getBottomDividerDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "bottomDividerDrawable$delegate", "Lkotlin/Lazy;", "bottomDividerEnabled", "addTab", "", "tab", "", "position", "setSelected", "getTabAt", "removeTab", "removeTabAt", "removeAllTabs", "getTabCount", "setTabMode", "getTabMode", "setTabGravity", "getTabGravity", "setIndicatorDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "getIndicatorDrawable", "setIndicatorColor", "color", "setIndicatorHeight", "height", "setIndicatorInterpolator", "indicatorInterpolator", "Lcom/larksuite/component/universe_design/tab/UDTabIndicatorInterpolator;", "setTabTitleColors", "colors", "normalColor", "selectedColor", "setTabTitleColor", "setTabTitleColorResource", "colorRes", "getTabTitleColors", "setTabBackgroundColor", "setTabBackgroundColors", "setTabBackgroundColorResource", "getTabBackgroundColors", "setTabIconTintColors", "tint", "setTabIconTintColor", "tintColor", "setTabIconTintColorResource", "tintRes", "getTabIconTintColor", "setEdgeShadowEnabled", "enable", "isEdgeShadowEnabled", "setBottomDividerEnabled", "isBottomDividerEnabled", "newTab", "selectTab", "updateIndicator", "selectTab$universe_ui_tab_release", "selectTabAt", "selectTabAt$universe_ui_tab_release", "getSelectPosition", "setIndicatorFullWidth", "fullWidth", "isIndicatorFullWidth", "setTabMargin", GXTemplateKey.FLEXBOX_MARGIN, "getTabMargin", "addOnTabSelectedListener", "listener", "removeOnTabSelectedListener", "setTabPadding", "paddingStart", "paddingTop", "paddingEnd", "paddingBottom", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "width", "params", "Landroid/view/ViewGroup$LayoutParams;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onDrawForeground", "canvas", "Landroid/graphics/Canvas;", "onScrollChanged", "oldl", "oldt", "setScrollPosition", "offset", "", "updateSelectedText", "setScrollPosition$universe_ui_tab_release", "invaliIndicator", "invaliIndicator$universe_ui_tab_release", "applyAttrs", "addViewInternal", "addTabInternal", "removeTabInternal", "addTabFromItemView", "itemView", "Lcom/larksuite/component/universe_design/tab/UDTabItem;", "addTabView", "addTabToList", "setupTabMaxWidth", "maxWidth", "configureTabStyle", "updateTabsStyle", "updateTabsPosition", "startPosition", "selectTabInternal", "animateToTab", "calculateScrollXForTab", "updateEdgeShadow", "dispatchSelectState", "selectedPosition", "dispatchTabSelected", "dispatchTabReselected", "dispatchTabUnselected", "forEachListenersReverse", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "applyTabMode", "applyTabGravity", "createColorStateList", "generateEdgeShadowDrawable", "OnTabSelectedListener", "TabMode", "TabGravity", "UDTabIndicator", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDTabLayout extends HorizontalScrollView {
    public static final a Companion = null;
    public static final int NO_POSITION = -1;
    private final Lazy bottomDividerDrawable$delegate;
    private boolean bottomDividerEnabled;
    private GradientDrawable edgeShadowDrawable;
    private boolean edgeShadowEnable;
    private boolean edgeShadowShow;
    private final c indicator;
    private long indicatorAnimatorDuration;
    private boolean indicatorFullWidth;
    private ValueAnimator scrollAnimator;
    private final Rect scrollBounds;
    private final List<b> selectedListeners;
    private ColorStateList tabBackgroundColors;
    private int tabGravity;
    private ColorStateList tabIconTintColors;
    private int tabLayoutPaddingStart;
    private int tabMargin;
    private int tabMaxWidth;
    private int tabMinWidth;
    private int tabMode;
    private int tabMultiLineTitleTextSize;
    private int tabPaddingBottom;
    private int tabPaddingEnd;
    private int tabPaddingStart;
    private int tabPaddingTop;
    private ColorStateList tabTitleColors;
    private int tabTitleTextAppearance;
    private int tabTitleTextSize;
    private final List<com.larksuite.component.universe_design.tab.b> tabs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout$TabGravity;", "", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TabGravity {
        public static final int CENTER = 0;
        public static final a Companion = null;
        public static final int FILL = 1;
        public static final int START = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f285260a = null;

            static {
                f285260a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f285260a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout$TabMode;", "", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TabMode {
        public static final int AUTO = 2;
        public static final a Companion = null;
        public static final int FIXED = 1;
        public static final int SCROLLABLE = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f285261a = null;

            static {
                f285261a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f285261a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(com.larksuite.component.universe_design.tab.b r100);

        void b(com.larksuite.component.universe_design.tab.b r100);

        void c(com.larksuite.component.universe_design.tab.b r100);
    }

    public final class c extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f285262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f285263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f285264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f285265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f285266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.larksuite.component.universe_design.tab.c f285267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f285268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ValueAnimator f285269h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f285270i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ UDTabLayout f285271j;

        public final void b() {
            int r100 = getChildCount();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L24;
            View r102 = getChildAt(r101);
            Intrinsics.checkNotNull(r102);
            ViewGroup.LayoutParams r103 = r102.getLayoutParams();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
            boolean r105 = true;
            if (this.f285264c != 1) goto L16;
            if (this.f285263b != 1) goto L16;
            if (r104.weight == 1.0f) goto L12;
            r105 = false;
        L12:
            if (r105 == true) goto L14;
            int r106 = r104.width;
        L14:
            r104.width = 0;
            r104.weight = 1.0f;
        L23:
            r101 = r101 + 1;
        L16:
            if (r104.weight == 0.0f) goto L20;
            r105 = false;
        L20:
            if (r105 == true) goto L22;
            int r107 = r104.width;
        L22:
            r104.width = -2;
            r104.weight = 0.0f;
            goto L23
        }

        public final void a(int r100) {
            Drawable r101 = this.f285262a;
            if (r101 == null) goto L16;
            UDTabLayout r102 = this.f285271j;
            ValueAnimator r103 = this.f285269h;
            if (r103 == null) goto L9;
            boolean r104 = true;
            if (r103.isRunning() != true) goto L9;
        L10:
            if (r104 == false) goto L14;
            ValueAnimator r105 = this.f285269h;
            if (r105 == null) goto L14;
            r105.cancel();
        L14:
            com.larksuite.component.universe_design.tab.c r106 = this.f285267f;
            View r107 = getChildAt(r100);
            r106.getClass();
            Intrinsics.checkNotNullParameter(r102, "tabLayout");
            Intrinsics.checkNotNullParameter(r101, "indicator");
            boolean r108 = r102.isIndicatorFullWidth();
            int r109 = com.larksuite.component.universe_design.tab.c.a(r107, r108);
            int r110 = com.larksuite.component.universe_design.tab.c.b(r107, r108);
            r101.setBounds(r109, r101.getBounds().top, r110, r101.getBounds().bottom);
            invalidate();
            return;
        L9:
            r104 = false;
            goto L10
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            super.onDraw(r100);
            Drawable r101 = this.f285262a;
            if (r101 == null) goto L12;
            int r102 = this.f285268g;
            if (r102 > 0) goto L8;
            r102 = r101.getIntrinsicHeight();
        L8:
            if (r102 <= 0) goto L13;
            int r103 = getHeight() - r102;
            int r104 = getHeight();
            r101.setBounds(r101.getBounds().left, r103, r101.getBounds().right, r104);
            r101.draw(r100);
            return;
        L13:
            return;
        }

        public c(UDTabLayout r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f285271j = r100;
            super(r101);
            this.f285262a = UDIconUtils.getIconDrawable(r101, R.drawable.ud_tab_indicator);
            this.f285263b = 2;
            this.f285264c = 1;
            this.f285265d = -1;
            this.f285267f = new com.larksuite.component.universe_design.tab.c();
            this.f285268g = -1;
            setWillNotDraw(false);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r110, int r111) {
            super.onMeasure(r110, r111);
            if (View.MeasureSpec.getMode(r110) == 1073741824) goto L5;
            return;
        L5:
            boolean r100 = false;
            if (this.f285263b != 2) goto L29;
            if (this.f285264c != 1) goto L29;
            int r101 = getChildCount();
            int r102 = 0;
            int r103 = 0;
        L10:
            if (r102 >= r101) goto L13;
            View r104 = getChildAt(r102);
            Intrinsics.checkNotNull(r104);
            r103 = r103 + r104.getMeasuredWidth();
            r102 = r102 + 1;
            goto L10
        L13:
            if (r103 > getMeasuredWidth()) goto L25;
            int r105 = getChildCount();
            int r106 = 0;
            boolean r107 = false;
        L15:
            if (r106 >= r105) goto L26;
            View r108 = getChildAt(r106);
            Intrinsics.checkNotNull(r108);
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r109;
            if (r112.weight != 1.0f) goto L19;
            boolean r113 = true;
        L20:
            if (r113 == true) goto L22;
        L23:
            r112.weight = 1.0f;
            r112.width = 0;
            r107 = true;
        L24:
            r106 = r106 + 1;
            goto L15
        L22:
            if (r112.width == 0) goto L24;
        L19:
            r113 = false;
        L26:
            if (r107 == false) goto L29;
            super.onMeasure(r110, r111);
            goto L29
        L25:
            b();
            r107 = false;
        L29:
            if (this.f285264c != 0) goto L64;
            int r114 = getChildCount();
            int r115 = 0;
            int r116 = 0;
            int r117 = 0;
        L31:
            if (r115 >= r114) goto L37;
            View r118 = getChildAt(r115);
            Intrinsics.checkNotNull(r118);
            if (r118.getVisibility() != 0) goto L35;
            r117 = Math.max(r117, r118.getMeasuredWidth());
            r116 = r116 + 1;
        L35:
            r115 = r115 + 1;
            goto L31
        L37:
            if ((r116 * r117) <= getMeasuredWidth()) goto L39;
            this.f285264c = 1;
            b();
            b();
        L51:
            if (r100 == false) goto L65;
            super.onMeasure(r110, r111);
            return;
        L65:
            return;
        L39:
            int r119 = getChildCount();
            int r120 = 0;
            boolean r121 = false;
        L40:
            if (r120 >= r119) goto L50;
            View r122 = getChildAt(r120);
            Intrinsics.checkNotNull(r122);
            ViewGroup.LayoutParams r123 = r122.getLayoutParams();
            Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r124 = (LinearLayout.LayoutParams) r123;
            if (r124.width == r117) goto L44;
        L48:
            r124.width = r117;
            r124.weight = 0.0f;
            r121 = true;
        L49:
            r120 = r120 + 1;
            goto L40
        L44:
            if (r124.weight != 0.0f) goto L46;
            boolean r125 = true;
        L47:
            if (r125 == true) goto L49;
        L46:
            r125 = false;
            goto L47
        L50:
            r100 = r121;
            goto L51
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.f285269h;
            if (r105 == null) goto L7;
            boolean r106 = true;
            if (r105.isRunning() != true) goto L7;
        L8:
            if (r106 == true) goto L11;
            if (r100 == false) goto L11;
        L12:
            int r107 = this.f285265d;
            int r108 = r107 + 1;
            float r109 = this.f285266e;
            Drawable r110 = this.f285262a;
            if (r110 == null) goto L15;
            UDTabLayout r111 = this.f285271j;
            com.larksuite.component.universe_design.tab.c r112 = this.f285267f;
            View r113 = getChildAt(r107);
            View r114 = getChildAt(r108);
            r112.getClass();
            com.larksuite.component.universe_design.tab.c.c(r111, r113, r114, r109, r110);
            postInvalidateOnAnimation();
        L15:
            this.f285270i = false;
            return;
        L11:
            if (this.f285270i == true) goto L12;
            return;
        L7:
            r106 = false;
            goto L8
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTabLayout f285272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f285273b;

        public d(UDTabLayout r100, ValueAnimator r101) {
            this.f285272a = r100;
            this.f285273b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            UDTabLayout r101 = this.f285272a;
            Object r102 = this.f285273b.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.scrollTo(((Integer) r102).intValue(), 0);
        }
    }

    static {
        Companion = new a();
    }

    @TabGravity
    private static /* synthetic */ void getTabGravity$annotations() {
    }

    @TabMode
    private static /* synthetic */ void getTabMode$annotations() {
    }

    private final void applyTabGravity() {
        c r100 = this.indicator;
        r100.f285264c = this.tabGravity;
        r100.b();
        int r101 = this.tabGravity;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L10;
        this.indicator.setGravity(GravityCompat.START);
    L10:
        this.indicator.f285270i = true;
        if (isLaidOut() == false) goto L14;
        updateTabsStyle();
        return;
    L14:
        return;
    L9:
        this.indicator.setGravity(17);
        goto L10
    }

    private final void applyTabMode() {
        c r100 = this.indicator;
        r100.f285263b = this.tabMode;
        r100.b();
        if (isLaidOut() == false) goto L6;
        updateTabsStyle();
        this.indicator.f285270i = true;
        return;
    }

    private final GradientDrawable generateEdgeShadowDrawable() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        int[] r101 = new int[2];
        ColorStateList r102 = this.tabBackgroundColors;
        ColorStateList r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r102 = null;
    L5:
        r101[0] = UDColorUtils.getAlphaColor(r102.getDefaultColor(), 0.0f);
        ColorStateList r104 = this.tabBackgroundColors;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
    L9:
        r101[1] = r103.getDefaultColor();
        r100.setColors(r101);
        return r100;
    L8:
        r103 = r104;
        goto L9
    }

    private final GradientDrawable getBottomDividerDrawable() {
        return (GradientDrawable) this.bottomDividerDrawable$delegate.getValue();
    }

    private final void updateEdgeShadow() {
        if (this.edgeShadowEnable == true) goto L6;
        return;
    L6:
        if (this.indicator.getWidth() > getWidth()) goto L8;
    L13:
        boolean r100 = false;
    L14:
        if (r100 == false) goto L17;
        setWillNotDraw(false);
    L17:
        if (r100 == this.edgeShadowShow) goto L20;
        this.edgeShadowShow = r100;
        invalidate();
        return;
    L20:
        return;
    L8:
        if (this.indicator.getChildCount() <= 0) goto L12;
        c r101 = this.indicator;
        r100 = true;
        View r102 = r101.getChildAt(r101.getChildCount() - 1);
        getHitRect(this.scrollBounds);
        if (((r102.getRight() - r102.getPaddingRight()) - getScrollX()) > this.scrollBounds.right) goto L14;
    }

    private final void updateTabsStyle() {
        Iterator<com.larksuite.component.universe_design.tab.b> r100 = this.tabs.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        configureTabStyle(r100.next());
        goto L4
    L6:
        ColorStateList r101 = this.tabBackgroundColors;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r101 = null;
    L9:
        setBackgroundColor(r101.getDefaultColor());
    }

    public final Drawable getIndicatorDrawable() {
        return this.indicator.f285262a;
    }

    public final int getSelectPosition() {
        return this.indicator.f285265d;
    }

    public final ColorStateList getTabBackgroundColors() {
        ColorStateList r100 = this.tabBackgroundColors;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        return null;
    L6:
        return r100;
    }

    public final int getTabCount() {
        return this.tabs.size();
    }

    public final ColorStateList getTabIconTintColor() {
        ColorStateList r100 = this.tabIconTintColors;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabIconTintColors");
        return null;
    L6:
        return r100;
    }

    public final ColorStateList getTabTitleColors() {
        ColorStateList r100 = this.tabTitleColors;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitleColors");
        return null;
    L6:
        return r100;
    }

    public final void invaliIndicator$universe_ui_tab_release() {
        this.indicator.f285270i = true;
    }

    public final com.larksuite.component.universe_design.tab.b newTab() {
        com.larksuite.component.universe_design.tab.b r100 = new com.larksuite.component.universe_design.tab.b(getContext());
        configureTabStyle(r100);
        return r100;
    }

    public final void removeAllTabs() {
        this.tabs.clear();
        this.indicator.removeAllViews();
        selectTabAt(-1);
    }

    @TabGravity
    public final int getTabGravity() {
        return this.tabGravity;
    }

    public final int getTabMargin() {
        return this.tabMargin;
    }

    @TabMode
    public final int getTabMode() {
        return this.tabMode;
    }

    public final boolean isBottomDividerEnabled() {
        return this.bottomDividerEnabled;
    }

    public final boolean isEdgeShadowEnabled() {
        return this.edgeShadowEnable;
    }

    public final boolean isIndicatorFullWidth() {
        return this.indicatorFullWidth;
    }

    public UDTabLayout(Context r100) {
        this(r100, null);
    }

    public static final /* synthetic */ long access$getIndicatorAnimatorDuration$p(UDTabLayout r100) {
        return r100.indicatorAnimatorDuration;
    }

    private final void addTabFromItemView(UDTabItem r100) {
        com.larksuite.component.universe_design.tab.b r101 = newTab();
        r101.b(r100.getTitle$universe_ui_tab_release());
        r101.f285295d = r100.getIcon$universe_ui_tab_release();
        r101.c();
        if (r100.getCustomView$universe_ui_tab_release() == null) goto L10;
        Integer r102 = r100.getCustomView$universe_ui_tab_release();
        if (r102 != null) goto L8;
    L9:
        View r103 = LayoutInflater.from(r101.getContext()).inflate(r100.getCustomView$universe_ui_tab_release().intValue(), null);
        Intrinsics.checkNotNullParameter(r103, "value");
        r101.f285296e = r103;
        r101.d();
        r101.c();
        goto L10
    L8:
        if (r102.intValue() != 0) goto L9;
    L10:
        addTab(r101);
    }

    private final void addViewInternal(View r100) {
        if ((r100 instanceof UDTabItem) == false) goto L7;
        addTabFromItemView((UDTabItem) r100);
        return;
    L7:
        throw new IllegalArgumentException("Only UDTabItem instances can be added to UDTabLayout.".toString());
    }

    private final void animateToTab(com.larksuite.component.universe_design.tab.b r100) {
        ValueAnimator r101 = this.scrollAnimator;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        ValueAnimator r103 = this.scrollAnimator;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{getScrollX(), calculateScrollXForTab(r100.f285297f, 0.0f)});
        r104.setInterpolator((PathInterpolator) UDAnimation$Interpolator.f284491b.getValue());
        r104.setDuration(this.indicatorAnimatorDuration);
        r104.addUpdateListener(new d(this, r104));
        r104.start();
        this.scrollAnimator = r104;
        return;
    L5:
        if (r101.isRunning() != true) goto L7;
        r102 = true;
        goto L8
    }

    private final void configureTabStyle(com.larksuite.component.universe_design.tab.b r110) {
        r110.f285296e.setPaddingRelative(this.tabPaddingStart, this.tabPaddingTop, this.tabPaddingEnd, this.tabPaddingBottom);
        r110.f285296e.setMinimumWidth(this.tabMinWidth);
        ViewGroup.LayoutParams r100 = r110.f285296e.getLayoutParams();
        f r101 = null;
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r102 != null) goto L8;
    L12:
        ColorStateList r103 = this.tabIconTintColors;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tabIconTintColors");
        r103 = null;
    L15:
        Intrinsics.checkNotNullParameter(r103, "colors");
        ImageView r104 = (ImageView) r110.f285296e.findViewById(R.id.ud_tab_icon);
        if (r104 == null) goto L19;
        r104.setImageTintList(r103);
    L19:
        ColorStateList r105 = this.tabBackgroundColors;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r105 = null;
    L22:
        Intrinsics.checkNotNullParameter(r105, "colors");
        r110.f285296e.setBackgroundTintList(r105);
        r110.f285296e.invalidate();
        TextView r106 = r110.a();
        int r107 = 2;
        if (r106 == null) goto L29;
        r106.setTextAppearance(r106.getContext(), this.tabTitleTextAppearance);
        r106.setTextSize(0, this.tabTitleTextSize);
        if (this.tabMode != 1) goto L27;
        int r108 = 2;
    L28:
        r106.setMaxLines(r108);
        goto L29
    L27:
        r108 = 1;
    L29:
        TextView r109 = (TextView) r110.f285296e.findViewById(R.id.ud_tab_title_bold);
        if (r109 == null) goto L36;
        r109.setTextAppearance(r109.getContext(), this.tabTitleTextAppearance);
        w08.a.b(r109, 1);
        r109.setTextSize(0, this.tabTitleTextSize);
        if (this.tabMode == 1) goto L35;
        r107 = 1;
    L35:
        r109.setMaxLines(r107);
    L36:
        ColorStateList r111 = this.tabTitleColors;
        if (r111 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitleColors");
        r111 = null;
    L39:
        Intrinsics.checkNotNullParameter(r111, "colors");
        TextView r112 = r110.a();
        if (r112 == null) goto L45;
        r112.setTextColor(r111);
        TextView r113 = (TextView) r110.f285296e.findViewById(R.id.ud_tab_title_bold);
        if (r113 == null) goto L45;
        r113.setTextColor(r111);
    L45:
        View r114 = r110.f285296e;
        if ((r114 instanceof f) == false) goto L48;
        r101 = (f) r114;
    L48:
        if (r101 == null) goto L50;
        r101.setMultiLineTitleTextSize$universe_ui_tab_release(this.tabMultiLineTitleTextSize);
        r101.setSingleLineTitleTextSize$universe_ui_tab_release(this.tabTitleTextSize);
        r101.setMaxWidth$universe_ui_tab_release(this.tabMaxWidth);
    L50:
        boolean r115 = r110.f285296e.isSelected();
        r110.f285296e.setSelected(r115);
        TextView r116 = r110.a();
        if (r116 == null) goto L56;
        if (r115 == false) goto L55;
        w08.a.b(r116, 1);
        goto L56
    L55:
        w08.a.b(r116, 0);
    L56:
        this.indicator.f285270i = true;
        requestLayout();
        return;
    L8:
        if (r110.f285297f <= 0) goto L10;
        int r117 = this.tabMargin;
    L11:
        r102.leftMargin = r117;
        goto L12
    L10:
        r117 = this.tabLayoutPaddingStart;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    private final void dispatchSelectState(int r100) {
        int r101 = this.tabs.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        com.larksuite.component.universe_design.tab.b r103 = (com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r102);
        if (r102 != r100) goto L7;
        boolean r104 = true;
    L8:
        r103.f285296e.setSelected(r104);
        TextView r105 = r103.a();
        if (r105 == null) goto L14;
        if (r104 == false) goto L13;
        w08.a.b(r105, 1);
        goto L14
    L13:
        w08.a.b(r105, 0);
    L14:
        r102 = r102 + 1;
        goto L3
    L7:
        r104 = false;
        goto L8
    }

    private final void dispatchTabReselected(com.larksuite.component.universe_design.tab.b r100) {
        int r101 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r101 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r101)).c(r100);
        r101 = r101 - 1;
        goto L3
    }

    private final void dispatchTabSelected(com.larksuite.component.universe_design.tab.b r100) {
        int r101 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r101 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r101)).b(r100);
        r101 = r101 - 1;
        goto L3
    }

    private final void dispatchTabUnselected(com.larksuite.component.universe_design.tab.b r100) {
        int r101 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r101 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r101)).a(r100);
        r101 = r101 - 1;
        goto L3
    }

    private final void forEachListenersReverse(Function1<? super b, Unit> r100) {
        int r101 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r101 < 0) goto L5;
        r100.invoke((b) ListProtector.get(this.selectedListeners, r101));
        r101 = r101 - 1;
        goto L3
    }

    private final void removeTabInternal(com.larksuite.component.universe_design.tab.b r100) {
        if (r100.f285297f == this.indicator.f285265d) goto L5;
    L8:
        this.tabs.remove(r100);
        c r101 = this.indicator;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tab");
        r101.removeView(r100.f285296e);
        r101.b();
        r101.f285270i = true;
        updateTabsPosition(r100.f285297f);
        return;
    L5:
        if (this.tabs.isEmpty() == false) goto L7;
        selectTabAt(-1);
        goto L8
    L7:
        selectTabAt(Math.max(0, r100.f285297f - 1));
        goto L8
    }

    private final void setupTabMaxWidth(int r100) {
        if (r100 != this.tabMaxWidth) goto L5;
        return;
    L5:
        Iterator<com.larksuite.component.universe_design.tab.b> r101 = this.tabs.iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        View r102 = r101.next().f285296e;
        if ((r102 instanceof f) == false) goto L11;
        f r103 = (f) r102;
    L12:
        if (r103 == null) goto L7;
        r103.setMaxWidth$universe_ui_tab_release(this.tabMaxWidth);
        goto L7
    L11:
        r103 = null;
        goto L12
    }

    private final void updateTabsPosition(int r100) {
        int r101 = this.tabs.size();
    L3:
        if (r100 >= r101) goto L5;
        ((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r100)).f285297f = r100;
        r100 = r100 + 1;
        goto L3
    }

    public final void addOnTabSelectedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.selectedListeners.add(r100);
    }

    public final void addTab(List<com.larksuite.component.universe_design.tab.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabs");
        Iterator<com.larksuite.component.universe_design.tab.b> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        addTab(r101.next());
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        addViewInternal(r100);
    }

    public final com.larksuite.component.universe_design.tab.b getTabAt(int r100) {
        return (com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r100);
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.edgeShadowEnable == true) goto L5;
    L15:
        super.onDrawForeground(r100);
        if (this.bottomDividerEnabled == false) goto L19;
        int r101 = getScrollX();
        int r102 = getHeight() - ((int) h18.d.b(getContext(), 1));
        int r103 = getWidth() + getScrollX();
        int r104 = getHeight();
        getBottomDividerDrawable().setBounds(r101, r102, r103, r104);
        getBottomDividerDrawable().draw(r100);
        return;
    L19:
        return;
    L5:
        if (this.edgeShadowShow == false) goto L15;
        int r105 = (getWidth() - ((int) h18.d.b(getContext(), 64))) + getScrollX();
        int r106 = getWidth() + getScrollX();
        int r107 = getHeight();
        if (this.edgeShadowDrawable != null) goto L9;
        this.edgeShadowDrawable = generateEdgeShadowDrawable();
    L9:
        GradientDrawable r108 = this.edgeShadowDrawable;
        if (r108 == null) goto L12;
        r108.setBounds(r105, 0, r106, r107);
    L12:
        GradientDrawable r109 = this.edgeShadowDrawable;
        if (r109 == null) goto L15;
        r109.draw(r100);
        goto L15
    }

    public final void removeOnTabSelectedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.selectedListeners.remove(r100);
    }

    public final void removeTab(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        removeTabInternal(r100);
    }

    public final void removeTabAt(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.tabs.size()) goto L8;
        removeTab((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r100));
        return;
    }

    public final void selectTab(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        selectTab$universe_ui_tab_release(r100, true);
    }

    public final void selectTabAt(int r100) {
        selectTabAt$universe_ui_tab_release(r100, true);
    }

    public final void setBottomDividerEnabled(boolean r100) {
        if (this.bottomDividerEnabled == r100) goto L6;
        this.bottomDividerEnabled = r100;
        invalidate();
        return;
    }

    public final void setEdgeShadowEnabled(boolean r100) {
        if (this.edgeShadowEnable == r100) goto L6;
        this.edgeShadowEnable = r100;
        updateEdgeShadow();
        return;
    }

    public final void setIndicatorColor(int r100) {
        Drawable r101 = this.indicator.f285262a;
        if (r101 == null) goto L5;
        r101.mutate();
        r101.setTint(r100);
    L5:
        this.indicator.invalidate();
    }

    public final void setIndicatorDrawable(int r100) {
        c r101 = this.indicator;
        r101.f285262a = UDIconUtils.getIconDrawable(getContext(), r100);
        r101.f285270i = true;
        r101.requestLayout();
        this.indicator.invalidate();
    }

    public final void setIndicatorFullWidth(boolean r100) {
        this.indicatorFullWidth = r100;
        c r101 = this.indicator;
        r101.a(r101.f285265d);
    }

    public final void setIndicatorHeight(int r100) {
        c r101 = this.indicator;
        r101.f285268g = r100;
        r101.invalidate();
    }

    public final void setIndicatorInterpolator(com.larksuite.component.universe_design.tab.c r100) {
        Intrinsics.checkNotNullParameter(r100, "indicatorInterpolator");
        c r101 = this.indicator;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f285267f = r100;
    }

    public final void setTabBackgroundColor(int r100) {
        setTabBackgroundColors(ColorStateList.valueOf(r100));
    }

    public final void setTabBackgroundColorResource(int r100) {
        setTabBackgroundColors(UDColorUtils.getColorStateList(getContext(), r100));
    }

    public final void setTabBackgroundColors(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.tabBackgroundColors = r100;
        updateTabsStyle();
        GradientDrawable r101 = this.edgeShadowDrawable;
        if (r101 == null) goto L13;
        int[] r102 = new int[2];
        ColorStateList r103 = this.tabBackgroundColors;
        ColorStateList r104 = null;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r103 = null;
    L7:
        r102[0] = UDColorUtils.getAlphaColor(r103.getDefaultColor(), 0.0f);
        ColorStateList r105 = this.tabBackgroundColors;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
    L11:
        r102[1] = r104.getDefaultColor();
        r101.setColors(r102);
        return;
    L10:
        r104 = r105;
        goto L11
    }

    public final void setTabGravity(@TabGravity int r100) {
        this.tabGravity = r100;
        applyTabGravity();
    }

    public final void setTabIconTintColor(int r100) {
        this.tabIconTintColors = ColorStateList.valueOf(r100);
        updateTabsStyle();
    }

    public final void setTabIconTintColorResource(int r100) {
        this.tabIconTintColors = UDColorUtils.getColorStateList(getContext(), r100);
        updateTabsStyle();
    }

    public final void setTabIconTintColors(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        this.tabIconTintColors = r100;
        updateTabsStyle();
    }

    public final void setTabMargin(int r100) {
        this.tabMargin = r100;
        updateTabsStyle();
    }

    public final void setTabMode(@TabMode int r100) {
        this.tabMode = r100;
        applyTabMode();
    }

    public final void setTabTitleColor(int r100) {
        this.tabTitleColors = ColorStateList.valueOf(r100);
        updateTabsStyle();
    }

    public final void setTabTitleColorResource(int r100) {
        this.tabTitleColors = UDColorUtils.getColorStateList(getContext(), r100);
        updateTabsStyle();
    }

    public final void setTabTitleColors(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.tabTitleColors = r100;
        updateTabsStyle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        addTab(r100, this.tabs.isEmpty());
    }

    public final void setIndicatorDrawable(Drawable r100) {
        c r101 = this.indicator;
        r101.f285262a = r100;
        r101.f285270i = true;
        r101.requestLayout();
        this.indicator.invalidate();
    }

    public UDTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private final void addTabToList(com.larksuite.component.universe_design.tab.b r100, int r101) {
        ListProtector.add(this.tabs, r101, r100);
        r100.f285293b = this;
        updateTabsPosition(r101);
        configureTabStyle(r100);
    }

    private final void addTabView(com.larksuite.component.universe_design.tab.b r100, boolean r101) {
        c r102 = this.indicator;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "tab");
        r102.addView(r100.f285296e, r100.f285297f);
        r102.b();
        r102.f285270i = true;
        if (r101 == false) goto L6;
        selectTabInternal(r100, true);
        return;
    }

    private final int calculateScrollXForTab(int r100, float r101) {
        int r102 = this.tabMode;
        int r103 = 0;
        if (r102 == 0) goto L7;
        if (r102 == 2) goto L7;
        return 0;
    L7:
        View r104 = this.indicator.getChildAt(r100);
        int r105 = r100 + 1;
        if (r105 > this.indicator.getChildCount()) goto L10;
        View r106 = this.indicator.getChildAt(r105);
    L11:
        if (r104 == null) goto L13;
        int r107 = r104.getWidth();
    L14:
        if (r106 == null) goto L17;
        r103 = r106.getWidth();
    L17:
        return (-(((getWidth() / 2) - (r107 / 2)) - r104.getLeft())) + ((int) (((r103 + r107) * 0.5f) * r101));
    L13:
        r107 = 0;
        goto L14
    L10:
        r106 = null;
        goto L11
    }

    private final ColorStateList createColorStateList(int r100, int r101) {
        return new ColorStateList(new int[][]{View.SELECTED_STATE_SET, View.EMPTY_STATE_SET}, new int[]{r101, r100});
    }

    private final void selectTabInternal(com.larksuite.component.universe_design.tab.b r100, boolean r110) {
        if (r100 != null) goto L8;
        c r101 = this.indicator;
        r101.f285265d = -1;
        if (r110 == false) goto L34;
        r101.a(-1);
        return;
    L34:
        return;
    L8:
        dispatchSelectState(r100.f285297f);
        int r102 = getSelectPosition();
        int r103 = r100.f285297f;
        c r104 = this.indicator;
        if (r103 != r104.f285265d) goto L11;
        dispatchTabReselected(r100);
        animateToTab(r100);
    L32:
        dispatchTabSelected(r100);
        return;
    L11:
        if (r110 == false) goto L29;
        animateToTab(r100);
        c r111 = this.indicator;
        boolean r105 = false;
        if (r102 == (-1)) goto L15;
        boolean r106 = true;
    L16:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r100, "tab");
        int r107 = r100.f285297f;
        if (r106 == false) goto L28;
        long r108 = access$getIndicatorAnimatorDuration$p(r111.f285271j);
        ValueAnimator r109 = r111.f285269h;
        if (r109 != null) goto L21;
    L23:
        if (r105 == false) goto L27;
        ValueAnimator r112 = r111.f285269h;
        if (r112 == null) goto L27;
        r112.cancel();
    L27:
        int r113 = r111.f285265d;
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setInterpolator((PathInterpolator) UDAnimation$Interpolator.f284491b.getValue());
        r114.setDuration(r108);
        r114.addUpdateListener(new com.larksuite.component.universe_design.tab.d(r111, r113, r107, r114));
        r114.addListener(new e(r111, r107));
        r114.start();
        r111.f285269h = r114;
    L30:
        if (r102 == (-1)) goto L32;
        dispatchTabUnselected((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r102));
        goto L32
    L21:
        if (r109.isRunning() != true) goto L23;
        r105 = true;
        goto L23
    L28:
        r111.f285265d = r107;
        r111.a(r107);
        r111.invalidate();
        goto L30
    L15:
        r106 = false;
        goto L16
    L29:
        r104.f285265d = r103;
        goto L30
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        addTab(r100, this.tabs.size(), r101);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        addViewInternal(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) != 0) goto L5;
        r102 = this.tabMaxWidth;
    L8:
        setupTabMaxWidth(r102);
        super.onMeasure(r100, r101);
        boolean r103 = true;
        if (getChildCount() != 1) goto L27;
        boolean r104 = false;
        View r105 = getChildAt(0);
        int r106 = this.tabMode;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L20;
    L24:
        if (r104 == false) goto L28;
        r105.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r101);
        return;
    L28:
        return;
    L17:
        if (r105.getMeasuredWidth() != getMeasuredWidth()) goto L23;
    L22:
        r103 = false;
    L23:
        r104 = r103;
    L20:
        if (r105.getMeasuredWidth() >= getMeasuredWidth()) goto L22;
    L27:
        return;
    L5:
        int r107 = this.tabMaxWidth;
        if (r107 <= 0) goto L8;
        r102 = r107;
        goto L8
    }

    public final void selectTab$universe_ui_tab_release(com.larksuite.component.universe_design.tab.b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        selectTabInternal(r100, r101);
    }

    public final void selectTabAt$universe_ui_tab_release(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
    L6:
        selectTabInternal(null, r101);
        return;
    L4:
        if (r100 >= this.tabs.size()) goto L6;
        selectTab$universe_ui_tab_release((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r100), r101);
    }

    public final void setTabIconTintColors(int r100, int r101) {
        this.tabIconTintColors = createColorStateList(r100, r101);
        updateTabsStyle();
    }

    public final void setTabTitleColors(int r100, int r101) {
        this.tabTitleColors = createColorStateList(r100, r101);
        updateTabsStyle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        addTab(r100, r101, false);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        addViewInternal(r100);
    }

    public UDTabLayout(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, R.style.UDTabLayout);
    }

    private final void addTabInternal(com.larksuite.component.universe_design.tab.b r100, int r101, boolean r102) {
        addTabToList(r100, r101);
        addTabView(r100, r102);
    }

    private final void applyAttrs(AttributeSet r100, int r101, int r102) {
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_tab_backgroundColor, R.attr.ud_tab_bottomDividerEnabled, R.attr.ud_tab_edgeShadowEnabled, R.attr.ud_tab_gravity, R.attr.ud_tab_iconTint, R.attr.ud_tab_indicator, R.attr.ud_tab_indicatorAnimationDuration, R.attr.ud_tab_indicatorColor, R.attr.ud_tab_indicatorFullWidth, R.attr.ud_tab_indicatorHeight, R.attr.ud_tab_layoutPaddingStart, R.attr.ud_tab_maxWidth, R.attr.ud_tab_minWidth, R.attr.ud_tab_mode, R.attr.ud_tab_multiLineTitleSize, R.attr.ud_tab_padding, R.attr.ud_tab_paddingBottom, R.attr.ud_tab_paddingEnd, R.attr.ud_tab_paddingStart, R.attr.ud_tab_paddingTop, R.attr.ud_tab_tabMargin, R.attr.ud_tab_titleColor, R.attr.ud_tab_titleSize, R.attr.ud_tab_titleTextAppearance}, r101, r102);
        setTabGravity(r103.getInt(3, this.tabGravity));
        setTabMode(r103.getInt(13, this.tabMode));
        ColorStateList r104 = r103.getColorStateList(0);
        if (r104 != null) goto L5;
        r104 = ColorStateList.valueOf(UDColorUtils.getColor(getContext(), R.color.bg_body));
    L5:
        this.tabBackgroundColors = r104;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r104 = null;
    L8:
        setBackgroundColor(r104.getDefaultColor());
        this.tabTitleTextAppearance = r103.getResourceId(23, R.style.UDText_Body2);
        this.tabTitleTextSize = r103.getDimensionPixelSize(22, this.tabTitleTextSize);
        this.tabMultiLineTitleTextSize = r103.getDimensionPixelSize(14, this.tabMultiLineTitleTextSize);
        ColorStateList r105 = r103.getColorStateList(21);
        if (r105 != null) goto L11;
        r105 = UDColorUtils.getColorStateList(getContext(), R.color.ud_tab_title_text_color);
    L11:
        this.tabTitleColors = r105;
        ColorStateList r106 = r103.getColorStateList(4);
        if (r106 != null) goto L14;
        r106 = UDColorUtils.getColorStateList(getContext(), R.color.ud_tab_title_text_color);
    L14:
        this.tabIconTintColors = r106;
        int r107 = r103.getDimensionPixelSize(15, 0);
        this.tabPaddingStart = r103.getDimensionPixelSize(18, r107);
        this.tabPaddingTop = r103.getDimensionPixelSize(19, r107);
        this.tabPaddingEnd = r103.getDimensionPixelSize(17, r107);
        this.tabPaddingBottom = r103.getDimensionPixelSize(16, r107);
        this.tabMargin = r103.getDimensionPixelSize(20, this.tabMargin);
        this.tabLayoutPaddingStart = r103.getDimensionPixelSize(10, 0);
        this.tabMinWidth = r103.getDimensionPixelSize(12, this.tabMinWidth);
        this.tabMaxWidth = r103.getDimensionPixelSize(11, this.tabMaxWidth);
        c r108 = this.indicator;
        r108.f285262a = r103.getDrawable(5);
        r108.f285270i = true;
        r108.requestLayout();
        if (r103.hasValue(7) == false) goto L17;
        setIndicatorColor(r103.getColor(7, 0));
    L17:
        setIndicatorHeight(r103.getDimensionPixelSize(9, 0));
        this.indicatorAnimatorDuration = r103.getInt(6, (int) this.indicatorAnimatorDuration);
        this.indicatorFullWidth = r103.getBoolean(8, this.indicatorFullWidth);
        this.edgeShadowEnable = r103.getBoolean(2, this.edgeShadowEnable);
        this.bottomDividerEnabled = r103.getBoolean(1, this.bottomDividerEnabled);
        r103.recycle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        addTabInternal(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        addViewInternal(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        addViewInternal(r100);
    }

    public UDTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        c r104 = new c(this, getContext());
        this.indicator = r104;
        this.tabs = new ArrayList();
        this.selectedListeners = new ArrayList();
        this.tabMode = 2;
        this.tabGravity = 1;
        this.tabMaxWidth = -1;
        this.indicatorAnimatorDuration = 300;
        this.edgeShadowEnable = true;
        this.indicatorFullWidth = true;
        this.tabTitleTextAppearance = R.style.UDText_Body2;
        this.tabTitleTextSize = h18.d.d(getContext(), R.dimen.ud_tabs_title_text_size);
        this.tabMultiLineTitleTextSize = h18.d.d(getContext(), R.dimen.ud_tabs_title_text_size_multi_line);
        this.scrollBounds = new Rect();
        this.bottomDividerDrawable$delegate = LazyKt.lazy(new UDTabLayout$bottomDividerDrawable$2(this));
        this.bottomDividerEnabled = true;
        applyAttrs(r101, r102, r103);
        super.addView(r104, 0, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        updateEdgeShadow();
    }

    public final void setScrollPosition$universe_ui_tab_release(int r100, float r101, boolean r110, boolean r111) {
        ValueAnimator r102 = this.scrollAnimator;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L13;
        ValueAnimator r105 = this.scrollAnimator;
        if (r105 == null) goto L13;
        r105.cancel();
    L13:
        if (Float.isNaN(r101) == false) goto L15;
        return;
    L15:
        int r106 = MathKt.roundToInt(r100 + r101);
        if (r106 >= 0) goto L18;
        return;
    L18:
        if (r106 >= this.tabs.size()) goto L39;
        scrollTo(calculateScrollXForTab(r100, r101), 0);
        if (r111 == false) goto L34;
        c r112 = this.indicator;
        int r107 = r100 + 1;
        Drawable r108 = r112.f285262a;
        if (r108 == null) goto L34;
        UDTabLayout r109 = r112.f285271j;
        ValueAnimator r113 = r112.f285269h;
        if (r113 != null) goto L27;
    L29:
        if (r103 == false) goto L33;
        ValueAnimator r114 = r112.f285269h;
        if (r114 == null) goto L33;
        r114.cancel();
    L33:
        com.larksuite.component.universe_design.tab.c r115 = r112.f285267f;
        View r116 = r112.getChildAt(r100);
        View r117 = r112.getChildAt(r107);
        r115.getClass();
        com.larksuite.component.universe_design.tab.c.c(r109, r116, r117, r101, r108);
        r112.invalidate();
        goto L34
    L27:
        if (r113.isRunning() != true) goto L29;
        r103 = true;
    L34:
        if (r110 == false) goto L38;
        dispatchSelectState(r106);
        return;
    L38:
        return;
    L39:
        return;
    L5:
        if (r102.isRunning() != true) goto L7;
        r104 = true;
        goto L8
    }

    public final void setTabPadding(int r100, int r101, int r102, int r103) {
        Iterator<com.larksuite.component.universe_design.tab.b> r104 = this.tabs.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().f285296e.setPaddingRelative(r100, r101, r102, r103);
        goto L4
    L6:
        this.indicator.f285270i = true;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        updateEdgeShadow();
    }
}

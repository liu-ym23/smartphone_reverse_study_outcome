package com.larus.common_ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.common_res.common_ui.databinding.LarusItemSuggestedActionBinding;
import com.larus.common_res.common_ui.databinding.LarusItemSuggestedActionLoadingBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n*\u0001,\u0018\u0000 j2\u00020\u0001:\u0003hijB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u00104\u001a\u0002052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u0011J\b\u00108\u001a\u000205H\u0014J\b\u00109\u001a\u000205H\u0014J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J9\u0010<\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\"2\b\u0010?\u001a\u0004\u0018\u0001012\b\b\u0002\u0010@\u001a\u00020\u00112\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010BJ=\u0010C\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\"2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00140E2\b\u0010?\u001a\u0004\u0018\u0001012\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010FJ5\u0010G\u001a\u0002052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\"2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00140E2\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010HJ1\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\u000fH\u0002J1\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020>2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010MJ\u0019\u0010S\u001a\u00020\u001f2\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u000205H\u0002J\b\u0010V\u001a\u000205H\u0002J\b\u0010W\u001a\u000205H\u0002J\b\u0010X\u001a\u000205H\u0002J\u0006\u0010Y\u001a\u000205J\u000e\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u00020\u0011J\u0010\u0010\\\u001a\u0002052\u0006\u00104\u001a\u00020\u0011H\u0002J\u000e\u0010]\u001a\u0002052\u0006\u0010$\u001a\u00020\u0011J \u0010^\u001a\u0002052\u0006\u0010_\u001a\u00020\u00112\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010aJ\u0006\u0010b\u001a\u000205J\u0018\u0010c\u001a\u0002052\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010aJ\u000e\u0010d\u001a\u0002052\u0006\u0010e\u001a\u00020\u0014J\u0010\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/larus/common_ui/view/SuggestedActionBar;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COLOR_START", "COLOR_END", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "clickEnabled", "", "darkMode", "itemPrefix", "", "animShowMode", "visibleItemSet", "", "directShowItemSet", "heightAnimator", "Landroid/animation/ValueAnimator;", "alphaAnimator", "Landroid/animation/ObjectAnimator;", "loadingDots", "", "Landroid/view/View;", "loadingDotsByItem", "", "", "loadingAnimator", "value", "", "loadingDuration", "getLoadingDuration", "()F", "setLoadingDuration", "(F)V", "scrollListener", "com/larus/common_ui/view/SuggestedActionBar$scrollListener$1", "Lcom/larus/common_ui/view/SuggestedActionBar$scrollListener$1;", "registeredViewTreeObserver", "Landroid/view/ViewTreeObserver;", "cb", "Lcom/larus/common_ui/view/SuggestedActionBar$Callback;", "contentVersion", "incrementalTransitionPending", "init", "", "setDarkMode", "enabled", "onAttachedToWindow", "onDetachedFromWindow", "addScrollChangedListener", "removeScrollChangedListener", "bindSuggestedAction", "items", "Lcom/larus/common_ui/view/SuggestedActionBar$SuggestedActionBarItem;", "callback", "withAnim", "itemBgDrawableRes", "(Ljava/util/List;Lcom/larus/common_ui/view/SuggestedActionBar$Callback;ZLjava/lang/Integer;)V", "insertSuggestedActionsFirstWithAnimate", "removeActionKeys", "", "(Ljava/util/List;Ljava/util/Set;Lcom/larus/common_ui/view/SuggestedActionBar$Callback;Ljava/lang/Integer;)V", "insertSuggestedActionsFirstNow", "(Ljava/util/List;Ljava/util/Set;Ljava/lang/Integer;)V", "bindItem", MapController.ITEM_LAYER_TAG, SlcFlexDirection.FLEX_ROW, "column", "(Lcom/larus/common_ui/view/SuggestedActionBar$SuggestedActionBarItem;IILjava/lang/Integer;)Landroid/view/View;", "findOrCreateLine", "updateItemMargins", "line", "bindNormalItem", "suggestedAction", "bindLoadingItem", "(Ljava/lang/Integer;)Landroid/view/View;", "startLoadingAnimator", "updateLoadingDotsAlpha", "refreshLoadingDots", "endIncrementalTransition", "resetUI", "setSuggestedActionBarEnabled", "enable", "checkItemVisible", "changeShowMode", "launchShowAnimator", "isShow", "endCallback", "Lkotlin/Function0;", "animShow", "animHide", "addPrefixToItems", "prefix", "buildDisplayName", CommonConstant.KEY_DISPLAY_NAME, "Callback", "SuggestedActionBarItem", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestedActionBar extends HorizontalScrollView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f328260t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f328263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f328264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f328266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f328267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f328268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f328269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f328270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ObjectAnimator f328271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<View> f328272l;
    private float loadingDuration;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<View, List<View>> f328273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f328274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i f328275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f328276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f328277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f328278r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f328279s;

    /* JADX INFO: loaded from: classes27.dex */
    public interface a {
        void a(String r100, int r101, int r102, boolean r103);

        void b(String r100, int r101, int r102, boolean r103);
    }

    public static final class b {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f328280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f328281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f328282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f328283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f328284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f328285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f328286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f328287h;

        public c() {
            this(null, 0, null, false, false, 255);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f328280a, r101.f328280a) == true) goto L12;
            return false;
        L12:
            if (this.f328281b == r101.f328281b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f328282c, r101.f328282c) == true) goto L18;
            return false;
        L18:
            if (this.f328283d == r101.f328283d) goto L21;
            return false;
        L21:
            if (this.f328284e == r101.f328284e) goto L24;
            return false;
        L24:
            if (this.f328285f == r101.f328285f) goto L27;
            return false;
        L27:
            if (this.f328286g == r101.f328286g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f328287h, r101.f328287h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f328280a.hashCode() * 31) + this.f328281b) * 31) + this.f328282c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f328283d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f328284e == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f328285f == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (r105 + r106) * 31;
            if (this.f328286g == true) goto L18;
            r101 = 1237;
        L18:
            int r108 = (r107 + r101) * 31;
            Integer r109 = this.f328287h;
            if (r109 != null) goto L21;
            int r110 = 0;
        L23:
            return r108 + r110;
        L21:
            r110 = r109.hashCode();
            goto L23
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "SuggestedActionBarItem(key=" + this.f328280a + ", row=" + this.f328281b + ", displayName=" + this.f328282c + ", highlight=" + this.f328283d + ", loading=" + this.f328284e + ", showIcon=" + this.f328285f + ", selected=" + this.f328286g + ", textColor=" + this.f328287h + ')';
        }

        public c(String r100, int r101, String r102, boolean r103, boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = false;
        L15:
            if ((r105 & 16) == 0) goto L18;
            r104 = false;
        L18:
            if ((r105 & 32) == 0) goto L20;
            boolean r106 = true;
        L21:
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
            this.f328280a = r100;
            this.f328281b = r101;
            this.f328282c = r102;
            this.f328283d = r103;
            this.f328284e = r104;
            this.f328285f = r106;
            this.f328286g = false;
            this.f328287h = null;
            return;
        L20:
            r106 = false;
            goto L21
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f328289b;

        public d(SuggestedActionBar r100, Function0 r101) {
            this.f328288a = r100;
            this.f328289b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            this.f328288a.i(false, this.f328289b);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328290a;

        public e(SuggestedActionBar r100) {
            this.f328290a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            SuggestedActionBar r109 = this.f328290a;
            int r110 = SuggestedActionBar.f328260t;
            r109.i(true, null);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class f implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f328292b;

        public f(SuggestedActionBar r100, boolean r101) {
            this.f328291a = r100;
            this.f328292b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            SuggestedActionBar.a(this.f328291a, true);
            if (this.f328292b == false) goto L6;
            this.f328291a.setAlpha(0.0f);
            this.f328291a.animate().alpha(1.0f).setDuration(120).start();
            return;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class g implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328293a;

        public g(SuggestedActionBar r100) {
            this.f328293a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            SuggestedActionBar.a(this.f328293a, true);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f328294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f328295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328296c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Unit> r101 = this.f328294a;
            if (r101 == null) goto L6;
            r101.invoke();
        L6:
            if (this.f328295b == true) goto L8;
            e1.o(this.f328296c);
        L8:
            SuggestedActionBar r102 = this.f328296c;
            ViewGroup.LayoutParams r103 = r102.getLayoutParams();
            if (r103 == null) goto L13;
            r103.height = -2;
            r102.setLayoutParams(r103);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        public h(Function0<Unit> r100, boolean r101, SuggestedActionBar r102) {
            this.f328294a = r100;
            this.f328295b = r101;
            this.f328296c = r102;
        }
    }

    public static final class i implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f328297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SuggestedActionBar f328298b;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (this.f328297a == this.f328298b.getScrollX()) goto L6;
            this.f328297a = this.f328298b.getScrollX();
            SuggestedActionBar.a(this.f328298b, false);
            return;
        }

        public i(SuggestedActionBar r100) {
            this.f328298b = r100;
            this.f328297a = -1;
        }
    }

    static {
    }

    public final void c() {
        if (this.f328267g == false) goto L5;
        this.f328267g = false;
        e1.x(this);
        addOnLayoutChangeListener(new e(this));
        return;
    L5:
        ValueAnimator r100 = this.f328270j;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        ObjectAnimator r101 = this.f328271k;
        if (r101 == null) goto L11;
        r101.cancel();
    L11:
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L16;
        r102.height = -2;
        setLayoutParams(r102);
        setAlpha(1.0f);
        e1.x(this);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void j() {
        this.f328278r++;
        scrollTo(0, 0);
        if (this.f328279s == false) goto L6;
        TransitionManager.endTransitions(this.f328263c);
        this.f328279s = false;
    L6:
        ObjectAnimator r100 = this.f328274n;
        if (r100 == null) goto L9;
        r100.cancel();
    L9:
        this.f328274n = null;
        ((ArrayList) this.f328272l).clear();
        ((LinkedHashMap) this.f328273m).clear();
        this.f328263c.removeAllViews();
    }

    public final void k() {
        ObjectAnimator r100 = this.f328274n;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f328274n = null;
        if (this.f328272l.isEmpty() == false) goto L8;
        return;
    L8:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "loadingDuration", new float[]{0.0f, 1.0f});
        r101.setRepeatCount(-1);
        r101.setDuration(800);
        r101.start();
        this.f328274n = r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver r100 = getViewTreeObserver();
        if (r100.isAlive() == true) goto L5;
    L7:
        boolean r101 = true;
        if ((!this.f328272l.isEmpty()) == false) goto L18;
        ObjectAnimator r102 = this.f328274n;
        if (r102 != null) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == true) goto L19;
        k();
        return;
    L19:
        return;
    L12:
        if (r102.isStarted() != true) goto L14;
    L18:
        return;
    L5:
        if (Intrinsics.areEqual(this.f328276p, r100) == true) goto L7;
        r100.addOnScrollChangedListener(this.f328275o);
        this.f328276p = r100;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver r100 = this.f328276p;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isAlive() != true) goto L7;
    L8:
        if (r101 == false) goto L11;
        r100.removeOnScrollChangedListener(this.f328275o);
    L13:
        this.f328276p = null;
        ObjectAnimator r102 = this.f328274n;
        if (r102 == null) goto L17;
        r102.cancel();
        return;
    L17:
        return;
    L11:
        if (getViewTreeObserver().isAlive() == false) goto L13;
        getViewTreeObserver().removeOnScrollChangedListener(this.f328275o);
    L7:
        r101 = false;
        goto L8
    }

    public final float getLoadingDuration() {
        return this.loadingDuration;
    }

    public SuggestedActionBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328261a = ColorProtector.parseColor("#FF9425");
        this.f328262b = ColorProtector.parseColor("#F038B8");
        this.f328263c = new LinearLayout(getContext());
        this.f328264d = true;
        this.f328266f = "";
        this.f328268h = new LinkedHashSet();
        this.f328269i = new LinkedHashSet();
        this.f328272l = new ArrayList();
        this.f328273m = new LinkedHashMap();
        this.f328275o = new i(this);
        g(null);
    }

    public static void l(LinearLayout r100) {
        Iterator<View> r101 = ViewGroupKt.getChildren(r100).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L17;
        View r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r105 = r103;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L16;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r102 != 0) goto L13;
        int r108 = 0;
    L14:
        r107.setMarginStart(r108);
        r105.setLayoutParams(r107);
        r102 = r104;
        goto L4
    L13:
        r108 = c7.b(8);
        goto L14
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b(Function0<Unit> r100) {
        if (this.f328267g == false) goto L5;
        this.f328267g = false;
        addOnLayoutChangeListener(new d(this, r100));
        return;
    L5:
        e1.o(this);
    }

    public final String f(String r100) {
        if (this.f328266f.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r100;
    L8:
        if (StringsKt.startsWith$default(r100, this.f328266f, false, 2, null) == false) goto L11;
        return r100;
    L11:
        return this.f328266f + r100;
    L5:
        r101 = false;
        goto L6
    }

    public final void g(AttributeSet r100) {
        this.f328263c.setOrientation(1);
        addView(this.f328263c);
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.larus_dark_mode});
        this.f328265e = r101.getBoolean(0, false);
        r101.recycle();
    }

    public final void setDarkMode(boolean r100) {
        this.f328265e = r100;
    }

    public final void setLoadingDuration(float r100) {
        this.loadingDuration = r100;
        Iterator r101 = CollectionsKt.reversed(this.f328272l).iterator();
    L4:
        if (r101.hasNext() == false) goto L23;
        View r102 = (View) r101.next();
        if (r100 >= 0.0f) goto L9;
        float r103 = 0.0f;
    L13:
        if (0.0f <= r103) goto L15;
    L17:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L21;
        float r105 = 1.0f - ((r103 * 0.9f) / 0.5f);
    L22:
        r102.setAlpha(r105);
        r100 = r100 + 0.167f;
        goto L4
    L21:
        r105 = (((r103 - 0.5f) * 0.9f) / 0.5f) + 0.1f;
        goto L22
    L15:
        if (r103 > 0.5f) goto L17;
        r104 = true;
        goto L19
    L9:
        if (r100 <= 1.0f) goto L11;
        r103 = r100 - 1.0f;
        goto L13
    L11:
        r103 = r100;
        goto L13
    }

    public final void setSuggestedActionBarEnabled(boolean r100) {
        this.f328264d = r100;
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    public SuggestedActionBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328261a = ColorProtector.parseColor("#FF9425");
        this.f328262b = ColorProtector.parseColor("#F038B8");
        this.f328263c = new LinearLayout(getContext());
        this.f328264d = true;
        this.f328266f = "";
        this.f328268h = new LinkedHashSet();
        this.f328269i = new LinkedHashSet();
        this.f328272l = new ArrayList();
        this.f328273m = new LinkedHashMap();
        this.f328275o = new i(this);
        g(r101);
    }

    public static final void a(SuggestedActionBar r110, boolean r111) {
        Iterator<View> r100 = ViewGroupKt.getChildren(r110.f328263c).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L45;
        View r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r104 = r102;
        if ((r104 instanceof ViewGroup) == false) goto L44;
        ViewGroup r105 = (ViewGroup) r104;
        Object r106 = r105.getTag();
        if ((r106 instanceof Integer) == false) goto L13;
        Integer r107 = (Integer) r106;
    L14:
        if (r107 == null) goto L16;
        r101 = r107.intValue();
    L16:
        Iterator<View> r108 = ViewGroupKt.getChildren(r105).iterator();
        int r109 = 0;
    L18:
        if (r108.hasNext() == false) goto L44;
        View r112 = r108.next();
        int r113 = r109 + 1;
        if (r109 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        View r114 = r112;
        Object r115 = r114.getTag();
        if ((r115 instanceof String) == false) goto L25;
        String r116 = (String) r115;
    L26:
        if (r116 == null) goto L43;
        Rect r117 = new Rect();
        if (r114.getGlobalVisibleRect(r117) == true) goto L31;
    L42:
        r110.f328268h.remove(r116);
        r110.f328269i.remove(r116);
        goto L43
    L31:
        if (r117.width() <= 0) goto L42;
        if (r117.height() <= 0) goto L42;
        if (r111 == false) goto L37;
        r110.f328269i.add(r116);
    L37:
        if (r110.f328268h.contains(r116) == true) goto L43;
        a r118 = r110.f328277q;
        if (r118 == null) goto L41;
        r118.b(r116, r101, r109, r110.f328269i.contains(r116));
    L41:
        r110.f328268h.add(r116);
    L43:
        r109 = r113;
        goto L18
    L25:
        r116 = null;
        goto L26
    L13:
        r107 = null;
    L44:
        r101 = r103;
        goto L4
    }

    public final void i(boolean r100, Function0<Unit> r110) {
        ValueAnimator r101 = this.f328270j;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        ObjectAnimator r102 = this.f328271k;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        if (r100 == false) goto L11;
        int r103 = 0;
    L12:
        if (r100 == false) goto L14;
        int r104 = getHeight();
    L15:
        float r105 = 1.0f;
        Interpolator r106 = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        if (r100 == false) goto L22;
        e1.x(this);
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if (r107 == null) goto L21;
        r107.height = 0;
        setLayoutParams(r107);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r103, r104});
        r108.setDuration(250);
        r108.setInterpolator(r106);
        r108.addUpdateListener(new w(this));
        r108.addListener(new h(r110, r100, this));
        this.f328270j = r108;
        if (r100 == false) goto L25;
        float r109 = 0.0f;
    L26:
        setAlpha(r109);
        Property r111 = HorizontalScrollView.ALPHA;
        float[] r112 = new float[2];
        if (r100 == false) goto L29;
        float r113 = 0.0f;
    L30:
        r112[0] = r113;
        if (r100 == true) goto L34;
        r105 = 0.0f;
    L34:
        r112[1] = r105;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this, r111, r112);
        long r115 = (long) (250 * 0.5f);
        r114.setDuration(r115);
        r114.setStartDelay(r115);
        this.f328271k = r114;
        ValueAnimator r116 = this.f328270j;
        if (r116 == null) goto L37;
        r116.start();
    L37:
        ObjectAnimator r117 = this.f328271k;
        if (r117 == null) goto L41;
        r117.start();
        return;
    L41:
        return;
    L29:
        r113 = 1.0f;
        goto L30
    L25:
        r109 = 1.0f;
        goto L26
    L14:
        r104 = 0;
        goto L15
    L11:
        r103 = getHeight();
        goto L12
    }

    public SuggestedActionBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328261a = ColorProtector.parseColor("#FF9425");
        this.f328262b = ColorProtector.parseColor("#F038B8");
        this.f328263c = new LinearLayout(getContext());
        this.f328264d = true;
        this.f328266f = "";
        this.f328268h = new LinkedHashSet();
        this.f328269i = new LinkedHashSet();
        this.f328272l = new ArrayList();
        this.f328273m = new LinkedHashMap();
        this.f328275o = new i(this);
        g(r101);
    }

    public final void h(List<c> r110, Set<String> r111, Integer r112) {
        if (this.f328279s == false) goto L6;
        TransitionManager.endTransitions(this.f328263c);
        this.f328279s = false;
    L6:
        LinearLayout r100 = this.f328263c;
        TransitionSet r101 = new TransitionSet();
        r101.setOrdering(0);
        r101.addTransition(new ChangeBounds());
        r101.addTransition(new Fade());
        r101.setDuration(200);
        TransitionManager.beginDelayedTransition(r100, r101);
        this.f328279s = true;
        List<c> r113 = r110;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r103 = r113.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(((c) r103.next()).f328280a);
        goto L8
    L10:
        Set r114 = SetsKt.plus(r111, CollectionsKt.toSet(r102));
        Iterator<View> r104 = ViewGroupKt.getChildren(this.f328263c).iterator();
    L12:
        if (r104.hasNext() == false) goto L26;
        View r105 = r104.next();
        if ((r105 instanceof LinearLayout) == false) goto L12;
        Iterator r106 = SequencesKt.toList(ViewGroupKt.getChildren((ViewGroup) r105)).iterator();
    L17:
        if (r106.hasNext() == false) goto L12;
        View r107 = (View) r106.next();
        Object r108 = r107.getTag();
        if ((r108 instanceof String) == false) goto L21;
        String r109 = (String) r108;
    L22:
        if (r109 == null) goto L17;
        if (r114.contains(r109) == false) goto L17;
        ((LinearLayout) r105).removeView(r107);
        goto L17
    L21:
        r109 = null;
        goto L22
    L26:
        Iterator r115 = r114.iterator();
    L28:
        if (r115.hasNext() == false) goto L30;
        String r116 = (String) r115.next();
        this.f328268h.remove(r116);
        this.f328269i.remove(r116);
        goto L28
    L30:
        LinkedHashMap r117 = new LinkedHashMap();
        Iterator<T> r118 = r113.iterator();
    L32:
        if (r118.hasNext() == false) goto L37;
        Object r119 = r118.next();
        Integer r120 = Integer.valueOf(((c) r119).f328281b);
        Object r121 = r117.get(r120);
        if (r121 != null) goto L36;
        r121 = new ArrayList();
        r117.put(r120, r121);
    L36:
        ((List) r121).add(r119);
        goto L32
    L37:
        Iterator r122 = MapsKt.toSortedMap(r117).entrySet().iterator();
    L39:
        if (r122.hasNext() == false) goto L78;
        Map.Entry r123 = (Map.Entry) r122.next();
        Integer r124 = (Integer) r123.getKey();
        List r125 = (List) r123.getValue();
        Intrinsics.checkNotNull(r124);
        int r126 = r124.intValue();
        Sequence r127 = SequencesKt.filter(ViewGroupKt.getChildren(this.f328263c), SuggestedActionBar$findOrCreateLine$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator r128 = r127.iterator();
    L42:
        if (r128.hasNext() == false) goto L46;
        Object r129 = r128.next();
        if (Intrinsics.areEqual(((LinearLayout) r129).getTag(), Integer.valueOf(r126)) == false) goto L42;
    L47:
        LinearLayout r130 = (LinearLayout) r129;
        if (r130 != null) goto L71;
        r130 = new LinearLayout(getContext());
        r130.setTag(Integer.valueOf(r126));
        int r131 = this.f328263c.getChildCount();
        Iterator<View> r132 = ViewGroupKt.getChildren(this.f328263c).iterator();
        int r133 = 0;
    L52:
        if (r132.hasNext() == false) goto L67;
        View r134 = r132.next();
        int r135 = r133 + 1;
        if (r133 >= 0) goto L56;
        CollectionsKt.throwIndexOverflow();
    L56:
        Object r136 = r134.getTag();
        if ((r136 instanceof Integer) == false) goto L59;
        Integer r137 = (Integer) r136;
    L60:
        if (r137 == null) goto L66;
        if (r137.intValue() <= r126) goto L66;
        if (r131 != this.f328263c.getChildCount()) goto L66;
        r131 = r133;
    L66:
        r133 = r135;
        goto L52
    L59:
        r137 = null;
        goto L60
    L67:
        LinearLayout r138 = this.f328263c;
        ViewGroup.MarginLayoutParams r139 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r126 == 0) goto L70;
        r139.topMargin = c7.b(12);
    L70:
        Unit r140 = Unit.INSTANCE;
        r138.addView(r130, r131, r139);
    L71:
        Intrinsics.checkNotNull(r125);
        Iterator r141 = CollectionsKt.asReversed(r125).iterator();
        int r142 = 0;
    L73:
        if (r141.hasNext() == false) goto L39;
        Object r143 = r141.next();
        int r144 = r142 + 1;
        if (r142 >= 0) goto L77;
        CollectionsKt.throwIndexOverflow();
    L77:
        c r145 = (c) r143;
        View r146 = d(r145, r124.intValue(), CollectionsKt.getLastIndex(r125) - r142, r112);
        r146.setTag(r145.f328280a);
        r130.addView(r146, 0, new ViewGroup.MarginLayoutParams(-2, -2));
        r142 = r144;
        goto L73
    L46:
        r129 = null;
        goto L47
    L78:
        Iterator r147 = SequencesKt.toList(ViewGroupKt.getChildren(this.f328263c)).iterator();
    L80:
        if (r147.hasNext() == false) goto L87;
        View r148 = (View) r147.next();
        if ((r148 instanceof LinearLayout) == false) goto L80;
        LinearLayout r149 = (LinearLayout) r148;
        if (r149.getChildCount() == 0) goto L85;
        l(r149);
        goto L80
    L85:
        this.f328263c.removeView(r148);
        goto L80
    L87:
        Sequence r150 = SequencesKt.filter(ViewGroupKt.getChildren(this.f328263c), SuggestedActionBar$refreshLoadingDots$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r150, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        ((LinkedHashMap) this.f328273m).keySet().retainAll(SequencesKt.toSet(SequencesKt.flatMap(r150, new x())));
        ((ArrayList) this.f328272l).clear();
        Collection r151 = ((LinkedHashMap) this.f328273m).values();
        List<View> r152 = this.f328272l;
        Iterator r153 = r151.iterator();
    L89:
        if (r153.hasNext() == false) goto L91;
        ((ArrayList) r152).addAll((Collection) r153.next());
        goto L89
    L91:
        k();
        addOnLayoutChangeListener(new g(this));
    }

    public final View d(c r110, final int r111, final int r112, Integer r113) {
        if (r110.f328284e == false) goto L30;
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.larus_item_suggested_action_loading, this, false);
        int r101 = R.id.suggested_action_loading_dot1;
        View r102 = ViewBindings.findChildViewById(r100, R.id.suggested_action_loading_dot1);
        if (r102 == null) goto L29;
        r101 = R.id.suggested_action_loading_dot2;
        View r103 = ViewBindings.findChildViewById(r100, R.id.suggested_action_loading_dot2);
        if (r103 == null) goto L29;
        r101 = R.id.suggested_action_loading_dot3;
        View r104 = ViewBindings.findChildViewById(r100, R.id.suggested_action_loading_dot3);
        if (r104 == null) goto L29;
        LinearLayout r105 = (LinearLayout) r100;
        LarusItemSuggestedActionLoadingBinding r106 = new LarusItemSuggestedActionLoadingBinding(r105, r102, r103, r104);
        if (this.f328265e == false) goto L13;
        r105.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.larus_bg_suggested_action_dark));
    L13:
        if (r113 == null) goto L15;
        r105.setBackground(ContextCompat.getDrawable(getContext(), r113.intValue()));
    L15:
        List<View> r107 = CollectionsKt.listOf(new View[]{r102, r103, r104});
        Iterator r108 = r107.iterator();
    L17:
        if (r108.hasNext() == false) goto L27;
        View r109 = (View) r108.next();
        if (this.f328265e == false) goto L26;
        Drawable r114 = r109.getBackground();
        if ((r114 instanceof GradientDrawable) == false) goto L23;
        GradientDrawable r115 = (GradientDrawable) r114;
    L24:
        if (r115 == null) goto L26;
        r115.setColor(v19.c.a(R.attr.larus_static_white, getContext(), android.R.color.white));
        goto L26
    L23:
        r115 = null;
    L26:
        List<View> r116 = this.f328272l;
        Intrinsics.checkNotNull(r109);
        ((ArrayList) r116).add(r109);
        goto L17
    L27:
        this.f328273m.put(r106.f326736a, r107);
        return r106.f326736a;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    L30:
        View r117 = LayoutInflater.from(getContext()).inflate(R.layout.larus_item_suggested_action, this, false);
        int r118 = R.id.suggested_action_icon;
        AppCompatImageView r119 = (AppCompatImageView) ViewBindings.findChildViewById(r117, R.id.suggested_action_icon);
        if (r119 == null) goto L51;
        r118 = R.id.suggested_action_text;
        TextView r120 = (TextView) ViewBindings.findChildViewById(r117, R.id.suggested_action_text);
        if (r120 == null) goto L51;
        LinearLayout r121 = (LinearLayout) r117;
        final LarusItemSuggestedActionBinding r122 = new LarusItemSuggestedActionBinding(r121, r119, r120);
        final String r123 = r110.f328280a;
        r121.setTag(r123);
        if (this.f328265e == false) goto L37;
        int r124 = v19.c.a(R.attr.larus_static_white, getContext(), android.R.color.white);
        r120.setTextColor(r124);
        r119.setColorFilter(r124);
        r121.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.larus_bg_suggested_action_dark));
    L37:
        if (r113 == null) goto L39;
        r121.setBackground(ContextCompat.getDrawable(getContext(), r113.intValue()));
    L39:
        r121.setSelected(r110.f328286g);
        Integer r125 = r110.f328287h;
        if (r125 == null) goto L43;
        r120.setTextColor(r125.intValue());
    L43:
        if (r110.f328285f == true) goto L46;
        e1.o(r119);
    L46:
        if (r110.f328283d == false) goto L48;
        r120.addOnLayoutChangeListener(new y(r122, this));
    L48:
        r120.setText(f(r110.f328282c));
        nda.d.a().oa(r120, r119);
        e1.d(r121, new v(this, r122, r111, r112, r123));
        return r121;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r117.getResources().getResourceName(r118)));
    }

    public final void e(List<c> r100, a r101, boolean r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f328277q = r101;
        j();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        Integer r105 = Integer.valueOf(((c) r104).f328281b);
        Object r106 = r102.get(r105);
        if (r106 != null) goto L8;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L8:
        ((List) r106).add(r104);
        goto L4
    L9:
        Iterator r107 = CollectionsKt.sorted(r102.keySet()).iterator();
    L11:
        if (r107.hasNext() == false) goto L26;
        int r108 = ((Number) r107.next()).intValue();
        List r109 = (List) r102.get(Integer.valueOf(r108));
        if (r109 == null) goto L11;
        LinearLayout r112 = new LinearLayout(getContext());
        r112.setTag(Integer.valueOf(r108));
        Iterator r113 = r109.iterator();
        int r114 = 0;
    L17:
        if (r113.hasNext() == false) goto L22;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        c r117 = (c) r115;
        View r118 = d(r117, r108, r114, r111);
        r118.setTag(r117.f328280a);
        r112.addView(r118, new ViewGroup.MarginLayoutParams(-2, -2));
        r114 = r116;
        goto L17
    L22:
        l(r112);
        ViewGroup.MarginLayoutParams r119 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r108 == 0) goto L25;
        r119.topMargin = c7.b(12);
    L25:
        this.f328263c.addView(r112, r119);
        goto L11
    L26:
        this.f328268h.clear();
        this.f328269i.clear();
        k();
        addOnLayoutChangeListener(new f(this, r110));
    }
}

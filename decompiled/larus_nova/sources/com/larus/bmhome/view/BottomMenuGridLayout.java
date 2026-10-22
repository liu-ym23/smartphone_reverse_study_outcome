package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common_res.common_ui.databinding.LarusWidgetBottomMenuGridItemBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b-\u0018\u0000 I2\u00020\u0001:\u0001IB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u001f\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0011J\u0016\u0010!\u001a\u00020\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H\u0002J\u0016\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010)\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001cJ\u0016\u0010,\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H\u0002J\u0016\u0010.\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H\u0002J\u0018\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u0014H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u001cH\u0002J\u0018\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0014H\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u00020\u0014H\u0014J\b\u00109\u001a\u00020\u0014H\u0014J(\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0019H\u0002J\u0010\u0010A\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0007H\u0002J\u0006\u0010B\u001a\u00020\u0014J\b\u0010C\u001a\u00020\u0014H\u0002J\u0006\u0010D\u001a\u00020\u0007JJ\u0010E\u001a\u00020\u00142B\u0010F\u001a>\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u000fJ\b\u0010G\u001a\u00020\u0014H\u0002J\u0016\u0010H\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u009a\u0001\u0010\u0015\u001a@\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f2D\u0010\u000e\u001a@\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/bmhome/view/BottomMenuGridLayout;", "Landroid/widget/GridLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "useNewStyle", "", "isImmerse", "immerseColor", "value", "Lkotlin/Function6;", "Landroid/view/View;", "", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "", "bottomMenuCallback", "setBottomMenuCallback", "(Lkotlin/jvm/functions/Function6;)V", "menuItems", "Lcom/larus/bmhome/view/BottomMenuItem;", "itemBindings", "", "", "Lcom/larus/common_res/common_ui/databinding/LarusWidgetBottomMenuGridItemBinding;", "itemClickableSnapshot", "setItems", "items", "applyItems", "visibleItems", "updateItemEnabled", "itemId", "enabled", "updateAllItemsEnabled", "updateAllItemsClickable", "clickable", "updateItemIcon", "iconRes", "isItemVisible", "isSameItems", "newItems", "updateItemsState", "updateItemClickableSnapshot", "rebuildLayout", "triggerWidthCheck", "reason", "checkWidthAndRelayoutIfNeeded", "viewCount", DBDefinition.RETRY_COUNT, "reapplyItemHeightAndRequestLayout", "buildParentChain", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "createItemBinding", MapController.ITEM_LAYER_TAG, "updateRowCount", "updateBottomMenuUIToNewStyle", "applyNewStyleToAllItems", "getBottomMenuHeight", "setCallback", "callback", "invokeCallback", "setImmerse", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomMenuGridLayout extends GridLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f315381h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f315382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f315383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f315384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function6<? super View, ? super List<? extends View>, ? super List<? extends ImageView>, ? super List<? extends TextView>, ? super Boolean, ? super Boolean, Unit> f315385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<k> f315386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, LarusWidgetBottomMenuGridItemBinding> f315387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Boolean> f315388g;

    public static final class a {
    }

    public BottomMenuGridLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomMenuGridLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        v19.c.b(R.attr.larus_neutral_70, null, R.color.larus_neutral_70);
        v19.c.b(R.attr.larus_bg_bottom_menu_background, null, R.drawable.larus_bg_bottom_menu_background);
    }

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f315387f).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L26;
        LarusWidgetBottomMenuGridItemBinding r101 = (LarusWidgetBottomMenuGridItemBinding) r100.next();
        AppCompatImageView r102 = r101.f326832c;
        r102.setBackground(null);
        Intrinsics.checkNotNull(r102);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L25;
        r103.height = -2;
        r102.setLayoutParams(r103);
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L23;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.bottomMargin = r102.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_1, null, R.dimen.larus_dp_1));
        r102.setLayoutParams(r105);
        LinearLayout r106 = r101.f326833d;
        if (this.f315383b == false) goto L12;
        GradientDrawable r107 = new GradientDrawable();
        r107.setShape(0);
        r107.setCornerRadius(c7.b(16));
        r107.setColor(this.f315384c);
        Drawable r108 = r107;
    L13:
        r106.setBackground(r108);
        Intrinsics.checkNotNull(r106);
        ViewGroup.LayoutParams r109 = r106.getLayoutParams();
        if (r109 == null) goto L21;
        r109.height = r106.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_85, null, R.dimen.larus_dp_85));
        r106.setLayoutParams(r109);
        ViewGroup.LayoutParams r110 = r106.getLayoutParams();
        if (r110 == null) goto L19;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        r111.setMarginStart(r106.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_4, null, R.dimen.larus_dp_4)));
        r111.setMarginEnd(r106.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_4, null, R.dimen.larus_dp_4)));
        r106.setLayoutParams(r111);
        goto L4
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        r108 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_bg_bottom_menu_background, getContext(), R.drawable.larus_bg_bottom_menu_background));
        goto L13
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final String b() {
        ArrayList r100 = new ArrayList();
        ViewParent r101 = getParent();
        int r102 = 0;
    L3:
        if (r101 == null) goto L8;
        if (r102 >= 6) goto L8;
        r100.add(r101.getClass().getSimpleName());
        r101 = r101.getParent();
        r102 = r102 + 1;
    L8:
        return CollectionsKt.joinToString$default(r100, "->", null, null, 0, null, null, 62, null);
    }

    public final void d() {
        Collection r100 = ((LinkedHashMap) this.f315387f).values();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((LarusWidgetBottomMenuGridItemBinding) r102.next()).f326834e);
        goto L4
    L6:
        Collection r103 = ((LinkedHashMap) this.f315387f).values();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r104.add(((LarusWidgetBottomMenuGridItemBinding) r105.next()).f326832c);
        goto L8
    L10:
        Collection r106 = ((LinkedHashMap) this.f315387f).values();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        r107.add(((LarusWidgetBottomMenuGridItemBinding) r108.next()).f326833d);
        goto L12
    L14:
        LinkedHashMap r109 = new LinkedHashMap();
        Iterator r110 = ((LinkedHashMap) this.f315387f).entrySet().iterator();
    L16:
        if (r110.hasNext() == false) goto L18;
        Map.Entry r111 = (Map.Entry) r110.next();
        LinearLayout r112 = ((LarusWidgetBottomMenuGridItemBinding) r111.getValue()).f326831b;
        r112.setClipToPadding(false);
        r112.setClipChildren(false);
        r109.put(r111.getKey(), ((LarusWidgetBottomMenuGridItemBinding) r111.getValue()).f326832c);
        goto L16
    L18:
        nda.d.a().ia(r109);
        Function6<? super View, ? super List<? extends View>, ? super List<? extends ImageView>, ? super List<? extends TextView>, ? super Boolean, ? super Boolean, Unit> r113 = this.f315385d;
        if (r113 == null) goto L26;
        r113.invoke(this, r107, r104, r101, Boolean.valueOf(this.f315382a), Boolean.valueOf(this.f315383b));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FLogger.f375446a.i("BottomMenuGridLayout", "onDetachedFromWindow width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " childCount:" + getChildCount());
        super.onDetachedFromWindow();
    }

    public final int getBottomMenuHeight() {
        if (getRowCount() > 1) goto L9;
        if (this.f315382a == false) goto L15;
        return getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_124, null, R.dimen.larus_dp_124));
    L15:
        return getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_130, null, R.dimen.larus_dp_130));
    L9:
        if (this.f315382a == false) goto L11;
        int r100 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_124, null, R.dimen.larus_dp_124));
        int r101 = getRowCount() - 1;
        int r102 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_93, null, R.dimen.larus_dp_93));
    L13:
        return r100 + (r101 * r102);
    L11:
        r100 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_130, null, R.dimen.larus_dp_130));
        r101 = getRowCount() - 1;
        r102 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_93, null, R.dimen.larus_dp_93));
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.f375446a.i("BottomMenuGridLayout", "onAttachedToWindow width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " visibility:" + getVisibility() + " windowVisibility:" + getWindowVisibility() + " parentChain:" + b());
        e("onAttachedToWindow");
    }

    private final void setBottomMenuCallback(Function6<? super View, ? super List<? extends View>, ? super List<? extends ImageView>, ? super List<? extends TextView>, ? super Boolean, ? super Boolean, Unit> r100) {
        this.f315385d = r100;
        if (r100 == null) goto L6;
        d();
        return;
    }

    public final void e(String r100) {
        final int r101 = this.f315386e.size();
        if (r101 == 4) goto L5;
        return;
    L5:
        FLogger.f375446a.i("BottomMenuGridLayout", "triggerWidthCheck reason:" + r100 + " width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " childCount:" + getChildCount() + " rowCount:" + getRowCount() + " columnCount:" + getColumnCount());
        post(new c(this, r101));
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L4;
    L10:
        Iterator r101 = ((LinkedHashMap) this.f315387f).entrySet().iterator();
    L12:
        if (r101.hasNext() == false) goto L23;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        LarusWidgetBottomMenuGridItemBinding r104 = (LarusWidgetBottomMenuGridItemBinding) r102.getValue();
        LinearLayout r105 = r104.f326831b;
        if (r100 == false) goto L21;
        Map<String, Boolean> r106 = this.f315388g;
        if (r106 == null) goto L20;
        Boolean r107 = r106.get(r103);
        if (r107 == null) goto L20;
        boolean r108 = r107.booleanValue();
    L22:
        r105.setClickable(r108);
    L20:
        r108 = r104.f326831b.isClickable();
        goto L22
    L21:
        r108 = false;
        goto L22
    L23:
        if (r100 == false) goto L31;
        this.f315388g = null;
        return;
    L31:
        return;
    L4:
        if (this.f315388g != null) goto L10;
        Map<String, LarusWidgetBottomMenuGridItemBinding> r109 = this.f315387f;
        LinkedHashMap r110 = new LinkedHashMap(MapsKt.mapCapacity(r109.size()));
        Iterator r111 = ((LinkedHashMap) r109).entrySet().iterator();
    L7:
        if (r111.hasNext() == false) goto L9;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.put(r112.getKey(), Boolean.valueOf(((LarusWidgetBottomMenuGridItemBinding) r112.getValue()).f326831b.isClickable()));
        goto L7
    L9:
        this.f315388g = MapsKt.toMutableMap(r110);
        goto L10
    }

    public final void setCallback(Function6<? super View, ? super List<? extends View>, ? super List<? extends ImageView>, ? super List<? extends TextView>, ? super Boolean, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        setBottomMenuCallback(r100);
    }

    public final void setItems(final List<k> r210) {
        Intrinsics.checkNotNullParameter(r210, "items");
        String r100 = ThreadMethodProxy.currentThread().getName();
        long r101 = ThreadMethodProxy.currentThread().getId();
        boolean r102 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
    L6:
        if (r104 == null) goto L8;
        String r105 = r104.getClass().getSimpleName();
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L13;
        String r110 = CollectionsKt.joinToString$default(ArraysKt.take(new Throwable().getStackTrace(), 6), " <- ", null, null, 0, null, new d(), 30, null);
        FLogger.f375446a.e("BottomMenuGridLayout", "setItems offMainThread thread:" + r100 + '#' + r101 + " caller:" + r110 + " ids:" + CollectionsKt.joinToString$default(r210, null, null, null, 0, null, new e(), 31, null));
        post(new f(this, r210));
        return;
    L13:
        ArrayList r111 = new ArrayList();
        Iterator<T> r106 = r210.iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        Object r112 = r106.next();
        if (((k) r112).f316996e == false) goto L15;
        r111.add(r112);
        goto L15
    L19:
        FLogger.f375446a.i("BottomMenuGridLayout", "setItems total:" + r210.size() + " visible:" + r111.size() + " ids:" + CollectionsKt.joinToString$default(r111, null, null, null, 0, null, new g(), 31, null) + " thread:" + r100 + '#' + r101 + " main:" + r102 + " width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " attached:" + isAttachedToWindow() + " visibility:" + getVisibility() + " windowVisibility:" + getWindowVisibility() + " parent:" + r105 + " parentChain:" + b());
        if (this.f315386e.size() != r111.size()) goto L32;
        List r107 = CollectionsKt.zip(this.f315386e, r111);
        if ((r107 instanceof Collection) == true) goto L25;
    L27:
        Iterator r108 = r107.iterator();
    L29:
        if (r108.hasNext() == false) goto L33;
        Pair r109 = (Pair) r108.next();
        if (Intrinsics.areEqual(((k) r109.component1()).f316992a, ((k) r109.component2()).f316992a) == true) goto L29;
    L33:
        boolean r113 = true;
    L35:
        if (r113 == false) goto L48;
        FLogger.f375446a.i("BottomMenuGridLayout", "setItems skipRebuild sameIds:true rowCount:" + getRowCount() + " columnCount:" + getColumnCount() + " width:" + getWidth() + " measuredWidth:" + getMeasuredWidth());
        Iterator r114 = r111.iterator();
    L38:
        if (r114.hasNext() == false) goto L106;
        k r115 = (k) r114.next();
        LarusWidgetBottomMenuGridItemBinding r116 = (LarusWidgetBottomMenuGridItemBinding) ((LinkedHashMap) this.f315387f).get(r115.f316992a);
        if (r116 == null) goto L38;
        LinearLayout r117 = r116.f326831b;
        if (r115.f316995d == false) goto L44;
        float r118 = 1.0f;
    L45:
        r117.setAlpha(r118);
        r116.f326831b.setClickable(r115.f316995d);
        String r119 = r115.f316992a;
        boolean r120 = r115.f316995d;
        Map<String, Boolean> r121 = this.f315388g;
        if (r121 == null) goto L38;
        r121.put(r119, Boolean.valueOf(r120));
        goto L38
    L44:
        r118 = 0.3f;
        goto L45
    L106:
        return;
    L48:
        this.f315386e = r111;
        FLogger r122 = FLogger.f375446a;
        r122.i("BottomMenuGridLayout", "rebuildLayout start width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " childCount:" + getChildCount() + " thread:" + ThreadMethodProxy.currentThread().getName() + '#' + ThreadMethodProxy.currentThread().getId());
        removeAllViews();
        ((LinkedHashMap) this.f315387f).clear();
        int r123 = this.f315386e.size();
        if (r123 != 0) goto L52;
        return;
    L52:
        if (r123 > 4) goto L54;
        setColumnCount(r123);
        setRowCount(1);
    L57:
        r122.d("BottomMenuGridLayout", "updateRowCount viewCount:" + r123 + " rowCount:" + getRowCount() + " columnCount:" + getColumnCount() + " thread:" + ThreadMethodProxy.currentThread().getName() + '#' + ThreadMethodProxy.currentThread().getId() + " main:" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        Iterator<T> r124 = this.f315386e.iterator();
    L59:
        if (r124.hasNext() == false) goto L77;
        final k r125 = (k) r124.next();
        View r126 = LayoutInflater.from(getContext()).inflate(R.layout.larus_widget_bottom_menu_grid_item, null, false);
        LinearLayout r127 = (LinearLayout) r126;
        int r128 = R.id.layout_menu_item_icon;
        AppCompatImageView r129 = (AppCompatImageView) ViewBindings.findChildViewById(r126, R.id.layout_menu_item_icon);
        if (r129 == null) goto L75;
        r128 = R.id.layout_menu_item_icon_area;
        LinearLayout r211 = (LinearLayout) ViewBindings.findChildViewById(r126, R.id.layout_menu_item_icon_area);
        if (r211 == null) goto L75;
        r128 = R.id.layout_menu_item_name;
        AppCompatTextView r130 = (AppCompatTextView) ViewBindings.findChildViewById(r126, R.id.layout_menu_item_name);
        if (r130 == null) goto L75;
        final LarusWidgetBottomMenuGridItemBinding r131 = new LarusWidgetBottomMenuGridItemBinding(r127, r127, r129, r211, r130);
        r129.setImageResource(r125.f316993b);
        r130.setText(r125.f316994c);
        if (r125.f316995d == false) goto L69;
        float r132 = 1.0f;
    L70:
        r127.setAlpha(r132);
        r127.setClickable(r125.f316995d);
        String r133 = r125.f316992a;
        boolean r134 = r125.f316995d;
        Map<String, Boolean> r135 = this.f315388g;
        if (r135 == null) goto L73;
        r135.put(r133, Boolean.valueOf(r134));
    L73:
        com.larus.utils.e1.d(r127, new h(r125, r131));
        this.f315387f.put(r125.f316992a, r131);
        GridLayout.LayoutParams r136 = new GridLayout.LayoutParams();
        r136.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
        r136.width = 0;
        r136.height = -2;
        Unit r137 = Unit.INSTANCE;
        addView(r127, r136);
        goto L59
    L69:
        r132 = 0.3f;
    L75:
        throw new NullPointerException("Missing required view with ID: ".concat(r126.getResources().getResourceName(r128)));
    L77:
        if (this.f315382a == false) goto L80;
        a();
    L80:
        if (this.f315385d == null) goto L82;
        d();
    L82:
        FLogger.f375446a.i("BottomMenuGridLayout", "rebuildLayout end width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " childCount:" + getChildCount() + " thread:" + ThreadMethodProxy.currentThread().getName() + '#' + ThreadMethodProxy.currentThread().getId());
        e("rebuildLayout_end");
        return;
    L54:
        if (r123 > 6) goto L56;
        setColumnCount(3);
        setRowCount((r123 + 2) / 3);
        goto L57
    L56:
        setColumnCount(4);
        setRowCount((r123 + 3) / 4);
        goto L57
    L25:
        if (r107.isEmpty() == false) goto L27;
    L32:
        r113 = false;
        goto L35
    L8:
        r105 = "null";
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void c(final int r210, final int r211) {
        if (r210 == 4) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L11;
        FLogger.f375446a.i("BottomMenuGridLayout", "width_check_wait retry:" + r211 + " width:" + getWidth() + " measuredWidth:" + getMeasuredWidth() + " childCount:" + getChildCount());
        if (r211 >= 3) goto L50;
        post(new i(this, r210, r211));
        return;
    L50:
        return;
    L11:
        boolean r100 = false;
        IntRange r101 = RangesKt.until(0, getChildCount());
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        r102.add(Integer.valueOf(getChildAt(((IntIterator) r103).nextInt()).getWidth()));
        goto L13
    L15:
        IntRange r104 = RangesKt.until(0, getChildCount());
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<Integer> r106 = r104.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        r105.add(Integer.valueOf(getChildAt(((IntIterator) r106).nextInt()).getMeasuredWidth()));
        goto L17
    L19:
        IntRange r107 = RangesKt.until(0, getChildCount());
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<Integer> r109 = r107.iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        int r110 = ((IntIterator) r109).nextInt();
        View r111 = getChildAt(r110);
        r108.add("[" + r110 + ':' + r111.getLeft() + '-' + r111.getRight() + ']');
        goto L21
    L23:
        int r112 = getWidth();
        Integer r113 = (Integer) CollectionsKt.maxOrNull(r102);
        if (r113 == null) goto L26;
        int r114 = r113.intValue();
    L27:
        float r115 = r112 / 4.0f;
        if (r114 <= r112) goto L30;
    L31:
        r100 = true;
    L33:
        if (r100 == false) goto L43;
        FLogger r116 = FLogger.f375446a;
        r116.e("BottomMenuGridLayout", "width_abnormal parentWidth:" + r112 + " measuredWidth:" + getMeasuredWidth() + " childWidths:" + r102 + " childMeasuredWidths:" + r105 + " childLeftRight:" + r108 + " paddingStart:" + getPaddingStart() + " paddingEnd:" + getPaddingEnd() + " columnCount:" + getColumnCount() + " rowCount:" + getRowCount() + " itemIds:" + CollectionsKt.joinToString$default(this.f315386e, null, null, null, 0, null, new j(), 31, null));
        StringBuilder r117 = new StringBuilder("reapplyItemHeightAndRequestLayout width:");
        r117.append(getWidth());
        r117.append(" measuredWidth:");
        r117.append(getMeasuredWidth());
        r117.append(" attached:");
        r117.append(isAttachedToWindow());
        r117.append(" parentChain:");
        r117.append(b());
        r116.i("BottomMenuGridLayout", r117.toString());
        Iterator r118 = ((LinkedHashMap) this.f315387f).values().iterator();
    L36:
        if (r118.hasNext() == false) goto L42;
        LinearLayout r119 = ((LarusWidgetBottomMenuGridItemBinding) r118.next()).f326831b;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L41;
        r120.height = -2;
        r119.setLayoutParams(r120);
        goto L36
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L42:
        requestLayout();
        return;
    L43:
        FLogger.f375446a.i("BottomMenuGridLayout", "width_check_ok parentWidth:" + r112 + " childWidths:" + r102 + " childMeasuredWidths:" + r105 + " childLeftRight:" + r108 + " columnCount:" + getColumnCount() + " rowCount:" + getRowCount());
        return;
    L30:
        if (r114 <= (r115 * 1.8f)) goto L33;
    L26:
        r114 = 0;
        goto L27
    }

    public final void g(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        LarusWidgetBottomMenuGridItemBinding r102 = (LarusWidgetBottomMenuGridItemBinding) ((LinkedHashMap) this.f315387f).get(r100);
        if (r102 == null) goto L12;
        LinearLayout r103 = r102.f326831b;
        if (r101 == false) goto L7;
        float r104 = 1.0f;
    L8:
        r103.setAlpha(r104);
        r102.f326831b.setClickable(r101);
        Map<String, Boolean> r105 = this.f315388g;
        if (r105 == null) goto L13;
        r105.put(r100, Boolean.valueOf(r101));
        return;
    L13:
        return;
    L7:
        r104 = 0.3f;
        goto L8
    }

    public BottomMenuGridLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315386e = CollectionsKt.emptyList();
        this.f315387f = new LinkedHashMap();
        int r103 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_2, null, R.dimen.larus_dp_2));
        int r104 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_6, null, R.dimen.larus_dp_6));
        setPadding(r104, r103, r104, getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_14, null, R.dimen.larus_dp_14)));
    }

    public /* synthetic */ BottomMenuGridLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        FLogger.f375446a.i("BottomMenuGridLayout", "onSizeChanged w:" + r100 + " h:" + r101 + " oldw:" + r102 + " oldh:" + r103 + " childCount:" + getChildCount() + " rowCount:" + getRowCount() + " columnCount:" + getColumnCount());
        if (getChildCount() <= 0) goto L6;
        e("onSizeChanged");
        return;
    }
}

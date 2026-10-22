package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0019J\u0006\u0010%\u001a\u00020\u0000J\u001e\u0010&\u001a\u00020\u00002\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010(\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0011J*\u0010+\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u001bJ;\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:J\n\u0010;\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010<\u001a\u00020\u0017H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\u0013\u0010>\u001a\u0004\u0018\u00010\u001b2\u0006\u0010?\u001a\u00020\nH\u0086\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "Lcom/larus/bmhome/view/screenmenu/widget/MaxWidthLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "menuHandler", "", "Lkotlin/reflect/KClass;", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItemHandler;", "menuItems", "", "itemClickListener", "Lkotlin/Function1;", "", "divideItemDrawable", "Landroid/graphics/drawable/Drawable;", "maskView", "Landroid/view/View;", "wrapperPadding", "dividerHorizontalMargin", "init", "contentWidthFixed", "fixedWidth", "setDividerHorizontalMargin", "marginPx", "applyItemDividerDrawable", "drawable", "contentWidthAdaptive", "support", "kClass", "handler", "update", MapController.ITEM_LAYER_TAG, "prepare", "items", "", "listener", "setWrapperPadding", GXTemplateKey.FLEXBOX_PADDING, "wrap", "wrapWithPadding", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/view/View;", "setMaskView", "visible", "", "ensureDivideDrawable", "addDivider", "tryRemovePreDivider", MonitorConstants.CONNECT_TYPE_GET, "id", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMenu extends MaxWidthLinearLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f317223j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f317224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<? extends ot8.a>, ot8.b> f317225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ot8.a> f317226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super ot8.a, Unit> f317227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f317228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f317229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f317230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f317231i;

    public final View i() {
        FrameLayout r100 = new FrameLayout(getContext());
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));     // Catch: Throwable -> L5
        r100.addView(this);     // Catch: Throwable -> L5
        r100.setBackgroundResource(R.drawable.larus_bg_common_menu);     // Catch: Throwable -> L5
        int r102 = this.f317230h;     // Catch: Throwable -> L5
        r100.setPadding(r102, r102, r102, r102);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        FLogger.f375446a.i(this.f317224b, r104.toString());
    L10:
        return r100;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public CommonMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f317224b = "CommonMenu";
        this.f317225c = new LinkedHashMap();
        this.f317226d = new ArrayList();
        this.f317227e = new f();
        this.f317230h = i5.Q();
        f(r100, null);
    }

    public final void d(int r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101.width == r100) goto L6;
        r101.width = r100;
        setLayoutParams(r101);
        return;
    }

    public final View e(int r100) {
        return findViewById(r100);
    }

    public final void setMaskView(boolean r100) {
        ViewParent r101 = getParent();
        if ((r101 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r101;
    L6:
        if (r102 == null) goto L19;
        r102.setClickable(r100);
        if (r100 == true) goto L10;
        View r103 = this.f317229g;
        if (r103 == null) goto L22;
        com.larus.utils.e1.o(r103);
        return;
    L22:
        return;
    L10:
        if (this.f317229g != null) goto L12;
        View r104 = new View(getContext());
        r104.setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight()));
        r104.setBackgroundResource(v19.c.b(R.attr.larus_fg_common_menu_mask, r104.getContext(), R.drawable.larus_fg_common_menu_mask));
        r104.setAlpha(0.5f);
        r104.setClickable(true);
        this.f317229g = r104;
        r102.addView(r104);
    L12:
        View r105 = this.f317229g;
        if (r105 == null) goto L20;
        com.larus.utils.e1.x(r105);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void update(ot8.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        View r101 = findViewById(r100.getId());
        if (r101 != null) goto L5;
        return;
    L5:
        ot8.b r102 = this.f317225c.get(Reflection.getOrCreateKotlinClass(r100.getClass()));
        if (r102 != null) goto L8;
        return;
    L8:
        Function1<? super ot8.a, Unit> r103 = this.f317227e;
        r102.update(r100, r101);
        r102.b(this, r100, r101, r103);
    }

    public CommonMenu(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f317224b = "CommonMenu";
        this.f317225c = new LinkedHashMap();
        this.f317226d = new ArrayList();
        this.f317227e = new f();
        this.f317230h = i5.Q();
        f(r100, r101);
    }

    public final void f(Context r100, AttributeSet r101) {
        setOrientation(1);
        setLayoutParams(new LinearLayoutCompat.LayoutParams(i5.F(), -2));
        setBackgroundResource(v19.c.b(R.attr.larus_bg_common_menu_new, r100, R.drawable.larus_bg_common_menu_new));
        this.f317228f = ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_common_menu_divider, r100, R.drawable.larus_common_menu_divider));
        h(Reflection.getOrCreateKotlinClass(l0.class), new q0());
        if (com.larus.utils.i.h(r100) == false) goto L6;
        setLayoutDirection(1);
        return;
    }

    @Deprecated(message = "remember to use wrap() to be wrapped in a background view")
    public final void g(List r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "items");
        Intrinsics.checkNotNullParameter(r111, "listener");
        removeAllViews();
        if (Intrinsics.areEqual(this.f317226d, r110) == true) goto L6;
        ((ArrayList) this.f317226d).clear();
        ((ArrayList) this.f317226d).addAll(r110);
    L6:
        if (Intrinsics.areEqual(this.f317227e, r111) == true) goto L8;
        this.f317227e = r111;
    L8:
        int r100 = r110.size();
        Iterator r112 = r110.iterator();
        int r101 = 0;
        int r102 = 0;
    L10:
        if (r112.hasNext() == false) goto L53;
        Object r103 = r112.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ot8.a r105 = (ot8.a) r103;
        ot8.b r106 = (ot8.b) ((LinkedHashMap) this.f317225c).get(Reflection.getOrCreateKotlinClass(r105.getClass()));
        if (r106 == null) goto L52;
        View r107 = r106.a(this, r102, r100, r105);
        r106.b(this, r105, r107, r111);
        if (r107 == null) goto L52;
        int r108 = r105.getId();
        if (r108 == 0) goto L21;
        r107.setId(r108);
    L21:
        AttributeSet r109 = null;
        if (r105.a() == false) goto L39;
        int r113 = getChildCount();
        if (r113 <= 0) goto L39;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L28
        Object r115 = Result.m9449constructorimpl(getChildAt(r113 - 1));     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r115) == false) goto L33;
        r115 = null;
    L33:
        View r116 = (View) r115;
        if (r116 == null) goto L39;
        if ((r116 instanceof Divider) == false) goto L39;
        removeView(r116);
    L28:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L39:
        addView(r107);
        if (r105.a() == true) goto L52;
        if (r102 == (r100 - 1)) goto L52;
        Drawable r118 = this.f317228f;
        if (r118 != null) goto L46;
        r118 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_common_menu_divider, getContext(), R.drawable.larus_common_menu_divider));
    L46:
        if (r118 == null) goto L52;
        int r119 = r118.getIntrinsicHeight();
        View r120 = new Divider(getContext(), r109, 6, r101);
        r120.setBackground(r118);
        LinearLayoutCompat.LayoutParams r121 = new LinearLayoutCompat.LayoutParams(-1, r119);
        int r122 = this.f317231i;
        if (r122 <= 0) goto L51;
        r121.setMargins(r122, 0, r122, 0);
    L51:
        addView(r120, r121);
    L52:
        r102 = r104;
        goto L10
    }

    public final void h(KClass r100, ot8.b r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f317225c.put(r100, r101);
        if ((!this.f317226d.isEmpty()) == false) goto L6;
        g(this.f317226d, this.f317227e);
        return;
    }

    public CommonMenu(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f317224b = "CommonMenu";
        this.f317225c = new LinkedHashMap();
        this.f317226d = new ArrayList();
        this.f317227e = new f();
        this.f317230h = i5.Q();
        f(r100, r101);
    }

    public static View j(CommonMenu r100, Integer r101, Integer r102, Integer r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        FrameLayout r105 = new FrameLayout(r100.getContext());
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L25
        r105.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));     // Catch: Throwable -> L25
        r105.addView(r100);     // Catch: Throwable -> L25
        r105.setBackgroundResource(R.drawable.larus_bg_common_menu);     // Catch: Throwable -> L25
        if (r101 == null) goto L15;
        int r107 = r101.intValue();     // Catch: Throwable -> L25
    L16:
        int r108 = r100.f317230h;     // Catch: Throwable -> L25
        if (r102 == null) goto L19;
        int r109 = r102.intValue();     // Catch: Throwable -> L25
    L20:
        if (r103 == null) goto L22;
        int r110 = r103.intValue();     // Catch: Throwable -> L25
    L23:
        r105.setPadding(r107, r108, r109, r110);     // Catch: Throwable -> L25
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L30;
        FLogger.f375446a.i(r100.f317224b, r112.toString());
    L30:
        return r105;
    L22:
        r110 = r100.f317230h;     // Catch: Throwable -> L25
        goto L23
    L19:
        r109 = r108;
        goto L20
    L15:
        r107 = r100.f317230h;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}

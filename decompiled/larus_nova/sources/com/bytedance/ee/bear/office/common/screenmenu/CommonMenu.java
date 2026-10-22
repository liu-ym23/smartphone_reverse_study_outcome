package com.bytedance.ee.bear.office.common.screenmenu;

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
import com.bytedance.ee.bear.office.common.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0000J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\nJ\u001e\u0010$\u001a\u00020\u00002\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010&\u001a\u00020\u0010J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u000fJ(\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020\u001bJ\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dJ\b\u00104\u001a\u00020\u0015H\u0002J\b\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\u0013\u00107\u001a\u0004\u0018\u00010\u001b2\u0006\u00108\u001a\u00020\nH\u0086\u0002R\"\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", "Lcom/bytedance/ee/bear/office/common/screenmenu/widget/MaxWidthLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuHandler", "", "Lkotlin/reflect/KClass;", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItem;", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItemHandler;", "menuItems", "", "itemClickListener", "Lkotlin/Function1;", "", "divideItemDrawable", "Landroid/graphics/drawable/Drawable;", "wrapperPadding", "dividerHorizontalMargin", "maskView", "Landroid/view/View;", "maskClickListener", "Lkotlin/Function0;", "init", "contentWidthFixed", "fixedWidth", "contentWidthAdaptive", "setDividerHorizontalMargin", "marginPx", "support", "kClass", "handler", "update", MapController.ITEM_LAYER_TAG, "prepare", "items", "", "listener", "setWrapperPadding", GXTemplateKey.FLEXBOX_PADDING, "wrap", "setMaskView", "visible", "", "setMaskClickListener", "updateMaskLayoutParams", "addDivider", "tryRemovePreDivider", MonitorConstants.CONNECT_TYPE_GET, "id", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMenu extends MaxWidthLinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f235152i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<? extends fk5.a>, fk5.b> f235153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<fk5.a> f235154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super fk5.a, Unit> f235155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f235156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f235157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f235158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f235159h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonMenu f235160a;

        public b(CommonMenu r100) {
            this.f235160a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f235160a.f235159h;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonMenu f235161a;

        public c(CommonMenu r100) {
            this.f235161a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CommonMenu r100 = this.f235161a;     // Catch: Throwable -> L4
            int r101 = CommonMenu.f235152i;     // Catch: Throwable -> L4
            r100.i();     // Catch: Throwable -> L4
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
    }

    public final void e() {
        setOrientation(1);
        setLayoutParams(new LinearLayoutCompat.LayoutParams(k.a(getContext(), 240), -2));
        setBackgroundResource(R.drawable.office_bg_common_menu_new);
        this.f235156e = ContextCompat.getDrawable(getContext(), R.drawable.office_common_menu_divider);
        this.f235157f = 0;
        h(Reflection.getOrCreateKotlinClass(e.class), new f());
    }

    public final View j() {
        FrameLayout r100 = new FrameLayout(getContext());
        r100.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.setElevation(k.a(r100.getContext(), 12));
        r100.setTranslationZ(k.a(r100.getContext(), 12));
        r100.addView(this);
        r100.setBackgroundResource(R.drawable.office_bg_common_menu_new);
        int r101 = this.f235157f;
        r100.setPadding(r101, r101, r101, r101);
        return r100;
    }

    public final void i() {
        Integer r100 = Integer.valueOf(getWidth());
        boolean r101 = true;
        if (r100.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        Integer r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        int r104 = r100.intValue();
    L13:
        Integer r105 = Integer.valueOf(getHeight());
        if (r105.intValue() > 0) goto L17;
        r101 = false;
    L17:
        if (r101 == false) goto L19;
        r103 = r105;
    L19:
        if (r103 == null) goto L21;
        int r106 = r103.intValue();
    L22:
        if (r104 <= 0) goto L27;
        if (r106 <= 0) goto L27;
        View r107 = this.f235158g;
        if (r107 == null) goto L29;
        r107.setLayoutParams(new FrameLayout.LayoutParams(r104, r106));
        return;
    L29:
        return;
    L27:
        post(new c(this));
        return;
    L21:
        r106 = getMeasuredHeight();
        goto L22
    L12:
        r104 = getMeasuredWidth();
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public CommonMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f235153b = new LinkedHashMap();
        this.f235154c = new ArrayList();
        this.f235155d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }

    public final void d(int r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101.width == r100) goto L6;
        r101.width = r100;
        setLayoutParams(r101);
        return;
    }

    public final void g(Function0 r100) {
        this.f235159h = r100;
        View r101 = this.f235158g;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new com.bytedance.ee.bear.office.common.screenmenu.a(this));
        return;
    }

    public final void setMaskView(boolean r100) {
        ViewParent r101 = getParent();
        if ((r101 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r100 == true) goto L10;
        View r103 = this.f235158g;
        if (r103 == null) goto L24;
        r103.setVisibility(8);
        return;
    L24:
        return;
    L10:
        if (this.f235158g != null) goto L12;
        View r104 = new View(getContext());
        r104.setBackgroundResource(R.drawable.office_fg_common_menu_mask);
        r104.setAlpha(0.5f);
        r104.setClickable(true);
        r104.setOnClickListener(new b(this));
        r102.addView(r104);
        this.f235158g = r104;
    L12:
        i();
        View r105 = this.f235158g;
        if (r105 == null) goto L15;
        r105.bringToFront();
    L15:
        View r106 = this.f235158g;
        if (r106 == null) goto L22;
        r106.setVisibility(0);
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void update(fk5.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        View r101 = findViewById(r100.getId());
        if (r101 != null) goto L5;
        return;
    L5:
        fk5.b r102 = this.f235153b.get(Reflection.getOrCreateKotlinClass(r100.getClass()));
        if (r102 != null) goto L8;
        return;
    L8:
        r102.update(r100, r101);
        r102.a(this, r100, r101, this.f235155d);
    }

    public CommonMenu(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f235153b = new LinkedHashMap();
        this.f235154c = new ArrayList();
        this.f235155d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }

    public final void f(List r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "items");
        Intrinsics.checkNotNullParameter(r111, "listener");
        removeAllViews();
        ((ArrayList) this.f235154c).clear();
        List r100 = r110;
        ((ArrayList) this.f235154c).addAll(r100);
        this.f235155d = r111;
        int r101 = r100.size();
        Iterator r112 = r110.iterator();
        int r102 = 0;
    L4:
        if (r112.hasNext() == false) goto L40;
        Object r103 = r112.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        fk5.a r105 = (fk5.a) r103;
        fk5.b r106 = (fk5.b) ((LinkedHashMap) this.f235153b).get(Reflection.getOrCreateKotlinClass(r105.getClass()));
        if (r106 == null) goto L39;
        View r107 = r106.b(this, r102, r101, r105);
        r106.a(this, r105, r107, r111);
        if (r107 == null) goto L39;
        if (r105.getId() == 0) goto L17;
        r107.setId(r105.getId());
    L17:
        if (r105.a() == true) goto L41;
    L31:
        addView(r107);
        if (r105.a() == true) goto L39;
        if (r102 == (r101 - 1)) goto L39;
        Drawable r108 = this.f235156e;
        if (r108 == null) goto L39;
        Divider r109 = new Divider(getContext(), null, 6, 0);
        r109.setBackground(r108);
        addView(r109, new LinearLayoutCompat.LayoutParams(-1, r108.getIntrinsicHeight()));
        goto L39
    L41:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L20
        Object r114 = Result.m9449constructorimpl(getChildAt(getChildCount() - 1));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r114) == false) goto L25;
        r114 = null;
    L25:
        View r115 = (View) r114;
        if (r115 == null) goto L31;
        if ((r115 instanceof Divider) == false) goto L31;
        removeView(r115);
    L20:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L39:
        r102 = r104;
        goto L4
    }

    public final void h(KClass r100, fk5.b r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f235153b.put(r100, r101);
        if ((!this.f235154c.isEmpty()) == false) goto L6;
        f(this.f235154c, this.f235155d);
        return;
    }

    public CommonMenu(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f235153b = new LinkedHashMap();
        this.f235154c = new ArrayList();
        this.f235155d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }
}

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
import com.bytedance.ee.bear.office.common.screenmenu.widget.MaxWidthLinearLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0000J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\nJ\u001e\u0010$\u001a\u00020\u00002\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010&\u001a\u00020\u0010J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u000fJ(\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020\u001bJ\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dJ\b\u00104\u001a\u00020\u0015H\u0002J\b\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\u0013\u00107\u001a\u0004\u0018\u00010\u001b2\u0006\u00108\u001a\u00020\nH\u0086\u0002R\"\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/office/common/screenmenu/CommonMenu;", "Lcom/bytedance/ee/bear/office/common/screenmenu/widget/MaxWidthLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuHandler", "", "Lkotlin/reflect/KClass;", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItem;", "Lcom/bytedance/ee/bear/office/common/screenmenu/abs/IMenuItemHandler;", "menuItems", "", "itemClickListener", "Lkotlin/Function1;", "", "divideItemDrawable", "Landroid/graphics/drawable/Drawable;", "wrapperPadding", "dividerHorizontalMargin", "maskView", "Landroid/view/View;", "maskClickListener", "Lkotlin/Function0;", "init", "contentWidthFixed", "fixedWidth", "contentWidthAdaptive", "setDividerHorizontalMargin", "marginPx", "support", "kClass", "handler", "update", "item", "prepare", "items", "", "listener", "setWrapperPadding", "padding", "wrap", "setMaskView", "visible", "", "setMaskClickListener", "updateMaskLayoutParams", "addDivider", "tryRemovePreDivider", "get", ResourceData.KEY_ID, "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMenu extends MaxWidthLinearLayout {
    public static final /* synthetic */ int i = 0;
    public final Map<KClass<? extends fk5.a>, fk5.b> b;
    public final List<fk5.a> c;
    public Function1<? super fk5.a, Unit> d;
    public Drawable e;
    public int f;
    public View g;
    public Function0<Unit> h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CommonMenu a;

        public b(CommonMenu r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.h;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CommonMenu a;

        public c(CommonMenu r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CommonMenu r0 = this.a;     // Catch: Throwable -> L4
            int r1 = CommonMenu.i;     // Catch: Throwable -> L4
            r0.i();     // Catch: Throwable -> L4
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        setOrientation(1);
        setLayoutParams(new LinearLayoutCompat.LayoutParams(k.a(getContext(), 240), -2));
        setBackgroundResource(2131244661);
        this.e = ContextCompat.getDrawable(getContext(), 2131244664);
        this.f = 0;
        h(Reflection.getOrCreateKotlinClass(e.class), new f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View j() {
        FrameLayout r0 = new FrameLayout(getContext());
        r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setElevation(k.a(r0.getContext(), 12));
        r0.setTranslationZ(k.a(r0.getContext(), 12));
        r0.addView(this);
        r0.setBackgroundResource(2131244661);
        int r1 = this.f;
        r0.setPadding(r1, r1, r1, r1);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        Integer r0 = Integer.valueOf(getWidth());
        boolean r2 = true;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r3 = r0.intValue();
    L13:
        Integer r5 = Integer.valueOf(getHeight());
        if (r5.intValue() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        r4 = r5;
    L19:
        if (r4 == null) goto L21;
        int r6 = r4.intValue();
    L22:
        if (r3 <= 0) goto L27;
        if (r6 <= 0) goto L27;
        View r7 = this.g;
        if (r7 == null) goto L29;
        r7.setLayoutParams(new FrameLayout.LayoutParams(r3, r6));
        return;
    L29:
        return;
    L27:
        post(new c(this));
        return;
    L21:
        r6 = getMeasuredHeight();
        goto L22
    L12:
        r3 = getMeasuredWidth();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public CommonMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r3) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0.width == r3) goto L6;
        r0.width = r3;
        setLayoutParams(r0);
        return;
    }

    public final void g(Function0 r2) {
        this.h = r2;
        View r3 = this.g;
        if (r3 == null) goto L6;
        r3.setOnClickListener(new com.bytedance.ee.bear.office.common.screenmenu.a(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaskView(boolean r3) {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r3 == true) goto L10;
        View r4 = this.g;
        if (r4 == null) goto L24;
        r4.setVisibility(8);
        return;
    L24:
        return;
    L10:
        if (this.g != null) goto L12;
        View r5 = new View(getContext());
        r5.setBackgroundResource(2131244670);
        r5.setAlpha(0.5f);
        r5.setClickable(true);
        r5.setOnClickListener(new b(this));
        r1.addView(r5);
        this.g = r5;
    L12:
        i();
        View r6 = this.g;
        if (r6 == null) goto L15;
        r6.bringToFront();
    L15:
        View r7 = this.g;
        if (r7 == null) goto L22;
        r7.setVisibility(0);
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(fk5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        View r0 = findViewById(r4.getId());
        if (r0 != null) goto L5;
        return;
    L5:
        fk5.b r1 = this.b.get(Reflection.getOrCreateKotlinClass(r4.getClass()));
        if (r1 != null) goto L8;
        return;
    L8:
        r1.update(r4, r0);
        r1.a(this, r4, r0, this.d);
    }

    public CommonMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(List r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r12, "listener");
        removeAllViews();
        ((ArrayList) this.c).clear();
        List r1 = r11;
        ((ArrayList) this.c).addAll(r1);
        this.d = r12;
        int r0 = r1.size();
        Iterator r13 = r11.iterator();
        int r2 = 0;
    L4:
        if (r13.hasNext() == false) goto L40;
        Object r3 = r13.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        fk5.a r5 = (fk5.a) r3;
        fk5.b r6 = (fk5.b) ((LinkedHashMap) this.b).get(Reflection.getOrCreateKotlinClass(r5.getClass()));
        if (r6 == null) goto L39;
        View r7 = r6.b(this, r2, r0, r5);
        r6.a(this, r5, r7, r12);
        if (r7 == null) goto L39;
        if (r5.getId() == 0) goto L17;
        r7.setId(r5.getId());
    L17:
        if (r5.a() == true) goto L41;
    L31:
        addView(r7);
        if (r5.a() == true) goto L39;
        if (r2 == (r0 - 1)) goto L39;
        Drawable r8 = this.e;
        if (r8 == null) goto L39;
        Divider r9 = new Divider(getContext(), null, 6, 0);
        r9.setBackground(r8);
        addView(r9, new LinearLayoutCompat.LayoutParams(-1, r8.getIntrinsicHeight()));
        goto L39
    L41:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        Object r14 = Result.constructor-impl(getChildAt(getChildCount() - 1));     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r14) == false) goto L25;
        r14 = null;
    L25:
        View r15 = (View) r14;
        if (r15 == null) goto L31;
        if ((r15 instanceof Divider) == false) goto L31;
        removeView(r15);
    L20:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        r2 = r4;
        goto L4
    }

    public final void h(KClass r2, fk5.b r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.b.put(r2, r3);
        if ((!this.c.isEmpty()) == false) goto L6;
        f(this.c, this.d);
        return;
    }

    public CommonMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = CommonMenu$itemClickListener$1.INSTANCE;
        e();
    }
}

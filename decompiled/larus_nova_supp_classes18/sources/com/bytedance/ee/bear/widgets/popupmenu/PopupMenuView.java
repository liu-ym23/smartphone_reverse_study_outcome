package com.bytedance.ee.bear.widgets.popupmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0018J\u0014\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rootView", "Landroid/widget/LinearLayout;", "rvMenuContainer", "Landroidx/recyclerview/widget/RecyclerView;", "backGrayView", "Landroid/view/View;", "menuAdapter", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuAdapter;", "animatorSet", "Landroid/animation/AnimatorSet;", "menuItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuItem;", "onMenuItemClickListener", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView$OnMenuItemClickListener;", "onMenuProxy", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView$OnMenuProxy;", "isShow", "", "isAnimatorStart", "setOnMenuItemClickListener", "", "listener", "setOnMenuProxy", "proxy", "setMenus", "menus", "", "switchMenu", "show", "hide", "initViews", "addGrayBackView", "initAdapter", "Companion", "OnMenuItemClickListener", "OnMenuProxy", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuView extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public LinearLayout a;
    public RecyclerView b;
    public View c;
    public PopupMenuAdapter d;
    public AnimatorSet e;
    public final ArrayList<kp5.a> f;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    public final void setOnMenuItemClickListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setOnMenuProxy(c r2) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
    }

    public static final void a(PopupMenuView r9) {
        if (r9.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        View r1 = r9.c;
        LinearLayout r3 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r1 = null;
    L11:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f});
        LinearLayout r5 = r9.a;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r5 = null;
    L14:
        float r6 = -r5.getHeight();
        LinearLayout r8 = r9.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L18:
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "translationY", new float[]{0.0f, r6});
        AnimatorSet r7 = new AnimatorSet();
        r9.e = r7;
        Intrinsics.checkNotNull(r7);
        r7.playTogether(new Animator[]{r2, r4});
        AnimatorSet r10 = r9.e;
        Intrinsics.checkNotNull(r10);
        r10.setDuration(200);
        AnimatorSet r11 = r9.e;
        Intrinsics.checkNotNull(r11);
        r11.addListener(new com.bytedance.ee.bear.widgets.popupmenu.b(r9));
        AnimatorSet r12 = r9.e;
        Intrinsics.checkNotNull(r12);
        r12.start();
        return;
    L17:
        r3 = r8;
        goto L18
    L20:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setMenus(List<kp5.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "menus");
        this.f.clear();
        this.f.addAll(r2);
        RecyclerView.Adapter r3 = this.d;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        r3 = null;
    L5:
        r3.notifyDataSetChanged();
    }

    public PopupMenuView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ArrayList<kp5.a> r8 = new ArrayList();
        this.f = r8;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r9 = new View(getContext());
        this.c = r9;
        r9.setId(2131393193);
        View r10 = this.c;
        PopupMenuAdapter r1 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r10 = null;
    L5:
        r10.setBackgroundResource(2131109414);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -2);
        View r0 = this.c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r0 = null;
    L8:
        addView(r0, r11);
        LayoutInflater.from(getContext()).inflate(2131568226, this);
        this.a = (LinearLayout) findViewById(2131393200);
        RecyclerView r12 = findViewById(2131393199);
        this.b = r12;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rvMenuContainer");
        r12 = null;
    L11:
        r12.setLayoutManager(new GridLayoutManager(getContext(), 3));
        setOnClickListener(new kp5.b(this));
        this.d = new PopupMenuAdapter(r8);
        RecyclerView r13 = this.b;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rvMenuContainer");
        r13 = null;
    L14:
        RecyclerView.Adapter r14 = this.d;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        r14 = null;
    L17:
        r13.setAdapter(r14);
        PopupMenuAdapter r15 = this.d;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
    L21:
        r1.setOnItemClickListener(new com.bytedance.ee.bear.widgets.popupmenu.a(this));
        return;
    L20:
        r1 = r15;
        goto L21
    }
}

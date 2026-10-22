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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0018J\u0014\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rootView", "Landroid/widget/LinearLayout;", "rvMenuContainer", "Landroidx/recyclerview/widget/RecyclerView;", "backGrayView", "Landroid/view/View;", "menuAdapter", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuAdapter;", "animatorSet", "Landroid/animation/AnimatorSet;", "menuItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuItem;", "onMenuItemClickListener", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView$OnMenuItemClickListener;", "onMenuProxy", "Lcom/bytedance/ee/bear/widgets/popupmenu/PopupMenuView$OnMenuProxy;", "isShow", "", "isAnimatorStart", "setOnMenuItemClickListener", "", "listener", "setOnMenuProxy", "proxy", "setMenus", "menus", "", "switchMenu", "show", "hide", "initViews", "addGrayBackView", "initAdapter", "Companion", "OnMenuItemClickListener", "OnMenuProxy", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuView extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f240309g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f240310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f240311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f240312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PopupMenuAdapter f240313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f240314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<kp5.a> f240315f;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    public final void setOnMenuItemClickListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setOnMenuProxy(c r100) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
    }

    public static final void a(PopupMenuView r100) {
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        View r102 = r100.f240312c;
        LinearLayout r103 = null;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r102 = null;
    L11:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{1.0f, 0.0f});
        LinearLayout r105 = r100.f240310a;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r105 = null;
    L14:
        float r106 = -r105.getHeight();
        LinearLayout r107 = r100.f240310a;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L18:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r106});
        AnimatorSet r109 = new AnimatorSet();
        r100.f240314e = r109;
        Intrinsics.checkNotNull(r109);
        r109.playTogether(new Animator[]{r104, r108});
        AnimatorSet r110 = r100.f240314e;
        Intrinsics.checkNotNull(r110);
        r110.setDuration(200);
        AnimatorSet r111 = r100.f240314e;
        Intrinsics.checkNotNull(r111);
        r111.addListener(new com.bytedance.ee.bear.widgets.popupmenu.b(r100));
        AnimatorSet r112 = r100.f240314e;
        Intrinsics.checkNotNull(r112);
        r112.start();
        return;
    L17:
        r103 = r107;
        goto L18
    L20:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setMenus(List<kp5.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "menus");
        this.f240315f.clear();
        this.f240315f.addAll(r100);
        PopupMenuAdapter r101 = this.f240313d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        r101 = null;
    L5:
        r101.notifyDataSetChanged();
    }

    public PopupMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ArrayList<kp5.a> r102 = new ArrayList();
        this.f240315f = r102;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r103 = new View(getContext());
        this.f240312c = r103;
        r103.setId(R.id.widget_gray_layer);
        View r104 = this.f240312c;
        PopupMenuAdapter r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r104 = null;
    L5:
        r104.setBackgroundResource(R.color.widget_color_transparent_30_percent_black);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -2);
        View r107 = this.f240312c;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backGrayView");
        r107 = null;
    L8:
        addView(r107, r106);
        LayoutInflater.from(getContext()).inflate(R.layout.widget_popup_menu_layout, this);
        this.f240310a = (LinearLayout) findViewById(R.id.widget_menu_root);
        RecyclerView r108 = (RecyclerView) findViewById(R.id.widget_menu_recyclerview);
        this.f240311b = r108;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rvMenuContainer");
        r108 = null;
    L11:
        r108.setLayoutManager(new GridLayoutManager(getContext(), 3));
        setOnClickListener(new kp5.b(this));
        this.f240313d = new PopupMenuAdapter(r102);
        RecyclerView r109 = this.f240311b;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rvMenuContainer");
        r109 = null;
    L14:
        PopupMenuAdapter r110 = this.f240313d;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
        r110 = null;
    L17:
        r109.setAdapter(r110);
        PopupMenuAdapter r111 = this.f240313d;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuAdapter");
    L21:
        r105.setOnItemClickListener(new com.bytedance.ee.bear.widgets.popupmenu.a(this));
        return;
    L20:
        r105 = r111;
        goto L21
    }
}

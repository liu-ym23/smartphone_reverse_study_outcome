package com.larus.bmhome.view.actionbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.view.f2;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionBarBinding;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rs8.g;
import rs8.h;
import rs8.p;
import rs8.q;
import rs8.r;
import rs8.x;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010&J7\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010+H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0016\u00107\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0014J\b\u00108\u001a\u00020\u001eH\u0014J,\u00109\u001a\u00020(2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006="}, d2 = {"Lcom/larus/bmhome/view/actionbar/NonPriorityMessageActionBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/actionbar/IMessageActionBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionBarBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionBarBinding;", "binding$delegate", "Lkotlin/Lazy;", "startActionContainer", "Landroid/widget/LinearLayout;", "getStartActionContainer", "()Landroid/widget/LinearLayout;", "startActionContainer$delegate", "endActionContainer", "getEndActionContainer", "endActionContainer$delegate", "oldStartActions", "", "Lcom/larus/bmhome/view/actionbar/IAction;", "oldEndActions", "compactActions", "", "getCompactActions", "()Z", "setCompactActions", "(Z)V", "update", "action", "useSubscribedColor", "(Lcom/larus/bmhome/view/actionbar/IAction;Ljava/lang/Boolean;)Z", "refresh", "", "addReplaceRegen", SlcCommonAction.KEY_ACTIONS, "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "(ZLjava/util/List;Ljava/lang/Boolean;Landroidx/fragment/app/Fragment;)V", "setUpPriorityList", "priorityList", "", "parentView", "Landroid/view/ViewParent;", "getViewGlobalVisibleRect", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "shouldUseCompactActions", "shouldSetActionTag", "onActionsRefreshed", "newStartActions", "newEndActions", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NonPriorityMessageActionBar extends ConstraintLayout implements h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f315639g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f315640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f315641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f315642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f315643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f315644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f315645f;

    public static final class a {
    }

    static {
    }

    public NonPriorityMessageActionBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NonPriorityMessageActionBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void T5(List<? extends g> r100, List<? extends g> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "newStartActions");
        Intrinsics.checkNotNullParameter(r101, "newEndActions");
    }

    public boolean U5(List<? extends g> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        return false;
    }

    @Override // rs8.h
    public void setUpPriorityList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "priorityList");
    }

    public Integer y3() {
        return null;
    }

    private final LarusLayoutTextMessageActionBarBinding getBinding() {
        return (LarusLayoutTextMessageActionBarBinding) this.f315640a.getValue();
    }

    public final LinearLayout getEndActionContainer() {
        return (LinearLayout) this.f315642c.getValue();
    }

    public final LinearLayout getStartActionContainer() {
        return (LinearLayout) this.f315641b.getValue();
    }

    @Override // rs8.h
    public final ViewParent f5() {
        return getParent();
    }

    public final boolean getCompactActions() {
        return this.f315645f;
    }

    public static LinearLayout R5(NonPriorityMessageActionBar r100) {
        return r100.getBinding().f324041d;
    }

    public static LinearLayout S5(NonPriorityMessageActionBar r100) {
        return r100.getBinding().f324040c;
    }

    @Override // rs8.h
    public final boolean b0(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        return getGlobalVisibleRect(r100);
    }

    public final void setCompactActions(boolean r100) {
        this.f315645f = r100;
    }

    @Override // rs8.h
    public boolean update(g r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        View r102 = findViewById(r100.getId());
        f2 r103 = null;
        if ((r102 instanceof LinearLayout) == false) goto L5;
        LinearLayout r104 = (LinearLayout) r102;
    L6:
        boolean r105 = false;
        if (r104 != null) goto L10;
        return false;
    L10:
        if ((r104 instanceof f2) == false) goto L12;
        r103 = (f2) r104;
    L12:
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r101 == null) goto L16;
        r105 = r101.booleanValue();
    L16:
        r103.a(r100, r105, this.f315645f);
        return true;
    L5:
        r104 = null;
        goto L6
    }

    public NonPriorityMessageActionBar(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315640a = LazyKt.lazy(new p(r100, this));
        this.f315641b = LazyKt.lazy(new q(this));
        this.f315642c = LazyKt.lazy(new r(this));
        this.f315643d = new ArrayList();
        this.f315644e = new ArrayList();
    }

    public /* synthetic */ NonPriorityMessageActionBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // rs8.h
    public final void q5(boolean r110, List<? extends g> r111, Boolean r112, Fragment r113) {
        Intrinsics.checkNotNullParameter(r111, SlcCommonAction.KEY_ACTIONS);
        ArrayList r114 = new ArrayList();
        ArrayList r115 = new ArrayList();
        Iterator<T> r100 = r111.iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L11;
        Object r102 = r100.next();
        if (((g) r102).b() != MessageActionBarAlign.START) goto L8;
        r101 = true;
    L8:
        if (r101 == true) goto L9;
        r115.add(r102);
        goto L3
    L9:
        r114.add(r102);
        goto L3
    L11:
        Pair r103 = new Pair(r114, r115);
        List<? extends g> r116 = (List) r103.component1();
        List<? extends g> r117 = (List) r103.component2();
        this.f315645f = U5(r111);
        boolean r118 = this instanceof AdaptiveMessageActionBar;
        Context r104 = getContext();
        List<g> r105 = this.f315643d;
        LinearLayout r106 = getStartActionContainer();
        if (r112 == null) goto L14;
        boolean r107 = r112.booleanValue();
    L15:
        x.a(r118, r104, r116, r105, r106, r107, this.f315645f);
        Context r108 = getContext();
        List<g> r109 = this.f315644e;
        LinearLayout r119 = getEndActionContainer();
        if (r112 == null) goto L18;
        boolean r120 = r112.booleanValue();
    L19:
        x.a(r118, r108, r117, r109, r119, r120, this.f315645f);
        ((ArrayList) this.f315643d).clear();
        ArrayList r121 = (ArrayList) this.f315643d;
        r121.addAll(r116);
        ((ArrayList) this.f315644e).clear();
        ArrayList r122 = (ArrayList) this.f315644e;
        r122.addAll(r117);
        T5(r116, r117, this.f315645f);
        return;
    L18:
        r120 = false;
        goto L19
    L14:
        r107 = false;
        goto L15
    }
}

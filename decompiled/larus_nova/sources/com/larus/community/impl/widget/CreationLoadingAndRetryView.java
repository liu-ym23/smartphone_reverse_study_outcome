package com.larus.community.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationLoadingAndRetryLayoutBinding;
import com.larus.community.impl.loading.CreationTemplateLoadingAdapter;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r29.k;
import t29.a;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/community/impl/widget/CreationLoadingAndRetryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationLoadingAndRetryLayoutBinding;", "onRetryClickListener", "Lkotlin/Function0;", "", "emptyViewCreator", "Landroid/view/View;", "emptyView", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setOnRetryClickListener", "bindItemDecoration", "updateSpanCount", "spanCount", "", "trySetEmptyView", "view", "setEmptyCreator", "updateStatus", "state", "Lcom/larus/community/impl/view/PageState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingAndRetryView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f330137f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationLoadingAndRetryLayoutBinding f330138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f330139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<? extends View> f330140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f330141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView.ItemDecoration f330142e;

    public CreationLoadingAndRetryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void R5(k r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (Intrinsics.areEqual(r100, k.d.f535815a) == false) goto L8;
        e1.x(this.f330138a.f329092b);
        e1.o(this.f330138a.f329093c);
        View r101 = this.f330141d;
        if (r101 == null) goto L40;
        e1.o(r101);
        return;
    L40:
        return;
    L8:
        if (Intrinsics.areEqual(r100, k.b.f535813a) == false) goto L13;
        e1.o(this.f330138a.f329092b);
        e1.x(this.f330138a.f329093c);
        View r102 = this.f330141d;
        if (r102 == null) goto L42;
        e1.o(r102);
        return;
    L42:
        return;
    L13:
        if (Intrinsics.areEqual(r100, k.e.f535816a) == false) goto L16;
        e1.o(this.f330138a.f329092b);
        e1.o(this.f330138a.f329093c);
        return;
    L16:
        if (Intrinsics.areEqual(r100, k.a.f535812a) == false) goto L35;
        e1.o(this.f330138a.f329092b);
        e1.o(this.f330138a.f329093c);
        if (this.f330141d != null) goto L32;
        Function0<? extends View> r103 = this.f330140c;
        if (r103 == null) goto L32;
        View r104 = r103.invoke();
        if (r104 == null) goto L32;
        if (this.f330141d != null) goto L32;
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L28;
        ViewGroup r106 = (ViewGroup) r105;
    L29:
        if (r106 == null) goto L31;
        r106.removeView(r104);
    L31:
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-1, -2);
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.topToTop = 0;
        Unit r108 = Unit.INSTANCE;
        addView(r104, r107);
        this.f330141d = r104;
        e1.o(r104);
        goto L32
    L28:
        r106 = null;
    L32:
        View r109 = this.f330141d;
        if (r109 == null) goto L45;
        e1.x(r109);
        return;
    L45:
        return;
    L35:
        View r110 = this.f330141d;
        if (r110 == null) goto L38;
        e1.o(r110);
    L38:
        e1.o(this.f330138a.f329092b);
        e1.o(this.f330138a.f329093c);
    }

    public final void setEmptyCreator(Function0<? extends View> r100) {
        this.f330140c = r100;
    }

    public final void setOnRetryClickListener(Function0<Unit> r100) {
        this.f330139b = r100;
    }

    public CreationLoadingAndRetryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_creation_loading_and_retry_layout, this);
        int r102 = R.id.loading_view;
        UnresponsiveRecyclerView r103 = (UnresponsiveRecyclerView) ViewBindings.findChildViewById(this, R.id.loading_view);
        if (r103 == null) goto L15;
        r102 = R.id.refresh_text;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.refresh_text)) == null) goto L15;
        r102 = R.id.retry_view;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.retry_view);
        if (r104 == null) goto L15;
        this.f330138a = new LarusCommunityCreationLoadingAndRetryLayoutBinding(this, r103, r104);
        if (c7.d(Integer.valueOf(i.d(r100))) <= 500.0f) goto L11;
        int r105 = 3;
    L12:
        r103.setLayoutManager(new StaggeredGridLayoutManager(r105, 1));
        r103.setAdapter(new CreationTemplateLoadingAdapter());
        e1.d(r104, new a(this));
        return;
    L11:
        r105 = 2;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}

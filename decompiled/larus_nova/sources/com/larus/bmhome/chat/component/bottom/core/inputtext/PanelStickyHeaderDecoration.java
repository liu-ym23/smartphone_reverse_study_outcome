package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/PanelStickyHeaderDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "headerTitleAt", "Lkotlin/Function1;", "", "", "createHeaderView", "Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "headerView", "boundTitle", "", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "findHeaderPosition", "firstVisiblePosition", "(I)Ljava/lang/Integer;", "findNextHeaderTop", "currentHeaderPosition", "(Landroidx/recyclerview/widget/RecyclerView;I)Ljava/lang/Integer;", "layoutHeader", "header", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelStickyHeaderDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, CharSequence> f298667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ViewGroup, TextView> f298668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f298669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f298670d;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelStickyHeaderDecoration(Function1<? super Integer, ? extends CharSequence> r100, Function1<? super ViewGroup, ? extends TextView> r101) {
        Intrinsics.checkNotNullParameter(r100, "headerTitleAt");
        Intrinsics.checkNotNullParameter(r101, "createHeaderView");
        this.f298667a = r100;
        this.f298668b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        if (r112.isPreLayout() == false) goto L5;
        return;
    L5:
        if (r111.getChildCount() == 0) goto L71;
        RecyclerView.LayoutManager r113 = r111.getLayoutManager();
        Integer r100 = null;
        if ((r113 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r114 = (LinearLayoutManager) r113;
    L11:
        if (r114 != null) goto L13;
        return;
    L13:
        int r101 = r114.findFirstVisibleItemPosition();
        if (r101 != (-1)) goto L16;
        return;
    L16:
        if ((-1) >= r101) goto L21;
        if (this.f298667a.invoke(Integer.valueOf(r101)) != null) goto L19;
        r101 = r101 - 1;
        goto L16
    L19:
        Integer r102 = Integer.valueOf(r101);
    L22:
        if (r102 == null) goto L69;
        int r103 = r102.intValue();
        View r115 = r114.findViewByPosition(r103);
        if (r115 != null) goto L26;
    L28:
        CharSequence r116 = this.f298667a.invoke(Integer.valueOf(r103));
        if (r116 == null) goto L70;
        String r117 = r116.toString();
        if (r117 == null) goto L72;
        TextView r104 = this.f298669c;
        if (r104 != null) goto L37;
        r104 = this.f298668b.invoke(r111);
        r104.setBackgroundColor(v19.c.a(R.attr.larus_base_3, r111.getContext(), R.color.larus_base_3));
        this.f298669c = r104;
        nda.d.a().wa(r104);
    L37:
        if (Intrinsics.areEqual(this.f298670d, r117) == true) goto L39;
        r104.setText(r117);
        this.f298670d = r117;
    L39:
        int r118 = (r111.getWidth() - r111.getPaddingLeft()) - r111.getPaddingRight();
        int r105 = 0;
        if (r104.isLayoutRequested() == false) goto L42;
    L44:
        r104.measure(View.MeasureSpec.makeMeasureSpec(r118, 1073741824), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(r111.getHeight(), 1073741824), r111.getPaddingTop() + r111.getPaddingBottom(), r104.getLayoutParams().height));
        r104.layout(0, 0, r104.getMeasuredWidth(), r104.getMeasuredHeight());
    L45:
        int r119 = r111.getChildCount();
        int r106 = 0;
    L46:
        if (r106 >= r119) goto L57;
        View r107 = r111.getChildAt(r106);
        int r108 = r111.getChildAdapterPosition(r107);
        if (r108 == (-1)) goto L56;
        if (r108 <= r103) goto L56;
        if (this.f298667a.invoke(Integer.valueOf(r108)) == null) goto L56;
        if (r100 == null) goto L54;
        int r109 = r100.intValue();
    L55:
        r100 = Integer.valueOf(Math.min(r109, r107.getTop()));
        goto L56
    L54:
        r109 = r107.getTop();
    L56:
        r106 = r106 + 1;
        goto L46
    L57:
        if (r100 == null) goto L59;
        r105 = Math.min(0, (r100.intValue() - r111.getPaddingTop()) - r104.getMeasuredHeight());
    L59:
        r110.save();
        r110.translate(r111.getPaddingLeft(), r111.getPaddingTop() + r105);
        r104.draw(r110);
        r110.restore();
        return;
    L42:
        if (r104.getWidth() != r118) goto L44;
    L72:
        return;
    L70:
        return;
    L26:
        if (r115.getTop() < r111.getPaddingTop()) goto L28;
        return;
    L69:
        return;
    L21:
        r102 = null;
        goto L22
    L10:
        r114 = null;
        goto L11
    }
}

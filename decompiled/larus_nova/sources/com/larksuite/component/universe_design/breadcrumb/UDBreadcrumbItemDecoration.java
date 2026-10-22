package com.larksuite.component.universe_design.breadcrumb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "decorationIconRes", "", "<init>", "(Landroid/content/Context;I)V", "mIconSize", "mRect", "Landroid/graphics/Rect;", "mDecorationIcon", "Landroid/graphics/drawable/Drawable;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDBreadcrumbItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f284563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f284564b;

    public UDBreadcrumbItemDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = d.d(r100, R.dimen.ud_breadcrumb_decoration_size);
        this.f284563a = r101;
        Rect r102 = new Rect(0, 0, r101, r101);
        Drawable r103 = UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_right_bold_outlined);
        r103.setBounds(r102);
        r103.setTint(UDColorUtils.getColor(r100, R.color.icon_n3));
        this.f284564b = r103;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = r101.getChildCount();
        RecyclerView.Adapter r104 = r101.getAdapter();
        if (r104 != null) goto L5;
        return;
    L5:
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L14;
        View r106 = r101.getChildAt(r105);
        int r107 = r101.getChildAdapterPosition(r106);
        if (r107 == (-1)) goto L13;
        if (r107 <= 0) goto L13;
        if (r107 >= r104.getItemCount()) goto L13;
        int r108 = (int) r106.getTranslationX();
        r100.save();
        float r109 = r106.getLeft();
        int r110 = r106.getHeight();
        float r111 = r109 + r108;
        int r112 = this.f284563a;
        r100.translate(r111 - r112, (r110 - r112) / 2.0f);
        this.f284564b.draw(r100);
        r100.restore();
    L13:
        r105 = r105 + 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 != null) goto L6;
        return;
    L6:
        if (r104 == (-1)) goto L12;
        if (r104 <= 0) goto L12;
        if (r104 >= r105.getItemCount()) goto L12;
        r100.set(this.f284563a, 0, 0, 0);
        return;
    L12:
        r100.set(0, 0, 0, 0);
    }
}

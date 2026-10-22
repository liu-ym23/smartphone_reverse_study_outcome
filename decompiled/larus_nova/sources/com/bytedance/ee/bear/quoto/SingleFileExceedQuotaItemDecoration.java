package com.bytedance.ee.bear.quoto;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/SingleFileExceedQuotaItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "screenWidth", "", "sidePaddingWidth", "itemWidth", "fixItemPaddingWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getDimension", "id", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleFileExceedQuotaItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f236330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f236331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f236332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f236333d;

    public SingleFileExceedQuotaItemDecoration() {
        int r100 = com.bytedance.ee.util.ui.n.v();
        this.f236330a = r100;
        int r101 = eu5.b.f474075a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        this.f236331b = r101;
        int r102 = eu5.b.f474075a.getResources().getDimensionPixelSize(R.dimen.space_suite_type_item_width);
        this.f236332c = r102;
        this.f236333d = ((r100 - (r101 * 2)) - (r102 * 3)) / 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getAdapter() != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r104 = r102.getAdapter();
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getItemCount();
        int r106 = r102.getChildAdapterPosition(r101);
        if (r106 != 0) goto L8;
        boolean r107 = true;
    L9:
        int r108 = r105 - 1;
        if (r106 != r108) goto L12;
        boolean r109 = true;
    L13:
        if (r105 >= 1) goto L15;
        int r110 = 0;
    L17:
        if (r105 != 3) goto L24;
        if (r107 == false) goto L20;
        int r111 = this.f236331b;
    L21:
        if (r109 == false) goto L23;
        int r112 = this.f236331b;
    L32:
        r100.set(r111, 0, r112, 0);
        return;
    L23:
        r112 = this.f236333d;
        goto L32
    L20:
        r111 = this.f236333d;
        goto L21
    L24:
        int r113 = this.f236330a;
        int r114 = this.f236333d;
        int r115 = ((r113 - (r110 * r114)) - (this.f236332c * r105)) / 2;
        if (r107 == false) goto L27;
        int r116 = r115;
    L28:
        if (r109 == false) goto L30;
        r112 = r115;
    L31:
        r111 = r116;
        goto L32
    L30:
        r112 = r114;
        goto L31
    L27:
        r116 = r114;
        goto L28
    L15:
        r110 = r108 * 2;
        goto L17
    L12:
        r109 = false;
        goto L13
    L8:
        r107 = false;
        goto L9
    }
}

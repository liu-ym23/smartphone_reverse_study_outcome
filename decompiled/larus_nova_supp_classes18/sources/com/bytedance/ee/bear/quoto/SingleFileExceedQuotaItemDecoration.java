package com.bytedance.ee.bear.quoto;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/SingleFileExceedQuotaItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "screenWidth", "", "sidePaddingWidth", "itemWidth", "fixItemPaddingWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getDimension", ResourceData.KEY_ID, "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleFileExceedQuotaItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public SingleFileExceedQuotaItemDecoration() {
        int r0 = com.bytedance.ee.util.ui.n.v();
        this.a = r0;
        int r1 = eu5.b.a.getResources().getDimensionPixelSize(2131168315);
        this.b = r1;
        int r2 = eu5.b.a.getResources().getDimensionPixelSize(2131168389);
        this.c = r2;
        this.d = ((r0 - (r1 * 2)) - (r2 * 3)) / 4;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        if (r7.getAdapter() != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r9 = r7.getAdapter();
        Intrinsics.checkNotNull(r9);
        int r10 = r9.getItemCount();
        int r11 = r7.getChildAdapterPosition(r6);
        if (r11 != 0) goto L8;
        boolean r1 = true;
    L9:
        int r2 = r10 - 1;
        if (r11 != r2) goto L12;
        boolean r12 = true;
    L13:
        if (r10 >= 1) goto L15;
        int r3 = 0;
    L17:
        if (r10 != 3) goto L24;
        if (r1 == false) goto L20;
        int r13 = this.b;
    L21:
        if (r12 == false) goto L23;
        int r14 = this.b;
    L32:
        r5.set(r13, 0, r14, 0);
        return;
    L23:
        r14 = this.d;
        goto L32
    L20:
        r13 = this.d;
        goto L21
    L24:
        int r15 = this.a;
        int r4 = this.d;
        int r16 = ((r15 - (r3 * r4)) - (this.c * r10)) / 2;
        if (r1 == false) goto L27;
        int r17 = r16;
    L28:
        if (r12 == false) goto L30;
        r14 = r16;
    L31:
        r13 = r17;
        goto L32
    L30:
        r14 = r4;
        goto L31
    L27:
        r17 = r4;
        goto L28
    L15:
        r3 = r2 * 2;
        goto L17
    L12:
        r12 = false;
        goto L13
    L8:
        r1 = false;
        goto L9
    }
}

package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;

    public CategoryItemDecoration() {
        this(0, 0, null, null, null, null, null, null, 255);
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, BaseCoreViewModel.CORE_TAG_STATE);
        Integer r7 = this.g;
        if (r7 == null) goto L5;
        int r8 = r7.intValue();
    L6:
        r3.left = r8;
        Integer r9 = this.h;
        int r0 = 0;
        if (r9 == null) goto L9;
        int r10 = r9.intValue();
    L10:
        r3.right = r10;
        Integer r11 = this.e;
        if (r11 == null) goto L13;
        int r12 = r11.intValue();
    L14:
        r3.top = r12;
        Integer r13 = this.f;
        if (r13 == null) goto L17;
        int r14 = r13.intValue();
    L18:
        r3.bottom = r14;
        RecyclerView.LayoutManager r15 = r5.getLayoutManager();
        if (r5.getChildAdapterPosition(r4) != 0) goto L30;
        Integer r1 = this.c;
        if (r1 != null) goto L26;
        Integer r2 = this.g;
        if (r2 == null) goto L25;
        r1 = Integer.valueOf(r2.intValue() * 2);
        goto L26
    L25:
        r1 = null;
    L26:
        if (r1 == null) goto L28;
        int r16 = r1.intValue();
    L29:
        r3.left = r16;
        goto L30
    L28:
        r16 = this.a * 2;
    L30:
        int r17 = r5.getChildAdapterPosition(r4);
        if (r15 == null) goto L34;
        r0 = r15.getItemCount();
    L34:
        if (r17 != (r0 - 1)) goto L47;
        Integer r18 = this.g;
        if (r18 == null) goto L38;
        int r19 = r18.intValue();
    L39:
        r3.left = r19;
        Integer r20 = this.d;
        if (r20 != null) goto L42;
        r20 = this.h;
    L42:
        if (r20 == null) goto L44;
        int r21 = r20.intValue();
    L45:
        r3.right = r21;
        return;
    L44:
        r21 = this.a;
        goto L45
    L38:
        r19 = this.a;
        goto L39
    L47:
        return;
    L17:
        r14 = this.b;
        goto L18
    L13:
        r12 = this.b;
        goto L14
    L9:
        r10 = 0;
        goto L10
    L5:
        r8 = this.a;
        goto L6
    }

    public CategoryItemDecoration(int r3, int r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L26;
        r10 = null;
    L26:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}

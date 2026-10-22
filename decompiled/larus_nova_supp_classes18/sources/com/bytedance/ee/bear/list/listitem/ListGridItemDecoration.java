package com.bytedance.ee.bear.list.listitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListGridItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public ListGridItemDecoration(Context r2) {
        this.e = false;
        this.e = c.k(r2);
        Resources r3 = r2.getResources();
        this.f = r3.getDimensionPixelSize(2131167707);
        this.g = r3.getDimensionPixelSize(2131167708);
        this.h = r3.getDimensionPixelSize(2131167710);
        this.i = r3.getDimensionPixelSize(2131167706);
    }

    public final void getItemOffsets(Rect r8, View r9, RecyclerView r10, RecyclerView.State r11) {
        super.getItemOffsets(r8, r9, r10, r11);
        if ((r10.getAdapter() instanceof BaseQuickAdapter) == false) goto L5;
        int r12 = r10.getAdapter().getHeaderLayoutCount();
        this.c = r12;
        this.a = r12;
    L5:
        int r13 = r10.getChildAdapterPosition(r9);
        if (r10.getAdapter().getItemViewType(r13) != 22) goto L8;
    L102:
        this.b = r13;
        return;
    L8:
        if (r10.getAdapter().getItemViewType(r13) == 33) goto L102;
        if (r10.getAdapter().getItemViewType(r13) != 273) goto L14;
        return;
    L14:
        if ((r10.getLayoutManager() instanceof GridLayoutManager) == false) goto L104;
        GridLayoutManager r14 = r10.getLayoutManager();
        boolean r1 = true;
        int r2 = 0;
        if (this.e == false) goto L51;
        int r15 = r14.getSpanCount();
        int r16 = r10.getAdapter().getItemCount() - this.c;
        int r0 = r16 % r15;
        if (r0 != 0) goto L20;
        int r3 = r16 - r15;
    L21:
        int r4 = this.a;
        if (((r13 - r4) % r15) != 0) goto L24;
        boolean r5 = true;
    L25:
        int r6 = (r13 + 1) - r4;
        if ((r6 % r15) != 0) goto L28;
        boolean r7 = true;
    L30:
        if (r13 >= (r15 + r4)) goto L32;
        boolean r17 = true;
    L33:
        if (r6 <= r3) goto L36;
        if (r6 > r16) goto L36;
    L37:
        if (r5 == false) goto L39;
        int r18 = this.f;
    L40:
        if (r17 == false) goto L42;
        r2 = this.h;
    L42:
        if (r7 == false) goto L44;
        int r19 = this.f;
    L45:
        if (r1 == true) goto L47;
    L49:
        int r110 = this.h;
    L50:
        r8.set(r18, r2, r19, r110);
        return;
    L47:
        if (this.d == true) goto L49;
        r110 = this.i;
        goto L50
    L44:
        r19 = this.g / 2;
        goto L45
    L39:
        r18 = this.g / 2;
    L36:
        r1 = false;
        goto L37
    L32:
        r17 = false;
        goto L33
    L28:
        r7 = false;
        goto L30
    L24:
        r5 = false;
        goto L25
    L20:
        r3 = r16 - r0;
        goto L21
    L51:
        int r111 = r14.getSpanCount();
        int r112 = r10.getAdapter().getItemCount() - this.c;
        int r20 = this.b;
        if (r20 == 0) goto L70;
        if (r13 <= r20) goto L70;
        int r21 = r13 - r20;
        if (((r21 - 1) % r111) != 0) goto L58;
        boolean r22 = true;
    L60:
        if ((r21 % r111) != 0) goto L62;
        boolean r23 = true;
    L64:
        if ((r13 - 1) >= (r20 + r111)) goto L66;
        boolean r24 = true;
    L68:
        if (((r13 + r111) - (((r112 - r20) - 1) % r111)) >= r112) goto L87;
    L86:
        r1 = false;
    L87:
        if (r22 == false) goto L89;
        int r25 = this.f;
    L90:
        if (r24 == false) goto L92;
        r2 = this.h;
    L92:
        if (r23 == false) goto L94;
        int r113 = this.f;
    L95:
        if (r1 == true) goto L97;
    L99:
        int r114 = this.h;
    L100:
        r8.set(r25, r2, r113, r114);
        return;
    L97:
        if (this.d == true) goto L99;
        r114 = this.i;
        goto L100
    L94:
        r113 = this.g / 2;
        goto L95
    L89:
        r25 = this.g / 2;
        goto L90
    L66:
        r24 = false;
        goto L68
    L62:
        r23 = false;
        goto L64
    L58:
        r22 = false;
    L70:
        int r26 = this.a;
        int r27 = r13 - r26;
        if ((r27 % r111) != 0) goto L73;
        r22 = true;
    L75:
        if ((((r13 + 1) - r26) % r111) != 0) goto L77;
        boolean r28 = true;
    L79:
        if (r13 >= (r26 + r111)) goto L81;
        boolean r29 = true;
    L83:
        if (r27 < ((r112 - r111) + (r112 % r111))) goto L85;
        r23 = r28;
        r24 = r29;
        goto L87
    L85:
        r23 = r28;
        r24 = r29;
        goto L86
    L81:
        r29 = false;
        goto L83
    L77:
        r28 = false;
        goto L79
    L73:
        r22 = false;
        goto L75
    }
}

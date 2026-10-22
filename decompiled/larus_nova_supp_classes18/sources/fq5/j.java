package fq5;

import android.app.Dialog;
import android.graphics.RectF;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements Runnable {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ String b;
    public final /* synthetic */ m c;

    public final void a() {
        Dialog r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L20;
        WikiTreeCtrlView r1 = this.c.b;
        String r2 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "uid");
        r1.getWikiTreeViewFromXml().n(r2, true);
        m r3 = this.c;
        String r4 = this.b;
        int r5 = r3.b.getMeasuredWidth();
        int r6 = r5 - r3.a.getResources().getDimensionPixelSize(2131168307);
        tt5.a.h("WikiTreeSwipeItemOnBoarding", " root view width = " + r5 + " left position = " + r6);
        int r7 = r6 - n.d(6);
        WikiTreeCtrlView r8 = r3.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r4, "uid");
        ArrayList r9 = new ArrayList(3);
        int[] r10 = {0, 0};
        RecyclerView.ViewHolder r11 = r8.getWikiTreeViewFromXml().b(r8.getWikiTreeViewFromXml().getWikiUIList().d(r4));
        if (r11 != null) goto L10;
        tt5.a.d(r8.e, "find aim view holden by wikiToken failed, holder == null");
    L14:
        if (hu5.a.d(r9) == true) goto L16;
        tt5.a.h("WikiTreeSwipeItemOnBoarding", " target item view location on Screen xPosition = " + ListProtector.get(r9, 0) + " yPosition = " + ListProtector.get(r9, 1) + " view height = " + ListProtector.get(r9, 2));
        int[] r12 = {((Integer) ListProtector.get(r9, 1)).intValue(), ((Integer) ListProtector.get(r9, 2)).intValue()};
    L17:
        int r13 = r12[0] - n.d(5);
        int r14 = (r12[1] + r12[0]) + n.d(4);
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "RectF left top right bottom " + r7 + " " + r13 + " " + r5 + " " + r14);
        RectF r15 = new RectF((float) r7, (float) r13, (float) r5, (float) r14);
        final m r16 = this.c;
        String r17 = this.b;
        Dialog r18 = this.a;
        r16.getClass();
        final k r19 = new k(r16, r18, r15, r17);
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().e().subscribe(new h(r16, r19), new i());
        return;
    L16:
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "get Recycler view target item position on screen and view height failed");
        r12 = new int[]{0, 0};
        goto L17
    L10:
        r11.itemView.getLocationOnScreen(r10);
        int r20 = r11.itemView.getMeasuredHeight();
        if (r10[1] <= 0) goto L14;
        r9.add(Integer.valueOf(r10[0]));
        r9.add(Integer.valueOf(r10[1]));
        r9.add(Integer.valueOf(r20));
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(m r1, Dialog r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}

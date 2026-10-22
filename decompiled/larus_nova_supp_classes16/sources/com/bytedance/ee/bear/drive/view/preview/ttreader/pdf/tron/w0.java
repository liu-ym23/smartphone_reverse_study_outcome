package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w0<T> implements Observer {
    public final /* synthetic */ v0 a;
    public final /* synthetic */ BubbleMenuVM b;
    public final /* synthetic */ Context c;

    public w0(v0 r1, BubbleMenuVM r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r10) {
        u55.b r11 = (u55.b) r10;
        if (AppInfoUtils.e().booleanValue() == false) goto L9;
        tt5.a.h("TTStreamingPdfView", "initCommentBubbleMenu - Mempope App, cannot comment");
        com.bytedance.ee.bear.drive.biz.bubblemenu.c r12 = this.a.j;
        if (r12 == null) goto L25;
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r13 = CollectionsKt.listOf(r12);
        if (r13 == null) goto L26;
        this.b.removeMenus(r13);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        if (r11 == null) goto L13;
        boolean r0 = true;
        if (r11.a() != true) goto L13;
    L14:
        if (r0 == true) goto L21;
        tt5.a.h("TTStreamingPdfView", "initCommentBubbleMenu - livePerm, canComment: false");
        com.bytedance.ee.bear.drive.biz.bubblemenu.c r14 = this.a.j;
        if (r14 == null) goto L28;
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r16 = CollectionsKt.listOf(r14);
        if (r16 == null) goto L29;
        this.b.removeMenus(r16);
        return;
    L29:
        return;
    L28:
        return;
    L21:
        if (this.b.hasMenu("bubble_menu_comment") == false) goto L23;
        tt5.a.h("TTStreamingPdfView", "initCommentBubbleMenu - livePerm, canComment: true, but menu has already been added.");
        return;
    L23:
        v0 r17 = this.a;
        String r4 = this.c.getString(2131887718);
        final BubbleMenuVM r2 = this.b;
        Function1<String, Boolean> r6 = new TTStreamingPdfView$initCommentBubbleMenu$1$5(r2);
        final BubbleMenuVM r3 = this.b;
        final v0 r8 = this.a;
        com.bytedance.ee.bear.drive.biz.bubblemenu.c r1 = new com.bytedance.ee.bear.drive.biz.bubblemenu.c("bubble_menu_comment", r4, 200, r6, new TTStreamingPdfView$initCommentBubbleMenu$1$6(r3, r8));
        BubbleMenuVM r5 = this.b;
        tt5.a.h("TTStreamingPdfView", "initCommentBubbleMenu - livePerm, canComment: true, add comment menu item.");
        r5.addMenus(CollectionsKt.listOf(r1));
        r17.j = r1;
        return;
    L13:
        r0 = false;
        goto L14
    }
}

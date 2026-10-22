package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.IReaderSelectionClient;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c1 implements IReaderSelectionClient {
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a a;
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a b;
    public final /* synthetic */ DrivePreviewAiResourceContextVM c;
    public final /* synthetic */ long d;
    public final /* synthetic */ BubbleMenuVM e;

    public static final class a implements Runnable {
        public final /* synthetic */ DrivePreviewAiResourceContextVM a;
        public final /* synthetic */ long b;
        public final /* synthetic */ List<TTReaderSelectionInfo> c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ BubbleMenuVM e;
        public final /* synthetic */ List<t75.g> f;
        public final /* synthetic */ String g;

        public a(DrivePreviewAiResourceContextVM r1, long r2, List<? extends TTReaderSelectionInfo> r4, Bundle r5, BubbleMenuVM r6, List<t75.g> r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final void a() {
            if (this.a.isCurrentGeneration(this.b) == true) goto L6;
            tt5.a.h("TTStreamingPdfView", "drop stale selection callback, generation=" + this.b);
            return;
        L6:
            StringBuilder r0 = new StringBuilder("onSelectionChanged, allSelectionInfos count = ");
            List<TTReaderSelectionInfo> r2 = this.c;
            if (r2 == null) goto L9;
            Integer r3 = Integer.valueOf(r2.size());
        L10:
            r0.append(r3);
            r0.append(", extra = ");
            r0.append(this.d);
            tt5.a.b("TTStreamingPdfView", r0.toString());
            this.e.updateSelectionData(new com.bytedance.ee.bear.drive.biz.bubblemenu.d(this.c, this.d));
            this.a.updateSelections(this.b, this.f);
            this.a.updateSelectionText(this.b, this.g);
            return;
        L9:
            r3 = null;
            goto L10
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
    }

    public final View getPopupMenu() {
        return null;
    }

    public final View getLeftIndicator() {
        return this.a;
    }

    public final View getRightIndicator() {
        return this.b;
    }

    public final void onSelectionChanged(List<TTReaderSelectionInfo> r22, Bundle r23) {
        if (r22 == null) goto L5;
        List r8 = CollectionsKt.toList(r22);
    L6:
        if (r23 == null) goto L8;
        Bundle r9 = new Bundle(r23);
    L9:
        int r1 = com.bytedance.ee.bear.drive.biz.ai.d.a;
        if (r8 != null) goto L12;
        List r2 = CollectionsKt.emptyList();
    L13:
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        TTReaderSelectionInfo r6 = (TTReaderSelectionInfo) r5.next();
        int r7 = r6.pageIndex;
        String r10 = r6.selectedText;
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        r4.add(new com.bytedance.ee.bear.drive.biz.ai.e(r7, r10));
        goto L15
    L20:
        Intrinsics.checkNotNullParameter(r4, "values");
        ArrayList r11 = new ArrayList();
        Iterator r12 = r4.iterator();
    L21:
        boolean r13 = true;
        if (r12.hasNext() == false) goto L34;
        Object r14 = r12.next();
        com.bytedance.ee.bear.drive.biz.ai.e r16 = (com.bytedance.ee.bear.drive.biz.ai.e) r14;
        if (r16.a >= 0) goto L26;
    L31:
        r13 = false;
    L32:
        if (r13 == false) goto L21;
        r11.add(r14);
        goto L21
    L26:
        if (r16.b.length() <= 0) goto L28;
        boolean r17 = true;
    L29:
        if (r17 == false) goto L31;
    L28:
        r17 = false;
        goto L29
    L34:
        List r18 = CollectionsKt.sortedWith(r11, new com.bytedance.ee.bear.drive.biz.ai.c());
        if (r18.isEmpty() == false) goto L38;
        List r19 = CollectionsKt.emptyList();
    L37:
        List r110 = r19;
        if (r8 != null) goto L52;
        List r20 = CollectionsKt.emptyList();
    L53:
        ArrayList r111 = new ArrayList();
        Iterator r21 = r20.iterator();
    L55:
        if (r21.hasNext() == false) goto L67;
        String r24 = ((TTReaderSelectionInfo) r21.next()).selectedText;
        if (r24 != null) goto L59;
    L64:
        r24 = null;
    L65:
        if (r24 == null) goto L55;
        r111.add(r24);
        goto L55
    L59:
        if (r24.length() <= 0) goto L61;
        boolean r26 = true;
    L62:
        if (r26 == false) goto L64;
    L61:
        r26 = false;
        goto L62
    L67:
        com.bytedance.ee.util.ui.j.f(new a(this.c, this.d, r8, r9, this.e, r110, CollectionsKt.joinToString$default(r111, DocViewModel.ENTER_CHAR, null, null, 0, null, null, 62, null)));
        return;
    L52:
        r20 = r8;
        goto L53
    L38:
        StringBuilder r27 = new StringBuilder();
        Iterator r28 = r18.iterator();
        int r29 = 20000;
        boolean r112 = false;
    L40:
        if (r28.hasNext() == false) goto L49;
        com.bytedance.ee.bear.drive.biz.ai.e r113 = (com.bytedance.ee.bear.drive.biz.ai.e) r28.next();
        if (r29 == 0) goto L48;
        String r114 = r113.b;
        int r115 = r114.codePointCount(0, r114.length());
        if (r115 <= r29) goto L46;
        r27.append(r114, 0, r114.offsetByCodePoints(0, r29));
        r29 = 0;
        goto L48
    L46:
        r27.append(r114);
        r29 = r29 - r115;
    L48:
        r112 = true;
        goto L40
    L49:
        r19 = CollectionsKt.listOf(new t75.g(new t75.d(((com.bytedance.ee.bear.drive.biz.ai.e) CollectionsKt.first(r18)).a + 1, ((com.bytedance.ee.bear.drive.biz.ai.e) CollectionsKt.last(r18)).a + 1), r27.toString(), r112));
        goto L37
    L12:
        r2 = r8;
        goto L13
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }

    public c1(com.bytedance.ee.bear.drive.view.widget.a r1, com.bytedance.ee.bear.drive.view.widget.a r2, DrivePreviewAiResourceContextVM r3, long r4, BubbleMenuVM r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}

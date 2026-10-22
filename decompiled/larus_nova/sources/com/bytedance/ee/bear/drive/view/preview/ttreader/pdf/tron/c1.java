package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.os.Bundle;
import android.view.View;
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

/* JADX INFO: loaded from: classes16.dex */
public final class c1 implements IReaderSelectionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DrivePreviewAiResourceContextVM f225333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f225334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BubbleMenuVM f225335e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePreviewAiResourceContextVM f225336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f225337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<TTReaderSelectionInfo> f225338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f225339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BubbleMenuVM f225340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<t75.g> f225341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f225342g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(DrivePreviewAiResourceContextVM r100, long r101, List<? extends TTReaderSelectionInfo> r102, Bundle r103, BubbleMenuVM r104, List<t75.g> r105, String r106) {
            this.f225336a = r100;
            this.f225337b = r101;
            this.f225338c = r102;
            this.f225339d = r103;
            this.f225340e = r104;
            this.f225341f = r105;
            this.f225342g = r106;
        }

        public final void a() {
            if (this.f225336a.isCurrentGeneration(this.f225337b) == true) goto L6;
            tt5.a.h("TTStreamingPdfView", "drop stale selection callback, generation=" + this.f225337b);
            return;
        L6:
            StringBuilder r100 = new StringBuilder("onSelectionChanged, allSelectionInfos count = ");
            List<TTReaderSelectionInfo> r101 = this.f225338c;
            if (r101 == null) goto L9;
            Integer r102 = Integer.valueOf(r101.size());
        L10:
            r100.append(r102);
            r100.append(", extra = ");
            r100.append(this.f225339d);
            tt5.a.b("TTStreamingPdfView", r100.toString());
            this.f225340e.updateSelectionData(new com.bytedance.ee.bear.drive.biz.bubblemenu.d(this.f225338c, this.f225339d));
            this.f225336a.updateSelections(this.f225337b, this.f225341f);
            this.f225336a.updateSelectionText(this.f225337b, this.f225342g);
            return;
        L9:
            r102 = null;
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

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderSelectionClient
    public final View getPopupMenu() {
        return null;
    }

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderSelectionClient
    public final View getLeftIndicator() {
        return this.f225331a;
    }

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderSelectionClient
    public final View getRightIndicator() {
        return this.f225332b;
    }

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderSelectionClient
    public final void onSelectionChanged(List<TTReaderSelectionInfo> r210, Bundle r211) {
        if (r210 == null) goto L5;
        List r100 = CollectionsKt.toList(r210);
    L6:
        if (r211 == null) goto L8;
        Bundle r101 = new Bundle(r211);
    L9:
        int r102 = com.bytedance.ee.bear.drive.biz.ai.d.f222592a;
        if (r100 != null) goto L12;
        List r103 = CollectionsKt.emptyList();
    L13:
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        TTReaderSelectionInfo r107 = (TTReaderSelectionInfo) r106.next();
        int r108 = r107.pageIndex;
        String r109 = r107.selectedText;
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        r105.add(new com.bytedance.ee.bear.drive.biz.ai.e(r108, r109));
        goto L15
    L20:
        Intrinsics.checkNotNullParameter(r105, "values");
        ArrayList r110 = new ArrayList();
        Iterator r111 = r105.iterator();
    L21:
        boolean r112 = true;
        if (r111.hasNext() == false) goto L34;
        Object r113 = r111.next();
        com.bytedance.ee.bear.drive.biz.ai.e r114 = (com.bytedance.ee.bear.drive.biz.ai.e) r113;
        if (r114.f222593a >= 0) goto L26;
    L31:
        r112 = false;
    L32:
        if (r112 == false) goto L21;
        r110.add(r113);
        goto L21
    L26:
        if (r114.f222594b.length() <= 0) goto L28;
        boolean r115 = true;
    L29:
        if (r115 == false) goto L31;
    L28:
        r115 = false;
        goto L29
    L34:
        List r116 = CollectionsKt.sortedWith(r110, new com.bytedance.ee.bear.drive.biz.ai.c());
        if (r116.isEmpty() == false) goto L38;
        List r117 = CollectionsKt.emptyList();
    L37:
        List r118 = r117;
        if (r100 != null) goto L52;
        List r119 = CollectionsKt.emptyList();
    L53:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r119.iterator();
    L55:
        if (r121.hasNext() == false) goto L67;
        String r122 = ((TTReaderSelectionInfo) r121.next()).selectedText;
        if (r122 != null) goto L59;
    L64:
        r122 = null;
    L65:
        if (r122 == null) goto L55;
        r120.add(r122);
        goto L55
    L59:
        if (r122.length() <= 0) goto L61;
        boolean r123 = true;
    L62:
        if (r123 == false) goto L64;
    L61:
        r123 = false;
        goto L62
    L67:
        com.bytedance.ee.util.ui.j.f(new a(this.f225333c, this.f225334d, r100, r101, this.f225335e, r118, CollectionsKt.joinToString$default(r120, "\n", null, null, 0, null, null, 62, null)));
        return;
    L52:
        r119 = r100;
        goto L53
    L38:
        StringBuilder r124 = new StringBuilder();
        Iterator r125 = r116.iterator();
        int r126 = 20000;
        boolean r127 = false;
    L40:
        if (r125.hasNext() == false) goto L49;
        com.bytedance.ee.bear.drive.biz.ai.e r128 = (com.bytedance.ee.bear.drive.biz.ai.e) r125.next();
        if (r126 == 0) goto L48;
        String r129 = r128.f222594b;
        int r130 = r129.codePointCount(0, r129.length());
        if (r130 <= r126) goto L46;
        r124.append(r129, 0, r129.offsetByCodePoints(0, r126));
        r126 = 0;
        goto L48
    L46:
        r124.append(r129);
        r126 = r126 - r130;
    L48:
        r127 = true;
        goto L40
    L49:
        r117 = CollectionsKt.listOf(new t75.g(new t75.d(((com.bytedance.ee.bear.drive.biz.ai.e) CollectionsKt.first(r116)).f222593a + 1, ((com.bytedance.ee.bear.drive.biz.ai.e) CollectionsKt.last(r116)).f222593a + 1), r124.toString(), r127));
        goto L37
    L12:
        r103 = r100;
        goto L13
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = null;
        goto L6
    }

    public c1(com.bytedance.ee.bear.drive.view.widget.a r100, com.bytedance.ee.bear.drive.view.widget.a r101, DrivePreviewAiResourceContextVM r102, long r103, BubbleMenuVM r104) {
        this.f225331a = r100;
        this.f225332b = r101;
        this.f225333c = r102;
        this.f225334d = r103;
        this.f225335e = r104;
    }
}

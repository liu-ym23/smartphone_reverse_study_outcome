package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.event.PresenterLocationChangedEvent;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends l65.a<DrivePdfState> {
    public c f;
    public C0156b g;
    public WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> h;
    public final a i;

    public class a implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC0155a {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b$b, reason: collision with other inner class name */
    public class C0156b implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b {
        public final h a;
        public final /* synthetic */ b b;

        public final void a() {
            tt5.a.b("CCMFollow_PDFVCFollowConnector", "ExhibitionModeChangeListener onExhibitionModeChanged: ");
            ((l65.a.C0248a) this.a).b();
        }

        public final void b() {
            b r0 = this.b;
            if (r0.d == null) goto L14;
            NonProguard r1 = r0.j();
            String r3 = r0.getModule();
            Map<String, l65.b> r4 = r0.a;
            if (r0.c == false) goto L7;
            String r2 = "BLOCK_PREVIEW";
        L8:
            l65.b r5 = r4.get(r2);
            if (r5 == null) goto L11;
            String r6 = r5.b;
        L12:
            FollowModuleState r7 = new FollowModuleState(r3, r6, JSON.toJSONString(r1));
            tt5.a.h("CCMFollow_PDFVCFollowConnector", "onAttach: send state when load success followModuleState=" + r7.toString());
            this.b.d.b(r7);
            return;
        L11:
            r6 = "";
            goto L12
        L7:
            r2 = "NOT_BLOCK_PREVIEW";
            goto L8
        }

        public C0156b(b r1, h r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class c implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c {
        public final h a;

        public c(h r1) {
            this.a = r1;
        }
    }

    @Override // l65.a
    public final l65.a<DrivePdfState>.C0248a i() {
        return new l65.a.C0248a(this);
    }

    @Override // l65.a
    public final NonProguard j() {
        DrivePdfState r0 = new DrivePdfState();
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r1 = p();
        if (r1 != null) goto L6;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generatePresenterState fail 350");
    L34:
        return r0;
    L6:
        if (r1.getCurrentMode() != ExhibitionMode.NORMAL) goto L12;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r3 = p();
        if (r3 != null) goto L10;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "findMiddleItem: recyclerview or layer is invalid");
        int r4 = -1;
    L11:
        int r5 = r4 + 1;
    L13:
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r6 = p();
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        r0.setPageNumber(r5);
        r0.setIsPresentationMode(r7);
        ExhibitionMode r8 = r1.getCurrentMode();
        ExhibitionMode r9 = ExhibitionMode.PRESENTATION;
        if (r8 == r9) goto L26;
        int r10 = r5 - 1;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r11 = p();
        if (r11 != null) goto L24;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generateOffsetPercent: recyclerview or layer is invalid");
        float r12 = -1.0f;
    L25:
        r0.setPageOffsetTop(r12);
        goto L26
    L24:
        r12 = r11.d(r10);
    L26:
        r0.setScale(1.0f);
        r0.setPageOffsetLeft(0.5f);
        if (r1.getCurrentMode() == r9) goto L33;
        DrivePdfState.V2Offset r2 = new DrivePdfState.V2Offset();
        r2.pageNumber = -1;
        r2.pageOffsetTop = -1.0f;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r13 = p();
        if (r13 != null) goto L31;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generateOffsetPercentV2: recyclerview or layer is invalid");
    L32:
        r0.setV2(r2);
        goto L33
    L31:
        r2 = r13.c();
    L33:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "generatePresenterState=" + r0);
        goto L34
    L16:
        if (r6.getCurrentMode() != ExhibitionMode.PRESENTATION) goto L18;
        r7 = true;
        goto L19
    L10:
        r4 = r3.f();
        goto L11
    L12:
        r5 = r1.getCurrentPage();
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "onDetach: 563 ");
        WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> r0 = this.h;
        if (r0 == null) goto L9;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r1 = r0.get();
        if (r1 == null) goto L10;
        r1.setScrollListener(null);
        r1.setPDFActionListener(null);
        return;
    L10:
        return;
    }

    public final com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a p() {
        WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> r0 = this.h;
        if (r0 != null) goto L7;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "getLayer mFollowView null ");
        return null;
    L7:
        return r0.get();
    }

    @Override // l65.a
    public final Class n() {
        return DrivePdfState.class;
    }

    public b(Map<String, l65.b> r1) {
        super(r1);
        this.i = new a(this);
    }

    @Override // l65.a, py4.g
    public final void c(FollowModuleState r2) {
        if (m() == false) goto L5;
        return;
    L5:
        super.c(r2);
    }

    @Override // l65.a
    public final void h(NonProguard r5) {
        DrivePdfState r6 = (DrivePdfState) r5;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r0 = p();
        if (r0 != null) goto L5;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "doRemoteAction: 228");
        return;
    L5:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "state=" + r6);
        if (r6 != null) goto L9;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        if (r6.isIsPresentationMode() == false) goto L14;
        ExhibitionMode r1 = r0.getCurrentMode();
        ExhibitionMode r2 = ExhibitionMode.PRESENTATION;
        if (r1 == r2) goto L14;
        r0.setExhibitionMode(r2);
    L19:
        if (r0.getCurrentMode() != ExhibitionMode.PRESENTATION) goto L21;
        r0.b(r6.getPageNumber());
        return;
    L21:
        r0.setState(r6);
        r0.setListenerChange(this.i);
        if (r6.getV2() != null) goto L24;
        r(r6.getPageNumber() - 1, r6.getPageOffsetTop());
        r0.setCurrentPosition(r6.getPageNumber());
        return;
    L24:
        s(r6.getV2());
        return;
    L14:
        if (r6.isIsPresentationMode() == true) goto L19;
        ExhibitionMode r3 = r0.getCurrentMode();
        ExhibitionMode r4 = ExhibitionMode.NORMAL;
        if (r3 == r4) goto L19;
        r0.setExhibitionMode(r4);
        goto L19
    }

    @Override // l65.a
    public final void k(l65.a<DrivePdfState>.C0248a r2) {
        this.f = new c(r2);
        this.g = new C0156b(this, r2);
    }

    public final void s(DrivePdfState.V2Offset r6) {
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r1 = p();
        if (r1 != null) goto L6;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionV2: recyclerview is invalid or layer is invalid");
        return;
    L6:
        int r3 = r6.pageNumber - 1;
        float r7 = r6.pageOffsetTop;
        if (r3 < r1.getPageCount()) goto L9;
        r3 = r1.getPageCount() - 1;
    L9:
        int r4 = Math.max(r3, 0);
        int r2 = r1.a(r4);     // Catch: Exception -> L19
        if (r2 <= 0) goto L13;
        int r8 = Math.max((int) (r2 * r7), 0);     // Catch: Exception -> L19
    L14:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal pos=" + r4 + "offset=" + r8);     // Catch: Exception -> L19
        int r9 = -r8;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r0 = p();     // Catch: Exception -> L19
        if (r0 != null) goto L17;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal: layer is invalid");     // Catch: Exception -> L19
        return;
    L17:
        r0.e(r4, r9);     // Catch: Exception -> L19
        return;
    L13:
        r8 = 0;
    L19:
        e = move-exception;
        tt5.a.e("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionV2: ", e, false);
    }

    public static PresenterLocationChangedEvent.Location q(DrivePdfState r8, int r9) {
        if (r9 > 0) goto L5;
        r9 = 1;
    L5:
        double r4 = 0.5d;
        if (r8.isIsPresentationMode() == false) goto L8;
        double r0 = (((double) r8.getPageNumber()) * 1.0d) / ((double) r9);
        String r10 = ExhibitionMode.PRESENTATION.name();
        double r1 = 0.5d;
        r4 = r0;
    L9:
        PresenterLocationChangedEvent.Location r11 = new PresenterLocationChangedEvent.Location();
        r11.setX(r4);
        r11.setY(r1);
        r11.setSpace(r10);
        return r11;
    L8:
        r1 = (((double) ((r8.getPageNumber() - 1) + r8.getPageOffsetTop())) * 1.0d) / ((double) r9);
        r10 = ExhibitionMode.NORMAL.name();
        goto L9
    }

    @Override // l65.a
    public final void l(NonProguard r2, NonProguard r3) {
        DrivePdfState r4 = (DrivePdfState) r2;
        DrivePdfState r5 = (DrivePdfState) r3;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r0 = this.h.get();
        if (r0 == null) goto L5;
        int r1 = r0.getPageCount();
    L6:
        PresenterLocationChangedEvent.Location r6 = q(r4, r1);
        PresenterLocationChangedEvent.Location r7 = q(r5, r1);
        if (this.d == null) goto L10;
        PresenterLocationChangedEvent r8 = new PresenterLocationChangedEvent();
        r8.setFollower(r7);
        r8.setPresenter(r6);
        this.d.a(r8);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void r(int r5, float r6) {
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r0 = p();
        if (r0 != null) goto L7;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPosition: recyclerview is invalid or layer is invalid");
        return;
    L7:
        if (r5 < r0.getPageCount()) goto L10;
        r5 = r0.getPageCount() - 1;
    L10:
        if (r5 >= 0) goto L26;
        r5 = 0;
    L26:
        int r3 = r0.a(r5);     // Catch: Exception -> L23
        if (r3 <= 0) goto L17;
        int r7 = (int) ((r0.getViewHeight() / 2) - (r3 * r6));     // Catch: Exception -> L23
        if (r7 < 0) goto L17;
    L18:
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r1 = p();     // Catch: Exception -> L23
        if (r1 != null) goto L21;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal: layer is invalid");     // Catch: Exception -> L23
        return;
    L21:
        r1.e(r5, r7);     // Catch: Exception -> L23
        return;
    L17:
        r7 = 0;
    L23:
        e = move-exception;
        tt5.a.e("CCMFollow_PDFVCFollowConnector", "scrollToTargetPosition: ", e, false);
    }
}

package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.event.PresenterLocationChangedEvent;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends l65.a<DrivePdfState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f223813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C3212b f223814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> f223815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f223816i;

    public class a implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC3211a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f223817a;

        public a(b r100) {
            this.f223817a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b$b, reason: collision with other inner class name */
    public class C3212b implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f223818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f223819b;

        public final void a() {
            tt5.a.b("CCMFollow_PDFVCFollowConnector", "ExhibitionModeChangeListener onExhibitionModeChanged: ");
            ((l65.a.C6654a) this.f223818a).b();
        }

        public final void b() {
            b r100 = this.f223819b;
            if (r100.f507691d == null) goto L14;
            NonProguard r101 = r100.j();
            String r102 = r100.getModule();
            Map<String, l65.b> r103 = r100.f507688a;
            if (r100.f507690c == false) goto L7;
            String r104 = "BLOCK_PREVIEW";
        L8:
            l65.b r105 = r103.get(r104);
            if (r105 == null) goto L11;
            String r106 = r105.f507697b;
        L12:
            FollowModuleState r107 = new FollowModuleState(r102, r106, JSON.toJSONString(r101));
            tt5.a.h("CCMFollow_PDFVCFollowConnector", "onAttach: send state when load success followModuleState=" + r107.toString());
            this.f223819b.f507691d.b(r107);
            return;
        L11:
            r106 = "";
            goto L12
        L7:
            r104 = "NOT_BLOCK_PREVIEW";
            goto L8
        }

        public C3212b(b r100, h r101) {
            this.f223819b = r100;
            this.f223818a = r101;
        }
    }

    public static class c implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f223820a;

        public c(h r100) {
            this.f223820a = r100;
        }
    }

    @Override // l65.a
    public final l65.a<DrivePdfState>.C6654a i() {
        return new l65.a.C6654a(this);
    }

    @Override // l65.a
    public final NonProguard j() {
        DrivePdfState r100 = new DrivePdfState();
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r101 = p();
        if (r101 != null) goto L6;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generatePresenterState fail 350");
    L34:
        return r100;
    L6:
        if (r101.getCurrentMode() != ExhibitionMode.NORMAL) goto L12;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r102 = p();
        if (r102 != null) goto L10;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "findMiddleItem: recyclerview or layer is invalid");
        int r103 = -1;
    L11:
        int r104 = r103 + 1;
    L13:
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r105 = p();
        if (r105 != null) goto L16;
    L18:
        boolean r106 = false;
    L19:
        r100.setPageNumber(r104);
        r100.setIsPresentationMode(r106);
        ExhibitionMode r107 = r101.getCurrentMode();
        ExhibitionMode r108 = ExhibitionMode.PRESENTATION;
        if (r107 == r108) goto L26;
        int r109 = r104 - 1;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r110 = p();
        if (r110 != null) goto L24;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generateOffsetPercent: recyclerview or layer is invalid");
        float r111 = -1.0f;
    L25:
        r100.setPageOffsetTop(r111);
        goto L26
    L24:
        r111 = r110.d(r109);
    L26:
        r100.setScale(1.0f);
        r100.setPageOffsetLeft(0.5f);
        if (r101.getCurrentMode() == r108) goto L33;
        DrivePdfState.V2Offset r112 = new DrivePdfState.V2Offset();
        r112.pageNumber = -1;
        r112.pageOffsetTop = -1.0f;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r113 = p();
        if (r113 != null) goto L31;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "generateOffsetPercentV2: recyclerview or layer is invalid");
    L32:
        r100.setV2(r112);
        goto L33
    L31:
        r112 = r113.c();
    L33:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "generatePresenterState=" + r100);
        goto L34
    L16:
        if (r105.getCurrentMode() != ExhibitionMode.PRESENTATION) goto L18;
        r106 = true;
        goto L19
    L10:
        r103 = r102.f();
        goto L11
    L12:
        r104 = r101.getCurrentPage();
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "onDetach: 563 ");
        WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> r100 = this.f223815h;
        if (r100 == null) goto L9;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r101 = r100.get();
        if (r101 == null) goto L10;
        r101.setScrollListener(null);
        r101.setPDFActionListener(null);
        return;
    L10:
        return;
    }

    public final com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a p() {
        WeakReference<com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a> r100 = this.f223815h;
        if (r100 != null) goto L7;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "getLayer mFollowView null ");
        return null;
    L7:
        return r100.get();
    }

    @Override // l65.a
    public final Class n() {
        return DrivePdfState.class;
    }

    public b(Map<String, l65.b> r100) {
        super(r100);
        this.f223816i = new a(this);
    }

    @Override // l65.a, py4.g
    public final void c(FollowModuleState r100) {
        if (m() == false) goto L5;
        return;
    L5:
        super.c(r100);
    }

    @Override // l65.a
    public final void h(NonProguard r100) {
        DrivePdfState r101 = (DrivePdfState) r100;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r102 = p();
        if (r102 != null) goto L5;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "doRemoteAction: 228");
        return;
    L5:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "state=" + r101);
        if (r101 != null) goto L9;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        if (r101.isIsPresentationMode() == false) goto L14;
        ExhibitionMode r103 = r102.getCurrentMode();
        ExhibitionMode r104 = ExhibitionMode.PRESENTATION;
        if (r103 == r104) goto L14;
        r102.setExhibitionMode(r104);
    L19:
        if (r102.getCurrentMode() != ExhibitionMode.PRESENTATION) goto L21;
        r102.b(r101.getPageNumber());
        return;
    L21:
        r102.setState(r101);
        r102.setListenerChange(this.f223816i);
        if (r101.getV2() != null) goto L24;
        r(r101.getPageNumber() - 1, r101.getPageOffsetTop());
        r102.setCurrentPosition(r101.getPageNumber());
        return;
    L24:
        s(r101.getV2());
        return;
    L14:
        if (r101.isIsPresentationMode() == true) goto L19;
        ExhibitionMode r105 = r102.getCurrentMode();
        ExhibitionMode r106 = ExhibitionMode.NORMAL;
        if (r105 == r106) goto L19;
        r102.setExhibitionMode(r106);
        goto L19
    }

    @Override // l65.a
    public final void k(l65.a<DrivePdfState>.C6654a r100) {
        this.f223813f = new c(r100);
        this.f223814g = new C3212b(this, r100);
    }

    public final void s(DrivePdfState.V2Offset r100) {
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r101 = p();
        if (r101 != null) goto L6;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionV2: recyclerview is invalid or layer is invalid");
        return;
    L6:
        int r102 = r100.pageNumber - 1;
        float r103 = r100.pageOffsetTop;
        if (r102 < r101.getPageCount()) goto L9;
        r102 = r101.getPageCount() - 1;
    L9:
        int r104 = Math.max(r102, 0);
        int r105 = r101.a(r104);     // Catch: Exception -> L19
        if (r105 <= 0) goto L13;
        int r106 = Math.max((int) (r105 * r103), 0);     // Catch: Exception -> L19
    L14:
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal pos=" + r104 + "offset=" + r106);     // Catch: Exception -> L19
        int r107 = -r106;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r108 = p();     // Catch: Exception -> L19
        if (r108 != null) goto L17;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal: layer is invalid");     // Catch: Exception -> L19
        return;
    L17:
        r108.e(r104, r107);     // Catch: Exception -> L19
        return;
    L13:
        r106 = 0;
    L19:
        e = move-exception;
        tt5.a.e("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionV2: ", e, false);
    }

    public static PresenterLocationChangedEvent.Location q(DrivePdfState r100, int r101) {
        if (r101 > 0) goto L5;
        r101 = 1;
    L5:
        double r102 = 0.5d;
        if (r100.isIsPresentationMode() == false) goto L8;
        double r103 = (((double) r100.getPageNumber()) * 1.0d) / ((double) r101);
        String r104 = ExhibitionMode.PRESENTATION.name();
        double r105 = 0.5d;
        r102 = r103;
    L9:
        PresenterLocationChangedEvent.Location r106 = new PresenterLocationChangedEvent.Location();
        r106.setX(r102);
        r106.setY(r105);
        r106.setSpace(r104);
        return r106;
    L8:
        r105 = (((double) ((r100.getPageNumber() - 1) + r100.getPageOffsetTop())) * 1.0d) / ((double) r101);
        r104 = ExhibitionMode.NORMAL.name();
        goto L9
    }

    @Override // l65.a
    public final void l(NonProguard r100, NonProguard r101) {
        DrivePdfState r102 = (DrivePdfState) r100;
        DrivePdfState r103 = (DrivePdfState) r101;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r104 = this.f223815h.get();
        if (r104 == null) goto L5;
        int r105 = r104.getPageCount();
    L6:
        PresenterLocationChangedEvent.Location r106 = q(r102, r105);
        PresenterLocationChangedEvent.Location r107 = q(r103, r105);
        if (this.f507691d == null) goto L10;
        PresenterLocationChangedEvent r108 = new PresenterLocationChangedEvent();
        r108.setFollower(r107);
        r108.setPresenter(r106);
        this.f507691d.a(r108);
        return;
    L10:
        return;
    L5:
        r105 = 0;
        goto L6
    }

    public final void r(int r100, float r101) {
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r102 = p();
        if (r102 != null) goto L7;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPosition: recyclerview is invalid or layer is invalid");
        return;
    L7:
        if (r100 < r102.getPageCount()) goto L10;
        r100 = r102.getPageCount() - 1;
    L10:
        if (r100 >= 0) goto L26;
        r100 = 0;
    L26:
        int r103 = r102.a(r100);     // Catch: Exception -> L23
        if (r103 <= 0) goto L17;
        int r104 = (int) ((r102.getViewHeight() / 2) - (r103 * r101));     // Catch: Exception -> L23
        if (r104 < 0) goto L17;
    L18:
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r105 = p();     // Catch: Exception -> L23
        if (r105 != null) goto L21;
        tt5.a.k("CCMFollow_PDFVCFollowConnector", "scrollToTargetPositionInternal: layer is invalid");     // Catch: Exception -> L23
        return;
    L21:
        r105.e(r100, r104);     // Catch: Exception -> L23
        return;
    L17:
        r104 = 0;
    L23:
        e = move-exception;
        tt5.a.e("CCMFollow_PDFVCFollowConnector", "scrollToTargetPosition: ", e, false);
    }
}

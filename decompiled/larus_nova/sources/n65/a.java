package n65;

import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.preview.vc.image.DriveImageState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends l65.a<DriveImageState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<b> f518158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C6901a f518159g;

    /* JADX INFO: renamed from: n65.a$a, reason: collision with other inner class name */
    public class C6901a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f518160a;

        public final void a() {
            tt5.a.b("CCMFollow_ImageVCFollowConnector", "ImageActionStateListener onScaleChanged: ");
            ((l65.a.C6654a) this.f518160a).b();
        }

        public C6901a(h r100) {
            this.f518160a = r100;
        }
    }

    @Override // l65.a
    public final l65.a<DriveImageState>.C6654a i() {
        return new l65.a.C6654a(this);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveImageState r100 = new DriveImageState();
        WeakReference<b> r101 = this.f518158f;
        if (r101 == null) goto L8;
        b r102 = r101.get();
        if (r102 == null) goto L8;
        r100.setOffsetX(0.0f);
        r100.setOffsetY(0.0f);
        r100.setRotate(0.0f);
        r100.setScale(r102.getScale());
    L9:
        return r100;
    L8:
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "generatePresenterState fail 350");
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_ImageVCFollowConnector", "onDetach: 563 ");
        WeakReference<b> r100 = this.f518158f;
        if (r100 == null) goto L9;
        b r101 = r100.get();
        if (r101 == null) goto L10;
        r101.setImageActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveImageState> n() {
        return DriveImageState.class;
    }

    public a(Map<String, l65.b> r100) {
        super(r100);
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
        DriveImageState r101 = (DriveImageState) r100;
        WeakReference<b> r102 = this.f518158f;
        if (r102 == null) goto L12;
        b r103 = r102.get();
        if (r103 == null) goto L12;
        if (r101 != null) goto L10;
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "doRemoteAction: state is null");
        return;
    L10:
        if (r101.getScale() == r103.getScale()) goto L15;
        float r104 = r101.getOffsetX();
        float r105 = r101.getOffsetY();
        r101.getRotate();
        r103.a(r104, r105, r101.getScale());
        return;
    L15:
        return;
    L12:
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveImageState>.C6654a r100) {
        this.f518159g = new C6901a(r100);
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r100, NonProguard r101) {
        DriveImageState r102 = (DriveImageState) r100;
        DriveImageState r103 = (DriveImageState) r101;
    }
}

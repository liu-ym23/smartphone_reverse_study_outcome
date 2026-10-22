package n65;

import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.preview.vc.image.DriveImageState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends l65.a<DriveImageState> {
    public WeakReference<b> f;
    public C0260a g;

    /* JADX INFO: renamed from: n65.a$a, reason: collision with other inner class name */
    public class C0260a implements b.a {
        public final h a;

        public final void a() {
            tt5.a.b("CCMFollow_ImageVCFollowConnector", "ImageActionStateListener onScaleChanged: ");
            ((l65.a.C0248a) this.a).b();
        }

        public C0260a(h r1) {
            this.a = r1;
        }
    }

    @Override // l65.a
    public final l65.a<DriveImageState>.C0248a i() {
        return new l65.a.C0248a(this);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveImageState r0 = new DriveImageState();
        WeakReference<b> r1 = this.f;
        if (r1 == null) goto L8;
        b r2 = r1.get();
        if (r2 == null) goto L8;
        r0.setOffsetX(0.0f);
        r0.setOffsetY(0.0f);
        r0.setRotate(0.0f);
        r0.setScale(r2.getScale());
    L9:
        return r0;
    L8:
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "generatePresenterState fail 350");
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_ImageVCFollowConnector", "onDetach: 563 ");
        WeakReference<b> r0 = this.f;
        if (r0 == null) goto L9;
        b r1 = r0.get();
        if (r1 == null) goto L10;
        r1.setImageActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveImageState> n() {
        return DriveImageState.class;
    }

    public a(Map<String, l65.b> r1) {
        super(r1);
    }

    @Override // l65.a, py4.g
    public final void c(FollowModuleState r2) {
        if (m() == false) goto L5;
        return;
    L5:
        super.c(r2);
    }

    @Override // l65.a
    public final void h(NonProguard r4) {
        DriveImageState r5 = (DriveImageState) r4;
        WeakReference<b> r0 = this.f;
        if (r0 == null) goto L12;
        b r1 = r0.get();
        if (r1 == null) goto L12;
        if (r5 != null) goto L10;
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "doRemoteAction: state is null");
        return;
    L10:
        if (r5.getScale() == r1.getScale()) goto L15;
        float r2 = r5.getOffsetX();
        float r3 = r5.getOffsetY();
        r5.getRotate();
        r1.a(r2, r3, r5.getScale());
        return;
    L15:
        return;
    L12:
        tt5.a.k("CCMFollow_ImageVCFollowConnector", "doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveImageState>.C0248a r2) {
        this.g = new C0260a(r2);
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r1, NonProguard r2) {
        DriveImageState r3 = (DriveImageState) r1;
        DriveImageState r4 = (DriveImageState) r2;
    }
}

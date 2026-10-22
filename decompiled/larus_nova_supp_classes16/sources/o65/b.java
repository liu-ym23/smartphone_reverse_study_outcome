package o65;

import com.bytedance.ee.bear.drive.biz.preview.vc.video.DriveVideoState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends l65.a<DriveVideoState> {
    public WeakReference<o65.a> f;
    public a g;
    public final String h;

    public class a implements o65.a.InterfaceC0267a {
        public final h a;

        public a(h r1) {
            this.a = r1;
        }
    }

    @Override // l65.a
    public final l65.a<DriveVideoState>.C0248a i() {
        return new l65.a.C0248a(this, 500);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveVideoState r0 = new DriveVideoState();
        WeakReference<o65.a> r1 = this.f;
        if (r1 != null) goto L5;
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "VideoVCFollowConnector#generateDrivePDFState");
    L9:
        return r0;
    L5:
        o65.a r2 = r1.get();
        if (r2 == null) goto L9;
        r0.setStatus(r2.getPlayState());
        r0.setFullscreen(false);
        r0.setPlaybackRate(1);
        r0.setCurrentTime(r2.getCurrentTime());
        r0.setRecordId(this.h);
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_VideoVCFollowConnector", "onDetach: 563 ");
        WeakReference<o65.a> r0 = this.f;
        if (r0 == null) goto L9;
        o65.a r1 = r0.get();
        if (r1 == null) goto L10;
        r1.setVideoActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveVideoState> n() {
        return DriveVideoState.class;
    }

    @Override // l65.a
    public final void h(NonProguard r3) {
        DriveVideoState r4 = (DriveVideoState) r3;
        WeakReference<o65.a> r0 = this.f;
        if (r0 == null) goto L10;
        o65.a r1 = r0.get();
        if (r1 == null) goto L10;
        if (r4 != null) goto L9;
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        r1.a(r4.getStatus(), r4.getCurrentTime());
        return;
    L10:
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "VideoVCFollowConnector#doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveVideoState>.C0248a r2) {
        this.g = new a(r2);
    }

    public b(Map<String, l65.b> r1, String r2) {
        super(r1);
        this.h = r2;
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r1, NonProguard r2) {
        DriveVideoState r3 = (DriveVideoState) r1;
        DriveVideoState r4 = (DriveVideoState) r2;
    }
}

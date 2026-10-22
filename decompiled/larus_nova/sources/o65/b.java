package o65;

import com.bytedance.ee.bear.drive.biz.preview.vc.video.DriveVideoState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends l65.a<DriveVideoState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<o65.a> f522198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f522199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f522200h;

    public class a implements o65.a.InterfaceC7020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f522201a;

        public a(h r100) {
            this.f522201a = r100;
        }
    }

    @Override // l65.a
    public final l65.a<DriveVideoState>.C6654a i() {
        return new l65.a.C6654a(this, 500);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveVideoState r100 = new DriveVideoState();
        WeakReference<o65.a> r101 = this.f522198f;
        if (r101 != null) goto L5;
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "VideoVCFollowConnector#generateDrivePDFState");
    L9:
        return r100;
    L5:
        o65.a r102 = r101.get();
        if (r102 == null) goto L9;
        r100.setStatus(r102.getPlayState());
        r100.setFullscreen(false);
        r100.setPlaybackRate(1);
        r100.setCurrentTime(r102.getCurrentTime());
        r100.setRecordId(this.f522200h);
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_VideoVCFollowConnector", "onDetach: 563 ");
        WeakReference<o65.a> r100 = this.f522198f;
        if (r100 == null) goto L9;
        o65.a r101 = r100.get();
        if (r101 == null) goto L10;
        r101.setVideoActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveVideoState> n() {
        return DriveVideoState.class;
    }

    @Override // l65.a
    public final void h(NonProguard r100) {
        DriveVideoState r101 = (DriveVideoState) r100;
        WeakReference<o65.a> r102 = this.f522198f;
        if (r102 == null) goto L10;
        o65.a r103 = r102.get();
        if (r103 == null) goto L10;
        if (r101 != null) goto L9;
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        r103.a(r101.getStatus(), r101.getCurrentTime());
        return;
    L10:
        tt5.a.k("CCMFollow_VideoVCFollowConnector", "VideoVCFollowConnector#doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveVideoState>.C6654a r100) {
        this.f522199g = new a(r100);
    }

    public b(Map<String, l65.b> r100, String r101) {
        super(r100);
        this.f522200h = r101;
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r100, NonProguard r101) {
        DriveVideoState r102 = (DriveVideoState) r100;
        DriveVideoState r103 = (DriveVideoState) r101;
    }
}

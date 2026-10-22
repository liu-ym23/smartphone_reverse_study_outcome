package m65;

import com.bytedance.ee.bear.drive.biz.preview.vc.audio.DriveAudioState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends l65.a<DriveAudioState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<b> f512282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C6774a f512283g;

    /* JADX INFO: renamed from: m65.a$a, reason: collision with other inner class name */
    public class C6774a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f512284a;

        public C6774a(h r100) {
            this.f512284a = r100;
        }
    }

    @Override // l65.a
    public final l65.a<DriveAudioState>.C6654a i() {
        return new l65.a.C6654a(this, 500);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveAudioState r100 = new DriveAudioState();
        WeakReference<b> r101 = this.f512282f;
        if (r101 != null) goto L5;
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "VideoVCFollowConnector#generateDrivePDFState");
    L9:
        return r100;
    L5:
        b r102 = r101.get();
        if (r102 == null) goto L9;
        r100.setStatus(r102.getPlayState());
        r100.setPlaybackRate(1);
        r100.setCurrentTime(r102.getCurrentTime());
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_AudioVCFollowConnector", "onDetach: 563 ");
        WeakReference<b> r100 = this.f512282f;
        if (r100 == null) goto L9;
        b r101 = r100.get();
        if (r101 == null) goto L10;
        r101.setAudioActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveAudioState> n() {
        return DriveAudioState.class;
    }

    public a(Map<String, l65.b> r100) {
        super(r100);
    }

    @Override // l65.a
    public final void h(NonProguard r100) {
        DriveAudioState r101 = (DriveAudioState) r100;
        WeakReference<b> r102 = this.f512282f;
        if (r102 == null) goto L10;
        b r103 = r102.get();
        if (r103 == null) goto L10;
        if (r101 != null) goto L9;
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        r103.g(r101.getStatus(), r101.getCurrentTime());
        return;
    L10:
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveAudioState>.C6654a r100) {
        this.f512283g = new C6774a(r100);
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r100, NonProguard r101) {
        DriveAudioState r102 = (DriveAudioState) r100;
        DriveAudioState r103 = (DriveAudioState) r101;
    }
}

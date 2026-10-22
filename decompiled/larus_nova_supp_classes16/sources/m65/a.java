package m65;

import com.bytedance.ee.bear.drive.biz.preview.vc.audio.DriveAudioState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import java.util.Map;
import l65.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends l65.a<DriveAudioState> {
    public WeakReference<b> f;
    public C0254a g;

    /* JADX INFO: renamed from: m65.a$a, reason: collision with other inner class name */
    public class C0254a implements b.a {
        public final h a;

        public C0254a(h r1) {
            this.a = r1;
        }
    }

    @Override // l65.a
    public final l65.a<DriveAudioState>.C0248a i() {
        return new l65.a.C0248a(this, 500);
    }

    @Override // l65.a
    public final NonProguard j() {
        DriveAudioState r0 = new DriveAudioState();
        WeakReference<b> r1 = this.f;
        if (r1 != null) goto L5;
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "VideoVCFollowConnector#generateDrivePDFState");
    L9:
        return r0;
    L5:
        b r2 = r1.get();
        if (r2 == null) goto L9;
        r0.setStatus(r2.getPlayState());
        r0.setPlaybackRate(1);
        r0.setCurrentTime(r2.getCurrentTime());
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_AudioVCFollowConnector", "onDetach: 563 ");
        WeakReference<b> r0 = this.f;
        if (r0 == null) goto L9;
        b r1 = r0.get();
        if (r1 == null) goto L10;
        r1.setAudioActionListener(null);
        return;
    L10:
        return;
    }

    @Override // l65.a
    public final Class<DriveAudioState> n() {
        return DriveAudioState.class;
    }

    public a(Map<String, l65.b> r1) {
        super(r1);
    }

    @Override // l65.a
    public final void h(NonProguard r5) {
        DriveAudioState r6 = (DriveAudioState) r5;
        WeakReference<b> r0 = this.f;
        if (r0 == null) goto L10;
        b r1 = r0.get();
        if (r1 == null) goto L10;
        if (r6 != null) goto L9;
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        r1.g(r6.getStatus(), r6.getCurrentTime());
        return;
    L10:
        tt5.a.k("CCMFollow_AudioVCFollowConnector", "doRemoteAction: 228");
    }

    @Override // l65.a
    public final void k(l65.a<DriveAudioState>.C0248a r2) {
        this.g = new C0254a(r2);
    }

    @Override // l65.a
    public final /* bridge */ /* synthetic */ void l(NonProguard r1, NonProguard r2) {
        DriveAudioState r3 = (DriveAudioState) r1;
        DriveAudioState r4 = (DriveAudioState) r2;
    }
}

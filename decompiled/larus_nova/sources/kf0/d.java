package kf0;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f503140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f503141b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r102 = this.f503140a;
        r101.getClass();
        TalkRoomBusinessFullLinkMonitor.C(r102, r100);
        ((InteractAudienceInviteContract$View) this.f503141b.f567428b).aa0();
    }

    public d(f r100, long r101) {
        this.f503141b = r100;
        this.f503140a = r101;
    }
}

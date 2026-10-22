package kf0;

import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f503142a;

    public e(f r100) {
        this.f503142a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        ((InteractAudienceInviteContract$View) this.f503142a.f567428b).aa0();
    }
}

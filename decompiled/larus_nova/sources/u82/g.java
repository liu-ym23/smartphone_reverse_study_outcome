package u82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f549170a;

    public g(h r100) {
        this.f549170a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.stacktrace(6, this.f549170a.f545018b, r101.getStackTrace());
        MediaAnchorLinkUserListContract$View r102 = (MediaAnchorLinkUserListContract$View) this.f549170a.f545019c;
        if (r102 == null) goto L6;
        r102.Y90(r101);
        return;
    }
}

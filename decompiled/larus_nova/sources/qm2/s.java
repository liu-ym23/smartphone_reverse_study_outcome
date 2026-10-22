package qm2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.microom.MicRoomAudienceTimeControlWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f533863a = null;

    static {
        f533863a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = MicRoomAudienceTimeControlWidget.f153745f;
        ALogger.e("MicRoomAudienceTimeControlWidget", ((Throwable) r100).getMessage());
    }
}

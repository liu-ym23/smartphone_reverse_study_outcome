package vh1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.RoomPreloadBusinessV2;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class y1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomPreloadBusinessV2 f554949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f554950b;

    public y1(RoomPreloadBusinessV2 r100, Class r101) {
        this.f554949a = r100;
        this.f554950b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        ALogger.i(this.f554949a.f107041b, "orientation change: ".concat(this.f554950b.getSimpleName()));
        ((LinkedHashMap) this.f554949a.f107049j).clear();
    }
}

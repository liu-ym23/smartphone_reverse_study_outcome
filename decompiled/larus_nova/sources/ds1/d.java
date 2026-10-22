package ds1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f469838a = null;

    static {
        f469838a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("MatchRoomLandScapeAnimUtil.mStateSubject ERROR ");
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r102.append(r103);
        ALogger.i("LiveMultiTab", r102.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }
}

package p72;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f527994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f527995b;

    public e(long r100, String r101) {
        this.f527994a = r100;
        this.f527995b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("FusionEmoji", "download emoji failed, emojiId:" + this.f527994a + ",roomId:" + this.f527995b);
    }
}

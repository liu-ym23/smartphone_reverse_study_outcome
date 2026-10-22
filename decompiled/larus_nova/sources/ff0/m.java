package ff0;

import android.util.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f476657a = null;

    static {
        f476657a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d r101 = d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", -1, Log.getStackTraceString((Throwable) r100), null, 16);
    }
}

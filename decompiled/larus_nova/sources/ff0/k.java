package ff0;

import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f476655a = null;

    static {
        f476655a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        PolarisFileWrapper r101 = new PolarisFileWrapper(new PolarisFileWrapper(s1.getContext().getExternalFilesDir(null), "hamlet_avatar"), "lip_sync_config");     // Catch: Throwable -> L5
        int r102 = n.f476658a;     // Catch: Throwable -> L5
        n.a(s1.getContext(), "lip_sync_config", r101);     // Catch: Throwable -> L5
        d r103 = d.f476647a;     // Catch: Throwable -> L5
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", 0, null, null, 24);     // Catch: Throwable -> L5
        r100.onNext(Boolean.TRUE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d r104 = d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "extra_lip_sync_config_result", -1, Log.getStackTraceString(th), null, 16);
        r100.onNext(Boolean.FALSE);
    }
}

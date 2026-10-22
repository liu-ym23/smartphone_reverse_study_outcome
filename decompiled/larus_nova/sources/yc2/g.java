package yc2;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.wgamex.gameinvite.j;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f567130a = null;

    static {
        f567130a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((j) r100).f160740b != 2) goto L6;
        f2.b(R.string.ttlive_wgame_invite_sent, 0);
        return;
    }
}

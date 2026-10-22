package qs0;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface d {

    public static final class a extends Response<Boolean> {
        public a() {
        }
    }

    Observable<a> f(long r100, long r101);

    boolean isPlayingGame();

    boolean isUserInAnchorLink(String r100);
}

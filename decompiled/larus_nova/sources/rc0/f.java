package rc0;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface f {
    void E(cy0.a r100);

    void a(AbsLivePlayerView r100);

    void b(AbsLivePlayerView r100);

    boolean c();

    void d();

    void e();

    boolean f(Context r100, String r101, LiveMode r102, boolean r103, IRoom r104, Pair<Integer, Integer> r105);

    void g(j r100, IRoom r101, Pair<Integer, Integer> r102);

    Pair<Integer, Integer> h();
}

package nb0;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    void a(d r100, List<o0> r101);

    void addFavorite(MusicPanel r100, ic0.a r101);

    void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102);

    void b(boolean r100, Throwable r101, y r102, long r103);

    String c();

    void d(boolean r100, Throwable r101, d r102, long r103);

    void delFavorite(MusicPanel r100, ic0.a r101);

    t61 e();

    Map<String, y> f(d r100);

    int g();

    String getRequiredSongInfo();

    x getRoomInfo();

    String h();

    void postSyncSongListData(y r100);

    void postSyncTabListData(d r100);

    void updateMusicPanelState(MusicPanel r100);
}

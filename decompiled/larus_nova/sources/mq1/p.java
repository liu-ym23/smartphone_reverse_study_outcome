package mq1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface p {
    List<EpisodeGroup> getAllEpisodeList();

    NextLiveData<List<EpisodeGroup>> getMoreReplayList();

    Observable<List<EpisodeGroup>> getPlayList();

    boolean hasMoreData();

    boolean isLoadingMore();

    Episode nextReplayItem();

    void onStartRoom(Episode r100, Context r101, ReplayDataContext r102, com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r103);

    void playNext(boolean r100);

    void refreshItem(Episode r100);

    void refreshReplayList();

    void registerReplayListListener(b r100, boolean r101);

    void registerReplaySwitchListener(e0 r100, boolean r101);

    void release();

    void switchPlayVideo(Episode r100, boolean r101);

    void tryLoadingMoreReplay(Episode r100);

    void unregisterReplayListListener(b r100);

    void unregisterReplaySwitchListener(e0 r100);
}

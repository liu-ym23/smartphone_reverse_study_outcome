package mq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    void onListDataChanged(List<? extends EpisodeGroup> r100);

    void onPullDataFailed(Throwable r100);
}

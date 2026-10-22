package yq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    boolean canShowMsgBoard(DataCenter r100);

    String getMsgBoardSchema(DataCenter r100);

    k getVsMsgBoardIcon(DataCenter r100);

    String getVsMsgBoardLiveEpisodeId(DataCenter r100);

    void paidStatusChanged(DataCenter r100);

    boolean replayToolbarDataHasDress(Episode r100);
}

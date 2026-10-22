package lm1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.widget.k0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes7.dex */
public interface b {
    n<Episode> getEpisode();

    m<Integer> getOpenPanelInReplay();

    j<k0> getReplayUISizeGetter();

    n<ViewGroup.LayoutParams> getVideoContainerPositionInfo();

    j<Object> getVsMsgBoardDataContext();

    m<Boolean> isPortrait();
}

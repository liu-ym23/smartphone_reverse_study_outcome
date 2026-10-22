package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void c(d r2) {
            r2.syncMineWantSingSongList(false, null);
        }

        public static /* synthetic */ void b(d r1, MusicPanel r2, Boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 4) == 0) goto L9;
            r3 = null;
        L9:
            r1.removeMusic(r2, r0, r3);
            return;
        L5:
            r0 = false;
            goto L7
        }

        public static /* synthetic */ void a(d r7, Throwable r8, int r9, RTChorusOperateType r10, MusicPanel r11) {
            r7.checkRTChorusPermissionInfoIfNeed(r8, r9, r10, r11, null, null);
        }
    }

    void addFavorite(MusicPanel r1, ic0.a r2);

    void addSong(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3, com.bytedance.android.live.ktv.common.music.control.b r4);

    void applyWantListen(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3);

    void beginWifiDownload(y r1);

    boolean canSelectMore();

    boolean checkMidiDataInRecentlyLabel(y r1);

    void checkRTChorusPermissionInfoIfNeed(Throwable r1, int r2, RTChorusOperateType r3, MusicPanel r4, String r5, String r6);

    void clearSelectedSongList();

    void cutMusic();

    void delFavorite(MusicPanel r1, ic0.a r2);

    void deleteSelfDownloadMusicById(String r1);

    String getCurSortType();

    boolean getForceUpdateBannerState();

    Map<String, LabelBannerUrl> getLabelBannerMap();

    ModeType getModeType();

    td2.b getOrderSongExtraInfo();

    MutableLiveData<vb0.a> getOrderSongUiState();

    OrderedSongDataContext getOrderedSongDataContext();

    void getOrderedSongList(boolean r1);

    String getRequiredSongInfo();

    Integer getSungOrderCount();

    int getWantSingSongThreshold();

    boolean inSelfDownloadMusicById(String r1);

    void initData();

    boolean isAudienceEnableSing();

    boolean isOnlyAcceptFollowerApply();

    void jumpToChorusRoom(MusicPanel r1);

    void moveOrderedSongToOtherRoom(long r1);

    void observeCurFavoriteMusic(LifecycleOwner r1, Observer<MusicPanel> r2);

    void observeCurOrderedMusic(LifecycleOwner r1, Observer<MusicPanel> r2);

    void observeMusicPlayerState(LifecycleOwner r1, Observer<Boolean> r2);

    void observeSecondLevelTabBanner(LifecycleOwner r1, Observer<Map<String, LabelBannerUrl>> r2);

    void observeSingUserChange(LifecycleOwner r1, boolean r2, Consumer<Boolean> r3);

    void observeSungOrderCount(LifecycleOwner r1, Observer<Integer> r2);

    void onDialogDismiss();

    void onDialogShow(int[] r1);

    void onItemClick(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3);

    void onSearchEnter();

    void onSearchExit();

    void onSearchReset();

    void orderPlayAllSong(List<MusicPanel> r1, y r2);

    void permitWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r1, y r2);

    void pinMusic(MusicPanel r1);

    void postSyncSongListData(y r1);

    void postSyncTabListData(com.bytedance.android.live.ktv.common.karaokestation.model.d r1);

    void removeMusic(MusicPanel r1, boolean r2, Boolean r3);

    void removeWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r1, y r2);

    void removeWantSingSong(KtvMusic r1);

    void setForceUpdateBannerState(boolean r1);

    void sortSecondLevelTabByType(String r1, y r2);

    void stopWifiDownload();

    void syncHighScoreSongList(boolean r1);

    void syncMineWantSingSongList(boolean r1, Function1<? super Boolean, Unit> r2);

    void syncMultiChorusWaitingList(boolean r1, Function1<? super Boolean, Unit> r2);

    void syncSongWaitingList(boolean r1, Function1<? super Boolean, Unit> r2);

    void syncSungSongList(boolean r1, Function1<? super Boolean, Unit> r2);

    void syncWantListenSongList(boolean r1, Function1<? super Boolean, Unit> r2);

    void togglePause(boolean r1);

    void updateCurrentTabData();

    void updateMusicPanelState(MusicPanel r1);

    void updateOrderSongExtraInfo(td2.b r1);

    void updateRequiredSongInfo(String r1);
}

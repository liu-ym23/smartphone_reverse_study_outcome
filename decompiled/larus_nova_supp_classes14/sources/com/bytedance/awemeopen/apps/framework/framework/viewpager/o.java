package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface o {
    void addPauseOrPlayObserver(LifecycleOwner r1, Observer<FeedPlayerHelper.b> r2);

    void addPlayDurationChangeListener(FeedSeekBarHelper.c r1);

    void addPlayStateListener(com.bytedance.awemeopen.infra.base.player.k r1);

    void addSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r1);

    Boolean canAutoPlay();

    void doAutoPlay();

    boolean forceEnableShareInCardMode();

    Boolean getAutoPlayState();

    String getCommerceClickType();

    String getContentScene();

    long getCurrentPosition();

    long getDuration();

    boolean getEnableFollowChannel();

    DiscardFirstValueLiveData<Boolean> getEnterCleanMode();

    DiscardFirstValueLiveData<Boolean> getEnterPinchMode();

    DiscardFirstValueLiveData<Boolean> getFeedHomeContainerDeliverHiddenState();

    LiveData<Integer> getFeedHomeContainerSelectedIndex();

    int getHasPlayCount();

    List<j54.a> getHostExtensionInfo();

    Map<String, String> getHostExtraInfo();

    com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d getISeekBar();

    DiscardFirstValueLiveData<Boolean> getLoadMoreUiShow();

    boolean getNeedDouyinFlag();

    String getOverType();

    FeedPageConfig getPageConfig();

    com.bytedance.awemeopen.infra.base.player.g getPlayer();

    p54.b getPlayerController();

    long getPostPlayTimeDurationRecord();

    MutableLiveData<Integer> getSlidesPlayCompletedPosition();

    MutableLiveData<p> getSlidesProgressInfo();

    MutableLiveData<Integer> getSlidesProgressPosition();

    String getStartType();

    l54.b getUIConfig();

    MutableLiveData<pz3.d> getVideoScaling();

    long getWatchDuration();

    boolean ignorePageStatusControl();

    boolean isFeedVisible();

    boolean isInFeedPage();

    void markDislike();

    void observeCommentShowState(LifecycleOwner r1, Observer<Integer> r2);

    void playPlayer();

    boolean playerIsPlaying();

    void removeObserveCommentShowState(Observer<Integer> r1);

    void removePauseOrPlayObserver(Observer<FeedPlayerHelper.b> r1);

    void removePlayDurationChangeListener(FeedSeekBarHelper.c r1);

    void removePlayStateListener(com.bytedance.awemeopen.infra.base.player.k r1);

    void removeSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r1);

    void removeVideoAutoPlayListener();

    String sceneId();

    void setCommentShowState(int r1);

    void setCommerceClickType(String r1);

    void setOverType(String r1);

    void setPlayTimeDurationRecord(long r1);

    void setPostPlayTimeDurationRecord(long r1);

    void setStartType(String r1);

    void setVideoAutoPlayListener(FeedPlayerHelper.c r1);

    Boolean showAutoPlaySwitch();

    Long timeOnLiveRoom();

    com.bytedance.awemeopen.infra.base.player.j toPlayRequest(r14.c r1);

    void turnOffAutoPlaySwitch();

    void turnOnAutoPlaySwitch();
}

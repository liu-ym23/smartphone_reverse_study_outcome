package com.bytedance.awemeopen.apps.framework.card.video;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.p;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.player.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements o {
    public final l54.a a;
    public final VideoCardPlayerViewModel b;
    public SingleVideoSeekBarHelper c;
    public final DiscardFirstValueLiveData<Integer> d;
    public k54.d e;
    public final boolean f;
    public String g;
    public long h;
    public String i;
    public String j;
    public final DiscardFirstValueLiveData<Boolean> k;
    public final DiscardFirstValueLiveData l;
    public final MutableLiveData<pz3.d> m;
    public final DiscardFirstValueLiveData<Boolean> n;
    public final DiscardFirstValueLiveData<Boolean> o;
    public final DiscardFirstValueLiveData<Boolean> p;
    public final boolean q;

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void doAutoPlay() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final String getContentScene() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean getEnableFollowChannel() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final int getHasPlayCount() {
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final Map<String, String> getHostExtraInfo() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final MutableLiveData<Integer> getSlidesPlayCompletedPosition() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final MutableLiveData<p> getSlidesProgressInfo() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final MutableLiveData<Integer> getSlidesProgressPosition() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean isInFeedPage() {
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void markDislike() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final String sceneId() {
        return "homepage_hot";
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setPlayTimeDurationRecord(long r1) {
    }

    public final FeedPlayerHelper a() {
        return this.b.getFeedPlayerHelper();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean forceEnableShareInCardMode() {
        this.a.getClass();
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final Boolean getAutoPlayState() {
        k54.d r0 = this.e;
        if (r0 == null) goto L5;
        r0.i();
        return Boolean.FALSE;
    L5:
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final List<j54.a> getHostExtensionInfo() {
        return this.a.h;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final FeedPageConfig getPageConfig() {
        return this.a.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final l54.b getUIConfig() {
        this.a.getClass();
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final Boolean showAutoPlaySwitch() {
        AosExtConfig.b.n1().d();
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final Long timeOnLiveRoom() {
        return 0L;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void turnOffAutoPlaySwitch() {
        k54.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.d(false);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void turnOnAutoPlaySwitch() {
        k54.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.d(true);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final long getCurrentPosition() {
        return a().e().getCurrentPosition();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final long getDuration() {
        return a().e().getDuration();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final com.bytedance.awemeopen.infra.base.player.g getPlayer() {
        return a().e();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final p54.b getPlayerController() {
        return a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final long getWatchDuration() {
        return a().e().getWatchDuration();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean ignorePageStatusControl() {
        return a().e;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void playPlayer() {
        a().playPlayer();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean playerIsPlaying() {
        return a().playerIsPlaying();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removeVideoAutoPlayListener() {
        a().d = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final Boolean canAutoPlay() {
        return Boolean.FALSE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final String getCommerceClickType() {
        return this.j;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final DiscardFirstValueLiveData<Boolean> getEnterCleanMode() {
        return this.n;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final DiscardFirstValueLiveData<Boolean> getEnterPinchMode() {
        return this.o;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final DiscardFirstValueLiveData<Boolean> getFeedHomeContainerDeliverHiddenState() {
        return this.k;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final LiveData<Integer> getFeedHomeContainerSelectedIndex() {
        return this.l;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d getISeekBar() {
        return this.c;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final DiscardFirstValueLiveData<Boolean> getLoadMoreUiShow() {
        return this.p;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean getNeedDouyinFlag() {
        return this.q;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final String getOverType() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final long getPostPlayTimeDurationRecord() {
        return this.h;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final String getStartType() {
        return this.i;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final MutableLiveData<pz3.d> getVideoScaling() {
        return this.m;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final boolean isFeedVisible() {
        return this.f;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void addPlayDurationChangeListener(FeedSeekBarHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        SingleVideoSeekBarHelper r1 = this.c;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.J.add(r3);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void addPlayStateListener(k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        a().c(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void addSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        SingleVideoSeekBarHelper r0 = this.c;
        if (r0 == null) goto L6;
        r0.addSeekBarChangeListener(r2);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removeObserveCommentShowState(Observer<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.d.removeObserver(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removePauseOrPlayObserver(Observer<FeedPlayerHelper.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        a().g.removeObserver(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removePlayDurationChangeListener(FeedSeekBarHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        SingleVideoSeekBarHelper r1 = this.c;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.J.remove(r3);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removePlayStateListener(k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        a().g(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void removeSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        SingleVideoSeekBarHelper r0 = this.c;
        if (r0 == null) goto L6;
        r0.removeSeekBarChangeListener(r2);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setCommentShowState(int r2) {
        this.d.setValue(Integer.valueOf(r2));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setCommerceClickType(String r1) {
        this.j = "";
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setOverType(String r1) {
        this.g = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setPostPlayTimeDurationRecord(long r1) {
        this.h = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setStartType(String r1) {
        this.i = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void setVideoAutoPlayListener(FeedPlayerHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FeedPlayerHelper r1 = a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.d = r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final com.bytedance.awemeopen.infra.base.player.j toPlayRequest(r14.c r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        a().getClass();
        com.bytedance.awemeopen.infra.base.player.j r3 = FeedPlayerHelper.i(r2);
        this.a.getClass();
        r3.m = null;
        this.a.getClass();
        return r3;
    }

    public j(l54.a r3, VideoCardPlayerViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "videoCardConfig");
        Intrinsics.checkNotNullParameter(r4, "playerVm");
        this.a = r3;
        this.b = r4;
        DiscardFirstValueLiveData<Integer> r5 = new DiscardFirstValueLiveData();
        r5.setValue(0);
        this.d = r5;
        this.f = true;
        this.j = r3.g.getEcDetailParams().optString("commerce_click_type");
        Boolean r1 = Boolean.FALSE;
        this.k = new DiscardFirstValueLiveData(r1);
        this.l = new DiscardFirstValueLiveData(0);
        this.m = new MutableLiveData();
        this.n = new DiscardFirstValueLiveData(r1);
        this.o = new DiscardFirstValueLiveData(r1);
        this.p = new DiscardFirstValueLiveData(r1);
        new DiscardFirstValueLiveData(r1);
        this.q = true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void addPauseOrPlayObserver(LifecycleOwner r2, Observer<FeedPlayerHelper.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        a().g.observe(r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public final void observeCommentShowState(LifecycleOwner r2, Observer<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.d.observe(r2, r3);
    }
}

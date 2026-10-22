package com.bytedance.livesdk.preview.viewmodel;

import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.platformplayer.layout.e;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.ss.android.ugc.aweme.live.player.IPreviewPlayerView;
import com.ss.android.ugc.aweme.live.preview.LivePreviewPlayerContainerAbility;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R!\u00105\u001a\b\u0012\u0004\u0012\u0002000/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00106\u001a\u00020%8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR!\u0010J\u001a\b\u0012\u0004\u0012\u00020G0/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u00102\u001a\u0004\bI\u00104R$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010M\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010k\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020r0q8\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\"\u0010w\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010B\u001a\u0004\bw\u0010D\"\u0004\bx\u0010FR)\u0010z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0y0q8\u0006¢\u0006\f\n\u0004\bz\u0010t\u001a\u0004\b{\u0010vR\"\u0010|\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010B\u001a\u0004\b}\u0010D\"\u0004\b~\u0010FR$\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0/8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0001\u00102\u001a\u0005\b\u0081\u0001\u00104¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/livesdk/preview/viewmodel/PreviewPlayerContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "livePlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "getLivePlayerView", "()Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "setLivePlayerView", "(Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;)V", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getLivePlayerClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "setLivePlayerClient", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;)V", "Lcom/ss/android/ugc/aweme/live/player/IPreviewPlayerView;", "previewPlayerView", "Lcom/ss/android/ugc/aweme/live/player/IPreviewPlayerView;", "getPreviewPlayerView", "()Lcom/ss/android/ugc/aweme/live/player/IPreviewPlayerView;", "setPreviewPlayerView", "(Lcom/ss/android/ugc/aweme/live/player/IPreviewPlayerView;)V", "Landroid/view/View;", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "Lcom/ss/android/ugc/aweme/live/preview/LivePreviewPlayerContainerAbility;", "playerContainerAbility", "Lcom/ss/android/ugc/aweme/live/preview/LivePreviewPlayerContainerAbility;", "getPlayerContainerAbility", "()Lcom/ss/android/ugc/aweme/live/preview/LivePreviewPlayerContainerAbility;", "setPlayerContainerAbility", "(Lcom/ss/android/ugc/aweme/live/preview/LivePreviewPlayerContainerAbility;)V", "", "mSaveWidth", "I", "getMSaveWidth", "()I", "setMSaveWidth", "(I)V", "mSaveHeight", "getMSaveHeight", "setMSaveHeight", "Lcom/bytedance/live/datacontext/k;", "", "startStreamEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getStartStreamEvent", "()Lcom/bytedance/live/datacontext/k;", "startStreamEvent", "playType", "getPlayType", "setPlayType", "", "currentTime", "J", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "", "firstFrameAfterSeek", "Z", "getFirstFrameAfterSeek", "()Z", "setFirstFrameAfterSeek", "(Z)V", "", "playerEvent$delegate", "getPlayerEvent", "playerEvent", "Lcom/bytedance/livesdk/preview/widgets/a;", "mSeiUpdateListener", "Lcom/bytedance/livesdk/preview/widgets/a;", "getMSeiUpdateListener", "()Lcom/bytedance/livesdk/preview/widgets/a;", "setMSeiUpdateListener", "(Lcom/bytedance/livesdk/preview/widgets/a;)V", "multiLinkSeiUpdateListener", "getMultiLinkSeiUpdateListener", "setMultiLinkSeiUpdateListener", "Landroid/graphics/drawable/TransitionDrawable;", "shareTransitionDrawable", "Landroid/graphics/drawable/TransitionDrawable;", "getShareTransitionDrawable", "()Landroid/graphics/drawable/TransitionDrawable;", "setShareTransitionDrawable", "(Landroid/graphics/drawable/TransitionDrawable;)V", "Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "displayRatio", "Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "getDisplayRatio", "()Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "setDisplayRatio", "(Lcom/bytedance/android/livesdkapi/model/DisplayRatio;)V", "Lcom/bytedance/android/live/platformplayer/layout/b;", "livePlayerLayoutManager", "Lcom/bytedance/android/live/platformplayer/layout/b;", "getLivePlayerLayoutManager", "()Lcom/bytedance/android/live/platformplayer/layout/b;", "setLivePlayerLayoutManager", "(Lcom/bytedance/android/live/platformplayer/layout/b;)V", "Lcom/bytedance/android/live/platformplayer/layout/c;", "livePlayerPosition", "Lcom/bytedance/android/live/platformplayer/layout/c;", "getLivePlayerPosition", "()Lcom/bytedance/android/live/platformplayer/layout/c;", "setLivePlayerPosition", "(Lcom/bytedance/android/live/platformplayer/layout/c;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/platformplayer/layout/e;", "playerDataEvent", "Landroidx/lifecycle/MutableLiveData;", "getPlayerDataEvent", "()Landroidx/lifecycle/MutableLiveData;", "isPortraitForUI", "setPortraitForUI", "Lkotlin/Pair;", "screenSize", "getScreenSize", "playerWidgetStartPreview", "getPlayerWidgetStartPreview", "setPlayerWidgetStartPreview", "Lcom/bytedance/android/livesdkapi/model/LayoutEvent;", "layoutEvent$delegate", "getLayoutEvent", "layoutEvent", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPlayerContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private View containerView;
    private long currentTime;
    private DisplayRatio displayRatio;
    private boolean firstFrameAfterSeek;
    private boolean isPortraitForUI;
    private final p layoutEvent$delegate;
    private ILivePlayerClient livePlayerClient;
    private com.bytedance.android.live.platformplayer.layout.b livePlayerLayoutManager;
    private com.bytedance.android.live.platformplayer.layout.c livePlayerPosition;
    private LivePlayerView livePlayerView;
    private int mSaveHeight;
    private int mSaveWidth;
    private com.bytedance.livesdk.preview.widgets.a mSeiUpdateListener;
    private com.bytedance.livesdk.preview.widgets.a multiLinkSeiUpdateListener;
    private int playType;
    private LivePreviewPlayerContainerAbility playerContainerAbility;
    private final MutableLiveData<e> playerDataEvent;
    private final p playerEvent$delegate;
    private boolean playerWidgetStartPreview;
    private IPreviewPlayerView previewPlayerView;
    private final MutableLiveData<Pair<Integer, Integer>> screenSize;
    private TransitionDrawable shareTransitionDrawable;
    private final p startStreamEvent$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PreviewPlayerContext.class, "startStreamEvent", "getStartStreamEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PreviewPlayerContext.class, "playerEvent", "getPlayerEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PreviewPlayerContext.class, "layoutEvent", "getLayoutEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    public final k<LayoutEvent> getLayoutEvent() {
        return (k) this.layoutEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final k<Object> getPlayerEvent() {
        return (k) this.playerEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final IPreviewPlayerView getPreviewPlayerView() {
        return null;
    }

    public final k<Unit> getStartStreamEvent() {
        return (k) this.startStreamEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void setPreviewPlayerView(IPreviewPlayerView r100) {
    }

    public final int getPlayType() {
        if (this.firstFrameAfterSeek == true) goto L7;
        return -1;
    L7:
        return this.playType;
    }

    public PreviewPlayerContext() {
        this.startStreamEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.playType = -1;
        this.currentTime = System.currentTimeMillis();
        this.playerEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.playerDataEvent = new MutableLiveData();
        this.isPortraitForUI = true;
        this.screenSize = new MutableLiveData(TuplesKt.to(-1, -1));
        this.layoutEvent$delegate = com.bytedance.live.datacontext.e.b(this);
    }

    public final View getContainerView() {
        return this.containerView;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final DisplayRatio getDisplayRatio() {
        return this.displayRatio;
    }

    public final boolean getFirstFrameAfterSeek() {
        return this.firstFrameAfterSeek;
    }

    public final ILivePlayerClient getLivePlayerClient() {
        return this.livePlayerClient;
    }

    public final com.bytedance.android.live.platformplayer.layout.b getLivePlayerLayoutManager() {
        return this.livePlayerLayoutManager;
    }

    public final com.bytedance.android.live.platformplayer.layout.c getLivePlayerPosition() {
        return this.livePlayerPosition;
    }

    public final LivePlayerView getLivePlayerView() {
        return this.livePlayerView;
    }

    public final int getMSaveHeight() {
        return this.mSaveHeight;
    }

    public final int getMSaveWidth() {
        return this.mSaveWidth;
    }

    public final com.bytedance.livesdk.preview.widgets.a getMSeiUpdateListener() {
        return this.mSeiUpdateListener;
    }

    public final com.bytedance.livesdk.preview.widgets.a getMultiLinkSeiUpdateListener() {
        return this.multiLinkSeiUpdateListener;
    }

    public final LivePreviewPlayerContainerAbility getPlayerContainerAbility() {
        return this.playerContainerAbility;
    }

    public final MutableLiveData<e> getPlayerDataEvent() {
        return this.playerDataEvent;
    }

    public final boolean getPlayerWidgetStartPreview() {
        return this.playerWidgetStartPreview;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getScreenSize() {
        return this.screenSize;
    }

    public final TransitionDrawable getShareTransitionDrawable() {
        return this.shareTransitionDrawable;
    }

    public final boolean isPortraitForUI() {
        return this.isPortraitForUI;
    }

    public final void setContainerView(View r100) {
        this.containerView = r100;
    }

    public final void setCurrentTime(long r100) {
        this.currentTime = r100;
    }

    public final void setDisplayRatio(DisplayRatio r100) {
        this.displayRatio = r100;
    }

    public final void setFirstFrameAfterSeek(boolean r100) {
        this.firstFrameAfterSeek = r100;
    }

    public final void setLivePlayerClient(ILivePlayerClient r100) {
        this.livePlayerClient = r100;
    }

    public final void setLivePlayerLayoutManager(com.bytedance.android.live.platformplayer.layout.b r100) {
        this.livePlayerLayoutManager = r100;
    }

    public final void setLivePlayerPosition(com.bytedance.android.live.platformplayer.layout.c r100) {
        this.livePlayerPosition = r100;
    }

    public final void setLivePlayerView(LivePlayerView r100) {
        this.livePlayerView = r100;
    }

    public final void setMSaveHeight(int r100) {
        this.mSaveHeight = r100;
    }

    public final void setMSaveWidth(int r100) {
        this.mSaveWidth = r100;
    }

    public final void setMSeiUpdateListener(com.bytedance.livesdk.preview.widgets.a r100) {
        this.mSeiUpdateListener = r100;
    }

    public final void setMultiLinkSeiUpdateListener(com.bytedance.livesdk.preview.widgets.a r100) {
        this.multiLinkSeiUpdateListener = r100;
    }

    public final void setPlayType(int r100) {
        this.playType = r100;
    }

    public final void setPlayerContainerAbility(LivePreviewPlayerContainerAbility r100) {
        this.playerContainerAbility = r100;
    }

    public final void setPlayerWidgetStartPreview(boolean r100) {
        this.playerWidgetStartPreview = r100;
    }

    public final void setPortraitForUI(boolean r100) {
        this.isPortraitForUI = r100;
    }

    public final void setShareTransitionDrawable(TransitionDrawable r100) {
        this.shareTransitionDrawable = r100;
    }
}

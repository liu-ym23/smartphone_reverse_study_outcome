package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.viewmodel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.mv.w;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicInterval;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.Error;
import id2.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u000289B%\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010.¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/efffectselect/viewmodel/EffectMusicSelectViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "", "updateAuditionState", "Landroid/content/Context;", "context", "initPlayerIfNeed", "onDialogDismiss", "initData", "", "getRequiredSongInfo", "requiredSongInfo", "updateRequiredSongInfo", "onSearchEnter", "onSearchExit", "onSearchReset", "clearSelectedSongList", "", "getAddSongLimitNum", "addSongLimitNum", "getCantSelectMoreToast", "panel", "tryApplyLink", "Lic0/a;", "favoriteCallback", "addFavorite", "delFavorite", "Lcom/bytedance/android/livesdkapi/model/ModeType;", "getModeType", "firstLevelTabDataValue", "syncSecondLevelTabBanner", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "onItemClick", "updateCurrentTabData", "updateMusicPanelState", "", "hasEnterSearchPage", "Z", "Lcom/ss/ttvideoengine/TTVideoEngine;", "mPlayer", "Lcom/ss/ttvideoengine/TTVideoEngine;", "mCurrentMusic", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "Ljava/lang/String;", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "orderedSongDataContext", "<init>", "(Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;)V", "Companion", "a", "EffectMusicSelectViewModelFactory", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EffectMusicSelectViewModel extends BaseOrderSongViewModel {
    public static final a Companion = null;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;
    public static final String TAG = "EffectMusicSelectViewModel";
    private boolean hasEnterSearchPage;
    private MusicPanel mCurrentMusic;
    private TTVideoEngine mPlayer;
    private String requiredSongInfo;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/efffectselect/viewmodel/EffectMusicSelectViewModel$EffectMusicSelectViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class EffectMusicSelectViewModelFactory implements ViewModelProvider.Factory {
        public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
        public final com.bytedance.android.live.ktv.common.search.viewmodel.a b;
        public final OrderedSongDataContext c;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final <T extends ViewModel> T create(Class<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "modelClass");
            if (r4.isAssignableFrom(EffectMusicSelectViewModel.class) == false) goto L7;
            return new EffectMusicSelectViewModel(this.a, this.b, this.c);
        L7:
            throw new IllegalArgumentException("Unknow ViewModel class: ".concat(r4.getName()));
        }

        public EffectMusicSelectViewModelFactory(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b extends w {
        public final /* synthetic */ EffectMusicSelectViewModel a;

        public b(EffectMusicSelectViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onCompletion(TTVideoEngine r2) {
            ALogger.d(EffectMusicSelectViewModel.TAG, "onCompletion");
        }

        public final void onError(Error r4) {
            StringBuilder r0 = new StringBuilder("onError:");
            String r1 = null;
            if (r4 == null) goto L5;
            Integer r2 = Integer.valueOf(r4.code);
        L6:
            r0.append(r2);
            r0.append('/');
            if (r4 == null) goto L9;
            r1 = r4.description;
        L9:
            r0.append(r1);
            ALogger.d(EffectMusicSelectViewModel.TAG, r0.toString());
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final void onPrepare(TTVideoEngine r2) {
            ALogger.d(EffectMusicSelectViewModel.TAG, "onPrepare");
        }

        public final void onPrepared(TTVideoEngine r7) {
            StringBuilder r0 = new StringBuilder("onPrepared: Duration:");
            if (r7 == null) goto L5;
            Integer r2 = Integer.valueOf(r7.getDuration());
        L6:
            r0.append(r2);
            ALogger.d(EffectMusicSelectViewModel.TAG, r0.toString());
            MusicPanel r1 = EffectMusicSelectViewModel.access$getMCurrentMusic$p(this.a);
            if (r1 == null) goto L18;
            KtvMusic r3 = r1.a;
            if (r3 == null) goto L19;
            List r4 = r3.getMMusicClimax();
            if (r4 == null) goto L20;
            MusicInterval r5 = (MusicInterval) CollectionsKt.firstOrNull(r4);
            if (r5 == null) goto L21;
            ALogger.d(EffectMusicSelectViewModel.TAG, "Climax Info -> startMs:" + r5.getStartMs() + " durationMs:" + r5.getDurationMs());
            if (r7 == null) goto L22;
            r7.seekTo((int) r5.getStartMs(), null);
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onCurrentPlaybackTimeUpdate(TTVideoEngine r10, int r11) {
            MusicPanel r0 = EffectMusicSelectViewModel.access$getMCurrentMusic$p(this.a);
            if (r0 == null) goto L23;
            KtvMusic r1 = r0.a;
            if (r1 == null) goto L24;
            List r2 = r1.getMMusicClimax();
            if (r2 == null) goto L25;
            MusicInterval r3 = (MusicInterval) CollectionsKt.firstOrNull(r2);
            if (r3 == null) goto L26;
            StringBuilder r4 = new StringBuilder("onCurrentPlaybackTimeUpdate duration:");
            if (r10 == null) goto L13;
            Integer r5 = Integer.valueOf(r10.getDuration());
        L14:
            r4.append(r5);
            r4.append(" currentPlaybackTime:");
            r4.append(r11);
            r4.append(" playLength from ");
            r4.append(r3.getStartMs());
            r4.append(" to ");
            r4.append(r3.getStartMs() + r3.getDurationMs());
            ALogger.d(EffectMusicSelectViewModel.TAG, r4.toString());
            long r6 = r11;
            if (r6 < (r3.getStartMs() + r3.getDurationMs())) goto L19;
            if (r10 == null) goto L27;
            r10.stop();
            return;
        L27:
            return;
        L19:
            if (r6 >= r3.getStartMs()) goto L29;
            if (r10 == null) goto L30;
            r10.seekTo((int) r3.getStartMs(), null);
            return;
        L30:
            return;
        L29:
            return;
        L13:
            r5 = null;
            goto L14
        L26:
            return;
        L25:
            return;
        L24:
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onLoadStateChanged(TTVideoEngine r2, int r3) {
            ALogger.d(EffectMusicSelectViewModel.TAG, "onLoadStateChanged loadState:" + r3 + ' ');
        }

        public final void onPlaybackStateChanged(TTVideoEngine r2, int r3) {
            ALogger.d(EffectMusicSelectViewModel.TAG, "onPlaybackStateChanged playbackState : " + r3);
            if (r3 != 0) goto L5;
        L14:
            MusicPanel r4 = EffectMusicSelectViewModel.access$getMCurrentMusic$p(this.a);
            if (r4 == null) goto L17;
            r4.k = 100;
        L17:
            this.a.updateCurrentTabData();
            return;
        L5:
            if (r3 != 2) goto L7;
            MusicPanel r5 = EffectMusicSelectViewModel.access$getMCurrentMusic$p(this.a);
            if (r5 == null) goto L17;
            r5.k = MonitorLevel.WARN;
            goto L17
        L7:
            if (r3 == 3) goto L14;
            MusicPanel r6 = EffectMusicSelectViewModel.access$getMCurrentMusic$p(this.a);
            if (r6 == null) goto L17;
            r6.k = 200;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public int getAddSongLimitNum() {
        return 1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void initData() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchEnter() {
        this.hasEnterSearchPage = true;
        TTVideoEngine r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchExit() {
        this.hasEnterSearchPage = false;
        TTVideoEngine r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void syncSecondLevelTabBanner(int r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchReset() {
        TTVideoEngine r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void clearSelectedSongList() {
        getSelfSelectedList().clear();
        getSelfDownloadList().clear();
        this.mCurrentMusic = null;
        TTVideoEngine r1 = this.mPlayer;
        if (r1 == null) goto L5;
        r1.stop();
    L5:
        TTVideoEngine r2 = this.mPlayer;
        if (r2 == null) goto L8;
        r2.release();
    L8:
        this.mPlayer = null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onDialogDismiss() {
        super.onDialogDismiss();
        TTVideoEngine r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        r0.release();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateCurrentTabData() {
        super.updateCurrentTabData();
        if (this.hasEnterSearchPage == false) goto L31;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r0 = getCommonSearchViewModel();
        if (r0 == null) goto L23;
        List r1 = r0.getSearchedMusicList();
        if (r1 == null) goto L23;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L24;
        MusicPanel r5 = (MusicPanel) r4.next();
        int r6 = 100;
        if (this.mCurrentMusic == null) goto L21;
        long r7 = r5.c();
        MusicPanel r8 = this.mCurrentMusic;
        if (r8 == null) goto L21;
        if (r7 != r8.c()) goto L21;
        MusicPanel r9 = this.mCurrentMusic;
        if (r9 == null) goto L20;
        r6 = r9.k;
    L20:
        r5.k = r6;
    L22:
        r3.add(r5);
    L21:
        r5.k = 100;
    L24:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r10 = getCommonSearchViewModel();
        if (r10 == null) goto L32;
        r10.updateSearchedMusicList(r3);
        return;
    L32:
        return;
    L23:
        r3 = null;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public ModeType getModeType() {
        return ModeType.MUSIC_EFFECT;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public String getRequiredSongInfo() {
        return this.requiredSongInfo;
    }

    public static final /* synthetic */ MusicPanel access$getMCurrentMusic$p(EffectMusicSelectViewModel r0) {
        return r0.mCurrentMusic;
    }

    private final void initPlayerIfNeed(Context r5) {
        if (this.mPlayer != null) goto L6;
        TTVideoEngine r0 = new TTVideoEngine(r5, 0);
        r0.setIntOption(4, 2);
        r0.setIntOption(7, 0);
        r0.setIntOption(160, 1);
        r0.setIntOption(21, 1);
        r0.setIntOption(602, MonitorLevel.WARN);
        r0.setIntOption(17, 0);
        r0.setRadioMode(true);
        r0.setVideoEngineCallback(new b(this));
        Unit r6 = Unit.INSTANCE;
        this.mPlayer = r0;
        return;
    }

    private final void updateAuditionState(MusicPanel r7) {
        int r1 = 100;
        if (this.mCurrentMusic == null) goto L12;
        long r2 = r7.c();
        MusicPanel r0 = this.mCurrentMusic;
        if (r0 == null) goto L12;
        if (r2 != r0.c()) goto L12;
        MusicPanel r3 = this.mCurrentMusic;
        if (r3 == null) goto L11;
        r1 = r3.k;
    L11:
        r7.k = r1;
        return;
    L12:
        r7.k = 100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public String getCantSelectMoreToast(int r1) {
        return s1.B(2131918437);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void tryApplyLink(MusicPanel r15) {
        Intrinsics.checkNotNullParameter(r15, "panel");
        Long r0 = KtvLoggerHelper.a;
        String r1 = String.valueOf(r15.a.getId());
        Intrinsics.checkNotNullParameter(r1, "songId");
        Intrinsics.checkNotNullParameter("music_effect", "enterFrom");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("song_id", r1);
        r2.put("enter_from", "music_effect");
        KtvLoggerHelper.A(r2);
        j0.l().sendLog("livesdk_interact_music_select_use_click", r2, new Object[]{IRoom.class});
        long r5 = r15.a.getId();
        String r3 = r15.a.getExtraJson();
        if (r3 != null) goto L5;
        String r7 = "";
    L6:
        String r8 = r15.n;
        String r9 = r15.o;
        String r10 = r15.q;
        String r11 = r15.l;
        int r12 = r15.a.getMLyricType();
        String r16 = r15.a.getMNewCoverUrl();
        if (r16 != null) goto L9;
        String r13 = "";
    L10:
        xs2.b.a().post(new c(r5, r7, r8, r9, r10, r11, r12, r13));
        return;
    L9:
        r13 = r16;
        goto L10
    L5:
        r7 = r3;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateMusicPanelState(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        super.updateMusicPanelState(r2);
        updateAuditionState(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateRequiredSongInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requiredSongInfo");
        this.requiredSongInfo = r2;
    }

    public static final /* synthetic */ void access$setMCurrentMusic$p(EffectMusicSelectViewModel r0, MusicPanel r1) {
        r0.mCurrentMusic = r1;
    }

    public EffectMusicSelectViewModel(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
        super(r1, r2, r3);
        this.requiredSongInfo = "";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onItemClick(Context r7, MusicPanel r8, RecyclerView.ViewHolder r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "musicPanel");
        initPlayerIfNeed(r7);
        MusicPanel r10 = this.mCurrentMusic;
        Long r1 = null;
        if (r10 != null) goto L21;
        MusicPanel r11 = MusicPanel.a(r8);
        this.mCurrentMusic = r11;
        r11.k = 200;
        TTVideoEngine r12 = this.mPlayer;
        if (r12 == null) goto L11;
        AudioInfo r13 = r8.a.getMFullTrack();
        if (r13 == null) goto L9;
        String r14 = r13.getMUrl();
    L10:
        r12.setDirectURL(r14);
        goto L11
    L9:
        r14 = null;
    L11:
        TTVideoEngine r15 = this.mPlayer;
        if (r15 == null) goto L14;
        r15.play();
    L14:
        MusicPanel r16 = this.mCurrentMusic;
        if (r16 == null) goto L19;
        KtvMusic r17 = r16.a;
        if (r17 == null) goto L19;
        r1 = Long.valueOf(r17.getId());
    L19:
        String r18 = String.valueOf(r1);
        Long r19 = KtvLoggerHelper.a;
        KtvLoggerHelper.M("trail", r18);
    L67:
        updateCurrentTabData();
        return;
    L21:
        if (r10.c() == r8.c()) goto L44;
        MusicPanel r20 = this.mCurrentMusic;
        if (r20 == null) goto L25;
        r20.k = 100;
    L25:
        MusicPanel r21 = MusicPanel.a(r8);
        this.mCurrentMusic = r21;
        r21.k = 200;
        TTVideoEngine r22 = this.mPlayer;
        if (r22 == null) goto L28;
        r22.stop();
    L28:
        TTVideoEngine r23 = this.mPlayer;
        if (r23 == null) goto L35;
        AudioInfo r24 = r8.a.getMFullTrack();
        if (r24 == null) goto L33;
        String r25 = r24.getMUrl();
    L34:
        r23.setDirectURL(r25);
        goto L35
    L33:
        r25 = null;
    L35:
        TTVideoEngine r26 = this.mPlayer;
        if (r26 == null) goto L38;
        r26.play();
    L38:
        MusicPanel r27 = this.mCurrentMusic;
        if (r27 == null) goto L43;
        KtvMusic r28 = r27.a;
        if (r28 == null) goto L43;
        r1 = Long.valueOf(r28.getId());
    L43:
        String r29 = String.valueOf(r1);
        Long r30 = KtvLoggerHelper.a;
        KtvLoggerHelper.M("trail", r29);
        goto L67
    L44:
        TTVideoEngine r31 = this.mPlayer;
        if (r31 != null) goto L47;
    L61:
        MusicPanel r32 = this.mCurrentMusic;
        if (r32 == null) goto L64;
        r32.k = 200;
    L64:
        TTVideoEngine r33 = this.mPlayer;
        if (r33 == null) goto L67;
        r33.play();
        goto L67
    L47:
        if (r31.isStarted() != true) goto L61;
        MusicPanel r34 = this.mCurrentMusic;
        if (r34 == null) goto L61;
        if (r34.k != 200) goto L61;
        r34.k = MonitorLevel.WARN;
        TTVideoEngine r35 = this.mPlayer;
        if (r35 == null) goto L55;
        r35.pause();
    L55:
        MusicPanel r36 = this.mCurrentMusic;
        if (r36 == null) goto L60;
        KtvMusic r37 = r36.a;
        if (r37 == null) goto L60;
        r1 = Long.valueOf(r37.getId());
    L60:
        String r38 = String.valueOf(r1);
        Long r39 = KtvLoggerHelper.a;
        KtvLoggerHelper.M("pause", r38);
        goto L67
    }

    @JvmStatic
    public static final d newInstance(ViewModelStoreOwner r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4, OrderedSongDataContext r5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
        return new ViewModelProvider(r2, new EffectMusicSelectViewModelFactory(r3, r4, r5)).get(EffectMusicSelectViewModel.class);
    }

    @JvmStatic
    public static final d newInstance(Fragment r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.live.ktv.common.search.viewmodel.a r3, OrderedSongDataContext r4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return ViewModelProviders.of(r1, new EffectMusicSelectViewModelFactory(r2, r3, r4)).get(EffectMusicSelectViewModel.class);
    }
}

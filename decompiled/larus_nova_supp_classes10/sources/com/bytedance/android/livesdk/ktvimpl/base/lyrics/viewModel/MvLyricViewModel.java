package com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvBaseLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.model.KtvLabelTextConfig;
import com.bytedance.android.livesdkapi.model.KtvLyricText;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import fd2.s;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import ub0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J'\u0010\f\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nH\u0002J&\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u0013H\u0002J\u0014\u0010\u0019\u001a\u00020\u00152\n\u0010\u0004\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u0014\u0010\u001a\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0017j\u0002`\u0018H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J+\u0010\"\u001a\u00020\u00052!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001cH\u0002J\f\u0010$\u001a\u00020\u0015*\u00020#H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0002J\u0012\u0010+\u001a\f\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010)H\u0014J\b\u0010,\u001a\u00020\u0005H\u0014J\u0006\u0010-\u001a\u00020\u0005J\u000e\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.J&\u00101\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u0013H\u0016J\u0016\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015J\u0006\u00105\u001a\u00020\u001dJ\u000e\u00106\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u000207H\u0016J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%J\u0018\u0010>\u001a\u00020\u00052\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0016R\u0016\u0010?\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR%\u0010S\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010@R\u0014\u0010X\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010@R\u0014\u0010Y\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010@R\u0018\u0010Z\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010@R \u0010^\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0017\u0010a\u001a\u00020`8\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010j\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i¨\u0006m"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/MvLyricViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "toState", "", "onPreparing", "", "", "prepareHints", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "currentMusic", "checkHighSongTips", "([Ljava/lang/String;Lcom/bytedance/android/livesdk/message/model/KtvMusic;)V", "music", "checkPrepareHint", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "transition", "", "isDifferentSongSingState", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$f;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/SingState;", "checkMidiAvailable", "checkLyricAvalable", "getPublicFirstOrderedSong", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "time", "countDownCb", "startCountDown", "", "notZero", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "seiCompat", "", "getRealLyricProgress", "Ljava/lang/Class;", "Lcom/bytedance/live/datacontext/DataContext;", "provideDataService", "onCleared", "releaseLyricRes", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvBaseLyricPresenter;", "lyricPresenter", "setLyricControlPresenter", "handleStateChange", "noMidi", "hasLyric", "inferTips", "getMyOrder", "isSinger", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "onSeiResult", "handleLyricSei", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicList", "onMusicListChange", "hasRelease", "Z", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvMvLyricPresenter;", "mLyricPresenter", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvMvLyricPresenter;", "getMLyricPresenter", "()Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvMvLyricPresenter;", "setMLyricPresenter", "(Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvMvLyricPresenter;)V", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "lyricResourceManager", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "getLyricResourceManager", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "setLyricResourceManager", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;)V", "Lio/reactivex/disposables/Disposable;", "prepareCountDownDisposable", "Lio/reactivex/disposables/Disposable;", "Landroidx/lifecycle/MutableLiveData;", "lyricPlaceHolderData", "Landroidx/lifecycle/MutableLiveData;", "getLyricPlaceHolderData", "()Landroidx/lifecycle/MutableLiveData;", "singRecordConfig", "enalbeCallbackCheck", "enalbeParseFix", "currentState", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "lyricReleaseEnable", "Lub0/d;", "lyricFectchResultListener", "Lkotlin/jvm/functions/Function1;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/a;", "lyricContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/a;", "getLyricContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/a;", "getCurrentIsSinger", "()Z", "currentIsSinger", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/a;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvLyricViewModel extends AbsKWidgetViewModel implements b {
    private KtvRoomLyricsStateMachineConfig.d currentState;
    private final boolean enalbeCallbackCheck;
    private final boolean enalbeParseFix;
    private boolean hasRelease;
    private final com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a lyricContext;
    private final Function1<d, Unit> lyricFectchResultListener;
    private final MutableLiveData<String[]> lyricPlaceHolderData;
    private final boolean lyricReleaseEnable;
    private h lyricResourceManager;
    private KtvMvLyricPresenter mLyricPresenter;
    private Disposable prepareCountDownDisposable;
    private boolean singRecordConfig;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MvLyricViewModel a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Function1 c;

        public a(MvLyricViewModel r1, Ref.IntRef r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Ref.IntRef r4 = this.b;
            int r0 = r4.element;
            if (r0 > 0) goto L7;
            Disposable r5 = MvLyricViewModel.access$getPrepareCountDownDisposable$p(this.a);
            if (r5 == null) goto L9;
            r5.dispose();
            return;
        L9:
            return;
        L7:
            int r1 = r0 - 1;
            r4.element = r1;
            this.c.invoke(Integer.valueOf(r1));
        }
    }

    private final boolean notZero(float r5) {
        double r0 = r5;
        if (r0 <= 1.0E-6d) goto L5;
    L8:
        return true;
    L5:
        if (r0 < (-1.0E-6d)) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public Class<? extends DataContext> provideDataService() {
        return null;
    }

    private final boolean getCurrentIsSinger() {
        return this.lyricContext.a();
    }

    private final String getCurrentUserId() {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        e r1 = r0.user();
        if (r1 == null) goto L9;
        String r2 = r1.n();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    private final KtvMusic getPublicFirstOrderedSong() {
        MusicPanel r0 = this.lyricContext.j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final int getMyOrder() {
        List<SongUniqueInfo> r0 = this.lyricContext.c();
        if (r0 == null) goto L17;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r3 = r1.next();
        if (((SongUniqueInfo) r3).isPublic() == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((SongUniqueInfo) r4.next()).getUserId(), getCurrentUserId()) == true) goto L25;
        r5 = r5 + 1;
        goto L12
    L25:
        return r5;
    L26:
        return -1;
    L17:
        return -1;
    }

    public final void releaseLyricRes() {
        KtvMvLyricPresenter r0 = this.mLyricPresenter;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        h r1 = this.lyricResourceManager;
        if (r1 == null) goto L8;
        r1.g = -1;
    L8:
        if (r1 == null) goto L10;
        h.a(r1);
    L10:
        h r2 = this.lyricResourceManager;
        if (r2 == null) goto L14;
        r2.q = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public void onCleared() {
        super.onCleared();
        releaseLyricRes();
        KtvMvLyricPresenter r0 = this.mLyricPresenter;
        if (r0 == null) goto L11;
        r0.e();
        if (((Boolean) KtvSettingHelper.l1.getValue()).booleanValue() == false) goto L10;
        wd2.a r2 = r0.l;
        if (r2 == null) goto L9;
        r2.b = null;
    L9:
        r0.l = null;
    L10:
        r0.i.dispose();
    L11:
        h r1 = this.lyricResourceManager;
        if (r1 == null) goto L15;
        r1.q = null;
        return;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a getLyricContext() {
        return this.lyricContext;
    }

    public final MutableLiveData<String[]> getLyricPlaceHolderData() {
        return this.lyricPlaceHolderData;
    }

    public final h getLyricResourceManager() {
        return this.lyricResourceManager;
    }

    public final KtvMvLyricPresenter getMLyricPresenter() {
        return this.mLyricPresenter;
    }

    public MvLyricViewModel(com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "lyricContext");
        this.lyricContext = r6;
        if (KtvSettingHelper.w() == false) goto L8;
        KtvContext r0 = r6.b();
        if (r0 == null) goto L7;
        h r1 = r0.getLyricResourceManager();
    L9:
        this.lyricResourceManager = r1;
        this.lyricPlaceHolderData = new MutableLiveData();
        this.singRecordConfig = vm2.d.Z();
        ReadOnlyProperty r2 = vm2.h.v4;
        KProperty[] r3 = vm2.h.a;
        this.enalbeCallbackCheck = ((Boolean) r2.getValue(null, r3[280(0x118, float:3.92E-43)])).booleanValue();
        this.enalbeParseFix = ((Boolean) vm2.d.f5.getValue(null, vm2.d.a[315(0x13b, float:4.41E-43)])).booleanValue();
        this.lyricReleaseEnable = ((Boolean) vm2.h.u4.getValue(null, r3[279(0x117, float:3.91E-43)])).booleanValue();
        Function1<d, Unit> r4 = new MvLyricViewModel$lyricFectchResultListener$1(this);
        this.lyricFectchResultListener = r4;
        r6.m(this);
        h r7 = this.lyricResourceManager;
        if (r7 == null) goto L13;
        r7.q = r4;
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L9
    L8:
        r1 = new h(r6.b());
        goto L9
    }

    public static final /* synthetic */ KtvRoomLyricsStateMachineConfig.d access$getCurrentState$p(MvLyricViewModel r0) {
        return r0.currentState;
    }

    public static final /* synthetic */ boolean access$getEnalbeCallbackCheck$p(MvLyricViewModel r0) {
        return r0.enalbeCallbackCheck;
    }

    public static final /* synthetic */ Disposable access$getPrepareCountDownDisposable$p(MvLyricViewModel r0) {
        return r0.prepareCountDownDisposable;
    }

    public static final /* synthetic */ KtvMusic access$getPublicFirstOrderedSong(MvLyricViewModel r0) {
        return r0.getPublicFirstOrderedSong();
    }

    private final void checkLyricAvalable(KtvRoomLyricsStateMachineConfig.d.f r9) {
        MusicPanel r0 = r9.b();
        Long r1 = null;
        if (r0 == null) goto L5;
        KtvMusic r2 = r0.a;
    L6:
        boolean r3 = checkMidiAvailable(r9);
        if (r2 == null) goto L14;
        List r5 = r2.getMLyricUrlList();
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L15:
        KtvMusic r7 = getPublicFirstOrderedSong();
        if (r7 == null) goto L18;
        Long r8 = Long.valueOf(r7.getMId());
    L19:
        if (r2 == null) goto L22;
        r1 = Long.valueOf(r2.getMId());
    L22:
        if (Intrinsics.areEqual(r8, r1) == false) goto L25;
        inferTips(r3, r6);
        return;
    L25:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r10 = r9.c;
        if (r10 != null) goto L28;
    L59:
        if (r6 == true) goto L63;
        KtvMvLyricPresenter r11 = this.mLyricPresenter;
        if (r11 == null) goto L63;
        r11.e();
    L63:
        inferTips(r3, r6);
        return;
    L28:
        if (KtvSettingHelper.w() == false) goto L43;
        if (r10.d() != 1) goto L33;
    L50:
        r6 = true;
    L51:
        String r12 = r10.t();
        if (r12 == null) goto L59;
        if (r12.length() <= 0) goto L56;
        boolean r13 = true;
    L57:
        if (r13 != true) goto L59;
        r3 = false;
        goto L59
    L56:
        r13 = false;
        goto L57
    L33:
        if (r10.p() != null) goto L40;
        List<v> r4 = r10.l();
        if (r4 != null) goto L37;
    L39:
        boolean r14 = false;
    L41:
        r6 = r14;
        goto L51
    L37:
        if ((!r4.isEmpty()) != true) goto L39;
    L40:
        r14 = true;
        goto L41
    L43:
        if (r10.p() != null) goto L50;
        List<v> r15 = r10.l();
        if (r15 != null) goto L47;
    L49:
        r6 = false;
        goto L51
    L47:
        if ((!r15.isEmpty()) != true) goto L49;
    L18:
        r8 = null;
        goto L19
    L11:
        if ((!r5.isEmpty()) != true) goto L13;
    L14:
        r6 = true;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private final boolean checkMidiAvailable(KtvRoomLyricsStateMachineConfig.d.f r4) {
        KtvMusic r0 = getPublicFirstOrderedSong();
        if (r0 != null) goto L9;
        MusicPanel r1 = r4.b();
        if (r1 == null) goto L7;
        r0 = r1.a;
        goto L9
    L7:
        r0 = null;
    L9:
        if (r0 == null) goto L19;
        String r5 = r0.getMidiUrl();
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.length() != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 != true) goto L31;
        return true;
    L31:
        return false;
    L15:
        r6 = false;
        goto L16
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r7 = r4.c;
        if (r7 == null) goto L32;
        String r8 = r7.t();
        if (r8 != null) goto L24;
        return false;
    L24:
        if (r8.length() != 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 != true) goto L34;
        return true;
    L34:
        return false;
    L26:
        r9 = false;
        goto L27
    L32:
        return false;
    }

    private final void checkPrepareHint(KtvMusic r6) {
        String[] r0 = {"", ""};
        r0[0] = s1.C(2131918564, new Object[]{r6.getMTitle()});
        checkHighSongTips(r0, r6);
        KtvMusic r2 = getPublicFirstOrderedSong();
        if (r2 != null) goto L5;
        return;
    L5:
        if (KtvUtilsKt.t(r2, r6) != true) goto L12;
        int r7 = getMyOrder();
        if (r7 <= 0) goto L9;
        r0[1] = s1.C(2131918565, new Object[]{Integer.valueOf(r7)});
    L9:
        this.lyricPlaceHolderData.setValue(r0);
        return;
    }

    private final long getRealLyricProgress(com.bytedance.android.livesdk.ktvimpl.base.sei.k r8) {
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        RealTimeChorusBusinessContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        j<s> r2 = r1.m454getService();
        if (r2 == null) goto L9;
        s r3 = (s) r2.getValue();
        if (r3 == null) goto L9;
        long r4 = r3.Qm();
    L10:
        long r5 = (long) ((r8.y() + r8.m()) * 1000.0f);
        if (RealTimeChorusBusinessContext.a.g() == false) goto L18;
        if (r0.j() == false) goto L18;
        if (r4 <= 1000) goto L18;
        return r4;
    L18:
        return r5;
    L9:
        r4 = 0;
        goto L10
    }

    private final boolean isDifferentSongSingState(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r6) {
        if (this.lyricReleaseEnable == false) goto L56;
        Object r7 = r6.c;
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L58;
        KtvMvLyricPresenter r0 = this.mLyricPresenter;
        String r1 = null;
        if (r0 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.o;
    L11:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L13;
        return false;
    L13:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L15;
        r7 = null;
    L15:
        KtvRoomLyricsStateMachineConfig.d.f r8 = (KtvRoomLyricsStateMachineConfig.d.f) r7;
        if (r0 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r3 = r0.o;
    L20:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L22;
        r3 = null;
    L22:
        KtvRoomLyricsStateMachineConfig.d.f r4 = (KtvRoomLyricsStateMachineConfig.d.f) r3;
        if (r8 == null) goto L29;
        MusicPanel r5 = r8.b;
        if (r5 == null) goto L29;
        KtvMusic r9 = r5.a;
        if (r9 == null) goto L29;
        Long r10 = Long.valueOf(r9.getMId());
    L30:
        if (r4 == null) goto L36;
        MusicPanel r11 = r4.b;
        if (r11 == null) goto L36;
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L36;
        Long r13 = Long.valueOf(r12.getMId());
    L38:
        if ((!Intrinsics.areEqual(r10, r13)) == false) goto L60;
        StringBuilder r14 = new StringBuilder("@@isDifferentSingState::");
        if (r8 == null) goto L46;
        MusicPanel r15 = r8.b;
        if (r15 == null) goto L46;
        KtvMusic r16 = r15.a;
        if (r16 == null) goto L46;
        String r17 = r16.getMTitle();
    L47:
        r14.append(r17);
        r14.append("--:");
        if (r4 == null) goto L54;
        MusicPanel r18 = r4.b;
        if (r18 == null) goto L54;
        KtvMusic r19 = r18.a;
        if (r19 == null) goto L54;
        r1 = r19.getMTitle();
    L54:
        r14.append(r1);
        ALogger.i("mv_lyric-handleStateChange", r14.toString());
        return true;
    L46:
        r17 = null;
        goto L47
    L60:
        return false;
    L36:
        r13 = null;
    L29:
        r10 = null;
        goto L30
    L18:
        r3 = null;
        goto L20
    L9:
        r2 = null;
        goto L11
    L58:
        return false;
    L56:
        return false;
    }

    private final void onPreparing(final KtvRoomLyricsStateMachineConfig.d r8) {
        KtvMvLyricPresenter r0 = this.mLyricPresenter;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        MusicPanel r2 = r8.b();
        Object r3 = null;
        if (r2 == null) goto L8;
        KtvMusic r4 = r2.a;
    L9:
        r1.element = r4;
        if (this.lyricContext.i() == false) goto L36;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r5 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvMusic r6 = (KtvMusic) r1.element;
        r5.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r6) == false) goto L36;
        final MusicPanel r9 = r8.b();
        final String[] r7 = {"", ""};
        KtvMusic r10 = (KtvMusic) r1.element;
        if (r10 == null) goto L17;
        r3 = r10.getMTitle();
    L17:
        r7[0] = s1.C(2131918564, new Object[]{r3});
        KtvMusic r11 = (KtvMusic) r1.element;
        if (r11 != null) goto L20;
        return;
    L20:
        if (this.enalbeParseFix == true) goto L25;
        h r12 = this.lyricResourceManager;
        if (r12 == null) goto L25;
        r12.c(r11, new MvLyricViewModel$onPreparing$$inlined$let$lambda$2(this, r9, r7, r1));
    L25:
        if (isSinger(r11) == false) goto L29;
        if (r9 == null) goto L56;
        checkHighSongTips(r7, (KtvMusic) r1.element);
        startCountDown(new MvLyricViewModel$onPreparing$$inlined$let$lambda$3(this, r9, r7, r1));
        return;
    L56:
        return;
    L29:
        if (this.enalbeParseFix == false) goto L33;
        h r13 = this.lyricResourceManager;
        if (r13 == null) goto L33;
        r13.c(r11, new MvLyricViewModel$onPreparing$$inlined$let$lambda$4(this, r9, r7, r1));
    L33:
        checkPrepareHint(r11);
        return;
    L36:
        if (KtvSettingHelper.w() == false) goto L58;
        KtvMusic r14 = getPublicFirstOrderedSong();
        KtvMusic r15 = (KtvMusic) r1.element;
        if (r15 == null) goto L40;
        Long r16 = Long.valueOf(r15.getMId());
    L41:
        if (r14 == null) goto L44;
        r3 = Long.valueOf(r14.getMId());
    L44:
        if (Intrinsics.areEqual(r16, r3) == false) goto L49;
        if (r14 != null) goto L47;
    L48:
        r1.element = r14;
        goto L49
    L47:
        if (r14.getMId() != 0) goto L48;
    L49:
        KtvMusic r17 = (KtvMusic) r1.element;
        if (r17 == null) goto L59;
        h r18 = this.lyricResourceManager;
        if (r18 == null) goto L60;
        r18.c(r17, new MvLyricViewModel$onPreparing$$inlined$let$lambda$1(this, r8));
        return;
    L60:
        return;
    L59:
        return;
    L40:
        r16 = null;
        goto L41
    L58:
        return;
    L8:
        r4 = null;
        goto L9
    }

    private final void startCountDown(Function1<? super Integer, Unit> r5) {
        Disposable r0 = this.prepareCountDownDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = 5;
        this.prepareCountDownDisposable = RxUtilKt.h(du2.a.d(1, TimeUnit.SECONDS)).subscribe(new a(this, r1, r5));
    }

    public final void handleLyricSei(com.bytedance.android.livesdk.ktvimpl.base.sei.k r10) {
        Intrinsics.checkNotNullParameter(r10, "seiCompat");
        if (getCurrentIsSinger() == false) goto L11;
        KtvMvLyricPresenter r11 = this.mLyricPresenter;
        if (r11 == null) goto L94;
        wd2.a r12 = r11.l;
        if (r12 == null) goto L95;
        r12.e();
        return;
    L95:
        return;
    L94:
        return;
    L11:
        if (notZero(r10.y()) == false) goto L21;
        long r0 = getRealLyricProgress(r10);
        KtvMvLyricPresenter r2 = this.mLyricPresenter;
        if (r2 == null) goto L21;
        r2.b = r0;
        wd2.a r3 = r2.l;
        if (r3 != null) goto L17;
    L20:
        r2.a.renderLyricsByPlayTime(r0);
        goto L21
    L17:
        if (r3.e == false) goto L20;
        r3.a(r0);
    L21:
        KtvMvLyricPresenter r1 = this.mLyricPresenter;
        if (r1 == null) goto L27;
        ub0.a r4 = r1.p;
        if (r4 == null) goto L27;
        if (r4.a != r10.j()) goto L27;
    L58:
        if (KtvSettingHelper.w() == false) goto L96;
        KtvContext r5 = this.lyricContext.b();
        if (r5 == null) goto L66;
        n<c> r6 = r5.getKtvCoreViewModel();
        if (r6 == null) goto L66;
        c r7 = (c) r6.getValue();
        if (r7 == null) goto L66;
        KtvRoomLyricsStateMachineConfig.d r8 = r7.getCurState();
    L68:
        if (this.hasRelease == true) goto L89;
        if (r10.d() != 1) goto L89;
        if (r10.C() != 0) goto L89;
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L76;
    L77:
        this.hasRelease = true;
        KtvMvLyricPresenter r13 = this.mLyricPresenter;
        if (r13 == null) goto L80;
        r13.e();
    L80:
        Disposable r14 = this.prepareCountDownDisposable;
        if (r14 == null) goto L86;
        if (r14.isDisposed() == true) goto L86;
        r14.dispose();
    L86:
        if (this.lyricPlaceHolderData.getValue() == null) goto L97;
        this.lyricPlaceHolderData.setValue(null);
        return;
    L97:
        return;
    L76:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L77;
    L89:
        if (r10.d() == 1) goto L91;
        return;
    L91:
        if (r10.C() == 0) goto L100;
        this.hasRelease = false;
        return;
    L100:
        return;
    L66:
        r8 = null;
        goto L68
    L96:
        return;
    L27:
        h r9 = this.lyricResourceManager;
        if (r9 == null) goto L58;
        Intrinsics.checkNotNullParameter(r10, "sei");
        if (Intrinsics.areEqual(r10.A(), r9.i) == true) goto L58;
        int r15 = r10.d();
        if (r15 == 0) goto L43;
        if (r15 == 1) goto L43;
        if (r15 == 3) goto L43;
        if (r15 == 4) goto L43;
        if (r15 != 5) goto L58;
    L43:
        if (r10.j() <= 0) goto L58;
        String r16 = r10.p();
        if (r16 != null) goto L47;
    L50:
        boolean r17 = true;
    L51:
        if (r17 == true) goto L58;
        if (r10.n() <= 0) goto L58;
        if (r10.j() == r9.g) goto L58;
        String r18 = r10.p();
        Intrinsics.checkNotNull(r18);
        r9.b(r18, r10.j(), r10.n(), r9.o);
        r9.g = r10.j();
        goto L58
    L47:
        if (r16.length() == 0) goto L50;
        r17 = false;
        goto L51
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void handleStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r22) {
        Intrinsics.checkNotNullParameter(r22, "transition");
        final KtvRoomLyricsStateMachineConfig.d r8 = (KtvRoomLyricsStateMachineConfig.d) r22.c;
        this.currentState = r8;
        KtvMvLyricPresenter r2 = this.mLyricPresenter;
        Integer r9 = null;
        if (r2 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.o;
    L6:
        final boolean r6 = isDifferentSongSingState(r22);
        KtvMvLyricPresenter r4 = this.mLyricPresenter;
        if (r4 == null) goto L9;
        r4.f(r8);
    L9:
        MusicPanel r5 = r8.b();
        if (r5 == null) goto L12;
        KtvMusic r7 = r5.a;
    L13:
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r7) == true) goto L20;
        KtvMvLyricPresenter r10 = this.mLyricPresenter;
        if (r10 == null) goto L19;
        r10.e();
    L19:
        this.lyricPlaceHolderData.setValue(null);
    L20:
        boolean r11 = false;
        if (r3 == null) goto L43;
        KtvRoomLyricsStateMachineConfig.a.getClass();
        Intrinsics.checkNotNullParameter(r22, "transition");
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r22.a).getClass(), ((KtvRoomLyricsStateMachineConfig.d) r22.c).getClass()) == false) goto L43;
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L42;
        Intrinsics.checkNotNullParameter(r22, "transition");
        Object r1 = r22.a;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L29;
        r1 = null;
    L29:
        KtvRoomLyricsStateMachineConfig.d.c r12 = (KtvRoomLyricsStateMachineConfig.d.c) r1;
        Object r13 = r22.c;
        if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L32;
        r13 = null;
    L32:
        KtvRoomLyricsStateMachineConfig.d.c r14 = (KtvRoomLyricsStateMachineConfig.d.c) r13;
        if (r14 == null) goto L40;
        if (r12 == null) goto L40;
        KtvMusic r15 = r12.b.a;
        KtvMusic r16 = r14.b.a;
        if (r15.getMId() != r16.getMId()) goto L40;
        if (Intrinsics.areEqual(r15.getOrderUserIdString(), r16.getOrderUserIdString()) == false) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == true) goto L43;
    L40:
        r17 = false;
    L42:
        if (r6 == true) goto L43;
    L186:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L243;
        KtvRoomLyricsStateMachineConfig.d.f r18 = (KtvRoomLyricsStateMachineConfig.d.f) r8;
        if (isSinger(r18.b.a) == false) goto L199;
        KtvMvLyricPresenter r0 = this.mLyricPresenter;
        if (r0 == null) goto L192;
        KtvRoomLyricsStateMachineConfig.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "$this$getSingProgress");
        r0.i(r18.d.a);
    L192:
        KtvMvLyricPresenter r19 = this.mLyricPresenter;
        if (r19 == null) goto L253;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r20 = r19.a;
        if (r20 == null) goto L197;
        r9 = Integer.valueOf(r20.getCurrentIndex());
    L197:
        if (r9 == null) goto L254;
        this.lyricContext.g(r9.intValue());
        return;
    L254:
        return;
    L253:
        return;
    L199:
        KtvMvLyricPresenter r21 = this.mLyricPresenter;
        if (r21 == null) goto L204;
        wd2.a r23 = r21.l;
        if (r23 == null) goto L204;
        r23.e = true;
    L204:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r24 = r18.c;
        if (r24 == null) goto L256;
        if (r21 == null) goto L257;
        Intrinsics.checkNotNullParameter(r24, "seiModelCompat");
        r21.d(r24.d());
        if (KtvSettingHelper.z() == true) goto L210;
    L212:
        String r25 = bb0.b.b().concat("-lyric");
        ALogger.i(r25, ("processLyricSeiResult:" + r24) + ", invoke class :" + KtvMvLyricPresenter.class.getSimpleName());
        List<v> r26 = r24.l();
        if (r26 == null) goto L258;
        int r27 = r24.n();
        r21.a.getDisplayConfig().n = r27;
        Iterator<v> r28 = r26.iterator();
    L216:
        if (r28.hasNext() == false) goto L260;
        v r29 = r28.next();
        String r30 = "";
        if (r27 != 2) goto L229;
        new lg4.b();
        TreeMap r31 = new TreeMap();
        String r32 = r29.a();
        if (r32 == null) goto L223;
        r30 = r32;
    L223:
        lg4.b.c(r31, r30);
        Iterator r33 = r31.keySet().iterator();
        if (r33 != null) goto L226;
    L235:
        com.bytedance.component.lyric.model.b r34 = null;
    L236:
        if (r34 == null) goto L216;
        int r35 = r29.b();
        Intrinsics.checkNotNullParameter(r34, "lyricsLineInfo");
        if (r21.e == true) goto L216;
        if (r21.q.contains(Integer.valueOf(r35)) == true) goto L216;
        r21.a.adjustAddLyricsLine(r34, true);
        r21.q.add(Integer.valueOf(r35));
        goto L216
    L226:
        if (r33.hasNext() != true) goto L235;
        r34 = (com.bytedance.component.lyric.model.b) r31.get(r33.next());
        goto L236
    L229:
        if (r27 != 3) goto L235;
        lg4.a r36 = new lg4.a();
        String r37 = r29.a();
        if (r37 == null) goto L234;
        r30 = r37;
    L234:
        r34 = r36.b(r30);
        goto L236
    L260:
        return;
    L258:
        return;
    L210:
        if (r21.e == false) goto L212;
        return;
    L257:
        return;
    L256:
        return;
    L243:
        return;
    L43:
        String r38 = bb0.b.b().concat("-lyric");
        ALogger.i(r38, ("handleStateChange " + r8) + ", invoke class :MvLyricViewModel");
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L53;
        KtvMvLyricPresenter r39 = this.mLyricPresenter;
        if (r39 == null) goto L48;
        r39.e();
    L48:
        Disposable r40 = this.prepareCountDownDisposable;
        if (r40 == null) goto L51;
        r40.dispose();
    L51:
        this.lyricPlaceHolderData.setValue(null);
        goto L186
    L53:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L62;
        KtvMvLyricPresenter r41 = this.mLyricPresenter;
        if (r41 == null) goto L57;
        r41.e();
    L57:
        Disposable r42 = this.prepareCountDownDisposable;
        if (r42 == null) goto L60;
        r42.dispose();
    L60:
        this.lyricPlaceHolderData.setValue(null);
        goto L186
    L62:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L65;
        onPreparing(r8);
        goto L186
    L65:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L121;
        if (getCurrentIsSinger() == true) goto L71;
        KtvMvLyricPresenter r43 = this.mLyricPresenter;
        if (r43 == null) goto L71;
        r43.d(4);
    L71:
        MusicPanel r44 = r8.b();
        if (r44 == null) goto L75;
        KtvMusic r45 = r44.a;
        if (r45 == null) goto L75;
    L76:
        final KtvMusic r110 = r45;
        String r46 = bb0.b.b().concat("-lyric-mv_lyric");
        ALogger.i(r46, ("PausedState ，music : " + r110) + ", invoke class :MvLyricViewModel");
        if (r110 == null) goto L186;
        if (this.enalbeParseFix == true) goto L81;
    L102:
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), "music不为空，getLyricResultEvent, invoke class :KtvMusic");
        KtvMvLyricPresenter r47 = this.mLyricPresenter;
        if (r47 == null) goto L105;
        ub0.a r48 = r47.p;
    L107:
        if (this.enalbeCallbackCheck == false) goto L117;
        if (r48 == null) goto L117;
        if (r48.a != r110.getMId()) goto L117;
        if ((r48 instanceof ub0.a.b) == false) goto L117;
        KtvMvLyricPresenter r49 = this.mLyricPresenter;
        if (r49 == null) goto L116;
        r49.c(r48);
    L116:
        pd2.d r50 = pd2.d.n;
        List r51 = ((ub0.a.b) r48).b;
        r50.getClass();
        pd2.d.C(r51, r110);
    L117:
        h r111 = this.lyricResourceManager;
        if (r111 == null) goto L186;
        r111.c(r110, new MvLyricViewModel$handleStateChange$$inlined$run$lambda$1(r110, this, r8, r110, r6));
        goto L186
    L105:
        r48 = null;
        goto L107
    L81:
        if (isSinger(r110) == false) goto L102;
        KtvRoomLyricsStateMachineConfig.d.C0041d r52 = (KtvRoomLyricsStateMachineConfig.d.C0041d) r8;
        KtvRoomLyricsStateMachineConfig.c r53 = r52.c;
        if (r53 == null) goto L102;
        List<com.bytedance.component.lyric.model.b> r54 = r53.c;
        if (r54 == null) goto L102;
        if (r54.size() <= 0) goto L89;
        r11 = true;
    L89:
        if (r11 == false) goto L91;
        List<com.bytedance.component.lyric.model.b> r112 = r54;
    L92:
        if (r112 == null) goto L102;
        KtvMvLyricPresenter r55 = this.mLyricPresenter;
        if (r55 == null) goto L100;
        long r113 = r110.getMId();
        int r114 = r110.getMLyricType();
        KtvRoomLyricsStateMachineConfig.c r56 = r52.c;
        if (r56 == null) goto L98;
        Long r57 = Long.valueOf(r56.a);
    L99:
        r55.c(new ub0.a.b(r113, r112, r114, r57.longValue()));
        goto L100
    L98:
        r57 = null;
    L100:
        this.lyricPlaceHolderData.setValue(null);
        return;
    L91:
        r112 = null;
    L75:
        r45 = getPublicFirstOrderedSong();
        goto L76
    L121:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L186;
        this.lyricPlaceHolderData.setValue(null);
        Disposable r58 = this.prepareCountDownDisposable;
        if (r58 == null) goto L126;
        r58.dispose();
    L126:
        if ((r22.a instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L128;
        MusicPanel r59 = r8.b();
        if (r59 == null) goto L136;
        KtvMusic r60 = r59.a;
        if (r60 == null) goto L136;
    L137:
        final KtvMusic r115 = r60;
        final Ref.BooleanRef r116 = new Ref.BooleanRef();
        r116.element = true;
        if (r115 == null) goto L183;
        if (this.enalbeParseFix == true) goto L142;
    L164:
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), "music不为空，getLyricResultEvent, invoke class :KtvMusic");
        KtvMvLyricPresenter r61 = this.mLyricPresenter;
        if (r61 == null) goto L167;
        ub0.a r62 = r61.p;
    L169:
        if (this.enalbeCallbackCheck == false) goto L179;
        if (r62 == null) goto L179;
        if (r62.a != r115.getMId()) goto L179;
        if ((r62 instanceof ub0.a.b) == false) goto L179;
        KtvMvLyricPresenter r63 = this.mLyricPresenter;
        if (r63 == null) goto L178;
        r63.c(r62);
    L178:
        pd2.d r64 = pd2.d.n;
        List r65 = ((ub0.a.b) r62).b;
        r64.getClass();
        pd2.d.C(r65, r115);
        r116.element = false;
    L179:
        h r117 = this.lyricResourceManager;
        if (r117 == null) goto L183;
        r117.c(r115, new MvLyricViewModel$handleStateChange$$inlined$run$lambda$2(r115, this, r8, r115, r116, r6));
        goto L183
    L167:
        r62 = null;
        goto L169
    L142:
        if (isSinger(r115) == false) goto L164;
        KtvRoomLyricsStateMachineConfig.d.f r66 = (KtvRoomLyricsStateMachineConfig.d.f) r8;
        KtvRoomLyricsStateMachineConfig.c r67 = r66.d;
        if (r67 == null) goto L164;
        List<com.bytedance.component.lyric.model.b> r68 = r67.c;
        if (r68 == null) goto L164;
        if (r68.size() <= 0) goto L150;
        boolean r69 = true;
    L151:
        if (r69 == false) goto L153;
        List<com.bytedance.component.lyric.model.b> r118 = r68;
    L154:
        if (r118 == null) goto L164;
        KtvMvLyricPresenter r70 = this.mLyricPresenter;
        if (r70 == null) goto L162;
        long r119 = r115.getMId();
        int r120 = r115.getMLyricType();
        KtvRoomLyricsStateMachineConfig.c r71 = r66.d;
        if (r71 == null) goto L160;
        Long r72 = Long.valueOf(r71.a);
    L161:
        r70.c(new ub0.a.b(r119, r118, r120, r72.longValue()));
        goto L162
    L160:
        r72 = null;
    L162:
        this.lyricPlaceHolderData.setValue(null);
        return;
    L153:
        r118 = null;
        goto L154
    L150:
        r69 = false;
    L183:
        if (r116.element == false) goto L186;
        checkLyricAvalable((KtvRoomLyricsStateMachineConfig.d.f) r8);
    L136:
        r60 = getPublicFirstOrderedSong();
        goto L137
    L128:
        if (getCurrentIsSinger() == true) goto L186;
        KtvMvLyricPresenter r73 = this.mLyricPresenter;
        if (r73 == null) goto L186;
        r73.d(5);
        goto L186
    L12:
        r7 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final boolean isSinger(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        String r0 = getCurrentUserId();
        OrderInfo r3 = r2.getOrderInfo();
        if (r3 == null) goto L8;
        InteractiveSongUserInfo r4 = r3.getTopUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
        if (r5 == null) goto L8;
    L10:
        return Intrinsics.areEqual(r0, r5);
    L8:
        r5 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void notifyClear(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clearListener");
        Intrinsics.checkNotNullParameter(r2, "clearListener");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void onMusicListChange(List<MusicPanel> r2) {
        h r0 = this.lyricResourceManager;
        if (r0 == null) goto L5;
        r0.f(r2);
    L5:
        KtvRoomLyricsStateMachineConfig.d r3 = this.currentState;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L8;
        r3 = null;
    L8:
        KtvRoomLyricsStateMachineConfig.d.e r4 = (KtvRoomLyricsStateMachineConfig.d.e) r3;
        if (r4 == null) goto L12;
        checkPrepareHint(r4.b.a);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void onSeiResult(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r2.b;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r4 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3;
        if (r4 == null) goto L9;
        handleLyricSei(r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void playPreviewMv(KtvStreamSingSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "syncData");
        Intrinsics.checkNotNullParameter(r2, "syncData");
    }

    public final void setLyricControlPresenter(KtvBaseLyricPresenter r2) {
        Intrinsics.checkNotNullParameter(r2, "lyricPresenter");
        if ((r2 instanceof KtvMvLyricPresenter) == true) goto L5;
        r2 = null;
    L5:
        KtvMvLyricPresenter r3 = (KtvMvLyricPresenter) r2;
        this.mLyricPresenter = r3;
        if (r3 == null) goto L9;
        r3.b();
        return;
    }

    public final void setLyricResourceManager(h r1) {
        this.lyricResourceManager = r1;
    }

    public final void setMLyricPresenter(KtvMvLyricPresenter r1) {
        this.mLyricPresenter = r1;
    }

    public static final /* synthetic */ void access$checkLyricAvalable(MvLyricViewModel r0, KtvRoomLyricsStateMachineConfig.d.f r1) {
        r0.checkLyricAvalable(r1);
    }

    public static final /* synthetic */ void access$setCurrentState$p(MvLyricViewModel r0, KtvRoomLyricsStateMachineConfig.d r1) {
        r0.currentState = r1;
    }

    public static final /* synthetic */ void access$setPrepareCountDownDisposable$p(MvLyricViewModel r0, Disposable r1) {
        r0.prepareCountDownDisposable = r1;
    }

    private final void checkHighSongTips(String[] r6, KtvMusic r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getMTitle();
    L6:
        if (r7 == null) goto L27;
        OrderInfo r8 = r7.getOrderInfo();
        if (r8 == null) goto L28;
        InteractiveSongUserInfo r9 = r8.getTopUser();
        if (r9 != null) goto L12;
        return;
    L12:
        if (this.singRecordConfig == false) goto L30;
        Map r2 = ((KtvLabelTextConfig) vm2.h.w4.getValue(null, vm2.h.a[281(0x119, float:3.94E-43)])).ktvLyricText;
        if (r2 != null) goto L17;
        r2 = MapsKt.emptyMap();
    L17:
        if (Intrinsics.areEqual(getCurrentUserId(), r9.getIdString()) == false) goto L22;
        KtvLyricText r10 = (KtvLyricText) r2.get(Integer.valueOf(r9.getKtvLyricTextFlex()));
        if (r10 == null) goto L21;
        r0 = r10.singerText;
    L21:
        r6[0] = Intrinsics.stringPlus(r0, r1);
        return;
    L22:
        KtvLyricText r11 = (KtvLyricText) r2.get(Integer.valueOf(r9.getKtvLyricTextFlex()));
        if (r11 == null) goto L25;
        r0 = r11.userText;
    L25:
        r6[0] = Intrinsics.stringPlus(r0, r1);
        return;
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void inferTips(boolean r3, boolean r4) {
        if (r4 == true) goto L4;
        this.lyricPlaceHolderData.setValue(new String[]{s1.B(2131918536), ""});
        return;
    L4:
        if (r3 == false) goto L6;
        this.lyricPlaceHolderData.setValue(null);
        return;
    L6:
        this.lyricPlaceHolderData.setValue(null);
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.api.h0;
import com.bytedance.android.live.ktv.common.model.api.x0;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.AddKTVDressContent;
import com.bytedance.android.livesdk.message.model.ChangeKTVDressContent;
import com.bytedance.android.livesdk.message.model.KTVDressMessageType;
import com.bytedance.android.livesdk.message.model.KtvDressMessage;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.message.AddDressPrompt;
import com.bytedance.android.livesdkapi.depend.message.DressPageItemCommon;
import com.bytedance.android.livesdkapi.depend.message.GetDressPageListMode;
import com.bytedance.android.livesdkapi.depend.message.KTVDressType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u0007¢\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001bH\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001bH\u0016J*\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f0\u001bH\u0016J0\u0010%\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\u0012\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u001e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010,R&\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/skin/viewmodel/KtvDressViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/skin/viewmodel/a;", "Lvlc/l;", "", "addMessageListenerIfNeed", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "obtainSingState", "getPageDressList", "", "dressType", "mode", "", "isSinger", "getPageHonorTagList", "getPageMidiSkinList", "Lcom/bytedance/android/livesdkapi/depend/message/TagDressPageItem;", "getCurrentSelectHonorTag", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressPageItem;", "getCurrentSelectMidiSkin", "onCleared", "Lcom/bytedance/android/live/ktv/common/model/api/x0;", "obtainHonorTagList", "Lcom/bytedance/android/live/ktv/common/model/api/h0;", "obtainMidiSkinList", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "observer", "observeHonorTagList", "observeMidiSkinList", "Lkotlin/Pair;", "observeKtvDressChangedState", "", "fromDressId", "toDressId", "midiOwnerDegree", "changeDress", "wearMidiSkin", "Ltlc/d;", "message", "onMessage", "Landroidx/lifecycle/MutableLiveData;", "honorTagList", "Landroidx/lifecycle/MutableLiveData;", "midiSkinList", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "currentMidiSkin", "ktvDressChangedState", "Lxd2/a;", "ktvDressModel$delegate", "Lkotlin/Lazy;", "getKtvDressModel", "()Lxd2/a;", "ktvDressModel", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room$delegate", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter$delegate", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose$delegate", "getCompositeDispose", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvDressViewModel extends ViewModel implements com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a, l {
    public static final a Companion = null;
    public static final String TAG = "KtvDressViewModel";
    private final Lazy compositeDispose$delegate;
    private MutableLiveData<MidiSkinDressInfo> currentMidiSkin;
    private final Lazy dataCenter$delegate;
    private MutableLiveData<x0> honorTagList;
    private final MutableLiveData<Pair<Integer, Integer>> ktvDressChangedState;
    private final Lazy ktvDressModel$delegate;
    private MutableLiveData<h0> midiSkinList;
    private final Lazy room$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a a(ViewModelStoreOwner r1) {
            Intrinsics.checkNotNullParameter(r1, "viewModelStoreOwner");
            return new ViewModelProvider(r1).get(KtvDressViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDispose() {
        return (CompositeDisposable) this.compositeDispose$delegate.getValue();
    }

    private final DataCenter getDataCenter() {
        return (DataCenter) this.dataCenter$delegate.getValue();
    }

    private final xd2.a getKtvDressModel() {
        return (xd2.a) this.ktvDressModel$delegate.getValue();
    }

    private final IRoom getRoom() {
        return (IRoom) this.room$delegate.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a newInstance(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    private final KtvRoomLyricsStateMachineConfig.d obtainSingState() {
        KtvContext.Companion.getClass();
        n<c> r0 = KtvContext.a.g().getKtvCoreViewModel();
        if (r0 == null) goto L7;
        c r1 = (c) r0.getValue();
        if (r1 == null) goto L7;
        return r1.getCurState();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public TagDressPageItem getCurrentSelectHonorTag() {
        x0 r0 = (x0) this.honorTagList.getValue();
        Object r1 = null;
        if (r0 == null) goto L24;
        List r2 = r0.b();
        if (r2 == null) goto L25;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        DressPageItemCommon r5 = ((TagDressPageItem) r4).common;
        if (r5 == null) goto L14;
        boolean r6 = true;
        if (r5.isSelected != true) goto L14;
    L15:
        if (r6 == false) goto L8;
        r1 = r4;
    L14:
        r6 = false;
    L18:
        return (TagDressPageItem) r1;
    L25:
        return null;
    L24:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public MidiSkinDressPageItem getCurrentSelectMidiSkin() {
        h0 r0 = (h0) this.midiSkinList.getValue();
        Object r1 = null;
        if (r0 == null) goto L24;
        List r2 = r0.a();
        if (r2 == null) goto L25;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        DressPageItemCommon r5 = ((MidiSkinDressPageItem) r4).common;
        if (r5 == null) goto L14;
        boolean r6 = true;
        if (r5.isSelected != true) goto L14;
    L15:
        if (r6 == false) goto L8;
        r1 = r4;
    L14:
        r6 = false;
    L18:
        return (MidiSkinDressPageItem) r1;
    L25:
        return null;
    L24:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void getPageDressList() {
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isCurrentUserIsSinger();
        int r1 = KTVDressType.KTV_DRESS_TYPE_TAG.getValue();
        GetDressPageListMode r2 = GetDressPageListMode.LIST_MODE_FULL;
        getPageHonorTagList(r1, r2.getValue(), r0);
        if (KtvContext.a.k() == false) goto L6;
        getPageMidiSkinList(KTVDressType.KTV_DRESS_TYPE_MIDI_SKIN.getValue(), r2.getValue(), r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public boolean hasNewKtvDress() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().getKtvAddDressVersion().getValue() != null) goto L5;
    L7:
        return false;
    L5:
        if ((!Intrinsics.areEqual((Long) KtvContext.a.g().getKtvAddDressVersion().getValue(), (Long) com.bytedance.android.livesdk.sharedpref.c.i.getValue())) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public x0 obtainHonorTagList() {
        return (x0) this.honorTagList.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public h0 obtainMidiSkinList() {
        return (h0) this.midiSkinList.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void wearMidiSkin() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L11;
        KtvRoomLyricsStateMachineConfig.d r0 = obtainSingState();
        if (r0 == null) goto L11;
        MusicPanel r1 = r0.b();
        if (r1 == null) goto L11;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L11;
        long r3 = r2.getMId();
    L12:
        long r5 = r3;
        System.currentTimeMillis();
        Disposable r4 = getKtvDressModel().a(getRoom().getId(), r5, new C02311(this), C02322.INSTANCE);
        if (r4 == null) goto L16;
        RxUtilKt.c(r4, getCompositeDispose());
        return;
    L16:
        return;
    L11:
        r3 = 0;
        goto L12
    }

    public KtvDressViewModel() {
        this.honorTagList = new MutableLiveData();
        this.midiSkinList = new MutableLiveData();
        this.currentMidiSkin = new MutableLiveData();
        this.ktvDressChangedState = new MutableLiveData();
        this.ktvDressModel$delegate = LazyKt.lazy(KtvDressViewModel$ktvDressModel$2.INSTANCE);
        this.room$delegate = LazyKt.lazy(KtvDressViewModel$room$2.INSTANCE);
        this.dataCenter$delegate = LazyKt.lazy(KtvDressViewModel$dataCenter$2.INSTANCE);
        this.compositeDispose$delegate = LazyKt.lazy(KtvDressViewModel$compositeDispose$2.INSTANCE);
        addMessageListenerIfNeed();
    }

    private final void addMessageListenerIfNeed() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L7;
        d r1 = (d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(MessageType.KTV_DRESS_MESSAGE.getIntType(), this);
    L7:
        DataCenter r2 = getDataCenter();
        if (r2 == null) goto L13;
        d r3 = (d) r2.get("data_message_manager", null);
        if (r3 == null) goto L14;
        r3.addMessageListener(MessageType.KTV_DRESS_MESSAGE.getIntType(), this);
        return;
    L14:
        return;
    }

    public void onCleared() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L7;
        d r1 = (d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(this);
    L7:
        getCompositeDispose().clear();
        super.onCleared();
    }

    public static final /* synthetic */ MutableLiveData access$getCurrentMidiSkin$p(KtvDressViewModel r0) {
        return r0.currentMidiSkin;
    }

    public static final /* synthetic */ MutableLiveData access$getHonorTagList$p(KtvDressViewModel r0) {
        return r0.honorTagList;
    }

    public static final /* synthetic */ MutableLiveData access$getKtvDressChangedState$p(KtvDressViewModel r0) {
        return r0.ktvDressChangedState;
    }

    public static final /* synthetic */ MutableLiveData access$getMidiSkinList$p(KtvDressViewModel r0) {
        return r0.midiSkinList;
    }

    public void onMessage(tlc.d r5) {
        String r1 = null;
        Long r2 = null;
        r2 = null;
        if ((r5 instanceof KtvDressMessage) == true) goto L5;
        r5 = null;
    L5:
        KtvDressMessage r6 = (KtvDressMessage) r5;
        if (r6 == null) goto L36;
        int r0 = r6.getMessageType();
        if (r0 != KTVDressMessageType.TYPE_ADD.getValue()) goto L22;
        AddKTVDressContent r3 = r6.getAddDressContent();
        if (r3 == null) goto L37;
        AddDressPrompt r4 = r3.addDressPrompt;
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.hasAddDress != true) goto L39;
        KtvContext.Companion.getClass();
        n<Long> r7 = KtvContext.a.g().getKtvAddDressVersion();
        AddKTVDressContent r8 = r6.getAddDressContent();
        if (r8 == null) goto L20;
        AddDressPrompt r9 = r8.addDressPrompt;
        if (r9 == null) goto L20;
        r2 = r9.addDressVersion;
    L20:
        r7.setValue(r2);
        Long r10 = KtvLoggerHelper.a;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("user_type", KtvLoggerHelper.I());
        KtvLoggerHelper.A(r11);
        j0.l().sendLog("livesdk_audience_ksong_resource_info_show", r11, new Object[]{IRoom.class});
        return;
    L39:
        return;
    L37:
        return;
    L22:
        if (r0 != KTVDressMessageType.TYPE_CHANGE.getValue()) goto L41;
        ChangeKTVDressContent r12 = r6.getChangeDressContent();
        if (r12 == null) goto L26;
        String r13 = r12.changeGlobalDressToast;
    L28:
        if (TextUtils.isEmpty(r13) == false) goto L30;
        return;
    L30:
        if (j.i() == true) goto L43;
        ChangeKTVDressContent r14 = r6.getChangeDressContent();
        if (r14 == null) goto L34;
        r1 = r14.changeGlobalDressToast;
    L34:
        f2.c(r1, 0);
        return;
    L43:
        return;
    L26:
        r13 = null;
        goto L28
    L41:
        return;
    }

    public static final /* synthetic */ void access$setCurrentMidiSkin$p(KtvDressViewModel r0, MutableLiveData r1) {
        r0.currentMidiSkin = r1;
    }

    public static final /* synthetic */ void access$setHonorTagList$p(KtvDressViewModel r0, MutableLiveData r1) {
        r0.honorTagList = r1;
    }

    public static final /* synthetic */ void access$setMidiSkinList$p(KtvDressViewModel r0, MutableLiveData r1) {
        r0.midiSkinList = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void observeHonorTagList(LifecycleOwner r2, Observer<x0> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.honorTagList.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void observeKtvDressChangedState(LifecycleOwner r2, Observer<Pair<Integer, Integer>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.ktvDressChangedState.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void observeMidiSkinList(LifecycleOwner r2, Observer<h0> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.midiSkinList.observe(r2, r3);
    }

    public void getPageHonorTagList(int r9, int r10, boolean r11) {
        System.currentTimeMillis();
        Disposable r12 = getKtvDressModel().b(getRoom().getId(), r9, r10, r11, new C02271(this), C02282.INSTANCE);
        if (r12 == null) goto L6;
        RxUtilKt.c(r12, getCompositeDispose());
        return;
    }

    public void getPageMidiSkinList(int r9, int r10, boolean r11) {
        System.currentTimeMillis();
        Disposable r12 = getKtvDressModel().b(getRoom().getId(), r9, r10, r11, new C02291(this), C02302.INSTANCE);
        if (r12 == null) goto L6;
        RxUtilKt.c(r12, getCompositeDispose());
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a
    public void changeDress(final int r15, String r16, String r17, final int r18, int r19) {
        Intrinsics.checkNotNullParameter(r16, "fromDressId");
        Intrinsics.checkNotNullParameter(r17, "toDressId");
        KtvContext.Companion.getClass();
        final boolean r8 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r8 == false) goto L11;
        KtvRoomLyricsStateMachineConfig.d r0 = obtainSingState();
        if (r0 == null) goto L11;
        MusicPanel r1 = r0.b();
        if (r1 == null) goto L11;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L11;
        long r3 = r2.getMId();
    L12:
        long r9 = r3;
        System.currentTimeMillis();
        Disposable r4 = getKtvDressModel().c(getRoom().getId(), r15, r16, r17, r18, r8, r9, r19, new AnonymousClass1(this, r15, r18, r8), AnonymousClass2.INSTANCE);
        if (r4 == null) goto L16;
        RxUtilKt.c(r4, getCompositeDispose());
        return;
    L16:
        return;
    L11:
        r3 = 0;
        goto L12
    }
}

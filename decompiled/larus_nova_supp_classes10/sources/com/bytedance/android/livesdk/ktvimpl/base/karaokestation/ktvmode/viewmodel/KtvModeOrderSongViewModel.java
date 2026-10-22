package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.viewmodel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.PermissionType;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdk.message.model.ej;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.ld;
import com.bytedance.android.livesdk.message.model.o2;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import tf0.q;
import xe2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0003012B%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J@\u0010\u0017\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel;", "Lcom/bytedance/android/livesdk/message/model/RTChorusOperateType;", LocationMonitorConst.TYPE, "", "getRequestPage", "getLimitType", "", "permissionType", "getPopupType", "", "cancelRTChorusPermissionDisposable", "initData", "Ltlc/d;", "message", "onMessage", "", "throwable", "errorCode", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "musicId", "orderUserId", "checkRTChorusPermissionInfoIfNeed", "", "shouldFillLocalPath", "onCleared", "Lcom/bytedance/android/livesdkapi/model/ModeType;", "getModeType", "lastMusicPanel", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "Lio/reactivex/disposables/Disposable;", "rtChorusPermissionInfoDisposable", "Lio/reactivex/disposables/Disposable;", "isEnterRoom", "Z", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel$b;", "ktvChorusPermissionData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel$b;", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "orderedSongDataContext", "<init>", "(Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;)V", "Companion", "a", "b", "KtvModeOrderSongViewModelFactory", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvModeOrderSongViewModel extends BaseOrderSongViewModel {
    public static final a Companion = null;
    public static final int RT_CHORUS_BUSSINESS_PERMISSION_ERROR_CODE = 4004521;
    private boolean isEnterRoom;
    private b ktvChorusPermissionData;
    private MusicPanel lastMusicPanel;
    private Disposable rtChorusPermissionInfoDisposable;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel$KtvModeOrderSongViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class KtvModeOrderSongViewModelFactory implements ViewModelProvider.Factory {
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
            if (r4.isAssignableFrom(KtvModeOrderSongViewModel.class) == false) goto L7;
            return new KtvModeOrderSongViewModel(this.a, this.b, this.c);
        L7:
            throw new IllegalArgumentException("Unknow ViewModel class: ".concat(r4.getName()));
        }

        public KtvModeOrderSongViewModelFactory(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d a(ViewModelStoreOwner r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4, OrderedSongDataContext r5) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            return new ViewModelProvider(r2, new KtvModeOrderSongViewModelFactory(r3, r4, r5)).get(KtvModeOrderSongViewModel.class);
        }
    }

    public static final class b {
        public int a;
        public int b;
        public ej c;
        public ej d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            ej r1 = this.c;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            ej r5 = this.d;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "KtvChorusPermissionData(orderPermissionType=" + this.a + ", joinPermissionType=" + this.b + ", orderSongGift=" + this.c + ", joinChorusGift=" + this.d + ")";
        }

        public b(int r2) {
            PermissionType r3 = PermissionType.All;
            int r0 = r3.getValue();
            int r4 = r3.getValue();
            this.a = r0;
            this.b = r4;
            this.c = null;
            this.d = null;
        }
    }

    public static final class c implements q {
        public final /* synthetic */ KtvModeOrderSongViewModel a;
        public final /* synthetic */ boolean b;

        public final void a() {
        }

        public final void b() {
            if (this.b == false) goto L5;
            f2.b(2131918532, 0);
            xs2.b.a().post(new ye2.a());
            return;
        L5:
            f2.b(2131918531, 0);
            WeakReference r0 = KtvModeOrderSongViewModel.access$getContextForCheckPermission$p(this.a);
            if (r0 == null) goto L8;
            Context r1 = (Context) r0.get();
        L9:
            MusicPanel r2 = KtvModeOrderSongViewModel.access$getLastMusicPanel$p(this.a);
            if (r1 == null) goto L13;
            if (r2 == null) goto L13;
            this.a.addSong(r1, r2, null, null);
        L13:
            KtvModeOrderSongViewModel.access$setLastMusicPanel$p(this.a, null);
            return;
        L8:
            r1 = null;
            goto L9
        }

        public c(KtvModeOrderSongViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvModeOrderSongViewModel a;

        public d(KtvModeOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (RealTimeChorusBusinessContext.Companion.j() == false) goto L20;
            OrderedSongDataContext r6 = KtvModeOrderSongViewModel.access$getMOrderedSongDataContext$p(this.a);
            if (r6 == null) goto L13;
            List<MusicPanel> r7 = r6.m200getKtvSingSongList();
            if (r7 == null) goto L13;
            List<MusicPanel> r8 = r7;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L12;
            MusicPanel r1 = (MusicPanel) r9.next();
            r0.add(KtvModeOrderSongViewModel.access$findLocalPath(this.a, r1));
            goto L10
        L12:
            List<MusicPanel> r10 = CollectionsKt.toMutableList(r0);
        L14:
            if (r10 == null) goto L21;
            OrderedSongDataContext r2 = KtvModeOrderSongViewModel.access$getMOrderedSongDataContext$p(this.a);
            if (r2 == null) goto L22;
            r2.updateKtvSingSongList(r10);
            return;
        L22:
            return;
        L21:
            return;
        L13:
            r10 = null;
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d newInstance(ViewModelStoreOwner r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.live.ktv.common.search.viewmodel.a r3, OrderedSongDataContext r4) {
        Companion.getClass();
        return a.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final void cancelRTChorusPermissionDisposable() {
        Disposable r0 = this.rtChorusPermissionInfoDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void initData() {
        super.initData();
        if (KtvSettingHelper.w() == false) goto L5;
        RealTimeChorusBusinessContext.Companion.o(this, new d(this));
    L5:
        vlc.d r0 = getMsgManager();
        if (r0 == null) goto L8;
        r0.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this);
    L8:
        vlc.d r1 = getMsgManager();
        xlc.a r2 = null;
        if ((r1 instanceof xlc.a) == true) goto L11;
        r1 = null;
    L11:
        xlc.a r3 = (xlc.a) r1;
        if (r3 == null) goto L14;
        r3.y(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this);
    L14:
        vlc.d r4 = getMsgManager();
        if (r4 == null) goto L17;
        r4.addMessageListener(MessageType.KTV_CHORUS_PERMISSION_MESSAGE.getIntType(), this);
    L17:
        xlc.a r5 = getMsgManager();
        if ((r5 instanceof xlc.a) == false) goto L21;
        r2 = r5;
    L21:
        xlc.a r6 = r2;
        if (r6 == null) goto L25;
        r6.y(MessageType.KTV_CHORUS_PERMISSION_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void onCleared() {
        super.onCleared();
        cancelRTChorusPermissionDisposable();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public ModeType getModeType() {
        return ModeType.KTV_MODE;
    }

    public static final /* synthetic */ WeakReference access$getContextForCheckPermission$p(KtvModeOrderSongViewModel r0) {
        return r0.getContextForCheckPermission();
    }

    public static final /* synthetic */ MusicPanel access$getLastMusicPanel$p(KtvModeOrderSongViewModel r0) {
        return r0.lastMusicPanel;
    }

    public static final /* synthetic */ OrderedSongDataContext access$getMOrderedSongDataContext$p(KtvModeOrderSongViewModel r0) {
        return r0.getMOrderedSongDataContext();
    }

    private final String getLimitType(RTChorusOperateType r2) {
        if (r2 != RTChorusOperateType.ORDER_SONG) goto L5;
        return "order_limit";
    L5:
        return "join_limit";
    }

    private final String getPopupType(int r2) {
        if (r2 != PermissionType.FansClub.getValue()) goto L6;
        return "fans_club";
    L6:
        if (r2 != PermissionType.Subscribe.getValue()) goto L9;
        return "vip";
    L9:
        if (r2 != PermissionType.SendAssignGift.getValue()) goto L11;
        return "gift";
    L11:
        return "";
    }

    private final String getRequestPage(RTChorusOperateType r2) {
        if (r2 != RTChorusOperateType.ORDER_SONG) goto L5;
        return "chorus_order";
    L5:
        return "chorus_join";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void onMessage(tlc.d r8) {
        super.onMessage(r8);
        if ((r8 instanceof jd) == false) goto L31;
        jd r0 = (jd) r8;
        Integer r2 = r0.getMsgType();
        if (r2 == null) goto L31;
        if (r2.intValue() != 1) goto L31;
        o2 r3 = r0.getGiftSentContent();
        Boolean r4 = null;
        if (r3 == null) goto L12;
        Boolean r5 = r3.b();
    L13:
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L24;
        WeakReference<Context> r7 = getContextForCheckPermission();
        if (r7 == null) goto L18;
        Context r9 = r7.get();
    L19:
        MusicPanel r10 = this.lastMusicPanel;
        if (r9 == null) goto L23;
        if (r10 == null) goto L23;
        addSong(r9, r10, null, null);
    L23:
        this.lastMusicPanel = null;
        goto L24
    L18:
        r9 = null;
    L24:
        o2 r1 = r0.getGiftSentContent();
        if (r1 == null) goto L28;
        r4 = r1.a();
    L28:
        if (Intrinsics.areEqual(r4, r6) == false) goto L31;
        xs2.b.a().post(new ye2.a());
        goto L31
    L12:
        r5 = null;
    L31:
        if ((r8 instanceof ld) == true) goto L33;
        return;
    L33:
        if (this.isEnterRoom == true) goto L36;
        this.isEnterRoom = true;
    L59:
        b r11 = this.ktvChorusPermissionData;
        ld r12 = (ld) r8;
        r11.a = r12.getOrderPermissionType();
        r11.b = r12.getJoinPermissionType();
        r11.c = r12.getOrderSongGift();
        r11.d = r12.getJoinChorusGift();
        h.d = r12.getJoinPermissionType();
        h.c = r12.getOrderPermissionType();
        return;
    L36:
        if (isAnchor() == false) goto L38;
    L39:
        int r13 = this.ktvChorusPermissionData.a;
        PermissionType r14 = PermissionType.SendAssignGift;
        if (r13 != r14.getValue()) goto L50;
        ld r15 = (ld) r8;
        if (this.ktvChorusPermissionData.a == r15.getOrderPermissionType()) goto L44;
        f2.c(s1.B(2131922304), 0);
        goto L50
    L44:
        ej r16 = this.ktvChorusPermissionData.c;
        if (r16 == null) goto L50;
        if ((!Intrinsics.areEqual(r16, r15.getOrderSongGift())) == false) goto L50;
        f2.c(s1.B(2131922304), 0);
    L50:
        if (this.ktvChorusPermissionData.b != r14.getValue()) goto L59;
        ld r17 = (ld) r8;
        if (this.ktvChorusPermissionData.b == r17.getJoinPermissionType()) goto L54;
        f2.c(s1.B(2131922303), 0);
        goto L59
    L54:
        ej r18 = this.ktvChorusPermissionData.d;
        if (r18 == null) goto L59;
        if ((!Intrinsics.areEqual(r18, r17.getJoinChorusGift())) == false) goto L59;
        f2.c(s1.B(2131922303), 0);
        goto L59
    L38:
        if (KtvUtilsKt.j() == false) goto L59;
        goto L39
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public boolean shouldFillLocalPath(MusicPanel r3) {
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        String r1 = null;
        if (KtvSettingHelper.w() == false) goto L18;
        OrderInfo r4 = r3.a.getOrderInfo();
        if (r4 == null) goto L10;
        InteractiveSongUserInfo r5 = r4.getTopUser();
        if (r5 == null) goto L10;
        r1 = r5.getIdString();
    L10:
        if (Intrinsics.areEqual(r1, k.n(IMiddlewareUserService.class).user().n().toString()) == true) goto L17;
        RealTimeChorusBusinessContext.a r6 = RealTimeChorusBusinessContext.Companion;
        r6.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L14;
    L16:
        return false;
    L14:
        if (r6.j() == false) goto L16;
    L17:
        return true;
    L18:
        OrderInfo r7 = r3.a.getOrderInfo();
        if (r7 == null) goto L24;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L24;
        r1 = r8.getIdString();
    L24:
        return Intrinsics.areEqual(r1, k.n(IMiddlewareUserService.class).user().n().toString());
    }

    public static final /* synthetic */ MusicPanel access$findLocalPath(KtvModeOrderSongViewModel r0, MusicPanel r1) {
        return r0.findLocalPath(r1);
    }

    public static final /* synthetic */ String access$getRequestPage(KtvModeOrderSongViewModel r0, RTChorusOperateType r1) {
        return r0.getRequestPage(r1);
    }

    public static final /* synthetic */ void access$setContextForCheckPermission$p(KtvModeOrderSongViewModel r0, WeakReference r1) {
        r0.setContextForCheckPermission(r1);
    }

    public static final /* synthetic */ void access$setLastMusicPanel$p(KtvModeOrderSongViewModel r0, MusicPanel r1) {
        r0.lastMusicPanel = r1;
    }

    public KtvModeOrderSongViewModel(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
        super(r1, r2, r3);
        this.ktvChorusPermissionData = new b(0);
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d newInstance(Fragment r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.live.ktv.common.search.viewmodel.a r3, OrderedSongDataContext r4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return ViewModelProviders.of(r1, new KtvModeOrderSongViewModelFactory(r2, r3, r4)).get(KtvModeOrderSongViewModel.class);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void checkRTChorusPermissionInfoIfNeed(Throwable r8, int r9, final RTChorusOperateType r10, MusicPanel r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, LocationMonitorConst.TYPE);
        if (r9 != 4004521) goto L32;
        this.lastMusicPanel = r11;
        RTChorusOperateType r14 = RTChorusOperateType.ORDER_SONG;
        if (r10 != r14) goto L7;
        int r15 = this.ktvChorusPermissionData.a;
    L8:
        final int r2 = r15;
        if (r10 != r14) goto L11;
        ej r16 = this.ktvChorusPermissionData.c;
    L12:
        boolean r17 = true;
        if (r2 != PermissionType.FansClub.getValue()) goto L15;
    L31:
        final String r6 = getPopupType(r2);
        final String r5 = getLimitType(r10);
        h.m(MapsKt.mapOf(new Pair[]{TuplesKt.to("limit_type", r5), TuplesKt.to("popup_type", r6)}));
        final ej r4 = r16;
        com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.k(r10, Integer.valueOf(r2), r16, new AnonymousClass1(r5, r6, r10, r2), new AnonymousClass2(this, r2, r10, r4, r5, r6));
        return;
    L15:
        if (r2 == PermissionType.Subscribe.getValue()) goto L31;
        if (r2 == PermissionType.SendAssignGift.getValue()) goto L31;
        if (r2 == PermissionType.Fans.getValue()) goto L22;
        ExceptionUtils.handleException(s1.getContext(), r8);
        return;
    L22:
        if (r10 == RTChorusOperateType.JOIN_CHORUS) goto L26;
        r17 = false;
    L26:
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0 == null) goto L34;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r18 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r18 == null) goto L35;
        r18.K2(r17, !r17, new c(this, r17));
        return;
    L35:
        return;
    L34:
        return;
    L11:
        r16 = this.ktvChorusPermissionData.d;
        goto L12
    L7:
        r15 = this.ktvChorusPermissionData.b;
        goto L8
    L32:
        ExceptionUtils.handleException(s1.getContext(), r8);
    }
}

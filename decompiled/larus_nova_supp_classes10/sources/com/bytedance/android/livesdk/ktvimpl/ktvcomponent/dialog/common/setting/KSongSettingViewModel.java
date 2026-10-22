package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.UpdateSongSettingType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.f;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.l;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J=\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/KSongSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/b;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/d;", "obtainKSongSettingKey", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/UpdateSongSettingType;", "updateSongSettingType", "", "checked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "requestCallback", "updateSettingByType", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "kSongSettingKey$delegate", "getKSongSettingKey", "()Landroidx/lifecycle/MutableLiveData;", "kSongSettingKey", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongSettingViewModel extends ViewModel implements b {
    public static final a Companion = null;
    public static final String TAG = "KSongSettingViewModel";
    private final Lazy compositeDisposable$delegate;
    private final Lazy kSongSettingKey$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static KSongSettingViewModel a(ViewModelStoreOwner r1) {
            Intrinsics.checkNotNullParameter(r1, "owner");
            return (KSongSettingViewModel) new ViewModelProvider(r1).get(KSongSettingViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    private final MutableLiveData<d> getKSongSettingKey() {
        return (MutableLiveData) this.kSongSettingKey$delegate.getValue();
    }

    @JvmStatic
    public static final KSongSettingViewModel newInstance(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public KSongSettingViewModel() {
        this.compositeDisposable$delegate = LazyKt.lazy(KSongSettingViewModel$compositeDisposable$2.INSTANCE);
        this.kSongSettingKey$delegate = LazyKt.lazy(KSongSettingViewModel$kSongSettingKey$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b
    public MutableLiveData<d> obtainKSongSettingKey() {
        return getKSongSettingKey();
    }

    public void onCleared() {
        super.onCleared();
        getCompositeDisposable().clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b
    public void updateSettingByType(UpdateSongSettingType r10, boolean r11, final Function1<? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "updateSongSettingType");
        long r2 = System.currentTimeMillis();
        if (r10 != UpdateSongSettingType.AUDIENCE_ADD_SONG) goto L8;
        int r13 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.a;
        Disposable r14 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.C0018b.a.a(r2, com.bytedance.android.live.ktv.common.util.a.c().getRoomId(), r11, new AnonymousClass1(r12), new AnonymousClass2(r12));
        if (r14 == null) goto L16;
        RxUtilKt.c(r14, getCompositeDisposable());
        return;
    L16:
        return;
    L8:
        if (r10 != UpdateSongSettingType.AUDIENCE_MULTI_CHORUS) goto L13;
        int r15 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.a;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b r16 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.C0018b.a;
        long r5 = com.bytedance.android.live.ktv.common.util.a.c().getRoomId();
        Function1<com.bytedance.android.live.network.response.e<m>, Unit> r0 = new AnonymousClass3(r12);
        Function1<Throwable, Unit> r7 = new AnonymousClass4(r12);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "successCallback");
        Intrinsics.checkNotNullParameter(r7, "failCallback");
        Disposable r17 = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateMultiChorusEnableSetting(r5, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.e(r2, r0), new f(r2, r11, r7));
        if (r17 == null) goto L18;
        RxUtilKt.c(r17, getCompositeDisposable());
        return;
    L18:
        return;
    L13:
        if (r10 != UpdateSongSettingType.HIDE_LYRICS_SUBTITLE_OPEN) goto L20;
        int r18 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.a;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b r19 = com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b.C0018b.a;
        long r6 = com.bytedance.android.live.ktv.common.util.a.c().getRoomId();
        Boolean r110 = Boolean.valueOf(r11);
        Function1<com.bytedance.android.live.network.response.e<l>, Unit> r1 = new AnonymousClass5(r12);
        Function1<Throwable, Unit> r8 = new AnonymousClass6(r12);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r1, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateKtvComponentSetting(r6, r110).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.c(r2, r1), new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.d(r2, r8));
        return;
    }
}

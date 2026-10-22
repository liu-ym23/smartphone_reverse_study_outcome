package com.bytedance.android.livesdk.locallife;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLifeInfoHandler;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermStateListener;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.performance.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JB\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\fH\u0016J\"\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001dH\u0016J&\u0010-\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010.\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/locallife/LiveLocalLifeServiceImpl;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeService;", "()V", "addShortTermStateListener", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "listener", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermStateListener;", "attachWindow", "Landroid/app/Activity;", "businessName", "", "dialogWindow", "Landroid/view/Window;", "Lkotlin/Function2;", "", "", "detachWindow", "getAnchorShelfSchema", "getCurrentRoomInfo", "Lorg/json/JSONObject;", "getLiveLocalRoomInfo", "Landroid/os/Bundle;", "uniqueKey", "isPreview", "getRoomInfoByUniqueKey", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getShortTermState", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "getTimeStamp", "", "scene", "milestone", "injectLiveLifeInfoHandler", "handler", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;", "removeEnterActionParams", "removeLiveLocalRoomInfo", "key", "removeShortTermStateListener", "setLifeShareId", "lifeShareId", "setShortTermState", BaseCoreViewModel.CORE_TAG_STATE, "toFullScreen", "toHalfScreen", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveLocalLifeServiceImpl implements ILiveLocalLifeService {
    public LiveLocalLifeServiceImpl() {
    }

    public void removeLiveLocalRoomInfo(FragmentActivity r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    public String getAnchorShelfSchema() {
        String r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.b();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return String.valueOf(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.a());
    }

    public JSONObject getCurrentRoomInfo(FragmentActivity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        boolean r2 = false;
        Bundle r3 = getLiveLocalRoomInfo(r9, null, false);
        if (r3 == null) goto L5;
        String r4 = r3.getString("data_enter_locallife_live_params");
    L6:
        if (r3 == null) goto L8;
        String r5 = r3.getString("log_enter_params");
    L9:
        Room r10 = LiveLocalLifeDataViewModel.getRoom$default((LiveLocalLifeDataViewModel) ViewModelProviders.of(r9).get(LiveLocalLifeDataViewModel.class), null, 1, null);
        if (r10 == null) goto L12;
        String r11 = r10.lifeShareId;
    L36:
        JSONObject r7 = new JSONObject(r5);     // Catch: Exception -> L35
        r7.put("locallife_live_params", r4);     // Catch: Exception -> L35
        if (r11 == null) goto L16;
        r7.put("life_share_id", r11);     // Catch: Exception -> L35
    L16:
        if (r3 == null) goto L18;
        String r12 = r3.getString("extra_params");     // Catch: Exception -> L35
    L19:
        if (r12 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L34;
        String r13 = new JSONObject(r12).optString("life_extra_info");     // Catch: Exception -> L35
        if (r13 != null) goto L29;
    L30:
        r2 = true;
    L31:
        if (r2 == true) goto L34;
        r7.put("life_extra_info", r13);     // Catch: Exception -> L35
    L29:
        if (r13.length() != 0) goto L31;
    L34:
        return r7;
    L21:
        if (r12.length() == 0) goto L24;
        r6 = false;
        goto L25
    L18:
        r12 = null;
    L38:
        return null;
    L12:
        r11 = null;
        goto L36
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public Bundle getLiveLocalRoomInfo(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        return getLiveLocalRoomInfo(r3, null, false);
    }

    public ShortTermState getShortTermState(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).getShortTermState();
    }

    public void addShortTermStateListener(FragmentActivity r2, ShortTermStateListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).addShortTermStateListener(r3);
    }

    public Room getRoomInfoByUniqueKey(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).getRoom(r3);
    }

    public long getTimeStamp(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "milestone");
        ILiveUxTracer r0 = k.f(ILiveUxTracer.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getTimeStamp(r2, r3);
    }

    public void injectLiveLifeInfoHandler(FragmentActivity r2, ILiveLifeInfoHandler r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "handler");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).setLiveLifeInfoHandler(r3);
    }

    public void removeEnterActionParams(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).removeEnterActionParams(r3);
    }

    public void removeLiveLocalRoomInfo(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "key");
        removeLiveLocalRoomInfo(r2, r3, null);
    }

    public void removeShortTermStateListener(FragmentActivity r2, ShortTermStateListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).removeShortTermStateListener(r3);
    }

    public void setLifeShareId(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).setLifeShareId(r3);
    }

    public void setShortTermState(FragmentActivity r2, ShortTermState r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, BaseCoreViewModel.CORE_TAG_STATE);
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r2).get(LiveLocalLifeDataViewModel.class)).setShortTermState(r3);
    }

    public void detachWindow(Activity r2, String r3, Window r4) {
        j0.g().d(r2, r3, r4);
    }

    public Bundle getLiveLocalRoomInfo(FragmentActivity r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        LiveLocalLifeDataViewModel r4 = (LiveLocalLifeDataViewModel) ViewModelProviders.of(r1).get(LiveLocalLifeDataViewModel.class);
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        Bundle r6 = (Bundle) r4.getData().getValue();
    L14:
        Room r7 = r4.getRoom(r2);
        if (r7 == null) goto L17;
        String r8 = r7.lifeShareId;
    L18:
        if (r8 == null) goto L21;
        if (r6 == null) goto L21;
        r6.putString("life_share_id", r8);
    L21:
        return r6;
    L17:
        r8 = null;
        goto L18
    L11:
        r6 = r4.getMultiRoomData().get(r2);
        if (r6 != null) goto L14;
        r6 = (Bundle) r4.getData().getValue();
        goto L14
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public void toFullScreen(Activity r2, String r3, Window r4) {
        j0.g().i(r2, r3, r4);
    }

    public void toHalfScreen(Activity r2, String r3, Window r4) {
        j0.g().j(r2, r3, r4);
    }

    public void attachWindow(Activity r2, String r3, Window r4, Function2<? super Boolean, ? super Integer, Unit> r5) {
        j0.g().b(r2, r3, r4, r5);
    }
}

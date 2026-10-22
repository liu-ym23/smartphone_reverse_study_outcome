package com.bytedance.android.livesdk.livead;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdNetWorkCallback;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCommitRemoveResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardRemoveRequest;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.k0;
import com.bytedance.android.livesdk.commerce.LiveAdViewModel;
import com.bytedance.android.livesdk.utils.a3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019`\u001aH\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J \u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livead/LiveAdServiceImpl;", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdService;", "()V", "canShowLiveAdCardWindow", "", "canShowLiveAdLandingPageDialogFragment", "clearAdParamsInLiveContainer", "", "commitCardRemove", "Lio/reactivex/disposables/Disposable;", "cardSwitchRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardRemoveRequest;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdNetWorkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCommitRemoveResp;", "getCardCount", "cardCountRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountResp;", "getCurrentRoomInfo", "Lorg/json/JSONObject;", "activity", "Landroidx/fragment/app/FragmentActivity;", "initLiveParamsBeforeOpenMiniApp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "putAdParamsToLiveContainer", "adParams", "enterFrom", "roomId", "updateCurrentRoomInfo", "key", "value", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveAdServiceImpl implements ILiveAdService {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ILiveAdNetWorkCallback a;

        public a(ILiveAdNetWorkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveAdNetWorkCallback r0 = this.a;
            r0.onSuccess((CardCommitRemoveResp) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ILiveAdNetWorkCallback a;

        public b(ILiveAdNetWorkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveAdNetWorkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ILiveAdNetWorkCallback a;

        public c(ILiveAdNetWorkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveAdNetWorkCallback r0 = this.a;
            r0.onSuccess((CardCountResp) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ILiveAdNetWorkCallback a;

        public d(ILiveAdNetWorkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveAdNetWorkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public LiveAdServiceImpl() {
    }

    public boolean canShowLiveAdCardWindow() {
        return true;
    }

    public boolean canShowLiveAdLandingPageDialogFragment() {
        return true;
    }

    public void clearAdParamsInLiveContainer() {
        JSONObject r0 = a3.a;
        a3.a = null;
    }

    public HashMap<String, String> initLiveParamsBeforeOpenMiniApp() {
        int r0 = k0.a;
        Room r4 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L7;
        m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        r4 = (Room) r2.getValue();
    L7:
        HashMap<String, String> r3 = k0.c(r4);
        r3.put("scene", "025001");
        r3.put("enterFrom", "ad");
        return r3;
    }

    public JSONObject getCurrentRoomInfo(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return new JSONObject((String) ViewModelProviders.of(r2).get(LiveAdViewModel.class).getMobData().getValue());
    L5:
        return null;
    }

    public Disposable commitCardRemove(CardRemoveRequest r4, ILiveAdNetWorkCallback<CardCommitRemoveResp> r5) {
        Intrinsics.checkNotNullParameter(r4, "cardSwitchRequest");
        Intrinsics.checkNotNullParameter(r5, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/aweme/v1/commerce/webcast/card/remove/all/");
        return ((ILiveAdApi) com.bytedance.android.live.network.c.b().e(ILiveAdApi.class)).commitCardSwitch(r2, r4.getSecUid(), r4.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r5), new b(r5));
    L6:
        r1 = "";
        goto L7
    }

    public Disposable getCardCount(CardCountRequest r4, ILiveAdNetWorkCallback<CardCountResp> r5) {
        Intrinsics.checkNotNullParameter(r4, "cardCountRequest");
        Intrinsics.checkNotNullParameter(r5, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/aweme/v1/commerce/webcast/card/count/");
        return ((ILiveAdApi) com.bytedance.android.live.network.c.b().e(ILiveAdApi.class)).getCardCount(r2, r4.getSecUid(), r4.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r5), new d(r5));
    L6:
        r1 = "";
        goto L7
    }

    public void putAdParamsToLiveContainer(JSONObject r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "adParams");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        Intrinsics.checkNotNullParameter(r6, "roomId");
        JSONObject r2 = a3.a;
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        Intrinsics.checkNotNullParameter(r6, "roomId");
        a3.b = r5;
        a3.c = r6;
        Intrinsics.checkNotNullParameter(r4, "params");
        a3.a = r4;
    }

    public void updateCurrentRoomInfo(FragmentActivity r2, String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        JSONObject r0 = getCurrentRoomInfo(r2);
        if (r0 == null) goto L5;
        r0.put(r3, r4);
    L5:
        LiveAdViewModel r5 = ViewModelProviders.of(r2).get(LiveAdViewModel.class);
        if (r0 == null) goto L9;
        r5.getMobData().setValue(r0.toString());
        return;
    }
}

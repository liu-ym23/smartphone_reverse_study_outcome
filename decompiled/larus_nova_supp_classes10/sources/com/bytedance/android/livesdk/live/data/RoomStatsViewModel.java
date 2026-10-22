package com.bytedance.android.livesdk.live.data;

import ac2.e;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdk.chatroom.model.b3;
import com.bytedance.android.livesdk.chatroom.model.s;
import com.bytedance.android.livesdk.chatroom.model.w3;
import com.bytedance.android.livesdk.live.api.RoomStatApi;
import com.bytedance.android.livesdk.live.api.RoomStateApi;
import com.bytedance.android.livesdk.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveInnerCheckLiveConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kf2.i;
import kf2.j;
import kf2.k;
import kf2.l;
import ng2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RoomStatsViewModel extends RxViewModel {
    private final boolean mChangeRequest;
    private final List<String> mEnterFrom;
    private final MutableLiveData<Map<String, f>> mRoomStatsResponse;

    public class a extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public static /* synthetic */ void Mo(RoomStatsViewModel r0, ListResponse r1) {
        r0.lambda$getRoomStats$2(r1);
    }

    public static /* synthetic */ void No(RoomStatsViewModel r0, Throwable r1) {
        r0.lambda$getRoomStats$1(r1);
    }

    public static /* synthetic */ void Oo(RoomStatsViewModel r0, List r1, List r2, s r3) {
        r0.lambda$getRoomStats$0(r1, r2, r3);
    }

    public static /* synthetic */ void yo(RoomStatsViewModel r0, Throwable r1) {
        r0.lambda$getRoomStats$3(r1);
    }

    public RoomStatsViewModel() {
        this.mRoomStatsResponse = new MutableLiveData();
        x0 r0 = x0.a;
        this.mChangeRequest = ((LiveInnerCheckLiveConfig) r0.getValue()).getChangeRequest();
        this.mEnterFrom = ((LiveInnerCheckLiveConfig) r0.getValue()).getLiveEntranceList();
    }

    public MutableLiveData<Map<String, f>> getRoomStatsResponse() {
        return this.mRoomStatsResponse;
    }

    private /* synthetic */ void lambda$getRoomStats$1(Throwable r2) throws Exception {
        this.mRoomStatsResponse.setValue(new HashMap());
    }

    private /* synthetic */ void lambda$getRoomStats$2(ListResponse r5) throws Exception {
        if (Lists.isEmpty(((BaseListResponse) r5).data) == true) goto L11;
        HashMap r0 = new HashMap();
        Iterator r6 = ((BaseListResponse) r5).data.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        f r1 = (f) r6.next();
        r0.put(String.valueOf(r1.roomId), r1);
        goto L6
    L8:
        this.mRoomStatsResponse.setValue(r0);
        return;
    }

    private /* synthetic */ void lambda$getRoomStats$3(Throwable r2) throws Exception {
        this.mRoomStatsResponse.setValue(new HashMap());
    }

    private boolean changeRequestEnable(String r3, String r4) {
        if (this.mEnterFrom != null) goto L5;
        return false;
    L5:
        String r5 = r3 + "-" + r4;
        if (this.mChangeRequest == true) goto L8;
        return false;
    L8:
        if (this.mEnterFrom.contains(r5) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ void lambda$getRoomStats$0(List r9, List r10, s r11) throws Exception {
        if (Lists.notEmpty(r11.a()) == false) goto L38;
        HashMap r0 = new HashMap();
        List r12 = ((b3) ListProtector.get(r11.a(), 0)).b();
        if (Lists.notEmpty(r12) == false) goto L19;
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L19;
        w3 r2 = (w3) r13.next();
        f r3 = new f();
        r3.roomId = r2.c();
        if (r2.b() != 1) goto L12;
        boolean r4 = true;
    L13:
        r3.alive = r4;
        long r6 = ((Long) ListProtector.get(r10, r9.indexOf(String.valueOf(r2.d())))).longValue();
        if (r2.b() != 1) goto L18;
        if (r2.c() == r6) goto L18;
        r3.roomId = r6;
        r3.alive = false;
    L18:
        r0.put(String.valueOf(r3.roomId), r3);
        goto L8
    L12:
        r4 = false;
    L19:
        int r14 = 0;
    L21:
        if (r14 >= r10.size()) goto L28;
        long r5 = ((Long) ListProtector.get(r10, r14)).longValue();
        String r7 = (String) ListProtector.get(r9, r14);
        if (r0.containsKey(String.valueOf(r5)) == true) goto L27;
        if (n0.b(r7) == false) goto L27;
        f r8 = new f();
        r8.roomId = r5;
        r8.alive = false;
        r0.put(String.valueOf(ListProtector.get(r10, r14)), r8);
    L27:
        r14 = r14 + 1;
        goto L21
    L28:
        this.mRoomStatsResponse.setValue(r0);
        return;
    }

    public void getRoomStats(List<Room> r17, String r18, String r19) {
        if (Lists.isEmpty(r17) == false) goto L6;
        this.mRoomStatsResponse.setValue(new HashMap());
        return;
    L6:
        final LinkedList r1 = new LinkedList();
        final LinkedList r2 = new LinkedList();
        LinkedList r3 = new LinkedList();
        Iterator<Room> r4 = r17.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Room r5 = r4.next();
        if (r5 == null) goto L8;
        r1.add(Long.valueOf(r5.getId()));
        r3.add(3);
        r2.add(r5.getOwnerUserIdString());
        goto L8
    L12:
        String r6 = TextUtils.join(",", r1);
        String r8 = TextUtils.join(",", r3);
        String r7 = TextUtils.join(",", r2);
        a r9 = new a();
        String r13 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(r9).second;
        if (changeRequestEnable(r18, r19) == true) goto L15;
        ((RoomStatApi) c.b().e(RoomStatApi.class)).checkRoom(r13, r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this), new l(this));
        return;
    L15:
        if (((LiveInnerCheckLiveConfig) x0.a.getValue()).getReportUseBytelink() == false) goto L17;
        RoomStateApi r10 = (RoomStateApi) e.b().a(RoomStateApi.class);
    L18:
        r10.checkUserLiveStatus(r7, r8, null, null, null, null, r13, "inner_interval", null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r2, r1), new j(this));
        return;
    L17:
        r10 = (RoomStateApi) c.b().e(RoomStateApi.class);
        goto L18
    }
}

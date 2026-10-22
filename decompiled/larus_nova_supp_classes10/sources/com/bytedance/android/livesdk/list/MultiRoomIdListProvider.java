package com.bytedance.android.livesdk.list;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.te1;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import if2.b;
import if2.d;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import vh7.c;
import yh0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class MultiRoomIdListProvider extends ILiveRoomListProvider implements LifecycleObserver {
    public final List<Long> a;
    public final Map<Long, Integer> b;
    public final List<Boolean> c;
    public final List<Long> d;
    public final List<Long> e;
    public List<Room> f;
    public final List<Bundle> g;
    public final Bundle h;
    public Disposable i;
    public Map<String, IRoom> j;
    public boolean k;
    public int l;
    public final boolean m;
    public boolean n;
    public CompositeDisposable o;
    public int p;
    public volatile boolean q;
    public a r;
    public List<Room> s;

    public final void alterSpecificItem(int r1, FeedItem r2) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.n = true;
        Disposable r0 = this.i;
        if (r0 == null) goto L5;
        r0.dispose();
        this.i = null;
    L5:
        CompositeDisposable r1 = this.o;
        if (r1 == null) goto L8;
        r1.dispose();
        this.o = null;
    L8:
        this.r = null;
    }

    public final String providerType() {
        return "MultiRoomIdListProvider";
    }

    public final List<Room> getRoomList() {
        List<Room> r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ArrayList();
    }

    public final int size() {
        return ((ArrayList) this.a).size();
    }

    public final List<Room> getPreloadRooms() {
        return this.s;
    }

    public final void addPreloadRooms(List<Room> r2) {
        if (Lists.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (this.s != null) goto L8;
        this.s = new ArrayList();
    L8:
        this.s.clear();
        this.s.addAll(r2);
    }

    public final Bundle getRoomArgs(int r10) {
        loadMore(r10);
        if (CollectionUtils.isEmpty(this.g) == false) goto L5;
    L8:
        Bundle r0 = new Bundle();
        Bundle r1 = this.h;
        if (r1 == null) goto L21;
        long r5 = r1.getLong("live.intent.extra.ROOM_ID");
        if (r5 <= 0) goto L21;
        if (r5 != ((Long) ListProtector.get(this.a, r10)).longValue()) goto L21;
        if (this.k == false) goto L17;
    L18:
        r0 = new Bundle(this.h);
        this.k = false;
        this.l = r10;
        Map<Long, Integer> r2 = this.b;
        HashMap r3 = (HashMap) r2;
        if (r3.containsKey(Long.valueOf(r5)) == false) goto L21;
        String r4 = VSConstants.EXTRA_ITEM_TYPE;
        Map<Long, Integer> r7 = this.b;
        HashMap r8 = (HashMap) r7;
        r0.putInt(r4, ((Integer) r8.get(Long.valueOf(r5))).intValue());
        goto L21
    L17:
        if (this.l == r10) goto L18;
    L21:
        if (r10 >= 0) goto L23;
    L33:
        if (r10 >= 0) goto L35;
    L37:
        if (r10 >= 0) goto L39;
    L45:
        if (r10 >= 0) goto L47;
    L53:
        return r0;
    L47:
        if (r10 >= ((ArrayList) this.e).size()) goto L53;
        if (ListProtector.get(this.e, r10) == null) goto L53;
        if (((Long) ListProtector.get(this.e, r10)).longValue() == 0) goto L53;
        r0.putString("joint_anchor_id", ((Long) ListProtector.get(this.e, r10)).toString());
        goto L53
    L39:
        if (r10 >= ((ArrayList) this.d).size()) goto L45;
        if (ListProtector.get(this.d, r10) == null) goto L45;
        if (((Long) ListProtector.get(this.d, r10)).longValue() == 0) goto L45;
        r0.putString("link_user_id", ((Long) ListProtector.get(this.d, r10)).toString());
        goto L45
    L35:
        if (r10 >= ((ArrayList) this.c).size()) goto L37;
        r0.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", ((Boolean) ListProtector.get(this.c, r10)).booleanValue());
        goto L37
    L23:
        if (r10 >= ((ArrayList) this.a).size()) goto L33;
        r0.putLong("live.intent.extra.ROOM_ID", ((Long) ListProtector.get(this.a, r10)).longValue());
        long r6 = ((Long) ListProtector.get(this.a, r10)).longValue();
        Map<String, IRoom> r9 = this.j;
        if (r9 == null) goto L29;
        HashMap r11 = (HashMap) r9;
        Room r12 = jm2.a.e((c) r11.get(String.valueOf(r6)));
        if (r12 == null) goto L29;
        String r13 = r12.getOwnerUserIdString();
    L30:
        r0.putString("anchor_id", r13);
        r0.putString("live.intent.extra.LOG_PB", this.h.getString("live.intent.extra.LOG_PB", ""));
        r0.putString("live.intent.extra.REQUEST_ID", this.h.getString("live.intent.extra.REQUEST_ID", ""));
        Map<Long, Integer> r14 = this.b;
        HashMap r15 = (HashMap) r14;
        if (r15.containsKey(ListProtector.get(this.a, r10)) == false) goto L33;
        String r16 = VSConstants.EXTRA_ITEM_TYPE;
        Map<Long, Integer> r17 = this.b;
        HashMap r18 = (HashMap) r17;
        r0.putInt(r16, ((Integer) r18.get(ListProtector.get(this.a, r10))).intValue());
    L29:
        r13 = BDLocationException.ERROR_TIMEOUT;
        goto L30
    L5:
        if (((ArrayList) this.g).size() <= r10) goto L8;
        return (Bundle) ListProtector.get(this.g, r10);
    }

    public final int indexOf(Bundle r7) {
        List<Boolean> r0 = this.c;
        if (r0 != null) goto L5;
    L17:
        long r1 = r7.getLong("live.intent.extra.ROOM_ID");
        List<Long> r8 = this.a;
        ArrayList r9 = (ArrayList) r8;
        return r9.indexOf(Long.valueOf(r1));
    L5:
        if (((ArrayList) r0).size() != ((ArrayList) this.a).size()) goto L17;
        long r2 = r7.getLong("live.intent.extra.ROOM_ID");
        boolean r10 = r7.getBoolean("live.intent.extra.IS_PSEUDO_LIVING");
        int r3 = 0;
    L8:
        if (r3 >= ((ArrayList) this.a).size()) goto L15;
        if (r2 != ((Long) ListProtector.get(this.a, r3)).longValue()) goto L14;
        if (r10 != ((Boolean) ListProtector.get(this.c, r3)).booleanValue()) goto L14;
        return r3;
    L14:
        r3 = r3 + 1;
        goto L8
    L15:
        return -1;
    }

    public final void loadMore(final int r7) {
        if (this.n == false) goto L6;
        return;
    L6:
        if (((Boolean) te1.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (this.m == true) goto L10;
        return;
    L10:
        if (this.f != null) goto L13;
        return;
    L13:
        if (this.q == false) goto L16;
        return;
    L16:
        if ((r7 + 5) >= this.f.size()) goto L19;
        return;
    L19:
        if (this.f.size() < this.a.size()) goto L22;
        return;
    L22:
        if (k.f(IRoomModuleService.class) != null) goto L24;
        return;
    L24:
        final int r0 = this.f.size();
        int r1 = Math.min(this.a.size(), r0 + 20) - r0;
        final long[] r2 = new long[r1];
        int r3 = 0;
    L25:
        if (r3 >= r1) goto L31;
        Long r4 = (Long) ListProtector.get(this.a, r0 + r3);
        if (r4 != null) goto L29;
        long r5 = 0;
    L30:
        r2[r3] = r5;
        r3 = r3 + 1;
        goto L25
    L29:
        r5 = r4.longValue();
        goto L30
    L31:
        this.q = true;
        Disposable r8 = k.f(IRoomModuleService.class).getRoomManager().p0(r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new if2.a(this, r2, r0, r7), new b(this, r7));
        CompositeDisposable r6 = this.o;
        if (r6 == null) goto L40;
        r6.add(r8);
        return;
    }

    public final void removeRoom(long r5) {
        if (CollectionUtils.isEmpty(this.a) == false) goto L6;
        return;
    L6:
        if (((ArrayList) this.a).size() != 1) goto L8;
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= ((ArrayList) this.a).size()) goto L36;
        if (((Long) ListProtector.get(this.a, r0)).longValue() == r5) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        ListProtector.remove(this.a, r0);
        if (((ArrayList) this.g).size() <= r0) goto L16;
        ListProtector.remove(this.g, r0);
    L16:
        List<Room> r6 = this.f;
        if (r6 != null) goto L19;
    L21:
        List<Long> r7 = this.d;
        if (r7 != null) goto L24;
    L26:
        List<Long> r8 = this.e;
        if (r8 != null) goto L29;
    L31:
        dispatchChange();
        return;
    L29:
        if (((ArrayList) r8).size() <= r0) goto L31;
        ListProtector.remove(this.e, r0);
        goto L31
    L24:
        if (((ArrayList) r7).size() <= r0) goto L26;
        ListProtector.remove(this.d, r0);
        goto L26
    L19:
        if (r6.size() <= r0) goto L21;
        ListProtector.remove(this.f, r0);
        goto L21
    }

    public MultiRoomIdListProvider(Lifecycle r4, List<Long> r5, List<Integer> r6, List<Boolean> r7, Bundle r8, boolean r9, List<Long> r10, List<Long> r11) {
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.k = true;
        this.l = -1;
        int r0 = 0;
        this.m = false;
        this.n = false;
        this.o = new CompositeDisposable();
        this.p = 2;
        this.q = false;
        this.r = k.f(IRadioService.class).createRadioBundleInserter();
        this.s = new ArrayList();
        this.m = r9;
        this.h = r8;
        int r12 = 0;
    L3:
        ArrayList r13 = (ArrayList) r5;
        if (r12 >= r13.size()) goto L15;
        List<Long> r14 = this.a;
        ArrayList r15 = (ArrayList) r14;
        r15.add((Long) ListProtector.get(r5, r12));
        if (r12 >= ((ArrayList) r6).size()) goto L9;
        Map<Long, Integer> r16 = this.b;
        HashMap r17 = (HashMap) r16;
        r17.put((Long) ListProtector.get(r5, r12), (Integer) ListProtector.get(r6, r12));
    L9:
        if (r12 >= ((ArrayList) r10).size()) goto L12;
        List<Long> r18 = this.d;
        ArrayList r19 = (ArrayList) r18;
        r19.add((Long) ListProtector.get(r10, r12));
    L12:
        if (r12 >= ((ArrayList) r11).size()) goto L14;
        List<Long> r20 = this.e;
        ArrayList r21 = (ArrayList) r20;
        r21.add((Long) ListProtector.get(r11, r12));
    L14:
        r12 = r12 + 1;
        goto L3
    L15:
        ArrayList r22 = (ArrayList) r7;
        if (r22.size() != ((ArrayList) this.a).size()) goto L21;
        int r23 = 0;
    L19:
        if (r23 >= r22.size()) goto L21;
        List<Boolean> r24 = this.c;
        ArrayList r25 = (ArrayList) r24;
        r25.add((Boolean) ListProtector.get(r7, r23));
        r23 = r23 + 1;
    L21:
        r4.addObserver(this);
        if (((Boolean) te1.a.getValue()).booleanValue() == true) goto L24;
    L26:
        long[] r26 = new long[r13.size()];
    L28:
        if (r0 >= r13.size()) goto L35;
        Long r27 = (Long) ListProtector.get(this.a, r0);
        if (r27 != null) goto L32;
        long r28 = 0;
    L33:
        r26[r0] = r28;
        r0 = r0 + 1;
        goto L28
    L32:
        r28 = r27.longValue();
        goto L33
    L35:
        if (k.f(IRoomModuleService.class) == null) goto L46;
        this.i = k.f(IRoomModuleService.class).getRoomManager().p0(r26).observeOn(AndroidSchedulers.mainThread()).subscribe(new if2.c(this), new d());
        return;
    L46:
        return;
    L24:
        if (this.m == false) goto L26;
        this.f = new ArrayList();
        loadMore(0);
    }
}

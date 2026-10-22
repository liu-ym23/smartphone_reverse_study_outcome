package com.bytedance.android.livesdk.live.listprovider;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.my;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdkapi.depend.model.live.IGameCPData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfigV2;
import com.bytedance.android.livesdkapi.service.IMultiTabRoomCache;
import com.bytedance.android.livesdkapi.service.XTabRoomCacheService;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class DouyinXTabListProvider extends ILiveRoomListProvider implements pg2.e, com.bytedance.android.livesdk.landscapeslide.b {
    public final ArrayList<Room> a;
    public final ArrayList<Bundle> b;
    public boolean c;
    public final long d;
    public final Lazy e;
    public final Lazy f;
    public int g;
    public final boolean h;
    public final Lazy i;
    public ArrayList<Room> j;
    public LiveLandSlideContext k;
    public int l;
    public final Bundle m;
    public final LifecycleOwner n;
    public final String o;
    public int p;

    public static final class a {
    }

    static {
    }

    @Override // pg2.e
    public final /* synthetic */ void b(int r1) {
    }

    @Override // pg2.e
    public final String j() {
        return "";
    }

    @Override // pg2.e
    public final String k() {
        return "";
    }

    @Override // pg2.e
    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
    }

    @Override // pg2.e
    public final void m(pg2.i r1) {
    }

    public final IMultiTabRoomCache o() {
        return (IMultiTabRoomCache) this.i.getValue();
    }

    public final String providerType() {
        return "DouyinXTabListProvider";
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int e() {
        return Math.max(this.l, 0);
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void h() {
        LiveLandSlideContext r0 = this.k;
        if (r0 == null) goto L19;
        long r4 = r0.getCurrentRoomId();
        int r1 = r0.getRelateRoomIndex() - 1;
        ArrayList<Room> r6 = this.j;
        if (r4 == 0) goto L7;
        Long r2 = Long.valueOf(r4);
    L20:
        o().setLandscape(false);
        ArrayList<Room> r5 = this.j;
        if (r5 == null) goto L42;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<Room> r8 = r5.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        r7.add(Long.valueOf(r8.next().id));
        goto L24
    L26:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L28:
        if (r10.hasNext() == false) goto L38;
        Object r11 = r10.next();
        long r12 = ((Number) r11).longValue();
        if (r2 != null) goto L33;
    L34:
        boolean r13 = true;
    L36:
        if (r13 == false) goto L28;
        r9.add(r11);
        goto L28
    L33:
        if (r12 != r2.longValue()) goto L34;
        r13 = false;
        goto L36
    L38:
        Iterator r3 = r9.iterator();
    L40:
        if (r3.hasNext() == false) goto L42;
        n(((Number) r3.next()).longValue(), DouyinXTabListProvider$doRemoveRoom$1.INSTANCE);
    L42:
        o().onRestoreItem();
        StringBuilder r14 = new StringBuilder("quitLand size: ");
        r14.append(this.a.size());
        r14.append(" internal: ");
        ArrayList<Room> r15 = this.j;
        if (r15 == null) goto L45;
        Integer r16 = Integer.valueOf(r15.size());
    L46:
        r14.append(r16);
        p(r14.toString());
        this.j = null;
        this.k = null;
        this.l = -1;
        return;
    L45:
        r16 = null;
        goto L46
    L7:
        if (r6 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == true) goto L19;
        int r18 = r6.size();
        if (r1 < 0) goto L19;
        if (r18 <= r1) goto L19;
        r2 = Long.valueOf(((Room) ListProtector.get(r6, r1)).getRoomId());
        goto L20
    L9:
        if (r6.isEmpty() == true) goto L12;
        r17 = false;
    L19:
        r2 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final int i() {
        ArrayList<Room> r0 = this.j;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final int size() {
        return this.b.size();
    }

    @Override // pg2.e
    public final boolean d() {
        if (o().getContentCategory() == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void release() {
        super.release();
        o().setInRoom(false);
    }

    public final List<Room> getRoomList() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void a(int r3) {
        p("loadLand index: " + r3 + " isRunning: " + this.c);
        loadMore(r3);
    }

    @Override // pg2.e
    public final void f(int r1) {
        loadMore(r1);
    }

    public final Bundle getRoomArgs(int r4) {
        if (r4 >= this.b.size()) goto L24;
        if (r4 >= this.a.size()) goto L24;
        if (r4 < 0) goto L24;
        Bundle r0 = (Bundle) ListProtector.get(this.b, r4);
        Room r5 = (Room) ListProtector.get(this.a, r4);
        r0.putString("is_similar", r5.getContentCategory());
        if ((!Intrinsics.areEqual(r5.getContentCategory(), "1")) == true) goto L10;
    L12:
        r0.putString("live.intent.extra.sub_tab_unique_label", this.o);
        if (((Boolean) my.a.getValue()).booleanValue() == false) goto L22;
        IGameCPData r6 = r5.getGameCPData();
        if (r6 == null) goto L20;
        Long r7 = r6.getPromoteInstanceId();
        if (r7 == null) goto L20;
        String r8 = String.valueOf(r7.longValue());
        if (r8 == null) goto L20;
    L21:
        r0.putString("promote_instance_id", r8);
    L20:
        r8 = "";
    L22:
        return r0;
    L10:
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.e() == false) goto L12;
        r0.putString("live.intent.extra.LIVE_FOLLOW_RECOMMEND_UNREAD_EXTRA", "homepage_tablive_live_cell");
    L24:
        return new Bundle();
    }

    public final int indexOf(Bundle r12) {
        if (XTabRoomCacheService.INSTANCE.isDuplicateOpt() == true) goto L5;
    L25:
        long r4 = -1;
        if (r12 == null) goto L28;
        r4 = r12.getLong("live.intent.extra.ROOM_ID", -1);
    L28:
        int r13 = this.b.size();
        int r6 = 0;
    L29:
        if (r6 >= r13) goto L41;
        Object r7 = ListProtector.get(this.b, r6);
        if (((Bundle) r7).getLong("live.intent.extra.ROOM_ID", 0) != r4) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == true) goto L38;
        r7 = null;
    L38:
        if (((Bundle) r7) != null) goto L39;
        r6 = r6 + 1;
        goto L29
    L39:
        return r6;
    L33:
        r8 = false;
        goto L34
    L41:
        return -1;
    L5:
        if (r12 == null) goto L7;
        String r5 = r12.getString("live.intent.extra.EXTRA_ROOM_UNIQUE_KEY");
    L8:
        if (r5 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == true) goto L25;
        int r10 = this.b.size();
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L25;
        Object r14 = ListProtector.get(this.b, r11);
        if (Intrinsics.areEqual(((Bundle) r14).getString("live.intent.extra.EXTRA_ROOM_UNIQUE_KEY"), r5) == true) goto L22;
        r14 = null;
    L22:
        if (((Bundle) r14) != null) goto L23;
        r11 = r11 + 1;
        goto L16
    L23:
        return r11;
    L10:
        if (StringsKt.isBlank(r5) == true) goto L13;
        r9 = false;
        goto L14
    L7:
        r5 = null;
        goto L8
    }

    public final void loadMore(int r2) {
        this.c = true;
        o().triggerLoadMore(r2);
    }

    public final void p(String r3) {
        com.bytedance.android.livesdk.landscapeslide.f.d("XTab: " + r3);
    }

    public final void removeRoom(final long r2) {
        n(r2, new AnonymousClass1(this, r2));
    }

    @Override // com.bytedance.android.livesdk.landscapeslide.b
    public final void c(int r12, LiveLandSlideContext r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        StringBuilder r0 = new StringBuilder("initLand: ");
        r0.append(r12);
        r0.append(" list: ");
        ArrayList<Room> r1 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<Room> r3 = r1.iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Room r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Room r8 = r6;
        StringBuilder r9 = new StringBuilder();
        if (r5 != r12) goto L11;
        String r10 = "*";
    L12:
        r9.append(r10);
        r9.append(r8.getRoomId() % ((long) 10000));
        r2.add(r9.toString());
        r5 = r7;
        goto L4
    L11:
        r10 = "";
        goto L12
    L13:
        r0.append(r2);
        p(r0.toString());
        this.k = r13;
        this.j = new ArrayList();
        this.l = r12;
        ArrayList<Room> r14 = this.a;
        ArrayList r4 = new ArrayList();
        Iterator<Room> r15 = r14.iterator();
        int r11 = 0;
    L14:
        boolean r16 = true;
        if (r15.hasNext() == false) goto L26;
        Room r17 = r15.next();
        int r18 = r11 + 1;
        if (r11 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        if (r11 > r12) goto L23;
        r16 = false;
    L23:
        if (r16 == false) goto L25;
        r4.add(r17);
    L25:
        r11 = r18;
        goto L14
    L26:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r20 = r4.iterator();
    L28:
        if (r20.hasNext() == false) goto L30;
        r19.add(Long.valueOf(((Room) r20.next()).getRoomId()));
        goto L28
    L30:
        Set r110 = CollectionsKt.toSet(r19);
        p("initLand store list: " + r110.size());
        IMultiTabRoomCache r21 = o();
        Set r111 = r110;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r23 = r111.iterator();
    L32:
        if (r23.hasNext() == false) goto L34;
        r22.add(String.valueOf(((Number) r23.next()).longValue()));
        goto L32
    L34:
        r21.onStoreItem(CollectionsKt.toSet(r22));
        Iterator r112 = r111.iterator();
    L36:
        if (r112.hasNext() == false) goto L38;
        n(((Number) r112.next()).longValue(), DouyinXTabListProvider$doRemoveRoom$1.INSTANCE);
        goto L36
    L38:
        o().setLandscape(true);
        a(r12);
    }

    @Override // pg2.e
    public final void g(long r2, int r4) {
        this.p = r4;
        ALogger.i("DouyinXTabListProvider", "onRoomShow roomId:" + r2 + ", currentIndex: " + this.p);
    }

    public final void n(long r6, Function1<? super Integer, Unit> r8) {
        if (CollectionUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(this.b) == false) goto L8;
        return;
    L8:
        if (this.c == false) goto L10;
    L12:
        int r0 = this.a.size();
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L29;
        if (((Room) ListProtector.get(this.a, r1)).id == r6) goto L17;
        r1 = r1 + 1;
        goto L13
    L17:
        if (this.b.size() <= r1) goto L20;
        ListProtector.remove(this.b, r1);
    L20:
        if (this.a.size() <= r1) goto L22;
        ListProtector.remove(this.a, r1);
    L22:
        o().removeRoom(r6);
        r8.invoke(Integer.valueOf(r1));
        return;
    L29:
        return;
    L10:
        if (this.a.size() != 1) goto L12;
    }

    public DouyinXTabListProvider(Bundle r3, List r4, Fragment r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "roomArgs");
        Intrinsics.checkNotNullParameter(r4, "initialRoomList");
        Intrinsics.checkNotNullParameter(r5, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r6, "tabUniqueLabel");
        this.m = r3;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        ArrayList<Room> r8 = new ArrayList();
        this.a = r8;
        this.b = new ArrayList();
        this.d = r3.getLong("live.intent.extra.ROOM_ID");
        this.e = LazyKt.lazy(DouyinXTabListProvider$liveRoomMemoryOpt$2.INSTANCE);
        this.f = LazyKt.lazy(DouyinXTabListProvider$roomMemoryOptV2$2.INSTANCE);
        this.h = XTabRoomCacheService.validTabLabel(r6);
        this.i = LazyKt.lazy(new DouyinXTabListProvider$tabRoomCacheService$2(this));
        r8.addAll(r4);
        int r9 = r8.size();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L10;
        if (((Room) ListProtector.get(this.a, r10)).id != this.d) goto L7;
        this.b.add(this.m);
    L8:
        r10 = r10 + 1;
        goto L3
    L7:
        this.b.add(ArgumentsBuilder.buildRoomArgs((Room) ListProtector.get(this.a, r10)));
        goto L8
    L10:
        if (((LiveRoomMemoryOptConfig) this.e.getValue()).getEnable() == false) goto L12;
        ALogger.i("DouyinXTabListProvider", "Memory opt: limit maxCacheCount = " + ((LiveRoomMemoryOptConfig) this.e.getValue()).getMaxCacheCount());
    L12:
        o().setInRoom(true);
        ALogger.i("DouyinXTabListProvider", "init roomId:" + this.d + ", currentIndex: " + this.p + ", cacheCountV2:" + ((LiveRoomMemoryOptConfigV2) this.f.getValue()).getMaxCacheCount());
        o().getDataUpdate().observe(this.n, new com.bytedance.android.livesdk.live.listprovider.a(this));
        this.l = -1;
    }
}

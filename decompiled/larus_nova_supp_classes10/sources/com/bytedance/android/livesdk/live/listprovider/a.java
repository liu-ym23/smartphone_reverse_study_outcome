package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfigV2;
import com.bytedance.android.livesdkapi.service.XTabRoomCacheService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ DouyinXTabListProvider a;

    public a(DouyinXTabListProvider r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Integer r10 = (Integer) r9;
        this.a.a.clear();
        DouyinXTabListProvider r11 = this.a;
        r11.a.addAll(r11.o().getRoomList());
        DouyinXTabListProvider r12 = this.a;
        int r0 = ((LiveRoomMemoryOptConfig) r12.e.getValue()).getMaxCacheCount();
        if (((LiveRoomMemoryOptConfig) r12.e.getValue()).getEnable() == true) goto L5;
    L16:
        DouyinXTabListProvider r13 = this.a;
        int r1 = ((LiveRoomMemoryOptConfigV2) r13.f.getValue()).getMaxCacheCount();
        if (((LiveRoomMemoryOptConfigV2) r13.f.getValue()).getEnable() == false) goto L37;
        if (r13.a.size() <= r1) goto L37;
        if (r1 <= 0) goto L37;
        int r2 = (r13.a.size() - r1) - 3;
        int r3 = r13.p - 3;
        if (r2 <= r3) goto L24;
        r2 = r3;
    L24:
        if (r2 < 0) goto L37;
        ArrayList r4 = new ArrayList();
        int r5 = 0;
    L27:
        if (r5 >= r2) goto L32;
        if (r5 >= r13.a.size()) goto L31;
        r4.add(Long.valueOf(((Room) ListProtector.get(r13.a, r5)).getRoomId()));
    L31:
        r5 = r5 + 1;
        goto L27
    L32:
        ALogger.i("DouyinXTabListProvider", "optRoomListCacheV2 canRemoveRoomIds.size:" + r4.size() + ", optIndex:" + r2 + ", currentIndex:" + r13.p + "， roomIds: " + r4);
        Iterator r6 = r4.iterator();
    L34:
        if (r6.hasNext() == false) goto L37;
        r13.n(((Number) r6.next()).longValue(), DouyinXTabListProvider$doRemoveRoom$1.INSTANCE);
    L37:
        if (XTabRoomCacheService.INSTANCE.isDuplicateOpt() == false) goto L45;
        this.a.b.clear();
        int r14 = this.a.a.size();
        int r7 = 0;
    L39:
        if (r7 >= r14) goto L53;
        long r8 = ((Room) ListProtector.get(this.a.a, r7)).id;
        DouyinXTabListProvider r15 = this.a;
        if (r8 != r15.d) goto L43;
        r15.b.add(r15.m);
    L44:
        r7 = r7 + 1;
        goto L39
    L43:
        this.a.b.add(ArgumentsBuilder.buildRoomArgs((Room) ListProtector.get(r15.a, r7)));
    L53:
        if (this.a.o().isLandscape() == false) goto L85;
        List r16 = this.a.o().getPrecessRoomList();
        ArrayList<Room> r17 = this.a.j;
        if (r17 == null) goto L57;
        r17.addAll(r16);
    L57:
        DouyinXTabListProvider r18 = this.a;
        StringBuilder r19 = new StringBuilder("update room: ");
        r19.append(this.a.a.size());
        r19.append(" | internal: ");
        ArrayList<Room> r20 = this.a.j;
        if (r20 == null) goto L60;
        Integer r21 = Integer.valueOf(r20.size());
    L61:
        r19.append(r21);
        r18.p(r19.toString());
        ArrayList<Room> r22 = this.a.j;
        if (r22 != null) goto L64;
    L67:
        boolean r23 = true;
    L68:
        if (r23 == true) goto L80;
        LiveLandSlideContext r24 = this.a.k;
        if (r24 == null) goto L74;
        com.bytedance.live.datacontext.m<Boolean> r25 = r24.isDataReady();
        if (r25 == null) goto L74;
        r25.setValue(Boolean.TRUE);
    L74:
        LiveLandSlideContext r26 = this.a.k;
        if (r26 == null) goto L79;
        com.bytedance.live.datacontext.m<Boolean> r27 = r26.isDataEmpty();
        if (r27 == null) goto L79;
        r27.setValue(Boolean.FALSE);
    L79:
        this.a.dispatchChange();
    L86:
        this.a.c = false;
        return;
    L80:
        LiveLandSlideContext r28 = this.a.k;
        if (r28 == null) goto L86;
        com.bytedance.live.datacontext.m<Boolean> r29 = r28.isDataEmpty();
        if (r29 == null) goto L86;
        r29.setValue(Boolean.TRUE);
        goto L86
    L64:
        if (r22.isEmpty() == true) goto L67;
        r23 = false;
        goto L68
    L60:
        r21 = null;
        goto L61
    L85:
        this.a.dispatchChange();
        goto L86
    L45:
        int r30 = this.a.b.size();
        int r31 = this.a.a.size();
    L46:
        if (r30 >= r31) goto L53;
        long r32 = ((Room) ListProtector.get(this.a.a, r30)).id;
        DouyinXTabListProvider r33 = this.a;
        if (r32 != r33.d) goto L50;
        r33.b.add(r33.m);
    L51:
        r30 = r30 + 1;
        goto L46
    L50:
        this.a.b.add(ArgumentsBuilder.buildRoomArgs((Room) ListProtector.get(r33.a, r30)));
        goto L51
    L5:
        if (r12.a.size() <= r0) goto L16;
        if (r0 <= 0) goto L16;
        int r34 = r12.a.size() - r0;
        int r35 = r12.g;
        if (r35 >= r34) goto L16;
    L10:
        if (r35 >= r34) goto L15;
        if (r12.a.size() <= r35) goto L14;
        Room r36 = (Room) ListProtector.get(r12.a, r35);
        Room r37 = new Room();
        r37.id = r36.getRoomId();
        r37.setUserCount(r36.getUserCount());
        r37.setIdStr(r36.getIdStr());
        r37.set_liveReason(r36.getLiveReason());
        r37.setItemExplicitInfo(r36.getItemExplicitInfo());
        r37.withAggregateColumn = r36.withAggregateColumn;
        r37.mVerticalTypeInfo = r36.mVerticalTypeInfo;
        r37.isSimilarRoom = r36.isSimilarRoom;
        User r38 = new User();
        r38.setIdString(r36.getOwnerUserIdString());
        Unit r39 = Unit.INSTANCE;
        r37.setOwner(r38);
        ListProtector.set(r12.a, r35, r37);
    L14:
        r35 = r35 + 1;
        goto L10
    L15:
        r12.g = r34;
        goto L16
    }
}

package com.bytedance.android.livesdk.live.rerank;

import android.os.Bundle;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.k41;
import com.bytedance.android.livesdk.config.u10;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveInnerReRankUtils {
    public static final k41 a = null;

    static {
        a = (k41) u10.a.getValue();
    }

    @JvmStatic
    public static final boolean b() {
        return a.c();
    }

    @JvmStatic
    public static final int c() {
        if (b() == true) goto L7;
        int r0 = k41.a;
        return -1;
    L7:
        return a.d();
    }

    @JvmStatic
    public static final void e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("LiveInnerReRankUtils", r1);
    }

    public static int a(List r2, int r3, Function1 r4) {
        if (r2.isEmpty() == false) goto L5;
        return -1;
    L5:
        if (r3 >= r2.size()) goto L18;
        if (r3 < 0) goto L19;
        int r0 = r2.size();
    L9:
        if (r3 >= r0) goto L20;
        if (((Boolean) r4.invoke(ListProtector.get(r2, r3))).booleanValue() == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return r3;
    L20:
        return -1;
    L19:
        return -1;
    L18:
        return -1;
    }

    public static void d(String r18, List r19, List r20) {
        Intrinsics.checkNotNullParameter(r18, "source");
        if (v.a() == true) goto L5;
        return;
    L5:
        if (a.b() == false) goto L82;
        int r1 = 0;
        boolean r2 = true;
        String r7 = null;
        if (r19 != null) goto L9;
    L40:
        String r8 = null;
    L42:
        if (r20.size() > 0) goto L45;
        r2 = false;
    L45:
        if (r2 == false) goto L47;
        List r3 = r20;
    L48:
        if (r3 == null) goto L73;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L51:
        if (r4.hasNext() == false) goto L72;
        Object r5 = r4.next();
        int r10 = r1 + 1;
        if (r1 >= 0) goto L55;
        CollectionsKt.throwIndexOverflow();
    L55:
        FeedItem r6 = (FeedItem) r5;
        StringBuilder r11 = new StringBuilder();
        r11.append(r1);
        r11.append('_');
        Item r12 = r6.getItem();
        if ((r12 instanceof Room) == true) goto L58;
        r12 = null;
    L58:
        Room r13 = (Room) r12;
        if (r13 == null) goto L61;
        String r14 = r13.getIdStr();
    L62:
        r11.append(r14);
        r11.append('_');
        Item r15 = r6.getItem();
        if ((r15 instanceof Room) == true) goto L65;
        r15 = null;
    L65:
        Room r16 = (Room) r15;
        if (r16 == null) goto L70;
        User r17 = r16.getOwner();
        if (r17 == null) goto L70;
        String r21 = r17.getNickName();
    L71:
        r11.append(r21);
        r11.append("_isHideBucketItem=");
        r11.append(r6.isHideBucketItem());
        r11.append("_content_category=");
        r11.append(r6.contentCategory);
        r9.add(r11.toString());
        r1 = r10;
    L70:
        r21 = null;
        goto L71
    L61:
        r14 = null;
        goto L62
    L72:
        r7 = CollectionsKt.joinToString$default(r9, "\n", null, null, 0, null, null, 62, null);
    L73:
        e(r18 + "->>> curent feed: " + r8 + ", hide feed: " + r7);
        return;
    L47:
        r3 = null;
        goto L48
    L9:
        if (((ArrayList) r19).size() <= 0) goto L11;
        boolean r22 = true;
    L12:
        if (r22 == false) goto L14;
        List r23 = r19;
    L15:
        if (r23 == null) goto L40;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
        int r110 = 0;
    L18:
        if (r25.hasNext() == false) goto L39;
        Object r111 = r25.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        FeedItem r113 = (FeedItem) r111;
        StringBuilder r114 = new StringBuilder();
        r114.append(r110);
        r114.append('_');
        Item r115 = r113.getItem();
        if ((r115 instanceof Room) == true) goto L25;
        r115 = null;
    L25:
        Room r116 = (Room) r115;
        if (r116 == null) goto L28;
        String r117 = r116.getIdStr();
    L29:
        r114.append(r117);
        r114.append('_');
        Item r118 = r113.getItem();
        if ((r118 instanceof Room) == true) goto L32;
        r118 = null;
    L32:
        Room r119 = (Room) r118;
        if (r119 == null) goto L37;
        User r120 = r119.getOwner();
        if (r120 == null) goto L37;
        String r121 = r120.getNickName();
    L38:
        r114.append(r121);
        r114.append("_isHideBucketItem=");
        r114.append(r113.isHideBucketItem());
        r114.append("_content_category=");
        r114.append(r113.contentCategory);
        r24.add(r114.toString());
        r110 = r112;
    L37:
        r121 = null;
        goto L38
    L28:
        r117 = null;
        goto L29
    L39:
        r8 = CollectionsKt.joinToString$default(r24, "\n", null, null, 0, null, null, 62, null);
        goto L42
    L14:
        r23 = null;
        goto L15
    L11:
        r22 = false;
        goto L12
    }

    @JvmStatic
    public static final void f(int r28, int r29, List<FeedItem> r30, List<FeedItem> r31, ArrayList<FeedItem> r32, ArrayList<Bundle> r33, ArrayList<Room> r34, a r35, ILiveRoomListProvider.ReplaceFeedItemsCallback r36, Function0<Unit> r37) {
        int r0 = r28;
        List<FeedItem> r2 = r30;
        ILiveRoomListProvider.ReplaceFeedItemsCallback r7 = r36;
        Intrinsics.checkNotNullParameter(r37, "resultBack");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r32 != null) goto L7;
        return;
    L7:
        if (r33 != null) goto L9;
        return;
    L9:
        if (r34 != null) goto L11;
        return;
    L11:
        if (r35 != null) goto L13;
        return;
    L13:
        List<FeedItem> r9 = r35.c;
        List<Bundle> r11 = r35.b;
        List<Room> r6 = r35.a;
        ArrayList r10 = (ArrayList) r9;
        if ((r30.size() + r29) == (r10.size() + r32.size())) goto L19;
        e("data list has changed");
        if (r7 == null) goto L232;
        r7.onFail("data list has changed", null);
        return;
    L232:
        return;
    L19:
        int r12 = r30.size();
        int r15 = 0;
    L20:
        if (r15 >= r12) goto L53;
        int r14 = r15 + r29;
        if (r14 < 0) goto L38;
        if (r14 >= r32.size()) goto L38;
        Room r13 = ((FeedItem) ListProtector.get(r2, r15)).getRoom();
        if (r13 == null) goto L28;
        Long r16 = Long.valueOf(r13.id);
    L29:
        Room r17 = ((FeedItem) ListProtector.get(r32, r14)).getRoom();
        if (r17 == null) goto L32;
        Long r4 = Long.valueOf(r17.id);
    L34:
        if ((!Intrinsics.areEqual(r16, r4)) == false) goto L38;
    L51:
        boolean r5 = true;
    L54:
        if (r31 != null) goto L56;
    L64:
        boolean r8 = false;
    L65:
        if (r5 == true) goto L71;
        if (r8 == true) goto L71;
        e("data no change, so skip");
        if (r7 == null) goto L233;
        r7.onFail("data no change, so skip", null);
        return;
    L233:
        return;
    L71:
        List r18 = CollectionsKt.toMutableList(r10);
        List r19 = CollectionsKt.toMutableList(r11);
        List r110 = CollectionsKt.toMutableList(r6);
        List r111 = CollectionsKt.toMutableList(r32);
        List r112 = CollectionsKt.toMutableList(r33);
        List r20 = CollectionsKt.toMutableList(r34);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L203
        boolean r114 = r8;
        d("before change", r32, r10);     // Catch: Throwable -> L203
        List<Room> r21 = r6;
        if ((r18.size() + r111.size()) == (r19.size() + r112.size())) goto L75;
    L199:
        e("data size is not equal, occur error");     // Catch: Throwable -> L203
        if (r7 == null) goto L235;
        r7.onFail("data size is not equal, occur error", null);     // Catch: Throwable -> L203
        return;
    L235:
        return;
    L75:
        if ((r18.size() + r111.size()) != (r110.size() + r20.size())) goto L199;
        if ((r19.size() + r112.size()) != (r110.size() + r20.size())) goto L199;
        if (r30.size() > 0) goto L82;
    L94:
        r19 = r19;
        r110 = r110;
    L95:
        boolean r22 = false;
    L96:
        if (r5 == false) goto L165;
        int r23 = r30.size();     // Catch: Throwable -> L203
        int r24 = 0;
        int r115 = 0;
        int r116 = 0;
    L98:
        if (r116 >= r23) goto L165;
        int r117 = r23;
        int r25 = r111.size();     // Catch: Throwable -> L203
        int r26 = r24;
        int r27 = r115;
        int r38 = r29;
    L102:
        if (r38 >= r25) goto L136;
        int r210 = r25;
        Room r39 = ((FeedItem) ListProtector.get(r2, r116)).getRoom();     // Catch: Throwable -> L203
        if (r39 == null) goto L106;
        Long r40 = Long.valueOf(r39.id);     // Catch: Throwable -> L203
    L107:
        Room r41 = ((FeedItem) ListProtector.get(r111, r38)).getRoom();     // Catch: Throwable -> L203
        if (r41 == null) goto L110;
        Long r42 = Long.valueOf(r41.id);     // Catch: Throwable -> L203
    L112:
        if (Intrinsics.areEqual(r40, r42) == true) goto L113;
        r38 = r38 + 1;     // Catch: Throwable -> L203
        r0 = r28;
        r11 = r11;
        r22 = r22;
        r25 = r210;
        r20 = r20;
        r18 = r18;
        r112 = r112;
        goto L102
    L113:
        int r43 = r29 + r116;     // Catch: Throwable -> L203
        if (r38 < r32.size()) goto L116;
    L128:
        ArrayList<Bundle> r118 = r33;
        ArrayList<Room> r119 = r34;
        if ((r43 - r111.size()) >= 0) goto L131;
    L133:
        List<Bundle> r120 = r11;
        List<Room> r44 = r21;
        e("change with feed range illegal =" + r38 + ", after = " + r43);     // Catch: Throwable -> L203
    L134:
        r27 = r43;
        boolean r45 = true;
    L137:
        if (r45 == true) goto L163;
        int r1 = r18.size();     // Catch: Throwable -> L203
        int r46 = 0;
    L139:
        if (r46 >= r1) goto L163;
        int r211 = r1;
        Room r3 = ((FeedItem) ListProtector.get(r2, r116)).getRoom();     // Catch: Throwable -> L203
        if (r3 == null) goto L143;
        Long r47 = Long.valueOf(r3.id);     // Catch: Throwable -> L203
    L144:
        Room r48 = ((FeedItem) ListProtector.get(r18, r46)).getRoom();     // Catch: Throwable -> L203
        if (r48 == null) goto L147;
        Long r49 = Long.valueOf(r48.id);     // Catch: Throwable -> L203
    L149:
        if (Intrinsics.areEqual(r47, r49) == true) goto L150;
        r46 = r46 + 1;     // Catch: Throwable -> L203
        r118 = r33;
        r119 = r34;
        r18 = r18;
        r38 = r38;
        r1 = r211;
        r44 = r44;
        r2 = r30;
        goto L139
    L150:
        int r50 = r29 + r116;     // Catch: Throwable -> L203
        int r51 = r111.size() + r46;     // Catch: Throwable -> L203
        if (r50 >= 0) goto L153;
    L155:
        List r52 = r19;
        List r53 = r110;
        if ((r50 - r111.size()) >= 0) goto L158;
    L160:
        r19 = r52;
        List<Room> r54 = r44;
        e("change with hide range illegal =" + r51 + ", after = " + r50);     // Catch: Throwable -> L203
    L161:
        r115 = r50;
        boolean r55 = true;
    L164:
        e("current change beforeIndex = " + r51 + ", afterIndex = " + r115 + ", curIndex = " + r28 + ", hitBucket = " + r55 + ", hitfeed = " + r45);     // Catch: Throwable -> L203
        r116 = r116 + 1;     // Catch: Throwable -> L203
        r21 = r54;
        r18 = r18;
        r24 = r51;
        r110 = r53;
        r0 = r28;
        r23 = r117;
        r22 = r22;
        r20 = r20;
        r2 = r30;
        r7 = r36;
        r11 = r120;
        r112 = r112;
        goto L98
    L158:
        if ((r50 - r111.size()) >= r18.size()) goto L160;
        ListProtector.set(r10, r50 - r111.size(), ListProtector.get(r18, r46));     // Catch: Throwable -> L203
        ((FeedItem) ListProtector.get(r10, r50 - r111.size())).setHideBucketItem(true);     // Catch: Throwable -> L203
        ListProtector.set(r120, r50 - r111.size(), ListProtector.get(r52, r46));     // Catch: Throwable -> L203
        r19 = r52;
        r54 = r44;
        ListProtector.set(r54, r50 - r111.size(), ListProtector.get(r53, r46));     // Catch: Throwable -> L203
        e("change with hide and hide before =" + r46 + ", after = " + (r50 - r111.size()));     // Catch: Throwable -> L203
        goto L161
    L153:
        if (r50 >= r111.size()) goto L155;
        ListProtector.set(r32, r50, ListProtector.get(r18, r46));     // Catch: Throwable -> L203
        ((FeedItem) ListProtector.get(r32, r50)).setHideBucketItem(false);     // Catch: Throwable -> L203
        List r56 = r19;
        ListProtector.set(r118, r50, ListProtector.get(r56, r46));     // Catch: Throwable -> L203
        r53 = r110;
        ListProtector.set(r119, r50, ListProtector.get(r53, r46));     // Catch: Throwable -> L203
        e("change with feed and hide before =" + r46 + ", after = " + r50);     // Catch: Throwable -> L203
        r19 = r56;
        r54 = r44;
        goto L161
    L147:
        r49 = null;
        goto L149
    L143:
        r47 = null;
    L163:
        int r212 = r38;
        r54 = r44;
        r53 = r110;
        r18 = r18;
        r51 = r212;
        r115 = r27;
        r55 = false;
        goto L164
    L131:
        if ((r43 - r111.size()) >= r18.size()) goto L133;
        ListProtector.set(r10, r43 - r111.size(), ListProtector.get(r111, r38));     // Catch: Throwable -> L203
        ((FeedItem) ListProtector.get(r10, r43 - r111.size())).setHideBucketItem(true);     // Catch: Throwable -> L203
        int r57 = r43 - r111.size();     // Catch: Throwable -> L203
        Object r58 = ListProtector.get(r112, r38);     // Catch: Throwable -> L203
        r120 = r11;
        ListProtector.set(r120, r57, r58);     // Catch: Throwable -> L203
        int r59 = r43 - r111.size();     // Catch: Throwable -> L203
        Object r60 = ListProtector.get(r20, r38);     // Catch: Throwable -> L203
        r44 = r21;
        ListProtector.set(r44, r59, r60);     // Catch: Throwable -> L203
        e("change with hide and feed before =" + r38 + ", after = " + r43);     // Catch: Throwable -> L203
        goto L134
    L116:
        if (r43 >= r32.size()) goto L128;
        if (r43 >= r111.size()) goto L128;
        if (r38 >= r111.size()) goto L128;
        if (r38 <= r0) goto L125;
        if (r43 <= r0) goto L125;
        ListProtector.set(r32, r43, ListProtector.get(r111, r38));     // Catch: Throwable -> L203
        ((FeedItem) ListProtector.get(r32, r43)).setHideBucketItem(false);     // Catch: Throwable -> L203
        r118 = r33;
        ListProtector.set(r118, r43, ListProtector.get(r112, r38));     // Catch: Throwable -> L203
        r119 = r34;
        ListProtector.set(r119, r43, ListProtector.get(r20, r38));     // Catch: Throwable -> L203
        e("change with feed and feed before =" + r38 + ", after = " + r43);     // Catch: Throwable -> L203
        r120 = r11;
        r44 = r21;
    L125:
        if (r7 == null) goto L234;
        r7.onFail("index is invalid, cannot replace", null);     // Catch: Throwable -> L203
        return;
    L234:
        return;
    L110:
        r42 = null;
        goto L112
    L106:
        r40 = null;
        goto L107
    L136:
        r22 = r22;
        r20 = r20;
        r112 = r112;
        r120 = r11;
        r18 = r18;
        r44 = r21;
        r118 = r33;
        r119 = r34;
        r38 = r26;
        r45 = false;
    L165:
        boolean r213 = r22;
        List<Bundle> r121 = r11;
        List<Room> r61 = r21;
        if (r114 == false) goto L191;
        if (r31 == null) goto L191;
        Iterator<T> r62 = r31.iterator();     // Catch: Throwable -> L203
    L170:
        if (r62.hasNext() == false) goto L191;
        final FeedItem r63 = (FeedItem) r62.next();     // Catch: Throwable -> L203
        int r64 = a(r32, r29, new LiveInnerReRankUtils$reRankReplaceCall$3$1$index$1(r63));     // Catch: Throwable -> L203
        if (r64 < r29) goto L182;
        if (r64 >= r32.size()) goto L182;
        ListProtector.remove(r32, r64);     // Catch: Throwable -> L203
        ListProtector.remove(r34, r64);     // Catch: Throwable -> L203
        ListProtector.remove(r33, r64);     // Catch: Throwable -> L203
        StringBuilder r122 = new StringBuilder();     // Catch: Throwable -> L203
        r122.append("remove origin index ");     // Catch: Throwable -> L203
        r122.append(r64);     // Catch: Throwable -> L203
        r122.append(", roomId: ");     // Catch: Throwable -> L203
        Room r65 = r63.getRoom();     // Catch: Throwable -> L203
        if (r65 == null) goto L179;
        Long r66 = Long.valueOf(r65.id);     // Catch: Throwable -> L203
    L180:
        r122.append(r66);     // Catch: Throwable -> L203
        e(r122.toString());     // Catch: Throwable -> L203
        goto L182
    L179:
        r66 = null;
    L182:
        int r67 = a(r10, 0, new LiveInnerReRankUtils$reRankReplaceCall$3$1$hideIndex$1(r63));     // Catch: Throwable -> L203
        if (r67 < 0) goto L170;
        if (r67 >= r10.size()) goto L170;
        ListProtector.remove(r10, r67);     // Catch: Throwable -> L203
        ListProtector.remove(r121, r67);     // Catch: Throwable -> L203
        ListProtector.remove(r61, r67);     // Catch: Throwable -> L203
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L203
        r123.append("remove hide origin index ");     // Catch: Throwable -> L203
        r123.append(r67);     // Catch: Throwable -> L203
        r123.append(", roomId: ");     // Catch: Throwable -> L203
        Room r68 = r63.getRoom();     // Catch: Throwable -> L203
        if (r68 == null) goto L189;
        Long r69 = Long.valueOf(r68.id);     // Catch: Throwable -> L203
    L190:
        r123.append(r69);     // Catch: Throwable -> L203
        e(r123.toString());     // Catch: Throwable -> L203
        goto L170
    L189:
        r69 = null;
    L191:
        r37.invoke();     // Catch: Throwable -> L203
        if (r36 == null) goto L194;
        r36.onSuccess(r32);     // Catch: Throwable -> L203
    L194:
        if (r213 == false) goto L198;
        e("needPreload preload next room");     // Catch: Throwable -> L203
        if (r36 == null) goto L198;
        r36.preloadNextRoom();     // Catch: Throwable -> L203
    L198:
        d("after change", r32, r10);     // Catch: Throwable -> L203
        Object r70 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L203
    L205:
        Throwable r71 = Result.exceptionOrNull-impl(r70);
        if (r71 == null) goto L236;
        Intrinsics.checkNotNullParameter("reRank error", "msg");
        Intrinsics.checkNotNullParameter(r71, "error");
        ALogger.e("LiveInnerReRankUtils", "reRank error", r71);
        return;
    L236:
        return;
    L82:
        if (r29 >= r111.size()) goto L94;
        Room r72 = ((FeedItem) ListProtector.get(r2, 0)).getRoom();     // Catch: Throwable -> L203
        if (r72 == null) goto L86;
        Long r73 = Long.valueOf(r72.id);     // Catch: Throwable -> L203
    L87:
        Room r74 = ((FeedItem) ListProtector.get(r111, r29)).getRoom();     // Catch: Throwable -> L203
        if (r74 == null) goto L90;
        Long r75 = Long.valueOf(r74.id);     // Catch: Throwable -> L203
    L92:
        if ((!Intrinsics.areEqual(r73, r75)) == false) goto L95;
        r22 = true;
        goto L96
    L90:
        r75 = null;
        goto L92
    L86:
        r73 = null;
    L203:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L205
    L56:
        if (r31.size() <= 0) goto L58;
        boolean r77 = true;
    L59:
        if (r77 == false) goto L61;
        List<FeedItem> r78 = r31;
    L62:
        if (r78 == null) goto L64;
        r8 = true;
        goto L65
    L61:
        r78 = null;
        goto L62
    L58:
        r77 = false;
        goto L59
    L32:
        r4 = null;
        goto L34
    L28:
        r16 = null;
    L38:
        if ((r14 - r32.size()) < 0) goto L52;
        if ((r14 - r32.size()) >= r10.size()) goto L52;
        Room r79 = ((FeedItem) ListProtector.get(r2, r15)).getRoom();
        if (r79 == null) goto L44;
        Long r80 = Long.valueOf(r79.id);
    L45:
        Room r81 = ((FeedItem) ListProtector.get(r10, r14 - r32.size())).getRoom();
        if (r81 == null) goto L48;
        Long r82 = Long.valueOf(r81.id);
    L50:
        if ((!Intrinsics.areEqual(r80, r82)) == false) goto L52;
    L48:
        r82 = null;
        goto L50
    L44:
        r80 = null;
    L52:
        r15 = r15 + 1;
        r12 = r12;
        goto L20
    L53:
        r5 = false;
        goto L54
    }
}

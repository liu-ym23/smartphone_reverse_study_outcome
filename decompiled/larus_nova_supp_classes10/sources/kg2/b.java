package kg2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.utils.f0;
import com.bytedance.android.livesdk.config.i41;
import com.bytedance.android.livesdk.live.f;
import com.bytedance.android.livesdk.live.listprovider.DrawRoomListProvider;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final Map<String, ILiveRoomListProvider> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final ILiveRoomListProvider b(c r15) {
        Intrinsics.checkNotNullParameter(r15, "createConfig");
        f0 r0 = r15.e;
        ILiveRoomListProvider r1 = null;
        if (r0 == null) goto L5;
        String r3 = r0.d;
    L6:
        Bundle r2 = r15.a;
        if (r0 == null) goto L12;
        String r4 = r0.c;
        if (r4 == null) goto L12;
        String r5 = r4;
    L13:
        String r10 = r15.d;
        Bundle r6 = r15.b;
        if (r6 != null) goto L16;
        r6 = new Bundle();
    L16:
        Bundle r11 = r6;
        boolean r7 = r15.f;
        a r8 = r15.g;
        MergeDrawerViewModel r9 = r15.h;
        f r12 = r15.j;
        Room r13 = r15.i;
        boolean r14 = r15.k;
        c("getRoomListProviderOrGenerate config " + r15);
        boolean r16 = true;
        if (r7 == false) goto L28;
        String r17 = "RoomListProviderCenter_" + SystemClock.elapsedRealtime() + '_' + new Object();
        c("generatePreloadTicket preloadTicket " + r17);
        ConcurrentHashMap r18 = (ConcurrentHashMap) a;
        Object r19 = r18.get(r17);
        if (r19 != null) goto L21;
        c("getRoomListProviderOrGenerate getOrPut preloadTicket " + r17);
        r19 = a(r3, r2, r5, r9, r13, r12, r14, r10, r11);
        r18.put(r17, r19);
    L21:
        ILiveRoomListProvider r20 = (ILiveRoomListProvider) r19;
        if (r17.length() <= 0) goto L24;
        boolean r21 = true;
    L25:
        if (r21 == false) goto L27;
        r2.putString("live.intent.extra.EXTRA_FEED_PRELOAD_PARAMS", r17);
    L27:
        String r22 = "预创建 ListProvider" + r20;
    L50:
        i41 r23 = lg2.a.a;
        if (v.a() == true) goto L53;
    L55:
        r16 = false;
    L56:
        if (r16 == false) goto L58;
        Toast.makeText(jc1.a.b(), "加载状态：" + r22, 0).show();
    L58:
        c("getRoomListProviderOrGenerate curProvider " + r20 + " mListProviderMap current size " + ((ConcurrentHashMap) a).size());
        return r20;
    L53:
        if (lg2.a.a.a() == false) goto L55;
    L24:
        r21 = false;
        goto L25
    L28:
        if (r2 == null) goto L31;
        String r24 = r2.getString("live.intent.extra.EXTRA_FEED_PRELOAD_PARAMS", "");
        if (r24 == null) goto L31;
    L33:
        if (StringsKt.isBlank(r24) == true) goto L43;
        ConcurrentHashMap r25 = (ConcurrentHashMap) a;
        if (r25.containsKey(r24) == false) goto L43;
        c("getRoomListProviderOrGenerate from cache ".concat(r24));
        ILiveRoomListProvider r26 = (ILiveRoomListProvider) r25.get(r24);
        if (r26 == null) goto L42;
        if (r8 == null) goto L41;
        r8.call(r26);
    L41:
        r1 = r26;
    L42:
        String r27 = "命中缓存 ListProvider" + r1;
    L44:
        r20 = r1;
        Map<String, ILiveRoomListProvider> r28 = a;
        if (r28 == null) goto L61;
        if (((ConcurrentHashMap) r28).containsKey(r24) == false) goto L49;
        c("getRoomListProviderOrGenerate hit cache remove cache ".concat(r24));
        TypeIntrinsics.asMutableMap(r28).remove(r24);
    L49:
        r22 = r27;
        goto L50
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L43:
        c("getRoomListProviderOrGenerate not hit cache");
        r1 = a(r3, r2, r5, r9, r13, r12, r14, r10, r11);
        r27 = "正常创建 ListProvider" + r1;
    L31:
        r24 = "";
    L12:
        r5 = "";
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("RoomListProviderCenter", r1);
    }

    public static DrawRoomListProvider a(String r12, Bundle r13, String r14, MergeDrawerViewModel r15, Room r16, f r17, boolean r18, String r19, Bundle r20) {
        if (TextUtils.isEmpty(r12) == true) goto L10;
        if (r12 != null) goto L7;
        String r7 = "";
    L8:
        DrawRoomListProvider r0 = new DrawRoomListProvider(r13, r14, r7, r15, r16, r17, r18);
    L37:
        return r0;
    L7:
        r7 = r12;
        goto L8
    L10:
        if ((!TextUtils.isEmpty(r13.getString("double_stream_feed_url"))) == false) goto L12;
        String r2 = "draw";
    L14:
        if (Intrinsics.areEqual("drawer_cover", r19) == true) goto L18;
        if (Intrinsics.areEqual("drawer_cell", r19) == true) goto L18;
    L30:
        if (r20.containsKey("from_lable") == false) goto L33;
        r20.getString("from_lable", "");
    L33:
        if (r2 != null) goto L35;
        String r8 = "";
    L36:
        r0 = new DrawRoomListProvider(r13, r14, r8, r15, r16, r17, r18);
        goto L37
    L35:
        r8 = r2;
    L18:
        if (TextUtils.isEmpty(r2) == false) goto L30;
        if (TextUtils.isEmpty(r20.getString("drawer_inner_req_from")) == true) goto L22;
        String r1 = r20.getString("drawer_inner_req_from", "");
    L26:
        if (TextUtils.isEmpty(r1) == false) goto L28;
        r2 = "";
        goto L30
    L28:
        r2 = Intrinsics.stringPlus(r1, "_draw");
        goto L30
    L22:
        r1 = c0.b().getReqFrom();
        if (r1 != null) goto L26;
        r1 = "";
        goto L26
    L12:
        r2 = "";
        goto L14
    }
}

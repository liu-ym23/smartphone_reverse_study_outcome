package i1a;

import android.text.TextUtils;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.ugc.perf.impl.d;
import com.larus.ugc.perf.impl.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nf9.b;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f488015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f488016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f488017c;

    /* JADX INFO: renamed from: i1a.a$a, reason: collision with other inner class name */
    public static final class C6218a implements b {
        public C6218a() {
        }

        @Override // nf9.b
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void d(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "oldMsgList");
            Intrinsics.checkNotNullParameter(r102, "newMsgList");
        }

        @Override // nf9.b
        public final void f(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            if (Intrinsics.areEqual(r101.getMessageId(), a.f488017c) == false) goto L6;
            a r102 = a.f488015a;
            a.f(r101, 30012L);
            return;
        }

        @Override // nf9.b
        public final void b(String r100, MessageListState r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "msgList");
            if (r101 != MessageListState.DELETE) goto L15;
            List<Message> r103 = r102;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L6:
            if (r105.hasNext() == false) goto L9;
            r104.add(((Message) r105.next()).getMessageId());
            goto L6
        L9:
            if (r104.contains(a.f488017c) == false) goto L16;
            Message r106 = (Message) CollectionsKt.firstOrNull(r102);
            if (r106 == null) goto L17;
            a r107 = a.f488015a;
            a.f(r106, 30012L);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public a() {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    static {
        f488015a = new a();
        f488017c = "";
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        String r101 = r100.b();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        f488017c = r101;
        if (f488016b == false) goto L8;
        return;
    L8:
        f488016b = true;
        com.larus.im.d.e().registerOnGlobalMessageObserver(new C6218a());
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(e r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        String r100 = r110.b();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = r100;
        long r102 = System.currentTimeMillis();
        Long r103 = r110.d();
        if (r103 == null) goto L8;
        long r104 = r103.longValue();
    L9:
        h1a.e.b(new h1a.a("music_create/chunk", "music_create", "1", 0L, Long.valueOf(r102 - r104), r101, null, null, 192), r110);
        return;
    L8:
        r104 = System.currentTimeMillis();
        goto L9
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    public static void f(Message r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "message");
        e r100 = d.a.a(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("lyrics_received");
        Boolean r102 = Boolean.TRUE;
        boolean r103 = Intrinsics.areEqual(r101, r102);
        long r104 = System.currentTimeMillis();
        Long r105 = r100.d();
        if (r105 == null) goto L8;
        long r106 = r105.longValue();
    L9:
        long r112 = r104 - r106;
        if (r103 == true) goto L17;
        if (r111 == null) goto L18;
        r100.f375105b.put("lyrics_received", r102);
        String r113 = r110.getMessageId();
        if (r113 != null) goto L15;
        r113 = "";
    L15:
        h1a.e.b(b(r113, "0", r112, r111.longValue()), r100);
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r106 = System.currentTimeMillis();
        goto L9
    }

    public final void i(Message r210, String r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        e r100 = d.a.a(r210);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("play_start");
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L9;
        return;
    L9:
        if (r210.getContentType() == 72) goto L11;
        return;
    L11:
        r100.f375105b.put("play_start", r102);
        Long r103 = null;
        if (r212 == false) goto L24;
        long r104 = System.currentTimeMillis();
        Object r105 = r100.f375105b.get("stream_url_time".concat(r211));
        if ((r105 instanceof Long) == false) goto L16;
        r103 = (Long) r105;
    L16:
        if (r103 == null) goto L18;
        long r106 = r103.longValue();
    L19:
        long r107 = r104 - r106;
        String r108 = r210.getMessageId();
        if (r108 != null) goto L22;
        String r110 = "";
    L23:
        h1a.e.b(new h1a.a("music_create/chunk/stream/start", "music_create/chunk/stream", "1", 0L, Long.valueOf(r107), r110, null, null, 192), r100);
        return;
    L22:
        r110 = r108;
        goto L23
    L18:
        r106 = System.currentTimeMillis();
        goto L19
    L24:
        long r109 = System.currentTimeMillis();
        Object r111 = r100.f375105b.get("vid_time".concat(r211));
        if ((r111 instanceof Long) == false) goto L27;
        r103 = (Long) r111;
    L27:
        if (r103 == null) goto L29;
        long r112 = r103.longValue();
    L30:
        long r113 = r109 - r112;
        String r114 = r210.getMessageId();
        if (r114 != null) goto L33;
        String r115 = "";
    L34:
        h1a.e.b(new h1a.a("music_create/chunk/vid/start", "music_create/chunk/vid", "1", 0L, Long.valueOf(r113), r115, null, null, 192), r100);
        return;
    L33:
        r115 = r114;
        goto L34
    L29:
        r112 = System.currentTimeMillis();
        goto L30
    }

    public static h1a.a b(String r110, String r111, long r112, long r113) {
        return new h1a.a("music_create/chunk/finish", "music_create/chunk", r111, Long.valueOf(r113), Long.valueOf(r112), r110, null, null, 192);
    }

    public final void g(Message r110, String r111, long r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        e r100 = d.a.a(r110);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r110.getContentType() == 72) goto L8;
        return;
    L8:
        r100.f375105b.put("play_start", Boolean.TRUE);
        Long r101 = null;
        if (r211 == false) goto L21;
        long r102 = System.currentTimeMillis();
        Object r103 = r100.f375105b.get("stream_url_time".concat(r111));
        if ((r103 instanceof Long) == false) goto L13;
        r101 = (Long) r103;
    L13:
        if (r101 == null) goto L15;
        long r104 = r101.longValue();
    L16:
        long r105 = r102 - r104;
        String r106 = r110.getMessageId();
        if (r106 != null) goto L19;
        String r112 = "";
    L20:
        h1a.e.b(new h1a.a("music_create/chunk/stream/start", "music_create/chunk/stream", "0", Long.valueOf(r210), Long.valueOf(r105), r112, null, null, 192), r100);
        return;
    L19:
        r112 = r106;
        goto L20
    L15:
        r104 = System.currentTimeMillis();
        goto L16
    L21:
        long r107 = System.currentTimeMillis();
        Object r108 = r100.f375105b.get("vid_time".concat(r111));
        if ((r108 instanceof Long) == false) goto L24;
        r101 = (Long) r108;
    L24:
        if (r101 == null) goto L26;
        long r109 = r101.longValue();
    L27:
        long r113 = r107 - r109;
        String r114 = r110.getMessageId();
        if (r114 != null) goto L30;
        String r115 = "";
    L31:
        h1a.e.b(new h1a.a("music_create/chunk/vid/start", "music_create/chunk/vid", "0", Long.valueOf(r210), Long.valueOf(r113), r115, null, null, 192), r100);
        return;
    L30:
        r115 = r114;
        goto L31
    L26:
        r109 = System.currentTimeMillis();
        goto L27
    }

    public final boolean e(Message r210, String r211, String r212, String r213, boolean r214, boolean r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r212, "streamUrl");
        Intrinsics.checkNotNullParameter(r213, "vid");
        e r110 = d.a.a(r210);
        if (r110 == null) goto L132;
        Object r100 = r110.f375105b.get("lyrics_received");
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L138;
        r110.f375106c.add(r211);
        if (r210.getMessageStatusLocal() != 21) goto L9;
    L14:
        boolean r111 = true;
    L15:
        String r102 = "vid_received";
        if (TextUtils.isEmpty(r213) == true) goto L31;
        if (Intrinsics.areEqual(r110.f375105b.get("vid_received" + r211), r101) == true) goto L31;
        r110.f375105b.put("vid_received" + r211, r101);
        r110.f375105b.put("vid_time" + r211, Long.valueOf(System.currentTimeMillis()));
        long r103 = System.currentTimeMillis();
        Long r104 = r110.d();
        if (r104 == null) goto L23;
        long r105 = r104.longValue();
    L24:
        long r106 = r103 - r105;
        String r107 = r110.b();
        if (r107 != null) goto L27;
        String r108 = "";
    L28:
        h1a.e.b(new h1a.a("music_create/chunk/vid", "music_create/chunk", "1", 0L, Long.valueOf(r106), r108, r211, null, 128), r110);
        goto L31
    L27:
        r108 = r107;
        goto L28
    L23:
        r105 = System.currentTimeMillis();
    L31:
        if (TextUtils.isEmpty(r212) == true) goto L45;
        if (Intrinsics.areEqual(r110.f375105b.get("chunk_received" + r211), r101) == true) goto L45;
        r110.f375105b.put("chunk_received" + r211, r101);
        r110.f375105b.put("stream_url_time" + r211, Long.valueOf(System.currentTimeMillis()));
        long r109 = System.currentTimeMillis();
        Long r112 = r110.d();
        if (r112 == null) goto L38;
        long r113 = r112.longValue();
    L39:
        long r114 = r109 - r113;
        String r115 = r110.b();
        if (r115 != null) goto L42;
        String r116 = "";
    L43:
        h1a.e.b(new h1a.a("music_create/chunk/stream", "music_create/chunk", "1", 0L, Long.valueOf(r114), r116, r211, null, 128), r110);
        goto L45
    L42:
        r116 = r115;
        goto L43
    L38:
        r113 = System.currentTimeMillis();
    L45:
        String r117 = "cover_received";
        if (r214 == false) goto L60;
        if (Intrinsics.areEqual(r110.f375105b.get("cover_received" + r211), r101) == true) goto L60;
        r110.f375105b.put("cover_received" + r211, r101);
        long r118 = System.currentTimeMillis();
        Long r119 = r110.d();
        if (r119 == null) goto L53;
        long r120 = r119.longValue();
    L54:
        long r121 = r118 - r120;
        String r122 = r110.b();
        if (r122 != null) goto L57;
        String r123 = "";
    L58:
        h1a.e.b(new h1a.a("music_create/chunk/cover", "music_create/chunk", "1", 0L, Long.valueOf(r121), r123, r211, null, 128), r110);
        goto L60
    L57:
        r123 = r122;
        goto L58
    L53:
        r120 = System.currentTimeMillis();
    L60:
        if (r310 == true) goto L62;
    L73:
        if (r111 == false) goto L139;
        r110.f375105b.put("lyrics_received", r101);
        e r124 = d.a.a(r210);
        if (r124 == null) goto L131;
        long r125 = System.currentTimeMillis();
        Long r126 = r124.d();
        if (r126 == null) goto L80;
        long r127 = r126.longValue();
    L81:
        long r128 = r125 - r127;
        if (r311 == false) goto L88;
        String r129 = r210.getMessageId();
        if (r129 != null) goto L86;
        String r130 = "";
    L87:
        h1a.e.b(b(r130, "0", r128, 30013), r110);
        goto L131
    L86:
        r130 = r129;
        goto L87
    L88:
        String r131 = r210.getMessageId();
        if (r131 != null) goto L91;
        String r132 = "";
    L92:
        h1a.e.b(b(r132, "1", r128, 0), r110);
        Iterator r133 = r110.f375106c.iterator();
    L94:
        if (r133.hasNext() == false) goto L131;
        String r134 = (String) r133.next();
        if (TextUtils.isEmpty(r134) == true) goto L131;
        Object r135 = r110.f375105b.get("chunk_received" + r134);
        Boolean r136 = Boolean.TRUE;
        if (Intrinsics.areEqual(r135, r136) == true) goto L106;
        String r137 = r110.b();
        if (r137 != null) goto L104;
        String r138 = "";
    L105:
        h1a.e.b(new h1a.a("music_create/chunk/stream", "music_create/chunk", "0", 30021L, 0L, r138, r134, null, 128), r110);
        goto L106
    L104:
        r138 = r137;
    L106:
        String r139 = r102;
        if (Intrinsics.areEqual(r110.f375105b.get(r139 + r134), r136) == true) goto L114;
        String r140 = r110.b();
        if (r140 != null) goto L112;
        String r141 = "";
    L113:
        h1a.e.b(new h1a.a("music_create/chunk/vid", "music_create/chunk", "0", 30031L, 0L, r141, r134, null, 128), r110);
        goto L114
    L112:
        r141 = r140;
    L114:
        String r142 = r117;
        if (Intrinsics.areEqual(r110.f375105b.get(r142 + r134), r136) == true) goto L123;
        String r143 = r110.b();
        if (r143 != null) goto L120;
        String r144 = "";
    L121:
        h1a.e.b(new h1a.a("music_create/chunk/cover", "music_create/chunk", "0", 30041L, 0L, r144, r134, null, 128), r110);
        goto L123
    L120:
        r144 = r143;
    L123:
        if (Intrinsics.areEqual(r110.f375105b.get("lyrics_received" + r134), r136) == true) goto L130;
        String r145 = r110.b();
        if (r145 != null) goto L128;
        String r146 = "";
    L129:
        h1a.e.b(new h1a.a("music_create/chunk/lyrics", "music_create/chunk", "0", 30051L, 0L, r146, r134, null, 128), r110);
        goto L130
    L128:
        r146 = r145;
    L130:
        r133 = r133;
        r102 = r139;
        r117 = r142;
        goto L94
    L91:
        r132 = r131;
        goto L92
    L80:
        r127 = System.currentTimeMillis();
    L131:
        return true;
    L139:
        return false;
    L62:
        if (Intrinsics.areEqual(r110.f375105b.get("lyrics_received" + r211), r101) == true) goto L73;
        r110.f375105b.put("lyrics_received" + r211, r101);
        long r147 = System.currentTimeMillis();
        Long r148 = r110.d();
        if (r148 == null) goto L67;
        long r149 = r148.longValue();
    L68:
        long r150 = r147 - r149;
        String r151 = r110.b();
        if (r151 != null) goto L71;
        String r152 = "";
    L72:
        h1a.e.b(new h1a.a("music_create/chunk/lyrics", "music_create/chunk", "1", 0L, Long.valueOf(r150), r152, r211, null, 128), r110);
        goto L73
    L71:
        r152 = r151;
        goto L72
    L67:
        r149 = System.currentTimeMillis();
        goto L68
    L9:
        if (r210.getMessageStatusLocal() == 23) goto L14;
        if (r210.getMessageStatusLocal() == 22) goto L14;
        r111 = false;
        goto L15
    L138:
        return false;
    L132:
        return false;
    }
}

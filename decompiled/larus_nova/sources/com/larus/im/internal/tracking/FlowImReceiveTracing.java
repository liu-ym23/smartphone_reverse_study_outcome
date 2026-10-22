package com.larus.im.internal.tracking;

import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.block.Block;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.k0;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import com.larus.im.internal.protocol.bean.FetchType;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.protocol.bean.NewMessageNotify;
import com.larus.im.internal.protocol.bean.SuggestQuestion;
import com.larus.im.internal.stream.StreamChannel;
import com.larus.im.internal.stream.Typewriter;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowImReceiveTracing extends e {

    /* JADX INFO: loaded from: classes30.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350218a = null;

        static {
            int[] r100 = new int[ReceiveMessageFrom.values().length];
            r100[ReceiveMessageFrom.FRONTIER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ReceiveMessageFrom.CLIENT_PULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ReceiveMessageFrom.FIRST_PACKAGE_TIME_OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ReceiveMessageFrom.OTHERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f350218a = r100;
        }
    }

    public FlowImReceiveTracing() {
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void e(b r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = r110.f350313h.a().getCode();
        String r101 = r110.f350314i.getMessageId();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r110.f350314i.getReplyId();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        int r105 = com.larus.im.internal.database.utils.k.e(r110.f350314i);
        int r106 = ResultStatus.TIMEOUT.ordinal();
        int r107 = FetchType.CHUNK_STREAM.value;
        String r108 = r110.f350313h.a().getTips();
        if (r108 != null) goto L13;
        String r109 = "";
    L14:
        D(this, r100, r102, r104, r105, r106, r107, r109, r110.f350310e, false, com.larus.im.internal.database.utils.k.c(r110.f350314i).get("intention"), 256);
        return;
    L13:
        r109 = r108;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void i(com.larus.im.internal.tracking.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptInfo");
        Intrinsics.checkNotNullParameter(r100, "interceptInfo");
        String r101 = r100.f350291b;
        String r102 = r100.f350290a;
        boolean r103 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L19;
        if (r102 != null) goto L12;
    L15:
        if (r103 == true) goto L20;
        e0 r105 = new e0();
        int r106 = c.f350315a;
        m.b(r105, c.b("", r100.f350294e, r100.f350291b, 0, null));
        Intrinsics.checkNotNullParameter(r100, "<this>");
        e0 r107 = new e0();
        ouc.j.c(r107, "conversation_id", r100.f350290a);
        ouc.j.c(r107, com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r100.f350291b);
        ouc.j.c(r107, "token", r100.f350292c);
        ouc.j.b(r107, "cmd", Long.valueOf(r100.f350293d));
        ouc.j.c(r107, "answer_id", r100.f350294e);
        ouc.j.b(r107, "seq_no", Long.valueOf(r100.f350295f));
        ouc.j.b(r107, "receive_start_time", Long.valueOf(r100.f350296g));
        ouc.j.b(r107, "intercept_time", Long.valueOf(r100.f350297h));
        ouc.j.b(r107, "duration", Long.valueOf(r100.f350297h - r100.f350296g));
        m.b(r105, r107.a());
        d0 r108 = r105.a();
        d1.f348206b.a("flow_im_message_receive_intercept", r108);
        return;
    L20:
        return;
    L12:
        if (StringsKt.isBlank(r102) == true) goto L15;
        r103 = false;
        goto L15
    L19:
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void j(b r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = r110.f350313h.a().getCode();
        String r101 = r110.f350314i.getMessageId();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r110.f350314i.getReplyId();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        int r105 = com.larus.im.internal.database.utils.k.e(r110.f350314i);
        int r106 = ResultStatus.INTERRUPT.ordinal();
        int r107 = FetchType.CHUNK_STREAM.value;
        String r108 = r110.f350313h.a().getTips();
        if (r108 != null) goto L13;
        String r109 = "";
    L14:
        D(this, r100, r102, r104, r105, r106, r107, r109, r110.f350310e, false, com.larus.im.internal.database.utils.k.c(r110.f350314i).get("intention"), 256);
        return;
    L13:
        r109 = r108;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void m(com.larus.im.internal.protocol.bean.c r100) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        com.larus.im.internal.delegate.a.f348188b.i("FlowImReceiveTracing", "receive cmd " + r100);
        Object r101 = k.f350321a;
        String r102 = r100.f349758b;
        String r103 = r100.f349759c;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Intrinsics.checkNotNullParameter(r103, "allEndMessageId");
        q r105 = k.d(r102);
        if (r105 == null) goto L8;
        r105.f350475w = SystemClock.elapsedRealtime();
        r105.f350476x = r103;
    L8:
        String r106 = r100.f349758b;
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        B(r104, ResultStatus.SUCCESS.ordinal());
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void n(b r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        MessageEntity r100 = r110.f350314i;
        Object r101 = k.f350321a;
        long r102 = 0;
        String r103 = "";
        if (k.a(r100.getMessageId(), r100.getReplyId()) <= 0) goto L29;
        e0 r104 = new e0();
        int r105 = c.f350315a;
        m.b(r104, c.b("", r100.getMessageId(), r100.getReplyId(), Integer.valueOf(com.larus.im.internal.database.utils.k.e(r100)), k.c(r110.f350314i.getReplyId(), r110.f350314i.getMessageId())));
        String r111 = r100.getMessageId();
        if (r111 != null) goto L7;
        String r106 = "";
    L8:
        String r112 = r100.getReplyId();
        if (r112 != null) goto L11;
        String r107 = "";
    L12:
        String r113 = r100.getMessageId();
        q r108 = k.d(r100.getReplyId());
        if (r108 == null) goto L28;
        CopyOnWriteArrayList<u> r109 = r108.c();
        Long r114 = null;
        if (r109 == null) goto L26;
        Iterator<T> r115 = r109.iterator();
    L18:
        if (r115.hasNext() == false) goto L22;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((u) r116).f350480a, r113) == false) goto L18;
    L23:
        u r117 = (u) r116;
        if (r117 == null) goto L26;
        r114 = Long.valueOf(r117.f350488i - r117.f350487h);
        goto L26
    L22:
        r116 = null;
    L26:
        if (r114 == null) goto L28;
        r102 = r114.longValue();
    L28:
        m.b(r104, c.c(r106, r107, r102, 0, false));
        int r118 = c.f350315a;
        m.b(r104, c.d(0, 0, ""));
        ouc.j.b(r104, "from", 1);
        ouc.j.c(r104, "intention", com.larus.im.internal.database.utils.k.c(r100).get("intention"));
        d1.f348206b.a("flow_im_message_receive_suggest_end", r104.a());
        goto L29
    L11:
        r107 = r112;
        goto L12
    L7:
        r106 = r111;
    L29:
        String r119 = r100.getMessageId();
        String r120 = r100.getReplyId();
        if (r120 == null) goto L33;
        r103 = r120;
    L33:
        E(r119, r103, 0);
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void v(b r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = r110.f350313h.a().getCode();
        String r101 = r110.f350314i.getMessageId();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r110.f350314i.getReplyId();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        int r105 = com.larus.im.internal.database.utils.k.e(r110.f350314i);
        int r106 = ResultStatus.CANCEL.ordinal();
        int r107 = FetchType.CHUNK_STREAM.value;
        String r108 = r110.f350313h.a().getTips();
        if (r108 != null) goto L13;
        String r109 = "";
    L14:
        D(this, r100, r102, r104, r105, r106, r107, r109, r110.f350310e, false, com.larus.im.internal.database.utils.k.c(r110.f350314i).get("intention"), 256);
        return;
    L13:
        r109 = r108;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void w(b r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = r110.f350313h.a().getCode();
        String r101 = r110.f350314i.getMessageId();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r110.f350314i.getReplyId();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        int r105 = com.larus.im.internal.database.utils.k.e(r110.f350314i);
        int r106 = ResultStatus.ERROR.ordinal();
        int r107 = FetchType.CHUNK_STREAM.value;
        String r108 = r110.f350313h.a().getTips();
        if (r108 != null) goto L13;
        String r109 = "";
    L14:
        D(this, r100, r102, r104, r105, r106, r107, r109, r110.f350310e, false, com.larus.im.internal.database.utils.k.c(r110.f350314i).get("intention"), 256);
        return;
    L13:
        r109 = r108;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    public final void B(String r210, int r211) {
        com.larus.im.internal.delegate.a.f348188b.i("FlowImReceiveTracing", "check all end reply id = " + r210);
        q r100 = k.d(r210);
        if (r100 == null) goto L8;
        String r101 = r100.f350476x;
        if (r101 == null) goto L8;
        String r102 = r101;
    L9:
        u r110 = null;
        if (StringsKt.isBlank(r102) == false) goto L12;
        boolean r111 = false;
    L48:
        if (r111 == false) goto L71;
        q r103 = k.d(r210);
        if (r103 == null) goto L69;
        CopyOnWriteArrayList<u> r104 = r103.c();
        if (r104 == null) goto L66;
        Iterator<T> r105 = r104.iterator();
    L55:
        if (r105.hasNext() == false) goto L62;
        Object r106 = r105.next();
        if (((u) r106).f350489j == 0) goto L59;
        boolean r107 = true;
    L60:
        if (r107 == false) goto L55;
    L63:
        u r108 = (u) r106;
        if (r108 == null) goto L66;
        Integer r109 = Integer.valueOf(r108.f350489j);
    L67:
        if (r109 == null) goto L69;
        int r112 = r109.intValue();
    L70:
        d1.f348206b.a("flow_im_receive_all_content_end", C(r112, 0, "", r102, r210, null, false));
        goto L71
    L59:
        r107 = false;
        goto L60
    L62:
        r106 = null;
    L66:
        r109 = null;
    L69:
        r112 = 0;
    L71:
        if (r111 == false) goto L73;
    L74:
        q r113 = k.d(r210);
        if (r113 == null) goto L86;
        CopyOnWriteArrayList<u> r114 = r113.c();
        if (r114 == null) goto L86;
        u r115 = (u) CollectionsKt.lastOrNull(r114);
        if (r115 == null) goto L86;
        if (r115.f350490k != 1) goto L83;
        boolean r116 = true;
    L84:
        if (r116 == false) goto L86;
        r110 = r115;
        goto L86
    L83:
        r116 = false;
    L86:
        if (r110 == null) goto L96;
        k0 r117 = k0.f348247b;
        String r118 = r110.f350480a;
        if (r118 != null) goto L90;
        String r119 = "";
    L91:
        int r120 = r110.f350481b;
        int r121 = r110.f350489j;
        if (r110.f350487h <= 0) goto L94;
        boolean r122 = true;
    L95:
        r117.d(r210, new ISDKPointCallback.EndMsg(r119, r120, r121, r122, 0, 16, null));
        goto L96
    L94:
        r122 = false;
        goto L95
    L90:
        r119 = r118;
    L96:
        if (r111 == false) goto L108;
        Object r123 = k.f350321a;
        if (r210 == null) goto L124;
        Object r124 = k.f350321a;
        monitor-enter(r124);
        q r125 = k.f350322b.remove(r210);     // Catch: Throwable -> L105
        monitor-exit(r124);
        return;
    L105:
        th = move-exception;
        throw th;
    L124:
        return;
    L108:
        return;
    L73:
        if (CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(ResultStatus.ERROR.ordinal()), Integer.valueOf(ResultStatus.TIMEOUT.ordinal()), Integer.valueOf(ResultStatus.INTERRUPT.ordinal()), Integer.valueOf(ResultStatus.CANCEL.ordinal())}).contains(Integer.valueOf(r211)) == false) goto L96;
    L12:
        q r126 = k.d(r210);
        if (r126 == null) goto L46;
        CopyOnWriteArrayList<u> r127 = r126.c();
        if (r127 == null) goto L24;
        Iterator<T> r128 = r127.iterator();
    L18:
        if (r128.hasNext() == false) goto L22;
        Object r129 = r128.next();
        if (Intrinsics.areEqual(r102, ((u) r129).f350480a) == false) goto L18;
    L23:
        u r130 = (u) r129;
    L25:
        if (r130 == null) goto L46;
        CopyOnWriteArrayList<u> r131 = r126.c();
        if (r131 != null) goto L29;
    L43:
        boolean r132 = false;
    L44:
        if (r132 == false) goto L46;
        boolean r133 = true;
    L47:
        r111 = r133;
        goto L48
    L29:
        if (r131.isEmpty() == true) goto L40;
        Iterator<T> r134 = r131.iterator();
    L33:
        if (r134.hasNext() == false) goto L40;
        if (((u) r134.next()).f350490k != 1) goto L37;
        boolean r135 = true;
    L38:
        if (r135 == true) goto L33;
        boolean r136 = false;
    L41:
        if (r136 != true) goto L43;
        r132 = true;
        goto L44
    L37:
        r135 = false;
    L40:
        r136 = true;
        goto L41
    L22:
        r129 = null;
        goto L23
    L24:
        r130 = null;
    L46:
        r133 = false;
    L8:
        r102 = "";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final Object g(b r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof FlowImReceiveTracing$onReceiveReplyContentChunk$1) == false) goto L7;
        FlowImReceiveTracing$onReceiveReplyContentChunk$1 r100 = (FlowImReceiveTracing$onReceiveReplyContentChunk$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        long r110 = 0;
        String r111 = "";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        d0 r105 = (d0) r100.L$1;
        MessageEntity r106 = (MessageEntity) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L74:
        MessageEntity r107 = (MessageEntity) r102;
        if (r107 == null) goto L77;
        String r108 = com.larus.im.internal.database.utils.k.o(r107);
    L78:
        e0 r109 = new e0();
        m.b(r109, r105);
        Object r112 = k.f350321a;
        String r113 = r106.getMessageId();
        q r114 = k.d(r106.getReplyId());
        if (r114 == null) goto L95;
        CopyOnWriteArrayList<u> r115 = r114.c();
        if (r115 == null) goto L92;
        Iterator<T> r116 = r115.iterator();
    L84:
        if (r116.hasNext() == false) goto L88;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((u) r117).f350480a, r113) == false) goto L84;
    L89:
        u r118 = (u) r117;
        if (r118 == null) goto L92;
        Long r119 = Long.valueOf(com.larus.im.internal.network.stragery.a.a(r118.f350485f));
    L93:
        if (r119 == null) goto L95;
        r110 = r119.longValue();
        goto L95
    L88:
        r117 = null;
    L92:
        r119 = null;
    L95:
        ouc.j.b(r109, "last_package_duration", Boxing.boxLong(r110));
        if (r108 == null) goto L122;
        ouc.j.b(r109, "character_count", Boxing.boxInt(r108.length()));
        Object r120 = k.f350321a;
        Intrinsics.checkNotNullParameter(r108, "content");
        if (r108.length() != 0) goto L100;
        boolean r121 = true;
    L101:
        if (r121 == false) goto L103;
        int r122 = -1;
    L121:
        ouc.j.b(r109, "character_type", Boxing.boxInt(r122));
        goto L122
    L103:
        int r123 = 0;
        int r124 = 0;
    L105:
        if (r123 >= r108.length()) goto L113;
        if (com.flow.kmp.common.util.g.a(String.valueOf(r108.charAt(r123))).length != 1) goto L109;
        boolean r125 = true;
    L110:
        if (r125 == false) goto L112;
        r124 = r124 + 1;
    L112:
        r123 = r123 + 1;
        goto L105
    L109:
        r125 = false;
        goto L110
    L113:
        double r126 = (((double) r124) * 1.0d) / ((double) r108.length());
        if (r126 < 0.9d) goto L117;
        int r127 = 0;
    L120:
        r122 = r127;
        goto L121
    L117:
        if (r126 <= 0.1d) goto L119;
        r127 = 2;
        goto L120
    L119:
        r127 = 1;
        goto L120
    L100:
        r121 = false;
    L122:
        ouc.j.b(r109, EventConstant.Key.IS_FINISH, Boxing.boxInt(1));
        ouc.j.b(r109, "receive_first", Boxing.boxInt(1));
        ouc.j.b(r109, "receive_type", Boxing.boxInt(FetchType.CHUNK_STREAM.value));
        d0 r128 = r109.a();
        Object r129 = k.f350321a;
        k.i(r106.getMessageId(), r106.getReplyId());
        d1.f348206b.a("flow_im_message_receive_content_end", r128);
        MessageEntity r130 = r106;
    L123:
        r111 = "";
    L180:
        Object r131 = k.f350321a;
        String r132 = r130.getMessageId();
        if (r132 != null) goto L183;
        r132 = r111;
    L183:
        String r133 = r130.getReplyId();
        if (r133 != null) goto L186;
        r133 = r111;
    L186:
        Intrinsics.checkNotNullParameter(r132, "botMessageId");
        q r134 = k.d(r133);
        if (r134 == null) goto L193;
        CopyOnWriteArrayList<String> r135 = r134.b();
        if (r135 == null) goto L193;
        if (r135.contains(r132) != true) goto L193;
        boolean r136 = true;
    L194:
        if (r136 == true) goto L236;
        if (com.larus.im.internal.database.utils.k.e(r130) == 1) goto L198;
    L203:
        boolean r137 = false;
    L204:
        if (r137 == false) goto L236;
        String r138 = r130.getMessageId();
        if (r138 != null) goto L208;
        r138 = r111;
    L208:
        String r139 = r130.getReplyId();
        if (r139 != null) goto L211;
        r139 = r111;
    L211:
        Intrinsics.checkNotNullParameter(r138, "botMessageId");
        q r140 = k.d(r139);
        if (r140 == null) goto L216;
        CopyOnWriteArrayList<String> r141 = r140.b();
        if (r141 == null) goto L216;
        r141.add(r138);
    L216:
        Map<String, String> r142 = com.larus.im.internal.database.utils.k.c(r130);
        String r143 = r142.get("bot_state");
        if (r143 != null) goto L219;
        r143 = SliceInitService.DEFAULT_SWITCH;
    L219:
        ouc.i r144 = (ouc.i) xt7.d.a(r143).get("agent_id");
        if (r144 == null) goto L222;
        String r145 = ouc.k.o(r144).a();
    L223:
        if (r145 != null) goto L225;
        String r212 = r111;
    L226:
        int r146 = c.f350315a;
        int r147 = FetchType.CHUNK_STREAM.value;
        int r148 = com.larus.im.internal.database.utils.k.e(r130);
        String r149 = r130.getReplyId();
        if (r149 != null) goto L229;
        String r150 = r111;
    L230:
        String r151 = r130.getMessageId();
        if (r151 != null) goto L233;
        String r152 = r111;
    L234:
        c.f(r147, r148, r150, r152, ResultStatus.SUCCESS.ordinal(), r142.get("intention"), r142.get("llm_model_type"), Boxing.boxLong(fuc.a.a().a()), r212);
        goto L236
    L233:
        r152 = r151;
        goto L234
    L229:
        r150 = r149;
        goto L230
    L225:
        r212 = r145;
        goto L226
    L222:
        r145 = null;
        goto L223
    L198:
        if (com.larus.im.internal.database.utils.k.o(r130).length() <= 0) goto L200;
        boolean r153 = true;
    L201:
        if (r153 == false) goto L203;
        r137 = true;
        goto L204
    L200:
        r153 = false;
    L236:
        return Unit.INSTANCE;
    L193:
        r136 = false;
        goto L194
    L77:
        r108 = null;
        goto L78
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        com.larus.im.internal.network.e<FetchChunkMessageDownlinkBody> r154 = r210.f350313h;
        r130 = r210.f350314i;
        if ((r154 instanceof com.larus.im.internal.network.e.f) == false) goto L17;
        com.larus.im.internal.network.e.f r155 = (com.larus.im.internal.network.e.f) r154;
    L18:
        if (r155 == null) goto L238;
        FetchChunkMessageDownlinkBody r156 = (FetchChunkMessageDownlinkBody) r155.f349185a;
        if (r156 == null) goto L238;
        if (r156.contentType == 2) goto L25;
        int r157 = ((com.larus.im.internal.network.e.f) r154).f349186b.getCode();
        String r158 = r130.getMessageId();
        if (r158 != null) goto L29;
        String r159 = "";
    L30:
        String r160 = r130.getReplyId();
        if (r160 != null) goto L33;
        String r213 = "";
    L34:
        d0 r161 = C(0, r157, "", r159, r213, Boxing.boxInt(com.larus.im.internal.database.utils.k.e(r130)), false);
        e0 r162 = new e0();
        m.b(r162, r161);
        ouc.j.b(r162, "status", Boxing.boxInt(ResultStatus.SUCCESS.ordinal()));
        ouc.j.c(r162, "log_id", r210.f350310e);
        ouc.j.c(r162, "intention", com.larus.im.internal.database.utils.k.c(r130).get("intention"));
        r105 = r162.a();
        int r163 = r156.seqNo;
        if (r163 == 0) goto L37;
        if (r163 == 1) goto L37;
    L57:
        Map<String, String> r164 = r156.ext;
        if (r164 == null) goto L60;
        String r165 = r164.get(EventConstant.Key.IS_FINISH);
    L62:
        if (Intrinsics.areEqual(r165, "1") == false) goto L64;
    L65:
        Object r166 = k.f350321a;
        if (k.f(r130.getMessageId(), r130.getReplyId()) == true) goto L124;
        be9.d r167 = ae9.e.a();
        String r168 = r130.getMessageId();
        if (r168 != null) goto L70;
        r168 = "";
    L70:
        r100.L$0 = r130;
        r100.L$1 = r105;
        r100.label = 1;
        r102 = ((MessageDaoSource) r167).a(r168, r100);
        if (r102 != r103) goto L73;
        return r103;
    L73:
        r106 = r130;
    L124:
        StreamChannel r169 = StreamChannel.f350095a;
        String r170 = r130.getMessageId();
        if (r170 != null) goto L127;
        r170 = "";
    L127:
        r169.getClass();
        Intrinsics.checkNotNullParameter(r170, "messageId");
        Typewriter.a r171 = Typewriter.f350104t;
        Typewriter r172 = Typewriter.a.a(r170);
        if (r172 == null) goto L130;
        Boolean r173 = Boolean.valueOf(r172.f350117g);
    L131:
        e0 r174 = new e0();
        m.b(r174, r105);
        Object r175 = k.f350321a;
        String r176 = r130.getMessageId();
        q r177 = k.d(r130.getReplyId());
        if (r177 == null) goto L152;
        CopyOnWriteArrayList<u> r178 = r177.c();
        if (r178 == null) goto L149;
        Iterator<T> r179 = r178.iterator();
    L137:
        if (r179.hasNext() == false) goto L141;
        Object r180 = r179.next();
        if (Intrinsics.areEqual(((u) r180).f350480a, r176) == false) goto L137;
    L142:
        u r181 = (u) r180;
        if (r181 == null) goto L149;
        long r182 = r181.f350485f;
        if (r182 > 0) goto L148;
        r182 = r181.f350484e;
    L148:
        long r183 = com.larus.im.internal.network.stragery.a.a(r182);
        r181.f350485f = SystemClock.elapsedRealtime();
        Long r184 = Long.valueOf(r183);
    L150:
        if (r184 == null) goto L153;
        long r185 = r184.longValue();
    L154:
        ouc.j.b(r174, "duration", Boxing.boxLong(r185));
        if (r173 == null) goto L157;
        Integer r186 = Boxing.boxInt(!r173.booleanValue() ? 1 : 0);
    L158:
        ouc.j.b(r174, "has_stuck", r186);
        if (r173 == null) goto L161;
        int r187 = 1;
    L162:
        ouc.j.b(r174, "is_typewriter", Boxing.boxInt(r187));
        d0 r188 = r174.a();
        Object r189 = k.f350321a;
        String r190 = r130.getMessageId();
        q r191 = k.d(r130.getReplyId());
        if (r191 == null) goto L175;
        CopyOnWriteArrayList<u> r192 = r191.c();
        if (r192 == null) goto L175;
        Iterator<T> r193 = r192.iterator();
    L168:
        if (r193.hasNext() == false) goto L172;
        Object r194 = r193.next();
        if (Intrinsics.areEqual(((u) r194).f350480a, r190) == false) goto L168;
    L173:
        u r195 = (u) r194;
        goto L175
    L172:
        r194 = null;
    L175:
        if (com.larus.im.internal.utils.w.f350562a.nextInt(1000) != 0) goto L177;
        boolean r196 = true;
    L178:
        if (r196 == false) goto L180;
        d1.f348206b.a("flow_im_message_receive_package", r188);
        goto L180
    L177:
        r196 = false;
        goto L178
    L161:
        r187 = 0;
        goto L162
    L157:
        r186 = null;
    L153:
        r185 = 0;
        goto L154
    L141:
        r180 = null;
    L149:
        r184 = null;
        goto L150
    L152:
        r111 = "";
        goto L153
    L130:
        r173 = null;
        goto L131
    L64:
        if (r130.getStatus() != 21) goto L124;
    L60:
        r165 = null;
    L37:
        Object r197 = k.f350321a;
        if (k.g(r130.getMessageId(), r130.getReplyId()) == true) goto L57;
        String r198 = r130.getMessageId();
        if (r198 != null) goto L42;
        r198 = "";
    L42:
        q r199 = k.d(r130.getReplyId());
        if (r199 == null) goto L56;
        CopyOnWriteArrayList<u> r200 = r199.c();
        if (r200 == null) goto L56;
        Iterator<T> r201 = r200.iterator();
    L48:
        if (r201.hasNext() == false) goto L52;
        Object r202 = r201.next();
        if (Intrinsics.areEqual(((u) r202).f350480a, r198) == false) goto L48;
    L53:
        u r203 = (u) r202;
        if (r203 == null) goto L56;
        r203.f350484e = SystemClock.elapsedRealtime();
        goto L56
    L52:
        r202 = null;
    L56:
        d1.f348206b.a("flow_im_message_receive_first_chunk", r105);
        goto L123
    L33:
        r213 = r160;
        goto L34
    L29:
        r159 = r158;
        goto L30
    L25:
        return Unit.INSTANCE;
    L238:
        return Unit.INSTANCE;
    L17:
        r155 = null;
    L7:
        r100 = new FlowImReceiveTracing$onReceiveReplyContentChunk$1(this, r211);
        goto L8
    }

    public final void E(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "replyId");
        Object r103 = k.f350321a;
        Intrinsics.checkNotNullParameter(r101, "replyMsgId");
        q r104 = k.d(r101);
        if (r104 == null) goto L16;
        CopyOnWriteArrayList<u> r105 = r104.c();
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(r100, ((u) r107).f350480a) == false) goto L8;
    L13:
        u r108 = (u) r107;
        if (r108 == null) goto L16;
        r108.f350490k = 1;
        r108.f350489j = r102;
        goto L16
    L12:
        r107 = null;
    L16:
        B(r101, r102);
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void f(MessageSuggestFrom r110, String r111, String r112, List<SuggestQuestion> r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, "replyId");
        Intrinsics.checkNotNullParameter(r113, "suggest");
        q r100 = k.d(r112);
        Long r101 = null;
        if (r100 == null) goto L17;
        CopyOnWriteArrayList<u> r102 = r100.c();
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((u) r104).f350480a, r111) == false) goto L8;
    L13:
        u r105 = (u) r104;
        if (r105 == null) goto L17;
        r105.f350488i = SystemClock.elapsedRealtime();
        goto L17
    L12:
        r104 = null;
    L17:
        if (k.a(r111, r112) > 0) goto L43;
        e0 r115 = new e0();
        int r106 = c.f350315a;
        m.b(r115, c.b("", r111, r112, 2, k.c(r112, r111)));
        q r107 = k.d(r112);
        if (r107 == null) goto L34;
        CopyOnWriteArrayList<u> r108 = r107.c();
        if (r108 == null) goto L32;
        Iterator<T> r109 = r108.iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        Object r116 = r109.next();
        if (Intrinsics.areEqual(((u) r116).f350480a, r111) == false) goto L24;
    L29:
        u r117 = (u) r116;
        if (r117 == null) goto L32;
        r117.f350487h = SystemClock.elapsedRealtime();
        r101 = Long.valueOf(com.larus.im.internal.network.stragery.a.a(r117.f350486g));
        goto L32
    L28:
        r116 = null;
    L32:
        if (r101 == null) goto L34;
        long r118 = r101.longValue();
    L35:
        m.b(r115, c.c(r111, r112, r118, 0, false));
        int r119 = c.f350315a;
        m.b(r115, c.d(0, 0, ""));
        ouc.j.b(r115, "from", Integer.valueOf(r110.ordinal() + 1));
        ouc.j.c(r115, "intention", r114);
        d1.f348206b.a("flow_im_message_receive_first_suggest", r115.a());
        return;
    L34:
        r118 = 0;
        goto L35
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void t(String r310, Integer r311, NewMessageNotify r410, ReceiveMessageFrom r411, Long r412) {
        Intrinsics.checkNotNullParameter(r310, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r411, "from");
        if (r410 != null) goto L5;
        return;
    L5:
        int r100 = r410.fetchType;
        if (r411 != ReceiveMessageFrom.FIRST_PACKAGE_TIME_OUT) goto L8;
        r100 = 4;
    L8:
        MessageBody r101 = r410.message;
        if (r101 == null) goto L14;
        String r102 = r101.botReplyMessageId;
        if (r102 == null) goto L14;
        String r210 = r102;
    L16:
        if (k.e(r210) == true) goto L18;
        return;
    L18:
        MessageBody r110 = r410.message;
        if (r110 == null) goto L21;
        String r103 = r110.messageId;
    L22:
        if (r103 != null) goto L24;
        String r104 = "";
    L25:
        if (r110 == null) goto L27;
        String r105 = r110.botReplyMessageId;
    L28:
        if (r105 != null) goto L30;
        r105 = "";
    L30:
        boolean r312 = false;
        if (r110 == null) goto L33;
        int r106 = com.larus.im.internal.database.utils.j.d(r110);
    L34:
        if (r110 == null) goto L36;
        Map<String, String> r107 = r110.ext;
    L37:
        Intrinsics.checkNotNullParameter(r104, "botMessageId");
        q r108 = k.d(r105);
        if (r108 == null) goto L55;
        CopyOnWriteArrayList<u> r109 = r108.c();
        if (r109 == null) goto L49;
        Iterator<T> r111 = r109.iterator();
    L43:
        if (r111.hasNext() == false) goto L47;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((u) r112).f350480a, r104) == false) goto L43;
    L48:
        u r113 = (u) r112;
    L50:
        if (r113 != null) goto L55;
        r108.f350465m++;
        CopyOnWriteArrayList<u> r114 = r108.c();
        if (r114 == null) goto L55;
        r114.add(new u(r104, r106, r108.f350465m, r107, 2036));
        goto L55
    L47:
        r112 = null;
        goto L48
    L49:
        r113 = null;
    L55:
        boolean r115 = k.h(r210);
        String r313 = SliceInitService.DEFAULT_SWITCH;
        if (r115 == true) goto L89;
        MessageBody r116 = r410.message;
        if (r116 == null) goto L63;
        Map<String, String> r117 = r116.ext;
        if (r117 == null) goto L63;
        String r118 = r117.get("bot_state");
        if (r118 == null) goto L63;
    L64:
        ouc.i r119 = (ouc.i) xt7.d.a(r118).get("agent_id");
        if (r119 == null) goto L67;
        String r120 = ouc.k.o(r119).a();
    L68:
        if (r120 != null) goto L70;
        String r121 = "";
    L71:
        int r122 = c.f350315a;
        if (r110 == null) goto L74;
        int r123 = com.larus.im.internal.database.utils.j.d(r110);
    L75:
        int r124 = ResultStatus.SUCCESS.ordinal();
        if (r110 == null) goto L80;
        Map<String, String> r125 = r110.ext;
        if (r125 == null) goto L80;
        String r126 = r125.get("intention");
    L81:
        if (r110 == null) goto L85;
        Map<String, String> r127 = r110.ext;
        if (r127 == null) goto L85;
        String r211 = r127.get("llm_model_type");
    L86:
        Object r128 = "intention";
        Object r314 = "agent_id";
        Object r315 = "bot_state";
        Object r316 = "llm_model_type";
        String r317 = "botMessageId";
        c.g(r100, r123, r210, r310, r124, 0, "", r126, r211, r412, r121);
        q r129 = k.d(r210);
        if (r129 == null) goto L90;
        r129.f350470r = SystemClock.elapsedRealtime();
    L90:
        MessageBody r130 = r410.message;
        if (r130 == null) goto L114;
        if (r100 != FetchType.FRONTIER_PUSH.value) goto L95;
    L98:
        String r131 = r130.messageId;
        if (r131 != null) goto L101;
        String r132 = "";
    L102:
        String r133 = r130.botReplyMessageId;
        if (r133 != null) goto L105;
        String r134 = "";
    L106:
        int r135 = com.larus.im.internal.database.utils.j.d(r130);
        int r212 = ResultStatus.SUCCESS.ordinal();
        MessageBody r136 = r410.message;
        if (r136 == null) goto L111;
        Map<String, String> r137 = r136.ext;
        if (r137 == null) goto L111;
        String r213 = r137.get(r128);
    L112:
        D(this, 0, r132, r134, r135, r212, r100, "", null, true, r213, 128);
    L111:
        r213 = null;
        goto L112
    L105:
        r134 = r133;
        goto L106
    L101:
        r132 = r131;
        goto L102
    L95:
        if (r100 != FetchType.CLIENT_PULL.value) goto L114;
        if (r411 == ReceiveMessageFrom.CLIENT_PULL) goto L98;
    L114:
        if (r110 == 0) goto L116;
        String r138 = r110.messageId;
    L117:
        if (r138 != null) goto L119;
        r138 = "";
    L119:
        if (r110 == 0) goto L121;
        String r139 = r110.botReplyMessageId;
    L122:
        if (r139 != null) goto L124;
        r139 = "";
    L124:
        String r140 = r317;
        Intrinsics.checkNotNullParameter(r138, r140);
        q r141 = k.d(r139);
        if (r141 == null) goto L131;
        CopyOnWriteArrayList<String> r142 = r141.b();
        if (r142 == null) goto L131;
        boolean r143 = r142.contains(r138);
        int r144 = 1;
        if (r143 != true) goto L132;
        boolean r145 = true;
    L133:
        if (r145 == true) goto L231;
        if (r110 != 0) goto L136;
    L138:
        boolean r146 = false;
    L139:
        if (r146 == false) goto L180;
        IntRange r147 = com.larus.im.internal.database.utils.j.f348165a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110.contentType == 9999) goto L143;
    L145:
        boolean r148 = false;
    L146:
        if (r148 == false) goto L148;
    L151:
        boolean r149 = true;
    L152:
        if (r149 == false) goto L165;
        List<Block> r150 = r110.contentBlock;
        if (r150 != null) goto L164;
        String r151 = r110.content;
        if (r151 == null) goto L161;
        String r152 = r110.messageId;
        if (r152 != null) goto L160;
        r152 = "";
    L160:
        r150 = com.larus.im.bean.message.a.a(r151, r152);
    L162:
        if (r150 != null) goto L164;
        r150 = CollectionsKt.emptyList();
        goto L164
    L161:
        r150 = null;
    L164:
        String r153 = com.larus.im.internal.core.message.concat.b.d(com.larus.im.internal.core.message.concat.b.c(r150));
    L175:
        if (r153.length() <= 0) goto L177;
        boolean r154 = true;
    L178:
        if (r154 == false) goto L180;
        r312 = true;
        goto L180
    L177:
        r154 = false;
        goto L178
    L165:
        String r155 = r110.content;
        if (r155 == null) goto L171;
        String r156 = r110.messageId;
        if (r156 != null) goto L170;
        r156 = "";
    L170:
        r153 = com.larus.im.bean.message.a.H0(r155, r156);
    L172:
        if (r153 != null) goto L175;
        r153 = "";
        goto L175
    L171:
        r153 = null;
        goto L172
    L148:
        if (com.larus.im.internal.database.utils.j.f(r110) == true) goto L151;
        r149 = false;
        goto L152
    L143:
        if (com.larus.im.internal.database.utils.j.f(r110) == true) goto L145;
        r148 = true;
    L180:
        if (r312 == false) goto L232;
        if (r110 == 0) goto L183;
        String r157 = r110.messageId;
    L184:
        if (r157 != null) goto L186;
        r157 = "";
    L186:
        if (r110 == 0) goto L188;
        String r158 = r110.botReplyMessageId;
    L189:
        if (r158 != null) goto L191;
        r158 = "";
    L191:
        Intrinsics.checkNotNullParameter(r157, r140);
        q r159 = k.d(r158);
        if (r159 == null) goto L196;
        CopyOnWriteArrayList<String> r160 = r159.b();
        if (r160 == null) goto L196;
        r160.add(r157);
    L196:
        MessageBody r161 = r410.message;
        if (r161 == null) goto L204;
        Map<String, String> r162 = r161.ext;
        if (r162 == null) goto L204;
        String r163 = r162.get(r315);
        if (r163 == null) goto L204;
        r313 = r163;
    L204:
        ouc.i r164 = (ouc.i) xt7.d.a(r313).get(r314);
        if (r164 == null) goto L207;
        String r165 = ouc.k.o(r164).a();
    L208:
        if (r165 != null) goto L210;
        String r166 = "";
    L211:
        int r167 = c.f350315a;
        if (r110 == 0) goto L214;
        int r168 = com.larus.im.internal.database.utils.j.d(r110);
    L215:
        int r169 = ResultStatus.SUCCESS.ordinal();
        if (r110 == 0) goto L220;
        Map<String, String> r170 = r110.ext;
        if (r170 == null) goto L220;
        String r171 = r170.get(r128);
    L221:
        if (r110 == 0) goto L225;
        Map<String, String> r172 = r110.ext;
        if (r172 == null) goto L225;
        String r173 = r172.get(r316);
    L226:
        c.f(r100, r168, r210, r310, r169, r171, r173, r412, r166);
        return;
    L225:
        r173 = null;
    L220:
        r171 = null;
        goto L221
    L214:
        r168 = -1;
        goto L215
    L210:
        r166 = r165;
        goto L211
    L207:
        r165 = null;
        goto L208
    L188:
        r158 = null;
        goto L189
    L183:
        r157 = null;
        goto L184
    L232:
        return;
    L136:
        if (com.larus.im.internal.database.utils.j.d(r110) != r144) goto L138;
        r146 = true;
        goto L139
    L231:
        return;
    L132:
        r145 = false;
    L131:
        r144 = 1;
        goto L132
    L121:
        r139 = null;
        goto L122
    L116:
        r138 = null;
    L85:
        r211 = null;
    L80:
        r126 = null;
        goto L81
    L74:
        r123 = -1;
        goto L75
    L70:
        r121 = r120;
        goto L71
    L67:
        r120 = null;
    L63:
        r118 = SliceInitService.DEFAULT_SWITCH;
        goto L64
    L89:
        r128 = "intention";
        r314 = "agent_id";
        r315 = "bot_state";
        r316 = "llm_model_type";
        r317 = "botMessageId";
        goto L90
    L36:
        r107 = null;
        goto L37
    L33:
        r106 = 0;
        goto L34
    L27:
        r105 = null;
        goto L28
    L24:
        r104 = r103;
        goto L25
    L21:
        r103 = null;
    L14:
        r210 = "";
        goto L16
    }

    @Override // com.larus.im.internal.tracking.e, com.larus.im.internal.tracking.r
    public final void z(String r210, String r211, com.larus.im.internal.network.e<DownlinkBody> r212, ReceiveMessageFrom r213, Long r310, String r311) {
        Intrinsics.checkNotNullParameter(r211, "replyMsgId");
        Intrinsics.checkNotNullParameter(r212, "errorStatus");
        Intrinsics.checkNotNullParameter(r213, "from");
        if (r211.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        if ((r212 instanceof com.larus.im.internal.network.e.f) == false) goto L11;
        return;
    L11:
        if (k.e(r211) == true) goto L13;
        return;
    L13:
        if ((r212 instanceof com.larus.im.internal.network.e.c) == false) goto L17;
        int r101 = ResultStatus.INTERRUPT.ordinal();
    L15:
        int r110 = r101;
        boolean r214 = k.h(r211);
        int r102 = a.f350218a[r213.ordinal()];
        if (r102 != 1) goto L26;
        int r103 = FetchType.FRONTIER_PUSH.value;
    L36:
        int r215 = r103;
    L38:
        if (r110 == ResultStatus.INTERRUPT.ordinal()) goto L44;
        if (r110 == ResultStatus.TIMEOUT.ordinal()) goto L44;
        if (r110 == ResultStatus.ERROR.ordinal()) goto L44;
    L60:
        int r104 = r110;
    L61:
        if (r214 == false) goto L76;
        int r105 = r212.a().getCode();
        if (r210 != null) goto L65;
        String r106 = "";
    L66:
        String r107 = r212.a().getTips();
        if (r107 != null) goto L69;
        String r108 = "";
    L70:
        D(this, r105, r106, r211, 0, r104, r215, r108, null, false, r311, 384);
        return;
    L69:
        r108 = r107;
        goto L70
    L65:
        r106 = r210;
        goto L66
    L76:
        return;
    L44:
        if (k.h(r211) == true) goto L60;
        q r109 = k.d(r211);
        if (r109 == null) goto L48;
        r109.f350470r = SystemClock.elapsedRealtime();
    L48:
        int r111 = c.f350315a;
        int r112 = r212.a().getCode();
        String r113 = r212.a().getTips();
        if (r113 != null) goto L51;
        String r114 = "";
    L52:
        c.g(r215, -1, r211, "", r110, r112, r114, null, null, r310, null);
        r104 = r110;
        k0.f348247b.d(r211, new ISDKPointCallback.EndMsg("-1", -1, r104, false, 0, 16, null));
        Object r115 = k.f350321a;
        monitor-enter(r115);
        q r116 = k.f350322b.remove(r211);     // Catch: Throwable -> L57
        monitor-exit(r115);
    L57:
        th = move-exception;
        throw th;
    L51:
        r114 = r113;
        goto L52
    L26:
        if (r102 != 2) goto L28;
        r103 = FetchType.CLIENT_PULL.value;
        goto L36
    L28:
        if (r102 == 3) goto L33;
        if (r102 != 4) goto L32;
        r215 = -1;
        goto L38
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r215 = 4;
        goto L38
    L17:
        if ((r212 instanceof com.larus.im.internal.network.e.g) == false) goto L20;
        r101 = ResultStatus.TIMEOUT.ordinal();
        goto L15
    L20:
        if ((r212 instanceof com.larus.im.internal.network.e.a) == false) goto L22;
        r101 = ResultStatus.CANCEL.ordinal();
        goto L15
    L22:
        r101 = ResultStatus.ERROR.ordinal();
        goto L15
    L5:
        r100 = false;
        goto L6
    }

    public static d0 C(int r100, int r101, String r102, String r110, String r111, Integer r112, boolean r113) {
        e0 r103 = new e0();
        int r104 = c.f350315a;
        m.b(r103, c.d(r100, r101, r102));
        m.b(r103, c.b("", r110, r111, r112, k.c(r111, r110)));
        q r105 = k.d(r111);
        if (r105 == null) goto L5;
        long r106 = com.larus.im.internal.network.stragery.a.a(r105.f350470r);
    L6:
        m.b(r103, c.c(r110, r111, r106, r100, r113));
        m.b(r103, ce9.a.a());
        ouc.j.b(r103, "received_count", Integer.valueOf(k.b(r110, r111)));
        return r103.a();
    L5:
        r106 = 0;
        goto L6
    }

    public static void D(FlowImReceiveTracing r110, int r111, String r112, String r113, int r114, int r115, int r116, String r117, String r118, boolean r119, String r210, int r211) {
        if ((r211 & 128) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 256) == 0) goto L9;
        boolean r101 = false;
    L10:
        r110.getClass();
        if (k.f(r112, r113) == false) goto L14;
        return;
    L14:
        if (r112.length() != 0) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L19;
    L21:
        d0 r103 = C(r115, r111, r117, r112, r113, Integer.valueOf(r114), r101);
        k.i(r112, r113);
        e0 r104 = new e0();
        m.b(r104, r103);
        ouc.j.b(r104, "receive_first", Integer.valueOf(k.g(r112, r113) ? 1 : 0));
        ouc.j.b(r104, "receive_type", Integer.valueOf(r116));
        ouc.j.b(r104, EventConstant.Key.IS_FINISH, 0);
        ouc.j.c(r104, "log_id", r100);
        ouc.j.c(r104, "intention", r210);
        d0 r105 = r104.a();
        d1.f348206b.a("flow_im_message_receive_content_end", r105);
        r110.E(r112, r113, r115);
        return;
    L19:
        if (r115 != ResultStatus.INTERRUPT.ordinal()) goto L21;
        return;
    L16:
        r102 = false;
        goto L17
    L9:
        r101 = r119;
        goto L10
    L5:
        r100 = r118;
        goto L7
    }
}

package com.larus.im.internal.stream;

import android.os.SystemClock;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.database.utils.j;
import com.larus.im.internal.database.utils.k;
import com.larus.im.internal.database.utils.o;
import com.larus.im.internal.protocol.bean.MessageBody;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
public final class PendingHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PendingHandler f350084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f350085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f350086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f350087d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f350088e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f350089f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f350090g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PendingHandler$globalStreamObserver$1 f350091h = null;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageBody f350092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function3<MessageBody, Long, Continuation<? super Unit>, Object> f350093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f350094c;

        public final Object a(Continuation<? super Unit> r100) {
            Object r101 = this.f350093b.invoke(this.f350092a, Boxing.boxLong(SystemClock.elapsedRealtime() - this.f350094c), r100);
            if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r101;
        L6:
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(MessageBody r100, Function3<? super MessageBody, ? super Long, ? super Continuation<? super Unit>, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
            Intrinsics.checkNotNullParameter(r101, "block");
            this.f350092a = r100;
            this.f350093b = r101;
            this.f350094c = SystemClock.elapsedRealtime();
        }
    }

    public PendingHandler() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.im.internal.stream.PendingHandler$globalStreamObserver$1] */
    static {
        f350084a = new PendingHandler();
        f350085b = new CopyOnWriteArrayList();
        f350086c = new LinkedHashSet();
        f350087d = "_pending";
        f350088e = new CopyOnWriteArrayList();
        f350089f = new CopyOnWriteArrayList();
        f350090g = true;
        f350091h = new PendingHandler$globalStreamObserver$1();
    }

    public static final void a(String r100) {
        CopyOnWriteArrayList<String> r101 = f350088e;
        if (r101.contains(r100) == false) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r100, "0") == true) goto L19;
        r101.add(r100);
        if (r101.size() <= 100) goto L18;
        r101.remove(0);
        return;
    L18:
        return;
    L19:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public static void c(String r100) {
        e.c(new PendingHandler$handleCvsPendingMsg$1(r100, null));
    }

    public static boolean d(String r100) {
        Iterator<a> r101 = f350085b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a r102 = r101.next();
        if (Intrinsics.areEqual(r102.f350092a.messageId, r100) == false) goto L4;
    L9:
        if (r102 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r102 = null;
        goto L9
    }

    public static final Object b(PendingHandler r100, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof PendingHandler$isCurCvsMsgStreaming$1) == false) goto L7;
        PendingHandler$isCurCvsMsgStreaming$1 r101 = (PendingHandler$isCurCvsMsgStreaming$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r106 = r101.I$0;
        MessageEntity r113 = (MessageEntity) r101.L$1;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L56:
        int r108 = r106;
        if (((Boolean) r112).booleanValue() == true) goto L59;
        MessageEntity r114 = r113;
        r110 = r107;
    L60:
        boolean r109 = true;
    L62:
        com.larus.im.internal.delegate.a r115 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r116 = new StringBuilder("isCurCvsMsg streaming cvsId = ");
        r116.append(r110);
        r116.append(" isSelf = ");
        r116.append(o.a(r114));
        r116.append("isReceiveStreaming= ");
        if (r108 == 0) goto L65;
        boolean r117 = true;
    L66:
        r116.append(r117);
        r116.append("isSendStreaming = ");
        r116.append(r109);
        r115.i("PendingHandler", r116.toString());
        if (r108 != 0) goto L69;
        if (r109 == true) goto L69;
    L71:
        return Boxing.boxBoolean(r105);
    L69:
        r105 = true;
        goto L71
    L65:
        r117 = false;
        goto L66
    L59:
        r114 = r113;
        r110 = r107;
    L61:
        r109 = false;
        goto L62
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        r114 = (MessageEntity) r112;
        if (r114 == null) goto L73;
        String r118 = "";
        if (o.a(r114) == true) goto L39;
        b r119 = b.f350138a;
        String r120 = r114.getMessageId();
        if (r120 != null) goto L31;
        r120 = "";
    L31:
        if (r119.c(r120) != null) goto L35;
        if (r114.getStatus() != 24) goto L39;
    L35:
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(6)}).contains(Boxing.boxInt(k.e(r114))) == false) goto L37;
    L38:
        r108 = 1;
    L41:
        if (o.a(r114) == false) goto L61;
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(13), Boxing.boxInt(12), Boxing.boxInt(14)}).contains(Boxing.boxInt(r114.getStatus())) == true) goto L61;
        if (r114.getStatus() == 10) goto L60;
        if (r114.getStatus() != 11) goto L61;
        String r121 = r114.getMessageId();
        if (r121 == null) goto L52;
        r118 = r121;
    L52:
        r101.L$0 = r110;
        r101.L$1 = r114;
        r101.I$0 = r108;
        r101.label = 2;
        Object r122 = r100.e(r110, r118, r101);
        if (r122 == r103) goto L75;
        r107 = r110;
        r113 = r114;
        r112 = r122;
        r106 = r108;
        goto L56
    L75:
        return r103;
    L37:
        if (k.g(r114) == true) goto L38;
    L39:
        r108 = 0;
        goto L41
    L73:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r112);
        if (r110 == null) goto L72;
        be9.d r123 = ae9.e.a();
        r101.L$0 = r110;
        r101.label = 1;
        r112 = r123.C(r110, r101);
        if (r112 != r103) goto L22;
        return r103;
    L72:
        return Boxing.boxBoolean(false);
    L7:
        r101 = new PendingHandler$isCurCvsMsgStreaming$1(r100, r111);
        goto L8
    }

    public final Object e(String r100, String r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof PendingHandler$isReceivedFirstPackage$1) == false) goto L7;
        PendingHandler$isReceivedFirstPackage$1 r103 = (PendingHandler$isReceivedFirstPackage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        Iterator r109 = ((List) r105).iterator();
        if (r109.hasNext() == false) goto L26;
        if (((MessageEntity) r109.next()).getStatus() != 24) goto L24;
        r108 = false;
    L24:
        return Boxing.boxBoolean(r108);
    L26:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        be9.d r110 = ae9.e.a();
        r103.label = 1;
        r105 = r110.i(r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new PendingHandler$isReceivedFirstPackage$1(this, r102);
        goto L8
    }

    public static Object f(MessageBody r100, boolean r101, Function3 r102, Continuation r103) {
        a r104 = new a(r100, r102);
        if (f350088e.contains(r100.botReplyMessageId) == true) goto L5;
    L30:
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "pending false: message_id = " + r100.messageId + ", reply_id = " + r100.botReplyMessageId + " ignorePending=" + r101);
        Object r105 = r104.a(r103);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        return r105;
    L34:
        return Unit.INSTANCE;
    L5:
        if (f350090g == false) goto L30;
        if (r101 == true) goto L30;
        IntRange r106 = j.f348165a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r107 = r100.ext;
        if (r107 != null) goto L11;
        r107 = MapsKt.emptyMap();
    L11:
        if (j.l(r107) == true) goto L30;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r108 = r100.ext;
        if (r108 != null) goto L16;
        r108 = MapsKt.emptyMap();
    L16:
        if (j.k(r108) == true) goto L30;
        Iterator<a> r109 = f350089f.iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        a r110 = r109.next();
        if (Intrinsics.areEqual(r110.f350092a, r100) == false) goto L20;
    L25:
        if (r110 != null) goto L27;
        f350089f.add(r104);
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "pending true: message_id = " + r100.messageId + ", reply_id = " + r100.botReplyMessageId);
    L29:
        return Unit.INSTANCE;
    L27:
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "pending exist: message_id = " + r100.messageId + ", reply_id = " + r100.botReplyMessageId);
        goto L29
    L24:
        r110 = null;
        goto L25
    }
}

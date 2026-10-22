package com.larus.im.internal.database.mock;

import be9.d;
import buc.a;
import buc.b;
import com.flow.kmp.common.util.i;
import com.larus.im.internal.database.delegate.ConversationDaoSource;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class MockMessageDaoSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MockMessageDaoSource f348123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f348124b = null;

    public MockMessageDaoSource() {
    }

    static {
        f348123a = new MockMessageDaoSource();
        f348124b = b.a(false);
    }

    public static MessageDaoSource f() {
        d.f18789c.getClass();
        return new MessageDaoSource();
    }

    public final Object e(Continuation<? super String> r100) {
        if ((r100 instanceof MockMessageDaoSource$mainCvsId$1) == false) goto L7;
        MockMessageDaoSource$mainCvsId$1 r101 = (MockMessageDaoSource$mainCvsId$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        ConversationEntity r106 = (ConversationEntity) r103;
        if (r106 == null) goto L20;
        String r107 = r106.getConversationId();
    L21:
        if (r107 != null) goto L24;
        return "";
    L24:
        return r107;
    L20:
        r107 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        be9.b.f18784b.getClass();
        ConversationDaoSource r108 = new ConversationDaoSource();
        r101.label = 1;
        r103 = r108.j(r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MockMessageDaoSource$mainCvsId$1(this, r100);
        goto L8
    }

    public static final Object a(MockMessageDaoSource r100, long r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MockMessageDaoSource$deleteMainMessage$1) == false) goto L7;
        MockMessageDaoSource$deleteMainMessage$1 r103 = (MockMessageDaoSource$deleteMainMessage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 != 3) goto L15;
        ResultKt.throwOnFailure(r105);
    L27:
        long r108 = ((Number) r105).longValue();
        com.larus.im.internal.delegate.a.f348188b.i("MockMessageDaoSource", "deleteMainMessage, result:" + r108);
        return Boxing.boxLong(r108);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        MessageDaoSource r110 = f();
        r103.L$0 = null;
        r103.label = 3;
        r105 = r110.I(r109, r103);
        if (r105 != r106) goto L27;
        return r106;
    L17:
        r101 = r103.J$0;
        ResultKt.throwOnFailure(r105);
    L21:
        r109 = (String) r105;
        r103.L$0 = r109;
        r103.label = 2;
        if (f().l(r109, (int) r101, r103) != r106) goto L24;
        return r106;
    L18:
        ResultKt.throwOnFailure(r105);
        r103.J$0 = r101;
        r103.label = 1;
        r105 = r100.e(r103);
        if (r105 != r106) goto L21;
        return r106;
    L7:
        r103 = new MockMessageDaoSource$deleteMainMessage$1(r100, r102);
        goto L8
    }

    public static final Object b(MockMessageDaoSource r100, long r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof MockMessageDaoSource$deleteOtherMessages$1) == false) goto L7;
        MockMessageDaoSource$deleteOtherMessages$1 r101 = (MockMessageDaoSource$deleteOtherMessages$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r104 = r101.J$0;
        ResultKt.throwOnFailure(r112);
    L59:
        long r105 = r104 - ((Number) r112).longValue();
        com.larus.im.internal.delegate.a.f348188b.i("MockMessageDaoSource", "deleteOtherMessages, result:" + r105);
        return Boxing.boxLong(r105);
    L13:
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L55:
        long r113 = ((Number) r112).longValue();
        MessageDaoSource r114 = f();
        r101.L$0 = null;
        r101.J$0 = r113;
        r101.label = 6;
        r112 = r114.I(r106, r101);
        if (r112 == r103) goto L72;
        r104 = r113;
        goto L59
    L72:
        return r103;
    L14:
        int r115 = r101.I$0;
        Iterator r116 = (Iterator) r101.L$1;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L41:
        if (r116.hasNext() == false) goto L52;
        ConversationEntity r117 = (ConversationEntity) r116.next();
        MessageDaoSource r108 = f();
        String r109 = r117.getConversationId();
        r101.L$0 = r107;
        r101.L$1 = r116;
        r101.L$2 = r117;
        r101.I$0 = r115;
        r101.label = 3;
        Object r118 = r108.I(r109, r101);
        if (r118 == r103) goto L69;
        String r119 = r107;
        Iterator r120 = r116;
        ConversationEntity r121 = r117;
        r112 = r118;
        String r122 = r119;
    L47:
        if (((int) ((Number) r112).longValue()) < r115) goto L51;
        MessageDaoSource r123 = f();
        String r124 = r121.getConversationId();
        r101.L$0 = r122;
        r101.L$1 = r120;
        r101.L$2 = null;
        r101.I$0 = r115;
        r101.label = 4;
        if (r123.l(r124, r115, r101) == r103) goto L70;
    L51:
        r116 = r120;
        r107 = r122;
        goto L41
    L70:
        return r103;
    L61:
        r116 = r120;
        r107 = r122;
        goto L41
    L69:
        return r103;
    L52:
        r106 = r107;
        r100.getClass();
        MessageDaoSource r125 = f();
        r101.L$0 = r106;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 5;
        r112 = r125.p(r101);
        if (r112 != r103) goto L55;
        return r103;
    L15:
        r115 = r101.I$0;
        r121 = (ConversationEntity) r101.L$2;
        r120 = (Iterator) r101.L$1;
        r122 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        goto L47
    L16:
        r110 = r101.J$0;
        r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        List r126 = (List) r112;
        if (r126 == null) goto L33;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L29:
        if (r128.hasNext() == false) goto L34;
        Object r129 = r128.next();
        if ((!Intrinsics.areEqual(((ConversationEntity) r129).getConversationId(), r107)) == false) goto L29;
        r127.add(r129);
    L34:
        if (r127 == null) goto L36;
        int r130 = r127.size();
    L37:
        r115 = (int) (r110 / ((long) r130));
        if (r127 == null) goto L52;
        r116 = r127.iterator();
        goto L41
    L36:
        r130 = 0;
        goto L37
    L33:
        r127 = null;
        goto L34
    L17:
        r110 = r101.J$0;
        ResultKt.throwOnFailure(r112);
    L21:
        String r131 = (String) r112;
        be9.b.f18784b.getClass();
        ConversationDaoSource r132 = new ConversationDaoSource();
        r101.L$0 = r131;
        r101.J$0 = r110;
        r101.label = 2;
        Object r133 = r132.k(r101);
        if (r133 == r103) goto L68;
        r107 = r131;
        r112 = r133;
        goto L25
    L68:
        return r103;
    L18:
        ResultKt.throwOnFailure(r112);
        r101.J$0 = r110;
        r101.label = 1;
        r112 = r100.e(r101);
        if (r112 != r103) goto L21;
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new MockMessageDaoSource$deleteOtherMessages$1(r100, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00fa -> B:28:0x00fd). Please report as a decompilation issue!!! */
    public static final Object c(MockMessageDaoSource r610, long r611, Continuation r612) {
        r610.getClass();
        if ((r612 instanceof MockMessageDaoSource$insertMainMessage$1) == false) goto L7;
        MockMessageDaoSource$insertMainMessage$1 r100 = (MockMessageDaoSource$insertMainMessage$1) r612;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L32:
        long r105 = ((Number) r102).longValue();
        com.larus.im.internal.delegate.a.f348188b.i("MockMessageDaoSource", "insertMainMessage, result:" + r105);
        return Boxing.boxLong(r105);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r106 = r100.J$1;
        long r107 = r100.J$0;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L28:
        r106 = r106 + 1;
    L24:
        if (r106 >= r107) goto L29;
        StringBuilder r109 = new StringBuilder("mock_000000_mock");
        int r110 = wf9.b.f559489a;
        r109.append(i.a());
        MessageEntity r111 = new MessageEntity(r109.toString(), null, null, null, null, 0, 0, 0, false, 12, 0, null, null, null, 0, false, com.larus.im.internal.delegate.b.f348193b.getUserId(), null, "mock_000000_mock", null, null, null, r108, null, null, r106, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -38076930, UnixStat.PERM_MASK, null);
        MessageDaoSource r112 = f();
        r100.L$0 = r108;
        r100.J$0 = r107;
        r100.J$1 = r106;
        r100.label = 2;
        if (r112.a0(r111, r100) != r103) goto L28;
        return r103;
    L29:
        MessageDaoSource r113 = f();
        r100.L$0 = null;
        r100.label = 3;
        r102 = r113.I(r108, r100);
        if (r102 != r103) goto L32;
        return r103;
    L17:
        long r114 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L22:
        r108 = (String) r102;
        long r613 = r114;
        r106 = 0;
        r107 = r613;
        goto L24
    L18:
        ResultKt.throwOnFailure(r102);
        r100.J$0 = r611;
        r100.label = 1;
        r102 = r610.e(r100);
        if (r102 == r103) goto L34;
        r114 = r611;
        goto L22
    L34:
        return r103;
    L7:
        r100 = new MockMessageDaoSource$insertMainMessage$1(r610, r612);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e6 -> B:46:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0197 -> B:52:0x019d). Please report as a decompilation issue!!! */
    public static final Object d(MockMessageDaoSource r610, long r611, Continuation r612) {
        r610.getClass();
        if ((r612 instanceof MockMessageDaoSource$insertOtherMessages$1) == false) goto L7;
        MockMessageDaoSource$insertOtherMessages$1 r100 = (MockMessageDaoSource$insertOtherMessages$1) r612;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L20;
        if (r104 == 3) goto L19;
        if (r104 == 4) goto L18;
        if (r104 != 5) goto L17;
        long r105 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L62:
        long r106 = r105 - ((Number) r102).longValue();
        com.larus.im.internal.delegate.a.f348188b.i("MockMessageDaoSource", "insertOtherMessages, result:" + r106);
        return Boxing.boxLong(r106);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L58:
        long r108 = ((Number) r102).longValue();
        MessageDaoSource r109 = f();
        r100.L$0 = null;
        r100.J$0 = r108;
        r100.label = 5;
        r102 = r109.I(r107, r100);
        if (r102 == r103) goto L73;
        r105 = r108;
        goto L62
    L73:
        return r103;
    L19:
        long r110 = r100.J$1;
        long r111 = r100.J$0;
        ConversationEntity r112 = (ConversationEntity) r100.L$2;
        Iterator r113 = (Iterator) r100.L$1;
        String r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Iterator r115 = r113;
        long r116 = r111;
    L52:
        long r117 = 1 + r110;
        String r118 = r114;
        long r119 = r117;
    L47:
        if (r119 >= r116) goto L53;
        StringBuilder r120 = new StringBuilder("mock_000000_mock");
        int r121 = wf9.b.f559489a;
        r120.append(i.a());
        long r122 = r116;
        long r613 = r119;
        MessageEntity r123 = new MessageEntity(r120.toString(), null, null, null, null, 0, 0, 0, false, 12, 0, null, null, null, 0, false, com.larus.im.internal.delegate.b.f348193b.getUserId(), null, "mock_000000_mock", null, null, null, r112.getConversationId(), null, null, r613, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -38076930, UnixStat.PERM_MASK, null);
        MessageDaoSource r124 = f();
        r100.L$0 = r118;
        r100.L$1 = r115;
        r100.L$2 = r112;
        r100.J$0 = r122;
        r100.J$1 = r613;
        r100.label = 3;
        if (r124.a0(r123, r100) == r103) goto L71;
        r114 = r118;
        r116 = r122;
        r110 = r613;
        goto L52
    L71:
        return r103;
    L53:
        long r125 = r116;
        String r126 = r118;
    L44:
        if (r115.hasNext() == false) goto L54;
        r119 = 0;
        r116 = r125;
        r118 = r126;
        r112 = (ConversationEntity) r115.next();
    L54:
        r610.getClass();
        MessageDaoSource r127 = f();
        r100.L$0 = r126;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 4;
        r102 = r127.p(r100);
        if (r102 == r103) goto L72;
        r107 = r126;
        goto L58
    L72:
        return r103;
    L20:
        long r128 = r100.J$0;
        r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L28:
        List r129 = (List) r102;
        if (r129 == null) goto L36;
        ArrayList r130 = new ArrayList();
        Iterator r131 = r129.iterator();
    L32:
        if (r131.hasNext() == false) goto L37;
        Object r132 = r131.next();
        if ((!Intrinsics.areEqual(((ConversationEntity) r132).getConversationId(), r126)) == false) goto L32;
        r130.add(r132);
    L37:
        if (r130 == null) goto L39;
        int r133 = r130.size();
    L40:
        r125 = r128 / ((long) r133);
        if (r130 == null) goto L54;
        r115 = r130.iterator();
        goto L44
    L39:
        r133 = 0;
        goto L40
    L36:
        r130 = null;
        goto L37
    L21:
        r128 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L25:
        r126 = (String) r102;
        be9.b.f18784b.getClass();
        ConversationDaoSource r134 = new ConversationDaoSource();
        r100.L$0 = r126;
        r100.J$0 = r128;
        r100.label = 2;
        r102 = r134.k(r100);
        if (r102 != r103) goto L28;
        return r103;
    L22:
        ResultKt.throwOnFailure(r102);
        r128 = r611;
        r100.J$0 = r128;
        r100.label = 1;
        r102 = r610.e(r100);
        if (r102 != r103) goto L25;
        return r103;
    L7:
        r100 = new MockMessageDaoSource$insertOtherMessages$1(r610, r612);
        goto L8
    }
}

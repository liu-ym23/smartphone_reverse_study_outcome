package com.larus.im.internal.core.cmd.internal;

import com.larus.im.callback.IMError;
import com.larus.im.internal.delegate.b;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.service.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import juc.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import vt7.a;

/* JADX INFO: loaded from: classes4.dex */
public final class CmdProcessorCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CmdProcessorCenter f347522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<Integer, List<c>> f347523b = null;

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/im/internal/core/cmd/internal/CmdProcessorCenter$From;", "", "<init>", "(Ljava/lang/String;I)V", "HTTP", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum From extends Enum<From> {
        public static final From HTTP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ From[] f347524a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f347525b = null;

        public static EnumEntries<From> getEntries() {
            return f347525b;
        }

        static {
            From r100 = new From();
            HTTP = r100;
            From[] r101 = {r100};
            f347524a = r101;
            f347525b = EnumEntriesKt.enumEntries(r101);
        }

        public From() {
            super("HTTP", 0);
        }

        public static From[] values() {
            return (From[]) f347524a.clone();
        }

        public static From valueOf(String r100) {
            return (From) r27.a.a(From.class, r100);
        }
    }

    public CmdProcessorCenter() {
    }

    static {
        f347522a = new CmdProcessorCenter();
        f347523b = new a(64);
    }

    public static void d() {
        a<Integer, List<c>> r100 = f347523b;
        monitor-enter(r100);
        r100.clear();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        a<Integer, List<c>> r101 = f347523b;
        monitor-enter(r101);
        int r102 = r100.f350825a;     // Catch: Throwable -> L16
        List<c> r103 = r101.get(Integer.valueOf(r102));     // Catch: Throwable -> L16
        if (r103 == null) goto L8;
        List<c> r104 = CollectionsKt.toMutableList(r103);     // Catch: Throwable -> L16
        if (r104 == null) goto L8;
    L10:
        if (r104.contains(r100) == false) goto L13;
        monitor-exit(r101);
        return;
    L13:
        r104.add(r100);     // Catch: Throwable -> L16
        r101.put(Integer.valueOf(r102), r104);     // Catch: Throwable -> L16
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        return;
    L8:
        r104 = new ArrayList();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final Object c(DownlinkMessage r100, Continuation<? super Unit> r101) {
        b r102 = b.f348193b;
        if (r102.isLogin() == false) goto L5;
    L8:
        Object r103 = b(f347523b.get(Boxing.boxInt(r100.cmd)), r100, From.HTTP, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L5:
        if (r102.e() == true) goto L8;
        com.larus.im.internal.delegate.a.f348188b.e("CmdProcessor", "user not login ! ! ! !");
        return Unit.INSTANCE;
    }

    public final Object b(List<? extends c> r210, DownlinkMessage r211, From r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof CmdProcessorCenter$consumeCmd$1) == false) goto L7;
        CmdProcessorCenter$consumeCmd$1 r100 = (CmdProcessorCenter$consumeCmd$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Iterator r105 = (Iterator) r100.L$1;
        d0 r106 = (d0) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L50:
        if (r105.hasNext() == false) goto L55;
        c r107 = (c) r105.next();
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.label = 1;
        if (r107.b(r106, r100) != r103) goto L50;
        return r103;
    L55:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        List<? extends c> r108 = r210;
        boolean r109 = false;
        if (r108 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == true) goto L23;
        com.larus.im.internal.delegate.a.f348188b.i("CmdProcessorCenter", "cmd(" + r211.cmd + ") index(" + r211.cmdIndex + ") from(" + r212 + ") will be consumed.");
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        wt7.c r112 = wt7.a.f561230a;     // Catch: Throwable -> L27
        DownlinkBody r113 = r211.downlinkBody;     // Catch: Throwable -> L27
        d<DownlinkBody> r114 = DownlinkBody.Companion.serializer();     // Catch: Throwable -> L27
        r112.getClass();     // Catch: Throwable -> L27
        Object r115 = Result.m9449constructorimpl(wt7.c.b(r113, r114));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r115) == false) goto L32;
        r115 = null;
    L32:
        String r116 = (String) r115;
        if (r116 != null) goto L35;
    L36:
        r109 = true;
    L37:
        if (r109 == false) goto L42;
        IMError r117 = new IMError(-18, null, null, null, 14, null);
        Iterator<T> r118 = r210.iterator();
    L40:
        if (r118.hasNext() == false) goto L55;
        ((c) r118.next()).a(r117);
        goto L40
    L42:
        wt7.c r119 = wt7.a.f561230a;
        d<d0> r120 = d0.Companion.serializer();
        r119.getClass();
        d0 r121 = (d0) wt7.c.a(r116, r120);
        if (r121 != null) goto L48;
        com.larus.im.internal.delegate.a.f348188b.e("CmdProcessorCenter", "cmd(" + r211.cmd + ") index(" + r211.cmdIndex + ") from(" + r212 + ") jsonStr(" + r116 + ") parse failed.");
        IMError r122 = new IMError(-18, null, null, null, 14, null);
        Iterator<T> r123 = r210.iterator();
    L46:
        if (r123.hasNext() == false) goto L55;
        ((c) r123.next()).a(r122);
        goto L46
    L48:
        r105 = r210.iterator();
        r106 = r121;
        goto L50
    L35:
        if (StringsKt.isBlank(r116) == false) goto L37;
    L27:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L23:
        return Unit.INSTANCE;
    L17:
        if (r108.isEmpty() == true) goto L20;
        r110 = false;
    L7:
        r100 = new CmdProcessorCenter$consumeCmd$1(this, r213);
        goto L8
    }
}

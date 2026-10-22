package com.larus.im.internal.network.channel;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.im.internal.delegate.o0;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import com.larus.im.internal.tracking.FlowImTracingProxy;
import com.larus.im.internal.utils.l;
import com.larus.im.internal.utils.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd9.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ye9.a f349056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f349057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f349058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vt7.b<Function1<DownlinkMessage, Unit>> f349059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vt7.b<Function1<Boolean, Unit>> f349060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f349061f;

    public i(ye9.a r100) {
        o0 r101 = o0.f348249a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "depend");
        this.f349056a = r100;
        this.f349057b = r101;
        this.f349058c = "WsChannel";
        this.f349059d = new vt7.b();
        this.f349060e = new vt7.b();
        this.f349061f = new h(this);
    }

    public final void a(UplinkMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "uplink");
        com.larus.im.internal.delegate.a.f348188b.i(this.f349058c, "WsChannel send appendTraceKey");
        int r101 = s.f350552a;
        LinkedHashMap r102 = new LinkedHashMap();
        s.a(r102, r100);
        ye9.a r103 = this.f349056a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "struct");
        byte[] r104 = r103.f567422a.b(r100);
        if (r104 == null) goto L12;
        ye9.a r105 = this.f349056a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, WsConstants.KEY_PAYLOAD);
        Iterator<ye9.b> r106 = r105.f567423b.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r104 = r106.next().encode();
        goto L6
    L8:
        if (r104 == null) goto L13;
        com.larus.im.internal.delegate.a r107 = com.larus.im.internal.delegate.a.f348188b;
        String r108 = this.f349058c;
        StringBuilder r109 = new StringBuilder("onSend: ");
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r109.append(l.f(StringsKt.decodeToString(r104)));
        r107.i(r108, r109.toString());
        this.f349057b.a(r104, r102);
        FlowImTracingProxy.f350219a.d(r100, r104);
        return;
    L13:
        return;
    }
}

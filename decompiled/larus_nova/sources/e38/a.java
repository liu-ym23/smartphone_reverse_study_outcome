package e38;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.bytedance.lark.sdk.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.sdk.i;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements se6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Command, g.b> f470931a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<com.ss.android.lark.pb.improto.Command, g.b> f470932b = null;

    public a() {
    }

    static {
        a r100 = new a();
        ((CopyOnWriteArrayList) d.f254139f).add(r100);
        f470931a = new ConcurrentHashMap();
        f470932b = new ConcurrentHashMap();
    }

    @Override // se6.c
    public final void a(Packet r110, long r111, long r112) {
        if (r110 != null) goto L5;
        return;
    L5:
        Command r100 = r110.cmd;
        Log.i("PushDispatcher", "thread = " + ThreadMethodProxy.currentThread().getName() + " command = " + r100 + " uid=" + r110.user_id);
        ByteString r101 = r110.payload;
        if (r101 != null) goto L8;
        r101 = ByteString.EMPTY;
    L8:
        com.ss.android.lark.sdk.d r102 = i.f439882b;
        if (r102 == null) goto L11;
        boolean r103 = r102.e();
    L12:
        if (r103 == true) goto L14;
    L16:
        g.b r104 = null;
        if (Intrinsics.areEqual(r100, Command.PASS_THROUGH_PUSH) == true) goto L45;
        if (r100 == null) goto L34;
        r104 = (g.b) ((ConcurrentHashMap) f470931a).get(r100);
    L34:
        if (r104 != null) goto L36;
        Log.w("PushDispatcher", "unprocessed push：" + r100);
    L40:
        long r105 = System.currentTimeMillis();
        if ((r105 - r111) <= 10000) goto L47;
        String r113 = "push time out command = " + r100 + ", decode time = " + (r112 - r111) + ", handle push time = " + (r105 - r112);
        Log.e("PushDispatcher", r113, new RuntimeException(r113), true);
        return;
    L47:
        return;
    L36:
        if ((r104 instanceof g.a) == false) goto L38;
        ((g.a) r104).f(r101.toByteArray(), r110);
        goto L40
    L38:
        r104.a(r101.toByteArray());
        goto L40
    L45:
        com.ss.android.lark.pb.improto.Packet r106 = com.ss.android.lark.pb.improto.Packet.ADAPTER.decode(r101);     // Catch: IllegalStateException -> L25 IOException -> L32
        r101 = r106.mpayload;     // Catch: IllegalStateException -> L25 IOException -> L32
        com.ss.android.lark.pb.improto.Command r107 = com.ss.android.lark.pb.improto.Command.fromValue(r106.mcommand.intValue());     // Catch: IllegalStateException -> L25 IOException -> L32
        if (r107 == null) goto L23;
        r104 = (g.b) ((ConcurrentHashMap) f470932b).get(r107);     // Catch: IllegalStateException -> L25 IOException -> L32
    L44:
    L23:
        Log.e("PushDispatcher", "onPush  passThroughCommand is null, " + r100);     // Catch: IllegalStateException -> L25 IOException -> L32
    L32:
        e = move-exception;
        Log.e("PushDispatcher", e.getMessage());
    L25:
        e = move-exception;
        String r108 = e.getMessage();
        Log.e("PushDispatcher", e.getMessage());
        if (r108 != null) goto L29;
    L31:
        throw e;
    L29:
        if (StringsKt.contains$default(r108, "mcmd", false, 2, r104) == false) goto L31;
        Log.w("PushDispatcher", "catch exception for unsupported command");
        goto L34
    L14:
        if (d.t(r110) == true) goto L16;
        return;
    L11:
        r103 = false;
        goto L12
    }
}

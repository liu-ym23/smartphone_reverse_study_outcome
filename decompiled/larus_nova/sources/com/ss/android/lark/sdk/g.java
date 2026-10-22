package com.ss.android.lark.sdk;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements se6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Command, List<b>> f439871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<com.ss.android.lark.pb.improto.Command, b> f439872b;

    public interface a extends b {
        void f(byte[] r100, Packet r101);
    }

    public interface b {
        void a(byte[] r100);
    }

    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f439873a;

        public c(a r100) {
            this.f439873a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            if (this.f439873a != null) goto L6;
            Log.e("PushDispatcher", "SdkPacketPushListenerKeyWrapper mSdkPushListener is null");
            return;
        L6:
            Log.d("PushDispatcher", "SdkPacketPushListenerKeyWrapper just push");
            this.f439873a.a(r100);
        }

        @Override // com.ss.android.lark.sdk.g.a
        public final void f(byte[] r100, Packet r101) {
            if (this.f439873a != null) goto L6;
            Log.e("PushDispatcher", "SdkPacketPushListenerKeyWrapper mSdkPushListener is null");
            return;
        L6:
            Log.d("PushDispatcher", "SdkPacketPushListenerKeyWrapper just push");
            this.f439873a.f(r100, r101);
        }
    }

    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f439874a;

        public d(b r100) {
            this.f439874a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            if (this.f439874a != null) goto L6;
            Log.e("PushDispatcher", "SdkPushListenerKeyWrapper mSdkPushListener is null");
            return;
        L6:
            Log.d("PushDispatcher", "SdkPushListenerKeyWrapper just push");
            this.f439874a.a(r100);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f439875a = null;

        static {
            f439875a = new g();
        }
    }

    public g() {
        this.f439871a = new ConcurrentHashMap();
        this.f439872b = new ConcurrentHashMap();
    }

    public final void c(Command r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((ConcurrentHashMap) this.f439871a).remove(r100);
    }

    public final void b(Command r100, b r101) {
        if (r100 == null) goto L24;
        if (r101 != null) goto L6;
        return;
    L6:
        if (((ConcurrentHashMap) this.f439871a).containsKey(r100) == false) goto L18;
        Log.i("PushDispatcher", "command " + r100 + " has already exist.");
        List r102 = (List) ((ConcurrentHashMap) this.f439871a).get(r100);
        if (r102 != null) goto L10;
        Log.w("PushDispatcher", "command " + r100 + " value is null.");
        CopyOnWriteArrayList r103 = new CopyOnWriteArrayList();
        if ((r101 instanceof a) == false) goto L16;
        r103.add(new c((a) r101));
    L17:
        ((ConcurrentHashMap) this.f439871a).put(r100, r103);
        return;
    L16:
        r103.add(new d(r101));
        goto L17
    L10:
        if ((r101 instanceof a) == false) goto L12;
        r102.add(new c((a) r101));
        return;
    L12:
        r102.add(new d(r101));
        return;
    L18:
        Log.i("PushDispatcher", "command " + r100 + " added.");
        CopyOnWriteArrayList r104 = new CopyOnWriteArrayList();
        if ((r101 instanceof a) == false) goto L21;
        r104.add(new c((a) r101));
    L22:
        ((ConcurrentHashMap) this.f439871a).put(r100, r104);
        return;
    L21:
        r104.add(new d(r101));
        goto L22
    }

    @Override // se6.c
    public final void a(Packet r110, long r111, long r112) {
        Command r100 = r110.cmd;
        Log.i("PushDispatcher", "thread = " + ThreadMethodProxy.currentThread().getName() + " command = " + r100 + " uid=" + r110.user_id);
        ByteString r101 = r110.payload;
        if (r101 != null) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        com.ss.android.lark.sdk.d r102 = i.f439882b;
        if (r102 == null) goto L8;
        boolean r103 = r102.e();
    L9:
        if (r103 == true) goto L11;
    L13:
        List r104 = null;
        if (r100 == Command.PASS_THROUGH_PUSH) goto L54;
        if (r100 == null) goto L39;
        r104 = (List) ((ConcurrentHashMap) this.f439871a).get(r100);
    L39:
        if (r104 == null) goto L48;
        Iterator r105 = r104.iterator();
    L42:
        if (r105.hasNext() == false) goto L49;
        b r106 = (b) r105.next();
        if ((r106 instanceof a) == true) goto L45;
        if (r106 == null) goto L42;
        r106.a(r101.toByteArray());
        goto L42
    L45:
        ((a) r106).f(r101.toByteArray(), r110);
    L49:
        long r107 = System.currentTimeMillis();
        if ((r107 - r111) <= 10000) goto L67;
        String r113 = "push time out command = " + r100 + ", decode time = " + (r112 - r111) + ", handle push time = " + (r107 - r112);
        Log.e("PushDispatcher", r113, new RuntimeException(r113), true);
        return;
    L67:
        return;
    L48:
        Log.w("PushDispatcher", "unprocessed push：" + r100);
        goto L49
    L54:
        com.ss.android.lark.pb.improto.Packet r108 = com.ss.android.lark.pb.improto.Packet.ADAPTER.decode(r101);     // Catch: IllegalStateException -> L28 IOException -> L36
        r101 = r108.mpayload;     // Catch: IllegalStateException -> L28 IOException -> L36
        com.ss.android.lark.pb.improto.Command r109 = com.ss.android.lark.pb.improto.Command.fromValue(r108.mcommand.intValue());     // Catch: IllegalStateException -> L28 IOException -> L36
        if (r109 == null) goto L26;
        CopyOnWriteArrayList r114 = new CopyOnWriteArrayList();     // Catch: IllegalStateException -> L28 IOException -> L36
        r114.add((b) ((ConcurrentHashMap) this.f439872b).get(r109));     // Catch: IllegalStateException -> L22 IOException -> L24
        r104 = r114;
    L53:
    L24:
        IOException e100 = e;
        r104 = r114;
    L38:
        Log.e("PushDispatcher", e100.getMessage());
    L22:
        IllegalStateException e101 = e;
        r104 = r114;
    L30:
        String r115 = e101.getMessage();
        Log.e("PushDispatcher", e101.getMessage());
        if (r115 != null) goto L33;
        throw e101;
    L33:
        if (r115.contains("mcmd") == false) goto L66;
        Log.w("PushDispatcher", "catch exception for unsupported command");
        goto L39
    L66:
        throw e101;
    L26:
        Log.e("PushDispatcher", "onPush passThroughCommand is null, " + r100);     // Catch: IllegalStateException -> L28 IOException -> L36
    L36:
        e = move-exception;
        e100 = e;
    L28:
        e = move-exception;
        e101 = e;
        goto L30
    L11:
        if (com.bytedance.lark.sdk.d.t(r110) == true) goto L13;
        return;
    L8:
        r103 = false;
        goto L9
    }
}

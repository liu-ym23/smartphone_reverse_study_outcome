package com.bytedance.lark.sdk;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.bytedance.lark.pb.basic.v1.RequestPacket;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import com.ss.android.lark.sdk.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import okio.ByteString;
import se6.m;
import se6.r;
import se6.s;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Command f254167h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f254168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f254169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f254170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f254171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f254172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile CountDownLatch f254173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f254174g;

    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Packet f254175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f254176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f254177c;

        public b(Packet r100, long r101, long r102) {
            this.f254175a = r100;
            this.f254176b = r101;
            this.f254177c = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Command f254178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f254179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f254180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Command f254181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f254182e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final StreamDataSource f254183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h f254184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f254185h;

        public c(Command r100, byte[] r101, long r102, Command r103) {
            this.f254178a = r100;
            this.f254179b = r101;
            this.f254180c = r102;
            this.f254181d = r103;
        }

        public c(int r100, byte[] r101, long r102, String r103, StreamDataSource r104, h r105) {
            this.f254185h = r100;
            this.f254179b = r101;
            this.f254180c = r102;
            this.f254182e = r103;
            this.f254183f = r104;
            this.f254184g = r105;
        }

        public c(Command r100, byte[] r101, long r102, String r103, StreamDataSource r104, h r105) {
            this.f254178a = r100;
            this.f254179b = r101;
            this.f254180c = r102;
            this.f254182e = r103;
            this.f254183f = r104;
            this.f254184g = r105;
        }
    }

    public static class d implements se6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final se6.b f254186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f254187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f254188c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f254189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ byte[] f254190b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ d f254191c;

            @Override // java.lang.Runnable
            public final void run() {
                Runnable r100 = this.f254191c.f254188c;     // Catch: Throwable -> L9
                if (r100 == null) goto L5;
                r100.run();     // Catch: Throwable -> L9
            L5:
                se6.b r101 = this.f254191c.f254186a;     // Catch: Throwable -> L9
                if (r101 == null) goto L12;
                r101.b(this.f254189a, this.f254190b);     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public a(d r100, boolean r101, byte[] r102) {
                this.f254191c = r100;
                this.f254189a = r101;
                this.f254190b = r102;
            }
        }

        @Override // se6.b
        public final boolean a() {
            se6.b r100 = this.f254186a;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.a() == false) goto L7;
            return true;
        }

        @Override // se6.b
        public final void b(boolean r100, byte[] r101) {
            Runnable r102 = this.f254187b;
            if (r102 == null) goto L5;
            r102.run();
        L5:
            CoreThreadPool.getSerialTaskHandler().post(new a(this, r100, r101));
        }

        public d(SdkSender.b r100, r r101, s r102) {
            this.f254186a = r100;
            this.f254187b = r101;
            this.f254188c = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lark.sdk.e$e, reason: collision with other inner class name */
    public static class C3615e implements se6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final se6.b f254192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Command f254193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f254194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f254195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f254196e;

        @Override // se6.b
        public final boolean a() {
            return this.f254192a.a();
        }

        @Override // se6.b
        public final void b(boolean r100, byte[] r101) {
            this.f254192a.b(r100, r101);
        }

        public C3615e(se6.b r100, Command r101, int r102, String r103) {
            this.f254196e = false;
            this.f254192a = r100;
            this.f254193b = r101;
            this.f254194c = r102;
            this.f254195d = r103;
        }
    }

    static {
        f254167h = Command.WRAPPER_WITH_PACKET;
    }

    public final void h() {
        if (this.f254169b.isEmpty() == true) goto L23;
        com.ss.android.lark.sdk.d r100 = i.f439882b;
        ArrayList r101 = new ArrayList();
        this.f254168a.lock();     // Catch: Throwable -> L40
        Iterator<c> r102 = this.f254169b.iterator();     // Catch: Throwable -> L40
    L8:
        if (r102.hasNext() == false) goto L11;
        r101.add(r102.next());     // Catch: Throwable -> L40
        r102.remove();     // Catch: Throwable -> L40
        goto L8
    L11:
        this.f254168a.unlock();
        Iterator r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L21;
        c r104 = (c) r103.next();
        if (r100 != null) goto L16;
        com.bytedance.lark.sdk.d.f.f254166a.g(r104.f254178a.getValue(), r104.f254179b, r104.f254180c, r104.f254181d.getValue());
        goto L13
    L16:
        Command r105 = r104.f254178a;
        if (r105 != null) goto L18;
        b(r104.f254185h, r104.f254179b, r104.f254180c, r104.f254182e, r104.f254183f, r104.f254184g);
        Log.i("SdkRequestInterceptor", "sendCacheReq asyncInvokePassThroughCommandV2 command is = " + r104.f254178a);
        goto L13
    L18:
        c(r105, r104.f254179b, r104.f254180c, r104.f254182e, r104.f254183f, r104.f254184g);
        Log.i("SdkRequestInterceptor", "sendCacheReq asyncInvokeV2 command is = " + r104.f254178a);
        goto L13
    L21:
        r101.clear();
    L40:
        th = move-exception;
        this.f254168a.unlock();
        throw th;
    L23:
        if (this.f254171d.isEmpty() == true) goto L61;
        ArrayList r106 = new ArrayList();
        this.f254170c.lock();     // Catch: Throwable -> L37
        Iterator<b> r107 = this.f254171d.iterator();     // Catch: Throwable -> L37
    L28:
        if (r107.hasNext() == false) goto L31;
        r106.add(r107.next());     // Catch: Throwable -> L37
        r107.remove();     // Catch: Throwable -> L37
        goto L28
    L31:
        this.f254170c.unlock();
        Iterator r108 = r106.iterator();
    L33:
        if (r108.hasNext() == false) goto L35;
        b r109 = (b) r108.next();
        com.bytedance.lark.sdk.d r110 = com.bytedance.lark.sdk.d.f.f254166a;
        com.bytedance.lark.sdk.d.f254141h.execute(new m(r109.f254175a, r109.f254176b, r109.f254177c));
        goto L33
    L35:
        r106.clear();
        return;
    L37:
        th = move-exception;
        this.f254170c.unlock();
        throw th;
    }

    public e(com.bytedance.lark.sdk.d.b r100) {
        this.f254168a = new ReentrantLock();
        this.f254169b = new ConcurrentLinkedQueue();
        this.f254170c = new ReentrantLock();
        this.f254171d = new ConcurrentLinkedQueue();
        this.f254172e = new AtomicBoolean(true);
        this.f254173f = new CountDownLatch(1);
        this.f254174g = r100;
    }

    public static void f(int r100, String r101) {
        Log.i("SdkRequestInterceptor", "asyncInvokePassTrough Server command:[" + r100 + "]contextID:" + r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C3615e i(Command r100, SdkSender.b r101, String r102, int r103) {
        if (r100 != Command.MAKE_USER_ONLINE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        this.f254172e.set(false);
        r101 = new d(r101, new r(this), new s(this));
    L9:
        return new C3615e(r101, r100, r103, r102);
    L5:
        r104 = false;
        goto L6
    }

    public static void g(Command r100, String r101, boolean r102, String r103, Long r104) {
        StringBuilder r105 = new StringBuilder();
        if (r102 == false) goto L5;
        String r106 = "asyncInvoke";
    L6:
        r105.append(r106);
        r105.append(" SDK command:[");
        r105.append(r100.getValue());
        r105.append(":");
        r105.append(r100.name());
        r105.append("],contextID:");
        r105.append(r101);
        r105.append(",uid:");
        r105.append(r103);
        r105.append(",containerID:");
        r105.append(r104);
        Log.i("SdkRequestInterceptor", r105.toString());
        return;
    L5:
        r106 = AbsMethodDelegate.TAG_INVOKE;
        goto L6
    }

    public final SdkInterceptState a(Command r110, byte[] r111, long r112, String r113, StreamDataSource r210, h r211) {
        if (i.f439882b != null) goto L5;
        boolean r114 = false;
        if (r210 == null) goto L9;
        boolean r100 = true;
    L10:
        RequestPacket r101 = e(r110, r111, r113, r112, r100, r210, 0, r211);
        Command r102 = f254167h;
        byte[] r103 = r101.encode();
        g(r110, r113, true, r101.user_id, r101.user_container_id);
        if (this.f254172e.get() == false) goto L14;
        com.bytedance.lark.sdk.d.f.f254166a.g(r102.getValue(), r103, r112, r110.getValue());
        h();
    L20:
        if (r114 == false) goto L23;
        return SdkInterceptState.MakeOnline;
    L23:
        return SdkInterceptState.None;
    L14:
        if (r110 != Command.MAKE_USER_ONLINE) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        com.bytedance.lark.sdk.d.f.f254166a.g(r102.getValue(), r103, r112, r110.getValue());
        goto L20
    L19:
        this.f254169b.add(new c(r102, r103, r112, r110));
        Log.i("SdkRequestInterceptor", "asyncInvoke add cache command = " + r110.name());
        r114 = true;
        goto L20
    L16:
        r104 = false;
        goto L17
    L9:
        r100 = false;
        goto L10
    L5:
        return c(r110, r111, r112, r113, r210, r211);
    }

    public final void b(int r110, byte[] r111, long r112, String r113, StreamDataSource r114, h r115) {
        if (this.f254172e.get() == false) goto L8;
        if (r114 == null) goto L6;
        boolean r100 = true;
    L7:
        RequestPacket r101 = d(r110, r111, r113, r112, r100, r114, r115);
        Command r102 = f254167h;
        byte[] r103 = r101.encode();
        f(r110, r113);
        com.bytedance.lark.sdk.d.f.f254166a.g(r102.getValue(), r103, r112, Command.POST_GATEWAY.getValue());
        h();
        return;
    L6:
        r100 = false;
        goto L7
    L8:
        this.f254169b.add(new c(r110, r111, r112, r113, r114, r115));
        Log.i("SdkRequestInterceptor", "asyncInvokePassThroughCommand add cache command = " + r110);
    }

    public final SdkInterceptState c(Command r110, byte[] r111, long r112, String r113, StreamDataSource r210, h r211) {
        Command r100 = f254167h;
        boolean r101 = true;
        if (this.f254172e.get() == true) goto L5;
        this.f254169b.add(new c(r110, r111, r112, r113, r210, r211));
        Log.i("SdkRequestInterceptor", "asyncInvokeV2 add cache command = " + r110.name());
    L10:
        if (r101 == false) goto L13;
        return SdkInterceptState.MakeOnline;
    L13:
        return SdkInterceptState.None;
    L5:
        if (r210 == null) goto L7;
        boolean r102 = true;
    L8:
        RequestPacket r103 = e(r110, r111, r113, r112, r102, r210, 0, r211);
        byte[] r104 = r103.encode();
        g(r110, r113, true, r103.user_id, r103.user_container_id);
        com.bytedance.lark.sdk.d.f.f254166a.g(r100.getValue(), r104, r112, r110.getValue());
        h();
        r101 = false;
        goto L10
    L7:
        r102 = false;
        goto L8
    }

    public static RequestPacket d(int r100, byte[] r101, String r102, long r103, boolean r110, StreamDataSource r111, h r112) {
        com.ss.android.lark.sdk.d r104 = i.f439882b;
        if (r104 == null) goto L5;
        String r105 = r104.getUserId();
    L6:
        RequestPacket.Builder r106 = new RequestPacket.Builder().cmd(Command.POST_GATEWAY).context_id(r102).payload(ByteString.of(r101)).pass_through(new RequestPacket.PassThrough.Builder().ser_command(String.valueOf(r100)).build()).thread_id(0L);
        if (r103 == (-1)) goto L10;
        r106.task_id(Long.valueOf(r103));
    L10:
        if (TextUtils.isEmpty(r105) == false) goto L12;
        Log.e("SdkRequestInterceptor", "getPassTroughRequestPacket userId is empty command = " + r100 + ", userId = " + r105 + ". sdkDependency = " + r104);
    L16:
        if (r110 == false) goto L19;
        if (r111 == null) goto L19;
        r106.is_callback_by_stream(Boolean.TRUE);
        r106.biz_config(new RequestPacket.BizConfig.Builder().data_source(RequestPacket.BizConfig.DataSource.fromValue(r111.getNumber())).build());
    L20:
        if (r112 == null) goto L25;
        r106.span_id(Long.valueOf(r112.f439876a));
        r106.collect_trace(Boolean.valueOf(r112.f439877b));
        r106.mail_account_id(null);
        r106.enable_start_up_control(Boolean.valueOf(r112.f439878c));
        r106.traffic_type(r112.f439879d);
        Map<String, String> r107 = r112.a(null);
        if (r107 == null) goto L25;
        r106.biz_request_meta(r107);
    L25:
        return r106.build();
    L19:
        r106.is_callback_by_stream(Boolean.FALSE);
        goto L20
    L12:
        r106.user_id(r105);
        Long r108 = r104.a(r105);
        Log.d("SdkRequestInterceptor", "getRequestPacket containerId is " + r108 + ", command = " + r100 + ", userId = " + r105 + ". sdkDependency = " + r104);
        if (r108 == null) goto L15;
        r106.user_container_id(r108);
        goto L16
    L15:
        Log.e("SdkRequestInterceptor", "getPassTroughRequestPacket containerId is empty command = " + r100 + ", userId = " + r105 + ". sdkDependency = " + r104);
        goto L16
    L5:
        r105 = null;
        goto L6
    }

    public static RequestPacket e(Command r100, byte[] r101, String r102, long r103, boolean r104, StreamDataSource r110, long r111, h r112) {
        com.ss.android.lark.sdk.d r105 = i.f439882b;
        if (r105 != null) goto L5;
    L7:
        String r106 = null;
    L8:
        RequestPacket.Builder r107 = new RequestPacket.Builder().cmd(r100).context_id(r102).payload(ByteString.of(r101)).thread_id(Long.valueOf(r111));
        if (r103 == (-1)) goto L12;
        r107.task_id(Long.valueOf(r103));
    L12:
        if (TextUtils.isEmpty(r106) == false) goto L14;
        Log.e("SdkRequestInterceptor", "getRequestPacket userId is empty command = " + r100.name() + ", userId = " + r106 + ". sdkDependency = " + r105);
    L18:
        if (r104 == false) goto L21;
        if (r110 == null) goto L21;
        r107.is_callback_by_stream(Boolean.TRUE);
        r107.biz_config(new RequestPacket.BizConfig.Builder().data_source(RequestPacket.BizConfig.DataSource.fromValue(r110.getNumber())).build());
    L22:
        if (r112 == null) goto L27;
        r107.span_id(Long.valueOf(r112.f439876a));
        r107.collect_trace(Boolean.valueOf(r112.f439877b));
        r107.mail_account_id(null);
        r107.enable_start_up_control(Boolean.valueOf(r112.f439878c));
        r107.traffic_type(r112.f439879d);
        Map<String, String> r108 = r112.a(null);
        if (r108 == null) goto L27;
        r107.biz_request_meta(r108);
    L27:
        return r107.build();
    L21:
        r107.is_callback_by_stream(Boolean.FALSE);
        goto L22
    L14:
        r107.user_id(r106);
        Long r109 = r105.a(r106);
        Log.d("SdkRequestInterceptor", "getRequestPacket containerId is " + r109 + ", command = " + r100.name() + ", userId = " + r106 + ". sdkDependency = " + r105);
        if (r109 == null) goto L17;
        r107.user_container_id(r109);
        goto L18
    L17:
        Log.e("SdkRequestInterceptor", "getRequestPacket containerId is empty command = " + r100.name() + ", userId = " + r106 + ". sdkDependency = " + r105);
        goto L18
    L5:
        if (TextUtils.isEmpty(null) == false) goto L7;
        r106 = r105.getUserId();
        goto L8
    }
}

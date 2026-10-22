package com.bytedance.bdp.appbase.network.upload;

import android.content.Context;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.BdpNetRequest;
import com.bytedance.bdp.appbase.network.BdpNetResponse;
import com.bytedance.bdp.appbase.network.BdpNetworkEventHelper;
import com.bytedance.bdp.appbase.network.BdpNetworkManager;
import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.bytedance.bdp.appbase.network.IBdpNetCall;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f200914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f200915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBdpNetCall f200916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f200917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f200918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f200919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BdpUploadRequest f200920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BdpUploadCallback f200921h;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.network.upload.a$a, reason: collision with other inner class name */
    public static final class C2899a {
    }

    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f200922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f200923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f200924c;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f200923b.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() throws IOException {
            this.f200923b.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
            this.f200923b.write(r100);
            a r101 = this.f200924c;
            BdpUploadCallback r102 = r101.f200921h;
            if (r102 == null) goto L15;
            long r103 = this.f200922a + 1;
            this.f200922a = r103;
            if (r103 != r101.f200914a) goto L8;
            BdpPool.execute(BdpTask.TaskType.IO, new c(r101, r102, r103));
            return;
        L8:
            if (r101.f200915b.get() == 2) goto L11;
            return;
        L11:
            if ((System.currentTimeMillis() - r101.f200917d) < 100) goto L18;
            r101.f200917d = System.currentTimeMillis();
            BdpPool.execute(BdpTask.TaskType.IO, new d(r101, r102, r103));
            return;
        L18:
            return;
        }

        public b(a r100, OutputStream r101) {
            this.f200924c = r100;
            this.f200923b = r101;
        }
    }

    static {
    }

    public final BdpNetResponse a() {
        BdpUploadCallback r100 = this.f200921h;
        if (r100 == null) goto L6;
        r100.onStart(this.f200918e);
    L6:
        if (this.f200915b.compareAndSet(1, 2) == true) goto L10;
        return b(-201, "task is finished");
    L10:
        if (this.f200920g.getMaxLength() > 0) goto L12;
    L15:
        BdpNetworkManager r101 = BdpNetworkManager.Companion.with(this.f200919f);
        BdpUploadRequest r102 = this.f200920g;
        com.bytedance.bdp.appbase.network.upload.b r110 = new com.bytedance.bdp.appbase.network.upload.b(this, r102);
        BdpAppContext r103 = r102.getAppContext();
        String r104 = r102.getUrl();
        BdpFromSource r105 = r102.getFrom();
        if (r103 == null) goto L18;
        String r111 = r103.f200762b;
    L19:
        if (r103 == null) goto L21;
        com.bytedance.bdp.appbase.core.a r210 = r103.b();
    L23:
        if (r210 == null) goto L25;
        r210.getAppId();
    L25:
        new ArrayList();
        BdpRequestType r106 = BdpRequestType.OK;
        Boolean r310 = Boolean.FALSE;
        HashMap r107 = new HashMap();
        BdpRequestType r112 = r102.getRequestLibType();
        boolean r113 = r102.getAddBdpCommonParams();
        boolean r114 = r102.getAddHostCommonParams();
        boolean r108 = r102.getAddHostSecurityParams();
        long r211 = r102.getTimeout();
        long r212 = r102.getTimeout();
        long r213 = r102.getTimeout();
        ArrayList r115 = new ArrayList(r102.getHeaders().f480684a);
        IBdpNetCall r109 = r101.newCall(new BdpNetRequest(r104, r102.getMethod(), r105, false, r108, r114, false, r113, false, new gb4.c(r115), r111, r210, null, false, r112, r110, r211, r212, r213, true, null, r102.getEnableHttp2(), null, r310, r107));
        this.f200916c = r109;
        BdpNetResponse r116 = r109.execute();
        if (this.f200915b.compareAndSet(2, 3) == false) goto L31;
        BdpUploadCallback r117 = this.f200921h;
        if (r117 == null) goto L35;
        r117.onFinish(this.f200918e, this.f200920g, r116);
    L35:
        BdpNetworkEventHelper.INSTANCE.mpUploadMonitor(this.f200920g, r116, this.f200915b.get());
        return r116;
    L31:
        if (this.f200915b.get() != 4) goto L35;
        BdpUploadCallback r118 = this.f200921h;
        if (r118 == null) goto L35;
        r118.onCancel(this.f200918e, this.f200920g);
        goto L35
    L21:
        r210 = null;
        goto L23
    L18:
        r111 = null;
        goto L19
    L12:
        if (this.f200920g.getBody().b() <= this.f200920g.getMaxLength()) goto L15;
        return b(-202, "request body exceed max size " + this.f200920g.getMaxLength());
    }

    public final BdpNetResponse b(int r110, String r111) {
        BdpNetResponse r112 = new BdpNetResponse(r110, r111, this.f200920g.getUrl(), gb4.c.f480683b, null, new Exception(r111), this.f200920g.getRequestLibType(), new gb4.d(), MapsKt.emptyMap());
        if (this.f200915b.compareAndSet(2, 3) == false) goto L8;
        BdpUploadCallback r113 = this.f200921h;
        if (r113 == null) goto L12;
        r113.onFinish(this.f200918e, this.f200920g, r112);
    L12:
        BdpNetworkEventHelper.INSTANCE.mpUploadMonitor(this.f200920g, r112, this.f200915b.get());
        return r112;
    L8:
        if (this.f200915b.get() != 4) goto L12;
        BdpUploadCallback r114 = this.f200921h;
        if (r114 == null) goto L12;
        r114.onCancel(this.f200918e, this.f200920g);
        goto L12
    }

    public a(int r100, Context r101, BdpUploadRequest r102, BdpUploadCallback r103) {
        this.f200918e = r100;
        this.f200919f = r101;
        this.f200920g = r102;
        this.f200921h = r103;
        this.f200914a = r102.getBody().b();
        this.f200915b = new AtomicInteger(1);
    }
}

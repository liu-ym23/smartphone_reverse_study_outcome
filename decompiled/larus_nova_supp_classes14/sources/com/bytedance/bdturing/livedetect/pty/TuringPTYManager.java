package com.bytedance.bdturing.livedetect.pty;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYCvMat;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.api.mutilinstance.HostSetupWatcher;
import com.bytedance.pitaya.api.mutilinstance.PreHostSetupWatcher;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.n;
import vb4.e;
import vb4.f;
import vb4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TuringPTYManager {
    public static volatile TuringPTYManager h;
    public int a;
    public IPitayaCore b;
    public PTYTaskResultCallback c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;

    /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.pty.TuringPTYManager$9, reason: invalid class name */
    public final class AnonymousClass9 extends PthreadThreadV2 {
        public final /* synthetic */ long v;
        public final /* synthetic */ TuringPTYManager w;

        public final void l() {
            Bitmap r0 = Bitmap.createBitmap(480, 640, Bitmap.Config.ARGB_4444);     // Catch: Exception -> L4
            r0.eraseColor(-16777216);     // Catch: Exception -> L4
            ArrayList<Float> r1 = new ArrayList();     // Catch: Exception -> L4
            r1.add(Float.valueOf(0.2f));     // Catch: Exception -> L4
            r1.add(Float.valueOf(0.3f));     // Catch: Exception -> L4
            r1.add(Float.valueOf(0.8f));     // Catch: Exception -> L4
            r1.add(Float.valueOf(0.8f));     // Catch: Exception -> L4
            this.w.c(r0, r1, new AnonymousClass1(this));     // Catch: Exception -> L4
            System.currentTimeMillis();     // Catch: Exception -> L4
            int r2 = n.a;     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            this.w.f.set(false);
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass9(TuringPTYManager r1, long r2) {
            this.w = r1;
            this.v = r2;
            super("TuringPTYManager$9");
        }
    }

    public interface a {
    }

    public static TuringPTYManager b() {
        if (h != null) goto L15;
        monitor-enter(TuringPTYManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new TuringPTYManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TuringPTYManager.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public final boolean e() {
        IPitayaCore r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isReady() == false) goto L7;
        return true;
    }

    public TuringPTYManager() {
        this.a = 0;
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
    }

    public final boolean f() {
        if (e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g.get() == false) goto L7;
        return true;
    }

    public final void g(final String r4, final f r5) {
        if (this.b == null) goto L11;
        BdTuringConfig r0 = qb4.b.c.a.a;
        if (r0 != null) goto L7;
    L9:
        final String r1 = "live_detect";
    L10:
        this.b.queryPackage(r1, new AnonymousClass3(this, r5, r4, r1));
        return;
    L7:
        if (r0.getRegionType() != BdTuringConfig.RegionType.REGION_BOE) goto L9;
        r1 = "live_detect_test";
        goto L10
    L11:
        if (r5 == null) goto L15;
        r5.e.c((m) r5.a, r5.b, r5.c, r5.d);
        return;
    }

    public final void a(Context r7, final d r8, final String r9) {
    L13:
        e = move-exception;
        e.printStackTrace();
        if (r8 == null) goto L20;
        ((h) r8).a(false);
        return;
    L20:
        return;
    L4:
        if (e() == false) goto L6;
        return;
    L6:
        final BdTuringConfig r2 = qb4.b.c.a.a;     // Catch: Exception -> L13
        if (r2 != null) goto L11;
        if (r8 == null) goto L19;
        ((h) r8).a(false);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L11:
        PTYSetupInfo.a r3 = new PTYSetupInfo.a();     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter("3216", "aid");     // Catch: Exception -> L13
        r3.a = "3216";     // Catch: Exception -> L13
        String r4 = r2.getChannel();     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r4, "channel");     // Catch: Exception -> L13
        r3.c = r4;     // Catch: Exception -> L13
        r3.e = new AnonymousClass6(this);     // Catch: Exception -> L13
        String r5 = r2.getAppVersion();     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r5, "appVersion");     // Catch: Exception -> L13
        r3.b = r5;     // Catch: Exception -> L13
        r3.d = new AnonymousClass5(this, r2);     // Catch: Exception -> L13
        r3.i = true;     // Catch: Exception -> L13
        r3.h = 2;     // Catch: Exception -> L13
        IPitayaCore r0 = PitayaCoreFactory.getCore("3216");     // Catch: Exception -> L13
        this.b = r0;     // Catch: Exception -> L13
        r0.setup(r7, new PTYSetupInfo(r3, null), new AnonymousClass7(this, r9, r8));     // Catch: Exception -> L13
        this.a = 3;     // Catch: Exception -> L13
    }

    public final void c(Bitmap r5, ArrayList<Float> r6, PTYTaskResultCallback r7) {
        if (this.e.get() == false) goto L6;
        r7.onResult(false, null, null, null);
        return;
    L6:
        this.c = r7;
        if (f() == true) goto L12;
        PTYTaskResultCallback r8 = this.c;
        if (r8 == null) goto L44;
        r8.onResult(false, null, null, null);
        return;
    L44:
        return;
    L12:
        PTYCvMat r9 = new PTYCvMat();
        r9.setBitmap(r5);
        JSONObject r10 = new JSONObject();
        r10.put("image", r9);     // Catch: Exception -> L23
        JSONArray r11 = new JSONArray();     // Catch: Exception -> L23
        if (r6 != null) goto L16;
    L21:
        r10.put("roi", r11);     // Catch: Exception -> L23
        r10.put("cfg", new HashMap());     // Catch: Exception -> L23
    L25:
        PTYTaskData r12 = new PTYTaskData(r10);
        BdTuringConfig r13 = qb4.b.c.a.a;
        if (r13 != null) goto L28;
    L30:
        String r14 = "live_detect";
    L31:
        r10.toString();
        int r15 = n.a;
        this.e.set(true);
        this.b.runTask(r14, r12, new PTYTaskConfig(), new AnonymousClass8(this));     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        th.printStackTrace();
        this.e.set(false);
        PTYTaskResultCallback r16 = this.c;
        if (r16 == null) goto L45;
        r16.onResult(false, null, null, null);
        return;
    L45:
        return;
    L28:
        if (r13.getRegionType() != BdTuringConfig.RegionType.REGION_BOE) goto L30;
        r14 = "live_detect_test";
        goto L31
    L16:
        if (r6.size() <= 0) goto L21;
        int r0 = 0;
    L19:
        if (r0 >= r6.size()) goto L21;
        r11.put(ListProtector.get(r6, r0));     // Catch: Exception -> L23
        r0 = r0 + 1;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public final void d(final Context r6, final h r7, final String r8) {
    L22:
        th = move-exception;
        th.printStackTrace();
        if (r7 == null) goto L32;
        r7.a(false);
        return;
    L32:
        return;
    L4:
        if (f() == false) goto L10;
        this.a = 6;     // Catch: Throwable -> L22
        if (r7 == null) goto L28;
        r7.a(true);     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L10:
        if (e() == true) goto L18;
        HostSetupWatcher r1 = HostSetupWatcher.INSTANCE;     // Catch: Throwable -> L22
        if (r1.isHostSetup() == true) goto L17;
        PreHostSetupWatcher r3 = PreHostSetupWatcher.INSTANCE;     // Catch: Throwable -> L22
        if (r3.isPreHostSetup() == true) goto L17;
        r1.registerHostSetupListener(new AnonymousClass1(this, r6, r7, r8));     // Catch: Throwable -> L22
        r3.registerListener(new AnonymousClass2(this, r6, r7, r8));     // Catch: Throwable -> L22
        this.a = 1;     // Catch: Throwable -> L22
        return;
    L17:
        a(r6, r7, r8);     // Catch: Throwable -> L22
        e.b = true;     // Catch: Throwable -> L22
        return;
    L18:
        this.a = 2;     // Catch: Throwable -> L22
        g(r8, null);     // Catch: Throwable -> L22
        if (r7 == null) goto L31;
        r7.a(false);     // Catch: Throwable -> L22
        return;
    }
}

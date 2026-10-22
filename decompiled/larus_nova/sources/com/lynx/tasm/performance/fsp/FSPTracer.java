package com.lynx.tasm.performance.fsp;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import y7a.g;
import z7a.a;
import z7a.b;
import z7a.c;
import z7a.d;
import z7a.e;
import z7a.h;

/* JADX INFO: loaded from: classes32.dex */
public final class FSPTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f383539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f383540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f383541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f383542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<PerformanceController> f383543e;

    public static final enum ResultStatus extends Enum<ResultStatus> {
        public static final ResultStatus CANCEL_BY_TIMEOUT = null;
        public static final ResultStatus CANCEL_BY_USER_INTERACTION = null;
        public static final ResultStatus ERROR = null;
        public static final ResultStatus STOP = null;
        public static final ResultStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultStatus[] f383544a = null;
        private final String value;

        static {
            ResultStatus r100 = new ResultStatus("SUCCESS", 0, "success");
            SUCCESS = r100;
            ResultStatus r101 = new ResultStatus("CANCEL_BY_USER_INTERACTION", 1, "cancelByUserInteraction");
            CANCEL_BY_USER_INTERACTION = r101;
            ResultStatus r102 = new ResultStatus("CANCEL_BY_TIMEOUT", 2, "timeout");
            CANCEL_BY_TIMEOUT = r102;
            ResultStatus r103 = new ResultStatus("STOP", 3, "stop");
            STOP = r103;
            ResultStatus r104 = new ResultStatus("ERROR", 4, "error");
            ERROR = r104;
            f383544a = new ResultStatus[]{r100, r101, r102, r103, r104};
        }

        public static ResultStatus[] values() {
            return (ResultStatus[]) f383544a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static ResultStatus fromValue(String r100) {
            ResultStatus[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ResultStatus r104 = r101[r103];
            if (r104.value.equals(r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static ResultStatus valueOf(String r100) {
            return (ResultStatus) r27.a.a(ResultStatus.class, r100);
        }

        public ResultStatus(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final boolean b() {
        PerformanceController r100 = this.f383543e.get();
        if (r100 != null) goto L6;
        return LynxEnv.inst().enableFSP();
    L6:
        return r100.l();
    }

    public FSPTracer(PerformanceController r100) {
        this.f383540b = new AtomicBoolean(false);
        this.f383542d = -1;
        this.f383543e = new WeakReference(null);
        this.f383543e = new WeakReference(r100);
        this.f383542d = r100.f383536h;
    }

    public final void c(final h r100) {
        if (this.f383539a.f570704i <= 0) goto L6;
        final WeakReference r101 = new WeakReference(this);
        UIThreadUtils.runOnUiThread(new c(r101, r100), this.f383539a.f570704i);
        return;
    }

    public final void a(ResultStatus r100, final b r101, final long r102) {
        final PerformanceController r103 = this.f383543e.get();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r101 != null) goto L15;
        final HashMap r104 = new HashMap(1);
        r104.put("fspStatus", r100.getValue());
        if (r103.f383533e == true) goto L12;
        r103.q(new g(r103, r102, r104));
    L12:
        if (TraceEvent.isTracingStarted() == false) goto L23;
        r104.put("instance_id", String.valueOf(r103.f383536h));
        UIThreadUtils.runOnUiThread(new d(r104));
        return;
    L23:
        return;
    L15:
        final HashMap r105 = new HashMap(1);
        r105.put("fspStatus", r100.getValue());
        r105.put("contentFillPercentageX", String.valueOf(r101.f570715j));
        r105.put("contentFillPercentageY", String.valueOf(r101.f570716k));
        r105.put("contentFillPercentageTotalArea", String.valueOf(r101.f570717l));
        r105.put("containerFillPercentageContainerArea", String.valueOf(r101.f570718m));
        final long r106 = r101.f570714i;
        if (r103.f383533e == true) goto L20;
        r103.q(new g(r103, r106, r105));
    L20:
        if (TraceEvent.isTracingStarted() == false) goto L24;
        r105.put("instance_id", String.valueOf(r103.f383536h));
        UIThreadUtils.runOnUiThread(new e(r101, r105));
        return;
    }
}

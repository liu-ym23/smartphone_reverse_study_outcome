package t3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.ai.bridge.method.device.DeviceSensorInterval;
import com.google.gson.JsonObject;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c implements e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f544252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<e3.d> f544253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f544254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SensorManager f544255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f544256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f544257h;

    public static final class a implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f544258a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
        }

        public a(c r100) {
            this.f544258a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            c r101 = this.f544258a;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            e3.d r103 = r101.f544253d.get();     // Catch: Throwable -> L11
            if (r103 == null) goto L8;
            r103.a(r101.f544251b, r101.c(r100));     // Catch: Throwable -> L11
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
            return;
        L8:
            r104 = null;
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    public abstract JsonObject c(SensorEvent r100);

    @Override // e3.b
    public final void a() {
        Object r100 = this.f544254e;
        monitor-enter(r100);
        this.f544257h = true;     // Catch: Throwable -> L20
        a r101 = this.f544256g;     // Catch: Throwable -> L20
        if (r101 != null) goto L25;
    L17:
        this.f544256g = null;     // Catch: Throwable -> L20
        this.f544255f = null;     // Catch: Throwable -> L20
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r100);
        return;
    L25:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        SensorManager r104 = this.f544255f;     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
        b(r104, r101);     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
    L16:
        Result.m9448boximpl(r106);     // Catch: Throwable -> L20
        goto L17
    L11:
        r105 = null;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r100 = this.f544254e;
        monitor-enter(r100);
        boolean r101 = this.f544257h;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        Object r100 = this.f544254e;
        monitor-enter(r100);
        a r101 = this.f544256g;     // Catch: Throwable -> L19
        if (r101 != null) goto L24;
    L16:
        this.f544256g = null;     // Catch: Throwable -> L19
        this.f544255f = null;     // Catch: Throwable -> L19
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r100);
        return;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        SensorManager r104 = this.f544255f;     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        b(r104, r101);     // Catch: Throwable -> L13
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L15:
        Result.m9448boximpl(r106);     // Catch: Throwable -> L19
        goto L16
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void b(SensorManager r100, SensorEventListener r101) {
        if (fna.g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        ona.b.c(new ona.a(r101.hashCode(), null));
    }

    public final r0 e(DeviceSensorInterval r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, VideoThumbInfo.KEY_INTERVAL);
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        if (d() == true) goto L5;
        e3.d r102 = this.f544253d.get();
        if (r102 == null) goto L9;
        Context r103 = e3.e.b(r102);
        if (r103 == null) goto L13;
        Context r104 = r103.getApplicationContext();
        if (r104 == null) goto L18;
        r103 = r104;
    L18:
        Object r105 = r103.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
        r0 r106 = null;
        if ((r105 instanceof SensorManager) == false) goto L21;
        SensorManager r107 = (SensorManager) r105;
    L22:
        if (r107 == null) goto L24;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L31
        r4.k r109 = r4.a.f535984k;     // Catch: Throwable -> L31
        if (r109 == null) goto L28;
        Sensor r110 = r109.e(r107, r102, r101, this.f544250a);     // Catch: Throwable -> L31
    L29:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L31
    L33:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 != null) goto L73;
        Sensor r113 = (Sensor) r111;
        if (r113 == null) goto L38;
        a r114 = new a(this);
        Object r115 = this.f544254e;
        monitor-enter(r115);
    L69:
        th = move-exception;
        throw th;
    L42:
        if (this.f544257h == false) goto L80;
        r0 r116 = new r0("context is null", f3.a.f475265f);     // Catch: Throwable -> L69
    L67:
        monitor-exit(r115);
        return r116;
    L80:
    L60:
        e = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L63
        b(r107, r114);     // Catch: Throwable -> L63
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L66:
        r116 = new r0("start sensor failed: " + e.getMessage(), f3.a.f475265f);     // Catch: Throwable -> L69
    L63:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L69
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
        goto L66
    L46:
        if (r107.registerListener(r114, r113, r100.getSensorDelay()) == true) goto L48;
        r106 = new r0("failed to register sensor listener", f3.a.f475265f);     // Catch: Exception -> L60 Throwable -> L69
    L59:
        r116 = r106;
        goto L67
    L48:
        SensorManager r119 = this.f544255f;     // Catch: Exception -> L60 Throwable -> L69
        a r120 = this.f544256g;     // Catch: Exception -> L60 Throwable -> L69
        this.f544255f = r107;     // Catch: Exception -> L60 Throwable -> L69
        this.f544256g = r114;     // Catch: Exception -> L60 Throwable -> L69
        if (r120 == null) goto L59;
        if (r119 != null) goto L74;
        Unit r121 = null;
    L55:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L52
    L58:
        Result.m9448boximpl(r122);     // Catch: Exception -> L60 Throwable -> L69
    L52:
        th = move-exception;
        Result.Companion r123 = Result.Companion;     // Catch: Exception -> L60 Throwable -> L69
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L60 Throwable -> L69
        goto L58
    L74:
        b(r119, r120);     // Catch: Throwable -> L52
        r121 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L55
    L38:
        return new r0(this.f544252c, f3.a.f475266g);
    L73:
        return new r0("start sensor failed: " + r112.getMessage(), f3.a.f475265f);
    L28:
        r110 = null;
    L31:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L24:
        return new r0(this.f544252c, f3.a.f475266g);
    L21:
        r107 = null;
        goto L22
    L13:
        return new r0("context is null", f3.a.f475265f);
    L9:
        return new r0("context is null", f3.a.f475265f);
    L5:
        return new r0("context is null", f3.a.f475265f);
    }

    public c(e3.d r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "changeEventName");
        Intrinsics.checkNotNullParameter(r103, "unavailableMessage");
        this.f544250a = r101;
        this.f544251b = r102;
        this.f544252c = r103;
        this.f544253d = new WeakReference(r100);
        this.f544254e = new Object();
    }
}

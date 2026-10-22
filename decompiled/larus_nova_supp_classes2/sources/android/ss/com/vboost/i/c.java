package android.ss.com.vboost.i;

import android.content.Context;
import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.Status;
import android.ss.com.vboost.VboostListener;
import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class c {
    private static final String e = "c";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static android.ss.com.vboost.utils.c<Context> f115f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RomUtils.a f116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f118c;
    private android.ss.com.vboost.utils.c<List<VboostListener.SystemListener>> d;

    public static class a extends android.ss.com.vboost.utils.c<Context> {
        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Context initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() == null) goto L6;
            LogUtil.info(c.c(), "register context.");
            return CapabilityScheduler.getInitialConfigProvider().getContext();
        L6:
            return null;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Context initialValue() {
            return initialValue();
        }
    }

    public class b extends android.ss.com.vboost.utils.c<List<VboostListener.SystemListener>> {
        public b(c r1) {
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ List<VboostListener.SystemListener> initialValue() {
            return initialValue2();
        }

        @Override // android.ss.com.vboost.utils.c
        /* JADX INFO: renamed from: initialValue, reason: avoid collision after fix types in other method */
        public List<VboostListener.SystemListener> initialValue2() {
            ArrayList r0 = new ArrayList();
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
        L7:
            return r0;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getSystemListener() == null) goto L7;
            r0.add(CapabilityScheduler.getInitialConfigProvider().getSystemListener());
            goto L7
        }
    }

    /* JADX INFO: renamed from: android.ss.com.vboost.i.c$c, reason: collision with other inner class name */
    public static /* synthetic */ class C0000c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f120b = null;

        static {
            int[] r0 = new int[CapabilityType.values().length];
            f120b = r0;
            r0[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L66:
            f120b[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L50:
            f120b[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L62:
            f120b[CapabilityType.UFS_FREQ_MAX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L68:
            f120b[CapabilityType.CPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L52:
            f120b[CapabilityType.GPU_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L54:
            f120b[CapabilityType.BUS_FREQ_MIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L76:
            f120b[CapabilityType.UFS_FREQ_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L44:
            f120b[CapabilityType.CPU_AFFINITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L70:
            f120b[CapabilityType.TASK_PRIORITY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L74:
            f120b[CapabilityType.PRESET_SCENE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L58:
            f120b[CapabilityType.THUMB_FETCH.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L64:
            f120b[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L48:
            f120b[CapabilityType.NETWORK_ENHANCE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L20:
            int[] r4 = new int[RomUtils.a.values().length];
            f119a = r4;
            r4[RomUtils.a.f179b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L78:
            f119a[RomUtils.a.f180c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L46:
            f119a[RomUtils.a.e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L56:
            f119a[RomUtils.a.f181f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f121a = null;

        static {
            f121a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f121a;
        }
    }

    static {
        f115f = new a();
    }

    private c() {
        this.f116a = RomUtils.a.f178a;
        this.d = new b(this);
        this.f116a = RomUtils.getRomType();
        if (this.f117b != null) goto L18;
        String r0 = e;
        LogUtil.info(r0, "create " + this.f116a + " provider.");
        int r1 = C0000c.f119a[this.f116a.ordinal()];
        if (r1 != 1) goto L7;
        h r2 = l.a(f115f.get());
    L17:
        this.f117b = r2;
        goto L18
    L7:
        if (r1 != 2) goto L9;
        r2 = android.ss.com.vboost.i.b.a(f115f.get());
        goto L17
    L9:
        if (r1 != 3) goto L11;
        r2 = e.a(f115f.get());
        goto L17
    L11:
        if (r1 == 4) goto L13;
        LogUtil.warn(r0, "Not implement provider of this device " + this.f116a + "!");
        goto L18
    L13:
        r2 = m.a(f115f.get());
    L18:
        this.f118c = new f(f115f.get());
    }

    public /* synthetic */ c(a r1) {
        this();
    }

    public static void a(Context r1) {
        f115f.set(r1);
        e();
    }

    public static /* synthetic */ String c() {
        return e;
    }

    public static Context d() {
        return f115f.get();
    }

    private i d(android.ss.com.vboost.request.d r10) {
        i r0 = new i(r10.f158a);
        r10.t = r0;
        switch(C0000c.f120b[r0.f133a.ordinal()]) {
            case 1: goto L56;
            case 2: goto L56;
            case 3: goto L56;
            case 4: goto L56;
            case 5: goto L56;
            case 6: goto L56;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L48;
            case 10: goto L38;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L10;
            case 14: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L38:
        k r1 = k.a();
        g r4 = g.f131b;
        android.ss.com.vboost.i.d r2 = (android.ss.com.vboost.i.d) r1.a(r4, r0.f133a).get(r10.f159b);
        if (r2 != null) goto L42;
        LogUtil.warn(e, "No level regulation set！！！");
        return null;
    L42:
        r0.f138h = r10.d;
        r0.f135c = r2.f123a;
        if (r2.f124b != r4) goto L45;
        h r11 = this.f118c;
    L46:
        r0.f134b = r11;
        return r0;
    L45:
        r11 = this.f117b;
        goto L46
    L48:
        r0.f138h = r10.d;
        r0.f137g = r10.f161f;
        h r3 = this.f117b;
        if (r3 != null) goto L51;
    L53:
        h r12 = this.f118c;
    L54:
        r0.f134b = r12;
        return r0;
    L51:
        if (r3.a(r10.f158a) == false) goto L53;
        r12 = this.f117b;
        goto L54
    L56:
        h r5 = this.f117b;
        if (r5 != null) goto L59;
    L85:
        h r6 = this.f117b;
        if (r6 == null) goto L97;
        if (r6.a(r10.f158a) == false) goto L97;
        r0.f134b = this.f117b;
        android.ss.com.vboost.i.d r7 = (android.ss.com.vboost.i.d) k.a().a(g.f130a, r0.f133a).get(r10.f159b);
        if (r7 != null) goto L93;
        LogUtil.warn(e, "No level regulation set！！！");
        return null;
    L93:
        long r8 = r10.f160c;
        int r13 = r7.f125c;
        if (r8 > r13) goto L104;
    L105:
        r0.f136f = r8;
        r0.f135c = r7.f123a;
    L106:
        return r0;
    L104:
        r8 = r13;
    L97:
        if (this.f118c.a(r10.f158a) == false) goto L107;
        r0.f134b = this.f118c;
        r7 = (android.ss.com.vboost.i.d) k.a().a(g.f131b, r0.f133a).get(r10.f159b);
        if (r7 != null) goto L102;
        LogUtil.warn(e, "No level regulation set！！！");
        return null;
    L102:
        r8 = r10.f160c;
        r13 = r7.f125c;
        if (r8 <= r13) goto L105;
    L107:
        LogUtil.warn(e, "No provider support this capability!!!");
        return null;
    L59:
        if (r5.a(r0.f133a) == false) goto L85;
        if (this.f118c.a(r0.f133a) == false) goto L85;
        k r9 = k.a();
        g r14 = g.f130a;
        android.ss.com.vboost.i.d r15 = (android.ss.com.vboost.i.d) r9.a(r14, r0.f133a).get(r10.f159b);
        if (r15 != null) goto L66;
        LogUtil.warn(e, "No level regulation set！！！");
        return null;
    L66:
        long r16 = r10.f160c;
        if (r16 > r15.f125c) goto L69;
        r0.f136f = r16;
        r0.f135c = r15.f123a;
        if (r15.f124b != g.f131b) goto L83;
    L82:
        h r17 = this.f118c;
    L84:
        r0.f134b = r17;
    L83:
        r17 = this.f117b;
        goto L84
    L69:
        if (r15.a(r10.f159b, (int) r16) == false) goto L77;
        android.ss.com.vboost.i.d r18 = (android.ss.com.vboost.i.d) k.a().a(r14, r0.f133a).get(r15.d);
        if (r18 != null) goto L74;
        LogUtil.warn(e, "Fallback level regulation is not set！！！");
        return null;
    L74:
        r0.f136f = r10.f160c;
        r0.f135c = r18.f123a;
        if (r18.f124b != g.f131b) goto L83;
    L77:
        r0.f135c = r15.f123a;
        r0.f136f = r15.f125c;
        if (r15.f124b != g.f131b) goto L83;
    L6:
        if (this.f117b.a(r0.f133a) == false) goto L8;
        r0.f134b = this.f117b;
    L8:
        return r0;
    L10:
        if (this.f118c.a(r0.f133a) == false) goto L14;
        r0.e = r10.f163h;
        h r19 = this.f118c;
    L12:
        r0.f134b = r19;
    L16:
        return r0;
    L14:
        if (this.f117b.a(r0.f133a) == false) goto L16;
        r19 = this.f117b;
        goto L12
    L18:
        if (this.f118c.a(r0.f133a) == false) goto L22;
        h r110 = this.f118c;
    L20:
        r0.f134b = r110;
    L24:
        return r0;
    L22:
        if (this.f117b.a(r0.f133a) == false) goto L24;
        r110 = this.f117b;
        goto L20
    L26:
        if (this.f118c.a(r0.f133a) == false) goto L30;
        h r20 = this.f118c;
    L28:
        r0.f134b = r20;
    L32:
        j r21 = new j(r10.f162g);
        r0.d = r21;
        if (r10.f165j == false) goto L35;
        Status r111 = Status.END;
    L36:
        r21.f140b = r111;
        return r0;
    L35:
        r111 = Status.BEGIN;
        goto L36
    L30:
        if (this.f117b.a(r0.f133a) == false) goto L32;
        r20 = this.f117b;
        goto L28
    }

    public static c e() {
        if (f115f.get() != null) goto L7;
        LogUtil.warn(e, "Some provider must inject a application context!!!");
        return null;
    L7:
        return d.a();
    }

    public Set<CapabilityType> a() {
        return ((android.ss.com.vboost.i.a) this.f118c).a();
    }

    public void a(VboostListener.SystemListener r2) {
        this.d.get().add(r2);
    }

    public boolean a(CapabilityType r4) {
        LogUtil.debug(e, "name:" + r4.getName() + "  index:" + r4.getIndex());
        return ((android.ss.com.vboost.i.a) this.f118c).b(r4);
    }

    public boolean a(android.ss.com.vboost.request.d r3) {
        h r0 = this.f117b;
        if (r0 == null) goto L7;
        if (r0.a(r3.f158a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f118c.a(r3.f158a) == true) goto L8;
        return false;
    }

    public Object b(android.ss.com.vboost.request.d r2) {
        i r3 = d(r2);
        if (r3 == null) goto L8;
        h r0 = r3.f134b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r3);
    L8:
        return null;
    }

    public void b() {
        if (android.ss.com.vboost.utils.a.a() == false) goto L23;
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L18
        r0.put("vendor", this.f116a.name());     // Catch: JSONException -> L18
        if (this.f117b == null) goto L11;
        boolean r2 = true;
    L12:
        r0.put("vendorInit", r2);     // Catch: JSONException -> L18
        r0.put("platform", android.ss.com.vboost.h.d.a().name());     // Catch: JSONException -> L18
        r0.put("platformInit", android.ss.com.vboost.h.d.b());     // Catch: JSONException -> L18
        android.ss.com.vboost.utils.a.a("vboost_event_launch", r0, "behavior");     // Catch: JSONException -> L18
        return;
    L11:
        r2 = false;
    L18:
        e = move-exception;
        LogUtil.error(e, e.getMessage());
        return;
    }

    public void b(VboostListener.SystemListener r3) {
        this.d.get().remove(r3);
        Iterator<VboostListener.SystemListener> r0 = this.d.get().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r3 != r0.next()) goto L4;
        r0.remove();
        goto L4
    }

    public Object c(android.ss.com.vboost.request.d r4) {
        if (r4.f165j == false) goto L5;
        i r5 = r4.t;
    L6:
        if (r5 == null) goto L14;
        h r0 = r5.f134b;
        if (r0 == null) goto L16;
        j r1 = r5.d;
        if (r1 == null) goto L13;
        r1.f140b = Status.END;
    L13:
        return r0.a(r5);
    L16:
        return null;
    L14:
        return null;
    L5:
        r5 = d(r4);
        goto L6
    }
}

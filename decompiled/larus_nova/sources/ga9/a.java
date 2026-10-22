package ga9;

import com.larus.flowsdk.common.experiment.FlowABValueType;
import com.larus.flowsdk.common.experiment.FlowExperimentDefaultScope;
import com.larus.init.task.experiment.FlowClientExperimentSettingsRuntime;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<C5998a> f480591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<b> f480592b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f480593c = null;

    /* JADX INFO: renamed from: ga9.a$a, reason: collision with other inner class name */
    public static final class C5998a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f480594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowExperimentDefaultScope f480595b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5998a) == true) goto L8;
            return false;
        L8:
            C5998a r101 = (C5998a) r100;
            if (Intrinsics.areEqual(this.f480594a, r101.f480594a) == true) goto L12;
            return false;
        L12:
            if (this.f480595b == r101.f480595b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f480594a.hashCode() * 31) + this.f480595b.hashCode();
        }

        public final String toString() {
            return "RuntimeInstallation(runtime=" + this.f480594a + ", defaultScope=" + this.f480595b + ')';
        }

        public C5998a(FlowClientExperimentSettingsRuntime r100, FlowExperimentDefaultScope r101) {
            Intrinsics.checkNotNullParameter(r100, "runtime");
            Intrinsics.checkNotNullParameter(r101, "defaultScope");
            this.f480594a = r100;
            this.f480595b = r101;
        }
    }

    static {
        f480591a = new AtomicReference(null);
        b.f480596a.getClass();
        f480592b = new AtomicReference(b.a.f480598b);
        f480593c = new AtomicLong(0);
    }

    public static c m() {
        C5998a r100 = f480591a.get();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f480594a;
    }

    public static void g(f r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        c r101 = m();
        if (r101 != null) goto L6;
        StringBuilder r102 = new StringBuilder("register dropped: ");
        r102.append("key=" + r100.f480601a + ", owner=" + r100.f480602b + ", type=" + r100.f480603c.getWireValue() + ", defaultValue=" + r100.f480604d + ", stable=" + r100.f480605e);
        r102.append(", runtimeInstalled=false");
        f480592b.get().w(r102.toString());
        return;
    L6:
        r101.c(r100);
    }

    public static JSONArray a(String r100, JSONArray r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        c r102 = m();
        if (r102 != null) goto L6;
        f("getArray", r100, r101);
        return r101;
    L6:
        return r102.a(r100, r101);
    }

    public static boolean b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        c r102 = m();
        if (r102 != null) goto L6;
        f("getBool", r100, Boolean.valueOf(r101));
        return r101;
    L6:
        return r102.e(r100, r101);
    }

    public static JSONObject c(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        c r102 = m();
        if (r102 != null) goto L6;
        f("getDict", r100, r101);
        return r101;
    L6:
        return r102.f(r100, r101);
    }

    public static int d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        c r102 = m();
        if (r102 != null) goto L6;
        f("getInt", r100, Integer.valueOf(r101));
        return r101;
    L6:
        return r102.b(r100, r101);
    }

    public static String e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        c r102 = m();
        if (r102 != null) goto L6;
        f("getString", r100, r101);
        return r101;
    L6:
        return r102.d(r100, r101);
    }

    public static void f(String r100, String r101, Object r102) {
        f480592b.get().w(r100 + " fallback: key=" + r101 + ", defaultValue=" + r102 + ", runtimeInstalled=false");
    }

    public static void h(String r100, String r101, JSONArray r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        g(new f(r100, r101, FlowABValueType.ARRAY, r102, true));
    }

    public static void i(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        g(new f(r100, r101, FlowABValueType.BOOL, Boolean.valueOf(r102), true));
    }

    public static void j(String r100, String r101, JSONObject r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        g(new f(r100, r101, FlowABValueType.DICT, r102, r110));
    }

    public static void k(String r100, String r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        g(new f(r100, r101, FlowABValueType.INT, Integer.valueOf(r102), r110));
    }

    public static void l(String r100, String r101, String r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        g(new f(r100, r101, FlowABValueType.STRING, r102, r110));
    }
}

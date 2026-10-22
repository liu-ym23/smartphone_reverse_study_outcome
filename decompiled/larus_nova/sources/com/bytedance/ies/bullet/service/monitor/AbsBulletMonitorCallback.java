package com.bytedance.ies.bullet.service.monitor;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.r;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import h16.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w26.g;
import w26.h;

/* JADX INFO: loaded from: classes19.dex */
public class AbsBulletMonitorCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f247939c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BulletContext f247940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f247941b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", TextFieldImplKt.ContainerId, "Engine", "Plugin", "Business", "RL", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ErrStage extends Enum<ErrStage> {
        public static final ErrStage Business = null;
        public static final ErrStage Container = null;
        public static final ErrStage Engine = null;
        public static final ErrStage Plugin = null;
        public static final ErrStage RL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrStage[] f247942a = null;
        private final String tag;

        public static ErrStage valueOf(String r100) {
            return (ErrStage) r27.a.a(ErrStage.class, r100);
        }

        public static ErrStage[] values() {
            return (ErrStage[]) f247942a.clone();
        }

        static {
            ErrStage r100 = new ErrStage(TextFieldImplKt.ContainerId, 0, "bullet");
            Container = r100;
            ErrStage r101 = new ErrStage("Engine", 1, "engine");
            Engine = r101;
            ErrStage r102 = new ErrStage("Plugin", 2, CloudControlInf.PLUGIN);
            Plugin = r102;
            ErrStage r103 = new ErrStage("Business", 3, "business");
            Business = r103;
            ErrStage r104 = new ErrStage("RL", 4, "resource");
            RL = r104;
            f247942a = new ErrStage[]{r100, r101, r102, r103, r104};
        }

        public final String getTag() {
            return this.tag;
        }

        public ErrStage(String r100, int r101, String r102) {
            super(r100, r101);
            this.tag = r102;
        }
    }

    public static final class a {
    }

    public static final class b extends r.a {
        public b() {
        }
    }

    static {
    }

    public void A() {
    }

    public void B() {
    }

    public void C(e r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorContainer");
    }

    public void D() {
    }

    public void E() {
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void K() {
        Intrinsics.checkNotNullParameter("kit_load_start", "key");
    }

    public void L() {
    }

    public void M() {
    }

    public long d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return 0;
    }

    public void g(BulletContext r100, Integer r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void i(e r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorContainer");
    }

    public void j() {
    }

    public void k(Long r100) {
    }

    public void m() {
    }

    public void n(String r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s(long r100, boolean r101) {
    }

    public void t(ErrStage r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "errStage");
        Intrinsics.checkNotNullParameter(r101, "errMessage");
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public void z() {
    }

    public Map<String, Long> a() {
        return new LinkedHashMap();
    }

    public final BulletContext c() {
        BulletContext r100 = this.f247940a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
        return null;
    L6:
        return r100;
    }

    public final String f() {
        BulletContext r100 = this.f247940a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mBulletContext");
        r100 = null;
    L6:
        return r100.getSessionId();
    }

    public AbsBulletMonitorCallback() {
        this.f247941b = new b();
    }

    public r.a b() {
        return this.f247941b;
    }

    public void h(BulletContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f247940a == null) goto L5;
        return;
    L5:
        this.f247940a = r100;
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        g r102 = (g) x26.a.a(g.class);
        if (r102 == null) goto L8;
        h r103 = (h) r102.n0(h.class);
    L9:
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L17;
        AbsBulletMonitorCallback r105 = new AbsBulletMonitorCallback();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r100.f246435c = r105;
        return;
    L17:
        return;
    L11:
        if (r103.f() == true) goto L13;
        r104 = true;
        goto L14
    L8:
        r103 = null;
        goto L9
    }

    public void I(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke();
    }
}

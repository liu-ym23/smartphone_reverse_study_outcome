package qx8;

import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import gx8.d;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends gx8.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f535156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f535157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f535158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f535159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f535160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f535161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f535162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f535163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f535164j;

    static {
        f535156b = new a();
        f535159e = 1;
        f535164j = true;
    }

    @Override // gx8.a
    public final d b() {
        b r100 = new b();
        f535157c = r100;
        return r100;
    }

    public final void i() {
        ((LinkedHashMap) this.f483123a.f483125b).clear();
        f535159e = 1;
        f535158d = 0;
        b r100 = f535157c;
        if (r100 == null) goto L5;
        r100.f535165a = null;
        r100.f535166b = "";
    L5:
        f535160f = false;
        f535161g = false;
        f535162h = false;
        f535163i = null;
    }

    public a() {
    }

    public final void d(ICameraEventExt r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        i();
        if (r100 != null) goto L5;
        return;
    L5:
        b r102 = f535157c;
        if (r102 == null) goto L9;
        JSONObject r103 = r100.enterPageEventExt();
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        r102.f535165a = r103;
        r102.f535166b = b.b(r101);
        return;
    }

    public final void e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        gx8.b r102 = this.f483123a;
        CameraEvent r103 = CameraEvent.CAPTURE_RESULT;
        JSONObject r104 = new JSONObject();
        r104.put("is_success", "0");
        r104.put("error_msg", r101);
        r104.put("error_code", r100);
        Unit r105 = Unit.INSTANCE;
        r102.b(r103, r104);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        FLogger.f375446a.i("CameraMonitor", "[onRecordFail] from: " + f535163i + ", hasReportRecordResult: " + f535161g + ", triggerRecord: " + f535160f + ", code:" + r100 + ", reason:" + r101);
        if (f535160f == true) goto L5;
        return;
    L5:
        if (f535161g == true) goto L10;
        gx8.b r102 = this.f483123a;
        CameraEvent r103 = CameraEvent.RECORD_RESULT;
        JSONObject r104 = new JSONObject();
        r104.put("is_success", "0");
        r104.put("error_msg", r101);
        r104.put("error_code", r100);
        r104.putOpt("record_mode", f535163i);
        r104.put("enable_audio", f535162h ? 1 : 0);
        Unit r105 = Unit.INSTANCE;
        r102.b(r103, r104);
        f535161g = true;
        f535160f = false;
        return;
    }

    public final void h(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        if (r100 > 0) goto L5;
        return;
    L5:
        gx8.b r102 = this.f483123a;
        CameraEvent r103 = CameraEvent.PREVIEW_RENDER_FPS;
        JSONObject r104 = new JSONObject();
        r104.put("value", r100);
        r104.put("trigger_from", r101);
        Unit r105 = Unit.INSTANCE;
        r102.b(r103, r104);
    }

    public final void f(int r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        gx8.b r104 = this.f483123a;
        CameraEvent r105 = CameraEvent.SAVE_LOCAL_RESULT;
        JSONObject r106 = new JSONObject();
        r106.put("is_success", "0");
        r106.put("error_msg", r101);
        r106.put("error_code", r100);
        r106.put("multi_question", r102);
        r106.put("from_album", r103 ? 1 : 0);
        Unit r107 = Unit.INSTANCE;
        r104.b(r105, r106);
    }
}

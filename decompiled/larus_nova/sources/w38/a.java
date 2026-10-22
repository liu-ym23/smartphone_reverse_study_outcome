package w38;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f558179a = null;

    static {
        f558179a = new a();
    }

    public a() {
    }

    public static void a(String r100) {
        SaasTracking r101 = SaasTracking.f286464a;
        JSONObject r102 = new JSONObject();
        r102.put("path", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("doubao_account_network_request", r102);
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
    public static void b(String r100, b r101) {
        b.C8063b r102 = null;
        if ((r101 instanceof b.a) == false) goto L5;
        b.a r103 = (b.a) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f558180a;
    L8:
        SaasTracking r104 = SaasTracking.f286464a;
        JSONObject r105 = new JSONObject();
        r105.put("path", r100);
        r105.put("success", r101 instanceof b.d ? 1 : 0);
        if (r102 == null) goto L11;
        r105.put("err_code", r102.f558182a);
        r105.put(LocationMonitorConst.ERR_MSG, r102.f558183b);
    L11:
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("doubao_account_network_result", r105);
        return;
    L5:
        r103 = null;
        goto L6
    }
}

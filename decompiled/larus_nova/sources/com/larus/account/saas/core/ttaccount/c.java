package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import org.json.JSONObject;
import wb7.k;
import x38.h;
import yb7.j;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f286291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f286292b;

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
    public final void b(ua7.e<k> r100) {
        this.f286291a.onSendSuccess();
        JSONObject r101 = new JSONObject();
        boolean r102 = this.f286292b;
        r101.put("success", 1);
        r101.put("resend", r102 ? 1 : 0);
        SaasTracking.f286464a.reportEvent("doubao_account_login_send_code_result", r101);
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public c(com.larus.account.saas.jsb.core.e r100, boolean r101) {
        this.f286291a = r100;
        this.f286292b = r101;
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
    public final void a(ua7.e<k> r100, int r101) {
        h r102 = this.f286291a;
        String r103 = null;
        if (r100 == null) goto L6;
        String r104 = r100.f549255i;
        if (r104 == null) goto L6;
    L9:
        r102.a(r101, r104);
        JSONObject r105 = new JSONObject();
        boolean r106 = this.f286292b;
        r105.put("success", 0);
        r105.put("resend", r106 ? 1 : 0);
        r105.put("err_code", r101);
        if (r100 == null) goto L12;
        r103 = r100.f549255i;
    L12:
        if (r103 == null) goto L14;
        r105.put("err_tips", r100.f549255i);
    L14:
        SaasTracking.f286464a.reportEvent("doubao_account_login_send_code_result", r105);
        return;
    L6:
        if (r100 == null) goto L8;
        r104 = r100.f549256j;
        goto L9
    L8:
        r104 = null;
        goto L9
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}

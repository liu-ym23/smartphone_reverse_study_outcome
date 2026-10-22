package com.bytedance.ee.bear.bitable.newform;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.newform.notification.ContactChooseFragment;
import com.bytedance.ee.bear.bitable.newform.notification.SelectItem;
import kotlin.Unit;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ContactChooseFragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f214766a;

    @Override // com.bytedance.ee.bear.bitable.newform.notification.ContactChooseFragment.b
    public final void onCancel() {
        m r100 = this.f214766a;
        if (r100 == null) goto L6;
        JSONObject r101 = new JSONObject();
        r101.put2("callbackType", "cancel");
        r100.b(r101);
        return;
    }

    public c(m r100) {
        this.f214766a = r100;
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
    @Override // com.bytedance.ee.bear.bitable.newform.notification.ContactChooseFragment.b
    public final void a(SelectItem[] r100) {
        m r101 = this.f214766a;
        if (r101 == null) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put2("callbackType", "success");
        JSONObject r103 = new JSONObject();
        r103.put2("selectItems", r100);
        Unit r104 = Unit.INSTANCE;
        r102.put2("data", r103);
        r101.b(r102);
        return;
    }
}

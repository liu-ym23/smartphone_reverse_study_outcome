package com.bytedance.ee.bear.bitable.jsapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import java.util.List;
import kotlin.Unit;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements CommonAttachmentPanel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f214327a;

    public a(m r100) {
        this.f214327a = r100;
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
    @Override // com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel.d
    public final void a(List<CommonAttachmentPanel.AttachmentInfo> r100) {
        m r101 = this.f214327a;
        JSONObject r102 = new JSONObject();
        r102.put2("callbackType", "success");
        JSONObject r103 = new JSONObject();
        JSONArray r104 = new JSONArray();
        if (r100 == null) goto L5;
        r104.addAll(r100);
    L5:
        Unit r105 = Unit.INSTANCE;
        r103.put2("infos", r104);
        r102.put2("data", r103);
        r101.b(r102);
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
    @Override // com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel.d
    public final void b(int r100, String r101) {
        m r102 = this.f214327a;
        JSONObject r103 = new JSONObject();
        r103.put2("callbackType", "failure");
        JSONObject r104 = new JSONObject();
        r104.put2("errCode", Integer.valueOf(r100));
        r104.put2("errMsg", r101);
        Unit r105 = Unit.INSTANCE;
        r103.put2("data", r104);
        r102.b(r103);
    }
}

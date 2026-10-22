package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class f4 {
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
    public static final void a(String r100, boolean r101, Boolean r102) {
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;
        JSONObject r104 = new JSONObject();
        r104.put("current_page", "bot_voice_change");
        if (r101 == false) goto L5;
        String r105 = "on";
    L6:
        r104.put("to_status", r105);
        if (r102 == null) goto L9;
        r104.put("success", r102.booleanValue() ? 1 : 0);
    L9:
        Unit r106 = Unit.INSTANCE;
        r103.reportEvent(r100, r104);
        return;
    L5:
        r105 = "off";
        goto L6
    }
}

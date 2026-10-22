package com.bytedance.ies.bullet.web.pia;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class o implements IDLXBridgeMethod.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<Object> f248339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f248340b;

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
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
    public final void invoke(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        l47.a<Object> r101 = this.f248339a;
        l47.a<PiaMethod.Error> r102 = this.f248340b;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L25
        Object r104 = r100.get("code");     // Catch: Throwable -> L25
        Map r105 = null;
        String r106 = null;
        if ((r104 instanceof Integer) == false) goto L6;
        Integer r107 = (Integer) r104;     // Catch: Throwable -> L25
    L7:
        if (r107 != null) goto L10;
    L16:
        if (r107 == null) goto L18;
        int r108 = r107.intValue();     // Catch: Throwable -> L25
    L19:
        Object r109 = r100.get("msg");     // Catch: Throwable -> L25
        if ((r109 instanceof String) == false) goto L22;
        r106 = (String) r109;     // Catch: Throwable -> L25
    L22:
        r102.accept(new PiaMethod.Error(r108, r106));     // Catch: Throwable -> L25
    L23:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        l47.a<PiaMethod.Error> r111 = this.f248340b;
        Throwable r112 = Result.m9452exceptionOrNullimpl(r110);
        if (r112 == null) goto L33;
        r111.accept(new PiaMethod.Error(r112.getMessage()));
        return;
    L33:
        return;
    L18:
        r108 = 0;
        goto L19
    L10:
        if (r107.intValue() != 1) goto L16;
        Object r113 = r100.get("data");     // Catch: Throwable -> L25
        if ((r113 instanceof Map) == false) goto L14;
        r105 = (Map) r113;     // Catch: Throwable -> L25
    L14:
        r101.accept(r105);     // Catch: Throwable -> L25
        goto L23
    L6:
        r107 = null;
    L25:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public o(m47.h r100, m47.i r101) {
        this.f248339a = r100;
        this.f248340b = r101;
    }
}

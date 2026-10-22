package com.larus.canvas.feature.component.logic.provider;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends com.larus.gallery.api.t<ky8.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f323469f;

    public w(j r100) {
        Intrinsics.checkNotNullParameter(r100, "canvasGalleryContext");
        this.f323469f = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, ky8.a] */
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
    @Override // com.larus.gallery.api.t
    public final void w(ky8.a r100, int r101) {
        ky8.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f343898d = r102;
        c0 r103 = this.f323469f.f323445d;
        if (r103 == 0) goto L6;
        r103.a(r102);
        return;
    }
}

package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.TextFutureRunner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class t implements com.ss.android.lark.coremd.base.parse.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cab.b f420160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.r<v7b.n> f420161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LarkLinkPlugin f420162c;

    public t(cab.b r100, com.ss.android.lark.coremd.impl.parse.k r101, LarkLinkPlugin r102) {
        this.f420160a = r100;
        this.f420161b = r101;
        this.f420162c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1] */
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
    @Override // com.ss.android.lark.coremd.base.parse.x
    public final void a(final TextFutureRunner.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        cab.b r101 = this.f420160a;
        Context r102 = this.f420161b.getContext();
        v7b.n r103 = this.f420161b.getNode();
        final LarkLinkPlugin r104 = this.f420162c;
        final com.ss.android.lark.coremd.base.parse.r<v7b.n> r105 = this.f420161b;
        r101.b(r102, r103, new LarkLinkPlugin$visitLink$1$1(r100, r104, r105));
    }
}

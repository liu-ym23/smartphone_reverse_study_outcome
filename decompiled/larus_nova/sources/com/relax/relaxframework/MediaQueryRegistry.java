package com.relax.relaxframework;

import com.relax.runtime.gen.GlobalState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class MediaQueryRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GlobalState f404786a;

    public static final class Companion {
        public static GlobalState a() {
            if (MediaQueryRegistry.f404786a != null) goto L13;
            RelaxInstance.Companion.getClass();
            RelaxInstance r100 = RelaxInstance.access$getCurrentInstance$cp();
            if (r100 == null) goto L9;
            boolean r101 = true;
            if (r100.rtsPipelineEnabled() != true) goto L9;
        L10:
            if (r101 == false) goto L12;
            RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r102);
            qpa.b r103 = r102.getContextProxy();
            Intrinsics.checkNotNull(r103);
            GlobalState r104 = r103.f534444a.d();
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.relax.runtime.gen.GlobalState");
            MediaQueryRegistry.f404786a = r104;
            goto L13
        L12:
            MediaQueryRegistry.f404786a = RelaxInstance.access$getCurrentInstance$cp().getMediaQuery().c();
        L9:
            r101 = false;
        L13:
            GlobalState r105 = MediaQueryRegistry.f404786a;
            Intrinsics.checkNotNull(r105);
            return r105;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.relax.relaxframework.v2] */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.relax.relaxframework.u2] */
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
        public static Function0 b(final Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            RelaxInstance.Companion.getClass();
            RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
            if (r101 == null) goto L7;
            boolean r102 = true;
            if (r101.rtsPipelineEnabled() != true) goto L7;
        L8:
            if (r102 == false) goto L10;
            RelaxInstance r103 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r103);
            qpa.b r104 = r103.getContextProxy();
            Intrinsics.checkNotNull(r104);
            ?? r105 = new u2(r100);
            r104.f534444a.c(r105);
        L12:
            return new MediaQueryRegistry$Companion$onStateChange$3(r100);
        L10:
            ?? r106 = new v2(r100);
            RelaxInstance.access$getCurrentInstance$cp().getMediaQuery().b(r106);
        L7:
            r102 = false;
            goto L8
        }
    }

    static {
    }
}

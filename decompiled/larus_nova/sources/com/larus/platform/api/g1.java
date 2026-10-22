package com.larus.platform.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface g1 {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void c(Fragment r100, FragmentActivity r101, List r102, c r103) {
            com.larus.platform.service.i2.f365748b.j(r100, r101, r102, null, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(Fragment r100, List r101, c r102, Map r103, JSONObject r110, int r111) {
            com.larus.platform.service.i2 r104 = com.larus.platform.service.i2.f365748b;
            if ((r111 & 8) == 0) goto L5;
            Map r105 = null;
        L7:
            if ((r111 & 16) == 0) goto L9;
            JSONObject r106 = null;
        L10:
            r104.k(r100, r101, r102, r105, r106);
            return;
        L9:
            r106 = r110;
            goto L10
        L5:
            r105 = r103;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public static /* synthetic */ void b(FragmentActivity r100, List r101, c r102, Map r110, JSONObject r111, int r112) {
            com.larus.platform.service.i2 r103 = com.larus.platform.service.i2.f365748b;
            if ((r112 & 8) == 0) goto L5;
            Map r104 = null;
        L7:
            if ((r112 & 16) == 0) goto L9;
            JSONObject r105 = null;
        L11:
            if ((r112 & 32) == 0) goto L13;
            boolean r106 = true;
        L14:
            r103.g(r100, r101, r102, r104, r105, r106);
            return;
        L13:
            r106 = false;
            goto L14
        L9:
            r105 = r111;
            goto L11
        L5:
            r104 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public interface b {
        void onGoSettingsDialogDismiss(boolean r100);

        void onGoSettingsDialogShow();

        void onSettingPageReturn();
    }

    /* JADX INFO: loaded from: classes31.dex */
    public interface c extends b {
        void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103);
    }

    void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102);

    void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103);

    boolean d(String r100);

    void f(boolean r100);

    void g(FragmentActivity r100, List<String> r101, c r102, Map<String, String> r103, JSONObject r104, boolean r105);

    void i(FragmentActivity r100, c r101);

    void j(Fragment r100, FragmentActivity r101, List<String> r102, JSONObject r103, c r104);

    void k(Fragment r100, List<String> r101, c r102, Map<String, String> r103, JSONObject r104);

    void l(FragmentActivity r100, String r101, String r102, b r103);

    void m(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102);
}

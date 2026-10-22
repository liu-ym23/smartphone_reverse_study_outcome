package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = null;

    static {
        INSTANCE = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
    }

    public static /* synthetic */ CharSequence accessor$SignatureBuildingComponents$lambda0(String r100) {
        return jvmDescriptor$lambda$2(r100);
    }

    private final String escapeClassName(String r100) {
        if (r100.length() > 1) goto L5;
        return r100;
    L5:
        return "L" + r100 + ';';
    }

    private static final CharSequence jvmDescriptor$lambda$2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return INSTANCE.escapeClassName(r100);
    }

    public final String[] constructors(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "signatures");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.add("<init>(" + r100[r103] + ")V");
        r103 = r103 + 1;
        goto L3
    L6:
        return (String[]) r101.toArray(new String[0]);
    }

    public final String javaFunction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return "java/util/function/" + r100;
    }

    public final String javaLang(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return "java/lang/" + r100;
    }

    public final String javaUtil(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return "java/util/" + r100;
    }

    public final Set<String> inClass(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "internalName");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        LinkedHashSet r102 = new LinkedHashSet();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(r100 + '.' + r101[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public final Set<String> inJavaLang(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        return inClass(javaLang(r100), (String[]) Arrays.copyOf(r101, r101.length));
    }

    public final Set<String> inJavaUtil(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        return inClass(javaUtil(r100), (String[]) Arrays.copyOf(r101, r101.length));
    }

    public final String signature(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "internalName");
        Intrinsics.checkNotNullParameter(r101, "jvmDescriptor");
        return r100 + '.' + r101;
    }

    public final String jvmDescriptor(String r110, List<String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "parameters");
        Intrinsics.checkNotNullParameter(r112, "ret");
        return r110 + '(' + CollectionsKt.joinToString$default(r111, "", null, null, 0, null, SignatureBuildingComponents$$Lambda$0.INSTANCE, 30, null) + ')' + escapeClassName(r112);
    }
}

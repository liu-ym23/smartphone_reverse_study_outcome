package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 3) goto L7;
        if (r100 == 5) goto L7;
        switch(r100) {
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            default: goto L6;
        };
    L6:
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r100 == 3) goto L13;
        if (r100 == 5) goto L13;
        switch(r100) {
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            default: goto L12;
        };
    L12:
        int r102 = 3;
    L14:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            default: goto L16;
        };
    L16:
        r103[0] = "internalName";
    L21:
        if (r100 == 3) goto L29;
        if (r100 == 5) goto L28;
        switch(r100) {
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            default: goto L24;
        };
    L24:
        r103[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
    L30:
        switch(r100) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L36;
            case 4: goto L33;
            case 5: goto L36;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            default: goto L31;
        };
    L31:
        r103[2] = "byInternalName";
        goto L36
    L32:
        r103[2] = "<init>";
        goto L36
    L33:
        r103[2] = "byFqNameWithoutInnerClasses";
        goto L36
    L34:
        r103[2] = "internalNameByClassId";
        goto L36
    L35:
        r103[2] = "byClassId";
    L36:
        String r104 = String.format(r101, r103);
        if (r100 == 3) goto L42;
        if (r100 == 5) goto L42;
        switch(r100) {
            case 8: goto L42;
            case 9: goto L42;
            case 10: goto L42;
            default: goto L43;
        };
    L43:
        throw new IllegalArgumentException(r104);
    L42:
        throw new IllegalStateException(r104);
    L25:
        r103[1] = "getInternalName";
        goto L30
    L26:
        r103[1] = "getPackageFqName";
        goto L30
    L27:
        r103[1] = "getFqNameForClassNameWithoutDollars";
        goto L30
    L28:
        r103[1] = "byFqNameWithoutInnerClasses";
        goto L30
    L29:
        r103[1] = "internalNameByClassId";
        goto L30
    L17:
        r103[0] = "fqName";
        goto L21
    L18:
        r103[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        goto L21
    L19:
        r103[0] = "classId";
    L13:
        r102 = 2;
    L7:
        r101 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    public String getInternalName() {
        String r100 = this.internalName;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r100;
    }

    public FqName getPackageFqName() {
        int r100 = this.internalName.lastIndexOf(HTTP.URL_DEFAULT);
        if (r100 != (-1)) goto L9;
        FqName r101 = FqName.ROOT;
        if (r101 != null) goto L7;
        $$$reportNull$$$0(9);
    L7:
        return r101;
    L9:
        return new FqName(this.internalName.substring(0, r100).replace('/', '.'));
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }

    private JvmClassName(String r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.internalName = r100;
    }

    public static JvmClassName byClassId(ClassId r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return new JvmClassName(internalNameByClassId(r100));
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        JvmClassName r101 = new JvmClassName(r100.asString().replace('.', '/'));
        r101.fqName = r100;
        return r101;
    }

    public static JvmClassName byInternalName(String r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new JvmClassName(r100);
    }

    public static String internalNameByClassId(ClassId r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        FqName r101 = r100.getPackageFqName();
        String r102 = r100.getRelativeClassName().asString().replace('.', Typography.dollar);
        if (r101.isRoot() == true) goto L8;
        r102 = r101.asString().replace('.', '/') + HTTP.URL_DEFAULT + r102;
    L8:
        if (r102 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        return r102;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return this.internalName.equals(((JvmClassName) r100).internalName);
    }
}

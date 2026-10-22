package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.u.i;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.open.SocialConstants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum JvmPrimitiveType extends Enum<JvmPrimitiveType> {
    private static final /* synthetic */ JvmPrimitiveType[] $VALUES = null;
    public static final JvmPrimitiveType BOOLEAN = null;
    public static final JvmPrimitiveType BYTE = null;
    public static final JvmPrimitiveType CHAR = null;
    public static final JvmPrimitiveType DOUBLE = null;
    public static final JvmPrimitiveType FLOAT = null;
    public static final JvmPrimitiveType INT = null;
    public static final JvmPrimitiveType LONG = null;
    private static final Map<String, String> OWNER_TO_BOXING_METHOD_DESCRIPTOR = null;
    public static final JvmPrimitiveType SHORT = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = null;
    private static final Set<String> WRAPPER_CLASS_INTERNAL_NAMES = null;
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 4) goto L7;
        if (r100 == 6) goto L7;
        switch(r100) {
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            default: goto L6;
        };
    L6:
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r100 == 4) goto L13;
        if (r100 == 6) goto L13;
        switch(r100) {
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L13;
            default: goto L12;
        };
    L12:
        int r102 = 3;
    L14:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L22;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L21;
            case 13: goto L21;
            case 14: goto L21;
            case 15: goto L21;
            default: goto L16;
        };
    L16:
        r103[0] = "internalName";
    L26:
        if (r100 == 4) goto L34;
        if (r100 == 6) goto L34;
        switch(r100) {
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            default: goto L29;
        };
    L29:
        r103[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
    L35:
        switch(r100) {
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L41;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L41;
            case 15: goto L41;
            default: goto L36;
        };
    L36:
        r103[2] = "isWrapperClassInternalName";
        goto L41
    L37:
        r103[2] = "<init>";
        goto L41
    L38:
        r103[2] = "getByDesc";
        goto L41
    L39:
        r103[2] = MonitorConstants.CONNECT_TYPE_GET;
        goto L41
    L40:
        r103[2] = "isBoxingMethodDescriptor";
    L41:
        String r104 = String.format(r101, r103);
        if (r100 == 4) goto L47;
        if (r100 == 6) goto L47;
        switch(r100) {
            case 12: goto L47;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L47;
            default: goto L48;
        };
    L48:
        throw new IllegalArgumentException(r104);
    L47:
        throw new IllegalStateException(r104);
    L30:
        r103[1] = "getWrapperFqName";
        goto L35
    L31:
        r103[1] = "getDesc";
        goto L35
    L32:
        r103[1] = "getJavaKeywordName";
        goto L35
    L33:
        r103[1] = "getPrimitiveType";
    L34:
        r103[1] = MonitorConstants.CONNECT_TYPE_GET;
        goto L35
    L17:
        r103[0] = "wrapperClassName";
        goto L26
    L18:
        r103[0] = "primitiveType";
        goto L26
    L19:
        r103[0] = SocialConstants.PARAM_APP_DESC;
        goto L26
    L20:
        r103[0] = "type";
        goto L26
    L21:
        r103[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        goto L26
    L22:
        r103[0] = "name";
        goto L26
    L23:
        r103[0] = "methodDescriptor";
        goto L26
    L24:
        r103[0] = "owner";
    L13:
        r102 = 2;
    L7:
        r101 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    static {
        JvmPrimitiveType r100 = new JvmPrimitiveType("BOOLEAN", 0, PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean");
        BOOLEAN = r100;
        JvmPrimitiveType r101 = new JvmPrimitiveType("CHAR", 1, PrimitiveType.CHAR, "char", "C", "java.lang.Character");
        CHAR = r101;
        JvmPrimitiveType r102 = new JvmPrimitiveType("BYTE", 2, PrimitiveType.BYTE, "byte", "B", "java.lang.Byte");
        BYTE = r102;
        JvmPrimitiveType r103 = new JvmPrimitiveType("SHORT", 3, PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short");
        SHORT = r103;
        JvmPrimitiveType r104 = new JvmPrimitiveType("INT", 4, PrimitiveType.INT, "int", "I", "java.lang.Integer");
        INT = r104;
        JvmPrimitiveType r105 = new JvmPrimitiveType("FLOAT", 5, PrimitiveType.FLOAT, "float", FaceService.girlLabel, "java.lang.Float");
        FLOAT = r105;
        JvmPrimitiveType r106 = new JvmPrimitiveType("LONG", 6, PrimitiveType.LONG, "long", "J", "java.lang.Long");
        LONG = r106;
        JvmPrimitiveType r107 = new JvmPrimitiveType("DOUBLE", 7, PrimitiveType.DOUBLE, ItemStyle.ITEM_STYLE_DOUBLE, "D", "java.lang.Double");
        DOUBLE = r107;
        int r108 = 0;
        $VALUES = new JvmPrimitiveType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        TYPE_BY_NAME = new HashMap();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
        TYPE_BY_DESC = new HashMap();
        WRAPPER_CLASS_INTERNAL_NAMES = new HashSet();
        OWNER_TO_BOXING_METHOD_DESCRIPTOR = new HashMap();
        JvmPrimitiveType[] r109 = values();
        int r110 = r109.length;
    L3:
        if (r108 >= r110) goto L5;
        JvmPrimitiveType r111 = r109[r108];
        TYPE_BY_NAME.put(r111.getJavaKeywordName(), r111);
        TYPE_BY_PRIMITIVE_TYPE.put(r111.getPrimitiveType(), r111);
        TYPE_BY_DESC.put(r111.getDesc(), r111);
        String r112 = r111.wrapperFqName.asString().replace('.', '/');
        WRAPPER_CLASS_INTERNAL_NAMES.add(r112);
        OWNER_TO_BOXING_METHOD_DESCRIPTOR.put(r112, "(" + r111.desc + ")L" + r112 + i.f25853b);
        r108 = r108 + 1;
        goto L3
    }

    public static JvmPrimitiveType[] values() {
        return (JvmPrimitiveType[]) $VALUES.clone();
    }

    public String getDesc() {
        String r100 = this.desc;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r100;
    }

    public String getJavaKeywordName() {
        String r100 = this.name;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r100;
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType r100 = this.primitiveType;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r100;
    }

    public FqName getWrapperFqName() {
        FqName r100 = this.wrapperFqName;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r100;
    }

    public static JvmPrimitiveType get(String r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        JvmPrimitiveType r101 = TYPE_BY_NAME.get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new AssertionError("Non-primitive type name passed: " + r100);
    }

    public static JvmPrimitiveType valueOf(String r100) {
        return (JvmPrimitiveType) a.a(JvmPrimitiveType.class, r100);
    }

    public static JvmPrimitiveType get(PrimitiveType r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        JvmPrimitiveType r101 = TYPE_BY_PRIMITIVE_TYPE.get(r100);
        if (r101 != null) goto L7;
        $$$reportNull$$$0(6);
    L7:
        return r101;
    }

    private JvmPrimitiveType(String r100, int r101, PrimitiveType r102, String r103, String r104, String r105) {
        if (r102 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r103 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        if (r104 != null) goto L8;
        $$$reportNull$$$0(10);
    L8:
        if (r105 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        super(r100, r101);
        this.primitiveType = r102;
        this.name = r103;
        this.desc = r104;
        this.wrapperFqName = new FqName(r105);
    }
}

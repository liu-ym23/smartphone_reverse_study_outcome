package org.apache.commons.lang3;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class ClassUtils {
    public static final String INNER_CLASS_SEPARATOR = null;
    public static final String PACKAGE_SEPARATOR = null;
    private static final Map<String, String> abbreviationMap = null;
    private static final Map<String, Class<?>> namePrimitiveMap = null;
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = null;
    private static final Map<String, String> reverseAbbreviationMap = null;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = null;

    public static final enum Interfaces extends Enum<Interfaces> {
        private static final /* synthetic */ Interfaces[] $VALUES = null;
        public static final Interfaces EXCLUDE = null;
        public static final Interfaces INCLUDE = null;

        static {
            Interfaces r100 = new Interfaces("INCLUDE", 0);
            INCLUDE = r100;
            Interfaces r101 = new Interfaces("EXCLUDE", 1);
            EXCLUDE = r101;
            $VALUES = new Interfaces[]{r100, r101};
        }

        public static Interfaces[] values() {
            return (Interfaces[]) $VALUES.clone();
        }

        public static Interfaces valueOf(String r100) {
            return (Interfaces) a.a(Interfaces.class, r100);
        }

        private Interfaces(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        PACKAGE_SEPARATOR = String.valueOf('.');
        INNER_CLASS_SEPARATOR = String.valueOf(Typography.dollar);
        HashMap r100 = new HashMap();
        namePrimitiveMap = r100;
        Class r101 = Boolean.TYPE;
        r100.put("boolean", r101);
        r100.put("byte", Byte.TYPE);
        r100.put("char", Character.TYPE);
        r100.put("short", Short.TYPE);
        Class r102 = Integer.TYPE;
        r100.put("int", r102);
        Class r103 = Long.TYPE;
        r100.put("long", r103);
        r100.put(ItemStyle.ITEM_STYLE_DOUBLE, Double.TYPE);
        Class r110 = Float.TYPE;
        r100.put("float", r110);
        r100.put("void", Void.TYPE);
        HashMap r104 = new HashMap();
        primitiveWrapperMap = r104;
        r104.put(r101, Boolean.class);
        r104.put(Byte.TYPE, Byte.class);
        r104.put(Character.TYPE, Character.class);
        r104.put(Short.TYPE, Short.class);
        r104.put(r102, Integer.class);
        r104.put(r103, Long.class);
        r104.put(Double.TYPE, Double.class);
        r104.put(r110, Float.class);
        Class r105 = Void.TYPE;
        r104.put(r105, r105);
        wrapperPrimitiveMap = new HashMap();
        Iterator r106 = r104.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        Map.Entry r107 = (Map.Entry) r106.next();
        Class<?> r108 = (Class) r107.getKey();
        Class<?> r109 = (Class) r107.getValue();
        if (r108.equals(r109) == true) goto L4;
        wrapperPrimitiveMap.put(r109, r108);
        goto L4
    L8:
        HashMap r111 = new HashMap();
        r111.put("int", "I");
        r111.put("boolean", "Z");
        r111.put("float", FaceService.girlLabel);
        r111.put("long", "J");
        r111.put("short", ExifInterface.LATITUDE_SOUTH);
        r111.put("byte", "B");
        r111.put(ItemStyle.ITEM_STYLE_DOUBLE, "D");
        r111.put("char", "C");
        HashMap r112 = new HashMap();
        Iterator r113 = r111.entrySet().iterator();
    L10:
        if (r113.hasNext() == false) goto L12;
        Map.Entry r114 = (Map.Entry) r113.next();
        r112.put(r114.getValue(), r114.getKey());
        goto L10
    L12:
        abbreviationMap = Collections.unmodifiableMap(r111);
        reverseAbbreviationMap = Collections.unmodifiableMap(r112);
    }

    public static List<Class<?>> getAllInterfaces(Class<?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r101 = new LinkedHashSet();
        getAllInterfaces(r100, r101);
        return new ArrayList(r101);
    }

    public static String getShortClassName(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
        if (r100.startsWith("[") == true) goto L9;
    L19:
        int r103 = r100.lastIndexOf(46);
        if (r103 == (-1)) goto L23;
        r102 = r103 + 1;
    L23:
        int r104 = r100.indexOf(36, r102);
        String r105 = r100.substring(r103 + 1);
        if (r104 == (-1)) goto L27;
        r105 = r105.replace(Typography.dollar, '.');
    L27:
        return r105 + r101;
    L9:
        if (r100.charAt(0) != '[') goto L12;
        r100 = r100.substring(1);
        r101.append("[]");
        goto L9
    L12:
        if (r100.charAt(0) == 'L') goto L14;
    L16:
        Map<String, String> r106 = reverseAbbreviationMap;
        if (r106.containsKey(r100) == false) goto L19;
        r100 = r106.get(r100);
        goto L19
    L14:
        if (r100.charAt(r100.length() - 1) != ';') goto L16;
        r100 = r100.substring(1, r100.length() - 1);
        goto L16
    }

    public static boolean isPrimitiveWrapper(Class<?> r100) {
        return wrapperPrimitiveMap.containsKey(r100);
    }

    public static Class<?> primitiveToWrapper(Class<?> r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.isPrimitive() == true) goto L6;
        return r100;
    L6:
        return primitiveWrapperMap.get(r100);
    }

    public static Class<?> wrapperToPrimitive(Class<?> r100) {
        return wrapperPrimitiveMap.get(r100);
    }

    public static String getShortClassName(Class<?> r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return getShortClassName(r100.getName());
    }

    private static void getAllInterfaces(Class<?> r100, HashSet<Class<?>> r101) {
    L2:
        if (r100 == null) goto L10;
        Class<?>[] r102 = r100.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        Class<?> r105 = r102[r104];
        if (r101.add(r105) == false) goto L8;
        getAllInterfaces(r105, r101);
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r100 = r100.getSuperclass();
        goto L2
    }

    public static boolean isAssignable(Class<?> r100, Class<?> r101) {
        return isAssignable(r100, r101, true);
    }

    public static boolean isAssignable(Class<?> r100, Class<?> r101, boolean r102) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 == null) goto L8;
        if (r102 == false) goto L25;
        if (r100.isPrimitive() == false) goto L18;
        if (r101.isPrimitive() == true) goto L18;
        r100 = primitiveToWrapper(r100);
        if (r100 != null) goto L18;
        return false;
    L18:
        if (r101.isPrimitive() == false) goto L25;
        if (r100.isPrimitive() == true) goto L25;
        r100 = wrapperToPrimitive(r100);
        if (r100 != null) goto L25;
        return false;
    L25:
        if (r100.equals(r101) == false) goto L28;
        return true;
    L28:
        if (r100.isPrimitive() == false) goto L99;
        if (r101.isPrimitive() == true) goto L32;
        return false;
    L32:
        Class r103 = Integer.TYPE;
        if (r103.equals(r100) == true) goto L35;
        Class r104 = Long.TYPE;
        if (r104.equals(r100) == false) goto L51;
        if (Float.TYPE.equals(r101) == false) goto L47;
    L48:
        return true;
    L47:
        if (Double.TYPE.equals(r101) == true) goto L48;
        return false;
    L51:
        if (Boolean.TYPE.equals(r100) == false) goto L54;
        return false;
    L54:
        if (Double.TYPE.equals(r100) == false) goto L56;
        return false;
    L56:
        Class r105 = Float.TYPE;
        if (r105.equals(r100) == false) goto L61;
        return Double.TYPE.equals(r101);
    L61:
        if (Character.TYPE.equals(r100) == false) goto L73;
        if (r103.equals(r101) == false) goto L65;
    L70:
        return true;
    L65:
        if (r104.equals(r101) == true) goto L70;
        if (r105.equals(r101) == true) goto L70;
        if (Double.TYPE.equals(r101) == true) goto L70;
        return false;
    L73:
        if (Short.TYPE.equals(r100) == false) goto L85;
        if (r103.equals(r101) == false) goto L77;
    L82:
        return true;
    L77:
        if (r104.equals(r101) == true) goto L82;
        if (r105.equals(r101) == true) goto L82;
        if (Double.TYPE.equals(r101) == true) goto L82;
        return false;
    L85:
        if (Byte.TYPE.equals(r100) == true) goto L87;
        return false;
    L87:
        if (Short.TYPE.equals(r101) == false) goto L89;
    L96:
        return true;
    L89:
        if (r103.equals(r101) == true) goto L96;
        if (r104.equals(r101) == true) goto L96;
        if (r105.equals(r101) == true) goto L96;
        if (Double.TYPE.equals(r101) == true) goto L96;
        return false;
    L35:
        if (Long.TYPE.equals(r101) == false) goto L37;
    L40:
        return true;
    L37:
        if (Float.TYPE.equals(r101) == true) goto L40;
        if (Double.TYPE.equals(r101) == true) goto L40;
        return false;
    L99:
        return r101.isAssignableFrom(r100);
    L8:
        return !r101.isPrimitive();
    }
}

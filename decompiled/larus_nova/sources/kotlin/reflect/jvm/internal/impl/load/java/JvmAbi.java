package kotlin.reflect.jvm.internal.impl.load.java;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = null;
    public static final ClassId JVM_FIELD_ANNOTATION_CLASS_ID = null;
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = null;
    private static final ClassId REFLECTION_FACTORY_IMPL = null;
    private static final ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = null;

    private JvmAbi() {
    }

    static {
        INSTANCE = new JvmAbi();
        FqName r100 = new FqName("kotlin.jvm.JvmField");
        JVM_FIELD_ANNOTATION_FQ_NAME = r100;
        ClassId.Companion r101 = ClassId.Companion;
        JVM_FIELD_ANNOTATION_CLASS_ID = r101.topLevel(r100);
        REFLECTION_FACTORY_IMPL = r101.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = ClassId.Companion.fromString$default(r101, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }

    @JvmStatic
    public static final String getterName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "propertyName");
        if (startsWithIsPrefix(r100) == false) goto L6;
        return r100;
    L6:
        return MonitorConstants.CONNECT_TYPE_GET + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r100);
    }

    @JvmStatic
    public static final boolean isGetterName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (StringsKt.startsWith$default(r100, MonitorConstants.CONNECT_TYPE_GET, false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r100, "is", false, 2, null) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final boolean isSetterName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return StringsKt.startsWith$default(r100, "set", false, 2, null);
    }

    @JvmStatic
    public static final String setterName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "propertyName");
        StringBuilder r101 = new StringBuilder("set");
        if (startsWithIsPrefix(r100) == false) goto L5;
        String r102 = r100.substring(2);
    L6:
        r101.append(r102);
        return r101.toString();
    L5:
        r102 = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r100);
        goto L6
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (StringsKt.startsWith$default(r100, "is", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (r100.length() != 2) goto L8;
        return false;
    L8:
        char r101 = r100.charAt(2);
        if (Intrinsics.compare(97, r101) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.compare(r101, 122) > 0) goto L12;
        return false;
    }
}

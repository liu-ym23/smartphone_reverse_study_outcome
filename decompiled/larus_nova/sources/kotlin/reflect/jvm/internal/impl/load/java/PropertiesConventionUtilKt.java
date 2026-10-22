package kotlin.reflect.jvm.internal.impl.load.java;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String r101 = r100.asString();
        if (JvmAbi.isGetterName(r101) == false) goto L7;
        return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(r100));
    L7:
        if (JvmAbi.isSetterName(r101) == false) goto L11;
        return propertyNamesBySetMethodName(r100);
    L11:
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(r100);
    }

    public static final Name propertyNameByGetMethodName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Name r101 = propertyNameFromAccessorMethodName$default(r100, MonitorConstants.CONNECT_TYPE_GET, false, null, 12, null);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return propertyNameFromAccessorMethodName$default(r100, "is", false, null, 8, null);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        return CollectionsKt.listOfNotNull(new Name[]{propertyNameBySetMethodName(r100, false), propertyNameBySetMethodName(r100, true)});
    }

    public static final Name propertyNameBySetMethodName(Name r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        if (r101 == false) goto L5;
        String r102 = "is";
    L7:
        return propertyNameFromAccessorMethodName$default(r100, "set", false, r102, 4, null);
    L5:
        r102 = null;
        goto L7
    }

    private static final Name propertyNameFromAccessorMethodName(Name r100, String r101, boolean r102, String r103) {
        if (r100.isSpecial() == false) goto L5;
        return null;
    L5:
        String r104 = r100.getIdentifier();
        boolean r105 = false;
        if (StringsKt.startsWith$default(r104, r101, false, 2, null) == true) goto L9;
        return null;
    L9:
        if (r104.length() != r101.length()) goto L11;
        return null;
    L11:
        char r106 = r104.charAt(r101.length());
        if ('a' <= r106) goto L14;
    L16:
        if (r105 == false) goto L18;
        return null;
    L18:
        if (r103 != null) goto L20;
        if (r102 == true) goto L23;
        return r100;
    L23:
        String r107 = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(r104, r101), true);
        if (Name.isValidIdentifier(r107) == true) goto L27;
        return null;
    L27:
        return Name.identifier(r107);
    L20:
        return Name.identifier(r103 + StringsKt.removePrefix(r104, r101));
    L14:
        if (r106 >= '{') goto L16;
        r105 = true;
        goto L16
    }

    public static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name r100, String r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r103 = null;
    L9:
        return propertyNameFromAccessorMethodName(r100, r101, r102, r103);
    }
}

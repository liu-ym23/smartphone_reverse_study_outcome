package com.larksuite.framework.utils;

import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class ICUUtils {

    public static class FormatArgsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<UFormatPair> f285892a;

        public FormatArgsBuilder() {
            this.f285892a = new ArrayList();
        }

        public final void a(Integer r100) {
            UFormatPair r101 = new UFormatPair();
            r101.key = "num";
            r101.valueType = UValueType.UValue_Long;
            r101.intValue = r100.intValue();
            ((ArrayList) this.f285892a).add(r101);
        }

        public final void b(String r100, String r101) {
            UFormatPair r102 = new UFormatPair();
            r102.key = r100;
            r102.valueType = UValueType.UValue_String;
            r102.stringValue = r101;
            ((ArrayList) this.f285892a).add(r102);
        }
    }

    public static class UFormatPair {
        public double doubleValue;
        public int intValue;
        public String key;
        public long longValue;
        public String stringValue;
        public UValueType valueType;

        public UFormatPair() {
        }
    }

    public static final enum UValueType extends Enum<UValueType> {
        public static final UValueType UValue_Date = null;
        public static final UValueType UValue_Double = null;
        public static final UValueType UValue_Int64 = null;
        public static final UValueType UValue_Long = null;
        public static final UValueType UValue_String = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UValueType[] f285893a = null;

        static {
            UValueType r100 = new UValueType("UValue_Date", 0);
            UValue_Date = r100;
            UValueType r101 = new UValueType("UValue_Double", 1);
            UValue_Double = r101;
            UValueType r102 = new UValueType("UValue_Long", 2);
            UValue_Long = r102;
            UValueType r103 = new UValueType("UValue_String", 3);
            UValue_String = r103;
            UValueType r104 = new UValueType("UValue_Int64", 4);
            UValue_Int64 = r104;
            f285893a = new UValueType[]{r100, r101, r102, r103, r104};
        }

        public static UValueType[] values() {
            return (UValueType[]) f285893a.clone();
        }

        public static UValueType valueOf(String r100) {
            return (UValueType) r27.a.a(UValueType.class, r100);
        }

        public UValueType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ICUUtils() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native String icuFormat(String r100, String r101, List<UFormatPair> r102);

    static {
        INVOKESTATIC_com_larksuite_framework_utils_ICUUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("icu_lark");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_larksuite_framework_utils_ICUUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static String getLangCode(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return r100.getResources().getConfiguration().getLocales().get(0).toLanguageTag();
    L6:
        return r100.getResources().getConfiguration().locale.toLanguageTag();
    }

    public static String icuFormat(String r100, List<UFormatPair> r101) {
        return icuFormat(getLangCode(b.f285948a), r100, r101);
    }

    public static String icuFormat(String r100, String r101, Double r102) {
        String r103 = getLangCode(b.f285948a);
        FormatArgsBuilder r104 = new FormatArgsBuilder();
        UFormatPair r105 = new UFormatPair();
        r105.key = r101;
        r105.valueType = UValueType.UValue_Double;
        r105.doubleValue = r102.doubleValue();
        ((ArrayList) r104.f285892a).add(r105);
        return icuFormat(r103, r100, r104.f285892a);
    }

    public static String icuTimeFormat(String r100, String r101, Double r102) {
        String r103 = getLangCode(b.f285948a);
        FormatArgsBuilder r104 = new FormatArgsBuilder();
        UFormatPair r105 = new UFormatPair();
        r105.key = r101;
        r105.valueType = UValueType.UValue_Date;
        r105.doubleValue = r102.doubleValue();
        ((ArrayList) r104.f285892a).add(r105);
        return icuFormat(r103, r100, r104.f285892a);
    }

    public static String icuFormat(String r100, String r101, Long r102) {
        String r103 = getLangCode(b.f285948a);
        FormatArgsBuilder r104 = new FormatArgsBuilder();
        UFormatPair r105 = new UFormatPair();
        r105.key = r101;
        r105.valueType = UValueType.UValue_Int64;
        r105.longValue = r102.longValue();
        ((ArrayList) r104.f285892a).add(r105);
        return icuFormat(r103, r100, r104.f285892a);
    }

    public static String icuFormat(String r100, String r101, String r102) {
        String r103 = getLangCode(b.f285948a);
        FormatArgsBuilder r104 = new FormatArgsBuilder();
        r104.b(r101, r102);
        return icuFormat(r103, r100, r104.f285892a);
    }
}

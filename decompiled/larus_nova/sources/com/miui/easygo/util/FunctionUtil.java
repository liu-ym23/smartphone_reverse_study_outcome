package com.miui.easygo.util;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.miui.easygo.sdk.module.EasyGoServer;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes32.dex */
class FunctionUtil extends DatabaseUtil {
    private static final String TAG = "FunctionUtil";

    public FunctionUtil() {
    }

    public static boolean isAidlSupport(EasyGoServer r100) {
        String r101 = r100.getServiceVersion();
        if (BaseUtil.isNullOrEmpty(new String[]{r101}) == false) goto L18;
        return false;
    L18:
        String[] r102 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L12 NumberFormatException -> L15
        String[] r103 = "1.0".split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L12 NumberFormatException -> L15
        if (r102.length == 2) goto L8;
        return false;
    L8:
        if (CastIntegerProtector.parseUnsignedInt(r102[0]) <= CastIntegerProtector.parseUnsignedInt(r103[0])) goto L11;
        return false;
    L11:
        return true;
    L15:
        e = move-exception;
        e.getMessage();
        return false;
    L12:
        e = move-exception;
        e.getMessage();
        return false;
    }

    public static boolean isLibSupprt(String r100) {
        if (BaseUtil.isNullOrEmpty(new String[]{r100}) == false) goto L24;
        return false;
    L24:
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        String[] r102 = EasyGoConstant.LIB_SUPPORT_AAR_VERSION.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        if (r101.length != 3) goto L8;
        int r103 = CastIntegerProtector.parseUnsignedInt(r102[0]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r104 = CastIntegerProtector.parseUnsignedInt(r102[1]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r105 = CastIntegerProtector.parseUnsignedInt(r101[0]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r106 = CastIntegerProtector.parseUnsignedInt(r101[1]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        if (r105 > r103) goto L12;
        if (r105 != r103) goto L17;
        if (r106 <= r104) goto L17;
        return false;
    L17:
        return true;
    L12:
        return false;
    L8:
        return false;
    L21:
        e = move-exception;
        e.getMessage();
        return false;
    L18:
        e = move-exception;
        e.getMessage();
        return false;
    }

    public static EasyGoServer getFunctionInfo(Context r100, String r101) {
        return DatabaseUtil.queryServerInfo(r100, r101);
    }
}

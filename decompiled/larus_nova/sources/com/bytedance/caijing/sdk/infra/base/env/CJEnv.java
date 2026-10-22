package com.bytedance.caijing.sdk.infra.base.env;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.env.ICJDeviceHelper;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CJEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f202288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f202289b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f202290c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f202291d = 0;

    static {
        f202288a = -1;
        f202289b = LazyKt.lazy(CJEnv$hostService$2.INSTANCE);
        f202290c = LazyKt.lazy(CJEnv$cjDeviceHelper$2.INSTANCE);
        f202291d = ISmModel.VERSION_0700;
    }

    public static CJHostService f() {
        return (CJHostService) f202289b.getValue();
    }

    @JvmStatic
    public static final long l() {
        long r100 = f202288a;
        if (r100 < 0) goto L75;
        return r100;
    L75:
        String r101 = k();     // Catch: Exception -> L70
        int r102 = 0;
        if (StringsKt.contains$default(r101, "-", false, 2, null) == false) goto L20;
        List<String> r103 = new Regex("-").split(r101, 0);     // Catch: Exception -> L70
        if (r103.isEmpty() == true) goto L18;
        ListIterator<String> r104 = r103.listIterator(r103.size());     // Catch: Exception -> L70
    L11:
        if (r104.hasPrevious() == false) goto L18;
        if (r104.previous().length() != 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L11;
        List r106 = CollectionsKt.take(r103, r104.nextIndex() + 1);     // Catch: Exception -> L70
    L19:
        r101 = ((String[]) r106.toArray(new String[0]))[0];     // Catch: Exception -> L70
        goto L20
    L15:
        r105 = false;
    L18:
        r106 = CollectionsKt.emptyList();     // Catch: Exception -> L70
    L20:
        List<String> r107 = new Regex(EasyGoConstant.VERSION_SEPARATIVE_SIGN).split(r101, 0);     // Catch: Exception -> L70
        if (r107.isEmpty() == true) goto L31;
        ListIterator<String> r108 = r107.listIterator(r107.size());     // Catch: Exception -> L70
    L24:
        if (r108.hasPrevious() == false) goto L31;
        if (r108.previous().length() != 0) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == true) goto L24;
        List r110 = CollectionsKt.take(r107, r108.nextIndex() + 1);     // Catch: Exception -> L70
    L32:
        String[] r111 = (String[]) r110.toArray(new String[0]);     // Catch: Exception -> L70
        if (r111.length == 4) goto L73;
        f202288a = 0;     // Catch: Exception -> L70
        return 0;
    L73:
        int r112 = CastIntegerProtector.parseInt(r111[0]);     // Catch: Exception -> L69
        if (r112 < 0) goto L41;
        if (r112 > 99) goto L41;
    L42:
        int r113 = ((r112 * 100) * 100) * 1000;
        int r114 = CastIntegerProtector.parseInt(r111[1]);     // Catch: Exception -> L68
        if (r114 < 0) goto L47;
        if (r114 > 99) goto L47;
    L48:
        int r115 = (r114 * 100) * 1000;
        int r116 = CastIntegerProtector.parseInt(r111[2]);     // Catch: Exception -> L67
        if (r116 < 0) goto L53;
        if (r116 > 99) goto L53;
    L54:
        int r117 = r116 * 1000;
        int r118 = CastIntegerProtector.parseInt(r111[3]);     // Catch: Exception -> L66
        if (r118 < 0) goto L63;
        if (r118 > 999) goto L63;
        r102 = r118;
    L63:
        f202288a = ((r113 + r115) + r117) + r102;     // Catch: Exception -> L70
    L53:
        r116 = 0;
    L47:
        r114 = 0;
    L41:
        r112 = 0;
        goto L42
    L28:
        r109 = false;
    L31:
        r110 = CollectionsKt.emptyList();     // Catch: Exception -> L70
    L65:
        return f202288a;
    }

    @JvmStatic
    public static final boolean q() {
        ICJDeviceHelper r100 = (ICJDeviceHelper) f202290c.getValue();
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isPad());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final Application a() {
        return f().getHostApplication();
    }

    @JvmStatic
    public static final String b() {
        return f().getHostChannel();
    }

    @JvmStatic
    public static final String c() {
        return f().getDeviceId();
    }

    @JvmStatic
    public static final float d() {
        return f().getFontScale();
    }

    @JvmStatic
    public static final String e() {
        return f().getHostAid();
    }

    @JvmStatic
    public static final int g() {
        return f().getHostUpdateVersionCode();
    }

    @JvmStatic
    public static final String h() {
        return f().getHostUserId();
    }

    @JvmStatic
    public static final String i() {
        return f().getHostVersionName();
    }

    @JvmStatic
    public static final INetEnv j() {
        CJHostService r100 = f();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNetEnvHelper();
    }

    @JvmStatic
    public static final String k() {
        int r100 = f().getPluginVersion();
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        String r101 = "8.1.7.0-p" + r100;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        return "7.3.5.0-mock";
    }

    @JvmStatic
    public static final String m() {
        String r100 = k();
        return CollectionsKt.joinToString$default(CollectionsKt.take(StringsKt.split$default((String) CollectionsKt.first(StringsKt.split$default(r100, new String[]{"-"}, false, 0, 6, null)), new String[]{"."}, false, 0, 6, null), 3), ".", null, null, 0, null, null, 62, null);
    L5:
        CJLogger.b("", "getSdkVersionName3Digit error");
        return r100;
    }

    @JvmStatic
    public static final boolean n() {
        if (p() == false) goto L5;
    L8:
        return true;
    L5:
        if (f().hostIsDebug() == true) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean o() {
        return f().isFollowSystemTheme();
    }

    @JvmStatic
    public static final boolean p() {
        return f().isLocalTestChannel();
    }
}

package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
@GeckoRegister(boeAccessKey = "73a366492b309d791bb8ee3c911e4d67", prodAccessKey = "5732db7721bbec6f51a3dde6714837a2", testAccessKey = "790726a9aad935da182d7f2de6d4140e")
public final class n implements IGeckoRegister {

    public static final class a {
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b implements OptionCheckUpdateParams.CustomValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f271350a = null;

        static {
            f271350a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
        public final Object getValue() {
            int r100 = com.bytedance.ug.sdk.luckycat.utils.g.f271565a;
            Matcher r101 = PatternProtector.compile("^([0-9]{1,2})\\.([0-9]{1,2})\\.([0-9]{1,2})-").matcher("8.75.0-rc.12-db");     // Catch: Throwable -> L7
            if (r101.find() == false) goto L9;
            return r101.group(1) + "." + r101.group(2) + "." + r101.group(3);
        L9:
            return "88.88.88";
        L7:
            th = move-exception;
            th.toString();
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class c implements OptionCheckUpdateParams.CustomValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f271351a = null;

        static {
            f271351a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
        public final Object getValue() {
            boolean r100 = zl7.b.f572790a;
            return Integer.valueOf(zl7.b.a(m.a.f271349a.f()) ? 1 : 0);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class d implements OptionCheckUpdateParams.CustomValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f271352a = null;

        static {
            f271352a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
        public final Object getValue() {
            return Integer.valueOf(m.a.f271349a.g());
        }
    }

    static {
    }

    public n() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public final Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        LuckyCatSettingsManger r101 = LuckyCatSettingsManger.b.f271283a;
        r101.getClass();
        Object r102 = r101.c(new String[]{"common", "enable_gecko_register"});
        boolean r103 = true;
        if ((r102 instanceof Boolean) == false) goto L5;
        boolean r104 = ((Boolean) r102).booleanValue();
    L6:
        if (r104 == false) goto L8;
        r100.put("lucky_sdk_version", b.f271350a);
    L8:
        r101.getClass();
        Object r105 = r101.c(new String[]{"common", "enable_gecko_pass_is_build_32"});
        if ((r105 instanceof Boolean) == false) goto L11;
        r103 = ((Boolean) r105).booleanValue();
    L11:
        if (r103 == false) goto L13;
        r100.put("is_build_32", c.f271351a);
    L13:
        r100.put("lucky_app_id", d.f271352a);
        return r100;
    L5:
        r104 = true;
        goto L6
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public final String registerRootDir(Context r100) {
        if (r100 != null) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.a("luckycat_gecko_register", "context is null");
        return "";
    L6:
        return new PolarisFileWrapper(r100.getFilesDir(), "luckycat_gecko_root_dir").getAbsolutePath();
    }
}

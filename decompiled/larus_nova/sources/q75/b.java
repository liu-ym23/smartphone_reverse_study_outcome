package q75;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531970a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a() {
            if (AppInfoUtils.f().booleanValue() == false) goto L5;
            tt5.a.h("DriveComponent", "isWpsPreviewHostEnabled() isOfficeSdk=true, WpsEnable=false");
            boolean r100 = false;
        L6:
            if (r100 == true) goto L9;
            tt5.a.h("DriveComponent", "getWpsEnable() WpsPreviewHost=false");
            return false;
        L9:
            b0 r101 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
            if (((k) org.koin.java.a.c(k.class, null, null, 6)).isUsPackage() == false) goto L14;
            boolean r102 = c.a.f206237a.i("spacekit.mobile.wps_enable", false);
            tt5.a.h("DriveComponent", "getWpsEnable() isUsPackage, WpsEnable=" + r102);
            return r102;
        L14:
            if (r101.f() == false) goto L16;
        L19:
            boolean r103 = c.a.f206237a.i("spacekit.mobile.wps_enable", false);
            tt5.a.h("DriveComponent", "getWpsEnable() is ka and notOverseaTenantBrand, WpsEnable=" + r103);
            return r103;
        L16:
            if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == false) goto L19;
            tt5.a.h("DriveComponent", "getWpsEnable() is not ka and notOverseaTenantBrand, WpsEnable=true");
            return true;
        L5:
            tt5.a.h("DriveComponent", "isWpsPreviewHostEnabled() isOfficeSdk=false, WpsEnable=true");
            r100 = true;
            goto L6
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(String r100) {
        c r101 = c.a.f206237a;
        if (r101.f("spacekit.mobile.drive_wps_center_version_enable") == true) goto L5;
    L14:
        tt5.a.h("DriveComponent", "isSupportWpsAndEt() = false, FG is disable");
    L15:
        return false;
    L5:
        if (a.a() == false) goto L14;
        boolean r102 = r101.f("ccm.drive.wps_support_wps_and_et");
        tt5.a.h("DriveComponent", "isSupportWpsAndEt() = " + r102);
        if (r102 == false) goto L15;
        if ("wps".equalsIgnoreCase(r100) == false) goto L12;
    L13:
        return true;
    L12:
        if ("et".equalsIgnoreCase(r100) == false) goto L15;
        goto L13
    }
}

package j43;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.skubuy.platform.helper.AppInfos;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f497353a = 0;

    static {
        f497353a = k.r(ECAppInfoService.f48114e.getAppId(), 1128);
    }

    public static int a() {
        AppInfos.a r100 = AppInfos.Companion;
        int r101 = f497353a;
        r100.getClass();
        AppInfos[] r102 = AppInfos.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        AppInfos r105 = r102[r104];
        if (r105.getAid() != r101) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 != null) goto L18;
        return 2;
    L18:
        return r105.getBType();
    L7:
        r106 = false;
        goto L8
    L11:
        r105 = null;
        goto L12
    }

    @JvmStatic
    public static final String b() {
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getWebcastAppId();
    }
}

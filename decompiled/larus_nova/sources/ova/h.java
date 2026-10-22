package ova;

import com.ss.android.lark.applink.AppLinkHostSetting;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set<String> f526968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<String> f526969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f526970c = null;

    static {
        AppLinkHostSetting r100 = (AppLinkHostSetting) SettingManager.getInstance().get(AppLinkHostSetting.class);
        if (r100 == null) goto L5;
        List<String> r101 = r100.a();
    L6:
        f526970c = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}

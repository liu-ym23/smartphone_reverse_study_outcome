package ui5;

import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground.permission.setting.appsetting.ShareWithPasswordConfig;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550207a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a() {
        boolean r100 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).f();
        ShareWithPasswordConfig r101 = (ShareWithPasswordConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("docs_folder_ShareWithPasswordEnable", ShareWithPasswordConfig.class, new ShareWithPasswordConfig(r100));
        if (r101 == null) goto L7;
        return r101.isDoc_enable();
    L7:
        return !r100;
    }

    @JvmStatic
    public static final boolean b() {
        boolean r100 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).f();
        ShareWithPasswordConfig r101 = (ShareWithPasswordConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("docs_folder_ShareWithPasswordEnable", ShareWithPasswordConfig.class, new ShareWithPasswordConfig(r100));
        if (r101 == null) goto L7;
        return r101.isFolder_enable();
    L7:
        return !r100;
    }
}

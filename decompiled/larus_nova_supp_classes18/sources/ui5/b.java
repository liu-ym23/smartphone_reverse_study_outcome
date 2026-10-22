package ui5;

import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground.permission.setting.appsetting.ShareWithPasswordConfig;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a() {
        boolean r0 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).f();
        ShareWithPasswordConfig r1 = (ShareWithPasswordConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("docs_folder_ShareWithPasswordEnable", ShareWithPasswordConfig.class, new ShareWithPasswordConfig(r0));
        if (r1 == null) goto L7;
        return r1.isDoc_enable();
    L7:
        return !r0;
    }

    @JvmStatic
    public static final boolean b() {
        boolean r0 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).f();
        ShareWithPasswordConfig r1 = (ShareWithPasswordConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("docs_folder_ShareWithPasswordEnable", ShareWithPasswordConfig.class, new ShareWithPasswordConfig(r0));
        if (r1 == null) goto L7;
        return r1.isFolder_enable();
    L7:
        return !r0;
    }
}

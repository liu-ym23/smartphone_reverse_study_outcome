package com.bytedance.ies.bullet.secure;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@GeckoRegister(boeAccessKey = "afe58e0f6709cd80a6524f309678f67d", prodAccessKey = "d8feacce0eae150c8140e5c435ccbbda", testAccessKey = "e1927d8fdbbf6786914e8ca27307104b")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusSdkGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerCustomParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "registerRootDir", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ArgusSdkGeckoAppRegister implements IGeckoRegister {
    public static final String BOE_ACCESS_KEY = "afe58e0f6709cd80a6524f309678f67d";
    public static final a Companion = null;
    public static final String DIR_NAME = "offlineX";
    public static final String ONLINE_ACCESS_KEY = "d8feacce0eae150c8140e5c435ccbbda";
    public static final String TEST_ACCESS_KEY = "e1927d8fdbbf6786914e8ca27307104b";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements OptionCheckUpdateParams.CustomValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f247732a = null;

        static {
            f247732a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
        public final Object getValue() {
            return "10.4.0";
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("business_version", b.f247732a);
        return r100;
    }

    public ArgusSdkGeckoAppRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        return com.bytedance.geckox.b.a.f245076a.getContext().getFilesDir().getAbsolutePath() + File.separator + "offlineX";
    }
}

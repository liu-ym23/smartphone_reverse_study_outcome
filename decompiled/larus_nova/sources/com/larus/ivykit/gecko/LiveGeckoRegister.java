package com.larus.ivykit.gecko;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import pg9.f;

/* JADX INFO: loaded from: classes30.dex */
@GeckoRegister(boeAccessKey = "", prodAccessKey = "5fb33cde3ebff01c8433ddc22aac0816", testAccessKey = "36723dc3e85a23e701d1697d57de07ed")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/ivykit/gecko/LiveGeckoRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "<init>", "()V", "registerCustomParams", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerRootDir", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveGeckoRegister implements IGeckoRegister {
    public LiveGeckoRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        f.f529216a.getClass();
        return rx7.f.c();
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        return f.f529216a.f(r100);
    }
}

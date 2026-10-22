package com.larus.ivykit.gecko;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import pg9.h;
import rx7.f;

/* JADX INFO: loaded from: classes30.dex */
@GeckoRegister(boeAccessKey = "", prodAccessKey = "87ec37efe80e501744cad5d3fa51c9fc", testAccessKey = "32e600d864177a201bd545b3bbd8791f")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/ivykit/gecko/ObricGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "<init>", "()V", "registerCustomParams", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerRootDir", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricGeckoAppRegister implements IGeckoRegister {
    public ObricGeckoAppRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        h.f529218a.getClass();
        return f.c();
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        return h.f529218a.f(r100);
    }
}

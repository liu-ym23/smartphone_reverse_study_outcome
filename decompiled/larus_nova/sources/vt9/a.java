package vt9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.ASRStrengthenConfig;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public a() {
    }

    public static ASRStrengthenConfig a() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        ASRStrengthenConfig.Companion.getClass();
        return ASRStrengthenConfig.access$getV0$cp();
    L5:
        ASRStrengthenConfig.Companion.getClass();
        return ASRStrengthenConfig.access$getV1_CN$cp();
    }
}

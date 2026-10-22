package com.ss.android.lark.chameleon;

import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/IMonitorDependency;", "", "getBizParams", "", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMonitorDependency {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Map<String, Object> getBizParams(IMonitorDependency r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "host");
            return null;
        }
    }

    Map<String, Object> getBizParams(ChameleonPluginHost r100);
}

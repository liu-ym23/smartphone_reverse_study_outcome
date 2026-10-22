package com.ss.android.lark.chameleon.pluginapi;

import com.bytedance.ee.bear.browser.plugin.i;
import com.ss.android.lark.chameleon.ChameleonConfig;
import kotlin.Metadata;
import vv4.m;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ChameleonContextAbility;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "getUrl", "", "getSession", "getWebService", "P", "Lcom/bytedance/ee/bear/browser/WebService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChameleonContextAbility extends i {
    ChameleonConfig getChameleonConfig();

    String getSession();

    String getUrl();

    <P extends m> P getWebService(Class<P> r100);
}

package com.volcengine.zeus.plugin;

import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/volcengine/zeus/plugin/PluginMigrationHandlerFactory;", XmlPullParser.NO_NAMESPACE, "create", "Lcom/volcengine/zeus/plugin/PluginMigrationHandler;", "pluginPkg", XmlPullParser.NO_NAMESPACE, "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public interface PluginMigrationHandlerFactory {
    PluginMigrationHandler create(String r1);
}

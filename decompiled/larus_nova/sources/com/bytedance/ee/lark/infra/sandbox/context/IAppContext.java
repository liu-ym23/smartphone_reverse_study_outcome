package com.bytedance.ee.lark.infra.sandbox.context;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.tt.refer.common.base.AppType;
import fs5.c;
import i18.d;
import j18.b;
import jz7.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface IAppContext {
    void bindAppContainer(b r100);

    void bindDependAppContext(String r100, IAppContext r101);

    void destroy();

    <T extends c> T findService(Class<T> r100);

    <T extends IBaseService> T findServiceByInterface(Class<T> r100);

    LKOpenApiAccessConfig getApiAccessConfig();

    b getAppContainer();

    String getAppId();

    String getAppIdentify();

    AppType getAppType();

    Context getApplicationContext();

    BizType getBizType();

    IAppContext getBoundDependAppContext(String r100, String r101);

    i18.c getBridgeContext();

    String getContainerType();

    Activity getCurrentActivity();

    b getCurrentNode();

    int getCurrentTheme();

    a getDefaultPluginContainer();

    <T> T getExtra();

    <T> T getExtra(String r100);

    fs5.b getGadgetInteractiveProxy();

    String getTraceId();

    OPTrace getTracingSpan();

    void initTrace();

    boolean isDestroyed();

    boolean isDestroying();

    boolean isEmbedContainer();

    boolean isNewContainer();

    boolean isPanelContainer();

    boolean isPanelOrEmbedContainer();

    boolean needClearTempDir();

    <T> void putExtra(String r100, T r101);

    void putExtras(fs5.a r100);

    void registerService(Class r100, c r101);

    <T extends IBaseService> boolean registerService(Class<T> r100, T r101);

    void removeExtra(String r100);

    LKBasePluginResult sendEvent(LKEvent r100);

    LKBasePluginResult sendEvent(String r100);

    LKBasePluginResult sendEvent(String r100, JSONObject r101);

    LKBasePluginResult sendEvent(String r100, JSONObject r101, j18.c r102);

    void sendEvent(String r100, Bundle r101);

    void setApiAccessConfig(LKOpenApiAccessConfig r100);

    void setAppId(String r100);

    void setAppIdentify(String r100);

    void setContainerType(String r100);

    void setCurrentActivity(Activity r100);

    void setCurrentTheme(int r100);

    void setDefaultPluginContainer(a r100);

    void setExtra(Object r100);

    void setGadgetInteractiveProxy(fs5.b r100);

    void setNeedClearTempDir(boolean r100);

    void setTracingSpan(OPTrace r100);

    void startActivityForResult(Intent r100, int r101);

    void startDestroy();

    void unBindDependAppContext(String r100, IAppContext r101);

    void unRegisterOnResultAllPlugin();

    void unRegisterOnResultPlugin(d r100);
}

package com.bytedance.ee.bear.lark.dependency;

import com.larksuite.framework.callback.UIGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IMiraDependency {

    public static abstract class UIGetPluginCallback<Data> extends UIGetDataCallback<Data> {
        public abstract void onPluginLoading();

        public UIGetPluginCallback() {
        }
    }
}

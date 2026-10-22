package com.larksuite.component.openplatform.plugins.config;

import android.text.TextUtils;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.bytedance.ee.lark.plugin_annotation.bean.PluginEnv;
import com.bytedance.ee.lark.plugin_annotation.bean.Scope;
import i18.d;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class LKPluginConfig implements Serializable {
    private List<String> mEventList;
    public d mLkPlugin;
    public List<LKOpenApiAccessConfig> mOpenConditions;
    public LKOpenApiBizDomain mOwner;
    public String mPluginClassName;
    public PluginEnv mPluginEnv;
    public Scope mScope;

    public static /* synthetic */ class a {
    }

    public static class b {
    }

    public boolean configInvalid() {
        if (TextUtils.isEmpty(this.mPluginClassName) == true) goto L5;
    L6:
        List<String> r100 = this.mEventList;
        if (r100 != null) goto L9;
    L12:
        return true;
    L9:
        if (r100.isEmpty() == true) goto L12;
        return false;
    L5:
        if (this.mLkPlugin == null) goto L12;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("LKPluginConfig{mLkPlugin=");
        d r101 = this.mLkPlugin;
        if (r101 == null) goto L5;
        String r102 = r101.getClass().getName();
    L6:
        r100.append(r102);
        r100.append(", mPluginClassName='");
        r100.append(this.mPluginClassName);
        r100.append("', mOwner=");
        r100.append(this.mOwner);
        r100.append(", mOpenConditions=");
        r100.append(this.mOpenConditions);
        r100.append(", mScope=");
        r100.append(this.mScope);
        r100.append(", mEventList=");
        r100.append(this.mEventList);
        r100.append(", mPluginEnv=");
        r100.append(this.mPluginEnv);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    public List<String> getEventList() {
        return this.mEventList;
    }

    public LKPluginConfig(b r100, a r101) {
        this.mOwner = LKOpenApiBizDomain.OPEN_PLATFORM;
        throw null;
    }
}

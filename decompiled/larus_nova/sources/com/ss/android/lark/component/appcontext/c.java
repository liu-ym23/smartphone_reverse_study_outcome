package com.ss.android.lark.component.appcontext;

import android.app.Application;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements ILarkAppContext {
    public c() {
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final b8b.a appIdInfo() {
        return ((b) AppContextDependencyProvider.f417275a.getValue()).getAppId();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final LarkBuildConfig buildConfig() {
        return ((b) AppContextDependencyProvider.f417275a.getValue()).getBuildConfig();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext, com.ss.android.lark.component.appcontext.a
    public Application getContext() {
        return ((b) AppContextDependencyProvider.f417275a.getValue()).getContext();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final b8b.b releaseInfo() {
        return ((b) AppContextDependencyProvider.f417275a.getValue()).getReleaseInformation();
    }
}

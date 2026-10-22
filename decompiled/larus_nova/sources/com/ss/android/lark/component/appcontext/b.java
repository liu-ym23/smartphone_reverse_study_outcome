package com.ss.android.lark.component.appcontext;

import android.app.Application;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    b8b.a getAppId();

    LarkBuildConfig getBuildConfig();

    Application getContext();

    b8b.b getReleaseInformation();
}

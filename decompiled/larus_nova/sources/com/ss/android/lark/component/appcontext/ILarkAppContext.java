package com.ss.android.lark.component.appcontext;

import android.app.Application;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "Lcom/ss/android/lark/component/appcontext/IAppContext;", "buildConfig", "Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "appIdInfo", "Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "releaseInfo", "Lcom/ss/android/lark/component/appcontext/model/ReleaseInfo;", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkAppContext extends a {
    b8b.a appIdInfo();

    LarkBuildConfig buildConfig();

    @Override // com.ss.android.lark.component.appcontext.a
    /* synthetic */ Application getContext();

    b8b.b releaseInfo();
}

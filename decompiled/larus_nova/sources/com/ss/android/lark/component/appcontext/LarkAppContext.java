package com.ss.android.lark.component.appcontext;

import android.app.Application;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/component/appcontext/LarkAppContext;", "Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "<init>", "()V", "appIdInfo", "Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "buildConfig", "Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "getContext", "Landroid/app/Application;", "releaseInfo", "Lcom/ss/android/lark/component/appcontext/model/ReleaseInfo;", "Companion", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkAppContext implements ILarkAppContext {
    public static final a Companion = null;
    private static ILarkAppContext instance;
    private final /* synthetic */ c $$delegate_0;

    public static final class a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public b8b.a appIdInfo() {
        return this.$$delegate_0.appIdInfo();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public LarkBuildConfig buildConfig() {
        return this.$$delegate_0.buildConfig();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext, com.ss.android.lark.component.appcontext.a
    public Application getContext() {
        return this.$$delegate_0.getContext();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public b8b.b releaseInfo() {
        return this.$$delegate_0.releaseInfo();
    }

    static {
        Companion = new a();
        instance = new LarkAppContext();
    }

    @JvmStatic
    public static final ILarkAppContext inst() {
        Companion.getClass();
        return access$getInstance$cp();
    }

    private LarkAppContext() {
        this.$$delegate_0 = new c();
    }

    public static final /* synthetic */ ILarkAppContext access$getInstance$cp() {
        return instance;
    }
}

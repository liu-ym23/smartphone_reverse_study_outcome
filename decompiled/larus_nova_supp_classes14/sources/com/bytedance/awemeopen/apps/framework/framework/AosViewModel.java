package com.bytedance.awemeopen.apps.framework.framework;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import y54.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class AosViewModel extends ViewModel {
    private final Application application;

    public AosViewModel() {
        this.application = a.a();
    }

    public final Application getApplication() {
        return this.application;
    }
}

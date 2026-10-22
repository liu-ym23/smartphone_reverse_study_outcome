package com.ss.android.lark.picker.config;

import androidx.core.app.NotificationCompat;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.picker.Dependency;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/config/NavPickerConfig;", "Lcom/ss/android/lark/picker/config/PickerConfig;", "dependency", "Lcom/ss/android/lark/picker/Dependency;", ComplianceResult.JsonKey.PERMISSIONS, "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/Dependency;Lcom/ss/android/lark/picker/config/Permissions;)V", "navigationConfig", "Lcom/ss/android/lark/picker/config/NavigationConfig;", "getNavigationConfig", "()Lcom/ss/android/lark/picker/config/NavigationConfig;", "setNavigationConfig", "(Lcom/ss/android/lark/picker/config/NavigationConfig;)V", NotificationCompat.CATEGORY_NAVIGATION, "", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavPickerConfig extends PickerConfig {
    private NavigationConfig navigationConfig;

    public final NavigationConfig getNavigationConfig() {
        return this.navigationConfig;
    }

    public final void navigation(Function1<? super NavigationConfig, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        NavigationConfig r101 = new NavigationConfig();
        this.navigationConfig = r101;
        r100.invoke(r101);
    }

    public final void setNavigationConfig(NavigationConfig r100) {
        this.navigationConfig = r100;
    }

    public NavPickerConfig(Dependency r100, Permissions r101) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        super(r100, r101);
    }
}

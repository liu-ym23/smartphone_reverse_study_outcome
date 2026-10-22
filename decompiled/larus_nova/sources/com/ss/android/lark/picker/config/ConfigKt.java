package com.ss.android.lark.picker.config;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.Dependency;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b\u001a/\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "dependency", "Lcom/ss/android/lark/picker/Dependency;", ComplianceResult.JsonKey.PERMISSIONS, "Lcom/ss/android/lark/picker/config/Permissions;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "navPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "picker_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ConfigKt {
    private static final String TAG = "Picker_Config";

    public static final NavPickerConfig navPickerConfig(Dependency r100, Permissions r101, Function1<? super NavPickerConfig, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "init");
        NavPickerConfig r103 = new NavPickerConfig(r100, r101);
        r102.invoke(r103);     // Catch: Throwable -> L5
    L7:
        return r103;
    L5:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        goto L7
    }

    public static final PickerConfig pickerConfig(Dependency r100, Permissions r101, Function1<? super PickerConfig, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "init");
        PickerConfig r103 = new PickerConfig(r100, r101);
        r102.invoke(r103);     // Catch: Throwable -> L5
    L7:
        return r103;
    L5:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        goto L7
    }
}

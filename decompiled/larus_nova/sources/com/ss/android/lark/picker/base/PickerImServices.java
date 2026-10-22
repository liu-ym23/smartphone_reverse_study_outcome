package com.ss.android.lark.picker.base;

import com.ss.android.lark.im.sdk.service.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerImServices;", "", "<init>", "()V", "TAG", "", "chatterService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "getChatterService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "chatterService$delegate", "Lkotlin/Lazy;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerImServices {
    public static final PickerImServices INSTANCE = null;
    private static final String TAG = "PickerImServices";
    private static final Lazy chatterService$delegate = null;

    private PickerImServices() {
    }

    static {
        INSTANCE = new PickerImServices();
        chatterService$delegate = LazyKt.lazy(PickerImServices$chatterService$2.INSTANCE);
    }

    public final h getChatterService() {
        return (h) chatterService$delegate.getValue();
    }
}

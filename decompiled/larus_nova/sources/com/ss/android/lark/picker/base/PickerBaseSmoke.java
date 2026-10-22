package com.ss.android.lark.picker.base;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerBaseSmoke;", "", "<init>", "()V", "SMOKE_FLAG", "", "isSmokeOk", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerBaseSmoke {
    public static final PickerBaseSmoke INSTANCE = null;
    public static final String SMOKE_FLAG = "picker_base_smoke_ok";

    static {
        INSTANCE = new PickerBaseSmoke();
    }

    private PickerBaseSmoke() {
    }

    @JvmStatic
    public static final boolean isSmokeOk() {
        if (SMOKE_FLAG.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}

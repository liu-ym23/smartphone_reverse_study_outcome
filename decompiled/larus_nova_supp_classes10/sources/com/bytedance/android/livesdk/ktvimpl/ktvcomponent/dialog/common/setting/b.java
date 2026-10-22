package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.UpdateSongSettingType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    MutableLiveData<d> obtainKSongSettingKey();

    void updateSettingByType(UpdateSongSettingType r1, boolean r2, Function1<? super Boolean, Unit> r3);
}

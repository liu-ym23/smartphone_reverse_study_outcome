package com.ss.android.lark.picker.doubao.api;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.picker.doubao.IDoubaoPickerApi;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/doubao/api/IDoubaoPicker;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "createDoubaoPicker", "Lcom/ss/android/lark/picker/doubao/IDoubaoPickerApi;", "config", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoubaoPicker extends IOfficeSDKCapacity {
    IDoubaoPickerApi createDoubaoPicker(DoubaoPickerConfig r100);
}

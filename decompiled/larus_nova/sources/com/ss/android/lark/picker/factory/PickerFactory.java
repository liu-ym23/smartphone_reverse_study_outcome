package com.ss.android.lark.picker.factory;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/factory/PickerFactory;", "", "createNavPickerHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "config", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PickerFactory {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ PickerViewHolder createNavPickerHolder$default(PickerFactory r100, FragmentActivity r101, NavPickerConfig r102, PickerStatistics.Scene r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = PickerStatistics.Scene.Unknown;
        L7:
            return r100.createNavPickerHolder(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNavPickerHolder");
        }
    }

    PickerViewHolder createNavPickerHolder(FragmentActivity r100, NavPickerConfig r101, PickerStatistics.Scene r102);
}

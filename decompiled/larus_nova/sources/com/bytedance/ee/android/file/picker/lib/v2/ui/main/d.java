package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilePickerViewModel f206140a;

    public d(FilePickerViewModel r100) {
        this.f206140a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(FilePickerViewModel.access$getMCategoryConfigManager$p(this.f206140a).a(((GroupEntity) r100).f206021a).f542569a), Integer.valueOf(FilePickerViewModel.access$getMCategoryConfigManager$p(this.f206140a).a(((GroupEntity) r101).f206021a).f542569a));
    }
}

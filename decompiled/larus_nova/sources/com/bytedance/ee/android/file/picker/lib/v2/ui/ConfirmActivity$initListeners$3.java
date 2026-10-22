package com.bytedance.ee.android.file.picker.lib.v2.ui;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ConfirmActivity$initListeners$3 extends FunctionReferenceImpl implements Function2<Key, Key, Unit> {
    public ConfirmActivity$initListeners$3(Object r100) {
        super(2, r100, ConfirmViewModel.class, "unselectFile", "unselectFile(Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Key r100, Key r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((ConfirmViewModel) this.receiver).unselectFile(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Key r100, Key r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}

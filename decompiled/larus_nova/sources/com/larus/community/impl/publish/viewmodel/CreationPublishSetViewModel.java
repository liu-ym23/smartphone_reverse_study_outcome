package com.larus.community.impl.publish.viewmodel;

import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetState;", "<init>", "()V", "updateChecked", "", "checked", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishSetViewModel extends ComponentViewModel<CreationPublishSetState> {
    public static /* synthetic */ CreationPublishSetState No(boolean r100, CreationPublishSetState r101) {
        return updateChecked$lambda$0(r100, r101);
    }

    public CreationPublishSetViewModel() {
    }

    public final void updateChecked(final boolean r100) {
        setStateImmediate(new a(r100));
    }

    private static final CreationPublishSetState updateChecked$lambda$0(boolean r100, CreationPublishSetState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setStateImmediate");
        return r101.copy(r100);
    }
}

package com.larus.community.impl.publish.viewmodel;

import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleState;", "<init>", "()V", "updatePublishingState", "", "isPublishing", "", "setShowPublish", "showPublish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishTitleViewModel extends ComponentViewModel<CreationPublishTitleState> {
    public static /* synthetic */ CreationPublishTitleState No(boolean r100, CreationPublishTitleState r101) {
        return setShowPublish$lambda$1(r100, r101);
    }

    public static /* synthetic */ CreationPublishTitleState Oo(boolean r100, CreationPublishTitleState r101) {
        return updatePublishingState$lambda$0(r100, r101);
    }

    public CreationPublishTitleViewModel() {
    }

    public final void setShowPublish(final boolean r100) {
        setState(new f(r100));
    }

    public final void updatePublishingState(final boolean r100) {
        setState(new e(r100));
    }

    private static final CreationPublishTitleState setShowPublish$lambda$1(boolean r100, CreationPublishTitleState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return CreationPublishTitleState.copy$default(r101, false, r100, 1, null);
    }

    private static final CreationPublishTitleState updatePublishingState$lambda$0(boolean r100, CreationPublishTitleState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return CreationPublishTitleState.copy$default(r101, r100, false, 2, null);
    }
}

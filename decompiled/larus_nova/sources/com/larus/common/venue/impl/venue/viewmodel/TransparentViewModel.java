package com.larus.common.venue.impl.venue.viewmodel;

import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z09.a;
import z09.b;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/larus/common/venue/impl/venue/viewmodel/TransparentViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/common/venue/impl/venue/viewmodel/TransparentState;", "<init>", "()V", "setHasShowMenu", "", "hasShowMenu", "", "setHasShowIme", "hasShowIme", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransparentViewModel extends ComponentViewModel<TransparentState> {
    public static /* synthetic */ TransparentState No(boolean r100, TransparentState r101) {
        return setHasShowIme$lambda$1(r100, r101);
    }

    public static /* synthetic */ TransparentState Oo(boolean r100, TransparentState r101) {
        return setHasShowMenu$lambda$0(r100, r101);
    }

    public TransparentViewModel() {
    }

    public final void setHasShowIme(final boolean r100) {
        setState(new b(r100));
    }

    public final void setHasShowMenu(final boolean r100) {
        setState(new a(r100));
    }

    private static final TransparentState setHasShowIme$lambda$1(boolean r100, TransparentState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return TransparentState.copy$default(r101, false, r100, 1, null);
    }

    private static final TransparentState setHasShowMenu$lambda$0(boolean r100, TransparentState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return TransparentState.copy$default(r101, r100, false, 2, null);
    }
}

package com.larus.bmhome.floatchat.component;

import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u001a\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/floatchat/component/FoldHandlerVMState;", "<init>", "()V", "foldFloatChat", "", "needAnim", "", "from", "", "toHalfScreen", "toNineSplitScreen", "toFullScreen", "setDragging", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FoldHandlerVM extends ComponentViewModel<FoldHandlerVMState> {
    public static final a Companion = null;
    private static final String TAG = "FoldHandlerVM";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ FoldHandlerVMState No(boolean r100, FoldHandlerVMState r101) {
        return toNineSplitScreen$lambda$2(r100, r101);
    }

    public static /* synthetic */ FoldHandlerVMState Oo(boolean r100, FoldHandlerVMState r101) {
        return foldFloatChat$lambda$0(r100, r101);
    }

    public static /* synthetic */ FoldHandlerVMState Po(boolean r100, FoldHandlerVMState r101) {
        return toHalfScreen$lambda$1(r100, r101);
    }

    public static /* synthetic */ FoldHandlerVMState Qo(boolean r100, FoldHandlerVMState r101) {
        return toFullScreen$lambda$3(r100, r101);
    }

    public static /* synthetic */ FoldHandlerVMState So(FoldHandlerVMState r100) {
        return setDragging$lambda$4(r100);
    }

    public final void setDragging() {
        FLogger.f375446a.i(TAG, "setDragging");
        setStateImmediate(new f0());
    }

    public FoldHandlerVM() {
    }

    private static final FoldHandlerVMState setDragging$lambda$4(FoldHandlerVMState r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setStateImmediate");
        return r100.copy(4, false);
    }

    private static final FoldHandlerVMState foldFloatChat$lambda$0(boolean r100, FoldHandlerVMState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setStateImmediate");
        return r101.copy(0, r100);
    }

    private static final FoldHandlerVMState toFullScreen$lambda$3(boolean r100, FoldHandlerVMState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setStateImmediate");
        return r101.copy(3, r100);
    }

    private static final FoldHandlerVMState toHalfScreen$lambda$1(boolean r100, FoldHandlerVMState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setStateImmediate");
        return r101.copy(1, r100);
    }

    private static final FoldHandlerVMState toNineSplitScreen$lambda$2(boolean r100, FoldHandlerVMState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setStateImmediate");
        return r101.copy(2, r100);
    }

    public final void foldFloatChat(final boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        FLogger.f375446a.i(TAG, "foldFloatChat, needAnim = " + r100 + " from: " + r101);
        setStateImmediate(new b0(r100));
    }

    public final void toFullScreen(final boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        FLogger.f375446a.i(TAG, "toFullScreen, needAnim = " + r100 + ", from = " + r101);
        setStateImmediate(new e0(r100));
    }

    public final void toHalfScreen(final boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        FLogger.f375446a.i(TAG, "expandToHalfScreen, needAnim = " + r100 + " from:" + r101);
        setStateImmediate(new c0(r100));
    }

    public final void toNineSplitScreen(final boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        FLogger.f375446a.i(TAG, "toNineSplitScreen, needAnim = " + r100 + ", from = " + r101);
        setStateImmediate(new d0(r100));
    }

    public static /* synthetic */ void foldFloatChat$default(FoldHandlerVM r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.foldFloatChat(r101, r102);
    }

    public static /* synthetic */ void toFullScreen$default(FoldHandlerVM r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = "";
    L8:
        r100.toFullScreen(r101, r102);
    }

    public static /* synthetic */ void toHalfScreen$default(FoldHandlerVM r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.toHalfScreen(r101, r102);
    }

    public static /* synthetic */ void toNineSplitScreen$default(FoldHandlerVM r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = "";
    L8:
        r100.toNineSplitScreen(r101, r102);
    }
}

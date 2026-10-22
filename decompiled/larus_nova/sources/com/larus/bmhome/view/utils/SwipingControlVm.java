package com.larus.bmhome.view.utils;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/utils/SwipingControlVm;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "swipingControlFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getSwipingControlFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "scrollToPlayingMusicCardFlow", "Lcom/larus/bmhome/view/utils/SwipingControlVm$TargetMusicCardInfo;", "getScrollToPlayingMusicCardFlow", "TargetMusicCardInfo", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipingControlVm extends ViewModel {
    private final MutableSharedFlow<a> scrollToPlayingMusicCardFlow;
    private final MutableSharedFlow<Boolean> swipingControlFlow;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f317518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f317519b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f317518a == r101.f317518a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f317519b, r101.f317519b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f317518a * 31) + this.f317519b.hashCode();
        }

        public final String toString() {
            return "TargetMusicCardInfo(targetPosition=" + this.f317518a + ", messageId=" + this.f317519b + ')';
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "messageId");
            this.f317518a = r100;
            this.f317519b = r101;
        }
    }

    public SwipingControlVm() {
        BufferOverflow r100 = BufferOverflow.DROP_OLDEST;
        this.swipingControlFlow = SharedFlowKt.MutableSharedFlow(1, 0, r100);
        this.scrollToPlayingMusicCardFlow = SharedFlowKt.MutableSharedFlow(0, 1, r100);
    }

    public final MutableSharedFlow<a> getScrollToPlayingMusicCardFlow() {
        return this.scrollToPlayingMusicCardFlow;
    }

    public final MutableSharedFlow<Boolean> getSwipingControlFlow() {
        return this.swipingControlFlow;
    }
}

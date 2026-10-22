package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Ipc$VisibilityChangeEvent;", "Lcom/bytedance/ee/util/io/NonProguard;", "visibilityState", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;)V", "getVisibilityState", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$Ipc$VisibilityChangeEvent implements NonProguard {
    private final IWebview$VisibilityState visibilityState;

    public static /* synthetic */ IWebview$Ipc$VisibilityChangeEvent copy$default(IWebview$Ipc$VisibilityChangeEvent r100, IWebview$VisibilityState r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.visibilityState;
    L6:
        return r100.copy(r101);
    }

    public final IWebview$VisibilityState component1() {
        return this.visibilityState;
    }

    public final IWebview$Ipc$VisibilityChangeEvent copy(IWebview$VisibilityState r100) {
        Intrinsics.checkNotNullParameter(r100, "visibilityState");
        return new IWebview$Ipc$VisibilityChangeEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWebview$Ipc$VisibilityChangeEvent) == true) goto L9;
        return false;
    L9:
        if (this.visibilityState == ((IWebview$Ipc$VisibilityChangeEvent) r100).visibilityState) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.visibilityState.hashCode();
    }

    public String toString() {
        return "VisibilityChangeEvent(visibilityState=" + this.visibilityState + ')';
    }

    public final IWebview$VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public IWebview$Ipc$VisibilityChangeEvent(IWebview$VisibilityState r100) {
        Intrinsics.checkNotNullParameter(r100, "visibilityState");
        this.visibilityState = r100;
    }
}

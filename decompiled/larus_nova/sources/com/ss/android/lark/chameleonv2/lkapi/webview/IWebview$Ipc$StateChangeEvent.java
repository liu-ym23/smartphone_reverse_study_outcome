package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Ipc$StateChangeEvent;", "Lcom/bytedance/ee/util/io/NonProguard;", "status", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;)V", "getStatus", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$Ipc$StateChangeEvent implements NonProguard {
    private final IWebview$Status status;

    public static /* synthetic */ IWebview$Ipc$StateChangeEvent copy$default(IWebview$Ipc$StateChangeEvent r100, IWebview$Status r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        return r100.copy(r101);
    }

    public final IWebview$Status component1() {
        return this.status;
    }

    public final IWebview$Ipc$StateChangeEvent copy(IWebview$Status r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        return new IWebview$Ipc$StateChangeEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWebview$Ipc$StateChangeEvent) == true) goto L9;
        return false;
    L9:
        if (this.status == ((IWebview$Ipc$StateChangeEvent) r100).status) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "StateChangeEvent(status=" + this.status + ')';
    }

    public final IWebview$Status getStatus() {
        return this.status;
    }

    public IWebview$Ipc$StateChangeEvent(IWebview$Status r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.status = r100;
    }
}

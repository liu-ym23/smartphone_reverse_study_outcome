package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Ipc$ConfirmDialogClosedDetails;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "reason", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;", "actionKey", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getReason", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;", "getActionKey", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Ipc$ConfirmDialogClosedDetails implements NonProguard {
    private final String actionKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f411465id;
    private final IWidget$Internal$ConfirmDialogCloseReason reason;

    public static /* synthetic */ IWidget$Ipc$ConfirmDialogClosedDetails copy$default(IWidget$Ipc$ConfirmDialogClosedDetails r100, String r101, IWidget$Internal$ConfirmDialogCloseReason r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f411465id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.reason;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.actionKey;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f411465id;
    }

    public final IWidget$Internal$ConfirmDialogCloseReason component2() {
        return this.reason;
    }

    public final String component3() {
        return this.actionKey;
    }

    public final IWidget$Ipc$ConfirmDialogClosedDetails copy(String r100, IWidget$Internal$ConfirmDialogCloseReason r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "reason");
        return new IWidget$Ipc$ConfirmDialogClosedDetails(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$Ipc$ConfirmDialogClosedDetails) == true) goto L8;
        return false;
    L8:
        IWidget$Ipc$ConfirmDialogClosedDetails r101 = (IWidget$Ipc$ConfirmDialogClosedDetails) r100;
        if (Intrinsics.areEqual(this.f411465id, r101.f411465id) == true) goto L12;
        return false;
    L12:
        if (this.reason == r101.reason) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionKey, r101.actionKey) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f411465id.hashCode() * 31) + this.reason.hashCode()) * 31;
        String r101 = this.actionKey;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ConfirmDialogClosedDetails(id=" + this.f411465id + ", reason=" + this.reason + ", actionKey=" + this.actionKey + ')';
    }

    public final String getActionKey() {
        return this.actionKey;
    }

    public final String getId() {
        return this.f411465id;
    }

    public final IWidget$Internal$ConfirmDialogCloseReason getReason() {
        return this.reason;
    }

    public IWidget$Ipc$ConfirmDialogClosedDetails(String r100, IWidget$Internal$ConfirmDialogCloseReason r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f411465id = r100;
        this.reason = r101;
        this.actionKey = r102;
    }
}

package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastShowResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "toastId", "", "<init>", "(I)V", "getToastId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ToastShowResult implements NonProguard {
    private final int toastId;

    public static /* synthetic */ IWidget$Internal$ToastShowResult copy$default(IWidget$Internal$ToastShowResult r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.toastId;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.toastId;
    }

    public final IWidget$Internal$ToastShowResult copy(int r100) {
        return new IWidget$Internal$ToastShowResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$Internal$ToastShowResult) == true) goto L9;
        return false;
    L9:
        if (this.toastId == ((IWidget$Internal$ToastShowResult) r100).toastId) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.toastId;
    }

    public String toString() {
        return "ToastShowResult(toastId=" + this.toastId + ')';
    }

    public final int getToastId() {
        return this.toastId;
    }

    public IWidget$Internal$ToastShowResult(int r100) {
        this.toastId = r100;
    }
}

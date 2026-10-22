package com.ss.android.lark.intent.export.entity.input;

import android.text.TextUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendTarget;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "targetId", "", "targetDesc", "targetType", "Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/TargetType;)V", "getTargetId", "()Ljava/lang/String;", "setTargetId", "(Ljava/lang/String;)V", "getTargetDesc", "getTargetType", "()Lcom/ss/android/lark/intent/export/entity/input/TargetType;", "isValid", "", "toString", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendTarget implements Serializable, IContentValid {
    private final String targetDesc;
    private String targetId;
    private final TargetType targetType;

    public static /* synthetic */ SendTarget copy$default(SendTarget r100, String r101, String r102, TargetType r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.targetId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.targetDesc;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.targetType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.targetId;
    }

    public final String component2() {
        return this.targetDesc;
    }

    public final TargetType component3() {
        return this.targetType;
    }

    public final SendTarget copy(String r100, String r101, TargetType r102) {
        return new SendTarget(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendTarget) == true) goto L8;
        return false;
    L8:
        SendTarget r101 = (SendTarget) r100;
        if (Intrinsics.areEqual(this.targetId, r101.targetId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetDesc, r101.targetDesc) == true) goto L15;
        return false;
    L15:
        if (this.targetType == r101.targetType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.targetId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        TargetType r107 = this.targetType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        if (TextUtils.isEmpty(this.targetId) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.targetDesc) == false) goto L8;
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendTarget(targetId=");
        String r101 = this.targetId;
        String r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(", targetDesc=");
        String r103 = this.targetDesc;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    }

    public final String getTargetDesc() {
        return this.targetDesc;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final TargetType getTargetType() {
        return this.targetType;
    }

    public final void setTargetId(String r100) {
        this.targetId = r100;
    }

    public SendTarget(String r100, String r101, TargetType r102) {
        this.targetId = r100;
        this.targetDesc = r101;
        this.targetType = r102;
    }
}

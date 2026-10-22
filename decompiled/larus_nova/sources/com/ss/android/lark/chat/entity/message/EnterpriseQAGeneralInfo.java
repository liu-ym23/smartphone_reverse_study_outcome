package com.ss.android.lark.chat.entity.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;", "Ljava/io/Serializable;", "saveDocInfo", "Lcom/ss/android/lark/chat/entity/message/SaveDocInfo;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/SaveDocInfo;)V", "getSaveDocInfo", "()Lcom/ss/android/lark/chat/entity/message/SaveDocInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterpriseQAGeneralInfo implements Serializable {

    @SerializedName("save_doc_info")
    private final SaveDocInfo saveDocInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public EnterpriseQAGeneralInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EnterpriseQAGeneralInfo copy$default(EnterpriseQAGeneralInfo r100, SaveDocInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.saveDocInfo;
    L6:
        return r100.copy(r101);
    }

    public final SaveDocInfo component1() {
        return this.saveDocInfo;
    }

    public final EnterpriseQAGeneralInfo copy(SaveDocInfo r100) {
        return new EnterpriseQAGeneralInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EnterpriseQAGeneralInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.saveDocInfo, ((EnterpriseQAGeneralInfo) r100).saveDocInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        SaveDocInfo r100 = this.saveDocInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "EnterpriseQAGeneralInfo(saveDocInfo=" + this.saveDocInfo + ')';
    }

    public final SaveDocInfo getSaveDocInfo() {
        return this.saveDocInfo;
    }

    public EnterpriseQAGeneralInfo(SaveDocInfo r100) {
        this.saveDocInfo = r100;
    }

    public /* synthetic */ EnterpriseQAGeneralInfo(SaveDocInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

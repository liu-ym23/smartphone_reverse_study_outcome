package com.ss.android.lark.chat.entity.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/SaveDocInfo;", "Ljava/io/Serializable;", "saveCardDocButton", "Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;", "cardKey", "", "<init>", "(Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;Ljava/lang/String;)V", "getSaveCardDocButton", "()Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;", "getCardKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveDocInfo implements Serializable {

    @SerializedName("card_key")
    private final String cardKey;

    @SerializedName("save_card_doc_button")
    private final CustomizeAIButton saveCardDocButton;

    /* JADX WARN: Multi-variable type inference failed */
    public SaveDocInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SaveDocInfo copy$default(SaveDocInfo r100, CustomizeAIButton r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.saveCardDocButton;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cardKey;
    L9:
        return r100.copy(r101, r102);
    }

    public final CustomizeAIButton component1() {
        return this.saveCardDocButton;
    }

    public final String component2() {
        return this.cardKey;
    }

    public final SaveDocInfo copy(CustomizeAIButton r100, String r101) {
        return new SaveDocInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SaveDocInfo) == true) goto L8;
        return false;
    L8:
        SaveDocInfo r101 = (SaveDocInfo) r100;
        if (Intrinsics.areEqual(this.saveCardDocButton, r101.saveCardDocButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardKey, r101.cardKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CustomizeAIButton r100 = this.saveCardDocButton;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.cardKey;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SaveDocInfo(saveCardDocButton=" + this.saveCardDocButton + ", cardKey=" + this.cardKey + ')';
    }

    public final String getCardKey() {
        return this.cardKey;
    }

    public final CustomizeAIButton getSaveCardDocButton() {
        return this.saveCardDocButton;
    }

    public SaveDocInfo(CustomizeAIButton r100, String r101) {
        this.saveCardDocButton = r100;
        this.cardKey = r101;
    }

    public /* synthetic */ SaveDocInfo(CustomizeAIButton r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

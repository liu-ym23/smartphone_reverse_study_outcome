package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.TextTagInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationMsgContentData;", "Ljava/io/Serializable;", "text", "", "textTags", "", "Lcom/larus/im/bean/message/TextTagInfo;", "creationInfo", "Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMsgContentData implements Serializable {

    @SerializedName("creation_info")
    public final CreationInfo creationInfo;

    @SerializedName("text")
    public final String text;

    @SerializedName("text_tags")
    public final List<TextTagInfo> textTags;

    public CreationMsgContentData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationMsgContentData copy$default(CreationMsgContentData r100, String r101, List r102, CreationInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.textTags;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.creationInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.text;
    }

    public final List<TextTagInfo> component2() {
        return this.textTags;
    }

    public final CreationInfo component3() {
        return this.creationInfo;
    }

    public final CreationMsgContentData copy(String r100, List<TextTagInfo> r101, CreationInfo r102) {
        return new CreationMsgContentData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationMsgContentData) == true) goto L8;
        return false;
    L8:
        CreationMsgContentData r101 = (CreationMsgContentData) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textTags, r101.textTags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationInfo, r101.creationInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<TextTagInfo> r104 = this.textTags;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CreationInfo r107 = this.creationInfo;
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

    public String toString() {
        return "CreationMsgContentData(text=" + this.text + ", textTags=" + this.textTags + ", creationInfo=" + this.creationInfo + ')';
    }

    public CreationMsgContentData(String r100, List<TextTagInfo> r101, CreationInfo r102) {
        this.text = r100;
        this.textTags = r101;
        this.creationInfo = r102;
    }

    public /* synthetic */ CreationMsgContentData(String r100, List r101, CreationInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

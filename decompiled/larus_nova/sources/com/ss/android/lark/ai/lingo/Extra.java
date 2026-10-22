package com.ss.android.lark.ai.lingo;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pua.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003JT\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/ss/android/lark/ai/lingo/Extra;", "", "space", "", "spaceId", "", "spaceSubId", "showPin", "", "pinInfo", "Lcom/ss/android/lark/ai/lingo/PinInfo;", "ignoreInfo", "Lcom/ss/android/lark/ai/lingo/IgnoreInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/ai/lingo/PinInfo;Lcom/ss/android/lark/ai/lingo/IgnoreInfo;)V", "getSpace", "()I", "getSpaceId", "()Ljava/lang/String;", "getSpaceSubId", "getShowPin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPinInfo", "()Lcom/ss/android/lark/ai/lingo/PinInfo;", "getIgnoreInfo", "()Lcom/ss/android/lark/ai/lingo/IgnoreInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/ai/lingo/PinInfo;Lcom/ss/android/lark/ai/lingo/IgnoreInfo;)Lcom/ss/android/lark/ai/lingo/Extra;", "equals", "other", "hashCode", "toString", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Extra {
    private final a ignoreInfo;
    private final PinInfo pinInfo;
    private final Boolean showPin;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    private final int f408636space;
    private final String spaceId;
    private final String spaceSubId;

    public static /* synthetic */ Extra copy$default(Extra r100, int r101, String r102, String r103, Boolean r104, PinInfo r105, a r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f408636space;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.spaceId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.spaceSubId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.showPin;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.pinInfo;
    L17:
        PinInfo r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r100.getClass();
        r110 = null;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.f408636space;
    }

    public final String component2() {
        return this.spaceId;
    }

    public final String component3() {
        return this.spaceSubId;
    }

    public final Boolean component4() {
        return this.showPin;
    }

    public final PinInfo component5() {
        return this.pinInfo;
    }

    public final a component6() {
        return null;
    }

    public final Extra copy(@JSONField(name = "space") int r100, @JSONField(name = "spaceId") String r110, @JSONField(name = "spaceSubId") String r111, @JSONField(name = "showPin") Boolean r112, @JSONField(name = "pinInfo") PinInfo r113, @JSONField(name = "ignoreInfo") a r114) {
        return new Extra(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Extra) == true) goto L8;
        return false;
    L8:
        Extra r101 = (Extra) r100;
        if (this.f408636space == r101.f408636space) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spaceId, r101.spaceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spaceSubId, r101.spaceSubId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showPin, r101.showPin) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pinInfo, r101.pinInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final a getIgnoreInfo() {
        return null;
    }

    public int hashCode() {
        int r100 = this.f408636space * 31;
        String r101 = this.spaceId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.spaceSubId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.showPin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        PinInfo r110 = this.pinInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L19:
        return ((r109 + r111) * 31) + 0;
    L17:
        r111 = r110.hashCode();
        goto L19
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Extra(space=" + this.f408636space + ", spaceId=" + this.spaceId + ", spaceSubId=" + this.spaceSubId + ", showPin=" + this.showPin + ", pinInfo=" + this.pinInfo + ", ignoreInfo=null)";
    }

    public final PinInfo getPinInfo() {
        return this.pinInfo;
    }

    public final Boolean getShowPin() {
        return this.showPin;
    }

    public final int getSpace() {
        return this.f408636space;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getSpaceSubId() {
        return this.spaceSubId;
    }

    public Extra(@JSONField(name = "space") int r100, @JSONField(name = "spaceId") String r101, @JSONField(name = "spaceSubId") String r102, @JSONField(name = "showPin") Boolean r103, @JSONField(name = "pinInfo") PinInfo r104, @JSONField(name = "ignoreInfo") a r105) {
        this.f408636space = r100;
        this.spaceId = r101;
        this.spaceSubId = r102;
        this.showPin = r103;
        this.pinInfo = r104;
    }
}

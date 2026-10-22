package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/SmartReplyEntryInfo;", "Ljava/io/Serializable;", "", "hasPreGenerated", "", "aiMessageId", "", "recommendContent", "", "<init>", "(ZLjava/lang/String;Ljava/lang/CharSequence;)V", "getHasPreGenerated", "()Z", "getAiMessageId", "()Ljava/lang/String;", "getRecommendContent", "()Ljava/lang/CharSequence;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmartReplyEntryInfo implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient CharSequence f415311a;
    private final String aiMessageId;
    private final boolean hasPreGenerated;

    public static /* synthetic */ SmartReplyEntryInfo copy$default(SmartReplyEntryInfo r100, boolean r101, String r102, CharSequence r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hasPreGenerated;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.aiMessageId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f415311a;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.hasPreGenerated;
    }

    public final String component2() {
        return this.aiMessageId;
    }

    public final CharSequence component3() {
        return this.f415311a;
    }

    public final SmartReplyEntryInfo copy(boolean r100, String r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r101, "aiMessageId");
        return new SmartReplyEntryInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SmartReplyEntryInfo) == true) goto L8;
        return false;
    L8:
        SmartReplyEntryInfo r101 = (SmartReplyEntryInfo) r100;
        if (this.hasPreGenerated == r101.hasPreGenerated) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiMessageId, r101.aiMessageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f415311a, r101.f415311a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.hasPreGenerated == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.aiMessageId.hashCode()) * 31;
        CharSequence r102 = this.f415311a;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "SmartReplyEntryInfo(hasPreGenerated=" + this.hasPreGenerated + ", aiMessageId=" + this.aiMessageId + ", recommendContent=" + this.f415311a + ')';
    }

    public Object clone() {
        return super.clone();
    }

    public final String getAiMessageId() {
        return this.aiMessageId;
    }

    public final boolean getHasPreGenerated() {
        return this.hasPreGenerated;
    }

    public final CharSequence getRecommendContent() {
        return this.f415311a;
    }

    public SmartReplyEntryInfo(boolean r100, String r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r101, "aiMessageId");
        this.hasPreGenerated = r100;
        this.aiMessageId = r101;
        this.f415311a = r102;
    }

    public /* synthetic */ SmartReplyEntryInfo(boolean r100, String r101, CharSequence r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}

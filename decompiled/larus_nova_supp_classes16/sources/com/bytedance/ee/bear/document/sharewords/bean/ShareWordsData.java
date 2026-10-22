package com.bytedance.ee.bear.document.sharewords.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0006H\u0016J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JN\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", "", "srcObjToken", "srcObjType", "", "commentable", "", "showCommentEntry", "startTimeStamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZJ)V", "getUrl", "()Ljava/lang/String;", "getSrcObjToken", "setSrcObjToken", "(Ljava/lang/String;)V", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommentable", "()Z", "getShowCommentEntry", "getStartTimeStamp", "()J", "toString", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZJ)Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsData implements NonProguard {
    private final boolean commentable;
    private final boolean showCommentEntry;
    private String srcObjToken;
    private Integer srcObjType;
    private final long startTimeStamp;
    private final String url;

    public static /* synthetic */ ShareWordsData copy$default(ShareWordsData r5, String r6, String r7, Integer r8, boolean r9, boolean r10, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.url;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.srcObjToken;
    L8:
        String r16 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.srcObjType;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.commentable;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.showCommentEntry;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.startTimeStamp;
    L20:
        String r12 = r6;
        return r5.copy(r12, r16, r0, r1, r2, r11);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.srcObjToken;
    }

    public final Integer component3() {
        return this.srcObjType;
    }

    public final boolean component4() {
        return this.commentable;
    }

    public final boolean component5() {
        return this.showCommentEntry;
    }

    public final long component6() {
        return this.startTimeStamp;
    }

    public final ShareWordsData copy(String r10, String r11, Integer r12, boolean r13, boolean r14, long r16) {
        Intrinsics.checkNotNullParameter(r10, "url");
        return new ShareWordsData(r10, r11, r12, r13, r14, r16);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "ShareWordsData(url: " + this.url + ')';
    }

    public final boolean getCommentable() {
        return this.commentable;
    }

    public final boolean getShowCommentEntry() {
        return this.showCommentEntry;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof ShareWordsData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(((ShareWordsData) r3).url, this.url) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final void setSrcObjToken(String r1) {
        this.srcObjToken = r1;
    }

    public final void setSrcObjType(Integer r1) {
        this.srcObjType = r1;
    }

    public ShareWordsData(String r2, String r3, Integer r4, boolean r5, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.url = r2;
        this.srcObjToken = r3;
        this.srcObjType = r4;
        this.commentable = r5;
        this.showCommentEntry = r6;
        this.startTimeStamp = r7;
    }

    public /* synthetic */ ShareWordsData(String r7, String r8, Integer r9, boolean r10, boolean r11, long r12, int r14, DefaultConstructorMarker r16) {
        Integer r1 = null;
        if ((r14 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r14 & 4) != 0) goto L10;
        r1 = r9;
    L10:
        boolean r3 = false;
        if ((r14 & 8) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r14 & 16) != 0) goto L19;
        r3 = r11;
    L19:
        if ((r14 & 32) == 0) goto L21;
        long r4 = 1;
    L22:
        this(r7, r0, r1, r2, r3, r4);
        return;
    L21:
        r4 = r12;
        goto L22
    L13:
        r2 = r10;
        goto L15
    L5:
        r0 = r8;
        goto L7
    }
}

package com.bytedance.ee.bear.document.sharewords.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0006H\u0016J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JN\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", "", "srcObjToken", "srcObjType", "", "commentable", "", "showCommentEntry", "startTimeStamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZJ)V", "getUrl", "()Ljava/lang/String;", "getSrcObjToken", "setSrcObjToken", "(Ljava/lang/String;)V", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommentable", "()Z", "getShowCommentEntry", "getStartTimeStamp", "()J", "toString", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZJ)Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsData implements NonProguard {
    private final boolean commentable;
    private final boolean showCommentEntry;
    private String srcObjToken;
    private Integer srcObjType;
    private final long startTimeStamp;
    private final String url;

    public static /* synthetic */ ShareWordsData copy$default(ShareWordsData r100, String r101, String r102, Integer r103, boolean r104, boolean r110, long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.srcObjToken;
    L8:
        String r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.srcObjType;
    L11:
        Integer r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.commentable;
    L14:
        boolean r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.showCommentEntry;
    L17:
        boolean r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.startTimeStamp;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
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

    public final ShareWordsData copy(String r110, String r111, Integer r112, boolean r113, boolean r114, long r115) {
        Intrinsics.checkNotNullParameter(r110, "url");
        return new ShareWordsData(r110, r111, r112, r113, r114, r115);
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

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof ShareWordsData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(((ShareWordsData) r100).url, this.url) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public ShareWordsData(String r100, String r101, Integer r102, boolean r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.url = r100;
        this.srcObjToken = r101;
        this.srcObjType = r102;
        this.commentable = r103;
        this.showCommentEntry = r104;
        this.startTimeStamp = r105;
    }

    public /* synthetic */ ShareWordsData(String r100, String r101, Integer r102, boolean r110, boolean r111, long r112, int r113, DefaultConstructorMarker r114) {
        Integer r103 = null;
        if ((r113 & 2) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r113 & 4) != 0) goto L10;
        r103 = r102;
    L10:
        boolean r105 = false;
        if ((r113 & 8) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r113 & 16) != 0) goto L19;
        r105 = r111;
    L19:
        if ((r113 & 32) == 0) goto L21;
        long r107 = 1;
    L22:
        this(r100, r104, r103, r106, r105, r107);
        return;
    L21:
        r107 = r112;
        goto L22
    L13:
        r106 = r110;
        goto L15
    L5:
        r104 = r101;
        goto L7
    }
}

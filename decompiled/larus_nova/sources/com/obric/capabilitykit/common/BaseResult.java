package com.obric.capabilitykit.common;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0003Jv\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/common/BaseResult;", "", "questionId", "", "replyId", "ret", "", "details", "", "file", "Ljava/io/File;", "uiType", "replyFor", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getQuestionId", "()Ljava/lang/Long;", "setQuestionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReplyFor", "setReplyFor", "getReplyId", "setReplyId", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/BaseResult;", "equals", "", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BaseResult {
    private String details;
    private ConcurrentHashMap<String, String> ext;
    private File file;
    private Long questionId;
    private String replyFor;
    private Long replyId;
    private int ret;
    private int uiType;

    public BaseResult() {
        this(null, null, 0, null, null, 0, null, null, 255, null);
    }

    public BaseResult(Long r100, Long r101, int r102, String r103, File r104, int r105, String r106, ConcurrentHashMap<String, String> r107) {
        this.questionId = r100;
        this.replyId = r101;
        this.ret = r102;
        this.details = r103;
        this.file = r104;
        this.uiType = r105;
        this.replyFor = r106;
        this.ext = r107;
    }

    public /* synthetic */ BaseResult(Long r110, Long r111, int r112, String r113, File r114, int r115, String r116, ConcurrentHashMap r117, int r118, DefaultConstructorMarker r119) {
        ConcurrentHashMap r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = null;
    L10:
        int r103 = 1;
        if ((r118 & 4) == 0) goto L13;
        int r104 = 1;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        File r106 = null;
    L23:
        if ((r118 & 32) != 0) goto L27;
        r103 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r105, r106, r103, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResult copy$default(BaseResult r100, Long r110, Long r111, int r112, String r113, File r114, int r115, String r116, ConcurrentHashMap r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Long r101 = r100.questionId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = r100.replyId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.ret;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.details;
    L19:
        if ((r118 & 16) == 0) goto L21;
        File r105 = r100.file;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.uiType;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.replyFor;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ConcurrentHashMap r108 = r100.ext;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Long component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.replyId;
    }

    public final int component3() {
        return this.ret;
    }

    public final String component4() {
        return this.details;
    }

    public final File component5() {
        return this.file;
    }

    public final int component6() {
        return this.uiType;
    }

    public final String component7() {
        return this.replyFor;
    }

    public final ConcurrentHashMap<String, String> component8() {
        return this.ext;
    }

    public final BaseResult copy(Long r110, Long r111, int r112, String r113, File r114, int r115, String r116, ConcurrentHashMap<String, String> r117) {
        return new BaseResult(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BaseResult) == true) goto L8;
        return false;
    L8:
        BaseResult r101 = (BaseResult) r100;
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L15;
        return false;
    L15:
        if (this.ret == r101.ret) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.details, r101.details) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.file, r101.file) == true) goto L24;
        return false;
    L24:
        if (this.uiType == r101.uiType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replyFor, r101.replyFor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getDetails() {
        return this.details;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final File getFile() {
        return this.file;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final Long getReplyId() {
        return this.replyId;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public int hashCode() {
        Long r100 = this.questionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.replyId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.ret) * 31;
        String r107 = this.details;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        File r110 = this.file;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.uiType) * 31;
        String r113 = this.replyFor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ConcurrentHashMap<String, String> r116 = this.ext;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final void setDetails(String r100) {
        this.details = r100;
    }

    public final void setExt(ConcurrentHashMap<String, String> r100) {
        this.ext = r100;
    }

    public final void setFile(File r100) {
        this.file = r100;
    }

    public final void setQuestionId(Long r100) {
        this.questionId = r100;
    }

    public final void setReplyFor(String r100) {
        this.replyFor = r100;
    }

    public final void setReplyId(Long r100) {
        this.replyId = r100;
    }

    public final void setRet(int r100) {
        this.ret = r100;
    }

    public final void setUiType(int r100) {
        this.uiType = r100;
    }

    public String toString() {
        return "BaseResult(questionId=" + this.questionId + ", replyId=" + this.replyId + ", ret=" + this.ret + ", details=" + this.details + ", file=" + this.file + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", ext=" + this.ext + ')';
    }
}

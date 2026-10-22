package com.larus.bmhome.chat.resp;

import bb8.i;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0003J\u0082\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/resp/Notice;", "", "noticeId", "", "createTime", "noticeGroup", "", "noticeType", "noticeTypeStr", "", "hasRead", "", "auditPass", "commonNoticeData", "Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "uniqId", "bannerModels", "", "Lcom/larus/bmhome/banner/BannerModel;", "<init>", "(JJIILjava/lang/String;ZLjava/lang/Boolean;Lcom/larus/bmhome/chat/resp/CommonNoticeData;Ljava/lang/String;Ljava/util/List;)V", "getNoticeId", "()J", "getCreateTime", "getNoticeGroup", "()I", "getNoticeType", "getNoticeTypeStr", "()Ljava/lang/String;", "getHasRead", "()Z", "setHasRead", "(Z)V", "getAuditPass", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommonNoticeData", "()Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "getUniqId", "getBannerModels", "()Ljava/util/List;", "setBannerModels", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JJIILjava/lang/String;ZLjava/lang/Boolean;Lcom/larus/bmhome/chat/resp/CommonNoticeData;Ljava/lang/String;Ljava/util/List;)Lcom/larus/bmhome/chat/resp/Notice;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Notice {

    @SerializedName("audit_pass")
    private final Boolean auditPass;
    private transient List<i> bannerModels;

    @SerializedName("common_notice_data")
    private final CommonNoticeData commonNoticeData;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("has_read")
    private boolean hasRead;

    @SerializedName("notice_group")
    private final int noticeGroup;

    @SerializedName("notice_id")
    private final long noticeId;

    @SerializedName("notice_type")
    private final int noticeType;

    @SerializedName("notice_type_str")
    private final String noticeTypeStr;

    @SerializedName("uniq_id")
    private final String uniqId;

    public Notice() {
        this(0, 0, 0, 0, null, false, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Notice copy$default(Notice r110, long r111, long r112, int r113, int r114, String r210, boolean r211, Boolean r212, CommonNoticeData r213, String r214, List r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        long r100 = r110.noticeId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        long r101 = r110.createTime;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.noticeGroup;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = r110.noticeType;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.noticeTypeStr;
    L23:
        if ((r216 & 32) == 0) goto L25;
        boolean r105 = r110.hasRead;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Boolean r115 = r110.auditPass;
    L31:
        if ((r216 & 128) == 0) goto L33;
        CommonNoticeData r116 = r110.commonNoticeData;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.uniqId;
    L39:
        if ((r216 & 512) == 0) goto L41;
        List r106 = r110.bannerModels;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r106);
    L41:
        r106 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.noticeId;
    }

    public final List<i> component10() {
        return this.bannerModels;
    }

    public final long component2() {
        return this.createTime;
    }

    public final int component3() {
        return this.noticeGroup;
    }

    public final int component4() {
        return this.noticeType;
    }

    public final String component5() {
        return this.noticeTypeStr;
    }

    public final boolean component6() {
        return this.hasRead;
    }

    public final Boolean component7() {
        return this.auditPass;
    }

    public final CommonNoticeData component8() {
        return this.commonNoticeData;
    }

    public final String component9() {
        return this.uniqId;
    }

    public final Notice copy(long r110, long r111, int r112, int r210, String r211, boolean r212, Boolean r213, CommonNoticeData r214, String r215, List<i> r216) {
        Intrinsics.checkNotNullParameter(r216, "bannerModels");
        return new Notice(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Notice) == true) goto L8;
        return false;
    L8:
        Notice r101 = (Notice) r100;
        if (this.noticeId == r101.noticeId) goto L12;
        return false;
    L12:
        if (this.createTime == r101.createTime) goto L15;
        return false;
    L15:
        if (this.noticeGroup == r101.noticeGroup) goto L18;
        return false;
    L18:
        if (this.noticeType == r101.noticeType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.noticeTypeStr, r101.noticeTypeStr) == true) goto L24;
        return false;
    L24:
        if (this.hasRead == r101.hasRead) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.auditPass, r101.auditPass) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.commonNoticeData, r101.commonNoticeData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uniqId, r101.uniqId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bannerModels, r101.bannerModels) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r100 = this.noticeId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.createTime;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.noticeGroup) * 31) + this.noticeType) * 31;
        String r104 = this.noticeTypeStr;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        if (this.hasRead == false) goto L9;
        int r108 = 1231;
    L10:
        int r109 = (r107 + r108) * 31;
        Boolean r110 = this.auditPass;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        CommonNoticeData r113 = this.commonNoticeData;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.uniqId;
        if (r116 == null) goto L23;
        r105 = r116.hashCode();
    L23:
        return ((r115 + r105) * 31) + this.bannerModels.hashCode();
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = 1237;
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public String toString() {
        return "Notice(noticeId=" + this.noticeId + ", createTime=" + this.createTime + ", noticeGroup=" + this.noticeGroup + ", noticeType=" + this.noticeType + ", noticeTypeStr=" + this.noticeTypeStr + ", hasRead=" + this.hasRead + ", auditPass=" + this.auditPass + ", commonNoticeData=" + this.commonNoticeData + ", uniqId=" + this.uniqId + ", bannerModels=" + this.bannerModels + ')';
    }

    public final Boolean getAuditPass() {
        return this.auditPass;
    }

    public final List<i> getBannerModels() {
        return this.bannerModels;
    }

    public final CommonNoticeData getCommonNoticeData() {
        return this.commonNoticeData;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final int getNoticeGroup() {
        return this.noticeGroup;
    }

    public final long getNoticeId() {
        return this.noticeId;
    }

    public final int getNoticeType() {
        return this.noticeType;
    }

    public final String getNoticeTypeStr() {
        return this.noticeTypeStr;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final void setBannerModels(List<i> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bannerModels = r100;
    }

    public final void setHasRead(boolean r100) {
        this.hasRead = r100;
    }

    public Notice(long r100, long r101, int r102, int r103, String r104, boolean r105, Boolean r110, CommonNoticeData r111, String r112, List<i> r113) {
        Intrinsics.checkNotNullParameter(r113, "bannerModels");
        this.noticeId = r100;
        this.createTime = r101;
        this.noticeGroup = r102;
        this.noticeType = r103;
        this.noticeTypeStr = r104;
        this.hasRead = r105;
        this.auditPass = r110;
        this.commonNoticeData = r111;
        this.uniqId = r112;
        this.bannerModels = r113;
    }

    public /* synthetic */ Notice(long r110, long r111, int r112, int r113, String r210, boolean r211, Boolean r212, CommonNoticeData r213, String r214, List r215, int r216, DefaultConstructorMarker r217) {
        long r100 = -1;
        if ((r216 & 1) == 0) goto L5;
        long r101 = -1;
    L7:
        if ((r216 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        int r102 = -1;
        if ((r216 & 4) == 0) goto L13;
        int r103 = -1;
    L15:
        if ((r216 & 8) != 0) goto L18;
        r102 = r113;
    L18:
        String r104 = "";
        if ((r216 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r216 & 32) == 0) goto L25;
        boolean r106 = false;
    L26:
        CommonNoticeData r114 = null;
        if ((r216 & 64) == 0) goto L29;
        Boolean r115 = null;
    L31:
        if ((r216 & 128) != 0) goto L35;
        r114 = r213;
    L35:
        if ((r216 & 256) != 0) goto L39;
        r104 = r214;
    L39:
        if ((r216 & 512) == 0) goto L41;
        List r107 = CollectionsKt.emptyList();
    L42:
        this(r101, r100, r103, r102, r105, r106, r115, r114, r104, r107);
        return;
    L41:
        r107 = r215;
        goto L42
    L29:
        r115 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L26
    L21:
        r105 = r210;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}

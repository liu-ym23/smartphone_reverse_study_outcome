package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001d\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/LifeNoticeUploadMessageStruct;", "", "", "component1", "", "component2", "uploadMessageType", "rawData", "copy", "toString", "hashCode", "other", "", "equals", "I", "getUploadMessageType", "()I", "setUploadMessageType", "(I)V", "Ljava/lang/String;", "getRawData", "()Ljava/lang/String;", "setRawData", "(Ljava/lang/String;)V", "<init>", "(ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class LifeNoticeUploadMessageStruct {
    public static final a Companion = null;
    public static final int TYPE_COMMON_IMPRESSION = 7;
    public static final int TYPE_COMMON_RESOURCE_IMPRESSION = 8;
    public static final int TYPE_DIAMOND_DROP_DOWN_CARD_IMPRESSION = 4;
    public static final int TYPE_FEED_MALL_CARD_IMPRESSION = 2;
    public static final int TYPE_FEED_SHOP_CARD_IMPRESSION = 3;
    public static final int TYPE_GENERAL_BUBBLE_IMPRESSION = 6;
    public static final int TYPE_MALL_BUBBLE_IMPRESSION = 1;
    public static final int TYPE_SHOP_BUBBLE_IMPRESSION = 5;

    @SerializedName("data")
    private String rawData;

    @SerializedName("upload_message_type")
    private int uploadMessageType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LifeNoticeUploadMessageStruct() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LifeNoticeUploadMessageStruct copy$default(LifeNoticeUploadMessageStruct r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uploadMessageType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.rawData;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.uploadMessageType;
    }

    public final String component2() {
        return this.rawData;
    }

    public final LifeNoticeUploadMessageStruct copy(int r100, String r101) {
        return new LifeNoticeUploadMessageStruct(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LifeNoticeUploadMessageStruct) == true) goto L8;
        return false;
    L8:
        LifeNoticeUploadMessageStruct r101 = (LifeNoticeUploadMessageStruct) r100;
        if (this.uploadMessageType == r101.uploadMessageType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.uploadMessageType * 31;
        String r101 = this.rawData;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "LifeNoticeUploadMessageStruct(uploadMessageType=" + this.uploadMessageType + ", rawData=" + this.rawData + ')';
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final int getUploadMessageType() {
        return this.uploadMessageType;
    }

    public final void setRawData(String r100) {
        this.rawData = r100;
    }

    public final void setUploadMessageType(int r100) {
        this.uploadMessageType = r100;
    }

    public LifeNoticeUploadMessageStruct(int r100, String r101) {
        this.uploadMessageType = r100;
        this.rawData = r101;
    }

    public /* synthetic */ LifeNoticeUploadMessageStruct(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

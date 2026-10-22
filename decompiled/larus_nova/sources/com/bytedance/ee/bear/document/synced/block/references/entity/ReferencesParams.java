package com.bytedance.ee.bear.document.synced.block.references.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0006\u0010\u001f\u001a\u00020\fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/entity/ReferencesParams;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "resourceToken", "", "getResourceToken", "()Ljava/lang/String;", "setResourceToken", "(Ljava/lang/String;)V", "resourceType", "", "getResourceType", "()Ljava/lang/Integer;", "setResourceType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docxSyncedBlockHostToken", "getDocxSyncedBlockHostToken", "setDocxSyncedBlockHostToken", "docxSyncedBlockHostType", "getDocxSyncedBlockHostType", "setDocxSyncedBlockHostType", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "getLimit", "setLimit", "totalCount", "getTotalCount", "setTotalCount", "toString", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferencesParams implements Parcelable, NonProguard {
    public static final Parcelable.Creator<ReferencesParams> CREATOR = null;

    @JSONField(name = "docxSyncedBlockHostToken")
    private String docxSyncedBlockHostToken;

    @JSONField(name = "docxSyncedBlockHostType")
    private Integer docxSyncedBlockHostType;

    @JSONField(name = VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private Integer limit;

    @JSONField(name = "resourceToken")
    private String resourceToken;

    @JSONField(name = "resourceType")
    private Integer resourceType;

    @JSONField(name = "totalCount")
    private Integer totalCount;

    public static final class a implements Parcelable.Creator<ReferencesParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ReferencesParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.readInt();
            return new ReferencesParams();
        }

        @Override // android.os.Parcelable.Creator
        public final ReferencesParams[] newArray(int r100) {
            return new ReferencesParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ReferencesParams() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(1);
    }

    public String toString() {
        return "ReferencesParams(resourceToken=" + this.resourceToken + ", resourceType=" + this.resourceType + ", docxSyncedBlockHostToken=" + this.docxSyncedBlockHostToken + ", docxSyncedBlockHostType=" + this.docxSyncedBlockHostType + ", limit=" + this.limit + ", totalCount=" + this.totalCount + ')';
    }

    public final String getDocxSyncedBlockHostToken() {
        return this.docxSyncedBlockHostToken;
    }

    public final Integer getDocxSyncedBlockHostType() {
        return this.docxSyncedBlockHostType;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final String getResourceToken() {
        return this.resourceToken;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setDocxSyncedBlockHostToken(String r100) {
        this.docxSyncedBlockHostToken = r100;
    }

    public final void setDocxSyncedBlockHostType(Integer r100) {
        this.docxSyncedBlockHostType = r100;
    }

    public final void setLimit(Integer r100) {
        this.limit = r100;
    }

    public final void setResourceToken(String r100) {
        this.resourceToken = r100;
    }

    public final void setResourceType(Integer r100) {
        this.resourceType = r100;
    }

    public final void setTotalCount(Integer r100) {
        this.totalCount = r100;
    }
}

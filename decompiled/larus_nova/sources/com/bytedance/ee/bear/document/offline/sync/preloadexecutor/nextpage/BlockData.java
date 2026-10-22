package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockData;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "parentId", "", "text", "Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockText;", "type", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockText;Ljava/lang/String;)V", "getParentId", "()Ljava/lang/String;", "getText", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockText;", "getType", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockData implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<BlockData> CREATOR = null;

    @SerializedName("parent_id")
    private final String parentId;
    private final BlockText text;
    private final String type;

    public static final class a implements Parcelable.Creator<BlockData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BlockData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            BlockText r102 = null;
        L7:
            return new BlockData(r101, r102, r100.readString());
        L5:
            r102 = BlockText.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BlockData[] newArray(int r100) {
            return new BlockData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ BlockData copy$default(BlockData r100, String r101, BlockText r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.parentId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.parentId;
    }

    public final BlockText component2() {
        return this.text;
    }

    public final String component3() {
        return this.type;
    }

    public final BlockData copy(String r100, BlockText r101, String r102) {
        return new BlockData(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockData) == true) goto L8;
        return false;
    L8:
        BlockData r101 = (BlockData) r100;
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.parentId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        BlockText r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
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
        return "BlockData(parentId=" + this.parentId + ", text=" + this.text + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.parentId);
        BlockText r102 = this.text;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.type);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public Object clone() {
        return super.clone();
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final BlockText getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public BlockData(String r100, BlockText r101, String r102) {
        this.parentId = r100;
        this.text = r101;
        this.type = r102;
    }
}

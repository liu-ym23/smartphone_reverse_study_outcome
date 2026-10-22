package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final BlockData createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            String r1 = r4.readString();
            if (r4.readInt() != 0) goto L5;
            BlockText r2 = null;
        L7:
            return new BlockData(r1, r2, r4.readString());
        L5:
            r2 = BlockText.CREATOR.createFromParcel(r4);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BlockData[] newArray(int r1) {
            return new BlockData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ BlockData copy$default(BlockData r0, String r1, BlockText r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.parentId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        return r0.copy(r1, r2, r3);
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

    public final BlockData copy(String r2, BlockText r3, String r4) {
        return new BlockData(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockData) == true) goto L8;
        return false;
    L8:
        BlockData r6 = (BlockData) r5;
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.parentId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        BlockText r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.type;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockData(parentId=" + this.parentId + ", text=" + this.text + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.parentId);
        BlockText r0 = this.text;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.type);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
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

    public BlockData(String r1, BlockText r2, String r3) {
        this.parentId = r1;
        this.text = r2;
        this.type = r3;
    }
}

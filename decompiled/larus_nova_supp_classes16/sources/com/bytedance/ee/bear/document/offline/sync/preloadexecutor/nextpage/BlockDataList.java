package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockDataList;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "data", "Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockData;", "<init>", "(Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockData;)V", "getData", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockDataList implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<BlockDataList> CREATOR = null;
    private final BlockData data;

    public static final class a implements Parcelable.Creator<BlockDataList> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BlockDataList createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            if (r3.readInt() != 0) goto L5;
            BlockData r4 = null;
        L7:
            return new BlockDataList(r4);
        L5:
            r4 = BlockData.CREATOR.createFromParcel(r3);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BlockDataList[] newArray(int r1) {
            return new BlockDataList[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ BlockDataList copy$default(BlockDataList r0, BlockData r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        return r0.copy(r1);
    }

    public final BlockData component1() {
        return this.data;
    }

    public final BlockDataList copy(BlockData r2) {
        return new BlockDataList(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BlockDataList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, ((BlockDataList) r4).data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        BlockData r0 = this.data;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "BlockDataList(data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        BlockData r0 = this.data;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
    }

    public Object clone() {
        return super.clone();
    }

    public final BlockData getData() {
        return this.data;
    }

    public BlockDataList(BlockData r1) {
        this.data = r1;
    }
}

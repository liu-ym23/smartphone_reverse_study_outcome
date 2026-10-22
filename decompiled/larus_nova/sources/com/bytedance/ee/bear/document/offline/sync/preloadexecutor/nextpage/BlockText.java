package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/BlockText;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "apool", "Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Apool;", "initialAttributedTexts", "Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/InitAttr;", "<init>", "(Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Apool;Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/InitAttr;)V", "getApool", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Apool;", "getInitialAttributedTexts", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/InitAttr;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockText implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<BlockText> CREATOR = null;
    private final Apool apool;
    private final InitAttr initialAttributedTexts;

    public static final class a implements Parcelable.Creator<BlockText> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BlockText createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            InitAttr r101 = null;
            if (r100.readInt() != 0) goto L5;
            Apool r102 = null;
        L6:
            Apool r103 = r102;
            if (r100.readInt() == 0) goto L11;
            r101 = InitAttr.CREATOR.createFromParcel(r100);
        L11:
            return new BlockText(r103, r101);
        L5:
            r102 = Apool.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BlockText[] newArray(int r100) {
            return new BlockText[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ BlockText copy$default(BlockText r100, Apool r101, InitAttr r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.apool;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.initialAttributedTexts;
    L9:
        return r100.copy(r101, r102);
    }

    public final Apool component1() {
        return this.apool;
    }

    public final InitAttr component2() {
        return this.initialAttributedTexts;
    }

    public final BlockText copy(Apool r100, InitAttr r101) {
        return new BlockText(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockText) == true) goto L8;
        return false;
    L8:
        BlockText r101 = (BlockText) r100;
        if (Intrinsics.areEqual(this.apool, r101.apool) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.initialAttributedTexts, r101.initialAttributedTexts) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Apool r100 = this.apool;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        InitAttr r104 = this.initialAttributedTexts;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockText(apool=" + this.apool + ", initialAttributedTexts=" + this.initialAttributedTexts + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Apool r102 = this.apool;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        InitAttr r103 = this.initialAttributedTexts;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public Object clone() {
        return super.clone();
    }

    public final Apool getApool() {
        return this.apool;
    }

    public final InitAttr getInitialAttributedTexts() {
        return this.initialAttributedTexts;
    }

    public BlockText(Apool r100, InitAttr r101) {
        this.apool = r100;
        this.initialAttributedTexts = r101;
    }
}

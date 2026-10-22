package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0000J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "avatarKey", "", "chatterId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getChatterId", "clone", "isItemSame", "", "diffable", "isContentSame", "equals", "other", "", "hashCode", "", "component1", "component2", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarChatterInfo implements Serializable, b<AvatarChatterInfo> {
    private final String avatarKey;
    private final String chatterId;

    public static /* synthetic */ AvatarChatterInfo copy$default(AvatarChatterInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.avatarKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chatterId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final AvatarChatterInfo copy(String r100, String r101) {
        return new AvatarChatterInfo(r100, r101);
    }

    public String toString() {
        return "AvatarChatterInfo(avatarKey=" + this.avatarKey + ", chatterId=" + this.chatterId + ')';
    }

    public final AvatarChatterInfo clone() {
        return new AvatarChatterInfo(this.avatarKey, this.chatterId);
    }

    public int hashCode() {
        String r100 = this.avatarKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.chatterId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AvatarChatterInfo) == true) goto L8;
        return false;
    L8:
        AvatarChatterInfo r101 = (AvatarChatterInfo) r100;
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r101.chatterId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean isContentSame(AvatarChatterInfo r100) {
        String r101 = this.chatterId;
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.chatterId;
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L14;
        String r104 = this.avatarKey;
        if (r100 == null) goto L12;
        r102 = r100.avatarKey;
    L12:
        if (Intrinsics.areEqual(r104, r102) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public boolean isItemSame(AvatarChatterInfo r100) {
        String r101 = this.chatterId;
        if (r100 == null) goto L5;
        String r102 = r100.chatterId;
    L7:
        return Intrinsics.areEqual(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((AvatarChatterInfo) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((AvatarChatterInfo) r100);
    }

    public AvatarChatterInfo(String r100, String r101) {
        this.avatarKey = r100;
        this.chatterId = r101;
    }
}

package com.ss.android.lark.intent.export.entity.donate;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/ChatterDonateEntity;", "Lcom/ss/android/lark/intent/export/entity/donate/ScreenDonateEntity;", "chatterId", "", "chatterName", "avatarFile", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getChatterId", "()Ljava/lang/String;", "getChatterName", "getAvatarFile", "()Ljava/io/File;", "parser", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;", "(Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;)Ljava/lang/Object;", "toDesc", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterDonateEntity extends ScreenDonateEntity {
    private final File avatarFile;
    private final String chatterId;
    private final String chatterName;

    public static /* synthetic */ ChatterDonateEntity copy$default(ChatterDonateEntity r100, String r101, String r102, File r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.chatterId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.chatterName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.avatarFile;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.chatterId;
    }

    public final String component2() {
        return this.chatterName;
    }

    public final File component3() {
        return this.avatarFile;
    }

    public final ChatterDonateEntity copy(String r100, String r101, File r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "chatterName");
        return new ChatterDonateEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatterDonateEntity) == true) goto L8;
        return false;
    L8:
        ChatterDonateEntity r101 = (ChatterDonateEntity) r100;
        if (Intrinsics.areEqual(this.chatterId, r101.chatterId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterName, r101.chatterName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarFile, r101.avatarFile) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.chatterId.hashCode() * 31) + this.chatterName.hashCode()) * 31;
        File r101 = this.avatarFile;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ChatterDonateEntity(chatterId='");
        r100.append(this.chatterId);
        r100.append("', hasAvatar=");
        if (this.avatarFile == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public String toDesc() {
        return toString();
    }

    public final File getAvatarFile() {
        return this.avatarFile;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final String getChatterName() {
        return this.chatterName;
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public <R> R parser(IDonateEntityVisitor<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        return r100.visit(this);
    }

    public ChatterDonateEntity(String r100, String r101, File r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "chatterName");
        super(DonateType.Chatter);
        this.chatterId = r100;
        this.chatterName = r101;
        this.avatarFile = r102;
    }
}

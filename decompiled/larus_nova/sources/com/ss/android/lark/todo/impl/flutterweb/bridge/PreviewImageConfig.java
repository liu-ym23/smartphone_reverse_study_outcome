package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/PreviewImageConfig;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "imageKey", "", "fsUnit", "base64Crypto", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageKey", "()Ljava/lang/String;", "getFsUnit", "getBase64Crypto", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewImageConfig implements NonProguard {
    private final String base64Crypto;
    private final String fsUnit;
    private final String imageKey;

    public static /* synthetic */ PreviewImageConfig copy$default(PreviewImageConfig r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.imageKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fsUnit;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.base64Crypto;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.imageKey;
    }

    public final String component2() {
        return this.fsUnit;
    }

    public final String component3() {
        return this.base64Crypto;
    }

    public final PreviewImageConfig copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        Intrinsics.checkNotNullParameter(r102, "base64Crypto");
        return new PreviewImageConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewImageConfig) == true) goto L8;
        return false;
    L8:
        PreviewImageConfig r101 = (PreviewImageConfig) r100;
        if (Intrinsics.areEqual(this.imageKey, r101.imageKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fsUnit, r101.fsUnit) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.base64Crypto, r101.base64Crypto) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.imageKey.hashCode() * 31) + this.fsUnit.hashCode()) * 31) + this.base64Crypto.hashCode();
    }

    public String toString() {
        return "PreviewImageConfig(imageKey='" + this.imageKey + "', fsUnit='" + this.fsUnit + "', base64Crypto='" + this.base64Crypto + "')";
    }

    public final String getBase64Crypto() {
        return this.base64Crypto;
    }

    public final String getFsUnit() {
        return this.fsUnit;
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public PreviewImageConfig(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        Intrinsics.checkNotNullParameter(r102, "base64Crypto");
        this.imageKey = r100;
        this.fsUnit = r101;
        this.base64Crypto = r102;
    }
}

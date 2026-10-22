package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/Chatter;", "Lcom/bytedance/ee/util/io/NonProguard;", "avatarKey", "", "name", "localizedName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getName", "getLocalizedName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Chatter implements NonProguard {
    private final String avatarKey;
    private final String localizedName;
    private final String name;

    public static /* synthetic */ Chatter copy$default(Chatter r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.avatarKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.localizedName;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.localizedName;
    }

    public final Chatter copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "localizedName");
        return new Chatter(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Chatter) == true) goto L8;
        return false;
    L8:
        Chatter r101 = (Chatter) r100;
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localizedName, r101.localizedName) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.avatarKey.hashCode() * 31) + this.name.hashCode()) * 31) + this.localizedName.hashCode();
    }

    public String toString() {
        return "Chatter(avatarKey=" + this.avatarKey + ", name=" + this.name + ", localizedName=" + this.localizedName + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getLocalizedName() {
        return this.localizedName;
    }

    public final String getName() {
        return this.name;
    }

    public Chatter(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "localizedName");
        this.avatarKey = r100;
        this.name = r101;
        this.localizedName = r102;
    }
}

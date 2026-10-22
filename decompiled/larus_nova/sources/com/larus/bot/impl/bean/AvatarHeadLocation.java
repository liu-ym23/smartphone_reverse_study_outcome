package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/bean/AvatarHeadLocation;", "Ljava/io/Serializable;", "avatars", "", "Lcom/larus/bot/impl/bean/HeadLocation;", "<init>", "(Ljava/util/List;)V", "getAvatars", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarHeadLocation implements Serializable {

    @SerializedName("avatars")
    private final List<List<HeadLocation>> avatars;

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarHeadLocation() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AvatarHeadLocation copy$default(AvatarHeadLocation r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.avatars;
    L6:
        return r100.copy(r101);
    }

    public final List<List<HeadLocation>> component1() {
        return this.avatars;
    }

    public final AvatarHeadLocation copy(List<? extends List<HeadLocation>> r100) {
        return new AvatarHeadLocation(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AvatarHeadLocation) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.avatars, ((AvatarHeadLocation) r100).avatars) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<List<HeadLocation>> r100 = this.avatars;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "AvatarHeadLocation(avatars=" + this.avatars + ')';
    }

    public final List<List<HeadLocation>> getAvatars() {
        return this.avatars;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarHeadLocation(List<? extends List<HeadLocation>> r100) {
        this.avatars = r100;
    }

    public /* synthetic */ AvatarHeadLocation(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/bootprotector/PreciseFixStategy;", "", "bizTag", "", "crashPortrait", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "urgentCmds", "", "Lcom/larus/settings/provider/bootprotector/UrgentCmd;", "<init>", "(Ljava/lang/String;Lcom/larus/settings/provider/bootprotector/CrashPortrait;Ljava/util/List;)V", "getBizTag", "()Ljava/lang/String;", "getCrashPortrait", "()Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "getUrgentCmds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreciseFixStategy {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("crash_portrait")
    private final CrashPortrait crashPortrait;

    @SerializedName("urgent_cmds")
    private final List<UrgentCmd> urgentCmds;

    public PreciseFixStategy() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreciseFixStategy copy$default(PreciseFixStategy r100, String r101, CrashPortrait r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bizTag;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.crashPortrait;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.urgentCmds;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.bizTag;
    }

    public final CrashPortrait component2() {
        return this.crashPortrait;
    }

    public final List<UrgentCmd> component3() {
        return this.urgentCmds;
    }

    public final PreciseFixStategy copy(String r100, CrashPortrait r101, List<UrgentCmd> r102) {
        return new PreciseFixStategy(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreciseFixStategy) == true) goto L8;
        return false;
    L8:
        PreciseFixStategy r101 = (PreciseFixStategy) r100;
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.crashPortrait, r101.crashPortrait) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urgentCmds, r101.urgentCmds) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.bizTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CrashPortrait r104 = this.crashPortrait;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<UrgentCmd> r107 = this.urgentCmds;
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
        return "PreciseFixStategy(bizTag=" + this.bizTag + ", crashPortrait=" + this.crashPortrait + ", urgentCmds=" + this.urgentCmds + ')';
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final CrashPortrait getCrashPortrait() {
        return this.crashPortrait;
    }

    public final List<UrgentCmd> getUrgentCmds() {
        return this.urgentCmds;
    }

    public PreciseFixStategy(String r100, CrashPortrait r101, List<UrgentCmd> r102) {
        this.bizTag = r100;
        this.crashPortrait = r101;
        this.urgentCmds = r102;
    }

    public /* synthetic */ PreciseFixStategy(String r100, CrashPortrait r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}

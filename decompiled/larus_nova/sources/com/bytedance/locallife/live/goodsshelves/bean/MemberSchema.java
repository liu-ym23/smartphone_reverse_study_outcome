package com.bytedance.locallife.live.goodsshelves.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;", "Ljava/io/Serializable;", "show_member_entrance", "", "member_schema_url", "", "(ZLjava/lang/String;)V", "getMember_schema_url", "()Ljava/lang/String;", "getShow_member_entrance", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MemberSchema implements Serializable {
    private final String member_schema_url;
    private final boolean show_member_entrance;

    /* JADX WARN: Multi-variable type inference failed */
    public MemberSchema() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MemberSchema copy$default(MemberSchema r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.show_member_entrance;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.member_schema_url;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.show_member_entrance;
    }

    public final String component2() {
        return this.member_schema_url;
    }

    public final MemberSchema copy(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "member_schema_url");
        return new MemberSchema(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MemberSchema) == true) goto L8;
        return false;
    L8:
        MemberSchema r101 = (MemberSchema) r100;
        if (this.show_member_entrance == r101.show_member_entrance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.member_schema_url, r101.member_schema_url) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.show_member_entrance == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.member_schema_url.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "MemberSchema(show_member_entrance=" + this.show_member_entrance + ", member_schema_url=" + this.member_schema_url + ')';
    }

    public final String getMember_schema_url() {
        return this.member_schema_url;
    }

    public final boolean getShow_member_entrance() {
        return this.show_member_entrance;
    }

    public MemberSchema(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "member_schema_url");
        this.show_member_entrance = r100;
        this.member_schema_url = r101;
    }

    public /* synthetic */ MemberSchema(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}

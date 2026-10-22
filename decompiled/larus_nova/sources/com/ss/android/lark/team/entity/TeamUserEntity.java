package com.ss.android.lark.team.entity;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamUserEntity;", "Ljava/io/Serializable;", "userRoles", "", "Lcom/ss/android/lark/team/entity/TeamRole;", "version", "", "<init>", "(Ljava/util/List;Ljava/lang/Long;)V", "getUserRoles", "()Ljava/util/List;", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Long;)Lcom/ss/android/lark/team/entity/TeamUserEntity;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeamUserEntity implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 4939940387694822720L;
    private final List<TeamRole> userRoles;
    private final Long version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TeamUserEntity copy$default(TeamUserEntity r100, List r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.userRoles;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.version;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<TeamRole> component1() {
        return this.userRoles;
    }

    public final Long component2() {
        return this.version;
    }

    public final TeamUserEntity copy(List<? extends TeamRole> r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "userRoles");
        return new TeamUserEntity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TeamUserEntity) == true) goto L8;
        return false;
    L8:
        TeamUserEntity r101 = (TeamUserEntity) r100;
        if (Intrinsics.areEqual(this.userRoles, r101.userRoles) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.userRoles.hashCode() * 31;
        Long r101 = this.version;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "TeamUserEntity(userRoles=" + this.userRoles + ", version=" + this.version + ')';
    }

    public final List<TeamRole> getUserRoles() {
        return this.userRoles;
    }

    public final Long getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TeamUserEntity(List<? extends TeamRole> r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "userRoles");
        this.userRoles = r100;
        this.version = r101;
    }
}

package com.ss.android.lark.team.entity;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamMemberMeta;", "Ljava/io/Serializable;", "userRoles", "", "Lcom/ss/android/lark/team/entity/TeamRole;", "<init>", "(Ljava/util/List;)V", "getUserRoles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeamMemberMeta implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final List<TeamRole> userRoles;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TeamMemberMeta copy$default(TeamMemberMeta r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.userRoles;
    L6:
        return r100.copy(r101);
    }

    public final List<TeamRole> component1() {
        return this.userRoles;
    }

    public final TeamMemberMeta copy(List<? extends TeamRole> r100) {
        Intrinsics.checkNotNullParameter(r100, "userRoles");
        return new TeamMemberMeta(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TeamMemberMeta) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userRoles, ((TeamMemberMeta) r100).userRoles) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.userRoles.hashCode();
    }

    public String toString() {
        return "TeamMemberMeta(userRoles=" + this.userRoles + ')';
    }

    public final List<TeamRole> getUserRoles() {
        return this.userRoles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TeamMemberMeta(List<? extends TeamRole> r100) {
        Intrinsics.checkNotNullParameter(r100, "userRoles");
        this.userRoles = r100;
    }
}

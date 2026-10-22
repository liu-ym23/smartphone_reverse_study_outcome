package com.ss.android.lark.mention.base.impl.atselector.bean;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends ChatChatter> f431716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<UserGroupEntity> f431717b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f431716a, r101.f431716a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431717b, r101.f431717b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f431716a.hashCode() * 31) + this.f431717b.hashCode();
    }

    public final String toString() {
        return "IMMentionResultModel(chatters=" + this.f431716a + ", userGroups=" + this.f431717b + ')';
    }

    public d() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public d(List<? extends ChatChatter> r100, List<UserGroupEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatters");
        Intrinsics.checkNotNullParameter(r101, "userGroups");
        this.f431716a = r100;
        this.f431717b = r101;
    }
}

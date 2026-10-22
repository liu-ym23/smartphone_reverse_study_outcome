package com.larus.home.impl.main.side_bar.data;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConversationGroupPolicy f344493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GroupSortPolicy f344494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConversationArchiveFilter f344495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f344496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f344497e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f344493a == r101.f344493a) goto L12;
        return false;
    L12:
        if (this.f344494b == r101.f344494b) goto L15;
        return false;
    L15:
        if (this.f344495c == r101.f344495c) goto L18;
        return false;
    L18:
        if (this.f344496d == r101.f344496d) goto L21;
        return false;
    L21:
        if (this.f344497e == r101.f344497e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f344493a.hashCode() * 31) + this.f344494b.hashCode()) * 31) + this.f344495c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f344496d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f344497e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationGroupLocalConfig(groupPolicy=" + this.f344493a + ", sortPolicy=" + this.f344494b + ", archiveFilter=" + this.f344495c + ", socialIndependentGroup=" + this.f344496d + ", hasManuallyChangedConversationGroupPolicy=" + this.f344497e + ')';
    }

    public e() {
        this(ConversationGroupPolicy.Project, GroupSortPolicy.UpdateTime, ConversationArchiveFilter.Active, true, false);
    }

    public e(ConversationGroupPolicy r100, GroupSortPolicy r101, ConversationArchiveFilter r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "groupPolicy");
        Intrinsics.checkNotNullParameter(r101, "sortPolicy");
        Intrinsics.checkNotNullParameter(r102, "archiveFilter");
        this.f344493a = r100;
        this.f344494b = r101;
        this.f344495c = r102;
        this.f344496d = r103;
        this.f344497e = r104;
    }
}

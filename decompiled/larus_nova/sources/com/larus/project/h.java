package com.larus.project;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniProject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<OmniProject> f367023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<wc9.e>> f367024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Message> f367025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f367026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f367027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f367028f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f367023a, r101.f367023a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367024b, r101.f367024b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f367025c, r101.f367025c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367026d, r101.f367026d) == true) goto L21;
        return false;
    L21:
        if (this.f367027e == r101.f367027e) goto L24;
        return false;
    L24:
        if (this.f367028f == r101.f367028f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f367023a.hashCode() * 31) + this.f367024b.hashCode()) * 31) + this.f367025c.hashCode()) * 31) + this.f367026d.hashCode()) * 31) + this.f367027e) * 31;
        if (this.f367028f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProjectListPage(projects=" + this.f367023a + ", firstPageConversations=" + this.f367024b + ", briefMessages=" + this.f367025c + ", projectsWithMoreConversations=" + this.f367026d + ", nextCursor=" + this.f367027e + ", hasMore=" + this.f367028f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<OmniProject> r100, Map<String, ? extends List<wc9.e>> r101, Map<String, Message> r102, Set<String> r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "projects");
        Intrinsics.checkNotNullParameter(r101, "firstPageConversations");
        Intrinsics.checkNotNullParameter(r102, "briefMessages");
        Intrinsics.checkNotNullParameter(r103, "projectsWithMoreConversations");
        this.f367023a = r100;
        this.f367024b = r101;
        this.f367025c = r102;
        this.f367026d = r103;
        this.f367027e = r104;
        this.f367028f = r105;
    }
}

package com.larus.bmhome.taskskill.service;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.platform.model.SlashMentionConfig;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OmniProject f314445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<wc9.e> f314446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Message> f314447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f314448d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f314445a, r101.f314445a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314446b, r101.f314446b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314447c, r101.f314447c) == true) goto L18;
        return false;
    L18:
        if (this.f314448d == r101.f314448d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f314445a.hashCode() * 31) + this.f314446b.hashCode()) * 31) + this.f314447c.hashCode()) * 31;
        if (this.f314448d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProjectListItem(project=" + this.f314445a + ", firstPageConversations=" + this.f314446b + ", briefMessages=" + this.f314447c + ", hasMoreConversations=" + this.f314448d + ')';
    }

    public /* synthetic */ h(OmniProject r100) {
        this(r100, CollectionsKt.emptyList(), MapsKt.emptyMap(), false);
    }

    public h(OmniProject r100, List<wc9.e> r101, Map<String, Message> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        Intrinsics.checkNotNullParameter(r101, "firstPageConversations");
        Intrinsics.checkNotNullParameter(r102, "briefMessages");
        this.f314445a = r100;
        this.f314446b = r101;
        this.f314447c = r102;
        this.f314448d = r103;
    }
}

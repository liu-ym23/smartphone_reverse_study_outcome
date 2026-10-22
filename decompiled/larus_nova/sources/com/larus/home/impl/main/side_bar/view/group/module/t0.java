package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.im.internal.jni.bean.OmniConversationProjectStatus;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f345542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f345543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OmniConversationProjectStatus f345544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.im.k0 f345545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f345546e;

    public final y a() {
        c0 r100 = this.f345542a;
        n0 r101 = r100.f345483t;
        eb9.e.b r110 = new eb9.e.b(R.string.larus_groupChats_navBar_chatGroup_recents);
        c0 r102 = this.f345542a;
        com.larus.home.impl.main.side_bar.view.group.render.z r103 = r102.f345479p.f345521f;
        boolean r104 = this.f345546e;
        OmniPinStatus r105 = OmniPinStatus.PinStatus_UNPIN;
        OmniConversationProjectStatus r106 = this.f345544c;
        com.larus.home.impl.main.side_bar.view.group.datasource.im.k0 r107 = this.f345545d;
        r101.getClass();
        return n0.f(r101, r100, "conversation", r110, n0.a(r101, r102, "conversation", r103, r104, n0.c(r102, r103, r105, r106, r107), u0.a(this.f345542a, "conversation", this.f345543b), null, null, null, null, false, "main_conversations", 1984), null, 240);
    }

    public t0(c0 r100, boolean r101, OmniConversationProjectStatus r102, com.larus.home.impl.main.side_bar.view.group.datasource.im.k0.c r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r102 = OmniConversationProjectStatus.ConversationProjectStatus_ALL;
    L5:
        com.larus.home.impl.main.side_bar.view.group.datasource.im.k0 r105 = r103;
        if ((r104 & 8) == 0) goto L9;
        r105 = com.larus.home.impl.main.side_bar.view.group.datasource.im.k0.a.f345356a;
    L9:
        if ((r104 & 16) == 0) goto L11;
        boolean r106 = true;
    L12:
        Intrinsics.checkNotNullParameter(r100, "deps");
        Intrinsics.checkNotNullParameter(r102, "projectStatus");
        Intrinsics.checkNotNullParameter(r105, "deviceScope");
        this.f345542a = r100;
        this.f345543b = r101;
        this.f345544c = r102;
        this.f345545d = r105;
        this.f345546e = r106;
        return;
    L11:
        r106 = false;
        goto L12
    }
}

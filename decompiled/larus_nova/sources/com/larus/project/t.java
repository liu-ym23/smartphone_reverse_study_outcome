package com.larus.project;

import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t implements IProjectCreatePanelService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskProjectFragment f367059a;

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void a(boolean r100) {
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void c() {
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void d(boolean r100) {
    }

    public t(TaskProjectFragment r100) {
        this.f367059a = r100;
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void b(com.larus.bmhome.taskskill.service.a r110) {
        Intrinsics.checkNotNullParameter(r110, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        TaskProjectFragment r100 = this.f367059a;
        String r101 = r110.f314427a;
        String r102 = r110.f314428b;
        String r103 = r110.f314432f;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        i r105 = new i(r101, r102, r104, r110.f314431e, r110.f314432f, r110.f314429c, r110.f314430d);
        int r111 = TaskProjectFragment.f366975w;
        TaskProjectFragment.W90(r100, r100.ia0(r105));
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}

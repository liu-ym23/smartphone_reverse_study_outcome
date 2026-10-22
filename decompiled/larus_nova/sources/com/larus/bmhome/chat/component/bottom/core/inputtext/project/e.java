package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements IProjectCreatePanelService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectPanelController f299130a;

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void a(boolean r100) {
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void c() {
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void d(boolean r100) {
    }

    public e(ProjectPanelController r100) {
        this.f299130a = r100;
    }

    @Override // com.larus.bmhome.taskskill.service.IProjectCreatePanelService.a
    public final void b(com.larus.bmhome.taskskill.service.a r110) {
        Intrinsics.checkNotNullParameter(r110, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        if (this.f299130a.c() == true) goto L5;
        return;
    L5:
        be8.a r100 = this.f299130a.f299111d.invoke();
        if (r100 == null) goto L15;
        String r101 = r110.f314427a;
        String r102 = r110.f314428b;
        String r103 = r110.f314432f;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        r100.UF(new be8.f(r101, r102, r104, r110.f314431e, r110.f314432f, r110.f314429c, r110.f314430d, 128), null);
        goto L15
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L15:
        this.f299130a.f299114g.invoke();
    }
}

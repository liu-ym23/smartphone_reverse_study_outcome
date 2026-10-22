package com.larus.home.impl.main.side_bar.view.group.assembly;

import android.content.Context;
import com.larus.im.bean.conversation.ArchiveStatus;
import com.larus.nova.R;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideBarTimeGroupArchiveHandler f345199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArchiveStatus f345200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f345201c;

    public /* synthetic */ z(SideBarTimeGroupArchiveHandler r100, ArchiveStatus r101, String r102) {
        this.f345199a = r100;
        this.f345200b = r101;
        this.f345201c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SideBarTimeGroupArchiveHandler r100 = this.f345199a;
        ArchiveStatus r101 = this.f345200b;
        String r102 = this.f345201c;
        r100.f345154d = false;
        Context r103 = r100.f345151a.getContext();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100.f345151a.getView() == null) goto L19;
        int r104 = SideBarTimeGroupArchiveHandler.b.f345157b[r101.ordinal()];
        if (r104 != 1) goto L9;
        t19.s r105 = t19.s.f544207a;
        String r106 = r103.getString(R.string.larus_infra_archiveChat_toast_allTimeGroupArchived, new Object[]{r102});
        r105.getClass();
        t19.s.p(r103, r106);
        return;
    L9:
        if (r104 != 2) goto L11;
        t19.s.f544207a.getClass();
        t19.s.s(r103, R.string.larus_infra_archiveChat_toast_projectChatsPartlyHidden);
        return;
    L11:
        if (r104 != 3) goto L14;
        t19.s.f544207a.getClass();
        t19.s.s(r103, R.string.larus_infra_archiveChat_toast_projectChatsHiddenFail);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}

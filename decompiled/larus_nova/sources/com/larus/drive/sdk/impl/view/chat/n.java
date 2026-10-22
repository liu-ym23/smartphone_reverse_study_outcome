package com.larus.drive.sdk.impl.view.chat;

import com.larus.utils.logger.FLogger;
import va8.g0;

/* JADX INFO: loaded from: classes27.dex */
public final class n implements va8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFloatChatContainer f342227a;

    @Override // va8.d
    public final void foldStatusChanged() {
        DriveFloatChatContainer.c r100 = this.f342227a.f342060g;
        if (r100 == null) goto L5;
        g0 r101 = r100.b();
    L6:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[foldStatusChanged] isExpanded=");
        boolean r104 = true;
        if (r101 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        r103.append(r105);
        r103.append(", containerId=");
        r103.append(this.f342227a.f342056c);
        r102.i("DriveFloatChatContainer", r103.toString());
        DriveFloatChatContainer.a r106 = this.f342227a.f342058e;
        if (r101 != null) goto L15;
    L17:
        r104 = false;
    L18:
        r106.a(r104, r101);
        return;
    L15:
        if (r101.YC() != true) goto L17;
    L9:
        if (r101.YC() != true) goto L11;
        r105 = true;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public n(DriveFloatChatContainer r100) {
        this.f342227a = r100;
    }
}

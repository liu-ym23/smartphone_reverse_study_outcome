package com.larus.drive.sdk.impl.view.chat;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFloatChatContainer f342228a;

    public o(DriveFloatChatContainer r100) {
        this.f342228a = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
    public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("DriveFloatChatContainer", "[onStateChanged] state=" + r100);
        if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L6;
        this.f342228a.f342058e.b(((com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r100).f299423a, true);
        return;
    }
}

package com.bytedance.applet.aibridge.luna;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import f3.h;
import tx9.v1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements u {
    public final /* synthetic */ h<AbsJumpToLunaMethodIDL.b> a;

    public final void cancel() {
        v1.a("member", CommentPublishScene.UNKNOWN, 0, "user_cancel", 48);
        FLogger.a.i("JumpToLunaMethod", "member fail, errorMsg: user_cancel");
        h.a.a(this.a, "user_cancel", null, null, 14);
    }

    public b(h<AbsJumpToLunaMethodIDL.b> r1) {
        this.a = r1;
    }
}

package com.bytedance.applet.base;

import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import kotlin.jvm.internal.Intrinsics;
import r2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements AppletChatInputController {
    public final Fragment a;
    public boolean b;

    public final void A7(AppletFullScreenActivity.b r1) {
    }

    public final void I1(boolean r1, boolean r2) {
    }

    public final void q7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
    }

    public final void r7(AppletModelContextProvider r1) {
    }

    public final void t7() {
    }

    public final f u6() {
        return null;
    }

    public final void u7(AppletChatInputController.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void x7(String r1, String r2) {
    }

    public final void z7(AppletChatInputController.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public d() {
        this.a = new Fragment();
    }

    public final Fragment getFragment() {
        return this.a;
    }

    public final boolean getVisibility() {
        return this.b;
    }

    public final void s7(AppletChatInputController.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void setVisibility(boolean r1) {
        this.b = r1;
    }

    public final void v7(r2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final void w7(AppletChatInputController.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void y7(AppletChatInputController.d r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }
}

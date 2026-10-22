package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f414069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f414070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Chat f414071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f414072d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f414069a, r101.f414069a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f414070b, r101.f414070b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f414071c, r101.f414071c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f414072d, r101.f414072d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f414069a.hashCode() * 31) + this.f414070b.hashCode()) * 31) + this.f414071c.hashCode()) * 31) + this.f414072d.hashCode();
    }

    public final String toString() {
        return "ClickContext(context=" + this.f414069a + ", fragment=" + this.f414070b + ", chat=" + this.f414071c + ", message=" + this.f414072d + ')';
    }

    public final Context getContext() {
        return this.f414069a;
    }

    public c(FragmentActivity r100, MessageFullScreenFragment r101, Chat r102, Message r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "chat");
        Intrinsics.checkNotNullParameter(r103, "message");
        this.f414069a = r100;
        this.f414070b = r101;
        this.f414071c = r102;
        this.f414072d = r103;
    }
}

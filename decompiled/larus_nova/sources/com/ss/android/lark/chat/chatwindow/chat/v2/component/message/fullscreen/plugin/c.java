package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f414003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f414004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MessageFullScreenViewModel f414005c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f414003a, r101.f414003a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f414004b, r101.f414004b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f414005c, r101.f414005c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f414003a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f414004b.hashCode()) * 31) + this.f414005c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PluginContext(context=" + this.f414003a + ", fragment=" + this.f414004b + ", viewModel=" + this.f414005c + ')';
    }

    public final Context getContext() {
        return this.f414003a;
    }

    public c(Context r100, Fragment r101, MessageFullScreenViewModel r102) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f414003a = r100;
        this.f414004b = r101;
        this.f414005c = r102;
    }
}

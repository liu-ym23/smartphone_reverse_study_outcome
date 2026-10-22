package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.BadgeBackView;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements CoreNavigationBar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j f423093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TitleTheme.ThemeType f423094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TitleBarActionKey f423095c;

    public i(com.ss.android.lark.biz.im.api.extension.chat_window.j r100, TitleTheme.ThemeType r101, TitleBarActionKey r102) {
        this.f423093a = r100;
        this.f423094b = r101;
        this.f423095c = r102;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        BadgeBackView r101 = ((com.ss.android.lark.biz.im.api.extension.chat_window.m) this.f423093a).a(this.f423094b);
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 == null) goto L8;
        r103.removeView(r101);
    L8:
        r101.setTag(this.f423095c);
        return r101;
    L5:
        r103 = null;
        goto L6
    }
}

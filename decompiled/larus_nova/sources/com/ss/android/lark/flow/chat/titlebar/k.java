package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements CoreNavigationBar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j f423099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TitleTheme.ThemeType f423100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TitleBarActionKey f423101c;

    public k(com.ss.android.lark.biz.im.api.extension.chat_window.j r100, TitleTheme.ThemeType r101, TitleBarActionKey r102) {
        this.f423099a = r100;
        this.f423100b = r101;
        this.f423101c = r102;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppCompatImageView r101 = new AppCompatImageView(r100);
        com.ss.android.lark.biz.im.api.extension.chat_window.j r102 = this.f423099a;
        TitleTheme.ThemeType r103 = this.f423100b;
        TitleBarActionKey r104 = this.f423101c;
        r101.setScaleType(ImageView.ScaleType.CENTER);
        r101.setImageDrawable(((com.ss.android.lark.biz.im.api.extension.chat_window.k) r102).g(r103));
        r101.setTag(r104);
        return r101;
    }
}

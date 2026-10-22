package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements CoreNavigationBar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j f423096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TitleTheme.ThemeType f423097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TitleBarActionKey f423098c;

    public j(com.ss.android.lark.biz.im.api.extension.chat_window.j r100, TitleTheme.ThemeType r101, TitleBarActionKey r102) {
        this.f423096a = r100;
        this.f423097b = r101;
        this.f423098c = r102;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppCompatTextView r101 = new AppCompatTextView(r100);
        com.ss.android.lark.biz.im.api.extension.chat_window.j r102 = this.f423096a;
        TitleTheme.ThemeType r103 = this.f423097b;
        TitleBarActionKey r104 = this.f423098c;
        com.ss.android.lark.biz.im.api.extension.chat_window.l r105 = (com.ss.android.lark.biz.im.api.extension.chat_window.l) r102;
        r101.setText(r105.getText());
        r105.getTextSize();
        r101.setTextSize(2, 17);
        r105.c(r103);
        r101.setTextColor(ContextCompat.getColor(r100, R.color.flow_ud_neutral_100));
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setGravity(17);
        r101.setTag(r104);
        r101.setPadding(r105.e(), r105.b(), r105.e(), r105.b());
        return r101;
    }
}

package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements CoreNavigationBar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleBarActionKey f423102a;

    public l(TitleBarActionKey r100) {
        this.f423102a = r100;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppCompatTextView r101 = new AppCompatTextView(r100);
        TitleBarActionKey r102 = this.f423102a;
        r101.setText("");
        r101.setTag(r102);
        return r101;
    }
}

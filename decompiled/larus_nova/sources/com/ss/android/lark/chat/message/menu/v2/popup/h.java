package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends View {
    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, false, 0.5f, R.color.ud_neutral_color_10, 16);
    }

    public h(Context r100, boolean r101, float r102, int r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        if (r101 == false) goto L5;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(UIUtils.dp2px(r100, r102), UIUtils.dp2px(r100, 30.0f));
        r105.gravity = 16;
        ViewGroup.LayoutParams r106 = r105;
    L6:
        setLayoutParams(r106);
        setBackgroundColor(UIUtils.getColor(r100, r103));
        return;
    L5:
        ViewGroup.MarginLayoutParams r107 = new ViewGroup.MarginLayoutParams(-1, UIUtils.dp2px(r100, r102));
        r107.setMarginStart(UIUtils.dp2px(r100, r104));
        r107.setMarginEnd(UIUtils.dp2px(r100, r104));
        r106 = r107;
        goto L6
    }

    public /* synthetic */ h(Context r100, boolean r101, float r102, int r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        float r103 = 0.5f;
    L7:
        if ((r111 & 8) == 0) goto L9;
        int r104 = R.color.ud_neutral_color_10;
    L11:
        if ((r111 & 16) == 0) goto L13;
        float r105 = 16.0f;
    L14:
        this(r100, r101, r103, r104, r105);
        return;
    L13:
        r105 = 0.0f;
        goto L14
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }
}

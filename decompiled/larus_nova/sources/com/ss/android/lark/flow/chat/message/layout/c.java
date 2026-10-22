package com.ss.android.lark.flow.chat.message.layout;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f422607a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f422608b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f422609c = 0;

    static {
        f422607a = UIHelper.dp2px(7.0f);
        f422608b = UIHelper.dp2px(2.0f);
        f422609c = UIHelper.dp2px(12.0f);
    }

    public static int a(m2b.a r100) {
        if (r100.e0() == true) goto L9;
        if (r100.getChat() == null) goto L9;
        return f422609c;
    L9:
        return f422607a;
    }
}

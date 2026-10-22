package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f413317a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f413318b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f413319c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f413320d = 0;

    static {
        f413317a = UIHelper.dp2px(7.0f);
        f413318b = UIHelper.dp2px(2.0f);
        f413319c = UIHelper.dp2px(12.0f);
        f413320d = UIHelper.dp2px(8.0f);
    }

    public static int a(m2b.a r100) {
        if (r100.e0() == true) goto L9;
        if (r100.getChat() == null) goto L9;
        return f413319c;
    L9:
        return f413317a;
    }
}

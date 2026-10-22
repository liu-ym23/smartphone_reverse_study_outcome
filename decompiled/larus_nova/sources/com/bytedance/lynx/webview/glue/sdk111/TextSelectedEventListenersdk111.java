package com.bytedance.lynx.webview.glue.sdk111;

/* JADX INFO: loaded from: classes21.dex */
public abstract class TextSelectedEventListenersdk111 {
    public static final int COPY = 0;
    public static final int CUT = 1;
    public static final int ON_DESTROY = 8;
    public static final int ON_SHOW = 7;
    public static final int PASTE = 2;
    public static final int PASTE_AS_PLAIN_TEXT = 6;
    public static final int SELECT_ALL = 3;
    public static final int SHARE = 4;
    public static final int WEB_SEARCH = 5;

    public TextSelectedEventListenersdk111() {
    }

    public abstract void onTextSelectedEvent(int r100, String r101);
}

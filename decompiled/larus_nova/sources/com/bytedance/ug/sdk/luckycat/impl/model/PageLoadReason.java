package com.bytedance.ug.sdk.luckycat.impl.model;

/* JADX INFO: loaded from: classes22.dex */
public final enum PageLoadReason extends Enum<PageLoadReason> {
    public static final PageLoadReason BULLET_CONTAINER = null;
    public static final PageLoadReason KEEP_LIVE_RETRY = null;
    public static final PageLoadReason MANUAL_RETRY = null;
    public static final PageLoadReason NEW_PAGE = null;
    public static final PageLoadReason PAGE_RELOAD = null;
    public static final PageLoadReason PLUGIN_MANUAL_RETRY = null;
    public static final PageLoadReason PRE_LOAD = null;
    public static final PageLoadReason RENDER_PROCESS_GONE = null;
    public static final PageLoadReason TAB_CLICK = null;
    public static final PageLoadReason TAB_PRE_LOAD = null;
    public static final PageLoadReason TAB_REFRESH = null;
    public static final PageLoadReason URL_REPLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageLoadReason[] f271379a = null;
    public String reason;

    static {
        PageLoadReason r100 = new PageLoadReason("NEW_PAGE", 0, "open_new_page");
        NEW_PAGE = r100;
        PageLoadReason r101 = new PageLoadReason("PRE_LOAD", 1, "pre_load");
        PRE_LOAD = r101;
        PageLoadReason r102 = new PageLoadReason("TAB_PRE_LOAD", 2, "tab_pre_load");
        TAB_PRE_LOAD = r102;
        PageLoadReason r103 = new PageLoadReason("TAB_REFRESH", 3, "tab_refresh");
        TAB_REFRESH = r103;
        PageLoadReason r104 = new PageLoadReason("TAB_CLICK", 4, "tab_click");
        TAB_CLICK = r104;
        PageLoadReason r105 = new PageLoadReason("PAGE_RELOAD", 5, "page_reload");
        PAGE_RELOAD = r105;
        PageLoadReason r110 = new PageLoadReason("KEEP_LIVE_RETRY", 6, "keep_live_retry");
        KEEP_LIVE_RETRY = r110;
        PageLoadReason r111 = new PageLoadReason("MANUAL_RETRY", 7, "manual_retry");
        MANUAL_RETRY = r111;
        PageLoadReason r112 = new PageLoadReason("PLUGIN_MANUAL_RETRY", 8, "plugin_manual_retry");
        PLUGIN_MANUAL_RETRY = r112;
        PageLoadReason r113 = new PageLoadReason("RENDER_PROCESS_GONE", 9, "render_process_gone");
        RENDER_PROCESS_GONE = r113;
        PageLoadReason r114 = new PageLoadReason("URL_REPLACE", 10, "url_replace");
        URL_REPLACE = r114;
        PageLoadReason r106 = new PageLoadReason("BULLET_CONTAINER", 11, "bullet_container");
        BULLET_CONTAINER = r106;
        f271379a = new PageLoadReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
    }

    public static PageLoadReason[] values() {
        return (PageLoadReason[]) f271379a.clone();
    }

    public static PageLoadReason valueOf(String r100) {
        return (PageLoadReason) r27.a.a(PageLoadReason.class, r100);
    }

    public PageLoadReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}

package z5c;

/* JADX INFO: loaded from: classes38.dex */
public final class n2 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570263c = null;

    static {
        n2 r100 = new n2();
        r100.a("需要区分页面类型（im仅支持user、云文档两类，本期不包含群名片）");
        r100.a("all");
        r100.a("user");
        r100.a("doc");
        r100.a("main_view");
        r100.a("folder_view");
        r100.a("floating_menu");
        f570263c = r100.a("overlay_menu");
    }

    public n2() {
        super("page_type");
    }
}

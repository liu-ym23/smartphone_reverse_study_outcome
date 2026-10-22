package z5c;

import com.bytedance.sdk.account.platform.api.IVKService;

/* JADX INFO: loaded from: classes38.dex */
public final class o3 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570272d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s5c.a f570273e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s5c.a f570274f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s5c.a f570275g = null;

    static {
        o3 r100 = new o3();
        r100.a("normal_group");
        r100.a("topic");
        r100.a("permission_approval");
        r100.a("pin");
        r100.a("basic_info");
        r100.a("vc_setting");
        r100.a("create_new");
        r100.a("select_from_existing_fields");
        r100.a("widget_tab");
        f570271c = r100.a("all");
        f570272d = r100.a(IVKService.ResponseConstants.CREATED);
        f570273e = r100.a("collaborated");
        f570274f = r100.a("from_doc");
        f570275g = r100.a("from_chat");
        r100.a("archived");
        r100.a("image");
        r100.a("doc_and_resources");
    }

    public o3() {
        super("tab_type");
    }
}

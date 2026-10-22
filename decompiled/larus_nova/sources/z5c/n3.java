package z5c;

import com.bytedance.sdk.account.platform.api.IVKService;

/* JADX INFO: loaded from: classes38.dex */
public final class n3 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570264c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570265d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s5c.a f570266e = null;

    static {
        n3 r100 = new n3();
        f570264c = r100.a("recently_used");
        f570265d = r100.a("all");
        r100.a("in_charge");
        r100.a(IVKService.ResponseConstants.CREATED);
        r100.a("followed");
        r100.a("assigned");
        r100.a("no_deadline");
        r100.a("no_owner");
        r100.a("completed");
        r100.a("from_doc");
        r100.a("recent_collaborator");
        f570266e = r100.a("commonly_used");
        r100.a("full_block");
        r100.a("restriction_block");
    }

    public n3() {
        super("tab");
    }
}

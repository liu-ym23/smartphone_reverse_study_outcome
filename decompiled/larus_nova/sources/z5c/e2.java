package z5c;

import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: classes38.dex */
public final class e2 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570190c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570191d = null;

    static {
        e2 r100 = new e2();
        r100.a("im");
        r100.a("all_user");
        r100.a("user");
        r100.a("doc");
        r100.a("chat");
        r100.a(DocumentType.BITABLE_NAME);
        r100.a(DocumentType.SHEET_NAME);
        f570190c = r100.a("mention_recommand");
        f570191d = r100.a("chat_member");
    }

    public e2() {
        super("mention_type");
    }
}

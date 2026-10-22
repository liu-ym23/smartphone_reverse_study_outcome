package com.bytedance.ee.space.sync;

import faceverify.q;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/space/sync/PushResource$EType;", "", "data", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "NOTICE", "PERMISSION_CHANGE", "WIKI_TREE", "LIKE", q.KEY_TOKEN, "BULLETIN", "Companion", "contentmanager-space-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushResource$EType extends Enum<PushResource$EType> {
    public static final PushResource$EType BULLETIN = null;
    public static final a Companion = null;
    public static final String KEY_NAME = "resource_type";
    public static final PushResource$EType LIKE = null;
    public static final PushResource$EType NOTICE = null;
    public static final PushResource$EType PERMISSION_CHANGE = null;
    public static final PushResource$EType TOKEN = null;
    public static final PushResource$EType WIKI_TREE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushResource$EType[] f243070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243071b = null;
    private final String data;

    public static EnumEntries<PushResource$EType> getEntries() {
        return f243071b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.space.sync.PushResource$EType$a] */
    static {
        PushResource$EType r100 = new PushResource$EType("NOTICE", 0, "NOTICE");
        NOTICE = r100;
        PushResource$EType r101 = new PushResource$EType("PERMISSION_CHANGE", 1, "PERMISSION_CHANGE");
        PERMISSION_CHANGE = r101;
        PushResource$EType r102 = new PushResource$EType("WIKI_TREE", 2, "WIKI_TREE");
        WIKI_TREE = r102;
        PushResource$EType r103 = new PushResource$EType("LIKE", 3, "LIKE");
        LIKE = r103;
        PushResource$EType r104 = new PushResource$EType(q.KEY_TOKEN, 4, "token");
        TOKEN = r104;
        PushResource$EType r105 = new PushResource$EType("BULLETIN", 5, "BULLETIN");
        BULLETIN = r105;
        PushResource$EType[] r110 = {r100, r101, r102, r103, r104, r105};
        f243070a = r110;
        f243071b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static PushResource$EType[] values() {
        return (PushResource$EType[]) f243070a.clone();
    }

    public final String getData() {
        return this.data;
    }

    public static PushResource$EType valueOf(String r100) {
        return (PushResource$EType) r27.a.a(PushResource$EType.class, r100);
    }

    public PushResource$EType(String r100, int r101, String r102) {
        super(r100, r101);
        this.data = r102;
    }
}

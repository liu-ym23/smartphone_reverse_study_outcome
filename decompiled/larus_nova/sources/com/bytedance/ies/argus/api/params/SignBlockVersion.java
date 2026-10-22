package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/params/SignBlockVersion;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "OLD", "NEW", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SignBlockVersion extends Enum<SignBlockVersion> {
    public static final SignBlockVersion NEW = null;
    public static final SignBlockVersion OLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignBlockVersion[] f245695a = null;
    private final String strValue;

    public static SignBlockVersion valueOf(String r100) {
        return (SignBlockVersion) r27.a.a(SignBlockVersion.class, r100);
    }

    public static SignBlockVersion[] values() {
        return (SignBlockVersion[]) f245695a.clone();
    }

    static {
        SignBlockVersion r100 = new SignBlockVersion("OLD", 0, "old");
        OLD = r100;
        SignBlockVersion r101 = new SignBlockVersion("NEW", 1, "new");
        NEW = r101;
        f245695a = new SignBlockVersion[]{r100, r101};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public SignBlockVersion(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}

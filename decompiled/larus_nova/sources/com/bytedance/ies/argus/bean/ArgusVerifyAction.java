package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "", "Lcom/bytedance/ies/argus/bean/q;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "", "index", "I", "getIndex", "()I", "PASS", "REWRITE", "BLOCK", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusVerifyAction extends Enum<ArgusVerifyAction> implements q {
    public static final ArgusVerifyAction BLOCK = null;
    public static final ArgusVerifyAction PASS = null;
    public static final ArgusVerifyAction REWRITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusVerifyAction[] f245975a = null;
    private final int index;
    private final String stringValue;

    public static ArgusVerifyAction valueOf(String r100) {
        return (ArgusVerifyAction) r27.a.a(ArgusVerifyAction.class, r100);
    }

    public static ArgusVerifyAction[] values() {
        return (ArgusVerifyAction[]) f245975a.clone();
    }

    static {
        ArgusVerifyAction r100 = new ArgusVerifyAction("PASS", 0, "pass", 0);
        PASS = r100;
        ArgusVerifyAction r101 = new ArgusVerifyAction("REWRITE", 1, "rewrite", 1);
        REWRITE = r101;
        ArgusVerifyAction r102 = new ArgusVerifyAction("BLOCK", 2, "block", 2);
        BLOCK = r102;
        f245975a = new ArgusVerifyAction[]{r100, r101, r102};
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    public ArgusVerifyAction(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.stringValue = r102;
        this.index = r103;
    }
}

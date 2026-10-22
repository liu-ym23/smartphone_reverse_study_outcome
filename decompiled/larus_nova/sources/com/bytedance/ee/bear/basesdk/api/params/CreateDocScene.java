package com.bytedance.ee.bear.basesdk.api.params;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/api/params/CreateDocScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENTERPRICE_QA", "DEFAULT", "basesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateDocScene extends Enum<CreateDocScene> {
    public static final CreateDocScene DEFAULT = null;
    public static final CreateDocScene ENTERPRICE_QA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateDocScene[] f206494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206495b = null;
    private final String value;

    public static EnumEntries<CreateDocScene> getEntries() {
        return f206495b;
    }

    static {
        CreateDocScene r100 = new CreateDocScene("ENTERPRICE_QA", 0, "enterprice_qa_upload");
        ENTERPRICE_QA = r100;
        CreateDocScene r101 = new CreateDocScene("DEFAULT", 1, "");
        DEFAULT = r101;
        CreateDocScene[] r102 = {r100, r101};
        f206494a = r102;
        f206495b = EnumEntriesKt.enumEntries(r102);
    }

    public static CreateDocScene[] values() {
        return (CreateDocScene[]) f206494a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreateDocScene valueOf(String r100) {
        return (CreateDocScene) a.a(CreateDocScene.class, r100);
    }

    public CreateDocScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

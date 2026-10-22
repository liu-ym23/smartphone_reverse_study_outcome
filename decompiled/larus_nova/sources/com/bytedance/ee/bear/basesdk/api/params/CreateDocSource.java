package com.bytedance.ee.bear.basesdk.api.params;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/api/params/CreateDocSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ENTERPRICE_QA", "DEFAULT", "basesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateDocSource extends Enum<CreateDocSource> {
    public static final CreateDocSource DEFAULT = null;
    public static final CreateDocSource ENTERPRICE_QA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateDocSource[] f206496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206497b = null;
    private final int value;

    public static EnumEntries<CreateDocSource> getEntries() {
        return f206497b;
    }

    static {
        CreateDocSource r100 = new CreateDocSource("ENTERPRICE_QA", 0, 86);
        ENTERPRICE_QA = r100;
        CreateDocSource r101 = new CreateDocSource("DEFAULT", 1, 0);
        DEFAULT = r101;
        CreateDocSource[] r102 = {r100, r101};
        f206496a = r102;
        f206497b = EnumEntriesKt.enumEntries(r102);
    }

    public static CreateDocSource[] values() {
        return (CreateDocSource[]) f206496a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CreateDocSource valueOf(String r100) {
        return (CreateDocSource) a.a(CreateDocSource.class, r100);
    }

    public CreateDocSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

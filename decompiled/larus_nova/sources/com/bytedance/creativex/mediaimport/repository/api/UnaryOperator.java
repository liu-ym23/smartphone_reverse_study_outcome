package com.bytedance.creativex.mediaimport.repository.api;

import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/UnaryOperator;", "Lcom/bytedance/creativex/mediaimport/repository/api/Operator;", "", "option", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOption", "()Ljava/lang/String;", "EQUAL", "GREATER", "LESS", "GOE", "LOE", "LIKE", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UnaryOperator extends Enum<UnaryOperator> {
    public static final UnaryOperator EQUAL = null;
    public static final UnaryOperator GOE = null;
    public static final UnaryOperator GREATER = null;
    public static final UnaryOperator LESS = null;
    public static final UnaryOperator LIKE = null;
    public static final UnaryOperator LOE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnaryOperator[] f203624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203625b = null;
    private final String option;

    public static EnumEntries<UnaryOperator> getEntries() {
        return f203625b;
    }

    static {
        UnaryOperator r100 = new UnaryOperator("EQUAL", 0, ContainerUtils.KEY_VALUE_DELIMITER);
        EQUAL = r100;
        UnaryOperator r101 = new UnaryOperator("GREATER", 1, ">");
        GREATER = r101;
        UnaryOperator r102 = new UnaryOperator("LESS", 2, "<");
        LESS = r102;
        UnaryOperator r103 = new UnaryOperator("GOE", 3, ">=");
        GOE = r103;
        UnaryOperator r104 = new UnaryOperator("LOE", 4, "<=");
        LOE = r104;
        UnaryOperator r105 = new UnaryOperator("LIKE", 5, "LIKE");
        LIKE = r105;
        UnaryOperator[] r110 = {r100, r101, r102, r103, r104, r105};
        f203624a = r110;
        f203625b = EnumEntriesKt.enumEntries(r110);
    }

    public static UnaryOperator[] values() {
        return (UnaryOperator[]) f203624a.clone();
    }

    public String getOption() {
        return this.option;
    }

    public static UnaryOperator valueOf(String r100) {
        return (UnaryOperator) r27.a.a(UnaryOperator.class, r100);
    }

    public UnaryOperator(String r100, int r101, String r102) {
        super(r100, r101);
        this.option = r102;
    }
}

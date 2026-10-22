package com.ss.android.lark.maintab.export.opennavi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/maintab/export/opennavi/OpenNavBizType;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "CCM", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenNavBizType extends Enum<OpenNavBizType> {
    public static final OpenNavBizType CCM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenNavBizType[] f431622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431623b = null;
    private final int priority;

    public static EnumEntries<OpenNavBizType> getEntries() {
        return f431623b;
    }

    static {
        OpenNavBizType r100 = new OpenNavBizType();
        CCM = r100;
        OpenNavBizType[] r101 = {r100};
        f431622a = r101;
        f431623b = EnumEntriesKt.enumEntries(r101);
    }

    public OpenNavBizType() {
        super("CCM", 0);
        this.priority = 10;
    }

    public static OpenNavBizType[] values() {
        return (OpenNavBizType[]) f431622a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public static OpenNavBizType valueOf(String r100) {
        return (OpenNavBizType) a.a(OpenNavBizType.class, r100);
    }
}

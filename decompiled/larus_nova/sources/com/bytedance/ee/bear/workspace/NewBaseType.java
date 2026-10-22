package com.bytedance.ee.bear.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/workspace/NewBaseType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "App", "Form", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NewBaseType extends Enum<NewBaseType> {
    public static final NewBaseType App = null;
    public static final NewBaseType Form = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NewBaseType[] f242621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242622b = null;
    private final String value;

    public static EnumEntries<NewBaseType> getEntries() {
        return f242622b;
    }

    static {
        NewBaseType r100 = new NewBaseType("App", 0, "bitable_application");
        App = r100;
        NewBaseType r101 = new NewBaseType("Form", 1, "bitable_form");
        Form = r101;
        NewBaseType[] r102 = {r100, r101};
        f242621a = r102;
        f242622b = EnumEntriesKt.enumEntries(r102);
    }

    public static NewBaseType[] values() {
        return (NewBaseType[]) f242621a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NewBaseType valueOf(String r100) {
        return (NewBaseType) a.a(NewBaseType.class, r100);
    }

    public NewBaseType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

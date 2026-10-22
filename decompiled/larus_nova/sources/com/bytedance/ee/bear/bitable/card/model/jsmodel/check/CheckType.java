package com.bytedance.ee.bear.bitable.card.model.jsmodel.check;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/CheckType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SetFieldAttr", "ConfirmConvertType", "ConfirmConvertModifiedTime", "ConfirmKeepNoExistData", "ConfirmConvertPeople", "ConfirmExtendFieldDelete", "ConfirmAIGenerate", "ConfirmAIFieldTypeChange", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CheckType extends Enum<CheckType> {
    public static final CheckType ConfirmAIFieldTypeChange = null;
    public static final CheckType ConfirmAIGenerate = null;
    public static final CheckType ConfirmConvertModifiedTime = null;
    public static final CheckType ConfirmConvertPeople = null;
    public static final CheckType ConfirmConvertType = null;
    public static final CheckType ConfirmExtendFieldDelete = null;
    public static final CheckType ConfirmKeepNoExistData = null;
    public static final CheckType SetFieldAttr = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckType[] f207103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207104b = null;
    private final String value;

    public static EnumEntries<CheckType> getEntries() {
        return f207104b;
    }

    static {
        CheckType r100 = new CheckType("SetFieldAttr", 0, "SetFieldAttr");
        SetFieldAttr = r100;
        CheckType r101 = new CheckType("ConfirmConvertType", 1, "ConfirmConvertType");
        ConfirmConvertType = r101;
        CheckType r102 = new CheckType("ConfirmConvertModifiedTime", 2, "ConfirmConvertModifiedTime");
        ConfirmConvertModifiedTime = r102;
        CheckType r103 = new CheckType("ConfirmKeepNoExistData", 3, "ConfirmKeepNoExistData");
        ConfirmKeepNoExistData = r103;
        CheckType r104 = new CheckType("ConfirmConvertPeople", 4, "ConfirmConvertPeople");
        ConfirmConvertPeople = r104;
        CheckType r105 = new CheckType("ConfirmExtendFieldDelete", 5, "ConfirmExtendFieldDelete");
        ConfirmExtendFieldDelete = r105;
        CheckType r110 = new CheckType("ConfirmAIGenerate", 6, "ConfirmAIGenerate");
        ConfirmAIGenerate = r110;
        CheckType r111 = new CheckType("ConfirmAIFieldTypeChange", 7, "ConfirmAIFieldTypeChange");
        ConfirmAIFieldTypeChange = r111;
        CheckType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f207103a = r112;
        f207104b = EnumEntriesKt.enumEntries(r112);
    }

    public static CheckType[] values() {
        return (CheckType[]) f207103a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CheckType valueOf(String r100) {
        return (CheckType) a.a(CheckType.class, r100);
    }

    public CheckType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

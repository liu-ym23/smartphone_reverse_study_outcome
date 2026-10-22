package com.larus.bmhome.instruction.core.model.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/widget/TranslatorSelectorType;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "TARGET", "VOICE", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TranslatorSelectorType extends Enum<TranslatorSelectorType> {
    public static final TranslatorSelectorType SOURCE = null;
    public static final TranslatorSelectorType TARGET = null;
    public static final TranslatorSelectorType VOICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TranslatorSelectorType[] f312059a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312060b = null;

    public static EnumEntries<TranslatorSelectorType> getEntries() {
        return f312060b;
    }

    static {
        TranslatorSelectorType r100 = new TranslatorSelectorType("SOURCE", 0);
        SOURCE = r100;
        TranslatorSelectorType r101 = new TranslatorSelectorType("TARGET", 1);
        TARGET = r101;
        TranslatorSelectorType r102 = new TranslatorSelectorType("VOICE", 2);
        VOICE = r102;
        TranslatorSelectorType[] r103 = {r100, r101, r102};
        f312059a = r103;
        f312060b = EnumEntriesKt.enumEntries(r103);
    }

    public static TranslatorSelectorType[] values() {
        return (TranslatorSelectorType[]) f312059a.clone();
    }

    public static TranslatorSelectorType valueOf(String r100) {
        return (TranslatorSelectorType) a.a(TranslatorSelectorType.class, r100);
    }

    public TranslatorSelectorType(String r100, int r101) {
        super(r100, r101);
    }
}

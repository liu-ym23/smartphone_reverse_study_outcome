package com.larus.bmhome.instruction.core.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarDisplayType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "SWITCH", "MENU", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarDisplayType extends Enum<ActionBarDisplayType> {
    public static final ActionBarDisplayType MENU = null;
    public static final ActionBarDisplayType NORMAL = null;
    public static final ActionBarDisplayType SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarDisplayType[] f312047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312048b = null;
    private final int value;

    public static EnumEntries<ActionBarDisplayType> getEntries() {
        return f312048b;
    }

    static {
        ActionBarDisplayType r100 = new ActionBarDisplayType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ActionBarDisplayType r101 = new ActionBarDisplayType("SWITCH", 1, 1);
        SWITCH = r101;
        ActionBarDisplayType r102 = new ActionBarDisplayType("MENU", 2, 2);
        MENU = r102;
        ActionBarDisplayType[] r103 = {r100, r101, r102};
        f312047a = r103;
        f312048b = EnumEntriesKt.enumEntries(r103);
    }

    public static ActionBarDisplayType[] values() {
        return (ActionBarDisplayType[]) f312047a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionBarDisplayType valueOf(String r100) {
        return (ActionBarDisplayType) a.a(ActionBarDisplayType.class, r100);
    }

    public ActionBarDisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

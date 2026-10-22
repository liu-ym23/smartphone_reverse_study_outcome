package com.obric.sva.sdk.controller;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/controller/ExecuteCategory;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "NOT_RESTART_RECOG", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExecuteCategory extends Enum<ExecuteCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExecuteCategory[] $VALUES = null;
    public static final ExecuteCategory NORMAL = null;
    public static final ExecuteCategory NOT_RESTART_RECOG = null;

    private static final /* synthetic */ ExecuteCategory[] $values() {
        return new ExecuteCategory[]{NORMAL, NOT_RESTART_RECOG};
    }

    public static EnumEntries<ExecuteCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        NORMAL = new ExecuteCategory(EffectConstants.NORMAL, 0);
        NOT_RESTART_RECOG = new ExecuteCategory("NOT_RESTART_RECOG", 1);
        ExecuteCategory[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ExecuteCategory[] values() {
        return (ExecuteCategory[]) $VALUES.clone();
    }

    public static ExecuteCategory valueOf(String r100) {
        return (ExecuteCategory) r27.a.a(ExecuteCategory.class, r100);
    }

    private ExecuteCategory(String r100, int r101) {
        super(r100, r101);
    }
}

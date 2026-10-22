package com.larus.office.base.plugins.dialog;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/base/plugins/dialog/InputState;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ACTIVE", "ERROR", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputState extends Enum<InputState> {
    public static final InputState ACTIVE = null;
    public static final InputState ERROR = null;
    public static final InputState NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputState[] f360740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360741b = null;

    public static EnumEntries<InputState> getEntries() {
        return f360741b;
    }

    static {
        InputState r100 = new InputState(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        InputState r101 = new InputState("ACTIVE", 1);
        ACTIVE = r101;
        InputState r102 = new InputState("ERROR", 2);
        ERROR = r102;
        InputState[] r103 = {r100, r101, r102};
        f360740a = r103;
        f360741b = EnumEntriesKt.enumEntries(r103);
    }

    public static InputState[] values() {
        return (InputState[]) f360740a.clone();
    }

    public static InputState valueOf(String r100) {
        return (InputState) r27.a.a(InputState.class, r100);
    }

    public InputState(String r100, int r101) {
        super(r100, r101);
    }
}

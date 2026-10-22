package com.larus.canvas.feature.component.instruction.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "LOADING", "SELECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIOptionStatus extends Enum<UIOptionStatus> {
    public static final UIOptionStatus LOADING = null;
    public static final UIOptionStatus NORMAL = null;
    public static final UIOptionStatus SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UIOptionStatus[] f323167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323168b = null;

    public static EnumEntries<UIOptionStatus> getEntries() {
        return f323168b;
    }

    static {
        UIOptionStatus r100 = new UIOptionStatus(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        UIOptionStatus r101 = new UIOptionStatus("LOADING", 1);
        LOADING = r101;
        UIOptionStatus r102 = new UIOptionStatus("SELECTED", 2);
        SELECTED = r102;
        UIOptionStatus[] r103 = {r100, r101, r102};
        f323167a = r103;
        f323168b = EnumEntriesKt.enumEntries(r103);
    }

    public static UIOptionStatus[] values() {
        return (UIOptionStatus[]) f323167a.clone();
    }

    public static UIOptionStatus valueOf(String r100) {
        return (UIOptionStatus) r27.a.a(UIOptionStatus.class, r100);
    }

    public UIOptionStatus(String r100, int r101) {
        super(r100, r101);
    }
}

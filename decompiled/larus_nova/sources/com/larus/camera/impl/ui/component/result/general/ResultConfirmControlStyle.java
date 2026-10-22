package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultConfirmControlStyle;", "", "<init>", "(Ljava/lang/String;I)V", "GENERAL", "EDU", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultConfirmControlStyle extends Enum<ResultConfirmControlStyle> {
    public static final ResultConfirmControlStyle EDU = null;
    public static final ResultConfirmControlStyle GENERAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultConfirmControlStyle[] f322138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f322139b = null;

    public static EnumEntries<ResultConfirmControlStyle> getEntries() {
        return f322139b;
    }

    static {
        ResultConfirmControlStyle r100 = new ResultConfirmControlStyle("GENERAL", 0);
        GENERAL = r100;
        ResultConfirmControlStyle r101 = new ResultConfirmControlStyle("EDU", 1);
        EDU = r101;
        ResultConfirmControlStyle[] r102 = {r100, r101};
        f322138a = r102;
        f322139b = EnumEntriesKt.enumEntries(r102);
    }

    public static ResultConfirmControlStyle[] values() {
        return (ResultConfirmControlStyle[]) f322138a.clone();
    }

    public static ResultConfirmControlStyle valueOf(String r100) {
        return (ResultConfirmControlStyle) r27.a.a(ResultConfirmControlStyle.class, r100);
    }

    public ResultConfirmControlStyle(String r100, int r101) {
        super(r100, r101);
    }
}

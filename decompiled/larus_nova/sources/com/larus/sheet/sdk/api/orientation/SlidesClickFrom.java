package com.larus.sheet.sdk.api.orientation;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/SlidesClickFrom;", "", "clickFrom", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getClickFrom", "()Ljava/lang/String;", EffectConstants.NORMAL, "PRESENTATION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SlidesClickFrom extends Enum<SlidesClickFrom> {
    public static final SlidesClickFrom NORMAL = null;
    public static final SlidesClickFrom PRESENTATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlidesClickFrom[] f369135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f369136b = null;
    private final String clickFrom;

    public static EnumEntries<SlidesClickFrom> getEntries() {
        return f369136b;
    }

    static {
        SlidesClickFrom r100 = new SlidesClickFrom(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        SlidesClickFrom r101 = new SlidesClickFrom("PRESENTATION", 1, "presentation");
        PRESENTATION = r101;
        SlidesClickFrom[] r102 = {r100, r101};
        f369135a = r102;
        f369136b = EnumEntriesKt.enumEntries(r102);
    }

    public static SlidesClickFrom[] values() {
        return (SlidesClickFrom[]) f369135a.clone();
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public static SlidesClickFrom valueOf(String r100) {
        return (SlidesClickFrom) a.a(SlidesClickFrom.class, r100);
    }

    public SlidesClickFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.clickFrom = r102;
    }
}

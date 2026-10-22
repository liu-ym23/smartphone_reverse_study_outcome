package com.bytedance.ee.bear.onboarding.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/onboarding/export/OnBoardingColorStyle;", "", "bgColorRes", "", "shadowColorRes", "maskColorRes", "<init>", "(Ljava/lang/String;IIII)V", "getBgColorRes", "()I", "getShadowColorRes", "getMaskColorRes", "Blue", "features-onboarding-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnBoardingColorStyle extends Enum<OnBoardingColorStyle> {
    public static final OnBoardingColorStyle Blue = null;
    public static final /* synthetic */ OnBoardingColorStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int bgColorRes;
    private final int maskColorRes;
    private final int shadowColorRes;

    public static EnumEntries<OnBoardingColorStyle> getEntries() {
        return b;
    }

    static {
        OnBoardingColorStyle r0 = new OnBoardingColorStyle();
        Blue = r0;
        OnBoardingColorStyle[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public OnBoardingColorStyle() {
        super("Blue", 0);
        this.bgColorRes = 2131103402;
        this.shadowColorRes = 2131103408;
        this.maskColorRes = 2131100562;
    }

    public static OnBoardingColorStyle[] values() {
        return (OnBoardingColorStyle[]) a.clone();
    }

    public final int getBgColorRes() {
        return this.bgColorRes;
    }

    public final int getMaskColorRes() {
        return this.maskColorRes;
    }

    public final int getShadowColorRes() {
        return this.shadowColorRes;
    }

    public static OnBoardingColorStyle valueOf(String r1) {
        return (OnBoardingColorStyle) a.a(OnBoardingColorStyle.class, r1);
    }
}

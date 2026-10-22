package com.bytedance.ee.bear.onboarding.export;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/onboarding/export/OnBoardingColorStyle;", "", "bgColorRes", "", "shadowColorRes", "maskColorRes", "<init>", "(Ljava/lang/String;IIII)V", "getBgColorRes", "()I", "getShadowColorRes", "getMaskColorRes", "Blue", "features-onboarding-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnBoardingColorStyle extends Enum<OnBoardingColorStyle> {
    public static final OnBoardingColorStyle Blue = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnBoardingColorStyle[] f236152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236153b = null;
    private final int bgColorRes;
    private final int maskColorRes;
    private final int shadowColorRes;

    public static EnumEntries<OnBoardingColorStyle> getEntries() {
        return f236153b;
    }

    static {
        OnBoardingColorStyle r100 = new OnBoardingColorStyle();
        Blue = r100;
        OnBoardingColorStyle[] r101 = {r100};
        f236152a = r101;
        f236153b = EnumEntriesKt.enumEntries(r101);
    }

    public OnBoardingColorStyle() {
        super("Blue", 0);
        this.bgColorRes = R.color.lkui_B400;
        this.shadowColorRes = R.color.lkui_B900;
        this.maskColorRes = R.color.bg_mask;
    }

    public static OnBoardingColorStyle[] values() {
        return (OnBoardingColorStyle[]) f236152a.clone();
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

    public static OnBoardingColorStyle valueOf(String r100) {
        return (OnBoardingColorStyle) a.a(OnBoardingColorStyle.class, r100);
    }
}

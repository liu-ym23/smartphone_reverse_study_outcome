package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/onboarding/OnboardingVUIMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START_ONBOARDING", "START_KEY_ONLY", "START_VOICE_ONLY", "START_RADIO_ONLY", "STOP_ONBOARDING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnboardingVUIMode extends Enum<OnboardingVUIMode> {
    public static final OnboardingVUIMode START_KEY_ONLY = null;
    public static final OnboardingVUIMode START_ONBOARDING = null;
    public static final OnboardingVUIMode START_RADIO_ONLY = null;
    public static final OnboardingVUIMode START_VOICE_ONLY = null;
    public static final OnboardingVUIMode STOP_ONBOARDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnboardingVUIMode[] f336600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336601b = null;
    private final int value;

    public static EnumEntries<OnboardingVUIMode> getEntries() {
        return f336601b;
    }

    static {
        OnboardingVUIMode r100 = new OnboardingVUIMode("START_ONBOARDING", 0, 4);
        START_ONBOARDING = r100;
        OnboardingVUIMode r101 = new OnboardingVUIMode("START_KEY_ONLY", 1, 5);
        START_KEY_ONLY = r101;
        OnboardingVUIMode r102 = new OnboardingVUIMode("START_VOICE_ONLY", 2, 6);
        START_VOICE_ONLY = r102;
        OnboardingVUIMode r103 = new OnboardingVUIMode("START_RADIO_ONLY", 3, 7);
        START_RADIO_ONLY = r103;
        OnboardingVUIMode r104 = new OnboardingVUIMode("STOP_ONBOARDING", 4, 5);
        STOP_ONBOARDING = r104;
        OnboardingVUIMode[] r105 = {r100, r101, r102, r103, r104};
        f336600a = r105;
        f336601b = EnumEntriesKt.enumEntries(r105);
    }

    public static OnboardingVUIMode[] values() {
        return (OnboardingVUIMode[]) f336600a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OnboardingVUIMode valueOf(String r100) {
        return (OnboardingVUIMode) r27.a.a(OnboardingVUIMode.class, r100);
    }

    public OnboardingVUIMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

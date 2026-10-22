package com.ss.android.ugc.aweme.tools;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public abstract enum RecordingSpeed extends Enum<RecordingSpeed> {
    public static final RecordingSpeed EPIC = null;
    public static final RecordingSpeed FAST = null;
    public static final RecordingSpeed LAPSE = null;
    public static final RecordingSpeed NORMAL = null;
    public static final RecordingSpeed SLOW = null;
    public static final RecordingSpeed STORY_BOOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingSpeed[] f454344a = null;

    public RecordingSpeed() {
        throw null;
    }

    public abstract String description();

    public abstract float value();

    static {
        final String r100 = "EPIC";
        final int r101 = 0;
        RecordingSpeed r102 = new AnonymousClass1(r100, r101);
        EPIC = r102;
        final String r103 = "SLOW";
        final int r104 = 1;
        RecordingSpeed r105 = new AnonymousClass2(r103, r104);
        SLOW = r105;
        final String r106 = EffectConstants.NORMAL;
        final int r107 = 2;
        RecordingSpeed r108 = new AnonymousClass3(r106, r107);
        NORMAL = r108;
        final String r109 = "STORY_BOOM";
        final int r110 = 3;
        RecordingSpeed r111 = new AnonymousClass4(r109, r110);
        STORY_BOOM = r111;
        final String r112 = "FAST";
        final int r113 = 4;
        RecordingSpeed r114 = new AnonymousClass5(r112, r113);
        FAST = r114;
        final String r115 = "LAPSE";
        final int r116 = 5;
        RecordingSpeed r117 = new AnonymousClass6(r115, r116);
        LAPSE = r117;
        f454344a = new RecordingSpeed[]{r102, r105, r108, r111, r114, r117};
    }

    public static RecordingSpeed[] values() {
        return (RecordingSpeed[]) f454344a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return description();
    }

    public static RecordingSpeed fromValue(float r100) {
        RecordingSpeed r101 = EPIC;
        if (r100 != r101.value()) goto L5;
        return r101;
    L5:
        RecordingSpeed r102 = SLOW;
        if (r100 != r102.value()) goto L8;
        return r102;
    L8:
        RecordingSpeed r103 = NORMAL;
        if (r100 != r103.value()) goto L11;
        return r103;
    L11:
        RecordingSpeed r104 = FAST;
        if (r100 != r104.value()) goto L14;
        return r104;
    L14:
        RecordingSpeed r105 = LAPSE;
        if (r100 != r105.value()) goto L17;
        return r105;
    L17:
        RecordingSpeed r106 = STORY_BOOM;
        if (r100 != r106.value()) goto L20;
        return r106;
    L20:
        return null;
    }

    public static RecordingSpeed valueOf(String r100) {
        return (RecordingSpeed) a.a(RecordingSpeed.class, r100);
    }

    public RecordingSpeed(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}

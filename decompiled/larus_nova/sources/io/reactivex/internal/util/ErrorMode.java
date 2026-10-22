package io.reactivex.internal.util;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes41.dex */
public final enum ErrorMode extends Enum<ErrorMode> {
    public static final ErrorMode BOUNDARY = null;
    public static final ErrorMode END = null;
    public static final ErrorMode IMMEDIATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorMode[] f495040a = null;

    static {
        ErrorMode r100 = new ErrorMode("IMMEDIATE", 0);
        IMMEDIATE = r100;
        ErrorMode r101 = new ErrorMode("BOUNDARY", 1);
        BOUNDARY = r101;
        ErrorMode r102 = new ErrorMode(GXAnimation.STATE_END, 2);
        END = r102;
        f495040a = new ErrorMode[]{r100, r101, r102};
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) f495040a.clone();
    }

    public static ErrorMode valueOf(String r100) {
        return (ErrorMode) r27.a.a(ErrorMode.class, r100);
    }

    public ErrorMode(String r100, int r101) {
        super(r100, r101);
    }
}

package com.ss.android.lark.corrupt;

import com.bytedance.lark.pb.basic.v1.PushDataCorruptResponse;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum Reason extends Enum<Reason> {
    public static final Reason DATABASE_CORRUPT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Reason[] f420173a = null;
    private int mValue;

    static {
        Reason r100 = new Reason();
        DATABASE_CORRUPT = r100;
        f420173a = new Reason[]{r100};
    }

    public Reason() {
        super("DATABASE_CORRUPT", 0);
        this.mValue = 1;
    }

    public static Reason[] values() {
        return (Reason[]) f420173a.clone();
    }

    public boolean isDbCorrupt() {
        if (this.mValue == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getValue() {
        return this.mValue;
    }

    public static Reason convert(PushDataCorruptResponse.Reason r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return fromValue(r100.getValue());
    }

    public static Reason fromValue(int r100) {
        if (r100 == 1) goto L7;
        return null;
    L7:
        return DATABASE_CORRUPT;
    }

    public static Reason valueOf(String r100) {
        return (Reason) a.a(Reason.class, r100);
    }

    public static Reason valueOf(int r100) {
        return fromValue(r100);
    }
}

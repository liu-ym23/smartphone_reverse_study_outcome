package com.bytedance.ug.sdk.tools.check.api.model;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum CheckLevel extends Enum<CheckLevel> {
    public static final CheckLevel HIGH = null;
    public static final CheckLevel LOW = null;
    public static final CheckLevel MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckLevel[] f272360a = null;

    static {
        CheckLevel r100 = new CheckLevel("HIGH", 0);
        HIGH = r100;
        CheckLevel r101 = new CheckLevel("MIDDLE", 1);
        MIDDLE = r101;
        CheckLevel r102 = new CheckLevel("LOW", 2);
        LOW = r102;
        f272360a = new CheckLevel[]{r100, r101, r102};
    }

    public static CheckLevel[] values() {
        return (CheckLevel[]) f272360a.clone();
    }

    public static CheckLevel valueOf(String r100) {
        return (CheckLevel) a.a(CheckLevel.class, r100);
    }

    public CheckLevel(String r100, int r101) {
        super(r100, r101);
    }
}

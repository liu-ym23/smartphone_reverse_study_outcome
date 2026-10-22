package com.bytedance.salamander.anniex;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXLynxSizeMode;", "", "", "value", "I", "getValue", "()I", "undefined", "exact", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXLynxSizeMode extends Enum<AnnieXLynxSizeMode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXLynxSizeMode[] f267831a = null;
    public static final AnnieXLynxSizeMode exact = null;
    public static final AnnieXLynxSizeMode max = null;
    public static final AnnieXLynxSizeMode undefined = null;
    private final int value;

    public static AnnieXLynxSizeMode valueOf(String r100) {
        return (AnnieXLynxSizeMode) r27.a.a(AnnieXLynxSizeMode.class, r100);
    }

    public static AnnieXLynxSizeMode[] values() {
        return (AnnieXLynxSizeMode[]) f267831a.clone();
    }

    static {
        AnnieXLynxSizeMode r100 = new AnnieXLynxSizeMode("undefined", 0, 0);
        undefined = r100;
        AnnieXLynxSizeMode r101 = new AnnieXLynxSizeMode("exact", 1, 1);
        exact = r101;
        AnnieXLynxSizeMode r102 = new AnnieXLynxSizeMode(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 2, 2);
        max = r102;
        f267831a = new AnnieXLynxSizeMode[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXLynxSizeMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

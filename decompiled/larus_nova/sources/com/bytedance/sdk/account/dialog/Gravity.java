package com.bytedance.sdk.account.dialog;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/account/dialog/Gravity;", "", "CENTER", "BOTTOM", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
public final enum Gravity extends Enum<Gravity> {
    public static final Gravity BOTTOM = null;
    public static final Gravity CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Gravity[] f268893a = null;

    static {
        Gravity r100 = new Gravity("CENTER", 0);
        CENTER = r100;
        Gravity r101 = new Gravity("BOTTOM", 1);
        BOTTOM = r101;
        f268893a = new Gravity[]{r100, r101};
    }

    public static Gravity valueOf(String r100) {
        return (Gravity) a.a(Gravity.class, r100);
    }

    public static Gravity[] values() {
        return (Gravity[]) f268893a.clone();
    }

    public Gravity(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.locallife.cube.api.config;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/ApplicableScene;", "", "", "value", "I", "getValue", "()I", AccountType.ALL, "SMART_PRERENDER", "INPAGE_PRELOAD", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum ApplicableScene extends Enum<ApplicableScene> {
    public static final ApplicableScene ALL = null;
    public static final ApplicableScene INPAGE_PRELOAD = null;
    public static final ApplicableScene SMART_PRERENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplicableScene[] f257160a = null;
    private final int value;

    public static ApplicableScene valueOf(String r100) {
        return (ApplicableScene) a.a(ApplicableScene.class, r100);
    }

    public static ApplicableScene[] values() {
        return (ApplicableScene[]) f257160a.clone();
    }

    static {
        ApplicableScene r100 = new ApplicableScene(AccountType.ALL, 0, 0);
        ALL = r100;
        ApplicableScene r101 = new ApplicableScene("SMART_PRERENDER", 1, 1);
        SMART_PRERENDER = r101;
        ApplicableScene r102 = new ApplicableScene("INPAGE_PRELOAD", 2, 2);
        INPAGE_PRELOAD = r102;
        f257160a = new ApplicableScene[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ApplicableScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

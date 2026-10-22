package com.bytedance.gamecenter.base.order;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/gamecenter/base/order/SdkInitStatusEnum;", "", "", BaseSwitches.V, "I", "getV", "()I", "DEFAULT", "INIT_FINISH", "WAIT_INIT", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum SdkInitStatusEnum extends Enum<SdkInitStatusEnum> {
    public static final SdkInitStatusEnum DEFAULT = null;
    public static final SdkInitStatusEnum INIT_FINISH = null;
    public static final SdkInitStatusEnum WAIT_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SdkInitStatusEnum[] f245018a = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f245019v;

    static {
        SdkInitStatusEnum r100 = new SdkInitStatusEnum("DEFAULT", 0, -1);
        DEFAULT = r100;
        SdkInitStatusEnum r101 = new SdkInitStatusEnum("INIT_FINISH", 1, 0);
        INIT_FINISH = r101;
        SdkInitStatusEnum r102 = new SdkInitStatusEnum("WAIT_INIT", 2, 1);
        WAIT_INIT = r102;
        f245018a = new SdkInitStatusEnum[]{r100, r101, r102};
    }

    public static SdkInitStatusEnum valueOf(String r100) {
        return (SdkInitStatusEnum) r27.a.a(SdkInitStatusEnum.class, r100);
    }

    public static SdkInitStatusEnum[] values() {
        return (SdkInitStatusEnum[]) f245018a.clone();
    }

    public final int getV() {
        return this.f245019v;
    }

    public SdkInitStatusEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.f245019v = r102;
    }

    public /* synthetic */ SdkInitStatusEnum(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}

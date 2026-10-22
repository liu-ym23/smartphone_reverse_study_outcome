package com.bytedance.ies.bullet.assembler.settings;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/assembler/settings/DeviceShape;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, "PAD", "FOLD", "HORIZONTAL_FOLD", "VERTICAL_FOLD", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum DeviceShape extends Enum<DeviceShape> {
    public static final DeviceShape FOLD = null;
    public static final DeviceShape HORIZONTAL_FOLD = null;
    public static final DeviceShape NORMAL = null;
    public static final DeviceShape PAD = null;
    public static final DeviceShape VERTICAL_FOLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceShape[] f246266a = null;
    private final String value;

    public static DeviceShape valueOf(String r100) {
        return (DeviceShape) a.a(DeviceShape.class, r100);
    }

    public static DeviceShape[] values() {
        return (DeviceShape[]) f246266a.clone();
    }

    static {
        DeviceShape r100 = new DeviceShape(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        DeviceShape r101 = new DeviceShape("PAD", 1, CommonCmd.AIDL_PLATFORM_TYPE_PAD);
        PAD = r101;
        DeviceShape r102 = new DeviceShape("FOLD", 2, "fold");
        FOLD = r102;
        DeviceShape r103 = new DeviceShape("HORIZONTAL_FOLD", 3, "horizontal_fold");
        HORIZONTAL_FOLD = r103;
        DeviceShape r104 = new DeviceShape("VERTICAL_FOLD", 4, "vertical_fold");
        VERTICAL_FOLD = r104;
        f246266a = new DeviceShape[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public DeviceShape(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

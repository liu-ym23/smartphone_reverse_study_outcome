package com.larus.dora.impl.device.manage;

import com.byted.cast.common.bean.State;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/manage/DeviceMode;", "", "modeName", "", "isHighlight", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getModeName", "()Ljava/lang/String;", "()Z", EffectConstants.NORMAL, "EARPHONE", "VIDEO_CALL", "INTERPRET", State.RECORDING, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeviceMode extends Enum<DeviceMode> {
    public static final DeviceMode EARPHONE = null;
    public static final DeviceMode INTERPRET = null;
    public static final DeviceMode NORMAL = null;
    public static final DeviceMode RECORDING = null;
    public static final DeviceMode VIDEO_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceMode[] f333655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f333656b = null;
    private final boolean isHighlight;
    private final String modeName;

    public static EnumEntries<DeviceMode> getEntries() {
        return f333656b;
    }

    static {
        int r100 = com.larus.utils.j0.f375426a;
        DeviceMode r101 = new DeviceMode(EffectConstants.NORMAL, 0, com.larus.utils.j0.d(R.string.larus_dora_device_state_connected_cn), false, 2, null);
        NORMAL = r101;
        DeviceMode r102 = new DeviceMode("EARPHONE", 1, com.larus.utils.j0.d(R.string.larus_dora_gesture_headphone_mode_cn), false, 2, null);
        EARPHONE = r102;
        DeviceMode r103 = new DeviceMode("VIDEO_CALL", 2, com.larus.utils.j0.d(R.string.larus_call_videoCall_title), true);
        VIDEO_CALL = r103;
        DeviceMode r104 = new DeviceMode("INTERPRET", 3, com.larus.utils.j0.d(R.string.larus_dora_g_device_trans_on_cn), true);
        INTERPRET = r104;
        DeviceMode r105 = new DeviceMode(State.RECORDING, 4, com.larus.utils.j0.d(R.string.larus_dora_g_device_audio_rec_cn), true);
        RECORDING = r105;
        DeviceMode[] r106 = {r101, r102, r103, r104, r105};
        f333655a = r106;
        f333656b = EnumEntriesKt.enumEntries(r106);
    }

    public static DeviceMode[] values() {
        return (DeviceMode[]) f333655a.clone();
    }

    public final String getModeName() {
        return this.modeName;
    }

    public final boolean isHighlight() {
        return this.isHighlight;
    }

    public static DeviceMode valueOf(String r100) {
        return (DeviceMode) r27.a.a(DeviceMode.class, r100);
    }

    public DeviceMode(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.modeName = r102;
        this.isHighlight = r103;
    }

    public /* synthetic */ DeviceMode(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}

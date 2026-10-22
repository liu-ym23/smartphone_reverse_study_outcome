package com.larus.dora.impl.device.settings.gesture.wakeup;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "", "titleResId", "", "subtitleResId", "<init>", "(Ljava/lang/String;III)V", "getTitleResId", "()I", "getSubtitleResId", "RADIO", "RADIO_CONTINUOUS_DIALOGUE", "RADIO_RECORD", "CLOSE", "isAvailable", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GestureWakeupType extends Enum<GestureWakeupType> {
    public static final GestureWakeupType CLOSE = null;
    public static final GestureWakeupType RADIO = null;
    public static final GestureWakeupType RADIO_CONTINUOUS_DIALOGUE = null;
    public static final GestureWakeupType RADIO_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureWakeupType[] f334520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334521b = null;
    private final int subtitleResId;
    private final int titleResId;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334522a = null;

        static {
            int[] r100 = new int[GestureWakeupType.values().length];
            r100[GestureWakeupType.RADIO_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f334522a = r100;
        }
    }

    public static EnumEntries<GestureWakeupType> getEntries() {
        return f334521b;
    }

    static {
        GestureWakeupType r100 = new GestureWakeupType("RADIO", 0, R.string.larus_dora_wakeup_gesture_radio_title_cn, R.string.larus_dora_wakeup_gesture_radio_subtitle_cn);
        RADIO = r100;
        GestureWakeupType r101 = new GestureWakeupType("RADIO_CONTINUOUS_DIALOGUE", 1, R.string.larus_dora_wakeup_gesture_radio_continuous_dialogue_title_cn, R.string.larus_dora_wakeup_gesture_radio_continuous_dialogue_subtitle_cn);
        RADIO_CONTINUOUS_DIALOGUE = r101;
        GestureWakeupType r102 = new GestureWakeupType("RADIO_RECORD", 2, R.string.larus_dora_quick_note_long_press_cn, R.string.larus_dora_aikey_note_longpress_subtitle_cn);
        RADIO_RECORD = r102;
        GestureWakeupType r103 = new GestureWakeupType("CLOSE", 3, R.string.larus_dora_wakeup_gesture_radio_none_cn, 0);
        CLOSE = r103;
        GestureWakeupType[] r104 = {r100, r101, r102, r103};
        f334520a = r104;
        f334521b = EnumEntriesKt.enumEntries(r104);
    }

    public static GestureWakeupType[] values() {
        return (GestureWakeupType[]) f334520a.clone();
    }

    public final boolean isAvailable() {
        if (a.f334522a[ordinal()] != 1) goto L13;
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L11;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L11;
        if (r101.q0(null) != true) goto L11;
        return true;
    L11:
        return false;
    L13:
        return true;
    }

    public final int getSubtitleResId() {
        return this.subtitleResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public static GestureWakeupType valueOf(String r100) {
        return (GestureWakeupType) r27.a.a(GestureWakeupType.class, r100);
    }

    public GestureWakeupType(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.titleResId = r102;
        this.subtitleResId = r103;
    }
}

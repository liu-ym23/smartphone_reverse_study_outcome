package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model;

import com.bytedance.bdlocation.client.LocationInfoConst;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/model/CloseOrderSongDialogSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "MANUAL", "AUTO", "CLOSE_KTV_COMPONENT", "OPEN_TUNING_DIALOG", "OPEN_VIDEO_CHORUS", "OPEN_KTV_CHALLENGE_SETTING_DIALOG", "SWITCH_SCENE", "BUSINESS_WIDGET_DESTROY", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CloseOrderSongDialogSource extends Enum<CloseOrderSongDialogSource> {
    public static final CloseOrderSongDialogSource AUTO = null;
    public static final CloseOrderSongDialogSource BUSINESS_WIDGET_DESTROY = null;
    public static final CloseOrderSongDialogSource CLOSE_KTV_COMPONENT = null;
    public static final CloseOrderSongDialogSource MANUAL = null;
    public static final CloseOrderSongDialogSource OPEN_KTV_CHALLENGE_SETTING_DIALOG = null;
    public static final CloseOrderSongDialogSource OPEN_TUNING_DIALOG = null;
    public static final CloseOrderSongDialogSource OPEN_VIDEO_CHORUS = null;
    public static final CloseOrderSongDialogSource SWITCH_SCENE = null;
    public static final CloseOrderSongDialogSource UNKNOWN = null;
    public static final /* synthetic */ CloseOrderSongDialogSource[] a = null;
    private final String value;

    public static CloseOrderSongDialogSource valueOf(String r1) {
        return (CloseOrderSongDialogSource) a.a(CloseOrderSongDialogSource.class, r1);
    }

    public static CloseOrderSongDialogSource[] values() {
        return (CloseOrderSongDialogSource[]) a.clone();
    }

    static {
        CloseOrderSongDialogSource r1 = new CloseOrderSongDialogSource("UNKNOWN", 0, LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD);
        UNKNOWN = r1;
        CloseOrderSongDialogSource r2 = new CloseOrderSongDialogSource("MANUAL", 1, "manual");
        MANUAL = r2;
        CloseOrderSongDialogSource r3 = new CloseOrderSongDialogSource("AUTO", 2, "auto");
        AUTO = r3;
        CloseOrderSongDialogSource r4 = new CloseOrderSongDialogSource("CLOSE_KTV_COMPONENT", 3, "close_ktv_component");
        CLOSE_KTV_COMPONENT = r4;
        CloseOrderSongDialogSource r5 = new CloseOrderSongDialogSource("OPEN_TUNING_DIALOG", 4, "open_tuning_dialog");
        OPEN_TUNING_DIALOG = r5;
        CloseOrderSongDialogSource r6 = new CloseOrderSongDialogSource("OPEN_VIDEO_CHORUS", 5, "open_video_chorus");
        OPEN_VIDEO_CHORUS = r6;
        CloseOrderSongDialogSource r7 = new CloseOrderSongDialogSource("OPEN_KTV_CHALLENGE_SETTING_DIALOG", 6, "open_ktv_challenge_setting_dialog");
        OPEN_KTV_CHALLENGE_SETTING_DIALOG = r7;
        CloseOrderSongDialogSource r8 = new CloseOrderSongDialogSource("SWITCH_SCENE", 7, "switch_scene");
        SWITCH_SCENE = r8;
        CloseOrderSongDialogSource r9 = new CloseOrderSongDialogSource("BUSINESS_WIDGET_DESTROY", 8, "business_widget_destroy");
        BUSINESS_WIDGET_DESTROY = r9;
        a = new CloseOrderSongDialogSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getValue() {
        return this.value;
    }

    public CloseOrderSongDialogSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.ss.android.lark.widget.photo.preview.video.pip;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/video/pip/PipModeActionInfo;", "", "iconRes", "", "requestCode", "intentAction", "", "<init>", "(Ljava/lang/String;IIILjava/lang/String;)V", "getIconRes", "()I", "getRequestCode", "getIntentAction", "()Ljava/lang/String;", "BACK_BTN", "PAUSE_BTN", "PLAY_BTN", "FORWARD_BTN", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PipModeActionInfo extends Enum<PipModeActionInfo> {
    public static final PipModeActionInfo BACK_BTN = null;
    public static final PipModeActionInfo FORWARD_BTN = null;
    public static final PipModeActionInfo PAUSE_BTN = null;
    public static final PipModeActionInfo PLAY_BTN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PipModeActionInfo[] f447391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f447392b = null;
    private final int iconRes;
    private final String intentAction;
    private final int requestCode;

    public static EnumEntries<PipModeActionInfo> getEntries() {
        return f447392b;
    }

    static {
        PipModeActionInfo r100 = new PipModeActionInfo("BACK_BTN", 0, R.drawable.ud_icon_back_15s_outlined, 0, "BACK_BTN_CLICK_IN_PIP_MODE");
        BACK_BTN = r100;
        PipModeActionInfo r101 = new PipModeActionInfo("PAUSE_BTN", 1, R.drawable.ud_icon_pause_filled, 1, "PAUSE_BTN_CLICK_IN_PIP_MODE");
        PAUSE_BTN = r101;
        PipModeActionInfo r102 = new PipModeActionInfo("PLAY_BTN", 2, R.drawable.ud_icon_play_filled, 2, "PLAY_BTN_CLICK_IN_PIP_MODE");
        PLAY_BTN = r102;
        PipModeActionInfo r103 = new PipModeActionInfo("FORWARD_BTN", 3, R.drawable.ud_icon_forward_15s_outlined, 3, "FORWARD_BTN_CLICK_IN_PIP_MODE");
        FORWARD_BTN = r103;
        PipModeActionInfo[] r104 = {r100, r101, r102, r103};
        f447391a = r104;
        f447392b = EnumEntriesKt.enumEntries(r104);
    }

    public static PipModeActionInfo[] values() {
        return (PipModeActionInfo[]) f447391a.clone();
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public static PipModeActionInfo valueOf(String r100) {
        return (PipModeActionInfo) r27.a.a(PipModeActionInfo.class, r100);
    }

    public PipModeActionInfo(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.iconRes = r102;
        this.requestCode = r103;
        this.intentAction = r104;
    }
}

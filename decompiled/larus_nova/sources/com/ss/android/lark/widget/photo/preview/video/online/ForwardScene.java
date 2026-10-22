package com.ss.android.lark.widget.photo.preview.video.online;

import com.larus.network.http.ServiceType;
import com.obric.miniapp.alarm.AlarmSessionType;

/* JADX INFO: loaded from: classes38.dex */
final enum ForwardScene extends Enum<ForwardScene> {
    public static final ForwardScene CHAT = null;
    public static final ForwardScene FAVORITE = null;
    public static final ForwardScene Mark = null;
    public static final ForwardScene Message = null;
    public static final ForwardScene Moments = null;
    public static final ForwardScene TODO = null;
    public static final ForwardScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardScene[] f447268a = null;
    private final int value;

    static {
        ForwardScene r100 = new ForwardScene("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ForwardScene r101 = new ForwardScene("CHAT", 1, 1);
        CHAT = r101;
        ForwardScene r102 = new ForwardScene("FAVORITE", 2, 2);
        FAVORITE = r102;
        ForwardScene r103 = new ForwardScene(AlarmSessionType.TODO, 3, 3);
        TODO = r103;
        ForwardScene r104 = new ForwardScene("Moments", 4, 4);
        Moments = r104;
        ForwardScene r105 = new ForwardScene("Mark", 5, 5);
        Mark = r105;
        ForwardScene r110 = new ForwardScene(ServiceType.IM, 6, 6);
        Message = r110;
        f447268a = new ForwardScene[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static ForwardScene[] values() {
        return (ForwardScene[]) f447268a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ForwardScene fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return Message;
    L16:
        return Mark;
    L18:
        return Moments;
    L20:
        return TODO;
    L22:
        return FAVORITE;
    L24:
        return CHAT;
    L26:
        return UNKNOWN;
    }

    public static ForwardScene valueOf(String r100) {
        return (ForwardScene) r27.a.a(ForwardScene.class, r100);
    }

    public ForwardScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

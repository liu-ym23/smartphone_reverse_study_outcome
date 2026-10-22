package com.bytedance.lark.pb.media.v1;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DownloadFileScene extends Enum<DownloadFileScene> implements WireEnum {
    private static final /* synthetic */ DownloadFileScene[] $VALUES = null;
    public static final ProtoAdapter<DownloadFileScene> ADAPTER = null;
    public static final DownloadFileScene CHAT = null;
    public static final DownloadFileScene Draft = null;
    public static final DownloadFileScene FAVORITE = null;
    public static final DownloadFileScene ImFeedAudio = null;
    public static final DownloadFileScene MessageLink = null;
    public static final DownloadFileScene TODO = null;
    public static final DownloadFileScene UNKNOWN = null;
    public static final DownloadFileScene UniversalCard = null;
    private final int value;

    static {
        DownloadFileScene r100 = new DownloadFileScene("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DownloadFileScene r101 = new DownloadFileScene("CHAT", 1, 1);
        CHAT = r101;
        DownloadFileScene r102 = new DownloadFileScene("FAVORITE", 2, 2);
        FAVORITE = r102;
        DownloadFileScene r103 = new DownloadFileScene(AlarmSessionType.TODO, 3, 3);
        TODO = r103;
        DownloadFileScene r104 = new DownloadFileScene("ImFeedAudio", 4, 7);
        ImFeedAudio = r104;
        DownloadFileScene r105 = new DownloadFileScene("MessageLink", 5, 8);
        MessageLink = r105;
        DownloadFileScene r110 = new DownloadFileScene("UniversalCard", 6, 9);
        UniversalCard = r110;
        DownloadFileScene r111 = new DownloadFileScene("Draft", 7, 20);
        Draft = r111;
        $VALUES = new DownloadFileScene[]{r100, r101, r102, r103, r104, r105, r110, r111};
        ADAPTER = ProtoAdapter.newEnumAdapter(DownloadFileScene.class);
    }

    public static DownloadFileScene[] values() {
        return (DownloadFileScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DownloadFileScene fromValue(int r100) {
        if (r100 == 0) goto L34;
        if (r100 == 1) goto L32;
        if (r100 == 2) goto L30;
        if (r100 == 3) goto L28;
        if (r100 == 7) goto L26;
        if (r100 == 8) goto L24;
        if (r100 == 9) goto L22;
        if (r100 == 20) goto L20;
        return null;
    L20:
        return Draft;
    L22:
        return UniversalCard;
    L24:
        return MessageLink;
    L26:
        return ImFeedAudio;
    L28:
        return TODO;
    L30:
        return FAVORITE;
    L32:
        return CHAT;
    L34:
        return UNKNOWN;
    }

    public static DownloadFileScene valueOf(String r100) {
        return (DownloadFileScene) a.a(DownloadFileScene.class, r100);
    }

    private DownloadFileScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

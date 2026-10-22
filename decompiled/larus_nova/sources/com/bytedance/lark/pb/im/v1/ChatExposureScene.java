package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChatExposureScene extends Enum<ChatExposureScene> implements WireEnum {
    private static final /* synthetic */ ChatExposureScene[] $VALUES = null;
    public static final ProtoAdapter<ChatExposureScene> ADAPTER = null;
    public static final ChatExposureScene Feed_list = null;
    public static final ChatExposureScene Notify = null;
    public static final ChatExposureScene Search = null;
    public static final ChatExposureScene Short_cut = null;
    public static final ChatExposureScene Unkown = null;
    private final int value;

    static {
        ChatExposureScene r100 = new ChatExposureScene("Unkown", 0, 0);
        Unkown = r100;
        ChatExposureScene r101 = new ChatExposureScene("Feed_list", 1, 1);
        Feed_list = r101;
        ChatExposureScene r102 = new ChatExposureScene("Short_cut", 2, 2);
        Short_cut = r102;
        ChatExposureScene r103 = new ChatExposureScene("Search", 3, 3);
        Search = r103;
        ChatExposureScene r104 = new ChatExposureScene("Notify", 4, 4);
        Notify = r104;
        $VALUES = new ChatExposureScene[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatExposureScene.class);
    }

    public static ChatExposureScene[] values() {
        return (ChatExposureScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatExposureScene fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return Notify;
    L16:
        return Search;
    L18:
        return Short_cut;
    L20:
        return Feed_list;
    L22:
        return Unkown;
    }

    public static ChatExposureScene valueOf(String r100) {
        return (ChatExposureScene) a.a(ChatExposureScene.class, r100);
    }

    private ChatExposureScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

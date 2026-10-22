package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.tencent.connect.common.Constants;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum AppDetail extends Enum<AppDetail> implements WireEnum {
    private static final /* synthetic */ AppDetail[] $VALUES = null;
    public static final ProtoAdapter<AppDetail> ADAPTER = null;
    public static final AppDetail AppDetailUnknown = null;
    public static final AppDetail Others = null;
    public static final AppDetail QQ = null;
    public static final AppDetail WeChat = null;
    public static final AppDetail WeChatMoments = null;
    public static final AppDetail Weibo = null;
    private final int value;

    static {
        AppDetail r100 = new AppDetail("AppDetailUnknown", 0, 0);
        AppDetailUnknown = r100;
        AppDetail r101 = new AppDetail("WeChat", 1, 1);
        WeChat = r101;
        AppDetail r102 = new AppDetail("WeChatMoments", 2, 2);
        WeChatMoments = r102;
        AppDetail r103 = new AppDetail(Constants.SOURCE_QQ, 3, 3);
        QQ = r103;
        AppDetail r104 = new AppDetail("Weibo", 4, 4);
        Weibo = r104;
        AppDetail r105 = new AppDetail("Others", 5, 5);
        Others = r105;
        $VALUES = new AppDetail[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppDetail.class);
    }

    public static AppDetail[] values() {
        return (AppDetail[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppDetail fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return Others;
    L18:
        return Weibo;
    L20:
        return QQ;
    L22:
        return WeChatMoments;
    L24:
        return WeChat;
    L26:
        return AppDetailUnknown;
    }

    public static AppDetail valueOf(String r100) {
        return (AppDetail) a.a(AppDetail.class, r100);
    }

    private AppDetail(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

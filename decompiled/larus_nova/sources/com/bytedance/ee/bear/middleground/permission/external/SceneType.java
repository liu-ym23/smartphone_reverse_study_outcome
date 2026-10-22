package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/SceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVITE_EXTERNAL_MEMBER", "INVITE_EXTERNAL_PARTNER_TENANT_MEMBER", "PASSWORD_SHARE", "WECHAT_SHARE", "WECHAT_MOMENTS_SHARE", "QQ_SHARE", "WEIBO_SHARE", "LINK_SHARE", "PERMISSION_SETTINGS", "MORE_SHARE", "IM_SHARE_EXTERNAL_MEMBER", "IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER", "CALENDER_DOC_CARD", "ESCAPE", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SceneType extends Enum<SceneType> {
    public static final SceneType CALENDER_DOC_CARD = null;
    public static final SceneType ESCAPE = null;
    public static final SceneType IM_SHARE_EXTERNAL_MEMBER = null;
    public static final SceneType IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER = null;
    public static final SceneType INVITE_EXTERNAL_MEMBER = null;
    public static final SceneType INVITE_EXTERNAL_PARTNER_TENANT_MEMBER = null;
    public static final SceneType LINK_SHARE = null;
    public static final SceneType MORE_SHARE = null;
    public static final SceneType PASSWORD_SHARE = null;
    public static final SceneType PERMISSION_SETTINGS = null;
    public static final SceneType QQ_SHARE = null;
    public static final SceneType WECHAT_MOMENTS_SHARE = null;
    public static final SceneType WECHAT_SHARE = null;
    public static final SceneType WEIBO_SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneType[] f233883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233884b = null;
    private final int value;

    public static EnumEntries<SceneType> getEntries() {
        return f233884b;
    }

    static {
        SceneType r100 = new SceneType("INVITE_EXTERNAL_MEMBER", 0, 0);
        INVITE_EXTERNAL_MEMBER = r100;
        SceneType r101 = new SceneType("INVITE_EXTERNAL_PARTNER_TENANT_MEMBER", 1, 1);
        INVITE_EXTERNAL_PARTNER_TENANT_MEMBER = r101;
        SceneType r102 = new SceneType("PASSWORD_SHARE", 2, 2);
        PASSWORD_SHARE = r102;
        SceneType r103 = new SceneType("WECHAT_SHARE", 3, 3);
        WECHAT_SHARE = r103;
        SceneType r104 = new SceneType("WECHAT_MOMENTS_SHARE", 4, 4);
        WECHAT_MOMENTS_SHARE = r104;
        SceneType r105 = new SceneType("QQ_SHARE", 5, 5);
        QQ_SHARE = r105;
        SceneType r110 = new SceneType("WEIBO_SHARE", 6, 6);
        WEIBO_SHARE = r110;
        SceneType r111 = new SceneType("LINK_SHARE", 7, 7);
        LINK_SHARE = r111;
        SceneType r112 = new SceneType("PERMISSION_SETTINGS", 8, 8);
        PERMISSION_SETTINGS = r112;
        SceneType r113 = new SceneType("MORE_SHARE", 9, 9);
        MORE_SHARE = r113;
        SceneType r114 = new SceneType("IM_SHARE_EXTERNAL_MEMBER", 10, 10);
        IM_SHARE_EXTERNAL_MEMBER = r114;
        SceneType r115 = new SceneType("IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER", 11, 11);
        IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER = r115;
        SceneType r106 = new SceneType("CALENDER_DOC_CARD", 12, 19);
        CALENDER_DOC_CARD = r106;
        SceneType r107 = new SceneType("ESCAPE", 13, 21);
        ESCAPE = r107;
        SceneType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f233883a = r108;
        f233884b = EnumEntriesKt.enumEntries(r108);
    }

    public static SceneType[] values() {
        return (SceneType[]) f233883a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SceneType valueOf(String r100) {
        return (SceneType) a.a(SceneType.class, r100);
    }

    public SceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static final /* synthetic */ SceneType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SceneType> getEntries() {
        return b;
    }

    static {
        SceneType r0 = new SceneType("INVITE_EXTERNAL_MEMBER", 0, 0);
        INVITE_EXTERNAL_MEMBER = r0;
        SceneType r1 = new SceneType("INVITE_EXTERNAL_PARTNER_TENANT_MEMBER", 1, 1);
        INVITE_EXTERNAL_PARTNER_TENANT_MEMBER = r1;
        SceneType r3 = new SceneType("PASSWORD_SHARE", 2, 2);
        PASSWORD_SHARE = r3;
        SceneType r5 = new SceneType("WECHAT_SHARE", 3, 3);
        WECHAT_SHARE = r5;
        SceneType r7 = new SceneType("WECHAT_MOMENTS_SHARE", 4, 4);
        WECHAT_MOMENTS_SHARE = r7;
        SceneType r9 = new SceneType("QQ_SHARE", 5, 5);
        QQ_SHARE = r9;
        SceneType r11 = new SceneType("WEIBO_SHARE", 6, 6);
        WEIBO_SHARE = r11;
        SceneType r13 = new SceneType("LINK_SHARE", 7, 7);
        LINK_SHARE = r13;
        SceneType r15 = new SceneType("PERMISSION_SETTINGS", 8, 8);
        PERMISSION_SETTINGS = r15;
        SceneType r14 = new SceneType("MORE_SHARE", 9, 9);
        MORE_SHARE = r14;
        SceneType r12 = new SceneType("IM_SHARE_EXTERNAL_MEMBER", 10, 10);
        IM_SHARE_EXTERNAL_MEMBER = r12;
        SceneType r10 = new SceneType("IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER", 11, 11);
        IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER = r10;
        SceneType r8 = new SceneType("CALENDER_DOC_CARD", 12, 19);
        CALENDER_DOC_CARD = r8;
        SceneType r4 = new SceneType("ESCAPE", 13, 21);
        ESCAPE = r4;
        SceneType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r4};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static SceneType[] values() {
        return (SceneType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SceneType valueOf(String r1) {
        return (SceneType) a.a(SceneType.class, r1);
    }

    public SceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

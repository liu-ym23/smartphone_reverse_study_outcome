package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "aliasValue", "getAliasValue", UserProfileEvent.POSITION_NONE, OpenNetMethod.REPORT, "SHARE", "COLLECT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum NavBtnType extends Enum<NavBtnType> {
    public static final NavBtnType COLLECT = null;
    public static final NavBtnType NONE = null;
    public static final NavBtnType REPORT = null;
    public static final NavBtnType SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavBtnType[] f248141a = null;
    private final String aliasValue;
    private final String value;

    public static NavBtnType valueOf(String r100) {
        return (NavBtnType) r27.a.a(NavBtnType.class, r100);
    }

    public static NavBtnType[] values() {
        return (NavBtnType[]) f248141a.clone();
    }

    static {
        NavBtnType r100 = new NavBtnType(UserProfileEvent.POSITION_NONE, 0, "none", "0");
        NONE = r100;
        NavBtnType r101 = new NavBtnType(OpenNetMethod.REPORT, 1, "report", "1");
        REPORT = r101;
        NavBtnType r102 = new NavBtnType("SHARE", 2, "share", "2");
        SHARE = r102;
        NavBtnType r103 = new NavBtnType("COLLECT", 3, ShareChannel.COLLECT, "3");
        COLLECT = r103;
        f248141a = new NavBtnType[]{r100, r101, r102, r103};
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }

    public NavBtnType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.aliasValue = r103;
    }
}

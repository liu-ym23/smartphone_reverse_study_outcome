package com.bytedance.ies.bullet.ui.common.view;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/TitleBarRightBtn;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, OpenNetMethod.REPORT, "SHARE", "COLLECT", UserProfileEvent.POSITION_NONE, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TitleBarRightBtn extends Enum<TitleBarRightBtn> {
    public static final TitleBarRightBtn COLLECT = null;
    public static final a Companion = null;
    public static final TitleBarRightBtn NONE = null;
    public static final TitleBarRightBtn REPORT = null;
    public static final TitleBarRightBtn SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarRightBtn[] f248277a = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            TitleBarRightBtn[] r101 = TitleBarRightBtn.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            if (Intrinsics.areEqual(r101[r103].getType(), r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return;
        }
    }

    public static TitleBarRightBtn valueOf(String r100) {
        return (TitleBarRightBtn) r27.a.a(TitleBarRightBtn.class, r100);
    }

    public static TitleBarRightBtn[] values() {
        return (TitleBarRightBtn[]) f248277a.clone();
    }

    static {
        TitleBarRightBtn r100 = new TitleBarRightBtn(OpenNetMethod.REPORT, 0, "report");
        REPORT = r100;
        TitleBarRightBtn r101 = new TitleBarRightBtn("SHARE", 1, "share");
        SHARE = r101;
        TitleBarRightBtn r102 = new TitleBarRightBtn("COLLECT", 2, ShareChannel.COLLECT);
        COLLECT = r102;
        TitleBarRightBtn r103 = new TitleBarRightBtn(UserProfileEvent.POSITION_NONE, 3, "none");
        NONE = r103;
        f248277a = new TitleBarRightBtn[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public final String getType() {
        return this.type;
    }

    public TitleBarRightBtn(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

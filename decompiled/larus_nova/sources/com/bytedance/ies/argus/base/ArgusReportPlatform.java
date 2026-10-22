package com.bytedance.ies.argus.base;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", "", "ONLY_SLARDAR", "ONLY_TEA", AccountType.ALL, UserProfileEvent.POSITION_NONE, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusReportPlatform extends Enum<ArgusReportPlatform> {
    public static final ArgusReportPlatform ALL = null;
    public static final ArgusReportPlatform NONE = null;
    public static final ArgusReportPlatform ONLY_SLARDAR = null;
    public static final ArgusReportPlatform ONLY_TEA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusReportPlatform[] f245934a = null;

    public static ArgusReportPlatform valueOf(String r100) {
        return (ArgusReportPlatform) r27.a.a(ArgusReportPlatform.class, r100);
    }

    public static ArgusReportPlatform[] values() {
        return (ArgusReportPlatform[]) f245934a.clone();
    }

    static {
        ArgusReportPlatform r100 = new ArgusReportPlatform("ONLY_SLARDAR", 0);
        ONLY_SLARDAR = r100;
        ArgusReportPlatform r101 = new ArgusReportPlatform("ONLY_TEA", 1);
        ONLY_TEA = r101;
        ArgusReportPlatform r102 = new ArgusReportPlatform(AccountType.ALL, 2);
        ALL = r102;
        ArgusReportPlatform r103 = new ArgusReportPlatform(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f245934a = new ArgusReportPlatform[]{r100, r101, r102, r103};
    }

    public ArgusReportPlatform(String r100, int r101) {
        super(r100, r101);
    }
}

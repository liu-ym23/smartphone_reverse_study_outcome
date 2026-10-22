package af2;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final long a(IBaseBattleSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$defaultPunishDuration");
        if (r2.getPunishOptimizeOn() == false) goto L5;
        return 60;
    L5:
        return 180;
    }

    public static final long b(IBaseBattleSetting r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$optimizePunishDuration");
        if (r5.getPunishOptimizeOn() == true) goto L7;
        return r5.getPunishDuration();
    L7:
        if (r5.getPunishDuration() >= 0) goto L10;
        return 0;
    L10:
        if (r5.getPunishDuration() != 0) goto L13;
        return a(r5);
    L13:
        return r5.getPunishDuration();
    }

    public static final boolean c(IBaseBattleSetting r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$needShowLastResult");
        if (r1.getDisplayLastResult() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getNeedCloseLinkmic() == true) goto L7;
        return true;
    }

    public static final boolean d(IBaseBattleSetting r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$needSkipPenal");
        if (r4.getPunishOptimizeOn() == true) goto L6;
    L8:
        return false;
    L6:
        if (r4.getPunishDuration() >= 0) goto L8;
        return true;
    }

    public static final String e(IBaseBattleSetting r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toSimpleString");
        return "BattleSettings{battleId=" + r3.getBattleId() + ", battleType=" + r3.getBattleType() + ", mode=" + r3.getMode() + ", duration=" + r3.getDuration() + ", startTimeMs=" + r3.getStartTimeMs() + ", punishDuration=" + r3.getPunishDuration() + ", punishStartTimeMs=" + r3.getPunishStartTimeMs() + '}';
    }
}

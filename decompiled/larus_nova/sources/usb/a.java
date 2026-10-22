package usb;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.newemoji.settings.EmojiConfigData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    public static int a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        EmojiConfigData r101 = (EmojiConfigData) SettingManager.getInstance().get(EmojiConfigData.class);     // Catch: Throwable -> L4
    L6:
        if (r101 == null) goto L10;
        Integer r102 = r101.a();
        if (r102 == null) goto L10;
        return RangesKt.coerceAtLeast(r102.intValue(), 1);
    L10:
        return 2;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r101 = null;
        goto L6
    }
}

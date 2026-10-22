package yib;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.forwardv3.settings.MergeForwardLimitSettings;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f568004a = null;

    static {
        f568004a = new c();
    }

    public c() {
    }

    public static int a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl((MergeForwardLimitSettings) SettingManager.getInstance().get(MergeForwardLimitSettings.class));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        MergeForwardLimitSettings r102 = (MergeForwardLimitSettings) r101;
        if (r102 == null) goto L14;
        Integer r103 = r102.getSelectCountLimit();
        if (r103 == null) goto L14;
        return r103.intValue();
    L14:
        return 20;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}

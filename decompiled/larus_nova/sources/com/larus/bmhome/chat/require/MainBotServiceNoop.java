package com.larus.bmhome.chat.require;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/require/MainBotServiceNoop;", "Lcom/larus/bmhome/chat/require/IMainBotService;", "<init>", "()V", "openMainBot", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "isEnableDouYinSdk", "", "getSearchSceneId", "", "isEnableDouyinFeedCocoEntrance", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainBotServiceNoop implements IMainBotService {
    public MainBotServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final String a() {
        return "";
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final boolean b() {
        return false;
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final void c(Context r100, IMainBotService.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
    }
}

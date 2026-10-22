package com.larus.platform.api;

import android.content.Context;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/api/IAiFilePreviewService;", "", "openAiFilePreview", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/larus/platform/model/office/AiFilePreviewRequest;", "fallback", "Lkotlin/Function0;", "openDriveUplinkPreview", "", "driveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "sourceConversationId", "", "sourceBotId", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiFilePreviewService {
    boolean a(Context r100, DriveUplinkInfo r101, String r102, String r103);

    void j(Context r100, CoroutineScope r101, cr9.a r102, Function0<Unit> r103);
}

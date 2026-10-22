package com.obric.assistant.obric_action;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H&J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/obric_action/IObricActionService;", "", "dispatchAsync", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fullUrl", "", "expectKey", "dispatch", "Lcom/obric/assistant/obric_action/ObricActionResult;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toObricActionString", "actionHost", "data", "key", "isSchemaMatch", "", "url", "generateKey", "obricActionKey", WikiFolderPushPlugin.BLOCK_ID, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionService {
    boolean a(String r100);

    String b(String r100, String r101, String r102);

    String c(String r100, String r101);

    void d(Context r100, String r101, String r102);

    Object e(Context r100, String r101, String r102, Continuation<? super h<? extends Object>> r103);
}

package com.obric.assistant.obric_action;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J0\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/obric_action/EmptyObricActionService;", "Lcom/obric/assistant/obric_action/IObricActionService;", "<init>", "()V", "dispatchAsync", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fullUrl", "", "expectKey", "dispatch", "Lcom/obric/assistant/obric_action/ObricActionResult;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toObricActionString", "actionHost", "data", "key", "isSchemaMatch", "", "url", "generateKey", "obricActionKey", WikiFolderPushPlugin.BLOCK_ID, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EmptyObricActionService implements IObricActionService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyObricActionService f390394a = null;

    static {
        f390394a = new EmptyObricActionService();
    }

    private EmptyObricActionService() {
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return false;
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "actionHost");
        Intrinsics.checkNotNullParameter(r101, "data");
        return "";
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String c(String r100, String r101) {
        return "";
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final void d(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fullUrl");
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final Object e(Context r100, String r101, String r102, Continuation<? super h<? extends Object>> r103) {
        return h.a.a(h.f390443d, "ObricActionService is null", 2);
    }
}

package com.larus.receive.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/larus/receive/api/IReceiveIntentService;", "", "isReceive", "", "intent", "Landroid/content/Intent;", "parseUris", "", "Landroid/net/Uri;", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "currentPage", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IReceiveIntentService {
    void a(Context r100);

    boolean b(Intent r100);

    List<Uri> c(Intent r100);
}

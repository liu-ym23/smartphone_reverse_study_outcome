package com.larus.bmhome.chat.quickreply;

import android.content.Context;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import mi8.g;
import mi8.h;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/quickreply/IMoaGrantingAppletService;", "", "createCardView", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingCardView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "prepare", "", "request", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingPrepareRequest;", "operate", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingOperateRequest;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMoaGrantingAppletService {
    void a(g r100);

    PermissionApplyCardView b(Context r100);

    void c(h r100);
}

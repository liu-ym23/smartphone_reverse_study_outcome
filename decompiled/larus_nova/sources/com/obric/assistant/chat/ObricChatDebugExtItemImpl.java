package com.obric.assistant.chat;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.debug.IChatDebugExtItem;
import com.obric.assistant.agent.ObricAgentService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatDebugExtItemImpl;", "Lcom/larus/bmhome/debug/IChatDebugExtItem;", "<init>", "()V", "priority", "", "supplyItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "messageId", "", "supplyItemGroup", "Landroid/widget/LinearLayout;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatDebugExtItemImpl implements IChatDebugExtItem {
    public ObricChatDebugExtItemImpl() {
    }

    @Override // com.larus.bmhome.debug.IChatDebugExtItem
    public final void priority() {
    }

    @Override // com.larus.bmhome.debug.IChatDebugExtItem
    public final LinearLayout a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        return ObricAgentService.f385580a.b(r100, r101);
    }

    @Override // com.larus.bmhome.debug.IChatDebugExtItem
    public final AppCompatTextView b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        return ObricAgentService.f385580a.c(r100, r101);
    }
}

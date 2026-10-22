package com.obric.assistant.interaction.impl.essentialtask;

import com.bytedance.android.livesdk.gift.model.n;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/TaskUtils;", "", "<init>", "()V", "MEMORY_DATA_PLUGIN_PKG_NAME", "", "AI_AGENT_PLUGIN_PKG_NAME", n.KEY_PLUGINS, "", "getPlugins", "()Ljava/util/List;", "systemLog", "", "tag", "logText", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskUtils {
    public static final String AI_AGENT_PLUGIN_PKG_NAME = "com.obric.aiagent.plugin";
    public static final TaskUtils INSTANCE = null;
    public static final String MEMORY_DATA_PLUGIN_PKG_NAME = "com.obric.memorydata.plugin";

    static {
        INSTANCE = new TaskUtils();
    }

    private TaskUtils() {
    }

    public final List<String> getPlugins() {
        List r100 = CollectionsKt.createListBuilder();
        if (t9a.b.a().e() == true) goto L5;
        r100.add("com.obric.memorydata.plugin");
    L5:
        r100.add("com.obric.aiagent.plugin");
        return CollectionsKt.build(r100);
    }

    public final void systemLog(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "logText");
        if (r102 == null) goto L5;
        FLogger.f375446a.w(r100, "[sys] " + r101, r102);
        return;
    L5:
        FLogger.f375446a.i(r100, "[sys] " + r101);
    }

    public static /* synthetic */ void systemLog$default(TaskUtils r100, String r101, String r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.systemLog(r101, r102, r103);
    }
}

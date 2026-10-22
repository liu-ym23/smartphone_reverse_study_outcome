package com.obric.assistant.interaction.impl.essentialtask;

import android.util.EventsUtils;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/TaskUtils;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "MEMORY_DATA_PLUGIN_PKG_NAME", XmlPullParser.NO_NAMESPACE, "AI_AGENT_PLUGIN_PKG_NAME", "plugins", XmlPullParser.NO_NAMESPACE, "getPlugins", "()Ljava/util/List;", "systemLog", XmlPullParser.NO_NAMESPACE, "tag", "logText", "error", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
        List r0 = CollectionsKt.createListBuilder();
        if (b.a().e() == true) goto L5;
        r0.add(MEMORY_DATA_PLUGIN_PKG_NAME);
    L5:
        r0.add("com.obric.aiagent.plugin");
        return CollectionsKt.build(r0);
    }

    public final void systemLog(String r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "logText");
        if (r6 == null) goto L5;
        FLogger.a.w(r4, "[sys] " + r5, r6);
        return;
    L5:
        FLogger.a.i(r4, "[sys] " + r5);
    }

    public static /* synthetic */ void systemLog$default(TaskUtils r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.systemLog(r1, r2, r3);
    }
}

package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", XmlPullParser.NO_NAMESPACE, "priorityAffinity", XmlPullParser.NO_NAMESPACE, "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public interface PriorityProvider {
    public static final Companion Companion = null;
    public static final int INFERIOR = 1;
    public static final int ORDINARY = 6;
    public static final int PIVOTAL = 11;
    public static final int REALTIME = 16;

    static {
        Companion = Companion.$$INSTANCE;
    }

    int priorityAffinity();
}

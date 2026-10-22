package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;", XmlPullParser.NO_NAMESPACE, "onThreadExit", XmlPullParser.NO_NAMESPACE, "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public interface IThreadExitListener {
    void onThreadExit();
}

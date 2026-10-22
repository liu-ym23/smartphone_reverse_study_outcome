package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.util.EventsUtils;
import java.util.Timer;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadTimer;", "Ljava/util/Timer;", "()V", "isDaemon", XmlPullParser.NO_NAMESPACE, "(Z)V", "name", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public class PthreadTimer extends Timer {
    public PthreadTimer() {
    }

    public PthreadTimer(String r1) {
        super(r1);
    }

    public PthreadTimer(String r1, boolean r2) {
        super(r1, r2);
    }

    public PthreadTimer(boolean r1) {
        super(r1);
    }
}

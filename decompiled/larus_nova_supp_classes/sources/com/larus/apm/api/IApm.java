package com.larus.apm.api;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/larus/apm/api/IApm;", XmlPullParser.NO_NAMESPACE, "initLogAndALog", XmlPullParser.NO_NAMESPACE, "debug", XmlPullParser.NO_NAMESPACE, "maxALogDirSizeMb", XmlPullParser.NO_NAMESPACE, "application", "Landroid/app/Application;", "initApm", "addLogObserver", "observer", "Lcom/larus/apm/api/ApmLogObserver;", "isMainProcess", "context", "Landroid/content/Context;", "registerDolaCloudControlConsumer", "isMinorMode", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IApm {
    void a(boolean r1, int r2, Application r3);

    void b(boolean r1);

    void c();

    boolean isMainProcess(Context r1);
}

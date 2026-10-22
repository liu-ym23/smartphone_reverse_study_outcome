package com.larus.bootprotector;

import android.content.Context;
import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/larus/bootprotector/BootProtectorDependency;", XmlPullParser.NO_NAMESPACE, "initBootProtectorLandingPageDependency", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "exeUrgentCmdTask", "isDebug", XmlPullParser.NO_NAMESPACE, "()Z", "uid", XmlPullParser.NO_NAMESPACE, "getUid", "()Ljava/lang/String;", "did", "getDid", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface BootProtectorDependency {
    void a(Context r1);

    void b();

    String getDid();

    String getUid();

    boolean isDebug();
}

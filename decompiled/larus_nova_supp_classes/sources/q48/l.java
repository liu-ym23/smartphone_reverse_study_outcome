package q48;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l implements y8a.b {
    public List<String> a;

    @Override // com.monitor.cloudmessage.callback.IConsumerResultCallback
    public final z8a.b getConsumerResult() {
        boolean r0 = !this.a.isEmpty();
        if (r0 == false) goto L5;
        String r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        if (r0 == false) goto L8;
        HashMap<String, String> r2 = null;
    L10:
        return new z8a.b(r0, r1, r2);
    L8:
        r2 = ALog.getLastFetchErrorInfo();
        goto L10
    L5:
        r1 = "alog file not get";
        goto L6
    }

    public l() {
        this.a = CollectionsKt.emptyList();
    }

    @Override // y8a.b
    public final List<String> handleAlogData(long r4, long r6, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        boolean r0 = k.a;
        k.b("Logger", "handleAlogData, startTime: " + r4 + ", endTime: " + r6 + ", params: " + r8);
        if (r4 >= r6) goto L10;
        ALog.asyncFlush();
        ObricAlogServiceDelegate.b.e();
        Thread.sleep(1000);     // Catch: InterruptedException -> L7
    L9:
        List<String> r5 = ALog.getALogFiles(r4, r6);
        this.a = r5;
        this.a = ObricAlogServiceDelegate.b.a(r5);
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        FLogger.a.e("Logger", "handleAlogData " + this.a);
        return this.a;
    }
}

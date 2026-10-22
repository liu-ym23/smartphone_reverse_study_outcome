package q48;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l implements y8a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f531701a;

    @Override // com.monitor.cloudmessage.callback.IConsumerResultCallback
    public final z8a.b getConsumerResult() {
        boolean r100 = !this.f531701a.isEmpty();
        if (r100 == false) goto L5;
        String r101 = "";
    L6:
        if (r100 == false) goto L8;
        HashMap<String, String> r102 = null;
    L10:
        return new z8a.b(r100, r101, r102);
    L8:
        r102 = ALog.getLastFetchErrorInfo();
        goto L10
    L5:
        r101 = "alog file not get";
        goto L6
    }

    public l() {
        this.f531701a = CollectionsKt.emptyList();
    }

    @Override // y8a.b
    public final List<String> handleAlogData(long r100, long r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        boolean r103 = k.f531692a;
        k.b("Logger", "handleAlogData, startTime: " + r100 + ", endTime: " + r101 + ", params: " + r102);
        if (r100 >= r101) goto L10;
        ALog.asyncFlush();
        ObricAlogServiceDelegate.f387841b.e();
        Thread.sleep(1000);     // Catch: InterruptedException -> L7
    L9:
        List<String> r104 = ALog.getALogFiles(r100, r101);
        this.f531701a = r104;
        this.f531701a = ObricAlogServiceDelegate.f387841b.a(r104);
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        FLogger.f375446a.e("Logger", "handleAlogData " + this.f531701a);
        return this.f531701a;
    }
}

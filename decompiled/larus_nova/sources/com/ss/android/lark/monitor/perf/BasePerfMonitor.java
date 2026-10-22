package com.ss.android.lark.monitor.perf;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public class BasePerfMonitor {

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlatformType {
        public static final int SLARDAR = 1;
        public static final int TEA = 2;
    }

    public interface a {
        void generateData(JSONObject r100, JSONObject r101, JSONObject r102);

        String getEventName(int r100);

        boolean isValid();

        boolean needReport(int r100);
    }

    public static abstract class b implements a {
        protected long costInMillis;

        public b() {
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean needReport(int r100) {
            if (r100 != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean isValid() {
            if (this.costInMillis <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void end() {
            this.costInMillis = SystemClock.elapsedRealtime() - this.costInMillis;
        }

        public void start() {
            this.costInMillis = SystemClock.elapsedRealtime();
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public void generateData(JSONObject r100, JSONObject r101, JSONObject r102) {
            r100.put("time", this.costInMillis);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public BasePerfMonitor() {
    }

    public static /* synthetic */ void a(a r100) {
        lambda$reportToTea$0(r100);
    }

    public static /* synthetic */ void b(a r100) {
        lambda$reportToSlardar$1(r100);
    }

    private static /* synthetic */ void lambda$reportToSlardar$1(a r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r100.generateData(r101, r102, r103);     // Catch: Exception -> L4
        ApmAgent.monitorEvent(r100.getEventName(1), r102, r101, r103);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CommonPerfMonitor", "reportToSlardar error", e);
    }

    private static /* synthetic */ void lambda$reportToTea$0(a r100) {
        JSONObject r101 = new JSONObject();
        r100.generateData(r101, r101, r101);
        Statistics.sendEvent(r100.getEventName(2), r101);
    }

    public static void reportToSlardar(final a r100) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.monitor.perf.a(r100));
        Log.d("CommonPerfMonitor", "start reportToSlardar");
    }

    public static void reportToTea(final a r100) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.monitor.perf.b(r100));
        Log.d("CommonPerfMonitor", "start reportToTea");
    }
}

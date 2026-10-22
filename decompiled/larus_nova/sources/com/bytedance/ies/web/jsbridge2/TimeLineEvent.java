package com.bytedance.ies.web.jsbridge2;

import android.os.SystemClock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes19.dex */
public class TimeLineEvent implements Serializable {
    private final long elapsedTimestamp;
    private final HashMap<String, Object> extra;
    private final String label;
    private final String message;
    private final String time;
    private final long timeInMillis;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f249287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f249288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f249289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f249290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public HashMap<String, Object> f249291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SimpleDateFormat f249292f;

        public final void c() {
            this.f249288b = this.f249292f.format(new Date());
            this.f249290d = SystemClock.elapsedRealtime();
            this.f249289c = System.currentTimeMillis();
        }

        public b() {
            this.f249292f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);
        }

        public final void a(String r100, List r101) {
            c();
            this.f249287a = r100;
            TimeLineEvent r102 = new TimeLineEvent(this, null);
            if (r101 == null) goto L6;
            r101.add(r102);
            return;
        }

        public final void b(String r100, Object r101) {
            if (this.f249291e != null) goto L5;
            this.f249291e = new HashMap();
        L5:
            this.f249291e.put(r100, r101);
        }
    }

    public long getElapsedTimestamp() {
        return this.elapsedTimestamp;
    }

    public HashMap<String, Object> getExtra() {
        return this.extra;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTime() {
        return this.time;
    }

    public long getTimeInMillis() {
        return this.timeInMillis;
    }

    private TimeLineEvent(b r100) {
        this.label = r100.f249287a;
        this.message = null;
        this.time = r100.f249288b;
        this.extra = r100.f249291e;
        this.elapsedTimestamp = r100.f249290d;
        this.timeInMillis = r100.f249289c;
    }

    public /* synthetic */ TimeLineEvent(b r100, a r101) {
        this(r100);
    }
}

package com.bytedance.ug.sdk.luckycat.impl.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class Statistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f271204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f271205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.bytedance.ug.sdk.luckycat.impl.lynx.queue.d> f271206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f271207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f271208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f271209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f271210g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/lynx/Statistics$Action;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "SUCCESS", "TIMEOUT", "PAGE_FINISHED", "ERROR", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Action extends Enum<Action> {
        public static final Action ERROR = null;
        public static final Action PAGE_FINISHED = null;
        public static final Action SUCCESS = null;
        public static final Action TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f271211a = null;
        private final String reason;

        static {
            Action r100 = new Action("SUCCESS", 0, "success");
            SUCCESS = r100;
            Action r101 = new Action("TIMEOUT", 1, "timeout");
            TIMEOUT = r101;
            Action r102 = new Action("PAGE_FINISHED", 2, "page_finished");
            PAGE_FINISHED = r102;
            Action r103 = new Action("ERROR", 3, "error");
            ERROR = r103;
            f271211a = new Action[]{r100, r101, r102, r103};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f271211a.clone();
        }

        public final String getReason() {
            return this.reason;
        }

        public Action(String r100, int r101, String r102) {
            super(r100, r101);
            this.reason = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/lynx/Statistics$Status;", "", "READY", "ERROR", "LOADING", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Status extends Enum<Status> {
        public static final Status ERROR = null;
        public static final Status LOADING = null;
        public static final Status READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f271212a = null;

        static {
            Status r100 = new Status("READY", 0);
            READY = r100;
            Status r101 = new Status("ERROR", 1);
            ERROR = r101;
            Status r102 = new Status("LOADING", 2);
            LOADING = r102;
            f271212a = new Status[]{r100, r101, r102};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f271212a.clone();
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Statistics(String r100) {
        this.f271210g = r100;
        this.f271205b = new LinkedHashMap();
        this.f271206c = new LinkedHashMap();
        this.f271207d = new ArrayList();
        this.f271209f = new AtomicBoolean(false);
    }

    public final void a(Action r100) {
        if (this.f271209f.compareAndSet(false, true) == false) goto L27;
        JSONObject r101 = new JSONObject();
        r101.put("finish_type", r100.getReason());
        Iterator<T> r102 = this.f271207d.iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        String r103 = (String) r102.next();
        r101.put("need_" + r103, 1);
        String r104 = r103 + "_status";
        if (this.f271205b.containsKey(r103) == false) goto L11;
        Status r105 = Status.READY;
    L14:
        r101.put(r104, r105.name());
        Iterator r106 = ((LinkedHashMap) this.f271205b).entrySet().iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        Map.Entry r107 = (Map.Entry) r106.next();
        r101.put(((String) r107.getKey()) + "_time_consuming", ((Number) r107.getValue()).longValue());
        goto L16
    L18:
        Iterator r108 = ((LinkedHashMap) this.f271206c).entrySet().iterator();
    L20:
        if (r108.hasNext() == false) goto L6;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r110 = ((String) r109.getKey()) + "_error_code";
        ((com.bytedance.ug.sdk.luckycat.impl.lynx.queue.d) r109.getValue()).getClass();
        r101.put(r110, 0);
        String r111 = ((String) r109.getKey()) + "_error_reason";
        ((com.bytedance.ug.sdk.luckycat.impl.lynx.queue.d) r109.getValue()).getClass();
        r101.put(r111, null);
        goto L20
    L11:
        if (this.f271206c.containsKey(r103) == false) goto L13;
        r105 = Status.ERROR;
        goto L14
    L13:
        r105 = Status.LOADING;
        goto L14
    L22:
        r101.put("url", this.f271210g);
        r101.put("cat_sdk_version_code", 890100);
        r101.put("cat_sdk_version", "8.75.0-rc.12-db");
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatLynxFragment", "ug_sdk_luckycat_container_env_prepare: " + r101);
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_container_env_prepare", r101, true);
        this.f271204a = new JSONObject(r101.toString());
        return;
    }

    public final void b(boolean r100, List<String> r101) {
        this.f271208e = System.currentTimeMillis();
        this.f271207d = r101;
        if (r100 == false) goto L11;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        this.f271205b.put(r103, 0L);
        goto L6
    L8:
        a(Action.SUCCESS);
        return;
    }
}

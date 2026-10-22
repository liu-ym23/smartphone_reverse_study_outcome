package com.bytedance.pia.core.tracing;

import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f266349d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f266350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<b> f266351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f266352c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GsonUtils.Exclude
        public boolean f266353a;

        @SerializedName("args")
        public final Map<String, Object> args;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f266354b;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        public long f266355id;

        @SerializedName("name")
        public final EventName name;

        @SerializedName("ts")
        public final Long timestamp;

        public final void a() {
            d r100 = this.f266354b;
            int r101 = d.f266349d;
            r100.getClass();
            ThreadUtil.d(new c(r100, this, true));
        }

        public a(d r100, EventName r101, long r102) {
            this.f266354b = r100;
            this.f266355id = r100.f266352c.getAndIncrement();
            this.f266353a = false;
            this.name = r101;
            this.timestamp = Long.valueOf(r102);
            this.args = new HashMap();
        }
    }

    public interface b extends l47.a<a> {
        boolean isFinished();
    }

    public d() {
        this.f266350a = new CopyOnWriteArrayList();
        this.f266351b = new HashSet();
        this.f266352c = new AtomicLong(0);
    }

    static {
    }

    public final a a(EventName r100) {
        return new a(this, r100, System.currentTimeMillis());
    }
}

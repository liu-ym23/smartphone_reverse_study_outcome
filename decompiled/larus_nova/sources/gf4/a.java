package gf4;

import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.state.Stage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stage f481048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f481049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f481050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f481051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f481052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f481053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f481054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f481055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f481056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f481057j;

    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("stage", this.f481048a.getDesc());
        b r101 = this.f481056i;
        r101.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("cj_open_time", Long.valueOf(r101.f481058a));
        r102.put("container_create_start", Long.valueOf(RangesKt.coerceAtLeast(r101.f481059b - r101.f481058a, 0)));
        r102.put("container_create_end", Long.valueOf(RangesKt.coerceAtLeast(r101.f481060c - r101.f481058a, 0)));
        r102.put("container_load_start", Long.valueOf(RangesKt.coerceAtLeast(r101.f481061d - r101.f481058a, 0)));
        r102.put("container_load_template_start", Long.valueOf(RangesKt.coerceAtLeast(r101.f481062e - r101.f481058a, 0)));
        r102.put("container_load_end", Long.valueOf(RangesKt.coerceAtLeast(r101.f481063f - r101.f481058a, 0)));
        r102.put("container_load_failed", Long.valueOf(RangesKt.coerceAtLeast(r101.f481064g - r101.f481058a, 0)));
        r102.put("contaier_destory_latency", Long.valueOf(RangesKt.coerceAtLeast(r101.f481065h - r101.f481058a, 0)));
        r102.put("container_destory_latency", Long.valueOf(RangesKt.coerceAtLeast(r101.f481065h - r101.f481058a, 0)));
        r100.putAll(r102);
        return r100;
    }

    public a() {
        this.f481048a = Stage.STAGE_INIT;
        this.f481049b = new AtomicBoolean(false);
        this.f481050c = new AtomicBoolean(false);
        this.f481051d = new AtomicBoolean(false);
        this.f481056i = new b();
        this.f481057j = new AtomicBoolean(false);
    }
}

package com.bytedance.ug.sdk.luckydog.api.eventsample;

import com.bytedance.ug.sdk.luckydog.api.log.d;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyEventSampleManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f271570e = "LuckyEventSampleManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f271571f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f271572g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f271574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f271575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f271576d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f271577a = null;

        static {
            f271577a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "instance", "getInstance()Lcom/bytedance/ug/sdk/luckydog/api/eventsample/LuckyEventSampleManager;"))};
        }

        public a() {
        }

        public static LuckyEventSampleManager a() {
            Lazy r100 = LuckyEventSampleManager.f271571f;
            KProperty r101 = f271577a[0];
            return (LuckyEventSampleManager) r100.getValue();
        }
    }

    static {
        f271572g = new a();
        f271570e = "LuckyEventSampleManager";
        f271571f = LazyKt.lazy(LuckyEventSampleManager$Companion$instance$2.INSTANCE);
    }

    public LuckyEventSampleManager() {
        this.f271573a = "sample_strategy_file";
        this.f271574b = "sample_strategy_key";
        this.f271575c = new JSONObject();
        this.f271576d = 10000;
    }

    public final boolean a(String r110) {
        double r100 = this.f271575c.optDouble(r110, -1.0d);
        boolean r101 = false;
        double r102 = 0;
        if (r100 < r102) goto L15;
        String r103 = f271570e;
        d.d(r103, "allowSample() call, event:" + r110 + ", sampleRate: " + r100 + '}');
        if (r100 < r102) goto L13;
        double r104 = 100;
        if (r100 > r104) goto L13;
        int r105 = new Random().nextInt(this.f271576d);
        d.d(r103, "begin sample, event:" + r110 + ", sampleRate: " + r100 + ", randomInt: " + r105);
        if ((r105 % this.f271576d) >= (r100 * r104)) goto L16;
        r101 = true;
    L16:
        return r101;
    L13:
        d.d(r103, "采样率数值错误 直接上报");
        return true;
    L15:
        return true;
    }
}

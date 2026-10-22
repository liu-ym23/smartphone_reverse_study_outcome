package com.bytedance.live.dynamicresource.client;

import com.bytedance.live.dynamicresource.b;
import com.bytedance.live.dynamicresource.d;
import com.bytedance.live.dynamicresource.producer.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f255112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f255113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f255114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f255115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final KClass<EntranceModel> f255116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final KClass<LayoutConfig> f255117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a<EntranceModel, LayoutConfig, RouterKey>> f255118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<EntranceModel, RouterKey, String> f255119j;

    public static final class Builder<EntranceModel, LayoutConfig, RouterKey> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f255120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f255121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f255122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f255123d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f255124e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f255125f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<a<EntranceModel, LayoutConfig, RouterKey>> f255126g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final b f255127h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public KClass<EntranceModel> f255128i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public KClass<LayoutConfig> f255129j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Function2<? super EntranceModel, ? super RouterKey, String> f255130k;

        public Builder() {
            this.f255120a = "";
            this.f255121b = "";
            this.f255122c = "";
            this.f255123d = "";
            this.f255124e = "entrance.json";
            this.f255125f = 5;
            this.f255126g = new ArrayList();
            this.f255127h = d.f255131a.getContext();
            this.f255130k = ResourceClientContext$Builder$routerRuleProducer$1.INSTANCE;
        }

        public final b getContext() {
            return this.f255127h;
        }
    }

    public ResourceClientContext(Builder<EntranceModel, LayoutConfig, RouterKey> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f255110a = r100.f255120a;
        this.f255111b = r100.f255121b;
        this.f255112c = r100.f255122c;
        this.f255113d = r100.f255123d;
        this.f255114e = r100.f255124e;
        this.f255115f = r100.f255125f;
        KClass<EntranceModel> r101 = r100.f255128i;
        if (r101 == null) goto L11;
        this.f255116g = r101;
        KClass<LayoutConfig> r102 = r100.f255129j;
        if (r102 == null) goto L9;
        this.f255117h = r102;
        this.f255118i = r100.f255126g;
        this.f255119j = r100.f255130k;
        return;
    L9:
        throw new Error("set modelClazz");
    L11:
        throw new Error("set entranceClazz");
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        return this.f255110a + '/' + this.f255111b + '/' + r100;
    }
}

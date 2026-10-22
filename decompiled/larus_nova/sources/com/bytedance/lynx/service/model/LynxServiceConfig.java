package com.bytedance.lynx.service.model;

import android.app.Application;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LynxServiceConfig {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f264868l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f264869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f264870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f264871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f264872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f264873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f264874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f264875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f264876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f264877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f264878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AdapterType f264879k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "", "COMMON", "GLOBAL", "LynxService_noasanRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum AdapterType extends Enum<AdapterType> {
        public static final AdapterType COMMON = null;
        public static final AdapterType GLOBAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdapterType[] f264880a = null;

        public static AdapterType valueOf(String r100) {
            return (AdapterType) r27.a.a(AdapterType.class, r100);
        }

        public static AdapterType[] values() {
            return (AdapterType[]) f264880a.clone();
        }

        static {
            AdapterType r100 = new AdapterType("COMMON", 0);
            COMMON = r100;
            AdapterType r101 = new AdapterType("GLOBAL", 1);
            GLOBAL = r101;
            f264880a = new AdapterType[]{r100, r101};
        }

        public AdapterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f264881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f264882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f264883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f264884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f264885e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f264886f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f264887g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f264888h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function0<Unit> f264889i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AdapterType f264890j;

        public final Application getContext() {
            return this.f264881a;
        }

        public Builder(Application r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f264881a = r100;
            this.f264882b = "";
            this.f264883c = "";
            this.f264884d = "";
            this.f264885e = "";
            this.f264886f = "";
            this.f264887g = "";
            this.f264888h = "";
            this.f264889i = LynxServiceConfig$Builder$additionInit$1.INSTANCE;
            this.f264890j = AdapterType.COMMON;
        }
    }

    public static final class a {
    }

    static {
    }

    public final Application getContext() {
        return this.f264869a;
    }

    public LynxServiceConfig(Application r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Function0 r108, AdapterType r110) {
        this.f264869a = r100;
        this.f264870b = r101;
        this.f264871c = r102;
        this.f264872d = r103;
        this.f264873e = r104;
        this.f264874f = r105;
        this.f264875g = r106;
        this.f264876h = r107;
        this.f264877i = r108;
        this.f264878j = false;
        this.f264879k = r110;
    }
}

package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.lynx.tasm.LynxEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LynxConfig implements com.bytedance.ies.bullet.service.base.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Builder f247327a;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f247328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f247329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f247330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<com.lynx.tasm.behavior.a> f247331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, g26.c> f247332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f247333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<? super LynxEnv, Unit> f247334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f247335h;

        public final Application getContext() {
            return this.f247328a;
        }

        public Builder(Application r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f247328a = r100;
            this.f247329b = true;
            this.f247330c = new ArrayList();
            this.f247331d = new ArrayList();
            this.f247332e = new LinkedHashMap();
            this.f247334g = LynxConfig$Builder$additionInit$1.INSTANCE;
        }
    }

    public LynxConfig(Application r100, Builder r101) {
        this.f247327a = r101;
        h r102 = h.f247352a;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        h.f247353b = r100;
    }
}

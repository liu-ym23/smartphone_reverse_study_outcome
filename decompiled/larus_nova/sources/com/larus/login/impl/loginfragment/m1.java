package com.larus.login.impl.loginfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class m1 extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f357989b = null;

    public static final class a {
    }

    public static final class b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f357990a;

        public b() {
            this.f357990a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            this.f357990a = "else";     // Catch: Throwable -> L5
            return LayoutInflater.from(r100).inflate(r102, r101, false);
        L5:
            th = move-exception;
            FLogger.f375446a.e("LOGINFragmentNitaView", " msg=" + th.getMessage());
            JSONObject r103 = new JSONObject();
            r103.put("tag", "login_fragment_nita");
            r103.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r103.put("err_view", this.f357990a);
            return new View(r100);
        }
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final void e(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "activity");
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "login_fragment_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    static {
        f357989b = new ArrayList();
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return CollectionsKt.toIntArray(f357989b);
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public m1() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}

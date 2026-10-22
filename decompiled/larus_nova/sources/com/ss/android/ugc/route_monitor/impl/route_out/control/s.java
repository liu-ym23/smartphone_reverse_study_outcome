package com.ss.android.ugc.route_monitor.impl.route_out.control;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f454671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MatchResult f454672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f454673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ControlRule f454674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f454675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<mhc.c> f454676f;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{result=");
        r100.append(this.f454672b);
        r100.append(", hasRuleForCertId=");
        r100.append(this.f454675e);
        r100.append(", routeOutInfo=");
        r100.append(this.f454671a);
        r100.append(",rule=");
        ControlRule r101 = this.f454674d;
        if (r101 == null) goto L5;
        JSONObject r102 = r101.toJsonObject$route_monitor_release();
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public /* synthetic */ s(o r100, MatchResult r101, String r110, ControlRule r111, boolean r112) {
        this(r100, r101, r110, r111, r112, new ArrayList());
    }

    public s(o r100, MatchResult r101, String r102, ControlRule r103, boolean r104, List<mhc.c> r105) {
        this.f454671a = r100;
        this.f454672b = r101;
        this.f454673c = r102;
        this.f454674d = r103;
        this.f454675e = r104;
        this.f454676f = r105;
    }
}

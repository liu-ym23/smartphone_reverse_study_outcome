package mhc;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.android.ugc.route_monitor.impl.route_out.control.o;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f514030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ControlRule f514031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RuleConditionBean f514032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f514033d;

    public final String toString() {
        return "SingleRuleMatchResult(routeOutInfo=" + this.f514030a + ", missMatchConditionBean=" + this.f514032c + ", result=" + this.f514033d + ')';
    }

    public c(o r100, ControlRule r101, RuleConditionBean r102, boolean r103) {
        this.f514030a = r100;
        this.f514031b = r101;
        this.f514032c = r102;
        this.f514033d = r103;
    }
}

package com.larus.perfdegrade.impl;

import com.larus.perfdegrade.api.IPerfDegradeAbility;
import com.larus.perfdegrade.api.model.PerfDegradeScrollEvent;
import com.larus.perfdegrade.api.model.PerfDegradeType;
import com.larus.utils.logger.FLogger;
import cp9.a;
import cp9.b;
import fp9.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/perfdegrade/impl/PerfDegradeAbilityImpl;", "Lcom/larus/perfdegrade/api/IPerfDegradeAbility;", "<init>", "()V", "isExperimentEnabled", "", "type", "Lcom/larus/perfdegrade/api/model/PerfDegradeType;", "trigger", "Lcom/larus/perfdegrade/api/model/PerfDegradeResult;", "request", "Lcom/larus/perfdegrade/api/model/PerfDegradeRequest;", "shouldDispatchScrollEvent", "scene", "", "dispatchScrollEvent", "", "event", "Lcom/larus/perfdegrade/api/model/PerfDegradeScrollEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerfDegradeAbilityImpl implements IPerfDegradeAbility {
    public PerfDegradeAbilityImpl() {
    }

    @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
    public final b a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        String r101 = dp9.b.f469616a;
        Intrinsics.checkNotNullParameter(r100, "request");
        FLogger r102 = FLogger.f375446a;
        String r103 = dp9.b.f469616a;
        StringBuilder r104 = new StringBuilder("receive trigger request, type=");
        r104.append(r100.getType());
        r104.append(", scene=");
        r104.append(r100.f464727b);
        r104.append(", hasDebugOptions=");
        r100.getClass();
        boolean r105 = true;
        r104.append(false);
        r102.i(r103, r104.toString());
        h r106 = (h) ((Map) dp9.b.f469617b.getValue()).get(r100.getType());
        if (r106 != null) goto L5;
        b r107 = new b(false, "unsupported degrade type: " + r100.getType());
        r102.w(r103, "reject trigger request, type=" + r100.getType() + ", scene=" + r100.f464727b + ", reason=" + r107.f464729b);
        return r107;
    L5:
        b r108 = r106.a(r100);
        if (r108.f464728a == false) goto L8;
        r102.i(r103, "trigger request accepted, type=" + r100.getType() + ", scene=" + r100.f464727b + ", reason=" + r108.f464729b);
        return r108;
    L8:
        String r109 = r108.f464729b;
        if (r109 != null) goto L12;
        r109 = "";
    L12:
        if (StringsKt.contains(r109, "invalid", true) == false) goto L14;
    L19:
        if (r105 == false) goto L21;
        r102.w(r103, "trigger request rejected, type=" + r100.getType() + ", scene=" + r100.f464727b + ", reason=" + r108.f464729b);
        return r108;
    L21:
        r102.i(r103, "trigger request skipped, type=" + r100.getType() + ", scene=" + r100.f464727b + ", reason=" + r108.f464729b);
        return r108;
    L14:
        if (StringsKt.contains(r109, "unsupported", true) == true) goto L19;
        if (StringsKt.contains(r109, "empty", true) == true) goto L19;
        r105 = false;
        goto L19
    }

    @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
    public final void b(PerfDegradeScrollEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = dp9.b.f469616a;
        Intrinsics.checkNotNullParameter(r100, "event");
        h r102 = (h) ((Map) dp9.b.f469617b.getValue()).get(r100.getType());
        if (r102 == null) goto L6;
        r102.b(r100);
        return;
    }

    @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
    public final boolean c(PerfDegradeType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        String r102 = dp9.b.f469616a;
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        h r103 = (h) ((Map) dp9.b.f469617b.getValue()).get(r100);
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.c(r101) != true) goto L7;
        return true;
    }
}

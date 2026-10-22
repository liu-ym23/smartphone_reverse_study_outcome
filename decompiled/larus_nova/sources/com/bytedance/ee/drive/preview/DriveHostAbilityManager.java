package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.drive.render.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveHostAbilityManager implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f242672a;

    @Override // com.bytedance.ee.drive.render.m
    public final List<i> b() {
        Map r100 = (Map) this.f242672a.getValue();
        ArrayList r101 = new ArrayList(r100.size());
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add((i) ((Map.Entry) r102.next()).getValue());
        goto L4
    L6:
        return r101;
    }

    public DriveHostAbilityManager() {
        this.f242672a = LazyKt.lazy(DriveHostAbilityManager$hostAbilities$2.INSTANCE);
    }

    @Override // com.bytedance.ee.drive.render.m
    public final <T extends i> void a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        ((Map) this.f242672a.getValue()).remove(r100);
    }

    @Override // com.bytedance.ee.drive.render.m
    public final <T extends i> void c(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "hostAbility");
        ((Map) this.f242672a.getValue()).put(r100, r101);
    }
}

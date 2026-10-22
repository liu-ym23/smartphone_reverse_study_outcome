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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveHostAbilityManager implements m {
    public final Lazy a;

    @Override // com.bytedance.ee.drive.render.m
    public final List<i> b() {
        Map r0 = (Map) this.a.getValue();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((i) ((Map.Entry) r2.next()).getValue());
        goto L4
    L6:
        return r1;
    }

    public DriveHostAbilityManager() {
        this.a = LazyKt.lazy(DriveHostAbilityManager$hostAbilities$2.INSTANCE);
    }

    @Override // com.bytedance.ee.drive.render.m
    public final <T extends i> void a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        ((Map) this.a.getValue()).remove(r2);
    }

    @Override // com.bytedance.ee.drive.render.m
    public final <T extends i> void c(Class<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "hostAbility");
        ((Map) this.a.getValue()).put(r2, r3);
    }
}

package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class Config {
    public final Context a;
    public final String b;
    public final String c;
    public final Keva d;
    public final Lazy e;

    public final JSONObject a() {
        String r0 = this.d.getStringJustDisk(this.b, "");
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L12;
        return null;
    L12:
        return new JSONObject(r0);
    L11:
        return null;
    L5:
        r1 = false;
        goto L7
    }

    public final Context getContext() {
        return this.a;
    }

    public final void b(k r5) {
        Intrinsics.checkNotNullParameter(r5, "fastMatchGroups");
        ((Set) this.e.getValue()).clear();
        Set<Model$EventType> r6 = r5.d;
        if (r6 != null) goto L6;
        r6 = SetsKt.emptySet();
    L6:
        if (r6.isEmpty() == false) goto L8;
        return;
    L8:
        ((Set) this.e.getValue()).addAll(r6);
        Keva r7 = this.d;
        String r0 = this.c;
        Set r1 = (Set) this.e.getValue();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r2.add(((Model$EventType) r3.next()).getAlias());
        goto L10
    L12:
        r7.storeStringSetJustDisk(r0, CollectionsKt.toSet(r2));
    }

    public Config(com.bytedance.applog.log.a r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "appId");
        this.a = r3;
        this.b = "data";
        this.c = "fast_match_event_types";
        this.d = Keva.getRepo("applog_priority_origin@" + r4 + "_config", 0);
        this.e = LazyKt.lazy(new Config$fastMatchEventTypes$2(this));
    }
}

package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class Config {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f192645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f192646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Keva f192648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f192649e;

    public final JSONObject a() {
        String r100 = this.f192648d.getStringJustDisk(this.f192646b, "");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L12;
        return null;
    L12:
        return new JSONObject(r100);
    L11:
        return null;
    L5:
        r101 = false;
        goto L7
    }

    public final Context getContext() {
        return this.f192645a;
    }

    public final void b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "fastMatchGroups");
        ((Set) this.f192649e.getValue()).clear();
        Set<Model$EventType> r101 = r100.f192752d;
        if (r101 != null) goto L6;
        r101 = SetsKt.emptySet();
    L6:
        if (r101.isEmpty() == false) goto L8;
        return;
    L8:
        ((Set) this.f192649e.getValue()).addAll(r101);
        Keva r102 = this.f192648d;
        String r103 = this.f192647c;
        Set r104 = (Set) this.f192649e.getValue();
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(((Model$EventType) r106.next()).getAlias());
        goto L10
    L12:
        r102.storeStringSetJustDisk(r103, CollectionsKt.toSet(r105));
    }

    public Config(com.bytedance.applog.log.a r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "appId");
        this.f192645a = r101;
        this.f192646b = "data";
        this.f192647c = "fast_match_event_types";
        this.f192648d = Keva.getRepo("applog_priority_origin@" + r102 + "_config", 0);
        this.f192649e = LazyKt.lazy(new Config$fastMatchEventTypes$2(this));
    }
}

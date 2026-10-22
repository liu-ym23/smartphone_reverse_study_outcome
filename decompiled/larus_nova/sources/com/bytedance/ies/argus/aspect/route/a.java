package com.bytedance.ies.argus.aspect.route;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class a extends com.bytedance.ies.argus.strategy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f245902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f245903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f245904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f245905e;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f245901a = r100;
        this.f245902b = null;
        this.f245903c = new CopyOnWriteArrayList();
        this.f245904d = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "sessionId", this.f245901a);
        CopyOnWriteArrayList<e> r102 = this.f245903c;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<e> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r104.next().d(r100));
        goto L4
    L6:
        JSONUtilsKt.d(r101, "chain", r103);
        JSONUtilsKt.d(r101, "scene", this.f245902b);
        JSONUtilsKt.d(r101, "entryScene", this.f245905e);
        e r105 = (e) CollectionsKt.firstOrNull(this.f245903c);
        String r106 = null;
        if (r105 == null) goto L9;
        String r107 = r105.f245908b;
    L10:
        JSONUtilsKt.d(r101, "entrySchema", r107);
        e r108 = (e) CollectionsKt.firstOrNull(this.f245903c);
        if (r108 == null) goto L13;
        r106 = r108.f245907a;
    L13:
        JSONUtilsKt.d(r101, "firstContainerClassName", r106);
        return r101;
    L9:
        r107 = null;
        goto L10
    }
}

package com.bytedance.android.shopping.mall.feed.help;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ShelterEventHelp implements s, g {
    public final List<Pair<String, JSONObject>> a;
    public boolean b;
    public boolean c;
    public final Map<Integer, List<Pair<String, JSONObject>>> d;
    public RecyclerView e;
    public final Set<BaseViewHolder> f;
    public final ShelterEventHelp$attachListener$1 g;
    public volatile boolean h;
    public final Lazy i;
    public final Lazy j;
    public final q k;

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void j(boolean r1) {
    }

    public final void b() {
        Set<BaseViewHolder> r0 = this.f;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L3:
        Integer r3 = null;
        if (r2.hasNext() == false) goto L15;
        ECHybridListItemVO r4 = ((BaseViewHolder) r2.next()).c;
        if (r4 == null) goto L14;
        com.bytedance.android.ec.hybrid.list.entity.n r5 = r4.o;
        if (r5 == null) goto L14;
        List r6 = r5.c;
        if (r6 == null) goto L14;
        com.bytedance.android.ec.hybrid.list.entity.c r7 = (com.bytedance.android.ec.hybrid.list.entity.c) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L14;
        r3 = r7.h;
    L14:
        r1.add(r3);
        goto L3
    L15:
        List r8 = CollectionsKt.filterNotNull(r1);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L41
        Iterator r10 = ((ArrayList) this.a).iterator();     // Catch: Throwable -> L41
    L18:
        if (r10.hasNext() == false) goto L39;
        Pair<String, JSONObject> r11 = (Pair) r10.next();     // Catch: Throwable -> L41
        Object r12 = ((JSONObject) r11.getSecond()).opt("item_data_flag");     // Catch: Throwable -> L41
        if ((r12 instanceof Integer) == true) goto L22;
        r12 = null;
    L22:
        Integer r13 = (Integer) r12;     // Catch: Throwable -> L41
        if (r13 != null) goto L25;
    L33:
        AppLogNewUtils.onEventV3((String) r11.getFirst(), (JSONObject) r11.getSecond());     // Catch: Throwable -> L41
    L35:
        if (this.d.isEmpty() == false) goto L18;
        RecyclerView r14 = this.e;     // Catch: Throwable -> L41
        if (r14 == null) goto L18;
        r14.removeOnChildAttachStateChangeListener(this.g);     // Catch: Throwable -> L41
        goto L18
    L25:
        if (r8.isEmpty() == true) goto L33;
        if (r8.contains(r13) == true) goto L33;
        List<Pair<String, JSONObject>> r15 = (List) ((LinkedHashMap) this.d).get(r13);     // Catch: Throwable -> L41
        if (r15 != null) goto L32;
        r15 = new ArrayList();     // Catch: Throwable -> L41
    L32:
        r15.add(r11);     // Catch: Throwable -> L41
        this.d.put(r13, r15);     // Catch: Throwable -> L41
        goto L35
    L39:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        ((ArrayList) this.a).clear();
        q r16 = this.k;
        if (r16 == null) goto L46;
        r16.h((ShelterEventHelp$popupListener$2.a) this.j.getValue());
    L46:
        q r17 = this.k;
        if (r17 == null) goto L65;
        r17.a((ShelterEventHelp$halfPageListener$2.a) this.i.getValue());
        return;
    L65:
        return;
    L41:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.android.shopping.mall.feed.help.ShelterEventHelp$attachListener$1] */
    public ShelterEventHelp(q r1) {
        this.k = r1;
        this.a = new ArrayList();
        this.d = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new ShelterEventHelp$attachListener$1(this);
        this.h = true;
        this.i = LazyKt.lazy(new ShelterEventHelp$halfPageListener$2(this));
        this.j = LazyKt.lazy(new ShelterEventHelp$popupListener$2(this));
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void k(boolean r1) {
        this.b = r1;
        if (this.c == true) goto L6;
        b();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.s
    public final boolean a(final String r2, final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "eventParams");
        if (this.k != null) goto L5;
        return false;
    L5:
        if (this.h == false) goto L11;
        t93.a.c(new ShelterEventHelp$checkShelterAndReport$1(this, r2, r3));
        return true;
    L11:
        return false;
    }
}

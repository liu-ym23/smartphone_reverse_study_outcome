package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import androidx.collection.LruCache;
import com.bytedance.android.ec.model.response.RitTagUI;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final LruCache<Integer, d> e = null;
    public static final a f = null;
    public final Map<RitTagUI.RitTagUIItem.UIItemType, Function1<Context, b>> a;
    public final Map<RitTagUI.RitTagUIItem.UIItemType, Function3<b, RitTagUI.RitTagUIItem, RitTagUI, Unit>> b;
    public final int c;
    public final int d;

    public static final class a {
        public a() {
        }
    }

    static {
        f = new a();
        e = new LruCache(20);
    }

    public d() {
        this.c = 14;
        this.d = 10;
        RitTagUI.RitTagUIItem.UIItemType r2 = RitTagUI.RitTagUIItem.UIItemType.TEXT;
        RitTagUI.RitTagUIItem.UIItemType r3 = RitTagUI.RitTagUIItem.UIItemType.IMAGE;
        RitTagUI.RitTagUIItem.UIItemType r5 = RitTagUI.RitTagUIItem.UIItemType.SPLIT;
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, RitTagViewFactory$elementGenerators$1.INSTANCE), TuplesKt.to(r3, RitTagViewFactory$elementGenerators$2.INSTANCE), TuplesKt.to(r5, RitTagViewFactory$elementGenerators$3.INSTANCE)});
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, new RitTagViewFactory$elementStyleBinders$1(this)), TuplesKt.to(r3, new RitTagViewFactory$elementStyleBinders$2(this)), TuplesKt.to(r5, RitTagViewFactory$elementStyleBinders$3.INSTANCE)});
    }
}

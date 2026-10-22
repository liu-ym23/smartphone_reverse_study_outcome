package com.ss.android.ugc.aweme.search.keyboard;

import com.ss.android.ugc.aweme.discover.commodity.utils.JsonParseUtils;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import com.ss.android.ugc.aweme.search.common.config.Strategy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/keyboard/EcSearchKeyboardManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcSearchKeyboardManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f453272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f453273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f453274c;

    public EcSearchKeyboardManager() {
    }

    public final boolean a() {
        ECSearchExperiment.f451414b.getClass();
        if (ECSearchExperiment.i().length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L42;
        List r101 = CollectionsKt.emptyList();
    L11:
        Iterator r102 = r101.iterator();
    L12:
        Integer r103 = null;
        if (r102.hasNext() == false) goto L17;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((Strategy) r104).b(), this.f453272a) == false) goto L12;
    L18:
        Strategy r105 = (Strategy) r104;
        if (r105 != null) goto L22;
        return false;
    L22:
        if (this.f453273b == true) goto L28;
        if (r105.c() != 1) goto L47;
        return true;
    L47:
        return false;
    L28:
        if (r105.d() != 1) goto L30;
        return true;
    L30:
        Map<String, Integer> r106 = r105.a();
        if (r106 == null) goto L36;
        String r107 = this.f453274c;
        if (r107 != null) goto L35;
        r107 = "";
    L35:
        r103 = r106.get(r107);
    L36:
        if (r103 != null) goto L39;
        return false;
    L39:
        if (r103.intValue() != 1) goto L48;
        return true;
    L48:
        return false;
    L17:
        r104 = null;
        goto L18
    L42:
        r101 = JsonParseUtils.a(ECSearchExperiment.i(), Strategy.class);     // Catch: Exception -> L10
    L10:
        r101 = CollectionsKt.emptyList();
        goto L11
    L5:
        r100 = false;
        goto L6
    }
}

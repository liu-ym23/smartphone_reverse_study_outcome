package com.larksuite.component.card.cardcontainer;

import android.content.Context;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f283233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardData f283234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardContext f283235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardConfig f283236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cz7.a f283237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f283238f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f283233a, r101.f283233a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283234b, r101.f283234b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283235c, r101.f283235c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f283236d, r101.f283236d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f283237e, r101.f283237e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f283238f, r101.f283238f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f283233a.hashCode() * 31) + this.f283234b.hashCode()) * 31) + this.f283235c.hashCode()) * 31) + this.f283236d.hashCode()) * 31) + this.f283237e.hashCode()) * 31;
        Integer r101 = this.f283238f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UniversalCardShareData(context=" + this.f283233a + ", cardData=" + this.f283234b + ", cardContext=" + this.f283235c + ", cardConfig=" + this.f283236d + ", componentShareData=" + this.f283237e + ", exactLynxViewWidth=" + this.f283238f + ')';
    }

    public final Context getContext() {
        return this.f283233a;
    }

    public c(Context r100, CardData r101, CardContext r102, CardConfig r103, cz7.a r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardData");
        Intrinsics.checkNotNullParameter(r102, "cardContext");
        Intrinsics.checkNotNullParameter(r103, "cardConfig");
        Intrinsics.checkNotNullParameter(r104, "componentShareData");
        this.f283233a = r100;
        this.f283234b = r101;
        this.f283235c = r102;
        this.f283236d = r103;
        this.f283237e = r104;
        this.f283238f = r105;
    }
}

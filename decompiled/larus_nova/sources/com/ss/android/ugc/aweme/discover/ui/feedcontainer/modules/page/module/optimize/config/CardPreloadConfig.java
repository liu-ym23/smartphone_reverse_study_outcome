package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/CardPreloadConfig;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardPreloadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mode f450684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Mode f450685b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CardPreloadConfig) == false) goto L10;
        CardPreloadConfig r101 = (CardPreloadConfig) r100;
        if (Intrinsics.areEqual(this.f450684a, r101.f450684a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450685b, r101.f450685b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Mode r100 = this.f450684a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Mode r104 = this.f450685b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CardPreloadConfig(cardCreateMode=" + this.f450684a + ", cardBindMode=" + this.f450685b + ")";
    }

    public CardPreloadConfig() {
        Mode r100 = Mode.NO_PRELOAD;
        this(r100, r100);
    }

    public CardPreloadConfig(Mode r100, Mode r101) {
        Intrinsics.checkNotNullParameter(r100, "cardCreateMode");
        Intrinsics.checkNotNullParameter(r101, "cardBindMode");
        this.f450684a = r100;
        this.f450685b = r101;
    }
}

package com.larus.im.internal.core.conversation.bot;

import com.larus.im.bean.bot.BotModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f347563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Set<String>> f347564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<BotModel>> f347565c;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f347563a, r101.f347563a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347564b, r101.f347564b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347565c, r101.f347565c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f347563a.hashCode() * 31) + this.f347564b.hashCode()) * 31) + this.f347565c.hashCode();
    }

    public final String toString() {
        return "FetchInfo(needFetchConv=" + this.f347563a + ", needFetchBotMap=" + this.f347564b + ", availableBotMap=" + this.f347565c + ')';
    }

    public /* synthetic */ f(Set r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SetsKt.emptySet();
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = MapsKt.emptyMap();
    L9:
        if ((r102 & 4) == 0) goto L11;
        Map r103 = MapsKt.emptyMap();
    L12:
        this(r100, r101, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Set<String> r100, Map<String, ? extends Set<String>> r101, Map<String, ? extends List<BotModel>> r102) {
        Intrinsics.checkNotNullParameter(r100, "needFetchConv");
        Intrinsics.checkNotNullParameter(r101, "needFetchBotMap");
        Intrinsics.checkNotNullParameter(r102, "availableBotMap");
        this.f347563a = r100;
        this.f347564b = r101;
        this.f347565c = r102;
    }
}

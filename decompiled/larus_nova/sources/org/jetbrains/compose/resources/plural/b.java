package org.jetbrains.compose.resources.plural;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.AsyncCache;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f525867a = 0;

    public static final class a {
    }

    static {
        new AsyncCache();
        new b(new PluralRule[0]);
    }

    public b(PluralRule[] r100) {
        Intrinsics.checkNotNullParameter(r100, "rules");
    }
}

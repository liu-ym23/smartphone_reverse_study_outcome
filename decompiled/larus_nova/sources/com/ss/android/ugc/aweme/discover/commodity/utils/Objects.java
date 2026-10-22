package com.ss.android.ugc.aweme.discover.commodity.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/Objects;", "", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public class Objects {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f450380a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/Objects$Companion;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @JvmStatic
        public static boolean a(Object r100, Object r101) {
            if (Intrinsics.areEqual(r100, r101) == true) goto L9;
            if (r100 != null) goto L6;
        L8:
            return false;
        L6:
            if (r100.equals(r101) == false) goto L8;
        L9:
            return true;
        }
    }

    static {
        f450380a = new Companion(0);
    }

    @JvmStatic
    public static final boolean a(Object r100, Object r101) {
        f450380a.getClass();
        return Companion.a(r100, r101);
    }
}

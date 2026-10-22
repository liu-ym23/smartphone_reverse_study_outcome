package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public static boolean f;
    public static final a g = null;
    public boolean a;
    public int b;
    public Boolean c;
    public Boolean d;
    public Boolean e;

    public static final class a {
        public a() {
        }

        public static void a(Function1 r4) {
            Intrinsics.checkNotNullParameter(r4, "cb");
            if (p.f == true) goto L5;
            return;
        L5:
            KtvContext.Companion.getClass();
            LongSparseArray<p> r0 = KtvContext.a.g().getLyricStateRecordMap();
            int r1 = r0.size();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L8;
            r4.invoke(r0.valueAt(r2));
            r2 = r2 + 1;
            goto L6
        }
    }

    static {
        g = new a();
    }

    public final String toString() {
        return "LyricStateRecord(mId=0, emptyViewVisible=" + this.a + ", emptyViewState=" + this.b + ", singingDuration=null, singingStartTime=null, isLyricVisible=" + this.c + ", isLyricInfoPrepare=" + this.d + ", showState=null, haveUrl=" + this.e + ')';
    }
}

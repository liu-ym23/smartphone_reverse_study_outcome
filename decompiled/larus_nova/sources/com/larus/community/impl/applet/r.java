package com.larus.community.impl.applet;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f328898a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f328899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f328900b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f328899a, r101.f328899a) == true) goto L12;
            return false;
        L12:
            if (this.f328900b == r101.f328900b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f328899a.hashCode() * 31;
            long r101 = this.f328900b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PayloadEntry(payload=" + this.f328899a + ", createTimeMs=" + this.f328900b + ')';
        }

        public a(Bundle r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
            this.f328899a = r100;
            this.f328900b = r101;
        }
    }

    static {
        f328898a = new ConcurrentHashMap();
    }
}

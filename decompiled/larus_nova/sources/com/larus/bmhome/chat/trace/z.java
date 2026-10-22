package com.larus.bmhome.chat.trace;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z implements com.larus.bmhome.chat.api.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f310295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f310296b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f310297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f310298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f310299c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f310297a, r101.f310297a) == true) goto L12;
            return false;
        L12:
            if (this.f310298b == r101.f310298b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f310299c, r101.f310299c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f310297a.hashCode() * 31;
            long r101 = this.f310298b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            String r103 = this.f310299c;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "SendTraceParam(traceId=" + this.f310297a + ", startTime=" + this.f310298b + ", messageId=" + this.f310299c + ')';
        }

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "traceId");
            this.f310297a = r100;
            this.f310298b = r101;
            this.f310299c = null;
        }
    }

    public z() {
    }

    static {
        f310295a = new z();
        f310296b = new CopyOnWriteArraySet();
    }

    @Override // com.larus.bmhome.chat.api.s
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        a r101 = new a(r100, SystemClock.elapsedRealtime());
        CopyOnWriteArraySet<a> r102 = f310296b;
        if (r102.contains(r101) == false) goto L5;
        return;
    L5:
        r102.add(r101);
        FLogger.f375446a.d("ChatSendTrace", "send start: " + r101.f310298b + ", traceId: " + r100);
    }
}

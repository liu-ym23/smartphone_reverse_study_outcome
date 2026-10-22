package com.larus.dora.impl;

import com.bytedance.common.wschannel.WsConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Integer> f331972a;

    /* JADX INFO: renamed from: com.larus.dora.impl.a$a, reason: collision with other inner class name */
    public static final class C4208a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f331973c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f331974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f331975b;

        /* JADX INFO: renamed from: com.larus.dora.impl.a$b$a, reason: collision with other inner class name */
        public static final class C4209a {
            public static b a(byte[] r110) {
                Intrinsics.checkNotNullParameter(r110, WsConstants.KEY_PAYLOAD);
                if (r110.length >= 12) goto L5;
                return null;
            L5:
                if (r110[0] == 82) goto L7;
                return null;
            L7:
                if (((r110[2] & UByte.MAX_VALUE) | ((r110[3] & UByte.MAX_VALUE) << 8)) == r110.length) goto L10;
                return null;
            L10:
                return new b((r110[4] & UByte.MAX_VALUE) | ((r110[5] & UByte.MAX_VALUE) << 8), ((((((long) r110[9]) & 255) << 8) | (((long) r110[8]) & 255)) | ((((long) r110[10]) & 255) << 16)) | ((((long) r110[11]) & 255) << 24));
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f331974a == r101.f331974a) goto L12;
            return false;
        L12:
            if (this.f331975b == r101.f331975b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f331974a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f331975b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "EtpFrameHeader(requestId=" + this.f331974a + ", functionId=" + this.f331975b + ')';
        }

        public b(long r100, long r101) {
            this.f331974a = r100;
            this.f331975b = r101;
        }
    }

    static {
    }

    public a() {
        this.f331972a = new LinkedHashMap();
    }

    public final boolean a(long r100) {
        Map<Long, Integer> r101 = this.f331972a;
        monitor-enter(r101);
        boolean r102 = b(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean b(long r100) {
        Map<Long, Integer> r101 = this.f331972a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Integer r103 = (Integer) r102.get(Long.valueOf(r100));
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
        if (r104 != 1) goto L7;
        this.f331972a.remove(Long.valueOf(r100));
    L8:
        return true;
    L7:
        Long r105 = Long.valueOf(r100);
        this.f331972a.put(r105, Integer.valueOf(r104 - 1));
        goto L8
    L9:
        return false;
    }
}

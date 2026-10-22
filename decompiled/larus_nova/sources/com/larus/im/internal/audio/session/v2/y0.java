package com.larus.im.internal.audio.session.v2;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f347491a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f347492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xe9.e f347493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f347494c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f347492a == r101.f347492a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f347493b, r101.f347493b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f347494c, r101.f347494c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f347492a * 31) + this.f347493b.hashCode()) * 31;
            byte[] r101 = this.f347494c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = Arrays.hashCode(r101);
            goto L7
        }

        public final String toString() {
            return "QueueItem(type=" + this.f347492a + ", model=" + this.f347493b + ", data=" + Arrays.toString(this.f347494c) + ')';
        }

        public final int getType() {
            return this.f347492a;
        }

        public b(int r100, xe9.e r101, byte[] r102) {
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f347492a = r100;
            this.f347493b = r101;
            this.f347494c = r102;
        }
    }

    static {
    }

    public y0() {
        this.f347491a = new CopyOnWriteArrayList();
    }
}

package com.larus.dora.obric.device_management.device_home;

import android.os.Bundle;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f339259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f339260b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f339259a, r101.f339259a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f339260b, r101.f339260b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f339259a.hashCode() * 31;
            Bundle r101 = this.f339260b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Route(route=" + this.f339259a + ", arguments=" + this.f339260b + ')';
        }

        public a(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
            this.f339259a = r100;
            this.f339260b = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f339261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f339262b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f339261a, r101.f339261a) == true) goto L12;
            return false;
        L12:
            if (this.f339262b == r101.f339262b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f339261a.hashCode() * 31;
            long r101 = this.f339262b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "ShowEnvironmentMemoryAuthorization(deviceMac=" + this.f339261a + ", requestId=" + this.f339262b + ')';
        }

        public b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "deviceMac");
            this.f339261a = r100;
            this.f339262b = r101;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraObricEnvironmentMemoryToastType f339263a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f339263a == ((c) r100).f339263a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339263a.hashCode();
        }

        public final String toString() {
            return "ShowEnvironmentMemoryToast(type=" + this.f339263a + ')';
        }

        public final DoraObricEnvironmentMemoryToastType getType() {
            return this.f339263a;
        }

        public c(DoraObricEnvironmentMemoryToastType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f339263a = r100;
        }
    }

    public i() {
    }
}

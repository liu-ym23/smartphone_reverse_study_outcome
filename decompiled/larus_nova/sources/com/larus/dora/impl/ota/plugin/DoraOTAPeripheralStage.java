package com.larus.dora.impl.ota.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage;", "", "PeripheralDownloading", "PeripheralInstalling", "PeripheralRestarting", "PeripheralOTASuccess", "PeripheralOTAFailed", "PeripheralOther", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralDownloading;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralInstalling;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOTAFailed;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOTASuccess;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralOther;", "Lcom/larus/dora/impl/ota/plugin/DoraOTAPeripheralStage$PeripheralRestarting;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraOTAPeripheralStage {

    public static final class a implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337785a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f337785a == ((a) r100).f337785a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337785a;
        }

        public final String toString() {
            return "PeripheralDownloading(progress=" + this.f337785a + ')';
        }

        public a(int r100) {
            this.f337785a = r100;
        }
    }

    public static final class b implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337786a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f337786a == ((b) r100).f337786a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337786a;
        }

        public final String toString() {
            return "PeripheralInstalling(progress=" + this.f337786a + ')';
        }

        public b(int r100) {
            this.f337786a = r100;
        }
    }

    public static final class c implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.dora.impl.ota.c f337788b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f337787a == r101.f337787a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337788b, r101.f337788b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f337787a * 31) + this.f337788b.hashCode();
        }

        public final String toString() {
            return "PeripheralOTAFailed(errorCode=" + this.f337787a + ", otaIntent=" + this.f337788b + ')';
        }

        public c(int r100, com.larus.dora.impl.ota.c r101) {
            Intrinsics.checkNotNullParameter(r101, "otaIntent");
            this.f337787a = r100;
            this.f337788b = r101;
        }
    }

    public static final class d implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f337789a = null;

        static {
            f337789a = new d();
        }

        public d() {
        }
    }

    public static final class e implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337790a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f337790a == ((e) r100).f337790a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337790a;
        }

        public final String toString() {
            return "PeripheralOther(stage=" + this.f337790a + ')';
        }

        public e(int r100) {
            this.f337790a = r100;
        }
    }

    public static final class f implements DoraOTAPeripheralStage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337791a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f337791a == ((f) r100).f337791a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337791a;
        }

        public final String toString() {
            return "PeripheralRestarting(progress=" + this.f337791a + ')';
        }

        public f(int r100) {
            this.f337791a = r100;
        }
    }
}

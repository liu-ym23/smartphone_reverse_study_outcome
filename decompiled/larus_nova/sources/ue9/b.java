package ue9;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f549835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f549836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f549837c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f549835a, r101.f549835a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f549836b, r101.f549836b) == true) goto L15;
            return false;
        L15:
            if (this.f549837c == r101.f549837c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f549835a.hashCode() * 31;
            d0 r101 = this.f549836b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f549837c == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        @Override // ue9.b
        public final String toString() {
            return "Connected(desc=" + this.f549835a + ", connectedInfo=" + this.f549836b + ", isPseudo=" + this.f549837c + ')';
        }

        public a(String r100, d0 r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            this.f549835a = r100;
            this.f549836b = r101;
            this.f549837c = r102;
        }
    }

    /* JADX INFO: renamed from: ue9.b$b, reason: collision with other inner class name */
    public static final class C7871b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f549838a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7871b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f549838a, ((C7871b) r100).f549838a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f549838a.hashCode();
        }

        @Override // ue9.b
        public final String toString() {
            return "Connecting(desc=" + this.f549838a + ')';
        }

        public C7871b(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            this.f549838a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ue9.c f549839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f549840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f549841c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f549839a, r101.f549839a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f549840b, r101.f549840b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f549841c, r101.f549841c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f549839a.hashCode() * 31) + this.f549840b.hashCode()) * 31;
            Integer r101 = this.f549841c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // ue9.b
        public final String toString() {
            return "Disconnected(error=" + this.f549839a + ", detailErrorMsg=" + this.f549840b + ", subCode=" + this.f549841c + ')';
        }

        public c(ue9.c r100, String r101, Integer r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r101, "detailErrorMsg");
            this.f549839a = r100;
            this.f549840b = r101;
            this.f549841c = r102;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f549842a = null;

        static {
            f549842a = new d();
        }

        public d() {
        }
    }

    public b() {
    }

    public String toString() {
        return "FlowLinkSessionConnectionState";
    }
}

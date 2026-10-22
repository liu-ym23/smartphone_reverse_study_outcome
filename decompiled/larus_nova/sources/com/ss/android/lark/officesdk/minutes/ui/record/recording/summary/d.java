package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.view.View;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d implements k {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f436602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f436604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f436605d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f436602a, r101.f436602a) == true) goto L12;
            return false;
        L12:
            if (this.f436603b == r101.f436603b) goto L15;
            return false;
        L15:
            if (this.f436604c == r101.f436604c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f436605d, r101.f436605d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f436602a.hashCode() * 31;
            int r101 = 1231;
            if (this.f436603b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f436604c == true) goto L11;
            r101 = 1237;
        L11:
            return ((r103 + r101) * 31) + this.f436605d.hashCode();
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "BindFishBoneWebView(webView=" + this.f436602a + ", showThemeTransition=" + this.f436603b + ", retryOnAttachFailure=" + this.f436604c + ", source=" + this.f436605d + ')';
        }

        public a(View r100, boolean r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "webView");
            Intrinsics.checkNotNullParameter(r103, "source");
            this.f436602a = r100;
            this.f436603b = r101;
            this.f436604c = r102;
            this.f436605d = r103;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f436606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436607b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f436606a == r101.f436606a) goto L12;
            return false;
        L12:
            if (this.f436607b == r101.f436607b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f436606a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            if (this.f436607b == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "FishBoneWebScrollResult(requestId=" + this.f436606a + ", canScroll=" + this.f436607b + ')';
        }

        public b(long r100, boolean r101) {
            this.f436606a = r100;
            this.f436607b = r101;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436608a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436608a, ((c) r100).f436608a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436608a.hashCode();
        }

        public final String toString() {
            return "OpenWebPage(url=" + this.f436608a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f436608a = r100;
        }
    }

    public d() {
    }
}

package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class r implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436108a = null;

        static {
            f436108a = new a();
        }

        public a() {
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f436109a = null;

        static {
            f436109a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return -1236682910;
        }

        public final String toString() {
            return "DismissSaveSwitchTooltip";
        }

        public b() {
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436110a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436110a, ((c) r100).f436110a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436110a.hashCode();
        }

        public final String toString() {
            return "HideSheet(reason=" + this.f436110a + ')';
        }

        public c() {
            this("close");
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f436110a = r100;
        }
    }

    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l f436111a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436111a, ((d) r100).f436111a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436111a.hashCode();
        }

        public final String toString() {
            return "NavigateToSubtitle(request=" + this.f436111a + ')';
        }

        public d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            this.f436111a = r100;
        }
    }

    public static final class e extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f436112a = null;

        static {
            f436112a = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return -505831255;
        }

        public final String toString() {
            return "OpenCamera";
        }

        public e() {
        }
    }

    public static final class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmAINoteHint f436113a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f436113a == ((f) r100).f436113a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436113a.hashCode();
        }

        public final String toString() {
            return "ShowHint(hint=" + this.f436113a + ')';
        }

        public f(MmAINoteHint r100) {
            Intrinsics.checkNotNullParameter(r100, "hint");
            this.f436113a = r100;
        }
    }

    public static final class g extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f436114a = null;

        static {
            f436114a = new g();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            g r101 = (g) r100;
            return true;
        }

        public final int hashCode() {
            return 374054747;
        }

        public final String toString() {
            return "ShowSaveSwitchTooltip";
        }

        public g() {
        }
    }

    public static final class h extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436115a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f436115a == ((h) r100).f436115a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436115a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ShowSheet(expandImmediately=" + this.f436115a + ')';
        }

        public h(boolean r100) {
            this.f436115a = r100;
        }
    }

    public r() {
    }
}

package com.obric.assistant.cocreationreview;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387680a;

    public static final class a extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReviewMode f387681b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f387681b == ((a) r100).f387681b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f387681b.hashCode();
        }

        public final String toString() {
            return "EmptyState(reviewMode=" + this.f387681b + ')';
        }

        public a(ReviewMode r100) {
            Intrinsics.checkNotNullParameter(r100, "reviewMode");
            super("empty-state");
            this.f387681b = r100;
        }
    }

    public static final class b extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MainView f387682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f387683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f387684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f387685e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f387682b == r101.f387682b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387683c, r101.f387683c) == true) goto L15;
            return false;
        L15:
            if (this.f387684d == r101.f387684d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f387685e, r101.f387685e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f387682b.hashCode() * 31) + this.f387683c.hashCode()) * 31;
            if (this.f387684d == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f387685e;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Header(mainView=" + this.f387682b + ", dateLabel=" + this.f387683c + ", settlementCompletedToday=" + this.f387684d + ", settlementTimeLabel=" + this.f387685e + ')';
        }

        public b(MainView r100, String r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "mainView");
            Intrinsics.checkNotNullParameter(r101, "dateLabel");
            super("header");
            this.f387682b = r100;
            this.f387683c = r101;
            this.f387684d = r102;
            this.f387685e = r103;
        }
    }

    public static final class c extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<p5> f387686b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f387686b, ((c) r100).f387686b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f387686b.hashCode();
        }

        public final String toString() {
            return "ModuleTabs(tabs=" + this.f387686b + ')';
        }

        public c(List<p5> r100) {
            Intrinsics.checkNotNullParameter(r100, "tabs");
            super("module-tabs");
            this.f387686b = r100;
        }
    }

    public static final class d extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f387687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<o5> f387688c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f387687b == r101.f387687b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387688c, r101.f387688c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f387687b * 31) + this.f387688c.hashCode();
        }

        public final String toString() {
            return "OverviewRow(rowIndex=" + this.f387687b + ", modules=" + this.f387688c + ')';
        }

        public d(int r100, List<o5> r101) {
            Intrinsics.checkNotNullParameter(r101, IPerformanceManager.Params.modules);
            super("overview-row-" + r100);
            this.f387687b = r100;
            this.f387688c = r101;
        }
    }

    public static final class e extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReviewMode f387689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final u5 f387690c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f387689b == r101.f387689b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387690c, r101.f387690c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f387689b.hashCode() * 31) + this.f387690c.hashCode();
        }

        public final String toString() {
            return "SummaryHero(reviewMode=" + this.f387689b + ", stats=" + this.f387690c + ')';
        }

        public e(ReviewMode r100, u5 r101) {
            Intrinsics.checkNotNullParameter(r100, "reviewMode");
            Intrinsics.checkNotNullParameter(r101, "stats");
            super("summary-hero");
            this.f387689b = r100;
            this.f387690c = r101;
        }
    }

    public static final class f extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e4 f387691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f387692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f387693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f387694e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f387691b, r101.f387691b) == true) goto L12;
            return false;
        L12:
            if (this.f387692c == r101.f387692c) goto L15;
            return false;
        L15:
            if (this.f387693d == r101.f387693d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f387694e, r101.f387694e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f387691b.hashCode() * 31;
            int r101 = 1231;
            if (this.f387692c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f387693d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            String r105 = this.f387694e;
            if (r105 != null) goto L13;
            int r106 = 0;
        L15:
            return r104 + r106;
        L13:
            r106 = r105.hashCode();
            goto L15
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "TaskCard(task=" + this.f387691b + ", expanded=" + this.f387692c + ", hasRun=" + this.f387693d + ", launchingTaskId=" + this.f387694e + ')';
        }

        public f(e4 r100, boolean r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "task");
            super("task-card-" + r100.f387269a);
            this.f387691b = r100;
            this.f387692c = r101;
            this.f387693d = r102;
            this.f387694e = r103;
        }
    }

    public static final class g extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CocreationTaskFilter f387695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f387696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f387697d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f387695b == r101.f387695b) goto L12;
            return false;
        L12:
            if (this.f387696c == r101.f387696c) goto L15;
            return false;
        L15:
            if (this.f387697d == r101.f387697d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f387695b.hashCode() * 31;
            int r101 = 1231;
            if (this.f387696c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f387697d == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "TaskEmpty(filter=" + this.f387695b + ", loading=" + this.f387696c + ", loadFailed=" + this.f387697d + ')';
        }

        public g(CocreationTaskFilter r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "filter");
            super("task-empty");
            this.f387695b = r100;
            this.f387696c = r101;
            this.f387697d = r102;
        }
    }

    public static final class h extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f387698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f387699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CocreationTaskFilter f387700d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f387698b == r101.f387698b) goto L12;
            return false;
        L12:
            if (this.f387699c == r101.f387699c) goto L15;
            return false;
        L15:
            if (this.f387700d == r101.f387700d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f387698b * 31) + this.f387699c) * 31) + this.f387700d.hashCode();
        }

        public final String toString() {
            return "TaskSummary(total=" + this.f387698b + ", run=" + this.f387699c + ", filter=" + this.f387700d + ')';
        }

        public h(int r100, int r101, CocreationTaskFilter r102) {
            Intrinsics.checkNotNullParameter(r102, "filter");
            super("task-summary");
            this.f387698b = r100;
            this.f387699c = r101;
            this.f387700d = r102;
        }
    }

    public static final class i extends q5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.assistant.cocreationreview.a f387701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a5 f387702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f387703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<b5> f387704e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f387701b, r101.f387701b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387702c, r101.f387702c) == true) goto L15;
            return false;
        L15:
            if (this.f387703d == r101.f387703d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f387704e, r101.f387704e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f387701b.hashCode() * 31) + this.f387702c.hashCode()) * 31;
            if (this.f387703d == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f387704e.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "UsageCard(record=" + this.f387701b + ", feedback=" + this.f387702c + ", readOnly=" + this.f387703d + ", feedbackMedia=" + this.f387704e + ')';
        }

        public i(com.obric.assistant.cocreationreview.a r100, a5 r101, boolean r102, List<b5> r103) {
            Intrinsics.checkNotNullParameter(r100, "record");
            Intrinsics.checkNotNullParameter(r101, "feedback");
            Intrinsics.checkNotNullParameter(r103, "feedbackMedia");
            super("usage-card-" + r100.a());
            this.f387701b = r100;
            this.f387702c = r101;
            this.f387703d = r102;
            this.f387704e = r103;
        }
    }

    public q5(String r100) {
        this.f387680a = r100;
    }
}

package eb9;

import com.larus.home.api.feed.FlowFeedActionScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowFeedActionScene f471854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f471855b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f471854a == r101.f471854a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471855b, r101.f471855b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f471854a.hashCode() * 31) + this.f471855b.hashCode();
        }

        public final String toString() {
            return "SelectionChanged(scene=" + this.f471854a + ", optionId=" + this.f471855b + ')';
        }

        public a(FlowFeedActionScene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "optionId");
            this.f471854a = r100;
            this.f471855b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowFeedActionScene f471856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f471857b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f471856a == r101.f471856a) goto L12;
            return false;
        L12:
            if (this.f471857b == r101.f471857b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f471856a.hashCode() * 31;
            if (this.f471857b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ToggleChanged(scene=" + this.f471856a + ", checked=" + this.f471857b + ')';
        }

        public b(FlowFeedActionScene r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f471856a = r100;
            this.f471857b = r101;
        }
    }

    /* JADX INFO: renamed from: eb9.c$c, reason: collision with other inner class name */
    public static final class C5762c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowFeedActionScene f471858a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5762c) == true) goto L9;
            return false;
        L9:
            if (this.f471858a == ((C5762c) r100).f471858a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f471858a.hashCode();
        }

        public final String toString() {
            return "Trigger(scene=" + this.f471858a + ')';
        }

        public C5762c(FlowFeedActionScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f471858a = r100;
        }
    }

    public c() {
    }
}

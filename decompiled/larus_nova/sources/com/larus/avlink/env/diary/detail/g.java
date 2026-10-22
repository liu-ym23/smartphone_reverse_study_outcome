package com.larus.avlink.env.diary.detail;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Block f292010a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f292010a, ((a) r100).f292010a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f292010a.hashCode();
        }

        public final String toString() {
            return "BlockContent(block=" + this.f292010a + ')';
        }

        public a(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            this.f292010a = r100;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f292012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f292013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f292014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f292015e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f292011a, r101.f292011a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292012b, r101.f292012b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f292013c, r101.f292013c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f292014d, r101.f292014d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f292015e, r101.f292015e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f292011a.hashCode() * 31) + this.f292012b.hashCode()) * 31) + this.f292013c.hashCode()) * 31;
            String r101 = this.f292014d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f292015e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "DateHeader(day=" + this.f292011a + ", yearMonth=" + this.f292012b + ", weekday=" + this.f292013c + ", emotionIconUrl=" + this.f292014d + ", emotionText=" + this.f292015e + ')';
        }

        public b(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
            Intrinsics.checkNotNullParameter(r101, "yearMonth");
            Intrinsics.checkNotNullParameter(r102, "weekday");
            this.f292011a = r100;
            this.f292012b = r101;
            this.f292013c = r102;
            this.f292014d = r103;
            this.f292015e = r104;
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j98.c f292017b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f292016a, r101.f292016a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292017b, r101.f292017b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f292016a.hashCode() * 31) + this.f292017b.hashCode();
        }

        public final String toString() {
            return "FeedbackEntry(diaryId=" + this.f292016a + ", uiModel=" + this.f292017b + ')';
        }

        public c(String r100, j98.c r101) {
            Intrinsics.checkNotNullParameter(r100, "diaryId");
            Intrinsics.checkNotNullParameter(r101, "uiModel");
            this.f292016a = r100;
            this.f292017b = r101;
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f292018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f292019b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f292018a == r101.f292018a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292019b, r101.f292019b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f292018a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f292019b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "RecordStatus(isRecording=" + this.f292018a + ", nextUpdateTime=" + this.f292019b + ')';
        }

        public d(boolean r100, String r101) {
            this.f292018a = r100;
            this.f292019b = r101;
        }
    }

    public static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292020a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f292020a, ((e) r100).f292020a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f292020a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Title(title=" + this.f292020a + ')';
        }

        public e(String r100) {
            this.f292020a = r100;
        }
    }

    public g() {
    }
}

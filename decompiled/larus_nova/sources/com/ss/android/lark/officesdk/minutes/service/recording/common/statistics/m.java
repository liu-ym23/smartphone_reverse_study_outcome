package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435464a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f435466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f435467c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f435465a, r101.f435465a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f435466b, r101.f435466b) == true) goto L15;
            return false;
        L15:
            if (this.f435467c == r101.f435467c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f435465a.hashCode() * 31) + this.f435466b.hashCode()) * 31) + this.f435467c;
        }

        public final String toString() {
            return "TranslatedSubtitleInfo(originalLanguage=" + this.f435465a + ", translationLanguage=" + this.f435466b + ", paragraphCnt=" + this.f435467c + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "originalLanguage");
            Intrinsics.checkNotNullParameter(r101, "translationLanguage");
            this.f435465a = r100;
            this.f435466b = r101;
            this.f435467c = 1;
        }
    }

    static {
    }

    public m(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435464a = r100;
    }

    public final void a(String r100, String r101, String r102) {
        MmRecordingCommonParam r103 = this.f435464a.b(r100);
        if (r103 != null) goto L6;
        lvb.a.h("MmRecordingSubtitleTracker", "[trackTranslationOpenStatus] skip: commonParam missing, sessionId=".concat(r100));
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r104 = r103.asTrackerParams();
        r104.e("translation_language", r101);
        r104.e("open_translation_entry", r102);
        JSONObject r105 = r104.a();
        this.f435464a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("vc_subtitle_translation_open_status", r105);
    }
}

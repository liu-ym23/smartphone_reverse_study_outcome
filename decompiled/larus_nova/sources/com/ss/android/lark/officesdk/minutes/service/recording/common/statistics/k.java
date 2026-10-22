package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmFeatureDetail;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRenderType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaScene;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435450a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435451a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f435452b = null;

        static {
            int[] r100 = new int[MmRecordingQuotaCtaRenderType.values().length];
            r100[MmRecordingQuotaCtaRenderType.WindowLimited7D.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MmRecordingQuotaCtaRenderType.WindowLimited5H.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[MmRecordingQuotaCtaRenderType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f435451a = r100;
            int[] r101 = new int[MmRecordingQuotaCtaScene.values().length];
            r101[MmRecordingQuotaCtaScene.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[MmRecordingQuotaCtaScene.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f435452b = r101;
        }
    }

    public k(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435450a = r100;
    }

    public static JSONObject a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r110) {
        boolean r100 = r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c;
        MmQuotaData r101 = null;
        if (r100 == false) goto L6;
        MmQuotaType r102 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r110).f434923a;
    L16:
        if (r102 != null) goto L18;
        return null;
    L18:
        if (r100 == false) goto L21;
        r101 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r110).f434924b;
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r103 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        if (r101 == null) goto L33;
        MmFeatureDetail r104 = r101.getFeatureDetail(r102);
        if (r104 == null) goto L33;
        Map<String, String> r105 = r104.getDataTracking();
        if (r105 == null) goto L33;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L31:
        if (r106.hasNext() == false) goto L33;
        Map.Entry<String, String> r107 = r106.next();
        r103.e(r107.getKey(), r107.getValue());
    L33:
        JSONObject r108 = r103.a();
        boolean r109 = false;
        if (r108.optString("function_type").length() != 0) goto L36;
        boolean r111 = true;
    L37:
        if (r111 == false) goto L39;
        r108.put("function_type", "none");
    L39:
        String r112 = "minutes_recording_notes_page";
        String r113 = "";
        if (r100 == false) goto L49;
        int r114 = a.f435452b[((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r110).f434925c.ordinal()];
        if (r114 == 1) goto L47;
        if (r114 != 2) goto L46;
    L64:
        r108.put("function_scene", r112);
        if (r101 == null) goto L67;
        r109 = r101.isAdmin(r102);
    L67:
        r108.put("admin_flag", r109);
        if (r100 == false) goto L71;
        MmRecordingQuotaCtaRenderType r115 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r110).f434926d;
    L81:
        int r116 = a.f435451a[r115.ordinal()];
        if (r116 == 1) goto L90;
        if (r116 != 2) goto L85;
        r113 = "5h";
    L91:
        r108.put("limit_type", r113);
        return r108;
    L85:
        if (r116 == 3) goto L91;
        throw new NoWhenBranchMatchedException();
    L90:
        r113 = "7d";
        goto L91
    L71:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L74;
        r115 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r110).f434930d;
        goto L81
    L74:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.f434921a) == false) goto L76;
    L80:
        r115 = MmRecordingQuotaCtaRenderType.Default;
        goto L81
    L76:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.f434922a) == true) goto L80;
        throw new NoWhenBranchMatchedException();
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        r112 = "minutes_recording_transcript_page";
        goto L64
    L49:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L57;
        int r117 = a.f435452b[((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r110).f434929c.ordinal()];
        if (r117 == 1) goto L47;
        if (r117 == 2) goto L64;
        throw new NoWhenBranchMatchedException();
    L57:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.f434921a) == false) goto L59;
    L63:
        r112 = "";
        goto L64
    L59:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.f434922a) == true) goto L63;
        throw new NoWhenBranchMatchedException();
    L36:
        r111 = false;
        goto L37
    L21:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L23;
        r101 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r110).f434928b;
        goto L23
    L6:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L9;
        r102 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r110).f434927a;
        goto L16
    L9:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.f434921a) == false) goto L11;
    L15:
        r102 = null;
        goto L16
    L11:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.f434922a) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }
}

package com.ss.android.lark.officesdk.minutes.service.foundation.feature;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdb.g;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f433792f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f433793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<lub.a> f433794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f433795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<MmRecordingSource> f433796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f433797e;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.feature.a$a, reason: collision with other inner class name */
    public static final class C5159a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433798a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f433799b = null;

        static {
            int[] r100 = new int[MmRecordingSource.values().length];
            r100[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L53:
            r100[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L61:
            r100[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L39:
            r100[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L41:
            r100[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L49:
            r100[MmRecordingSource.FEISHU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L59:
            r100[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L43:
            r100[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L55:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L57:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L35:
            r100[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L51:
            r100[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L16:
            f433798a = r100;
            int[] r101 = new int[MmOfficeSdkFeature.values().length];
            r101[MmOfficeSdkFeature.RecordingNoAiNotes.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L47:
            r101[MmOfficeSdkFeature.RecordAiLayout.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L19:
            f433799b = r101;
        }
    }

    static {
    }

    public a() {
        throw null;
    }

    public static boolean b(MmOfficeSdkFeature r100) {
        int r101 = b.f433799b[r100.ordinal()];
        if (r101 != 1) goto L5;
    L6:
        return false;
    L5:
        if (r101 != 2) goto L6;
        return true;
    }

    public final boolean c(MmOfficeSdkFeature r100) {
        if (this.f433795c.invoke().booleanValue() == false) goto L5;
        Boolean r101 = r100.getLarkFgFixedValue();
    L6:
        if (r101 == null) goto L10;
        boolean r102 = r101.booleanValue();
        lvb.a.a("MmOfficeSdkFeatureService", "[getFeatureGatingValue] fixed value, feature=" + r100.name() + ", value=" + r102);
        return r102;
    L10:
        return f(r100);
    L5:
        r101 = r100.getDoubaoFgFixedValue();
        goto L6
    }

    public final boolean d(MmOfficeSdkFeature r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        lub.a r102 = this.f433794b.invoke();     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        lvb.a.h("MmOfficeSdkFeatureService", "[getHostSettingValue] host setting service missing, feature=" + r100.name());     // Catch: Throwable -> L9
        boolean r103 = false;
    L7:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L14;
        lvb.a.b("MmOfficeSdkFeatureService", "[getHostSettingValue] failed, feature=" + r100.name() + ", error=" + r105);
    L14:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L18;
        r104 = r106;
    L18:
        return ((Boolean) r104).booleanValue();
    L6:
        boolean r107 = r102.G(r100);     // Catch: Throwable -> L9
        lvb.a.a("MmOfficeSdkFeatureService", "[getHostSettingValue] success, feature=" + r100.name() + ", value=" + r107);     // Catch: Throwable -> L9
        r103 = r107;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean e(MmOfficeSdkFeature r100) {
        if ((!StringsKt.isBlank(r100.getAbSettingKey())) == false) goto L6;
        lvb.a.a("MmOfficeSdkFeatureService", "[getNonFeiShuValue] use host setting first, feature=" + r100.name() + ", hostSettingKey=" + r100.getAbSettingKey());
        return d(r100);
    L6:
        lvb.a.a("MmOfficeSdkFeatureService", "[getNonFeiShuValue] empty setting config, fallback to fg, feature=" + r100.name());
        return c(r100);
    }

    public final boolean f(MmOfficeSdkFeature r100) {
        if (StringsKt.isBlank(r100.getFgKey()) == false) goto L21;
        lvb.a.h("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] empty fgKey, feature=" + r100.name());
        return false;
    L21:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(this.f433793a.isCurrentEnable(r100.getFgKey())));     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L13;
        lvb.a.a("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] fg result, feature=" + r100.name() + ", value=" + ((Boolean) r102).booleanValue());
    L13:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        lvb.a.b("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] fg failed, feature=" + r100.name() + ", error=" + r103);
    L16:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L20;
        r102 = r104;
    L20:
        return ((Boolean) r102).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean h(MmOfficeSdkFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        boolean r102 = this.f433795c.invoke().booleanValue();     // Catch: Throwable -> L20
        MmRecordingSource r103 = this.f433796d.invoke();     // Catch: Throwable -> L20
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] route, feature=" + r100.name() + ", isFeiShu=" + r102 + ", hostSettingKey=" + r100.getAbSettingKey() + ", recordingSource=" + r103);     // Catch: Throwable -> L20
        if (r100 != MmOfficeSdkFeature.RecordingNoAiNotes) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        boolean r105 = g(r100, r103, r102);     // Catch: Throwable -> L20
    L18:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L20
    L22:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L25;
        lvb.a.b("MmOfficeSdkFeatureService", "[isFeatureEnable] route failed, feature=" + r100.name() + ", error=" + r107);
    L25:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L28;
        r106 = r108;
    L28:
        boolean r109 = ((Boolean) r106).booleanValue();
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] result, feature=" + r100.name() + ", enabled=" + r109);
        return r109;
    L12:
        if (r102 == false) goto L15;
        r105 = c(r100);     // Catch: Throwable -> L20
        goto L18
    L15:
        if (r103 != MmRecordingSource.OBRIC_RECORDER) goto L17;
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] recorder source uses host setting, feature=" + r100.name());     // Catch: Throwable -> L20
        r105 = d(r100);     // Catch: Throwable -> L20
        goto L18
    L17:
        r105 = e(r100);     // Catch: Throwable -> L20
        goto L18
    L6:
        if (r100 == MmOfficeSdkFeature.RecordAiLayout) goto L9;
        r104 = false;
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final Map<String, Boolean> a(List<String> r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "featureKeys");
        lvb.a.a("MmOfficeSdkFeatureService", "[getBooleanValues] start, size=" + r100.size());
        List<String> r101 = r100;
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        String r105 = (String) r104;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(this.f433793a.isCurrentEnable(r105)));     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L13;
        lvb.a.b("MmOfficeSdkFeatureService", "[getBooleanValues] fg failed, key=" + r105 + ", error=" + r108);
    L13:
        Boolean r109 = Boolean.valueOf(r110);
        if (Result.m9455isFailureimpl(r107) == false) goto L16;
        r107 = r109;
    L16:
        r102.put(r104, Boolean.valueOf(((Boolean) r107).booleanValue()));
    L8:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        return r102;
    }

    public a(g r100, Function0 r101, Function0 r102) {
        MmOfficeSdkFeatureService$2 r103 = MmOfficeSdkFeatureService$2.INSTANCE;
        MmOfficeSdkFeatureService$4 r104 = MmOfficeSdkFeatureService$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "featureGatingService");
        Intrinsics.checkNotNullParameter(r101, "featureSettingServiceProvider");
        Intrinsics.checkNotNullParameter(r103, "isLarkAppProvider");
        Intrinsics.checkNotNullParameter(r102, "recordingSourceProvider");
        Intrinsics.checkNotNullParameter(r104, "isDoubaoBUserProvider");
        this.f433793a = r100;
        this.f433794b = r101;
        this.f433795c = r103;
        this.f433796d = r102;
        this.f433797e = r104;
    }

    public final boolean g(MmOfficeSdkFeature r100, MmRecordingSource r101, boolean r102) {
        if (r101 != null) goto L4;
        int r103 = -1;
    L5:
        switch(r103) {
            case -1: goto L24;
            case 0: goto L7;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L8;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        return false;
    L24:
        if (r102 == false) goto L27;
        return f(r100);
    L27:
        return b(r100);
    L28:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(this.f433797e.invoke().booleanValue()));     // Catch: Throwable -> L13
    L15:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L19;
        r105 = r106;
    L19:
        if (((Boolean) r105).booleanValue() == false) goto L34;
        return f(r100);
    L34:
        return b(r100);
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L7:
        throw new NoWhenBranchMatchedException();
    L31:
        return f(r100);
    L32:
        return d(r100);
    L35:
        return f(r100);
    L36:
        return b(r100);
    L4:
        r103 = b.f433798a[r101.ordinal()];
        goto L5
    }
}

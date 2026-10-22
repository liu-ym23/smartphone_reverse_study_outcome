package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.minutes.v1.MinutesGetI18nTemplatesRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesGetI18nTemplatesResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class RustMmAIInterpretationGateway implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434740b;

    public RustMmAIInterpretationGateway(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f434739a = r100;
        this.f434740b = "RustMmAIInterpretationGateway";
    }

    public final Object d(List<String> r100, Continuation<? super Result<? extends Map<String, String>>> r101) {
        if ((r101 instanceof RustMmAIInterpretationGateway$getI18nTemplates$1) == false) goto L7;
        RustMmAIInterpretationGateway$getI18nTemplates$1 r102 = (RustMmAIInterpretationGateway$getI18nTemplates$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L17:
        boolean r108 = Result.m9456isSuccessimpl(r107);
        Object r109 = r107;
        if (r108 == false) goto L24;
        Map<String, String> r110 = ((MinutesGetI18nTemplatesResponse) r107).templates;
        Map<String, String> r111 = r110;
        if (r110 != null) goto L22;
        r111 = MapsKt.emptyMap();
    L22:
        lvb.a.e(this.f434740b, "[getI18nTemplates] success, templateSize=" + r111.size());
        r109 = r111;
    L24:
        return Result.m9449constructorimpl(r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        lvb.a.e(this.f434740b, "[getI18nTemplates] request, keySize=" + r100.size());
        MinutesGetI18nTemplatesRequest r112 = new MinutesGetI18nTemplatesRequest.Builder().keys(r100).build();
        MmMockAwareRequestService r113 = this.f434739a.M();
        Command r114 = Command.MINUTES_GET_I18N_TEMPLATES;
        Intrinsics.checkNotNull(r112);
        r102.label = 1;
        Object r115 = r113.b(r114, MinutesGetI18nTemplatesResponse.class, r112, r102);
        r107 = r115;
        if (r115 != r105) goto L17;
        return r105;
    L7:
        r102 = new RustMmAIInterpretationGateway$getI18nTemplates$1(this, r101);
        goto L8
    }

    public static final Object c(RustMmAIInterpretationGateway r110, List r111, Continuation r112) {
        List r100 = r111;
        r110.getClass();
        if ((r112 instanceof RustMmAIInterpretationGateway$localizeLanguages$1) == false) goto L7;
        RustMmAIInterpretationGateway$localizeLanguages$1 r101 = (RustMmAIInterpretationGateway$localizeLanguages$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L30:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L34;
        lvb.a.h(r110.f434740b, "[localizeLanguages] get i18n templates failed, fallback to raw descriptions, error=" + r107.getMessage());
        r106 = MapsKt.emptyMap();
    L34:
        Map r108 = (Map) r106;
        if (r108.isEmpty() == false) goto L37;
        lvb.a.e(r110.f434740b, "[localizeLanguages] empty templates, fallback to raw descriptions");
        return r100;
    L37:
        List r109 = r100;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r114 = r109.iterator();
    L39:
        if (r114.hasNext() == false) goto L47;
        g r115 = (g) r114.next();
        String r116 = (String) r108.get(r115.f434766b);
        if (r116 != null) goto L44;
        r116 = "";
    L44:
        if ((!StringsKt.isBlank(r116)) == false) goto L46;
        String r117 = r115.f434765a;
        String r118 = r115.f434767c;
        Intrinsics.checkNotNullParameter(r117, "languageType");
        Intrinsics.checkNotNullParameter(r116, "description");
        Intrinsics.checkNotNullParameter(r118, "icon");
        r115 = new g(r117, r116, r118);
    L46:
        r113.add(r115);
        goto L39
    L47:
        lvb.a.e(r110.f434740b, "[localizeLanguages] localized=" + CollectionsKt.joinToString$default(r113, null, "[", "]", 0, null, RustMmAIInterpretationGateway$localizeLanguages$3$1.INSTANCE, 25, null));
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List r119 = r100;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L16:
        if (r121.hasNext() == false) goto L18;
        r120.add(((g) r121.next()).f434766b);
        goto L16
    L18:
        ArrayList r122 = new ArrayList();
        Iterator r123 = r120.iterator();
    L20:
        if (r123.hasNext() == false) goto L24;
        Object r124 = r123.next();
        if ((!StringsKt.isBlank((String) r124)) == false) goto L20;
        r122.add(r124);
        goto L20
    L24:
        List<String> r125 = CollectionsKt.distinct(r122);
        if (r125.isEmpty() == false) goto L27;
        lvb.a.e(r110.f434740b, "[localizeLanguages] skip, empty keys");
        return r100;
    L27:
        r101.L$0 = r100;
        r101.label = 1;
        r106 = r110.d(r125, r101);
        if (r106 != r104) goto L30;
        return r104;
    L7:
        r101 = new RustMmAIInterpretationGateway$localizeLanguages$1(r110, r112);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.f
    public final Object b(String r100, String r101, Continuation<? super Result<? extends List<g>>> r102) {
        if ((r102 instanceof RustMmAIInterpretationGateway$getSetting$1) == false) goto L7;
        RustMmAIInterpretationGateway$getSetting$1 r103 = (RustMmAIInterpretationGateway$getSetting$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        RustMmAIInterpretationGateway$getSetting$2 r108 = new RustMmAIInterpretationGateway$getSetting$2(this, r100, r101, null);
        r103.label = 1;
        Object r109 = MmCustomExceptionKt.a(3, r108, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new RustMmAIInterpretationGateway$getSetting$1(this, r102);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.f
    public final Object a(String r110, String r111, boolean r112, g r113, Continuation<? super Result<p>> r114) {
        if ((r114 instanceof RustMmAIInterpretationGateway$updateSetting$1) == false) goto L7;
        RustMmAIInterpretationGateway$updateSetting$1 r100 = (RustMmAIInterpretationGateway$updateSetting$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        RustMmAIInterpretationGateway$updateSetting$2 r104 = new RustMmAIInterpretationGateway$updateSetting$2(this, r110, r111, r112, r113, null);
        r100.label = 1;
        Object r105 = MmCustomExceptionKt.a(3, r104, r100);
        if (r105 != r115) goto L18;
        return r115;
    L18:
        return r105;
    L7:
        r100 = new RustMmAIInterpretationGateway$updateSetting$1(this, r114);
        goto L8
    }
}

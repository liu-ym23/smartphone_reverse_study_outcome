package com.larus.bmhome.utils;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a3 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f314968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f314969b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314970a = null;

        static {
            int[] r100 = new int[ExternalRedirectPromptFrequencyConfig.values().length];
            r100[ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ExternalRedirectPromptFrequencyConfig.EACH_DOMAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ExternalRedirectPromptFrequencyConfig.NEVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f314970a = r100;
        }
    }

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put("click_type", 1);
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("external_domain_jumper", r101);
        ExternalRedirectPromptFrequencyConfig r103 = z2.a();
        int r104 = a.f314970a[r103.ordinal()];
        if (r104 != 1) goto L5;
        z2.f315159b.storeBoolean("safety_domain_confirm_permission", true);
    L13:
        this.f314969b.invoke();
        return;
    L5:
        if (r104 != 2) goto L7;
        String r105 = this.f314968a;
        z2.f315158a.storeBoolean(r105, true);
        goto L13
    L7:
        if (r104 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public a3(String r100, Function0<Unit> r101) {
        this.f314968a = r100;
        this.f314969b = r101;
    }
}

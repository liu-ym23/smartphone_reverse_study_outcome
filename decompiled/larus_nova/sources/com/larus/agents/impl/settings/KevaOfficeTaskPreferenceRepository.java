package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.platform.service.AccountService;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class KevaOfficeTaskPreferenceRepository implements e {

    public static final class a {
    }

    static {
    }

    public KevaOfficeTaskPreferenceRepository() {
    }

    public static final Keva c(KevaOfficeTaskPreferenceRepository r100) {
        r100.getClass();
        int r101 = c.f286714a;
        String r102 = AccountService.f365697a.getSecUserId();
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        r102 = "guest";
    L9:
        return Keva.getRepo(r102.concat("_office_task_preference"), 0);
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object a(Continuation<? super b> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaOfficeTaskPreferenceRepository$get$2(this, null), r100);
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object b(String r100, Continuation<? super OfficeTaskPreferenceSaveResult> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaOfficeTaskPreferenceRepository$save$2(r100, this, null), r101);
    }
}

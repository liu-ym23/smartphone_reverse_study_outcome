package com.ss.android.lark.passport.assemble;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.utils.ApiUtils;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class b implements izb.a {
    @Inject
    public b() {
    }

    @Override // izb.a
    public final Pair<EnvironmentType, String> a() {
        int r100 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
        if (r100 != 1) goto L5;
        EnvironmentType r101 = EnvironmentType.RELEASE;
    L13:
        return new Pair(r101, ((gpb.a) ApiUtils.getApi(gpb.a.class)).getUserUnit());
    L5:
        if (r100 != 2) goto L7;
        r101 = EnvironmentType.STAGING;
        goto L13
    L7:
        if (r100 == 3) goto L9;
        r101 = EnvironmentType.RELEASE;
        goto L13
    L9:
        r101 = EnvironmentType.PRE_RELEASE;
        goto L13
    }

    @Override // izb.a
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        izb.a.f496737a.getClass();
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        switch(r100.hashCode()) {
            case 93912099: goto L26;
            case 93912675: goto L22;
            case 96855691: goto L18;
            case 96855972: goto L14;
            case 878174793: goto L10;
            case 886218363: goto L6;
            default: goto L29;
        };
    L29:
        String r101 = null;
    L30:
        if (r101 != null) goto L33;
        return r100;
    L33:
        return r101;
    L6:
        if (r100.equals("larksgaws") == false) goto L29;
        r101 = EnvConst$GEO.SG;
        goto L30
    L10:
        if (r100.equals("larkjpaws") == false) goto L29;
        r101 = EnvConst$GEO.JP;
        goto L30
    L14:
        if (r100.equals("eu_nc") == false) goto L29;
        r101 = "cn";
        goto L30
    L18:
        if (r100.equals("eu_ea") == false) goto L29;
        r101 = EnvConst$GEO.US;
        goto L30
    L22:
        if (r100.equals(EnvConst$UNIT.BOE_VA) == false) goto L29;
        r101 = EnvConst$GEO.BOE_US;
        goto L30
    L26:
        if (r100.equals(EnvConst$UNIT.BOE_CN) == false) goto L29;
        r101 = EnvConst$GEO.BOE_CN;
        goto L30
    }
}

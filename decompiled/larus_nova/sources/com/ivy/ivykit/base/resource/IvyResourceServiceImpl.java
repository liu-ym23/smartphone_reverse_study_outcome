package com.ivy.ivykit.base.resource;

import com.bytedance.geckox.b;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.ivy.ivykit.api.plugin.IvyResourceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ivy/ivykit/base/resource/IvyResourceServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IvyResourceService;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ivy_base_release"}, k = 1, mv = {1, 7, 1})
public final class IvyResourceServiceImpl implements IvyResourceService {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public final void b() {
        b r100 = b.a.f245076a;
        GlobalConfigSettings r101 = GlobalSettingsManager.f250833a;
        ReqType r102 = ReqType.NORMAL;
        GlobalSettingsManager.f250840h = null;
        GlobalSettingsManager.c(r102, false);
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public final void a() {
        Iterator<T> r100 = mx7.a.a().b().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IGeckoRegister r101 = (IGeckoRegister) r100.next();
        b r102 = b.a.f245076a;
        b.e(r101);
        goto L4
    }

    public IvyResourceServiceImpl() {
    }
}

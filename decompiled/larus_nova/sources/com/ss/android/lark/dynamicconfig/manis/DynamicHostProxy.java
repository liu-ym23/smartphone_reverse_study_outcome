package com.ss.android.lark.dynamicconfig.manis;

import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
@RemoteService
public interface DynamicHostProxy extends IHookInterface {
    String getDocMainDomain();

    String getMainDomain();

    List<String> getMainDomains();
}

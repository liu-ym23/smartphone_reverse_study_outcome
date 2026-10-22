package com.ss.android.lark.auditsdk.v2.receivecheck;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.auditsdk.v2.receivecheck.a$a, reason: collision with other inner class name */
    public interface InterfaceC4761a {
        void a(Map<String, ValidateIMFileResult> r100);
    }

    void a(InterfaceC4761a r100);

    Map<String, ValidateIMFileResult> b(Map<String, AuthorityParam> r100, boolean r101);

    void c(InterfaceC4761a r100);

    void destroy();
}

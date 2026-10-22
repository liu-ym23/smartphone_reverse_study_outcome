package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginDowngradeImpl;", "Lcom/obric/assistant/onelogin/IObricOneLogin;", "<init>", "()V", "createObricLoginRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "initOAccountLoginState", "", "isMainActivityStarted", "", "setMainActivityStarted", "getOneLoginActivity", "", "getXttTokenMap", "", "waitInitOAccount", "init", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginDowngradeImpl implements IObricOneLogin {

    public static final class a {
    }

    static {
    }

    public ObricOneLoginDowngradeImpl() {
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final void b() {
        FLogger.f375446a.d("ObricOneLoginDowngradeI", "initOAccountLoginState");
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final String c() {
        FLogger.f375446a.d("ObricOneLoginDowngradeI", "getOneLoginActivity");
        return "";
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final q97.a d() {
        FLogger.f375446a.d("ObricOneLoginDowngradeI", "createObricLoginRouterInterceptor");
        return null;
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final void a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        r100.invoke();
    }
}

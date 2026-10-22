package gm9;

import com.larus.platform.api.g4;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f481758a;

    @Override // com.larus.platform.api.g4
    public final void a() {
        FLogger.f375446a.i("AccountLoginStateInterceptor", "logout success");
        this.f481758a.f481757a.set(false);
    }

    @Override // com.larus.platform.api.g4
    public final void b() {
        FLogger.f375446a.i("AccountLoginStateInterceptor", "logout failed");
        this.f481758a.f481757a.set(false);
    }

    public d(c r100) {
        this.f481758a = r100;
    }
}

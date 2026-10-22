package qbb;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements d0c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSession f532426a;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c
    public final UserSession e9() {
        UserSession r100 = this.f532426a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ((com.ss.android.lark.passportc.convention.a) k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final l provideComponent() {
        UserSession r100 = e9();
        return ((v) k.a(LarkContext.getApplication(), v.class)).c(r100);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public c(UserSession r100) {
        this.f532426a = r100;
    }
}

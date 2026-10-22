package com.ss.android.lark.keyboard.edittext2.compat;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.keyboard.edittext2.base.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C5086a f428962c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext2.base.b f428963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f428964b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.compat.a$a, reason: collision with other inner class name */
    public static final class C5086a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f428965a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<a> a() {
            return this.f428965a.f428961a;
        }

        public C5086a() {
            this.f428965a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        f428962c = new C5086a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r100 = this.f428963a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    public a() {
        this.f428964b = "";
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428963a = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    }
}

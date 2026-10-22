package com.ss.android.lark.keyboard.edittext2.mdeditor;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.keyboard.edittext2.base.b;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u9b.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.keyboard.edittext2.base.a, c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C5096a f429182c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends d<? extends Object>> f429183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f429184b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.mdeditor.a$a, reason: collision with other inner class name */
    public static final class C5096a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429185a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<a> a() {
            return this.f429185a.f428961a;
        }

        public C5096a() {
            this.f429185a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        f429182c = new C5096a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final b getTarget() {
        b r100 = this.f429184b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    public a() {
        SpanToNodeMappers r100 = SpanToNodeMappers.f419704a;
        this.f429183a = com.ss.android.lark.coremdbiz.facade.a.c();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429184b = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f429183a = ((a) r100).f429183a;
    }
}

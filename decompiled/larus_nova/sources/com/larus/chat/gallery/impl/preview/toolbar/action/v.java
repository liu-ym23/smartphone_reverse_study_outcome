package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.chat.gallery.api.q f324786a;

    public static final class a {
    }

    static {
    }

    public v(com.larus.chat.gallery.api.q r100) {
        Intrinsics.checkNotNullParameter(r100, "mediaSession");
        this.f324786a = r100;
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r100, Continuation<? super Unit> r101) {
        final com.larus.chat.gallery.api.a0 r102 = this.f324786a.Pa(r100.f324766a.f565427b, !this.f324786a.Oa(r100.f324766a.f565427b));
        if (r102.f324127a == false) goto L5;
        PreviewToolbarView r103 = r100.f324771f;
        if (r103 == null) goto L10;
        r103.b(ToolbarButtonType.SELECT, new u(r102));
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}

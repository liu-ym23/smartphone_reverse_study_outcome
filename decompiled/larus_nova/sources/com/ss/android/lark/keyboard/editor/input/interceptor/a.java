package com.ss.android.lark.keyboard.editor.input.interceptor;

import com.baidu.platform.comapi.map.MapController;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.e;
import com.ss.android.lark.keyboard.keyboard2.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C5084a f428901c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i7b.a f428902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428903b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.interceptor.a$a, reason: collision with other inner class name */
    public static final class C5084a implements c.a<a> {
        public C5084a() {
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f428904a;

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean u(m r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            return true;
        }

        public b(a r100) {
            this.f428904a = r100;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean n(m r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            if (r100.g() == KeyboardMenuItemKey.At) goto L5;
            return true;
        L5:
            int r101 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.f412048a;
            i7b.a r102 = this.f428904a.f428902a;
            return !com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.b(r102.f488506f, r102.f488507g, r102.f488509i);
        }
    }

    static {
        f428901c = new C5084a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        com.ss.android.lark.keyboard.b r100 = this.f428903b;
        com.ss.android.lark.keyboard.b r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        r100 = null;
    L6:
        r100.H().M(new b(this));
        com.ss.android.lark.keyboard.b r102 = this.f428903b;
        if (r102 == null) goto L9;
        r101 = r102;
    L10:
        r101.H().m();
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        goto L10
    }

    public a(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        this.f428902a = r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428903b = r100;
    }
}

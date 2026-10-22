package com.ss.android.lark.keyboard.editor.input.interceptor;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.keyboard2.f;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import cya.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ChatEditorMenuLayoutManager implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f428882e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.a f428883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.widget.a f428884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f428886d;

    public static final class a implements c.a<ChatEditorMenuLayoutManager> {
        public a() {
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatEditorMenuLayoutManager f428887b;

        public b(ChatEditorMenuLayoutManager r100) {
            this.f428887b = r100;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r100, List<? extends View> r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "visibleChildViews");
            com.ss.android.lark.keyboard.b r102 = this.f428887b.f428885c;
            cya.c r103 = null;
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
            r102 = null;
        L6:
            com.ss.android.lark.keyboard.keyboard2.b r104 = r102.L();
            if ((r104 instanceof cya.c) == false) goto L9;
            r103 = (cya.c) r104;
        L9:
            if (r103 != null) goto L11;
            this.f428887b.f428883a.a(r100, r101);
            return;
        L11:
            int r105 = r103.a().d().a();
            if (r105 != 4) goto L14;
        L18:
            this.f428887b.f428883a.a(r100, r101);
            return;
        L14:
            if (r105 == 8) goto L18;
            if (r105 == 16) goto L18;
            this.f428887b.f428884b.a(r100, r101);
        }
    }

    static {
        f428882e = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        com.ss.android.lark.keyboard.b r100 = this.f428885c;
        com.ss.android.lark.keyboard.b r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        r100 = null;
    L6:
        final d r102 = r100.H();
        com.ss.android.lark.keyboard.b r103 = this.f428885c;
        if (r103 == null) goto L9;
        r101 = r103;
    L10:
        r101.e().of(this).d(h.class, new ChatEditorMenuLayoutManager$onAttached$1(r102));
        r102.C(this.f428886d);
        r102.m();
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        goto L10
    }

    public ChatEditorMenuLayoutManager() {
        this.f428883a = f.f429545a;
        this.f428884b = new com.ss.android.lark.keyboard.widget.a();
        this.f428886d = new b(this);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428885c = r100;
    }
}

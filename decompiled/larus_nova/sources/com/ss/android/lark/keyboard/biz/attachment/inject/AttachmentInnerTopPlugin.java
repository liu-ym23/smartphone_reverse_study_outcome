package com.ss.android.lark.keyboard.biz.attachment.inject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class AttachmentInnerTopPlugin implements wnb.b<AttachmentInnerTopPlugin> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f428282i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f428285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f428286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f428287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData f428288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LifecycleOwner f428289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f428290h;

    public static final class a implements wnb.b.a<AttachmentInnerTopPlugin> {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentInnerTopPlugin f428291a;

        public b(AttachmentInnerTopPlugin r100) {
            this.f428291a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Chat r101 = (Chat) r100;
            Intrinsics.checkNotNullParameter(r101, "chat");
            this.f428291a.f(r101);
        }
    }

    static {
        f428282i = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        h r100 = this.f428283a.f410100e;
        if (r100 == null) goto L8;
        MutableLiveData<Chat> r101 = r100.f410103c;
        if (r101 == null) goto L8;
        Chat r102 = r101.getValue();
        if (r102 == null) goto L8;
    L9:
        f(r102);
        wxa.a r103 = (wxa.a) this.f428286d.getValue();
        ViewGroup r104 = null;
        if (r103 == null) goto L12;
        ViewGroup r105 = r103.q2();
    L14:
        if ((r105 instanceof View) == false) goto L16;
        r104 = r105;
    L16:
        if (r104 != null) goto L19;
        Log.e("AttachmentInnerTopPlugin", "takeAttachmentPanelView is null.");
        return new FrameLayout(this.f428283a.f410096a.requireContext());
    L19:
        com.ss.android.lark.biz.im.api.extension.chat_window.b r106 = this.f428283a;
        h r107 = r106.f410100e;
        if (r107 == null) goto L32;
        MutableLiveData<Chat> r108 = r107.f410103c;
        if (r108 == null) goto L32;
        LifecycleOwner r109 = r106.f410096a.getViewLifecycleOwner();
        MutableLiveData<Chat> r110 = this.f428288f;
        if (r110 == r108) goto L27;
    L29:
        if (r110 == null) goto L31;
        r110.removeObserver(this.f428290h);
    L31:
        this.f428288f = r108;
        this.f428289g = r109;
        r108.observe(r109, this.f428290h);
        goto L32
    L27:
        if (this.f428289g != r109) goto L29;
    L32:
        return r104;
    L12:
        r105 = null;
    L8:
        r102 = this.f428283a.f410098c;
        goto L9
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, 0, 0);
    }

    @Override // wnb.b
    public final c h() {
        c r100 = this.f428285c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        MutableLiveData r100 = this.f428288f;
        if (r100 == null) goto L5;
        r100.removeObserver(this.f428290h);
    L5:
        this.f428288f = null;
        this.f428289g = null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerTop;
    }

    @Override // wnb.b
    public final wnb.b.a<AttachmentInnerTopPlugin> getKey() {
        return f428282i;
    }

    public AttachmentInnerTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428283a = r100;
        this.f428286d = LazyKt.lazy(new AttachmentInnerTopPlugin$attachmentExtension$2(this));
        this.f428290h = new b(this);
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428285c = r100;
    }

    public final void f(Chat r100) {
        boolean r101 = com.ss.android.lark.keyboard.utils.b.a(r100);
        if (Intrinsics.areEqual(this.f428287e, Boolean.valueOf(r101)) == false) goto L5;
        return;
    L5:
        this.f428287e = Boolean.valueOf(r101);
        Log.i("AttachmentInnerTopPlugin", "update suggested action visibility, visible=" + r101);
        wxa.a r102 = (wxa.a) this.f428286d.getValue();
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428284b = r100;
    }
}

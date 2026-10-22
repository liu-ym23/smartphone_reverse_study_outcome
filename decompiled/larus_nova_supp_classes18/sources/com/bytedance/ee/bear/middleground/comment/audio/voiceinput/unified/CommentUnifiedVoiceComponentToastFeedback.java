package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.app.Activity;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentUnifiedVoiceComponentToastFeedback implements g {
    public final Activity a;
    public final Function1<Function0<Unit>, com.larksuite.component.universe_design.toast.c> b;
    public final Function0<Boolean> c;
    public com.larksuite.component.universe_design.toast.c d;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void a() {
        UDToast.show(this.a, 2131889569, 2131256189);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void b() {
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L5;
        return;
    L5:
        UDToast.show(this.a, 2131890985, 2131254921);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void c() {
        UDToast.show(this.a, 2131890453, 2131256189);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void e() {
        UDToast.show(this.a, 2131891301, 2131256189);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void f() {
        com.larksuite.component.universe_design.toast.c r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        this.d = null;
        r0.cancel();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.g
    public final void d() {
        f();
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.larksuite.component.universe_design.toast.c r1 = (com.larksuite.component.universe_design.toast.c) this.b.invoke(new CommentUnifiedVoiceComponentToastFeedback$showRecognizing$toast$1(this, r0));
        r0.element = r1;
        this.d = r1;
        r1.show();
    }

    public CommentUnifiedVoiceComponentToastFeedback(final Activity r4) {
        Function1<Function0<? extends Unit>, com.larksuite.component.universe_design.toast.c> r0 = new AnonymousClass1(r4);
        AnonymousClass2 r1 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r0, "recognizingToastFactory");
        Intrinsics.checkNotNullParameter(r1, "isOfficeSDK");
        this.a = r4;
        this.b = r0;
        this.c = r1;
    }
}

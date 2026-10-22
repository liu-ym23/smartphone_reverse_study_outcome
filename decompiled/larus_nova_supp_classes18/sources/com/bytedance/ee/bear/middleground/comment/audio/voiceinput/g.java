package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.LarkImCommentVoiceInputController;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.t;
import com.bytedance.ee.bear.middleground.comment.export.CommentVoiceHostPolicy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements h {
    public static final /* synthetic */ int b = 0;
    public final h a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0049a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CommentVoiceHostPolicy.Route.values().length];
                r0[CommentVoiceHostPolicy.Route.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[CommentVoiceHostPolicy.Route.LARK_IM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static g a(f r3) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            CommentVoiceHostPolicy.Route r0 = com.bytedance.ee.bear.middleground.comment.export.e.c();
            int r1 = C0049a.a[r0.ordinal()];
            if (r1 != 1) goto L5;
        L15:
            return null;
        L5:
            if (r1 == 2) goto L18;
            if (r1 != 3) goto L13;
            if (r3.I != null) goto L11;
            tt5.a.k("CommentVoiceInputController", "skip unified voice component: simpleInputContext is null");
            goto L15
        L11:
            t r2 = t.a;
            return new g(new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.f(r3));
        L13:
            throw new NoWhenBranchMatchedException();
        L18:
            return new g(new LarkImCommentVoiceInputController(r3));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean b(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.a.b(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean c(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.a.c(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void d() {
        this.a.d();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void destroy() {
        this.a.destroy();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void e() {
        this.a.e();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean f(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.a.f(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void g() {
        this.a.g();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void h() {
        this.a.h();
    }

    public g(h r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }
}

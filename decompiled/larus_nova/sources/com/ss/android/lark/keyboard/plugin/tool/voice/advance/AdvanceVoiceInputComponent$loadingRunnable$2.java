package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AdvanceVoiceInputComponent$loadingRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ b this$0;

    public static final class a implements Runnable {
        public a(b r100) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AdvanceVoiceInputComponent$loadingRunnable$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Runnable invoke2() {
        return new a(this.this$0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Runnable invoke() {
        return invoke2();
    }
}

package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioRecognizePopupView$mOnLongPressedRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ AudioRecognizePopupView this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioRecognizePopupView f429962a;

        public a(AudioRecognizePopupView r100) {
            this.f429962a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i(this.f429962a.getMTag(), "Start record by long pressed");     // Catch: Throwable -> L4
            AudioRecognizePopupView r100 = this.f429962a;     // Catch: Throwable -> L4
            r100.f429957c = false;     // Catch: Throwable -> L4
            AudioRecognizePopupView.b6(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AudioRecognizePopupView$mOnLongPressedRunnable$2(AudioRecognizePopupView r100) {
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

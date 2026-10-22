package com.bytedance.android.livesdk.ktvimpl.speech;

import com.bytedance.android.live.ktv.common.speech.LyricsRecognizer;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/speech/LyricsRecognitionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/ktv/common/speech/LyricsRecognizer;", "lyricsRecognizer$delegate", "Lkotlin/Lazy;", "getLyricsRecognizer", "()Lcom/bytedance/android/live/ktv/common/speech/LyricsRecognizer;", "lyricsRecognizer", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LyricsRecognitionContext extends DataContext {
    public static final a Companion = null;
    private final Lazy lyricsRecognizer$delegate;

    public static final class a {
        public a() {
        }

        public final LyricsRecognitionContext getContext() {
            DataContext r0 = d.d(LyricsRecognitionContext.class);
            if ((r0 instanceof LyricsRecognitionContext) == true) goto L6;
            r0 = null;
        L6:
            return (LyricsRecognitionContext) r0;
        }
    }

    private final LyricsRecognizer getLyricsRecognizer() {
        return (LyricsRecognizer) this.lyricsRecognizer$delegate.getValue();
    }

    static {
        Companion = new a();
    }

    public LyricsRecognitionContext() {
        this.lyricsRecognizer$delegate = LazyKt.lazy(LyricsRecognitionContext$lyricsRecognizer$2.INSTANCE);
    }

    public static final /* synthetic */ LyricsRecognizer access$getLyricsRecognizer$p(LyricsRecognitionContext r0) {
        return r0.getLyricsRecognizer();
    }
}

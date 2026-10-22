package com.bytedance.android.livesdk.ktvimpl.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.speech.LyricsRecognizer;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.b;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/speech/LyricsRecognitionWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LyricsRecognitionWidget extends HolderRoomWidget {
    public final CompositeDisposable d;

    public static final class a {
    }

    static {
    }

    public LyricsRecognitionWidget() {
        this.d = new CompositeDisposable();
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        ALogger.i("LyricsRecognitionWidget", "onCreate");
        Pair r0 = d.a(LyricsRecognitionWidget$onCreate$dataContext$1.INSTANCE);
        b.a((DataContext) r0.getFirst(), LyricsRecognitionContext.class);
        this.d.add((Disposable) r0.getSecond());
    }

    public final void onDestroy() {
        super.onDestroy();
        ALogger.i("LyricsRecognitionWidget", "onDestroy");
        LyricsRecognitionContext r0 = LyricsRecognitionContext.Companion.getContext();
        if (r0 == null) goto L5;
        LyricsRecognizer r1 = LyricsRecognitionContext.access$getLyricsRecognizer$p(r0);
    L6:
        if (r1 == null) goto L8;
        r1.destroyEngine();
    L8:
        this.d.clear();
        return;
    L5:
        r1 = null;
        goto L6
    }
}

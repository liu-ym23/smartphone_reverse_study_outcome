package com.ss.android.lark.audio.recorder;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f409120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager f409121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioFocusRequest f409122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f409123d;

    public static final class a {
    }

    public static final class b implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f409124a;

        public b(e r100) {
            this.f409124a = r100;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r100) {
            Function1<Integer, Unit> r101 = this.f409124a.f409120a;
            if (r101 == null) goto L6;
            r101.invoke(Integer.valueOf(r100));
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f409120a = r101;
        Object r102 = r100.getSystemService("audio");
        if ((r102 instanceof AudioManager) == false) goto L5;
        AudioManager r103 = (AudioManager) r102;
    L6:
        this.f409121b = r103;
        this.f409123d = new b(this);
        return;
    L5:
        r103 = null;
        goto L6
    }
}

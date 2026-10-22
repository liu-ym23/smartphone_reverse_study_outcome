package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardImeWrapper extends ImeWrapper implements c {
    public static final a D = null;
    public com.ss.android.lark.keyboard.b C;

    public static final class a implements c.a<KeyboardImeWrapper> {
        public a() {
        }
    }

    static {
        D = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        setFocusDelegate(new KeyboardImeWrapper$onAttached$1(this));
    }

    public com.ss.android.lark.keyboard.b getKeyboard() {
        com.ss.android.lark.keyboard.b r100 = this.C;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    public KeyboardImeWrapper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.C = r100;
    }
}

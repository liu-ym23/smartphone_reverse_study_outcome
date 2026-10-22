package com.ss.android.lark.keyboard.edittext2.base;

import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface c extends com.ss.android.lark.keyboard.edittext2.base.a {

    public static final class a {
        public static EditText a(c r100) {
            Object r101 = r100.getTarget();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.EditText");
            return (EditText) r101;
        }
    }
}

package com.ss.android.lark.chatwindow.view.preview;

import android.view.ViewGroup;
import com.ss.android.lark.chatwindow.view.preview.c.a;
import h2b.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface c<T extends a, S extends h2b.a> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f417043a;

        public a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "containerView");
            this.f417043a = r100;
        }
    }

    void a(S r100, T r101);

    T b(S r100, ViewGroup r101);

    int getPreviewType();
}

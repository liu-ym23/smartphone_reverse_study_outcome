package com.ss.android.lark.keyboard.keyboard2;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f429556f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyboardScene f429557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f429558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f429559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f429560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429561e;

    public static final class a implements c.a<k> {
        public a() {
        }
    }

    static {
        f429556f = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    public final Activity getContext() {
        return this.f429559c;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429561e = r100;
    }

    public k(KeyboardScene r100, Lifecycle r101, Activity r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f429557a = r100;
        this.f429558b = r101;
        this.f429559c = r102;
        this.f429560d = r103;
    }
}

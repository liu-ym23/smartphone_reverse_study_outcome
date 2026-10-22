package com.ss.lark.android.avatar.plugin;

import android.content.Context;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.lark.android.avatar.ui.AvatarSource;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarSource f456637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CallbackManager f456638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<Context> f456639c;

    public a(Context r100, AvatarSource r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f456637a = r101;
        this.f456638b = new CallbackManager();
        this.f456639c = new WeakReference(r100);
    }
}

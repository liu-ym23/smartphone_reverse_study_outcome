package com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop;

import android.content.Context;
import android.widget.FrameLayout;
import com.ss.android.lark.biz.im.extension.chat_window.keyboard_top.ExtendType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ExtendType, Integer> f412106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f412107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f412108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ExtendType, Integer> f412109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<ExtendType, Object> f412110e;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a$a, reason: collision with other inner class name */
    public static final class C4794a {
    }

    public interface b {
    }

    static {
    }

    public final Context getContext() {
        return this.f412107b;
    }

    public a(Map<ExtendType, Integer> r100, Context r101, FrameLayout r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "propertiesMap");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "dependency");
        this.f412106a = r100;
        this.f412107b = r101;
        this.f412108c = r102;
        ConcurrentHashMap r104 = new ConcurrentHashMap();
        this.f412109d = r104;
        this.f412110e = new ConcurrentHashMap();
        new LinkedHashMap();
        new ConcurrentHashMap();
        r104.putAll(r100);
    }
}

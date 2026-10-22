package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<MessageListAnimationContainer> f412078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f412079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f412080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f412081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f412082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f412083f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<MessageListAnimationContainer> r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "animContainerProvider");
        Intrinsics.checkNotNullParameter(r101, "marginHandler");
        this.f412078a = r100;
        this.f412079b = r101;
    }
}

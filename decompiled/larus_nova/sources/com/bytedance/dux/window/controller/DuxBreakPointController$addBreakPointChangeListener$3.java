package com.bytedance.dux.window.controller;

import android.view.View;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import em4.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DuxBreakPointController$addBreakPointChangeListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ hm4.c $config;
    final /* synthetic */ View $view;
    final /* synthetic */ DuxBreakPointController this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBreakPointController f205931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hm4.c f205932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f205933c;

        public a(DuxBreakPointController r100, hm4.c r101, View r102) {
            this.f205931a = r100;
            this.f205932b = r101;
            this.f205933c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DuxBreakPointController r100 = this.f205931a;     // Catch: Throwable -> L4
            int r101 = this.f205932b.f485932b;     // Catch: Throwable -> L4
            this.f205933c.getRight();     // Catch: Throwable -> L4
            this.f205933c.getLeft();     // Catch: Throwable -> L4
            this.f205933c.getBottom();     // Catch: Throwable -> L4
            this.f205933c.getTop();     // Catch: Throwable -> L4
            int r102 = DuxBreakPointController.f205930a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            Map<PadAdaptScene, Boolean> r103 = DuxConfig.f204897a;     // Catch: Throwable -> L4
            d.b("DuxBreakPointController", "updateViewBreakPoint：only support pad or fold!");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DuxBreakPointController$addBreakPointChangeListener$3(View r100, DuxBreakPointController r101, hm4.c r102) {
        this.$view = r100;
        this.this$0 = r101;
        this.$config = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View r100 = this.$view;
        r100.post(new a(this.this$0, this.$config, r100));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

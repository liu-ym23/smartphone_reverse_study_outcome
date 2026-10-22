package com.bytedance.ee.bear.list.homepage.ai;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.myai.export.d;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import osb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceHomePageAiLauncher {
    public static final /* synthetic */ int g = 0;
    public volatile String a;
    public volatile String b;
    public volatile boolean c;
    public final Object d;
    public final Lazy e;
    public d f;

    public static final class Companion {
        public static void a(Context r1, ce5.a r2, final Function1 r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
            Intrinsics.checkNotNullParameter(r3, "callback");
            if (r2.d.isCurrentEnable("ccm.workspace.next.sidebar_my_ai_chat_entry") == false) goto L8;
            e0 r4 = (e0) LarkContext.spiByDwarf(e0.class);
            if (r4 == null) goto L9;
            r4.j(new SpaceHomePageAiLauncher$Companion$observeAiEnableChange$1(r3));
            return;
        L9:
            return;
        }
    }

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "InitMyAIParams(chatId=" + this.a + ", aiChatModeId=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "aiChatModeId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final e0 a() {
        return (e0) this.e.getValue();
    }

    public final void b() {
        c(SpaceHomePageAiLauncher$init$1.INSTANCE);
    }

    public SpaceHomePageAiLauncher() {
        this.d = new Object();
        this.e = LazyKt.lazy(SpaceHomePageAiLauncher$aiDependency$2.INSTANCE);
    }

    public final void c(final Function1<? super a, Unit> r5) {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode net disconnected, return");
        return;
    L6:
        a().g();
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode");
        Object r0 = this.d;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L9:
        if (this.a == null) goto L22;
        if (this.b == null) goto L22;
        String r2 = this.a;     // Catch: Throwable -> L31
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        String r3 = this.b;     // Catch: Throwable -> L31
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        r5.invoke(new a(r2, r3));     // Catch: Throwable -> L31
        monitor-exit(r0);
        return;
    L22:
        if (this.c == false) goto L27;
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode initializing");     // Catch: Throwable -> L31
        monitor-exit(r0);
        return;
    L27:
        this.c = true;     // Catch: Throwable -> L31
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r0);
        b.a r4 = new b.a();
        Intrinsics.checkNotNullParameter("SpaceHome", "<set-?>");
        r4.a = "SpaceHome";
        r4.b = "";
        a().c(new b(r4), new SpaceHomePageAiLauncher$initChatMode$2(this, r5));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$getMyAIParam$1] */
    public final void d(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        tt5.a.h("SpaceHomePageAiLauncher", "launch Ai View");
        tt5.a.h("SpaceHomePageAiLauncher", "doOpenMyAI");
        a().g();
        final Function1<a, Unit> r1 = new SpaceHomePageAiLauncher$doOpenMyAI$1(this, r4);
        tt5.a.h("SpaceHomePageAiLauncher", "getMyAIParam");
        String r5 = this.b;
        boolean r0 = false;
        if (r5 != null) goto L5;
    L10:
        if (r0 == false) goto L15;
        e0 r6 = a();
        String r2 = this.b;
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r6.d(r2, new SpaceHomePageAiLauncher$getMyAIParam$1(r1, this));
        return;
    L15:
        c(r1);
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 != true) goto L10;
        r0 = true;
        goto L10
    L7:
        r7 = false;
        goto L8
    }
}

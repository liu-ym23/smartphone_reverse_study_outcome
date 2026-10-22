package com.bytedance.ee.bear.list.homepage.ai;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.myai.export.d;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import osb.b;

/* JADX INFO: loaded from: classes18.dex */
public final class SpaceHomePageAiLauncher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f228245g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f228246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f228247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f228248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f228249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f228250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f228251f;

    public static final class Companion {
        public static void a(Context r100, ce5.a r101, final Function1 r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
            Intrinsics.checkNotNullParameter(r102, "callback");
            if (r101.f23449d.isCurrentEnable("ccm.workspace.next.sidebar_my_ai_chat_entry") == false) goto L8;
            e0 r103 = (e0) LarkContext.spiByDwarf(e0.class);
            if (r103 == null) goto L9;
            r103.j(new SpaceHomePageAiLauncher$Companion$observeAiEnableChange$1(r102));
            return;
        L9:
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f228252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f228253b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f228252a, r101.f228252a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f228253b, r101.f228253b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f228252a.hashCode() * 31) + this.f228253b.hashCode();
        }

        public final String toString() {
            return "InitMyAIParams(chatId=" + this.f228252a + ", aiChatModeId=" + this.f228253b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            Intrinsics.checkNotNullParameter(r101, "aiChatModeId");
            this.f228252a = r100;
            this.f228253b = r101;
        }
    }

    static {
    }

    public final e0 a() {
        return (e0) this.f228250e.getValue();
    }

    public final void b() {
        c(SpaceHomePageAiLauncher$init$1.INSTANCE);
    }

    public SpaceHomePageAiLauncher() {
        this.f228249d = new Object();
        this.f228250e = LazyKt.lazy(SpaceHomePageAiLauncher$aiDependency$2.INSTANCE);
    }

    public final void c(final Function1<? super a, Unit> r100) {
        if (j.a.f217090a.getNetworkState().a() == true) goto L6;
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode net disconnected, return");
        return;
    L6:
        a().g();
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode");
        Object r101 = this.f228249d;
        monitor-enter(r101);
    L31:
        th = move-exception;
        throw th;
    L9:
        if (this.f228246a == null) goto L22;
        if (this.f228247b == null) goto L22;
        String r102 = this.f228246a;     // Catch: Throwable -> L31
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        String r103 = this.f228247b;     // Catch: Throwable -> L31
        if (r103 != null) goto L18;
        r103 = "";
    L18:
        r100.invoke(new a(r102, r103));     // Catch: Throwable -> L31
        monitor-exit(r101);
        return;
    L22:
        if (this.f228248c == false) goto L27;
        tt5.a.h("SpaceHomePageAiLauncher", "initChatMode initializing");     // Catch: Throwable -> L31
        monitor-exit(r101);
        return;
    L27:
        this.f228248c = true;     // Catch: Throwable -> L31
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r101);
        b.a r105 = new b.a();
        Intrinsics.checkNotNullParameter("SpaceHome", "<set-?>");
        r105.f526599a = "SpaceHome";
        r105.f526600b = "";
        a().c(new b(r105), new SpaceHomePageAiLauncher$initChatMode$2(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$getMyAIParam$1] */
    public final void d(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("SpaceHomePageAiLauncher", "launch Ai View");
        tt5.a.h("SpaceHomePageAiLauncher", "doOpenMyAI");
        a().g();
        final Function1<a, Unit> r101 = new SpaceHomePageAiLauncher$doOpenMyAI$1(this, r100);
        tt5.a.h("SpaceHomePageAiLauncher", "getMyAIParam");
        String r102 = this.f228247b;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L10:
        if (r103 == false) goto L15;
        e0 r104 = a();
        String r105 = this.f228247b;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r104.d(r105, new SpaceHomePageAiLauncher$getMyAIParam$1(r101, this));
        return;
    L15:
        c(r101);
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 != true) goto L10;
        r103 = true;
        goto L10
    L7:
        r106 = false;
        goto L8
    }
}

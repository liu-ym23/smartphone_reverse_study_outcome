package com.bytedance.applet.provider.impl;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.utils.f;
import jw3.d;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements d {
    public static final b a = null;

    public static final class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        public final void a(AppletMonitorableEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            r3.f("questionId", this.a);
            r3.f("botId", this.b);
            r3.f("conversationId", this.c);
            r3.g("isHistory", this.d);
            r3.g("success", this.e);
        }

        public a(String r1, String r2, String r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    @Override // jw3.d
    public final void trace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        f.j(r2);
    }

    @Override // jw3.d
    public final void a(String r8, String r9, String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "questionId");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        com.bytedance.ai.monitor.b.d("applet_save_bot_reply", new a(r8, r9, r10, r11, r12));
    }
}

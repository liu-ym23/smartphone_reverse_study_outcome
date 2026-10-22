package com.bytedance.live.livelink.kmp.impl.core.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/live/livelink/kmp/impl/core/link/LinkManager$logReporter$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/live/livelink/kmp/impl/core/link/LinkManager$logReporter$2$a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LinkManager$logReporter$2 extends Lambda implements Function0<a> {
    final /* synthetic */ LinkManager this$0;

    public static final class a implements ki6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkManager$logReporter$2 f255414a;

        public a(LinkManager$logReporter$2 r100) {
            this.f255414a = r100;
        }

        @Override // ki6.b
        public final void a(final JsonObject r100) {
            final String r101 = "live_client_monitor_log";
            Intrinsics.checkNotNullParameter("live_client_monitor_log", "logType");
            Intrinsics.checkNotNullParameter(r100, "log");
            oi6.d r102 = this.f255414a.this$0.f255413j.s();
            if (r102 == null) goto L6;
            oi6.c.b(r102, new LinkManager$logReporter$2$1$onLogReport$1(this, r101, r100), "LinkManager log report");
            return;
        }
    }

    public LinkManager$logReporter$2(LinkManager r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}

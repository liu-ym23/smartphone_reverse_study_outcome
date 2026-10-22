package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import fd2.e;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/jsb/ChorusJsbDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lfd2/e;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusJsbDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final String CMD_JOIN_CHORUS_STATE = "cmd_join_chorus_state";
    public static final String CMD_RUNTIME_PARAMETERS_ON_LINK = "cmd_runtime_parameters_on_link";
    public static final String CMD_START_RTC_ENGINE = "cmd_start_rtc_engine";
    public static final a Companion = null;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final ChorusJsbDataContext getContext() {
            DataContext r0 = d.d(ChorusJsbDataContext.class);
            if ((r0 instanceof ChorusJsbDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (ChorusJsbDataContext) r0;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ChorusJsbDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<e> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public ChorusJsbDataContext() {
        this.service$delegate = ConstantKt.c(this);
    }
}

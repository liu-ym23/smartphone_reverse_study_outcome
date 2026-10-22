package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InteractionQuickReplyTracker$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final InteractionQuickReplyTracker$1 INSTANCE = null;

    static {
        INSTANCE = new InteractionQuickReplyTracker$1();
    }

    public InteractionQuickReplyTracker$1() {
        super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}

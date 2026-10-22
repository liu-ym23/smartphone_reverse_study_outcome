package com.ss.android.lark.statistics.drive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import o5c.b;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/statistics/api/IStatistics;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatDriveHitPoint$statistics$2 extends Lambda implements Function0<b> {
    public static final ChatDriveHitPoint$statistics$2 INSTANCE = null;

    static {
        INSTANCE = new ChatDriveHitPoint$statistics$2();
    }

    public ChatDriveHitPoint$statistics$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b invoke2() {
        return (b) k.a(LarkContext.getApplication(), b.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ b invoke() {
        return invoke2();
    }
}

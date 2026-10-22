package com.ss.android.lark.tab.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabProcessor$executor$2 extends Lambda implements Function0<ExecutorService> {
    public static final ChatTabProcessor$executor$2 INSTANCE = null;

    static {
        INSTANCE = new ChatTabProcessor$executor$2();
    }

    public ChatTabProcessor$executor$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ExecutorService invoke2() {
        return CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("chat_tab");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ExecutorService invoke() {
        return invoke2();
    }
}

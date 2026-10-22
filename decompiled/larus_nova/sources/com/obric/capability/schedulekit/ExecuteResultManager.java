package com.obric.capability.schedulekit;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.tencent.open.SocialConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
public final class ExecuteResultManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, Function1<JobResultWrapper, Unit>> f396029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f396030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecuteResultManager$resultReceiver$1 f396031c = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.ExecuteResultManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ExecuteResultManager.f396030b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.capability.schedulekit.ExecuteResultManager$resultReceiver$1, com.obric.capabilitykit.common.ICapabilityFeedbackReceiver, java.lang.Object] */
    static {
        f396029a = new ConcurrentHashMap();
        ?? r100 = new ExecuteResultManager$resultReceiver$1();
        f396031c = r100;
        CoroutineScope r101 = b.f396036a;
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        new CapabilityScheduleSdk$registerActionsResultReceiver$1(r100);
        b.a();
        throw null;
    }
}

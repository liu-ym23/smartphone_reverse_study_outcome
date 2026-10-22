package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f345369a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345370a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f345371b = null;

        static {
            int[] r100 = new int[OmniArchiveStatus.values().length];
            r100[OmniArchiveStatus.ArchiveStatus_ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            r100[OmniArchiveStatus.ArchiveStatus_BELONG_ARCHIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L18:
            r100[OmniArchiveStatus.ArchiveStatus_NO_BELONG_ARCHIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L6:
            f345370a = r100;
            int[] r101 = new int[OmniConversationSortType.values().length];
            r101[OmniConversationSortType.OmniConversationSortType_CREATE_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L8:
            f345371b = r101;
        }
    }

    static {
        f345369a = LazyKt.lazy(new n());
    }

    public static final wc9.f c(wc9.e r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f559198a;
        Integer r101 = r110.f559207j;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = r110.f559202e;
        if (r103 == null) goto L12;
        boolean r104 = true;
        if (r103.intValue() != 1) goto L12;
    L13:
        int r105 = r102;
        boolean r106 = r104;
        return new wc9.f(r100, r105, r106, r110.L, r110.f559218u);
    L12:
        r104 = false;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public static final long b(wc9.e r100, OmniConversationSortType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sortType");
        if (a.f345371b[r101.ordinal()] == 1) goto L10;
        Long r102 = r100.f559201d;
        if (r102 != null) goto L11;
        return 0;
    L11:
        return r102.longValue();
    L10:
        return r100.K;
    }

    public static final Object a(long r100, String r101, String r102, Function1 r103, ContinuationImpl r104) {
        kotlinx.coroutines.j r105 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r104), 1);
        r105.C();
        r103.invoke(new q(((ScheduledExecutorService) f345369a.getValue()).schedule(new r(r105, r101, r102), r100, TimeUnit.MILLISECONDS), r105, r101, r102));
        Object r106 = r105.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L5:
        return r106;
    }
}

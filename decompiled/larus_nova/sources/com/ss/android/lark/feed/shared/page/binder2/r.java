package com.ss.android.lark.feed.shared.page.binder2;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f421379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aeb.f f421380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f421381c;

    public final BaseFeedSwipeActionView a() {
        int r100 = dfb.b.f468331a;
        Context r101 = this.f421381c;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Map<ImExtensionType, List<Class<?>>> r102 = com.ss.android.lark.im.base.d.f425883a;
        dfb.c r103 = (dfb.c) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_SWIPE_ACTION_VIEW, dfb.c.class));
        if (r103 == null) goto L5;
        com.ss.android.lark.flow.feed.action.a r104 = r103.createView(r101);
    L6:
        if (r104 == null) goto L10;
        r104.c();
        return r104;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r104 = null;
        goto L6
    }

    public r(ViewGroup r100, aeb.f r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "rightActionContainer");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f421379a = r100;
        this.f421380b = r101;
        this.f421381c = r102;
    }
}

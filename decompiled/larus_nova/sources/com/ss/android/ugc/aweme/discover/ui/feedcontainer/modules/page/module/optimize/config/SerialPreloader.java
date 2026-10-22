package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.AsyncBindManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.android.cachalot.api.Trigger;
import com.ss.ugc.android.cachalot.common.async.controller.a;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/SerialPreloader;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SerialPreloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f450688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f450689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BindManagerEx f450690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<Integer> f450691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f450692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f450693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Trigger f450694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f450695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f450696i;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.SerialPreloader$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public final void a() {
        if (this.f450688a == false) goto L6;
        return;
    L6:
        if (this.f450695h == false) goto L12;
        this.f450689b = true;
        Integer r100 = this.f450691d.poll();
        if (r100 == null) goto L10;
        this.f450690c.a(r100.intValue(), new a(this.f450693f, this.f450692e, new SerialPreloader$preload$1(this), null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_AUDIOTRACK_POOL_SIZE), this.f450694g);
        return;
    L10:
        this.f450689b = false;
        this.f450696i.invoke();
        return;
    L12:
        if ((!this.f450691d.isEmpty()) == false) goto L27;
        if (this.f450688a == true) goto L15;
        Integer r101 = this.f450691d.poll();
        if (r101 == null) goto L12;
        this.f450690c.a(r101.intValue(), new a(this.f450693f, null, null, null, null, 1021), this.f450694g);
        goto L12
    L15:
        return;
    }

    public SerialPreloader(AsyncBindManager r100, Queue r101, Function0 r102, boolean r103, Trigger r104, boolean r105, Function0 r106) {
        Intrinsics.checkNotNullParameter(r100, "bindManager");
        Intrinsics.checkNotNullParameter(r101, "preloadQ");
        Intrinsics.checkNotNullParameter(r102, "canContinue");
        Intrinsics.checkNotNullParameter(r104, "trigger");
        Intrinsics.checkNotNullParameter(r106, "onComplete");
        this.f450690c = r100;
        this.f450691d = r101;
        this.f450692e = r102;
        this.f450693f = r103;
        this.f450694g = r104;
        this.f450695h = r105;
        this.f450696i = r106;
    }
}

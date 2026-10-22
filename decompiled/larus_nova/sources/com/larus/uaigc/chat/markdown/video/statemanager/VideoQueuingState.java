package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
public final class VideoQueuingState implements ez9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f371257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ISketchLoadingController f371258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy<i1<CreationQueuingTaskUIState>> f371259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<q0.a> f371260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f371261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f371262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f371263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f371264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Message f371265i;

    public static final class a {
    }

    static {
    }

    @Override // ez9.c
    public final int getLevel() {
        return this.f371261e;
    }

    @Override // ez9.c
    public final void g(ez9.c r100) {
        FLogger.f375446a.i("VideoQueuingState", "onLeave, curTaskId: " + this.f371264h);
        if ((r100 instanceof VideoLoadingState) == false) goto L5;
    L8:
        this.f371263g = null;
        Job r101 = this.f371262f;
        if (r101 == null) goto L11;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L11:
        this.f371262f = null;
        q0.a r102 = this.f371260d.invoke();
        if (r102 == null) goto L16;
        zd8.b r103 = r102.P9();
        if (r103 == null) goto L16;
        r103.B8(false, this.f371265i, this.f371264h);
    L16:
        this.f371265i = null;
        this.f371264h = null;
        return;
    L5:
        if ((r100 instanceof i) == false) goto L7;
        BuildersKt.launch$default(this.f371257a, null, null, new VideoQueuingState$onLeave$1(this, null), 3, null);
        goto L8
    L7:
        this.f371258b.hide();
        goto L8
    }

    @Override // ez9.c
    public final void e(String r110, Message r111) {
        if (r110 != null) goto L6;
        if (r111 != null) goto L6;
        g(null);
    L6:
        if (r111 == null) goto L8;
        String r100 = r111.getLocalMessageId();
    L9:
        String r101 = DataConverterKt.a(r100, r110);
        if (o0.d(r110) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.f371263g, r101) == true) goto L23;
        this.f371264h = r110;
        this.f371265i = r111;
        this.f371263g = r101;
        ISketchLoadingController.a.b(this.f371258b, false, null, 2, 3);
        Job r102 = this.f371262f;
        if (r102 == null) goto L16;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L16:
        this.f371262f = BuildersKt.launch$default(this.f371257a, null, null, new VideoQueuingState$observeQueuingUIStateChange$1(this, null), 3, null);
        q0.a r103 = this.f371260d.invoke();
        if (r103 == null) goto L24;
        zd8.b r104 = r103.P9();
        if (r104 == null) goto L25;
        r104.B8(true, r111, r110);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        r100 = null;
        goto L9
    }

    public VideoQueuingState(CoroutineScope r100, ISketchLoadingController r101, Lazy r102, com.larus.uaigc.chat.markdown.video.h r103) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "loadingController");
        Intrinsics.checkNotNullParameter(r102, "queuingUIState");
        Intrinsics.checkNotNullParameter(r103, "modelProviderGetter");
        this.f371257a = r100;
        this.f371258b = r101;
        this.f371259c = r102;
        this.f371260d = r103;
        this.f371261e = 1;
    }
}

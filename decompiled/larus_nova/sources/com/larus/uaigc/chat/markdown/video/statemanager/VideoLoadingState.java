package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
public final class VideoLoadingState implements ez9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f371250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<i1<MessageLoadingUIState>> f371251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ISketchLoadingController f371252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f371253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f371254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f371255f;

    public static final class a {
    }

    static {
    }

    @Override // ez9.c
    public final int getLevel() {
        return this.f371253d;
    }

    @Override // ez9.c
    public final void g(ez9.c r100) {
        FLogger.f375446a.d("VideoLoadingState", "onLeave, loadingId: " + this.f371255f);
        this.f371255f = null;
        if ((r100 instanceof i) == false) goto L5;
        BuildersKt.launch$default(this.f371250a, null, null, new VideoLoadingState$onLeave$1(this, null), 3, null);
    L6:
        Job r101 = this.f371254e;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        this.f371254e = null;
        return;
    L5:
        this.f371252c.hide();
        goto L6
    }

    @Override // ez9.c
    public final void e(String r100, Message r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        g(null);
    L6:
        if (r101 == null) goto L8;
        String r102 = r101.getLocalMessageId();
    L9:
        String r103 = DataConverterKt.a(r102, r100);
        if (o0.d(r100) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.f371255f, r103) == true) goto L19;
        this.f371255f = r103;
        ISketchLoadingController.a.b(this.f371252c, false, null, 2, 3);
        Job r104 = this.f371254e;
        if (r104 == null) goto L16;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L16:
        this.f371254e = BuildersKt.launch$default(this.f371250a, null, null, new VideoLoadingState$observeProgress$1(this, null), 3, null);
        return;
    L19:
        return;
    L8:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoLoadingState(CoroutineScope r100, Lazy<? extends i1<MessageLoadingUIState>> r101, ISketchLoadingController r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "loadingProgressState");
        Intrinsics.checkNotNullParameter(r102, "loadingController");
        this.f371250a = r100;
        this.f371251b = r101;
        this.f371252c = r102;
        this.f371253d = 2;
    }
}

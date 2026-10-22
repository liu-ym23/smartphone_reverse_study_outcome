package com.larus.audio.tts.notification;

import android.content.ServiceConnection;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowTtsMediaSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f289852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f289853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f289854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function1<g, Unit>> f289855d;

    public FlowTtsMediaSessionManager() {
        this.f289855d = new ArrayList();
    }

    public final void a(Function1<? super g, Unit> r100) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new FlowTtsMediaSessionManager$doAction$1(this, r100, null), 3, null);
    }
}

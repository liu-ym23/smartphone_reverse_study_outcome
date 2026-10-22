package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.collect.serviceapi.AoCameraService;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MultiCameraPresenter extends f04.a<Unit> {
    public final a14.a d;
    public final LifecycleOwner e;
    public final Lazy f;
    public final ViewGroup g;

    @Override // f04.a
    public final void k() {
    }

    @Override // f04.a
    public final void j(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        AoCameraService r5 = (AoCameraService) this.f.getValue();
        boolean r0 = true;
        if (r5 == null) goto L5;
        boolean r6 = r5.C();
    L6:
        Map r1 = this.d.a.w();
        if (r1 == null) goto L9;
        List r2 = (List) r1.get(7);
    L10:
        if (r6 == false) goto L24;
        if (r2 != null) goto L13;
    L15:
        r0 = false;
    L16:
        if (r0 == false) goto L24;
        String r7 = this.d.a.x();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L23
        new JSONObject(r7).optString("7", "");     // Catch: Throwable -> L23
        AoCameraService r8 = (AoCameraService) this.f.getValue();
        if (r8 == null) goto L22;
        this.d.a.getClass();
        r8.U1();
    L22:
        x54.b.a(this.g);
        return;
    L23:
        x54.b.a(this.g);
        return;
    L13:
        if ((!r2.isEmpty()) != true) goto L15;
    L24:
        x54.b.a(this.g);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r6 = true;
        goto L6
    }

    public MultiCameraPresenter(a14.a r1, LifecycleOwner r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r1, "pgParameters");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super(r1.b);
        this.d = r1;
        this.e = r2;
        this.f = LazyKt.lazy(MultiCameraPresenter$bdpCameraService$2.INSTANCE);
        this.g = (ViewGroup) i(2131380425);
    }
}

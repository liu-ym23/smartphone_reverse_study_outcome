package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.FlowSettingsScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f367890a = null;

    static {
        f367890a = new d();
    }

    public d() {
    }

    @Override // com.larus.setting.api.i
    public final void a(FragmentActivity r100, FlowSettingsScene r101, Function1<? super List<zs9.c>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r101 != FlowSettingsScene.NOTIFY) goto L10;
        int r103 = t.f367925a;
        IOrderMessageNotifySettingsProvider r104 = (IOrderMessageNotifySettingsProvider) ServiceManager.get().getService(IOrderMessageNotifySettingsProvider.class);
        if (r104 == null) goto L7;
        List<zs9.c> r105 = r104.a(r100);
    L8:
        if (r105 != null) goto L11;
        r105 = CollectionsKt.emptyList();
    L11:
        ((e) r102).invoke(r105);
        return;
    L7:
        r105 = null;
        goto L8
    L10:
        r105 = CollectionsKt.emptyList();
        goto L11
    }
}

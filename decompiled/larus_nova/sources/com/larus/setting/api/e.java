package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.FlowSettingsScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f367899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f367900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowSettingsScene f367901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f367902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1 f367903e;

    public /* synthetic */ e(List r100, FragmentActivity r101, FlowSettingsScene r102, int r103, Function1 r104) {
        this.f367899a = r100;
        this.f367900b = r101;
        this.f367901c = r102;
        this.f367902d = r103;
        this.f367903e = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        List r101 = this.f367899a;
        FragmentActivity r102 = this.f367900b;
        FlowSettingsScene r103 = this.f367901c;
        int r104 = this.f367902d;
        Function1 r105 = this.f367903e;
        List r106 = (List) r100;
        Intrinsics.checkNotNullParameter(r106, "sections");
        r101.add(r106);
        h r107 = h.f367906a;
        h.b(r102, r103, r104 + 1, r101, r105);
        return Unit.INSTANCE;
    }
}

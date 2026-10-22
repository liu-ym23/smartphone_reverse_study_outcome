package rg6;

import com.bytedance.android.scope.o;
import dn0.c;
import gd0.j;
import kotlin.jvm.internal.Intrinsics;
import qg6.f;
import sg6.b;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements o, qf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f537704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bn0.b f537705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f537706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tc0.b f537707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f537708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cg6.a f537709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f537710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f537711h;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f537704a = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f537704a = new b(this.f537706c, this.f537709f, this.f537710g, this.f537707d, this.f537705b, this.f537711h);
    }

    @Override // qf6.a
    public final b ob() {
        return this.f537704a;
    }

    public a(bn0.b r100, g r101, tc0.b r102, j r103, cg6.a r104, f r105, c r106) {
        Intrinsics.checkNotNullParameter(r100, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "linkInRoomDataHolderKt");
        Intrinsics.checkNotNullParameter(r103, "interactServiceKt");
        Intrinsics.checkNotNullParameter(r104, "multiLinkComponentService");
        Intrinsics.checkNotNullParameter(r105, "hostService");
        Intrinsics.checkNotNullParameter(r106, "linkSecurityService");
        this.f537705b = r100;
        this.f537706c = r101;
        this.f537707d = r102;
        this.f537708e = r103;
        this.f537709f = r104;
        this.f537710g = r105;
        this.f537711h = r106;
    }
}

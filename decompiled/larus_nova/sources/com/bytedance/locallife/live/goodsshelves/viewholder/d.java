package com.bytedance.locallife.live.goodsshelves.viewholder;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements kv6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeGoodsShelvesLynxNativeViewHolder f260382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f260383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveGoodsShelvesCard f260384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f260385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f260386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f260387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f260388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f260389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.locallife.live.goodsshelves.manager.i f260390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Boolean f260391j;

    @Override // kv6.d
    public final void onSuccess() {
    }

    @Override // kv6.d
    public final void onFail(String r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        LiveLocalLifeGoodsShelvesLynxNativeViewHolder r100 = this.f260382a;
        LiveGoodsShelvesCard r101 = this.f260384c;
        int r102 = this.f260385d;
        FragmentActivity r103 = this.f260386e;
        int r104 = this.f260387f;
        int r105 = this.f260388g;
        boolean r106 = this.f260389h;
        com.bytedance.locallife.live.goodsshelves.manager.i r107 = this.f260390i;
        Boolean r108 = this.f260391j;
        int r111 = LiveLocalLifeGoodsShelvesLynxNativeViewHolder.f260308i;
        r100.T3(r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public d(LiveLocalLifeGoodsShelvesLynxNativeViewHolder r100, Map r101, LiveGoodsShelvesCard r102, int r103, FragmentActivity r104, int r105, int r106, com.bytedance.locallife.live.goodsshelves.manager.i r107, Boolean r108) {
        this.f260382a = r100;
        this.f260383b = r101;
        this.f260384c = r102;
        this.f260385d = r103;
        this.f260386e = r104;
        this.f260387f = r105;
        this.f260388g = r106;
        this.f260389h = false;
        this.f260390i = r107;
        this.f260391j = r108;
    }
}

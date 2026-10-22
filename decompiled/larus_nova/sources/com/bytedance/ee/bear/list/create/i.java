package com.bytedance.ee.bear.list.create;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.list.DocumentListInfo;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends com.bytedance.ee.bear.list.e<DocumentListInfo> implements r0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f227735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f227736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f227737d;

    public static final class a implements nc5.b {
        public a() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    public static final class b implements nc5.a<DocumentListInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f227738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nc5.a<DocumentListInfo> f227739b;

        @Override // nc5.a
        public final void onFailure(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            tt5.a.e(this.f227738a.f227735b, "createDocument network error", r100, false);
            this.f227739b.onFailure(r100);
        }

        @Override // nc5.a
        public final void onSuccess(DocumentListInfo r100) {
            DocumentListInfo r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            tt5.a.h(this.f227738a.f227735b, "createDocument success");
            this.f227739b.onSuccess(r101);
        }

        public b(i r100, nc5.a<DocumentListInfo> r101) {
            this.f227738a = r100;
            this.f227739b = r101;
        }
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<DocumentListInfo> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.list.u());
    }

    public i() {
        this.f227735b = "CreateExecutor";
        this.f227736c = "/space/api/explorer/v2/create/folder/";
        this.f227737d = "/space/api/explorer/v2/create/object/";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.f227735b;
    }

    @Override // com.bytedance.ee.bear.list.create.r0
    public final nc5.b g(String r100, String r101, nc5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter("0", "source");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.h(this.f227735b, "createFolder, name: " + r100 + ", parentToken: " + du5.b.k(r101) + ", source: 0");
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L17:
        IllegalArgumentException r104 = new IllegalArgumentException("name/source is empty");
        tt5.a.e(this.f227735b, "createFolder param error", r104, false);
        r102.onFailure(r104);
        return new j();
    L8:
        if ("0".length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L17;
        if (r101 != null) goto L16;
        r101 = "";
    L16:
        return l(com.bytedance.ee.bear.list.e.k(this.f227736c, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("name", r100), TuplesKt.to("source", "0"), TuplesKt.to(DocViewModel.EXTRA_PARENT_TOKEN, r101)})), new k(this, r102));
    L10:
        r105 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.create.r0
    public final nc5.b a(int r100, String r101, String r102, String r110, nc5.a<DocumentListInfo> r111) {
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, "callback");
        tt5.a.h(this.f227735b, "createDocument, type: " + r100 + ", parentToken: " + du5.b.k(r101) + ", uuid: " + r102 + ", source: " + r110);
        if (r110.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        IllegalArgumentException r104 = new IllegalArgumentException("source is empty");
        tt5.a.e(this.f227735b, "createDocument param error", r104, false);
        r111.onFailure(r104);
        return new a();
    L9:
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("type", String.valueOf(r100));
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r105[1] = TuplesKt.to(DocViewModel.EXTRA_PARENT_TOKEN, r101);
        r105[2] = TuplesKt.to(ST.UUID_DEVICE, r102);
        r105[3] = TuplesKt.to("source", r110);
        return l(com.bytedance.ee.bear.list.e.k(this.f227737d, MapsKt.hashMapOf(r105)), new b(this, r111));
    L5:
        r103 = false;
        goto L6
    }
}

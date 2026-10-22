package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends com.bytedance.ee.bear.list.e<DocumentListInfo> implements r0 {
    public final String b;
    public final String c;
    public final String d;

    public static final class a implements nc5.b {
        public a() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    public static final class b implements nc5.a<DocumentListInfo> {
        public final /* synthetic */ i a;
        public final /* synthetic */ nc5.a<DocumentListInfo> b;

        @Override // nc5.a
        public final void onFailure(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            tt5.a.e(this.a.b, "createDocument network error", r4, false);
            this.b.onFailure(r4);
        }

        @Override // nc5.a
        public final void onSuccess(DocumentListInfo r3) {
            DocumentListInfo r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            tt5.a.h(this.a.b, "createDocument success");
            this.b.onSuccess(r4);
        }

        public b(i r1, nc5.a<DocumentListInfo> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<DocumentListInfo> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.list.u());
    }

    public i() {
        this.b = "CreateExecutor";
        this.c = "/space/api/explorer/v2/create/folder/";
        this.d = "/space/api/explorer/v2/create/object/";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.list.create.r0
    public final nc5.b g(String r7, String r8, nc5.a r9) {
        Intrinsics.checkNotNullParameter(r7, "name");
        Intrinsics.checkNotNullParameter("0", "source");
        Intrinsics.checkNotNullParameter(r9, "callback");
        tt5.a.h(this.b, "createFolder, name: " + r7 + ", parentToken: " + du5.b.k(r8) + ", source: 0");
        if (r7.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
    L17:
        IllegalArgumentException r10 = new IllegalArgumentException("name/source is empty");
        tt5.a.e(this.b, "createFolder param error", r10, false);
        r9.onFailure(r10);
        return new j();
    L8:
        if ("0".length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L17;
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        return l(com.bytedance.ee.bear.list.e.k(this.c, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("name", r7), TuplesKt.to("source", "0"), TuplesKt.to("parent_token", r8)})), new k(this, r9));
    L10:
        r4 = false;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.create.r0
    public final nc5.b a(int r7, String r8, String r9, String r10, nc5.a<DocumentListInfo> r11) {
        Intrinsics.checkNotNullParameter(r9, "uuid");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "callback");
        tt5.a.h(this.b, "createDocument, type: " + r7 + ", parentToken: " + du5.b.k(r8) + ", uuid: " + r9 + ", source: " + r10);
        if (r10.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        IllegalArgumentException r12 = new IllegalArgumentException("source is empty");
        tt5.a.e(this.b, "createDocument param error", r12, false);
        r11.onFailure(r12);
        return new a();
    L9:
        Pair[] r3 = new Pair[4];
        r3[0] = TuplesKt.to(ResourceData.KEY_TYPE, String.valueOf(r7));
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        r3[1] = TuplesKt.to("parent_token", r8);
        r3[2] = TuplesKt.to("uuid", r9);
        r3[3] = TuplesKt.to("source", r10);
        return l(com.bytedance.ee.bear.list.e.k(this.d, MapsKt.hashMapOf(r3)), new b(this, r11));
    L5:
        r2 = false;
        goto L6
    }
}

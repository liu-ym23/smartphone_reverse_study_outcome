package com.bytedance.ee.bear.document.restore.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements com.bytedance.ee.bear.document.restore.api.a {
    public final String b;
    public WikiCheckRestorePuller$WikiCheckRestoreResult c;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            WikiCheckRestorePuller$WikiCheckRestoreResult r5 = (WikiCheckRestorePuller$WikiCheckRestoreResult) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            boolean r1 = true;
            if (r5.can_restore == false) goto L15;
            String r0 = r5.space_id;
            if (r0 != null) goto L7;
        L10:
            boolean r2 = true;
        L11:
            if (r2 == true) goto L15;
            if (r5.target_type == 0) goto L15;
            boolean r3 = true;
        L16:
            if (r3 == false) goto L18;
            this.a.c = r5;
        L20:
            return Boolean.valueOf(r1);
        L18:
            r1 = false;
            goto L20
        L7:
            if (r0.length() == 0) goto L10;
            r2 = false;
        L15:
            r3 = false;
            goto L16
        }
    }

    @Override // com.bytedance.ee.bear.document.restore.api.a
    public final Flowable<Boolean> a() {
        String r0 = this.b;
        NetService.f r1 = new NetService.f("/space/api/wiki/v2/tree/check_node_restore/");
        r1.c = 1;
        JSONObject r2 = new JSONObject();
        r2.put("wiki_token", r0);     // Catch: Exception -> L5
    L7:
        r1.j = r2.toString();
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new r()).a(r1).map(new s()).map(new a(this));
    L5:
        e = move-exception;
        tt5.a.e("WikiCheckRestorePuller", "WikiCheckRestorePuller put params err. ", e, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.restore.api.a
    public final Flowable<RestoreFileResult> b() {
        WikiCheckRestorePuller$WikiCheckRestoreResult r0 = this.c;
        if (r0 == null) goto L28;
        if (r0.can_restore == false) goto L17;
        String r1 = r0.space_id;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L17;
        if (r0.target_type == 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L28;
        String r4 = r0.space_id;
        String r5 = this.b;
        int r6 = r0.target_type;
        NetService.f r7 = new NetService.f("/space/api/wiki/v2/tree/restore_node/");
        r7.c = 1;
        JSONObject r8 = new JSONObject();
        r8.put(DocViewModel.EXTRA_SPACE_ID, r4);     // Catch: Exception -> L23
        r8.put("wiki_token", r5);     // Catch: Exception -> L23
        r8.put("target_type", r6);     // Catch: Exception -> L23
        r8.put("need_no_perm_info", true);     // Catch: Exception -> L23
    L25:
        r7.j = r8.toString();
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new v()).a(r7).onErrorResumeNext(new b()).flatMap(new u()).onErrorResumeNext(new b());
    L23:
        e = move-exception;
        tt5.a.e("WikiRestorePuller", "WikiRestorePuller put params err. ", e, false);
        goto L25
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L17:
        r3 = false;
    L28:
        return Flowable.error(new Throwable("checkRestoreResult is Empty! "));
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "wikiToken");
        this.b = r2;
    }
}

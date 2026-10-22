package com.bytedance.ee.bear.document.restore.api;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.document.restore.api.a {
    public final String b;
    public final int c;
    public SpaceCheckRestorePuller$SpaceCheckRestoreResult d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            SpaceCheckRestorePuller$SpaceCheckRestoreResult r5 = (SpaceCheckRestorePuller$SpaceCheckRestoreResult) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            boolean r1 = true;
            if (r5.can_restore == false) goto L13;
            String r0 = r5.node_token;
            if (r0 != null) goto L7;
        L10:
            boolean r2 = true;
        L11:
            if (r2 == true) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == false) goto L16;
            this.a.d = r5;
        L18:
            return Boolean.valueOf(r1);
        L16:
            r1 = false;
            goto L18
        L7:
            if (r0.length() == 0) goto L10;
            r2 = false;
        L13:
            r3 = false;
            goto L14
        }
    }

    @Override // com.bytedance.ee.bear.document.restore.api.a
    public final Flowable<Boolean> a() {
        String r0 = this.b;
        int r1 = this.c;
        NetService.e r2 = new NetService.f("/space/api/explorer/v2/trash/check_restore/");
        r2.c = 1;
        HashMap r3 = new HashMap();
        r3.put("obj_token", r0);
        r3.put("obj_type", String.valueOf(r1));
        r2.d(r3);
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new e()).a(r2).map(new f()).map(new a(this));
    }

    @Override // com.bytedance.ee.bear.document.restore.api.a
    public final Flowable<RestoreFileResult> b() {
        SpaceCheckRestorePuller$SpaceCheckRestoreResult r0 = this.d;
        if (r0 == null) goto L20;
        boolean r2 = false;
        if (r0.can_restore == false) goto L15;
        String r1 = r0.node_token;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        r2 = true;
        goto L15
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
    L15:
        if (r2 == false) goto L20;
        String r4 = r0.node_token;
        NetService.e r5 = new NetService.f("/space/api/explorer/v2/trash/restore/");
        r5.c = 1;
        HashMap r6 = new HashMap();
        r6.put("token", r4);
        r6.put("need_no_perm_info", String.valueOf(true));
        r5.d(r6);
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new l()).a(r5).map(new m()).flatMap(new h()).map(new i()).onErrorResumeNext(new b());
    L20:
        return Flowable.error(new Throwable("checkRestoreResult is Empty! "));
    }

    public c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "objToken");
        this.b = r2;
        this.c = r3;
    }
}

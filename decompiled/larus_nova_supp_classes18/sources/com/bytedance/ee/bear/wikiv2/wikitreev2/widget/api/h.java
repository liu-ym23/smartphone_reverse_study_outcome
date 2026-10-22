package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.exception.OfflineCreateException;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ ce5.a b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(String r1, ce5.a r2, int r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object apply(Object r5) {
            OfflineDoc r6 = (OfflineDoc) r5;
            Intrinsics.checkNotNullParameter(r6, "offlineDoc");
            String r0 = this.a;
            if (r0 != null) goto L10;
            r0 = dq5.j.a(this.b);
            if (r0 != null) goto L10;
            OfflineCreateException.Companion.getClass();
            throw new OfflineCreateException(OfflineCreateException.access$getACCOUNT_EMPTY$cp());
        L10:
            if (((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).U5() == null) goto L16;
            com.bytedance.ee.bear.contract.route.parcelable.m.a r1 = new com.bytedance.ee.bear.contract.route.parcelable.m.a();
            Intrinsics.checkNotNullParameter(r0, "spaceId");
            r1.b = r0;
            r1.c = r0;
            String r2 = r6.getFakeToken();
            Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
            r1.a = r2;
            r1.f = r6.getFakeToken();
            r1.d = r6.getFakeToken();
            r1.e = this.c;
            r1.g = this.d;
            String r7 = this.e;
            if (r7 != null) goto L14;
            r7 = "";
        L14:
            Intrinsics.checkNotNullParameter(r7, "title");
            r1.i = r7;
            com.bytedance.ee.bear.contract.route.parcelable.m r8 = new com.bytedance.ee.bear.contract.route.parcelable.m(r1);
            Intrinsics.checkNotNullParameter(r8, "<this>");
            r8.k = System.currentTimeMillis() + 8.988465674311579E307d;
            return xp5.h.a(r8);
        L16:
            OfflineCreateException.Companion.getClass();
            throw new OfflineCreateException(OfflineCreateException.access$getACCOUNT_EMPTY$cp());
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<TreeNode> a(String r8, String r9, String r10, int r11, ce5.a r12) {
        Intrinsics.checkNotNullParameter(r12, "userComponentAbility");
        if (r9 != null) goto L5;
        String r0 = "";
    L7:
        return q0.a(r11, r0, true, true).map(new a(r8, r12, r11, r9, r10));
    L5:
        r0 = r9;
        goto L7
    }
}

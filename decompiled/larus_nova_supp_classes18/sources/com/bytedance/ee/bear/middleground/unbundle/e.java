package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public long a;

    public static final class a {
    }

    public static final class b<T extends Result> implements NetService.c {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final Result<BenefitStore> parse(String r6) {
            JSONObject r0 = new JSONObject(r6);
            int r7 = JSONObjectProtectorUtils.getInt(r0, "code");
            String r1 = JSONObjectProtectorUtils.getString(r0, "msg");
            if (r7 != 0) goto L6;
            String r2 = JSONObjectProtectorUtils.getString(r0, WikiFolderPushPlugin.DATA);
            tt5.a.h("Benefit_UserBenefitFetcher", "sourceBenefit: " + r2);
            NonProguard r3 = BenefitStore.b.b(BenefitStore.Companion, this.a, r2, BenefitStore.FROM_SERVER);
            Result<BenefitStore> r4 = new Result();
            r4.data = r3;
            r4.code = r7;
            r4.msg = r1;
            return r4;
        L6:
            tt5.a.d("Benefit_UserBenefitFetcher", r1);
            throw new NetService.HttpErrorException(r7, r1);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i<BenefitStore> a;

        public c(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Result r4 = (Result) r3;
            tt5.a.h("Benefit_UserBenefitFetcher", "fetchUserBenefit...  result.size is " + ((BenefitStore) r4.data).getBenefitMap().size());
            i<BenefitStore> r0 = this.a;
            kotlin.Result.Companion r1 = kotlin.Result.Companion;
            r0.resumeWith(kotlin.Result.constructor-impl(r4.data));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ i<BenefitStore> a;

        public d(j r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.resumeWith(kotlin.Result.constructor-impl(null));
            this.a.cancel(null);
            tt5.a.e("Benefit_UserBenefitFetcher", "fetchUserBenefit... error: ", (Throwable) r4, false);
        }
    }

    static {
    }

    public e() {
        this.a = -3600000;
    }

    public final Object a(NetService r8, String r9, Continuation<? super BenefitStore> r10) throws Exception {
        tt5.a.h("Benefit_UserBenefitFetcher", "fetchUserBenefit...  userId is " + r9);
        monitor-enter(this);
        long r1 = System.currentTimeMillis() - this.a;     // Catch: Throwable -> L22
        if (r1 >= 3600000) goto L9;
        tt5.a.h("Benefit_UserBenefitFetcher", "fetchUserBenefit... currentTimeMillis - updateTime is " + r1);     // Catch: Throwable -> L22
        monitor-exit(this);
        boolean r0 = false;
    L13:
        if (r0 == true) goto L15;
        return null;
    L15:
        j r2 = new j(IntrinsicsKt.intercepted(r10), 1);
        r2.C();
        NetService.f r3 = new NetService.f("/space/api/benefit/my");
        Map r4 = ((NetService.e) r3).e;
        String r5 = String.valueOf(((b0) org.koin.java.a.c(b0.class, null, null, 6)).getAppId());
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        ((HashMap) r4).put("app_id", r5);
        ((HashMap) ((NetService.e) r3).e).put("pull_item_names", "unbundle_doc_benefit,unbundle_doc_benefit,unbundle_wiki_benefit,unbundle_base_benefit");
        ((HashMap) ((NetService.e) r3).e).put("platform", "android");
        ((HashMap) ((NetService.e) r3).e).put("version", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getVersionName());
        r8.Vc(new b(r9)).a(r3).subscribe(new c(r2), new d(r2));
        Object r11 = r2.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L21:
        return r11;
    L9:
        this.a = System.currentTimeMillis();     // Catch: Throwable -> L22
        monitor-exit(this);
        r0 = true;
    L22:
        th = move-exception;
        throw th;
    }
}

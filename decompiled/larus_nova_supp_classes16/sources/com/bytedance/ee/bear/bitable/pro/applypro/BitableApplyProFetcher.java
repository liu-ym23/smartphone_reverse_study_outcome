package com.bytedance.ee.bear.bitable.pro.applypro;

import ax4.f;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableApplyProFetcher {
    public final String a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher$ApplyPermissionCode;", "Lcom/bytedance/ee/util/io/NonProguard;", "permissionCode", "", "<init>", "(I)V", "getPermissionCode", "()I", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ApplyPermissionCode implements NonProguard {
        public static final int ALLOW = 0;
        public static final a Companion = null;
        public static final int DENY = 1;
        private final int permissionCode;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public ApplyPermissionCode() {
            int r2 = 0;
            this(r2, 1, null);
        }

        public final int getPermissionCode() {
            return this.permissionCode;
        }

        public ApplyPermissionCode(int r1) {
            this.permissionCode = r1;
        }

        public /* synthetic */ ApplyPermissionCode(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher$ApplyPermissionCodeResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher$ApplyPermissionCode;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ApplyPermissionCodeResult extends Result<ApplyPermissionCode> {
        public ApplyPermissionCodeResult() {
        }
    }

    public static final class a implements NetService.c<ApplyPermissionCodeResult> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher$a$a, reason: collision with other inner class name */
        public static final class C0015a {
        }

        static {
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r5) {
            ApplyPermissionCodeResult r0 = new ApplyPermissionCodeResult();
            if (r5 != null) goto L17;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == false) goto L13;
            tt5.a.d("ApplyPermissionCodeParser", "json is null or empty");     // Catch: Exception -> L8
        L16:
            return r0;
        L13:
            r0.data = new ApplyPermissionCode(JSON.parseObject(r5).getJSONObject("data").getIntValue("applyPermissionCode"));     // Catch: Exception -> L8
            goto L16
        L17:
        L8:
            e = move-exception;
            tt5.a.e("ApplyPermissionCodeParser", "parse error", e, false);
            goto L16
        L5:
            if (r5.length() == 0) goto L10;
            r3 = false;
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    public final Flowable<ApplyPermissionCodeResult> b() {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        NetService.f r1 = new NetService.f(String.format("/space/api/bitable/permission/%s/apply_permission_code", Arrays.copyOf(new Object[]{this.a}, 1)));
        r1.b("uid", ((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).getUserId());
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new a()).a(r1);
    }

    public BitableApplyProFetcher(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        this.a = r2;
    }

    public final Flowable<SimpleRequestResult> a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "note");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        NetService.f r2 = new NetService.f(String.format("/space/api/bitable/permission/%s/apply", Arrays.copyOf(new Object[]{this.a}, 1)));
        r2.c = 1;
        JSONObject r1 = new JSONObject();
        r1.put("message", r5);
        r2.j = r1.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r2);
    }
}

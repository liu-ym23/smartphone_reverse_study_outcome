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

/* JADX INFO: loaded from: classes16.dex */
public final class BitableApplyProFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f215125a;

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
            int r100 = 0;
            this(r100, 1, null);
        }

        public final int getPermissionCode() {
            return this.permissionCode;
        }

        public ApplyPermissionCode(int r100) {
            this.permissionCode = r100;
        }

        public /* synthetic */ ApplyPermissionCode(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = 0;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher$ApplyPermissionCodeResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher$ApplyPermissionCode;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ApplyPermissionCodeResult extends Result<ApplyPermissionCode> {
        public ApplyPermissionCodeResult() {
        }
    }

    public static final class a implements NetService.c<ApplyPermissionCodeResult> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher$a$a, reason: collision with other inner class name */
        public static final class C3071a {
        }

        static {
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            ApplyPermissionCodeResult r101 = new ApplyPermissionCodeResult();
            if (r100 != null) goto L17;
        L10:
            boolean r102 = true;
        L11:
            if (r102 == false) goto L13;
            tt5.a.d("ApplyPermissionCodeParser", "json is null or empty");     // Catch: Exception -> L8
        L16:
            return r101;
        L13:
            r101.data = new ApplyPermissionCode(JSON.parseObject(r100).getJSONObject("data").getIntValue("applyPermissionCode"));     // Catch: Exception -> L8
            goto L16
        L17:
        L8:
            e = move-exception;
            tt5.a.e("ApplyPermissionCodeParser", "parse error", e, false);
            goto L16
        L5:
            if (r100.length() == 0) goto L10;
            r102 = false;
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    public final Flowable<ApplyPermissionCodeResult> b() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        NetService.f r101 = new NetService.f(String.format("/space/api/bitable/permission/%s/apply_permission_code", Arrays.copyOf(new Object[]{this.f215125a}, 1)));
        r101.b("uid", ((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).getUserId());
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new a()).a(r101);
    }

    public BitableApplyProFetcher(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f215125a = r100;
    }

    public final Flowable<SimpleRequestResult> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        NetService.f r102 = new NetService.f(String.format("/space/api/bitable/permission/%s/apply", Arrays.copyOf(new Object[]{this.f215125a}, 1)));
        r102.f216906c = 1;
        JSONObject r103 = new JSONObject();
        r103.put("message", r100);
        r102.f216913j = r103.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r102);
    }
}

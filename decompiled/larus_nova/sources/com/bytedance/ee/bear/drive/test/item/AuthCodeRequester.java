package com.bytedance.ee.bear.drive.test.item;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class AuthCodeRequester {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService.d<Result<AuthCodeResult>> f224649a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/test/item/AuthCodeRequester$AuthCodeResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "uploadCode", "", "getUploadCode", "()Ljava/lang/String;", "setUploadCode", "(Ljava/lang/String;)V", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthCodeResult implements NonProguard {
        private String uploadCode;

        public AuthCodeResult() {
        }

        public final String getUploadCode() {
            return this.uploadCode;
        }

        public final void setUploadCode(String r100) {
            this.uploadCode = r100;
        }
    }

    public static final class a implements NetService.c<Result<AuthCodeResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.test.item.AuthCodeRequester$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/drive/test/item/AuthCodeRequester$AuthCodeResultParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/drive/test/item/AuthCodeRequester$AuthCodeResult;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3226a extends TypeToken<Result<AuthCodeResult>> {
            public C3226a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AuthCodeResult> parse(String r100) throws NetService.ParseException {
            Intrinsics.checkNotNullParameter(r100, "json");
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new C3226a().getType());
        }
    }

    public static final class b {
    }

    static {
    }

    public AuthCodeRequester() {
        this.f224649a = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new a());
    }
}

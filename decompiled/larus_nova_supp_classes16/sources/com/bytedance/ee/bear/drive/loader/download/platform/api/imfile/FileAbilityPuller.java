package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import io.reactivex.Flowable;
import jcb.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller;", "", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "<init>", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "mPuller", "Lcom/bytedance/ee/bear/contract/NetService$Puller;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Result;", "pull", "Lio/reactivex/Flowable;", "params", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Params;", "buildRequest", "Lcom/bytedance/ee/bear/contract/NetService$SimpleRequest;", "path", "", "Companion", "AbilityParser", "Params", "Result", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileAbilityPuller {
    public static final Companion Companion = null;
    private static final String REQUEST_URL = "/api/file/ability/";
    private static final String TAG = "FileAbilityPuller";
    private final NetService.d<com.bytedance.ee.bear.contract.Result<Result>> mPuller;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$AbilityParser;", "Lcom/bytedance/ee/bear/contract/NetService$Parser;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Result;", "<init>", "()V", "parse", "json", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AbilityParser implements NetService.c<com.bytedance.ee.bear.contract.Result<Result>> {
        public AbilityParser() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public com.bytedance.ee.bear.contract.Result<Result> parse(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            com.bytedance.ee.bear.contract.Result<Result> r0 = new com.bytedance.ee.bear.contract.Result();
            Result r1 = new Result();     // Catch: JSONException -> L5
            JSONObject r2 = new JSONObject(r4);     // Catch: JSONException -> L5
            r0.msg = r2.optString("msg");     // Catch: JSONException -> L5
            r0.code = r2.optInt("code");     // Catch: JSONException -> L5
            r1.setAbility(r2.optInt("ability"));     // Catch: JSONException -> L5
            r1.setPermission(r2.optInt("permission"));     // Catch: JSONException -> L5
            r0.data = r1;     // Catch: JSONException -> L5
            return r0;
        L5:
            e = move-exception;
            a.f(FileAbilityPuller.TAG, e, false);
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_URL", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller$Params;", "<init>", "()V", "fileToken", "", "getFileToken", "()Ljava/lang/String;", "setFileToken", "(Ljava/lang/String;)V", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params extends BasePuller.Params {
        private String fileToken;

        public Params() {
            this.fileToken = "";
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final void setFileToken(String r1) {
            this.fileToken = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/imfile/FileAbilityPuller$Result;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller$Result;", "<init>", "()V", "ability", "", "getAbility", "()I", "setAbility", "(I)V", "permission", "getPermission", "setPermission", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Result extends BasePuller.Result {
        private int ability;
        private int permission;

        public Result() {
        }

        public final int getAbility() {
            return this.ability;
        }

        public final int getPermission() {
            return this.permission;
        }

        public final void setAbility(int r1) {
            this.ability = r1;
        }

        public final void setPermission(int r1) {
            this.permission = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FileAbilityPuller(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.mPuller = r2.Vc(new AbilityParser());
    }

    public final Flowable<Result> pull(Params r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        NetService.f<?> r3 = buildRequest(REQUEST_URL, r2);
        NetService.d<com.bytedance.ee.bear.contract.Result<Result>> r0 = this.mPuller;
        if (r0 == null) goto L7;
        Flowable<R> r4 = r0.a(r3);
        if (r4 == 0) goto L7;
        return r4.map(AnonymousClass1.INSTANCE);
    L7:
        return null;
    }

    private final NetService.f<?> buildRequest(String r2, Params r3) {
        String r4 = r2 + r3.getFileToken();
        a.h(TAG, "buildRequest, requestPath=" + r4);
        NetService.f<?> r5 = new NetService.f(r4);
        r5.a = b.c().a("file");
        r5.i = false;
        r5.c = 2;
        return r5;
    }
}

package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class BaseAppFirstScreenDataFetcher extends com.bytedance.ee.bear.bitable.chameleon.render.a<Payload, a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f209748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f209749d;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/chameleon/render/fetcher/BaseAppFirstScreenDataFetcher$Payload;", "Lcom/bytedance/ee/util/io/NonProguard;", "data", "Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;", "requestStart", "", "apiCode", "", "errorMsg", "", "xttLogId", "error", "", "<init>", "(Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getData", "()Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;", "getRequestStart", "()J", "getApiCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getXttLogId", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Payload implements NonProguard {
        private final int apiCode;
        private final BitableAppData data;
        private final Throwable error;
        private final String errorMsg;
        private final long requestStart;
        private final String xttLogId;

        public static /* synthetic */ Payload copy$default(Payload r100, BitableAppData r101, long r102, int r103, String r110, String r111, Throwable r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.requestStart;
        L8:
            long r104 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.apiCode;
        L11:
            int r115 = r103;
            if ((r113 & 8) == 0) goto L14;
            r110 = r100.errorMsg;
        L14:
            String r105 = r110;
            if ((r113 & 16) == 0) goto L17;
            r111 = r100.xttLogId;
        L17:
            String r106 = r111;
            if ((r113 & 32) == 0) goto L20;
            r112 = r100.error;
        L20:
            BitableAppData r107 = r101;
            return r100.copy(r107, r104, r115, r105, r106, r112);
        }

        public final BitableAppData component1() {
            return this.data;
        }

        public final long component2() {
            return this.requestStart;
        }

        public final int component3() {
            return this.apiCode;
        }

        public final String component4() {
            return this.errorMsg;
        }

        public final String component5() {
            return this.xttLogId;
        }

        public final Throwable component6() {
            return this.error;
        }

        public final Payload copy(BitableAppData r110, long r111, int r112, String r113, String r114, Throwable r115) {
            Intrinsics.checkNotNullParameter(r113, "errorMsg");
            Intrinsics.checkNotNullParameter(r114, "xttLogId");
            return new Payload(r110, r111, r112, r113, r114, r115);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Payload) == true) goto L8;
            return false;
        L8:
            Payload r101 = (Payload) r100;
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
            return false;
        L12:
            if (this.requestStart == r101.requestStart) goto L15;
            return false;
        L15:
            if (this.apiCode == r101.apiCode) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.xttLogId, r101.xttLogId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.error, r101.error) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            BitableAppData r100 = this.data;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            long r103 = this.requestStart;
            int r104 = ((((((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.apiCode) * 31) + this.errorMsg.hashCode()) * 31) + this.xttLogId.hashCode()) * 31;
            Throwable r105 = this.error;
            if (r105 == null) goto L11;
            r101 = r105.hashCode();
        L11:
            return r104 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Payload(data=" + this.data + ", requestStart=" + this.requestStart + ", apiCode=" + this.apiCode + ", errorMsg=" + this.errorMsg + ", xttLogId=" + this.xttLogId + ", error=" + this.error + ')';
        }

        public final int getApiCode() {
            return this.apiCode;
        }

        public final BitableAppData getData() {
            return this.data;
        }

        public final Throwable getError() {
            return this.error;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final long getRequestStart() {
            return this.requestStart;
        }

        public final String getXttLogId() {
            return this.xttLogId;
        }

        public Payload(BitableAppData r100, long r101, int r102, String r103, String r104, Throwable r105) {
            Intrinsics.checkNotNullParameter(r103, "errorMsg");
            Intrinsics.checkNotNullParameter(r104, "xttLogId");
            this.data = r100;
            this.requestStart = r101;
            this.apiCode = r102;
            this.errorMsg = r103;
            this.xttLogId = r104;
            this.error = r105;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f209750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f209751b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f209750a, r101.f209750a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f209751b, r101.f209751b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f209750a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f209751b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Request(token=" + this.f209750a + ", pageID=" + this.f209751b + ')';
        }

        public a(String r100, String r101) {
            this.f209750a = r100;
            this.f209751b = r101;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final String c() {
        return "biz.bitable.app.getFirstScreenData";
    }

    public BaseAppFirstScreenDataFetcher() {
        this.f209748c = "";
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final boolean b(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile_native.prefetch") == false) goto L7;
        com.bytedance.ee.bear.bitable.chameleon.i r102 = com.bytedance.ee.bear.bitable.chameleon.i.f209652a;
        ChameleonPluginHost r103 = r100.f221315d;
        r102.getClass();
        if (com.bytedance.ee.bear.bitable.chameleon.i.a(r103) != BitableSubType.BaseApp) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final a e(JSONObject r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.optString("token");
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        if (r100 == null) goto L18;
        String r103 = r100.optString("pageID");
        if (r103 == null) goto L18;
        if (r103.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        r101 = r103;
        goto L18
    L14:
        r104 = false;
    L18:
        return new a(r102, r101);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final Disposable g(DocumentLoaderV3 r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "onResult");
        y3 r112 = (y3) r110.f221315d.getHostAbility(y3.class);
        WikiInfo r100 = r112.getWikiInfo();
        boolean r101 = false;
        if (r100 == null) goto L15;
        String r102 = r100.getObjToken();
        if (r102 == null) goto L15;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
    L16:
        this.f209748c = r102;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        Object r113 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r112.getUrl()), "pageId"));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r113) == false) goto L24;
        r113 = null;
    L24:
        this.f209749d = (String) r113;
        if (this.f209748c.length() != 0) goto L27;
        r101 = true;
    L27:
        if (r101 == false) goto L30;
        r111.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new Payload(null, 0, -1, "Token is empty", "", new IllegalStateException("Token is empty")), null));
        return Disposables.empty();
    L30:
        long r105 = System.currentTimeMillis();
        tt5.a.h("AppFirstScreenDataFetcher", "startFetch: pageID=" + this.f209749d);
        int r114 = com.bytedance.ee.bear.bitable.preload.net.a.f215015a;
        return com.bytedance.ee.bear.bitable.preload.net.a.a(this.f209748c, this.f209749d).subscribe(new f(r111, r105, this), new g(r111, this, r105));
    L19:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L9:
        r103 = false;
    L15:
        r102 = r112.getToken();
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final void a(com.bytedance.ee.bear.document.render.node.e r100, com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<Payload> r101, List<com.bytedance.ee.bear.bitable.chameleon.render.a.b<a>> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r110, "callbacks");
        Iterator<T> r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L34;
        com.bytedance.ee.bear.bitable.chameleon.render.a.b r111 = (com.bytedance.ee.bear.bitable.chameleon.render.a.b) r102.next();
        Payload r103 = r101.f209673a;
        Throwable r104 = r101.f209674b;
        if (r104 != null) goto L10;
        if (r103 == null) goto L9;
        r104 = r103.getError();
        goto L10
    L9:
        r104 = null;
    L10:
        if (r103 == null) goto L12;
        BitableAppData r105 = r103.getData();
    L14:
        if (r105 == null) goto L19;
        if (r104 != null) goto L19;
        if (Intrinsics.areEqual(((a) r111.f209675a).f209750a, r105.getToken()) == true) goto L19;
        h.a(false, r103, "Token not match", null, r111.f209676b);
    L19:
        if (r105 == null) goto L26;
        if (r104 != null) goto L26;
        String r106 = ((a) r111.f209675a).f209751b;
        if (r106 == null) goto L26;
        if (Intrinsics.areEqual(r106, r105.getPageID()) == true) goto L26;
        h.a(false, r103, "PageID not match", null, r111.f209676b);
    L26:
        if (r105 == null) goto L29;
        if (r104 != null) goto L29;
        h.a(true, r103, null, r105.getDataJSON(), r111.f209676b);
    L29:
        if (r104 == null) goto L32;
        String r107 = r104.getMessage();
        if (r107 == null) goto L32;
    L33:
        h.a(false, r103, r107, null, r111.f209676b);
    L32:
        r107 = "No cached data available";
        goto L33
    L12:
        r105 = null;
        goto L14
    }
}

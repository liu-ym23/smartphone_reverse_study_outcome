package com.bytedance.ee.bear.list.thumbnail;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeThumbnailUrlRepository {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f229772c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f229773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f229774b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$DriveCdnBatchUrlResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "Lkotlin/collections/HashMap;", "<init>", "()V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DriveCdnBatchUrlResult extends Result<HashMap<String, ThumbnailUrlInfo>> {
        public DriveCdnBatchUrlResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$DriveCdnUrlResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "<init>", "()V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DriveCdnUrlResult extends Result<ThumbnailUrlInfo> {
        public DriveCdnUrlResult() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "Ljava/io/Serializable;", "url", "", "secret", "nonce", "encryptType", "", "encrypted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getUrl", "()Ljava/lang/String;", "getSecret", "getNonce", "getEncryptType", "()I", "getEncrypted", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThumbnailUrlInfo implements Serializable {
        private final int encryptType;
        private final boolean encrypted;
        private final String nonce;
        private final String secret;
        private final String url;

        public static /* synthetic */ ThumbnailUrlInfo copy$default(ThumbnailUrlInfo r100, String r101, String r102, String r103, int r104, boolean r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.url;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.secret;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.nonce;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.encryptType;
        L14:
            int r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.encrypted;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.secret;
        }

        public final String component3() {
            return this.nonce;
        }

        public final int component4() {
            return this.encryptType;
        }

        public final boolean component5() {
            return this.encrypted;
        }

        public final ThumbnailUrlInfo copy(String r100, String r101, String r110, int r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "url");
            return new ThumbnailUrlInfo(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ThumbnailUrlInfo) == true) goto L8;
            return false;
        L8:
            ThumbnailUrlInfo r101 = (ThumbnailUrlInfo) r100;
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.secret, r101.secret) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.nonce, r101.nonce) == true) goto L18;
            return false;
        L18:
            if (this.encryptType == r101.encryptType) goto L21;
            return false;
        L21:
            if (this.encrypted == r101.encrypted) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = this.url.hashCode() * 31;
            String r101 = this.secret;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.nonce;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (((r104 + r102) * 31) + this.encryptType) * 31;
            if (this.encrypted == false) goto L13;
            int r107 = 1231;
        L15:
            return r106 + r107;
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "ThumbnailUrlInfo(url=" + this.url + ", secret=" + this.secret + ", nonce=" + this.nonce + ", encryptType=" + this.encryptType + ", encrypted=" + this.encrypted + ')';
        }

        public final int getEncryptType() {
            return this.encryptType;
        }

        public final boolean getEncrypted() {
            return this.encrypted;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSecret() {
            return this.secret;
        }

        public final String getUrl() {
            return this.url;
        }

        public ThumbnailUrlInfo(String r100, String r101, String r102, int r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.url = r100;
            this.secret = r101;
            this.nonce = r102;
            this.encryptType = r103;
            this.encrypted = r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "<init>", "()V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThumbnailUrlResult extends Result<ThumbnailUrlInfo> {
        public ThumbnailUrlResult() {
        }
    }

    public interface a {
        void onFailure(Throwable r100);

        void onSuccess(Map<String, ThumbnailUrlInfo> r100);
    }

    public interface b {
        void cancel();
    }

    public static final class c {
        public static String a(Document r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = r100.f227873d;
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.append(r102);
            r101.append('#');
            r101.append(r100.getType());
            r101.append('#');
            r101.append(r100.M1);
            r101.append('#');
            String r104 = r100.f227891p;
            if (r104 == null) goto L9;
            r103 = r104;
        L9:
            r101.append(r103);
            return r101.toString();
        }

        public static String b(Document r100) {
            com.bytedance.ee.bear.list.thumbnail.b.a r101 = com.bytedance.ee.bear.list.thumbnail.b.b(r100);
            if (r101 == null) goto L6;
            String r102 = r101.f229786a;
            if (r102 == null) goto L6;
            return r102;
        L6:
            String r103 = r100.f227873d;
            if (r103 != null) goto L11;
            return "";
        L11:
            return r103;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Disposable f229775a;

        @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.b
        public final void cancel() {
            this.f229775a.dispose();
        }

        public d(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "disposable");
            this.f229775a = r100;
        }
    }

    public static final class e implements NetService.c<DriveCdnBatchUrlResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f229776a;

        public e(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "fileTokens");
            this.f229776a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r110) {
            Intrinsics.checkNotNullParameter(r110, "json");
            com.bytedance.ee.bear.list.thumbnail.a r100 = com.bytedance.ee.bear.list.thumbnail.a.f229782a;
            List<String> r101 = this.f229776a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r110, "json");
            Intrinsics.checkNotNullParameter(r101, "fileTokens");
            JSONObject r102 = new JSONObject(r110);
            JSONArray r111 = r102.optJSONArray("data");
            HashMap r103 = new HashMap();
            String r104 = null;
            if (r111 == null) goto L46;
            int r105 = r111.length();
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L27;
            JSONObject r112 = r111.optJSONObject(r106);
            if (r112 == null) goto L25;
            if (r112.optBoolean("permitted", true) == false) goto L25;
            String r107 = r112.optString("file_token");
            Intrinsics.checkNotNull(r107);
            if ((!StringsKt.isBlank(r107)) == true) goto L17;
            r107 = null;
        L17:
            if (r107 == null) goto L25;
            if (r101.contains(r107) == false) goto L25;
            ThumbnailUrlInfo r108 = com.bytedance.ee.bear.list.thumbnail.a.a(r112);
            if (r108 == null) goto L25;
            r103.put(r107, r108);
        L25:
            r106 = r106 + 1;
            goto L6
        L27:
            if (r101.size() != 1) goto L46;
            if (r103.isEmpty() == false) goto L46;
            if (r111.length() != 1) goto L46;
            JSONObject r113 = r111.optJSONObject(0);
            if (r113 == null) goto L35;
            String r109 = r113.optString("file_token");
        L36:
            if (r109 != null) goto L38;
            r109 = "";
        L38:
            if (r113 == null) goto L46;
            if (StringsKt.isBlank(r109) == false) goto L46;
            if (r113.optBoolean("permitted", true) == false) goto L46;
            ThumbnailUrlInfo r114 = com.bytedance.ee.bear.list.thumbnail.a.a(r113);
            if (r114 == null) goto L46;
            r103.put(CollectionsKt.first(r101), r114);
            goto L46
        L35:
            r109 = null;
        L46:
            int r115 = r102.optInt("code");
            String r116 = r102.optString("msg");
            Intrinsics.checkNotNull(r116);
            if ((true ^ StringsKt.isBlank(r116)) == false) goto L50;
            r104 = r116;
        L50:
            if (r104 != null) goto L52;
            r104 = r102.optString("message");
        L52:
            Intrinsics.checkNotNull(r104);
            Intrinsics.checkNotNullParameter(r104, "message");
            Intrinsics.checkNotNullParameter(r103, "infos");
            DriveCdnBatchUrlResult r117 = new DriveCdnBatchUrlResult();
            r117.code = r115;
            r117.msg = r104;
            r117.data = r103;
            return r117;
        }
    }

    public static final class f implements NetService.c<DriveCdnUrlResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f229777a;

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileToken");
            this.f229777a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r110) {
            Intrinsics.checkNotNullParameter(r110, "json");
            com.bytedance.ee.bear.list.thumbnail.a r100 = com.bytedance.ee.bear.list.thumbnail.a.f229782a;
            String r101 = this.f229777a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r110, "json");
            Intrinsics.checkNotNullParameter(r101, "fileToken");
            JSONObject r102 = new JSONObject(r110);
            JSONArray r111 = r102.optJSONArray("data");
            ThumbnailUrlInfo r103 = null;
            if (r111 != null) goto L5;
        L29:
            JSONObject r104 = null;
        L30:
            int r112 = r102.optInt("code");
            String r105 = r102.optString("msg");
            Intrinsics.checkNotNull(r105);
            if ((!StringsKt.isBlank(r105)) == true) goto L35;
            r105 = null;
        L35:
            if (r105 != null) goto L37;
            r105 = r102.optString("message");
        L37:
            Intrinsics.checkNotNull(r105);
            if (r104 != null) goto L40;
        L45:
            Intrinsics.checkNotNullParameter(r105, "message");
            DriveCdnUrlResult r106 = new DriveCdnUrlResult();
            r106.code = r112;
            r106.msg = r105;
            r106.data = r103;
            return r106;
        L40:
            if (r104.optBoolean("permitted", true) == true) goto L43;
            r104 = null;
        L43:
            if (r104 == null) goto L45;
            com.bytedance.ee.bear.list.thumbnail.a.f229782a.getClass();
            r103 = com.bytedance.ee.bear.list.thumbnail.a.a(r104);
            goto L45
        L5:
            if (r111.length() == 0) goto L29;
            int r107 = r111.length();
            int r108 = 0;
        L9:
            if (r108 >= r107) goto L18;
            r104 = r111.optJSONObject(r108);
            if (r104 == null) goto L16;
            if (Intrinsics.areEqual(r104.optString("file_token"), r101) == true) goto L30;
        L16:
            r108 = r108 + 1;
            goto L9
        L18:
            if (r111.length() != 1) goto L29;
            r104 = r111.optJSONObject(0);
            if (r104 == null) goto L22;
            String r113 = r104.optString("file_token");
        L23:
            if (r113 != null) goto L25;
            r113 = "";
        L25:
            if (r104 == null) goto L29;
            if (StringsKt.isBlank(r113) == false) goto L29;
        L22:
            r113 = null;
            goto L23
        }
    }

    public static final class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f229778a = null;

        static {
            f229778a = new g();
        }

        public g() {
        }

        @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.b
        public final void cancel() {
        }
    }

    public interface h {
        void a(ThumbnailUrlInfo r100);

        void onFailure(Throwable r100);
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Document f229779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f229780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f229781c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f229779a, r101.f229779a) == true) goto L12;
            return false;
        L12:
            if (this.f229780b == r101.f229780b) goto L15;
            return false;
        L15:
            if (this.f229781c == r101.f229781c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f229779a.hashCode() * 31) + this.f229780b) * 31) + this.f229781c;
        }

        public final String toString() {
            return "ThumbnailRequest(document=" + this.f229779a + ", width=" + this.f229780b + ", height=" + this.f229781c + ')';
        }

        public i(Document r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "document");
            this.f229779a = r100;
            this.f229780b = r101;
            this.f229781c = r102;
        }
    }

    public static final class j implements NetService.c<ThumbnailUrlResult> {
        public j() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            JSONObject r101 = new JSONObject(r100);
            ThumbnailUrlResult r102 = new ThumbnailUrlResult();
            r102.code = r101.optInt("code");
            r102.msg = r101.optString("msg");
            JSONObject r103 = r101.optJSONObject("data");
            if (r103 == null) goto L17;
            String r104 = r103.optString("url");
            String r105 = r103.optString("decrypt_key");
            Intrinsics.checkNotNull(r105);
            String r106 = null;
            if ((!StringsKt.isBlank(r105)) == false) goto L7;
            String r107 = r105;
        L8:
            String r108 = r103.optString("decrypt_nonce");
            Intrinsics.checkNotNull(r108);
            if ((!StringsKt.isBlank(r108)) == true) goto L12;
            r108 = null;
        L12:
            if (r108 != null) goto L15;
            r108 = r103.optString("nonce");
            Intrinsics.checkNotNull(r108);
            if ((!StringsKt.isBlank(r108)) == true) goto L15;
        L16:
            r102.data = new ThumbnailUrlInfo(r104, r107, r106, r103.optInt("decrypt_type"), !TextUtils.isEmpty(r103.optString("decrypt_key")));
        L15:
            r106 = r108;
            goto L16
        L7:
            r107 = null;
        L17:
            return r102;
        }
    }

    static {
        f229772c = SetsKt.setOf(new String[]{"doc", DocumentType.DOCX_NAME, ExportFileExtension.PDF, "ppt", ExportFileExtension.PPTX, "xls", "xlsx"});
    }

    public OfficeThumbnailUrlRepository() {
        NetService r100 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        b0 r101 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "infoProvideService");
        this.f229773a = r100;
        this.f229774b = r101;
    }

    public static JSONArray c(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        i r103 = (i) r102.next();
        JSONObject r104 = new JSONObject();
        r104.put("file_token", c.b(r103.f229779a));
        r104.put("policy", "allow_up");
        r104.put("height", 360);
        r104.put("width", 360);
        r101.put(r104);
        goto L4
    L6:
        return r101;
    }

    public final HashMap<String, ThumbnailUrlInfo> a(List<i> r100, Map<String, ThumbnailUrlInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "requests");
        Intrinsics.checkNotNullParameter(r101, "cdnInfos");
        Function3<Document, Integer, Integer, ThumbnailUrlInfo> r102 = new OfficeThumbnailUrlRepository$buildBatchResultWithCoverFallback$1(this);
        HashMap<String, ThumbnailUrlInfo> r103 = new HashMap();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        i r105 = (i) r104.next();
        String r106 = c.a(r105.f229779a);
        ThumbnailUrlInfo r107 = r101.get(c.b(r105.f229779a));
        if (r107 != null) goto L8;
        r107 = r102.invoke(r105.f229779a, Integer.valueOf(r105.f229780b), Integer.valueOf(r105.f229781c));
    L8:
        r103.put(r106, r107);
        goto L4
    L9:
        return r103;
    }

    public final ThumbnailUrlInfo b(Document r100, int r101, int r110) {
        String r102 = this.f229774b.r();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L15;
        String r104 = this.f229773a.getConfig().f216903a;
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        String r105 = StringsKt.trimEnd(r104, new char[]{'/'});
    L16:
        Integer r106 = Integer.valueOf(r101);
        if (r106.intValue() <= 0) goto L19;
        boolean r107 = true;
    L20:
        Integer r108 = null;
        if (r107 == true) goto L24;
        r106 = null;
    L24:
        int r109 = 240;
        if (r106 == null) goto L27;
        int r111 = r106.intValue();
    L28:
        Integer r112 = Integer.valueOf(r110);
        if (r112.intValue() <= 0) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L34;
        r108 = r112;
    L34:
        if (r108 == null) goto L37;
        r109 = r108.intValue();
    L37:
        return new ThumbnailUrlInfo(StringsKt.trimEnd(r105, new char[]{'/'}) + "/space/api/box/stream/download/v2/cover/" + c.b(r100) + "?width=" + r111 + "&height=" + r109 + "&policy=allow_up", null, null, 0, false);
    L31:
        r113 = false;
        goto L32
    L27:
        r111 = 240;
        goto L28
    L19:
        r107 = false;
        goto L20
    L15:
        r105 = "https://" + r102;
        goto L16
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L10
    }
}

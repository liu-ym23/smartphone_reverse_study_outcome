package com.bytedance.ee.bear.list.thumbnail;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeThumbnailUrlRepository {
    public static final Set<String> c = null;
    public final NetService a;
    public final b0 b;

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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "Ljava/io/Serializable;", ResourceData.KEY_URL, "", "secret", "nonce", "encryptType", "", "encrypted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getUrl", "()Ljava/lang/String;", "getSecret", "getNonce", "getEncryptType", "()I", "getEncrypted", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThumbnailUrlInfo implements Serializable {
        private final int encryptType;
        private final boolean encrypted;
        private final String nonce;
        private final String secret;
        private final String url;

        public static /* synthetic */ ThumbnailUrlInfo copy$default(ThumbnailUrlInfo r3, String r4, String r5, String r6, int r7, boolean r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.url;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.secret;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.nonce;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.encryptType;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.encrypted;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
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

        public final ThumbnailUrlInfo copy(String r8, String r9, String r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_URL);
            return new ThumbnailUrlInfo(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ThumbnailUrlInfo) == true) goto L8;
            return false;
        L8:
            ThumbnailUrlInfo r6 = (ThumbnailUrlInfo) r5;
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.secret, r6.secret) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.nonce, r6.nonce) == true) goto L18;
            return false;
        L18:
            if (this.encryptType == r6.encryptType) goto L21;
            return false;
        L21:
            if (this.encrypted == r6.encrypted) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.url.hashCode() * 31;
            String r1 = this.secret;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.nonce;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (((r4 + r2) * 31) + this.encryptType) * 31;
            if (this.encrypted == false) goto L13;
            int r7 = 1231;
        L15:
            return r6 + r7;
        L13:
            r7 = 1237;
            goto L15
        L5:
            r3 = r1.hashCode();
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

        public ThumbnailUrlInfo(String r2, String r3, String r4, int r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
            this.url = r2;
            this.secret = r3;
            this.nonce = r4;
            this.encryptType = r5;
            this.encrypted = r6;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/list/thumbnail/OfficeThumbnailUrlRepository$ThumbnailUrlInfo;", "<init>", "()V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThumbnailUrlResult extends Result<ThumbnailUrlInfo> {
        public ThumbnailUrlResult() {
        }
    }

    public interface a {
        void onFailure(Throwable r1);

        void onSuccess(Map<String, ThumbnailUrlInfo> r1);
    }

    public interface b {
        void cancel();
    }

    public static final class c {
        public static String a(Document r4) {
            StringBuilder r0 = new StringBuilder();
            String r1 = r4.d;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.append(r1);
            r0.append('#');
            r0.append(r4.getType());
            r0.append('#');
            r0.append(r4.M1);
            r0.append('#');
            String r5 = r4.p;
            if (r5 == null) goto L9;
            r2 = r5;
        L9:
            r0.append(r2);
            return r0.toString();
        }

        public static String b(Document r1) {
            com.bytedance.ee.bear.list.thumbnail.b.a r0 = com.bytedance.ee.bear.list.thumbnail.b.b(r1);
            if (r0 == null) goto L6;
            String r2 = r0.a;
            if (r2 == null) goto L6;
            return r2;
        L6:
            String r3 = r1.d;
            if (r3 != null) goto L11;
            return "";
        L11:
            return r3;
        }
    }

    public static final class d implements b {
        public final Disposable a;

        @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.b
        public final void cancel() {
            this.a.dispose();
        }

        public d(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "disposable");
            this.a = r2;
        }
    }

    public static final class e implements NetService.c<DriveCdnBatchUrlResult> {
        public final List<String> a;

        public e(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "fileTokens");
            this.a = r2;
        }

        public final Result parse(String r12) {
            Intrinsics.checkNotNullParameter(r12, "json");
            com.bytedance.ee.bear.list.thumbnail.a r1 = com.bytedance.ee.bear.list.thumbnail.a.a;
            List<String> r2 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r12, "json");
            Intrinsics.checkNotNullParameter(r2, "fileTokens");
            JSONObject r0 = new JSONObject(r12);
            JSONArray r13 = r0.optJSONArray(WikiFolderPushPlugin.DATA);
            HashMap r3 = new HashMap();
            String r4 = null;
            if (r13 == null) goto L46;
            int r5 = r13.length();
            int r7 = 0;
        L6:
            if (r7 >= r5) goto L27;
            JSONObject r10 = r13.optJSONObject(r7);
            if (r10 == null) goto L25;
            if (r10.optBoolean("permitted", true) == false) goto L25;
            String r8 = r10.optString("file_token");
            Intrinsics.checkNotNull(r8);
            if ((!StringsKt.isBlank(r8)) == true) goto L17;
            r8 = null;
        L17:
            if (r8 == null) goto L25;
            if (r2.contains(r8) == false) goto L25;
            ThumbnailUrlInfo r9 = com.bytedance.ee.bear.list.thumbnail.a.a(r10);
            if (r9 == null) goto L25;
            r3.put(r8, r9);
        L25:
            r7 = r7 + 1;
            goto L6
        L27:
            if (r2.size() != 1) goto L46;
            if (r3.isEmpty() == false) goto L46;
            if (r13.length() != 1) goto L46;
            JSONObject r14 = r13.optJSONObject(0);
            if (r14 == null) goto L35;
            String r6 = r14.optString("file_token");
        L36:
            if (r6 != null) goto L38;
            r6 = "";
        L38:
            if (r14 == null) goto L46;
            if (StringsKt.isBlank(r6) == false) goto L46;
            if (r14.optBoolean("permitted", true) == false) goto L46;
            ThumbnailUrlInfo r15 = com.bytedance.ee.bear.list.thumbnail.a.a(r14);
            if (r15 == null) goto L46;
            r3.put(CollectionsKt.first(r2), r15);
            goto L46
        L35:
            r6 = null;
        L46:
            int r16 = r0.optInt("code");
            String r11 = r0.optString("msg");
            Intrinsics.checkNotNull(r11);
            if ((true ^ StringsKt.isBlank(r11)) == false) goto L50;
            r4 = r11;
        L50:
            if (r4 != null) goto L52;
            r4 = r0.optString("message");
        L52:
            Intrinsics.checkNotNull(r4);
            Intrinsics.checkNotNullParameter(r4, "message");
            Intrinsics.checkNotNullParameter(r3, "infos");
            DriveCdnBatchUrlResult r17 = new DriveCdnBatchUrlResult();
            ((Result) r17).code = r16;
            ((Result) r17).msg = r4;
            ((Result) r17).data = r3;
            return r17;
        }
    }

    public static final class f implements NetService.c<DriveCdnUrlResult> {
        public final String a;

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            this.a = r2;
        }

        public final Result parse(String r10) {
            Intrinsics.checkNotNullParameter(r10, "json");
            com.bytedance.ee.bear.list.thumbnail.a r1 = com.bytedance.ee.bear.list.thumbnail.a.a;
            String r2 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r10, "json");
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            JSONObject r0 = new JSONObject(r10);
            JSONArray r11 = r0.optJSONArray(WikiFolderPushPlugin.DATA);
            ThumbnailUrlInfo r3 = null;
            if (r11 != null) goto L5;
        L29:
            JSONObject r8 = null;
        L30:
            int r12 = r0.optInt("code");
            String r4 = r0.optString("msg");
            Intrinsics.checkNotNull(r4);
            if ((!StringsKt.isBlank(r4)) == true) goto L35;
            r4 = null;
        L35:
            if (r4 != null) goto L37;
            r4 = r0.optString("message");
        L37:
            Intrinsics.checkNotNull(r4);
            if (r8 != null) goto L40;
        L45:
            Intrinsics.checkNotNullParameter(r4, "message");
            DriveCdnUrlResult r5 = new DriveCdnUrlResult();
            ((Result) r5).code = r12;
            ((Result) r5).msg = r4;
            ((Result) r5).data = r3;
            return r5;
        L40:
            if (r8.optBoolean("permitted", true) == true) goto L43;
            r8 = null;
        L43:
            if (r8 == null) goto L45;
            com.bytedance.ee.bear.list.thumbnail.a.a.getClass();
            r3 = com.bytedance.ee.bear.list.thumbnail.a.a(r8);
            goto L45
        L5:
            if (r11.length() == 0) goto L29;
            int r6 = r11.length();
            int r7 = 0;
        L9:
            if (r7 >= r6) goto L18;
            r8 = r11.optJSONObject(r7);
            if (r8 == null) goto L16;
            if (Intrinsics.areEqual(r8.optString("file_token"), r2) == true) goto L30;
        L16:
            r7 = r7 + 1;
            goto L9
        L18:
            if (r11.length() != 1) goto L29;
            r8 = r11.optJSONObject(0);
            if (r8 == null) goto L22;
            String r13 = r8.optString("file_token");
        L23:
            if (r13 != null) goto L25;
            r13 = "";
        L25:
            if (r8 == null) goto L29;
            if (StringsKt.isBlank(r13) == false) goto L29;
        L22:
            r13 = null;
            goto L23
        }
    }

    public static final class g implements b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.b
        public final void cancel() {
        }
    }

    public interface h {
        void a(ThumbnailUrlInfo r1);

        void onFailure(Throwable r1);
    }

    public static final class i {
        public final Document a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "ThumbnailRequest(document=" + this.a + ", width=" + this.b + ", height=" + this.c + ')';
        }

        public i(Document r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "document");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class j implements NetService.c<ThumbnailUrlResult> {
        public j() {
        }

        public final Result parse(String r9) {
            Intrinsics.checkNotNullParameter(r9, "json");
            JSONObject r0 = new JSONObject(r9);
            ThumbnailUrlResult r10 = new ThumbnailUrlResult();
            ((Result) r10).code = r0.optInt("code");
            ((Result) r10).msg = r0.optString("msg");
            JSONObject r1 = r0.optJSONObject(WikiFolderPushPlugin.DATA);
            if (r1 == null) goto L17;
            String r3 = r1.optString(ResourceData.KEY_URL);
            String r2 = r1.optString("decrypt_key");
            Intrinsics.checkNotNull(r2);
            String r5 = null;
            if ((!StringsKt.isBlank(r2)) == false) goto L7;
            String r4 = r2;
        L8:
            String r6 = r1.optString("decrypt_nonce");
            Intrinsics.checkNotNull(r6);
            if ((!StringsKt.isBlank(r6)) == true) goto L12;
            r6 = null;
        L12:
            if (r6 != null) goto L15;
            r6 = r1.optString("nonce");
            Intrinsics.checkNotNull(r6);
            if ((!StringsKt.isBlank(r6)) == true) goto L15;
        L16:
            ((Result) r10).data = new ThumbnailUrlInfo(r3, r4, r5, r1.optInt("decrypt_type"), !TextUtils.isEmpty(r1.optString("decrypt_key")));
        L15:
            r5 = r6;
            goto L16
        L7:
            r4 = null;
        L17:
            return r10;
        }
    }

    static {
        c = SetsKt.setOf(new String[]{DocumentType.DOC_NAME, DocumentType.DOCX_NAME, ExportFileExtension.PDF, "ppt", ExportFileExtension.PPTX, "xls", "xlsx"});
    }

    public OfficeThumbnailUrlRepository() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        b0 r1 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r0, "netService");
        Intrinsics.checkNotNullParameter(r1, "infoProvideService");
        this.a = r0;
        this.b = r1;
    }

    public static JSONArray c(List r4) {
        JSONArray r0 = new JSONArray();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        i r1 = (i) r5.next();
        JSONObject r2 = new JSONObject();
        r2.put("file_token", c.b(r1.a));
        r2.put("policy", "allow_up");
        r2.put("height", 360);
        r2.put("width", 360);
        r0.put(r2);
        goto L4
    L6:
        return r0;
    }

    public final HashMap<String, ThumbnailUrlInfo> a(List<i> r7, Map<String, ThumbnailUrlInfo> r8) {
        Intrinsics.checkNotNullParameter(r7, "requests");
        Intrinsics.checkNotNullParameter(r8, "cdnInfos");
        Function3<Document, Integer, Integer, ThumbnailUrlInfo> r0 = new OfficeThumbnailUrlRepository$buildBatchResultWithCoverFallback$1(this);
        HashMap<String, ThumbnailUrlInfo> r1 = new HashMap();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        i r2 = (i) r9.next();
        String r3 = c.a(r2.a);
        ThumbnailUrlInfo r4 = r8.get(c.b(r2.a));
        if (r4 != null) goto L8;
        r4 = (ThumbnailUrlInfo) r0.invoke(r2.a, Integer.valueOf(r2.b), Integer.valueOf(r2.c));
    L8:
        r1.put(r3, r4);
        goto L4
    L9:
        return r1;
    }

    public final ThumbnailUrlInfo b(Document r8, int r9, int r10) {
        String r0 = this.b.r();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L15;
        String r1 = this.a.getConfig().a;
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        String r2 = StringsKt.trimEnd(r1, new char[]{'/'});
    L16:
        Integer r11 = Integer.valueOf(r9);
        if (r11.intValue() <= 0) goto L19;
        boolean r4 = true;
    L20:
        Integer r5 = null;
        if (r4 == true) goto L24;
        r11 = null;
    L24:
        int r6 = 240;
        if (r11 == null) goto L27;
        int r12 = r11.intValue();
    L28:
        Integer r13 = Integer.valueOf(r10);
        if (r13.intValue() <= 0) goto L31;
        boolean r7 = true;
    L32:
        if (r7 == false) goto L34;
        r5 = r13;
    L34:
        if (r5 == null) goto L37;
        r6 = r5.intValue();
    L37:
        return new ThumbnailUrlInfo(StringsKt.trimEnd(r2, new char[]{'/'}) + "/space/api/box/stream/download/v2/cover/" + c.b(r8) + "?width=" + r12 + "&height=" + r6 + "&policy=allow_up", null, null, 0, false);
    L31:
        r7 = false;
        goto L32
    L27:
        r12 = 240;
        goto L28
    L19:
        r4 = false;
        goto L20
    L15:
        r2 = "https://" + r0;
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L10
    }
}

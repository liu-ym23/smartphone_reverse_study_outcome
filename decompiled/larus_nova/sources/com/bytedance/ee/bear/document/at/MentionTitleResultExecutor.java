package com.bytedance.ee.bear.document.at;

import android.net.Uri;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class MentionTitleResultExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f219086a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/at/MentionTitleResultExecutor$BatchMentionTitleResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/at/MentionData;", "Lkotlin/collections/HashMap;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BatchMentionTitleResult extends Result<HashMap<String, MentionData>> {
        public BatchMentionTitleResult() {
        }
    }

    public MentionTitleResultExecutor() {
    }

    static {
        f219086a = MapsKt.mapOf(TuplesKt.to(DocumentType.DOCX_WHITE_BOARD_NAME, 38));
    }

    public static final MentionData a(BearUrl r100, MentionData r101) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == false) goto L47;
        int r102 = sbb.e.g(r100.f222560a);
        if (sbb.g.b(r102) == false) goto L48;
        if (r101 != null) goto L10;
    L44:
        return null;
    L10:
        if (r101.type != r102) goto L44;
        String r103 = r101.title;
        boolean r104 = true;
        boolean r105 = false;
        if (r103 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L44;
        String r107 = r101.url;
        if (r107 != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == true) goto L43;
        Uri r109 = UriProtector.parse(r107);
        if (Intrinsics.areEqual(r109.getScheme(), "http") == false) goto L31;
    L32:
        String r110 = r109.getHost();
        if (r110 != null) goto L35;
    L38:
        boolean r111 = true;
    L39:
        if (r111 == false) goto L42;
    L41:
        r104 = false;
    L42:
        r105 = r104;
        goto L43
    L35:
        if (StringsKt.isBlank(r110) == true) goto L38;
        r111 = false;
        goto L39
    L31:
        if (Intrinsics.areEqual(r109.getScheme(), "https") == false) goto L41;
    L43:
        if (r105 == false) goto L44;
        return r101;
    L22:
        if (StringsKt.isBlank(r107) == true) goto L25;
        r108 = false;
        goto L26
    L14:
        if (StringsKt.isBlank(r103) == true) goto L17;
        r106 = false;
        goto L18
    L48:
        return r101;
    L47:
        return r101;
    }
}

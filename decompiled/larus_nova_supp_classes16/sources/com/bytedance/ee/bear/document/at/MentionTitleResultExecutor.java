package com.bytedance.ee.bear.document.at;

import android.net.Uri;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class MentionTitleResultExecutor {
    public static final Map<String, Integer> a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/at/MentionTitleResultExecutor$BatchMentionTitleResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/at/MentionData;", "Lkotlin/collections/HashMap;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BatchMentionTitleResult extends Result<HashMap<String, MentionData>> {
        public BatchMentionTitleResult() {
        }
    }

    public MentionTitleResultExecutor() {
    }

    static {
        a = MapsKt.mapOf(TuplesKt.to("whiteboard", 38));
    }

    public static final MentionData a(BearUrl r4, MentionData r5) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == false) goto L47;
        int r6 = sbb.e.g(r4.a);
        if (sbb.g.b(r6) == false) goto L48;
        if (r5 != null) goto L10;
    L44:
        return null;
    L10:
        if (r5.type != r6) goto L44;
        String r7 = r5.title;
        boolean r0 = true;
        boolean r1 = false;
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L44;
        String r9 = r5.url;
        if (r9 != null) goto L22;
    L25:
        boolean r2 = true;
    L26:
        if (r2 == true) goto L43;
        Uri r10 = UriProtector.parse(r9);
        if (Intrinsics.areEqual(r10.getScheme(), "http") == false) goto L31;
    L32:
        String r11 = r10.getHost();
        if (r11 != null) goto L35;
    L38:
        boolean r12 = true;
    L39:
        if (r12 == false) goto L42;
    L41:
        r0 = false;
    L42:
        r1 = r0;
        goto L43
    L35:
        if (StringsKt.isBlank(r11) == true) goto L38;
        r12 = false;
        goto L39
    L31:
        if (Intrinsics.areEqual(r10.getScheme(), "https") == false) goto L41;
    L43:
        if (r1 == false) goto L44;
        return r5;
    L22:
        if (StringsKt.isBlank(r9) == true) goto L25;
        r2 = false;
        goto L26
    L14:
        if (StringsKt.isBlank(r7) == true) goto L17;
        r8 = false;
        goto L18
    L48:
        return r5;
    L47:
        return r5;
    }
}

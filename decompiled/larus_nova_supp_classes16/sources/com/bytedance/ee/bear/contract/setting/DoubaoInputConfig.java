package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "ccm_mobile_doubao_ai_config")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR \u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/DoubaoInputConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "documentConfig", "", "", "Lcom/bytedance/ee/bear/contract/setting/DoubaoInputDocumentAccessConfig;", "isEnabled", "", "documentType", "Lcom/bytedance/ee/bear/contract/setting/DoubaoInputDocumentType;", "isEnterprise", "Companion", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoInputConfig implements NonProguard {
    public static final a Companion = null;

    @SerializedName("document_config")
    private Map<String, DoubaoInputDocumentAccessConfig> documentConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DoubaoInputConfig() {
    }

    public final boolean isEnabled(DoubaoInputDocumentType r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "documentType");
        Map<String, DoubaoInputDocumentAccessConfig> r0 = this.documentConfig;
        if (r0 == null) goto L19;
        Set<Map.Entry<String, DoubaoInputDocumentAccessConfig>> r1 = r0.entrySet();
        if (r1 == null) goto L19;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (StringsKt.equals((String) ((Map.Entry) r3).getKey(), r6.getConfigValue(), true) == false) goto L8;
    L13:
        Map.Entry r4 = (Map.Entry) r3;
        if (r4 == null) goto L19;
        DoubaoInputDocumentAccessConfig r8 = (DoubaoInputDocumentAccessConfig) r4.getValue();
        if (r8 == null) goto L19;
        return r8.isEnabled(r7);
    L12:
        r3 = null;
    L19:
        return true;
    }
}

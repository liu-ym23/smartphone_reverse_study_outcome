package com.bytedance.ee.bear.clip.handlers;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipReportHandler implements f<ReportData, LarkWebView> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipReportHandler$ReportData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "eventName", "", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "data", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReportData implements NonProguard {
        private Map<String, ? extends Object> data;
        private String eventName;

        public ReportData() {
        }

        public String toString() {
            return "event: " + this.eventName + ", params: " + du5.b.f(this.data) + ')';
        }

        public final Map<String, Object> getData() {
            return this.data;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final void setData(Map<String, ? extends Object> r1) {
            this.data = r1;
        }

        public final void setEventName(String r1) {
            this.eventName = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public ClipReportHandler() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        ReportData r5 = (ReportData) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        tt5.a.h("DocsClip#ClipReportHandler", String.valueOf(r5));
        boolean r6 = false;
        if (r5 == null) goto L12;
        String r7 = r5.getEventName();
        if (r7 == null) goto L12;
        if (r7.length() <= 0) goto L9;
        boolean r8 = true;
    L10:
        if (r8 != true) goto L12;
        r6 = true;
        goto L12
    L9:
        r8 = false;
    L12:
        if (r6 == false) goto L15;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n(r5.getEventName(), r5.getData());
        return;
    }
}

package com.bytedance.ee.bear.clip.handlers;

import at5.f;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipOpenUrlHandler implements f<UrlData, LarkWebView> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipOpenUrlHandler$UrlData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UrlData implements NonProguard {
        private String url;

        public UrlData() {
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("UrlData(url=");
            String r1 = this.url;
            if (r1 != null) goto L5;
            r1 = null;
        L5:
            r0.append(du5.b.f(r1));
            r0.append(')');
            return r0.toString();
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public ClipOpenUrlHandler() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        UrlData r5 = (UrlData) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        tt5.a.h("DocsClip#ClipOpenUrlHandler", "open url, data = " + r5);
        if (r5 == null) goto L15;
        String r6 = r5.getUrl();
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L16;
        h r8 = (h) org.koin.java.a.c(h.class, null, null, 6);
        String r9 = r5.getUrl();
        Intrinsics.checkNotNull(r9);
        r8.u5(r9);
        return;
    L16:
        return;
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
        goto L11
    }
}

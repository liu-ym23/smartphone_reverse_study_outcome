package com.bytedance.ee.bear.clip.handlers;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipLogHandler implements f<LogData, LarkWebView> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipLogHandler$LogData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogData implements NonProguard {
        private int level;
        private String msg;
        private String tag;

        public String toString() {
            return "LogData(level=" + this.level + ", tag='" + this.tag + "', msg='" + this.msg + "')";
        }

        public LogData() {
            this.tag = "";
            this.msg = "";
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final String getTag() {
            return this.tag;
        }

        public final void setLevel(int r1) {
            this.level = r1;
        }

        public final void setMsg(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.msg = r2;
        }

        public final void setTag(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.tag = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public ClipLogHandler() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void a(Object r3, at5.d r4, String r5, LarkWebView r6) {
        LogData r7 = (LogData) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r7 != null) goto L23;
        tt5.a.d("DocsClip#ClipLogHandler", "handle()... data is null");
        return;
    L23:
        int r8 = r7.getLevel();     // Catch: Exception -> L20
        if (r8 != 0) goto L9;
        tt5.a.b("DocsClip#" + r7.getTag(), r7.getMsg());     // Catch: Exception -> L20
    L22:
        return;
    L9:
        if (r8 != 1) goto L11;
        tt5.a.h("DocsClip#" + r7.getTag(), r7.getMsg());     // Catch: Exception -> L20
        goto L22
    L11:
        if (r8 != 2) goto L13;
        tt5.a.k("DocsClip#" + r7.getTag(), r7.getMsg());     // Catch: Exception -> L20
        goto L22
    L13:
        if (r8 == 3) goto L15;
        tt5.a.d("DocsClip#ClipLogHandler", "unknown log level! data = " + r7);     // Catch: Exception -> L20
        goto L22
    L15:
        tt5.a.d("DocsClip#" + r7.getTag(), r7.getMsg());     // Catch: Exception -> L20
    L20:
        tt5.a.d("DocsClip#ClipLogHandler", "log is sensitive! data = " + r7);
    }
}

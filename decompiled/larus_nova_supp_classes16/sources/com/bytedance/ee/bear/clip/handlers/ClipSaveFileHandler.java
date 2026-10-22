package com.bytedance.ee.bear.clip.handlers;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipSaveFileHandler implements f<SaveFileData, LarkWebView> {
    public long a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipSaveFileHandler$SaveFileData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "partId", "", "getPartId", "()I", "setPartId", "(I)V", "totalPart", "getTotalPart", "setTotalPart", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SaveFileData implements NonProguard {
        private String content;
        private String fileName;
        private int partId;
        private int totalPart;

        public SaveFileData() {
            this.totalPart = 1;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final int getPartId() {
            return this.partId;
        }

        public final int getTotalPart() {
            return this.totalPart;
        }

        public final void setContent(String r1) {
            this.content = r1;
        }

        public final void setFileName(String r1) {
            this.fileName = r1;
        }

        public final void setPartId(int r1) {
            this.partId = r1;
        }

        public final void setTotalPart(int r1) {
            this.totalPart = r1;
        }
    }

    public static final class a {
    }

    static {
    }

    public ClipSaveFileHandler() {
    }

    public final boolean shouldRunInUIThread() {
        return false;
    }

    public final void a(Object r11, at5.d r12, String r13, LarkWebView r14) {
        SaveFileData r16 = (SaveFileData) r11;
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r16 != null) goto L5;
        tt5.a.d("DocsClip#ClipSaveFileHandler", "handle()... data is null!");
        return;
    L5:
        StringBuilder r0 = new StringBuilder("save file, fileName = ");
        r0.append(r16.getFileName());
        r0.append(", content length = ");
        String r1 = r16.getContent();
        if (r1 == null) goto L8;
        int r2 = r1.length();
    L9:
        r0.append(r2);
        r0.append(", partId = ");
        r0.append(r16.getPartId());
        r0.append(", totalPart = ");
        r0.append(r16.getTotalPart());
        tt5.a.h("DocsClip#ClipSaveFileHandler", r0.toString());
        String r3 = r16.getFileName();
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L60;
        String r5 = r16.getContent();
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        return;
    L26:
        if (r16.getPartId() >= 0) goto L28;
        return;
    L28:
        if (r16.getPartId() >= r16.getTotalPart()) goto L63;
        String r7 = r16.getFileName();
        if (r7 != null) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == false) goto L64;
        VFSFile r9 = com.bytedance.ee.bear.clip.a.e();
        if (r9.exists() == true) goto L41;
        r9.mkdirs();
    L41:
        h r10 = ay4.d.a();
        String r17 = r16.getFileName();
        if (r17 == null) goto L65;
        VFSFile r18 = r10.D(r9, r17);
        long r19 = System.currentTimeMillis();     // Catch: Exception -> L54
        if (r16.getPartId() != 0) goto L48;
        this.a = 0;     // Catch: Exception -> L54
        FileUtils.c(r9.getVfsPath());     // Catch: Exception -> L54
        String r20 = r16.getContent();     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r20);     // Catch: Exception -> L54
        FilesKt.writeText$default(r18, r20, null, 2, null);     // Catch: Exception -> L54
    L49:
        this.a += System.currentTimeMillis() - r19;     // Catch: Exception -> L54
        if (r16.getPartId() != (r16.getTotalPart() - 1)) goto L52;
        int r110 = cw4.a.a;     // Catch: Exception -> L54
        cw4.a.a("write_file", this.a, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("file_size", Long.valueOf(r18.length()))}));     // Catch: Exception -> L54
    L52:
        r12.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("res", Boolean.TRUE)}));     // Catch: Exception -> L54
        return;
    L48:
        String r21 = r16.getContent();     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r21);     // Catch: Exception -> L54
        FilesKt.appendText$default(r18, r21, null, 2, null);     // Catch: Exception -> L54
    L54:
        e = move-exception;
        tt5.a.e("DocsClip#ClipSaveFileHandler", "saveFile failed!", e, false);
        r12.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("res", Boolean.FALSE)}));
        return;
    L65:
        return;
    L64:
        return;
    L33:
        if (StringsKt.contains$default(r7, "../", false, 2, null) == true) goto L35;
        r8 = true;
        goto L36
    L63:
        return;
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
        goto L24
    L60:
        return;
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = 0;
        goto L9
    }
}

package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/Cursor;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "position", "", "getPosition", "()Ljava/lang/String;", "setPosition", "(Ljava/lang/String;)V", "previous_text", "getPrevious_text", "setPrevious_text", "after_text", "getAfter_text", "setAfter_text", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Cursor implements NonProguard {
    private String after_text;
    private String position;
    private String previous_text;

    public Cursor() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("cursor(position=");
        r0.append(this.position);
        r0.append(", previous_text.length=");
        String r1 = this.previous_text;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.length());
    L6:
        r0.append(r3);
        r0.append(", after_text.length=");
        String r4 = this.after_text;
        if (r4 == null) goto L9;
        r2 = Integer.valueOf(r4.length());
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public final String getAfter_text() {
        return this.after_text;
    }

    public final String getPosition() {
        return this.position;
    }

    public final String getPrevious_text() {
        return this.previous_text;
    }

    public final void setAfter_text(String r1) {
        this.after_text = r1;
    }

    public final void setPosition(String r1) {
        this.position = r1;
    }

    public final void setPrevious_text(String r1) {
        this.previous_text = r1;
    }
}

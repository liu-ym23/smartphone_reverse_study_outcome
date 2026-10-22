package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010/\u001a\u00020\u0012H\u0016J\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012012\u0006\u00102\u001a\u000203R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/DocContext;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "selected_text", "Lcom/bytedance/ee/bear/document/ai/myai/SelectedText;", "getSelected_text", "()Lcom/bytedance/ee/bear/document/ai/myai/SelectedText;", "setSelected_text", "(Lcom/bytedance/ee/bear/document/ai/myai/SelectedText;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "cursor", "Lcom/bytedance/ee/bear/document/ai/myai/Cursor;", "getCursor", "()Lcom/bytedance/ee/bear/document/ai/myai/Cursor;", "setCursor", "(Lcom/bytedance/ee/bear/document/ai/myai/Cursor;)V", "previous_text", "Lcom/bytedance/ee/bear/document/ai/myai/PreviousText;", "getPrevious_text", "()Lcom/bytedance/ee/bear/document/ai/myai/PreviousText;", "setPrevious_text", "(Lcom/bytedance/ee/bear/document/ai/myai/PreviousText;)V", "doc_meta", "Lcom/bytedance/ee/bear/document/ai/myai/DocMeta;", "getDoc_meta", "()Lcom/bytedance/ee/bear/document/ai/myai/DocMeta;", "setDoc_meta", "(Lcom/bytedance/ee/bear/document/ai/myai/DocMeta;)V", "permission", "Lcom/bytedance/ee/bear/document/ai/myai/Permission;", "getPermission", "()Lcom/bytedance/ee/bear/document/ai/myai/Permission;", "setPermission", "(Lcom/bytedance/ee/bear/document/ai/myai/Permission;)V", "toString", "getMutableMap", "", "hacContent", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocContext implements NonProguard {
    private String content;
    private Cursor cursor;
    private DocMeta doc_meta;
    private Permission permission;
    private PreviousText previous_text;
    private SelectedText selected_text;
    private Long timestamp;

    public DocContext() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DocContext(timestamp=");
        r0.append(this.timestamp);
        r0.append(", selected_text=");
        r0.append(this.selected_text);
        r0.append(", content.length=");
        String r1 = this.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", cursor=");
        r0.append(this.cursor);
        r0.append(", previous_text=");
        r0.append(this.previous_text);
        r0.append(", doc_meta=");
        r0.append(this.doc_meta);
        r0.append(", permission=");
        r0.append(this.permission);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final Cursor getCursor() {
        return this.cursor;
    }

    public final DocMeta getDoc_meta() {
        return this.doc_meta;
    }

    public final Permission getPermission() {
        return this.permission;
    }

    public final PreviousText getPrevious_text() {
        return this.previous_text;
    }

    public final SelectedText getSelected_text() {
        return this.selected_text;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Map<String, String> getMutableMap(boolean r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Long r1 = this.timestamp;
        if (r1 == null) goto L5;
        String r2 = (String) r0.put("timestamp", String.valueOf(r1.longValue()));
    L5:
        SelectedText r3 = this.selected_text;
        if (r3 == null) goto L8;
        String r4 = (String) r0.put("selected_text", GsonProtectorUtils.toJson(new Gson(), r3));
    L8:
        String r6 = this.content;
        if (r6 == null) goto L12;
        if (r5 == false) goto L12;
        r0.put("content", r6);
    L12:
        Cursor r7 = this.cursor;
        if (r7 == null) goto L15;
        String r8 = (String) r0.put("cursor", GsonProtectorUtils.toJson(new Gson(), r7));
    L15:
        PreviousText r9 = this.previous_text;
        if (r9 == null) goto L18;
        String r10 = (String) r0.put("previous_text", GsonProtectorUtils.toJson(new Gson(), r9));
    L18:
        DocMeta r11 = this.doc_meta;
        if (r11 == null) goto L21;
        String r12 = (String) r0.put("doc_meta", GsonProtectorUtils.toJson(new Gson(), r11));
    L21:
        Permission r13 = this.permission;
        if (r13 == null) goto L24;
        r0.put("permission", GsonProtectorUtils.toJson(new Gson(), r13));
    L24:
        return r0;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setCursor(Cursor r1) {
        this.cursor = r1;
    }

    public final void setDoc_meta(DocMeta r1) {
        this.doc_meta = r1;
    }

    public final void setPermission(Permission r1) {
        this.permission = r1;
    }

    public final void setPrevious_text(PreviousText r1) {
        this.previous_text = r1;
    }

    public final void setSelected_text(SelectedText r1) {
        this.selected_text = r1;
    }

    public final void setTimestamp(Long r1) {
        this.timestamp = r1;
    }
}

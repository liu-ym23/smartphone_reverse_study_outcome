package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.multilevel;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020&H\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/multilevel/MultiLevelContent;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/BaseContent;", "<init>", "()V", "summary", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "Lkotlin/collections/ArrayList;", "getSummary", "()Ljava/util/ArrayList;", "setSummary", "(Ljava/util/ArrayList;)V", "subAvatarUrl", "", "getSubAvatarUrl", "()Ljava/lang/String;", "setSubAvatarUrl", "(Ljava/lang/String;)V", "subName", "getSubName", "setSubName", "subUserId", "getSubUserId", "setSubUserId", "translateContent", "getTranslateContent", "setTranslateContent", "targetLanguage", "getTargetLanguage", "setTargetLanguage", "translateStatus", "getTranslateStatus", "setTranslateStatus", "equals", "", "other", "", "hashCode", "", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiLevelContent extends BaseContent {
    private String subAvatarUrl;
    private String subName;
    private String subUserId;
    private ArrayList<TextContext> summary;
    private String targetLanguage;
    private ArrayList<TextContext> translateContent;
    private String translateStatus;

    public MultiLevelContent() {
        this.translateStatus = "default";
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent, com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        ArrayList<TextContext> r1 = this.summary;
        Object[] r2 = null;
        if (r1 == null) goto L5;
        Object[] r3 = r1.toArray();
    L6:
        int r4 = (r0 + Arrays.hashCode(r3)) * 31;
        String r5 = this.subAvatarUrl;
        int r6 = 0;
        if (r5 == null) goto L9;
        int r7 = r5.hashCode();
    L10:
        int r8 = (r4 + r7) * 31;
        String r9 = this.subName;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.subUserId;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        ArrayList<TextContext> r15 = this.translateContent;
        if (r15 == null) goto L21;
        r2 = r15.toArray();
    L21:
        int r16 = (r14 + Arrays.hashCode(r2)) * 31;
        String r17 = this.targetLanguage;
        if (r17 == null) goto L25;
        r6 = r17.hashCode();
    L25:
        return ((r16 + r6) * 31) + this.translateStatus.hashCode();
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final String getSubAvatarUrl() {
        return this.subAvatarUrl;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final String getSubUserId() {
        return this.subUserId;
    }

    public final ArrayList<TextContext> getSummary() {
        return this.summary;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final ArrayList<TextContext> getTranslateContent() {
        return this.translateContent;
    }

    public final String getTranslateStatus() {
        return this.translateStatus;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent, com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof MultiLevelContent) == true) goto L9;
        return false;
    L9:
        if (super.equals(r6) == true) goto L11;
        return false;
    L11:
        ArrayList<TextContext> r1 = this.summary;
        Object[] r3 = null;
        if (r1 == null) goto L14;
        Object[] r2 = r1.toArray();
    L15:
        MultiLevelContent r7 = (MultiLevelContent) r6;
        ArrayList<TextContext> r4 = r7.summary;
        if (r4 == null) goto L18;
        Object[] r5 = r4.toArray();
    L20:
        if (Arrays.equals(r2, r5) == true) goto L22;
        return false;
    L22:
        ArrayList<TextContext> r8 = this.translateContent;
        if (r8 == null) goto L25;
        Object[] r9 = r8.toArray();
    L26:
        ArrayList<TextContext> r10 = r7.translateContent;
        if (r10 == null) goto L30;
        r3 = r10.toArray();
    L30:
        if (Arrays.equals(r9, r3) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subAvatarUrl, r7.subAvatarUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.subName, r7.subName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.subUserId, r7.subUserId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.targetLanguage, r7.targetLanguage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.translateStatus, r7.translateStatus) == true) goto L47;
        return false;
    L47:
        return true;
    L25:
        r9 = null;
        goto L26
    L18:
        r5 = null;
        goto L20
    L14:
        r2 = null;
        goto L15
    }

    public final void setSubAvatarUrl(String r1) {
        this.subAvatarUrl = r1;
    }

    public final void setSubName(String r1) {
        this.subName = r1;
    }

    public final void setSubUserId(String r1) {
        this.subUserId = r1;
    }

    public final void setSummary(ArrayList<TextContext> r1) {
        this.summary = r1;
    }

    public final void setTargetLanguage(String r1) {
        this.targetLanguage = r1;
    }

    public final void setTranslateContent(ArrayList<TextContext> r1) {
        this.translateContent = r1;
    }

    public final void setTranslateStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.translateStatus = r2;
    }
}

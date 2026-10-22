package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/normal/NormalContent;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/BaseContent;", "<init>", "()V", "summary", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "Lkotlin/collections/ArrayList;", "getSummary", "()Ljava/util/ArrayList;", "setSummary", "(Ljava/util/ArrayList;)V", "translateContent", "getTranslateContent", "setTranslateContent", "targetLanguage", "", "getTargetLanguage", "()Ljava/lang/String;", "setTargetLanguage", "(Ljava/lang/String;)V", "translateStatus", "getTranslateStatus", "setTranslateStatus", "equals", "", "other", "", "hashCode", "", "Companion", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalContent extends BaseContent {
    public static final a Companion = null;
    public static final String TRANSLATE_STATUS_ERROR = "error";
    public static final String TRANSLATE_STATUS_TRANSLATED = "success";
    public static final String TRANSLATE_STATUS_TRANSLATING = "loading";
    public static final String TRANSLATE_STATUS_UNKNOWN = "default";
    private ArrayList<TextContext> summary;
    private String targetLanguage;
    private ArrayList<TextContext> translateContent;
    private String translateStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NormalContent() {
        this.translateStatus = "default";
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent, com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ArrayList<TextContext> r101 = this.summary;
        Object[] r102 = null;
        if (r101 == null) goto L5;
        Object[] r103 = r101.toArray();
    L6:
        int r104 = (r100 + Arrays.hashCode(r103)) * 31;
        ArrayList<TextContext> r105 = this.translateContent;
        if (r105 == null) goto L9;
        r102 = r105.toArray();
    L9:
        int r106 = (r104 + Arrays.hashCode(r102)) * 31;
        String r107 = this.targetLanguage;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L14:
        return ((r106 + r108) * 31) + this.translateStatus.hashCode();
    L12:
        r108 = 0;
        goto L14
    L5:
        r103 = null;
        goto L6
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
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NormalContent) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        ArrayList<TextContext> r101 = this.summary;
        Object[] r102 = null;
        if (r101 == null) goto L14;
        Object[] r103 = r101.toArray();
    L15:
        NormalContent r104 = (NormalContent) r100;
        ArrayList<TextContext> r105 = r104.summary;
        if (r105 == null) goto L18;
        Object[] r106 = r105.toArray();
    L20:
        if (Arrays.equals(r103, r106) == true) goto L22;
        return false;
    L22:
        ArrayList<TextContext> r107 = this.translateContent;
        if (r107 == null) goto L25;
        Object[] r108 = r107.toArray();
    L26:
        ArrayList<TextContext> r109 = r104.translateContent;
        if (r109 == null) goto L30;
        r102 = r109.toArray();
    L30:
        if (Arrays.equals(r108, r102) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.targetLanguage, r104.targetLanguage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.translateStatus, r104.translateStatus) == true) goto L38;
        return false;
    L38:
        return true;
    L25:
        r108 = null;
        goto L26
    L18:
        r106 = null;
        goto L20
    L14:
        r103 = null;
        goto L15
    }

    public final void setSummary(ArrayList<TextContext> r100) {
        this.summary = r100;
    }

    public final void setTargetLanguage(String r100) {
        this.targetLanguage = r100;
    }

    public final void setTranslateContent(ArrayList<TextContext> r100) {
        this.translateContent = r100;
    }

    public final void setTranslateStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.translateStatus = r100;
    }
}

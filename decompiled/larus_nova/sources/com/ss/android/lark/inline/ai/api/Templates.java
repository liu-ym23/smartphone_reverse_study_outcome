package com.ss.android.lark.inline.ai.api;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/Templates;", "Ljava/io/Serializable;", "templatePrefix", "", "templateList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/Template;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getTemplatePrefix", "()Ljava/lang/String;", "setTemplatePrefix", "(Ljava/lang/String;)V", "getTemplateList", "()Ljava/util/ArrayList;", "setTemplateList", "(Ljava/util/ArrayList;)V", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Templates implements Serializable {
    private ArrayList<Template> templateList;
    private String templatePrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Templates copy$default(Templates r100, String r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.templatePrefix;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.templateList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.templatePrefix;
    }

    public final ArrayList<Template> component2() {
        return this.templateList;
    }

    public final Templates copy(String r100, ArrayList<Template> r101) {
        Intrinsics.checkNotNullParameter(r100, "templatePrefix");
        Intrinsics.checkNotNullParameter(r101, "templateList");
        return new Templates(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Templates) == true) goto L8;
        return false;
    L8:
        Templates r101 = (Templates) r100;
        if (Intrinsics.areEqual(this.templatePrefix, r101.templatePrefix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateList, r101.templateList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.templatePrefix.hashCode() * 31) + this.templateList.hashCode();
    }

    public String toString() {
        return "Templates(templatePrefix='" + this.templatePrefix + "', templateList=" + this.templateList + ')';
    }

    public final ArrayList<Template> getTemplateList() {
        return this.templateList;
    }

    public final String getTemplatePrefix() {
        return this.templatePrefix;
    }

    public final void setTemplateList(ArrayList<Template> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateList = r100;
    }

    public final void setTemplatePrefix(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templatePrefix = r100;
    }

    public Templates(String r100, ArrayList<Template> r101) {
        Intrinsics.checkNotNullParameter(r100, "templatePrefix");
        Intrinsics.checkNotNullParameter(r101, "templateList");
        this.templatePrefix = r100;
        this.templateList = r101;
    }
}

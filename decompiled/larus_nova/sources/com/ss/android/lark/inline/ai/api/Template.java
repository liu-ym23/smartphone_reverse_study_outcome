package com.ss.android.lark.inline.ai.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/Template;", "Ljava/io/Serializable;", "templateName", "", "placeHolder", "key", "defaultUserInput", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTemplateName", "()Ljava/lang/String;", "setTemplateName", "(Ljava/lang/String;)V", "getPlaceHolder", "setPlaceHolder", "getKey", "setKey", "getDefaultUserInput", "setDefaultUserInput", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Template implements Serializable {
    private String defaultUserInput;
    private String key;
    private String placeHolder;
    private String templateName;

    public static /* synthetic */ Template copy$default(Template r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.templateName;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.placeHolder;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.key;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.defaultUserInput;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.templateName;
    }

    public final String component2() {
        return this.placeHolder;
    }

    public final String component3() {
        return this.key;
    }

    public final String component4() {
        return this.defaultUserInput;
    }

    public final Template copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "templateName");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "defaultUserInput");
        return new Template(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Template) == true) goto L8;
        return false;
    L8:
        Template r101 = (Template) r100;
        if (Intrinsics.areEqual(this.templateName, r101.templateName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.placeHolder, r101.placeHolder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultUserInput, r101.defaultUserInput) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.templateName.hashCode() * 31;
        String r101 = this.placeHolder;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.key.hashCode()) * 31) + this.defaultUserInput.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Template(templateName='" + this.templateName + "', placeHolder=" + this.placeHolder + ", key='" + this.key + "')";
    }

    public final String getDefaultUserInput() {
        return this.defaultUserInput;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final void setDefaultUserInput(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultUserInput = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setPlaceHolder(String r100) {
        this.placeHolder = r100;
    }

    public final void setTemplateName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateName = r100;
    }

    public Template(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "templateName");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "defaultUserInput");
        this.templateName = r100;
        this.placeHolder = r101;
        this.key = r102;
        this.defaultUserInput = r103;
    }

    public /* synthetic */ Template(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "";
    L8:
        this(r100, r101, r102, r103);
    }
}

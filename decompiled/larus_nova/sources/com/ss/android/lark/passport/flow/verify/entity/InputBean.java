package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/InputBean;", "Ljava/io/Serializable;", GXTemplateKey.GAIAX_PLACEHOLDER, "", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputBean implements Serializable {
    private final String label;
    private final String placeholder;

    /* JADX WARN: Multi-variable type inference failed */
    public InputBean() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InputBean copy$default(InputBean r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.placeholder;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.label;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.placeholder;
    }

    public final String component2() {
        return this.label;
    }

    public final InputBean copy(@JSONField(name = GXTemplateKey.GAIAX_PLACEHOLDER) String r100, @JSONField(name = "label") String r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_PLACEHOLDER);
        Intrinsics.checkNotNullParameter(r101, "label");
        return new InputBean(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputBean) == true) goto L8;
        return false;
    L8:
        InputBean r101 = (InputBean) r100;
        if (Intrinsics.areEqual(this.placeholder, r101.placeholder) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.placeholder.hashCode() * 31) + this.label.hashCode();
    }

    public String toString() {
        return "InputBean(placeholder=" + this.placeholder + ", label=" + this.label + ')';
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public InputBean(@JSONField(name = GXTemplateKey.GAIAX_PLACEHOLDER) String r100, @JSONField(name = "label") String r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_PLACEHOLDER);
        Intrinsics.checkNotNullParameter(r101, "label");
        this.placeholder = r100;
        this.label = r101;
    }

    public /* synthetic */ InputBean(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}

package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/MoTextBean;", "Ljava/io/Serializable;", "title", "", "content", "button", "Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;)V", "getTitle", "()Ljava/lang/String;", "getContent", "getButton", "()Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoTextBean implements Serializable {
    private final ButtonBean button;
    private final String content;
    private final String title;

    public static /* synthetic */ MoTextBean copy$default(MoTextBean r100, String r101, String r102, ButtonBean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.button;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final ButtonBean component3() {
        return this.button;
    }

    public final MoTextBean copy(@JSONField(name = "title") String r100, @JSONField(name = "content") String r101, @JSONField(name = "button") ButtonBean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        return new MoTextBean(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MoTextBean) == true) goto L8;
        return false;
    L8:
        MoTextBean r101 = (MoTextBean) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.title.hashCode() * 31) + this.content.hashCode()) * 31;
        ButtonBean r101 = this.button;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "MoTextBean(title=" + this.title + ", content=" + this.content + ", button=" + this.button + ')';
    }

    public final ButtonBean getButton() {
        return this.button;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public MoTextBean(@JSONField(name = "title") String r100, @JSONField(name = "content") String r101, @JSONField(name = "button") ButtonBean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.title = r100;
        this.content = r101;
        this.button = r102;
    }

    public /* synthetic */ MoTextBean(String r100, String r101, ButtonBean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, r102);
    }
}

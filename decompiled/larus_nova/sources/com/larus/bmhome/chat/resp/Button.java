package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JH\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/resp/Button;", "", "style", "", "content", "", "schema", "targetPage", "disableClip", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getStyle", "()I", "getContent", "()Ljava/lang/String;", "getSchema", "getTargetPage", "getDisableClip", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/resp/Button;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Button {

    @SerializedName("content")
    private final String content;

    @SerializedName("disable_clip")
    private final Boolean disableClip;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("style")
    private final int style;

    @SerializedName("target_page")
    private final String targetPage;

    public Button() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Button copy$default(Button r100, int r101, String r102, String r103, String r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.style;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.content;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.schema;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.targetPage;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.disableClip;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.style;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.schema;
    }

    public final String component4() {
        return this.targetPage;
    }

    public final Boolean component5() {
        return this.disableClip;
    }

    public final Button copy(int r100, String r101, String r110, String r111, Boolean r112) {
        return new Button(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Button) == true) goto L8;
        return false;
    L8:
        Button r101 = (Button) r100;
        if (this.style == r101.style) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.targetPage, r101.targetPage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disableClip, r101.disableClip) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.style * 31;
        String r101 = this.content;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.schema;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.targetPage;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.disableClip;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Button(style=" + this.style + ", content=" + this.content + ", schema=" + this.schema + ", targetPage=" + this.targetPage + ", disableClip=" + this.disableClip + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final Boolean getDisableClip() {
        return this.disableClip;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getTargetPage() {
        return this.targetPage;
    }

    public Button(int r100, String r101, String r102, String r103, Boolean r104) {
        this.style = r100;
        this.content = r101;
        this.schema = r102;
        this.targetPage = r103;
        this.disableClip = r104;
    }

    public /* synthetic */ Button(int r100, String r101, String r102, String r103, Boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r106 = "";
        if ((r105 & 2) == 0) goto L8;
        String r111 = "";
    L10:
        if ((r105 & 4) != 0) goto L14;
        r106 = r102;
    L14:
        if ((r105 & 8) == 0) goto L16;
        r103 = null;
    L16:
        String r107 = r103;
        if ((r105 & 16) == 0) goto L19;
        r104 = Boolean.FALSE;
    L19:
        Boolean r108 = r104;
        this(r100, r111, r106, r107, r108);
        return;
    L8:
        r111 = r101;
        goto L10
    }
}

package com.obric.assistant.cocreationreview;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatDetail;", "", EventConstant.Key.MODULE, "", "total", "completed", "skipped", "likes", "unlikes", "<init>", "(IIIIII)V", "getModule", "()I", "getTotal", "getCompleted", "getSkipped", "getLikes", "getUnlikes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackStatDetail {

    @SerializedName("completed")
    private final int completed;

    @SerializedName("likes")
    private final int likes;

    @SerializedName(EventConstant.Key.MODULE)
    private final int module;

    @SerializedName("skipped")
    private final int skipped;

    @SerializedName("total")
    private final int total;

    @SerializedName("unlikes")
    private final int unlikes;

    public CocreationUserFeedbackStatDetail() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ CocreationUserFeedbackStatDetail copy$default(CocreationUserFeedbackStatDetail r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.module;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.total;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.completed;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.skipped;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.likes;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.unlikes;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.module;
    }

    public final int component2() {
        return this.total;
    }

    public final int component3() {
        return this.completed;
    }

    public final int component4() {
        return this.skipped;
    }

    public final int component5() {
        return this.likes;
    }

    public final int component6() {
        return this.unlikes;
    }

    public final CocreationUserFeedbackStatDetail copy(int r100, int r110, int r111, int r112, int r113, int r114) {
        return new CocreationUserFeedbackStatDetail(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CocreationUserFeedbackStatDetail) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackStatDetail r101 = (CocreationUserFeedbackStatDetail) r100;
        if (this.module == r101.module) goto L12;
        return false;
    L12:
        if (this.total == r101.total) goto L15;
        return false;
    L15:
        if (this.completed == r101.completed) goto L18;
        return false;
    L18:
        if (this.skipped == r101.skipped) goto L21;
        return false;
    L21:
        if (this.likes == r101.likes) goto L24;
        return false;
    L24:
        if (this.unlikes == r101.unlikes) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.module * 31) + this.total) * 31) + this.completed) * 31) + this.skipped) * 31) + this.likes) * 31) + this.unlikes;
    }

    public String toString() {
        return "CocreationUserFeedbackStatDetail(module=" + this.module + ", total=" + this.total + ", completed=" + this.completed + ", skipped=" + this.skipped + ", likes=" + this.likes + ", unlikes=" + this.unlikes + ')';
    }

    public final int getCompleted() {
        return this.completed;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final int getModule() {
        return this.module;
    }

    public final int getSkipped() {
        return this.skipped;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getUnlikes() {
        return this.unlikes;
    }

    public CocreationUserFeedbackStatDetail(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.module = r100;
        this.total = r101;
        this.completed = r102;
        this.skipped = r103;
        this.likes = r104;
        this.unlikes = r105;
    }

    public /* synthetic */ CocreationUserFeedbackStatDetail(int r100, int r101, int r102, int r103, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r114 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r106 = 0;
    L19:
        if ((r112 & 16) == 0) goto L21;
        int r107 = 0;
    L23:
        if ((r112 & 32) == 0) goto L25;
        int r115 = 0;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}

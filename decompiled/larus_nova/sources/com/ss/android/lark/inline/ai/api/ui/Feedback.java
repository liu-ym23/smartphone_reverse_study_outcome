package com.ss.android.lark.inline.ai.api.ui;

import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0007H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Feedback;", "Ljava/io/Serializable;", "show", "", IStrategyStateSupplier.KEY_INFO_LIKE, "unlike", "position", "", "<init>", "(ZZZLjava/lang/String;)V", "getShow", "()Z", "setShow", "(Z)V", "getLike", "setLike", "getUnlike", "setUnlike", "getPosition$annotations", "()V", "getPosition", "()Ljava/lang/String;", "setPosition", "(Ljava/lang/String;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "Position", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Feedback implements Serializable {
    private boolean like;
    private String position;
    private boolean show;
    private boolean unlike;

    public static /* synthetic */ Feedback copy$default(Feedback r100, boolean r101, boolean r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.like;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.unlike;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.position;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @Deprecated(message = "组件内部判断显示位置，优先跟历史记录显示在同一行，没有历史记录则跟免责显示在一行")
    public static /* synthetic */ void getPosition$annotations() {
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.like;
    }

    public final boolean component3() {
        return this.unlike;
    }

    public final String component4() {
        return this.position;
    }

    public final Feedback copy(boolean r100, boolean r101, boolean r102, String r103) {
        return new Feedback(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Feedback) == true) goto L8;
        return false;
    L8:
        Feedback r101 = (Feedback) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (this.like == r101.like) goto L15;
        return false;
    L15:
        if (this.unlike == r101.unlike) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.like == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.unlike == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        String r106 = this.position;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "Feedback(show=" + this.show + ", like=" + this.like + ", unlike=" + this.unlike + ", position=" + this.position + ')';
    }

    public final boolean getLike() {
        return this.like;
    }

    public final String getPosition() {
        return this.position;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final boolean getUnlike() {
        return this.unlike;
    }

    public final void setLike(boolean r100) {
        this.like = r100;
    }

    public final void setPosition(String r100) {
        this.position = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setUnlike(boolean r100) {
        this.unlike = r100;
    }

    public Feedback(boolean r100, boolean r101, boolean r102, String r103) {
        this.show = r100;
        this.like = r101;
        this.unlike = r102;
        this.position = r103;
    }

    public /* synthetic */ Feedback(boolean r100, boolean r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}

package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "Ljava/io/Serializable;", "renderData", "", "isFullWidth", "", "appletType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Boolean;", "component3", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/aiagent/assistant/idl/bean/AppletBlock;", "equals", "other", "", "hashCode", "toString", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBlock implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("applet_type")
    public final Integer appletType;

    @SerializedName("is_full_width")
    public final Boolean isFullWidth;

    @SerializedName("render_data")
    public final String renderData;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AppletBlock() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AppletBlock copy$default(AppletBlock r100, String r101, Boolean r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.renderData;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isFullWidth;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.appletType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.renderData;
    }

    public final Boolean component2() {
        return this.isFullWidth;
    }

    public final Integer component3() {
        return this.appletType;
    }

    public final AppletBlock copy(String r100, Boolean r101, Integer r102) {
        return new AppletBlock(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppletBlock) == true) goto L8;
        return false;
    L8:
        AppletBlock r101 = (AppletBlock) r100;
        if (Intrinsics.areEqual(this.renderData, r101.renderData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFullWidth, r101.isFullWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletType, r101.appletType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.renderData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isFullWidth;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.appletType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletBlock(renderData=" + this.renderData + ", isFullWidth=" + this.isFullWidth + ", appletType=" + this.appletType + ')';
    }

    public AppletBlock(String r100, Boolean r101, Integer r102) {
        this.renderData = r100;
        this.isFullWidth = r101;
        this.appletType = r102;
    }

    public /* synthetic */ AppletBlock(String r100, Boolean r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

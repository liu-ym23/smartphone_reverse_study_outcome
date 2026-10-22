package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "flowFunctionScene", "", "enableForsetiPageSizeSlot", "", "enableSmallWindowTopInsetAdaptation", "userContextParam", "Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "<init>", "(Ljava/lang/String;ZZLcom/larus/bmhome/chat/bean/ChatUserContextParam;)V", "getFlowFunctionScene", "()Ljava/lang/String;", "getEnableForsetiPageSizeSlot", "()Z", "getEnableSmallWindowTopInsetAdaptation", "getUserContextParam", "()Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "isNotEmpty", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatPassThroughParams implements Parcelable, Serializable, t1a.c {
    public static final Parcelable.Creator<ChatPassThroughParams> CREATOR = null;
    private final boolean enableForsetiPageSizeSlot;
    private final boolean enableSmallWindowTopInsetAdaptation;
    private final String flowFunctionScene;
    private final ChatUserContextParam userContextParam;

    public static final class a implements Parcelable.Creator<ChatPassThroughParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPassThroughParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            boolean r102 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r102 = true;
        L10:
            return new ChatPassThroughParams(r101, r103, r102, (ChatUserContextParam) r100.readParcelable(ChatPassThroughParams.class.getClassLoader()));
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPassThroughParams[] newArray(int r100) {
            return new ChatPassThroughParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatPassThroughParams() {
        this(null, false, false, null, 15, null);
    }

    public static /* synthetic */ ChatPassThroughParams copy$default(ChatPassThroughParams r100, String r101, boolean r102, boolean r103, ChatUserContextParam r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.flowFunctionScene;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.enableForsetiPageSizeSlot;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enableSmallWindowTopInsetAdaptation;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.userContextParam;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.flowFunctionScene;
    }

    public final boolean component2() {
        return this.enableForsetiPageSizeSlot;
    }

    public final boolean component3() {
        return this.enableSmallWindowTopInsetAdaptation;
    }

    public final ChatUserContextParam component4() {
        return this.userContextParam;
    }

    public final ChatPassThroughParams copy(String r100, boolean r101, boolean r102, ChatUserContextParam r103) {
        return new ChatPassThroughParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatPassThroughParams) == true) goto L8;
        return false;
    L8:
        ChatPassThroughParams r101 = (ChatPassThroughParams) r100;
        if (Intrinsics.areEqual(this.flowFunctionScene, r101.flowFunctionScene) == true) goto L12;
        return false;
    L12:
        if (this.enableForsetiPageSizeSlot == r101.enableForsetiPageSizeSlot) goto L15;
        return false;
    L15:
        if (this.enableSmallWindowTopInsetAdaptation == r101.enableSmallWindowTopInsetAdaptation) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userContextParam, r101.userContextParam) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.flowFunctionScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.enableForsetiPageSizeSlot == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.enableSmallWindowTopInsetAdaptation == true) goto L14;
        r104 = 1237;
    L14:
        int r107 = (r106 + r104) * 31;
        ChatUserContextParam r108 = this.userContextParam;
        if (r108 == null) goto L19;
        r101 = r108.hashCode();
    L19:
        return r107 + r101;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatPassThroughParams(flowFunctionScene=" + this.flowFunctionScene + ", enableForsetiPageSizeSlot=" + this.enableForsetiPageSizeSlot + ", enableSmallWindowTopInsetAdaptation=" + this.enableSmallWindowTopInsetAdaptation + ", userContextParam=" + this.userContextParam + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.flowFunctionScene);
        r100.writeInt(this.enableForsetiPageSizeSlot ? 1 : 0);
        r100.writeInt(this.enableSmallWindowTopInsetAdaptation ? 1 : 0);
        r100.writeParcelable(this.userContextParam, r101);
    }

    public final boolean isNotEmpty() {
        String r100 = this.flowFunctionScene;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        ChatUserContextParam r102 = this.userContextParam;
        if (r102 != null) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L21;
        if (this.enableForsetiPageSizeSlot == true) goto L21;
        if (this.enableSmallWindowTopInsetAdaptation == true) goto L21;
        return false;
    L13:
        if (r102.isNotEmpty() != true) goto L15;
        r103 = true;
    L21:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean getEnableForsetiPageSizeSlot() {
        return this.enableForsetiPageSizeSlot;
    }

    public final boolean getEnableSmallWindowTopInsetAdaptation() {
        return this.enableSmallWindowTopInsetAdaptation;
    }

    public final String getFlowFunctionScene() {
        return this.flowFunctionScene;
    }

    public final ChatUserContextParam getUserContextParam() {
        return this.userContextParam;
    }

    public ChatPassThroughParams(String r100, boolean r101, boolean r102, ChatUserContextParam r103) {
        this.flowFunctionScene = r100;
        this.enableForsetiPageSizeSlot = r101;
        this.enableSmallWindowTopInsetAdaptation = r102;
        this.userContextParam = r103;
    }

    public /* synthetic */ ChatPassThroughParams(String r100, boolean r101, boolean r102, ChatUserContextParam r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

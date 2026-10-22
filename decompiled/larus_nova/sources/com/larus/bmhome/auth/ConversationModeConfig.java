package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012JF\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/auth/ConversationModeConfig;", "Landroid/os/Parcelable;", "conversationModeList", "", "Lcom/larus/bmhome/auth/ConversationMode;", "defaultConversationModeKeyNewChat", "", "defaultConversationModeKeyNewOffice", "enableConversationModeV2", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getConversationModeList", "()Ljava/util/List;", "getDefaultConversationModeKeyNewChat", "()Ljava/lang/String;", "getDefaultConversationModeKeyNewOffice", "getEnableConversationModeV2", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/ConversationModeConfig;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationModeConfig implements Parcelable {
    public static final Parcelable.Creator<ConversationModeConfig> CREATOR = null;

    @SerializedName("conversation_mode_list")
    private final List<ConversationMode> conversationModeList;

    @SerializedName("default_conversation_mode_key_new_chat")
    private final String defaultConversationModeKeyNewChat;

    @SerializedName("default_conversation_mode_key_new_office")
    private final String defaultConversationModeKeyNewOffice;

    @SerializedName("enable_conversation_mode_v2")
    private final Boolean enableConversationModeV2;

    public static final class a implements Parcelable.Creator<ConversationModeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationModeConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L12:
            String r104 = r100.readString();
            String r105 = r100.readString();
            if (r100.readInt() == 0) goto L20;
            if (r100.readInt() == 0) goto L18;
            r101 = true;
        L18:
            r102 = Boolean.valueOf(r101);
        L20:
            return new ConversationModeConfig(r103, r104, r105, r102);
        L5:
            int r106 = r100.readInt();
            r103 = new ArrayList(r106);
            int r107 = 0;
        L6:
            if (r107 == r106) goto L12;
            if (r100.readInt() != 0) goto L10;
            ConversationMode r108 = null;
        L11:
            r103.add(r108);
            r107 = r107 + 1;
            goto L6
        L10:
            r108 = ConversationMode.CREATOR.createFromParcel(r100);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationModeConfig[] newArray(int r100) {
            return new ConversationModeConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConversationModeConfig() {
        this(null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationModeConfig) == true) goto L8;
        return false;
    L8:
        ConversationModeConfig r101 = (ConversationModeConfig) r100;
        if (Intrinsics.areEqual(this.conversationModeList, r101.conversationModeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultConversationModeKeyNewChat, r101.defaultConversationModeKeyNewChat) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultConversationModeKeyNewOffice, r101.defaultConversationModeKeyNewOffice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableConversationModeV2, r101.enableConversationModeV2) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<ConversationMode> r100 = this.conversationModeList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.defaultConversationModeKeyNewChat;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.defaultConversationModeKeyNewOffice;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.enableConversationModeV2;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationModeConfig(conversationModeList=" + this.conversationModeList + ", defaultConversationModeKeyNewChat=" + this.defaultConversationModeKeyNewChat + ", defaultConversationModeKeyNewOffice=" + this.defaultConversationModeKeyNewOffice + ", enableConversationModeV2=" + this.enableConversationModeV2 + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<ConversationMode> r102 = this.conversationModeList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        r100.writeString(this.defaultConversationModeKeyNewChat);
        r100.writeString(this.defaultConversationModeKeyNewOffice);
        Boolean r103 = this.enableConversationModeV2;
        if (r103 != null) goto L15;
        r100.writeInt(0);
        return;
    L15:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ConversationMode> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        ConversationMode r105 = r104.next();
        if (r105 == null) goto L10;
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final List<ConversationMode> b() {
        return this.conversationModeList;
    }

    public final String c() {
        return this.defaultConversationModeKeyNewChat;
    }

    public final String d() {
        return this.defaultConversationModeKeyNewOffice;
    }

    public final Boolean e() {
        return this.enableConversationModeV2;
    }

    public ConversationModeConfig(List<ConversationMode> r100, String r101, String r102, Boolean r103) {
        this.conversationModeList = r100;
        this.defaultConversationModeKeyNewChat = r101;
        this.defaultConversationModeKeyNewOffice = r102;
        this.enableConversationModeV2 = r103;
    }

    public static ConversationModeConfig a(ConversationModeConfig r100, List r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.conversationModeList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.defaultConversationModeKeyNewChat;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.defaultConversationModeKeyNewOffice;
    L12:
        if ((r104 & 8) == 0) goto L14;
        Boolean r105 = r100.enableConversationModeV2;
    L16:
        return new ConversationModeConfig(r101, r102, r103, r105);
    L14:
        r105 = null;
        goto L16
    }
}

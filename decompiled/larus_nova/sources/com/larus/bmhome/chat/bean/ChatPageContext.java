package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.im.bean.message.GuiContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B~\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0016\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0080\u0001\u0010$\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020&HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatPageContext;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "reqHeaderMap", "", "", "reqExt", "userContextParam", "Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "guiContext", "", "Lcom/larus/im/bean/message/GuiContext;", "Lkotlinx/parcelize/RawValue;", "bizExt", "conversationMode", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/larus/bmhome/chat/bean/ChatUserContextParam;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getReqHeaderMap", "()Ljava/util/Map;", "getReqExt", "getUserContextParam", "()Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "getGuiContext", "()Ljava/util/List;", "getBizExt", "getConversationMode", "()Ljava/lang/String;", "isNotEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatPageContext implements Parcelable, Serializable, t1a.c {
    public static final Parcelable.Creator<ChatPageContext> CREATOR = null;
    private final Map<String, String> bizExt;
    private final String conversationMode;
    private final List<GuiContext> guiContext;
    private final Map<String, String> reqExt;
    private final Map<String, String> reqHeaderMap;
    private final ChatUserContextParam userContextParam;

    public static final class a implements Parcelable.Creator<ChatPageContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPageContext createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = 0;
            LinkedHashMap r101 = null;
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r102 = null;
        L10:
            if (r110.readInt() != 0) goto L12;
            LinkedHashMap r103 = null;
        L17:
            if (r110.readInt() != 0) goto L19;
            ChatUserContextParam r104 = null;
        L20:
            ChatUserContextParam r105 = r104;
            if (r110.readInt() != 0) goto L23;
            ArrayList r106 = null;
        L28:
            if (r110.readInt() == 0) goto L34;
            int r107 = r110.readInt();
            r101 = new LinkedHashMap(r107);
        L31:
            if (r100 == r107) goto L34;
            r101.put(r110.readString(), r110.readString());
            r100 = r100 + 1;
        L34:
            return new ChatPageContext(r102, r103, r105, r106, r101, r110.readString());
        L23:
            int r108 = r110.readInt();
            ArrayList r109 = new ArrayList(r108);
            int r111 = 0;
        L24:
            if (r111 == r108) goto L26;
            r109.add(r110.readSerializable());
            r111 = r111 + 1;
            goto L24
        L26:
            r106 = r109;
            goto L28
        L19:
            r104 = ChatUserContextParam.CREATOR.createFromParcel(r110);
            goto L20
        L12:
            int r112 = r110.readInt();
            LinkedHashMap r113 = new LinkedHashMap(r112);
            int r114 = 0;
        L13:
            if (r114 == r112) goto L15;
            r113.put(r110.readString(), r110.readString());
            r114 = r114 + 1;
            goto L13
        L15:
            r103 = r113;
            goto L17
        L5:
            int r115 = r110.readInt();
            LinkedHashMap r116 = new LinkedHashMap(r115);
            int r117 = 0;
        L6:
            if (r117 == r115) goto L8;
            r116.put(r110.readString(), r110.readString());
            r117 = r117 + 1;
            goto L6
        L8:
            r102 = r116;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPageContext[] newArray(int r100) {
            return new ChatPageContext[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatPageContext() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatPageContext copy$default(ChatPageContext r100, Map r101, Map r102, ChatUserContextParam r103, List r104, Map r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.reqHeaderMap;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.reqExt;
    L8:
        Map r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.userContextParam;
    L11:
        ChatUserContextParam r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.guiContext;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.bizExt;
    L17:
        Map r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.conversationMode;
    L20:
        Map r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Map<String, String> component1() {
        return this.reqHeaderMap;
    }

    public final Map<String, String> component2() {
        return this.reqExt;
    }

    public final ChatUserContextParam component3() {
        return this.userContextParam;
    }

    public final List<GuiContext> component4() {
        return this.guiContext;
    }

    public final Map<String, String> component5() {
        return this.bizExt;
    }

    public final String component6() {
        return this.conversationMode;
    }

    public final ChatPageContext copy(Map<String, String> r100, Map<String, String> r110, ChatUserContextParam r111, List<GuiContext> r112, Map<String, String> r113, String r114) {
        return new ChatPageContext(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatPageContext) == true) goto L8;
        return false;
    L8:
        ChatPageContext r101 = (ChatPageContext) r100;
        if (Intrinsics.areEqual(this.reqHeaderMap, r101.reqHeaderMap) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reqExt, r101.reqExt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userContextParam, r101.userContextParam) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.guiContext, r101.guiContext) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizExt, r101.bizExt) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conversationMode, r101.conversationMode) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.reqHeaderMap;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.reqExt;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ChatUserContextParam r107 = this.userContextParam;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<GuiContext> r110 = this.guiContext;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.bizExt;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.conversationMode;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public String toString() {
        return "ChatPageContext(reqHeaderMap=" + this.reqHeaderMap + ", reqExt=" + this.reqExt + ", userContextParam=" + this.userContextParam + ", guiContext=" + this.guiContext + ", bizExt=" + this.bizExt + ", conversationMode=" + this.conversationMode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Map<String, String> r102 = this.reqHeaderMap;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Map<String, String> r103 = this.reqExt;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L16:
        ChatUserContextParam r104 = this.userContextParam;
        if (r104 != null) goto L19;
        r100.writeInt(0);
    L20:
        List<GuiContext> r105 = this.guiContext;
        if (r105 != null) goto L23;
        r100.writeInt(0);
    L27:
        Map<String, String> r106 = this.bizExt;
        if (r106 != null) goto L30;
        r100.writeInt(0);
    L34:
        r100.writeString(this.conversationMode);
        return;
    L30:
        r100.writeInt(1);
        r100.writeInt(r106.size());
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L32:
        if (r107.hasNext() == false) goto L34;
        Map.Entry<String, String> r108 = r107.next();
        r100.writeString(r108.getKey());
        r100.writeString(r108.getValue());
        goto L32
    L23:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<GuiContext> r109 = r105.iterator();
    L25:
        if (r109.hasNext() == false) goto L27;
        r100.writeSerializable(r109.next());
        goto L25
    L19:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L20
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, String>> r110 = r103.entrySet().iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        Map.Entry<String, String> r111 = r110.next();
        r100.writeString(r111.getKey());
        r100.writeString(r111.getValue());
        goto L14
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r112 = r102.entrySet().iterator();
    L7:
        if (r112.hasNext() == false) goto L9;
        Map.Entry<String, String> r113 = r112.next();
        r100.writeString(r113.getKey());
        r100.writeString(r113.getValue());
        goto L7
    }

    public final boolean isNotEmpty() {
        Map<String, String> r100 = this.reqHeaderMap;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L49;
        Map<String, String> r102 = this.reqExt;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L49;
        Map<String, String> r104 = this.bizExt;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == false) goto L49;
        ChatUserContextParam r106 = this.userContextParam;
        if (r106 != null) goto L29;
    L31:
        boolean r107 = false;
    L32:
        if (r107 == true) goto L49;
        List<GuiContext> r108 = this.guiContext;
        if (r108 != null) goto L36;
    L39:
        boolean r109 = true;
    L40:
        if (r109 == false) goto L49;
        String r110 = this.conversationMode;
        if (r110 != null) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == false) goto L49;
        return false;
    L44:
        if (r110.length() == 0) goto L47;
        r111 = false;
        goto L48
    L36:
        if (r108.isEmpty() == true) goto L39;
        r109 = false;
        goto L40
    L29:
        if (r106.isNotEmpty() != true) goto L31;
        r107 = true;
        goto L32
    L21:
        if (r104.isEmpty() == true) goto L24;
        r105 = false;
        goto L25
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
    L49:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final Map<String, String> getBizExt() {
        return this.bizExt;
    }

    public final String getConversationMode() {
        return this.conversationMode;
    }

    public final List<GuiContext> getGuiContext() {
        return this.guiContext;
    }

    public final Map<String, String> getReqExt() {
        return this.reqExt;
    }

    public final Map<String, String> getReqHeaderMap() {
        return this.reqHeaderMap;
    }

    public final ChatUserContextParam getUserContextParam() {
        return this.userContextParam;
    }

    public ChatPageContext(Map<String, String> r100, Map<String, String> r101, ChatUserContextParam r102, List<GuiContext> r103, Map<String, String> r104, String r105) {
        this.reqHeaderMap = r100;
        this.reqExt = r101;
        this.userContextParam = r102;
        this.guiContext = r103;
        this.bizExt = r104;
        this.conversationMode = r105;
    }

    public /* synthetic */ ChatPageContext(Map r100, Map r101, ChatUserContextParam r102, List r103, Map r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Map r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Map r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        ChatUserContextParam r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Map r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
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

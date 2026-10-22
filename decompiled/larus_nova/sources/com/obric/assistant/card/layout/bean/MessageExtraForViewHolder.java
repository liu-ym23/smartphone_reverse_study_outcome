package com.obric.assistant.card.layout.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u001fHÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "Landroid/os/Parcelable;", "isPaused", "", "showRecentContact", "intentType", "", "intentName", "localMessageId", "ext", "", "msgExt", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()Z", "getShowRecentContact", "getIntentType", "()Ljava/lang/String;", "getIntentName", "getLocalMessageId", "getExt", "()Ljava/util/Map;", "getMsgExt", "setMsgExt", "(Ljava/util/Map;)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageExtraForViewHolder implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f386331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f386332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f386333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f386334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f386335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f386336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f386337g;

    public static final class a implements Parcelable.Creator<MessageExtraForViewHolder> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessageExtraForViewHolder createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = 0;
            if (r110.readByte() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r110.readByte() == 0) goto L9;
            boolean r102 = true;
        L10:
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            if (r105 != null) goto L13;
            String r106 = "";
        L14:
            MessageExtraForViewHolder.CREATOR.getClass();
            int r107 = r110.readInt();
            if (r107 >= 0) goto L17;
            HashMap r111 = null;
        L28:
            boolean r108 = r101;
            String r109 = r106;
            HashMap r112 = r111;
            return new MessageExtraForViewHolder(r108, r102, r103, r104, r109, r112, null, 64);
        L17:
            HashMap r113 = new HashMap(r107);
        L18:
            if (r100 >= r107) goto L27;
            String r114 = r110.readString();
            if (r114 == null) goto L26;
            String r115 = r110.readString();
            if (r115 != null) goto L25;
            r115 = "";
        L25:
            r113.put(r114, r115);
        L26:
            r100 = r100 + 1;
            goto L18
        L27:
            r111 = r113;
            goto L28
        L13:
            r106 = r105;
            goto L14
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MessageExtraForViewHolder[] newArray(int r100) {
            return new MessageExtraForViewHolder[r100];
        }

        public static final void a(a r100, Parcel r101, Map r102) {
            r100.getClass();
            if (r102 != null) goto L5;
            r101.writeInt(-1);
            return;
        L5:
            r101.writeInt(r102.size());
            Iterator r103 = r102.entrySet().iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            String r106 = (String) r104.getValue();
            r101.writeString(r105);
            r101.writeString(r106);
            goto L7
        }
    }

    static {
        CREATOR = new a();
    }

    public MessageExtraForViewHolder() {
        this(false, false, null, null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageExtraForViewHolder) == true) goto L8;
        return false;
    L8:
        MessageExtraForViewHolder r101 = (MessageExtraForViewHolder) r100;
        if (this.f386331a == r101.f386331a) goto L12;
        return false;
    L12:
        if (this.f386332b == r101.f386332b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f386333c, r101.f386333c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f386334d, r101.f386334d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f386335e, r101.f386335e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f386336f, r101.f386336f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f386337g, r101.f386337g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f386331a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f386332b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f386333c;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f386334d;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (((r107 + r109) * 31) + this.f386335e.hashCode()) * 31;
        Map<String, String> r111 = this.f386336f;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f386337g;
        if (r114 == null) goto L27;
        r105 = r114.hashCode();
    L27:
        return r113 + r105;
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageExtraForViewHolder(isPaused=" + this.f386331a + ", showRecentContact=" + this.f386332b + ", intentType=" + this.f386333c + ", intentName=" + this.f386334d + ", localMessageId=" + this.f386335e + ", ext=" + this.f386336f + ", msgExt=" + this.f386337g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.f386331a ? 1 : 0);
        r100.writeByte(this.f386332b ? 1 : 0);
        r100.writeString(this.f386333c);
        r100.writeString(this.f386334d);
        r100.writeString(this.f386335e);
        a r102 = CREATOR;
        a.a(r102, r100, this.f386336f);
        a.a(r102, r100, this.f386337g);
    }

    public MessageExtraForViewHolder(boolean r100, boolean r101, String r102, String r103, String r104, Map<String, String> r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r104, "localMessageId");
        this.f386331a = r100;
        this.f386332b = r101;
        this.f386333c = r102;
        this.f386334d = r103;
        this.f386335e = r104;
        this.f386336f = r105;
        this.f386337g = r106;
    }

    public /* synthetic */ MessageExtraForViewHolder(boolean r100, boolean r101, String r102, String r110, String r111, Map r112, Map r113, int r114) {
        boolean r103 = false;
        if ((r114 & 1) == 0) goto L5;
        boolean r104 = false;
    L7:
        if ((r114 & 2) != 0) goto L11;
        r103 = r101;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        r111 = "";
    L21:
        String r107 = r111;
        if ((r114 & 32) == 0) goto L24;
        Map r108 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        Map r115 = null;
    L29:
        this(r104, r103, r105, r106, r107, r108, r115);
        return;
    L28:
        r115 = r113;
        goto L29
    L24:
        r108 = r112;
        goto L26
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L5:
        r104 = r100;
        goto L7
    }
}

package com.ss.android.lark.biz.im.api.bundle.v2.biz.chat;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.ChatIntentExtraBundle;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_chat_key")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB¿\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b\u001c\u0010 J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u0004H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0013H\u0016J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0013HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010S\u001a\u00020\u001bHÆ\u0003JÁ\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\u0013\u0010U\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\u0004HÖ\u0001J\t\u0010Y\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010&\"\u0004\b'\u0010(R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010,\"\u0004\b.\u0010/R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010&R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006["}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "showPosition", "", "needShowPosition", "", "isSecretChat", "profileSource", "Lcom/ss/android/lark/biz/im/api/ProfileSource;", "appId", "", "messageId", "needBadge", "rebuildChat", "showMessageNotFoundTip", "isFromOfflinePush", "isOfflineImmediateOpenChat", "applyContactsBundle", "Landroid/os/Bundle;", "selectMessagesRandomKey", "selectMessagesParamsJsonString", "chatWindowPrepareData", "Lcom/ss/android/lark/biz/im/api/ChatWindowPrepareData;", "intentExtraBundle", "Lcom/ss/android/lark/biz/im/api/ChatIntentExtraBundle;", "tabId", "", "<init>", "(IZZLcom/ss/android/lark/biz/im/api/ProfileSource;Ljava/lang/String;Ljava/lang/String;ZZZZZLandroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/ChatWindowPrepareData;Lcom/ss/android/lark/biz/im/api/ChatIntentExtraBundle;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getShowPosition", "()I", "setShowPosition", "(I)V", "getNeedShowPosition", "()Z", "setSecretChat", "(Z)V", "getProfileSource", "()Lcom/ss/android/lark/biz/im/api/ProfileSource;", "getAppId", "()Ljava/lang/String;", "getMessageId", "setMessageId", "(Ljava/lang/String;)V", "getNeedBadge", "getRebuildChat", "getShowMessageNotFoundTip", "getApplyContactsBundle", "()Landroid/os/Bundle;", "getSelectMessagesRandomKey", "getSelectMessagesParamsJsonString", "getChatWindowPrepareData", "()Lcom/ss/android/lark/biz/im/api/ChatWindowPrepareData;", "getIntentExtraBundle", "()Lcom/ss/android/lark/biz/im/api/ChatIntentExtraBundle;", "getTabId", "()J", "writeToParcel", "", "flags", "describeContents", "putInBundle", "bundle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBizData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f410031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f410032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f410033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProfileSource f410034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f410035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f410036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f410037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f410038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f410039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f410040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f410041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Bundle f410042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f410043m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f410044n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ChatWindowPrepareData f410045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ChatIntentExtraBundle f410046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f410047q;

    public static final class a implements Parcelable.Creator<ChatBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatBizData createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            Intrinsics.checkNotNullParameter(r210, "parcel");
            int r100 = r210.readInt();
            if (r210.readByte() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r210.readByte() == 0) goto L9;
            boolean r102 = true;
        L10:
            ProfileSource r103 = (ProfileSource) r210.readParcelable(ProfileSource.class.getClassLoader());
            String r104 = r210.readString();
            String r105 = r210.readString();
            if (r210.readByte() == 0) goto L13;
            boolean r106 = true;
        L15:
            if (r210.readByte() == 0) goto L17;
            boolean r110 = true;
        L19:
            if (r210.readByte() == 0) goto L21;
            boolean r111 = true;
        L23:
            if (r210.readByte() == 0) goto L25;
            boolean r112 = true;
        L27:
            if (r210.readByte() == 0) goto L29;
            boolean r113 = true;
        L30:
            Bundle r107 = r210.readBundle(Bundle.class.getClassLoader());
            if (r107 != null) goto L33;
            r107 = new Bundle();
        L33:
            boolean r108 = r101;
            return new ChatBizData(r100, r108, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r210.readString(), r210.readString(), (ChatWindowPrepareData) r210.readSerializable(), (ChatIntentExtraBundle) r210.readParcelable(ChatIntentExtraBundle.class.getClassLoader()), r210.readLong());
        L29:
            r113 = false;
            goto L30
        L25:
            r112 = false;
            goto L27
        L21:
            r111 = false;
            goto L23
        L17:
            r110 = false;
            goto L19
        L13:
            r106 = false;
            goto L15
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatBizData[] newArray(int r100) {
            return new ChatBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatBizData() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatBizData) == true) goto L8;
        return false;
    L8:
        ChatBizData r101 = (ChatBizData) r100;
        if (this.f410031a == r101.f410031a) goto L12;
        return false;
    L12:
        if (this.f410032b == r101.f410032b) goto L15;
        return false;
    L15:
        if (this.f410033c == r101.f410033c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410034d, r101.f410034d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410035e, r101.f410035e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410036f, r101.f410036f) == true) goto L27;
        return false;
    L27:
        if (this.f410037g == r101.f410037g) goto L30;
        return false;
    L30:
        if (this.f410038h == r101.f410038h) goto L33;
        return false;
    L33:
        if (this.f410039i == r101.f410039i) goto L36;
        return false;
    L36:
        if (this.f410040j == r101.f410040j) goto L39;
        return false;
    L39:
        if (this.f410041k == r101.f410041k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f410042l, r101.f410042l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f410043m, r101.f410043m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f410044n, r101.f410044n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f410045o, r101.f410045o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f410046p, r101.f410046p) == true) goto L57;
        return false;
    L57:
        if (this.f410047q == r101.f410047q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f410031a * 31;
        int r101 = 1231;
        if (this.f410032b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f410033c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        ProfileSource r106 = this.f410034d;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f410035e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f410036f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f410037g == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f410038h == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f410039i == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.f410040j == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.f410041k == true) goto L42;
        r101 = 1237;
    L42:
        int r124 = (((r123 + r101) * 31) + this.f410042l.hashCode()) * 31;
        String r125 = this.f410043m;
        if (r125 != null) goto L45;
        int r126 = 0;
    L46:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f410044n;
        if (r128 != null) goto L49;
        int r129 = 0;
    L50:
        int r130 = (r127 + r129) * 31;
        ChatWindowPrepareData r131 = this.f410045o;
        if (r131 != null) goto L53;
        int r132 = 0;
    L54:
        int r133 = (r130 + r132) * 31;
        ChatIntentExtraBundle r134 = this.f410046p;
        if (r134 == null) goto L58;
        r107 = r134.hashCode();
    L58:
        long r135 = this.f410047q;
        return ((r133 + r107) * 31) + ((int) (r135 ^ (r135 >>> 32)));
    L53:
        r132 = r131.hashCode();
        goto L54
    L49:
        r129 = r128.hashCode();
        goto L50
    L45:
        r126 = r125.hashCode();
        goto L46
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatBizData(showPosition=" + this.f410031a + ", needShowPosition=" + this.f410032b + ", isSecretChat=" + this.f410033c + ", profileSource=" + this.f410034d + ", appId=" + this.f410035e + ", messageId=" + this.f410036f + ", needBadge=" + this.f410037g + ", rebuildChat=" + this.f410038h + ", showMessageNotFoundTip=" + this.f410039i + ", isFromOfflinePush=" + this.f410040j + ", isOfflineImmediateOpenChat=" + this.f410041k + ", applyContactsBundle=" + this.f410042l + ", selectMessagesRandomKey=" + this.f410043m + ", selectMessagesParamsJsonString=" + this.f410044n + ", chatWindowPrepareData=" + this.f410045o + ", intentExtraBundle=" + this.f410046p + ", tabId=" + this.f410047q + ')';
    }

    public /* synthetic */ ChatBizData(int r210) {
        this(-1, true, false, null, null, null, true, true, false, false, false, new Bundle(), null, null, null, null, 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f410031a);
        r100.writeByte(this.f410032b ? 1 : 0);
        r100.writeByte(this.f410033c ? 1 : 0);
        r100.writeParcelable(this.f410034d, r101);
        r100.writeString(this.f410035e);
        r100.writeString(this.f410036f);
        r100.writeByte(this.f410037g ? 1 : 0);
        r100.writeByte(this.f410038h ? 1 : 0);
        r100.writeByte(this.f410039i ? 1 : 0);
        r100.writeByte(this.f410040j ? 1 : 0);
        r100.writeByte(this.f410041k ? 1 : 0);
        r100.writeBundle(this.f410042l);
        r100.writeString(this.f410043m);
        r100.writeString(this.f410044n);
        r100.writeSerializable(this.f410045o);
        r100.writeParcelable(this.f410046p, r101);
        r100.writeLong(this.f410047q);
    }

    public ChatBizData(int r100, boolean r101, boolean r102, ProfileSource r103, String r104, String r105, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, Bundle r115, String r116, String r117, ChatWindowPrepareData r118, ChatIntentExtraBundle r119, long r210) {
        Intrinsics.checkNotNullParameter(r115, "applyContactsBundle");
        this.f410031a = r100;
        this.f410032b = r101;
        this.f410033c = r102;
        this.f410034d = r103;
        this.f410035e = r104;
        this.f410036f = r105;
        this.f410037g = r110;
        this.f410038h = r111;
        this.f410039i = r112;
        this.f410040j = r113;
        this.f410041k = r114;
        this.f410042l = r115;
        this.f410043m = r116;
        this.f410044n = r117;
        this.f410045o = r118;
        this.f410046p = r119;
        this.f410047q = r210;
    }
}

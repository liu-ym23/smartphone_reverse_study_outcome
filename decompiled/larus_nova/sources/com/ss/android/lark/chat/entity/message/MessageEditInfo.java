package com.ss.android.lark.chat.entity.message;

import com.alipay.sdk.m.x.d;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0096\u0002J\b\u00103\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000f¨\u00065"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageEditInfo;", "Ljava/io/Serializable;", "<init>", "()V", "editDraftId", "", "getEditDraftId", "()Ljava/lang/String;", "setEditDraftId", "(Ljava/lang/String;)V", "currentEditVersion", "", "getCurrentEditVersion", "()I", "setCurrentEditVersion", "(I)V", "lastEditTime", "", "getLastEditTime", "()J", "setLastEditTime", "(J)V", "editStatus", "Lcom/ss/android/lark/chat/entity/message/MessageEditInfo$EditStatus;", "getEditStatus", "()Lcom/ss/android/lark/chat/entity/message/MessageEditInfo$EditStatus;", "setEditStatus", "(Lcom/ss/android/lark/chat/entity/message/MessageEditInfo$EditStatus;)V", "msgType", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "getMsgType", "()Lcom/ss/android/lark/chat/entity/message/Message$Type;", "setMsgType", "(Lcom/ss/android/lark/chat/entity/message/Message$Type;)V", "title", "getTitle", d.f25925o, "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "baseEditVersion", "getBaseEditVersion", "setBaseEditVersion", "isEdited", "", "equals", "other", "", "hashCode", "EditStatus", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageEditInfo implements Serializable {
    private int baseEditVersion;
    private int currentEditVersion;
    private String editDraftId;
    private EditStatus editStatus;
    private long lastEditTime;
    private Message.Type msgType;
    private RichText richText;
    private String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageEditInfo$EditStatus;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "None", "NoRequest", "Waiting", "Failed", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EditStatus extends Enum<EditStatus> {
        public static final a Companion = null;
        public static final EditStatus Failed = null;
        public static final EditStatus NoRequest = null;
        public static final EditStatus None = null;
        public static final EditStatus Waiting = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EditStatus[] f415234a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415235b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<EditStatus> getEntries() {
            return f415235b;
        }

        static {
            EditStatus r100 = new EditStatus("None", 0, 0);
            None = r100;
            EditStatus r101 = new EditStatus("NoRequest", 1, 1);
            NoRequest = r101;
            EditStatus r102 = new EditStatus("Waiting", 2, 2);
            Waiting = r102;
            EditStatus r103 = new EditStatus("Failed", 3, 3);
            Failed = r103;
            EditStatus[] r104 = {r100, r101, r102, r103};
            f415234a = r104;
            f415235b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static EditStatus[] values() {
            return (EditStatus[]) f415234a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final EditStatus fromValue(int r100) {
            Companion.getClass();
            EditStatus[] r101 = values();
            if (r100 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L11;
            return r101[r100];
        L11:
            return None;
        L5:
            if (r100 >= r101.length) goto L7;
            r102 = true;
            goto L8
        }

        public static EditStatus valueOf(String r100) {
            return (EditStatus) r27.a.a(EditStatus.class, r100);
        }

        public EditStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public int hashCode() {
        int r100 = ((this.editDraftId.hashCode() * 31) + this.currentEditVersion) * 31;
        long r101 = this.lastEditTime;
        return ((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.editStatus.hashCode()) * 31) + this.msgType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.richText.hashCode()) * 31) + this.baseEditVersion;
    }

    public final boolean isEdited() {
        if (this.currentEditVersion <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public MessageEditInfo() {
        this.editDraftId = "";
        this.editStatus = EditStatus.None;
        this.msgType = Message.Type.UNKNOWN;
        this.title = "";
        this.richText = c.a();
    }

    public final int getBaseEditVersion() {
        return this.baseEditVersion;
    }

    public final int getCurrentEditVersion() {
        return this.currentEditVersion;
    }

    public final String getEditDraftId() {
        return this.editDraftId;
    }

    public final EditStatus getEditStatus() {
        return this.editStatus;
    }

    public final long getLastEditTime() {
        return this.lastEditTime;
    }

    public final Message.Type getMsgType() {
        return this.msgType;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MessageEditInfo) == true) goto L5;
        return false;
    L5:
        MessageEditInfo r101 = (MessageEditInfo) r100;
        if (this.currentEditVersion == r101.currentEditVersion) goto L8;
        return false;
    L8:
        if (this.lastEditTime == r101.lastEditTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.editDraftId, r101.editDraftId) == true) goto L12;
        return false;
    L12:
        if (this.editStatus == r101.editStatus) goto L14;
        return false;
    L14:
        if (this.msgType == r101.msgType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.richText, r101.richText) == true) goto L20;
        return false;
    L20:
        if (this.baseEditVersion != r101.baseEditVersion) goto L30;
        return true;
    L30:
        return false;
    }

    public final void setBaseEditVersion(int r100) {
        this.baseEditVersion = r100;
    }

    public final void setCurrentEditVersion(int r100) {
        this.currentEditVersion = r100;
    }

    public final void setEditDraftId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.editDraftId = r100;
    }

    public final void setEditStatus(EditStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.editStatus = r100;
    }

    public final void setLastEditTime(long r100) {
        this.lastEditTime = r100;
    }

    public final void setMsgType(Message.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msgType = r100;
    }

    public final void setRichText(RichText r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.richText = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }
}

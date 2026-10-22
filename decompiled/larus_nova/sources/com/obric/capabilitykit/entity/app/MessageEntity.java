package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\b\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000203H\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "text", "contacts", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;JJLjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", KevaImpl.PrivateConstants.FILES_DIR_NAME, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "setFiles", "(Ljava/util/List;)V", "groupChat", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "getGroupChat", "()Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "setGroupChat", "(Lcom/obric/capabilitykit/entity/app/GroupChatEntity;)V", "messageStatusType", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "getMessageStatusType", "()Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "setMessageStatusType", "(Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;)V", "messageType", "Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "getMessageType", "()Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "setMessageType", "(Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;)V", "getTelephones", "getText", "()Ljava/lang/String;", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessageEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 3;
    private final List<ContactEntity> contacts;
    private List<FileEntity> files;
    private GroupChatEntity groupChat;
    private MessageStatusTypeEnum messageStatusType;
    private MessageTypeEnum messageType;
    private final List<String> telephones;
    private final String text;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/MessageEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MessageEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MessageEntity");
            return (MessageEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageEntity[] newArray(int r100) {
            return new MessageEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MessageEntity(String r110, long r111, long r112, List<String> r113, String r114, List<ContactEntity> r115) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "telephones");
        Intrinsics.checkNotNullParameter(r114, "text");
        super(r110, r111, r112, 101);
        this.telephones = r113;
        this.text = r114;
        this.contacts = r115;
    }

    public /* synthetic */ MessageEntity(String r110, long r111, long r112, List r113, String r114, List r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 32) == 0) goto L5;
        List r100 = null;
    L6:
        this(r110, r111, r112, r113, r114, r100);
        return;
    L5:
        r100 = r115;
        goto L6
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r100 = this.contacts;
        if (r100 == null) goto L8;
        ContactEntity r101 = (ContactEntity) CollectionsKt.getOrNull(r100, 0);
        if (r101 == null) goto L8;
        String r102 = r101.getName();
        if (r102 == null) goto L8;
    L9:
        String r103 = r102;
        List<ContactEntity> r104 = this.contacts;
        if (r104 == null) goto L16;
        ContactEntity r105 = (ContactEntity) CollectionsKt.getOrNull(r104, 0);
        if (r105 == null) goto L16;
        FileEntity r106 = r105.getAvatar();
        if (r106 == null) goto L16;
        Uri r107 = r106.getContentUrl();
    L18:
        return new DisplayRepresentation(r107, r103, this.text, getLastModifiedTime());
    L16:
        r107 = null;
    L8:
        r102 = (String) ListProtector.get(this.telephones, 0);
        goto L9
    }

    public final List<FileEntity> getFiles() {
        return this.files;
    }

    public final GroupChatEntity getGroupChat() {
        return this.groupChat;
    }

    public final MessageStatusTypeEnum getMessageStatusType() {
        return this.messageStatusType;
    }

    public final MessageTypeEnum getMessageType() {
        return this.messageType;
    }

    public final List<String> getTelephones() {
        return this.telephones;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L6;
        this.groupChat = (GroupChatEntity) r100.readValue(r101);
        return;
    }

    public final void setFiles(List<FileEntity> r100) {
        this.files = r100;
    }

    public final void setGroupChat(GroupChatEntity r100) {
        this.groupChat = r100;
    }

    public final void setMessageStatusType(MessageStatusTypeEnum r100) {
        this.messageStatusType = r100;
    }

    public final void setMessageType(MessageTypeEnum r100) {
        this.messageType = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeStringList(this.telephones);
        r100.writeString(this.text);
        r100.writeTypedList(this.contacts);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(1);
        MessageTypeEnum r102 = this.messageType;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.name();
    L6:
        r100.writeString(r104);
        r100.writeTypedList(this.files);
        MessageStatusTypeEnum r105 = this.messageStatusType;
        if (r105 == null) goto L9;
        r103 = r105.name();
    L9:
        r100.writeString(r103);
        r100.writeValue(this.groupChat);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public MessageEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        List r103 = r110.createStringArrayList();
        if (r103 != null) goto L5;
        r103 = CollectionsKt.emptyList();
    L5:
        this(r100, r101, r102, r103, EntityExtKt.e(r110), r110.createTypedArrayList(ContactEntity.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r104 = r110.readInt();
        MessageTypeEnum.a r105 = MessageTypeEnum.Companion;
        String r106 = r110.readString();
        r105.getClass();
        MessageStatusTypeEnum r107 = null;
        if (r106 != null) goto L20;
    L11:
        MessageTypeEnum r108 = null;
    L12:
        this.messageType = r108;
        this.files = r110.createTypedArrayList(FileEntity.CREATOR);
        MessageStatusTypeEnum.a r109 = MessageStatusTypeEnum.Companion;
        String r111 = r110.readString();
        r109.getClass();
        if (r111 != null) goto L22;
    L18:
        this.messageStatusType = r107;
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r104);
        return;
    L22:
        r107 = MessageStatusTypeEnum.valueOf(r111);     // Catch: IllegalArgumentException -> L17
    L17:
        Reflection.getOrCreateKotlinClass(MessageStatusTypeEnum.class).getSimpleName();
        goto L18
    L20:
        r108 = MessageTypeEnum.valueOf(r106);     // Catch: IllegalArgumentException -> L10
    L10:
        Reflection.getOrCreateKotlinClass(MessageTypeEnum.class).getSimpleName();
        goto L11
    }
}

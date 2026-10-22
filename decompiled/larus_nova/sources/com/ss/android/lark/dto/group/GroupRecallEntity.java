package com.ss.android.lark.dto.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/dto/group/GroupRecallEntity;", "Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "pickType", "", "id", "", "name", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "writeToParcel", "", "flags", "describeContents", "CREATOR", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupRecallEntity extends PickChatEntity {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f420577c;

    public static final class a implements Parcelable.Creator<PickChatEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GroupRecallEntity(r100.readInt(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity[] newArray(int r100) {
            return new GroupRecallEntity[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.chat.entity.chat.PickChatEntity, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.chat.entity.chat.PickChatEntity, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f415165a);
        r100.writeString(this.f415166b);
        r100.writeString(this.f420577c);
    }

    public GroupRecallEntity(int r100, String r101, String r102) {
        super(r100, r101);
        this.f420577c = r102;
    }
}

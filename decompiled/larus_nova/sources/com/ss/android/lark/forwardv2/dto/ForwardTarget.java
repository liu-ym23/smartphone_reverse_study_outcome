package com.ss.android.lark.forwardv2.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.export.entity.chat.OpenChat;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardTarget implements Parcelable {
    public static final Parcelable.Creator<ForwardTarget> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f424780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f424781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f424782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Serializable f424784e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TargetType {
        public static final int CHAT = 0;
        public static final int CHATTER = 1;
        public static final int THREAD = 2;
        public static final int UNKNOWN = -1;
    }

    public class a implements Parcelable.Creator<ForwardTarget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTarget createFromParcel(Parcel r100) {
            return new ForwardTarget(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTarget[] newArray(int r100) {
            return new ForwardTarget[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final Chatter a() {
        Serializable r100 = this.f424784e;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof Chatter) == true) goto L7;
        return null;
    L7:
        return (Chatter) r100;
    }

    public final int b() {
        Serializable r100 = this.f424784e;
        if ((r100 instanceof OpenChat) == false) goto L7;
        return 0;
    L7:
        if ((r100 instanceof OpenChatter) == false) goto L11;
        return 1;
    L11:
        if ((r100 instanceof ThreadTarget) == false) goto L14;
        return 2;
    L14:
        return -1;
    }

    public final ThreadTarget c() {
        Serializable r100 = this.f424784e;
        if ((r100 instanceof ThreadTarget) == true) goto L5;
        return null;
    L5:
        return (ThreadTarget) r100;
    }

    public ForwardTarget(Parcel r100) {
        this.f424780a = r100.readString();
        this.f424781b = r100.readString();
        this.f424782c = r100.readString();
        this.f424784e = r100.readSerializable();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f424783d = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public ForwardTarget(Chat r100) {
        String r101 = r100.getId();
        String r102 = r100.getName();
        String r103 = r100.getAvatarKey();
        this.f424780a = r101;
        this.f424781b = r102;
        this.f424782c = r103;
        this.f424784e = r100;
    }

    public ForwardTarget(Chatter r100) {
        String r101 = r100.getId();
        String r102 = r100.getLocalizedName();
        String r103 = r100.getAvatarKey();
        this.f424780a = r101;
        this.f424781b = r102;
        this.f424782c = r103;
        this.f424784e = r100;
    }

    public ForwardTarget(ThreadTarget r100) {
        String r101 = r100.getId();
        String r102 = r100.getName();
        String r103 = r100.getAvatar();
        this.f424780a = r101;
        this.f424781b = r102;
        this.f424782c = r103;
        this.f424784e = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f424780a);
        r100.writeString(this.f424781b);
        r100.writeString(this.f424782c);
        r100.writeSerializable(this.f424784e);
        r100.writeByte(this.f424783d ? 1 : 0);
    }
}

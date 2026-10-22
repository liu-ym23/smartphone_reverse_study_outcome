package com.ss.android.lark.biz.im.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/biz/im/api/ChatIntentExtraBundle;", "Landroid/os/Parcelable;", "text", "", "docUrl", "photos", "", "Lcom/ss/android/lark/biz/im/api/PhotoData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getDocUrl", "getPhotos", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatIntentExtraBundle implements Parcelable {
    public static final Parcelable.Creator<ChatIntentExtraBundle> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<PhotoData> f409798c;

    public static final class a implements Parcelable.Creator<ChatIntentExtraBundle> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatIntentExtraBundle createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L10:
            return new ChatIntentExtraBundle(r101, r102, r103);
        L5:
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L6:
            if (r106 == r104) goto L8;
            r105.add(PhotoData.CREATOR.createFromParcel(r100));
            r106 = r106 + 1;
            goto L6
        L8:
            r103 = r105;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final ChatIntentExtraBundle[] newArray(int r100) {
            return new ChatIntentExtraBundle[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatIntentExtraBundle) == true) goto L8;
        return false;
    L8:
        ChatIntentExtraBundle r101 = (ChatIntentExtraBundle) r100;
        if (Intrinsics.areEqual(this.f409796a, r101.f409796a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409797b, r101.f409797b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409798c, r101.f409798c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f409796a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f409797b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<PhotoData> r107 = this.f409798c;
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

    public final String toString() {
        return "ChatIntentExtraBundle(text=" + this.f409796a + ", docUrl=" + this.f409797b + ", photos=" + this.f409798c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f409796a);
        r100.writeString(this.f409797b);
        List<PhotoData> r102 = this.f409798c;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<PhotoData> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, r101);
        goto L7
    }

    public ChatIntentExtraBundle(String r100, String r101, List<PhotoData> r102) {
        this.f409796a = r100;
        this.f409797b = r101;
        this.f409798c = r102;
    }
}

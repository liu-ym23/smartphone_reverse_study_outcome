package com.bytedance.ee.bear.content.creation.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B;\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\n\u0010\fJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020\u0003H\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;", "Landroid/os/Parcelable;", "createLocationType", "", "parentToken", "enableOfflineCreate", "", "spaceId", "ownerType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "()V", "isDefault", "()Z", "setDefault", "(Z)V", "getCreateLocationType", "()Ljava/lang/String;", "setCreateLocationType", "(Ljava/lang/String;)V", "getParentToken", "setParentToken", "getEnableOfflineCreate", "setEnableOfflineCreate", "getSpaceId", "setSpaceId", "getOwnerType", "()I", "setOwnerType", "(I)V", "isCreateInWiki", "isCreateInKnowledgeBase", "isCreateInLibraryRoot", "isCreateInMyLibrary", "isCreateNone", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "toString", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreateSelectResult implements Parcelable {
    public static final a CREATOR = null;
    public boolean a;
    public String b;
    public String c;
    public boolean d;
    public String e;
    public int f;

    public static final class a implements Parcelable.Creator<CreateSelectResult> {
        @JvmStatic
        public static CreateSelectResult b() {
            int r0 = com.bytedance.ee.bear.content.creation.location.a.a;
            CreateSelectResult r1 = com.bytedance.ee.bear.content.creation.location.a.d();
            r1.a = true;
            return r1;
        }

        public a() {
        }

        @JvmStatic
        public static CreateSelectResult c(String r2) {
            if (r2 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == true) goto L10;
            Object r3 = new Gson().fromJson(r2, CreateSelectResult.class);     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r3);     // Catch: Exception -> L13
            return (CreateSelectResult) r3;
        L13:
            e = move-exception;
            tt5.a.d("CreateSelectResult", "fromJson fail: " + e);
            return b();
        L10:
            return b();
        L4:
            if (r2.length() == 0) goto L7;
            r0 = false;
            goto L8
        }

        @JvmStatic
        public static String d(CreateSelectResult r2) {
            Intrinsics.checkNotNullParameter(r2, "createSelectResult");
            String r3 = new Gson().toJson(r2);     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
            return r3;
        L5:
            e = move-exception;
            tt5.a.d("CreateSelectResult", "toJson fail: " + e);
            return "";
        }

        @Override // android.os.Parcelable.Creator
        public final CreateSelectResult createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "source");
            CreateSelectResult r0 = new CreateSelectResult();
            boolean r2 = false;
            if (r6.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            r0.a = r1;
            r0.b = r6.readString();
            String r3 = r6.readString();
            String r4 = "";
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            r0.c = r3;
            if (r6.readByte() == 0) goto L12;
            r2 = true;
        L12:
            r0.d = r2;
            String r5 = r6.readString();
            if (r5 == null) goto L16;
            r4 = r5;
        L16:
            r0.e = r4;
            r0.f = r6.readInt();
            return r0;
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreateSelectResult[] newArray(int r1) {
            return new CreateSelectResult[r1];
        }

        @JvmStatic
        public static CreateSelectResult a(String r9, String r10, boolean r11, String r12) {
            Intrinsics.checkNotNullParameter(r9, "createLocationType");
            tt5.a.h("CreateSelectResult", "createCustomLocationResult() called with: createLocationType = " + r9 + ", parentToken = " + b.k(r10) + ", enableOfflineCreate = " + r11 + ", spaceId = " + r12);
            if (r10 != null) goto L5;
            String r4 = "";
        L6:
            if (r12 != null) goto L8;
            String r6 = "";
        L9:
            CreateSelectResult r0 = new CreateSelectResult(r9, r4, r11, r6, 0, 16);
            r0.a = false;
            return r0;
        L8:
            r6 = r12;
            goto L9
        L5:
            r4 = r10;
            goto L6
        }
    }

    static {
        CREATOR = new a();
    }

    @JvmStatic
    public static final CreateSelectResult b() {
        CREATOR.getClass();
        return a.b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean c() {
        int r0 = com.bytedance.ee.bear.content.creation.location.a.a;
        String r1 = com.bytedance.ee.bear.content.creation.location.a.e();
        if (Intrinsics.areEqual(this.b, "node") == true) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank(r1)) != true) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.e, r1) == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        r2 = false;
        goto L8
    }

    public final boolean d() {
        if (Intrinsics.areEqual(this.b, "my_document_library") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.b, "node") == true) goto L8;
        return false;
    }

    public final String toString() {
        return "createLocationType:" + this.b + " parentToken:" + b.i(this.c) + " spaceId:" + this.e + " ownerType:" + this.f + " enableOfflineCreate:" + this.d + ' ';
    }

    public CreateSelectResult() {
        this.c = "";
        this.d = true;
        this.e = "";
    }

    @JvmStatic
    public static final CreateSelectResult a(String r3) {
        CREATOR.getClass();
        Intrinsics.checkNotNullParameter("my_root_folder", "createLocationType");
        return a.a("my_root_folder", r3, true, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeByte(this.a ? 1 : 0);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeString(this.e);
        r1.writeInt(this.f);
    }

    public CreateSelectResult(String r3, String r4, boolean r5, String r6, int r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = true;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = "";
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r4, "parentToken");
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}

package com.bytedance.ee.bear.content.creation.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B;\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\n\u0010\fJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020\u0003H\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/content/creation/location/CreateSelectResult;", "Landroid/os/Parcelable;", "createLocationType", "", "parentToken", "enableOfflineCreate", "", "spaceId", "ownerType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "()V", "isDefault", "()Z", "setDefault", "(Z)V", "getCreateLocationType", "()Ljava/lang/String;", "setCreateLocationType", "(Ljava/lang/String;)V", "getParentToken", "setParentToken", "getEnableOfflineCreate", "setEnableOfflineCreate", "getSpaceId", "setSpaceId", "getOwnerType", "()I", "setOwnerType", "(I)V", "isCreateInWiki", "isCreateInKnowledgeBase", "isCreateInLibraryRoot", "isCreateInMyLibrary", "isCreateNone", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "toString", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreateSelectResult implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f216824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f216825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f216826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f216827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f216828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f216829f;

    public static final class a implements Parcelable.Creator<CreateSelectResult> {
        @JvmStatic
        public static CreateSelectResult b() {
            int r100 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
            CreateSelectResult r101 = com.bytedance.ee.bear.content.creation.location.a.d();
            r101.f216824a = true;
            return r101;
        }

        public a() {
        }

        @JvmStatic
        public static CreateSelectResult c(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == true) goto L10;
            Object r102 = new Gson().fromJson(r100, CreateSelectResult.class);     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r102);     // Catch: Exception -> L13
            return (CreateSelectResult) r102;
        L13:
            e = move-exception;
            tt5.a.d("CreateSelectResult", "fromJson fail: " + e);
            return b();
        L10:
            return b();
        L4:
            if (r100.length() == 0) goto L7;
            r101 = false;
            goto L8
        }

        @JvmStatic
        public static String d(CreateSelectResult r100) {
            Intrinsics.checkNotNullParameter(r100, "createSelectResult");
            String r101 = new Gson().toJson(r100);     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r101);     // Catch: Exception -> L5
            return r101;
        L5:
            e = move-exception;
            tt5.a.d("CreateSelectResult", "toJson fail: " + e);
            return "";
        }

        @Override // android.os.Parcelable.Creator
        public final CreateSelectResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            CreateSelectResult r101 = new CreateSelectResult();
            boolean r102 = false;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            r101.f216824a = r103;
            r101.f216825b = r100.readString();
            String r104 = r100.readString();
            String r105 = "";
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r101.f216826c = r104;
            if (r100.readByte() == 0) goto L12;
            r102 = true;
        L12:
            r101.f216827d = r102;
            String r106 = r100.readString();
            if (r106 == null) goto L16;
            r105 = r106;
        L16:
            r101.f216828e = r105;
            r101.f216829f = r100.readInt();
            return r101;
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreateSelectResult[] newArray(int r100) {
            return new CreateSelectResult[r100];
        }

        @JvmStatic
        public static CreateSelectResult a(String r100, String r110, boolean r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "createLocationType");
            tt5.a.h("CreateSelectResult", "createCustomLocationResult() called with: createLocationType = " + r100 + ", parentToken = " + b.k(r110) + ", enableOfflineCreate = " + r111 + ", spaceId = " + r112);
            if (r110 != null) goto L5;
            String r101 = "";
        L6:
            if (r112 != null) goto L8;
            String r102 = "";
        L9:
            CreateSelectResult r103 = new CreateSelectResult(r100, r101, r111, r102, 0, 16);
            r103.f216824a = false;
            return r103;
        L8:
            r102 = r112;
            goto L9
        L5:
            r101 = r110;
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
        int r100 = com.bytedance.ee.bear.content.creation.location.a.f216830a;
        String r101 = com.bytedance.ee.bear.content.creation.location.a.e();
        if (Intrinsics.areEqual(this.f216825b, "node") == true) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank(r101)) != true) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f216828e, r101) == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    public final boolean d() {
        if (Intrinsics.areEqual(this.f216825b, "my_document_library") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f216825b, "node") == true) goto L8;
        return false;
    }

    public final String toString() {
        return "createLocationType:" + this.f216825b + " parentToken:" + b.i(this.f216826c) + " spaceId:" + this.f216828e + " ownerType:" + this.f216829f + " enableOfflineCreate:" + this.f216827d + ' ';
    }

    public CreateSelectResult() {
        this.f216826c = "";
        this.f216827d = true;
        this.f216828e = "";
    }

    @JvmStatic
    public static final CreateSelectResult a(String r100) {
        CREATOR.getClass();
        Intrinsics.checkNotNullParameter("my_root_folder", "createLocationType");
        return a.a("my_root_folder", r100, true, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeByte(this.f216824a ? 1 : 0);
        r100.writeString(this.f216825b);
        r100.writeString(this.f216826c);
        r100.writeByte(this.f216827d ? 1 : 0);
        r100.writeString(this.f216828e);
        r100.writeInt(this.f216829f);
    }

    public CreateSelectResult(String r100, String r101, boolean r102, String r103, int r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = true;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = "";
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r101, "parentToken");
        Intrinsics.checkNotNullParameter(r103, "spaceId");
        this.f216825b = r100;
        this.f216826c = r101;
        this.f216827d = r102;
        this.f216828e = r103;
        this.f216829f = r104;
    }
}

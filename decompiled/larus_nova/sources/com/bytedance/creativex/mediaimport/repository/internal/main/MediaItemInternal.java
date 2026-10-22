package com.bytedance.creativex.mediaimport.repository.internal.main;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IMediaItem;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import ki4.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ri4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B°\u0001\u0012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010;\u001a\u00020<2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0=H\u0016J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0096\u0002J\b\u0010B\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010D\u001a\u00020\u000bH\u0016J\u000e\u0010E\u001a\u00070\u0003¢\u0006\u0002\b\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\t\u0010I\u001a\u00020\u000bHÂ\u0003J\t\u0010J\u001a\u00020\rHÆ\u0003J\t\u0010K\u001a\u00020\rHÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0018HÂ\u0003Jº\u0001\u0010U\u001a\u00020\u00002\r\b\u0002\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\u0006\u0010V\u001a\u00020\rJ\u0016\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\rR\u0019\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000e\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u0014\u0010\u000f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0014\u0010\u0010\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0014\u0010\u0016\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010+R\u0010\u00103\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b08X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006["}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/internal/main/MediaItemInternal;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMediaItem;", "sourceType", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialSourceType;", "Lkotlinx/android/parcel/RawValue;", "type", "Lcom/bytedance/creativex/mediaimport/repository/api/MediaType;", "date", "", "id", "pathBeforeQ", "", "width", "", "height", "size", "duration", "folderId", "folderName", SubInfo.KEY_FORMAT, "name", "relativePath", "version", "prebuiltUri", "Landroid/net/Uri;", "<init>", "(Lcom/bytedance/creativex/mediaimport/repository/api/MaterialSourceType;Lcom/bytedance/creativex/mediaimport/repository/api/MediaType;JJLjava/lang/String;IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/net/Uri;)V", "getSourceType", "()Lcom/bytedance/creativex/mediaimport/repository/api/MaterialSourceType;", "getType", "()Lcom/bytedance/creativex/mediaimport/repository/api/MediaType;", "getDate", "()J", "getId", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getSize", "getDuration", "getFolderId", "()Ljava/lang/String;", "getFolderName", "getFormat", "getName", "getRelativePath", "getVersion", "path", "getPath", "uriInternal", "uri", "getUri", "()Landroid/net/Uri;", PromotionProductPrivilegesStruct.TAGS, "", "getTags", "()Ljava/util/List;", "addTags", "", "", "equals", "", "other", "", "hashCode", "duplicate", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaItemInternal implements IMediaItem {
    public static final Parcelable.Creator<MediaItemInternal> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f203640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f203641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f203642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f203643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f203644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f203645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f203646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f203647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f203648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f203649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f203650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f203651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f203652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f203653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f203654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Uri f203655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Uri f203656q;

    public static final class a implements Parcelable.Creator<MediaItemInternal> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaItemInternal createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            return new MediaItemInternal((e0) r210.readValue(MediaItemInternal.class.getClassLoader()), MediaType.valueOf(r210.readString()), r210.readLong(), r210.readLong(), r210.readString(), r210.readInt(), r210.readInt(), r210.readLong(), r210.readLong(), r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.readInt(), (Uri) r210.readParcelable(MediaItemInternal.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final MediaItemInternal[] newArray(int r100) {
            return new MediaItemInternal[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeValue(this.f203640a);
        r100.writeString(this.f203641b.name());
        r100.writeLong(this.f203642c);
        r100.writeLong(this.f203643d);
        r100.writeString(this.f203644e);
        r100.writeInt(this.f203645f);
        r100.writeInt(this.f203646g);
        r100.writeLong(this.f203647h);
        r100.writeLong(this.f203648i);
        r100.writeString(this.f203649j);
        r100.writeString(this.f203650k);
        r100.writeString(this.f203651l);
        r100.writeString(this.f203652m);
        r100.writeString(this.f203653n);
        r100.writeInt(this.f203654o);
        r100.writeParcelable(this.f203655p, r101);
    }

    @Override // ki4.r
    public final Uri getUri() {
        Uri r100 = this.f203655p;
        if (r100 != null) goto L11;
        Uri r101 = this.f203656q;
        if (r101 == null) goto L7;
        return r101;
    L7:
        if (b.b() == false) goto L9;
        Uri r102 = ContentUris.withAppendedId(getType().getContentUri(), this.f203643d);
        this.f203656q = r102;
        return r102;
    L9:
        Uri r103 = Uri.fromFile(new PolarisFileWrapper(this.f203644e));
        this.f203656q = r103;
        Intrinsics.checkNotNull(r103);
        return r103;
    L11:
        return r100;
    }

    public final String toString() {
        return "MediaItem(id=" + this.f203643d + ", name=" + this.f203652m + ", folderName=" + this.f203650k + ", type=" + getType() + ", width=" + this.f203645f + ", height=" + this.f203646g + ", duration=" + this.f203648i + ", path='" + getPath() + "')";
    }

    @Override // ki4.r
    public final String getPath() {
        if (b.b() == false) goto L6;
        return getUri().toString();
    L6:
        return this.f203644e;
    }

    public final int hashCode() {
        return getPath().hashCode();
    }

    @Override // ki4.r
    public final long getDate() {
        return this.f203642c;
    }

    @Override // ki4.r
    public final long getDuration() {
        return this.f203648i;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IMediaItem
    public final String getFolderName() {
        return this.f203650k;
    }

    @Override // ki4.r
    public final String getFormat() {
        return this.f203651l;
    }

    @Override // ki4.r
    public final int getHeight() {
        return this.f203646g;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IMediaItem
    public final String getRelativePath() {
        return this.f203653n;
    }

    @Override // ki4.r
    public final long getSize() {
        return this.f203647h;
    }

    @Override // ki4.r
    public final e0 getSourceType() {
        return this.f203640a;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IMediaItem, ki4.r
    public MediaType getType() {
        return this.f203641b;
    }

    @Override // ki4.r
    public final int getVersion() {
        return this.f203654o;
    }

    @Override // ki4.r
    public final int getWidth() {
        return this.f203645f;
    }

    @Override // ki4.r
    public final MediaItemInternal a(int r210) {
        e0 r100 = this.f203640a;
        MediaType r110 = this.f203641b;
        long r101 = this.f203642c;
        long r102 = this.f203643d;
        String r111 = this.f203644e;
        int r103 = this.f203645f;
        int r112 = this.f203646g;
        long r113 = this.f203647h;
        long r114 = this.f203648i;
        String r115 = this.f203649j;
        String r104 = this.f203650k;
        String r105 = this.f203651l;
        String r106 = this.f203652m;
        String r107 = this.f203653n;
        Uri r108 = this.f203655p;
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "pathBeforeQ");
        return new MediaItemInternal(r100, r110, r101, r102, r111, r103, r112, r113, r114, r115, r104, r105, r106, r107, r210, r108);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaItemInternal) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(getPath(), ((MediaItemInternal) r100).getPath()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // ki4.r
    public final void setHeight(int r100) {
        this.f203646g = r100;
    }

    @Override // ki4.r
    public final void setWidth(int r100) {
        this.f203645f = r100;
    }

    public /* synthetic */ MediaItemInternal(BuiltInMaterialType r210, MediaType r211, long r212, long r310, String r311, int r312, int r313, long r314, long r315, String r316, String r410, String r411, String r412, String r413, Uri r414, int r415) {
        if ((r415 & 4) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r415 & 8) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r415 & 16) == 0) goto L13;
        String r110 = "";
    L15:
        if ((r415 & 128) == 0) goto L17;
        long r111 = 0;
    L19:
        if ((r415 & 256) == 0) goto L21;
        long r112 = 0;
    L23:
        if ((r415 & 512) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r415 & 1024) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r415 & 2048) == 0) goto L33;
        String r213 = null;
    L35:
        if ((r415 & 4096) == 0) goto L37;
        String r214 = null;
    L39:
        if ((r415 & 8192) == 0) goto L41;
        String r215 = null;
    L43:
        if ((r415 & 16384) == 0) goto L45;
        int r216 = -1;
    L47:
        if ((r415 & 32768) == 0) goto L49;
        Uri r217 = null;
    L50:
        this(r210, r211, r100, r101, r110, r312, r313, r111, r112, r113, r114, r213, r214, r215, r216, r217);
        return;
    L49:
        r217 = r414;
        goto L50
    L45:
        r216 = 0;
        goto L47
    L41:
        r215 = r413;
        goto L43
    L37:
        r214 = r412;
        goto L39
    L33:
        r213 = r411;
        goto L35
    L29:
        r114 = r410;
        goto L31
    L25:
        r113 = r316;
        goto L27
    L21:
        r112 = r315;
        goto L23
    L17:
        r111 = r314;
        goto L19
    L13:
        r110 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public MediaItemInternal(e0 r100, MediaType r101, long r102, long r110, String r111, int r112, int r113, long r114, long r115, String r116, String r210, String r211, String r212, String r213, int r214, Uri r215) {
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r111, "pathBeforeQ");
        this.f203640a = r100;
        this.f203641b = r101;
        this.f203642c = r102;
        this.f203643d = r110;
        this.f203644e = r111;
        this.f203645f = r112;
        this.f203646g = r113;
        this.f203647h = r114;
        this.f203648i = r115;
        this.f203649j = r116;
        this.f203650k = r210;
        this.f203651l = r211;
        this.f203652m = r212;
        this.f203653n = r213;
        this.f203654o = r214;
        this.f203655p = r215;
        new ArrayList();
    }
}

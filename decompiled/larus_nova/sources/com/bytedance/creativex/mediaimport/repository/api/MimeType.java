package com.bytedance.creativex.mediaimport.repository.api;

import androidx.collection.ArraySet;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Set;
import ki4.f0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/MimeType;", "", DBDefinition.MIME_TYPE, "", "extensions", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;)V", "getMimeType", "()Ljava/lang/String;", "getExtensions", "()Ljava/util/Set;", "JPG", "JPEG", "PNG", "GIF", "WEBP", "HEIC", "HEIF", "BMP", "MP4", "MKV", "TS", "AVI", "MPEG", "THREEGPP", "THREEGPP2", "QUICKTIME", "WEBM", "toString", "Companion", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MimeType extends Enum<MimeType> {
    public static final MimeType AVI = null;
    public static final MimeType BMP = null;
    public static final a Companion = null;
    public static final MimeType GIF = null;
    public static final MimeType HEIC = null;
    public static final MimeType HEIF = null;
    public static final MimeType JPEG = null;
    public static final MimeType JPG = null;
    public static final MimeType MKV = null;
    public static final MimeType MP4 = null;
    public static final MimeType MPEG = null;
    public static final MimeType PNG = null;
    public static final MimeType QUICKTIME = null;
    public static final MimeType THREEGPP = null;
    public static final MimeType THREEGPP2 = null;
    public static final MimeType TS = null;
    public static final MimeType WEBM = null;
    public static final MimeType WEBP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MimeType[] f203615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203616b = null;
    private final Set<String> extensions;
    private final String mimeType;

    public static final class a {
        public a() {
        }

        public static ArraySet a(boolean r100) {
            ArraySet r101 = f0.a(new MimeType[]{MimeType.JPG, MimeType.JPEG, MimeType.PNG, MimeType.WEBP, MimeType.HEIC, MimeType.HEIF, MimeType.BMP});
            if (r100 == false) goto L5;
            MimeType r102 = MimeType.GIF;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            r101.add(r102);
        L5:
            return r101;
        }
    }

    public static EnumEntries<MimeType> getEntries() {
        return f203616b;
    }

    static {
        MimeType r100 = new MimeType("JPG", 0, "image/jpg", f0.a(new String[]{"jpg"}));
        JPG = r100;
        MimeType r101 = new MimeType("JPEG", 1, "image/jpeg", f0.a(new String[]{LoadParams.ImageFormat.JPEG}));
        JPEG = r101;
        MimeType r102 = new MimeType("PNG", 2, "image/png", f0.a(new String[]{LoadParams.ImageFormat.PNG}));
        PNG = r102;
        MimeType r103 = new MimeType("GIF", 3, com.ss.android.downloadlib.constants.MimeType.GIF, f0.a(new String[]{"gif"}));
        GIF = r103;
        MimeType r104 = new MimeType("WEBP", 4, com.ss.android.downloadlib.constants.MimeType.WEBP, f0.a(new String[]{"webp"}));
        WEBP = r104;
        MimeType r105 = new MimeType("HEIC", 5, "image/heic", f0.a(new String[]{"heic"}));
        HEIC = r105;
        MimeType r110 = new MimeType("HEIF", 6, "image/heif", f0.a(new String[]{"heic"}));
        HEIF = r110;
        MimeType r106 = new MimeType("BMP", 7, "image/x-ms-bmp", f0.a(new String[]{"bmp"}));
        BMP = r106;
        MimeType r111 = new MimeType("MP4", 8, com.ss.android.downloadlib.constants.MimeType.MP4, f0.a(new String[]{"mp4", "m4v"}));
        MP4 = r111;
        MimeType r112 = new MimeType("MKV", 9, "video/x-matroska", f0.a(new String[]{"mkv"}));
        MKV = r112;
        MimeType r113 = new MimeType("TS", 10, "video/mp2ts", f0.a(new String[]{"ts"}));
        TS = r113;
        MimeType r107 = new MimeType("AVI", 11, "video/avi", f0.a(new String[]{"avi"}));
        AVI = r107;
        MimeType r108 = new MimeType("MPEG", 12, "video/mpeg", f0.a(new String[]{"mpeg", "mpg"}));
        MPEG = r108;
        MimeType r109 = new MimeType("THREEGPP", 13, "video/3gpp", f0.a(new String[]{"3gp", "3gpp"}));
        THREEGPP = r109;
        MimeType r114 = new MimeType("THREEGPP2", 14, "video/3gpp2", f0.a(new String[]{"3g2", "3gpp2"}));
        THREEGPP2 = r114;
        MimeType r115 = new MimeType("QUICKTIME", 15, com.ss.android.downloadlib.constants.MimeType.MOV, f0.a(new String[]{"mov"}));
        QUICKTIME = r115;
        MimeType r116 = new MimeType("WEBM", 16, "video/webm", f0.a(new String[]{"webm"}));
        WEBM = r116;
        MimeType[] r117 = {r100, r101, r102, r103, r104, r105, r110, r106, r111, r112, r113, r107, r108, r109, r114, r115, r116};
        f203615a = r117;
        f203616b = EnumEntriesKt.enumEntries(r117);
        Companion = new a();
    }

    public static MimeType[] values() {
        return (MimeType[]) f203615a.clone();
    }

    public final Set<String> getExtensions() {
        return this.extensions;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mimeType;
    }

    public static MimeType valueOf(String r100) {
        return (MimeType) r27.a.a(MimeType.class, r100);
    }

    public MimeType(String r100, int r101, String r102, ArraySet r103) {
        super(r100, r101);
        this.mimeType = r102;
        this.extensions = r103;
    }
}

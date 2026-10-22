package com.ss.android.lark.imageqrcode;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.utils.FileUtils;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u00060"}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "Ljava/io/Serializable;", "<init>", "()V", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "path", "getPath", "setPath", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "scaleType", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "getScaleType", "()Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "setScaleType", "(Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;)V", "contentList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/imageqrcode/QRCodeContentInfo;", "Lkotlin/collections/ArrayList;", "getContentList", "()Ljava/util/ArrayList;", "setContentList", "(Ljava/util/ArrayList;)V", "requestCode", "", "getRequestCode", "()Ljava/lang/Integer;", "setRequestCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "scanType", "getScanType", "setScanType", "isInValid", "", "toString", "Builder", "ScaleType", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QRCodeShowParam implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Bitmap f426638a;
    private ArrayList<QRCodeContentInfo> contentList;
    private String from;
    private String path;
    private Integer requestCode;
    private ScaleType scaleType;
    private String scanType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "", "<init>", "(Ljava/lang/String;I)V", "FIT_CENTER", "CENTER_CROP", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType CENTER_CROP = null;
        public static final ScaleType FIT_CENTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScaleType[] f426639a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426640b = null;

        public static EnumEntries<ScaleType> getEntries() {
            return f426640b;
        }

        static {
            ScaleType r100 = new ScaleType("FIT_CENTER", 0);
            FIT_CENTER = r100;
            ScaleType r101 = new ScaleType("CENTER_CROP", 1);
            CENTER_CROP = r101;
            ScaleType[] r102 = {r100, r101};
            f426639a = r102;
            f426640b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) f426639a.clone();
        }

        public static ScaleType valueOf(String r100) {
            return (ScaleType) a.a(ScaleType.class, r100);
        }

        public ScaleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ QRCodeShowParam(DefaultConstructorMarker r100) {
        this();
    }

    public final boolean isInValid() {
        if (FileUtils.r(this.path) == true) goto L7;
        int r100 = com.ss.android.lark.imageqrcode.utils.a.f426671a;
        if (com.ss.android.lark.imageqrcode.utils.a.c(this.f426638a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.contentList.isEmpty() == true) goto L8;
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("from:");
        r100.append(this.from);
        r100.append(",path:");
        r100.append(this.path);
        r100.append(",bitmap is null:");
        if (this.f426638a != null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append(",scaleType:");
        r100.append(this.scaleType);
        r100.append(",resultList:");
        r100.append(this.contentList);
        r100.append(",requestCode:");
        r100.append(this.requestCode);
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    private QRCodeShowParam() {
        this.from = "default";
        this.scaleType = ScaleType.FIT_CENTER;
        this.contentList = new ArrayList();
        this.scanType = "other";
    }

    public final Bitmap getBitmap() {
        return this.f426638a;
    }

    public final ArrayList<QRCodeContentInfo> getContentList() {
        return this.contentList;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getRequestCode() {
        return this.requestCode;
    }

    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public final String getScanType() {
        return this.scanType;
    }

    public final void setBitmap(Bitmap r100) {
        this.f426638a = r100;
    }

    public final void setContentList(ArrayList<QRCodeContentInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentList = r100;
    }

    public final void setFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.from = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setRequestCode(Integer r100) {
        this.requestCode = r100;
    }

    public final void setScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scaleType = r100;
    }

    public final void setScanType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scanType = r100;
    }
}

package com.ss.android.lark.imageocr_export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/imageocr_export/OCRScene;", "", "<init>", "(Ljava/lang/String;I)V", "OCR", "SCRATCH", "imageocr_export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OCRScene extends Enum<OCRScene> {
    public static final OCRScene OCR = null;
    public static final OCRScene SCRATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OCRScene[] f426636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426637b = null;

    public static EnumEntries<OCRScene> getEntries() {
        return f426637b;
    }

    static {
        OCRScene r100 = new OCRScene("OCR", 0);
        OCR = r100;
        OCRScene r101 = new OCRScene("SCRATCH", 1);
        SCRATCH = r101;
        OCRScene[] r102 = {r100, r101};
        f426636a = r102;
        f426637b = EnumEntriesKt.enumEntries(r102);
    }

    public static OCRScene[] values() {
        return (OCRScene[]) f426636a.clone();
    }

    public static OCRScene valueOf(String r100) {
        return (OCRScene) a.a(OCRScene.class, r100);
    }

    public OCRScene(String r100, int r101) {
        super(r100, r101);
    }
}

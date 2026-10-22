package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class QrCodeMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PixelType> f274252b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix$PixelType;", "", "DarkPixel", "LightPixel", "Background", "Logo", "VersionEye", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
    public static final enum PixelType extends Enum<PixelType> {
        public static final PixelType Background = null;
        public static final PixelType DarkPixel = null;
        public static final PixelType LightPixel = null;
        public static final PixelType Logo = null;
        public static final PixelType VersionEye = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PixelType[] f274253a = null;

        public static PixelType valueOf(String r100) {
            return (PixelType) r27.a.a(PixelType.class, r100);
        }

        public static PixelType[] values() {
            return (PixelType[]) f274253a.clone();
        }

        static {
            PixelType r100 = new PixelType("DarkPixel", 0);
            DarkPixel = r100;
            PixelType r101 = new PixelType("LightPixel", 1);
            LightPixel = r101;
            PixelType r102 = new PixelType("Background", 2);
            Background = r102;
            PixelType r103 = new PixelType("Logo", 3);
            Logo = r103;
            PixelType r104 = new PixelType("VersionEye", 4);
            VersionEye = r104;
            f274253a = new PixelType[]{r100, r101, r102, r103, r104};
        }

        public PixelType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public QrCodeMatrix(int r100) {
        this.f274251a = r100;
        int r101 = r100 * r100;
        ArrayList r102 = new ArrayList(r101);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102.add(PixelType.Background);
        r103 = r103 + 1;
        goto L3
    L5:
        this.f274252b = r102;
    }

    public final PixelType a(int r100, int r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        Integer r104 = Integer.valueOf(r100);
    L17:
        if (r104 != null) goto L21;
        return (PixelType) ListProtector.get(this.f274252b, r100 + (r101 * this.f274251a));
    L21:
        throw new IndexOutOfBoundsException("Index " + r104 + " is out of 0.." + (this.f274251a - 1) + " matrix bound");
    L10:
        if (r101 >= 0) goto L12;
    L14:
        if (r102 == true) goto L16;
        r104 = Integer.valueOf(r101);
        goto L17
    L16:
        r104 = null;
        goto L17
    L12:
        if (r101 >= this.f274251a) goto L14;
        r102 = true;
        goto L14
    L5:
        if (r100 >= this.f274251a) goto L7;
        r103 = true;
        goto L8
    }

    public final void b(int r100, int r101, PixelType r102) {
        Intrinsics.checkNotNullParameter(r102, "type");
        boolean r103 = false;
        if (r100 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        Integer r105 = Integer.valueOf(r100);
    L17:
        if (r105 != null) goto L21;
        ListProtector.set(this.f274252b, r100 + (r101 * this.f274251a), r102);
        return;
    L21:
        throw new IndexOutOfBoundsException("Index " + r105 + " is out of 0.." + (this.f274251a - 1) + " matrix bound");
    L10:
        if (r101 >= 0) goto L12;
    L14:
        if (r103 == true) goto L16;
        r105 = Integer.valueOf(r101);
        goto L17
    L16:
        r105 = null;
        goto L17
    L12:
        if (r101 >= this.f274251a) goto L14;
        r103 = true;
        goto L14
    L5:
        if (r100 >= this.f274251a) goto L7;
        r104 = true;
        goto L8
    }
}

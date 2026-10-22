package com.ss.android.lark.larkicon.transform;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import xpb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class ImgForegroundTransform extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f431156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f431157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gravity f431158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f431159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f431160e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/larkicon/transform/ImgForegroundTransform$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LeftTop", "LeftBottom", "RightTop", "RightBottom", "lark-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity LeftBottom = null;
        public static final Gravity LeftTop = null;
        public static final Gravity RightBottom = null;
        public static final Gravity RightTop = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gravity[] f431161a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431162b = null;

        public static EnumEntries<Gravity> getEntries() {
            return f431162b;
        }

        static {
            Gravity r100 = new Gravity("LeftTop", 0);
            LeftTop = r100;
            Gravity r101 = new Gravity("LeftBottom", 1);
            LeftBottom = r101;
            Gravity r102 = new Gravity("RightTop", 2);
            RightTop = r102;
            Gravity r103 = new Gravity("RightBottom", 3);
            RightBottom = r103;
            Gravity[] r104 = {r100, r101, r102, r103};
            f431161a = r104;
            f431162b = EnumEntriesKt.enumEntries(r104);
        }

        public static Gravity[] values() {
            return (Gravity[]) f431161a.clone();
        }

        public static Gravity valueOf(String r100) {
            return (Gravity) r27.a.a(Gravity.class, r100);
        }

        public Gravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f431163a = null;

        static {
            int[] r100 = new int[Gravity.values().length];
            r100[Gravity.LeftBottom.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Gravity.RightTop.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Gravity.RightBottom.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f431163a = r100;
        }
    }

    public ImgForegroundTransform(Drawable r100, Gravity r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f431158c = Gravity.LeftTop;
        this.f431156a = r100;
        this.f431158c = r101;
        this.f431159d = null;
        this.f431160e = null;
    }
}

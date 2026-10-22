package com.larus.slides.impl.select;

import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemGenerateImageBinding;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemGenerateImageBinding;", "defaultWidth", "", "defaultHeight", "onFinalImageSet", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "<init>", "(Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemGenerateImageBinding;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "bindData", "data", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "position", "showSparklesLottieAnim", "GenerateImageItemData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerateImageViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f369588e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusSlidesItemGenerateImageBinding f369589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f369590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f369591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f369592d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f369593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f369594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f369595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f369596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f369597e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f369598f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f369599g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f369600h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f369601i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f369593a == r101.f369593a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f369594b, r101.f369594b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f369595c, r101.f369595c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f369596d, r101.f369596d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f369597e, r101.f369597e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f369598f, r101.f369598f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f369599g, r101.f369599g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f369600h, r101.f369600h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f369601i, r101.f369601i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            if (this.f369593a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f369594b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f369595c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f369596d;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f369597e;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f369598f;
            if (r115 != null) goto L25;
            int r116 = 0;
        L26:
            int r117 = (r114 + r116) * 31;
            Integer r118 = this.f369599g;
            if (r118 != null) goto L29;
            int r119 = 0;
        L30:
            int r120 = (r117 + r119) * 31;
            Integer r121 = this.f369600h;
            if (r121 != null) goto L33;
            int r122 = 0;
        L34:
            int r123 = (r120 + r122) * 31;
            Integer r124 = this.f369601i;
            if (r124 == null) goto L39;
            r103 = r124.hashCode();
        L39:
            return r123 + r103;
        L33:
            r122 = r121.hashCode();
            goto L34
        L29:
            r119 = r118.hashCode();
            goto L30
        L25:
            r116 = r115.hashCode();
            goto L26
        L21:
            r113 = r112.hashCode();
            goto L22
        L17:
            r110 = r109.hashCode();
            goto L18
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "GenerateImageItemData(isError=" + this.f369593a + ", previewUrl=" + this.f369594b + ", downloadUrl=" + this.f369595c + ", url=" + this.f369596d + ", uri=" + this.f369597e + ", prompt=" + this.f369598f + ", progress=" + this.f369599g + ", width=" + this.f369600h + ", height=" + this.f369601i + ')';
        }

        public static b a(b r110, Integer r111, Integer r112, Integer r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            boolean r100 = r110.f369593a;
        L7:
            if ((r114 & 2) == 0) goto L9;
            String r101 = r110.f369594b;
        L11:
            if ((r114 & 4) == 0) goto L13;
            String r102 = r110.f369595c;
        L15:
            if ((r114 & 8) == 0) goto L17;
            String r103 = r110.f369596d;
        L19:
            if ((r114 & 16) == 0) goto L21;
            String r104 = r110.f369597e;
        L23:
            if ((r114 & 32) == 0) goto L25;
            String r105 = r110.f369598f;
        L27:
            if ((r114 & 64) == 0) goto L29;
            r111 = r110.f369599g;
        L29:
            Integer r106 = r111;
            if ((r114 & 128) == 0) goto L32;
            r112 = r110.f369600h;
        L32:
            Integer r107 = r112;
            if ((r114 & 256) == 0) goto L35;
            r113 = r110.f369601i;
        L35:
            r110.getClass();
            return new b(r100, r101, r102, r103, r104, r105, r106, r107, r113);
        L25:
            r105 = null;
            goto L27
        L21:
            r104 = null;
            goto L23
        L17:
            r103 = null;
            goto L19
        L13:
            r102 = null;
            goto L15
        L9:
            r101 = null;
            goto L11
        L5:
            r100 = false;
            goto L7
        }

        public b(boolean r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, Integer r108) {
            this.f369593a = r100;
            this.f369594b = r101;
            this.f369595c = r102;
            this.f369596d = r103;
            this.f369597e = r104;
            this.f369598f = r105;
            this.f369599g = r106;
            this.f369600h = r107;
            this.f369601i = r108;
        }
    }

    static {
    }

    public GenerateImageViewHolder(LarusSlidesItemGenerateImageBinding r100, Integer r101, Integer r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100);
        this.f369589a = r100;
        this.f369590b = r101;
        this.f369591c = r102;
        this.f369592d = r103;
        w0.e(r100.f369350c, c7.b(16));
    }
}

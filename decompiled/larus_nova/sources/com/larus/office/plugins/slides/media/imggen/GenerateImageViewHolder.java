package com.larus.office.plugins.slides.media.imggen;

import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.office.impl.databinding.LarusSdkSlidesItemGenerateImageBinding;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/office/plugins/slides/media/imggen/GenerateImageViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/office/impl/databinding/LarusSdkSlidesItemGenerateImageBinding;", "defaultWidth", "", "defaultHeight", "onFinalImageSet", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "<init>", "(Lcom/larus/office/impl/databinding/LarusSdkSlidesItemGenerateImageBinding;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "bindData", "data", "Lcom/larus/office/plugins/slides/media/imggen/GenerateImageViewHolder$GenerateImageItemData;", "position", "showSparklesLottieAnim", "GenerateImageItemData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerateImageViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f363305e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusSdkSlidesItemGenerateImageBinding f363306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f363307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f363308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f363309d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f363310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f363311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f363312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f363313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f363314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f363315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f363316g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f363317h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f363318i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f363310a == r101.f363310a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f363311b, r101.f363311b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f363312c, r101.f363312c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f363313d, r101.f363313d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f363314e, r101.f363314e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f363315f, r101.f363315f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f363316g, r101.f363316g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f363317h, r101.f363317h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f363318i, r101.f363318i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            if (this.f363310a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f363311b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f363312c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f363313d;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f363314e;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f363315f;
            if (r115 != null) goto L25;
            int r116 = 0;
        L26:
            int r117 = (r114 + r116) * 31;
            Integer r118 = this.f363316g;
            if (r118 != null) goto L29;
            int r119 = 0;
        L30:
            int r120 = (r117 + r119) * 31;
            Integer r121 = this.f363317h;
            if (r121 != null) goto L33;
            int r122 = 0;
        L34:
            int r123 = (r120 + r122) * 31;
            Integer r124 = this.f363318i;
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
            return "GenerateImageItemData(isError=" + this.f363310a + ", previewUrl=" + this.f363311b + ", downloadUrl=" + this.f363312c + ", url=" + this.f363313d + ", uri=" + this.f363314e + ", prompt=" + this.f363315f + ", progress=" + this.f363316g + ", width=" + this.f363317h + ", height=" + this.f363318i + ')';
        }

        public static b a(b r110, Integer r111, Integer r112, Integer r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            boolean r100 = r110.f363310a;
        L7:
            if ((r114 & 2) == 0) goto L9;
            String r101 = r110.f363311b;
        L11:
            if ((r114 & 4) == 0) goto L13;
            String r102 = r110.f363312c;
        L15:
            if ((r114 & 8) == 0) goto L17;
            String r103 = r110.f363313d;
        L19:
            if ((r114 & 16) == 0) goto L21;
            String r104 = r110.f363314e;
        L23:
            if ((r114 & 32) == 0) goto L25;
            String r105 = r110.f363315f;
        L27:
            if ((r114 & 64) == 0) goto L29;
            r111 = r110.f363316g;
        L29:
            Integer r106 = r111;
            if ((r114 & 128) == 0) goto L32;
            r112 = r110.f363317h;
        L32:
            Integer r107 = r112;
            if ((r114 & 256) == 0) goto L35;
            r113 = r110.f363318i;
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
            this.f363310a = r100;
            this.f363311b = r101;
            this.f363312c = r102;
            this.f363313d = r103;
            this.f363314e = r104;
            this.f363315f = r105;
            this.f363316g = r106;
            this.f363317h = r107;
            this.f363318i = r108;
        }
    }

    static {
    }

    public GenerateImageViewHolder(LarusSdkSlidesItemGenerateImageBinding r100, Integer r101, Integer r102, s r103) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100);
        this.f363306a = r100;
        this.f363307b = r101;
        this.f363308c = r102;
        this.f363309d = r103;
        w0.e(r100.f362201c, c7.b(16));
    }
}

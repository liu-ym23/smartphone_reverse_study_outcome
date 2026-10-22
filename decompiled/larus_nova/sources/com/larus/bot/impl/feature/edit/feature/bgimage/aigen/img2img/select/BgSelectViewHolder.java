package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import com.larus.bot.impl.databinding.LarusItemBotGenBgSelectItemBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotGenBgSelectItemBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotGenBgSelectItemBinding;)V", "bindData", "", "data", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder$BgSelectItemData;", "position", "", "showSparklesLottieAnim", "BgSelectItemData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgSelectViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f318762b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemBotGenBgSelectItemBinding f318763a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f318764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f318767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f318768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f318769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f318770g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f318764a == r101.f318764a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f318765b, r101.f318765b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f318766c, r101.f318766c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f318767d, r101.f318767d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f318768e, r101.f318768e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f318769f, r101.f318769f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f318770g, r101.f318770g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.f318764a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f318765b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f318766c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f318767d;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f318768e;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f318769f;
            if (r115 != null) goto L25;
            int r116 = 0;
        L26:
            int r117 = (r114 + r116) * 31;
            Integer r118 = this.f318770g;
            if (r118 == null) goto L31;
            r103 = r118.hashCode();
        L31:
            return r117 + r103;
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
            return "BgSelectItemData(isError=" + this.f318764a + ", previewUrl=" + this.f318765b + ", downloadUrl=" + this.f318766c + ", url=" + this.f318767d + ", uri=" + this.f318768e + ", prompt=" + this.f318769f + ", progress=" + this.f318770g + ')';
        }

        public a(boolean r100, String r101, String r102, String r103, String r104, String r105, Integer r106) {
            this.f318764a = r100;
            this.f318765b = r101;
            this.f318766c = r102;
            this.f318767d = r103;
            this.f318768e = r104;
            this.f318769f = r105;
            this.f318770g = r106;
        }
    }

    public static final class b {
    }

    static {
    }

    public BgSelectViewHolder(LarusItemBotGenBgSelectItemBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100);
        this.f318763a = r100;
        w0.e(r100.f317805c, c7.b(16));
    }
}

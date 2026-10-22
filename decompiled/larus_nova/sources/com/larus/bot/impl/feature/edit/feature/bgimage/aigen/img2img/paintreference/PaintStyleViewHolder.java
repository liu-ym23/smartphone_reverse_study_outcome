package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference;

import android.net.Uri;
import com.larus.bot.impl.databinding.LarusItemBotAvatarPaintStyleBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotAvatarPaintStyleBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotAvatarPaintStyleBinding;)V", "bindData", "", "data", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder$PaintStyleViewData;", "PaintStyleViewData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaintStyleViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemBotAvatarPaintStyleBinding f318696a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f318697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f318698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f318699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f318700d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f318697a, r101.f318697a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f318698b, r101.f318698b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f318699c, r101.f318699c) == true) goto L18;
            return false;
        L18:
            if (this.f318700d == r101.f318700d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Uri r100 = this.f318697a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f318698b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f318699c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (r106 + r101) * 31;
            if (this.f318700d == false) goto L17;
            int r109 = 1231;
        L19:
            return r108 + r109;
        L17:
            r109 = 1237;
            goto L19
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PaintStyleViewData(imageUri=" + this.f318697a + ", textStarlingKey=" + this.f318698b + ", text=" + this.f318699c + ", isSelected=" + this.f318700d + ')';
        }

        public static a a(a r100, boolean r101) {
            Uri r102 = r100.f318697a;
            String r103 = r100.f318698b;
            String r104 = r100.f318699c;
            r100.getClass();
            return new a(r102, r103, r104, r101);
        }

        public a(Uri r100, String r101, String r102, boolean r103) {
            this.f318697a = r100;
            this.f318698b = r101;
            this.f318699c = r102;
            this.f318700d = r103;
        }
    }

    public PaintStyleViewHolder(LarusItemBotAvatarPaintStyleBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100);
        this.f318696a = r100;
        w0.e(r100.f317776b, c7.b(14));
    }
}

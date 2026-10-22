package com.bytedance.lynx.map.ng.refactor;

import android.graphics.Bitmap;
import com.bytedance.map.api.exception.BDMapException;
import com.bytedance.map.api.image.ImageCallback;
import com.bytedance.map.api.image.ImageOptions;
import com.bytedance.map.api.image.MapImageLoader;
import com.bytedance.map.api.thread.ThreadManager;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PolylineTextureBitmapLoader {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lynx/map/ng/refactor/PolylineTextureBitmapLoader$TextureLoadFailureReason;", "", "NETWORK", "BASE64_DECODE", "x-element-map-ng_release"}, k = 1, mv = {1, 6, 0})
    public static final enum TextureLoadFailureReason extends Enum<TextureLoadFailureReason> {
        public static final TextureLoadFailureReason BASE64_DECODE = null;
        public static final TextureLoadFailureReason NETWORK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextureLoadFailureReason[] f264731a = null;

        public static TextureLoadFailureReason valueOf(String r100) {
            return (TextureLoadFailureReason) r27.a.a(TextureLoadFailureReason.class, r100);
        }

        public static TextureLoadFailureReason[] values() {
            return (TextureLoadFailureReason[]) f264731a.clone();
        }

        static {
            TextureLoadFailureReason r100 = new TextureLoadFailureReason("NETWORK", 0);
            NETWORK = r100;
            TextureLoadFailureReason r101 = new TextureLoadFailureReason("BASE64_DECODE", 1);
            BASE64_DECODE = r101;
            f264731a = new TextureLoadFailureReason[]{r100, r101};
        }

        public TextureLoadFailureReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f264732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextureLoadFailureReason f264733b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f264732a, r101.f264732a) == true) goto L12;
            return false;
        L12:
            if (this.f264733b == r101.f264733b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Bitmap r100 = this.f264732a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            TextureLoadFailureReason r104 = this.f264733b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BitmapLoadResult(bitmap=" + this.f264732a + ", failureReason=" + this.f264733b + ')';
        }

        public a(Bitmap r100, TextureLoadFailureReason r101) {
            this.f264732a = r100;
            this.f264733b = r101;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f264734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f264735b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f264734a, r101.f264734a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264735b, r101.f264735b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f264734a.hashCode() * 31;
            String r101 = this.f264735b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TextureAsset(id=" + this.f264734a + ", url=" + this.f264735b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f264734a = r100;
            this.f264735b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Bitmap> f264736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f264737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f264738c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f264736a, r101.f264736a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264737b, r101.f264737b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f264738c, r101.f264738c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f264736a.hashCode() * 31) + this.f264737b.hashCode()) * 31) + this.f264738c.hashCode();
        }

        public final String toString() {
            return "TextureLoadResult(bitmapMap=" + this.f264736a + ", failedNetworkTextureIds=" + this.f264737b + ", failedBase64TextureIds=" + this.f264738c + ')';
        }

        public d(Map<String, Bitmap> r100, List<String> r101, List<String> r102) {
            Intrinsics.checkNotNullParameter(r100, "bitmapMap");
            Intrinsics.checkNotNullParameter(r101, "failedNetworkTextureIds");
            Intrinsics.checkNotNullParameter(r102, "failedBase64TextureIds");
            this.f264736a = r100;
            this.f264737b = r101;
            this.f264738c = r102;
        }
    }

    public static final class e implements ImageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<a, Unit> f264739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f264740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PolylineTextureBitmapLoader f264741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f264742d;

        @Override // com.bytedance.map.api.image.ImageCallback
        public final void onSuccess(List<Bitmap> r100) {
            Intrinsics.checkNotNullParameter(r100, "bitmapList");
        }

        @Override // com.bytedance.map.api.image.ImageCallback
        public final void onFail(BDMapException r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            int r101 = this.f264740b;
            if (r101 <= 0) goto L5;
            this.f264741c.a(this.f264742d, r101 - 1, this.f264739a);
            return;
        L5:
            this.f264739a.invoke(new a(null, TextureLoadFailureReason.NETWORK));
        }

        @Override // com.bytedance.map.api.image.ImageCallback
        public final void onSuccess(Bitmap r100) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f264739a.invoke(new a(r100, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super a, Unit> r100, int r101, PolylineTextureBitmapLoader r102, c r103) {
            this.f264739a = r100;
            this.f264740b = r101;
            this.f264741c = r102;
            this.f264742d = r103;
        }
    }

    static {
    }

    public PolylineTextureBitmapLoader() {
    }

    public final void a(c r100, int r101, final Function1<? super a, Unit> r110) {
        final String r102 = r100.f264735b;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        r110.invoke(new a(null, null));
        return;
    L13:
        String r105 = r102.toLowerCase(Locale.ROOT);
        if (StringsKt.startsWith$default(r105, "http://", false, 2, null) == false) goto L16;
    L19:
        if (r103 == false) goto L22;
        ImageOptions r106 = new ImageOptions();
        r106.setUrl(r102);
        MapImageLoader.loadBitmap(r106, new e(r110, r101, this, r100));
        return;
    L22:
        ThreadManager.getInstance().getDiskThread().execute(new v(this, r102, r110));
        return;
    L16:
        if (StringsKt.startsWith$default(r105, "https://", false, 2, null) == true) goto L19;
        r103 = false;
        goto L19
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L10
    }
}

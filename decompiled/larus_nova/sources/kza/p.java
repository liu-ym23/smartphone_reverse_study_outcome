package kza;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Continuation<? super String>, ? extends Object> f506799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f506800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f506801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f506802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super Continuation<? super Bitmap>, ? extends Object> f506803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f506805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<? super Continuation<? super String>, ? extends Object> f506806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f506807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f506808l;

    public p() {
        this(null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f506797a, r101.f506797a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506798b, r101.f506798b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506799c, r101.f506799c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506800d, r101.f506800d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506801e, r101.f506801e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506802f, r101.f506802f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506803g, r101.f506803g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506804h, r101.f506804h) == true) goto L33;
        return false;
    L33:
        if (this.f506805i == r101.f506805i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506806j, r101.f506806j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f506807k, r101.f506807k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f506808l, r101.f506808l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506797a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f506798b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<? super Continuation<? super String>, ? extends Object> r107 = this.f506799c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.f506800d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f506801e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f506802f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Function1<? super Continuation<? super Bitmap>, ? extends Object> r119 = this.f506803g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f506804h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((r121 + r123) * 31) + this.f506805i) * 31;
        Function1<? super Continuation<? super String>, ? extends Object> r125 = this.f506806j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Object r128 = this.f506807k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Object r131 = this.f506808l;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuGalleryVideoItem(vid=" + this.f506797a + ", videoURL=" + this.f506798b + ", downloadURLProvider=" + this.f506799c + ", duration=" + this.f506800d + ", height=" + this.f506801e + ", width=" + this.f506802f + ", coverBitmap=" + this.f506803g + ", localPath=" + this.f506804h + ", startTime=" + this.f506805i + ", coverBitmapUri=" + this.f506806j + ", photoItem=" + this.f506807k + ", doubaoMessage=" + this.f506808l + ')';
    }

    public p(String r110, String r111, Function1 r112, Double r113, Integer r114, Integer r210, com.ss.android.lark.flow.chat.message.image.d r211, String r212, Function1 r213, Object r214, Object r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        Object r101 = null;
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Function1 r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Double r104 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        if ((r216 & 16) == 0) goto L21;
        Integer r105 = 0;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Integer r106 = 0;
    L27:
        if ((r216 & 64) == 0) goto L29;
        com.ss.android.lark.flow.chat.message.image.d r115 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r216 & 512) == 0) goto L37;
        Function1 r117 = null;
    L39:
        if ((r216 & 1024) == 0) goto L41;
        Object r118 = null;
    L43:
        if ((r216 & 2048) != 0) goto L46;
        r101 = r215;
    L46:
        this.f506797a = r100;
        this.f506798b = r102;
        this.f506799c = r103;
        this.f506800d = r104;
        this.f506801e = r105;
        this.f506802f = r106;
        this.f506803g = r115;
        this.f506804h = r116;
        this.f506805i = 0;
        this.f506806j = r117;
        this.f506807k = r118;
        this.f506808l = r101;
        return;
    L41:
        r118 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}

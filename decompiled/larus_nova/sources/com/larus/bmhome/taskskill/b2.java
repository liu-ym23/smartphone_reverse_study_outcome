package com.larus.bmhome.taskskill;

import android.graphics.Color;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f314255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f314256b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<a> f314257c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f314258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f314259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f314260c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f314258a, r101.f314258a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f314259b, r101.f314259b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f314260c, r101.f314260c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f314258a.hashCode() * 31) + this.f314259b.hashCode()) * 31) + this.f314260c.hashCode();
        }

        public final String toString() {
            return "ColorGroup(characters=" + this.f314258a + ", light=" + this.f314259b + ", dark=" + this.f314260c + ')';
        }

        public a(String r100, b r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, "characters");
            Intrinsics.checkNotNullParameter(r101, "light");
            Intrinsics.checkNotNullParameter(r102, "dark");
            this.f314258a = r100;
            this.f314259b = r101;
            this.f314260c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f314261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f314262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f314263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f314264d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f314261a == r101.f314261a) goto L12;
            return false;
        L12:
            if (this.f314262b == r101.f314262b) goto L15;
            return false;
        L15:
            if (this.f314263c == r101.f314263c) goto L18;
            return false;
        L18:
            if (this.f314264d == r101.f314264d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f314261a * 31) + this.f314262b) * 31) + this.f314263c) * 31) + this.f314264d;
        }

        public final String toString() {
            return "Colors(icon=" + this.f314261a + ", backgroundCenter=" + this.f314262b + ", backgroundEdge=" + this.f314263c + ", border=" + this.f314264d + ')';
        }

        public b(int r100, int r101, int r102, int r103) {
            this.f314261a = r100;
            this.f314262b = r101;
            this.f314263c = r102;
            this.f314264d = r103;
        }
    }

    public b2() {
    }

    static {
        b2 r100 = new b2();
        f314255a = a(r100, Color.rgb(77, 124, 255), Color.rgb(0, 68, 255), 0, 0.05f, 0.1f, 4);
        f314256b = a(r100, Color.rgb(57, 115, 229), Color.rgb(51, 119, 255), 0, 0.11f, 0.1f, 4);
        f314257c = CollectionsKt.listOf(new a[]{new a("024GOT", a(r100, Color.rgb(59, 178, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE), Color.rgb(92, 211, 229), 0, 0.1f, 0.0f, 20), a(r100, Color.rgb(59, 178, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE), Color.rgb(40, 226, 255), 0, 0.07f, 0.0f, 20)), new a("8EIJUY", a(r100, Color.rgb(77, 121, 255), Color.rgb(0, 64, 255), 0, 0.05f, 0.0f, 20), a(r100, Color.rgb(77, 121, 255), Color.rgb(51, 119, 255), Color.rgb(51, 102, 255), 0.11f, 0.0f, 16)), new a("1DFHMW", a(r100, Color.rgb(146, 104, 242), Color.rgb(145, 104, 242), 0, 0.08f, 0.0f, 20), a(r100, Color.rgb(146, 104, 242), Color.rgb(145, 104, 242), 0, 0.1f, 0.0f, 20)), new a("3BCLSV", a(r100, Color.rgb(64, 161, 40), Color.rgb(66, 166, 41), 0, 0.08f, 0.0f, 20), a(r100, Color.rgb(64, 161, 40), Color.rgb(41, 166, 124), 0, 0.07f, 0.0f, 20)), new a("67AKPQ", a(r100, Color.rgb(229, 160, 23), Color.rgb(229, 160, 23), 0, 0.09f, 0.12f, 4), a(r100, Color.rgb(229, 160, 23), Color.rgb(229, 160, 23), 0, 0.09f, 0.12f, 4)), new a("59NRXZ", a(r100, Color.rgb(247, 100, 86), Color.rgb(247, 100, 86), 0, 0.07f, 0.09f, 4), a(r100, Color.rgb(247, 100, 86), Color.rgb(247, 100, 86), 0, 0.07f, 0.09f, 4))});
    }

    public static b b(String r100, boolean r101) {
        b r102 = null;
        if (r100 == null) goto L20;
        Character r103 = StringsKt.lastOrNull(r100);
        if (r103 == null) goto L20;
        char r104 = Character.toUpperCase(r103.charValue());
        Iterator<T> r105 = f314257c.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (StringsKt.contains$default(((a) r106).f314258a, r104, false, 2, null) == false) goto L8;
    L13:
        a r107 = (a) r106;
        if (r107 == null) goto L20;
        if (r101 == false) goto L18;
        b r108 = r107.f314260c;
    L19:
        r102 = r108;
        goto L20
    L18:
        r108 = r107.f314259b;
        goto L19
    L12:
        r106 = null;
    L20:
        if (r102 != null) goto L28;
        if (r101 == false) goto L24;
        return f314256b;
    L24:
        return f314255a;
    L28:
        return r102;
    }

    public static int c(int r100, float r101) {
        return Color.argb(MathKt.roundToInt(r101 * 255), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public static b a(b2 r100, int r101, int r102, int r103, float r104, float r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r103 = r102;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r105 = 0.08f;
    L9:
        return new b(r101, c(r102, 0.0f), c(r103, r104), c(r101, r105));
    }
}

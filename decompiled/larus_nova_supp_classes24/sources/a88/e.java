package a88;

import android.graphics.Bitmap;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public Bitmap e;
    public final boolean f;
    public boolean g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Bitmap r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.f == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.g == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.h == true) goto L18;
        r5 = 1237;
    L18:
        int r10 = (r9 + r5) * 31;
        String r11 = this.i;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        String r14 = this.j;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (((((((r13 + r15) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        String r17 = this.n;
        if (r17 == null) goto L31;
        r2 = r17.hashCode();
    L31:
        return r16 + r2;
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicData(musicId=" + this.a + ", videoModelJsonStr=" + this.b + ", title=" + this.c + ", artist=" + this.d + ", albumArt=" + this.e + ", disableFavorite=" + this.f + ", isFavorite=" + this.g + ", enableHidingSkip=" + this.h + ", albumArtUrl=" + this.i + ", callId=" + this.j + ", conversationId=" + this.k + ", messageId=" + this.l + ", globalAudioEventScene=" + this.m + ", appletAppId=" + this.n + ')';
    }

    public e(String r3, String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, String r10, String r11, String r12, String r13, String r14, int r15) {
        if ((r15 & 32) == 0) goto L6;
        r7 = false;
    L6:
        if ((r15 & 64) == 0) goto L9;
        r8 = false;
    L9:
        if ((r15 & 128) == 0) goto L12;
        r9 = false;
    L12:
        if ((r15 & 256) == 0) goto L15;
        r10 = null;
    L15:
        if ((r15 & 8192) == 0) goto L17;
        r14 = null;
    L17:
        Intrinsics.checkNotNullParameter(r3, "musicId");
        Intrinsics.checkNotNullParameter(r4, "videoModelJsonStr");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "artist");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.PLUGIN_MUSIC, "globalAudioEventScene");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = GlobalAudioSceneEnum.PLUGIN_MUSIC;
        this.n = r14;
    }
}

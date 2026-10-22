package ye8;

import com.larus.bmhome.chat.input.ChatInputPlaceholderMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f567417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f567418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f567419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatInputPlaceholderMode f567420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f567421e;

    public a() {
        this(null, false, true, ChatInputPlaceholderMode.KEYBOARD, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f567417a, r101.f567417a) == true) goto L12;
        return false;
    L12:
        if (this.f567418b == r101.f567418b) goto L15;
        return false;
    L15:
        if (this.f567419c == r101.f567419c) goto L18;
        return false;
    L18:
        if (this.f567420d == r101.f567420d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f567421e, r101.f567421e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f567417a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f567418b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f567419c == true) goto L14;
        r104 = 1237;
    L14:
        int r107 = (((r106 + r104) * 31) + this.f567420d.hashCode()) * 31;
        String r108 = this.f567421e;
        if (r108 == null) goto L19;
        r101 = r108.hashCode();
    L19:
        return r107 + r101;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatInputPlaceholderConfig(hint=" + this.f567417a + ", showActionEntrance=" + this.f567418b + ", showPlusMenu=" + this.f567419c + ", mode=" + this.f567420d + ", speakHint=" + this.f567421e + ')';
    }

    public a(String r100, boolean r101, boolean r102, ChatInputPlaceholderMode r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "mode");
        this.f567417a = r100;
        this.f567418b = r101;
        this.f567419c = r102;
        this.f567420d = r103;
        this.f567421e = r104;
    }
}

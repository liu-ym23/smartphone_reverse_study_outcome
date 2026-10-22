package jn8;

import com.larus.im.bean.message.Reference;
import defpackage.AndroidUnique;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Reference> f499783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f499784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f499785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @AndroidUnique
    public final String f499786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f499787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f499788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f499789g;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f499783a, r101.f499783a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499784b, r101.f499784b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499785c, r101.f499785c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f499786d, r101.f499786d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f499787e, r101.f499787e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f499788f, r101.f499788f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f499789g, r101.f499789g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        List<Reference> r100 = this.f499783a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f499784b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f499785c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f499786d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f499787e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f499788f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f499789g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "SearchCotZoomInViewInput(reference=" + this.f499783a + ", idx=" + this.f499784b + ", toolType=" + this.f499785c + ", messageId=" + this.f499786d + ", chatType=" + this.f499787e + ", conversationId=" + this.f499788f + ", botId=" + this.f499789g + ')';
    }

    public /* synthetic */ s(int r100) {
        this(null, -1, null, null, null, null, null);
    }

    public s(List<Reference> r100, Integer r101, String r102, String r103, String r104, String r105, String r106) {
        this.f499783a = r100;
        this.f499784b = r101;
        this.f499785c = r102;
        this.f499786d = r103;
        this.f499787e = r104;
        this.f499788f = r105;
        this.f499789g = r106;
    }
}

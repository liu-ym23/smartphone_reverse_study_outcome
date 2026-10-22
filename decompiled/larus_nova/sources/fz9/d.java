package fz9;

import com.larus.im.bean.message.CreationTaskType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f479431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f479432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f479433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageInfo f479434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f479435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f479436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f479437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f479438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f479439k;

    public d() {
        this(null, 0, 0, null, 0, null, false, false, false, false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f479429a, r101.f479429a) == true) goto L12;
        return false;
    L12:
        if (this.f479430b == r101.f479430b) goto L15;
        return false;
    L15:
        if (this.f479431c == r101.f479431c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479432d, r101.f479432d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479433e, r101.f479433e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479434f, r101.f479434f) == true) goto L27;
        return false;
    L27:
        if (this.f479435g == r101.f479435g) goto L30;
        return false;
    L30:
        if (this.f479436h == r101.f479436h) goto L33;
        return false;
    L33:
        if (this.f479437i == r101.f479437i) goto L36;
        return false;
    L36:
        if (this.f479438j == r101.f479438j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f479439k, r101.f479439k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f479429a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f479430b) * 31) + this.f479431c) * 31;
        Message r104 = this.f479432d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f479433e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ImageInfo r110 = this.f479434f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.f479435g == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f479436h == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f479437i == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f479438j == true) goto L34;
        r113 = 1237;
    L34:
        int r120 = (r119 + r113) * 31;
        Integer r121 = this.f479439k;
        if (r121 == null) goto L39;
        r101 = r121.hashCode();
    L39:
        return r120 + r101;
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
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
        return "ImageItemData(taskId=" + this.f479429a + ", width=" + this.f479430b + ", height=" + this.f479431c + ", message=" + this.f479432d + ", index=" + this.f479433e + ", imageInfo=" + this.f479434f + ", canDownload=" + this.f479435g + ", canShare=" + this.f479436h + ", canEditImage=" + this.f479437i + ", canEditVideo=" + this.f479438j + ", taskType=" + this.f479439k + ')';
    }

    @Override // fz9.c
    public final int getHeight() {
        return this.f479431c;
    }

    @Override // fz9.c
    public final Integer getIndex() {
        return this.f479433e;
    }

    @Override // fz9.c
    public final Message getMessage() {
        return this.f479432d;
    }

    @Override // fz9.c
    public final String getTaskId() {
        return this.f479429a;
    }

    @Override // fz9.c
    public final int getWidth() {
        return this.f479430b;
    }

    public d(String r100, int r101, int r102, Message r103, Integer r104, ImageInfo r105, boolean r106, boolean r107, boolean r108, boolean r110, @CreationTaskType Integer r111) {
        this.f479429a = r100;
        this.f479430b = r101;
        this.f479431c = r102;
        this.f479432d = r103;
        this.f479433e = r104;
        this.f479434f = r105;
        this.f479435g = r106;
        this.f479436h = r107;
        this.f479437i = r108;
        this.f479438j = r110;
        this.f479439k = r111;
    }
}

package ky8;

import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.service.bean.AIBeautify;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CanvasMsgInfo;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<Boolean> f506696j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CanvasBlock> f506698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f506699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f506700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f506701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f506702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f506703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f506704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f506705i;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f506697a, r101.f506697a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506698b, r101.f506698b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506699c, r101.f506699c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506700d, r101.f506700d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506701e, r101.f506701e) == true) goto L24;
        return false;
    L24:
        if (this.f506702f == r101.f506702f) goto L27;
        return false;
    L27:
        if (this.f506703g == r101.f506703g) goto L30;
        return false;
    L30:
        if (this.f506704h == r101.f506704h) goto L33;
        return false;
    L33:
        if (this.f506705i == r101.f506705i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506697a.hashCode() * 31;
        List<CanvasBlock> r101 = this.f506698b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f506699c.hashCode()) * 31;
        h r105 = this.f506700d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((r104 + r102) * 31) + this.f506701e.hashCode()) * 31;
        int r107 = 1231;
        if (this.f506702f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f506703g) * 31;
        if (this.f506704h == true) goto L18;
        r107 = 1237;
    L18:
        long r110 = this.f506705i;
        return ((r109 + r107) * 31) + ((int) (r110 ^ (r110 >>> 32)));
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final boolean k() {
        return !CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{10, 11}), n());
    }

    public final String toString() {
        return "GenImageTaskItem(localId=" + this.f506697a + ", canvasBlockList=" + this.f506698b + ", previousTaskItem=" + this.f506699c + ", rootTaskItem=" + this.f506700d + ", inputDataSnapShot=" + this.f506701e + ", isLoaded=" + this.f506702f + ", saveStatus=" + this.f506703g + ", willBeRemove=" + this.f506704h + ", startTime=" + this.f506705i + ')';
    }

    static {
        f506696j = LazyKt.lazy(new e());
    }

    public final CanvasInfo a() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L9;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L9;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L9;
        return r102.canvasInfo;
    L9:
        return null;
    }

    public final AIBeautify c() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L11;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L11;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L11;
        CanvasInfo r103 = r102.canvasInfo;
        if (r103 == null) goto L11;
        return r103.aiBeautify;
    L11:
        return null;
    }

    public final Long d() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L11;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L11;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L11;
        CanvasInfo r103 = r102.canvasInfo;
        if (r103 == null) goto L11;
        return r103.canvasId;
    L11:
        return null;
    }

    public final String e() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L11;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L11;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L11;
        CanvasInfo r103 = r102.canvasInfo;
        if (r103 == null) goto L11;
        return r103.replySubId;
    L11:
        return null;
    }

    public final UserCreationFromIM f() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L9;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L9;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L9;
        return r102.creation;
    L9:
        return null;
    }

    public final ImageData h() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L23;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L23;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L23;
        ImageData r103 = r102.image;
        if (r103 == null) goto L23;
        String r104 = r103.imageUri;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L26;
        CreationNoWatermarkManager r106 = CreationNoWatermarkManager.f373832a;
        r106.getClass();
        ImageData r107 = r106.W(CreationNoWatermarkManager.z(r103), r103).f373863a;
        if (r107 != null) goto L25;
        return r103;
    L25:
        return r107;
    L26:
        return r103;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L23:
        return null;
    }

    public final CanvasMsgInfo m() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L9;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L9;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L9;
        return r102.msgInfo;
    L9:
        return null;
    }

    public final Integer n() {
        List<CanvasBlock> r100 = this.f506698b;
        if (r100 == null) goto L11;
        CanvasBlock r101 = (CanvasBlock) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L11;
        CanvasImageBlock r102 = r101.content;
        if (r102 == null) goto L11;
        CanvasInfo r103 = r102.canvasInfo;
        if (r103 == null) goto L11;
        return r103.canvasStatus;
    L11:
        return null;
    }

    public final String g() {
        ImageData r100 = h();
        if (r100 == null) goto L7;
        ImageObj r101 = r100.imageOrigin;
        if (r101 == null) goto L7;
        return r101.url;
    L7:
        return null;
    }

    public final String i() {
        ImageData r100 = h();
        String r101 = null;
        if (r100 == null) goto L64;
        boolean r102 = true;
        String r103 = "";
        if (z2.f365865a.enableBlockImagePreviewResize() == false) goto L46;
        ImageObj r104 = r100.imagePreviewResize;
        if (r104 == null) goto L9;
        String r105 = r104.getHeicUrl();
    L10:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        if (r105.length() != 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L65;
        ImageObj r107 = r100.imagePreviewResize;
        if (r107 == null) goto L20;
        r105 = r107.url;
    L21:
        if (r105 != null) goto L24;
        r105 = "";
    L24:
        if (r105.length() != 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L65;
        ImageObj r109 = r100.imagePreview;
        if (r109 == null) goto L31;
        String r110 = r109.getHeicUrl();
    L32:
        if (r110 == null) goto L36;
        r103 = r110;
    L36:
        if (r103.length() == 0) goto L39;
        r102 = false;
    L39:
        if (r102 == false) goto L44;
        ImageObj r111 = r100.imagePreview;
        if (r111 == null) goto L43;
        r101 = r111.url;
    L43:
        r103 = r101;
    L44:
        r105 = r103;
        goto L65
    L31:
        r110 = null;
        goto L32
    L26:
        r108 = false;
        goto L27
    L20:
        r105 = null;
    L65:
        return r105;
    L15:
        r106 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    L46:
        ImageObj r112 = r100.imagePreview;
        if (r112 == null) goto L49;
        String r113 = r112.getHeicUrl();
    L50:
        if (r113 == null) goto L54;
        r103 = r113;
    L54:
        if (r103.length() == 0) goto L57;
        r102 = false;
    L57:
        if (r102 == false) goto L63;
        ImageObj r114 = r100.imagePreview;
        if (r114 == null) goto L61;
        r101 = r114.url;
    L61:
        r103 = r101;
    L63:
        return r103;
    L49:
        r113 = null;
        goto L50
    L64:
        return null;
    }

    public final String j() {
        CanvasMsgInfo r100 = m();
        if (r100 == null) goto L6;
        String r101 = r100.taskId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        List<CanvasBlock> r102 = this.f506698b;
        if (r102 == null) goto L15;
        CanvasBlock r103 = (CanvasBlock) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L15;
        CanvasImageBlock r104 = r103.content;
        if (r104 == null) goto L15;
        ImageData r105 = r104.image;
        if (r105 == null) goto L15;
        return r105.taskId;
    L15:
        return null;
    }

    public final boolean l() {
        Integer r100 = n();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 10) goto L8;
        return true;
    }

    public static f b(f r110, List r111, boolean r112, int r113, boolean r114, int r210) {
        i r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = r110.f506697a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r102 = r110.f506698b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        h r103 = r110.f506699c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        h r104 = r110.f506700d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        r100 = r110.f506701e;
    L21:
        i r105 = r100;
        if ((r210 & 32) == 0) goto L24;
        boolean r115 = r110.f506702f;
    L26:
        if ((r210 & 64) == 0) goto L28;
        int r116 = r110.f506703g;
    L30:
        if ((r210 & 128) == 0) goto L32;
        boolean r117 = r110.f506704h;
    L34:
        if ((r210 & 256) == 0) goto L36;
        long r106 = r110.f506705i;
    L37:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "localId");
        Intrinsics.checkNotNullParameter(r103, "previousTaskItem");
        Intrinsics.checkNotNullParameter(r105, "inputDataSnapShot");
        return new f(r101, r102, r103, r104, r105, r115, r116, r117, r106);
    L36:
        r106 = 0;
        goto L37
    L32:
        r117 = r114;
        goto L34
    L28:
        r116 = r113;
        goto L30
    L24:
        r115 = r112;
        goto L26
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public f(String r100, List<CanvasBlock> r101, h r102, h r103, i r104, boolean r105, @ImageSaveStatus int r106, boolean r107, long r110) {
        Intrinsics.checkNotNullParameter(r100, "localId");
        Intrinsics.checkNotNullParameter(r102, "previousTaskItem");
        Intrinsics.checkNotNullParameter(r104, "inputDataSnapShot");
        this.f506697a = r100;
        this.f506698b = r101;
        this.f506699c = r102;
        this.f506700d = r103;
        this.f506701e = r104;
        this.f506702f = r105;
        this.f506703g = r106;
        this.f506704h = r107;
        this.f506705i = r110;
    }
}

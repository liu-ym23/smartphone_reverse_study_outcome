package rl8;

import com.larus.gallery.api.GalleryType;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends ab9.b<ty8.b> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f538479a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f538479a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ab9.b
    public final JSONObject y() {
        ty8.b r100 = (ty8.b) this.f343898d;
        if (r100 == null) goto L7;
        JSONObject r101 = r100.f548010f;
        if (r101 == null) goto L7;
        return new JSONObject(r101.toString());
    L7:
        return null;
    }

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ab9.b
    public final void A(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "slideStatus");
        ty8.b r103 = (ty8.b) this.f343898d;
        JSONObject r104 = null;
        if (r103 == null) goto L5;
        GalleryType r105 = r103.f548009e;
    L6:
        if (r105 != null) goto L8;
        int r106 = -1;
    L10:
        if (r106 != 1) goto L22;
        ty8.b r107 = (ty8.b) this.f343898d;
        if (r107 == null) goto L16;
        JSONObject r108 = r107.f548010f;
        if (r108 == null) goto L16;
        JSONObject r109 = new JSONObject(r108.toString());
    L17:
        o r110 = o.f365780a;
        if (r109 == null) goto L20;
        r109.put("enter_method", r101);
        r109.put("position", r100 + 1);
        Unit r111 = Unit.INSTANCE;
        r104 = r109;
    L20:
        r110.reportEvent("enter_picture_detail", r104);
        return;
    L16:
        r109 = null;
        goto L17
    L22:
        return;
    L8:
        r106 = a.f538479a[r105.ordinal()];
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}

package ny9;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Deprecated(message = "use CreatePageConfig")
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f521225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f521226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatParam f521227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f521228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zs8.a f521229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final by7.e f521230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f521231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ChatPageContext f521232h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f521225a, r101.f521225a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521226b, r101.f521226b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f521227c, r101.f521227c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f521228d, r101.f521228d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f521229e, r101.f521229e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f521230f, r101.f521230f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f521231g, r101.f521231g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f521232h, r101.f521232h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f521225a.hashCode() * 31) + this.f521226b.hashCode()) * 31;
        ChatParam r101 = this.f521227c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        TemplateInfo$TemplateInfo r105 = this.f521228d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        zs8.a r108 = this.f521229e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        by7.e r111 = this.f521230f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Bundle r114 = this.f521231g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        ChatPageContext r117 = this.f521232h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreatePageChooseTemplateConfig(activity=" + this.f521225a + ", item=" + this.f521226b + ", chatParam=" + this.f521227c + ", templateInfo=" + this.f521228d + ", hitPointData=" + this.f521229e + ", trackNode=" + this.f521230f + ", extraBundle=" + this.f521231g + ", chatPageContext=" + this.f521232h + ')';
    }

    public a(FragmentActivity r100, z0 r101, ChatParam r102, TemplateInfo$TemplateInfo r103, com.larus.bmhome.chat.u r104, Bundle r105, ChatPageContext r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f521225a = r100;
        this.f521226b = r101;
        this.f521227c = r102;
        this.f521228d = r103;
        this.f521229e = r104;
        this.f521230f = null;
        this.f521231g = r105;
        this.f521232h = r106;
    }
}

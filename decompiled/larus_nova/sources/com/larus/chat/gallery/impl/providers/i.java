package com.larus.chat.gallery.impl.providers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.l;
import com.larus.gallery.api.t;
import com.larus.nova.R;
import com.larus.platform.service.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class i<T> extends t<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f324835n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<T, f> f324836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f324837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f324838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f324839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.chat.gallery.api.h f324840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f324841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f324842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f324843m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.gallery.api.t
    public final boolean m() {
        return false;
    }

    @Override // com.larus.gallery.api.t
    public final boolean n() {
        return false;
    }

    public final void A() {
        View r100 = this.f324837g;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f324843m = null;
    }

    @Override // com.larus.gallery.api.t
    public final void v() {
        Job r100 = this.f324841k;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f324841k = null;
        this.f324842l = null;
        View r101 = this.f324837g;
        if (r101 == null) goto L8;
        r101.setOnClickListener(null);
    L8:
        this.f324837g = null;
        this.f324838h = null;
        this.f324839i = null;
        this.f324840j = null;
        this.f324843m = null;
    }

    public i(l r100) {
        Intrinsics.checkNotNullParameter(r100, "selector");
        this.f324836f = r100;
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.larus_gallery_find_similar_button, r100, false);
        r101.setVisibility(8);
        r101.setOnClickListener(new g(this));
        this.f324837g = r101;
        this.f324838h = (TextView) r101.findViewById(R.id.find_similar_text);
        return r101;
    }

    public final void y(com.larus.chat.gallery.api.h r100) {
        this.f324840j = r100;
        String r101 = r100.f324158b;
        String r102 = null;
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L8:
        String r103 = r100.f324159c;
        if (r103 != null) goto L11;
    L13:
        r103 = null;
    L15:
        if (r100.f324157a == false) goto L37;
        if (r101 == null) goto L37;
        if (r103 == null) goto L37;
        TextView r104 = this.f324838h;
        if (r104 == null) goto L22;
        r104.setText(r101);
    L22:
        View r105 = this.f324837g;
        if (r105 == null) goto L25;
        r105.setVisibility(0);
    L25:
        f r106 = this.f324839i;
        if (r106 == null) goto L28;
        String r107 = r106.f324827a;
    L30:
        if (Intrinsics.areEqual(r107, this.f324843m) == true) goto L39;
        if (r106 == null) goto L33;
        o.f365780a.reportEvent("ecom_icon_show", z(r106, r101));
    L33:
        if (r106 == null) goto L35;
        r102 = r106.f324827a;
    L35:
        this.f324843m = r102;
        return;
    L39:
        return;
    L28:
        r107 = null;
    L37:
        A();
        return;
    L11:
        if ((!StringsKt.isBlank(r103)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        goto L7
    }

    public static JSONObject z(f r100, String r101) {
        JSONObject r102 = new JSONObject();
        String r103 = r100.f324828b;
        if (r103 == null) goto L5;
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r103);
    L5:
        String r104 = r100.f324829c;
        if (r104 == null) goto L8;
        r102.put("enter_method", r104);
    L8:
        r102.put("icon_type", "find_same_product");
        r102.put(ElementGuideBubbleStruct.STYLE_ICON_TEXT_BUBBLE, r101);
        String r105 = r100.f324830d;
        if (r105 == null) goto L11;
        r102.put("bot_id", r105);
    L11:
        return r102;
    }

    @Override // com.larus.gallery.api.t
    public final void w(T r100, int r101) {
        this.f343898d = r100;
        f r102 = this.f324836f.invoke(r100);
        this.f324839i = r102;
        if (r102 == null) goto L5;
        String r103 = r102.f324827a;
    L6:
        boolean r104 = false;
        if (Intrinsics.areEqual(this.f324842l, r103) == false) goto L16;
        Job r105 = this.f324841k;
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        return;
    L11:
        if (r105.isActive() != true) goto L13;
        r106 = true;
    L16:
        Job r107 = this.f324841k;
        if (r107 == null) goto L19;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L19:
        this.f324841k = null;
        this.f324842l = null;
        this.f324840j = null;
        if (r103 != null) goto L22;
    L23:
        r104 = true;
    L24:
        if (r104 == false) goto L26;
        A();
        return;
    L26:
        ConcurrentHashMap<String, com.larus.chat.gallery.api.h> r108 = e.f324826a;
        Intrinsics.checkNotNullParameter(r103, "imageUri");
        com.larus.chat.gallery.api.h r109 = e.f324826a.get(r103);
        if (r109 == null) goto L29;
        y(r109);
        return;
    L29:
        A();
        this.f324842l = r103;
        this.f324841k = BuildersKt.launch$default(r(), null, null, new FindSimilarProvider$applyVisibility$2(this, r103, null), 3, null);
        return;
    L22:
        if (r103.length() != 0) goto L24;
    L5:
        r103 = null;
        goto L6
    }
}

package ofc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.photoeditor.crop_rotate.ClipPhotoEditorPlugin;
import com.ss.android.photoeditor.graffiti.GraffitiPhotoEditorPlugin;
import com.ss.android.photoeditor.mosaic.MosaicPhotoEditorPlugin;
import com.ss.android.photoeditor.mosaic.v2.MosaicPhotoEditorPluginV2;
import com.ss.android.photoeditor.text.TextPhotoEditorPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pfc.d;
import pfc.f;
import pfc.j;
import pfc.k;
import pfc.n;
import pfc.o;
import pfc.p;
import pfc.q;
import pfc.r;
import pfc.s;
import pfc.t;
import pfc.v;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f523138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f523139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Bitmap> f523140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, o> f523141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends k>, String> f523142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<o> f523143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f523144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f523145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f523146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j.a f523147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f523148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ufc.a f523149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f523150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<RectF> f523151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f523152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f523153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f523154q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f523155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f523156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f523157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<o> f523158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FrameLayout f523159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public sfc.a.b f523160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ufc.a f523161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f523162h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f523163i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<RectF> f523164j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f523165k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public n.b f523166l;

        public final b a() {
            if (this.f523155a == null) goto L37;
            if (this.f523156b == null) goto L35;
            if (this.f523159e == null) goto L33;
            n.b r100 = this.f523166l;
            if (r100 == null) goto L11;
            n.f529087a = r100;
        L11:
            b r101 = new b(this.f523155a, this);
            String[] r102 = this.f523157c;
            int r103 = 0;
        L13:
            if (r103 >= r102.length) goto L18;
            List<o> r104 = r101.f523143f;
            ArrayList r105 = (ArrayList) r104;
            r105.add((o) ((HashMap) r101.f523141d).get(r102[r103]));
            if (TextUtils.equals(r102[r103], "crop_and_rotate_plugin") == true) goto L17;
            ((ArrayList) r101.f523144g).add(r102[r103]);
        L17:
            r103 = r103 + 1;
            goto L13
        L18:
            int r106 = 0;
        L20:
            if (r106 >= ((ArrayList) r101.f523144g).size()) goto L22;
            ((ArrayList) r101.f523140c).add(null);
            r106 = r106 + 1;
            goto L20
        L22:
            Bitmap r107 = this.f523156b;
            r101.f523148k = r107;
            r101.f523138a.f529044b.f529083b = r107;
            List<o> r108 = this.f523158d;
            if (r108 != null) goto L25;
        L30:
            f r109 = f.i();
            Bitmap r110 = this.f523156b;
            r109.f529053e = r110;
            n.f529087a.i("call setOriginBitmap : " + r110);
            sfc.a.f541747a.getClass();
            sfc.a.f541751e = false;
            sfc.a.f541748b = false;
            sfc.a.f541749c = false;
            sfc.a.f541750d = false;
            ((ArrayList) sfc.a.f541755i).clear();
            ((ArrayList) sfc.a.f541756j).clear();
            ((ArrayList) sfc.a.f541757k).clear();
            sfc.a.f541758l = null;
            sfc.a.f541758l = this.f523160f;
            return r101;
        L25:
            if (((ArrayList) r108).size() <= 0) goto L30;
            int r111 = 0;
        L28:
            if (r111 >= ((ArrayList) this.f523158d).size()) goto L30;
            o r112 = (o) ListProtector.get(this.f523158d, r111);
            String r113 = r112.f529090c;
            ((HashMap) r101.f523141d).put(r113, r112);
            ((HashMap) r101.f523142e).put(r112.f529088a, r113);
            r111 = r111 + 1;
            goto L28
        L33:
            throw new IllegalArgumentException("photoEditorContainer not be null");
        L35:
            throw new IllegalArgumentException("originBitmap not be null");
        L37:
            throw new IllegalArgumentException("context not be null");
        }

        public a() {
            this.f523162h = false;
            this.f523163i = -1.0f;
            this.f523165k = false;
            this.f523158d = new ArrayList();
            this.f523157c = new String[]{"graffiti_plugin", "mosaic_plugin", "crop_and_rotate_plugin", "text_plugin"};
        }
    }

    public final void a() {
        sfc.a.f541747a.getClass();
        sfc.a.b r100 = sfc.a.f541758l;
        if (r100 == null) goto L29;
        Intrinsics.checkNotNull(r100);
        String r101 = "y";
        if (sfc.a.f541748b == false) goto L13;
        JSONObject r102 = new JSONObject();
        if (sfc.a.f541752f == false) goto L10;
        Object r103 = "y";
    L11:
        Statistics.sendEvent("pic_edit_draw", r102.put("pic_edit_draw_size_adjust", r103));
        goto L13
    L10:
        r103 = OfficeSDKRequestTag.KEY_NEW_USER;
    L13:
        if (sfc.a.f541749c == false) goto L20;
        JSONObject r104 = new JSONObject();
        if (sfc.a.f541753g == true) goto L18;
        r101 = OfficeSDKRequestTag.KEY_NEW_USER;
    L18:
        Statistics.sendEvent("pic_edit_Mosaic", r104.put("pic_edit_mosaic_size_adjust", r101));
    L20:
        if (sfc.a.f541750d == false) goto L23;
        Statistics.sendEvent("pic_edit_text", null);
    L23:
        if (sfc.a.f541751e == false) goto L26;
        Statistics.sendEvent("pic_edit_crop", null);
    L26:
        if (sfc.a.f541754h == false) goto L28;
        Statistics.sendEvent("pic_edit_text_size", null);
    L28:
        Statistics.sendEvent("pic_edit_draw_color", new JSONObject().put("color_id", sfc.a.C7605a.d(sfc.a.f541755i)));
        Statistics.sendEvent("pic_edit_mosaic_type", new JSONObject().put("mosaic_id", sfc.a.C7605a.d(sfc.a.f541756j)));
        Statistics.sendEvent("pic_edit_text_box_create", new JSONObject().put("text_color_id", sfc.a.C7605a.d(CollectionsKt.toMutableList(CollectionsKt.distinct(sfc.a.f541757k)))));
    L29:
        Iterator r105 = ((ArrayList) this.f523140c).iterator();
    L31:
        if (r105.hasNext() == false) goto L33;
        com.ss.android.photoeditor.util.b.e((Bitmap) r105.next());
        goto L31
    L33:
        v r106 = this.f523139b;
        Iterator r107 = ((HashMap) r106.f529113o).keySet().iterator();
    L35:
        if (r107.hasNext() == false) goto L37;
        Class r108 = (Class) r107.next();
        ((k) ((HashMap) r106.f529113o).get(r108)).destroy();
        goto L35
    L37:
        r106.f529101c.removeAllViews();
        f r109 = f.i();
        r109.f529049a.clear();
        ((ArrayList) r109.f529051c).clear();
        ((ArrayList) r109.f529050b).clear();
        r109.f529054f.removeCallbacksAndMessages(null);
        r109.f529054f = null;
        r109.f529055g = 0;
        r109.f529052d = null;
        f.f529047h = null;
        n.f529087a.i("call destroy");
    }

    public final b b(j.a r100) {
        this.f523147j = r100;
        Context r101 = this.f523145h;
        FrameLayout r102 = this.f523146i;
        v r103 = new v(r101, r102, this.f523143f, new ofc.a(this));
        this.f523139b = r103;
        View r104 = LayoutInflater.from(r101).inflate(R.layout.view_photo_editor, r103.f529107i);
        r103.f529104f = r104;
        r103.f529111m = r104.findViewById(R.id.ll_bottom_bar);
        r103.f529105g = (LinearLayout) r103.f529104f.findViewById(R.id.ll_plugin_icon_container);
        r103.f529106h = (RelativeLayout) r103.f529104f.findViewById(R.id.rl_top_bar);
        r103.f529112n = (ImageView) r103.f529104f.findViewById(R.id.iv_origin);
        r103.f529107i = (FrameLayout) r103.f529104f.findViewById(R.id.fl_container);
        View r105 = r103.f529106h.findViewById(R.id.tv_close);
        r103.f529108j = r105;
        r105.setOnClickListener(new q(r103));
        View r106 = r103.f529104f.findViewById(R.id.tv_save);
        r103.f529109k = r106;
        r106.setOnClickListener(new r(r103));
        View r107 = r103.f529104f.findViewById(R.id.tv_back);
        r103.f529110l = r107;
        r107.setOnClickListener(new s(r103));
        r102.addView(r103.f529104f);
        int r108 = 0;
    L4:
        if (r108 >= r103.f529102d.size()) goto L9;
        o r109 = (o) ListProtector.get(r103.f529102d, r108);
        ImageView r110 = new ImageView(r103.f529099a);
        r110.setImageDrawable(r109.f529089b);
        r110.setClickable(true);
        r110.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(0, com.ss.android.photoeditor.util.d.b(24), 1.0f);
        r111.setMarginStart((int) j08.b.a(r103.f529099a, 12.0f));
        r111.setMarginEnd((int) j08.b.a(r103.f529099a, 12.0f));
        r110.setLayoutParams(r111);
        r110.setOnClickListener(new t(r103, r109));
        r109.f529091d = r110;
        r103.f529105g.addView(r110);
        if (r103.f529102d.size() != 1) goto L8;
        r103.f529105g.setVisibility(4);
    L8:
        r108 = r108 + 1;
        goto L4
    L9:
        f r112 = f.i();
        r112.f529052d = new p(r103);
        if ((r112.f529049a.size() - r112.f529055g) > 0) goto L12;
        r103.f529110l.setEnabled(false);
    L13:
        r103.f529112n.setImageBitmap(((ofc.a) r103.f529100b).f523137a.f523138a.f529044b.f529083b);
        ViewConfiguration.get(this.f523145h).getScaledTouchSlop();
        List<o> r113 = this.f523143f;
        ArrayList r114 = (ArrayList) r113;
        if (r114.contains(((HashMap) this.f523141d).get("graffiti_plugin")) == false) goto L17;
        v r115 = this.f523139b;
        o r116 = (o) ((HashMap) this.f523141d).get("graffiti_plugin");
        r115.getClass();
        new t(r115, r116).onClick(r116.f529091d);
    L19:
        sfc.a.f541747a.getClass();
        if (sfc.a.f541758l == null) goto L23;
        Statistics.sendEvent("pic_edit", null);
    L23:
        if (sfc.a.f541758l == null) goto L25;
        Statistics.sendEvent("public_pic_edit_view", null);
    L25:
        return this;
    L17:
        if (((ArrayList) this.f523143f).size() <= 0) goto L19;
        v r117 = this.f523139b;
        Map<String, o> r118 = this.f523141d;
        HashMap r119 = (HashMap) r118;
        o r120 = (o) r119.get(((o) ListProtector.get(this.f523143f, 0)).f529090c);
        r117.getClass();
        new t(r117, r120).onClick(r120.f529091d);
        goto L19
    L12:
        r103.f529110l.setEnabled(true);
        goto L13
    }

    public b(Context r100, a r110) {
        this.f523152o = false;
        this.f523153p = -1.0f;
        this.f523154q = false;
        this.f523146i = r110.f523159e;
        ArrayList r101 = new ArrayList();
        this.f523140c = r101;
        this.f523145h = r100;
        HashMap r102 = new HashMap();
        this.f523141d = r102;
        HashMap r103 = new HashMap();
        this.f523142e = r103;
        this.f523143f = new ArrayList();
        this.f523152o = r110.f523162h;
        this.f523153p = r110.f523163i;
        this.f523151n = r110.f523164j;
        this.f523154q = r110.f523165k;
        this.f523138a = new d(r101);
        this.f523144g = new ArrayList();
        ufc.a r111 = r110.f523161g;
        this.f523149l = r111;
        if (r111 == null) goto L5;
        this.f523150m = p0c.a.a().isFeatureGatingEnable("image_editor.smart_mosaic");
    L7:
        if (this.f523150m == false) goto L9;
        Class r112 = MosaicPhotoEditorPluginV2.class;
    L10:
        r102.put("mosaic_plugin", new o(r112, r100.getResources().getDrawable(R.drawable.photo_editor_icon_mosaic), "mosaic_plugin"));
        r102.put("graffiti_plugin", new o(GraffitiPhotoEditorPlugin.class, r100.getResources().getDrawable(R.drawable.photo_editor_icon_graffiti), "graffiti_plugin"));
        r102.put("text_plugin", new o(TextPhotoEditorPlugin.class, r100.getResources().getDrawable(R.drawable.photo_editor_icon_text), "text_plugin"));
        r102.put("crop_and_rotate_plugin", new o(ClipPhotoEditorPlugin.class, r100.getResources().getDrawable(R.drawable.photo_editor_icon_clip), "crop_and_rotate_plugin"));
        r103.put(r112, "mosaic_plugin");
        r103.put(GraffitiPhotoEditorPlugin.class, "graffiti_plugin");
        r103.put(TextPhotoEditorPlugin.class, "text_plugin");
        r103.put(ClipPhotoEditorPlugin.class, "crop_and_rotate_plugin");
        return;
    L9:
        r112 = MosaicPhotoEditorPlugin.class;
        goto L10
    L5:
        this.f523150m = false;
        goto L7
    }
}

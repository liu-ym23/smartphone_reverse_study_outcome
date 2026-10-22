package md2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.live.ktv.common.midi.j;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.o40;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.KtvDressDataKt;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: classes10.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MidiSkinDressInfo f513264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, BitmapDrawable> f513265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Bitmap> f513266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f513267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Drawable> f513268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Drawable> f513269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Drawable> f513270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Bitmap> f513271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Bitmap> f513272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Bitmap> f513273j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f513274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f513275b;

        public a(d r100, String r101) {
            this.f513274a = r100;
            this.f513275b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            this.f513274a.f513265b.put(this.f513275b, new BitmapDrawable(s1.getResources(), r101));
            this.f513274a.f513266c.put(this.f513275b, r101);
            this.f513274a.c();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f513276a = null;

        static {
            f513276a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void H() {
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int getCurrentMode() {
        return 2;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int B() {
        MidiSkinDressInfo r100 = this.f513264a;
        if (r100 == null) goto L26;
        if (KtvDressDataKt.isAvailableMidiSkin(r100) != true) goto L26;
        MidiSkinDressInfo r101 = this.f513264a;
        if (r101 == null) goto L26;
        MidiSkinMaterial r102 = r101.getMaterial();
        if (r102 == null) goto L26;
        String r103 = r102.getScoreColor();
        if (r103 == null) goto L26;
        if (r103.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 != true) goto L26;
        MidiSkinDressInfo r105 = this.f513264a;
        if (r105 == null) goto L22;
        MidiSkinMaterial r106 = r105.getMaterial();
        if (r106 == null) goto L22;
        String r107 = r106.getScoreColor();
    L24:
        return ColorProtector.parseColor(r107);
    L22:
        r107 = null;
        goto L24
    L15:
        r104 = false;
    L26:
        return s1.h(R.color.ttlive_chorus_midi_score_low_text_color);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int D() {
        return o40.f120880a.getValue().intValue();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final int F() {
        return o40.f120880a.getValue().intValue();
    }

    public final boolean a() {
        MidiSkinDressInfo r100 = this.f513264a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        MidiSkinDressInfo r103 = this.f513264a;
        if (r103 == null) goto L12;
        r101 = r103.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r101, "0")) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public final void c() {
        BitmapDrawable r100 = this.f513265b.get("advan_scatter_deco_a");
        if (r100 != null) goto L6;
        r100 = s1.m(R.drawable.ttlive_chorus_hit_drawable_4);
    L6:
        BitmapDrawable r101 = this.f513265b.get("advan_scatter_deco_b");
        if (r101 != null) goto L10;
        r101 = s1.m(R.drawable.ttlive_chorus_hit_drawable_3);
    L10:
        BitmapDrawable r102 = this.f513265b.get("univ_scatter_deco_a");
        if (r102 != null) goto L14;
        r102 = s1.m(R.drawable.ttlive_ktv_hit_drawable_2);
    L14:
        BitmapDrawable r103 = this.f513265b.get("univ_scatter_deco_b");
        if (r103 != null) goto L18;
        r103 = s1.m(R.drawable.ttlive_ktv_hit_drawable_3);
    L18:
        List r104 = CollectionsKt.listOf(new Drawable[]{r102, s1.m(R.drawable.ttlive_ktv_hit_drawable_1), r103, r101, r100, r101, r100, r101, r100, r101});
        this.f513269f.clear();
        this.f513269f.addAll(r104);
        Bitmap r105 = this.f513266c.get("advan_scatter_deco_a");
        if (r105 != null) goto L21;
        r105 = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_chorus_hit_drawable_4);
    L21:
        Bitmap r106 = this.f513266c.get("advan_scatter_deco_b");
        if (r106 != null) goto L24;
        r106 = BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_chorus_hit_drawable_3);
    L24:
        List r107 = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_2), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_3), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_chorus_hit_drawable_3), r105, r106, r105, r106, r105, r106});
        this.f513272i.clear();
        this.f513272i.addAll(r107);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void clear() {
        ((LinkedHashMap) this.f513265b).clear();
        ((LinkedHashMap) this.f513266c).clear();
        this.f513267d.dispose();
    }

    public d() {
        this.f513265b = new LinkedHashMap();
        this.f513266c = new LinkedHashMap();
        this.f513267d = new CompositeDisposable();
        this.f513269f = new ArrayList();
        this.f513272i = new ArrayList();
        this.f513268e = CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_2));
        c();
        this.f513270g = CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3), s1.m(R.drawable.ttlive_chorus_hit_drawable_3)});
        this.f513271h = CollectionsKt.listOf(BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_2));
        this.f513273j = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_2), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_ktv_hit_drawable_3), BitmapFactory.decodeResource(s1.getResources(), R.drawable.ttlive_chorus_hit_drawable_3)});
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final Pair<String, String> E() {
        if (a() == false) goto L22;
        MidiSkinDressInfo r100 = this.f513264a;
        String r101 = null;
        if (r100 == null) goto L11;
        MidiSkinMaterial r102 = r100.getMaterial();
        if (r102 == null) goto L11;
        BackgroundMaterial r103 = r102.getBg();
        if (r103 == null) goto L11;
        String r104 = r103.getToneLineStart();
    L12:
        MidiSkinDressInfo r105 = this.f513264a;
        if (r105 == null) goto L20;
        MidiSkinMaterial r106 = r105.getMaterial();
        if (r106 == null) goto L20;
        BackgroundMaterial r107 = r106.getBg();
        if (r107 == null) goto L20;
        r101 = r107.getToneLineEnd();
    L20:
        return TuplesKt.to(r104, r101);
    L11:
        r104 = null;
        goto L12
    L22:
        return TuplesKt.to("#2AF2C9", "#2AF2C9");
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final k G() {
        if (a() == false) goto L12;
        MidiSkinDressInfo r100 = this.f513264a;
        if (r100 == null) goto L11;
        MidiSkinMaterial r101 = r100.getMaterial();
        if (r101 == null) goto L11;
        BackgroundMaterial r102 = r101.getBg();
        if (r102 == null) goto L11;
        return r102.getBuoyAreaBg();
    L11:
        return null;
    L12:
        int r103 = qy.a.f535172a;
        return qy.a.a(j.f69856c);
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String J() {
        if (a() == false) goto L17;
        MidiSkinDressInfo r100 = this.f513264a;
        if (r100 == null) goto L17;
        MidiSkinMaterial r101 = r100.getMaterial();
        if (r101 == null) goto L17;
        FeedbackMaterial r102 = r101.getFeedback();
        if (r102 == null) goto L17;
        k r103 = r102.getAdvanPerfectBg();
        if (r103 == null) goto L17;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L17;
        String r105 = (String) CollectionsKt.first(r104);
        if (r105 == null) goto L17;
        return r105;
    L17:
        return j.f69854a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final MidiSkinDressInfo z() {
        return this.f513264a;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final void y(MidiSkinDressInfo r100) {
        this.f513264a = r100;
        if (a() == false) goto L36;
        k r101 = null;
        if (r100 == null) goto L11;
        MidiSkinMaterial r102 = r100.getMaterial();
        if (r102 == null) goto L11;
        BuoyMaterial r103 = r102.getBuoy();
        if (r103 == null) goto L11;
        k r104 = r103.getAdvanScatterDecoA();
    L12:
        b("advan_scatter_deco_a", r104);
        if (r100 == null) goto L19;
        MidiSkinMaterial r105 = r100.getMaterial();
        if (r105 == null) goto L19;
        BuoyMaterial r106 = r105.getBuoy();
        if (r106 == null) goto L19;
        k r107 = r106.getAdvanScatterDecoB();
    L20:
        b("advan_scatter_deco_b", r107);
        if (r100 == null) goto L27;
        MidiSkinMaterial r108 = r100.getMaterial();
        if (r108 == null) goto L27;
        BuoyMaterial r109 = r108.getBuoy();
        if (r109 == null) goto L27;
        k r110 = r109.getUnivScatterDecoA();
    L28:
        b("univ_scatter_deco_a", r110);
        if (r100 == null) goto L35;
        MidiSkinMaterial r111 = r100.getMaterial();
        if (r111 == null) goto L35;
        BuoyMaterial r112 = r111.getBuoy();
        if (r112 == null) goto L35;
        r101 = r112.getUnivScatterDecoB();
    L35:
        b("univ_scatter_deco_b", r101);
        return;
    L27:
        r110 = null;
    L19:
        r107 = null;
    L11:
        r104 = null;
        goto L12
    L36:
        ((LinkedHashMap) this.f513266c).clear();
        ((LinkedHashMap) this.f513265b).clear();
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Bitmap> I(Integer r100, boolean r101) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 == null) goto L20;
        if (r100.intValue() != 3) goto L20;
        if (r101 == false) goto L23;
        return this.f513272i;
    L23:
        return this.f513273j;
    L20:
        return this.f513271h;
    L10:
        if (r100.intValue() != 2) goto L12;
    L21:
        return this.f513271h;
    L5:
        if (r100.intValue() != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final String K(int r100, boolean r101) {
        boolean r102 = a();
        if (r100 != 1) goto L5;
        if (r102 == false) goto L62;
        MidiSkinDressInfo r103 = this.f513264a;
        if (r103 == null) goto L84;
        MidiSkinMaterial r104 = r103.getMaterial();
        if (r104 == null) goto L85;
        FeedbackMaterial r105 = r104.getFeedback();
        if (r105 == null) goto L86;
        k r106 = r105.getNice();
        if (r106 == null) goto L87;
        List<String> r107 = r106.getUrls();
        if (r107 != null) goto L89;
        return null;
    L89:
        return (String) CollectionsKt.first(r107);
    L87:
        return null;
    L86:
        return null;
    L85:
        return null;
    L84:
        return null;
    L62:
        String r108 = j.f69854a;
        return j.f69858e;
    L5:
        if (r100 != 2) goto L7;
        if (r102 == false) goto L49;
        MidiSkinDressInfo r109 = this.f513264a;
        if (r109 == null) goto L77;
        MidiSkinMaterial r110 = r109.getMaterial();
        if (r110 == null) goto L78;
        FeedbackMaterial r111 = r110.getFeedback();
        if (r111 == null) goto L79;
        k r112 = r111.getGood();
        if (r112 == null) goto L80;
        List<String> r113 = r112.getUrls();
        if (r113 != null) goto L82;
        return null;
    L82:
        return (String) CollectionsKt.first(r113);
    L80:
        return null;
    L79:
        return null;
    L78:
        return null;
    L77:
        return null;
    L49:
        String r114 = j.f69854a;
        return j.f69859f;
    L7:
        if (r100 != 3) goto L90;
        if (r101 == false) goto L23;
        if (r102 == false) goto L22;
        MidiSkinDressInfo r115 = this.f513264a;
        if (r115 == null) goto L64;
        MidiSkinMaterial r116 = r115.getMaterial();
        if (r116 == null) goto L65;
        FeedbackMaterial r117 = r116.getFeedback();
        if (r117 == null) goto L66;
        k r118 = r117.getAdvanPerfectTx();
        if (r118 == null) goto L67;
        List<String> r119 = r118.getUrls();
        if (r119 != null) goto L69;
        return null;
    L69:
        return (String) CollectionsKt.first(r119);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L64:
        return null;
    L22:
        String r120 = j.f69854a;
        return j.f69855b;
    L23:
        if (r102 == false) goto L35;
        MidiSkinDressInfo r121 = this.f513264a;
        if (r121 == null) goto L71;
        MidiSkinMaterial r122 = r121.getMaterial();
        if (r122 == null) goto L72;
        FeedbackMaterial r123 = r122.getFeedback();
        if (r123 == null) goto L73;
        k r124 = r123.getPerfect();
        if (r124 == null) goto L74;
        List<String> r125 = r124.getUrls();
        if (r125 == null) goto L75;
        String r126 = (String) CollectionsKt.first(r125);
    L76:
        return r126;
    L75:
        return null;
    L74:
        return null;
    L73:
        return null;
    L72:
        return null;
    L71:
        return null;
    L35:
        String r127 = j.f69854a;
        r126 = j.f69855b;
        goto L76
    L90:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> M(Integer r100, boolean r101) {
        return this.f513269f;
    }

    @Override // com.bytedance.android.live.ktv.common.midi.g
    public final List<Drawable> N(Integer r100, boolean r110) {
        if (r100 == null) goto L9;
        if (r100.intValue() != 1) goto L9;
    L32:
        return CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_2));
    L9:
        if (r100 != null) goto L12;
    L14:
        if (r100 == null) goto L31;
        if (r100.intValue() != 3) goto L31;
        if (r110 == false) goto L34;
        Drawable r111 = (BitmapDrawable) ((LinkedHashMap) this.f513265b).get("advan_scatter_deco_a");
        if (r111 != null) goto L24;
        r111 = s1.m(R.drawable.ttlive_chorus_hit_drawable_4);
    L24:
        Drawable r101 = (BitmapDrawable) ((LinkedHashMap) this.f513265b).get("advan_scatter_deco_b");
        if (r101 != null) goto L33;
        r101 = s1.m(R.drawable.ttlive_chorus_hit_drawable_3);
    L33:
        return CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3), s1.m(R.drawable.ttlive_chorus_hit_drawable_3), r111, r101, r111, r101, r111, r101});
    L34:
        return CollectionsKt.listOf(new Drawable[]{s1.m(R.drawable.ttlive_ktv_hit_drawable_2), s1.m(R.drawable.ttlive_ktv_hit_drawable_3), s1.m(R.drawable.ttlive_chorus_hit_drawable_3)});
    L31:
        return CollectionsKt.listOf(s1.m(R.drawable.ttlive_ktv_hit_drawable_2));
    L12:
        if (r100.intValue() != 2) goto L14;
        goto L14
    }

    public final void b(String r100, k r101) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        if (r101 != null) goto L9;
    L11:
        RxUtilKt.c(a1.k(r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r100), b.f513276a), this.f513267d);
        return;
    L9:
        if (r101.isValid() == true) goto L11;
        return;
    L13:
        return;
    L5:
        r102 = false;
        goto L6
    }
}

package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.KtvDressDataKt;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class e implements com.bytedance.android.live.ktv.common.midi.g {
    public MidiSkinDressInfo a;
    public final Map<String, BitmapDrawable> b;
    public final Map<String, Bitmap> c;
    public final CompositeDisposable d;
    public final List<Drawable> e;
    public final List<Drawable> f;
    public final List<Drawable> g;
    public final List<Bitmap> h;
    public final List<Bitmap> i;
    public final List<Bitmap> j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;

        public a(e r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            this.a.b.put(this.b, new BitmapDrawable(s1.getResources(), r6));
            this.a.c.put(this.b, r6);
            this.a.c();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public final void H() {
    }

    public final int getCurrentMode() {
        return 2;
    }

    public final int B() {
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L26;
        if (KtvDressDataKt.isAvailableMidiSkin(r0) != true) goto L26;
        MidiSkinDressInfo r1 = this.a;
        if (r1 == null) goto L26;
        MidiSkinMaterial r2 = r1.getMaterial();
        if (r2 == null) goto L26;
        String r3 = r2.getScoreColor();
        if (r3 == null) goto L26;
        if (r3.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 != true) goto L26;
        MidiSkinDressInfo r5 = this.a;
        if (r5 == null) goto L22;
        MidiSkinMaterial r6 = r5.getMaterial();
        if (r6 == null) goto L22;
        String r7 = r6.getScoreColor();
    L24:
        return ColorProtector.parseColor(r7);
    L22:
        r7 = null;
        goto L24
    L15:
        r4 = false;
    L26:
        return s1.h(2131106997);
    }

    public final boolean a() {
        MidiSkinDressInfo r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getDressId();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        MidiSkinDressInfo r3 = this.a;
        if (r3 == null) goto L12;
        r1 = r3.getDressId();
    L12:
        if ((!Intrinsics.areEqual(r1, BDLocationException.ERROR_TIMEOUT)) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public final void c() {
        BitmapDrawable r1 = this.b.get("advan_scatter_deco_a");
        if (r1 != null) goto L6;
        r1 = s1.m(2131250223);
    L6:
        BitmapDrawable r4 = this.b.get("advan_scatter_deco_b");
        if (r4 != null) goto L10;
        r4 = s1.m(2131250222);
    L10:
        BitmapDrawable r7 = this.b.get("univ_scatter_deco_a");
        if (r7 != null) goto L14;
        r7 = s1.m(2131252075);
    L14:
        BitmapDrawable r9 = this.b.get("univ_scatter_deco_b");
        if (r9 != null) goto L18;
        r9 = s1.m(2131252076);
    L18:
        List r5 = CollectionsKt.listOf(new Drawable[]{r7, s1.m(2131252074), r9, r4, r1, r4, r1, r4, r1, r4});
        this.f.clear();
        this.f.addAll(r5);
        Bitmap r2 = this.c.get("advan_scatter_deco_a");
        if (r2 != null) goto L21;
        r2 = BitmapFactory.decodeResource(s1.getResources(), 2131250223);
    L21:
        Bitmap r3 = this.c.get("advan_scatter_deco_b");
        if (r3 != null) goto L24;
        r3 = BitmapFactory.decodeResource(s1.getResources(), 2131250222);
    L24:
        List r6 = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076), BitmapFactory.decodeResource(s1.getResources(), 2131250222), r2, r3, r2, r3, r2, r3});
        this.i.clear();
        this.i.addAll(r6);
    }

    public final void clear() {
        ((LinkedHashMap) this.b).clear();
        ((LinkedHashMap) this.c).clear();
        this.d.dispose();
    }

    public e() {
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new CompositeDisposable();
        this.f = new ArrayList();
        this.i = new ArrayList();
        this.e = CollectionsKt.listOf(s1.m(2131252075));
        c();
        this.g = CollectionsKt.listOf(new Drawable[]{s1.m(2131252075), s1.m(2131252076), s1.m(2131250222)});
        this.h = CollectionsKt.listOf(BitmapFactory.decodeResource(s1.getResources(), 2131252075));
        this.j = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076), BitmapFactory.decodeResource(s1.getResources(), 2131250222)});
    }

    public final int D() {
        return vm2.h.w();
    }

    public final Pair<String, String> E() {
        if (a() == false) goto L22;
        MidiSkinDressInfo r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L11;
        MidiSkinMaterial r2 = r0.getMaterial();
        if (r2 == null) goto L11;
        BackgroundMaterial r3 = r2.getBg();
        if (r3 == null) goto L11;
        String r4 = r3.getToneLineStart();
    L12:
        MidiSkinDressInfo r5 = this.a;
        if (r5 == null) goto L20;
        MidiSkinMaterial r6 = r5.getMaterial();
        if (r6 == null) goto L20;
        BackgroundMaterial r7 = r6.getBg();
        if (r7 == null) goto L20;
        r1 = r7.getToneLineEnd();
    L20:
        return TuplesKt.to(r4, r1);
    L11:
        r4 = null;
        goto L12
    L22:
        return TuplesKt.to("#2AF2C9", "#2AF2C9");
    }

    public final int F() {
        return vm2.h.w();
    }

    public final py.k G() {
        if (a() == false) goto L12;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L11;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L11;
        BackgroundMaterial r2 = r1.getBg();
        if (r2 == null) goto L11;
        return r2.getBuoyAreaBg();
    L11:
        return null;
    L12:
        int r3 = qy.a.a;
        return qy.a.a(com.bytedance.android.live.ktv.common.midi.j.c);
    }

    public final String J() {
        if (a() == false) goto L17;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L17;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L17;
        FeedbackMaterial r2 = r1.getFeedback();
        if (r2 == null) goto L17;
        py.k r3 = r2.getAdvanPerfectBg();
        if (r3 == null) goto L17;
        List r4 = r3.getUrls();
        if (r4 == null) goto L17;
        String r5 = (String) CollectionsKt.first(r4);
        if (r5 == null) goto L17;
        return r5;
    L17:
        return com.bytedance.android.live.ktv.common.midi.j.a;
    }

    public final MidiSkinDressInfo z() {
        return this.a;
    }

    public final void y(MidiSkinDressInfo r4) {
        this.a = r4;
        if (a() == false) goto L36;
        py.k r0 = null;
        if (r4 == null) goto L11;
        MidiSkinMaterial r1 = r4.getMaterial();
        if (r1 == null) goto L11;
        BuoyMaterial r2 = r1.getBuoy();
        if (r2 == null) goto L11;
        py.k r3 = r2.getAdvanScatterDecoA();
    L12:
        b("advan_scatter_deco_a", r3);
        if (r4 == null) goto L19;
        MidiSkinMaterial r5 = r4.getMaterial();
        if (r5 == null) goto L19;
        BuoyMaterial r6 = r5.getBuoy();
        if (r6 == null) goto L19;
        py.k r7 = r6.getAdvanScatterDecoB();
    L20:
        b("advan_scatter_deco_b", r7);
        if (r4 == null) goto L27;
        MidiSkinMaterial r8 = r4.getMaterial();
        if (r8 == null) goto L27;
        BuoyMaterial r9 = r8.getBuoy();
        if (r9 == null) goto L27;
        py.k r10 = r9.getUnivScatterDecoA();
    L28:
        b("univ_scatter_deco_a", r10);
        if (r4 == null) goto L35;
        MidiSkinMaterial r11 = r4.getMaterial();
        if (r11 == null) goto L35;
        BuoyMaterial r12 = r11.getBuoy();
        if (r12 == null) goto L35;
        r0 = r12.getUnivScatterDecoB();
    L35:
        b("univ_scatter_deco_b", r0);
        return;
    L27:
        r10 = null;
    L19:
        r7 = null;
    L11:
        r3 = null;
        goto L12
    L36:
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.b).clear();
    }

    public final List<Bitmap> I(Integer r3, boolean r4) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 == null) goto L20;
        if (r3.intValue() != 3) goto L20;
        if (r4 == false) goto L23;
        return this.i;
    L23:
        return this.j;
    L20:
        return this.h;
    L10:
        if (r3.intValue() != 2) goto L12;
    L21:
        return this.h;
    L5:
        if (r3.intValue() != 1) goto L7;
        goto L7
    }

    public final String K(int r4, boolean r5) {
        boolean r0 = a();
        if (r4 != 1) goto L5;
        if (r0 == false) goto L62;
        MidiSkinDressInfo r6 = this.a;
        if (r6 == null) goto L84;
        MidiSkinMaterial r7 = r6.getMaterial();
        if (r7 == null) goto L85;
        FeedbackMaterial r8 = r7.getFeedback();
        if (r8 == null) goto L86;
        py.k r9 = r8.getNice();
        if (r9 == null) goto L87;
        List r10 = r9.getUrls();
        if (r10 != null) goto L89;
        return null;
    L89:
        return (String) CollectionsKt.first(r10);
    L87:
        return null;
    L86:
        return null;
    L85:
        return null;
    L84:
        return null;
    L62:
        String r11 = com.bytedance.android.live.ktv.common.midi.j.a;
        return com.bytedance.android.live.ktv.common.midi.j.e;
    L5:
        if (r4 != 2) goto L7;
        if (r0 == false) goto L49;
        MidiSkinDressInfo r12 = this.a;
        if (r12 == null) goto L77;
        MidiSkinMaterial r13 = r12.getMaterial();
        if (r13 == null) goto L78;
        FeedbackMaterial r14 = r13.getFeedback();
        if (r14 == null) goto L79;
        py.k r15 = r14.getGood();
        if (r15 == null) goto L80;
        List r16 = r15.getUrls();
        if (r16 != null) goto L82;
        return null;
    L82:
        return (String) CollectionsKt.first(r16);
    L80:
        return null;
    L79:
        return null;
    L78:
        return null;
    L77:
        return null;
    L49:
        String r17 = com.bytedance.android.live.ktv.common.midi.j.a;
        return com.bytedance.android.live.ktv.common.midi.j.f;
    L7:
        if (r4 != 3) goto L90;
        if (r5 == false) goto L23;
        if (r0 == false) goto L22;
        MidiSkinDressInfo r18 = this.a;
        if (r18 == null) goto L64;
        MidiSkinMaterial r19 = r18.getMaterial();
        if (r19 == null) goto L65;
        FeedbackMaterial r20 = r19.getFeedback();
        if (r20 == null) goto L66;
        py.k r21 = r20.getAdvanPerfectTx();
        if (r21 == null) goto L67;
        List r22 = r21.getUrls();
        if (r22 != null) goto L69;
        return null;
    L69:
        return (String) CollectionsKt.first(r22);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L64:
        return null;
    L22:
        String r23 = com.bytedance.android.live.ktv.common.midi.j.a;
        return com.bytedance.android.live.ktv.common.midi.j.b;
    L23:
        if (r0 == false) goto L35;
        MidiSkinDressInfo r24 = this.a;
        if (r24 == null) goto L71;
        MidiSkinMaterial r25 = r24.getMaterial();
        if (r25 == null) goto L72;
        FeedbackMaterial r26 = r25.getFeedback();
        if (r26 == null) goto L73;
        py.k r27 = r26.getPerfect();
        if (r27 == null) goto L74;
        List r28 = r27.getUrls();
        if (r28 == null) goto L75;
        String r29 = (String) CollectionsKt.first(r28);
    L76:
        return r29;
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
        String r30 = com.bytedance.android.live.ktv.common.midi.j.a;
        r29 = com.bytedance.android.live.ktv.common.midi.j.b;
        goto L76
    L90:
        return null;
    }

    public final List<Drawable> M(Integer r1, boolean r2) {
        return this.f;
    }

    public final List<Drawable> N(Integer r9, boolean r10) {
        if (r9 == null) goto L9;
        if (r9.intValue() != 1) goto L9;
    L32:
        return CollectionsKt.listOf(s1.m(2131252075));
    L9:
        if (r9 != null) goto L12;
    L14:
        if (r9 == null) goto L31;
        if (r9.intValue() != 3) goto L31;
        if (r10 == false) goto L34;
        Drawable r11 = (BitmapDrawable) ((LinkedHashMap) this.b).get("advan_scatter_deco_a");
        if (r11 != null) goto L24;
        r11 = s1.m(2131250223);
    L24:
        Drawable r6 = (BitmapDrawable) ((LinkedHashMap) this.b).get("advan_scatter_deco_b");
        if (r6 != null) goto L33;
        r6 = s1.m(2131250222);
    L33:
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252075), s1.m(2131252076), s1.m(2131250222), r11, r6, r11, r6, r11, r6});
    L34:
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252075), s1.m(2131252076), s1.m(2131250222)});
    L31:
        return CollectionsKt.listOf(s1.m(2131252075));
    L12:
        if (r9.intValue() != 2) goto L14;
        goto L14
    }

    public final void b(String r2, py.k r3) {
        if (StringsKt.isBlank(r2) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        if (r3 != null) goto L9;
    L11:
        RxUtilKt.c(a1.k(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r2), b.a), this.d);
        return;
    L9:
        if (r3.isValid() == true) goto L11;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }
}

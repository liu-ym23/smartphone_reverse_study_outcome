package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements g {
    public MidiSkinDressInfo a;
    public final CompositeDisposable b;
    public final Map<String, Drawable> c;
    public final List<Drawable> d;
    public final List<Drawable> e;
    public final List<Drawable> f;
    public final List<Bitmap> g;
    public final List<Bitmap> h;
    public final List<Bitmap> i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.a$a, reason: collision with other inner class name */
    public static final class C0030a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public C0030a(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Map<String, Drawable> r0 = this.a.c;
            String r1 = this.b;
            Resources r3 = s1.getResources();
            r0.put(r1, new BitmapDrawable(r3, (Bitmap) r5));
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

    public final boolean A() {
        return false;
    }

    public final int D() {
        return 6;
    }

    public final int F() {
        return 4;
    }

    public final void H() {
    }

    public final boolean L() {
        return true;
    }

    public final int getCurrentMode() {
        return 1;
    }

    public a() {
        this.b = new CompositeDisposable();
        this.c = new LinkedHashMap();
        this.d = CollectionsKt.listOf(s1.m(2131252074));
        this.e = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078)});
        this.f = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
        this.g = CollectionsKt.listOf(BitmapFactory.decodeResource(s1.getResources(), 2131252074));
        this.h = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252074), BitmapFactory.decodeResource(s1.getResources(), 2131252074), BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076), BitmapFactory.decodeResource(s1.getResources(), 2131252077), BitmapFactory.decodeResource(s1.getResources(), 2131252078), BitmapFactory.decodeResource(s1.getResources(), 2131252077), BitmapFactory.decodeResource(s1.getResources(), 2131252078), BitmapFactory.decodeResource(s1.getResources(), 2131252077), BitmapFactory.decodeResource(s1.getResources(), 2131252078)});
        this.i = CollectionsKt.listOf(new Bitmap[]{BitmapFactory.decodeResource(s1.getResources(), 2131252074), BitmapFactory.decodeResource(s1.getResources(), 2131252075), BitmapFactory.decodeResource(s1.getResources(), 2131252076)});
    }

    public final Pair<String, String> E() {
        return TuplesKt.to("#FF4BE8", "#FF386B");
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

    public final void clear() {
        ((LinkedHashMap) this.c).clear();
        this.b.dispose();
    }

    public final int B() {
        return s1.h(2131107710);
    }

    public final int C() {
        if (KtvSettingHelper.z() == false) goto L6;
        return KtvSettingHelper.l();
    L6:
        return h.x();
    }

    public final k G() {
        if (a() == false) goto L12;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L13;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L14;
        BackgroundMaterial r2 = r1.getBg();
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getBuoyAreaBg();
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public final String J() {
        if (a() == false) goto L17;
        MidiSkinDressInfo r0 = this.a;
        if (r0 == null) goto L17;
        MidiSkinMaterial r1 = r0.getMaterial();
        if (r1 == null) goto L17;
        FeedbackMaterial r2 = r1.getFeedback();
        if (r2 == null) goto L17;
        k r3 = r2.getAdvanPerfectBg();
        if (r3 == null) goto L17;
        List r4 = r3.getUrls();
        if (r4 == null) goto L17;
        String r5 = (String) CollectionsKt.first(r4);
        if (r5 == null) goto L17;
        return r5;
    L17:
        return com.bytedance.android.live.ktv.common.midi.c.a;
    }

    public final MidiSkinDressInfo z() {
        return this.a;
    }

    public final void y(MidiSkinDressInfo r4) {
        this.a = r4;
        if (a() == false) goto L20;
        k r0 = null;
        if (r4 == null) goto L11;
        MidiSkinMaterial r1 = r4.getMaterial();
        if (r1 == null) goto L11;
        BuoyMaterial r2 = r1.getBuoy();
        if (r2 == null) goto L11;
        k r3 = r2.getAdvanScatterDecoA();
    L12:
        b("advan_scatter_deco_a", r3);
        if (r4 == null) goto L19;
        MidiSkinMaterial r5 = r4.getMaterial();
        if (r5 == null) goto L19;
        BuoyMaterial r6 = r5.getBuoy();
        if (r6 == null) goto L19;
        r0 = r6.getAdvanScatterDecoB();
    L19:
        b("advan_scatter_deco_b", r0);
        return;
    L11:
        r3 = null;
        goto L12
    L20:
        ((LinkedHashMap) this.c).clear();
    }

    public final List<Bitmap> I(Integer r3, boolean r4) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 == null) goto L20;
        if (r3.intValue() != 3) goto L20;
        if (r4 == false) goto L23;
        return this.h;
    L23:
        return this.i;
    L20:
        return this.g;
    L10:
        if (r3.intValue() != 2) goto L12;
    L21:
        return this.g;
    L5:
        if (r3.intValue() != 1) goto L7;
        goto L7
    }

    public final String K(int r3, boolean r4) {
        if (r3 == 1) goto L59;
        if (r3 == 2) goto L44;
        if (r3 != 3) goto L84;
        if (r4 == false) goto L26;
        if (a() == false) goto L24;
        MidiSkinDressInfo r5 = this.a;
        if (r5 == null) goto L24;
        MidiSkinMaterial r6 = r5.getMaterial();
        if (r6 == null) goto L24;
        FeedbackMaterial r7 = r6.getFeedback();
        if (r7 == null) goto L24;
        k r8 = r7.getAdvanPerfectTx();
        if (r8 == null) goto L24;
        List r9 = r8.getUrls();
        if (r9 == null) goto L24;
        String r1 = (String) CollectionsKt.first(r9);
        if (r1 == null) goto L24;
        return r1;
    L24:
        String r10 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.c;
    L26:
        if (a() == false) goto L40;
        MidiSkinDressInfo r11 = this.a;
        if (r11 == null) goto L39;
        MidiSkinMaterial r12 = r11.getMaterial();
        if (r12 == null) goto L39;
        FeedbackMaterial r13 = r12.getFeedback();
        if (r13 == null) goto L39;
        k r14 = r13.getPerfect();
        if (r14 == null) goto L39;
        List r15 = r14.getUrls();
        if (r15 == null) goto L39;
        String r16 = (String) CollectionsKt.first(r15);
        if (r16 == null) goto L39;
    L75:
        return r16;
    L39:
        String r17 = com.bytedance.android.live.ktv.common.midi.c.a;
    L41:
        r16 = com.bytedance.android.live.ktv.common.midi.c.g;
        goto L75
    L40:
        String r18 = com.bytedance.android.live.ktv.common.midi.c.a;
        goto L41
    L84:
        return null;
    L44:
        if (a() == false) goto L57;
        MidiSkinDressInfo r19 = this.a;
        if (r19 == null) goto L57;
        MidiSkinMaterial r20 = r19.getMaterial();
        if (r20 == null) goto L57;
        FeedbackMaterial r21 = r20.getFeedback();
        if (r21 == null) goto L57;
        k r22 = r21.getGood();
        if (r22 == null) goto L57;
        List r23 = r22.getUrls();
        if (r23 == null) goto L57;
        String r2 = (String) CollectionsKt.first(r23);
        if (r2 == null) goto L57;
        return r2;
    L57:
        String r24 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.f;
    L59:
        if (a() == false) goto L71;
        MidiSkinDressInfo r25 = this.a;
        if (r25 == null) goto L78;
        MidiSkinMaterial r26 = r25.getMaterial();
        if (r26 == null) goto L79;
        FeedbackMaterial r27 = r26.getFeedback();
        if (r27 == null) goto L80;
        k r28 = r27.getNice();
        if (r28 == null) goto L81;
        List r29 = r28.getUrls();
        if (r29 != null) goto L83;
        return null;
    L83:
        return (String) CollectionsKt.first(r29);
    L81:
        return null;
    L80:
        return null;
    L79:
        return null;
    L78:
        return null;
    L71:
        String r30 = com.bytedance.android.live.ktv.common.midi.c.a;
        return com.bytedance.android.live.ktv.common.midi.c.e;
    }

    public final List<Drawable> M(Integer r3, boolean r4) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 == null) goto L20;
        if (r3.intValue() != 3) goto L20;
        if (r4 == false) goto L23;
        return this.e;
    L23:
        return this.f;
    L20:
        return this.d;
    L10:
        if (r3.intValue() != 2) goto L12;
    L21:
        return this.d;
    L5:
        if (r3.intValue() != 1) goto L7;
        goto L7
    }

    public final List<Drawable> N(Integer r7, boolean r8) {
        if (r7 == null) goto L9;
        if (r7.intValue() != 1) goto L9;
    L24:
        return CollectionsKt.listOf(s1.m(2131252074));
    L9:
        if (r7 != null) goto L12;
    L14:
        if (r7 == null) goto L23;
        if (r7.intValue() != 3) goto L23;
        if (r8 == false) goto L26;
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078)});
    L26:
        return CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
    L23:
        return CollectionsKt.listOf(s1.m(2131252074));
    L12:
        if (r7.intValue() != 2) goto L14;
        goto L14
    }

    public final void b(String r2, k r3) {
        if (StringsKt.isBlank(r2) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        if (r3 != null) goto L9;
    L11:
        RxUtilKt.c(a1.k(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0030a(this, r2), b.a), this.b);
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

package eob;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlineStrategy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import fob.d;
import fob.f;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
public class a extends BaseFunctionEditor<hob.b> implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C5799a f473406f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends hob.b>, d<? extends hob.b>> f473407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> f473408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> f473409e;

    /* JADX INFO: renamed from: eob.a$a, reason: collision with other inner class name */
    public static final class C5799a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f473410a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<a> a() {
            return this.f473410a.f428961a;
        }

        public C5799a() {
            this.f473410a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        f473406f = new C5799a();
    }

    public final void V() {
        this.f473408d.clear();
        this.f473409e.clear();
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r100 = this.f473408d;
        Map<Class<? extends hob.b>, d<? extends hob.b>> r101 = this.f473407c;
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put(r104.getKey(), ((d) r104.getValue()).a(this));
        goto L4
    L6:
        r100.putAll(r102);
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r105 = this.f473409e;
        Map<Class<? extends hob.b>, d<? extends hob.b>> r106 = this.f473407c;
        LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r106.size()));
        Iterator<T> r108 = r106.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put(r109.getKey(), ((d) r109.getValue()).b(this));
        goto L8
    L10:
        r105.putAll(r107);
    }

    public final void X() {
        com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c r100 = com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.f428985a;
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f473407c.remove(r100.getType());
        this.f473408d.remove(r100.getType());
        this.f473409e.remove(r100.getType());
    }

    public a() {
        this.f473407c = new LinkedHashMap();
        this.f473408d = new LinkedHashMap();
        this.f473409e = new LinkedHashMap();
        Y(CollectionsKt.listOf(UrlInlineStrategy.f429001c));
        V();
    }

    public final void U(d<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f473407c.put((Class<? extends hob.b>) r100.getType(), (d<? extends hob.b>) r100);
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r101 = this.f473408d;
        GenericDeclaration r102 = r100.getType();
        r101.put((Class<? extends hob.b>) r102, r100.a(this));
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r103 = this.f473409e;
        GenericDeclaration r104 = r100.getType();
        r103.put((Class<? extends hob.b>) r104, r100.b(this));
    }

    public final void Y(List<? extends d<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f473407c.clear();
        Map<Class<? extends hob.b>, d<? extends hob.b>> r101 = this.f473407c;
        List<? extends d<?>> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        d r105 = (d) r104.next();
        r103.add(TuplesKt.to(r105.getType(), r105));
        goto L4
    L6:
        MapsKt.putAll(r101, r103);
        V();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, hob.b r101, int r102) {
        W(r100, r101, r102);
    }

    public void W(SpannableStringBuilder r100, hob.b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        String r103 = r101.f486304a;
        r100.append(r103);
        Object r104 = ((LinkedHashMap) this.f473407c).get(r101.getClass());
        if ((r104 instanceof d) == false) goto L5;
        d r105 = (d) r104;
    L6:
        if (r105 != null) goto L9;
        Log.w("AnchorEditor", "onInsert: fount no urlStrategy to handle data, link is " + r101.f486304a);
        return;
    L9:
        fob.b r106 = r105.c(this, r101);
        r100.setSpan(r106, r102, r103.length() + r102, 33);
        Object r107 = r106.e();
        if (r107 == null) goto L13;
        r100.setSpan(r107, r102, r103.length() + r102, 33);
        return;
    L13:
        return;
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z(Spannable r100, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        SpannableString r112 = SpannableString.valueOf(r100.subSequence(r110, r111));
        ArrayList r101 = new ArrayList();
        Iterator<fob.c<?, ?>> r102 = this.f473408d.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        fob.c<?, ?> r103 = r102.next();
        if ((r103 instanceof fob.c) == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L10;
        fob.c.a<?> r104 = r103.resolve(r112);
        if (r104.f478191a == false) goto L4;
        D r105 = r104.f478192b;
        if (r105 == 0) goto L4;
        r101.addAll((Collection) r105);
        goto L16
    L10:
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: find invalid url resolver");
    L16:
        Iterator r113 = r101.iterator();
    L18:
        if (r113.hasNext() == false) goto L32;
        f.b r106 = (f.b) r113.next();
        IntRange r107 = r106.f478196b;
        hob.b r108 = (hob.b) r106.f478195a;
        int r109 = r107.getFirst() + r110;
        int r114 = r107.getLast() + r110;
        boolean r115 = com.ss.android.lark.keyboard.edittext2.utils.b.c(r100, r109, r114);
        Object r116 = ((LinkedHashMap) this.f473407c).get(r108.getClass());
        if ((r116 instanceof d) == false) goto L22;
        d r117 = (d) r116;
    L23:
        if (r117 != null) goto L25;
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: find empty anchor strategy");
    L25:
        if (r114 < r109) goto L26;
        if (r115 == true) goto L18;
        if (r117 == null) goto L18;
        fob.b r118 = r117.c(this, r108);
        r100.setSpan(r118, r109, r114, 33);
        Object r119 = r118.e();
        if (r119 == null) goto L18;
        r100.setSpan(r119, r109, r114, 33);
        goto L18
    L26:
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: range.last < range.first, range{" + r109 + ", " + r114 + '}');
        goto L18
    L22:
        r117 = null;
        goto L23
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.b r100, SpannableStringBuilder r101, int r102, int r103) {
        hob.b r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        RichTextElement r105 = RichTextElementCreator.e(r104.f486304a);
        Map<String, String> r106 = r104.f486305b;
        if (r106 != null) goto L5;
        r106 = MapsKt.emptyMap();
    L5:
        r105.setStyle(r106);
        r101.setSpan(new p(r105, r101.subSequence(r102, r103).toString()), r102, r103, 33);
    }
}

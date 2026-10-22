package ty6;

import android.text.TextUtils;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.poi.rate.PoiPopupConfig;
import com.ss.android.ugc.aweme.poi.settings.PoiSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f547968h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PoiPopupConfig> f547969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PoiPopupConfig> f547970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f547971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, JsEventSubscriber> f547972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, e> f547973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f547974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f547975g;

    /* JADX INFO: renamed from: ty6.a$a, reason: collision with other inner class name */
    public static final class C7803a {
    }

    public static final class b implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f547976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiPopupConfig f547977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f547978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f547979d;

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            if (Intrinsics.areEqual(r100.getEventName(), this.f547976a) == false) goto L11;
            EventCenter.unregisterJsEventSubscriber(this.f547976a, this);
            XReadableMap r101 = r100.getParams();
            boolean r102 = false;
            if (r101 == null) goto L7;
            r102 = s.b(r101, "has_popup", false);
        L7:
            this.f547977b.a();
            if (r102 == true) goto L12;
            this.f547978c.a(this.f547979d + 1);
            return;
        L12:
            return;
        }

        public b(String r100, PoiPopupConfig r101, a r102, int r103) {
            this.f547976a = r100;
            this.f547977b = r101;
            this.f547978c = r102;
            this.f547979d = r103;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiPopupConfig f547980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f547981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f547982d;

        @Override // ty6.e
        public final void a(boolean r100) {
            vn6.b.c(this);
            this.f547980b.a();
            if (r100 == true) goto L6;
            a r101 = this.f547981c;
            int r102 = this.f547982d + 1;
            int r103 = a.f547968h;
            r101.a(r102);
            return;
        }

        public c(String r100, PoiPopupConfig r101, a r102, int r103) {
            this.f547980b = r101;
            this.f547981c = r102;
            this.f547982d = r103;
            super(r100);
        }
    }

    public static final class d implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f547983a;

        public d(a r100) {
            this.f547983a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            if (Intrinsics.areEqual(r100.getEventName(), "poi_detail_popup_register") == false) goto L15;
            XReadableMap r101 = r100.getParams();
            if (r101 == null) goto L7;
            String r102 = s.f(r101, "config_name", "");
        L8:
            if (r102 != null) goto L10;
            return;
        L10:
            if (TextUtils.isEmpty(r102) == false) goto L12;
            return;
        L12:
            if (((ArrayList) this.f547983a.f547971c).contains(r102) == true) goto L18;
            ((ArrayList) this.f547983a.f547971c).add(r102);
            return;
        L18:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    static {
    }

    public final void b() {
        EventCenter.unregisterJsEventSubscriber("poi_detail_popup_register", this.f547975g);
        vn6.b.c(this);
        Iterator<T> r100 = this.f547969a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        PoiPopupConfig r101 = (PoiPopupConfig) r100.next();
        if (CollectionsKt.contains(this.f547971c, r101.a()) == false) goto L4;
        ((ArrayList) this.f547970b).add(r101);
        goto L4
    L8:
        a(0);
    }

    public a() {
        PoiSetting r100 = IPoiSetting.a();
        if (r100 == null) goto L5;
        List<PoiPopupConfig> r101 = r100.o();
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this.f547969a = r101;
        this.f547970b = new ArrayList();
        this.f547971c = new ArrayList();
        this.f547972d = new LinkedHashMap();
        this.f547973e = new LinkedHashMap();
        this.f547974f = new LinkedHashMap();
        this.f547975g = new d(this);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void a(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= ((ArrayList) this.f547970b).size()) goto L45;
        PoiPopupConfig r101 = (PoiPopupConfig) ListProtector.get(this.f547970b, r100);
        if (r101.c() != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r101.c()) == false) goto L12;
        return;
    L12:
        if (r101.b() != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r101.b()) == true) goto L47;
        String r102 = r101.c();
        String r103 = "";
        if (r102 != null) goto L19;
        r102 = "";
    L19:
        String r104 = r101.b();
        if (r104 == null) goto L23;
        r103 = r104;
    L23:
        String r105 = r101.getType();
        if (Intrinsics.areEqual(r105, "lynx") == false) goto L31;
        b r106 = new b(r103, r101, this, r100);
        this.f547972d.put(r103, r106);
        EventCenter.registerJsEventSubscriber(r103, r106);
        Objects.toString(this.f547974f);
        long r107 = System.currentTimeMillis();
        JSONObject r108 = new JSONObject();
        Iterator r109 = ((LinkedHashMap) this.f547974f).entrySet().iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        Map.Entry r110 = (Map.Entry) r109.next();
        r108.put((String) r110.getKey(), r110.getValue());
        goto L27
    L29:
        Unit r111 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r102, r107, new ReadableMapImpl(r108)));
        return;
    L31:
        if (Intrinsics.areEqual(r105, "native") == false) goto L44;
        c r112 = new c(r103, r101, this, r100);
        this.f547973e.put(r103, r112);
        vn6.b.b(r112);
        Objects.toString(this.f547974f);
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r114 = ((LinkedHashMap) this.f547974f).entrySet().iterator();
    L34:
        if (r114.hasNext() == false) goto L36;
        Map.Entry r115 = (Map.Entry) r114.next();
        r113.put(r115.getKey(), r115.getValue());
        goto L34
    L36:
        vn6.b.a(new ty6.d(r102, r113));
        return;
    L44:
        return;
    L47:
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(ty6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (TextUtils.isEmpty(r100.f547986a) == true) goto L8;
        List<String> r101 = this.f547971c;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(r100.f547986a) == true) goto L9;
        String r103 = r100.f547986a;
        ((ArrayList) this.f547971c).add(r103);
        return;
    L9:
        return;
    }
}

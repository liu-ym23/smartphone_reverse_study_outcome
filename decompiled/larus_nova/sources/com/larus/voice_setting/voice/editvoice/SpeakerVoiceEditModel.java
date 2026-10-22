package com.larus.voice_setting.voice.editvoice;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.mix.res.VoiceAuditState;
import hq9.d5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class SpeakerVoiceEditModel {
    public static final /* synthetic */ int P = 0;
    public final MutableSharedFlow A;
    public final MutableLiveData<b1> B;
    public final MutableLiveData C;
    public final MutableLiveData<Boolean> D;
    public final MutableLiveData E;
    public final MediatorLiveData<v2a.f> F;
    public final MediatorLiveData<v2a.f> G;
    public SpeakerVoice H;
    public ArrayList<MixVoice> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f376715J;
    public final CopyOnWriteArraySet<String> K;
    public Integer L;
    public boolean M;
    public Job N;
    public String O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f376716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f376717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f376718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f376719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f376720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f376721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f376722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f376723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NonStickyLiveData<SpeakerVoice> f376724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NonStickyLiveData f376725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<MixVoice> f376726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Integer> f376727l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData f376728m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<MixVoice> f376729n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NonStickyLiveData<w2a.b> f376730o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final NonStickyLiveData f376731p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w2a.c f376732q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final NonStickyLiveData<w2a.d> f376733r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final NonStickyLiveData f376734s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final NonStickyLiveData<w2a.a> f376735t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final NonStickyLiveData f376736u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NonStickyLiveData<Boolean> f376737v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final NonStickyLiveData f376738w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MutableLiveData<Integer> f376739x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MutableLiveData f376740y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final MutableSharedFlow<a1> f376741z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f376742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f376743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f376744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f376745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f376746e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f376742a, r101.f376742a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f376743b, r101.f376743b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f376744c, r101.f376744c) == true) goto L18;
            return false;
        L18:
            if (this.f376745d == r101.f376745d) goto L21;
            return false;
        L21:
            if (this.f376746e == r101.f376746e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f376742a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f376743b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f376744c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (((r106 + r101) * 31) + this.f376745d) * 31;
            if (this.f376746e == false) goto L17;
            int r109 = 1231;
        L19:
            return r108 + r109;
        L17:
            r109 = 1237;
            goto L19
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "MixVoiceCompareItem(voiceId=" + this.f376742a + ", styleId=" + this.f376743b + ", languageCode=" + this.f376744c + ", percentage=" + this.f376745d + ", isEnable=" + this.f376746e + ')';
        }

        public b(String r100, String r101, String r102, int r103, boolean r104) {
            this.f376742a = r100;
            this.f376743b = r101;
            this.f376744c = r102;
            this.f376745d = r103;
            this.f376746e = r104;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            String r102 = ((b) r100).f376742a;
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            String r104 = ((b) r101).f376742a;
            if (r104 == null) goto L10;
            r103 = r104;
        L10:
            return ComparisonsKt.compareValues(r102, r103);
        }
    }

    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f376747a;

        public d(c r100) {
            this.f376747a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f376747a.compare(r100, r101);
            if (r102 != 0) goto L14;
            String r103 = ((b) r100).f376743b;
            String r104 = "";
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            String r105 = ((b) r101).f376743b;
            if (r105 == null) goto L13;
            r104 = r105;
        L13:
            return ComparisonsKt.compareValues(r103, r104);
        L14:
            return r102;
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f376748a;

        public e(d r100) {
            this.f376748a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f376748a.compare(r100, r101);
            if (r102 != 0) goto L14;
            String r103 = ((b) r100).f376744c;
            String r104 = "";
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            String r105 = ((b) r101).f376744c;
            if (r105 == null) goto L13;
            r104 = r105;
        L13:
            return ComparisonsKt.compareValues(r103, r104);
        L14:
            return r102;
        }
    }

    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f376749a;

        public f(e r100) {
            this.f376749a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f376749a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r100).f376745d), Integer.valueOf(((b) r101).f376745d));
        }
    }

    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f376750a;

        public g(f r100) {
            this.f376750a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f376750a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Boolean.valueOf(((b) r100).f376746e), Boolean.valueOf(((b) r101).f376746e));
        }
    }

    public static final class h implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f376751a;

        public h(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f376751a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f376751a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f376751a.invoke(r100);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<MixVoice> f() {
        if (this.f376720e == true) goto L5;
        NonStickyLiveData r100 = this.f376725j;
        if (r100 == null) goto L14;
        SpeakerVoice r101 = (SpeakerVoice) r100.getValue();
        if (r101 == null) goto L14;
        return CollectionsKt.listOf(new MixVoice(r101, 0, false, null, 14, null));
    L14:
        return CollectionsKt.emptyList();
    L5:
        return this.f376729n;
    }

    public final w2a.f g() {
        List<MixVoice> r100 = f();
        float r101 = 10;
        float r102 = h() * r101;
        float r103 = k() * r101;
        w2a.c r104 = this.f376732q;
        if (r104 == null) goto L5;
        String r105 = r104.b();
    L6:
        w2a.c r106 = this.f376732q;
        if (r106 == null) goto L9;
        String r107 = r106.c();
    L11:
        return new w2a.f(r100, 0, 0, r102, r103, r105, r107, this.f376715J, this.L, this.O, 6);
    L9:
        r107 = null;
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float h() {
        b1 r100 = (b1) this.C.getValue();
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SpeakerVoice j() {
        if (this.f376720e == false) goto L10;
        if (this.f376729n.size() != 1) goto L10;
        MixVoice r100 = (MixVoice) CollectionsKt.getOrNull(this.f376729n, 0);
        if (r100 != null) goto L14;
    L12:
        return null;
    L14:
        return r100.getVoiceItem();
    L10:
        if (this.f376720e == true) goto L12;
        return (SpeakerVoice) this.f376725j.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float k() {
        b1 r100 = (b1) this.C.getValue();
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.c();
    }

    public final void r() {
        com.larus.utils.t0.e(new l0(this));
    }

    public SpeakerVoiceEditModel(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModelScope");
        this.f376716a = r100;
        this.f376717b = "";
        this.f376718c = "";
        this.f376719d = "";
        NonStickyLiveData<SpeakerVoice> r101 = new NonStickyLiveData(0);
        this.f376724i = r101;
        this.f376725j = r101;
        this.f376726k = new ArrayList();
        MutableLiveData<Integer> r102 = new MutableLiveData();
        this.f376727l = r102;
        this.f376728m = r102;
        this.f376729n = new ArrayList();
        NonStickyLiveData<w2a.b> r103 = new NonStickyLiveData();
        this.f376730o = r103;
        this.f376731p = r103;
        NonStickyLiveData<w2a.d> r104 = new NonStickyLiveData();
        this.f376733r = r104;
        this.f376734s = r104;
        NonStickyLiveData<w2a.a> r105 = new NonStickyLiveData();
        this.f376735t = r105;
        this.f376736u = r105;
        NonStickyLiveData<Boolean> r106 = new NonStickyLiveData();
        this.f376737v = r106;
        this.f376738w = r106;
        MutableLiveData<Integer> r107 = new MutableLiveData(3);
        this.f376739x = r107;
        this.f376740y = r107;
        MutableSharedFlow<a1> r108 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f376741z = r108;
        this.A = r108;
        MutableLiveData<b1> r109 = new MutableLiveData(new b1(0));
        this.B = r109;
        this.C = r109;
        MutableLiveData<Boolean> r110 = new MutableLiveData(null);
        this.D = r110;
        this.E = r110;
        MediatorLiveData<v2a.f> r111 = new MediatorLiveData();
        this.F = r111;
        this.G = r111;
        this.I = new ArrayList();
        this.K = new CopyOnWriteArraySet();
        this.O = "";
        r111.addSource(r103, new h(new s0(this)));
        r111.addSource(r106, new h(new t0(this)));
    }

    public static final Map b(SpeakerVoiceEditModel r100) {
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("current_page", "bot_voice_change");
        r101.put("conversation_id", r100.f376719d);
        r101.put("bot_id", r100.f376718c);
        return r101;
    }

    public static SpeakerVoice i(SpeakerVoice r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getConfStatus() != 2) goto L9;
        FLogger.f375446a.i("SpeakerVoiceEditModel", "getSingleSelectVoice confStatus is invalid so return null");
        return null;
    L9:
        List<MixVoice> r101 = r100.getMixVoiceList();
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        return r100;
    L18:
        List<MixVoice> r103 = r100.getMixVoiceList();
        if (r103 != null) goto L21;
    L28:
        return r100;
    L21:
        if (r103.size() == 1) goto L23;
        r103.size();
        goto L28
    L23:
        if (((MixVoice) ListProtector.get(r103, 0)).isEnable() == true) goto L29;
        FLogger.f375446a.i("SpeakerVoiceEditModel", "getSingleSelectVoice it[0].isEnable false so return null");
        return null;
    L29:
        return ((MixVoice) ListProtector.get(r103, 0)).getVoiceItem();
    L12:
        if (r101.isEmpty() == true) goto L15;
        r102 = false;
        goto L16
    }

    public static List l(List r100) {
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L19;
        MixVoice r104 = (MixVoice) r103.next();
        SpeakerVoice r105 = r104.getVoiceItem();
        if (r105 == null) goto L8;
        String r106 = r105.getId();
    L9:
        SpeakerVoice r107 = r104.getVoiceItem();
        if (r107 == null) goto L12;
        String r108 = r107.getStyleId();
    L13:
        SpeakerVoice r109 = r104.getVoiceItem();
        if (r109 == null) goto L16;
        String r110 = r109.getLanguageCode();
    L17:
        r102.add(new b(r106, r108, r110, r104.getPercentage(), r104.isEnable()));
        goto L4
    L16:
        r110 = null;
        goto L17
    L12:
        r108 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    L19:
        return CollectionsKt.sortedWith(r102, new g(new f(new e(new d(new c())))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r110) {
        v2a.g.f552741a.f();
        ArrayList r100 = new ArrayList(this.f376729n);
        b1 r101 = (b1) this.C.getValue();
        this.f376729n.clear();
        this.f376730o.postValue(new w2a.b("clear", new MixVoice(null, 0, false, null, 15, null), r110, r100, r101, this.f376729n));
        com.larus.utils.t0.e(new q0(this));
        r();
    }

    public final void o(String r110) {
        d5 r100 = z2.f365865a.getVoiceSettingConvenienceConfig();
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.c());
    L6:
        FLogger.f375446a.i("SpeakerVoiceEditModel", "[tryStopCurrentAndPlayNewVoice]: caller = " + r110 + ", enableAutoPlay = " + r101);
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
        Job r102 = this.N;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.N = BuildersKt.launch$default(this.f376716a, null, null, new SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1(this, r110, null), 3, null);
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void p(final boolean r100) {
        if (Intrinsics.areEqual(this.D.getValue(), Boolean.valueOf(r100)) == true) goto L6;
        com.larus.utils.t0.e(new u0(this, r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(SpeakerVoice r210) {
        Intrinsics.checkNotNullParameter("from_tts", "from");
        FLogger.f375446a.i("SpeakerVoiceEditModel", "[updateVoice] current:" + this.f376729n + ", voice:" + r210 + ", from:from_tts");
        if ((!this.f376729n.isEmpty()) == false) goto L21;
        Iterator<MixVoice> r100 = this.f376729n.iterator();
        int r101 = 0;
    L6:
        if (r100.hasNext() == false) goto L15;
        SpeakerVoice r102 = r100.next().getVoiceItem();
        if (r102 == null) goto L10;
        String r103 = r102.getId();
    L12:
        if (Intrinsics.areEqual(r103, r210.getId()) == true) goto L13;
        r101 = r101 + 1;
        goto L6
    L13:
        int r110 = r101;
    L16:
        if (r110 == (-1)) goto L22;
        int r104 = ((MixVoice) ListProtector.get(this.f376729n, r110)).getPercentage();
        ArrayList r111 = new ArrayList(this.f376729n);
        b1 r112 = (b1) this.C.getValue();
        ListProtector.set(this.f376729n, r110, new MixVoice(r210, r104, false, null, 12, null));
        this.f376730o.postValue(new w2a.b("update", new MixVoice(r210, r104, false, null, 12, null), "from_tts", r110, r111, r112, this.f376729n));
        r();
        return;
    L22:
        return;
    L10:
        r103 = null;
        goto L12
    L15:
        r110 = -1;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean n(SpeakerVoice r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "from");
        if (r110 != null) goto L5;
        return false;
    L5:
        FLogger.f375446a.i("SpeakerVoiceEditModel", "[removeVoice] current:" + this.f376729n + ", voice:" + r110 + ", from:" + r111 + "  voiceSelectedMixMode:" + this.f376720e);
        if (this.f376720e == true) goto L8;
        SpeakerVoice r100 = (SpeakerVoice) this.f376725j.getValue();
        if (r100 == null) goto L30;
        String r101 = r100.getId();
    L32:
        if (Intrinsics.areEqual(r101, r110.getId()) == false) goto L34;
        q(null, false);
    L34:
        return false;
    L30:
        r101 = null;
        goto L32
    L8:
        if ((!this.f376729n.isEmpty()) == false) goto L34;
        Iterator<MixVoice> r102 = this.f376729n.iterator();
        int r103 = 0;
    L11:
        if (r102.hasNext() == false) goto L20;
        SpeakerVoice r104 = r102.next().getVoiceItem();
        if (r104 == null) goto L15;
        String r105 = r104.getId();
    L17:
        if (Intrinsics.areEqual(r105, r110.getId()) == true) goto L18;
        r103 = r103 + 1;
        goto L11
    L18:
        int r112 = r103;
    L21:
        if (r112 == (-1)) goto L34;
        v2a.g.f552741a.f();
        ArrayList r113 = new ArrayList(this.f376729n);
        b1 r114 = (b1) this.C.getValue();
        ListProtector.remove(this.f376729n, r112);
        this.f376730o.postValue(new w2a.b("remove", new MixVoice(r110, 0, false, null, 14, null), r111, r112, r113, r114, this.f376729n));
        if (this.f376729n.isEmpty() == false) goto L25;
        com.larus.utils.t0.e(new q0(this));
    L25:
        r();
        return true;
    L15:
        r105 = null;
        goto L17
    L20:
        r112 = -1;
        goto L21
    }

    public final void q(SpeakerVoice r100, boolean r110) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getId();
    L7:
        if (Intrinsics.areEqual(r102, "0") == true) goto L15;
        if (r100 == null) goto L10;
        String r103 = r100.getId();
    L12:
        if (Intrinsics.areEqual(r103, "none") == true) goto L15;
        SpeakerVoice r104 = r100;
    L16:
        this.f376724i.postValue(r104);
        if (r110 == false) goto L46;
        com.larus.utils.t0.e(new q0(this));
        if (r104 == null) goto L23;
        AudioPreview r111 = r104.getPreview();
        if (r111 == null) goto L23;
        String r112 = r111.getPreviewAudio();
    L25:
        if (com.larus.utils.o0.d(r112) == true) goto L27;
        return;
    L27:
        if (r104 == null) goto L29;
        String r105 = r104.getStyleId();
    L30:
        if (r104 == null) goto L34;
        AudioPreview r106 = r104.getPreview();
        if (r106 == null) goto L34;
        String r107 = r106.getPreviewText();
    L35:
        if (r104 == null) goto L39;
        AudioPreview r108 = r104.getPreview();
        if (r108 == null) goto L39;
        String r109 = r108.getPreviewAudio();
    L40:
        if (r104 == null) goto L44;
        AudioPreview r113 = r104.getPreview();
        if (r113 == null) goto L44;
        r101 = r113.getMd5();
    L44:
        w2a.c r114 = new w2a.c(r105, r107, r109, r101, 16);
        this.f376732q = r114;
        m(true, r100, r114);
        return;
    L39:
        r109 = null;
    L34:
        r107 = null;
        goto L35
    L29:
        r105 = null;
    L23:
        r112 = null;
        goto L25
    L46:
        return;
    L10:
        r103 = null;
    L15:
        r104 = null;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public static final Object a(SpeakerVoiceEditModel r110, List r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof SpeakerVoiceEditModel$generatePreviewVoice$1) == false) goto L7;
        SpeakerVoiceEditModel$generatePreviewVoice$1 r100 = (SpeakerVoiceEditModel$generatePreviewVoice$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SpeakerVoiceEditModel$generatePreviewVoice$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L43:
        w2a.c r107 = (w2a.c) r103;
        if (r107 == null) goto L47;
        r107.e(true);
    L49:
        return r107;
    L47:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r111.isEmpty() == true) goto L47;
        if (Intrinsics.areEqual(l(r110.f376726k), l(r111)) == false) goto L22;
        r107 = r110.f376732q;
        if (r107 != null) goto L49;
    L22:
        ((ArrayList) r110.f376726k).clear();
        Iterator r108 = r111.iterator();
    L24:
        if (r108.hasNext() == false) goto L27;
        MixVoice r109 = (MixVoice) r108.next();
        ((ArrayList) r110.f376726k).add(MixVoice.copy$default(r109, null, 0, false, null, 15, null));
        goto L24
    L27:
        if (r111.size() != 1) goto L40;
        SpeakerVoice r113 = ((MixVoice) ListProtector.get(r111, 0)).getVoiceItem();
        if (r113 == null) goto L47;
        String r114 = r113.getStyleId();
        AudioPreview r115 = r113.getPreview();
        if (r115 == null) goto L34;
        r106 = r115.getPreviewAudio();
    L34:
        String r116 = r106;
        AudioPreview r117 = r113.getPreview();
        if (r117 == null) goto L38;
        String r118 = r117.getMd5();
        if (r118 == null) goto L38;
    L39:
        w2a.c r119 = new w2a.c(r114, null, r116, r118, 18);
        r119.e(false);
        return r119;
    L38:
        r118 = "";
        goto L39
    L40:
        ArrayList r120 = new ArrayList();
        r120.addAll(r111);
        float r121 = 10;
        float r122 = r110.h() * r121;
        float r123 = r121 * r110.k();
        String r124 = r110.f376717b;
        r102.label = 1;
        r103 = r110.d(r120, r122, r123, r124, r102);
        if (r103 != r104) goto L43;
        return r104;
    L7:
        r100 = new SpeakerVoiceEditModel$generatePreviewVoice$1(r110, r112);
        goto L8
    }

    public final void m(final boolean r110, final SpeakerVoice r111, w2a.c r112) {
        p2a.q.a().stopAudio();
        p68.e r100 = new SpeakerVoiceEditModel$playVoice$playListener$1(this, r111, r110);
        boolean r101 = true;
        if (r110 == true) goto L5;
    L31:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("playVoice play ugc voice, voiceId = ");
        if (r111 == null) goto L34;
        String r104 = r111.getId();
    L35:
        r103.append(r104);
        r103.append(", pitchF64 = ");
        r103.append(h());
        r103.append(", speechRateF64 = ");
        r103.append(k());
        r102.i("SpeakerVoiceEditModel", r103.toString());
        com.larus.audio.s0 r105 = p2a.q.a();
        String r106 = r112.b();
        String r107 = r112.c();
        String r113 = r112.a();
        float r108 = h();
        float r109 = k();
        String r114 = this.f376718c;
        if (r114.length() == 0) goto L39;
        r101 = false;
    L39:
        if (r101 == false) goto L41;
        r114 = "0";
    L41:
        r105.k(r106, r107, r113, r108, r109, r114, r100);
        if (this.f376720e == false) goto L51;
        if (r110 == true) goto L46;
        r111 = null;
    L46:
        t(r111, "from_play_button", 0);
        return;
    L51:
        return;
    L34:
        r104 = null;
        goto L35
    L5:
        if (h() != 0.0f) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == false) goto L31;
        if (k() != 1.0f) goto L12;
        boolean r116 = true;
    L13:
        if (r116 == false) goto L31;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("playVoice play origin voice, voiceId = ");
        if (r111 == null) goto L17;
        String r119 = r111.getId();
    L18:
        r118.append(r119);
        r117.i("SpeakerVoiceEditModel", r118.toString());
        if (r111 == null) goto L48;
        com.larus.audio.s0 r120 = p2a.q.a();
        String r121 = r111.getStyleId();
        AudioPreview r122 = r111.getPreview();
        if (r122 == null) goto L23;
        String r123 = r122.getPreviewAudio();
    L24:
        AudioPreview r124 = r111.getPreview();
        if (r124 == null) goto L27;
        String r125 = r124.getMd5();
    L28:
        r120.l(r121, r123, r125, r100, r111.getId(), r111.getName());
        if (this.f376720e == false) goto L49;
        t(r111, "from_play_button", 0);
        return;
    L49:
        return;
    L27:
        r125 = null;
        goto L28
    L23:
        r123 = null;
        goto L24
    L48:
        return;
    L17:
        r119 = null;
        goto L18
    L12:
        r116 = false;
        goto L13
    L7:
        r115 = false;
        goto L8
    }

    public final void t(SpeakerVoice r100, String r101, @VoiceAuditState int r102) {
        Intrinsics.checkNotNullParameter(r101, "from");
        this.f376733r.postValue(new w2a.d(r100, r101, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(SpeakerVoice r110, String r111, boolean r112, int r210) {
        Intrinsics.checkNotNullParameter("from_tts", "from");
        boolean r113 = false;
        if (r110 != null) goto L5;
        return false;
    L5:
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[addVoice] current:");
        MixVoice r102 = (MixVoice) CollectionsKt.firstOrNull(this.f376729n);
        if (r102 == null) goto L10;
        SpeakerVoice r103 = r102.getVoiceItem();
        if (r103 == null) goto L10;
        String r104 = r103.getId();
    L11:
        r101.append(r104);
        r101.append(", voice:");
        r101.append(r110);
        r101.append(", from:from_tts");
        r100.i("SpeakerVoiceEditModel", r101.toString());
        ArrayList r114 = new ArrayList(this.f376729n);
        b1 r115 = (b1) this.C.getValue();
        if (r112 == false) goto L15;
        this.f376729n.clear();
    L15:
        if (this.f376729n.size() >= 3) goto L49;
        Iterator<MixVoice> r105 = this.f376729n.iterator();
        int r106 = 0;
    L18:
        if (r105.hasNext() == false) goto L27;
        SpeakerVoice r107 = r105.next().getVoiceItem();
        if (r107 == null) goto L22;
        String r108 = r107.getId();
    L24:
        if (Intrinsics.areEqual(r108, r110.getId()) == true) goto L28;
        r106 = r106 + 1;
    L28:
        if (r106 == (-1)) goto L30;
        return false;
    L30:
        v2a.g.f552741a.f();
        MixVoice r116 = new MixVoice(r110, 100, false, r111, 4, null);
        this.f376729n.add(r116);
        if (r112 == false) goto L33;
        BuildersKt.launch$default(this.f376716a, null, null, new SpeakerVoiceEditModel$addVoice$1(this, null), 3, null);
    L33:
        NonStickyLiveData<w2a.b> r117 = this.f376730o;
        if (r112 == false) goto L36;
        String r109 = BasicTestActionHandler.TEST_ACTION_RESET;
    L37:
        r117.postValue(new w2a.b(r109, r116, "from_tts", r114, r115, this.f376729n));
        r();
        this.f376715J = r111;
        String r118 = r110.getId();
        if (r118 == null) goto L45;
        Integer r119 = Integer.valueOf(r210);
        Intrinsics.checkNotNullParameter(r118, "voiceId");
        if (r118.length() <= 0) goto L42;
        r113 = true;
    L42:
        if (r113 == false) goto L44;
        this.K.add(r118);
    L44:
        this.L = r119;
    L45:
        return true;
    L36:
        r109 = "add";
        goto L37
    L22:
        r108 = null;
        goto L24
    L27:
        r106 = -1;
        goto L28
    L49:
        return false;
    L10:
        r104 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(final List<MixVoice> r210, final float r211, final float r212, final String r213, Continuation<? super w2a.c> r214) {
        if ((r214 instanceof SpeakerVoiceEditModel$createPreviewVoice$1) == false) goto L7;
        SpeakerVoiceEditModel$createPreviewVoice$1 r100 = (SpeakerVoiceEditModel$createPreviewVoice$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        float r104 = r100.F$1;
        float r105 = r100.F$0;
        String r106 = (String) r100.L$1;
        List<MixVoice> r107 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        final float r108 = r104;
        final float r109 = r105;
        final String r111 = r106;
        final List<MixVoice> r112 = r107;
    L36:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r102;
        if ((r113 instanceof com.larus.network.http.y) == false) goto L40;
        f2a.c r114 = com.larus.voice_setting.voice.utils.k.f377041a.b("request conf_preview_create success");
        r114.e(new n0(r109, r108, r111, r112));
        r114.f475230c.f475254b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r114, null, 15);
        return (w2a.c) ((com.larus.network.http.y) r113).f360135b;
    L40:
        if ((r113 instanceof com.larus.network.http.f) == false) goto L42;
        com.larus.network.http.f r115 = (com.larus.network.http.f) r113;
    L43:
        if (r115 == null) goto L45;
        f2a.c r116 = com.larus.voice_setting.voice.utils.k.f377041a.a("request conf_preview_create failed");
        final com.larus.network.http.f r117 = r115;
        r116.e(new o0(r109, r108, r111, r112, r117));
        r116.f475230c.f475254b = CollectionsKt.listOf("VoicePlay");
        Object r118 = null;
        f2a.c.c(r116, null, 15);
        FLogger.f375446a.e("SpeakerVoiceEditModel", "createPreviewVoice failed", r115.f360157d);
    L47:
        return r118;
    L45:
        r118 = null;
        goto L47
    L42:
        r115 = null;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        f2a.c r119 = com.larus.voice_setting.voice.utils.k.f377041a.b("request conf_preview_create");
        r119.e(new m0(r211, r212, r213, r210));
        r119.f475230c.f475254b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r119, null, 15);
        JSONObject r120 = new JSONObject();
        r120.put("pitch_f64", Boxing.boxFloat(r211));
        r120.put("speech_rate_f64", Boxing.boxFloat(r212));
        r120.put("bot_language", r213);
        JSONArray r121 = new JSONArray();
        if (r210 == null) goto L32;
        Iterator<T> r122 = r210.iterator();
    L18:
        if (r122.hasNext() == false) goto L32;
        MixVoice r123 = (MixVoice) r122.next();
        JSONObject r124 = new JSONObject();
        SpeakerVoice r125 = r123.getVoiceItem();
        if (r125 == null) goto L25;
        String r126 = r125.getId();
        if (r126 == null) goto L25;
        String r127 = r126;
    L26:
        r124.put("voice_id", r127);
        SpeakerVoice r128 = r123.getVoiceItem();
        if (r128 == null) goto L30;
        String r129 = r128.getStyleId();
        if (r129 == null) goto L30;
    L31:
        r124.put("style_id", r129);
        r124.put(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, r123.getPercentage());
        r121.put(r124);
    L30:
        r129 = "";
    L25:
        r127 = "";
    L32:
        r120.put("voice_list", r121);
        Unit r130 = Unit.INSTANCE;
        r100.L$0 = r210;
        r100.L$1 = r213;
        r100.F$0 = r211;
        r100.F$1 = r212;
        r100.label = 1;
        Object r131 = HttpExtKt.k(ServiceType.UGC, w2a.c.class, "/alice/audio/conf_preview_create", r120, null, null, false, null, null, null, r100, 1008);
        if (r131 != r110) goto L35;
        return r110;
    L35:
        r112 = r210;
        r109 = r211;
        r108 = r212;
        r111 = r213;
        r102 = r131;
    L7:
        r100 = new SpeakerVoiceEditModel$createPreviewVoice$1(this, r214);
        goto L8
    }
}

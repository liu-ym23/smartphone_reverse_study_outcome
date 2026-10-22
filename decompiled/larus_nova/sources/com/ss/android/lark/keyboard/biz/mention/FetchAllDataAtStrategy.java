package com.ss.android.lark.keyboard.biz.mention;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FetchAllDataAtStrategy implements com.ss.android.lark.keyboard.edittext2.edittors.at.c<g>, dob.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f428386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<g> f428387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext2.base.b f428388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>> f428389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> f428390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<hob.c, List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> f428391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, ? extends ChatChatter> f428392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Boolean> f428393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f428394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f428395j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FetchAllDataAtStrategy f428396a;

        public b(FetchAllDataAtStrategy r100) {
            this.f428396a = r100;
        }

        public final void a(hob.c r100, com.ss.android.lark.keyboard.edittext2.edittors.at.b r101) {
            g r102 = (g) r100;
            Intrinsics.checkNotNullParameter(r102, "data");
            Intrinsics.checkNotNullParameter(r101, "result");
            String r103 = r102.f486308a;
            List r104 = (List) ((LinkedHashMap) this.f428396a.f428389d).get(r103);
            if (r104 == null) goto L6;
            r104.add(r101);
            return;
        L6:
            if (this.f428396a.f428389d.size() < 100) goto L8;
            Log.w("FetchAllDataAtStrategy", "not load chatter, exceeded the limit, chatterId = " + r103);
            return;
        L8:
            ArrayList r105 = new ArrayList();
            r105.add(r101);
            this.f428396a.f428389d.put(r103, r105);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r100 = this.f428388c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public Class<g> getType() {
        return this.f428387b;
    }

    public FetchAllDataAtStrategy(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatIdProvider");
        this.f428386a = r100;
        this.f428387b = g.class;
        this.f428389d = new LinkedHashMap();
        this.f428390e = FetchAllDataAtStrategy$notifyFailedAction$1.INSTANCE;
        this.f428391f = FetchAllDataAtStrategy$notifySuccessAction$1.INSTANCE;
        this.f428394i = "";
        this.f428395j = new b(this);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428388c = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    }

    @Override // dob.d
    public final void a(RichText r100) {
        com.ss.android.lark.keyboard.edittext2.base.b r101 = getTarget();
        if ((r101 instanceof FlowKeyboardFunctionEditText) == false) goto L5;
        FlowKeyboardFunctionEditText r102 = (FlowKeyboardFunctionEditText) r101;
    L6:
        if (r102 == null) goto L9;
        final String r103 = r102.getCurChatId();
        if (r103 == null) goto L9;
    L11:
        if (r103.length() != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        Log.e("FetchAllDataAtStrategy", "loaded return, chat id is empty");
        return;
    L17:
        final List r105 = CollectionsKt.toList(((LinkedHashMap) this.f428389d).keySet());
        if (r105.size() != 0) goto L20;
        return;
    L20:
        AtomicInteger r106 = new AtomicInteger(2);
        com.larksuite.rucket.job.compat.f.a(new FetchAllDataAtStrategy$onRenderFinished$1(r103, r105)).then(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$2(this, r103, r106, null)).error(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$3(r103, this, r106, null));
        com.larksuite.rucket.job.compat.f.a(new FetchAllDataAtStrategy$onRenderFinished$4(r105, r103)).then(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$5(this, r103, r106, null)).error(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$6(r103, this, r106, null));
        return;
    L13:
        r104 = false;
    L9:
        r103 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // dob.d
    public final void b(RichText r100) {
        ((LinkedHashMap) this.f428389d).clear();
        this.f428392g = null;
        this.f428393h = null;
        if (r100 == null) goto L8;
        RichTextExtraInfo r101 = r100.getExtraInfo();
        if (r101 == null) goto L8;
        String r102 = r101.getCurChatId();
        if (r102 == null) goto L8;
    L9:
        this.f428394i = r102;
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a c(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        g r102 = (g) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "data");
        return new h(this.f428395j, r100, r102);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final fob.c.a<g> k(com.ss.android.lark.keyboard.edittext2.edittors.a r100, RichTextElement.AtProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r102 = this.f428386a.invoke();
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L28;
        if (Intrinsics.areEqual(r102, this.f428394i) == true) goto L10;
    L20:
        String r104 = r101.getAtContent();
        if (r104 == null) goto L24;
        String r105 = r104.substring(1);
        if (r105 == null) goto L24;
    L26:
        return new fob.c.a(true, new g(r101.getUserId(), r105, r101.isAnonymous(), r101.isOutChatUser()));
    L24:
        r105 = "";
        goto L26
    L10:
        if (r102.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L20;
        if (this.f428394i.length() <= 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
    L17:
        r107 = false;
        goto L18
    L12:
        r106 = false;
    L28:
        return new fob.c.a(false, null);
    L5:
        r103 = false;
        goto L6
    }

    public static final void e(FetchAllDataAtStrategy r110, String r111, AtomicInteger r112) {
        r110.getClass();
        if (r112.decrementAndGet() > 0) goto L69;
        Map<String, ? extends ChatChatter> r113 = r110.f428392g;
        boolean r100 = false;
        if (r113 != null) goto L8;
    L11:
        boolean r114 = true;
    L13:
        if (r114 == true) goto L40;
        Map<String, Boolean> r115 = r110.f428393h;
        if (r115 != null) goto L17;
    L20:
        boolean r116 = true;
    L21:
        if (r116 == true) goto L40;
        ChatterNameDisplayRule r117 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Iterator r101 = ((LinkedHashMap) r110.f428389d).entrySet().iterator();
    L25:
        if (r101.hasNext() == false) goto L39;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>> r104 = (List) r102.getValue();
        Map<String, ? extends ChatChatter> r105 = r110.f428392g;
        Boolean r106 = null;
        if (r105 == null) goto L29;
        ChatChatter r107 = r105.get(r103);
    L31:
        if (r107 == null) goto L32;
        Map<String, Boolean> r108 = r110.f428393h;
        if (r108 == null) goto L36;
        r106 = r108.get(r103);
    L36:
        if (r106 == null) goto L37;
        String r109 = com.ss.android.lark.chat.utils.m.b(r107, r117, true);
        String r118 = r107.getLocalizedName();
        Intrinsics.checkNotNull(r109);
        hob.c r119 = new hob.c(r103, r109, r118, !r106.booleanValue(), r107.isAnonymous());
        String r120 = f.f428425a;
        f.a(r119, r103);
        r110.f428391f.invoke(r119, r104);
        goto L25
    L37:
        r110.f428390e.invoke(r104);
        Log.e("FetchAllDataAtStrategy", "parse failed, isInChat is null, chatId = " + r111 + ", chatterId = " + r103);
        goto L25
    L32:
        r110.f428390e.invoke(r104);
        Log.e("FetchAllDataAtStrategy", "parse failed, chatter is null, chatId = " + r111 + ", chatterId = " + r103);
        goto L25
    L29:
        r107 = null;
        goto L31
    L39:
        ((LinkedHashMap) r110.f428389d).clear();
        return;
    L17:
        if (r115.isEmpty() == true) goto L20;
        r116 = false;
    L40:
        StringBuilder r121 = new StringBuilder("onRequestSuccess, chat id = ");
        r121.append(r111);
        r121.append(", chatters is empty = ");
        Map<String, ? extends ChatChatter> r122 = r110.f428392g;
        if (r122 != null) goto L43;
    L46:
        boolean r123 = true;
    L47:
        r121.append(r123);
        r121.append(", inChats is null ");
        Map<String, Boolean> r124 = r110.f428393h;
        if (r124 != null) goto L50;
    L51:
        r100 = true;
    L52:
        r121.append(r100);
        Log.i("FetchAllDataAtStrategy", r121.toString());
        Iterator r125 = ((LinkedHashMap) r110.f428389d).entrySet().iterator();
    L54:
        if (r125.hasNext() == false) goto L56;
        r110.f428390e.invoke((List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>) ((Map.Entry) r125.next()).getValue());
        goto L54
    L56:
        ((LinkedHashMap) r110.f428389d).clear();
        return;
    L50:
        if (r124.isEmpty() == false) goto L52;
    L43:
        if (r122.isEmpty() == true) goto L46;
        r123 = false;
        goto L47
    L8:
        if (r113.isEmpty() == true) goto L11;
        r114 = false;
        goto L13
    }
}

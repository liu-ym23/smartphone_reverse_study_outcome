package com.ss.android.lark.keyboard.biz.mention;

import com.facebook.keyframes.model.KFAnimation;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class IMCommonAtStrategy extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f428402i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f428403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f428404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AndroidThrottle<String> f428405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>> f428406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>, Unit> f428407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<Pair<String, String>, List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>>, Unit> f428408h;

    public static final class a {
    }

    public static final class b implements AndroidThrottle.d<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f428409a;

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final Collection<String> a() {
            ArrayList r100 = new ArrayList(this.f428409a);
            this.f428409a.clear();
            return r100;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void clear() {
            this.f428409a.clear();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final int size() {
            return this.f428409a.size();
        }

        public b() {
            this.f428409a = new LinkedHashSet();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void put(String r100) {
            String r101 = r100;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L13;
            this.f428409a.add(r101);
            return;
        L13:
            return;
        L5:
            if (r101.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMCommonAtStrategy f428410a;

        public c(IMCommonAtStrategy r100) {
            this.f428410a = r100;
        }

        public final void a(hob.c r100, com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>> r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "result");
            String r102 = r100.f486308a;
            LinkedHashMap r103 = (LinkedHashMap) this.f428410a.f428406f;
            Object r104 = r103.get(r102);
            if (r104 != null) goto L5;
            r104 = new ArrayList();
            r103.put(r102, r104);
        L5:
            ((List) r104).add(r101);
            IMCommonAtStrategy r105 = this.f428410a;
            if (r105.f428405e != null) goto L8;
            AndroidThrottle.a r106 = new AndroidThrottle.a();
            r106.f285878b = 200;
            r106.f285877a = CoreThreadPool.getNonblockingHandler();
            r106.f285880d = new b();
            r106.f285881e = new m(r105);
            r105.f428405e = r106.a();
        L8:
            AndroidThrottle<String> r107 = r105.f428405e;
            if (r107 == null) goto L12;
            r107.d(r102);
            return;
        }
    }

    static {
    }

    public IMCommonAtStrategy(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatIdProvider");
        this.f428403c = r100;
        this.f428404d = new c(this);
        this.f428406f = new LinkedHashMap();
        this.f428407g = IMCommonAtStrategy$notifyFailedAction$1.INSTANCE;
        this.f428408h = IMCommonAtStrategy$notifySuccessAction$1.INSTANCE;
    }

    public final void a(List<String> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = (String) r101.next();
        List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<String, String>>> r103 = this.f428406f.remove(r102);
        this.f428407g.invoke(r103);
        if (r103 == null) goto L4;
        r103.clear();
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(com.ss.android.lark.keyboard.edittext2.edittors.a r100, hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        String r102 = f.f428425a;
        f.a(r101, r101.f486308a);
        return new IMCommonAtSpanHolder(this.f428404d, r100, r101);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final fob.c.a<hob.c> k(com.ss.android.lark.keyboard.edittext2.edittors.a r100, RichTextElement.AtProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        fob.c.a<hob.c> r102 = super.k(r100, r101);
        hob.c r103 = r102.f478192b;
        if (r103 == null) goto L5;
        String r104 = f.f428425a;
        f.a(r103, r101.getUserId());
    L5:
        return r102;
    }
}

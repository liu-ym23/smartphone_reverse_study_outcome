package com.bytedance.ee.bear.lark.header;

import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.bytedance.ee.bear.lark.DocTabFragment;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements h {
    public final Map a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lark.header.a$a, reason: collision with other inner class name */
    public class C0198a implements yc5.b.a {
        public final /* synthetic */ DocTabFragment a;

        public final String getModule() {
            return "home";
        }

        public final String m6() {
            return this.a.m6();
        }

        public C0198a(DocTabFragment r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.lark.header.h
    public final Map<i, Integer> getHeaders() {
        return this.a;
    }

    public a(DocTabFragment r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        r0.put(new m(false), 0);
        r0.put(new l(new C0198a(r6)), 1);
        r0.put(new t(false, BannerScene.COMMON, "space"), 2);
        r0.put(new k(r6.getChildFragmentManager()), 3);
        r0.put(new c(), 4);
        r0.put(new p(), 5);
    }
}

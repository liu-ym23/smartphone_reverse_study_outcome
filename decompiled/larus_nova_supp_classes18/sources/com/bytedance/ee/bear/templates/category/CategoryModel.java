package com.bytedance.ee.bear.templates.category;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.scene.TopicData;
import com.bytedance.ee.bear.templates.scene.TopicDataResult;
import com.bytedance.ee.bear.templates.scene.c;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CategoryModel implements c {
    public final long a;
    public final Bundle b;
    public final int c;
    public final Function0<Boolean> d;
    public final Lazy e;
    public TopicData f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.category.CategoryModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m545invoke() {
            return invoke();
        }

        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ CategoryModel a;

        public b(CategoryModel r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            TemplateGroupTab r8 = (TemplateGroupTab) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            TopicDataResult r0 = new TopicDataResult();
            SelectTemplateConfig r2 = null;
            ((Result) r0).data = new TopicData(null, false, 3, null);
            if ((!r8.getCategoryTabList().isEmpty()) == true) goto L5;
        L7:
            ((TopicData) ((Result) r0).data).setTemplates(new ArrayList());
        L8:
            Bundle r1 = this.a.b;
            if (r1 == null) goto L11;
            r2 = (SelectTemplateConfig) r1.getParcelable("key_template_select_template_config");
        L11:
            ArrayList<TemplateV4> r3 = ((TopicData) ((Result) r0).data).getTemplates();
            if (r3 == null) goto L21;
            Iterator<T> r4 = r3.iterator();
        L15:
            if (r4.hasNext() == false) goto L21;
            TemplateV4 r5 = (TemplateV4) r4.next();
            if (r2 == null) goto L19;
            int r6 = r2.e;
        L20:
            r5.setBottomLabelType(r6);
            goto L15
        L19:
            r6 = -1;
        L21:
            ((TopicData) ((Result) r0).data).setHasMore(r8.getHasMore());
            this.a.f = (TopicData) ((Result) r0).data;
            return r0;
        L5:
            if ((!((CategoryTab) ListProtector.get(r8.getCategoryTabList(), 0)).getCategoryList().isEmpty()) == false) goto L7;
            ((TopicData) ((Result) r0).data).setTemplates(new ArrayList(((ao5.a) ListProtector.get(((CategoryTab) ListProtector.get(r8.getCategoryTabList(), 0)).getCategoryList(), 0)).c));
            goto L8
        }
    }

    static {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.scene.c
    public final void b4(TemplateV4 r11) {
        Intrinsics.checkNotNullParameter(r11, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateUtils r0 = TemplateUtils.a;
        ao5.a[] r1 = new ao5.a[1];
        TopicData r2 = this.f;
        if (r2 == null) goto L7;
        ArrayList<TemplateV4> r3 = r2.getTemplates();
        if (r3 == null) goto L7;
    L8:
        r1[0] = new ao5.a(null, false, r3, 0, 123);
        ArrayList r4 = CollectionsKt.arrayListOf(r1);
        Bundle r5 = this.b;
        Function0<Boolean> r6 = this.d;
        r0.getClass();
        TemplateUtils.j(r11, r4, r5, r6);
        return;
    L7:
        r3 = new ArrayList();
        goto L8
    }

    @Override // com.bytedance.ee.bear.templates.scene.c
    public final Flowable<TopicDataResult> v0(String r9) {
        Intrinsics.checkNotNullParameter(r9, "categoryId");
        com.bytedance.ee.bear.templates.center.list.system.c r7 = new com.bytedance.ee.bear.templates.center.list.system.c(2, "", false, this.a);
        NetService.d r1 = ((NetService) this.e.getValue()).Vc(r7);
        Intrinsics.checkNotNullParameter(r9, "categoryId");
        NetService.f r0 = new NetService.f("space/api/platform/template/category/template_list");
        r0.b("template_collection", "1");
        r0.b("platform", "mobile");
        r0.b("version", "4");
        r0.b("ecology", "true");
        r0.b("docx_template", "1");
        r0.b("category_id", r9);
        r0.b("page_number", "1");
        r0.b("page_size", String.valueOf(this.c));
        return r1.a(r0).map(new b(this));
    }

    public CategoryModel(long r2, Bundle r4, int r5, Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "canNavigate");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = LazyKt.lazy(CategoryModel$netService$2.INSTANCE);
    }
}

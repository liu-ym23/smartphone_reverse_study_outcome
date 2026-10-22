package io1;

import com.bytedance.android.live.core.tetris.componentx.component.ComponentCenter;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.InteractionMonitorConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.LiveInteractionFrameworkOptHelper;
import j70.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C6335b f495178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f495179b;

    public static final class a implements com.bytedance.android.live.core.tetris.componentx.component.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Long> f495180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Long> f495181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InteractionMonitorConfig f495182c;

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void a(Element r100) {
            Intrinsics.checkNotNullParameter(r100, "element");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void b(Element r100) {
            Intrinsics.checkNotNullParameter(r100, "element");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void c(f r100) {
            Intrinsics.checkNotNullParameter(r100, "elementType");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void d(Element r100, d70.a r101) {
            Intrinsics.checkNotNullParameter(r100, "element");
            Intrinsics.checkNotNullParameter(r101, "component");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void f(LayerDescriptorList r100) {
            Intrinsics.checkNotNullParameter(r100, "descriptors");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void h(Element r100, d70.a r101) {
            Intrinsics.checkNotNullParameter(r100, "element");
            Intrinsics.checkNotNullParameter(r101, "component");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void i(d70.a<h70.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void j(ComponentCenter r100) {
            Intrinsics.checkNotNullParameter(r100, "componentCenter");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void k(d70.a<h70.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void onDestroy() {
        }

        public a(InteractionMonitorConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f495182c = r100;
            this.f495180a = new LinkedHashMap();
            this.f495181b = new LinkedHashMap();
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void e(d70.a<h70.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
            f r101 = r100.getElementType();
            if (r101 != null) goto L5;
            return;
        L5:
            List<String> r102 = this.f495182c.getReportElementTypeList();
            if (r102 != null) goto L8;
            return;
        L8:
            if (r102.contains(r101.f497559b) != true) goto L17;
            Map<String, Long> r103 = this.f495180a;
            LinkedHashMap r104 = (LinkedHashMap) r103;
            Long r105 = (Long) r104.get(r101.f497559b);
            if (r105 == null) goto L13;
            long r106 = r105.longValue();
            long r107 = System.currentTimeMillis() - r106;
        L14:
            this.f495181b.put(r101.f497559b, Long.valueOf(r107));
            return;
        L13:
            r107 = -1;
            goto L14
        }

        @Override // com.bytedance.android.live.core.tetris.componentx.component.c
        public final void g(d70.a<h70.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
            f r101 = r100.getElementType();
            if (r101 != null) goto L5;
            return;
        L5:
            List<String> r102 = this.f495182c.getReportElementTypeList();
            if (r102 != null) goto L8;
            return;
        L8:
            if (r102.contains(r101.f497559b) != true) goto L13;
            this.f495180a.put(r101.f497559b, Long.valueOf(System.currentTimeMillis()));
            return;
        }
    }

    /* JADX INFO: renamed from: io1.b$b, reason: collision with other inner class name */
    public static final class C6335b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f495183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f495184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Long> f495185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Long> f495186d;

        /* JADX INFO: renamed from: io1.b$b$a */
        public static final class a {
        }

        static {
        }

        public C6335b() {
            this.f495185c = new LinkedHashMap();
            this.f495186d = new LinkedHashMap();
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "process");
            Map<String, Long> r101 = this.f495186d;
            Long r102 = (Long) ((LinkedHashMap) this.f495185c).get(r100);
            if (r102 == null) goto L5;
            long r103 = r102.longValue();
            long r104 = System.currentTimeMillis() - r103;
        L6:
            r101.put(r100, Long.valueOf(r104));
            return;
        L5:
            r104 = -1;
            goto L6
        }
    }

    public b() {
        InteractionMonitorConfig r100 = LiveInteractionFrameworkOptHelper.INSTANCE.monitorConfig();
        a r101 = null;
        if (r100.getEnableReportProcessCost() == false) goto L5;
        C6335b r102 = new C6335b();
    L6:
        this.f495178a = r102;
        if (r100.getEnableReportWidgetCost() == false) goto L9;
        r101 = new a(r100);
    L9:
        this.f495179b = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }
}

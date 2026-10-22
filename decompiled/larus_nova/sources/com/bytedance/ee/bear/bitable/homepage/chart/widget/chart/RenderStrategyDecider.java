package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.BaseChartEntity;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class RenderStrategyDecider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ks4.b f212687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f212688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f212689c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", "", "isFullUpdate", "", "<init>", "(Ljava/lang/String;IZ)V", "()Z", "RELOAD", "RENDER", "PLAYGROUND_RENDER", "UPDATE_DATA", "SKIP", "WAIT_NEXT", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RenderStrategy extends Enum<RenderStrategy> {
        public static final RenderStrategy PLAYGROUND_RENDER = null;
        public static final RenderStrategy RELOAD = null;
        public static final RenderStrategy RENDER = null;
        public static final RenderStrategy SKIP = null;
        public static final RenderStrategy UPDATE_DATA = null;
        public static final RenderStrategy WAIT_NEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderStrategy[] f212690a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f212691b = null;
        private final boolean isFullUpdate;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.PLAYGROUND_RENDER", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class PLAYGROUND_RENDER extends RenderStrategy {
            public PLAYGROUND_RENDER(String r100, int r101) {
                super(r100, r101, true, null);
            }

            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
                byte[] r102 = r101.f212695d;
                if (r102 == null) goto L7;
                r100.render(r102, r101.f212696e, null);
                return;
            L7:
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.RELOAD", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class RELOAD extends RenderStrategy {
            public RELOAD(String r100, int r101) {
                super(r100, r101, true, null);
            }

            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
                r100.reloadTemplate(r101.f212696e, null);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.RENDER", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class RENDER extends RenderStrategy {
            public RENDER(String r100, int r101) {
                super(r100, r101, true, null);
            }

            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
                r100.renderByTemplateLoader("/template.js", r101.f212696e, null);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.SKIP", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SKIP extends RenderStrategy {
            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
            }

            public SKIP(String r100, int r101) {
                super(r100, r101, false, null);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.UPDATE_DATA", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class UPDATE_DATA extends RenderStrategy {
            public UPDATE_DATA(String r100, int r101) {
                super(r100, r101, false, null);
            }

            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
                r100.updateData(r101.f212696e, null);
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider.RenderStrategy.WAIT_NEXT", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$RenderStrategy;", ChameleonOpenTracker.Stage.RENDER, "", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider$ChartRenderData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WAIT_NEXT extends RenderStrategy {
            @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.RenderStrategyDecider.RenderStrategy
            public void render(ks4.b r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
                Intrinsics.checkNotNullParameter(r101, "renderData");
            }

            public WAIT_NEXT(String r100, int r101) {
                super(r100, r101, true, null);
            }
        }

        public RenderStrategy() {
            throw null;
        }

        public static EnumEntries<RenderStrategy> getEntries() {
            return f212691b;
        }

        public abstract void render(ks4.b r100, a r101);

        static {
            RELOAD r100 = new RELOAD("RELOAD", 0);
            RELOAD = r100;
            RENDER r101 = new RENDER("RENDER", 1);
            RENDER = r101;
            PLAYGROUND_RENDER r102 = new PLAYGROUND_RENDER("PLAYGROUND_RENDER", 2);
            PLAYGROUND_RENDER = r102;
            UPDATE_DATA r103 = new UPDATE_DATA("UPDATE_DATA", 3);
            UPDATE_DATA = r103;
            SKIP r104 = new SKIP("SKIP", 4);
            SKIP = r104;
            WAIT_NEXT r105 = new WAIT_NEXT("WAIT_NEXT", 5);
            WAIT_NEXT = r105;
            RenderStrategy[] r110 = {r100, r101, r102, r103, r104, r105};
            f212690a = r110;
            f212691b = EnumEntriesKt.enumEntries(r110);
        }

        public static RenderStrategy[] values() {
            return (RenderStrategy[]) f212690a.clone();
        }

        public final boolean isFullUpdate() {
            return this.isFullUpdate;
        }

        public static RenderStrategy valueOf(String r100) {
            return (RenderStrategy) r27.a.a(RenderStrategy.class, r100);
        }

        public RenderStrategy(String r100, int r101, boolean r102, DefaultConstructorMarker r103) {
            super(r100, r101);
            this.isFullUpdate = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseChartEntity f212692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rs4.d f212693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f212694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f212695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f212696e;

        public a(BaseChartEntity r100, rs4.d r101, String r102, byte[] r103) {
            Intrinsics.checkNotNullParameter(r100, "chart");
            Intrinsics.checkNotNullParameter(r102, "scene");
            this.f212692a = r100;
            this.f212693b = r101;
            this.f212694c = r102;
            this.f212695d = r103;
            JSONObject r104 = new JSONObject();
            r104.put("baseToken", r100.getBaseToken());
            r104.put("dashboardToken", r100.getDashboardToken());
            r104.put("chartToken", r100.getChartToken());
            r104.put("scene", r102);
            r104.put("status", r100.getStatus());
            r104.put("isTemplate", r100.isTemplate());
            if (r101 == null) goto L5;
            r104.put("chartData", r101.f539106a);
        L5:
            this.f212696e = r104.toString();
        }
    }

    public static final class b {
    }

    static {
    }

    public RenderStrategyDecider(ks4.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f212687a = r100;
        this.f212689c = new AtomicBoolean(false);
    }
}

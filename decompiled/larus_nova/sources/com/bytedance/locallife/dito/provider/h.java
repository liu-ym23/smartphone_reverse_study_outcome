package com.bytedance.locallife.dito.provider;

import android.content.Context;
import android.util.Log;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.data.r;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.event.ThreadLiveData;
import com.bytedance.locallife.dito.log.error.DATA_COMPONENT_DATA_EMPTY;
import com.bytedance.locallife.dito.log.error.DATA_GSON_PARSE_ERROR;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.utils.j;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public interface h {

    public static final class a {
        public static BaseDitoModel<?> a(h r110, DitoViewModel r111, m r112) {
            Intrinsics.checkNotNullParameter(r111, "viewModel");
            Intrinsics.checkNotNullParameter(r112, "treeNode");
            r111.f258041g.u().setValue(new v(r112));
            Map<String, ? extends r> r100 = r110.a();
            DitoNode r101 = r112.f258221a;
            if (r101 == null) goto L6;
            String r102 = r101.getSubType();
            if (r102 == null) goto L6;
        L7:
            r r103 = r100.get(r102);
            BaseDitoModel<?> r113 = null;
            String r114 = null;
            if (r103 == null) goto L47;
            BaseDitoModel<?> r115 = r103.a().invoke(r111, r112);
            DitoNode r104 = r112.f258221a;
            if (r104 == null) goto L13;
            com.bytedance.locallife.dito.data.d r105 = r104.getData();
        L15:
            if (r105 != null) goto L25;
            DATA_COMPONENT_DATA_EMPTY r106 = DATA_COMPONENT_DATA_EMPTY.f258454a;
            StringBuilder r107 = new StringBuilder("组件");
            DitoNode r108 = r112.f258221a;
            if (r108 == null) goto L19;
            String r109 = r108.getSubType();
        L20:
            r107.append(r109);
            r107.append("的data为空");
            String r116 = r107.toString();
            Pair[] r117 = new Pair[2];
            DitoNode r118 = r112.f258221a;
            if (r118 == null) goto L23;
            String r119 = r118.getSubType();
        L24:
            r117[0] = TuplesKt.to("node_sub_type", r119);
            r117[1] = TuplesKt.to("node_tag", r112.f258222b);
            j.k(r111, r106, r116, MapsKt.mutableMapOf(r117), null, r112.f258222b, 8);
            goto L25
        L23:
            r119 = null;
            goto L24
        L19:
            r109 = null;
        L25:
            DitoNode r120 = r112.f258221a;
            if (r120 != null) goto L28;
            r115.g();
        L46:
            r113 = r115;
            goto L47
        L28:
            com.bytedance.locallife.dito.data.d r121 = r120.getData();
            if (r121 != null) goto L31;
            r115.g();
            goto L46
        L31:
            int r122 = BaseDitoModel.f258491i;
            if (BaseDitoModel.d(r115.getClass()) != null) goto L61;
            r115.g();
            goto L46
        L61:
            r120.setRawData(r115.a(r121.f258198a));     // Catch: Exception -> L36
        L45:
            r115.g();
        L36:
            e = move-exception;
            DATA_GSON_PARSE_ERROR r123 = DATA_GSON_PARSE_ERROR.f258458a;
            String r124 = Log.getStackTraceString(e);
            Pair[] r125 = new Pair[2];
            DitoNode r126 = r112.f258221a;
            if (r126 == null) goto L40;
            String r127 = r126.getSubType();
        L41:
            r125[0] = TuplesKt.to("node_sub_type", r127);
            r125[1] = TuplesKt.to("node_tag", r112.f258222b);
            j.j(r111, r123, r124, MapsKt.mutableMapOf(r125), e, r112.f258222b);
            rq6.a r128 = rq6.a.f538927a;
            StringBuilder r129 = new StringBuilder("createModel: ");
            DitoNode r130 = r112.f258221a;
            if (r130 == null) goto L44;
            r114 = r130.getSubType();
        L44:
            r129.append(r114);
            r129.append("解析rawData失败 ");
            r129.append(Log.getStackTraceString(e));
            r128.b("dito_log", r129.toString());
            goto L45
        L40:
            r127 = null;
            goto L41
        L13:
            r105 = null;
        L47:
            ThreadLiveData<v> r131 = r111.f258041g.u();
            v r132 = new v(false, r112);
            Intrinsics.checkNotNullParameter(BaseDitoModel.class, "clazz");
            String r133 = BaseDitoModel.class.getName();
            monitor-enter(r132);
            Intrinsics.checkNotNullParameter(r133, "key");     // Catch: Throwable -> L58
            if (r132.f258264b != null) goto L52;
            r132.f258264b = new LinkedHashMap();     // Catch: Throwable -> L58
        L52:
            Map<String, Object> r134 = r132.f258264b;     // Catch: Throwable -> L58
            if (r134 == null) goto L55;
            r134.put(r133, r113);     // Catch: Throwable -> L58
        L55:
            monitor-exit(r132);
            r131.setValue(r132);
            return r113;
        L58:
            th = move-exception;
            throw th;
        L6:
            r102 = "";
            goto L7
        }

        public static BaseDitoView<?> b(h r100, Context r101, m r102, DitoViewModel r103, BaseDitoModel<?> r104) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "treeNode");
            Intrinsics.checkNotNullParameter(r103, "viewModel");
            Intrinsics.checkNotNullParameter(r104, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Map<String, ? extends r> r105 = r100.a();
            DitoNode r106 = r102.f258221a;
            if (r106 == null) goto L5;
            String r107 = r106.getSubType();
        L6:
            r r108 = r105.get(r107);
            if (r108 == null) goto L11;
            Function2<Context, m, BaseDitoView<?>> r109 = r108.getCreateView();
            if (r109 == null) goto L11;
            BaseDitoView<?> r110 = r109.invoke(r101, r102);
        L12:
            if (r110 == null) goto L15;
            r110.W(r103, r104);
            return r110;
        L15:
            return null;
        L11:
            r110 = null;
            goto L12
        L5:
            r107 = null;
            goto L6
        }
    }

    Map<String, ? extends r> a();

    BaseDitoView<?> b(Context r100, m r101, DitoViewModel r102, BaseDitoModel<?> r103);

    BaseDitoModel<?> c(DitoViewModel r100, m r101);
}

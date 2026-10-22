package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.ICanvasRepoService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.FeatureOptionPanelItem;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.canvas.service.bean.TabExtra;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import cy8.l;
import cy8.m;
import cy8.q;
import cy8.v;
import cy8.w;
import cy8.x;
import cy8.y;
import hq9.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.CallbackFlowBuilder;

/* JADX INFO: loaded from: classes26.dex */
public final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f323332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f323333b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f323334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ny8.j> f323335d = null;

    public h() {
    }

    static {
        f323332a = new h();
        f323333b = z2.f365865a.getCreationCanvasClientConfig().f486752a;
        f323334c = LazyKt.lazy(new a());
        f323335d = new ConcurrentHashMap();
    }

    public static by8.a e() {
        pd6.b r100 = pd6.c.f528682a;
        return (by8.a) pd6.c.a(Reflection.getOrCreateKotlinClass(by8.a.class));
    }

    @Override // com.larus.canvas.feature.component.logic.canvasGenerator.j
    public final void b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "localIds");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = (String) r101.next();
        ny8.j r103 = f323335d.remove(r102);
        if (r103 == null) goto L4;
        r103.cancel();
        FLogger.f375446a.i("CanvasGenerator", "cancel task " + r102);
        goto L4
    }

    @Override // com.larus.canvas.feature.component.logic.canvasGenerator.j
    public final CallbackFlowBuilder a(ky8.c r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        return kotlinx.coroutines.flow.e.e(new CanvasGenerator$startStreamGenerate$1(r100, r101, null));
    }

    public static final Object c(ky8.c r310, CanvasGenerator$startStreamGenerate$1.b r311, Continuation r312) {
        by8.a r100 = e();
        if (r100 != null) goto L5;
        FLogger.f375446a.e("CanvasGenerator", "SSE_KMP ability not registered, report error, localId=" + r310.f506681c);
        r311.onError(-90001, "ICanvasSSEAbility kmpService is null");
        return Unit.INSTANCE;
    L5:
        int r101 = i.f323336a;
        Intrinsics.checkNotNullParameter(r310, "param");
        r0 r102 = z2.f365865a.getCreationCanvasClientConfig();
        String r103 = r310.f506681c;
        Intrinsics.checkNotNullParameter(r310, "param");
        StringBuilder r104 = new StringBuilder();
        r104.append(r310.f506679a);
        r104.append('_');
        r104.append(r310.f506680b);
        String r105 = r104.toString();
        Long r106 = r310.f506682d;
        Long r110 = r310.f506683e;
        Integer r111 = Integer.valueOf(r310.f506679a);
        Integer r112 = Integer.valueOf(r310.f506680b);
        String r113 = r310.f506681c;
        String r114 = r310.f506688j;
        String r115 = r310.f506689k;
        String r107 = r310.f506690l;
        List<InstructionTab> r108 = r310.f506684f;
        if (r108 == null) goto L51;
        List<InstructionTab> r109 = r108;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r117 = r109.iterator();
    L9:
        if (r117.hasNext() == false) goto L50;
        InstructionTab r118 = (InstructionTab) r117.next();
        String r210 = r118.getTabLabel();
        String r211 = r118.getTabName();
        Integer r212 = r118.getTabType();
        TabExtra r119 = r118.getExtra();
        if (r119 == null) goto L13;
        y r213 = new y(r119.isSupportRefImage(), r119.getEffectMode(), r119.getAbilityType());
    L14:
        Icon r120 = r118.getIcon();
        if (r120 == null) goto L17;
        m r214 = i.a(r120);
    L18:
        Icon r121 = r118.getDarkModeIcon();
        if (r121 == null) goto L21;
        m r313 = i.a(r121);
    L22:
        List<OptionItem> r122 = r118.getOptionList();
        if (r122 == null) goto L29;
        List<OptionItem> r123 = r122;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator<T> r125 = r123.iterator();
    L26:
        if (r125.hasNext() == false) goto L28;
        r124.add(i.b((OptionItem) r125.next()));
        goto L26
    L28:
        ArrayList r314 = r124;
    L30:
        OptionItem r126 = r118.getSingleOption();
        if (r126 == null) goto L33;
        q r315 = i.b(r126);
    L34:
        List<FeatureOptionPanelItem> r127 = r118.getFeatureOptionPanelList();
        if (r127 == null) goto L48;
        List<FeatureOptionPanelItem> r128 = r127;
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
        Iterator r130 = r128.iterator();
    L38:
        if (r130.hasNext() == false) goto L47;
        FeatureOptionPanelItem r131 = (FeatureOptionPanelItem) r130.next();
        Long r132 = r131.getId();
        String r133 = r131.getTitle();
        List<OptionItem> r134 = r131.getOptionList();
        if (r134 == null) goto L45;
        List<OptionItem> r135 = r134;
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator<T> r137 = r135.iterator();
    L43:
        if (r137.hasNext() == false) goto L46;
        r136.add(i.b((OptionItem) r137.next()));
    L46:
        r129.add(new cy8.f(r132, r133, r136));
        r130 = r130;
        r107 = r107;
        r102 = r102;
        goto L38
    L45:
        r136 = null;
        goto L46
    L47:
        String r215 = r107;
        r0 r316 = r102;
        ArrayList r317 = r129;
    L49:
        r116.add(new l(r210, r211, r212, r213, r214, r313, r314, r315, r317));
        r117 = r117;
        r107 = r215;
        r105 = r105;
        r103 = r103;
        r102 = r316;
        goto L9
    L48:
        r215 = r107;
        r316 = r102;
        r317 = null;
        goto L49
    L33:
        r315 = null;
        goto L34
    L29:
        r314 = null;
        goto L30
    L21:
        r313 = null;
        goto L22
    L17:
        r214 = null;
        goto L18
    L13:
        r213 = null;
        goto L14
    L50:
        String r216 = r107;
        r0 r318 = r102;
        String r319 = r103;
        String r320 = r105;
        ArrayList r138 = r116;
    L52:
        ImageObject r139 = r310.f506685g;
        cy8.j r140 = new cy8.j(r139.uri, r139.url, r139.width, r139.height, r139.urlFormats, r139.aiCreationImage);
        String r141 = r310.f506686h;
        String r142 = r310.f506691m;
        List<ImageObject> r143 = r310.f506687i;
        if (r143 == null) goto L59;
        List<ImageObject> r144 = r143;
        ArrayList r145 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r144, 10));
        Iterator r146 = r144.iterator();
    L56:
        if (r146.hasNext() == false) goto L58;
        ImageObject r147 = (ImageObject) r146.next();
        r145.add(new cy8.j(r147.uri, r147.url, r147.width, r147.height, r147.urlFormats, r147.aiCreationImage));
        r146 = r146;
        r142 = r142;
        goto L56
    L58:
        String r217 = r142;
    L60:
        v r148 = new v(r106, r110, r111, r112, r113, r114, r115, r216, r138, r140, r141, r217, r145, 256);
        r0 r149 = r318;
        Object r150 = r100.n2(new w(r319, r320, r148, new x(r149.f486755d, r149.f486756e, r149.f486757f, r149.f486758g), r149.f486753b)).collect(new b(r311, r310), r312);
        if (r150 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
        return r150;
    L64:
        return Unit.INSTANCE;
    L59:
        r217 = r142;
        r145 = null;
        goto L60
    L51:
        r216 = r107;
        r318 = r102;
        r319 = r103;
        r320 = r105;
        r138 = null;
        goto L52
    }

    public static final void d(String r100, ny8.c r101, List r102) {
        r101.a(r102);
        FLogger.f375446a.i("CanvasGenerator", "sse done but block not finished, getCanvasBlockInfo trigger, localId = " + r100);
        ICanvasRepoService.Companion r103 = ICanvasRepoService.f323790a;
        CanvasBlock r104 = (CanvasBlock) CollectionsKt.firstOrNull(r102);
        Long r105 = null;
        if (r104 == null) goto L9;
        CanvasImageBlock r106 = r104.content;
        if (r106 == null) goto L9;
        CanvasInfo r107 = r106.canvasInfo;
        if (r107 == null) goto L9;
        Long r108 = r107.canvasId;
    L10:
        CanvasBlock r109 = (CanvasBlock) CollectionsKt.firstOrNull(r102);
        if (r109 == null) goto L17;
        CanvasImageBlock r110 = r109.content;
        if (r110 == null) goto L17;
        CanvasInfo r111 = r110.canvasInfo;
        if (r111 == null) goto L17;
        r105 = r111.canvasSubId;
    L17:
        r103.b(new ny8.f(r108, r105, r100), new c(r100, r101, r102));
        return;
    L9:
        r108 = null;
        goto L10
    }
}

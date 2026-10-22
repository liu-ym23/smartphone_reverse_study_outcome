package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"filterNeedBindData", "", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "list", "", "showDependsOn", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/ShowDependsOn;", "state", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GalleryFragment$onPendantContainerStateChange$2 extends Lambda implements Function3<List<? extends LynxElementVO>, ShowDependsOn, State, List<LynxElementVO>> {
    public static final GalleryFragment$onPendantContainerStateChange$2 INSTANCE = null;

    static {
        INSTANCE = new GalleryFragment$onPendantContainerStateChange$2();
    }

    public GalleryFragment$onPendantContainerStateChange$2() {
        super(3);
    }

    public final List<LynxElementVO> invoke(List<LynxElementVO> r26, ShowDependsOn r27, State r28) {
        State r5 = r28;
        Intrinsics.checkNotNullParameter(r26, "list");
        Intrinsics.checkNotNullParameter(r27, "showDependsOn");
        Intrinsics.checkNotNullParameter(r5, "state");
        ArrayList r4 = new ArrayList();
        Iterator<T> r0 = r26.iterator();
    L4:
        if (r0.hasNext() == false) goto L35;
        LynxElementVO r2 = (LynxElementVO) r0.next();
        ShowDependsOn.a r3 = ShowDependsOn.Companion;
        LynxElementVO r6 = null;
        if (r2 == null) goto L10;
        ConfigModel r7 = r2.getConfig();
        if (r7 == null) goto L10;
        String r8 = r7.getShowDependsOn();
    L11:
        r3.getClass();
        ShowDependsOn[] r9 = ShowDependsOn.values();
        int r10 = r9.length;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L17;
        ShowDependsOn r12 = r9[r11];
        if (Intrinsics.areEqual(r12.getValue(), r8) == true) goto L18;
        r11 = r11 + 1;
    L18:
        if (r12 != r27) goto L32;
        if (r2 == null) goto L30;
        Map r13 = r2.getQueryData();
        if (r13 == null) goto L24;
        Map r14 = MapsKt.toMutableMap(r13);
        if (r14 == null) goto L24;
    L25:
        Map r15 = r14;
        if (r5 != State.ANIM_END) goto L28;
        String r16 = "1";
    L29:
        r15.put("need_anim", r16);
        Unit r17 = Unit.INSTANCE;
        r6 = LynxElementVO.copy$default(r2, null, null, r15, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, r28, 131067, null);
        ArrayList r18 = r4;
    L31:
        r18.add(r6);
    L33:
        r5 = r28;
        r4 = r18;
        goto L4
    L28:
        r16 = "0";
    L24:
        r14 = new LinkedHashMap();
        goto L25
    L30:
        r18 = r4;
        goto L31
    L32:
        r18 = r4;
        goto L33
    L17:
        r12 = null;
    L10:
        r8 = null;
        goto L11
    L35:
        return r4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, (ShowDependsOn) r2, (State) r3);
    }
}

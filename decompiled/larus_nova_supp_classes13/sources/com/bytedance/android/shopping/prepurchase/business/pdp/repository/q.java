package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.PageConfig;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public BottomButtonVO a;
    public TopRightControlsVO b;
    public com.bytedance.android.shopping.anchorv4.vm.a c;
    public List<com.bytedance.android.ecom.arch.slice.adapter.b> d;
    public HalfStrandVO e;
    public SmallVideoWindowVO f;
    public ShopFloatEntryVO g;
    public BackToTopEntryVO h;
    public PlayBackEntryVO i;
    public Map<String, PendantsComponentVO> j;
    public e73.a k;
    public JSONObject l;
    public l73.c m;
    public PendantContainerVO n;
    public final PackResponseDTO o;

    public final com.bytedance.android.shopping.anchorv4.vm.a a() {
        if (this.c != null) goto L17;
        PackParsedDTO r1 = this.o.getParsedDTO();
        List r2 = null;
        if (r1 == null) goto L9;
        PageConfig r3 = r1.getPageConfig();
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.getCollapseDetail());
    L10:
        boolean r5 = com.bytedance.android.shopping.extensions.k.i(r4);
        PackParsedDTO r6 = this.o.getParsedDTO();
        if (r6 == null) goto L15;
        PageConfig r7 = r6.getPageConfig();
        if (r7 == null) goto L15;
        r2 = r7.getCollapseIgnoreList();
    L15:
        this.c = new com.bytedance.android.shopping.anchorv4.vm.a(r5, r2);
    L9:
        r4 = null;
    L17:
        return this.c;
    }

    public q(PackResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "firstChunkData");
        this.o = r2;
    }
}

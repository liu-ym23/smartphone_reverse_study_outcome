package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECExposureDataDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECTrackDataDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallLiveCardOpt implements com.bytedance.android.shopping.mall.feed.opt.a {
    public static Bitmap b;
    public static Bitmap c;
    public static final a d = null;
    public final Lazy a;

    public static final class a {
        public a() {
        }
    }

    static {
        d = new a();
    }

    public MallLiveCardOpt() {
        this.a = LazyKt.lazy(MallLiveCardOpt$liveService$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r2, HomePageDTO r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        c(r2, r3);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r3, HomePageDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        d.getClass();
        b = BitmapFactory.decodeResource(r3.getResources(), 2131248018);
        c = BitmapFactory.decodeResource(r3.getResources(), 2131248019);
        c(r3, r4);
    }

    public final void c(Context r6, HomePageDTO r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        HomePageBffDTO r8 = r7.getBff();
        if (r8 == null) goto L45;
        ECHybridListDTO r9 = r8.getFeed();
        if (r9 == null) goto L69;
        List r10 = r9.getSections();
        if (r10 == null) goto L70;
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L71;
        ArrayList r0 = ((ECHybridListSectionDTO) r11.next()).getItems();
        if (r0 == null) goto L12;
        Iterator r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L12;
        ECHybridListItemDTO r2 = (ECHybridListItemDTO) r1.next();
        Integer r3 = r2.getItemType();
        if (r3 == null) goto L17;
        if (r3.intValue() != 1002) goto L17;
        ECTrackDataDTO r4 = r2.getTrackData();
        if (r4 == null) goto L17;
        List r5 = r4.getExposureData();
        if (r5 == null) goto L17;
        Iterator r12 = r5.iterator();
    L29:
        if (r12.hasNext() == false) goto L17;
        ECExposureDataDTO r13 = (ECExposureDataDTO) r12.next();
        if (Intrinsics.areEqual(r13.getEventName(), "show_ecom_card") == false) goto L29;
        Map r14 = r13.getParams();
        Object r15 = null;
        if (r14 == null) goto L35;
        Object r16 = r14.get("room_id");
    L37:
        if ((r16 instanceof String) == false) goto L40;
        r15 = r16;
    L40:
        String r17 = (String) r15;
        if (r17 == null) goto L29;
        t r18 = (t) this.a.getValue();
        if (r18 == null) goto L29;
        r18.createPlayViewAndSave(r6, r17);
        goto L29
    L35:
        r16 = null;
        goto L37
    L71:
        return;
    L70:
        return;
    L69:
        return;
    }
}

package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements td8.c {

    public static final class a {
    }

    static {
    }

    public n(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        Iterator<? extends xc8.b> r104 = r103.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L14;
        xc8.b r106 = r104.next();
        if (hp8.a.c(r106.getMessage()) == true) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L15;
        r105 = r105 + 1;
    L15:
        if (r105 == (-1)) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (hp8.a.b(r106.getMessage()) == true) goto L10;
        r107 = true;
        goto L11
    L14:
        r105 = -1;
        goto L15
    }

    @Override // td8.c
    public final List<xc8.b> b(int r510, xc8.b r511, xc8.b r512, List<xc8.b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        Iterator<xc8.b> r100 = r513.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L14;
        xc8.b r102 = r100.next();
        if (hp8.a.c(r102.getMessage()) == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L15;
        r101 = r101 + 1;
    L15:
        if (r101 == (-1)) goto L59;
        if (r101 >= 0) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L23;
        return r513;
    L23:
        xc8.b r105 = (xc8.b) ListProtector.get(r513, r101);
        List<UplinkFileEntity> r106 = com.larus.bmhome.chat.sendimage.e.e(r105.getMessage().getContent()).getEntities();
        if (r106 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
        return r513;
    L32:
        String r108 = r105.getMessage().getContent();
        if (r108 != null) goto L36;
        return r513;
    L36:
        if (Intrinsics.areEqual(r108, "null") == false) goto L38;
        return r513;
    L38:
        Message r109 = r105.getMessage();
        long r410 = r105.getMessage().getCreateTime();
        List<UplinkFileEntity> r110 = com.larus.bmhome.chat.sendimage.e.e(r109.getContent()).getEntities();
        if (r110 == null) goto L47;
        UplinkFileEntity r111 = (UplinkFileEntity) ListProtector.get(r110, 0);
        if (r111 == null) goto L47;
        ExpiredInfo r112 = r111.getExpiredInfo();
        if (r112 == null) goto L47;
        Long r113 = r112.getExpireTime();
        if (r113 == null) goto L47;
        long r114 = r113.longValue();
    L48:
        long r115 = r114 - (System.currentTimeMillis() / ((long) 1000));
        if (r115 < 86400) goto L52;
        String r116 = MathKt.roundToInt(r115 / 86400.0f) + " 天";
    L58:
        String r117 = AppHost.f326268a.getApplication().getString(R.string.larus_photo_expiration_template, new Object[]{r116});
        ListProtector.add(r513, r101, new xc8.l(b0.j(new Message(r109.getConversationId(), null, null, 0, 21, null, 1002, false, null, r117, null, null, null, null, null, r109.getMessageId() + "-time-stamp", r109.getLocalIndex() + 1, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, r410, null, null, null, -98898, 29, null), 12)));
        goto L59
    L52:
        if (r115 < TimeUtils.SECONDS_PER_HOUR) goto L55;
        r116 = MathKt.roundToInt(r115 / 3600.0f) + " 小时";
        goto L58
    L55:
        if (r115 < 60) goto L57;
        r116 = MathKt.roundToInt(r115 / 60.0f) + " 分钟";
        goto L58
    L57:
        r116 = "1 分钟";
    L47:
        r114 = Long.MAX_VALUE;
        goto L48
    L26:
        if (r106.isEmpty() == true) goto L29;
        r107 = false;
        goto L30
    L18:
        if (r101 >= r513.size()) goto L20;
        r104 = true;
    L59:
        return r513;
    L8:
        if (hp8.a.b(r102.getMessage()) == true) goto L10;
        r103 = true;
        goto L11
    L14:
        r101 = -1;
        goto L15
    }
}

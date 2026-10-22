package com.bytedance.locallife.cube.api.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a.\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0003*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\t"}, d2 = {"getBoolean", "", "", "", "", "key", "default", "getMap", "getString", "cube-saas_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
public final class PublishEventKt {
    public static final Map<String, Object> getMap(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Map) == true) goto L9;
        return null;
    L9:
        return (Map) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final String getString(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof String) == false) goto L11;
        return (String) r102;
    L11:
        if ((r102 instanceof Boolean) == true) goto L13;
        return null;
    L13:
        if (((Boolean) r102).booleanValue() == false) goto L15;
        return "true";
    L15:
        return "false";
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean getBoolean(Map<String, ? extends Object> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r103 = r100.get(r101);
    L7:
        if ((r103 instanceof Boolean) == false) goto L11;
        return ((Boolean) r103).booleanValue();
    L11:
        if ((r103 instanceof String) == false) goto L24;
        String r104 = (String) r103;
        if (StringsKt.equals(r104, "true", true) == false) goto L15;
    L23:
        return true;
    L15:
        if (StringsKt.equals(r104, BdpAppEventConstant.YES, true) == true) goto L23;
        if (StringsKt.equals(r104, "false", true) == false) goto L20;
        return false;
    L20:
        if (StringsKt.equals(r104, BdpAppEventConstant.NO, true) == false) goto L24;
        return false;
    L24:
        return r102;
    L5:
        r103 = null;
        goto L7
    }

    public static /* synthetic */ boolean getBoolean$default(Map r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return getBoolean(r100, r101, r102);
    }
}

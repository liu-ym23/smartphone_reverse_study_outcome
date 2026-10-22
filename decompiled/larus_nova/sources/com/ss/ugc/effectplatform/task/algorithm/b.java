package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z.b<String, Pair<Integer, Long>> f457712a;

    public b() {
        this.f457712a = new z.b(false);
    }

    public final void a(Effect r100) {
        Pair<Integer, Long> r101 = this.f457712a.get(r100.getPanel());
        if (r101 == null) goto L9;
        int r102 = r101.getFirst().intValue() - 1;
        if (r102 > 0) goto L7;
        this.f457712a.remove(r100.getPanel());
        return;
    L7:
        this.f457712a.put(r100.getPanel(), new Pair(Integer.valueOf(r102), r101.getSecond()));
        return;
    }

    public final void update(Effect r100) {
        Pair<Integer, Long> r101 = this.f457712a.get(r100.getPanel());
        if (r101 == null) goto L7;
        Integer r102 = r101.getFirst();
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        z.b<String, Pair<Integer, Long>> r104 = this.f457712a;
        String r105 = r100.getPanel();
        Integer r106 = Integer.valueOf(r103 + 1);
        int r107 = b0.a.f16820a;
        r104.put(r105, new Pair(r106, Long.valueOf(System.currentTimeMillis())));
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public final String b(String r110, String r111) {
        String r100 = "null";
        if (this.f457712a.isEmpty() == false) goto L6;
        Logger.e$default(Logger.INSTANCE, "JKL", "[EffectBlock][BlockSingle][Result][" + r110 + "][Scene:" + r111 + "][None]", null, 4, null);
        return "null";
    L6:
        Iterator<Map.Entry<String, Pair<Integer, Long>>> r101 = this.f457712a.entrySet().iterator();
        int r102 = 0;
        long r103 = 0;
    L8:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, Pair<Integer, Long>> r104 = r101.next();
        StringBuilder r105 = new StringBuilder("<");
        r105.append(r104.getKey());
        r105.append(", ");
        r105.append(r104.getValue().getFirst().intValue());
        r105.append(", ");
        r105.append(r104.getValue().getSecond().longValue());
        r105.append(Typography.greater);
        if (Intrinsics.areEqual(r104.getKey(), r111) == true) goto L8;
        if (r104.getValue().getFirst().intValue() > r102) goto L18;
        if (r104.getValue().getFirst().intValue() != r102) goto L8;
        if (r104.getValue().getSecond().longValue() <= r103) goto L8;
    L18:
        r100 = r104.getKey();
        long r106 = r104.getValue().getSecond().longValue();
        r102 = r104.getValue().getFirst().intValue();
        r103 = r106;
        goto L8
    L19:
        Logger.INSTANCE.d("JKL", "[EffectBlock][BlockSingle][Result][" + r110 + "][Scene:" + r111 + "][maxScene : " + r100 + "][maxCount : " + r102 + ']');
        return r100;
    }

    public final String c(String r110, String r111) {
        b r100 = a.f457708a;
        String r101 = "null";
        if (a.f457710c == true) goto L6;
        return "null";
    L6:
        if (this.f457712a.isEmpty() == false) goto L9;
        Logger.e$default(Logger.INSTANCE, "JKL", "[EffectBlock][BlockList][Source][" + r110 + "][Scene:" + r111 + "][None]", null, 4, null);
        return "null";
    L9:
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, Pair<Integer, Long>>> r103 = this.f457712a.entrySet().iterator();
    L10:
        int r104 = 0;
        if (r103.hasNext() == false) goto L19;
        Map.Entry<String, Pair<Integer, Long>> r105 = r103.next();
        StringBuilder r106 = new StringBuilder("<");
        r106.append(r105.getKey());
        r106.append(", ");
        r106.append(r105.getValue().getFirst().intValue());
        r106.append(">");
        if (Intrinsics.areEqual(r105.getKey(), r111) == true) goto L10;
        int r107 = r105.getValue().getFirst().intValue();
    L16:
        if (r104 >= r107) goto L10;
        r102.append(r105.getKey());
        r102.append(",");
        r104 = r104 + 1;
        goto L16
    L19:
        if (r102.length() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L25;
    L28:
        Logger.INSTANCE.w("JKL", "[EffectBlock][BlockList][Source][" + r110 + "][Scene:" + r111 + "][" + r101 + ']');
        return r101;
    L25:
        if (StringsKt.endsWith$default(r102, ",", false, 2, null) == false) goto L27;
        r101 = StringsKt.removeSuffix(r102, ",").toString();
        goto L28
    L27:
        r101 = r102.toString();
        goto L28
    L21:
        r108 = false;
        goto L22
    }
}

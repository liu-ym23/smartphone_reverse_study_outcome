package com.larus.bmhome.tipoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class TipOffRepo {
    public TipOffRepo() {
    }

    public static Object a(int r110, String r111, ArrayList r112, String r113, String r114, String r115, int r210, List r211, Map r212, Function1 r213, Continuation r214) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TipOffRepo$requireTipOff$2(r115, r111, r110, r112, r113, r114, r210, r211, r212, r213, null), r214);
    }
}

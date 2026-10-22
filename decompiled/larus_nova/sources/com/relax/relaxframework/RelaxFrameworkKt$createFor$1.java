package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/relax/relaxframework/s5;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/s5;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class RelaxFrameworkKt$createFor$1 extends Lambda implements Function0<s5<Object>> {
    final /* synthetic */ ArrayList<Object> $each;
    final /* synthetic */ Function2<Object, Integer, j5> $renderItem;

    /* JADX WARN: Multi-variable type inference failed */
    public RelaxFrameworkKt$createFor$1(ArrayList<Object> r100, Function2<Object, ? super Integer, ? extends j5> r101) {
        this.$each = r100;
        this.$renderItem = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final s5<Object> invoke() {
        s5<Object> r100 = new s5();
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = com.bytedance.rts.foundation.j.d(this.$each);
        com.bytedance.rts.foundation.k.c(r101, r102);
        Function2<Object, Integer, j5> r103 = this.$renderItem;
        ArrayList<Object> r104 = this.$each;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        r100.t(r103.invoke(ListProtector.get(r104, r105), Integer.valueOf(r105)));
        r105 = r105 + 1;
        goto L3
    L5:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ s5<Object> invoke() {
        return invoke();
    }
}

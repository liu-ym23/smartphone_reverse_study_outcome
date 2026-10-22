package com.bytedance.ies.sve_list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/sve_core/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/ies/sve_list/a;", "P", "Lcom/bytedance/ies/sve_core/r;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/ies/sve_core/r;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class RecyclerViewItemWidget$bindListReducerState$func$1 extends Lambda implements Function0<r<a>> {
    final /* synthetic */ s $initState;
    final /* synthetic */ u $name;
    final /* synthetic */ Function2 $reducer;
    final /* synthetic */ RecyclerViewItemWidget this$0;

    public RecyclerViewItemWidget$bindListReducerState$func$1(RecyclerViewItemWidget r100, u r101, Function2 r102, s r103) {
        this.this$0 = r100;
        this.$name = r101;
        this.$reducer = r102;
        this.$initState = r103;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final r<a> invoke() {
        u r100 = this.$name.a(this.this$0.f248717e);
        return this.this$0.xq(r100, this.$reducer, this.$initState);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ r<a> invoke() {
        return invoke();
    }
}

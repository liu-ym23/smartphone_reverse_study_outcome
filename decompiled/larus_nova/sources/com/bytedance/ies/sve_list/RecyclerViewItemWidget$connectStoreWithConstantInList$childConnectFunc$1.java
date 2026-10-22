package com.bytedance.ies.sve_list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sve_core.f;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.u;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/sve_core/e;", "C", "Lcom/bytedance/ies/sve_list/a;", "P", "Lcom/bytedance/ies/sve_core/r;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/ies/sve_core/r;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class RecyclerViewItemWidget$connectStoreWithConstantInList$childConnectFunc$1 extends Lambda implements Function0<r<a>> {
    final /* synthetic */ f $constant;
    final /* synthetic */ Function1 $mapIntentToAction;
    final /* synthetic */ Function3 $mapStateToProps;
    final /* synthetic */ u $name;
    final /* synthetic */ RecyclerViewItemWidget this$0;

    public RecyclerViewItemWidget$connectStoreWithConstantInList$childConnectFunc$1(RecyclerViewItemWidget r100, u r101, f r102, Function1 r103, Function3 r104) {
        this.this$0 = r100;
        this.$name = r101;
        this.$constant = r102;
        this.$mapIntentToAction = r103;
        this.$mapStateToProps = r104;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final r<a> invoke() {
        u r100 = this.$name.a(this.this$0.f248717e);
        f r101 = this.$constant;
        String r102 = this.this$0.f248717e;
        if (r102 == null) goto L10;
        r101.getClass();
        if (r102.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        String r104 = r102 + '-' + r101.f248702a;
    L12:
        return RecyclerViewItemWidget.Nq(this.this$0, r100, new f(r104), this.$mapIntentToAction, this.$mapStateToProps);
    L7:
        r103 = false;
    L10:
        r104 = r101.f248702a;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ r<a> invoke() {
        return invoke();
    }
}

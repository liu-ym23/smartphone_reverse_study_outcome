package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.config.condition.ShieldP2PCondition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/config/ShieldP2P;", "Lcom/ss/android/lark/picker/config/Entity;", "Lcom/ss/android/lark/picker/config/condition/ShieldP2PCondition;", "Lcom/ss/android/lark/picker/config/ShieldP2PFilter;", "Lcom/ss/android/lark/picker/config/ShieldP2PExtra;", "<init>", "()V", "filter", "getFilter", "()Lcom/ss/android/lark/picker/config/ShieldP2PFilter;", "extra", "getExtra", "()Lcom/ss/android/lark/picker/config/ShieldP2PExtra;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShieldP2P implements Entity<ShieldP2PCondition<?>, ShieldP2PFilter, ShieldP2PExtra> {
    private final ShieldP2PExtra extra;
    private final ShieldP2PFilter filter;

    public ShieldP2P() {
        this.filter = new ShieldP2PFilter();
        this.extra = new ShieldP2PExtra();
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public /* bridge */ /* synthetic */ Extra getExtra() {
        return getExtra();
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public /* bridge */ /* synthetic */ Filter getFilter() {
        return getFilter();
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public ShieldP2PExtra getExtra() {
        return this.extra;
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public ShieldP2PFilter getFilter() {
        return this.filter;
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void extra(Function1<? super ShieldP2PExtra, Unit> r100) {
        Entity.DefaultImpls.extra(this, r100);
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void filter(Function1<? super ShieldP2PFilter, Unit> r100) {
        Entity.DefaultImpls.filter(this, r100);
    }
}

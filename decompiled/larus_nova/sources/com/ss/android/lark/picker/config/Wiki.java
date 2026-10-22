package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.config.condition.WikiCondition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/config/Wiki;", "Lcom/ss/android/lark/picker/config/Entity;", "Lcom/ss/android/lark/picker/config/condition/WikiCondition;", "Lcom/ss/android/lark/picker/config/WikiFilter;", "Lcom/ss/android/lark/picker/config/WikiExtra;", "<init>", "()V", "filter", "getFilter", "()Lcom/ss/android/lark/picker/config/WikiFilter;", "extra", "getExtra", "()Lcom/ss/android/lark/picker/config/WikiExtra;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Wiki implements Entity<WikiCondition<?>, WikiFilter, WikiExtra> {
    private final WikiExtra extra;
    private final WikiFilter filter;

    public Wiki() {
        this.filter = new WikiFilter();
        this.extra = new WikiExtra();
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
    public WikiExtra getExtra() {
        return this.extra;
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public WikiFilter getFilter() {
        return this.filter;
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void extra(Function1<? super WikiExtra, Unit> r100) {
        Entity.DefaultImpls.extra(this, r100);
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void filter(Function1<? super WikiFilter, Unit> r100) {
        Entity.DefaultImpls.filter(this, r100);
    }
}

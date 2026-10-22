package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.config.condition.MailContactCondition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/MailContactCondition;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MailContactCondition<C extends MailContactCondition<C>> extends Condition.Element<C> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <C extends MailContactCondition<C>, E extends Condition.Element<E>> E get(MailContactCondition<C> r100, Condition.Key<E> r101) {
            Intrinsics.checkNotNullParameter(r101, "key");
            return (E) Condition.Element.DefaultImpls.get(r100, r101);
        }
    }
}

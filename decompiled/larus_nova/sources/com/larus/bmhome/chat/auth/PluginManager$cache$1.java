package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PluginManager$cache$1 extends FunctionReferenceImpl implements Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object>, SuspendFunction {
    public PluginManager$cache$1(Object r100) {
        super(5, r100, PluginAuthRepository.class, "requestPluginList", "requestPluginList(Ljava/lang/String;IILcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(String r100, Integer r101, Integer r102, DowngradeSource r110, Continuation<? super PluginItemData> r111) {
        return invoke(r100, r101.intValue(), r102.intValue(), r110, r111);
    }

    public final Object invoke(String r100, int r101, int r110, DowngradeSource r111, Continuation<? super PluginItemData> r112) {
        return ((PluginAuthRepository) this.receiver).c(r100, r101, r110, r111, r112);
    }
}

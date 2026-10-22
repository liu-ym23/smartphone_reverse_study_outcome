package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements y.a<BotModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData<BotModel> f297938a;

    public f(MutableLiveData<BotModel> r100) {
        this.f297938a = r100;
    }

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(BotModel r100) {
        BotModel r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f297938a.postValue(r101);
    }
}

package com.larus.bmhome.chat.component.cvs;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public interface y extends m1a.a {

    public interface a<T> {
        void c(T r100);
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {
        public static /* synthetic */ void a(y r100, a r101) {
            r100.ll(new a0(), r101);
        }

        public static /* synthetic */ void b(y r100, a r101) {
            r100.rh(new z(), r101);
        }
    }

    String Y1();

    void Z7(Function1<? super String, Unit> r100);

    String getBotId();

    wc9.e h();

    BotModel j0();

    void lQ(a<?> r100);

    void ll(Function2<? super BotModel, ? super BotModel, Boolean> r100, a<BotModel> r101);

    void rh(Function2<? super wc9.e, ? super wc9.e, Boolean> r100, a<wc9.e> r101);

    void updateConversationId(String r100, String r101);
}

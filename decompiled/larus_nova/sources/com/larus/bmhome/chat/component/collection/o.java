package com.larus.bmhome.chat.component.collection;

import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CollectionType;
import com.larus.platform.model.MessageCollection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface o extends t1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(o r100, String r101, Message r102) {
            r100.eK(r101, r102, new n());
        }

        public static /* synthetic */ void b(o r100, String r101, String r102, List r110, Function2 r111) {
            r100.i50(r101, r102, r110, 5, null, r111);
        }
    }

    void eK(String r100, Message r101, Function1 r102);

    NovaTitleBarEx gU();

    boolean i0();

    void i50(String r100, String r101, List<Message> r102, @CollectionType int r103, JSONObject r104, Function2<? super Boolean, ? super String, Unit> r105);

    MessageCollection lA();
}

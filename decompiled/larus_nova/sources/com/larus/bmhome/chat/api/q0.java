package com.larus.bmhome.chat.api;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.utils.u2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageContentType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "do not use message adapter directly")
public interface q0 extends wq8.b {

    public interface a {
        maa.e C9();

        com.larus.bmhome.instruction.g D9();

        com.larus.bmhome.chat.component.trace.z E9();

        LifecycleCoroutineScope F9();

        com.larus.bmhome.chat.component.showcase.x G9();

        qd8.b H9();

        va8.k I9();

        IChatMessageShareAbility J9();

        ld8.n K9();

        com.larus.bmhome.chat.component.showcase.y L9();

        ry8.b M9();

        com.larus.bmhome.chat.component.bottom.reference.a N9();

        SwipingControlVm O9();

        zb8.e P8();

        zd8.b P9();

        xa8.d Z8();

        com.larus.bmhome.chat.component.push.a a9();

        q0 e();

        gd8.g h2();

        com.larus.bmhome.chat.component.collection.o i2();

        com.larus.bmhome.chat.component.bottom.multimodal.g r5();

        com.larus.bmhome.chat.component.regen.a s5();

        com.larus.bmhome.chat.component.cvs.y u0();

        u7 u3();

        ICoreInputAbility v0();

        va8.o w0();
    }

    h0 A7();

    ChatMessageList B7();

    Message C7(Message r100);

    List<wq8.a> D7();

    l0 D9();

    LruSet<String> E7();

    @Deprecated(message = "DO NOT USE")
    MessageAdapter F7();

    u2 G7();

    nq9.e H7();

    Integer I7();

    ComponentFeature J7();

    Function4<q0, Message, Integer, Boolean, Unit> K7();

    MessageAdapter L7();

    n0 M7();

    i0 N7();

    o0 P7();

    k0 Q7();

    void R7(String r100);

    g0 a9();

    ChatParam getChatParam();

    Function0<Fragment> getHostFragment();

    a getProvider();

    m0 i2();

    boolean l3(String r100, @MessageContentType Integer r101);

    f0 s5();

    boolean x7(String r100, @MessageContentType int r101);

    j0 y7();

    p0 z7();
}

package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chatbase.i;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import q3b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements i<MessageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<MessageListPinExtraLoader> f413351a;

    public e(g r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f413351a = r100;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        MessageListPinExtraLoader r102 = this.f413351a.invoke();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f413355b == false) goto L11;
        BuildersKt.runBlocking$default(null, new MessageUniversalPinExtraDecorator$decorate$1(this, r101, null), 1, null);
        return;
    }

    public static final Object b(e r100, Map r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MessageUniversalPinExtraDecorator$patchPinExtra$1) == false) goto L7;
        MessageUniversalPinExtraDecorator$patchPinExtra$1 r103 = (MessageUniversalPinExtraDecorator$patchPinExtra$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (Map) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L26:
        Map r108 = (Map) r105;
        if ((!r108.isEmpty()) == false) goto L35;
        Iterator r109 = r101.entrySet().iterator();
    L30:
        if (r109.hasNext() == false) goto L35;
        Map.Entry r110 = (Map.Entry) r109.next();
        Long r111 = StringsKt.toLongOrNull((String) r110.getKey());
        if (r111 == null) goto L30;
        ((MessageInfo) r110.getValue()).setUniversalPinExtra((UniversalPinExtra) r108.get(Boxing.boxLong(r111.longValue())));
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MessageListPinExtraLoader r112 = r100.f413351a.invoke();
        if (r112 == null) goto L46;
        Set r113 = r101.keySet();
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L19:
        if (r115.hasNext() == false) goto L23;
        Long r116 = StringsKt.toLongOrNull((String) r115.next());
        if (r116 == null) goto L19;
        r114.add(r116);
        goto L19
    L23:
        ArrayList r117 = new ArrayList(r114);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r112.e(r117, r103);
        if (r105 != r106) goto L26;
        return r106;
    L46:
        return Unit.INSTANCE;
    L7:
        r103 = new MessageUniversalPinExtraDecorator$patchPinExtra$1(r100, r102);
        goto L8
    }
}

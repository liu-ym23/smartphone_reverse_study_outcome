package com.larus.im.internal.core.conversation.bot;

import com.larus.im.bean.IMMsgExt;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.database.delegate.BotDaoSource;
import com.larus.im.internal.database.entity.BotEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.service.BotChangeType;
import com.larus.im.service.y;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class BotHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BotHandler f347542a = null;

    static {
        f347542a = new BotHandler();
    }

    public BotHandler() {
    }

    public static void b(BotEntity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botEntity");
        com.larus.im.internal.database.utils.e.c(new BotHandler$saveBot$1(r101, r100, null));
        vt7.a<String, Set<y>> r102 = uc9.d.f549669a;
        uc9.d.a(d.c(r100), BotChangeType.ADD);
    }

    public final Object c(BotEntity r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof BotHandler$syncBot$1) == false) goto L7;
        BotHandler$syncBot$1 r102 = (BotHandler$syncBot$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        r100 = (BotEntity) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L34:
        vt7.a<String, Set<y>> r107 = uc9.d.f549669a;
        uc9.d.a(d.c(r100), BotChangeType.ADD);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
    L30:
        return Unit.INSTANCE;
    L17:
        r100 = (BotEntity) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        BotEntity r108 = (BotEntity) r104;
        if (r108 == null) goto L31;
        r102.L$0 = null;
        r102.label = 2;
        Object r109 = OmniDatabaseExtKt.e(new BotHandler$updateBot$2(r100, r108, null), r102);
        if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        r109 = Unit.INSTANCE;
    L27:
        if (r109 != r105) goto L30;
        return r105;
    L31:
        be9.a r110 = ae9.a.a();
        r102.L$0 = r100;
        r102.label = 3;
        if (((BotDaoSource) r110).d(r100, r102) != r105) goto L34;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        String r111 = r100.getBotId();
        be9.a r112 = ae9.a.a();
        r102.L$0 = r100;
        r102.label = 1;
        r104 = ((BotDaoSource) r112).j(r111, r102);
        if (r104 != r105) goto L21;
        return r105;
    L7:
        r102 = new BotHandler$syncBot$1(this, r101);
        goto L8
    }

    public final Object d(List<BotEntity> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof BotHandler$syncBots$1) == false) goto L7;
        BotHandler$syncBots$1 r102 = (BotHandler$syncBots$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator r107 = (Iterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L16:
        if (r107.hasNext() == false) goto L21;
        BotEntity r108 = (BotEntity) r107.next();
        BotHandler r109 = f347542a;
        r102.L$0 = r107;
        r102.label = 1;
        if (r109.c(r108, r102) != r105) goto L16;
        return r105;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r107 = r100.iterator();
    L7:
        r102 = new BotHandler$syncBots$1(this, r101);
        goto L8
    }

    public final Object a(String r710, IIMError r810, Continuation<? super Unit> r811) {
        String r100 = r710;
        if ((r811 instanceof BotHandler$onUpdateBotStatus$1) == false) goto L7;
        BotHandler$onUpdateBotStatus$1 r101 = (BotHandler$onUpdateBotStatus$1) r811;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L53:
        BotEntity r106 = (BotEntity) r103;
        if (r106 != null) goto L57;
        com.larus.im.internal.delegate.a.f348188b.e("BotHandler", "update bot local bot is null");
        return Unit.INSTANCE;
    L57:
        vt7.a<String, Set<y>> r107 = uc9.d.f549669a;
        uc9.d.a(d.c(r106), BotChangeType.UPDATE);
    L59:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L47:
        if (((Boolean) r103).booleanValue() == false) goto L49;
        be9.a r108 = ae9.a.a();
        r101.L$0 = null;
        r101.label = 3;
        r103 = ((BotDaoSource) r108).j(r100, r101);
        if (r103 != r104) goto L53;
        return r104;
    L49:
        return Unit.INSTANCE;
    L17:
        int r109 = r101.I$0;
        String r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r111 = r109;
        r100 = r110;
        Object r112 = r103;
    L39:
        BotEntity r113 = (BotEntity) r112;
        if (r113 == null) goto L42;
        BotEntity r114 = BotEntity.copy$default(r113, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, Boxing.boxInt(r111), null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16385, -1, null);
        be9.a r115 = ae9.a.a();
        r101.L$0 = r100;
        r101.label = 2;
        r103 = ((BotDaoSource) r115).e(r114, r113, r101);
        if (r103 != r104) goto L47;
        return r104;
    L42:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L21;
        long r116 = r810.getCode();
        if (r116 != IMMsgExt.ERR_BOT_DELETE) goto L26;
        r111 = -10;
    L35:
        if (r111 == 0) goto L59;
        be9.a r117 = ae9.a.a();
        r101.L$0 = r100;
        r101.I$0 = r111;
        r101.label = 1;
        r112 = ((BotDaoSource) r117).j(r100, r101);
        if (r112 != r104) goto L39;
        return r104;
    L26:
        if (r116 != IMMsgExt.ERR_BOT_BAN) goto L29;
        r111 = -30;
        goto L35
    L29:
        if (r116 != IMMsgExt.ERR_BOT_PRIVATE) goto L32;
        r111 = -40;
        goto L35
    L32:
        if (r116 != IMMsgExt.ERR_BOT_REVIEWING) goto L34;
        r111 = -20;
        goto L35
    L34:
        r111 = 0;
        goto L35
    L21:
        return Unit.INSTANCE;
    L7:
        r101 = new BotHandler$onUpdateBotStatus$1(this, r811);
        goto L8
    }
}

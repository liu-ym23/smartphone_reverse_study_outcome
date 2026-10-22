package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes25.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, BotModel> f303579a;

    public static final class a {
    }

    static {
    }

    public a3() {
        this.f303579a = new HashMap();
    }

    public final Object a(String r110, com.larus.bmhome.chat.list.cell.prompt.t0 r111, Continuation r112) {
        if ((r112 instanceof SuggestPromptBotsCreator$requireBot$1) == false) goto L7;
        SuggestPromptBotsCreator$requireBot$1 r100 = (SuggestPromptBotsCreator$requireBot$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SuggestPromptBotsCreator$requireBot$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        Function3 r114 = (Function3) r102.L$1;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L14
        Function3 r115 = r114;
    L26:
        BotModel r116 = (BotModel) r113;     // Catch: Exception -> L14
        if (r116 == null) goto L29;
        this.f303579a.put(r110, r116);     // Catch: Exception -> L14
        r115.invoke(r116, Boxing.boxBoolean(true), "success");     // Catch: Exception -> L14
    L33:
        return Unit.INSTANCE;
    L29:
        r115.invoke(null, Boxing.boxBoolean(false), "bot model is null");     // Catch: Exception -> L14
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        if (this.f303579a.get(r110) == null) goto L23;
        r111.invoke(this.f303579a.get(r110), Boxing.boxBoolean(true), "cache success");     // Catch: Exception -> L14
        return Unit.INSTANCE;
    L23:
        IBotRepoService r105 = zh8.a.f572200e;     // Catch: Exception -> L14
        r102.L$0 = r110;     // Catch: Exception -> L14
        r102.L$1 = r111;     // Catch: Exception -> L14
        r102.label = 1;     // Catch: Exception -> L14
        r113 = IBotRepoService.b.a(r105, r110, true, "default", false, r102, 16);     // Catch: Exception -> L14
        r115 = r111;
        if (r113 != r103) goto L26;
        return r103;
    L14:
        e = move-exception;
        r111.invoke(null, Boxing.boxBoolean(false), "error >>> " + e);
    L7:
        r100 = new SuggestPromptBotsCreator$requireBot$1(this, r112);
        goto L8
    }
}

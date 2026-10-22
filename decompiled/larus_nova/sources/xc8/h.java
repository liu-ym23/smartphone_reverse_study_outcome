package xc8;

import android.content.Context;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public class h extends com.larus.bmhome.chat.layout.item.i {
    public h(Context r100) {
        super(r100);
    }

    public static String m(BotModel r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = r100.getBotType();
    L6:
        if (r102 != null) goto L9;
    L11:
        if (r102 != null) goto L14;
    L22:
        return "other_default";
    L14:
        if (r102.intValue() != 0) goto L22;
        BotCreatorInfo r103 = r100.getBotCreatorInfo();
        if (r103 == null) goto L19;
        r101 = r103.getId();
    L19:
        if (Intrinsics.areEqual(r101, AccountService.f365697a.getUserId()) == false) goto L21;
        return "self_created";
    L21:
        return "others_created";
    L9:
        if (r102.intValue() != 1) goto L11;
        return "default";
    L5:
        r102 = null;
        goto L6
    }
}

package com.larus.bmhome.chat.component.push;

import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.OpenPushReminderScene;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.push.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes25.dex */
    public static final class C4049a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r100, OpenPushReminderScene r101, e r110, BotModel r111, Map r112, Function1 r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            e r102 = null;
        L7:
            if ((r114 & 4) == 0) goto L9;
            BotModel r103 = null;
        L11:
            if ((r114 & 8) == 0) goto L13;
            Map r104 = null;
        L15:
            if ((r114 & 16) == 0) goto L17;
            Function1 r105 = null;
        L18:
            r100.dK(r101, r102, r103, r104, r105);
            return;
        L17:
            r105 = r113;
            goto L18
        L13:
            r104 = r112;
            goto L15
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    void HX(OpenPushReminderScene r100, e r101, String r102, Map<String, ? extends Object> r103, Function1<? super Boolean, Unit> r104);

    void dK(OpenPushReminderScene r100, e r101, BotModel r102, Map<String, ? extends Object> r103, Function1<? super Boolean, Unit> r104);
}

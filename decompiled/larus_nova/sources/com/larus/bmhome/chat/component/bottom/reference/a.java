package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;

/* JADX INFO: loaded from: classes25.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.a$a, reason: collision with other inner class name */
    public static final class C4041a {
        public static /* synthetic */ void a(a r100, Message r101, Integer r110, String r111, boolean r112, RefEntranceType r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            String r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            boolean r103 = true;
        L11:
            if ((r114 & 16) == 0) goto L13;
            RefEntranceType r104 = null;
        L14:
            r100.Vu(r101, r110, r102, r103, r104);
            return;
        L13:
            r104 = r113;
            goto L14
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }
    }

    void CN(Message r100);

    void Dk(String r100);

    void Ek(boolean r100);

    boolean GD();

    void L60(String r100, boolean r101);

    boolean LX();

    void NR();

    void OW(BotModel r100);

    boolean Qj();

    ReferenceInfo T6();

    String TL();

    boolean VM();

    void Vu(Message r100, Integer r101, String r102, boolean r103, RefEntranceType r104);

    boolean i9();

    void mE();

    void sZ();

    String vS();

    String wf();

    void xo(Message r100, boolean r101);
}

package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public interface IChatMessageShareAbility extends t1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "UN_KNOW", "SHARE", "COLLECT", "DELETE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType COLLECT = null;
        public static final ActionType DELETE = null;
        public static final ActionType SHARE = null;
        public static final ActionType UN_KNOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f301530a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f301531b = null;

        public static EnumEntries<ActionType> getEntries() {
            return f301531b;
        }

        static {
            ActionType r100 = new ActionType("UN_KNOW", 0);
            UN_KNOW = r100;
            ActionType r101 = new ActionType("SHARE", 1);
            SHARE = r101;
            ActionType r102 = new ActionType("COLLECT", 2);
            COLLECT = r102;
            ActionType r103 = new ActionType("DELETE", 3);
            DELETE = r103;
            ActionType[] r104 = {r100, r101, r102, r103};
            f301530a = r104;
            f301531b = EnumEntriesKt.enumEntries(r104);
        }

        public static ActionType[] values() {
            return (ActionType[]) f301530a.clone();
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    void A60(FlowCollector<? super rr8.a> r100);

    boolean H1();

    void S00(wq8.b r100);

    List<Message> Us(Message r100, List<Message> r101);

    NovaTitleBarEx VU();

    void cG(hca.e r100);

    void j();

    void kN(hca.e r100);

    boolean n8(Message r100);

    boolean yk(Message r100);

    void yt(ActionType r100, Message r101, List<Message> r102, Map<String, Object> r103);
}

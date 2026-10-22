package qg8;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.p;
import ic8.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f532877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, DeepThinkFoldStatus> f532878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f532879c;

    public b() {
    }

    static {
        f532877a = LazyKt.lazy(new a());
        f532878b = new HashMap();
    }

    public static Message b(MessageAdapter r100) {
        Object r101 = null;
        if (r100 == null) goto L30;
        List<xc8.b> r102 = r100.z2();
        if (r102 == null) goto L31;
        List<xc8.b> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r104.add(((wq8.a) r105.next()).getMessage());
        goto L8
    L10:
        Iterator r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        Message r108 = (Message) r107;
        boolean r109 = true;
        if (r108.getContentType() == 1) goto L19;
        if (r108.getContentType() == 9999) goto L19;
        r109 = false;
    L19:
        if (r109 == false) goto L12;
        r101 = r107;
    L22:
        return (Message) r101;
    L31:
        return null;
    L30:
        return null;
    }

    public static boolean h(Message r100) {
        Boolean r101 = com.larus.im.bean.message.a.T(r100);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L17;
        if (r103 == false) goto L17;
        if (d.f0(r100) == true) goto L17;
        if (com.larus.im.bean.message.a.m0(r100) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.q(r100), r102) == true) goto L8;
        r103 = false;
        goto L10
    }

    public static boolean e(Message r100, q0 r101) {
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L36;
        List<wq8.a> r102 = r101.D7();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.add(((wq8.a) r104.next()).getMessage());
        goto L6
    L8:
        Iterator r105 = r103.iterator();
    L9:
        String r106 = null;
        if (r105.hasNext() == false) goto L22;
        Object r107 = r105.next();
        Message r108 = (Message) r107;
        if (r108.getContentType() != 1) goto L14;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L9;
    L23:
        Message r110 = (Message) r107;
        if (r110 == null) goto L27;
        r106 = r110.getMessageId();
    L27:
        if (Intrinsics.areEqual(r106, r100.getMessageId()) == false) goto L37;
        return true;
    L37:
        return false;
    L14:
        if (r108.getContentType() == 2022) goto L19;
        if (r108.getContentType() == 9999) goto L19;
        r109 = false;
        goto L20
    L22:
        r107 = null;
        goto L23
    L36:
        return false;
    }

    public static void g(String r100, DeepThinkFoldStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "deepThinkFoldStatus");
        f532878b.put(r100, r101);
    }

    public static DeepThinkFoldStatus a(boolean r100, boolean r101, DeepThinkFoldStatus r102) {
        if (r102 == null) goto L4;
        return r102;
    L4:
        if (r100 == true) goto L9;
        if (r101 == false) goto L8;
        return DeepThinkFoldStatus.CompleteExpand;
    L8:
        return DeepThinkFoldStatus.CompleteFold;
    L9:
        if (r101 == false) goto L12;
        return DeepThinkFoldStatus.HalfFold;
    L12:
        if (((p) f532877a.getValue()).a() == false) goto L15;
        return DeepThinkFoldStatus.HalfFold;
    L15:
        return DeepThinkFoldStatus.CompleteFold;
    }

    public static DeepThinkFoldStatus d(Message r100, q0 r101, IChatMessageShareAbility r102, u7 r110, boolean r111) {
        boolean r103 = false;
        if (r100 == null) goto L5;
        boolean r104 = com.larus.im.bean.message.a.f0(r100);
    L7:
        if (r100 != null) goto L10;
        return a(r104, false, null);
    L10:
        if ((r110 instanceof va8.p) == false) goto L12;
        va8.p r105 = (va8.p) r110;
    L14:
        if (r105 != null) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r106 == true) goto L96;
        if (r111 == true) goto L97;
        String r112 = r100.getMessageId();
        if (r112 != null) goto L26;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == false) goto L31;
        Message r114 = r100;
    L32:
        if (r114 == null) goto L35;
        return DeepThinkFoldStatus.CompleteExpand;
    L35:
        if (com.larus.im.bean.message.a.m0(r100) == true) goto L37;
        Message r115 = r100;
    L38:
        if (r115 != null) goto L99;
        if (r102 != null) goto L42;
    L52:
        String r107 = r100.getMessageId();
        String r116 = "";
        if (r107 != null) goto L55;
        r107 = "";
    L55:
        HashMap<String, DeepThinkFoldStatus> r108 = f532878b;
        if (r108.containsKey(r107) == true) goto L58;
        DeepThinkFoldStatus r109 = null;
    L59:
        if (r109 == null) goto L62;
        return r109;
    L62:
        if (h(r100) == false) goto L64;
        Message r117 = r100;
    L65:
        if (r117 == null) goto L72;
        DeepThinkFoldStatus r118 = a(com.larus.im.bean.message.a.f0(r100), false, null);
        String r119 = r100.getMessageId();
        if (r119 == null) goto L70;
        r116 = r119;
    L70:
        g(r116, r118);
    L102:
        return r118;
    L72:
        if (r101 == null) goto L74;
        boolean r120 = e(r100, r101);
    L76:
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L84;
        if (r110 != null) goto L79;
    L81:
        boolean r121 = false;
    L82:
        if (r121 == false) goto L84;
        boolean r122 = true;
    L86:
        if (com.larus.im.bean.message.a.i(r100) == true) goto L90;
        if (r120 == true) goto L89;
        if (r122 == false) goto L90;
    L89:
        r103 = true;
    L90:
        r118 = a(r104, r103, null);
        String r123 = r100.getMessageId();
        if (r123 == null) goto L94;
        r116 = r123;
    L94:
        g(r116, r118);
        goto L102
    L79:
        if (r100.getLocalIndex() != r110.Mg()) goto L81;
        r121 = true;
    L84:
        r122 = false;
        goto L86
    L74:
        r120 = false;
        goto L76
    L64:
        r117 = null;
        goto L65
    L58:
        r109 = r108.get(r107);
        goto L59
    L42:
        if (r102.H1() == true) goto L44;
    L46:
        boolean r124 = false;
    L47:
        if (r124 == true) goto L50;
        r102 = null;
    L50:
        if (r102 == null) goto L52;
        return a(r104, false, null);
    L44:
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L46;
        r124 = true;
        goto L47
    L99:
        return DeepThinkFoldStatus.CompleteExpand;
    L37:
        r115 = null;
        goto L38
    L31:
        r114 = null;
        goto L32
    L26:
        if (StringsKt.startsWith$default(r112, "long_screenshot_", false, 2, null) != true) goto L28;
        r113 = true;
        goto L29
    L97:
        return DeepThinkFoldStatus.CompleteExpand;
    L96:
        return DeepThinkFoldStatus.CompleteExpand;
    L16:
        if (r105.Q80(r100.getMessageId()) != true) goto L18;
        r106 = true;
        goto L19
    L12:
        r105 = null;
        goto L14
    L5:
        r104 = false;
        goto L7
    }

    public static void f(Map.Entry r100, MessageAdapter r101, Message r102, boolean r103, Message r104, List r110) {
        String r105 = (String) r100.getKey();
        DeepThinkFoldStatus r106 = (DeepThinkFoldStatus) r100.getValue();
        if (q.b(r106) == true) goto L7;
        r106 = null;
    L7:
        if (r106 == null) goto L39;
        boolean r107 = true;
        if (r101 == null) goto L11;
        r101.x7(r105, 1);
    L11:
        if (r104 == null) goto L39;
        if (Intrinsics.areEqual(r104.getMessageId(), r105) == true) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L21;
        r104 = null;
    L21:
        if (r104 == null) goto L39;
        if (r101 == null) goto L25;
        int r109 = ((ArrayList) r101.getCurrentList()).indexOf(r104);
    L26:
        Integer r111 = Integer.valueOf(r109);
        if (r111.intValue() != (-1)) goto L30;
        r107 = false;
    L30:
        if (r107 == true) goto L33;
        r111 = null;
    L33:
        if (r111 == null) goto L39;
        int r112 = r111.intValue();
        if (r101 == null) goto L39;
        ChatMessageList r113 = r101.f297036u;
        if (r113 == null) goto L39;
        r113.scrollToPosition(r112);
        goto L39
    L25:
        r109 = -1;
        goto L26
    L15:
        if (com.larus.im.bean.message.a.f0(r104) == false) goto L17;
        r108 = true;
    L39:
        if (r102 == null) goto L41;
        String r114 = r102.getMessageId();
    L43:
        if (Intrinsics.areEqual(r105, r114) == false) goto L46;
        if (r103 == true) goto L46;
        g(r105, a(com.larus.im.bean.message.a.f0(r102), false, null));
        return;
    L46:
        ((ArrayList) r110).add(r105);
        return;
    L41:
        r114 = null;
        goto L43
    }

    public static DeepThinkFoldStatus c(Message r100, q0 r101, boolean r102, Long r110, boolean r111, DeepThinkFoldStatus r112, boolean r113) {
        boolean r103 = com.larus.im.bean.message.a.f0(r100);
        Message r104 = null;
        if (r101 == null) goto L7;
        q0.a r105 = r101.getProvider();
        if (r105 == null) goto L7;
        u7 r106 = r105.u3();
    L9:
        if ((r106 instanceof va8.p) == false) goto L11;
        va8.p r107 = (va8.p) r106;
    L12:
        boolean r108 = true;
        if (r107 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == true) goto L20;
        String r114 = r100.getMessageId();
        if (r114 != null) goto L24;
    L26:
        boolean r115 = false;
    L27:
        if (r115 == false) goto L29;
        Message r116 = r100;
    L30:
        if (r116 != null) goto L32;
        if (r113 == false) goto L37;
        return DeepThinkFoldStatus.CompleteExpand;
    L37:
        if (com.larus.im.bean.message.a.m0(r100) == true) goto L39;
        Message r117 = r100;
    L40:
        if (r117 == null) goto L44;
        if (r112 == null) goto L43;
        return r112;
    L43:
        return DeepThinkFoldStatus.CompleteExpand;
    L44:
        if (r102 == true) goto L46;
    L49:
        String r118 = "";
        if (r111 == true) goto L61;
        String r119 = r100.getMessageId();
        if (r119 != null) goto L54;
        r119 = "";
    L54:
        HashMap<String, DeepThinkFoldStatus> r120 = f532878b;
        if (r120.containsKey(r119) == true) goto L57;
        DeepThinkFoldStatus r121 = null;
    L58:
        if (r121 == null) goto L61;
        return r121;
    L57:
        r121 = r120.get(r119);
    L61:
        if (h(r100) == false) goto L63;
        r104 = r100;
    L63:
        if (r104 == null) goto L70;
        DeepThinkFoldStatus r122 = a(com.larus.im.bean.message.a.f0(r100), false, r112);
        String r123 = r100.getMessageId();
        if (r123 == null) goto L68;
        r118 = r123;
    L68:
        g(r118, r122);
        return r122;
    L70:
        if (r101 == null) goto L72;
        boolean r124 = e(r100, r101);
    L74:
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L81;
        long r125 = r100.getLocalIndex();
        if (r110 == null) goto L81;
        if (r125 != r110.longValue()) goto L81;
        boolean r126 = true;
    L83:
        if (com.larus.im.bean.message.a.i(r100) == true) goto L87;
        if (r124 == true) goto L88;
        if (r126 == false) goto L87;
    L88:
        DeepThinkFoldStatus r127 = a(r103, r108, r112);
        String r128 = r100.getMessageId();
        if (r128 == null) goto L92;
        r118 = r128;
    L92:
        g(r118, r127);
        return r127;
    L87:
        r108 = false;
    L81:
        r126 = false;
        goto L83
    L72:
        r124 = false;
        goto L74
    L46:
        if (com.larus.im.bean.message.a.f0(r100) == false) goto L49;
        return a(r103, false, null);
    L39:
        r117 = null;
        goto L40
    L32:
        return DeepThinkFoldStatus.CompleteExpand;
    L29:
        r116 = null;
        goto L30
    L24:
        if (StringsKt.startsWith$default(r114, "long_screenshot_", false, 2, null) != true) goto L26;
        r115 = true;
        goto L27
    L20:
        return DeepThinkFoldStatus.CompleteExpand;
    L15:
        if (r107.Q80(r100.getMessageId()) != true) goto L17;
        r109 = true;
        goto L18
    L11:
        r107 = null;
    L7:
        r106 = null;
        goto L9
    }
}

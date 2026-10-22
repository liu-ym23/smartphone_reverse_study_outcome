package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.j;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageVisibleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f414305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageVisibleHintPointParams f414306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f414307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Long> f414308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y6b.c<?> f414309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MessageVisibleManager$1$1 f414310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.a f414311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MessageVisibleEntity f414312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList<Pair<y6b.c<?>, Long>> f414313i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/MessageVisibleManager$CalculateExposeTimeScene;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE_LIST_UPDATE", "SCROLL_STATE_IDLE", "ON_START", "ON_STOP", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CalculateExposeTimeScene extends Enum<CalculateExposeTimeScene> {
        public static final CalculateExposeTimeScene MESSAGE_LIST_UPDATE = null;
        public static final CalculateExposeTimeScene ON_START = null;
        public static final CalculateExposeTimeScene ON_STOP = null;
        public static final CalculateExposeTimeScene SCROLL_STATE_IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CalculateExposeTimeScene[] f414315a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f414316b = null;

        public static EnumEntries<CalculateExposeTimeScene> getEntries() {
            return f414316b;
        }

        static {
            CalculateExposeTimeScene r100 = new CalculateExposeTimeScene("MESSAGE_LIST_UPDATE", 0);
            MESSAGE_LIST_UPDATE = r100;
            CalculateExposeTimeScene r101 = new CalculateExposeTimeScene("SCROLL_STATE_IDLE", 1);
            SCROLL_STATE_IDLE = r101;
            CalculateExposeTimeScene r102 = new CalculateExposeTimeScene("ON_START", 2);
            ON_START = r102;
            CalculateExposeTimeScene r103 = new CalculateExposeTimeScene("ON_STOP", 3);
            ON_STOP = r103;
            CalculateExposeTimeScene[] r104 = {r100, r101, r102, r103};
            f414315a = r104;
            f414316b = EnumEntriesKt.enumEntries(r104);
        }

        public static CalculateExposeTimeScene[] values() {
            return (CalculateExposeTimeScene[]) f414315a.clone();
        }

        public static CalculateExposeTimeScene valueOf(String r100) {
            return (CalculateExposeTimeScene) r27.a.a(CalculateExposeTimeScene.class, r100);
        }

        public CalculateExposeTimeScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(MessageVisibleEntity r100);

        void b(y6b.c<?> r100, MessageVisibleHintPointParams r101);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414317a = null;

        static {
            int[] r100 = new int[CalculateExposeTimeScene.values().length];
            r100[CalculateExposeTimeScene.ON_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f414317a = r100;
        }
    }

    static {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.a b() {
        com.ss.android.lark.chat.chatwindow.chat.a r100 = this.f414311g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        RecyclerView r101 = this.f414305a;
        if (r101 == null) goto L8;
        RecyclerView.Adapter r102 = r101.getAdapter();
    L10:
        if ((r102 instanceof ConcatAdapter) == false) goto L12;
        ConcatAdapter r103 = (ConcatAdapter) r102;
    L13:
        if (r103 == null) goto L15;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r104 = r103.getAdapters();
    L16:
        int r105 = 0;
        if (r104 == null) goto L19;
        int r106 = r104.size();
    L20:
        if (r105 >= r106) goto L29;
        if (r104 == null) goto L23;
        Object r107 = (RecyclerView.Adapter) ListProtector.get(r104, r105);
    L25:
        if ((r107 instanceof com.ss.android.lark.chat.chatwindow.chat.a) == true) goto L26;
        r105 = r105 + 1;
        goto L20
    L26:
        Log.i("MessageVisibleManager", "current adapter is IChatAdapter.");
        com.ss.android.lark.chat.chatwindow.chat.a r108 = (com.ss.android.lark.chat.chatwindow.chat.a) r107;
        this.f414311g = r108;
        return r108;
    L23:
        r107 = null;
        goto L25
    L29:
        return null;
    L19:
        r106 = 0;
        goto L20
    L15:
        r104 = null;
        goto L16
    L12:
        r103 = null;
        goto L13
    L8:
        r102 = null;
        goto L10
    }

    public final void a(CalculateExposeTimeScene r110) {
        Intrinsics.checkNotNullParameter(r110, "calculateExposeTimeScene");
        RecyclerView r100 = this.f414305a;
        if (r100 == null) goto L5;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
    L6:
        if (r101 != null) goto L8;
    L10:
        int r102 = -1;
        int r103 = -1;
    L11:
        com.ss.android.lark.chat.chatwindow.chat.a r104 = b();
        if (r104 == null) goto L16;
        List<y6b.c<?>> r105 = r104.h();
        if (r105 == null) goto L16;
        int r106 = r105.size();
    L18:
        if (this.f414312h != null) goto L20;
        this.f414312h = new MessageVisibleEntity();
    L20:
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L45;
        boolean r108 = true;
        if (c.f414317a[r110.ordinal()] != 1) goto L25;
        c(r107);
    L44:
        r107 = r107 + 1;
        goto L21
    L25:
        if (r102 > r107) goto L28;
        if (r107 > r103) goto L28;
    L29:
        if (r108 == false) goto L43;
        com.ss.android.lark.chat.chatwindow.chat.a r109 = b();
        if (r109 == null) goto L33;
        y6b.c<?> r111 = r109.getItem(r107);
    L34:
        this.f414309e = r111;
        if (r111 == null) goto L37;
        this.f414307c.b(r111, this.f414306b);
    L37:
        y6b.c<?> r112 = this.f414309e;
        if (r112 == null) goto L41;
        String r113 = r112.f566482c;
        if (r113 == null) goto L41;
    L42:
        long r114 = System.currentTimeMillis();
        this.f414308d.put(r113, Long.valueOf(r114));
        Log.i("MessageVisibleManager", "visibleMsgStartTimeStamp key: " + r113 + ", value: " + r114 + " ms.");
    L41:
        r113 = "";
        goto L42
    L33:
        r111 = null;
        goto L34
    L43:
        c(r107);
    L28:
        r108 = false;
        goto L29
    L45:
        MessageVisibleEntity r115 = this.f414312h;
        if (r115 == null) goto L48;
        r115.setMessageVisibleHintPointParams(this.f414306b);
    L48:
        this.f414307c.a(this.f414312h);
        LinkedList<Pair<y6b.c<?>, Long>> r116 = this.f414313i;
        if (r116 == null) goto L56;
        r116.clear();
        return;
    L56:
        return;
    L16:
        r106 = 0;
        goto L18
    L8:
        if ((r101 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r117 = (LinearLayoutManager) r101;
        r102 = r117.findFirstVisibleItemPosition();
        r103 = r117.findLastVisibleItemPosition();
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public final void c(int r100) {
        long r101 = System.currentTimeMillis();
        com.ss.android.lark.chat.chatwindow.chat.a r102 = b();
        if (r102 == null) goto L5;
        y6b.c<?> r103 = r102.getItem(r100);
    L6:
        HashMap<String, Long> r104 = this.f414308d;
        if (r103 == null) goto L10;
        String r105 = r103.f566482c;
        if (r105 == null) goto L10;
    L11:
        Long r106 = r104.remove(r105);
        if (r106 == null) goto L36;
        if (r103 == null) goto L16;
        Message.Type r107 = r103.getType();
        if (r107 == null) goto L16;
    L17:
        MessageVisibleHintPointParams r108 = this.f414306b;
        if (r108 == null) goto L24;
        LinkedList<Message.Type> r109 = r108.getUnTrackedMessageTypes();
        if (r109 == null) goto L24;
        boolean r110 = r109.contains(r107);
        boolean r111 = true;
        if (r110 != true) goto L24;
    L25:
        if (r111 == false) goto L27;
        return;
    L27:
        long r112 = r101 - r106.longValue();
        Log.i("MessageVisibleManager", "pos: " + r100 + ", exposure time: " + r112 + " ms.");
        if (r103 == null) goto L37;
        Pair<y6b.c<?>, Long> r113 = TuplesKt.to(r103, Long.valueOf(r112));
        LinkedList<Pair<y6b.c<?>, Long>> r114 = this.f414313i;
        if (r114 == null) goto L32;
        r114.add(r113);
    L32:
        MessageVisibleEntity r115 = this.f414312h;
        if (r115 == null) goto L38;
        r115.setVisibleMessageWithDurationPairs(this.f414313i);
        return;
    L38:
        return;
    L37:
        return;
    L24:
        r111 = false;
    L16:
        r107 = Message.Type.UNKNOWN;
        goto L17
    L36:
        return;
    L10:
        r105 = "";
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager$1$1, java.lang.Object] */
    public MessageVisibleManager(SceneCoordinateRecyclerView r100, MessageVisibleHintPointParams r101, j r102) {
        Intrinsics.checkNotNullParameter(r102, "mMessageVisibleWatcher");
        this.f414305a = r100;
        this.f414306b = r101;
        this.f414307c = r102;
        this.f414308d = new HashMap();
        this.f414313i = new LinkedList();
        if (r100 != 0) goto L6;
        Log.e("MessageVisibleManager", "recyclerView list is null.");
    L6:
        if ((r100 instanceof SceneCoordinateRecyclerView) == false) goto L8;
        SceneCoordinateRecyclerView r103 = r100;
    L9:
        if (r103 == null) goto L12;
        a(CalculateExposeTimeScene.MESSAGE_LIST_UPDATE);
        ?? r104 = new MessageVisibleManager$1$1(this);
        this.f414310f = r104;
        r103.setViewLifecycleInterface(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.a(this, r103));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
        r100.addOnScrollListener(r104);
        return;
    L12:
        return;
    L8:
        r103 = null;
        goto L9
    }
}

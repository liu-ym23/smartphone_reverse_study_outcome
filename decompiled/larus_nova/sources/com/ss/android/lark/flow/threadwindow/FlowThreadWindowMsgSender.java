package com.ss.android.lark.flow.threadwindow;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowMsgSender extends j4b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f424201n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f424202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f424203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f424204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<c> f424205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f424206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p f424207m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowMsgSender$MsgType;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "POST", "IMAGE", "FILE", "VIDEO", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MsgType extends Enum<MsgType> {
        public static final MsgType FILE = null;
        public static final MsgType IMAGE = null;
        public static final MsgType POST = null;
        public static final MsgType TEXT = null;
        public static final MsgType VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MsgType[] f424208a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f424209b = null;

        public static EnumEntries<MsgType> getEntries() {
            return f424209b;
        }

        static {
            MsgType r100 = new MsgType(CardAdapter.TEXT, 0);
            TEXT = r100;
            MsgType r101 = new MsgType("POST", 1);
            POST = r101;
            MsgType r102 = new MsgType("IMAGE", 2);
            IMAGE = r102;
            MsgType r103 = new MsgType("FILE", 3);
            FILE = r103;
            MsgType r104 = new MsgType("VIDEO", 4);
            VIDEO = r104;
            MsgType[] r105 = {r100, r101, r102, r103, r104};
            f424208a = r105;
            f424209b = EnumEntriesKt.enumEntries(r105);
        }

        public static MsgType[] values() {
            return (MsgType[]) f424208a.clone();
        }

        public static MsgType valueOf(String r100) {
            return (MsgType) r27.a.a(MsgType.class, r100);
        }

        public MsgType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void b(String r100, Message r101);
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MsgType f424210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m5b.d f424211b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f424210a == r101.f424210a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f424211b, r101.f424211b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f424210a.hashCode() * 31;
            m5b.d r101 = this.f424211b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingItem(type=" + this.f424210a + ", sendInfo=" + this.f424211b + ')';
        }

        public final MsgType getType() {
            return this.f424210a;
        }

        public c(MsgType r100, m5b.d r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f424210a = r100;
            this.f424211b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424212a = null;

        static {
            int[] r100 = new int[MsgType.values().length];
            r100[MsgType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[MsgType.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[MsgType.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MsgType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[MsgType.VIDEO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f424212a = r100;
        }
    }

    static {
    }

    @Override // j4b.a, m5b.b
    public final void g(m5b.d r100) {
        MsgType r101 = MsgType.TEXT;
        if (this.f424204j != null) goto L5;
        this.f424204j = new c(r101, r100);
    L7:
        if (this.f424206l == true) goto L11;
        this.f424206l = true;
        this.f424203i.post(this.f424207m);
        return;
    L11:
        return;
    L5:
        List<c> r102 = this.f424205k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
        goto L7
    }

    @Override // j4b.a, m5b.b
    public final void j(m5b.d r100) {
        MsgType r101 = MsgType.IMAGE;
        List<c> r102 = this.f424205k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
        if (this.f424206l == true) goto L7;
        this.f424206l = true;
        this.f424203i.post(this.f424207m);
        return;
    }

    @Override // j4b.a, m5b.b
    public final void l(m5b.d r100) {
        MsgType r101 = MsgType.POST;
        if (this.f424204j != null) goto L5;
        this.f424204j = new c(r101, r100);
    L7:
        if (this.f424206l == true) goto L11;
        this.f424206l = true;
        this.f424203i.post(this.f424207m);
        return;
    L11:
        return;
    L5:
        List<c> r102 = this.f424205k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
        goto L7
    }

    @Override // j4b.a, m5b.b
    public final void n(m5b.d r100) {
        MsgType r101 = MsgType.FILE;
        List<c> r102 = this.f424205k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
        if (this.f424206l == true) goto L7;
        this.f424206l = true;
        this.f424203i.post(this.f424207m);
        return;
    }

    @Override // j4b.a, m5b.b
    public final void p(m5b.d r100) {
        MsgType r101 = MsgType.VIDEO;
        List<c> r102 = this.f424205k;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
        if (this.f424206l == true) goto L7;
        this.f424206l = true;
        this.f424203i.post(this.f424207m);
        return;
    }

    public final void y(c r100) {
        MsgType r101 = r100.getType();
        int r102 = d.f424212a[r101.ordinal()];
        if (r102 != 1) goto L5;
        super.g(r100.f424211b);
        return;
    L5:
        if (r102 != 2) goto L7;
        super.l(r100.f424211b);
        return;
    L7:
        if (r102 != 3) goto L9;
        super.j(r100.f424211b);
        return;
    L9:
        if (r102 != 4) goto L11;
        super.n(r100.f424211b);
        return;
    L11:
        if (r102 != 5) goto L14;
        super.p(r100.f424211b);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void z(final c r110, final long r111, boolean r112, final Function2<? super String, ? super Message, Unit> r113) {
        m5b.d r100 = r110.f424211b;
        if (r100 == null) goto L7;
        m5b.e r101 = r100.f512222e;
        if (r101 == null) goto L7;
        r101.f512226d = Long.valueOf(r111);
        r101.f512227e = Boolean.valueOf(r112);
    L7:
        m5b.d r114 = r110.f424211b;
        String r102 = null;
        if (r114 == null) goto L12;
        m5b.e r115 = r114.f512222e;
        if (r115 == null) goto L12;
        String r116 = r115.f512230h;
    L13:
        final String r103 = q.a(r116);
        m5b.d r117 = r110.f424211b;
        if (r117 == null) goto L18;
        m5b.e r118 = r117.f512222e;
        if (r118 == null) goto L18;
        r102 = r118.f512231i;
    L18:
        final String r104 = q.a(r102);
        s(new FlowThreadWindowMsgSender$sendRoot$rootListener$1(r111, r113, r110, r103, r104, this));
        y(r110);
        return;
    L12:
        r116 = null;
        goto L13
    }

    public FlowThreadWindowMsgSender(com.ss.android.lark.im.sdk.service.h r100, com.ss.android.lark.im.sdk.service.p r101, IChatService r102, FlowThreadWindowFragment$initComponents$4.AnonymousClass1 r103, FlowThreadWindowFragment$initComponents$4$1$messageSender$2.a r104) {
        Intrinsics.checkNotNullParameter(r100, "chatterService");
        Intrinsics.checkNotNullParameter(r101, "messageService");
        Intrinsics.checkNotNullParameter(r102, "legacyChatService");
        Intrinsics.checkNotNullParameter(r103, "listener");
        Intrinsics.checkNotNullParameter(r104, "callback");
        super(r100, r101, r102, r103);
        this.f424202h = r104;
        this.f424203i = new Handler(Looper.getMainLooper());
        this.f424205k = new ArrayList();
        this.f424207m = new p(this);
    }
}

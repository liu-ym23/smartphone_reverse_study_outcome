package com.larus.bmhome.chat.stop;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class PendingAppletActionCancellation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PendingAppletActionCancellation f309941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<c> f309942b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f309943c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f309944d;

    public interface a {
        void a(b r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f309945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f309946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f309947c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309945a, r101.f309945a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309946b, r101.f309946b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f309947c, r101.f309947c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f309945a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f309946b.hashCode()) * 31;
            String r104 = this.f309947c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StoppedRound(conversationId=" + this.f309945a + ", messageIds=" + this.f309946b + ", scene=" + this.f309947c + ')';
        }

        public b(String r100, Set<String> r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "messageIds");
            this.f309945a = r100;
            this.f309946b = r101;
            this.f309947c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f309948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f309949b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f309948a, r101.f309948a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309949b, r101.f309949b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f309948a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f309949b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "StoppedRoundRecord(conversationId=" + this.f309948a + ", messageIds=" + this.f309949b + ')';
        }

        public c(String r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r101, "messageIds");
            this.f309948a = r100;
            this.f309949b = r101;
        }
    }

    public PendingAppletActionCancellation() {
    }

    static {
        f309941a = new PendingAppletActionCancellation();
        f309942b = new ArrayList();
        f309943c = new CopyOnWriteArraySet();
    }

    public static boolean b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (f309944d == true) goto L5;
        return false;
    L5:
        List r101 = CollectionsKt.listOf(new String[]{r100.getMessageId(), r100.getLocalMessageId()});
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        String r104 = e((String) r103.next());
        if (r104 == null) goto L7;
        r102.add(r104);
        goto L7
    L11:
        Set r105 = CollectionsKt.toSet(r102);
        if (r105.isEmpty() == false) goto L15;
        return false;
    L15:
        return d(r105, e(r100.getConversationId()));
    }

    public static String e(String r100) {
        if (r100 == null) goto L15;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L15;
        boolean r102 = false;
        if (r101.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
    L13:
        if (r102 == false) goto L15;
        return r101;
    L11:
        if (Intrinsics.areEqual(r101, "null") == true) goto L13;
        r102 = true;
        goto L13
    L8:
        r103 = false;
    L15:
        return null;
    }

    public static boolean d(Set r100, String r101) {
        List<c> r102 = f309942b;
        monitor-enter(r102);
        boolean r103 = false;
        if (((ArrayList) r102).isEmpty() == true) goto L35;
        Iterator r104 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L37
    L8:
        if (r104.hasNext() == false) goto L35;
        c r105 = (c) r104.next();     // Catch: Throwable -> L37
        Set<String> r106 = r105.f309949b;     // Catch: Throwable -> L37
        if ((r106 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L37
    L17:
        if (r107.hasNext() == false) goto L21;
        if (r100.contains((String) r107.next()) == false) goto L17;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L32;
        PendingAppletActionCancellation r109 = f309941a;     // Catch: Throwable -> L37
        String r110 = r105.f309948a;     // Catch: Throwable -> L37
        r109.getClass();     // Catch: Throwable -> L37
        if (r110 == null) goto L29;
        if (r101 == null) goto L29;
        boolean r111 = Intrinsics.areEqual(r110, r101);     // Catch: Throwable -> L37
    L30:
        if (r111 == false) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == false) goto L8;
        r103 = true;
    L29:
        r111 = true;
    L32:
        r112 = false;
    L21:
        r108 = false;
        goto L22
    L13:
        if (r106.isEmpty() == false) goto L15;
    L35:
        monitor-exit(r102);
        return r103;
    L37:
        th = move-exception;
        throw th;
    }

    public final void a(com.larus.bmhome.chat.stop.a r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        List<Message> r100 = com.larus.bmhome.chat.stop.b.c(r110);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (b0.f((Message) r103) == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        String r104 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.plus(r101, r110.f309951b)), new f()));
        Set r112 = SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(CollectionsKt.plus(r101, r110.f309951b)), new g()), new PendingAppletActionCancellation$cancel$messageIds$2(this)));
        if (r112.isEmpty() == false) goto L11;
        return;
    L11:
        List<c> r105 = f309942b;
        monitor-enter(r105);
        Iterator r106 = ((ArrayList) r105).iterator();     // Catch: Throwable -> L67
        int r107 = 0;
    L15:
        if (r106.hasNext() == false) goto L41;
        c r108 = (c) r106.next();     // Catch: Throwable -> L67
        Set<String> r109 = r108.f309949b;     // Catch: Throwable -> L67
        if ((r109 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r113 = r109.iterator();     // Catch: Throwable -> L67
    L23:
        if (r113.hasNext() == false) goto L27;
        if (r112.contains((String) r113.next()) == false) goto L23;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L37;
        PendingAppletActionCancellation r115 = f309941a;     // Catch: Throwable -> L67
        String r116 = r108.f309948a;     // Catch: Throwable -> L67
        r115.getClass();     // Catch: Throwable -> L67
        if (r116 == null) goto L34;
        if (r104 == null) goto L34;
        boolean r117 = Intrinsics.areEqual(r116, r104);     // Catch: Throwable -> L67
    L35:
        if (r117 == false) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == true) goto L42;
        r107 = r107 + 1;     // Catch: Throwable -> L67
    L42:
        if (r107 < 0) goto L48;
        c r119 = (c) ((ArrayList) f309942b).remove(r107);     // Catch: Throwable -> L67
        String r120 = r119.f309948a;     // Catch: Throwable -> L67
        if (r120 == null) goto L47;
        r104 = r120;
    L47:
        c r121 = new c(r104, SetsKt.plus(r119.f309949b, r112));     // Catch: Throwable -> L67
    L49:
        ((ArrayList) f309942b).add(r121);     // Catch: Throwable -> L67
    L50:
        List<c> r122 = f309942b;     // Catch: Throwable -> L67
        if (((ArrayList) r122).size() <= 64) goto L53;
        ((ArrayList) r122).remove(0);     // Catch: Throwable -> L67
        goto L50
    L53:
        f309944d = true;     // Catch: Throwable -> L67
        monitor-exit(r105);
        b r123 = new b(r121.f309948a, r121.f309949b, r111);
        CopyOnWriteArraySet<a> r124 = f309943c;
        if (r124.isEmpty() == true) goto L66;
        Iterator<a> r125 = r124.iterator();
    L60:
        if (r125.hasNext() == false) goto L89;
        r125.next().a(r123);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        FLogger.f375446a.e("PendingAppletStop", "round stop revoker failed, scene=" + r123.f309947c, th);
        goto L60
    L89:
        return;
    L66:
        return;
    L48:
        r121 = new c(r104, r112);     // Catch: Throwable -> L67
    L34:
        r117 = true;
    L37:
        r118 = false;
    L27:
        r114 = false;
        goto L28
    L19:
        if (r109.isEmpty() == false) goto L21;
    L41:
        r107 = -1;
    L67:
        th = move-exception;
        throw th;
    }

    public final boolean c(Message r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "reply");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        if (f309944d == true) goto L5;
        return false;
    L5:
        Set r102 = SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(CollectionsKt.listOf(new Message[]{r100, r101})), new e()), new PendingAppletActionCancellation$isCancelledRound$normalizedRoundIds$2(this)));
        if (r102.isEmpty() == false) goto L9;
        return false;
    L9:
        return d(r102, (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf(new String[]{r100.getConversationId(), r101.getConversationId()}), new PendingAppletActionCancellation$isCancelledRound$normalizedConversationId$1(this))));
    }
}

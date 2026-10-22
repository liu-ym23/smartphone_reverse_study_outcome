package com.ss.android.lark.newemoji.emoji_panel;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.newemoji.larkemoji.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.sequences.SequencesKt;
import qsb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class DefaultEmojiPanelData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f432955a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_panel/DefaultEmojiPanelData$Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "CUSTOM", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type CUSTOM = null;
        public static final a Companion = null;
        public static final Type DEFAULT = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f432956a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f432957b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f432957b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("DEFAULT", 1, 1);
            DEFAULT = r101;
            Type r102 = new Type("CUSTOM", 2, 2);
            CUSTOM = r102;
            Type[] r103 = {r100, r101, r102};
            f432956a = r103;
            f432957b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f432956a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Type f432958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f432959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f432960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Pair<String, String>> f432961d;

        /* JADX INFO: renamed from: com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData$a$a, reason: collision with other inner class name */
        public static final class RunnableC5148a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final RunnableC5148a f432962a = null;

            static {
                f432962a = new RunnableC5148a();
            }

            public RunnableC5148a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.b();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final List<String> a() {
            List<Pair<String, String>> r100 = this.f432961d;
            ArrayList r101 = new ArrayList();
            Iterator r102 = ((ArrayList) r100).iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Object r103 = r102.next();
            if ((!b.a().i7((String) ((Pair) r103).getFirst())) == false) goto L4;
            r101.add(r103);
            goto L4
        L8:
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r105 = r101.iterator();
        L10:
            if (r105.hasNext() == false) goto L12;
            r104.add((String) ((Pair) r105.next()).getFirst());
            goto L10
        L12:
            return r104;
        }

        public final List<com.ss.android.lark.newemoji.larkemoji.a> b() {
            List<Pair<String, String>> r100 = this.f432961d;
            ArrayList r101 = new ArrayList();
            Iterator r102 = ((ArrayList) r100).iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Pair r103 = (Pair) r102.next();
            ReentrantLock r104 = c.f433050a;
            com.ss.android.lark.newemoji.larkemoji.b r105 = c.d((String) r103.getFirst());
            if (r105 == null) goto L4;
            r101.add(r105);
            goto L4
        L8:
            return r101;
        }

        public final String toString() {
            return "EmojiGroupData(type=" + this.f432958a + ", iconKey='" + this.f432959b + "', title='" + this.f432960c + "', size=" + ((ArrayList) this.f432961d).size() + ')';
        }

        public a() {
            this.f432958a = Type.UNKNOWN;
            this.f432959b = "";
            this.f432960c = "";
            this.f432961d = new ArrayList();
        }

        public final Type getType() {
            return this.f432958a;
        }

        public final void c(List<Pair<String, String>> r100) {
            if (r100.isEmpty() == false) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            return;
        L8:
            ((ArrayList) this.f432961d).clear();
            ((ArrayList) this.f432961d).addAll(r100);
            Iterator r102 = ((ArrayList) this.f432961d).iterator();
        L10:
            if (r102.hasNext() == false) goto L15;
            Pair r103 = (Pair) r102.next();
            ReentrantLock r104 = c.f433050a;
            String r105 = (String) r103.getFirst();
            String r106 = (String) r103.getSecond();
            if (r106 != null) goto L14;
            r106 = (String) r103.getFirst();
        L14:
            c.f(r105, r106);
            goto L10
        L15:
            ThreadUtils.runOnUIThread(RunnableC5148a.f432962a);
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public final List<String> a() {
        List<a> r100 = this.f432955a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (((a) r103).getType() != Type.CUSTOM) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L12:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.map(CollectionsKt.asSequence(r101), DefaultEmojiPanelData$getCustomEmojiKeys$2.INSTANCE), DefaultEmojiPanelData$getCustomEmojiKeys$3.INSTANCE));
    }

    public final List<String> b() {
        List<a> r100 = this.f432955a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        List<a> r102 = this.f432955a;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();
        if (((a) r105).getType() != Type.DEFAULT) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L14;
        r103.add(r105);
        goto L14
    L18:
        r106 = false;
        goto L19
    L22:
        return ((a) ListProtector.get(r103, 0)).a();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean c() {
        Iterator<T> r100 = this.f432955a.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((a) r101).getType() != Type.CUSTOM) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        if (r101 != null) goto L21;
        return false;
    L21:
        return true;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final boolean d() {
        List<a> r100 = this.f432955a;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return false;
    }

    public final String toString() {
        return this.f432955a.toString();
    }

    public DefaultEmojiPanelData() {
        this.f432955a = new ArrayList();
    }
}

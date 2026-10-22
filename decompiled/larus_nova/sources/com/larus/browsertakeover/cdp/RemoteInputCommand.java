package com.larus.browsertakeover.cdp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class RemoteInputCommand {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/browsertakeover/cdp/RemoteInputCommand$Key;", "", "key", "", "code", "virtualKeyCode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getCode", "getVirtualKeyCode", "()I", "BACKSPACE", "TAB", "ENTER", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Key extends Enum<Key> {
        public static final Key BACKSPACE = null;
        public static final Key DELETE = null;
        public static final Key ENTER = null;
        public static final Key TAB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key[] f319453a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319454b = null;
        private final String code;
        private final String key;
        private final int virtualKeyCode;

        public static EnumEntries<Key> getEntries() {
            return f319454b;
        }

        static {
            Key r100 = new Key("BACKSPACE", 0, "Backspace", "Backspace", 8);
            BACKSPACE = r100;
            Key r101 = new Key("TAB", 1, "Tab", "Tab", 9);
            TAB = r101;
            Key r102 = new Key("ENTER", 2, "Enter", "Enter", 13);
            ENTER = r102;
            Key r103 = new Key("DELETE", 3, "Delete", "Delete", 46);
            DELETE = r103;
            Key[] r104 = {r100, r101, r102, r103};
            f319453a = r104;
            f319454b = EnumEntriesKt.enumEntries(r104);
        }

        public static Key[] values() {
            return (Key[]) f319453a.clone();
        }

        public final String getCode() {
            return this.code;
        }

        public final String getKey() {
            return this.key;
        }

        public final int getVirtualKeyCode() {
            return this.virtualKeyCode;
        }

        public static Key valueOf(String r100) {
            return (Key) r27.a.a(Key.class, r100);
        }

        public Key(String r100, int r101, String r102, String r103, int r104) {
            super(r100, r101);
            this.key = r102;
            this.code = r103;
            this.virtualKeyCode = r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/browsertakeover/cdp/RemoteInputCommand$Phase;", "", "cdpType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCdpType", "()Ljava/lang/String;", "DOWN", "UP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase DOWN = null;
        public static final Phase UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Phase[] f319455a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319456b = null;
        private final String cdpType;

        public static EnumEntries<Phase> getEntries() {
            return f319456b;
        }

        static {
            Phase r100 = new Phase("DOWN", 0, "keyDown");
            DOWN = r100;
            Phase r101 = new Phase("UP", 1, "keyUp");
            UP = r101;
            Phase[] r102 = {r100, r101};
            f319455a = r102;
            f319456b = EnumEntriesKt.enumEntries(r102);
        }

        public static Phase[] values() {
            return (Phase[]) f319455a.clone();
        }

        public final String getCdpType() {
            return this.cdpType;
        }

        public static Phase valueOf(String r100) {
            return (Phase) r27.a.a(Phase.class, r100);
        }

        public Phase(String r100, int r101, String r102) {
            super(r100, r101);
            this.cdpType = r102;
        }
    }

    public static final class a extends RemoteInputCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f319457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f319458b;

        public a(Function0<Unit> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f319457a = r100;
            this.f319458b = r101;
        }
    }

    public static final class b extends RemoteInputCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319459a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f319459a, ((b) r100).f319459a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f319459a.hashCode();
        }

        public final String toString() {
            return "InsertText(text=" + this.f319459a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f319459a = r100;
        }
    }

    public static final class c extends RemoteInputCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Key f319460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Phase f319461b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f319460a == r101.f319460a) goto L12;
            return false;
        L12:
            if (this.f319461b == r101.f319461b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f319460a.hashCode() * 31) + this.f319461b.hashCode();
        }

        public final String toString() {
            return "KeyEvent(key=" + this.f319460a + ", phase=" + this.f319461b + ')';
        }

        public c(Key r100, Phase r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "phase");
            this.f319460a = r100;
            this.f319461b = r101;
        }
    }

    public RemoteInputCommand() {
    }
}

package com.ss.android.lark.coremd.base.parse;

import android.text.Spannable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TextFutureRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f419526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f419527b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/coremd/base/parse/TextFutureRunner$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "FINISH", "FAILED", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State FAILED = null;
        public static final State FINISH = null;
        public static final State IDLE = null;
        public static final State RUNNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f419528a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f419529b = null;

        public static EnumEntries<State> getEntries() {
            return f419529b;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("RUNNING", 1);
            RUNNING = r101;
            State r102 = new State("FINISH", 2);
            FINISH = r102;
            State r103 = new State("FAILED", 3);
            FAILED = r103;
            State[] r104 = {r100, r101, r102, r103};
            f419528a = r104;
            f419529b = EnumEntriesKt.enumEntries(r104);
        }

        public static State[] values() {
            return (State[]) f419528a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final class a implements x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x.a f419530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextFutureRunner f419531b;

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void a() {
            TextFutureRunner r100 = this.f419531b;
            r100.f419527b = State.FAILED;
            this.f419530a.a();
        }

        public a(TextFutureRunner r100, com.ss.android.lark.coremd.impl.parse.n.a r101) {
            Intrinsics.checkNotNullParameter(r101, "handle");
            this.f419531b = r100;
            this.f419530a = r101;
        }

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void b(v7b.s r100, Spannable r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "text");
            TextFutureRunner r102 = this.f419531b;
            r102.f419527b = State.FINISH;
            this.f419530a.b(r100, r101);
        }
    }

    public TextFutureRunner(com.ss.android.lark.coremdbiz.facade.plugins.t r100) {
        Intrinsics.checkNotNullParameter(r100, "future");
        this.f419526a = r100;
        this.f419527b = State.IDLE;
    }
}

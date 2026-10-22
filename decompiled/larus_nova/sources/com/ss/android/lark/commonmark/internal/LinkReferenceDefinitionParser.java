package com.ss.android.lark.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import v7b.x;

/* JADX INFO: loaded from: classes35.dex */
public final class LinkReferenceDefinitionParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f417166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<w7b.f> f417167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<v7b.o> f417168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<x> f417169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuilder f417170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f417171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f417172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StringBuilder f417173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f417174i;

    public static final enum State extends Enum<State> {
        public static final State DESTINATION = null;
        public static final State LABEL = null;
        public static final State PARAGRAPH = null;
        public static final State START_DEFINITION = null;
        public static final State START_TITLE = null;
        public static final State TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f417175a = null;

        static {
            State r100 = new State("START_DEFINITION", 0);
            START_DEFINITION = r100;
            State r101 = new State("LABEL", 1);
            LABEL = r101;
            State r102 = new State("DESTINATION", 2);
            DESTINATION = r102;
            State r103 = new State("START_TITLE", 3);
            START_TITLE = r103;
            State r104 = new State("TITLE", 4);
            TITLE = r104;
            State r105 = new State("PARAGRAPH", 5);
            PARAGRAPH = r105;
            f417175a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State[] values() {
            return (State[]) f417175a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f417176a = null;

        static {
            int[] r100 = new int[State.values().length];
            f417176a = r100;
            r100[State.START_DEFINITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f417176a[State.LABEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f417176a[State.DESTINATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f417176a[State.START_TITLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f417176a[State.TITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final void a() {
        if (this.f417174i == true) goto L5;
        return;
    L5:
        String r100 = u7b.a.b(this.f417171f);
        StringBuilder r101 = this.f417173h;
        if (r101 == null) goto L8;
        String r102 = u7b.a.b(r101.toString());
    L9:
        v7b.o r103 = new v7b.o(this.f417170e.toString(), r100, r102);
        r103.n(this.f417169d);
        ((ArrayList) this.f417169d).clear();
        ((ArrayList) this.f417168c).add(r103);
        this.f417170e = null;
        this.f417174i = false;
        this.f417171f = null;
        this.f417173h = null;
        return;
    L8:
        r102 = null;
        goto L9
    }

    public LinkReferenceDefinitionParser() {
        this.f417166a = State.START_DEFINITION;
        this.f417167b = new ArrayList();
        this.f417168c = new ArrayList();
        this.f417169d = new ArrayList();
        this.f417174i = false;
    }
}

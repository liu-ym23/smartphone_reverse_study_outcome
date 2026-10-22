package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: loaded from: classes42.dex */
public final class LinkReferenceDefinitionParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f525651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f525652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<LinkReferenceDefinition> f525653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f525654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f525655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f525656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f525657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StringBuilder f525658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f525659i;

    public static final enum State extends Enum<State> {
        public static final State DESTINATION = null;
        public static final State LABEL = null;
        public static final State PARAGRAPH = null;
        public static final State START_DEFINITION = null;
        public static final State START_TITLE = null;
        public static final State TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f525660a = null;

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
            f525660a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State[] values() {
            return (State[]) f525660a.clone();
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
        public static final /* synthetic */ int[] f525661a = null;

        static {
            int[] r100 = new int[State.values().length];
            f525661a = r100;
            r100[State.PARAGRAPH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f525661a[State.START_DEFINITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f525661a[State.LABEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f525661a[State.DESTINATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f525661a[State.START_TITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f525661a[State.TITLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public final void a() {
        if (this.f525659i == true) goto L5;
        return;
    L5:
        String r100 = tvc.a.a(this.f525656f);
        StringBuilder r101 = this.f525658h;
        if (r101 == null) goto L8;
        String r102 = tvc.a.a(r101.toString());
    L9:
        ((ArrayList) this.f525653c).add(new LinkReferenceDefinition(this.f525655e, r100, r102));
        this.f525654d = null;
        this.f525659i = false;
        this.f525655e = null;
        this.f525656f = null;
        this.f525658h = null;
        return;
    L8:
        r102 = null;
        goto L9
    }

    public LinkReferenceDefinitionParser() {
        this.f525651a = State.START_DEFINITION;
        this.f525652b = new StringBuilder();
        this.f525653c = new ArrayList();
        this.f525659i = false;
    }
}

package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.log.Log;
import eab.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class InsertListStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext2.list.b f429144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditorListApplier f429145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public State f429146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpannableStringBuilder f429147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public char f429148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f429149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f429150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f429151h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/list/InsertListStateMachine$State;", "", "<init>", "(Ljava/lang/String;I)V", "None", "LineStart", "OLNumber", "ULSymbol", "OLDot", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State LineStart = null;
        public static final State None = null;
        public static final State OLDot = null;
        public static final State OLNumber = null;
        public static final State ULSymbol = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f429152a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429153b = null;

        public static EnumEntries<State> getEntries() {
            return f429153b;
        }

        static {
            State r100 = new State("None", 0);
            None = r100;
            State r101 = new State("LineStart", 1);
            LineStart = r101;
            State r102 = new State("OLNumber", 2);
            OLNumber = r102;
            State r103 = new State("ULSymbol", 3);
            ULSymbol = r103;
            State r104 = new State("OLDot", 4);
            OLDot = r104;
            State[] r105 = {r100, r101, r102, r103, r104};
            f429152a = r105;
            f429153b = EnumEntriesKt.enumEntries(r105);
        }

        public static State[] values() {
            return (State[]) f429152a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429154a = null;

        static {
            int[] r100 = new int[State.values().length];
            r100[State.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[State.LineStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[State.OLNumber.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[State.ULSymbol.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[State.OLDot.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f429154a = r100;
        }
    }

    static {
    }

    public final void e() {
        State r100 = this.f429146c;
        State r101 = State.None;
        if (r100 != r101) goto L5;
        return;
    L5:
        Log.d("InsertListStateMachine", "toStateNone");
        this.f429146c = r101;
        this.f429147d.clear();
        this.f429149f = -1;
        this.f429148e = 0;
    }

    public final void d(int r100) {
        this.f429146c = State.LineStart;
        this.f429147d.clear();
        this.f429149f = r100;
        this.f429148e = 0;
        Log.d("InsertListStateMachine", "toStateLineStart, start is " + r100);
    }

    public InsertListStateMachine(com.ss.android.lark.keyboard.edittext2.list.b r100, EditorListApplier r101) {
        Intrinsics.checkNotNullParameter(r100, "coordinator");
        Intrinsics.checkNotNullParameter(r101, "actionHandle");
        this.f429144a = r100;
        this.f429145b = r101;
        this.f429146c = State.None;
        this.f429147d = new SpannableStringBuilder();
        this.f429149f = -1;
        this.f429150g = -1;
        this.f429151h = -1;
    }

    public final void a(Editable r100, int r101, int r110) {
        com.ss.android.lark.coremd.impl.buildnode.a[] r102 = (com.ss.android.lark.coremd.impl.buildnode.a[]) r100.getSpans(0, r100.length(), com.ss.android.lark.coremd.impl.buildnode.a.class);
        Intrinsics.checkNotNull(r102);
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        if ((r102[r104].f419828a instanceof e) == true) goto L7;
        r104 = r104 + 1;
        goto L4
    L7:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L13;
        e();
        return;
    L13:
        int r106 = b.f429154a[this.f429146c.ordinal()];
        float r107 = 16.0f;
        if (r106 != 4) goto L16;
        com.ss.android.lark.keyboard.edittext2.list.b r108 = this.f429144a;
        y9b.c r109 = r108.f429160c.acquire();
        if (r109 != null) goto L37;
        r109 = new y9b.c();
    L37:
        y9b.b r111 = r109;
        r111.h(0);
        r111.f(0);
        Float r112 = r108.f429162e.f429163a;
        if (r112 == null) goto L40;
        r107 = r112.floatValue();
    L40:
        r111.f419934a.f419947j = UIUtils.dp2px(r108.f429158a, r107);
        Integer r113 = r108.f429162e.f429164b;
        if (r113 == null) goto L43;
        int r114 = r113.intValue();
    L44:
        r111.f419934a.f419944g = r114;
        r108.d(r111);
        boolean r115 = false;
    L45:
        int r116 = r110 - r101;
        Character r117 = StringsKt.getOrNull(r100, r110 - 1);
        if (r117 == null) goto L52;
        if (r117.charValue() != '\n') goto L52;
        r116 = r116 - 1;
    L52:
        if (r116 <= this.f429147d.length()) goto L54;
        String r118 = "";
    L55:
        int r119 = r110 - (this.f429147d.length() - r118.length());
        int r120 = this.f429149f;
        r100.replace(r120, this.f429147d.length() + r120, r118);
        r100.setSpan(r111, r101, r119, 33);
        if (r115 == false) goto L76;
        Object[] r121 = r100.getSpans(r119, r119, y9b.b.class);
        int r122 = r121.length;
        int r123 = 0;
    L58:
        if (r123 >= r122) goto L66;
        Object r124 = r121[r123];
        if (r100.getSpanStart((y9b.b) r124) != r119) goto L62;
        boolean r125 = true;
    L63:
        if (r125 == true) goto L67;
        r123 = r123 + 1;
    L67:
        y9b.b r126 = (y9b.b) r124;
        if (r126 == null) goto L70;
        r126.g(ListHeadType.None);
    L70:
        this.f429145b.h(r100);
        return;
    L62:
        r125 = false;
        goto L63
    L66:
        r124 = null;
        goto L67
    L76:
        return;
    L54:
        r118 = "\u200b";
        goto L55
    L43:
        r114 = r108.f429159b.f429168b;
        goto L44
    L16:
        if (r106 == 5) goto L19;
        e();
        return;
    L19:
        SpannableStringBuilder r127 = this.f429147d;
        String r128 = r127.subSequence(0, r127.length() - 2).toString();
        com.ss.android.lark.keyboard.edittext2.list.b r129 = this.f429144a;
        Integer r130 = StringsKt.toIntOrNull(r128);
        if (r130 == null) goto L22;
        int r131 = r130.intValue();
    L23:
        r111 = r129.f429161d.acquire();
        if (r111 != null) goto L26;
        r111 = new y9b.b();
    L26:
        r111.h(r131);
        r111.f(0);
        Float r132 = r129.f429162e.f429163a;
        if (r132 == null) goto L29;
        r107 = r132.floatValue();
    L29:
        r111.f419934a.f419947j = UIUtils.dp2px(r129.f429158a, r107);
        Integer r133 = r129.f429162e.f429164b;
        if (r133 == null) goto L32;
        int r134 = r133.intValue();
    L33:
        r111.f419934a.f419944g = r134;
        r129.d(r111);
        r111.g(ListHeadType.VirtualHead);
        r115 = true;
        goto L45
    L32:
        r134 = r129.f429159b.f429168b;
        goto L33
    L22:
        r131 = 1;
        goto L23
    L9:
        r105 = false;
        goto L10
    }

    public final void c(Editable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "s");
        if (this.f429150g == r101) goto L5;
    L7:
        this.f429150g = r101;
        this.f429151h = r102;
        Log.d("InsertListStateMachine", "selectionChange: start is " + r101 + ", end is " + r102);
        if (r101 == r102) goto L10;
    L37:
        e();
        return;
    L10:
        if (r101 == (-1)) goto L37;
        int r103 = 12;
        int r104 = r101;
    L14:
        if (r104 <= 0) goto L19;
        int r105 = r104 - 1;
        if (r100.charAt(r105) == '\n') goto L19;
        if (r103 < 0) goto L19;
        r103 = r103 - 1;
        r104 = r105;
    L19:
        boolean r106 = false;
        if (r104 != 0) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == true) goto L28;
    L35:
        e();
        return;
    L28:
        if (r100.getSpans(r104, r101, y9b.b.class).length != 0) goto L31;
        r106 = true;
    L31:
        if ((!r106) == true) goto L35;
        b(r100, r104, r101, true);
        return;
    L22:
        if (r100.charAt(r104 - 1) == '\n') goto L25;
        r107 = false;
        goto L26
    L5:
        if (this.f429151h != r102) goto L7;
    }

    public final void b(Editable r100, int r101, int r110, boolean r111) {
        if (r110 != r101) goto L5;
        d(r101);
        return;
    L5:
        State r102 = this.f429146c;
        int r103 = b.f429154a[r102.ordinal()];
        boolean r104 = true;
        if (r103 != 1) goto L8;
        d(r101);
        int r112 = r101;
    L95:
        if (r112 >= r110) goto L127;
        if (this.f429146c == State.None) goto L125;
        if (r112 >= r100.length()) goto L126;
        char r105 = r100.charAt(r112);
        this.f429147d.append(r105);
        this.f429148e = r105;
        r112 = r112 + 1;
        b(r100, r101, r112, false);
        goto L95
    L126:
        return;
    L125:
        return;
    L127:
        return;
    L8:
        if (r103 == 2) goto L66;
        if (r103 != 3) goto L12;
        char r106 = this.f429148e;
        if ('0' > r106) goto L49;
        if (r106 >= ':') goto L49;
    L50:
        if (r104 == false) goto L56;
        State r107 = this.f429146c;
        State r108 = State.OLNumber;
        if (r107 == r108) goto L121;
        Log.d("InsertListStateMachine", "toStateOLNumber");
        this.f429146c = r108;
        return;
    L121:
        return;
    L56:
        if (r106 != '.') goto L58;
    L61:
        State r109 = this.f429146c;
        State r113 = State.OLDot;
        if (r109 == r113) goto L122;
        Log.d("InsertListStateMachine", "toStateOLDot");
        this.f429146c = r113;
        return;
    L122:
        return;
    L58:
        if (r106 == 12290) goto L61;
        e();
        return;
    L49:
        r104 = false;
        goto L50
    L12:
        if (r103 == 4) goto L32;
        if (r103 != 5) goto L30;
        if (this.f429148e != ' ') goto L28;
        if (r111 == true) goto L19;
        e();
        return;
    L19:
        if (r110 >= r100.length()) goto L24;
        if (r100.charAt(r110) == '\n') goto L24;
        r110 = r110 + 1;
    L24:
        if (r110 >= r100.length()) goto L26;
        r110 = r110 + 1;
    L26:
        a(r100, r101, r110);
        return;
    L28:
        e();
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        if (this.f429148e != ' ') goto L44;
        if (r111 == true) goto L35;
        e();
        return;
    L35:
        if (r110 >= r100.length()) goto L40;
        if (r100.charAt(r110) == '\n') goto L40;
        r110 = r110 + 1;
    L40:
        if (r110 >= r100.length()) goto L42;
        r110 = r110 + 1;
    L42:
        a(r100, r101, r110);
        return;
    L44:
        e();
        return;
    L66:
        if ((r110 - this.f429149f) == 1) goto L68;
    L93:
        e();
        return;
    L68:
        if (this.f429147d.length() != 1) goto L93;
        char r114 = this.f429148e;
        if (r114 != '*') goto L72;
    L89:
        State r115 = this.f429146c;
        State r116 = State.ULSymbol;
        if (r115 == r116) goto L124;
        Log.d("InsertListStateMachine", "toStateULSymbol");
        this.f429146c = r116;
        return;
    L124:
        return;
    L72:
        if (r114 == '-') goto L89;
        if (r114 == 65290) goto L89;
        if (r114 == 65293) goto L89;
        if ('1' > r114) goto L82;
        if (r114 >= ':') goto L82;
    L83:
        if (r104 == false) goto L88;
        State r117 = this.f429146c;
        State r118 = State.OLNumber;
        if (r117 == r118) goto L123;
        Log.d("InsertListStateMachine", "toStateOLNumber");
        this.f429146c = r118;
        return;
    L123:
        return;
    L88:
        e();
        return;
    L82:
        r104 = false;
        goto L83
    }
}

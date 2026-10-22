package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes36.dex */
public class EditorListApplier implements TextWatcher, InputFilter {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f429112o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f429113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext2.list.b f429114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f429115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f429116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f429117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f429118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<y9b.a> f429119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet<y9b.a> f429120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList<y9b.a> f429121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedList<y9b.a> f429122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<y9b.a, ULong> f429123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final InsertListStateMachine f429124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f429125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f429126n;

    public static final class a {
    }

    public final class b implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f429127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditorListApplier f429128b;

        public b(EditorListApplier r100) {
            this.f429128b = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r110, int r111, KeyEvent r112) {
            Intrinsics.checkNotNullParameter(r112, "event");
            Editable r113 = this.f429128b.f429113a.getEditableText();
            boolean r100 = false;
            int r101 = 0;
            if (r112.getAction() != 0) goto L49;
            if (r111 == 61) goto L12;
            if (r111 == 112) goto L10;
            if (r111 == 66) goto L9;
            if (r111 == 67) goto L10;
            this.f429127a = false;
        L47:
            return this.f429127a;
        L9:
            EditorListApplier r114 = this.f429128b;
            Intrinsics.checkNotNull(r113);
            this.f429127a = r114.c(r113, true);
        L10:
            EditorListApplier r115 = this.f429128b;
            Intrinsics.checkNotNull(r113);
            this.f429127a = r115.g(r113, true);
            goto L47
        L12:
            if ((r112.getMetaState() & 1) != 1) goto L14;
            boolean r116 = true;
        L15:
            if (r116 == false) goto L17;
            int r117 = -1;
        L18:
            EditorListApplier r118 = this.f429128b;
            Intrinsics.checkNotNull(r113);
            r118.getClass();
            int r102 = Selection.getSelectionStart(r113);
            int r103 = Selection.getSelectionEnd(r113);
            y9b.a[] r104 = (y9b.a[]) r113.getSpans(Math.min(r102, r103), Math.max(r102, r103), y9b.a.class);
            if (r104.length != 0) goto L21;
            boolean r105 = true;
        L22:
            if (r105 == true) goto L45;
            LinkedHashSet<y9b.a> r106 = r118.f429120h;
            r106.clear();
            int r107 = r104.length;
            boolean r108 = false;
        L25:
            if (r101 >= r107) goto L39;
            y9b.a r109 = r104[r101];
            int r119 = r113.getSpanEnd(r109);
            if (r102 != r119) goto L35;
            Character r120 = StringsKt.getOrNull(r113, r119 - 1);
            if (r120 == null) goto L35;
            if (r120.charValue() != '\n') goto L35;
        L38:
            r101 = r101 + 1;
        L35:
            if ((r109 instanceof y9b.b) == false) goto L37;
            r108 = true;
        L37:
            r109.f(r109.b() + r117);
            r109.g(ListHeadType.None);
            r106.add(r109);
            goto L38
        L39:
            if (r108 == false) goto L42;
            r118.d(r113, r106);
        L42:
            if ((!r106.isEmpty()) == false) goto L44;
            r118.m(r113, r106);
        L44:
            r106.clear();
            r100 = true;
        L45:
            this.f429127a = r100;
            goto L47
        L21:
            r105 = false;
            goto L22
        L17:
            r117 = 1;
            goto L18
        L14:
            r116 = false;
            goto L15
        L49:
            if (r112.getAction() != 1) goto L60;
            if (r111 == 61) goto L56;
            if (r111 == 112) goto L56;
            if (r111 == 66) goto L56;
            if (r111 == 67) goto L56;
            return false;
        L56:
            return this.f429127a;
        L60:
            return false;
        }
    }

    public static final class c implements SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<Editable, Object, Unit> f429129a;

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super Editable, Object, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "realWatcher");
            this.f429129a = r100;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
            if (r100 != null) goto L4;
        L7:
            boolean r106 = true;
        L8:
            if (r106 == false) goto L10;
            return;
        L10:
            if ((r100 instanceof Editable) == false) goto L15;
            this.f429129a.invoke(r100, r101);
            return;
        L15:
            return;
        L4:
            if (r100.length() == 0) goto L7;
            r106 = false;
            goto L8
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y9b.a f429130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f429131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f429132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f429133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f429134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f429135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f429136g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f429137h;

        public d() {
            this.f429130a = null;
            this.f429131b = -1;
            this.f429132c = -1;
            this.f429133d = -1;
            this.f429134e = false;
            this.f429135f = false;
            this.f429136g = 0;
            this.f429137h = null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f429138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f429139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f429140c;

        public e() {
            this.f429138a = -1;
            this.f429139b = -1;
            this.f429140c = -1;
        }
    }

    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429141a = null;

        static {
            int[] r100 = new int[ListHeadType.values().length];
            r100[ListHeadType.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ListHeadType.VirtualHead.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f429141a = r100;
        }
    }

    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Editable f429142a;

        public g(Editable r100) {
            this.f429142a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Editable r102 = this.f429142a;
            Integer r103 = Integer.valueOf(r102.getSpanStart((y9b.a) r100));
            Editable r104 = this.f429142a;
            return ComparisonsKt.compareValues(r103, Integer.valueOf(r104.getSpanStart((y9b.a) r101)));
        }
    }

    public static final class h<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Editable f429143a;

        public h(Editable r100) {
            this.f429143a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Editable r102 = this.f429143a;
            Integer r103 = Integer.valueOf(r102.getSpanStart((y9b.a) r100));
            Editable r104 = this.f429143a;
            return ComparisonsKt.compareValues(r103, Integer.valueOf(r104.getSpanStart((y9b.a) r101)));
        }
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public final void b() {
        this.f429113a.addTextChangedListener(this);
        a(this.f429113a.getEditableText());
        InputFilter[] r100 = this.f429113a.getFilters();
        InputFilter[] r101 = (InputFilter[]) Arrays.copyOf(r100, r100.length + 1);
        r101[r100.length] = this;
        this.f429113a.setFilters(r101);
    }

    public final void a(Editable r100) {
        if (r100.getSpanStart(this.f429125m) != (-1)) goto L6;
        r100.setSpan(this.f429125m, 0, r100.length(), 18);
        this.f429124l.c(r100, Selection.getSelectionStart(r100), Selection.getSelectionEnd(r100));
        return;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        long r101 = System.currentTimeMillis();
        if (this.f429115c == true) goto L12;
        this.f429115c = true;
        d r102 = this.f429116d;
        CharSequence r103 = r102.f429137h;
        if (r102.f429134e == false) goto L10;
        if (r100 != r103) goto L10;
        f(r100, r102);
    L11:
        this.f429115c = false;
    L10:
        e(r100, this.f429117e);
    L12:
        d r104 = this.f429116d;
        r104.f429130a = null;
        r104.f429131b = -1;
        r104.f429132c = -1;
        r104.f429133d = -1;
        r104.f429135f = false;
        r104.f429134e = false;
        r104.f429137h = null;
        r104.f429136g = 0;
        e r105 = this.f429117e;
        r105.f429138a = -1;
        r105.f429139b = -1;
        r105.f429140c = -1;
        Log.d("ListActionHandle", "afterTextChanged: cost time: " + (System.currentTimeMillis() - r101) + "ms");
    }

    public final void h(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        LinkedHashSet<y9b.a> r101 = this.f429120h;
        r101.clear();
        d(r100, r101);
        if ((!r101.isEmpty()) == false) goto L5;
        m(r100, r101);
    L5:
        r101.clear();
    }

    public EditorListApplier(EditText r100, com.ss.android.lark.keyboard.edittext2.list.b r101) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "coordinator");
        this.f429113a = r100;
        this.f429114b = r101;
        this.f429116d = new d();
        this.f429117e = new e();
        this.f429118f = new ArrayList();
        this.f429119g = new ArrayList();
        this.f429120h = new LinkedHashSet();
        this.f429121i = new LinkedList();
        this.f429122j = new LinkedList();
        this.f429123k = new LinkedHashMap();
        this.f429124l = new InsertListStateMachine(r101, this);
        this.f429125m = new c(new EditorListApplier$innerSpanWatcher$1(this));
    }

    public static y9b.a k(Editable r100, int r101) {
        y9b.a[] r102 = (y9b.a[]) r100.getSpans(r101, r101, y9b.a.class);
        if (r102.length != 2) goto L15;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L28;
        y9b.a r105 = r102[r104];
        if (r100.getSpanStart(r105) != r101) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L13;
        r104 = r104 + 1;
        goto L5
    L13:
        return r105;
    L9:
        r106 = false;
        goto L10
    L28:
        return null;
    L15:
        if (r102.length != 1) goto L25;
        y9b.a r107 = r102[0];
        Character r108 = StringsKt.getOrNull(r100, r101 - 1);
        if (r108 != null) goto L20;
    L24:
        return r107;
    L20:
        if (r108.charValue() != '\n') goto L24;
        if (r100.getSpanEnd(r107) != r101) goto L24;
        return null;
    L25:
        return null;
    }

    public static long l(int r100, int r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100) << 32) + ULong.m9623constructorimpl(((long) UInt.m9544constructorimpl(r101)) & BodyPartID.bodyIdMax));
    }

    public static void p(y9b.a r100, Editable r101) {
        int r102 = r101.getSpanEnd(r100);
        if (r100.f566994c != ListHeadType.ListHead) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L25;
        Object[] r104 = r101.getSpans(r102, r102, y9b.b.class);
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L16;
        Object r107 = r104[r106];
        if (r101.getSpanStart((y9b.b) r107) != r102) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L17;
        r106 = r106 + 1;
    L17:
        y9b.b r109 = (y9b.b) r107;
        if (r109 == null) goto L20;
        r109.g(ListHeadType.ListHead);
    L20:
        if (r109 == null) goto L26;
        r109.h(1);
        return;
    L26:
        return;
    L12:
        r108 = false;
        goto L13
    L16:
        r107 = null;
        goto L17
    L25:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final boolean c(Editable r100, boolean r101) {
        int r102 = Selection.getSelectionStart(r100);
        boolean r103 = false;
        if (r102 == Selection.getSelectionEnd(r100)) goto L5;
        return false;
    L5:
        y9b.a r104 = k(r100, r102);
        if (r104 != null) goto L9;
        return false;
    L9:
        if (r104.b() == 0) goto L11;
    L13:
        int r105 = r100.getSpanStart(r104);
        String r106 = r100.subSequence(r105, r100.getSpanEnd(r104)).toString();
        if (Intrinsics.areEqual(r106, "\u200b\n") == false) goto L16;
    L19:
        boolean r107 = true;
    L20:
        LinkedHashSet<y9b.a> r108 = this.f429120h;
        r108.clear();
        if (r107 == false) goto L35;
        if (r105 <= r102) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == false) goto L35;
        r104.f(r104.b() - 1);
        r104.g(ListHeadType.None);
        r108.add(r104);
        if ((r104 instanceof y9b.b) == false) goto L32;
        d(r100, r108);
    L32:
        if ((!r108.isEmpty()) == false) goto L34;
        m(r100, r108);
    L34:
        r103 = true;
        goto L35
    L24:
        if (r102 > (r105 + 1)) goto L26;
        r109 = true;
    L35:
        r108.clear();
        return r103;
    L16:
        if (Intrinsics.areEqual(r106, "\u200b") == true) goto L19;
        r107 = false;
        goto L20
    L11:
        if (o(r100, r102, r104, r101) == false) goto L13;
        return true;
    }

    public final void d(Editable r110, Set<y9b.a> r111) {
        long r100 = System.currentTimeMillis();
        ArrayList r101 = (ArrayList) this.f429119g;
        r101.clear();
        LinkedList<y9b.a> r102 = this.f429121i;
        r102.clear();
        LinkedList<y9b.a> r103 = this.f429122j;
        r103.clear();
        LinkedHashMap r104 = (LinkedHashMap) this.f429123k;
        r104.clear();
        int r105 = 0;
        Object[] r106 = r110.getSpans(0, r110.length(), y9b.b.class);
        int r107 = r106.length;
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L6;
        y9b.b r112 = (y9b.b) r106[r108];
        r101.add(r112);
        r104.put(r112, ULong.m9617boximpl(l(r110.getSpanStart(r112), r110.getSpanEnd(r112))));
        r108 = r108 + 1;
        goto L3
    L6:
        if (r101.size() <= 1) goto L8;
        CollectionsKt.sortWith(r101, new g(r110));
    L8:
        int r113 = r101.size();
    L9:
        if (r105 >= r113) goto L19;
        y9b.a r109 = (y9b.a) ListProtector.get(r101, r105);
        int r114 = r109.b();
        if (r103.isEmpty() == false) goto L13;
    L16:
        r103.add(r109);
    L17:
        r105 = r105 + 1;
        goto L9
    L13:
        if (r103.getLast().b() <= r114) goto L16;
        i(r103, r102, r104, r111, r114);
        r103.add(r109);
        goto L17
    L19:
        if ((!r103.isEmpty()) == false) goto L21;
        i(r103, r102, r104, r111, -1);
    L21:
        r101.clear();
        r102.clear();
        r103.clear();
        r104.clear();
        Log.d("ListActionHandle", "checkAndChangeListNumbers cost: " + (System.currentTimeMillis() - r100));
    }

    public void e(Editable r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "s");
        Intrinsics.checkNotNullParameter(r101, "info");
        InsertListStateMachine r102 = this.f429124l;
        int r103 = r101.f429138a;
        int r104 = r101.f429139b;
        int r105 = r101.f429140c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "dest");
        Log.d("InsertListStateMachine", "textChange");
        boolean r106 = true;
        if (r100.length() != 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        r102.d(0);
        r102.f429150g = 0;
        r102.f429151h = 0;
    L18:
        a(r100);
        return;
    L8:
        if (r104 != 0) goto L12;
        if (r105 != 1) goto L12;
        if (r103 < 0) goto L12;
    L14:
        if (r102.f429146c == InsertListStateMachine.State.None) goto L17;
        if (r106 == false) goto L17;
        char r108 = r100.charAt(r103);
        r102.f429147d.append(r108);
        r102.f429148e = r108;
    L17:
        r102.e();
    L12:
        r106 = false;
        goto L14
    L5:
        r107 = false;
        goto L6
    }

    public void f(Editable r110, d r111) {
        Intrinsics.checkNotNullParameter(r110, "s");
        Intrinsics.checkNotNullParameter(r111, "info");
        y9b.a r100 = r111.f429130a;
        if (r100 == null) goto L121;
        int r101 = r111.f429131b;
        int r102 = r111.f429132c;
        int r103 = r111.f429133d;
        int r104 = Math.min(r110.length(), r103);
    L6:
        if (r104 >= r110.length()) goto L11;
        if (r110.charAt(r104) == '\n') goto L11;
        r104 = r104 + 1;
    L11:
        if (r104 >= r110.length()) goto L13;
        r104 = r104 + 1;
    L13:
        LinkedList<y9b.a> r105 = this.f429122j;
        r105.clear();
        if (r110.length() != 0) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L19;
        int r113 = 1;
        boolean r114 = false;
    L41:
        if ((r103 - r102) == 1) goto L43;
    L45:
        boolean r106 = false;
    L46:
        if (r106 == false) goto L48;
        r113 = 2;
    L48:
        int r107 = r101;
    L50:
        if (r107 >= r104) goto L57;
        if (r107 >= r110.length()) goto L56;
        if (r110.charAt(r107) != 8203) goto L56;
        r110.delete(r107, r107 + 1);
        r104 = r104 - 1;
    L56:
        r107 = r107 + 1;
    L57:
        int r108 = r101 - 1;
        ArrayList r109 = (ArrayList) this.f429118f;
        r109.clear();
        int r115 = r101;
    L58:
        if (r115 >= r104) goto L71;
        if (r113 <= 0) goto L71;
        if (r110.charAt(r115) == '\n') goto L65;
        if (r115 == (r104 - 1)) goto L65;
    L70:
        r115 = r115 + 1;
    L65:
        if (r110.charAt(r115) == '\n') goto L67;
    L69:
        r109.add(Integer.valueOf(Math.min(r110.length(), r115 + 1)));
        r113 = r113 - 1;
        r108 = r115;
        goto L70
    L67:
        if ((r115 - r108) != 1) goto L69;
        r110.insert(r115, "\u200b");
        r104 = r104 + 1;
        r115 = r115 + 1;
    L71:
        if (r113 <= 0) goto L83;
        if (r104 != r110.length()) goto L83;
        if (r110.length() != 0) goto L77;
        boolean r116 = true;
    L78:
        if (r116 == false) goto L80;
    L81:
        r110.append(8203);
        r109.add(Integer.valueOf(r110.length()));
        goto L83
    L80:
        if (StringsKt.last(r110) != '\n') goto L83;
    L77:
        r116 = false;
    L83:
        if ((!r109.isEmpty()) == false) goto L101;
        int r117 = 0;
        int r118 = 0;
    L86:
        if (r117 >= r109.size()) goto L103;
        int r119 = r117 + 1;
        int r120 = ((Number) ListProtector.get(r109, r117)).intValue();
        if ((r100 instanceof y9b.b) == false) goto L90;
        r118 = r118 + 1;
    L90:
        int r121 = r110.getSpanStart(r100);
        int r122 = r110.getSpanEnd(r100);
        if (r121 != r101) goto L93;
        if (r122 != r120) goto L93;
    L95:
        if (r119 == r109.size()) goto L96;
        y9b.a r123 = r105.pollFirst();
        if (r123 != null) goto L100;
        r123 = this.f429114b.a(r100);
    L100:
        this.f429114b.getClass();
        com.ss.android.lark.keyboard.edittext2.list.b.c(r123, r100);
        this.f429114b.d(r123);
        r100 = r123;
        r101 = r120;
        r117 = r119;
        goto L86
    L96:
        r101 = r120;
    L93:
        r110.setSpan(r100, r101, r120, 33);
    L103:
        if ((!r105.isEmpty()) == false) goto L107;
        y9b.a r124 = r105.pollFirst();
        if (r124 == null) goto L103;
        r110.removeSpan(r124);
        this.f429114b.b(r124);
        goto L103
    L107:
        if (r114 == false) goto L110;
        if (r101 == r104) goto L110;
        boolean r125 = true;
    L111:
        boolean r126 = r111.f429135f;
        if (r118 == r111.f429136g) goto L114;
        boolean r127 = true;
    L115:
        if (r127 == true) goto L118;
        if (r125 == true) goto L118;
        if (r126 == true) goto L118;
        return;
    L118:
        h(r110);
        return;
    L114:
        r127 = false;
    L110:
        r125 = false;
        goto L111
    L101:
        r118 = 0;
        goto L103
    L43:
        if (r110.charAt(r102) != '\n') goto L45;
        r106 = true;
        goto L46
    L19:
        y9b.a[] r128 = (y9b.a[]) r110.getSpans(r101, Math.min(r104 + 1, r110.length()), y9b.a.class);
        if (r128.length <= 1) goto L22;
        ArraysKt.sortWith(r128, new h(r110));
    L22:
        int r129 = r128.length;
        int r130 = 0;
        r113 = 0;
        r114 = false;
    L23:
        if (r130 >= r129) goto L41;
        y9b.a r131 = r128[r130];
        int r132 = r110.getSpanStart(r131);
        int r133 = r110.getSpanEnd(r131);
        if (r132 != r104) goto L27;
        r114 = true;
    L27:
        if (r133 > r104) goto L31;
        if (r133 > r102) goto L30;
        if (r132 >= r103) goto L31;
    L30:
        r113 = r113 + 1;
    L31:
        if (r101 > r132) goto L34;
        if (r132 >= r104) goto L34;
        boolean r134 = true;
    L35:
        if (r134 == false) goto L39;
        if (Intrinsics.areEqual(r131, r100) == true) goto L39;
        r105.addLast(r131);
    L39:
        r130 = r130 + 1;
    L34:
        r134 = false;
        goto L35
    L16:
        r112 = false;
        goto L17
    L121:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean g(Editable r100, boolean r101) {
        int r102 = Selection.getSelectionStart(r100);
        int r103 = Selection.getSelectionEnd(r100);
        int r104 = Math.min(r102, r103);
        int r105 = Math.max(r102, r103);
        if ((r105 - r104) == 1) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r105 == r104) goto L11;
        if (r106 == true) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
    L27:
        return false;
    L14:
        if (r105 == (-1)) goto L27;
        y9b.a r108 = k(r100, r104);
        if (r108 != null) goto L19;
        return false;
    L19:
        int r109 = r100.getSpanStart(r108);
        if (o(r100, r104, r108, r101) == false) goto L22;
        return true;
    L22:
        if (r109 != r104) goto L27;
        p(r108, r100);
        r100.removeSpan(r108);
        this.f429114b.b(r108);
        if ((r108 instanceof y9b.b) == false) goto L26;
        h(r100);
    L26:
        return true;
    L11:
        r107 = false;
        goto L12
    L5:
        if (r100.charAt(r104) != 8203) goto L7;
        r106 = true;
        goto L8
    }

    public final void m(Spannable r110, Set<y9b.a> r111) {
        SpanWatcher[] r100 = (SpanWatcher[]) r110.getSpans(0, r110.length(), SpanWatcher.class);
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L9;
        y9b.a r113 = (y9b.a) r112.next();
        this.f429114b.d(r113);
        int r114 = r110.getSpanStart(r113);
        int r115 = r110.getSpanEnd(r113);
        int r116 = r100.length;
        int r101 = 0;
    L6:
        if (r101 >= r116) goto L4;
        r100[r101].onSpanChanged(r110, r113, r114, r115, r114, r115);
        r101 = r101 + 1;
        goto L6
    }

    public static void n(Map r100, List r101, Set r110) {
        Iterator r102 = r101.iterator();
        int r103 = -2;
        int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L31;
        y9b.a r105 = (y9b.a) r102.next();
        ULong r106 = (ULong) r100.get(r105);
        if (r106 == null) goto L4;
        long r107 = r106.m9675unboximpl();
        int r108 = (int) ULong.m9623constructorimpl(r107 >>> 32);
        int r109 = (int) r107;
        ListHeadType r111 = r105.f566994c;
        boolean r112 = true;
        if (r108 == r103) goto L10;
        if (r108 <= r103) goto L30;
        int r113 = f.f429141a[r111.ordinal()];
        if (r113 != 1) goto L21;
        int r114 = r104 + 1;
        if (r105.c() == r114) goto L27;
        r105.h(r114);
    L28:
        if (r112 == false) goto L30;
        r110.add(r105);
        goto L30
    L27:
        r112 = false;
        goto L28
    L21:
        if (r113 != 2) goto L30;
        r105.g(ListHeadType.ListHead);
    L30:
        r104 = r105.c();
        r103 = r109;
        goto L4
    L10:
        if (r111 == ListHeadType.ListHead) goto L30;
        r105.g(ListHeadType.None);
        int r115 = r104 + 1;
        if (r105.c() == r115) goto L14;
        r105.h(r115);
    L15:
        if (r112 == false) goto L30;
        r110.add(r105);
        goto L30
    L14:
        r112 = false;
        goto L15
    }

    public static void q(y9b.a r100, List r101, Map r102) {
        ULong r103 = (ULong) r102.get((y9b.a) CollectionsKt.last(r101));
        if (r103 == null) goto L8;
        int r104 = (int) r103.m9675unboximpl();
        ULong r105 = (ULong) r102.get(r100);
        if (r105 == null) goto L9;
        r102.put(r100, ULong.m9617boximpl(l((int) ULong.m9623constructorimpl(r105.m9675unboximpl() >>> 32), r104)));
        return;
    L9:
        return;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r110, int r111, int r112, int r113) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.f429115c == true) goto L40;
        this.f429115c = true;
        e r100 = this.f429117e;
        r100.f429138a = r111;
        r100.f429139b = r112;
        r100.f429140c = r113;
        if (this.f429126n == true) goto L35;
        Editable r101 = this.f429113a.getEditableText();
        Intrinsics.checkNotNull(r101);
        y9b.a r102 = k(r101, r111);
        if (r102 == null) goto L36;
        int r103 = r101.getSpanStart(r102);
        if (r112 <= 0) goto L15;
        if (r113 != 0) goto L15;
        boolean r104 = true;
    L16:
        int r114 = r112 + r111;
        int r105 = r114 + 1;
        if (r104 == true) goto L19;
    L33:
        boolean r106 = false;
    L34:
        int r115 = r101.getSpans(r103, r114, y9b.b.class).length;
        d r107 = this.f429116d;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "span");
        r107.f429131b = r103;
        r107.f429132c = r111;
        r107.f429133d = r113 + r111;
        r107.f429134e = true;
        r107.f429135f = r106;
        r107.f429137h = r110;
        r107.f429136g = r115;
        r107.f429130a = r102;
        goto L36
    L19:
        if (r105 > r101.length()) goto L33;
        Object[] r108 = r101.getSpans(r105, r105, y9b.a.class);
        int r109 = r108.length;
        int r116 = 0;
    L21:
        if (r116 >= r109) goto L29;
        Object r117 = r108[r116];
        if (r101.getSpanStart((y9b.a) r117) != r105) goto L25;
        boolean r118 = true;
    L26:
        if (r118 == true) goto L31;
        r116 = r116 + 1;
    L31:
        if (((y9b.a) r117) == null) goto L33;
        r106 = true;
        goto L34
    L25:
        r118 = false;
        goto L26
    L29:
        r117 = null;
    L15:
        r104 = false;
    L36:
        this.f429115c = false;
        return;
    L35:
        this.f429126n = false;
        goto L36
    }

    public final boolean o(Editable r110, int r111, y9b.a r112, boolean r113) {
        int r100 = r110.getSpanStart(r112);
        int r101 = r110.getSpanEnd(r112);
        String r102 = r110.subSequence(r100, r101).toString();
        if (Intrinsics.areEqual(r102, "\u200b\n") == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L22;
        if (r100 <= r111) goto L12;
    L14:
        boolean r114 = false;
    L15:
        if (r114 == false) goto L22;
        p(r112, r110);
        r110.removeSpan(r112);
        this.f429114b.b(r112);
        if ((r112 instanceof y9b.b) == false) goto L19;
        h(r110);
    L19:
        if (r113 == false) goto L21;
        r110.replace(r100, r101, StringsKt.replace$default(r102, "\u200b", "", false, 4, null));
    L21:
        return true;
    L12:
        if (r111 > (r100 + 1)) goto L14;
        r114 = true;
    L22:
        return false;
    L5:
        if (Intrinsics.areEqual(r102, "\u200b") == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void i(LinkedList r100, LinkedList r101, Map r102, Set r103, int r104) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        r101.clear();
    L7:
        if ((!r100.isEmpty()) == false) goto L18;
        if (((y9b.a) r100.getLast()).b() <= r104) goto L18;
        y9b.a r105 = (y9b.a) r100.remove(CollectionsKt.getLastIndex(r100));
        r101.addFirst(r105);
        if ((!r100.isEmpty()) == false) goto L7;
        if (((y9b.a) r100.getLast()).b() >= r105.b()) goto L7;
        n(r102, r101, r103);
        if ((!r101.isEmpty()) == false) goto L7;
        q((y9b.a) r100.getLast(), r101, r102);
        r101.clear();
    L18:
        if ((!r101.isEmpty()) == false) goto L22;
        n(r102, r101, r103);
        if ((!r100.isEmpty()) == false) goto L22;
        q((y9b.a) r100.getLast(), r101, r102);
    L22:
        r101.clear();
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        if (this.f429115c == true) goto L42;
        this.f429115c = true;
        Editable r106 = this.f429113a.getEditableText();
        if (r100 != null) goto L7;
    L10:
        boolean r107 = true;
    L11:
        if (r107 == true) goto L13;
    L15:
        boolean r108 = false;
    L17:
        if (r105 != (r104 + 1)) goto L29;
        if (r103 == null) goto L25;
        Character r109 = StringsKt.getOrNull(r103, r104);
        if (r109 == null) goto L25;
        if (r109.charValue() != 8203) goto L25;
        boolean r110 = true;
    L26:
        if (r110 == false) goto L29;
        boolean r111 = false;
    L31:
        if (r108 == false) goto L37;
        Intrinsics.checkNotNull(r106);
        if (g(r106, r111) == false) goto L41;
        if (r111 == false) goto L41;
        this.f429126n = true;
        r100 = "\n";
    L41:
        this.f429115c = false;
        goto L42
    L37:
        if (Intrinsics.areEqual(r100, "\n") == false) goto L41;
        Intrinsics.checkNotNull(r106);
        if (c(r106, r111) == false) goto L41;
        r100 = "";
    L25:
        r110 = false;
    L29:
        r111 = true;
        goto L31
    L13:
        if ((r105 - r104) != 1) goto L15;
        r108 = true;
        goto L17
    L7:
        if (r100.length() == 0) goto L10;
        r107 = false;
    L42:
        return r100;
    }
}

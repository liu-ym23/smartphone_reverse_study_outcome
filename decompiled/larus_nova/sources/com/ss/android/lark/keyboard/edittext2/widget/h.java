package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.method.MetaKeyKeyListener;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import com.ss.android.lark.widget.light.viewstub.ViewHolderSpan;
import com.ss.android.lark.widget.span.VideoImageSpan;
import com.ss.android.lark.widget.span.m0;
import com.ss.android.lark.widget.span.v;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f429267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Class<? extends CharacterStyle>> f429268b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Class<? extends Object>> f429269c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Class<? extends Object>> f429270d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Class<? extends ReplacementSpan>> f429271e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f429272a = 0;

        static {
        }
    }

    public h() {
    }

    static {
        f429267a = new h();
        f429268b = SetsKt.setOf(new Class[]{com.ss.android.lark.widget.linked_emojicon.base.a.class, ncc.e.class, com.ss.android.lark.widget.span.a.class, com.ss.android.lark.keyboard.edittext2.span.a.class});
        f429269c = SetsKt.setOf(new Class[]{com.ss.android.lark.widget.linked_emojicon.base.a.class, ncc.e.class, com.ss.android.lark.widget.span.a.class, VideoImageSpan.class, m0.class, ViewHolderSpan.class, com.ss.android.lark.keyboard.edittext2.span.f.class, v.class});
        f429270d = SetsKt.setOf(new Class[]{ReplacementSpan.class, ClickableSpan.class, com.ss.android.lark.keyboard.edittext2.span.f.class, com.ss.android.lark.widget.light.span.p.class});
        f429271e = SetsKt.setOf(new Class[]{VideoImageSpan.class, m0.class, ViewHolderSpan.class, v.class});
    }

    private final boolean delete(Editable r100, KeyEvent r101, boolean r110) {
        if ((!KeyEvent.metaStateHasNoModifiers(r101.getMetaState())) == false) goto L5;
        return false;
    L5:
        int r102 = Selection.getSelectionStart(r100);
        int r103 = Selection.getSelectionEnd(r100);
        if (r102 == (-1)) goto L11;
        if (r103 == (-1)) goto L11;
        if (r102 != r103) goto L11;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        return false;
    L14:
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = f429269c.iterator();
    L16:
        if (r106.hasNext() == false) goto L19;
        CollectionsKt.addAll(r105, r100.getSpans(r102, r103, (Class) r106.next()));
        goto L16
    L19:
        if (r105.isEmpty() == false) goto L21;
        return false;
    L21:
        Iterator r107 = r105.iterator();
    L23:
        if (r107.hasNext() == false) goto L41;
        Object r108 = r107.next();
        int r109 = r100.getSpanStart(r108);
        int r111 = r100.getSpanEnd(r108);
        if (r110 == false) goto L27;
        if (r109 != r102) goto L27;
    L35:
        r100.delete(r109, r111);
        if (CollectionsKt.contains(f429271e, r108.getClass()) == true) goto L38;
    L40:
        return true;
    L38:
        if ((r100 instanceof p) == false) goto L40;
        ((p) r100).b();
    L27:
        if (r110 == true) goto L30;
        if (r111 == r102) goto L35;
    L30:
        if ((r109 + 1) > r102) goto L33;
        if (r102 >= r111) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L23;
    L33:
        r112 = false;
        goto L34
    L41:
        return false;
    L11:
        r104 = true;
        goto L12
    }

    public final boolean b(Editable r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r101 != 67) goto L5;
        boolean r103 = delete(r100, r102, false);
    L9:
        if (r103 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r100);
        return true;
    L12:
        return false;
    L5:
        if (r101 == 112) goto L7;
        r103 = false;
        goto L9
    L7:
        r103 = delete(r100, r102, true);
        goto L9
    }

    public static boolean a(InputConnectionWrapper r100, Editable r101, int r110, int r111, boolean r112) {
        if (r101 == null) goto L91;
        if (r100 == null) goto L91;
        if (r110 < 0) goto L91;
        if (r111 < 0) goto L91;
        int r102 = Selection.getSelectionStart(r101);
        int r103 = Selection.getSelectionEnd(r101);
        if (r102 == (-1)) goto L15;
        if (r103 == (-1)) goto L15;
        if (r102 != r103) goto L15;
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        return false;
    L18:
        if (r112 == false) goto L77;
        int r113 = a.f429272a;
        int r114 = RangesKt.coerceAtLeast(r110, 0);
        Intrinsics.checkNotNullParameter(r101, SRStrategy.MEDIAINFO_KEY_CACHE_SIZE);
        int r105 = r101.length();
        if (r102 < 0) goto L46;
        if (r105 < r102) goto L46;
        if (r114 < 0) goto L46;
    L25:
        boolean r106 = false;
    L26:
        if (r114 == 0) goto L47;
        r102 = r102 - 1;
        if (r102 < 0) goto L30;
        char r107 = r101.charAt(r102);
        if (r106 == true) goto L36;
        if (Character.isSurrogate(r107) == false) goto L41;
        if (Character.isHighSurrogate(r107) == true) goto L46;
        r106 = true;
        goto L26
    L41:
        r114 = r114 - 1;
        goto L26
    L36:
        if (Character.isHighSurrogate(r107) == false) goto L46;
        r114 = r114 - 1;
        goto L25
    L30:
        if (r106 == true) goto L46;
        r102 = 0;
    L47:
        int r115 = a.f429272a;
        int r116 = RangesKt.coerceAtLeast(r111, 0);
        Intrinsics.checkNotNullParameter(r101, SRStrategy.MEDIAINFO_KEY_CACHE_SIZE);
        int r117 = r101.length();
        if (r103 < 0) goto L73;
        if (r117 < r103) goto L73;
        if (r116 < 0) goto L73;
    L53:
        boolean r118 = false;
    L54:
        if (r116 == 0) goto L74;
        if (r103 >= r117) goto L57;
        char r108 = r101.charAt(r103);
        if (r118 == true) goto L63;
        if (Character.isSurrogate(r108) == false) goto L68;
        if (Character.isLowSurrogate(r108) == true) goto L73;
        r103 = r103 + 1;
        r118 = true;
        goto L54
    L68:
        r116 = r116 - 1;
        r103 = r103 + 1;
        goto L54
    L63:
        if (Character.isLowSurrogate(r108) == false) goto L73;
        r116 = r116 - 1;
        r103 = r103 + 1;
        goto L53
    L57:
        if (r118 == false) goto L59;
        r117 = -1;
    L59:
        r103 = r117;
    L74:
        if (r102 == (-1)) goto L76;
        if (r103 == (-1)) goto L76;
    L78:
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = f429269c.iterator();
    L80:
        if (r120.hasNext() == false) goto L83;
        CollectionsKt.addAll(r119, r101.getSpans(r102, r103, (Class) r120.next()));
        goto L80
    L83:
        if (r119.isEmpty() == false) goto L85;
        return false;
    L85:
        Iterator r121 = r119.iterator();
    L87:
        if (r121.hasNext() == false) goto L89;
        Object r122 = r121.next();
        int r123 = r101.getSpanStart(r122);
        int r124 = r101.getSpanEnd(r122);
        r102 = RangesKt.coerceAtMost(r123, r102);
        r103 = RangesKt.coerceAtLeast(r124, r103);
        goto L87
    L89:
        int r125 = RangesKt.coerceAtLeast(r102, 0);
        int r126 = RangesKt.coerceAtMost(r103, r101.length());
        r100.beginBatchEdit();
        r101.delete(r125, r126);
        r100.endBatchEdit();
        return true;
    L76:
        return false;
    L73:
        r103 = -1;
    L46:
        r102 = -1;
        goto L47
    L77:
        r102 = RangesKt.coerceAtLeast(r102 - r110, 0);
        r103 = RangesKt.coerceAtMost(r103 + r111, r101.length());
    L15:
        r104 = true;
    L91:
        return false;
    }
}

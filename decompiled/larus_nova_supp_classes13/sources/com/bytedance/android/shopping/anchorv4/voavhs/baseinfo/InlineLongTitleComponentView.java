package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.LruCache;
import com.bytedance.android.ec.core.rxjava.ECCompletableMergeArray;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/InlineLongTitleComponentView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "a", "Z", "getResizeBitmap", "()Z", "setResizeBitmap", "(Z)V", "resizeBitmap", "b", "getResizeToLineHeight", "setResizeToLineHeight", "resizeToLineHeight", "", "c", "F", "getLineSpace", "()F", "setLineSpace", "(F)V", "lineSpace", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InlineLongTitleComponentView extends AppCompatTextView {
    public static final LruCache<String, h> d = null;
    public static final LruCache<String, h> e = null;
    public boolean a;
    public boolean b;
    public float c;

    public static final class a {
    }

    static {
        d = new LruCache(10);
        e = new LruCache(5);
    }

    public final float getLineSpace() {
        return this.c;
    }

    public final boolean getResizeBitmap() {
        return this.a;
    }

    public final boolean getResizeToLineHeight() {
        return this.b;
    }

    public InlineLongTitleComponentView(Context r2) {
        this(r2, null);
    }

    public final void setLineSpace(float r1) {
        this.c = r1;
    }

    public final void setResizeBitmap(boolean r1) {
        this.a = r1;
    }

    public final void setResizeToLineHeight(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.InlineLongTitleComponentView] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    public final void x(LongTitleComponent r15) {
        setLineSpacing(this.c, 1.0f);
        ArrayList r0 = null;
        if (r15 == null) goto L5;
        IconsWithSpaceElement r5 = r15.getHeadIcons();
    L6:
        if (r15 == null) goto L8;
        IconsWithSpaceElement r1 = r15.getTailIcons();
    L9:
        if (r15 == null) goto L11;
        TextElement r16 = r15.getContent();
    L12:
        if (r5 == null) goto L14;
        List r2 = r5.getIconList();
    L15:
        List r3 = r2;
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L36;
        if (r1 == null) goto L25;
        List r6 = r1.getIconList();
    L26:
        List r7 = r6;
        if (r7 != null) goto L29;
    L32:
        boolean r8 = true;
    L33:
        if (r8 == false) goto L36;
        z(CollectionsKt.emptyList(), 0, CollectionsKt.emptyList(), 0, r16, this);
        return;
    L29:
        if (r7.isEmpty() == true) goto L32;
        r8 = false;
        goto L33
    L25:
        r6 = null;
    L36:
        if (r5 == null) goto L49;
        List r9 = r5.getIconList();
        if (r9 == null) goto L49;
        List r10 = r9;
        ?? r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L41:
        if (r12.hasNext() == false) goto L50;
        ECUrlModel r13 = ((ImageModel) r12.next()).getRemote();
        if (r13 == null) goto L45;
        String r14 = r13.getUri();
    L46:
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        r11.add(r14);
        goto L41
    L45:
        r14 = null;
    L50:
        List r17 = y(true, r11);
        if (r1 == null) goto L64;
        List r18 = r1.getIconList();
        if (r18 == null) goto L64;
        List r19 = r18;
        ?? r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L56:
        if (r21.hasNext() == false) goto L65;
        ECUrlModel r22 = ((ImageModel) r21.next()).getRemote();
        if (r22 == null) goto L60;
        String r23 = r22.getUri();
    L61:
        if (r23 != null) goto L63;
        r23 = "";
    L63:
        r20.add(r23);
        goto L56
    L60:
        r23 = null;
    L65:
        List r24 = y(false, r20);
        int r25 = ((ArrayList) r17).size();
        if (r5 == null) goto L70;
        List r26 = r5.getIconList();
        if (r26 == null) goto L70;
        int r27 = r26.size();
    L71:
        if (r25 != r27) goto L86;
        int r28 = ((ArrayList) r24).size();
        if (r1 == null) goto L77;
        List r29 = r1.getIconList();
        if (r29 == null) goto L77;
        int r30 = r29.size();
    L78:
        if (r28 != r30) goto L86;
        if (r5 == null) goto L81;
        int r31 = r5.getSpace();
    L82:
        if (r1 == null) goto L84;
        int r110 = r1.getSpace();
    L85:
        z(r17, r31, r24, r110, r16, this);
        return;
    L84:
        r110 = 0;
        goto L85
    L81:
        r31 = 0;
    L77:
        r30 = 0;
    L86:
        if (r5 == null) goto L102;
        List r32 = r5.getIconList();
        if (r32 == null) goto L102;
        ArrayList r33 = new ArrayList();
        Iterator r34 = r32.iterator();
    L91:
        if (r34.hasNext() == false) goto L98;
        Object r35 = r34.next();
        if (((ImageModel) r35).getRemote() == null) goto L95;
        boolean r36 = true;
    L96:
        if (r36 == false) goto L91;
        r33.add(r35);
        goto L91
    L95:
        r36 = false;
        goto L96
    L98:
        ?? r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r38 = r33.iterator();
    L100:
        if (r38.hasNext() == false) goto L103;
        ImageModel r39 = (ImageModel) r38.next();
        ECUrlModel r40 = r39.getRemote();
        Intrinsics.checkNotNull(r40);
        r37.add(new h(null, r40.getWidth(), r39.getRemote().getHeight()));
    L103:
        ?? r41 = r37;
        if (r5 == null) goto L106;
        int r42 = r5.getSpace();
    L107:
        if (r1 == null) goto L123;
        List r43 = r1.getIconList();
        if (r43 == null) goto L123;
        ArrayList r44 = new ArrayList();
        Iterator r45 = r43.iterator();
    L112:
        if (r45.hasNext() == false) goto L119;
        Object r46 = r45.next();
        if (((ImageModel) r46).getRemote() == null) goto L116;
        boolean r111 = true;
    L117:
        if (r111 == false) goto L112;
        r44.add(r46);
        goto L112
    L116:
        r111 = false;
        goto L117
    L119:
        ?? r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r48 = r44.iterator();
    L121:
        if (r48.hasNext() == false) goto L124;
        ImageModel r49 = (ImageModel) r48.next();
        ECUrlModel r112 = r49.getRemote();
        Intrinsics.checkNotNull(r112);
        r47.add(new h(null, r112.getWidth(), r49.getRemote().getHeight()));
    L124:
        ?? r50 = r47;
        if (r1 == null) goto L127;
        int r113 = r1.getSpace();
    L128:
        z(r41, r42, r50, r113, r16, this);
        ArrayList r51 = new ArrayList();
        u r52 = u.a;
        if (r5 == null) goto L152;
        List r53 = r5.getIconList();
        if (r53 == null) goto L152;
        ArrayList r54 = new ArrayList();
        Iterator r55 = r53.iterator();
    L134:
        if (r55.hasNext() == false) goto L138;
        ECUrlModel r56 = ((ImageModel) r55.next()).getRemote();
        if (r56 == null) goto L134;
        r54.add(r56);
        goto L134
    L138:
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        Iterator r58 = r54.iterator();
        int r59 = 0;
    L140:
        if (r58.hasNext() == false) goto L146;
        Object r114 = r58.next();
        int r115 = r59 + 1;
        if (r59 >= 0) goto L144;
        CollectionsKt.throwIndexOverflow();
    L144:
        r57.add(Observable.create(new t((ECUrlModel) r114, r59)).onErrorReturn(r52));
        r59 = r115;
        goto L140
    L146:
        if ((!r57.isEmpty()) == true) goto L149;
        r57 = null;
    L149:
        if (r57 == null) goto L152;
        Observable r60 = Observable.zip(r57, new o(r51));
        if (r60 == null) goto L152;
    L153:
        ArrayList r61 = new ArrayList();
        if (r1 == null) goto L176;
        List r62 = r1.getIconList();
        if (r62 == null) goto L176;
        ArrayList r63 = new ArrayList();
        Iterator r64 = r62.iterator();
    L159:
        if (r64.hasNext() == false) goto L163;
        ECUrlModel r116 = ((ImageModel) r64.next()).getRemote();
        if (r116 == null) goto L159;
        r63.add(r116);
        goto L159
    L163:
        ArrayList r65 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r63, 10));
        Iterator r66 = r63.iterator();
        int r117 = 0;
    L165:
        if (r66.hasNext() == false) goto L171;
        Object r118 = r66.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L169;
        CollectionsKt.throwIndexOverflow();
    L169:
        r65.add(Observable.create(new t((ECUrlModel) r118, r117)).onErrorReturn(r52));
        r117 = r119;
        goto L165
    L171:
        if ((!r65.isEmpty()) == false) goto L173;
        r0 = r65;
    L173:
        if (r0 == null) goto L176;
        Observable r67 = Observable.zip(r0, new q(r61));
        if (r67 == null) goto L176;
    L177:
        CompletableSource[] r68 = {r60.ignoreElements(), r67.ignoreElements()};
        ObjectHelper.requireNonNull(r68, "sources is null");
        fa3.c.b(bg4.b.a(RxJavaPlugins.onAssembly(new ECCompletableMergeArray(r68))).subscribe(new r(this, r51, r5, r61, r16, this), new s(this, r16)));
        return;
    L176:
        r67 = Observable.empty();
    L152:
        r60 = Observable.empty();
        goto L153
    L127:
        r113 = 0;
    L123:
        r47 = CollectionsKt.emptyList();
        goto L124
    L106:
        r42 = 0;
    L102:
        r37 = CollectionsKt.emptyList();
    L70:
        r27 = 0;
    L64:
        r20 = CollectionsKt.emptyList();
    L49:
        r11 = CollectionsKt.emptyList();
        goto L50
    L18:
        if (r3.isEmpty() == true) goto L21;
        r4 = false;
        goto L22
    L14:
        r2 = null;
        goto L15
    L11:
        r16 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineLongTitleComponentView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
        this.c = com.bytedance.android.shopping.extensions.b.b(4);
        setIncludeFontPadding(false);
        setFirstBaselineToTopHeight(0);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public static List y(boolean r3, List r4) {
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        String r1 = (String) r5.next();
        if (r3 == false) goto L8;
        h r2 = (h) d.get(r1);
    L9:
        if (r2 == null) goto L12;
        r0.add(r2);
        goto L4
    L12:
        return new ArrayList();
    L8:
        r2 = (h) e.get(r1);
        goto L9
    L13:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(List<h> r16, int r17, List<h> r18, int r19, TextElement r20, TextView r21) {
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        Iterator<T> r2 = r16.iterator();
        int r4 = 0;
    L3:
        Integer r8 = null;
        if (r2.hasNext() == false) goto L38;
        Object r5 = r2.next();
        int r11 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        h r6 = (h) r5;
        if (this.a == true) goto L11;
    L29:
        Bitmap r7 = r6.a;
    L30:
        SpannableString r9 = new SpannableString(" ");
        if (r7 == null) goto L33;
        com.bytedance.android.shopping.widget.c r10 = new com.bytedance.android.shopping.widget.c(getContext(), r7);
    L34:
        r9.setSpan(r10, 0, 1, 17);
        r1.append(r9);
        if (r17 <= 0) goto L37;
        SpannableString r12 = new SpannableString(" ");
        r12.setSpan(new com.bytedance.commerce.base.richtext.b.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r17))), 0, 1, 17);
        r1.append(r12);
    L37:
        r4 = r11;
        goto L3
    L33:
        r10 = new m(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6.b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6.c)));
        goto L34
    L11:
        if (r6.a == null) goto L29;
        Integer r13 = Integer.valueOf(getLineHeight());
        if (r13.intValue() > 0) goto L15;
    L17:
        boolean r14 = false;
    L18:
        if (r14 == false) goto L20;
        r8 = r13;
    L20:
        if (r8 == null) goto L22;
        int r15 = r8.intValue();
    L23:
        int r22 = (int) (((r15 * 1.0f) / r6.a.getHeight()) * r6.a.getWidth());
        if (r15 < 0) goto L28;
        if (r22 < 0) goto L28;
        r7 = Bitmap.createScaledBitmap(r6.a, r22, r15, true);
    L28:
        r7 = r6.a;
        goto L30
    L22:
        r15 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6.c));
        goto L23
    L15:
        if (this.b == false) goto L17;
        r14 = true;
        goto L18
    L38:
        if (r20 == null) goto L40;
        r1.append(v.a(r20));
    L40:
        Iterator<T> r3 = r18.iterator();
        int r23 = 0;
    L42:
        if (r3.hasNext() == false) goto L76;
        Object r24 = r3.next();
        int r110 = r23 + 1;
        if (r23 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        h r25 = (h) r24;
        if (this.a == true) goto L49;
    L68:
        Bitmap r26 = r25.a;
    L69:
        if (r19 <= 0) goto L71;
        SpannableString r111 = new SpannableString(" ");
        r111.setSpan(new com.bytedance.commerce.base.richtext.b.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r19))), 0, 1, 17);
        r1.append(r111);
    L71:
        SpannableString r112 = new SpannableString(" ");
        if (r26 == null) goto L74;
        com.bytedance.android.shopping.widget.c r27 = new com.bytedance.android.shopping.widget.c(getContext(), r26);
    L75:
        r112.setSpan(r27, 0, 1, 17);
        r1.append(r112);
        r23 = r110;
        goto L42
    L74:
        r27 = new m(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r25.b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r25.c)));
        goto L75
    L49:
        if (r25.a == null) goto L68;
        Integer r28 = Integer.valueOf(getLineHeight());
        if (r28.intValue() > 0) goto L53;
    L55:
        boolean r113 = false;
    L56:
        if (r113 == true) goto L59;
        r28 = null;
    L59:
        if (r28 == null) goto L61;
        int r29 = r28.intValue();
    L62:
        int r114 = (int) (((r29 * 1.0f) / r25.a.getHeight()) * r25.a.getWidth());
        if (r29 < 0) goto L67;
        if (r114 < 0) goto L67;
        r26 = Bitmap.createScaledBitmap(r25.a, r114, r29, true);
    L67:
        r26 = r25.a;
        goto L69
    L61:
        r29 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r25.c));
        goto L62
    L53:
        if (this.b == false) goto L55;
        r113 = true;
        goto L56
    L76:
        r21.setText(r1);
    }
}

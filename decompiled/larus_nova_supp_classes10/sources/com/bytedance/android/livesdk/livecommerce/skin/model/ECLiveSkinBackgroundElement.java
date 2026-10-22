package com.bytedance.android.livesdk.livecommerce.skin.model;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveSkinUtil;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0005HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "component1", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "component2", "image", "color", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "Ljava/util/List;", "getColor", "()Ljava/util/List;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;Ljava/util/List;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBackgroundElement implements Serializable {
    public static final a Companion = null;

    @SerializedName("color")
    private final List<String> color;

    @SerializedName("image")
    private final ECLiveSkinImageElement image;

    public static final class a {
        public a() {
        }

        public static Drawable a(ECLiveSkinBackgroundElement r11, Context r12, List r13, ECDraweeView r14) {
            Intrinsics.checkNotNullParameter(r11, "$this$convertToDrawable");
            GradientDrawable r0 = null;
            ECLiveSkinImageElement r1 = r11.getImage();     // Catch: Exception -> L120
            boolean r2 = true;
            if (r1 == null) goto L65;
            if (r12 == null) goto L68;
            String r5 = r1.getResourceName();     // Catch: Exception -> L120
            if (r5 != null) goto L10;
        L48:
            String r15 = r1.getUrl();     // Catch: Exception -> L120
            if (r15 != null) goto L51;
        L62:
            if (r14 == null) goto L64;
            r14.setVisibility(8);     // Catch: Exception -> L120
        L64:
            Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L120
            goto L68
        L51:
            if (r15.length() <= 0) goto L53;
            boolean r3 = true;
        L54:
            if (r3 == false) goto L56;
            String r6 = r15;
        L57:
            if (r6 == null) goto L62;
            if (r14 == null) goto L68;
            r14.setVisibility(0);     // Catch: Exception -> L120
            h0.e(r14, r6, null, null, null, 120);     // Catch: Exception -> L120
            return new ColorDrawable(0);
        L56:
            r6 = null;
            goto L57
        L53:
            r3 = false;
            goto L54
        L10:
            if (r5.length() <= 0) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == true) goto L16;
            r5 = null;
        L16:
            if (r5 == null) goto L48;
            ECLiveSkinUtil.l.getClass();     // Catch: Exception -> L120
            Integer r8 = ECLiveSkinUtil.b(r5);     // Catch: Exception -> L120
            if (r8 == null) goto L48;
            r8.intValue();     // Catch: Exception -> L120
            int r17 = r8.intValue();     // Catch: Exception -> L120
            Lazy r18 = UtilityKotlinExtentionsKt.a;     // Catch: Exception -> L120
            Intrinsics.checkNotNullParameter(r12, "$this$getDrawableCompat");     // Catch: Exception -> L120
            Drawable r19 = th.a.b(r12, r17);     // Catch: Exception -> L120
            if ((r19 instanceof BitmapDrawable) == true) goto L22;
            Drawable r110 = null;
        L23:
            BitmapDrawable r111 = (BitmapDrawable) r110;     // Catch: Exception -> L120
            if (r111 == null) goto L26;
            r111.setGravity(17);     // Catch: Exception -> L120
        L26:
            List<String> r112 = r1.getTintColor();     // Catch: Exception -> L120
            if (r112 == null) goto L47;
            String r113 = (String) CollectionsKt.firstOrNull(r112);     // Catch: Exception -> L120
            if (r113 == null) goto L47;
            if (r113.length() > 0) goto L34;
            r2 = false;
        L34:
            if (r2 == true) goto L37;
            r113 = null;
        L37:
            if (r113 == null) goto L47;
            Integer r114 = s.b(r113);     // Catch: Exception -> L120
            if (r114 == null) goto L47;
            int r115 = r114.intValue();     // Catch: Exception -> L120
            if ((r19 instanceof BitmapDrawable) == true) goto L43;
            Drawable r116 = null;
        L44:
            BitmapDrawable r117 = (BitmapDrawable) r116;     // Catch: Exception -> L120
            if (r117 == null) goto L47;
            r117.setColorFilter(r115, PorterDuff.Mode.DST);     // Catch: Exception -> L120
            goto L47
        L43:
            r116 = r19;
        L47:
            return r19;
        L22:
            r110 = r19;
            goto L23
        L12:
            r7 = false;
        L68:
            List<String> r118 = r11.getColor();     // Catch: Exception -> L120
            if (r118 != null) goto L71;
        L122:
            return null;
        L71:
            if ((!r118.isEmpty()) == true) goto L74;
            r118 = null;
        L74:
            if (r118 == null) goto L122;
            ArrayList r119 = new ArrayList();     // Catch: Exception -> L120
            Iterator<T> r120 = r118.iterator();     // Catch: Exception -> L120
        L77:
            if (r120.hasNext() == false) goto L82;
            Integer r121 = s.b((String) r120.next());     // Catch: Exception -> L120
            if (r121 == null) goto L77;
            r119.add(Integer.valueOf(r121.intValue()));     // Catch: Exception -> L120
            goto L77
        L82:
            if (r119.size() <= 0) goto L84;
            boolean r122 = true;
        L85:
            if (r122 == false) goto L87;
            ArrayList r123 = r119;
        L88:
            if (r123 == null) goto L122;
            if (r123.size() <= 1) goto L103;
            GradientDrawable r124 = new GradientDrawable();     // Catch: Exception -> L120
            r124.setColors(CollectionsKt.toIntArray(r119));     // Catch: Exception -> L120
            r124.setGradientType(0);     // Catch: Exception -> L120
            r124.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L120
            if (r13 == null) goto L131;
            List r125 = r13;     // Catch: Exception -> L120
            ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));     // Catch: Exception -> L120
            Iterator r127 = r125.iterator();     // Catch: Exception -> L120
        L95:
            if (r127.hasNext() == false) goto L98;
            r126.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r127.next()).intValue()))));     // Catch: Exception -> L120
            goto L95
        L98:
            if (r126.size() != 4) goto L100;
            r124.setCornerRadii(CollectionsKt.toFloatArray(r126));     // Catch: Exception -> L120
            return r124;
        L100:
            Float r128 = (Float) CollectionsKt.firstOrNull(r126);     // Catch: Exception -> L120
            if (r128 == null) goto L133;
            r124.setCornerRadius(r128.floatValue());     // Catch: Exception -> L120
            return r124;
        L133:
            return r124;
        L131:
            return r124;
        L103:
            Integer r129 = (Integer) CollectionsKt.firstOrNull(r123);     // Catch: Exception -> L120
            if (r129 == null) goto L119;
            int r130 = r129.intValue();     // Catch: Exception -> L120
            GradientDrawable r131 = new GradientDrawable();     // Catch: Exception -> L120
            r131.setColor(r130);     // Catch: Exception -> L120
            if (r13 == null) goto L117;
            List r132 = r13;     // Catch: Exception -> L120
            ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));     // Catch: Exception -> L120
            Iterator r134 = r132.iterator();     // Catch: Exception -> L120
        L109:
            if (r134.hasNext() == false) goto L112;
            r133.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r134.next()).intValue()))));     // Catch: Exception -> L120
            goto L109
        L112:
            if (r133.size() != 4) goto L114;
            r131.setCornerRadii(CollectionsKt.toFloatArray(r133));     // Catch: Exception -> L120
            goto L117
        L114:
            Float r135 = (Float) CollectionsKt.firstOrNull(r133);     // Catch: Exception -> L120
            if (r135 == null) goto L117;
            r131.setCornerRadius(r135.floatValue());     // Catch: Exception -> L120
        L117:
            r0 = r131;
        L119:
            return r0;
        L87:
            r123 = null;
            goto L88
        L84:
            r122 = false;
            goto L85
        L65:
            if (r14 == null) goto L67;
            r14.setVisibility(8);     // Catch: Exception -> L120
        L67:
            Unit r136 = Unit.INSTANCE;     // Catch: Exception -> L120
        L120:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L122
        }

        public static /* synthetic */ Drawable b(a r1, ECLiveSkinBackgroundElement r2, Context r3, ECDraweeView r4, int r5) {
            if ((r5 & 4) == 0) goto L5;
            r4 = null;
        L5:
            r1.getClass();
            return a(r2, r3, null, r4);
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECLiveSkinBackgroundElement() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBackgroundElement copy$default(ECLiveSkinBackgroundElement r0, ECLiveSkinImageElement r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.image;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.color;
    L9:
        return r0.copy(r1, r2);
    }

    public final ECLiveSkinImageElement component1() {
        return this.image;
    }

    public final List<String> component2() {
        return this.color;
    }

    public final ECLiveSkinBackgroundElement copy(ECLiveSkinImageElement r2, List<String> r3) {
        return new ECLiveSkinBackgroundElement(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinBackgroundElement) == false) goto L10;
        ECLiveSkinBackgroundElement r4 = (ECLiveSkinBackgroundElement) r3;
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ECLiveSkinImageElement r0 = this.image;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.color;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinBackgroundElement(image=" + this.image + ", color=" + this.color + ")";
    }

    public final List<String> getColor() {
        return this.color;
    }

    public final ECLiveSkinImageElement getImage() {
        return this.image;
    }

    public ECLiveSkinBackgroundElement(ECLiveSkinImageElement r1, List<String> r2) {
        this.image = r1;
        this.color = r2;
    }

    public /* synthetic */ ECLiveSkinBackgroundElement(ECLiveSkinImageElement r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}

package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextWithIconConfig;", "", "Landroid/content/Context;", "component1", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "component2", "Lp93/a;", "component3", "context", "uiParams", "imageLoad", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "getUiParams", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "Lp93/a;", "getImageLoad", "()Lp93/a;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;Lp93/a;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextWithIconConfig {
    private final Context context;
    private final p93.a imageLoad;
    private final UIConfig uiParams;

    public static /* synthetic */ TextWithIconConfig copy$default(TextWithIconConfig r0, Context r1, UIConfig r2, p93.a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.context;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.uiParams;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.imageLoad;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Context component1() {
        return this.context;
    }

    public final UIConfig component2() {
        return this.uiParams;
    }

    public final p93.a component3() {
        return this.imageLoad;
    }

    public final TextWithIconConfig copy(Context r2, UIConfig r3, p93.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiParams");
        Intrinsics.checkNotNullParameter(r4, "imageLoad");
        return new TextWithIconConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TextWithIconConfig) == false) goto L12;
        TextWithIconConfig r4 = (TextWithIconConfig) r3;
        if (Intrinsics.areEqual(this.context, r4.context) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uiParams, r4.uiParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageLoad, r4.imageLoad) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Context r0 = this.context;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        UIConfig r4 = this.uiParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        p93.a r7 = this.imageLoad;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TextWithIconConfig(context=" + this.context + ", uiParams=" + this.uiParams + ", imageLoad=" + this.imageLoad + ")";
    }

    public final Context getContext() {
        return this.context;
    }

    public final p93.a getImageLoad() {
        return this.imageLoad;
    }

    public final UIConfig getUiParams() {
        return this.uiParams;
    }

    public TextWithIconConfig(Context r2, UIConfig r3, p93.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiParams");
        Intrinsics.checkNotNullParameter(r4, "imageLoad");
        this.context = r2;
        this.uiParams = r3;
        this.imageLoad = r4;
    }

    public /* synthetic */ TextWithIconConfig(Context r1, UIConfig r2, p93.a r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new b();
    L5:
        this(r1, r2, r3);
    }
}

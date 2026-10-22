package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/widget/category/TextCategoryView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/window/shop/widget/category/a;", "", "c", "Z", "getLastChosen", "()Z", "setLastChosen", "(Z)V", "lastChosen", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "d", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "getCategory", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "category", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextCategoryView extends AppCompatTextView implements com.bytedance.android.window.shop.widget.category.a {
    public final int a;
    public final int b;
    public boolean c;
    public final WindowProductCategoryVODeprecated.d d;
    public final Function3<WindowProductCategoryVODeprecated.a, Integer, Integer, Unit> e;

    public static final class a {
        public final float a;
        public final Integer b;

        public a(float r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void u() {
        setTextColor(this.a);
        f.e(this, 500);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void w() {
        setTextColor(this.b);
        f.e(this, 400);
    }

    public /* bridge */ /* synthetic */ WindowProductCategoryVODeprecated.a getCategory() {
        return m972getCategory();
    }

    public boolean getLastChosen() {
        return this.c;
    }

    /* JADX INFO: renamed from: getCategory, reason: collision with other method in class */
    public WindowProductCategoryVODeprecated.d m972getCategory() {
        return this.d;
    }

    public void setLastChosen(boolean r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextCategoryView(WindowProductCategoryVODeprecated.d r3, Context r4, Function3<? super WindowProductCategoryVODeprecated.a, ? super Integer, ? super Integer, Unit> r5, a r6) {
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "config");
        super(r4);
        this.d = r3;
        this.e = r5;
        Integer r7 = m972getCategory().e;
        if (r7 == null) goto L5;
        int r8 = r7.intValue();
    L6:
        this.a = r8;
        Integer r9 = m972getCategory().f;
        if (r9 == null) goto L9;
        int r10 = r9.intValue();
    L10:
        this.b = r10;
        setGravity(17);
        Resources r11 = r4.getResources();
        Integer r12 = r6.b;
        if (r12 == null) goto L13;
        setBackgroundDrawable(r11.getDrawable(r12.intValue()));
    L13:
        setText(m972getCategory().b);
        setTextSize(1, r6.a);
        setTypeface(Typeface.defaultFromStyle(1));
        return;
    L9:
        r10 = (int) 2568362019L;
        goto L10
    L5:
        r8 = (int) 4279638051L;
        goto L6
    }
}

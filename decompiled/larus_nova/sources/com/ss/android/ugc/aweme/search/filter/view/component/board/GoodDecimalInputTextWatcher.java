package com.ss.android.ugc.aweme.search.filter.view.component.board;

import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/board/GoodDecimalInputTextWatcher;", "Landroid/text/TextWatcher;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoodDecimalInputTextWatcher implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f453079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f453080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f453081c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/board/GoodDecimalInputTextWatcher$Companion;", "", "()V", "Period", "", "Zero", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public GoodDecimalInputTextWatcher(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f453079a = r100;
        this.f453080b = 8;
        this.f453081c = 2;
    }

    public final void a(Editable r100) {
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.toString();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.length());
    L9:
        if (r103.intValue() == 0) goto L16;
        EditText r104 = this.f453079a;
        if (r104 == null) goto L13;
        r104.setGravity(17);
    L13:
        EditText r105 = this.f453079a;
        if (r105 == null) goto L31;
        r105.setPadding(0, 0, 0, 0);
        return;
    L31:
        return;
    L16:
        EditText r106 = this.f453079a;
        if (r106 == null) goto L21;
        CharSequence r107 = r106.getHint();
        if (r107 == null) goto L21;
        r101 = r107.toString();
    L21:
        Paint r108 = new Paint();
        r108.setTextSize(this.f453079a.getTextSize());
        float r109 = (this.f453079a.getWidth() - r108.measureText(r101)) / 2;
        EditText r110 = this.f453079a;
        if (r110 == null) goto L25;
        r110.setGravity(8388627);
    L25:
        if (r109 >= 0) goto L27;
        r109 = 0.0f;
    L27:
        EditText r111 = this.f453079a;
        if (r111 == null) goto L33;
        r111.setPadding((int) r109, 0, 0, 0);
        return;
    L33:
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r110) {
        Intrinsics.checkNotNullParameter(r110, "editable");
        String r100 = r110.toString();     // Catch: Exception -> L40
        this.f453079a.removeTextChangedListener(this);     // Catch: Exception -> L40
        this.f453079a.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f453080b)});     // Catch: Exception -> L40
        if (StringsKt.contains$default(r100, ".", false, 2, null) == false) goto L13;
        this.f453079a.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter((this.f453080b + 1) + this.f453081c)});     // Catch: Exception -> L40
        if (((r100.length() - 1) - StringsKt.indexOf$default(r100, ".", 0, false, 6, null)) <= this.f453081c) goto L20;
        r100 = r100.substring(0, (StringsKt.indexOf$default(r100, ".", 0, false, 6, null) + this.f453081c) + 1);     // Catch: Exception -> L40
        int r101 = r110.length();     // Catch: Exception -> L40
        if (r100 == null) goto L12;
        r110.replace(0, r101, StringsKt.trim(r100).toString());     // Catch: Exception -> L40
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L40
    L20:
        if (r100 == null) goto L38;
        if (Intrinsics.areEqual(StringsKt.trim(r100).toString(), ".") == false) goto L30;
        r100 = "0".concat(r100);     // Catch: Exception -> L40
        int r102 = r110.length();     // Catch: Exception -> L40
        if (r100 == null) goto L28;
        r110.replace(0, r102, StringsKt.trim(r100).toString());     // Catch: Exception -> L40
        goto L30
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L40
    L30:
        if (StringsKt.startsWith$default(r100, "0", false, 2, null) == true) goto L32;
    L36:
        a(r110);     // Catch: Exception -> L40
        this.f453079a.addTextChangedListener(this);     // Catch: Exception -> L40
        return;
    L32:
        if (StringsKt.trim(r100).toString().length() <= 1) goto L36;
        if ((!Intrinsics.areEqual(r100.substring(1, 2), ".")) == false) goto L36;
        r110.replace(0, r110.length(), "0");     // Catch: Exception -> L40
        goto L36
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L40
    L13:
        this.f453079a.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter((this.f453080b + 1) + this.f453081c)});     // Catch: Exception -> L40
        int r103 = r100.length();     // Catch: Exception -> L40
        int r104 = this.f453080b;     // Catch: Exception -> L40
        if (r103 <= r104) goto L20;
        r100 = r100.substring(0, r104);     // Catch: Exception -> L40
        int r105 = r110.length();     // Catch: Exception -> L40
        if (r100 == null) goto L19;
        r110.replace(0, r105, StringsKt.trim(r100).toString());     // Catch: Exception -> L40
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L40
    }
}

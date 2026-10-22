package q29;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f531464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f531465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f531466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function3<String, Boolean, Integer, Unit> f531467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f531468e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        int r102 = r101.length() + h.a(r101);
        if (r102 <= this.f531466c) goto L25;
        int r103 = this.f531464a.element.length() + h.a(this.f531464a.element);
        int r104 = this.f531466c;
        if (r103 <= r104) goto L13;
        this.f531465b.element = 0;
        this.f531464a.element = "";
        r103 = 0;
    L13:
        int r105 = r104 - r103;
        int r106 = r101.length() - 1;
        int r107 = this.f531465b.element;
        int r108 = r101.length();
    L14:
        if (r107 >= r108) goto L19;
        r105 = r105 - (h.a(String.valueOf(r101.charAt(r107))) + 1);
        if (r105 < 0) goto L17;
        r107 = r107 + 1;
        goto L14
    L17:
        r106 = r107;
    L19:
        Ref.ObjectRef<String> r109 = this.f531464a;
        Ref.IntRef r110 = this.f531465b;
        EditText r111 = this.f531468e;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
        r101 = r101.substring(0, r106) + r109.element.substring(r110.element);     // Catch: Throwable -> L22
        r111.setText(r101);     // Catch: Throwable -> L22
        r111.setSelection(r106);     // Catch: Throwable -> L22
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        this.f531467d.invoke(r101, Boolean.TRUE, Integer.valueOf((this.f531466c + 1) / 2));
        return;
    L22:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L25:
        this.f531467d.invoke(r101, Boolean.FALSE, Integer.valueOf((r102 + 1) / 2));
        return;
    L4:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [T] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L4;
        ?? r104 = r100.toString();
    L5:
        if (r104 != 0) goto L7;
        r104 = "";
    L7:
        this.f531464a.element = r104;
        return;
    L4:
        r104 = 0;
        goto L5
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        this.f531465b.element = r101;
    }

    public g(Ref.ObjectRef r100, Ref.IntRef r101, int r102, com.larus.community.impl.publish.a r103, AppCompatEditText r104) {
        this.f531464a = r100;
        this.f531465b = r101;
        this.f531466c = r102;
        this.f531467d = r103;
        this.f531468e = r104;
    }
}

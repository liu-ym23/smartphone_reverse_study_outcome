package lob;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f510162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f510163b;

    public b() {
        this.f510162a = new ArrayList();
    }

    public final void a(boolean r100) {
        Iterator<T> r101 = this.f510162a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a r102 = (a) r101.next();
        if ((r102 instanceof mob.b) == false) goto L4;
        ((mob.b) r102).a(r100);
        goto L4
    }

    @Override // lob.a, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (this.f510163b == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f510162a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((a) r101.next()).afterTextChanged(r100);
        goto L7
    }

    @Override // lob.a
    public final void j(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        if (this.f510163b == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f510162a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((a) r101.next()).j(r100);
        goto L7
    }

    @Override // lob.a
    public final boolean z(int r100, KeyEvent r101) {
        Iterator<T> r102 = this.f510162a.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L6;
        r103 = r103 & ((a) r102.next()).z(r100, r101);
        goto L4
    L6:
        return r103;
    }

    @Override // lob.a
    public final void r(Editable r100, int r101, int r102) {
        if (this.f510163b == false) goto L5;
        return;
    L5:
        Iterator<T> r103 = this.f510162a.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((a) r103.next()).r(r100, r101, r102);
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (this.f510163b == false) goto L5;
        return;
    L5:
        Iterator<T> r104 = this.f510162a.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((a) r104.next()).beforeTextChanged(r100, r101, r102, r103);
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (this.f510163b == false) goto L5;
        return;
    L5:
        Iterator<T> r104 = this.f510162a.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((a) r104.next()).onTextChanged(r100, r101, r102, r103);
        goto L7
    }
}

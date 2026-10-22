package v8c;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements com.larksuite.component.universe_design.dialog.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f553766a;

    public g(Ref.ObjectRef<String> r100) {
        this.f553766a = r100;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.larksuite.component.universe_design.dialog.c.a
    public final void onTextChanged(CharSequence r100) {
        Ref.ObjectRef<String> r101 = this.f553766a;
        r101.element = String.valueOf(r100);
    }
}

package u08;

import android.text.Editable;
import android.text.TextWatcher;
import com.larksuite.component.universe_design.edittext.UDEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDEditText f548204a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    public a(UDEditText r100) {
        this.f548204a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        UDEditText r101 = this.f548204a;
        int r102 = UDEditText.f284963k0;
        r101.d();
    }
}

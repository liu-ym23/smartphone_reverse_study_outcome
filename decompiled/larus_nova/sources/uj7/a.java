package uj7;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550411a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public a(ProjectActivity r100) {
        this.f550411a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        ProjectActivity r101 = this.f550411a;
        r101.f271430a = r100.toString();
    }
}

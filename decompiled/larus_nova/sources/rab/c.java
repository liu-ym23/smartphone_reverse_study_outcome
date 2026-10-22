package rab;

import com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer;
import oab.f;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRepeatBottomContainer f536863a;

    public c(CustomRepeatBottomContainer r100) {
        this.f536863a = r100;
    }

    @Override // oab.f
    public final void onItemSelected(int r100) {
        CustomRepeatBottomContainer r101 = this.f536863a;
        r101.f420337f = r101.f420335d.b(r100);
        this.f536863a.b();
    }
}

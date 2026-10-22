package cz8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.ChatConstraintLayout;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatConstraintLayout f466058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f466059b;

    @Override // va8.m
    public final l iX() {
        return new a(this.f466058a);
    }

    @Override // va8.m
    public final Fragment getChatFragment() {
        return this.f466059b;
    }

    public b(ChatConstraintLayout r100, Fragment r101) {
        this.f466058a = r100;
        this.f466059b = r101;
    }
}

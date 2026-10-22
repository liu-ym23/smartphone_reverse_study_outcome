package fe5;

import com.lynx.tasm.LynxGroup;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.ss.android.lark.lynxkit.initializer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f476591a;

    public c(String r100) {
        this.f476591a = r100;
    }

    @Override // com.ss.android.lark.lynxkit.initializer.a
    public final LynxGroup a() {
        String r100 = this.f476591a;
        return LynxGroup.Create(r100, r100, null, false, false);
    }
}

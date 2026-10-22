package y06;

import android.view.View;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.bullet.service.base.o;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "AnnieX 容器内部闭环，外部禁止使用")
public abstract class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C8292a f565584a;

    /* JADX INFO: renamed from: y06.a$a, reason: collision with other inner class name */
    public static final class C8292a extends ia.a {
        public C8292a() {
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public abstract /* synthetic */ j getContext();

    @Override // com.bytedance.ies.bullet.service.base.o
    public void g() {
        AnnieXContainerManager r100 = AnnieXContainerManager.INSTANCE;
        View r101 = realView();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        r100.removeContainerProxyFromEngineHashCode(r102);
        this.f565584a = null;
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public final void o() {
        C8292a r100 = this.f565584a;
        if (r100 == null) goto L10;
        AnnieXContainerManager r101 = AnnieXContainerManager.INSTANCE;
        View r102 = realView();
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        r101.saveContainerProxyFromEngineHashCode(r103, r100);
        return;
    L7:
        r103 = -1;
        goto L8
    }

    public a() {
        this.f565584a = new C8292a();
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return true;
    }
}

package t70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<? extends View>, Constructor<? extends View>> f544873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f544874b;

    public Context getContext() {
        return this.f544874b.getContext();
    }

    public k(LayoutInflater r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        this.f544874b = r100;
        this.f544873a = new HashMap();
    }

    public <T extends View> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClass");
        if (this.f544873a.containsKey(r100) == false) goto L5;
        GenericDeclaration r101 = this.f544873a.get(r100);
        Intrinsics.checkNotNull(r101);
        Constructor<T> r102 = (Constructor) r101;
    L6:
        T r103 = r102.newInstance(new Object[]{this.f544874b.getContext()});
        if (r103 == null) goto L11;
        return r103;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L5:
        Constructor<T> r104 = r100.getDeclaredConstructor(new Class[]{Context.class});
        this.f544873a.put(r100, r104);
        r102 = r104;
        goto L6
    }

    public View b(int r100) {
        if ((this.f544874b.getContext() instanceof AppCompatActivity) == false) goto L12;
        Context r101 = this.f544874b.getContext();
        if (r101 == null) goto L11;
        x70.b r102 = ViewPools.a((AppCompatActivity) r101);
        if (r102.a(r100) == false) goto L12;
        View r103 = r102.e(r100);
        Intrinsics.checkNotNull(r103);
        return r103;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L12:
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.f544874b.inflate(r100, null);
    }
}

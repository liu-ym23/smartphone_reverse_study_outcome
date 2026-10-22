package t70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.RecyclableTetrisElement;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Class<? extends View>, Constructor<? extends View>> f544864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclableTetrisElement f544865d;

    @Override // t70.k
    public Context getContext() {
        return this.f544874b.getContext();
    }

    @Override // t70.k
    public final <T extends View> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClass");
        if (this.f544864c.containsKey(r100) == false) goto L5;
        GenericDeclaration r101 = this.f544864c.get(r100);
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
        this.f544864c.put(r100, r104);
        r102 = r104;
        goto L6
    }

    @Override // t70.k
    public final View b(int r100) {
        if (d80.d.a() == false) goto L8;
        RecyclableTetrisElement.f65682u.getClass();
        View r101 = (View) ((HashMap) RecyclableTetrisElement.f65681t).get(this.f544865d.f65686o.getClass());
        if (r101 == null) goto L8;
        return r101;
    L8:
        if ((this.f544874b.getContext() instanceof AppCompatActivity) == false) goto L17;
        Context r102 = this.f544874b.getContext();
        if (r102 == null) goto L16;
        x70.b r103 = ViewPools.a((AppCompatActivity) r102);
        if (r103.a(r100) == false) goto L17;
        View r104 = r103.e(r100);
        Intrinsics.checkNotNull(r104);
        return r104;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L17:
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.f544874b.inflate(r100, null);
    }

    public g(LayoutInflater r100, RecyclableTetrisElement r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        Intrinsics.checkNotNullParameter(r101, "recyclableTetrisElement");
        super(r100);
        this.f544865d = r101;
        this.f544864c = new HashMap();
    }
}

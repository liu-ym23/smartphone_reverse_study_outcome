package p37;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.bytedance.nita.exception.NitaIllegalArgumentException;
import com.bytedance.nita.exception.NitaRuntimeException;
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ContextThemeWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f527595a;

    public final Activity getActivity() {
        WeakReference<Context> r100 = this.f527595a;
        Context r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.get();
    L7:
        if ((r102 instanceof Activity) == false) goto L17;
        WeakReference<Context> r103 = this.f527595a;
        if (r103 == null) goto L11;
        r101 = r103.get();
    L11:
        if (r101 == null) goto L15;
        return (Activity) r101;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    L17:
        throw new NitaRuntimeException("make sure you get this preCreated View from Activity context ");
    L5:
        r102 = null;
        goto L7
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        WeakReference<Context> r100 = this.f527595a;
        if (r100 == null) goto L12;
        Context r101 = r100.get();
        if (r101 == null) goto L12;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L12;
        AssetManager r103 = r102.getAssets();
        if (r103 == null) goto L12;
        return r103;
    L12:
        return super.getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WeakReference<Context> r100 = this.f527595a;
        if (r100 == null) goto L10;
        Context r101 = r100.get();
        if (r101 == null) goto L10;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return super.getResources();
    }

    public final WeakReference<Context> getContext() {
        return this.f527595a;
    }

    public a(Context r100) {
        super(r100, 0);
        this.f527595a = new WeakReference(r100);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r100) {
        return super.getSystemService(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        WeakReference<Context> r101 = this.f527595a;
        Context r102 = null;
        if (r101 == null) goto L5;
        Context r103 = r101.get();
    L7:
        if ((r103 instanceof Activity) == false) goto L17;
        WeakReference<Context> r104 = this.f527595a;
        if (r104 == null) goto L11;
        r102 = r104.get();
    L11:
        if (r102 == null) goto L15;
        ((Activity) r102).startActivity(r100);
        return;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    L17:
        throw new NitaIllegalArgumentException();
    L5:
        r103 = null;
        goto L7
    }

    public a(Context r100, int r101) {
        super(r100.getApplicationContext(), r101);
        this.f527595a = new WeakReference(r100);
    }
}

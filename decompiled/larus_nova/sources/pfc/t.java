package pfc;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.log.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f529096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f529097b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Class<? extends k> r101 = this.f529097b.f529115q;
        if (r101 != null) goto L5;
    L7:
        View r102 = this.f529097b.f529116r;
        if (r102 == null) goto L10;
        r102.setSelected(false);
    L10:
        r100.setSelected(true);
        v r103 = this.f529097b;
        r103.f529116r = r100;
        Class<? extends k> r104 = this.f529096a.f529088a;
        k r105 = (k) ((HashMap) r103.f529113o).get(r104);
        this.f529097b.f529103e.push(r104);
        k r106 = this.f529097b.f529114p;
        if (r106 == null) goto L13;
        r106.stop();
    L13:
        if (r105 == null) goto L36;
        k r107 = this.f529097b.f529114p;
        if (r107 == null) goto L17;
        r105.c(r107.getLocation(), this.f529097b.f529114p.d());
    L17:
        r105.setImageBitmap(f.i().h());
        r105.restart();
    L34:
        this.f529097b.f529107i.removeAllViews();
        this.f529097b.f529107i.addView(r105.getEditView());
        v r108 = this.f529097b;
        r108.f529114p = r105;
        r108.f529115q = r104;
        r105.b();
        return;
    L36:
        r105 = r104.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f529097b.f529099a});     // Catch: NoSuchMethodException -> L20 InvocationTargetException -> L22 IllegalAccessException -> L24 InstantiationException -> L26
    L28:
        ((HashMap) this.f529097b.f529113o).put(r104, r105);
        if (r105 == null) goto L34;
        r105.setImageBitmap(f.i().h());
        v r109 = this.f529097b;
        r109.getClass();
        r105.setPluginContext(new u(r109));
        k r110 = this.f529097b.f529114p;
        if (r110 == null) goto L33;
        r105.c(r110.getLocation(), this.f529097b.f529114p.d());
    L33:
        r105.create();
        goto L34
    L24:
        e = move-exception;
        Log.e("PluginViewHandler", e.toString());
        e.printStackTrace();
    L26:
        e = move-exception;
        Log.e("PluginViewHandler", e.toString());
        e.printStackTrace();
    L20:
        e = move-exception;
        Log.e("PluginViewHandler", e.toString());
        e.printStackTrace();
    L22:
        e = move-exception;
        Log.e("PluginViewHandler", e.toString());
        e.printStackTrace();
        goto L28
    L5:
        if (r101.getName().equals(this.f529096a.f529088a.getName()) == false) goto L7;
    }

    public t(v r100, o r101) {
        this.f529097b = r100;
        this.f529096a = r101;
    }
}

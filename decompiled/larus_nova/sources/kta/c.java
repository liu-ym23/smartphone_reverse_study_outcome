package kta;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c<SERVICE> implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f506101b;

    /* JADX INFO: loaded from: classes34.dex */
    public class a extends pta.e<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f506102b;

        public a(c r100) {
            this.f506102b = r100;
        }

        @Override // pta.e
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            Context r102 = (Context) r100[0];
            String r103 = this.f506102b.f506100a;
            if (r102.getPackageManager().getPackageInfo(r103, 128) == null) goto L7;
            r101 = true;
        L7:
            return Boolean.valueOf(r101);
        }
    }

    public abstract Intent b(Context r100);

    public abstract w.b<SERVICE, String> c();

    public c(String r100) {
        this.f506101b = new a(this);
        this.f506100a = r100;
    }

    @Override // kta.o
    public final boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f506101b.b(new Object[]{r100}).booleanValue();
    }

    @Override // kta.o
    public o.a getOaid(Context r100) {
        String r101 = (String) new w(r100, b(r100), c()).a();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        o.a r102 = new o.a();
        r102.f506112a = r101;
        return r102;
    }
}

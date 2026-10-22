package com.larksuite.framework.http.call;

import com.larksuite.framework.http.response.ErrorResult;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z18.b f285567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f285568b;

    public a(b r100, z18.b r101) {
        this.f285568b = r100;
        this.f285567a = r101;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        ErrorResult r102 = new ErrorResult(-1, 0, r101.getMessage());
        z18.b r103 = this.f285567a;
        if (r103 == null) goto L5;
        r103.a(r102);
    L5:
        c.a(this.f285568b.f285569a, r102.getErrorMessage());
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r100, Response r101) throws IOException {
        Type r102 = this.f285567a.getClass().getGenericSuperclass();
        if ((r102 instanceof ParameterizedType) == true) goto L5;
        Class<Object> r103 = Object.class;
    L12:
        this.f285568b.f285569a.b();
        c.a r104 = c.b(r103, this.f285568b.f285569a, r101);
        ErrorResult r105 = r104.f285574b;
        if (r105 == null) goto L15;
        c.a(this.f285568b.f285569a, r105.getErrorMessage());
        this.f285567a.a(r104.f285574b);
        return;
    L15:
        c.a(this.f285568b.f285569a, null);
        this.f285567a.onSuccess(r104.f285573a);
        return;
    L5:
        Type[] r106 = ((ParameterizedType) r102).getActualTypeArguments();
        if (r106.length <= 0) goto L11;
        Type r107 = r106[0];
        if ((r107 instanceof Class) == true) goto L10;
        r103 = Object.class;
        goto L12
    L10:
        r103 = (Class) r107;
        goto L12
    L11:
        r103 = Object.class;
        goto L12
    }
}

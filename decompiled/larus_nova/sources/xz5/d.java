package xz5;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f565523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f565524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f565525c;

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.f565525c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f565524b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f565523a;
    }

    public d(Type r100, Type r101, Type[] r102) {
        this.f565523a = r100;
        this.f565524b = r101;
        this.f565525c = r102;
    }
}

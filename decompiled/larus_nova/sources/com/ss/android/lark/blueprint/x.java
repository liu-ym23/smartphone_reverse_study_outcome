package com.ss.android.lark.blueprint;

/* JADX INFO: loaded from: classes34.dex */
public abstract class x<Data, PatchData> implements i<Data, PatchData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f410660a;

    public x() {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final Class<PatchData> b() {
        return null;
    }

    @Override // com.ss.android.lark.blueprint.i
    public abstract /* synthetic */ void update(m<Data> r100, q<Data> r101, Data r102);

    @Override // com.ss.android.lark.blueprint.i
    public final void a(m<Data> r100, q<Data> r101) {
        i.a.a(r100, r101);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, q r101, Object r102, Object r103) {
        i.a.b(this, r100, r101, r102, r103);
    }
}

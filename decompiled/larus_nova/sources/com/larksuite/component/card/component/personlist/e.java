package com.larksuite.component.card.component.personlist;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements com.larksuite.component.card.component.personlist.avatar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonListLynxUI f283507a;

    @Override // com.larksuite.component.card.component.personlist.avatar.b
    public final void a() {
        PersonListTextView r100 = (PersonListTextView) PersonListLynxUI.M(this.f283507a);
        if (r100 == null) goto L6;
        r100.postInvalidate();
        return;
    }

    public e(PersonListLynxUI r100) {
        this.f283507a = r100;
    }
}

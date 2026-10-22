package com.ss.android.lark.contact.customized.newcontact.repository;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f419339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f419340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f419341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ChatApplication> f419342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC4928a f419343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f419344f;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.newcontact.repository.a$a, reason: collision with other inner class name */
    public static final class C4938a {
    }

    public static final class b implements f9b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f419345a;

        public b(a r100) {
            this.f419345a = r100;
        }

        @Override // f9b.a
        public final void a(List<ChatApplication> r100) {
            if (CollectionUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC4928a r101 = this.f419345a.f419343e;
            if (r101 == null) goto L9;
            r101.a(r100);
            return;
        }
    }

    static {
    }

    public a() {
        this.f419339a = true;
        this.f419341c = "0";
        this.f419342d = new ArrayList();
        this.f419344f = new b(this);
    }
}

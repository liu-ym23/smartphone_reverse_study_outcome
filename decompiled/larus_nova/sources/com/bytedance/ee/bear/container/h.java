package com.bytedance.ee.bear.container;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.document.doccomponent.DocComponentVM;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements bk5.b {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bk5.a f216753a;

        public a(bk5.a r100) {
            this.f216753a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            Bundle r102 = this.f216753a.h9();
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(r101, r102.getString("url")) == true) goto L16;
            Bundle r104 = new Bundle(r102);
            r104.putString("url", r101);
            r104.putParcelable("bear_url", s45.p.a().Z(r101));
            this.f216753a.o0(r104);
            return;
        L16:
            return;
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    public h() {
    }

    public final String toString() {
        return "DocComponentInitNode";
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return !TextUtils.isEmpty(s05.e.b(r102.h9()));
    }

    @Override // bk5.b
    public final Object a(BearUrl r100, bk5.e r101, bk5.a r102, Continuation<? super bk5.e> r103) {
        Fragment r104 = r102.getFragment();
        LifecycleOwner r105 = r104.getViewLifecycleOwner();
        MutableLiveData<String> r106 = ((DocComponentVM) new ViewModelProvider(r104).get(DocComponentVM.class)).getLiveMoveToWiki();
        r106.removeObservers(r105);
        r106.observe(r105, new a(r102));
        return r101;
    }
}

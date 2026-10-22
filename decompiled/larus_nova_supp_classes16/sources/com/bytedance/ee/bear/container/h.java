package com.bytedance.ee.bear.container;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.document.doccomponent.DocComponentVM;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements bk5.b {

    public static final class a<T> implements Observer {
        public final /* synthetic */ bk5.a a;

        public a(bk5.a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            Bundle r0 = this.a.h9();
            if (r5 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            if (Intrinsics.areEqual(r5, r0.getString("url")) == true) goto L16;
            Bundle r2 = new Bundle(r0);
            r2.putString("url", r5);
            r2.putParcelable("bear_url", s45.p.a().Z(r5));
            this.a.o0(r2);
            return;
        L16:
            return;
        L5:
            if (r5.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public h() {
    }

    public final String toString() {
        return "DocComponentInitNode";
    }

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        return !TextUtils.isEmpty(s05.e.b(r4.h9()));
    }

    public final Object a(BearUrl r2, bk5.e r3, bk5.a r4, Continuation<? super bk5.e> r5) {
        Fragment r6 = r4.getFragment();
        LifecycleOwner r7 = r6.getViewLifecycleOwner();
        MutableLiveData<String> r8 = ((DocComponentVM) new ViewModelProvider(r6).get(DocComponentVM.class)).getLiveMoveToWiki();
        r8.removeObservers(r7);
        r8.observe(r7, new a(r4));
        return r3;
    }
}
